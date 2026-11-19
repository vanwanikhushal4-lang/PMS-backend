package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class TaskRoster {
    private static final String MEMBER = " JOIN scm_mobile_account a ON a.LOGIN_ID=l.LOGINID"
        + " WHERE a.COMPANY_CODE=? AND a.ENABLED=TRUE AND l.COMPANY=? AND l.FULL_NAME IS NOT NULL"
        + " AND NOT EXISTS(SELECT 1 FROM LOGINMASTER d WHERE d.COMPANY=l.COMPANY AND d.FULL_NAME=l.FULL_NAME AND d.LOGINID<>l.LOGINID)";
    private static final String ROSTER =
        "SELECT Developer, Team_Leader, ImplementerName, 0 AS SUPPORT FROM TlMaster"
        + " WHERE Customer_name=? AND PRODUCT_SUIT=? AND SECURITY_SOLTION=?"
        + " UNION ALL SELECT Developer, Team_Leader, ImplementerName, 1 AS SUPPORT FROM TlMasterSupport"
        + " WHERE Customer_name=? AND PRODUCT_SUIT=? AND SECURITY_SOLTION=?";
    private static final String CONTEXT_ROSTER =
        "SELECT Customer_name,PRODUCT_SUIT,SECURITY_SOLTION,Developer,Team_Leader,ImplementerName,0 AS SUPPORT FROM TlMaster"
        + " UNION ALL SELECT Customer_name,PRODUCT_SUIT,SECURITY_SOLTION,Developer,Team_Leader,ImplementerName,1 AS SUPPORT FROM TlMasterSupport";

    private TaskRoster() {}

    static boolean role(String first, String second) { return first.equalsIgnoreCase(second); }

    static boolean manager(Accounts.Account actor) {
        return role(actor.role, "Implementor") || role(actor.role, "Support_Manager") || role(actor.role, "Support Manager");
    }

    static boolean canCreate(Accounts.Account actor) {
        return manager(actor) || role(actor.role, "Developer") || role(actor.role, "Tester") || role(actor.role, "Support");
    }

    private static boolean teamLead(Accounts.Account actor) {
        return (role(actor.role, "Developer") || role(actor.role, "Tester") || role(actor.role, "Support"))
            && (role(actor.designation, "Team Leader") || role(actor.designation, "Jr. Team Leader") || role(actor.designation, "Sr Team Leader"));
    }

    static boolean standaloneProfile(Connection db, Accounts.Account actor) throws SQLException {
        // The legacy roster names people without an account ID or company.
        try (PreparedStatement query = db.prepareStatement("SELECT l.LOGINID FROM LOGINMASTER l" + MEMBER
                + " AND l.LOGINID=? AND NOT EXISTS(SELECT 1 FROM LOGINMASTER d WHERE d.FULL_NAME=l.FULL_NAME AND d.LOGINID<>l.LOGINID)")) {
            query.setString(1, actor.companyCode);
            query.setString(2, actor.companyName);
            query.setInt(3, actor.id);
            try (ResultSet row = query.executeQuery()) { return row.next(); }
        }
    }

    static JSONObject contexts(Connection db, Accounts.Account actor, String term) throws SQLException {
        JSONArray items = new JSONArray();
        String sql = "SELECT DISTINCT r.Customer_name,r.PRODUCT_SUIT,r.SECURITY_SOLTION FROM (" + CONTEXT_ROSTER + ") r"
            + " JOIN LOGINMASTER l ON l.FULL_NAME=r.Developer" + MEMBER
            + " AND ((r.SUPPORT=1 AND LOWER(l.ROLE_TYPE)='support') OR (r.SUPPORT=0 AND LOWER(l.ROLE_TYPE) IN ('developer','tester')))"
            + " AND (l.LOGINID=? OR LOWER(r.ImplementerName)=? OR LOWER(r.Team_Leader)=?)"
            + " AND CHAR_LENGTH(TRIM(r.Customer_name)) BETWEEN 1 AND 240 AND CHAR_LENGTH(TRIM(r.PRODUCT_SUIT)) BETWEEN 1 AND 240"
            + " AND CHAR_LENGTH(TRIM(r.SECURITY_SOLTION)) BETWEEN 1 AND 240"
            + " AND LOWER(CONCAT_WS(' ',r.Customer_name,r.PRODUCT_SUIT,r.SECURITY_SOLTION)) LIKE ? ESCAPE '!'"
            + " ORDER BY r.Customer_name,r.PRODUCT_SUIT,r.SECURITY_SOLTION LIMIT 31";
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setString(1, actor.companyCode);
            query.setString(2, actor.companyName);
            query.setInt(3, actor.id);
            String name = actor.fullname.toLowerCase(Locale.ROOT);
            query.setString(4, manager(actor) ? name : null);
            query.setString(5, teamLead(actor) ? name : null);
            query.setString(6, "%" + term.toLowerCase(Locale.ROOT).replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%");
            try (ResultSet rows = query.executeQuery()) {
                while (rows.next()) {
                    if (items.length() == 30) return new JSONObject().put("items", items).put("hasMore", true);
                    items.put(new JSONObject().put("customer", label(rows, "Customer_name"))
                        .put("suite", label(rows, "PRODUCT_SUIT")).put("tool", label(rows, "SECURITY_SOLTION")));
                }
            }
        }
        return new JSONObject().put("items", items).put("hasMore", false);
    }

    static List<Candidate> forProject(Connection db, Accounts.Account actor, String customer, String suite, String tool) throws SQLException {
        Map<String, Candidate> candidates = new LinkedHashMap<>();
        for (Candidate candidate : roster(db, actor, customer, suite, tool)) {
            if (candidate.id == actor.id || (manager(actor) && role(actor.fullname, candidate.manager))
                    || (teamLead(actor) && role(actor.fullname, candidate.lead))) {
                candidates.put(candidate.key(), candidate);
            }
            if (manager(actor) && role(actor.fullname, candidate.manager)) {
                Candidate self = new Candidate(actor.id, actor.fullname, actor.role, "", actor.fullname);
                candidates.put(self.key(), self);
            }
        }
        return new ArrayList<>(candidates.values());
    }

    static List<Candidate> forReassignment(Connection db, Accounts.Account actor, TaskAssignments.Task task) throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        String wanted = role(actor.role, "Tester") ? "Tester"
            : role(actor.role, "Support") || role(actor.role, "Support_Manager") || role(actor.role, "Support Manager") ? "Support" : "Developer";
        for (Candidate candidate : roster(db, actor, task.customer, task.suite, task.tool)) {
            if (role(candidate.role, wanted) && !role(candidate.name, task.assignee)
                    && (task.lead.isEmpty() || "NA".equalsIgnoreCase(task.lead) || role(candidate.lead, task.lead))
                    && (task.manager.isEmpty() || "NA".equalsIgnoreCase(task.manager) || role(candidate.manager, task.manager))) {
                candidates.add(candidate);
            }
        }
        return candidates;
    }

    static Candidate find(List<Candidate> roster, String key) {
        for (Candidate candidate : roster) if (candidate.key().equals(key)) return candidate;
        return null;
    }

    static JSONObject options(List<Candidate> roster, String term) {
        String query = term.toLowerCase(Locale.ROOT);
        JSONArray items = new JSONArray();
        Map<String, Candidate> distinct = new LinkedHashMap<>();
        for (Candidate candidate : roster) distinct.put(candidate.key(), candidate);
        for (Candidate candidate : distinct.values()) {
            if (!candidate.name.toLowerCase(Locale.ROOT).contains(query)) continue;
            if (items.length() == 30) return new JSONObject().put("items", items).put("hasMore", true);
            items.put(new JSONObject().put("key", candidate.key()).put("name", candidate.name)
                .put("role", candidate.role).put("lead", candidate.lead).put("manager", candidate.manager));
        }
        return new JSONObject().put("items", items).put("hasMore", false);
    }

    static int profileId(Connection db, Accounts.Account actor, String name) throws SQLException {
        if (name.isEmpty()) return 0;
        try (PreparedStatement query = db.prepareStatement("SELECT l.LOGINID FROM LOGINMASTER l" + MEMBER + " AND l.FULL_NAME=?")) {
            query.setString(1, actor.companyCode);
            query.setString(2, actor.companyName);
            query.setString(3, name);
            try (ResultSet row = query.executeQuery()) { return row.next() ? row.getInt(1) : 0; }
        }
    }

    private static List<Candidate> roster(Connection db, Accounts.Account actor, String customer, String suite, String tool) throws SQLException {
        List<Candidate> options = new ArrayList<>();
        if (customer.isEmpty() || suite.isEmpty() || tool.isEmpty()) return options;
        String sql = "SELECT l.LOGINID,l.FULL_NAME,l.ROLE_TYPE,r.Team_Leader,r.ImplementerName,r.SUPPORT"
            + " FROM (" + ROSTER + ") r JOIN LOGINMASTER l ON l.FULL_NAME=r.Developer"
            + MEMBER
            + " ORDER BY l.FULL_NAME,l.LOGINID,r.Team_Leader,r.ImplementerName";
        try (PreparedStatement query = db.prepareStatement(sql)) {
            for (int parameter : new int[]{1, 4}) {
                query.setString(parameter, customer);
                query.setString(parameter + 1, suite);
                query.setString(parameter + 2, tool);
            }
            query.setString(7, actor.companyCode);
            query.setString(8, actor.companyName);
            try (ResultSet rows = query.executeQuery()) {
                while (rows.next()) {
                    String role = label(rows, "ROLE_TYPE");
                    if (rows.getBoolean("SUPPORT") ? role(role, "Support") : role(role, "Developer") || role(role, "Tester")) {
                        options.add(new Candidate(rows.getInt("LOGINID"), label(rows, "FULL_NAME"), role,
                            label(rows, "Team_Leader"), label(rows, "ImplementerName")));
                    }
                }
            }
        }
        return options;
    }

    static String label(ResultSet row, String column) throws SQLException {
        String value = row.getString(column);
        return value == null ? "" : value.trim();
    }

    static final class Candidate {
        final int id;
        final String name, role, lead, manager;

        Candidate(int id, String name, String role, String lead, String manager) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.lead = lead;
            this.manager = manager;
        }

        String key() {
            return Secrets.tokenHash(new JSONArray().put(id).put(name).put(role).put(lead).put(manager).toString());
        }
    }
}
