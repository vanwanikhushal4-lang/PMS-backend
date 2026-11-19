import assert from 'node:assert/strict';
import { createHmac } from 'node:crypto';
import { readFile, readdir } from 'node:fs/promises';
import { resolve } from 'node:path';
import { test } from 'node:test';
import { pathToFileURL } from 'node:url';

const clientSource = process.env.SCM_MOBILE_CLIENT_DIR;
const authSource = clientSource ? pathToFileURL(resolve(clientSource, 'auth-api.ts'))
  : new URL('../../../../mobile/src/scm/auth-api.ts', import.meta.url);
const kickoffSource = clientSource ? pathToFileURL(resolve(clientSource, 'kickoff-contract.ts'))
  : new URL('../../../../mobile/src/scm/kickoff-contract.ts', import.meta.url);
const { createAuthClient, resolveAuthConfig } = await import(authSource.href);
const { decodeScheduledKickoff } = await import(kickoffSource.href);

const base = process.env.SCM_JAVA_QA_ENDPOINT;
const datesBase = process.env.SCM_JAVA_DATE_BATCH_ENDPOINT;
const strict = process.env.SCM_JAVA_STRICT_ENDPOINT;
const disabled = process.env.SCM_JAVA_DISABLED_ENDPOINT;
const inbox = process.env.SCM_JAVA_QA_INBOX;
if (!base || !datesBase || !strict || !disabled || !inbox) throw new Error('Run tools/test_mobile_auth_java.sh to launch the private staging service');
const client = createAuthClient(resolveAuthConfig(base, true));
const factoryPassword = 'Stage-only-password-28';
const credentials = (username, companyCode = 'QA-A', password = factoryPassword) => ({ username, companyCode, password });

async function count(channel, address) {
  const data = await readFile(inbox, 'utf8').catch((error) => { if (error.code === 'ENOENT') return ''; throw error; });
  return data.split('\n').filter((row) => row.startsWith(`${channel}\t${address}\t`));
}
async function delivered(channel, address, previous = 0) {
  for (let attempt = 0; attempt < 80; attempt++) {
    const entries = await count(channel, address);
    if (entries.length > previous) return entries.at(-1).split('\t')[2];
    await new Promise((resolve) => setTimeout(resolve, 25));
  }
  throw new Error('The staging code was not delivered to its test sink');
}
function totp(secret, step) {
  const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ234567';
  const binary = [...secret].map((char) => alphabet.indexOf(char).toString(2).padStart(5, '0')).join('');
  const key = Buffer.from((binary.match(/.{8}/g) ?? []).map((chunk) => parseInt(chunk, 2)));
  const counter = Buffer.alloc(8);
  counter.writeBigUInt64BE(BigInt(step));
  const digest = createHmac('sha1', key).update(counter).digest();
  const offset = digest.at(-1) & 15;
  return ((digest.readUInt32BE(offset) & 0x7fffffff) % 1_000_000).toString().padStart(6, '0');
}

await test('the production profile is opt-in and requires TLS; staging rejects malformed requests', async () => {
  assert.equal((await fetch(`${disabled}session`)).status, 404);
  assert.equal((await fetch(`${strict}session`)).status, 403);
  const body = await fetch(`${base}sign-in`, { method: 'POST', headers: { 'Content-Type': 'text/plain' }, body: 'irrelevant' });
  assert.equal(body.status, 415);
  assert.equal(body.headers.get('cache-control'), 'no-store');
  assert.equal((await fetch(`${base}sign-in`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: ' '.repeat(9000) })).status, 413);
  assert.equal((await fetch(`${base}session?extra=1`)).status, 400);
});

await test('scoped legacy identity, disabled accounts, and session confirmation/logout', async () => {
  const alice = await client.signIn(credentials('alex'));
  assert.equal(alice.kind, 'authenticated');
  assert.equal(alice.session.identity.role, 'Sales Manager');
  assert.equal(alice.session.identity.companyCode, 'QA-A');
  assert.equal((await client.signIn(credentials('alex', 'QA-B'))).reason, 'invalid-credentials');
  assert.equal((await client.signIn(credentials('missing'))).reason, 'invalid-credentials');
  assert.equal((await client.signIn(credentials('disabled'))).reason, 'invalid-credentials');
  const other = await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'));
  assert.equal(other.session.identity.role, 'Engineer');
  assert.equal(other.session.identity.companyCode, 'QA-B');
  assert.equal((await client.session(alice.grant)).identity.displayName, 'Alex Rao');
  await client.signOut(alice.grant);
  await client.signOut(alice.grant);
  await assert.rejects(() => client.session(alice.grant), { code: 'expired' });
  assert.equal((await client.session(other.grant)).identity.displayName, 'Alex Kim');
});

await test('directory sign-in follows the directory adapter and has no local-password fallback', async () => {
  assert.equal((await client.signIn(credentials('directory'))).reason, 'invalid-credentials');
  const fromDirectory = await client.signIn(credentials('directory', 'QA-A', 'Synthetic-AD-only-22'));
  assert.equal(fromDirectory.session.identity.displayName, 'Maya Sen');
  assert.equal((await client.startRecovery({ companyCode: 'QA-A', username: 'directory', channel: 'email' })).kind, 'recovery-sent');
  assert.equal((await count('email', 'dir@fixture.invalid')).length, 0);
});

await test('workspace shows requester totals and up to 20 latest incident updates within the verified company', async () => {
  assert.equal((await fetch(`${base}workspace`)).status, 401);
  const first = await client.signIn(credentials('alex'));
  const request = { headers: { Authorization: `Bearer ${first.grant.sessionToken}` } };
  assert.equal((await fetch(`${base}workspace?companyCode=QA-B`, request)).status, 400);
  const workspace = await client.workspace(first.grant);
  assert.equal(workspace.total, 3);
  assert.deepEqual(workspace.statuses, [{ status: 'Assigned', count: 2 }, { status: 'Resolved', count: 1 }]);
  assert.deepEqual(workspace.activity.map(({ incidentId }) => incidentId), ['INC-381', 'INC-409', 'INC-434']);
  assert.equal(workspace.activity[0].message, 'Workplace Support scheduled the Wi-Fi diagnostics.');
  assert.equal(workspace.activity[0].date, '2026-11-03T09:18:00');
  assert.equal(workspace.activity[2].date, null);
  const other = await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'));
  assert.deepEqual(await client.workspace(other.grant), {
    total: 1, statuses: [{ status: 'Closed', count: 1 }],
    activity: [{ incidentId: 'INC-381', status: 'Closed', date: '2026-11-04T10:20:00', message: 'Second company activity.' }],
  });
  const empty = await client.signIn(credentials('directory', 'QA-A', 'Synthetic-AD-only-22'));
  assert.deepEqual(await client.workspace(empty.grant), { total: 0, statuses: [], activity: [] });
  const history = await client.signIn(credentials('phone'));
  const capped = await client.workspace(history.grant);
  assert.equal(capped.total, 21);
  assert.equal(capped.activity.length, 20);
  assert.equal(capped.activity[0].incidentId, 'INC-QA-41');
  assert.equal(capped.activity.at(-1).incidentId, 'INC-QA-22');
  await client.signOut(first.grant);
  await assert.rejects(() => client.workspace(first.grant), { code: 'expired' });
});

await test('SMS code uses the test sink, resend rotates it, and only one racing verification succeeds', async () => {
  const start = await client.signIn(credentials('sms'));
  assert.equal(start.kind, 'challenge');
  assert.equal(start.maskedDestination, '•••103');
  const oldCode = await delivered('sms', '+12025550103');
  await assert.rejects(() => client.session({ sessionToken: start.challengeId, expiresAt: start.expiresAt }), { code: 'expired' });
  const next = await client.resend(start.challengeId);
  const code = await delivered('sms', '+12025550103', 1);
  assert.equal(next.canResend, false);
  assert.equal((await client.verify(start.challengeId, oldCode)).reason, 'expired');
  assert.equal((await client.verify(next.challengeId, code === '111111' ? '222222' : '111111')).reason, 'invalid-code');
  const races = await Promise.all([client.verify(next.challengeId, code), client.verify(next.challengeId, code)]);
  assert.equal(races.filter((result) => result.kind === 'authenticated').length, 1);
  assert.equal(races.filter((result) => result.kind === 'rejected' && result.reason === 'expired').length, 1);
});

