package com.velox.itsm.mobileauth;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

final class PublishedProjects {
    private static final int LIMIT = 30;
    private static final String REGISTERED_PHASE = " AND EXISTS (SELECT 1 FROM FunctionMaster exact_phase"
        + " WHERE TRIM(exact_phase.FUNCTION_NAME)=TRIM(t.FUNCTION_NAME))";
    private static final String PHASE_PREFIX = " AND LEFT(TRIM(t.FUNCTION_NAME),CHAR_LENGTH(?))=?"
        + " AND EXISTS(SELECT 1 FROM FunctionMaster chosen_phase WHERE TRIM(chosen_phase.FUNCTION_NAME)=?)";
    private static final String SUITE = " AND TRIM(t.PRODUCTSUIT)=?";
    private static final String TOOL = " AND TRIM(t.PRODUCTTOOL)=?";
    private static final String COMPLETED = " AND t.STATUS='Completed'";
    private static final String WEIGHT = "SUM(CASE WHEN TRIM(t.WEIGHTAGE) REGEXP '^[0-9]{1,9}([.][0-9]{1,6})?$'"
        + " THEN CAST(TRIM(t.WEIGHTAGE) AS DECIMAL(16,6)) ELSE 0 END)";
    static final String ORDER_SCOPE = " FROM scm_mobile_purchase_order_access g JOIN PurchaseOrder p ON p.SR_NO=g.PURCHASE_ORDER_ID";
    static final String ORDER_FILTER = " WHERE g.LOGIN_ID=? AND g.COMPANY_CODE=? AND p.vlx_id LIKE 'PO-%'";
    private static final String ORDER_FIELDS =
        "SELECT p.SR_NO,p.vlx_id,p.customername,p.ProductSuitName,p.SecurityToolName,p.purchaseNumber,p.purchaseDate,p.vlx_status";
    private static final String[][] MILESTONES = {
        {"Server availability", "SERVER_AVAILABILITY", "SERVER_RESPONSIBILITY", "SERVER_STARTDATE", "SERVER_ENDDATE"},
        {"Velox license installation", "INSTALL_VELOX_LICENSE", "RESPONSIBILTIY_VELOX_LICENSE", "VELOX_LICENSE_STARTDATE", "VELOX_LICENSE_ENDDATE"},
        {"UAT testing", "UAT_TESTING", "RESPONSIBILITY_UAT_TESTING", "UAT_STARTDATE", "UAT_ENDDATE"},
        {"Production go-live", "PRODUCT_GO_LIVE", "RESPONSIBILITY_PRODUCTGOLIVE", "PRODUCT_GO_LIVE_STARTDATE", "PRODUCT_GO_LIVE_ENDDATE"},
        {"Rollout", "ROLLOUT", "RSPOSINBILITY_ROLLOUT", "ROLLOUT_STARTDATE", "ROLLOUT_ENDDATE"},
        {"Live demo", "DEMO_LIVE", "RESPONSIBILTY_DEMOLIVE", "DEMOLIVE_STARTDATE", "DEMOLIVE_ENDDATE"},
        {"Payment terms", "PAYMENT_TERMS", "RESPONSIBILITY_PAYMENTTERMS", "PAYMENT_TERMS_STARTDATE", "PAYMENT_TERMS_ENDDATE"},
        {"Sign-off", "SIGNOFF", "RESPONSIBILTY_SIGNOFF", "SIGNOFF_STARTDATE", "SIGNOFF_ENDDATE"}
    };

    private PublishedProjects() {}

    static boolean valid(String action, JSONObject input) {
        boolean tree = action.endsWith("/tree");
        boolean orders = action.endsWith("/orders");
        if (!tree && !orders) {
            return AssignedTasks.validId(input.opt("id")) && (input.length() == 1
                || (action.endsWith("/tasks") && input.length() == 2 && AssignedTasks.validId(input.opt("before"))));
        }
        for (String key : input.keySet()) {
            switch (key) {
                case "phase": case "suite": case "tool":
                    if (!validLabel(input.opt(key), 240)) return false;
                    break;
                case "query":
                    if (!tree || !(input.opt(key) instanceof String) || input.getString(key).length() > 120) return false;
                    break;
                case "after":
                    if (!tree || !validLabel(input.opt(key), 240)) return false;
                    break;
                case "customer":
                    if (!orders || !validLabel(input.opt(key), 240)) return false;
                    break;
                case "before":
                    if (!orders || !AssignedTasks.validId(input.opt(key))) return false;
                    break;
                default: return false;
            }
        }
        if (input.has("suite") && !input.has("phase") || input.has("tool") && !input.has("suite")) return false;
        return tree || input.has("tool") && input.has("customer");
    }

    private static boolean validLabel(Object value, int limit) {
        return value instanceof String && !((String)value).trim().isEmpty() && ((String)value).length() <= limit;
    }

