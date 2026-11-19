package com.velox.itsm.mobileauth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/** Legacy identity is read-only. Task writes use the shared SCM mapping and the scoped connection. */
public final class Accounts {
    private static final String READ = "SELECT l.LOGINID, l.USERNAME, l.FULL_NAME, l.ROLE_TYPE, l.DESIGNATION, l.LOGIN_TYPE, l.EMAIL, l.PHONE, l.SIDEBAR_SCOPE,"
        + " c.COMPANY_CODE, c.COMPANY_NAME, m.PASSWORD_HASH, m.MFA_MODE, m.TOTP_ENCRYPTED, m.REVISION,"
        + " EXISTS(SELECT 1 FROM scm_mobile_project_access a WHERE a.LOGIN_ID=m.LOGIN_ID AND a.COMPANY_CODE=m.COMPANY_CODE) AS PROJECT_ACCESS,"
        + " EXISTS(SELECT 1 FROM scm_mobile_project_create_context a WHERE a.LOGIN_ID=m.LOGIN_ID AND a.COMPANY_CODE=m.COMPANY_CODE) AS PROJECT_CREATE,"
        + " EXISTS(SELECT 1 FROM scm_mobile_purchase_order_access a WHERE a.LOGIN_ID=m.LOGIN_ID AND a.COMPANY_CODE=m.COMPANY_CODE) AS PURCHASE_ORDER_ACCESS,"
        + " EXISTS(SELECT 1 FROM scm_mobile_task_access a WHERE a.LOGIN_ID=m.LOGIN_ID AND a.COMPANY_CODE=m.COMPANY_CODE) AS TASK_ACCESS"
        + " FROM scm_mobile_account m JOIN LOGINMASTER l ON l.LOGINID=m.LOGIN_ID"
        + " JOIN company_code_master c ON c.COMPANY_CODE=m.COMPANY_CODE AND c.COMPANY_NAME=l.COMPANY"
        + " WHERE m.ENABLED=TRUE AND ";
    private final DataSource source;
    private final Supplier<SessionFactory> legacySessions;

    public Accounts(DataSource source, Supplier<SessionFactory> legacySessions) {
        this.source = source;
        this.legacySessions = legacySessions;
    }

    Account find(String company, String username) throws SQLException {
        try (Connection db = source.getConnection(); PreparedStatement statement = db.prepareStatement(READ + "c.COMPANY_CODE=? AND l.USERNAME=?")) {
            statement.setString(1, company); statement.setString(2, username);
            return one(statement);
        }
    }

    Account get(int id, String company) throws SQLException {
        try (Connection db = source.getConnection(); PreparedStatement statement = db.prepareStatement(READ + "m.LOGIN_ID=? AND c.COMPANY_CODE=?")) {
            statement.setInt(1, id); statement.setString(2, company);
            return one(statement);
        }
    }

    JSONObject workspace(Account account) throws SQLException {
        try (Connection db = source.getConnection()) {
            return PersonalIncidents.read(db, account.username, account.companyName);
        }
    }