await test('profile, projects, tasks and work logs enforce the verified account and company', async () => {
  assert.equal((await fetch(`${base}profile`)).status, 401);
  const a = await client.signIn(credentials('alex'));
  const b = await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'));
  const noAccess = await client.signIn(credentials('directory', 'QA-A', 'Synthetic-AD-only-22'));
  assert.deepEqual(a.session.identity.capabilities, ['projects.read', 'projects.publish', 'tasks.assigned-by-me', 'tasks.assigned-to-me']);
  assert.deepEqual(noAccess.session.identity.capabilities, []);
  assert.deepEqual(await client.profile(a.grant), {
    email: 'alex@fixture.invalid', phone: '+12025550101', location: 'Pune', site: 'West office',
    department: 'Commercial operations', subdepartment: 'Delivery',
  });
  assert.equal((await client.profile(b.grant)).location, 'Chennai');
  assert.equal((await client.profile(b.grant)).subdepartment, '');
  const aProjects = await client.projects(a.grant, {});
  assert.deepEqual(aProjects.items.map(({ id }) => id), [44, 43, 41]);
  assert.equal(aProjects.next, null);
  assert.deepEqual((await client.projects(b.grant, {})).items.map(({ id }) => id), [51]);
  assert.deepEqual((await client.projects(a.grant, { query: '% coverage' })).items.map(({ id }) => id), [44]);
  assert.deepEqual((await client.projects(a.grant, { query: '_' })).items, []);
  assert.deepEqual((await client.projects(a.grant, { query: 'riverside' })).items.map(({ id }) => id), [44, 41]);
  assert.equal((await client.project(a.grant, 43)).responsibility, 'Survey and handover');
  const records = await client.projectRecords(a.grant, 44);
  assert.deepEqual(records.requirements.items.map(({ reference }) => reference), ['RD-61']);
  assert.equal(records.understanding.items[0].status, 'UD Approved By MD');
  assert.equal(records.kickoff.items[0].format, 'Video conference');
  assert.deepEqual((await client.projectRecords(a.grant, 41)).kickoff, { items: [], hasMore: false });
  assert.deepEqual((await client.projectRecords(b.grant, 51)).requirements.items.map(({ reference }) => reference), ['RD-63']);
  await assert.rejects(() => client.projectRecords(a.grant, 51), { code: 'not-found' });
  await assert.rejects(() => client.project(a.grant, 51), { code: 'not-found' });
  await assert.rejects(() => client.project(a.grant, 52), { code: 'not-found' });
  await assert.rejects(() => client.project(a.grant, 555), { code: 'not-found' });
  await assert.rejects(() => client.projects(noAccess.grant, {}), { code: 'forbidden' });
  await assert.rejects(() => client.project(noAccess.grant, 41), { code: 'forbidden' });
  const request = (body) => ({
    method: 'POST', headers: { Authorization: `Bearer ${a.grant.sessionToken}`, 'Content-Type': 'application/json' },
    body: JSON.stringify(body),
  });
  assert.equal((await fetch(`${base}projects/list`, request({ companyCode: 'QA-B' }))).status, 400);
  assert.equal((await fetch(`${base}projects/detail`, request({ id: '41' }))).status, 400);
  assert.equal((await fetch(`${base}projects/tasks`, request({ id: 44, before: 0 }))).status, 400);
  assert.equal((await fetch(`${base}projects/tasks`, request({ id: 44, companyCode: 'QA-B' }))).status, 400);
  assert.equal((await fetch(`${base}projects/tasks`, request({ query: 'pilot' }))).status, 400);
  assert.deepEqual((await client.projectTasks(a.grant, 44, {})).items.map(({ id }) => id), [206, 202, 201]);
  assert.deepEqual((await client.projectTasks(a.grant, 44, { query: 'PILOT', before: 206 })).items.map(({ id }) => id), [201]);
  assert.deepEqual((await client.projectTasks(a.grant, 44, { query: 'Noor' })).items.map(({ id }) => id), [202, 201]);
  assert.deepEqual((await client.projectTasks(a.grant, 44, { query: '%' })).items, []);
  assert.deepEqual(await client.projectTasks(a.grant, 41, {}), { items: [], next: null });
  assert.deepEqual((await client.projectTasks(b.grant, 51, {})).items.map(({ id }) => id), [204]);
  await assert.rejects(() => client.projectTasks(a.grant, 51, {}), { code: 'not-found' });
  await assert.rejects(() => client.projectTasks(a.grant, 52, {}), { code: 'not-found' });
  await assert.rejects(() => client.projectTasks(noAccess.grant, 44, {}), { code: 'forbidden' });
  assert.deepEqual((await client.projects(a.grant, { saved: true })).items, []);
  await Promise.all([client.setProjectFavorite(a.grant, 44, true), client.setProjectFavorite(a.grant, 44, true)]);
  assert.equal((await client.project(a.grant, 44)).favorite, true);
  assert.deepEqual((await client.projects(a.grant, { saved: true })).items.map(({ id }) => id), [44]);
  assert.deepEqual((await client.projects(a.grant, { saved: true, query: 'Wi-Fi' })).items, []);
  assert.deepEqual((await client.projects(b.grant, { saved: true })).items, []);
  await assert.rejects(() => client.setProjectFavorite(b.grant, 44, true), { code: 'not-found' });
  await assert.rejects(() => client.setProjectFavorite(noAccess.grant, 44, true), { code: 'forbidden' });
  assert.equal((await fetch(`${base}projects/favorite`, request({ id: 44, favorite: 'true' }))).status, 400);
  await client.setProjectFavorite(a.grant, 44, false);
  assert.equal((await client.project(a.grant, 44)).favorite, false);
  assert.deepEqual((await client.assignedTasks(a.grant)).items.map(({ id }) => id), [202, 201]);
  assert.deepEqual((await client.assignedTasks(a.grant, 202)).items.map(({ id }) => id), [201]);
  assert.deepEqual((await client.assignedTasks(b.grant)).items.map(({ id }) => id), [204]);
  assert.equal((await client.assignedTasks(a.grant)).items[1].developer, 'Noor Paul');
  assert.deepEqual((await client.myTasks(a.grant)).items.map(({ id }) => id), [206]);
  const { date, completed, loggedToday, ...history } = await client.workLog(a.grant, 206);
  assert.match(date, /^\d{2}\.\d{2}\.\d{4}$/);
  assert.equal(completed, false);
  assert.equal(loggedToday, date === '16.11.2026');
  assert.deepEqual(history, {
    taskId: 206, hasMore: false, items: [
      { id: 301, date: '16.11.2026', note: 'Verified pilot accounts and recorded rollout exceptions.', status: 'In-Progress', author: 'Alex Rao' },
    ],
  });
  await assert.rejects(() => client.workLog(a.grant, 207), { code: 'not-found' });
  await assert.rejects(() => client.workLog(b.grant, 206), { code: 'not-found' });
  await assert.rejects(() => client.assignedTasks(noAccess.grant), { code: 'forbidden' });
  assert.equal((await fetch(`${base}tasks/assigned-by-me`, request({ fullname: 'Alex Kim' }))).status, 400);
  const many = await client.signIn(credentials('phone'));
  const first = await client.projects(many.grant, {});
  assert.equal(first.items.length, 30);
  assert.equal(first.next, 103);
  const second = await client.projects(many.grant, { before: first.next });
  assert.deepEqual(second.items.map(({ id }) => id), [102, 101, 100]);
  assert.equal(second.next, null);
  assert.equal((await client.workLog(many.grant, 210)).loggedToday, false);
  await assert.rejects(() => client.logProgress(b.grant, 210, 'Outside the company'), { code: 'not-found' });
  await assert.rejects(() => client.completeTask(a.grant, 210), { code: 'not-found' });
  await assert.rejects(() => client.completeTask(a.grant, 201), { code: 'not-found' });
  await assert.rejects(() => client.completeTask(a.grant, 207), { code: 'not-found' });
  assert.equal((await fetch(`${base}tasks/progress`, request({ id: 206, note: ' ', date }))).status, 400);
  assert.equal((await fetch(`${base}tasks/progress`, request({ id: 206, note: ' '.repeat(256) }))).status, 400);
  const logs = await Promise.allSettled([
    client.logProgress(many.grant, 210, 'Tested support access & confirmed the handoff.'),
    client.logProgress(many.grant, 210, 'Concurrent progress note.'),
  ]);
  assert.equal(logs.filter((item) => item.status === 'fulfilled').length, 1);
  assert.equal(logs.find((item) => item.status === 'rejected').reason.code, 'progress-already-logged');
  const progress = await client.workLog(many.grant, 210);
  assert.equal(progress.loggedToday, true);
  assert.equal(progress.items.length, 1);
  assert.equal(progress.items[0].note, logs[0].status === 'fulfilled' ? 'Tested support access & confirmed the handoff.' : 'Concurrent progress note.');
  assert.equal(progress.items[0].author, 'Gia Gupta');
  assert.equal(progress.items[0].status, 'In-Progress');
  assert.ok(progress.items[0].id >= 1000);
  await Promise.all([client.completeTask(many.grant, 210), client.completeTask(many.grant, 210)]);
  const closed = await client.workLog(many.grant, 210);
  assert.equal(closed.completed, true);
  assert.deepEqual(closed.items.map(({ status }) => status), ['Completed', 'In-Progress']);
  assert.deepEqual((await client.completedTasks(many.grant)).items.map(({ id }) => id), [210]);
  const board = (await client.projectTasks(many.grant, 100, {})).items;
  assert.deepEqual(board.map(({ id, status, workLog }) => [id, status, workLog]), [[210, 'Completed', true]]);
  assert.deepEqual((await client.myTasks(many.grant)).items.map(({ id }) => id), [211]);
  await assert.rejects(() => client.logProgress(many.grant, 210, 'After completion'), { code: 'task-closed' });
  await assert.rejects(() => client.completeTask(many.grant, 211), { code: 'unavailable' });
  assert.equal((await client.workLog(many.grant, 211)).completed, false);
  assert.deepEqual((await client.myTasks(many.grant)).items.map(({ id }) => id), [211]);
  const currentDates = await client.taskDates(a.grant, 206);
  assert.equal(currentDates.requestMode, 'due');
  assert.equal(currentDates.due, '20.11.2026');
  await assert.rejects(() => client.taskDates(b.grant, 206), { code: 'not-found' });
  await assert.rejects(() => client.taskDates(noAccess.grant, 206), { code: 'forbidden' });
  await assert.rejects(() => client.requestTaskDates(a.grant, 206, { due: '2026-02-29', reason: '' }), { code: 'date-range' });
  await assert.rejects(() => client.requestTaskDates(a.grant, 206, { due: '12.11.2026', reason: '' }), { code: 'date-range' });
  await assert.rejects(() => client.requestTaskDates(a.grant, 206, { due: '26.11.2026', reason: '&'.repeat(255) }), { code: 'date-reason-length' });
  await assert.rejects(() => client.requestTaskDates(a.grant, 206, { start: '20.11.2026', due: '26.11.2026', reason: 'Scope test' }), { code: 'not-found' });
  const requestReason = 'Pilot follow-up & access checks < 4 hours';
  const requested = await Promise.allSettled([
    client.requestTaskDates(a.grant, 206, { due: '2026-11-26', reason: requestReason }),
    client.requestTaskDates(a.grant, 206, { due: '26.11.2026', reason: requestReason }),
  ]);
  assert.equal(requested.filter((item) => item.status === 'fulfilled').length, 1);
  assert.equal(requested.find((item) => item.status === 'rejected').reason.code, 'date-change-conflict');
  const awaiting = await client.taskDates(a.grant, 206);
  assert.equal(awaiting.approval, 'Pending for approval');
  assert.equal(awaiting.requestedDue, '26.11.2026');
  assert.equal(awaiting.due, '20.11.2026');
  assert.equal(awaiting.canApprove, false);
  assert.equal(awaiting.reason, requestReason);
  assert.equal((await client.projectTasks(a.grant, 44, {query: 'acceptance'})).items[0].due, '20.11.2026');
  assert.deepEqual((await client.myTasks(a.grant)).items, []);
  assert.deepEqual((await client.dateQueue(a.grant, 'mine')).items.map(({ id }) => id), [206]);
  assert.deepEqual((await client.dateQueue(many.grant, 'review')).items.map(({ id }) => id), [206]);
  await assert.rejects(() => client.approveTaskDates(a.grant, 206, awaiting.revision), { code: 'not-found' });
  await assert.rejects(() => client.approveTaskDates(b.grant, 206, awaiting.revision), { code: 'not-found' });
  await assert.rejects(() => client.approveTaskDates(many.grant, 206, 'a'.repeat(43)), { code: 'date-change-conflict' });
  assert.equal((await client.taskDates(many.grant, 206)).canApprove, true);
  const approvals = await Promise.allSettled([
    client.approveTaskDates(many.grant, 206, awaiting.revision),
    client.approveTaskDates(many.grant, 206, awaiting.revision),
  ]);
  assert.equal(approvals.filter((item) => item.status === 'fulfilled').length, 1);
  assert.equal(approvals.find((item) => item.status === 'rejected').reason.code, 'date-change-conflict');
  const confirmedDates = await client.taskDates(a.grant, 206);
  assert.equal(confirmedDates.due, '26.11.2026');
  assert.equal(confirmedDates.approval, 'Date Approved');
  assert.equal(confirmedDates.revision, null);
  assert.deepEqual(confirmedDates.history.map(({ due, revisedDue, by, reason }) => [due, revisedDue, by, reason]),
    [['20.11.2026', '26.11.2026', 'Gia Gupta', requestReason]]);
  assert.deepEqual((await client.myTasks(a.grant)).items.map(({ id }) => id), [206]);
  assert.equal((await client.projectTasks(a.grant, 44, {query: 'acceptance'})).items[0].due, '26.11.2026');
  assert.deepEqual((await client.dateQueue(many.grant, 'review')).items, []);

  assert.deepEqual((await client.dateQueue(a.grant, 'team')).items.map(({ id }) => id), [212]);
  assert.equal((await client.taskDates(a.grant, 212)).requestMode, 'schedule');
  await assert.rejects(() => client.requestTaskDates(a.grant, 212, { start: '04.12.2026', due: '09.12.2026', reason: '' }), { code: 'date-range' });
  await client.requestTaskDates(a.grant, 212, { start: '04.12.2026', due: '09.12.2026', reason: 'Site access shifted' });
  assert.deepEqual((await client.dateQueue(a.grant, 'review')).items, []);
  const schedule = await client.taskDates(many.grant, 212);
  assert.equal(schedule.requestedStart, '04.12.2026');
  await client.approveTaskDates(many.grant, 212, schedule.revision);
  const revisedSchedule = await client.taskDates(a.grant, 212);
  assert.equal(revisedSchedule.start, '04.12.2026');
  assert.equal(revisedSchedule.due, '09.12.2026');
  assert.equal(revisedSchedule.history[0].start, '02.12.2026');
  assert.equal(revisedSchedule.history[0].revisedStart, '04.12.2026');

  await client.requestTaskDates(many.grant, 211, { due: '30.11.2026', reason: '' });
  const rollbackDate = await client.taskDates(a.grant, 211);
  await assert.rejects(() => client.approveTaskDates(a.grant, 211, rollbackDate.revision), { code: 'unavailable' });
  const rolledBack = await client.taskDates(a.grant, 211);
  assert.equal(rolledBack.approval, 'Pending for approval');
  assert.equal(rolledBack.revision, rollbackDate.revision);
  assert.equal(rolledBack.due, '');
  assert.deepEqual(rolledBack.history, []);
  const roster = await client.assignees(many.grant, 100, true);
  assert.deepEqual(roster.items.map(({ name }) => name), ['Dev Singh', 'Gia Gupta', 'Noor Paul']);
  assert.deepEqual((await client.assignees(many.grant, 100, true, 'noor')).items.map(({ name }) => name), ['Noor Paul']);
  await assert.rejects(() => client.assignees(a.grant, 44, true), { code: 'forbidden' });
  await assert.rejects(() => client.assignees(many.grant, 44, true), { code: 'not-found' });
  const draft = {
    module: 'Pilot clean-up & handoff', description: 'Complete the follow-up checks for the VPN pilot.',
    start: '2026-11-27', due: '30.11.2026', priority: 'High', weight: '20',
    candidate: roster.items.find(({ name }) => name === 'Gia Gupta').key,
    requestKey: 'scm-stage-assignment-retry-001',
  };
  await assert.rejects(() => client.createTask(many.grant, 100, { ...draft, due: '26.11.2026' }), { code: 'invalid-task-draft' });
  await assert.rejects(() => client.createTask(many.grant, 100, { ...draft, weight: '70' }), { code: 'task-weight-limit' });
  await assert.rejects(() => client.createTask(many.grant, 100, { ...draft, candidate: 'z'.repeat(43) }), { code: 'candidate-unavailable' });
  const created = await Promise.all([client.createTask(many.grant, 100, draft), client.createTask(many.grant, 100, draft)]);
  assert.equal(created[0], created[1]);
  const taskId = created[0];
  await assert.rejects(() => client.createTask(many.grant, 100, { ...draft, module: 'Changed draft' }), { code: 'task-assignment-conflict' });
  const asCreated = (await client.projectTasks(many.grant, 100, {})).items.filter((task) => task.id === taskId);
  assert.equal(asCreated.length, 1);
  assert.match(asCreated[0].reference, /^Riverside Works-\d+$/);
  assert.equal(asCreated[0].priority, 'High');
  assert.equal(asCreated[0].weight, '20');
  assert.deepEqual(asCreated.map(({ module, start, due, developer, status }) => [module, start, due, developer, status]),
    [[draft.module, '27.11.2026', '30.11.2026', 'Gia Gupta', 'Pending']]);
  assert.ok((await client.myTasks(many.grant)).items.some((task) => task.id === taskId));
  assert.ok((await client.assignedTasks(many.grant)).items.some((task) => task.id === taskId));
  assert.ok((await client.assignmentQueue(many.grant)).items.some((task) => task.id === taskId));
  await assert.rejects(() => client.assignees(many.grant, 210, false), { code: 'not-found' });
  await assert.rejects(() => client.assignees(b.grant, taskId, false), { code: 'not-found' });
  const transfer = await client.assignees(many.grant, taskId, false);
  assert.deepEqual(transfer.items.map(({ name }) => name), ['Dev Singh', 'Noor Paul']);
  await assert.rejects(() => client.reassignTask(many.grant, taskId, 'a'.repeat(43), transfer.items[1].key), { code: 'task-assignment-conflict' });
  await client.reassignTask(many.grant, taskId, transfer.revision, transfer.items[1].key);
  await assert.rejects(() => client.reassignTask(many.grant, taskId, transfer.revision, transfer.items[0].key), { code: 'task-assignment-conflict' });
  const transferred = (await client.projectTasks(many.grant, 100, {})).items.find((task) => task.id === taskId);
  assert.equal(transferred.developer, 'Noor Paul');
  assert.equal(transferred.due, '30.11.2026');
  assert.ok(!(await client.myTasks(many.grant)).items.some((task) => task.id === taskId));
  const recipientChallenge = await client.signIn(credentials('totp'));
  const recipient = await client.verify(recipientChallenge.challengeId, totp('GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ', Math.floor(Date.now() / 30_000)));
  assert.equal(recipient.kind, 'authenticated');
  assert.equal((await client.myTasks(recipient.grant)).items.find((task) => task.id === taskId).developer, 'Noor Paul');
  const rollbackDraft = { ...draft, module: 'Assignment rollback fixture', weight: '25', requestKey: 'scm-stage-rollback-assignment-01' };
  await assert.rejects(() => client.createTask(many.grant, 101, rollbackDraft), { code: 'unavailable' });
  assert.deepEqual((await client.projectTasks(many.grant, 101, {})).items, []);
  const exactWeight = await client.createTask(many.grant, 100, {
    ...draft, module: 'Remaining allocation', weight: '49.75', requestKey: 'scm-stage-exact-assignment-001',
  });
  assert.ok(exactWeight > taskId);
  await assert.rejects(() => client.createTask(many.grant, 100, {
    ...draft, weight: '0.01', requestKey: 'scm-stage-excess-assignment-001',
  }), { code: 'task-weight-limit' });

  assert.equal(many.session.identity.capabilities.includes('tasks.create-standalone'), true);
  await assert.rejects(() => client.taskContexts(a.grant), { code: 'forbidden' });
  const catalog = await client.taskContexts(many.grant);
  assert.deepEqual(catalog.items.map(({ customer }) => customer), ['Harbor Clinic', 'Riverside Works']);
  assert.ok(catalog.functions.includes('Development'));
  assert.deepEqual(catalog.responsibilities, ['Velox Solution', 'End Customer']);
  assert.deepEqual((await client.taskContexts(many.grant, 'device')).items, [catalog.items[0]]);
  assert.deepEqual((await client.taskContexts(many.grant, '%')).items, []);
  const context = catalog.items[0];
  const scope = { context, function: 'Development', responsibility: 'End Customer' };
  const options = await client.standaloneAssignees(many.grant, context);
  assert.deepEqual(options.items.map(({ name }) => name), ['Dev Singh', 'Gia Gupta', 'Noor Paul']);
  assert.ok(recipient.session.identity.capabilities.includes('tasks.create-standalone'));
  assert.ok(!recipient.session.identity.capabilities.includes('projects.read'));
  assert.deepEqual((await client.standaloneAssignees(recipient.grant, context)).items.map(({ name }) => name), ['Noor Paul']);
  await assert.rejects(() => client.createTask(recipient.grant, scope, draft), { code: 'candidate-unavailable' });
  await assert.rejects(() => client.standaloneAssignees(many.grant, { ...context, customer: 'Other Roster', suite: 'Service Operations',
    tool: 'Endpoint' }), { code: 'not-found' });
  await assert.rejects(() => client.standaloneAssignees(b.grant, context), { code: 'forbidden' });
  const soloDraft = { ...draft, module: 'Inventory endpoint devices', requestKey: 'scm-stage-standalone-assignment-01' };
  await assert.rejects(() => client.createTask(many.grant, { ...scope, function: 'Unconfigured' }, soloDraft), { code: 'invalid-task-draft' });
  await assert.rejects(() => client.createTask(many.grant, { ...scope, context: { ...context, tool: 'Unrelated' } }, soloDraft), { code: 'not-found' });
  const standalone = await client.createTask(many.grant, scope, soloDraft);
  assert.equal(await client.createTask(many.grant, scope, soloDraft), standalone);
  await assert.rejects(() => client.createTask(many.grant, { ...scope, responsibility: 'Velox Solution' }, soloDraft), { code: 'task-assignment-conflict' });
  const solo = (await client.assignedTasks(many.grant)).items.find((task) => task.id === standalone);
  assert.equal(solo.customer, 'Harbor Clinic');
  assert.equal(solo.tool, 'Device Security');
  assert.equal(solo.developer, 'Gia Gupta');
  assert.equal(solo.function, 'Development');
  assert.equal(solo.responsibility, 'End Customer');
  assert.match(solo.reference, /^Harbor Clinic-\d+$/);
  assert.ok((await client.myTasks(many.grant)).items.some((task) => task.id === standalone));
  assert.ok(!(await client.projectTasks(many.grant, 100, {})).items.some((task) => task.id === standalone));

  const projectTransfer = await client.assignees(many.grant, taskId, false);
  const soloTransfer = await client.assignees(many.grant, standalone, false);
  const changes = [
    { id: taskId, revision: projectTransfer.revision, candidate: projectTransfer.items.find(({ name }) => name === 'Dev Singh').key },
    { id: standalone, revision: soloTransfer.revision, candidate: soloTransfer.items.find(({ name }) => name === 'Noor Paul').key },
  ];
  await assert.rejects(() => client.reassignTasks(many.grant, [changes[0], { ...changes[1], revision: 'a'.repeat(43) }]),
    { code: 'task-assignment-conflict', taskId: standalone });
  assert.equal((await client.assignees(many.grant, taskId, false)).revision, projectTransfer.revision);
  assert.equal((await client.assignees(many.grant, standalone, false)).revision, soloTransfer.revision);
  await assert.rejects(() => client.reassignTasks(b.grant, changes), { code: 'not-found', taskId });
  const duplicate = await fetch(new URL('tasks/assignments/reassign-bulk', base), {
    method: 'POST', headers: { Authorization: 'Bearer ' + many.grant.sessionToken, 'Content-Type': 'application/json' },
    body: JSON.stringify({ items: [changes[0], changes[0]] }),
  });
  assert.equal(duplicate.status, 400);
  await client.reassignTasks(many.grant, [...changes].reverse());
  const afterBatch = (await client.assignmentQueue(many.grant)).items;
  assert.equal(afterBatch.find((task) => task.id === taskId).developer, 'Dev Singh');
  assert.equal(afterBatch.find((task) => task.id === taskId).due, '30.11.2026');
  assert.equal(afterBatch.find((task) => task.id === standalone).developer, 'Noor Paul');
  assert.equal((await client.myTasks(recipient.grant)).items.find((task) => task.id === standalone).developer, 'Noor Paul');
  assert.ok(!(await client.myTasks(recipient.grant)).items.some((task) => task.id === taskId));
  await client.signOut(a.grant);
  await assert.rejects(() => client.profile(a.grant), { code: 'expired' });
  await assert.rejects(() => client.projects(a.grant, {}), { code: 'expired' });
  await assert.rejects(() => client.assignedTasks(a.grant), { code: 'expired' });
});

