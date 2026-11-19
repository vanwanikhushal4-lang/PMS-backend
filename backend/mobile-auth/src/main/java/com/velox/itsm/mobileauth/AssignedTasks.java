package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.util.HtmlUtils;

final class AssignedTasks {
    private static final int PAGE_SIZE = 30;
    static final String SCOPED =
        " FROM scm_mobile_task_access a JOIN DaywiseTask t ON t.SR_NO=a.TASK_ID WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=?";
    private static final String MINE = " AND t.DEVELOPER_NAME=?";
    static final String PENDING = "(t.STATUS='Pending'"
        + " AND (t.updateDate_Status IS NULL OR t.updateDate_Status='' OR t.updateDate_Status='Date Approved'))";
    static final String OWNED_HISTORY = SCOPED + MINE + " AND (" + PENDING + " OR t.STATUS='Completed')";
    private static final String TASK_FIELDS = "SELECT t.SR_NO, t.STATUS, t.CUSTOMERNAME, t.PRODUCTSUIT, t.PRODUCTTOOL,"
        + " t.DESCRIPTION, t.MODULE_NAME, t.TEAM_LEADER, t.DEVELOPER_NAME, t.ASSIGNBY, t.START_DATE, t.END_DATE,"
        + " t.updateDate_Status, t.MANAGER_NAME, t.Task_ID, t.PRIORITY, t.WEIGHTAGE, t.FUNCTION_NAME, t.RESPONSIBILITY,t.Assign_date";
    private static final int LOG_LIMIT = 20;

    private AssignedTasks() {}

    static boolean validId(Object value) {
        if (!(value instanceof Number)) return false;
        double id = ((Number)value).doubleValue();
        return id >= 1 && id <= Integer.MAX_VALUE && id == Math.rint(id);
    }

    static JSONObject read(Connection db, Accounts.Account account, int before, String action) throws SQLException {
        String scope;
        switch (action) {
            case "tasks/assigned-to-me": scope = MINE + " AND " + PENDING; break;
            case "tasks/completed": scope = MINE + " AND t.STATUS='Completed'"; break;
            case "tasks/assignments/list":
                scope = " AND t.STATUS<> 'Completed'" + (TaskRoster.role(account.role, "Implementor")
                    ? " AND t.MANAGER_NAME=?" : " AND t.TEAM_LEADER=?");
                break;
            default: scope = " AND t.ASSIGNBY=?";
        }
        String sql = TASK_FIELDS + SCOPED + scope
            + (before == 0 ? "" : " AND t.SR_NO<?") + " ORDER BY t.SR_NO DESC LIMIT " + (PAGE_SIZE + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bind(query, account);
            if (before != 0) query.setInt(4, before);
            return page(query, account);
        }
    }

    static JSONObject dateQueue(Connection db, Accounts.Account account, int before, String queue) throws SQLException {
        boolean leadRoute = !TaskDates.managerRoute(account);
        String reviews = " AND t.STATUS='Pending' AND " + TaskDates.WAITING
            + " AND COALESCE(t.DEVELOPER_NAME,'')<>? AND COALESCE(t.dateUpdateBy,'')<>?"
            + " AND (t.MANAGER_NAME=?" + (leadRoute ? " OR (COALESCE(t.updateStarts_Date,'')='' AND t.TEAM_LEADER=?)" : "") + ")";
        String filter;
        switch (queue) {
            case "mine":
                filter = " AND (t.DEVELOPER_NAME=? OR (t.TEAM_LEADER=? AND t.dateUpdateBy=?))"
                    + " AND t.updateDate_Status IN ('Pending for approval','Date Approved')";
                break;
            case "team":
                filter = " AND t.TEAM_LEADER=? AND " + PENDING + (leadRoute ? "" : " AND 1=0");
                break;
            default: filter = reviews;
        }
        boolean review = "review".equals(queue);
        String sql = TASK_FIELDS + (review ? TaskDates.PROPOSAL_FIELDS : "") + SCOPED + filter
            + (before == 0 ? "" : " AND t.SR_NO<?") + " ORDER BY t.SR_NO DESC LIMIT " + (PAGE_SIZE + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bind(query, account);
            int parameter = 4;
            if (review) {
                query.setString(parameter++, account.fullname);
                query.setString(parameter++, account.fullname);
                if (leadRoute) query.setString(parameter++, account.fullname);
            }
            if ("mine".equals(queue)) {
                query.setString(parameter++, account.fullname);
                query.setString(parameter++, account.fullname);
            }
            if (before != 0) query.setInt(parameter, before);
            return page(query, account, review);
        }
    }

