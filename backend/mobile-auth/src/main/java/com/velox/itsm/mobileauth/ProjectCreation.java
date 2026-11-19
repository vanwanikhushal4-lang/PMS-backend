package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProjectCreation {
    private static final int PAGE_SIZE = 30;
    private static final String CATALOG = " FROM scm_mobile_project_create_context WHERE LOGIN_ID=? AND COMPANY_CODE=?";

    private ProjectCreation() {}

    static boolean validOptions(JSONObject input) {
        for (String key : input.keySet()) {
            if (!("query".equals(key) || "functionQuery".equals(key)) || !(input.opt(key) instanceof String)
                || input.getString(key).length() > 120) return false;
        }
        return true;
    }

    static boolean validDraft(JSONObject input) {
        String name = input.opt("name") instanceof String ? input.getString("name").trim() : "";
        String function = input.opt("function") instanceof String ? input.getString("function").trim() : "";
        return input.length() == 5 && !name.isEmpty() && name.length() <= 120 && name.codePoints().noneMatch(Character::isISOControl)
            && !function.isEmpty() && function.length() <= 240 && TaskAssignments.RESPONSIBILITIES.contains(input.opt("responsibility"))
            && TaskAssignments.validContext(input.optJSONObject("context"))
            && input.opt("requestKey") instanceof String && input.getString("requestKey").matches("[A-Za-z0-9_-]{20,64}");
    }

    static JSONObject options(Connection db, Accounts.Account account, String query, String functionQuery) throws SQLException {
        JSONArray contexts = new JSONArray(), functions = new JSONArray();
        boolean moreContexts, moreFunctions;
        try (PreparedStatement statement = db.prepareStatement("SELECT DISTINCT CUSTOMER,PRODUCT_SUITE,PRODUCT_TOOL" + CATALOG
                + " AND LOWER(CONCAT_WS(' ',CUSTOMER,PRODUCT_SUITE,PRODUCT_TOOL)) LIKE ? ESCAPE '!'"
                + " ORDER BY CUSTOMER,PRODUCT_SUITE,PRODUCT_TOOL LIMIT " + (PAGE_SIZE + 1))) {
            bind(statement, account);
            statement.setString(3, pattern(query));
            try (ResultSet row = statement.executeQuery()) {
                while (contexts.length() < PAGE_SIZE && row.next()) {
                    contexts.put(new JSONObject().put("customer", row.getString("CUSTOMER"))
                        .put("suite", row.getString("PRODUCT_SUITE")).put("tool", row.getString("PRODUCT_TOOL")));
                }
                moreContexts = contexts.length() == PAGE_SIZE && row.next();
            }
        }
        try (PreparedStatement statement = db.prepareStatement("SELECT DISTINCT TRIM(FUNCTION_NAME) AS FUNCTION_LABEL FROM FunctionMaster"
                + " WHERE CHAR_LENGTH(TRIM(FUNCTION_NAME)) BETWEEN 1 AND 240 AND LOWER(TRIM(FUNCTION_NAME)) LIKE ? ESCAPE '!'"
                + " ORDER BY FUNCTION_LABEL LIMIT " + (PAGE_SIZE + 1))) {
            statement.setString(1, pattern(functionQuery));
            try (ResultSet row = statement.executeQuery()) {
                while (functions.length() < PAGE_SIZE && row.next()) functions.put(row.getString("FUNCTION_LABEL"));
                moreFunctions = functions.length() == PAGE_SIZE && row.next();
            }
        }
        return new JSONObject().put("kind", "project-create-options").put("contexts", contexts).put("moreContexts", moreContexts)
            .put("functions", functions).put("moreFunctions", moreFunctions).put("responsibilities", new JSONArray(TaskAssignments.RESPONSIBILITIES));
    }

    static JSONObject create(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        db.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        db.setAutoCommit(false);
        try {
            JSONObject result = createLocked(db, account, input);
            db.commit();
            return result;
        } catch (SQLException | RuntimeException failure) {
            db.rollback();
            throw failure;
        }
    }

    private static JSONObject createLocked(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        JSONObject context = input.getJSONObject("context");
        String customer = context.getString("customer"), suite = context.getString("suite"), tool = context.getString("tool");
        String name = input.getString("name").trim(), function = input.getString("function").trim();
        String responsibility = input.getString("responsibility"), key = input.getString("requestKey");
        try (PreparedStatement grant = db.prepareStatement("SELECT CUSTOMER,PRODUCT_SUITE,PRODUCT_TOOL" + CATALOG
                + " AND CUSTOMER=? AND PRODUCT_SUITE=? AND PRODUCT_TOOL=? FOR UPDATE")) {
            bind(grant, account);
            grant.setString(3, customer);
            grant.setString(4, suite);
            grant.setString(5, tool);
            try (ResultSet row = grant.executeQuery()) {
                if (!row.next()) return rejected("project-context-unavailable");
                customer = row.getString("CUSTOMER");
                suite = row.getString("PRODUCT_SUITE");
                tool = row.getString("PRODUCT_TOOL");
            }
        }
        try (PreparedStatement mutex = db.prepareStatement("SELECT ID FROM scm_mobile_project_create_lock WHERE ID=1 FOR UPDATE");
             ResultSet row = mutex.executeQuery()) {
            if (!row.next()) throw new SQLException("SCM project allocation row is missing");
        }
        String hash = Secrets.tokenHash(new JSONArray().put(customer).put(suite).put(tool).put(name).put(function).put(responsibility).toString());
        try (PreparedStatement submission = db.prepareStatement("SELECT PROJECT_ID,REQUEST_HASH FROM scm_mobile_project_submission"
                + " WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REQUEST_KEY=?")) {
            bind(submission, account);
            submission.setString(3, key);
            try (ResultSet row = submission.executeQuery()) {
                if (row.next()) {
                    if (!hash.equals(row.getString("REQUEST_HASH"))) return rejected("project-request-conflict");
                    return created(db, account, row.getInt("PROJECT_ID"));
                }
            }
        }
        try (PreparedStatement master = db.prepareStatement("SELECT SR_NO FROM FunctionMaster WHERE TRIM(FUNCTION_NAME)=? LIMIT 1")) {
            master.setString(1, function);
            try (ResultSet row = master.executeQuery()) {
                if (!row.next()) return rejected("project-function-unavailable");
            }
        }
        try (PreparedStatement duplicate = db.prepareStatement("SELECT SR_NO FROM ProjectData"
                + " WHERE CUSTOMERNAME=? AND PRODUCTSUIT=? AND PRODUCTTOOL=? AND PROJECTNAME=? AND FUNCTION_NAME=? LIMIT 1")) {
            duplicate.setString(1, customer);
            duplicate.setString(2, suite);
            duplicate.setString(3, tool);
            duplicate.setString(4, name);
            duplicate.setString(5, function);
            try (ResultSet row = duplicate.executeQuery()) {
                if (row.next()) return rejected("project-duplicate");
            }
        }
        int id;
        try (PreparedStatement latest = db.prepareStatement("SELECT SR_NO FROM ProjectData ORDER BY SR_NO DESC LIMIT 1 FOR UPDATE");
             ResultSet row = latest.executeQuery()) {
            int last = row.next() ? row.getInt(1) : 0;
            if (last < 0 || last == Integer.MAX_VALUE) throw new SQLException("SCM project ID limit reached");
            id = last + 1;
        }
        try (PreparedStatement write = db.prepareStatement("INSERT INTO ProjectData"
                + " (SR_NO,PROJECTNAME,FUNCTION_NAME,RESPONSIBILITY,PRODUCTSUIT,PRODUCTTOOL,CUSTOMERNAME,SUBMITTEDBY,Task_ID)"
                + " VALUES (?,?,?,?,?,?,?,?,?)");
             PreparedStatement grant = db.prepareStatement("INSERT INTO scm_mobile_project_access (LOGIN_ID,COMPANY_CODE,PROJECT_ID) VALUES (?,?,?)");
             PreparedStatement receipt = db.prepareStatement("INSERT INTO scm_mobile_project_submission"
                 + " (LOGIN_ID,COMPANY_CODE,REQUEST_KEY,REQUEST_HASH,PROJECT_ID) VALUES (?,?,?,?,?)")) {
            write.setInt(1, id);
            String[] fields = { name, function, responsibility, suite, tool, customer, account.fullname, customer + "-" + id };
            for (int index = 0; index < fields.length; index++) write.setString(index + 2, fields[index]);
            write.executeUpdate();
            bind(grant, account);
            grant.setInt(3, id);
            grant.executeUpdate();
            bind(receipt, account);
            receipt.setString(3, key);
            receipt.setString(4, hash);
            receipt.setInt(5, id);
            receipt.executeUpdate();
        }
        JSONObject result = created(db, account, id);
        if (!"project-created".equals(result.getString("kind"))) throw new SQLException("SCM project grant was not saved");
        return result;
    }

    private static JSONObject created(Connection db, Accounts.Account account, int id) throws SQLException {
        JSONObject result = Projects.detail(db, account, id);
        return result == null ? rejected("project-context-unavailable") : result.put("kind", "project-created");
    }

    private static JSONObject rejected(String reason) {
        return new JSONObject().put("kind", "rejected").put("reason", reason);
    }

    private static void bind(PreparedStatement statement, Accounts.Account account) throws SQLException {
        statement.setInt(1, account.id);
        statement.setString(2, account.companyCode);
    }

    private static String pattern(String query) {
        return "%" + query.trim().toLowerCase(Locale.ROOT).replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%";
    }
}