await test('team schedule proposals and approvals apply each batch atomically', async () => {
  const client = createAuthClient(resolveAuthConfig(datesBase, true));
  const lead = await client.signIn(credentials('schedule-lead'));
  const reviewer = await client.signIn(credentials('schedule-manager'));
  const assignee = await client.signIn(credentials('schedule-assignee'));
  assert.equal(lead.kind, 'authenticated');
  assert.equal(reviewer.kind, 'authenticated');
  assert.equal(assignee.kind, 'authenticated');

  const queue = await client.dateQueue(lead.grant, 'team');
  assert.deepEqual(queue.items.map(({ id }) => id), [194, 193]);
  const [first, second] = await Promise.all([client.taskDates(lead.grant, 193), client.taskDates(lead.grant, 194)]);
  assert.match(first.scheduleRevision, /^[A-Za-z0-9_-]{43}$/);
  assert.match(second.scheduleRevision, /^[A-Za-z0-9_-]{43}$/);
  const proposals = [
    { id: 193, start: '19.11.2026', due: '23.11.2026', reason: 'Pilot readiness & sign-off', revision: first.scheduleRevision },
    { id: 194, start: '23.11.2026', due: '27.11.2026', reason: 'More time for access validation', revision: second.scheduleRevision },
  ];
  await assert.rejects(() => client.requestTaskDatesBatch(assignee.grant, proposals), { code: 'not-found', taskId: 193 });
  await assert.rejects(() => client.requestTaskDatesBatch(lead.grant, [proposals[0], { ...proposals[1], due: '21.11.2026' }]),
    { code: 'date-range', taskId: 194 });
  await assert.rejects(() => client.requestTaskDatesBatch(lead.grant, [proposals[0], { ...proposals[1], reason: '<'.repeat(255) }]),
    { code: 'date-reason-length', taskId: 194 });
  await assert.rejects(() => client.requestTaskDatesBatch(lead.grant, [proposals[0], { ...proposals[1], revision: 'b'.repeat(43) }]),
    { code: 'date-change-conflict', taskId: 194 });
  assert.equal((await client.taskDates(lead.grant, 193)).revision, null);
  assert.equal((await client.taskDates(lead.grant, 194)).revision, null);
  await client.requestTaskDatesBatch(lead.grant, [...proposals].reverse());
  assert.deepEqual((await client.dateQueue(lead.grant, 'team')).items, []);
  assert.deepEqual((await client.dateQueue(lead.grant, 'mine')).items.map(({ id, dateApproval }) => [id, dateApproval]),
    [[194, 'Pending for approval'], [193, 'Pending for approval']]);
  assert.deepEqual((await client.dateQueue(reviewer.grant, 'mine')).items, []);

  const pending = await client.dateQueue(reviewer.grant, 'review');
  const items = pending.items;
  assert.deepEqual(items.map(({ id }) => id), [196, 195, 194, 193]);
  const approval = (taskId) => {
    const task = items.find(({ id }) => id === taskId);
    assert.ok(task.dateReview.canApprove);
    return { id: task.id, revision: task.dateReview.revision };
  };
  const pendingFirst = items.find(({ id }) => id === 193);
  assert.equal(pendingFirst.start, '18.11.2026');
  assert.deepEqual(pendingFirst.dateReview, {
    start: '19.11.2026', due: '23.11.2026', reason: 'Pilot readiness & sign-off', revision: approval(193).revision, canApprove: true,
  });
  assert.equal(approval(193).revision, (await client.taskDates(reviewer.grant, 193)).revision);
  assert.equal(items.find(({ id }) => id === 195).dateReview.start, '25.11.2026');
  await assert.rejects(() => client.approveTaskDatesBatch(lead.grant, [approval(193), approval(195)]), { code: 'not-found', taskId: 193 });
  await assert.rejects(() => client.approveTaskDatesBatch(reviewer.grant, [approval(193), { ...approval(194), revision: 'b'.repeat(43) }]),
    { code: 'date-change-conflict', taskId: 194 });
  await assert.rejects(() => client.approveTaskDatesBatch(reviewer.grant, [approval(193), approval(196)]), { code: 'unavailable' });
  assert.equal((await client.taskDates(reviewer.grant, 193)).revision, approval(193).revision);
  assert.deepEqual((await client.taskDates(reviewer.grant, 193)).history, []);
  assert.deepEqual((await client.taskDates(reviewer.grant, 196)).history, []);
  await client.approveTaskDatesBatch(reviewer.grant, [approval(194), approval(195), approval(193)]);
  assert.deepEqual((await client.dateQueue(reviewer.grant, 'review')).items.map(({ id }) => id), [196]);
  assert.deepEqual((await client.dateQueue(lead.grant, 'mine')).items.map(({ id, dateApproval }) => [id, dateApproval]),
    [[194, 'Date Approved'], [193, 'Date Approved']]);
  const assigned = await client.myTasks(assignee.grant);
  assert.deepEqual(assigned.items.map(({ id, start, due }) => [id, start, due]), [
    [195, '25.11.2026', '30.11.2026'], [194, '23.11.2026', '27.11.2026'], [193, '19.11.2026', '23.11.2026'],
  ]);
  for (const id of [193, 194, 195]) {
    const dates = await client.taskDates(assignee.grant, id);
    assert.equal(dates.approval, 'Date Approved');
    assert.deepEqual(dates.history.map(({ by, revisedStart, revisedDue }) => [by, revisedStart, revisedDue]),
      [['Raj Nair', dates.start, dates.due]]);
  }
});

