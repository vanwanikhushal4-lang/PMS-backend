# SCM mobile API handoff

Updated 18 November 2026. Frontend implementation lives in [PMS-Mobile/mobile](https://github.com/vanwanikhushal4-lang/PMS-Mobile/tree/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile).

This document tracks the mobile client and Java API contract. The [Java backend setup](../backend/mobile-auth/README.md) describes the isolated test service, schema migrations, and deployment configuration. The planned legacy modules below still need implementation.

## Delivery order and frontend coverage

| Priority | Frontend surface | Backend delivery needed |
| --- | --- | --- |
| P0 | Sign-in, MFA/enrollment, recovery, session, profile | Identity and tenant validation, role/capability response, token lifecycle, challenge delivery |
| P0 | Projects, saved projects, creation, task List/Board/Timeline | Scoped project reads, options, creation, favorites, linked task reads |
| P0 | Requirement/understanding detail, review queues and decisions | Linked record detail, revision checks, approved/rejected/submitted queues |
| P0 | Kickoff scheduling form, meeting detail and Files | Options/participant search, multipart scheduling, attachment metadata and download |
| P1 | My work, project/general task creation and reassignment | Assignee roster, creation, individual/bulk reassignment |
| P1 | Work logs, completion, date requests and approvals | State changes, revision checks, atomic batches, history |
| P1 | Publish Project browser, purchase orders and Form C | Function → suite → tool → customer tree, approved orders, Form C and linked tasks |
| P1 | Service dashboard | Incident counts and recent activity |
| P2 | Remaining legacy modules | See the planned frontend table below; their final request contracts will accompany their screens |

These are implemented client surfaces, with the exception of P2. The opt-in frontend preview uses in-memory sample data. Its interactions do not create backend records or send invitations. It is not an authorization or integration test.

## Transport and shared rules

- Configure `EXPO_PUBLIC_SCM_AUTH_URL=https://<host>/<context>/mobile/v1/auth/`. The current route prefix is a client convention, including domain routes under `auth/`; agree any change with frontend before implementation.
- HTTPS for shared/release environments. The app sends `Authorization: Bearer <sessionToken>` for authenticated calls. It does not use JSP cookies. Do not redirect mobile calls to an HTML login page or storage login.
- JSON endpoints use `Accept: application/json`, `Content-Type: application/json` for POST, and `Cache-Control: no-store`. Return JSON content type and no-store responses. Only `session`, `profile`, and `workspace` below are authenticated GETs; domain reads currently use POST bodies for their filters.
- `kind` is a required response discriminator. Return actual numbers and booleans, not stringified values. Omit an absent optional field unless its schema explicitly allows `null`.
- IDs are positive integers up to 2,147,483,647. Labels generally allow at most 500 characters. Exact bounds and discriminators are enforced by the linked TypeScript decoders.
- Standard list pages contain at most 30 rows sorted by descending ID. `before` is exclusive. `next` is `null` at the end; otherwise it equals the last ID in a full page. Publishing tree uses a label cursor instead.
- Read linked records using the verified account, company, project, and typed record relationship. A role label or a client-supplied ID is insufficient authorization. Server flags/capabilities drive action visibility, and the server validates every action again.
- Creation uses `requestKey`. Repeating the same key and payload must return the same result. A reused key with different content returns a conflict. This matters when a mobile connection drops after saving.
- Revisions are opaque 43-character `[A-Za-z0-9_-]` strings in the current contracts. Check them atomically when reviewing, reassigning, or approving dates. Batches must either commit every item or report the failed item without partial changes.
- Authentication timestamps are epoch milliseconds. New task date inputs are `YYYY-MM-DD`. Work-log `date` currently uses legacy `DD.MM.YYYY`. Kickoff input is company-local `YYYY-MM-DDTHH:mm`; options must provide an IANA `timeZone` such as `Asia/Kolkata`. Convert legacy display formats on the server and document the stored timezone.
- JSON requests currently time out after 9 seconds. Kickoff upload allows 90 seconds. Downloads allow 15 seconds for headers and 30 seconds without incoming data. Keep long operations idempotent and return a definite saved result or a retryable error.

The optional server-connection screen still checks the public SCM HTML entry at `EXPO_PUBLIC_SCM_URL`. If the redesigned backend replaces that webapp, agree a public health endpoint and update this check together; its current success only proves the entry page responds.

### Common errors

```json
{ "kind": "rejected", "reason": "project-review-conflict" }
```

| Status | Client meaning / payload |
| --- | --- |
| 400 | Invalid action data; use the workflow reason below |
| 401 | Session expired/revoked; client clears the matching active session |
| 403 | Account lacks access or capability |
| 404 | `project-not-found`, `task-not-found`, `context-not-found`, `attachment-not-found`, or `publishing-not-found` as appropriate |
| 409 | Stale revision, concurrent change, unavailable participant/assignee, duplicate or idempotency conflict |
| 413 | Kickoff upload too large |
| 429 | `{ "kind": "rejected", "reason": "rate-limited" }` for authentication; domain rate-limit UI needs a coordinated client extension |
| 5xx | Service unavailable; client retains retry controls |

The current client does not map `422` field errors. Use the documented `400` reasons for now, or agree a field-error schema and update the client with the backend contract. Never return stack traces, SQL errors, paths, or HTML in mobile error bodies.

## Authentication and profile

Paths in all tables are relative to the configured base above. All endpoints are POST unless explicitly labeled GET. Brackets in field lists indicate optional fields, not JSON syntax.

| Path | Request | Response |
| --- | --- | --- |
| `sign-in` | `{companyCode, username, password}` | `authenticated`, `challenge`, `enrollment`, or `rejected` |
| `challenge/verify` | `{challengeId, code}` | Same authentication union |
| `challenge/resend` | `{challengeId}` | Updated challenge or rejection |
| GET `session` | Bearer only | `authenticated` with current identity, capabilities, expiry |
| `sign-out` | `{}` + bearer | HTTP 204; revoke token |
| `recovery/start` | `{companyCode, username, channel:"email"\|"sms"}` | `{kind:"recovery-sent", challengeId, expiresAt}` or rejection |
| `recovery/verify` | `{challengeId, code}` | `{kind:"recovery-verified", resetGrant, expiresAt}` or rejection |
| `recovery/complete` | `{resetGrant, password}` | `{kind:"password-changed"}` or rejection |
| GET `profile` | Bearer only | `{kind:"profile", email, phone, location, site, department, subdepartment}` |
| GET `workspace` | Bearer only | `{kind:"workspace", statuses, activity}` as described below |

Authenticated example, with placeholder token values:

```json
{
  "kind": "authenticated",
  "sessionToken": "<22-to-256-character-opaque-token>",
  "expiresAt": 1795000000000,
  "identity": {
    "username": "aditi",
    "displayName": "Aditi Shah",
    "companyCode": "VELOX",
    "companyName": "Velox",
    "role": "MD",
    "designation": "Project director",
    "capabilities": ["projects.read", "projects.understanding-review"]
  }
}
```

Use a future expiry at runtime. Tokens/challenge IDs/reset grants must be opaque 22–256 character `[A-Za-z0-9_-]` values. Challenge/recovery expiry must be within 15 minutes. `sessionToken` is required after successful sign-in/verification; session confirmation keeps the existing grant.

- SMS challenge fields are `kind:"challenge", challengeId, expiresAt, method:"sms", canResend, [maskedDestination]`.
- TOTP challenge uses `method:"totp", canResend:false` and no destination.
- Enrollment uses `kind:"enrollment", challengeId, expiresAt, method:"totp", setupUri`. `setupUri` is an `otpauth://totp/...` URI with a valid Base32 secret. Do not place secrets in public Expo variables or logs.
- Auth rejection reasons are `invalid-credentials`, `invalid-code`, `expired`, `rate-limited`, `account-unavailable`, `password-policy`.
- The backend decides local/AD account verification, active/deleted account policy, lockout, recovery delivery, and MFA requirements.

Service dashboard `statuses` is `[{status:string|null, count:positiveInteger}]` with unique statuses. `activity` has at most 20 unique incidents `[{incidentId, date:string|null, status:string|null, message:string|null}]`. Non-null dates currently use `YYYY-MM-DDTHH:mm:ss`. The frontend sums status counts; define the timestamp timezone and the user's incident scope in the backend response documentation.

Exact decoders: [authentication](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/auth-contract.ts), [workspace](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/workspace-contract.ts).

## Roles and action access

Return the account's actual legacy role in `identity.role` and a reviewed capability list. Do not infer all permissions from a hard-coded mobile role count. The original application has distinct sales, delivery, support, administration, finance and management roles; map the real role catalog and account scopes during backend integration.

| Capability currently read by UI | Visible feature |
| --- | --- |
| `projects.read` | Projects tab and project workspace |
| `projects.create` | Create project |
| `projects.publish` | Publish Project browser |
| `projects.requirement-review` | Requirement review queues and decisions |
| `projects.understanding-review` | Understanding review queues and decisions |
| `projects.requirements-submitted` | Sales Initiator's My requirements register |
| `projects.kickoff-schedule` | Schedule kickoff from an approved understanding document |
| `tasks.assigned-by-me` | My work tab and project task views |
| `tasks.create-standalone` | General task creation |

Record detail returns `review` only when a decision is permitted. Task rows return `workLog`, `dateAccess`, `dateReview.canApprove`, and `reassignable`; assignee/options endpoints must also check scope. Backend must provide the role-to-capability matrix plus representative test users. Preview identity capabilities are solely for inspecting the UI.

## Projects and record review

| Path | Request | Response |
| --- | --- | --- |
| `projects/list` | `{[query], [before], [saved]}` | `{kind:"projects", items:Project[], next:number|null}` |
| `projects/detail` | `{id}` | `{kind:"project", item:Project}` |
| `projects/favorite` | `{id, favorite:boolean}` | `{kind:"project-favorite", projectId, favorite}` |
| `projects/create-options` | `{[query], [functionQuery]}` | `{kind:"project-create-options", contexts, functions, responsibilities, moreContexts, moreFunctions}` |
| `projects/create` | `{name, function, responsibility, context, requestKey}` | `{kind:"project-created", item:Project}` |
| `projects/tasks` | `{id, [query], [before]}` | `{kind:"assigned-tasks", projectId, items:Task[], next}` |
| `projects/records` | `{id}` | `{kind:"project-records", projectId, requirements:RecordGroup, understanding:RecordGroup, kickoff:RecordGroup}` |
| `projects/records/detail` | `{id, scope, recordId}` | `{kind:"project-record-detail", projectId, scope, item:Record, fields, [review]}` |
| `projects/records/review-queue` | `{scope:"requirement"\|"understanding", [before], [mode]}` | `{kind:"project-review-queue", scope, [mode], items:ReviewItem[], next}` |
| `projects/records/review` | `{id, scope, recordId, revision, decision:"approve"\|"reject", [reason]}` | Updated `project-record-detail` with final status and without `review` |

Shared shapes:

```ts
type Context = { customer: string; suite: string; tool: string };
type Project = Context & {
  id: number; name: string; function: string; responsibility: string;
  reference: string; favorite: boolean;
};
type Record = { id: number; reference: string; date: string; status: string; format: string };
type RecordGroup = { items: Record[]; hasMore: boolean }; // at most 20, descending ID
type ReviewItem = Record & {
  projectId: number; projectName: string; projectReference: string; decisionDate: string;
};
type Review = { revision: string; canReject: boolean };
```

`scope` is `requirement`, `understanding`, or `kickoff`. `fields` is an object of nonempty string values, maximum 65,535 characters each; omit missing values. The detail screen currently renders these keys:

| Scope | Field keys |
| --- | --- |
| Requirement | `description`, `requirementNote`, `purchaseOrder`, `submittedBy`, `designation`, `productManager`, `function`, `suite`, `tool` |
| Understanding | `projectDescription`, `objectives`, `projectScope`, `start`, `end`, `functional`, `nonfunctional`, `technical`, `rejectedBy`, `rejectedDate`, `rejectionReason`, `description`, `requirementNote`, `understandingNote`, `purchaseOrder`, `requirementReference`, `submittedBy`, `designation`, `productManager`, `teamLead`, `developers`, `function`, `suite`, `tool` |
| Kickoff | `conference`, `meetingLink`, `telephone`, `room`, `roomCapacity`, `meetingResource`, `resources`, `projectHead`, `salesManager`, `productManager`, `attendees`, `purchaseOrder`, `understandingReference` |

Review rules currently expected by UI:

- `mode` defaults to `pending`; other modes are `approved`, `rejected`, `submitted`. Return `mode` for non-pending responses. `decisionDate` is empty except in the rejected queue. Submission ownership must use verified account identifiers.
- Omit `review` when unavailable; `review:null` is not accepted by the current decoder. Requirement reviews use `canReject:false`; understanding uses `canReject:true`.
- Requirement approval returns `RD Approved`. Understanding approval returns `UD Approved By MD`, and rejection returns `UD Rejected By MD`. Approved lists may also contain stored `UD Approved By SI` records. Agree legacy status variants before changing these literals.
- Review conflict returns 409 `project-review-conflict`. Refresh the record/queue before another decision.
- Creation errors are `invalid-project-draft`, `project-context-unavailable`, `project-function-unavailable`, `project-request-conflict`, `project-duplicate`. Context/function choices are max 30; “more” is true only for a full page. Responsibilities must be a nonempty unique list.

Exact field bounds: [project contracts](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/projects-contract.ts). Current method/request mapping: [client adapter](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/auth-api.ts).

## Kickoff scheduling

The Java service implements both endpoints below. Eligible legacy roles with the corresponding sidebar scope and project access receive the scheduling capability. Each request also requires an approved understanding record and a purchase order granted to that account, company, and project. The service uses the deployment's `SCM_MOBILE_KICKOFF_TIME_ZONE`, which defaults to `Asia/Kolkata`.

### Options and participant search

`POST projects/kickoff/options` with `{id, recordId, [query]}`. `recordId` is the approved understanding document. Resolve its linked purchase order on the server.

```json
{
  "kind": "kickoff-options",
  "projectId": 44,
  "recordId": 71,
  "purchaseOrder": "PO-910",
  "understanding": "UD-71",
  "kickoffStatus": "",
  "timeZone": "Asia/Kolkata",
  "rooms": ["SecureIT - 901", "ScanPlus - 906", "AssetGrid - 908", "Conference - 1st Floor"],
  "providers": ["zoom", "teams", "webex", "GMeet"],
  "heads": [{"id": 11, "name": "Aditi Shah"}],
  "sales": [{"id": 12, "name": "Rohan Mehta"}],
  "managers": [{"id": 13, "name": "Noor Paul"}],
  "headsMore": false,
  "salesMore": false,
  "managersMore": false
}
```

Search `query` filters names in all three rosters. Each roster has at most 40 unique participant IDs; a “More” flag requires 40 rows and prompts a narrower search. Preserve selected IDs across searches. Server must recheck all participants at submission time. Legacy grouping is heads = Collection Manager / Head Projects, sales = Sales Manager / Sales Initiator, managers = Implementor / Support Manager / Project Manager, within company and allowed scope. Confirm exact role identifiers and policy with the backend team.

### Submission and files

`POST projects/kickoff/schedule`, bearer required, `multipart/form-data`:

| Part | Type | Required |
| --- | --- | --- |
| `details` | JSON encoded string with the draft below | Yes |
| `agenda` | Binary file with original filename | Yes |
| `plan` | Binary file with original filename | No |

The HTTP client supplies the multipart boundary. Expo native requests send `X-SCM-Filename-Encoding: percent` because Expo percent-encodes multipart filenames. Other callers omit the header and send the literal filename.

```json
{
  "id": 44,
  "recordId": 71,
  "requestKey": "<stable-key-for-this-draft>",
  "time": "2026-11-25T10:30",
  "mode": "Virtual Mode",
  "provider": "teams",
  "connection": "https://teams.example.com/meeting",
  "heads": [11],
  "sales": [12],
  "managers": [13]
}
```

Physical mode replaces `mode`, `provider`, and `connection` with `"mode":"Physical Mode", "rooms":["SecureIT - 901"]`. At least one participant per group is required. Time must be a real calendar date and valid 24-hour clock in the returned company timezone. A virtual platform and nonempty link/credentials are required. Physical room selection currently follows the legacy optional selection; agree any new requirement before changing it.

Frontend file limit is 10 MiB per file, nonempty, filename up to 160 characters, without control characters or path separators. Allowed extensions are PDF, DOC/DOCX, XLS/XLSX, PPT/PPTX, TXT, CSV, JPG/JPEG, PNG, ZIP. Backend must validate content, storage, and its own limits. If policy changes, coordinate the frontend limit and displayed explanation.

Success after saving the meeting and its files:

```json
{ "kind": "kickoff-scheduled", "projectId": 44, "recordId": 71, "meetingId": 301 }
```

Return the existing result on an identical retry. The app opens `projects/records/detail` with `scope:"kickoff", recordId:meetingId` and then the normal attachments list. The meeting must also appear in the project's Records group. Use the legacy `M-<id>` reference and `Meeting Scheduled` status unless the migration team agrees a replacement.

Errors are 400/413 `invalid-kickoff`, 409 `kickoff-conflict`, 409 `kickoff-participants-unavailable`, and 401/403/404 as above. The app displays a warning if options reports `kickoffStatus:"Meeting Scheduled"`. A new request key may schedule a follow-up meeting, as in the JSP workflow. Invitations and calendar delivery remain planned.

Exact contract: [kickoff types and decoder](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/kickoff-contract.ts). Multipart construction: [upload adapter](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/kickoff-upload.ts).

## Attachments

`POST projects/attachments/list` with either `{scope:"purchase-order", id}` or `{scope:"requirement"|"understanding"|"kickoff", id:projectId, recordId}`.

Return `{kind:"project-attachments", scope, id, [recordId], items:[{kind, name, mimeType}]}`. Use unique kinds from this table; omit unavailable files.

| Scope | Allowed attachment kinds |
| --- | --- |
| Purchase order | `masked-po`, `product-features` |
| Requirement | `requirement-file`, `masked-po`, `scope-of-work`, `rfp`, `other` |
| Understanding | `understanding-file`, `other-understanding`, `requirement-file`, `masked-po`, `scope-of-work`, `rfp`, `other` |
| Kickoff | `kickoff-agenda`, `kickoff-plan` |

`POST projects/attachments/download` takes the same target plus `kind` and returns binary bytes, with bearer authorization. Required successful response headers:

```http
Content-Type: application/pdf
Content-Disposition: attachment; filename*=UTF-8''Pilot%20agenda.pdf
Content-Length: 12345
Cache-Control: no-store
```

Content type and decoded filename must match metadata. Content length is optional for chunked transfer; when present it must match the bytes. Names are max 255 characters and must be safe basenames. Stream files directly or agree a signed download contract and update the client together. The current client refuses redirects. Attachment URLs or storage paths are not accepted as a substitute for the binary response.

Contracts and transfer behavior: [metadata decoder](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/attachments-contract.ts), [download adapter](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/attachment-transfer.ts).

## Tasks, work logs and dates

| Path | Request | Response |
| --- | --- | --- |
| `tasks/assigned-by-me` | `{[before]}` | `{kind:"assigned-tasks", items:Task[], next}` |
| `tasks/assigned-to-me` | `{[before]}` | Same task page, scoped to current assignee |
| `tasks/completed` | `{[before]}` | Same task page, completed work |
| `tasks/work-log` | `{id}` | `{kind:"task-work-log", taskId, items, hasMore, date, completed, loggedToday}` |
| `tasks/progress` | `{id, note}` | `{kind:"task-progress-saved", taskId}` |
| `tasks/complete` | `{id}` | `{kind:"task-completed", taskId}` |
| `tasks/dates/list` | `{queue:"mine"\|"team"\|"review", [before]}` | Task page with permitted date actions/review snapshots |
| `tasks/dates/detail` | `{id}` | `TaskDates` below |
| `tasks/dates/request` | `{id, [start], due, reason}` | `{kind:"task-dates-requested", taskId}` |
| `tasks/dates/approve` | `{id, revision}` | `{kind:"task-dates-approved", taskId}` |
| `tasks/dates/request-batch` | `{items:[{id, revision, start, due, reason}]}` | `{kind:"task-date-batch-requested", taskIds:[...]}` |
| `tasks/dates/approve-batch` | `{items:[{id, revision}]}` | `{kind:"task-date-batch-approved", taskIds:[...]}` |

```ts
type Task = {
  id: number; module: string; status: string; customer: string; suite: string; tool: string;
  description: string; lead: string; developer: string; assigner: string; start: string; due: string;
  workLog: boolean; dateAccess: boolean; dateApproval: string; reassignable: boolean;
  reference: string; priority: string; weight: string; function: string; responsibility: string; assignedAt: string;
  dateReview?: { revision: string; start: string; due: string; reason: string; canApprove: boolean } | null;
};
type TaskDates = {
  kind: 'task-dates'; taskId: number; start: string; due: string; approval: string;
  requestedStart: string; requestedDue: string; reason: string;
  revision: string | null; scheduleRevision: string | null;
  requestMode: 'due' | 'schedule' | 'none'; canApprove: boolean; hasMore: boolean;
  history: { id: number; start: string; due: string; revisedStart: string; revisedDue: string;
    approvedAt: string; by: string; reason: string }[];
};
```

Task description/log notes allow up to 16,384 characters. Other task labels allow 500. Work-log entries are `{id, date, note, status, author}`, newest first, max 20. `loggedToday` uses the backend's company-local date and must be false for completed tasks. Enforce one daily progress log and coherent completion behavior under retries. Return 409 `progress-already-logged` or `task-closed` where appropriate.

Date detail history is newest first, max 20. `revision` is the pending request revision; when set, `requestMode` must be `none`. `scheduleRevision` identifies current schedule state and must match `revision` when both are set. Only return `canApprove:true` with a pending revision. Batch success returns the submitted IDs sorted ascending. Date errors are 400 `date-range` / `date-reason-length`, 409 `date-change-conflict` / `date-no-reviewer`; include `taskId` for an item failure.

The frontend renders List, Board and Timeline from the same loaded task page. Do not send different totals or status calculations per view. Weight is currently a numeric string; agree valid statuses, priorities, weight rules and rounding against legacy data with the backend team.

## Task assignment

| Path | Request | Response |
| --- | --- | --- |
| `tasks/assignments/list` | `{[before]}` | Task page with `reassignable` |
| `tasks/assignments/project-options` | `{id:projectId, [query]}` | `Assignees` with matching `id`, `revision:null` |
| `tasks/assignments/options` | `{id:taskId, [query]}` | `Assignees` with matching `id` and current revision |
| `tasks/assignments/contexts` | `{[query]}` | `{kind:"task-contexts", items:Context[], hasMore, functions:string[], responsibilities:string[]}` |
| `tasks/assignments/standalone-options` | `{context, [query]}` | `Assignees` with `id:null`, `revision:null`, matching `context` |
| `tasks/assignments/create` | `{id:projectId, ...TaskDraft}` | `{kind:"task-created", projectId, taskId}` |
| `tasks/assignments/standalone-create` | `{context, function, responsibility, ...TaskDraft}` | `{kind:"task-created", projectId:null, taskId}` |
| `tasks/assignments/reassign` | `{id, revision, candidate}` | `{kind:"task-reassigned", taskId}` |
| `tasks/assignments/reassign-bulk` | `{items:[{id, revision, candidate}]}` | `{kind:"tasks-reassigned", taskIds:[...]}` sorted ascending |

```ts
type TaskDraft = {
  module: string; description: string; start: string; due: string;
  priority: string; weight: string; candidate: string; requestKey: string;
};
type Assignees = {
  kind: 'task-assignees'; id: number | null; revision: string | null; context?: Context;
  hasMore: boolean;
  items: { key: string; name: string; role: string; lead: string; manager: string }[];
};
```

Candidate `key` is an opaque 43-character token, not a submitted display name. Option/context lists have at most 30 rows and use `hasMore` to ask for narrower search. Context strings are nonempty, max 240 characters. Validate dates, allowed priority, classification, workload/weight limit, and current candidate eligibility again on create/reassign. Errors are `invalid-task-draft`, `task-weight-limit`, `task-assignment-conflict`, `candidate-unavailable`, with `taskId` for a failed batch item.

Exact task shapes and validation: [task contracts](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/tasks-contract.ts).

## Publish Project and purchase orders

| Path | Request | Response |
| --- | --- | --- |
| `projects/publishing/tree` | `{[phase], [suite], [tool], [query], [after]}` | `{kind:"publish-tree", items:[{label, completedWeight}], next:string|null}` |
| `projects/publishing/orders` | `{phase, suite, tool, customer, [before]}` | `{kind:"publish-orders", items:Order[], next}` |
| `projects/publishing/order` | `{id}` | `{kind:"publish-order", item:OrderDetail, formC:FormC|null}` |
| `projects/publishing/tasks` | `{id:orderId, [before]}` | `{kind:"assigned-tasks", orderId, items:Task[], next}` |

Tree selects function/phase, then suite, then tool, then customer. Return max 30 unique labels, with `next` equal to the last label in a full page. `completedWeight` is `null` above the customer level and a numeric string between 0 and 100 for customers, with at most six decimal places. Backend must define the eligible task set and legacy over-100 behavior consistently.

```ts
type Order = { id: number; reference: string; customer: string; suite: string; tool: string;
  number: string; date: string; status: string };
type OrderDetail = Order & { formStatus: string; paymentTerms: string; license: string; projectId: number | null };
type FormC = {
  project: string; date: string; status: string; license: string; salesManager: string;
  implementor: string; implementorPhone: string; implementorEmail: string;
  endCustomer: string; endCustomerPhone: string;
  milestones: { name: string; description: string; responsibility: string; start: string; due: string }[];
};
```

References must start with `PO-`. A non-null `projectId` must be a verified linked project the account may open. Return only the authorized order/Form C/task relationship; do not associate records by an unverified display name.

Exact decoders: [publishing contracts](https://github.com/vanwanikhushal4-lang/PMS-Mobile/blob/b3b924a13156848e8ce866bba4fb7f4c57eba0f7/mobile/src/scm/publishing-contract.ts).

## Planned frontend modules and API families

These are future requirements from the original JSP inventory, not screens claimed complete by this handoff. Paths here are proposals and can be redesigned with the backend team before implementation.

| Module | API capabilities needed |
| --- | --- |
| Requirement and understanding authoring | Create/edit drafts, project/PO options, file upload/replace, submit, revision history, permitted transitions |
| Sales | Registrations, proposals and revisions, pricing/line items, approvals/rejections, licenses, purchase orders, Forms A/B/C, collections and generated documents |
| Helpdesk | Incident/ticket list/detail/create, categories and service catalog, assignment, priority/VIP/outage, hold/resolve/close/reopen, comments, files, SLA and full history |
| Specialist tasks | Operational, customization, RFP/compliance queues, lifecycle actions, evidence/files, reviewer history |
| E-forms/service operations | Software request/release/transfer, email/SMTP and business ID requests, approval queues and tracking |
| Administration | Actual role catalog, users/teams/scopes, customer/product/function masters, settings and server-driven permitted actions |
| Reports | Role-scoped filters, paginated report rows, totals, exports, export job state and downloads |
| Notifications | In-app inbox, unread count, read/dismiss, device registration, deep-link target, delivery preferences |
| Kickoff follow-up | Meeting edits/cancellation/history, attendee responses, invitation delivery/retry and calendar links if retained from legacy |

Reference inventory: [migration coverage](mobile-migration.md), [legacy route inventory](legacy-inventory.json). Each new screen will add its concrete request/response example here alongside frontend code.

## Backend handoff checklist

1. Share the deployed HTTPS base, API specification, allowed environments, and web CORS policy if browser preview is supported.
2. Confirm role/capability mapping, scoped test users, legacy status values, timezone, null/omission behavior, and action permissions.
3. Deliver P0 with examples for success, empty results, forbidden access, stale revision, duplicate retry and invalid input. Then deliver P1 by workflow.
4. Confirm file limits/storage, filename and MIME behavior, multipart parts, download headers, and notification delivery states.
5. Provide seeded test records for each role and linked lifecycle. Frontend will replace sample mode with the real adapter and verify screen behavior against these APIs.

The backend team may redesign persistence and internal services freely. Coordinate externally visible path/schema changes before frontend integration. Frontend preview never proves backend readiness.
