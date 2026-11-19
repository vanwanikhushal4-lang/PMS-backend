package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/** ProjectData has no tenant or stable owner field. Every read joins an explicit account grant. */
final class Projects {
    private static final int PAGE_SIZE = 30;
    private static final String SCOPED =
        "SELECT p.SR_NO, p.PROJECTNAME, p.CUSTOMERNAME, p.FUNCTION_NAME, p.RESPONSIBILITY,"
        + " p.PRODUCTSUIT, p.PRODUCTTOOL, p.Task_ID, f.PROJECT_ID AS FAVORITE_ID FROM scm_mobile_project_access a"
        + " JOIN ProjectData p ON p.SR_NO=a.PROJECT_ID"
        + " LEFT JOIN scm_mobile_project_favorite f ON f.PROJECT_ID=a.PROJECT_ID AND f.LOGIN_ID=a.LOGIN_ID AND f.COMPANY_CODE=a.COMPANY_CODE"
        + " WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=?";

    private Projects() {}

    static boolean valid(JSONObject input, String action) {
        if ("projects/records/detail".equals(action)) return ProjectRecords.validDetail(input);
        boolean taskPage = "projects/tasks".equals(action);
        if ("projects/favorite".equals(action))
            return input.length() == 2 && positiveId(input.opt("id")) && input.opt("favorite") instanceof Boolean;
        if (!taskPage && !"projects/list".equals(action)) return input.length() == 1 && positiveId(input.opt("id"));
        if (taskPage && !positiveId(input.opt("id"))) return false;
        for (String key : input.keySet()) {
            if (taskPage && "id".equals(key)) continue;
            if (!taskPage && "saved".equals(key) && input.opt(key) instanceof Boolean) continue;
            if ("before".equals(key)) {
                if (!positiveId(input.opt(key))) return false;
            } else if ("query".equals(key)) {
                Object value = input.opt(key);
                if (!(value instanceof String) || ((String)value).length() > 120) return false;
            } else return false;
        }
        return true;
    }

    private static boolean positiveId(Object value) {
        if (!(value instanceof Number)) return false;
        double id = ((Number)value).doubleValue();
        return id >= 1 && id <= Integer.MAX_VALUE && id == Math.rint(id);
    }

    static JSONObject page(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        String term = input.optString("query").trim().toLowerCase(Locale.ROOT);
        boolean hasFilter = !term.isEmpty();
        boolean hasCursor = input.has("before");
        String sql = SCOPED + (input.optBoolean("saved") ? " AND f.PROJECT_ID IS NOT NULL" : "")
            + (hasCursor ? " AND p.SR_NO<?" : "") + (hasFilter
            ? " AND (LOWER(p.PROJECTNAME) LIKE ? ESCAPE '!' OR LOWER(p.CUSTOMERNAME) LIKE ? ESCAPE '!' OR LOWER(p.PRODUCTTOOL) LIKE ? ESCAPE '!')" : "")
            + " ORDER BY p.SR_NO DESC LIMIT " + (PAGE_SIZE + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bindAccount(query, account);
            int parameter = 3;
            if (hasCursor) query.setInt(parameter++, input.getInt("before"));
            if (hasFilter) {
                String pattern = "%" + term.replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%";
                for (int i = 0; i < 3; i++) query.setString(parameter++, pattern);
            }
            try (ResultSet rows = query.executeQuery()) {
                JSONArray projects = new JSONArray();
                int last = 0;
                while (projects.length() < PAGE_SIZE && rows.next()) {
                    projects.put(row(rows));
                    last = rows.getInt("SR_NO");
                }
                Object next = projects.length() == PAGE_SIZE && rows.next() ? last : JSONObject.NULL;
                return new JSONObject().put("kind", "projects").put("items", projects).put("next", next);
            }
        }
    }

    static JSONObject detail(Connection db, Accounts.Account account, int id) throws SQLException {
        try (PreparedStatement query = db.prepareStatement(SCOPED + " AND p.SR_NO=?")) {
            bindAccount(query, account);
            query.setInt(3, id);
            try (ResultSet rows = query.executeQuery()) {
                return rows.next() ? new JSONObject().put("kind", "project").put("item", row(rows)) : null;
            }
        }
    }

    static JSONObject favorite(Connection db, Accounts.Account account, int id, boolean favorite) throws SQLException {
        if (detail(db, account, id) == null) return null;
        String sql = favorite
            ? "INSERT INTO scm_mobile_project_favorite (LOGIN_ID, COMPANY_CODE, PROJECT_ID)"
                + " SELECT a.LOGIN_ID, a.COMPANY_CODE, a.PROJECT_ID FROM scm_mobile_project_access a"
                + " JOIN ProjectData p ON p.SR_NO=a.PROJECT_ID WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=? AND a.PROJECT_ID=?"
                + " ON DUPLICATE KEY UPDATE LOGIN_ID=?"
            : "DELETE FROM scm_mobile_project_favorite WHERE LOGIN_ID=? AND COMPANY_CODE=? AND PROJECT_ID=?";
        try (PreparedStatement update = db.prepareStatement(sql)) {
            bindAccount(update, account);
            update.setInt(3, id);
            if (favorite) update.setInt(4, account.id);
            update.executeUpdate();
        }
        return new JSONObject().put("kind", "project-favorite").put("projectId", id).put("favorite", favorite);
    }

    private static void bindAccount(PreparedStatement query, Accounts.Account account) throws SQLException {
        query.setInt(1, account.id);
        query.setString(2, account.companyCode);
    }

    private static JSONObject row(ResultSet row) throws SQLException {
        return new JSONObject().put("id", row.getInt("SR_NO"))
            .put("name", label(row, "PROJECTNAME")).put("customer", label(row, "CUSTOMERNAME"))
            .put("function", label(row, "FUNCTION_NAME")).put("responsibility", label(row, "RESPONSIBILITY"))
            .put("suite", label(row, "PRODUCTSUIT")).put("tool", label(row, "PRODUCTTOOL"))
            .put("reference", label(row, "Task_ID")).put("favorite", row.getInt("FAVORITE_ID") != 0);
    }

    private static String label(ResultSet row, String column) throws SQLException {
        String value = row.getString(column);
        return value == null ? "" : value.trim();
    }
}