await test('an authorized creator can save a first project and use the new workspace', async () => {
  const client = createAuthClient(resolveAuthConfig(datesBase, true));
  const creator = await client.signIn(credentials('project-creator'));
  const viewer = await client.signIn(credentials('alex'));
  const otherCompany = await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'));
  for (const account of [creator, viewer, otherCompany]) assert.equal(account.kind, 'authenticated');
  for (const capability of ['projects.read', 'projects.create', 'tasks.create']) {
    assert.ok(creator.session.identity.capabilities.includes(capability));
  }
  assert.deepEqual((await client.projects(creator.grant, {})).items, []);
  assert.ok(viewer.session.identity.capabilities.includes('projects.read'));
  assert.ok(!viewer.session.identity.capabilities.includes('projects.create'));
  await assert.rejects(() => client.projectCreateOptions(viewer.grant, {}), { code: 'forbidden' });
  const options = await client.projectCreateOptions(creator.grant, {});
  assert.deepEqual(options.contexts.map(({ customer }) => customer), ['Harbor Clinic', 'Riverside Works']);
  assert.deepEqual(options.functions, ['Access rollout', 'Development', 'Development planning', 'Implementation']);
  assert.deepEqual(options.responsibilities, ['Velox Solution', 'End Customer']);
  const scoped = await client.projectCreateOptions(creator.grant, { query: 'device security', functionQuery: 'implement' });
  assert.deepEqual(scoped.contexts, [options.contexts[0]]);
  assert.deepEqual(scoped.functions, ['Implementation']);
  assert.deepEqual((await client.projectCreateOptions(creator.grant, { query: '%' })).contexts, []);

  const draft = {
    name: 'Harbor device rollout & validation', function: 'Development', responsibility: 'End Customer',
    context: options.contexts[0], requestKey: 'qa-project-concurrent-save-0001',
  };
  await assert.rejects(() => client.createProject(viewer.grant, draft), { code: 'forbidden' });
  await assert.rejects(() => client.createProject(otherCompany.grant, draft), { code: 'forbidden' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft,
    context: { customer: 'Valley Logistics', suite: 'Service Operations', tool: 'Warehouse access' } }), { code: 'project-context-unavailable' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft, function: 'Unconfigured' }), { code: 'project-function-unavailable' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft, name: '' }), { code: 'invalid-project-draft' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft, name: 'Paging test project',
    context: options.contexts[1], function: 'Access rollout' }), { code: 'project-duplicate' });

  const [created, retry] = await Promise.all([client.createProject(creator.grant, draft), client.createProject(creator.grant, draft)]);
  assert.deepEqual(created, retry);
  assert.equal(created.name, draft.name);
  assert.equal(created.reference, 'Harbor Clinic-' + created.id);
  assert.deepEqual((await client.projects(creator.grant, {})).items, [created]);
  assert.deepEqual(await client.project(creator.grant, created.id), created);
  await assert.rejects(() => client.project(viewer.grant, created.id), { code: 'not-found' });
  await assert.rejects(() => client.project(otherCompany.grant, created.id), { code: 'not-found' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft, name: 'Modified draft' }), { code: 'project-request-conflict' });
  await assert.rejects(() => client.createProject(creator.grant, { ...draft, requestKey: 'qa-project-duplicate-scope-001' }), { code: 'project-duplicate' });
  assert.deepEqual((await client.projectRecords(creator.grant, created.id)).requirements.items, []);
  assert.deepEqual((await client.projectTasks(creator.grant, created.id, {})).items, []);
  const roster = await client.assignees(creator.grant, created.id, true);
  const assigned = await client.createTask(creator.grant, created.id, {
    module: 'Inspect received devices', description: 'Review the inventory before validation.', start: '17.11.2026', due: '20.11.2026',
    priority: 'Normal', weight: '10', candidate: roster.items.find(({ name }) => name === 'Anika Mehta').key,
    requestKey: 'qa-project-first-task-save-0001',
  });
  assert.deepEqual((await client.projectTasks(creator.grant, created.id, {})).items.map(({ id, developer }) => [id, developer]),
    [[assigned, 'Anika Mehta']]);
  await client.setProjectFavorite(creator.grant, created.id, true);
  assert.equal((await client.projects(creator.grant, { saved: true })).items[0].id, created.id);

  const rollback = { ...draft, name: 'Receipt rollback specimen', requestKey: 'qa-project-receipt-failure-0001' };
  await assert.rejects(() => client.createProject(creator.grant, rollback), { code: 'unavailable' });
  assert.deepEqual((await client.projects(creator.grant, { query: rollback.name })).items, []);
  const recovered = await client.createProject(creator.grant, { ...rollback, requestKey: 'qa-project-receipt-retry-0001' });
  assert.equal(recovered.id, created.id + 1);
});

