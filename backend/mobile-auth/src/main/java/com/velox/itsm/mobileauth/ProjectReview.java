package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProjectReview {
    private static final int LIMIT = 30;
    private static final DateTimeFormatter LEGACY_DATE = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm", java.util.Locale.ROOT);

    enum Queue {
        PENDING("pending"), APPROVED("approved"), REJECTED("rejected"), SUBMITTED("submitted");

        final String key;
        Queue(String key) { this.key = key; }

        static Queue from(JSONObject input) {
            if (!input.has("mode")) return PENDING;
            for (Queue queue : values()) if (queue.key.equals(input.opt("mode"))) return queue;
            return null;
        }

        String condition(ProjectRecords.Kind scope) {
            String status = "LOWER(" + scope.status + ")";
            switch (this) {
                case SUBMITTED: return "d.UserId=?";
                case APPROVED:
                    return status + (scope == ProjectRecords.Kind.REQUIREMENT
                        ? " IN ('rd approved','rd approved by md','rd approved by si')"
                        : " IN ('ud approved by md','ud approved by si')");
                case REJECTED: return status + "='ud rejected by md'";
                default: return status + "=LOWER(?)";
            }
        }
    }

    private ProjectReview() {}

    static boolean supports(ProjectRecords.Kind scope) {
        return scope == ProjectRecords.Kind.REQUIREMENT || scope == ProjectRecords.Kind.UNDERSTANDING;
    }

    static boolean allowed(Accounts.Account account, ProjectRecords.Kind scope) {
        if (!account.projectAccess) return false;
        boolean director = "MD".equalsIgnoreCase(account.role);
        if (scope == ProjectRecords.Kind.REQUIREMENT) return director && account.hasSidebarScope("Requirement_Documents");
        return scope == ProjectRecords.Kind.UNDERSTANDING && account.hasSidebarScope("PMS")
            && (director || "Head_Projects".equalsIgnoreCase(account.role));
    }

    static boolean canListOwnRequirements(Accounts.Account account) {
        return account.projectAccess && "Sales_Initiator".equalsIgnoreCase(account.role)
            && account.hasSidebarScope("Requirement_Documents");
    }

    static boolean validQueue(JSONObject input) {
        boolean page = input.has("before");
        ProjectRecords.Kind scope = ProjectRecords.Kind.from(input.opt("scope"));
        Queue queue = Queue.from(input);
        return supports(scope) && queue != null
            && (queue != Queue.SUBMITTED || scope == ProjectRecords.Kind.REQUIREMENT)
            && (queue != Queue.REJECTED || scope == ProjectRecords.Kind.UNDERSTANDING)
            && input.length() == 1 + (page ? 1 : 0) + (input.has("mode") ? 1 : 0)
            && (!page || AssignedTasks.validId(input.opt("before")));
    }

    static boolean validDecision(JSONObject input) {
        ProjectRecords.Kind scope = ProjectRecords.Kind.from(input.opt("scope"));
        if (!supports(scope) || !AssignedTasks.validId(input.opt("id")) || !AssignedTasks.validId(input.opt("recordId"))
                || !TaskAssignments.token(input.opt("revision"))) return false;
        if ("approve".equals(input.opt("decision"))) return input.length() == 5;
        if (scope != ProjectRecords.Kind.UNDERSTANDING || !"reject".equals(input.opt("decision")) || input.length() != 6) return false;
        Object raw = input.opt("reason");
        if (!(raw instanceof String)) return false;
        String reason = ((String) raw).trim();
        return !reason.isEmpty() && reason.length() <= 255 && reason.codePoints().noneMatch(value ->
            Character.isISOControl(value) && value != '\r' && value != '\n' && value != '\t');
    }

    static String pendingStatus(ProjectRecords.Kind scope) {
        return scope == ProjectRecords.Kind.REQUIREMENT ? "RD Pending For Approval" : "UD Pending For Approval";
    }

    static JSONObject options(Accounts.Account account, ProjectRecords.Kind scope, int project, JSONObject item,
                              JSONArray fields, Map<String, String> files) {
        JSONArray snapshot = new JSONArray().put(account.id).put(account.companyCode).put(scope.key).put(project)
            .put(item.getInt("id")).put(item.getString("reference")).put(item.getString("date")).put(item.getString("status")).put(fields);
        files.forEach((kind, name) -> snapshot.put(kind).put(name));
        return new JSONObject().put("revision", Secrets.tokenHash(snapshot.toString())).put("canReject", scope == ProjectRecords.Kind.UNDERSTANDING);
    }

    static JSONObject queue(Connection db, Accounts.Account account, ProjectRecords.Kind scope, Queue queue, int before) throws SQLException {
        String sql = ProjectRecords.columns(scope) + ", q.PROJECT_ID, p.PROJECTNAME, p.Task_ID"
            + (queue == Queue.REJECTED ? ", d.rejectedMDDate" : "")
            + " FROM (SELECT l.RECORD_ID, MIN(p.SR_NO) AS PROJECT_ID FROM scm_mobile_project_access a"
            + " JOIN ProjectData p ON p.SR_NO=a.PROJECT_ID"
            + " JOIN scm_mobile_project_record l ON l.PROJECT_ID=a.PROJECT_ID AND l.COMPANY_CODE=a.COMPANY_CODE"
            + " WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=? AND l.RECORD_KIND=?"
            + (before > 0 ? " AND l.RECORD_ID<?" : "") + " GROUP BY l.RECORD_ID) q"
            + " JOIN " + scope.table + " d ON d.SR_NO=q.RECORD_ID JOIN ProjectData p ON p.SR_NO=q.PROJECT_ID"
            + " WHERE " + queue.condition(scope) + " ORDER BY d.SR_NO DESC LIMIT " + (LIMIT + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setInt(1, account.id);
            query.setString(2, account.companyCode);
            query.setString(3, scope.key);
            int parameter = 4;
            if (before > 0) query.setInt(parameter++, before);
            if (queue == Queue.PENDING) query.setString(parameter, pendingStatus(scope));
            if (queue == Queue.SUBMITTED) query.setString(parameter, account.username);
            try (ResultSet rows = query.executeQuery()) {
                JSONArray items = new JSONArray();
                int last = 0;
                while (items.length() < LIMIT && rows.next()) {
                    JSONObject item = ProjectRecords.summary(rows);
                    last = item.getInt("id");
                    if (queue == Queue.REJECTED) item.put("decisionDate", ProjectRecords.text(rows, "rejectedMDDate"));
                    items.put(item.put("projectId", rows.getInt("PROJECT_ID"))
                        .put("projectName", ProjectRecords.text(rows, "PROJECTNAME")).put("projectReference", ProjectRecords.text(rows, "Task_ID")));
                }
                return new JSONObject().put("kind", "project-review-queue").put("scope", scope.key).put("mode", queue.key).put("items", items)
                    .put("next", items.length() == LIMIT && rows.next() ? last : JSONObject.NULL);
            }
        }
    }

    static JSONObject decide(Connection db, Accounts.Account account, JSONObject input, LocalDateTime now) throws SQLException {
        db.setAutoCommit(false);
        try {
            JSONObject record = ProjectRecords.detail(db, account, input, true);
            if (record == null) { db.rollback(); return null; }
            JSONObject review = record.optJSONObject("review");
            if (review == null || !review.getString("revision").equals(input.getString("revision"))) {
                db.rollback(); return conflict();
            }
            ProjectRecords.Kind scope = ProjectRecords.Kind.from(input.get("scope"));
            boolean reject = "reject".equals(input.get("decision"));
            String status = scope == ProjectRecords.Kind.REQUIREMENT ? "RD Approved" : reject ? "UD Rejected By MD" : "UD Approved By MD";
            String column = scope == ProjectRecords.Kind.REQUIREMENT ? "RDStatus" : "UDStatus";
            String sql = "UPDATE " + scope.table + " SET " + column + "=?"
                + (reject ? ", rejectMDReason=?, rejectedByMD=?, rejectedMDDate=?" : "")
                + " WHERE SR_NO=? AND LOWER(" + column + ")=LOWER(?)";
            try (PreparedStatement update = db.prepareStatement(sql)) {
                int parameter = 1;
                update.setString(parameter++, status);
                if (reject) {
                    update.setString(parameter++, input.getString("reason").trim());
                    update.setString(parameter++, account.username);
                    update.setString(parameter++, LEGACY_DATE.format(now));
                }
                update.setInt(parameter++, input.getInt("recordId"));
                update.setString(parameter, pendingStatus(scope));
                if (update.executeUpdate() != 1) { db.rollback(); return conflict(); }
            }
            JSONObject updated = ProjectRecords.detail(db, account, input);
            if (updated == null) { db.rollback(); return conflict(); }
            db.commit();
            return updated;
        } catch (SQLException | RuntimeException failure) {
            try { db.rollback(); } catch (SQLException rollback) { failure.addSuppressed(rollback); }
            throw failure;
        }
    }

    private static JSONObject conflict() {
        return new JSONObject().put("kind", "rejected").put("reason", "project-review-conflict");
    }
}