    static JSONObject projectPage(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        int id = input.getInt("id");
        if (Projects.detail(db, account, id) == null) return null;
        String term = input.optString("query").trim().toLowerCase(Locale.ROOT);
        boolean hasFilter = !term.isEmpty();
        boolean hasCursor = input.has("before");
        String sql = TASK_FIELDS + " FROM scm_mobile_project_access p"
            + " JOIN ProjectData project ON project.SR_NO=p.PROJECT_ID"
            + " JOIN scm_mobile_project_task l ON l.PROJECT_ID=p.PROJECT_ID AND l.COMPANY_CODE=p.COMPANY_CODE"
            + " JOIN scm_mobile_task_access a ON a.TASK_ID=l.TASK_ID AND a.COMPANY_CODE=p.COMPANY_CODE AND a.LOGIN_ID=p.LOGIN_ID"
            + " JOIN DaywiseTask t ON t.SR_NO=a.TASK_ID"
            + " WHERE p.LOGIN_ID=? AND p.COMPANY_CODE=? AND p.PROJECT_ID=? AND (t.DEVELOPER_NAME=? OR t.ASSIGNBY=?)"
            + (hasCursor ? " AND t.SR_NO<?" : "")
            + (hasFilter ? " AND (LOWER(t.MODULE_NAME) LIKE ? ESCAPE '!' OR LOWER(t.DESCRIPTION) LIKE ? ESCAPE '!'"
                + " OR LOWER(t.DEVELOPER_NAME) LIKE ? ESCAPE '!' OR LOWER(t.STATUS) LIKE ? ESCAPE '!')" : "")
            + " ORDER BY t.SR_NO DESC LIMIT " + (PAGE_SIZE + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setInt(1, account.id);
            query.setString(2, account.companyCode);
            query.setInt(3, id);
            query.setString(4, account.fullname);
            query.setString(5, account.fullname);
            int parameter = 6;
            if (hasCursor) query.setInt(parameter++, input.getInt("before"));
            if (hasFilter) {
                String pattern = "%" + term.replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%";
                for (int i = 0; i < 4; i++) query.setString(parameter++, pattern);
            }
            return page(query, account).put("projectId", id);
        }
    }

    static JSONObject orderPage(Connection db, Accounts.Account account, int order, int before) throws SQLException {
        if (!PublishedProjects.hasOrder(db, account, order)) return null;
        String sql = TASK_FIELDS + SCOPED + " AND EXISTS(SELECT 1" + PublishedProjects.ORDER_SCOPE + PublishedProjects.ORDER_FILTER
            + " AND p.SR_NO=? AND TRIM(p.customername)=TRIM(t.CUSTOMERNAME)"
            + " AND TRIM(p.ProductSuitName)=TRIM(t.PRODUCTSUIT) AND TRIM(p.SecurityToolName)=TRIM(t.PRODUCTTOOL))"
            + (before == 0 ? "" : " AND t.SR_NO<?") + " ORDER BY t.SR_NO DESC LIMIT " + (PAGE_SIZE + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setInt(1, account.id);
            query.setString(2, account.companyCode);
            query.setInt(3, account.id);
            query.setString(4, account.companyCode);
            query.setInt(5, order);
            if (before != 0) query.setInt(6, before);
            return page(query, account).put("orderId", order);
        }
    }

    private static JSONObject page(PreparedStatement query, Accounts.Account account) throws SQLException {
        return page(query, account, false);
    }