await test('Publish Project browses scoped progress and opens the exact purchase order, Form C and tasks', async () => {
  const client = createAuthClient(resolveAuthConfig(datesBase, true));
  const publisher = await client.signIn(credentials('publish-reviewer'));
  const other = await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'));
  assert.equal(publisher.kind, 'authenticated');
  assert.equal(other.kind, 'authenticated');
  assert.ok(publisher.session.identity.capabilities.includes('projects.publish'));
  assert.deepEqual((await client.publishTree(publisher.grant, {})).items.map(({ label }) => label), ['Development', 'Development planning']);
  const phase = { phase: 'Development' };
  const suite = { ...phase, suite: 'Service Operations' };
  const tool = { ...suite, tool: 'VPN Access' };
  assert.deepEqual((await client.publishTree(publisher.grant, phase)).items, [{ label: suite.suite, completedWeight: null }]);
  assert.deepEqual((await client.publishTree(publisher.grant, suite)).items, [{ label: tool.tool, completedWeight: null }]);
  assert.deepEqual((await client.publishTree(publisher.grant, tool)).items, [
    { label: 'Riverside Works', completedWeight: '35.25' }, { label: 'Unordered Lab', completedWeight: '5' },
  ]);
  assert.deepEqual((await client.publishTree(publisher.grant, tool, 'river')).items, [{ label: 'Riverside Works', completedWeight: '35.25' }]);
  assert.deepEqual((await client.publishTree(publisher.grant, tool, '%')).items, []);
  assert.deepEqual((await client.publishTree(publisher.grant, { ...tool, phase: 'Development planning' })).items,
    [{ label: 'Riverside Works', completedWeight: '10.25' }]);
  assert.deepEqual((await client.publishTree(other.grant, tool)).items, []);

  const customer = { ...tool, customer: 'Riverside Works' };
  const orders = await client.publishOrders(publisher.grant, customer);
  assert.deepEqual(orders.items.map(({ id, reference }) => [id, reference]), [[904, 'PO-913'], [901, 'PO-910']]);
  assert.deepEqual((await client.publishOrders(publisher.grant, customer, 904)).items.map(({ id }) => id), [901]);
  assert.deepEqual((await client.publishOrders(publisher.grant, { ...tool, customer: 'Unordered Lab' })).items, []);
  await assert.rejects(() => client.publishOrders(publisher.grant, { ...tool, customer: 'Over Limit' }), { code: 'not-found' });
  await assert.rejects(() => client.publishOrders(publisher.grant, { ...customer, tool: 'Device Security' }), { code: 'not-found' });
  for (const id of [902, 905, 906]) await assert.rejects(() => client.publishOrder(publisher.grant, id), { code: 'not-found' });
  await assert.rejects(() => client.publishOrder(other.grant, 901), { code: 'not-found' });
  await assert.rejects(() => client.publishOrderTasks(other.grant, 901), { code: 'not-found' });

  const detail = await client.publishOrder(publisher.grant, 901);
  assert.equal(detail.item.projectId, 44);
  assert.equal(detail.item.formStatus, 'FORM3 Submitted');
  assert.equal(detail.item.paymentTerms, 'Net 30');
  assert.equal(detail.formC.project, 'Riverside VPN pilot');
  assert.equal(detail.formC.implementorEmail, 'dev+scm@fixture.invalid');
  assert.deepEqual(detail.formC.milestones, [
    { name: 'Server availability', description: 'Pilot servers ready', responsibility: 'End Customer', start: '16.11.2026', due: '18.11.2026' },
    { name: 'Sign-off', description: 'Customer sign-off', responsibility: '', start: '', due: '29.11.2026' },
  ]);
  const manual = await client.publishOrder(publisher.grant, 904);
  assert.equal(manual.formC, null);
  assert.equal(manual.item.projectId, null);
  assert.deepEqual((await client.publishOrderTasks(publisher.grant, 901)).items.map(({ id, assignedAt }) => [id, assignedAt]),
    [[187, '15.11.2026'], [182, '18.11.2026'], [181, '17.11.2026']]);
  assert.deepEqual((await client.publishOrderTasks(publisher.grant, 904)).items, []);

  const orderTarget = { scope: 'purchase-order', id: 901 };
  assert.deepEqual(await client.projectAttachments(publisher.grant, orderTarget), [
    { kind: 'masked-po', name: 'Riverside masked.pdf', mimeType: 'application/pdf' },
    { kind: 'product-features', name: 'Riverside – features.txt', mimeType: 'text/plain' },
  ]);
  assert.deepEqual(await client.projectAttachments(publisher.grant, { ...orderTarget, id: 904 }), []);
  await assert.rejects(() => client.projectAttachments(other.grant, orderTarget), { code: 'not-found' });
  const download = (grant, target) => fetch(new URL('projects/attachments/download', datesBase), {
    method: 'POST', headers: { 'Content-Type': 'application/json', ...(grant ? { Authorization: 'Bearer ' + grant.sessionToken } : {}) },
    body: JSON.stringify(target),
  });
  const masked = { ...orderTarget, kind: 'masked-po' };
  assert.equal((await download(null, masked)).status, 401);
  assert.equal((await download(other.grant, masked)).status, 404);
  assert.equal((await download(publisher.grant, { ...masked, kind: 'unmasked-po' })).status, 400);
  assert.equal((await download(publisher.grant, { ...masked, filename: 'Unmasked PO.pdf' })).status, 400);
  const pdf = await download(publisher.grant, masked);
  assert.equal(pdf.status, 200);
  assert.match(pdf.headers.get('content-type'), /^application\/pdf/);
  assert.equal(pdf.headers.get('cache-control'), 'no-store, no-transform');
  assert.match(pdf.headers.get('content-disposition'), /filename\*=UTF-8''Riverside%20masked\.pdf$/);
  const bytes = Buffer.from(await pdf.arrayBuffer());
  assert.equal(bytes.byteLength, Number(pdf.headers.get('content-length')));
  assert.equal(bytes.subarray(0, 8).toString(), '%PDF-1.4');
  assert.match(bytes.toString(), /Masked purchase order - Riverside pilot/);
  const features = await download(publisher.grant, { ...orderTarget, kind: 'product-features' });
  assert.equal(features.status, 200);
  assert.match(features.headers.get('content-disposition'), /Riverside%20%E2%80%93%20features\.txt$/);
  assert.equal(await features.text(), 'VPN pilot; device policy validation.\n');
  const requirement = { scope: 'requirement', id: 44, recordId: 61 };
  const understanding = { scope: 'understanding', id: 44, recordId: 71 };
  const kickoff = { scope: 'kickoff', id: 44, recordId: 81 };
  const rd = await client.projectRecordDetail(publisher.grant, requirement);
  assert.equal(rd.item.reference, 'RD-61');
  assert.equal(rd.fields.submittedBy, 'Alex Rao');
  assert.equal(rd.fields.requirementNote, 'Validate VPN coverage on the first 24 devices.');
  assert.equal(rd.fields.designation, undefined);
  const ud = await client.projectRecordDetail(publisher.grant, understanding);
  assert.equal(ud.item.status, 'UD Approved By MD');
  assert.equal(ud.fields.requirementReference, 'RD-61');
  assert.equal(ud.fields.end, '29.11.2026');
  assert.equal(ud.fields.functional, 'Sign in through the company directory');
  const meeting = await client.projectRecordDetail(publisher.grant, kickoff);
  assert.equal(meeting.item.format, 'Video conference');
  assert.equal(meeting.item.date, '19-11-2026 10:00');
  assert.equal(meeting.fields.projectHead, 'Anika Mehta');
  assert.equal(meeting.fields.meetingLink, 'https://meet.fixture.invalid/riverside-kickoff');
  for (const target of [{ ...requirement, recordId: 62 }, { ...requirement, id: 51, recordId: 63 }, { ...kickoff, recordId: 61 }]) {
    await assert.rejects(() => client.projectRecordDetail(publisher.grant, target), { code: 'not-found' });
  }
  await assert.rejects(() => client.projectRecordDetail(other.grant, kickoff), { code: 'not-found' });
  const recordRequest = (target, grant) => fetch(new URL('projects/records/detail', datesBase), {
    method: 'POST', headers: { 'Content-Type': 'application/json', ...(grant ? { Authorization: 'Bearer ' + grant.sessionToken } : {}) },
    body: JSON.stringify(target),
  });
  assert.equal((await recordRequest(kickoff)).status, 401);
  assert.equal((await recordRequest({ ...kickoff, scope: 'unknown' }, publisher.grant)).status, 400);
  assert.equal((await recordRequest({ ...kickoff, recordId: '81' }, publisher.grant)).status, 400);
  assert.deepEqual((await client.projectAttachments(publisher.grant, requirement)).map(({ kind }) => kind),
    ['requirement-file', 'masked-po', 'scope-of-work', 'rfp', 'other']);
  const scopeFile = await download(publisher.grant, { ...requirement, kind: 'scope-of-work' });
  assert.equal(scopeFile.status, 200);
  assert.equal(await scopeFile.text(), 'Riverside pilot deployment scope.\n');
  for (const kind of ['rfp', 'other']) {
    assert.equal((await download(publisher.grant, { ...requirement, kind })).status, 404);
  }
  assert.equal((await download(publisher.grant, { ...requirement, recordId: 62, kind: 'requirement-file' })).status, 404);
  assert.equal((await download(publisher.grant, { ...requirement, id: 51, kind: 'requirement-file' })).status, 404);
  assert.deepEqual((await client.projectAttachments(publisher.grant, understanding))
    .map(({ kind }) => kind), ['understanding-file', 'requirement-file']);
  assert.deepEqual(await client.projectAttachments(publisher.grant, kickoff), [
    { kind: 'kickoff-agenda', name: 'Riverside agenda.pdf', mimeType: 'application/pdf' },
    { kind: 'kickoff-plan', name: 'Riverside meeting plan.pdf', mimeType: 'application/pdf' },
  ]);
  const plan = await download(publisher.grant, { ...kickoff, kind: 'kickoff-plan' });
  assert.equal(plan.status, 200);
  assert.match(await plan.text(), /Kickoff plan for Riverside/);
  assert.equal((await download(other.grant, { ...kickoff, kind: 'kickoff-plan' })).status, 404);
});