    static JSONObject tree(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        boolean customers = input.has("tool");
        boolean phases = !input.has("phase");
        String column = phases ? "TRIM(f.FUNCTION_NAME)" : customers ? "TRIM(t.CUSTOMERNAME)"
            : input.has("suite") ? "TRIM(t.PRODUCTTOOL)" : "TRIM(t.PRODUCTSUIT)";
        String sql = "SELECT " + (customers ? "" : "DISTINCT ") + column + " AS LABEL"
            + (customers ? "," + WEIGHT + " AS COMPLETED_WEIGHT" : "");
        if (phases) {
            sql += " FROM FunctionMaster f WHERE EXISTS(SELECT 1" + AssignedTasks.SCOPED + REGISTERED_PHASE
                + " AND LEFT(TRIM(t.FUNCTION_NAME),CHAR_LENGTH(TRIM(f.FUNCTION_NAME)))=TRIM(f.FUNCTION_NAME))";
        } else {
            sql += AssignedTasks.SCOPED + branch(input);
        }
        sql += " AND CHAR_LENGTH(" + column + ") BETWEEN 1 AND 240 AND LOWER(" + column + ") LIKE ? ESCAPE '!'";
        if (input.has("after")) sql += " AND " + column + ">?";
        if (customers) sql += " GROUP BY " + column + " HAVING " + WEIGHT + "<=100";
        sql += " ORDER BY LABEL LIMIT " + (LIMIT + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bind(query, account);
            int parameter = phases ? 3 : bindBranch(query, input);
            query.setString(parameter++, pattern(input.optString("query")));
            if (input.has("after")) query.setString(parameter, input.getString("after"));
            try (ResultSet rows = query.executeQuery()) {
                JSONArray items = new JSONArray();
                String last = "";
                while (items.length() < LIMIT && rows.next()) {
                    last = rows.getString("LABEL");
                    Object weight = customers ? rows.getBigDecimal("COMPLETED_WEIGHT").stripTrailingZeros().toPlainString() : JSONObject.NULL;
                    items.put(new JSONObject().put("label", last).put("completedWeight", weight));
                }
                return new JSONObject().put("kind", "publish-tree").put("items", items)
                    .put("next", items.length() == LIMIT && rows.next() ? last : JSONObject.NULL);
            }
        }
    }