    private static JSONObject page(PreparedStatement query, Accounts.Account account, boolean review) throws SQLException {
        try (ResultSet rows = query.executeQuery()) {
            JSONArray items = new JSONArray();
            int last = 0;
            while (items.length() < PAGE_SIZE && rows.next()) {
                last = rows.getInt("SR_NO");
                String status = label(rows, "STATUS");
                String developer = label(rows, "DEVELOPER_NAME");
                String dateApproval = label(rows, "updateDate_Status");
                String lead = label(rows, "TEAM_LEADER");
                String manager = label(rows, "MANAGER_NAME");
                boolean dateAccess = account.fullname.equalsIgnoreCase(developer) || account.fullname.equalsIgnoreCase(lead)
                    || account.fullname.equalsIgnoreCase(manager);
                boolean history = account.fullname.equalsIgnoreCase(developer) && ("Completed".equalsIgnoreCase(status)
                    || ("Pending".equalsIgnoreCase(status) && (dateApproval.isEmpty() || "Date Approved".equalsIgnoreCase(dateApproval))));
                JSONObject item = new JSONObject().put("id", last)
                    .put("module", HtmlUtils.htmlUnescape(label(rows, "MODULE_NAME"))).put("status", status).put("workLog", history)
                    .put("reassignable", !status.isEmpty() && !"Completed".equalsIgnoreCase(status) && TaskAssignments.manages(account, lead, manager))
                    .put("dateAccess", dateAccess).put("dateApproval", dateAccess ? dateApproval : "")
                    .put("reference", label(rows, "Task_ID")).put("priority", label(rows, "PRIORITY")).put("weight", label(rows, "WEIGHTAGE"))
                    .put("function", label(rows, "FUNCTION_NAME")).put("responsibility", label(rows, "RESPONSIBILITY"))
                    .put("assignedAt", label(rows, "Assign_date"))
                    .put("customer", label(rows, "CUSTOMERNAME")).put("suite", label(rows, "PRODUCTSUIT"))
                    .put("tool", label(rows, "PRODUCTTOOL")).put("description", HtmlUtils.htmlUnescape(label(rows, "DESCRIPTION")))
                    .put("lead", lead).put("developer", developer)
                    .put("assigner", label(rows, "ASSIGNBY")).put("start", label(rows, "START_DATE")).put("due", label(rows, "END_DATE"));
                if (review) item.put("dateReview", TaskDates.review(rows, account, last));
                items.put(item);
            }
            Object next = items.length() == PAGE_SIZE && rows.next() ? last : JSONObject.NULL;
            return new JSONObject().put("kind", "assigned-tasks").put("items", items).put("next", next);
        }
    }

    static JSONObject workLog(Connection db, Accounts.Account account, int id, String today) throws SQLException {
        String authorized = "SELECT t.SR_NO" + OWNED_HISTORY + " AND t.SR_NO=?";
        boolean completed;
        try (PreparedStatement query = db.prepareStatement("SELECT t.STATUS" + OWNED_HISTORY + " AND t.SR_NO=?")) {
            bind(query, account);
            query.setInt(4, id);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                completed = "Completed".equalsIgnoreCase(row.getString("STATUS"));
            }
        }
        String sql = "SELECT w.SR_NO, w.DATE, w.TODAYS_PROGRESS, w.STATUS, w.FULL_NAME FROM Update_Todays_Progress w"
            + " WHERE w.TASK_ID=? AND w.TASK_TYPE='General' AND EXISTS (" + authorized + ")"
            + " ORDER BY w.SR_NO DESC LIMIT " + (LOG_LIMIT + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setString(1, Integer.toString(id));
            query.setInt(2, account.id);
            query.setString(3, account.companyCode);
            query.setString(4, account.fullname);
            query.setInt(5, id);
            try (ResultSet rows = query.executeQuery()) {
                JSONArray items = new JSONArray();
                while (items.length() < LOG_LIMIT && rows.next()) {
                    items.put(new JSONObject().put("id", rows.getInt("SR_NO")).put("date", label(rows, "DATE"))
                        .put("note", label(rows, "TODAYS_PROGRESS")).put("status", label(rows, "STATUS"))
                        .put("author", label(rows, "FULL_NAME")));
                }
                return new JSONObject().put("kind", "task-work-log").put("taskId", id)
                    .put("date", today).put("completed", completed)
                    .put("loggedToday", !completed && TaskProgress.hasEntry(db, id, today))
                    .put("items", items).put("hasMore", items.length() == LOG_LIMIT && rows.next());
            }
        }
    }

    static void bind(PreparedStatement query, Accounts.Account account) throws SQLException {
        query.setInt(1, account.id);
        query.setString(2, account.companyCode);
        query.setString(3, account.fullname);
    }

    private static String label(ResultSet row, String column) throws SQLException {
        String value = row.getString(column);
        return value == null ? "" : value.trim();
    }
}