await test('document decisions require the current revision, legacy review scope, and exact project and company', async () => {
  const reviewClient = createAuthClient(resolveAuthConfig(datesBase, true));
  const director = (await reviewClient.signIn(credentials('document-director'))).grant;
  const projectHead = (await reviewClient.signIn(credentials('document-project-head'))).grant;
  const limited = await reviewClient.signIn(credentials('document-limited'));
  const other = (await reviewClient.signIn(credentials('document-other-company', 'QA-B'))).grant;
  assert.ok(director && projectHead && limited.grant && other);

  const understand = (recordId) => ({ scope: 'understanding', id: 47, recordId });
  const requirement = { scope: 'requirement', id: 47, recordId: 64 };
  const item = await reviewClient.projectRecordDetail(director, understand(72));
  assert.match(item.review.revision, /^[A-Za-z0-9_-]{43}$/);
  assert.equal(item.review.canReject, true);
  const approval = { decision: 'approve', revision: item.review.revision };
  const queue = await reviewClient.documentReviewQueue(director, 'understanding');
  assert.deepEqual(queue.items.map(({ id, projectId, projectReference }) => [id, projectId, projectReference]),
    [[74, 47, 'PM-1047'], [73, 47, 'PM-1047'], [72, 47, 'PM-1047']]);
  assert.deepEqual((await reviewClient.documentReviewQueue(projectHead, 'understanding', 74)).items.map(({ id }) => id), [73, 72]);
  assert.deepEqual((await reviewClient.documentReviewQueue(other, 'understanding')).items.map(({ id }) => id), [76]);
  await assert.rejects(() => reviewClient.documentReviewQueue(projectHead, 'requirement'), { code: 'forbidden' });
  await assert.rejects(() => reviewClient.documentReviewQueue(limited.grant, 'understanding'), { code: 'forbidden' });
  assert.equal((await reviewClient.projectRecordDetail(limited.grant, understand(72))).review, null);
  await assert.rejects(() => reviewClient.reviewProjectRecord(limited.grant, understand(72), approval), { code: 'forbidden' });
  await assert.rejects(() => reviewClient.reviewProjectRecord(other, understand(72), approval), { code: 'not-found' });
  await assert.rejects(() => reviewClient.reviewProjectRecord(director, { ...understand(75), id: 43 }, approval), { code: 'not-found' });
  await assert.rejects(() => reviewClient.reviewProjectRecord(director, understand(73), approval), { code: 'project-review-conflict' });

  const reviewed = await reviewClient.reviewProjectRecord(director, understand(72), approval);
  assert.equal(reviewed.item.status, 'UD Approved By MD');
  assert.equal(reviewed.review, null);
  const approvals = await reviewClient.documentReviewQueue(director, 'understanding', undefined, undefined, 'approved');
  assert.deepEqual(approvals.items.map(({ id, status }) => [id, status]),
    [[79, 'UD Approved By SI'], [77, 'UD Approved By MD'], [72, 'UD Approved By MD']]);
  await assert.rejects(() => reviewClient.reviewProjectRecord(director, understand(72), approval), { code: 'project-review-conflict' });

  const rejectionRevision = (await reviewClient.projectRecordDetail(projectHead, understand(73))).review.revision;
  const write = (grant, payload) => fetch(new URL('projects/records/review', datesBase), {
    method: 'POST', headers: { 'Content-Type': 'application/json', ...(grant ? { Authorization: 'Bearer ' + grant.sessionToken } : {}) },
    body: JSON.stringify(payload),
  });
  assert.equal((await write(null, { ...understand(72), ...approval })).status, 401);
  const rejection = { decision: 'reject', revision: rejectionRevision };
  for (const reason of ['', '   ', 'a'.repeat(256)]) {
    assert.equal((await write(projectHead, { ...understand(73), ...rejection, reason })).status, 400);
  }
  const rejected = await reviewClient.reviewProjectRecord(projectHead, understand(73), { ...rejection, reason: ' Add a rollback checkpoint. ' });
  assert.equal(rejected.item.status, 'UD Rejected By MD');
  assert.equal(rejected.fields.rejectedBy, 'document-project-head');
  assert.match(rejected.fields.rejectedDate, /^\d{2}-\d{2}-\d{4} \d{2}:\d{2}$/);
  assert.equal(rejected.fields.rejectionReason, 'Add a rollback checkpoint.');
  assert.equal((await reviewClient.projectRecordDetail(limited.grant, understand(73))).fields.rejectionReason, rejected.fields.rejectionReason);
  const rejections = await reviewClient.documentReviewQueue(director, 'understanding', undefined, undefined, 'rejected');
  assert.deepEqual(rejections.items.map(({ id, decisionDate }) => [id, decisionDate]),
    [[78, '23-11-2026 14:10'], [73, rejected.fields.rejectedDate]]);
  assert.deepEqual((await reviewClient.documentReviewQueue(other, 'understanding', undefined, undefined, 'rejected')).items, []);

  const contenders = await Promise.all([director, projectHead].map(async (grant) => {
    const revision = (await reviewClient.projectRecordDetail(grant, understand(74))).review.revision;
    return { grant, revision };
  }));
  const race = await Promise.all(contenders.map(({ grant, revision }, index) => write(grant, {
    ...understand(74), revision, ...(index ? { decision: 'reject', reason: 'Needs rollout date' } : { decision: 'approve' }),
  })));
  assert.deepEqual(race.map(({ status }) => status).sort(), [200, 409]);
  assert.deepEqual((await reviewClient.documentReviewQueue(director, 'understanding')).items, []);

  const requirementDetail = await reviewClient.projectRecordDetail(director, requirement);
  assert.equal(requirementDetail.review.canReject, false);
  const revision = requirementDetail.review.revision;
  assert.equal((await write(director, { ...requirement, revision, decision: 'reject', reason: 'No' })).status, 400);
  await assert.rejects(() => reviewClient.reviewProjectRecord(projectHead, requirement, { decision: 'approve', revision }), { code: 'forbidden' });
  assert.equal((await reviewClient.reviewProjectRecord(director, requirement, { decision: 'approve', revision })).item.status, 'RD Approved');
  assert.deepEqual((await reviewClient.documentReviewQueue(director, 'requirement')).items, []);
  const approvedRequirements = await reviewClient.documentReviewQueue(director, 'requirement', undefined, undefined, 'approved');
  assert.deepEqual(approvedRequirements.items.map(({ id }) => id), [68, 67, 64]);
  assert.deepEqual((await reviewClient.documentReviewQueue(director, 'requirement', 67, undefined, 'approved')).items.map(({ id }) => id), [64]);
});

