/** Simulator QA service. Synthetic accounts only; never bind outside loopback. */
import { randomBytes } from 'node:crypto';
import { createServer } from 'node:http';
import { pathToFileURL } from 'node:url';

const accountPassword = 'SCM-qa-only-2026';
const accountCode = 'QA-OPS';
const ROOT = '/mobile/v1/auth/';
const challengeTtl = 180_000;
const sessionTtl = 15 * 60_000;
const testCode = '246810';
const otpUri = 'otpauth://totp/SCM%3Aenroll?secret=GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ&issuer=SCM';
const token = () => randomBytes(24).toString('base64url');

export function createFixture({ clock = Date.now } = {}) {
  const accounts = new Map([
    ['local', { displayName: 'Maya Patel', role: 'Sales Manager', designation: 'Commercial operations', method: 'off' }],
    ['directory', { displayName: 'Ravi Sinha', role: 'Engineer', designation: 'Service operations', method: 'off' }],
    ['sms', { displayName: 'Nina Rao', role: 'Ticket Co-ordinator', designation: 'Service desk', method: 'sms' }],
    ['totp', { displayName: 'Dev Shah', role: 'Developer', designation: 'Project delivery', method: 'totp' }],
    ['enroll', { displayName: 'Noor Paul', role: 'Engineer', designation: 'Service operations', method: 'enrollment' }],
  ].map(([username, account]) => [username, { ...account, username, password: accountPassword }]));
  const sessions = new Map();
  const pending = new Map();
  const resets = new Map();
  function challenge(account, purpose, allowResend = true) {
    const challengeId = token();
    const expiresAt = clock() + challengeTtl;
    const item = { account, purpose, expiresAt, attempts: 0, allowResend };
    pending.set(challengeId, item);
    if (purpose !== 'sign-in') return { kind: 'recovery-sent', challengeId, expiresAt };
    if (account.method === 'enrollment') return { kind: 'enrollment', challengeId, expiresAt, method: 'totp', setupUri: otpUri };
    return { kind: 'challenge', challengeId, expiresAt, method: account.method, canResend: account.method === 'sms' && allowResend,
      ...(account.method === 'sms' ? { maskedDestination: '•••042' } : {}) };
  }
  function identity(account, expiresAt) {
    return { kind: 'authenticated', expiresAt, identity: { username: account.username, displayName: account.displayName, companyCode: accountCode,
      companyName: 'SCM Test Operations', designation: account.designation, role: account.role, capabilities: [] } };
  }
  function authenticated(account) {
    const sessionToken = token();
    const expiresAt = clock() + sessionTtl;
    sessions.set(sessionToken, { account, expiresAt });
    return { ...identity(account, expiresAt), sessionToken };
  }
  function verify(body, kind) {
    const item = pending.get(body.challengeId);
    if (item?.purpose !== kind || item.expiresAt <= clock()) return [410, { kind: 'rejected', reason: 'expired' }];
    if (item.attempts >= 5) return [429, { kind: 'rejected', reason: 'rate-limited' }];
    item.attempts++;
    if (!item.account || body.code !== testCode) return [400, { kind: 'rejected', reason: 'invalid-code' }];
    if (kind === 'recovery') {
      const resetGrant = token();
      const expiresAt = clock() + challengeTtl;
      resets.set(resetGrant, { account: item.account, expiresAt });
      pending.delete(body.challengeId);
      return [200, { kind: 'recovery-verified', resetGrant, expiresAt }];
    }
    pending.delete(body.challengeId);
    if (item.account.method === 'enrollment') item.account.method = 'totp';
    return [200, authenticated(item.account)];
  }
  const dispatch = (path, body, req) => {
    if (path === 'sign-in' && req.method === 'POST') {
      const account = body.companyCode === accountCode ? accounts.get(body.username) : null;
      if (!account || account.password !== body.password) return [401, { kind: 'rejected', reason: 'invalid-credentials' }];
      return account.method === 'off' ? [200, authenticated(account)] : [202, challenge(account, 'sign-in')];
    }
    if (path === 'challenge/verify' && req.method === 'POST') return verify(body, 'sign-in');
    if (path === 'challenge/resend' && req.method === 'POST') {
      const item = pending.get(body.challengeId);
      if (item?.purpose !== 'sign-in' || item.expiresAt <= clock()) return [410, { kind: 'rejected', reason: 'expired' }];
      if (item.account?.method !== 'sms' || !item.allowResend) return [429, { kind: 'rejected', reason: 'rate-limited' }];
      pending.delete(body.challengeId);
      return [202, challenge(item.account, 'sign-in', false)];
    }
    if ((['session', 'workspace', 'profile'].includes(path) && req.method === 'GET') || (path === 'sign-out' && req.method === 'POST')) {
      const bearer = req.headers.authorization?.match(/^Bearer ([A-Za-z0-9_-]+)$/)?.[1];
      const item = sessions.get(bearer);
      if (!item || item.expiresAt <= clock()) return [401, { kind: 'rejected', reason: 'expired' }];
      if (path === 'session') return [200, identity(item.account, item.expiresAt)];
      if (path === 'workspace') return [200, { kind: 'workspace', statuses: [], activity: [] }];
      if (path === 'profile') return [200, { kind: 'profile', email: '', phone: '', location: '', site: '', department: '', subdepartment: '' }];
      sessions.delete(bearer);
      return [204];
    }
    if (path === 'recovery/start' && req.method === 'POST') {
      const account = ['email', 'sms'].includes(body.channel) && body.companyCode === accountCode ? accounts.get(body.username) : null;
      return [202, challenge(account, 'recovery')];
    }
    if (path === 'recovery/verify' && req.method === 'POST') return verify(body, 'recovery');
    if (path === 'recovery/complete' && req.method === 'POST') {
      const item = resets.get(body.resetGrant);
      if (!item || item.expiresAt <= clock()) return [410, { kind: 'rejected', reason: 'expired' }];
      if (typeof body.password !== 'string' || body.password.length < 12 || body.password.length > 512) return [400, { kind: 'rejected', reason: 'password-policy' }];
      item.account.password = body.password;
      resets.delete(body.resetGrant);
      for (const [key, value] of sessions) if (value.account === item.account) sessions.delete(key);
      for (const [key, value] of pending) if (value.account === item.account) pending.delete(key);
      for (const [key, value] of resets) if (value.account === item.account) resets.delete(key);
      return [200, { kind: 'password-changed' }];
    }
    return [404, { kind: 'rejected', reason: 'account-unavailable' }];
  };
  return createServer(async (req, res) => {
    const origin = req.headers.origin;
    if (origin && /^http:\/\/(localhost|127\.0\.0\.1):\d+$/.test(origin)) {
      res.setHeader('Access-Control-Allow-Origin', origin);
      res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
      res.setHeader('Access-Control-Allow-Headers', 'Content-Type, Authorization, Cache-Control');
      res.setHeader('Vary', 'Origin');
    }
    const end = (status, value) => {
      res.writeHead(status, { 'Content-Type': 'application/json', 'Cache-Control': 'no-store' });
      res.end(value === undefined ? undefined : JSON.stringify(value));
    };
    if (req.method === 'OPTIONS' && req.url?.startsWith(ROOT)) { end(204); return; }
    let data = '';
    for await (const chunk of req) {
      data += chunk;
      if (data.length > 8192) { end(413); return; }
    }
    try {
      const path = req.url?.startsWith(ROOT) ? req.url.slice(ROOT.length) : '';
      const body = data ? JSON.parse(data) : {};
      if (!body || typeof body !== 'object' || Array.isArray(body)) { end(400); return; }
      end(...dispatch(path, body, req));
    } catch { end(400); }
  });
}

if (process.argv[1] && import.meta.url === pathToFileURL(process.argv[1]).href) {
  const port = Number(process.env.SCM_FIXTURE_PORT ?? 8084);
  createFixture().listen(port, '127.0.0.1', () => console.log(`SCM synthetic authentication at http://127.0.0.1:${port}${ROOT}`));
}