    JSONObject profile(Account account) throws SQLException {
        try (Connection db = source.getConnection(); PreparedStatement query = db.prepareStatement(
                "SELECT EMAIL, PHONE, LOCATION, BRANCH, DEPARTMENT, SUB_DEPARTMENT FROM LOGINMASTER WHERE LOGINID=? AND COMPANY=?")) {
            query.setInt(1, account.id);
            query.setString(2, account.companyName);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                return new JSONObject().put("kind", "profile")
                    .put("email", Account.clean(row, "EMAIL")).put("phone", Account.clean(row, "PHONE"))
                    .put("location", Account.clean(row, "LOCATION")).put("site", Account.clean(row, "BRANCH"))
                    .put("department", Account.clean(row, "DEPARTMENT")).put("subdepartment", Account.clean(row, "SUB_DEPARTMENT"));
            }
        }
    }

    JSONObject projects(Account account, JSONObject input, String action) throws SQLException {
        try (Connection db = source.getConnection()) {
            switch (action) {
                case "projects/detail": return Projects.detail(db, account, input.getInt("id"));
                case "projects/records": return ProjectRecords.list(db, account, input.getInt("id"));
                case "projects/records/detail": return ProjectRecords.detail(db, account, input);
                case "projects/records/review-queue": return ProjectReview.queue(db, account, ProjectRecords.Kind.from(input.get("scope")),
                    ProjectReview.Queue.from(input), input.optInt("before"));
                case "projects/tasks": return AssignedTasks.projectPage(db, account, input);
                case "projects/favorite": return Projects.favorite(db, account, input.getInt("id"), input.getBoolean("favorite"));
                case "projects/create-options": return ProjectCreation.options(db, account, input.optString("query"), input.optString("functionQuery"));
                default: return Projects.page(db, account, input);
            }
        }
    }

    JSONObject reviewProjectRecord(Account account, JSONObject input, LocalDateTime time) throws SQLException {
        try (Connection db = source.getConnection()) {
            return ProjectReview.decide(db, account, input, time);
        }
    }

    JSONObject createProject(Account account, JSONObject input) throws SQLException {
        for (int attempt = 0; ; attempt++) {
            try (Connection db = source.getConnection()) {
                return ProjectCreation.create(db, account, input);
            } catch (SQLException failure) {
                // The legacy writer allocates its ID without the mobile lock.
                if (!allocationCollision(failure) || attempt >= 2) throw failure;
            }
        }
    }

    JSONObject publishing(Account account, JSONObject input, String action) throws SQLException {
        try (Connection db = source.getConnection()) {
            switch (action) {
                case "projects/publishing/tree": return PublishedProjects.tree(db, account, input);
                case "projects/publishing/orders": return PublishedProjects.orders(db, account, input);
                case "projects/publishing/order": return PublishedProjects.detail(db, account, input.getInt("id"));
                default: return AssignedTasks.orderPage(db, account, input.getInt("id"), input.optInt("before"));
            }
        }
    }

    ProjectAttachments.Names projectAttachments(Account account, ProjectAttachments.Target target) throws SQLException {
        try (Connection db = source.getConnection()) {
            return ProjectAttachments.names(db, account, target);
        }
    }

    JSONObject kickoffOptions(Account account, JSONObject input, ZoneId zone) throws SQLException {
        try (Connection db = source.getConnection()) {
            return ProjectKickoff.options(db, account, input, zone);
        }
    }

    JSONObject scheduleKickoff(Account account, KickoffFiles.Upload upload) throws SQLException, IOException {
        for (int attempt = 0; ; attempt++) {
            try (Connection db = source.getConnection()) {
                return ProjectKickoff.schedule(db, account, upload);
            } catch (SQLException failure) {
                if (!allocationCollision(failure) || attempt >= 2 || upload.retained()) throw failure;
            }
        }
    }

    JSONObject assignedTasks(Account account, int before, String action) throws SQLException {
        try (Connection db = source.getConnection()) {
            return AssignedTasks.read(db, account, before, action);
        }
    }

    JSONObject assignmentOptions(Account account, int id, String query, boolean project) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskAssignments.options(db, account, id, query, project);
        }
    }

    JSONObject taskContexts(Account account, String query) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskAssignments.contexts(db, account, query);
        }
    }

    JSONObject standaloneOptions(Account account, JSONObject context, String query) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskAssignments.standaloneOptions(db, account, context, query);
        }
    }

    JSONObject createTask(Account account, JSONObject input, LocalDateTime when) throws SQLException {
        for (int attempt = 0; ; attempt++) {
            try (Connection db = source.getConnection()) {
                return TaskAssignments.create(db, account, input, when);
            } catch (SQLException failure) {
                // A legacy MAX+1 writer does not take the mobile allocator lock.
                if (!allocationCollision(failure) || attempt >= 2) throw failure;
            }
        }
    }

    private static boolean allocationCollision(SQLException failure) {
        return "40001".equals(failure.getSQLState()) || "23505".equals(failure.getSQLState()) || failure.getErrorCode() == 1062;
    }

    JSONObject reassignTask(Account account, int id, String revision, String candidate) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskAssignments.reassign(db, account, id, revision, candidate);
        }
    }

    JSONObject reassignTasks(Account account, java.util.Map<Integer, JSONObject> items) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskAssignments.reassignBulk(db, account, items);
        }
    }

    JSONObject workLog(Account account, int taskId, String today) throws SQLException {
        try (Connection db = source.getConnection()) {
            return AssignedTasks.workLog(db, account, taskId, today);
        }
    }

    TaskProgress.Result updateTask(Account account, int taskId, String note, LocalDateTime now) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskProgress.apply(db, legacySessions.get(), account, taskId, note, now);
        } catch (RuntimeException failure) {
            throw new SQLException("SCM work log service is unavailable", failure);
        }
    }

    JSONObject dateQueue(Account account, int before, String queue) throws SQLException {
        try (Connection db = source.getConnection()) {
            return AssignedTasks.dateQueue(db, account, before, queue);
        }
    }

    JSONObject taskDates(Account account, int taskId) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskDates.detail(db, account, taskId);
        }
    }

    TaskDates.Result requestDates(Account account, int taskId, LocalDate start, LocalDate due, String reason, LocalDateTime now) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskDates.request(db, account, taskId, start, due, reason, now);
        }
    }

    TaskDates.Result approveDates(Account account, int taskId, String revision, LocalDateTime now) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskDates.approve(db, legacySessions.get(), account, taskId, revision, now);
        } catch (RuntimeException failure) {
            throw new SQLException("SCM date approval is unavailable", failure);
        }
    }

    TaskDates.Rejection requestDatesBatch(Account account, Map<Integer, TaskDates.Proposal> items, LocalDateTime now) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskDates.requestBatch(db, account, items, now);
        }
    }

    TaskDates.Rejection approveDatesBatch(Account account, Map<Integer, String> items, LocalDateTime now) throws SQLException {
        try (Connection db = source.getConnection()) {
            return TaskDates.approveBatch(db, legacySessions.get(), account, items, now);
        } catch (RuntimeException failure) {
            throw new SQLException("SCM date approval is unavailable", failure);
        }
    }

    private Account one(PreparedStatement statement) throws SQLException {
        try (ResultSet rows = statement.executeQuery()) {
            if (!rows.next()) return null;
            Account user = new Account(rows);
            return !user.valid() || rows.next() ? null : user;
        }
    }

    boolean acceptTotp(Account user, long step, String enrollment) throws SQLException {
        String update = enrollment == null
            ? "UPDATE scm_mobile_account SET LAST_TOTP_STEP=? WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REVISION=? AND ENABLED=TRUE AND LAST_TOTP_STEP<? AND TOTP_ENCRYPTED IS NOT NULL"
            : "UPDATE scm_mobile_account SET LAST_TOTP_STEP=?, TOTP_ENCRYPTED=?, REVISION=REVISION+1 WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REVISION=? AND ENABLED=TRUE AND LAST_TOTP_STEP<? AND TOTP_ENCRYPTED IS NULL";
        try (Connection db = source.getConnection(); PreparedStatement statement = db.prepareStatement(update)) {
            int i = 1;
            statement.setLong(i++, step);
            if (enrollment != null) statement.setString(i++, enrollment);
            statement.setInt(i++, user.id); statement.setString(i++, user.companyCode); statement.setLong(i++, user.revision); statement.setLong(i, step);
            return statement.executeUpdate() == 1;
        }
    }

    boolean reset(Account user, String passwordHash) throws SQLException {
        try (Connection db = source.getConnection(); PreparedStatement statement = db.prepareStatement(
                "UPDATE scm_mobile_account SET PASSWORD_HASH=?, REVISION=REVISION+1 WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REVISION=? AND ENABLED=TRUE")) {
            statement.setString(1, passwordHash); statement.setInt(2, user.id); statement.setString(3, user.companyCode); statement.setLong(4, user.revision);
            return statement.executeUpdate() == 1;
        }
    }

    static final class Account {
        final int id;
        final long revision;
        final boolean projectAccess;
        final boolean projectCreate;
        final boolean purchaseOrderAccess;
        final boolean taskAccess;
        private final String sidebarScope;
        final String username, fullname, role, designation, companyCode, companyName, email, phone, kind, mode, passwordHash, totp;
        Account(ResultSet data) throws SQLException {
            id = data.getInt("LOGINID"); revision = data.getLong("REVISION");
            projectAccess = data.getBoolean("PROJECT_ACCESS");
            projectCreate = data.getBoolean("PROJECT_CREATE");
            purchaseOrderAccess = data.getBoolean("PURCHASE_ORDER_ACCESS");
            taskAccess = data.getBoolean("TASK_ACCESS");
            sidebarScope = clean(data, "SIDEBAR_SCOPE");
            username = clean(data, "USERNAME"); fullname = clean(data, "FULL_NAME"); role = clean(data, "ROLE_TYPE");
            designation = clean(data, "DESIGNATION"); companyCode = clean(data, "COMPANY_CODE"); companyName = clean(data, "COMPANY_NAME");
            email = clean(data, "EMAIL"); phone = clean(data, "PHONE"); kind = clean(data, "LOGIN_TYPE"); mode = clean(data, "MFA_MODE");
            passwordHash = data.getString("PASSWORD_HASH"); totp = data.getString("TOTP_ENCRYPTED");
        }
        private boolean valid() {
            return id > 0 && revision > 0 && label(username, 128) && label(fullname, 128) && label(role, 96) && designation.length() <= 128
                && label(companyCode, 48) && label(companyName, 128) && (directory() || "non-ad".equalsIgnoreCase(kind))
                && ("off".equals(mode) || "sms".equals(mode) || "totp".equals(mode));
        }
        boolean directory() { return "AD".equalsIgnoreCase(kind); }
        boolean projectWorkspace() { return projectAccess || projectCreate || purchaseOrderAccess; }
        boolean publishingAccess() { return purchaseOrderAccess || ((projectAccess || projectCreate) && taskAccess); }
        boolean taskWorkspace() { return taskAccess || TaskRoster.canCreate(this); }
        boolean hasSidebarScope(String scope) {
            for (String token : sidebarScope.split(",")) if (scope.equals(token.trim())) return true;
            return false;
        }
        JSONObject identity() {
            JSONArray capabilities = new JSONArray();
            if (projectWorkspace()) capabilities.put("projects.read");
            if (projectCreate) capabilities.put("projects.create");
            if (publishingAccess()) capabilities.put("projects.publish");
            if (ProjectReview.allowed(this, ProjectRecords.Kind.REQUIREMENT)) capabilities.put("projects.requirement-review");
            if (ProjectReview.allowed(this, ProjectRecords.Kind.UNDERSTANDING)) capabilities.put("projects.understanding-review");
            if (ProjectReview.canListOwnRequirements(this)) capabilities.put("projects.requirements-submitted");
            if (ProjectKickoff.allowed(this)) capabilities.put("projects.kickoff-schedule");
            if (taskWorkspace()) capabilities.put("tasks.assigned-by-me").put("tasks.assigned-to-me");
            if ((projectAccess || projectCreate) && TaskRoster.canCreate(this)) capabilities.put("tasks.create");
            if (TaskRoster.canCreate(this)) capabilities.put("tasks.create-standalone");
            return new JSONObject().put("username", username).put("displayName", fullname).put("role", role).put("designation", designation)
                .put("companyCode", companyCode).put("companyName", companyName).put("capabilities", capabilities);
        }
        private static String clean(ResultSet source, String key) throws SQLException {
            String value = source.getString(key);
            return value == null ? "" : value.trim();
        }
        private static boolean label(String value, int max) { return !value.isEmpty() && value.length() <= max; }
    }
}