await test('Sales Initiators see requirements they submitted in granted projects and can open the original record', async () => {
  const client = createAuthClient(resolveAuthConfig(datesBase, true));
  const sales = await client.signIn(credentials('requirements-sales'));
  const director = await client.signIn(credentials('document-director'));
  assert.deepEqual(sales.session.identity.capabilities, ['projects.read', 'projects.requirements-submitted']);
  const own = await client.documentReviewQueue(sales.grant, 'requirement', undefined, undefined, 'submitted');
  assert.deepEqual(own.items.map(({ id, projectId }) => [id, projectId]), [[69, 47], [67, 47], [61, 44]]);
  assert.deepEqual((await client.documentReviewQueue(sales.grant, 'requirement', 67, undefined, 'submitted'))
    .items.map(({ id }) => id), [61]);
  const target = { scope: 'requirement', id: 47, recordId: 69 };
  const original = await client.projectRecordDetail(sales.grant, target);
  assert.equal(original.fields.requirementNote, 'Document the device handoff before go-live');
  assert.equal(original.review, null);
  await assert.rejects(() => client.documentReviewQueue(sales.grant, 'requirement'), { code: 'forbidden' });
  await assert.rejects(() => client.documentReviewQueue(director.grant, 'requirement', undefined, undefined, 'submitted'), { code: 'forbidden' });
  await assert.rejects(() => client.reviewProjectRecord(sales.grant, target, { decision: 'approve', revision: 'A'.repeat(43) }), { code: 'forbidden' });
  const send = (payload) => fetch(new URL('projects/records/review-queue', datesBase), {
    method: 'POST', headers: { 'Content-Type': 'application/json', Authorization: `Bearer ${sales.grant.sessionToken}` },
    body: JSON.stringify(payload),
  });
  assert.equal((await send({ scope: 'requirement', mode: 'submitted', username: 'different-user' })).status, 400);
  assert.equal((await send({ scope: 'understanding', mode: 'submitted' })).status, 400);
  assert.equal((await send({ scope: 'requirement', mode: 'rejected' })).status, 400);
});