    static JSONObject orders(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        String customer = input.getString("customer");
        try (PreparedStatement check = db.prepareStatement("SELECT TRIM(t.CUSTOMERNAME)" + AssignedTasks.SCOPED + branch(input)
                + " AND TRIM(t.CUSTOMERNAME)=? GROUP BY TRIM(t.CUSTOMERNAME) HAVING " + WEIGHT + "<=100")) {
            bind(check, account);
            check.setString(bindBranch(check, input), customer);
            try (ResultSet row = check.executeQuery()) { if (!row.next()) return null; }
        }
        int before = input.optInt("before");
        String sql = ORDER_FIELDS + ORDER_SCOPE + ORDER_FILTER + " AND TRIM(p.customername)=?"
            + (before == 0 ? "" : " AND p.SR_NO<?") + " ORDER BY p.SR_NO DESC LIMIT " + (LIMIT + 1);
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bind(query, account);
            query.setString(3, customer);
            if (before != 0) query.setInt(4, before);
            try (ResultSet rows = query.executeQuery()) {
                JSONArray orders = new JSONArray();
                int last = 0;
                while (orders.length() < LIMIT && rows.next()) {
                    orders.put(order(rows));
                    last = rows.getInt("SR_NO");
                }
                return new JSONObject().put("kind", "publish-orders").put("items", orders)
                    .put("next", orders.length() == LIMIT && rows.next() ? last : JSONObject.NULL);
            }
        }
    }

    static JSONObject detail(Connection db, Accounts.Account account, int id) throws SQLException {
        JSONObject item;
        try (PreparedStatement query = db.prepareStatement(ORDER_FIELDS + ",p.Form3_status,p.paymentterms,p.prodliscense,a.PROJECT_ID"
                + ORDER_SCOPE + " LEFT JOIN scm_mobile_project_access a ON a.PROJECT_ID=g.PROJECT_ID"
                + " AND a.LOGIN_ID=g.LOGIN_ID AND a.COMPANY_CODE=g.COMPANY_CODE" + ORDER_FILTER + " AND p.SR_NO=?")) {
            bind(query, account);
            query.setInt(3, id);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                int project = row.getInt("PROJECT_ID");
                item = order(row).put("formStatus", label(row, "Form3_status")).put("paymentTerms", label(row, "paymentterms"))
                    .put("license", label(row, "prodliscense")).put("projectId", project > 0 ? project : JSONObject.NULL);
            }
        }
        return new JSONObject().put("kind", "publish-order").put("item", item).put("formC", formC(db, account, id));
    }

    static boolean hasOrder(Connection db, Accounts.Account account, int id) throws SQLException {
        try (PreparedStatement query = db.prepareStatement("SELECT p.SR_NO" + ORDER_SCOPE + ORDER_FILTER + " AND p.SR_NO=?")) {
            bind(query, account);
            query.setInt(3, id);
            try (ResultSet row = query.executeQuery()) { return row.next(); }
        }
    }

    private static Object formC(Connection db, Accounts.Account account, int id) throws SQLException {
        StringBuilder select = new StringBuilder("SELECT d.PROJECT_NAME,d.T_Date,d.VP_status,d.SALES_MANAGER_NAME,d.CUSTOMER_IMPLEMENTOR_NAME,")
            .append("d.CUSTOMER_IMPLEMENTOR_CONTACT,d.CUSTOMER_IMPLEMENTOR_EMAIL,d.END_CUSTOMER_NAME,d.END_CUSTOMER_CONTACT,d.product_license");
        for (String[] milestone : MILESTONES) for (int i = 1; i < milestone.length; i++) select.append(",d.").append(milestone[i]);
        select.append(ORDER_SCOPE).append(" JOIN scm_mobile_purchase_order_form_c f ON f.PURCHASE_ORDER_ID=p.SR_NO"
            + " AND f.COMPANY_CODE=g.COMPANY_CODE JOIN FORM3 d ON d.SR_NO=f.FORM_C_ID AND d.VP_id=p.vlx_id")
            .append(ORDER_FILTER).append(" AND p.SR_NO=? ORDER BY d.SR_NO DESC LIMIT 1");
        try (PreparedStatement query = db.prepareStatement(select.toString())) {
            bind(query, account);
            query.setInt(3, id);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return JSONObject.NULL;
                JSONArray milestones = new JSONArray();
                for (String[] milestone : MILESTONES) {
                    String description = label(row, milestone[1]), owner = label(row, milestone[2]);
                    String start = label(row, milestone[3]), due = label(row, milestone[4]);
                    if (!description.isEmpty() || !owner.isEmpty() || !start.isEmpty() || !due.isEmpty()) {
                        milestones.put(new JSONObject().put("name", milestone[0]).put("description", description)
                            .put("responsibility", owner).put("start", start).put("due", due));
                    }
                }
                return new JSONObject().put("project", label(row, "PROJECT_NAME")).put("date", label(row, "T_Date"))
                    .put("status", label(row, "VP_status")).put("license", label(row, "product_license"))
                    .put("salesManager", label(row, "SALES_MANAGER_NAME")).put("implementor", label(row, "CUSTOMER_IMPLEMENTOR_NAME"))
                    .put("implementorPhone", label(row, "CUSTOMER_IMPLEMENTOR_CONTACT")).put("implementorEmail", label(row, "CUSTOMER_IMPLEMENTOR_EMAIL"))
                    .put("endCustomer", label(row, "END_CUSTOMER_NAME")).put("endCustomerPhone", label(row, "END_CUSTOMER_CONTACT"))
                    .put("milestones", milestones);
            }
        }
    }

    private static JSONObject order(ResultSet row) throws SQLException {
        return new JSONObject().put("id", row.getInt("SR_NO")).put("reference", label(row, "vlx_id"))
            .put("customer", label(row, "customername")).put("suite", label(row, "ProductSuitName")).put("tool", label(row, "SecurityToolName"))
            .put("number", label(row, "purchaseNumber")).put("date", label(row, "purchaseDate")).put("status", label(row, "vlx_status"));
    }

    private static String branch(JSONObject input) {
        return REGISTERED_PHASE + PHASE_PREFIX + (input.has("suite") ? SUITE : "") + (input.has("tool") ? TOOL + COMPLETED : "");
    }

    private static int bindBranch(PreparedStatement query, JSONObject input) throws SQLException {
        String phase = input.getString("phase");
        for (int i = 3; i <= 5; i++) query.setString(i, phase);
        int next = 6;
        if (input.has("suite")) query.setString(next++, input.getString("suite"));
        if (input.has("tool")) query.setString(next++, input.getString("tool"));
        return next;
    }

    private static void bind(PreparedStatement query, Accounts.Account account) throws SQLException {
        query.setInt(1, account.id);
        query.setString(2, account.companyCode);
    }

    private static String pattern(String value) {
        return "%" + value.trim().toLowerCase(Locale.ROOT).replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%";
    }

    private static String label(ResultSet row, String column) throws SQLException {
        String value = row.getString(column);
        if (value == null) return "";
        value = value.trim();
        if (!value.contains("%")) return value;
        try { return URLDecoder.decode(value.replace("+", "%2B"), StandardCharsets.UTF_8.name()); }
        catch (java.io.UnsupportedEncodingException impossible) { throw new IllegalStateException(impossible); }
        catch (IllegalArgumentException malformed) { return value; }
    }
}