await test('kickoff options and multipart scheduling use the scoped order and persist retry-safe meeting records and files', async () => {
  const api = createAuthClient(resolveAuthConfig(datesBase, true));
  const director = await api.signIn(credentials('kickoff-director'));
  const sales = await api.signIn(credentials('requirements-sales'));
  const foreign = await api.signIn(credentials('document-other-company', 'QA-B'));
  assert.ok(director.session.identity.capabilities.includes('projects.kickoff-schedule'));
  const target = { id: 44, recordId: 71 };
  const options = await api.kickoffOptions(director.grant, target);
  assert.equal(options.purchaseOrder, 'PO-910');
  assert.equal(options.understanding, 'UD-71');
  assert.equal(options.timeZone, 'Asia/Kolkata');
  assert.equal(options.kickoffStatus, '');
  assert.ok(options.rooms.includes('SecureIT - 901'));
  assert.ok(options.providers.includes('teams'));
  assert.deepEqual(options.roster.heads.choices, [{ id: 15, name: 'Riya Naik' }]);
  assert.deepEqual(options.roster.sales.choices, [{ id: 18, name: 'Meera Shah' }]);
  const searched = await api.kickoffOptions(director.grant, target, 'SAMIRA');
  assert.deepEqual(searched.roster.managers.choices, [{ id: 13, name: 'Samira Rao' }]);
  assert.deepEqual(searched.roster.heads.choices, []);
  await assert.rejects(() => api.kickoffOptions(sales.grant, target), { code: 'forbidden' });
  await assert.rejects(() => api.kickoffOptions(foreign.grant, target), { code: 'not-found' });
  await assert.rejects(() => api.kickoffOptions(director.grant, { ...target, recordId: 72 }), { code: 'not-found' });

  const draft = { ...target, requestKey: 'qa-kickoff-virtual-key-001', time: '2026-11-25T10:30', mode: 'Virtual Mode',
    provider: 'teams', connection: 'https://meet.fixture.invalid/riverside', heads: [15], sales: [18], managers: [13] };
  const attachmentFolder = `${inbox}-attachments-_scm-auth-dates-qa`;
  const agenda = await readFile(`${attachmentFolder}/Riverside agenda.pdf`);
  const namesBefore = (await readdir(attachmentFolder)).sort();
  const send = (details, grant = director.grant, file = agenda, withPlan = true, nativeNames = true) => {
    const body = new FormData();
    body.append('details', JSON.stringify(details));
    if (file !== null) body.append('agenda', new Blob([file], { type: 'application/pdf' }), nativeNames ? 'Sprint%20%E2%80%93%20agenda.pdf' : 'Sprint %20 agenda.pdf');
    if (withPlan) body.append('plan', new Blob(['Confirm pilot access.\n'], { type: 'text/plain' }), nativeNames ? 'Pilot%20plan.txt' : 'Pilot plan.txt');
    return fetch(new URL('projects/kickoff/schedule', datesBase), { method: 'POST', body, headers: {
      ...(nativeNames ? { 'X-SCM-Filename-Encoding': 'percent' } : {}), ...(grant ? { Authorization: `Bearer ${grant.sessionToken}` } : {}),
    } });
  };
  assert.equal((await send(draft, null)).status, 401);
  assert.equal((await send(draft, sales.grant)).status, 403);
  assert.equal((await send(draft, foreign.grant)).status, 404);
  assert.equal((await send({ ...draft, time: '2026-11-31T10:30' })).status, 400);
  assert.equal((await send(draft, director.grant, null)).status, 400);
  assert.equal((await send(draft, director.grant, 'This is not a PDF')).status, 400);
  assert.equal((await send(draft, director.grant, Buffer.alloc(10 * 1024 * 1024 + 1))).status, 413);
  const wrongGroup = await send({ ...draft, heads: [20] });
  assert.equal(wrongGroup.status, 409);
  assert.equal((await wrongGroup.json()).reason, 'kickoff-participants-unavailable');
  assert.equal((await send({ ...draft, connection: 'fixture rollback' })).status, 503);
  assert.deepEqual((await readdir(attachmentFolder)).sort(), namesBefore);
  assert.deepEqual((await api.projectRecords(director.grant, 44)).kickoff.items.map(({ id }) => id), [81]);
  assert.equal((await api.kickoffOptions(director.grant, target)).kickoffStatus, '');

  const retries = await Promise.all([send(draft), send(draft)]);
  for (const response of retries) assert.equal(response.status, 200, await response.clone().text());
  const scheduled = await retries[0].json();
  assert.deepEqual(await retries[1].json(), scheduled);
  const meetingId = decodeScheduledKickoff(scheduled, target);
  assert.ok(meetingId > 81);
  const mismatchedRetry = await send({ ...draft, connection: 'https://meet.fixture.invalid/changed' });
  assert.equal(mismatchedRetry.status, 409);
  assert.equal((await mismatchedRetry.json()).reason, 'kickoff-conflict');
  const modifiedBytes = Buffer.concat([agenda, Buffer.from('\n')]);
  assert.equal((await send(draft, director.grant, modifiedBytes)).status, 409);
  assert.equal((await api.kickoffOptions(director.grant, target)).kickoffStatus, 'Meeting Scheduled');
  const meetingTarget = { scope: 'kickoff', id: 44, recordId: meetingId };
  const meeting = await api.projectRecordDetail(director.grant, meetingTarget);
  assert.deepEqual(meeting.item, { id: meetingId, reference: `M-${meetingId}`, date: '25-11-2026 10:30 AM', status: 'Meeting Scheduled', format: 'Virtual Mode' });
  assert.equal(meeting.fields.projectHead, 'Riya Naik');
  assert.equal(meeting.fields.salesManager, 'Meera Shah');
  assert.equal(meeting.fields.productManager, 'Samira Rao');
  assert.equal(meeting.fields.meetingLink, draft.connection);
  assert.deepEqual((await api.projectRecords(director.grant, 44)).kickoff.items.map(({ id }) => id), [meetingId, 81]);
  assert.deepEqual(await api.projectAttachments(director.grant, meetingTarget), [
    { kind: 'kickoff-agenda', name: 'Sprint – agenda.pdf', mimeType: 'application/pdf' },
    { kind: 'kickoff-plan', name: 'Pilot plan.txt', mimeType: 'text/plain' },
  ]);
  const download = (grant, kind) => fetch(new URL('projects/attachments/download', datesBase), {
    method: 'POST', headers: { 'Content-Type': 'application/json', Authorization: `Bearer ${grant.sessionToken}` },
    body: JSON.stringify({ ...meetingTarget, kind }),
  });
  const pdf = await download(director.grant, 'kickoff-agenda');
  assert.equal(pdf.status, 200);
  assert.match(pdf.headers.get('content-disposition'), /filename\*=UTF-8''Sprint%20%E2%80%93%20agenda\.pdf$/);
  assert.deepEqual(Buffer.from(await pdf.arrayBuffer()), agenda);
  assert.equal(await (await download(director.grant, 'kickoff-plan')).text(), 'Confirm pilot access.\n');
  await assert.rejects(() => api.projectAttachments(foreign.grant, meetingTarget), { code: 'not-found' });
  const { provider, connection, ...common } = draft;
  const physical = await send({ ...common, mode: 'Physical Mode', rooms: ['SecureIT - 901'], requestKey: 'qa-kickoff-physical-key-002' }, director.grant, agenda, false, false);
  assert.equal(physical.status, 200, await physical.clone().text());
  const physicalTarget = { ...meetingTarget, recordId: (await physical.json()).meetingId };
  assert.equal((await api.projectRecordDetail(director.grant, physicalTarget)).fields.room, 'SecureIT - 901');
  assert.deepEqual(await api.projectAttachments(director.grant, physicalTarget), [{ kind: 'kickoff-agenda', name: 'Sprint %20 agenda.pdf', mimeType: 'application/pdf' }]);
  const filesAfter = await readdir(attachmentFolder);
  assert.equal(filesAfter.length, namesBefore.length + 3);
  assert.ok(filesAfter.every((name) => !name.startsWith('.scm-kickoff-')));
});

await test('authenticator enrollment generates a usable secret and prevents reusing a time slot', async () => {
  const first = await client.signIn(credentials('enroll'));
  assert.equal(first.kind, 'enrollment');
  const uri = new URL(first.setupUri);
  const secret = uri.searchParams.get('secret');
  assert.match(secret, /^[A-Z2-7]{32}$/);
  const frame = Math.floor(Date.now() / 30000) + 1;
  const code = totp(secret, frame);
  assert.equal((await client.verify(first.challengeId, code)).kind, 'authenticated');
  const returning = await client.signIn(credentials('enroll'));
  assert.equal(returning.kind, 'challenge');
  assert.equal(returning.method, 'totp');
  assert.equal((await client.verify(returning.challengeId, code)).reason, 'invalid-code');
  const existing = await client.signIn(credentials('totp'));
  assert.equal((await client.verify(existing.challengeId, totp('GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ', frame))).kind, 'authenticated');
});

await test('email recovery changes only the verified mobile credential and invalidates older sessions', async () => {
  const prior = await client.signIn(credentials('alex'));
  const unknown = await client.startRecovery({ companyCode: 'QA-A', username: 'does-not-exist', channel: 'email' });
  const requested = await client.startRecovery({ companyCode: 'QA-A', username: 'alex', channel: 'email' });
  assert.equal(unknown.kind, requested.kind);
  const code = await delivered('email', 'alex@fixture.invalid');
  assert.equal((await client.verifyRecovery(unknown.challengeId, code)).reason, 'invalid-code');
  assert.equal((await client.completeRecovery(requested.challengeId, 'Unproven-password')).reason, 'expired');
  const verified = await client.verifyRecovery(requested.challengeId, code);
  assert.equal(verified.kind, 'recovery-verified');
  assert.equal((await client.completeRecovery(verified.resetGrant, 'too-short')).reason, 'password-policy');
  assert.equal((await client.completeRecovery(verified.resetGrant, 'Replacement-mobile-pass')).kind, 'password-changed');
  assert.equal((await client.completeRecovery(verified.resetGrant, 'Different-password')).reason, 'expired');
  await assert.rejects(() => client.session(prior.grant), { code: 'expired' });
  assert.equal((await client.signIn(credentials('alex'))).reason, 'invalid-credentials');
  assert.equal((await client.signIn(credentials('alex', 'QA-A', 'Replacement-mobile-pass'))).kind, 'authenticated');
  assert.equal((await client.signIn(credentials('alex', 'QA-B', 'Second-company-fixture-only'))).kind, 'authenticated');
});

await test('phone recovery uses the phone on the account and rejects repeated failed codes', async () => {
  const issued = await client.startRecovery({ companyCode: 'QA-A', username: 'phone', channel: 'sms', phone: '+12025550199' });
  const code = await delivered('sms', '+12025550108');
  assert.equal((await count('sms', '+12025550199')).length, 0);
  const bad = code === '444444' ? '555555' : '444444';
  for (let i = 0; i < 5; i++) assert.equal((await client.verifyRecovery(issued.challengeId, bad)).reason, 'invalid-code');
  assert.equal((await client.verifyRecovery(issued.challengeId, code)).reason, 'rate-limited');
  const fresh = await client.startRecovery({ companyCode: 'QA-A', username: 'phone', channel: 'sms' });
  const verified = await client.verifyRecovery(fresh.challengeId, await delivered('sms', '+12025550108', 1));
  assert.equal(verified.kind, 'recovery-verified');
  assert.equal((await client.completeRecovery(verified.resetGrant, 'Replacement-phone-pass')).kind, 'password-changed');
});
