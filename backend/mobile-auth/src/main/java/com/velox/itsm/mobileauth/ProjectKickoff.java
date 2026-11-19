package com.velox.itsm.mobileauth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringJoiner;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProjectKickoff {
    private static final int PAGE = 40;
    private static final DateTimeFormatter INPUT_TIME = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter LEGACY_TIME = DateTimeFormatter.ofPattern("dd-MM-uuuu hh:mm a", Locale.ENGLISH);
    private static final List<String> ROOMS = Arrays.asList("SecureIT - 901", "ScanPlus - 906", "AssetGrid - 908", "Conference - 1st Floor");
    private static final List<String> PROVIDERS = Arrays.asList("zoom", "teams", "webex", "GMeet");
    private static final String CONTEXT = " FROM scm_mobile_project_access a"
        + " JOIN scm_mobile_project_record r ON r.PROJECT_ID=a.PROJECT_ID AND r.COMPANY_CODE=a.COMPANY_CODE AND r.RECORD_KIND='understanding'"
        + " JOIN UnderstandingDocument u ON u.SR_NO=r.RECORD_ID"
        + " JOIN scm_mobile_purchase_order_access g ON g.LOGIN_ID=a.LOGIN_ID AND g.COMPANY_CODE=a.COMPANY_CODE AND g.PROJECT_ID=a.PROJECT_ID"
        + " JOIN PurchaseOrder p ON p.SR_NO=g.PURCHASE_ORDER_ID AND p.vlx_id=u.POnumber"
        + " WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=? AND a.PROJECT_ID=? AND r.RECORD_ID=?"
        + " AND LOWER(u.UDStatus) IN ('ud approved by md','ud approved by si')";

    enum Group {
        HEADS("heads", "'collection_manager','head_projects'"), SALES("sales", "'sales_manager','sales_initiator'"),
        MANAGERS("managers", "'implementor','support_manager','project_manager'");
        final String key, roles;
        Group(String key, String roles) { this.key = key; this.roles = roles; }
    }

    private ProjectKickoff() {}

    static boolean allowed(Accounts.Account account) {
        if (!account.projectAccess) return false;
        String role = account.role.toLowerCase(Locale.ROOT);
        if (Arrays.asList("admin", "md", "head_projects").contains(role) && account.hasSidebarScope("PMS")) return true;
        if ("sales_manager".equals(role) && account.hasSidebarScope("Project_Kick_Meeting_Approval")) return true;
        return Arrays.asList("business_head", "sales_initiator", "md").contains(role) && account.hasSidebarScope("Project_Kick_Of_Meeting");
    }

    static boolean validOptions(JSONObject input) {
        return input.length() == (input.has("query") ? 3 : 2) && AssignedTasks.validId(input.opt("id"))
            && AssignedTasks.validId(input.opt("recordId")) && (!input.has("query") || text(input.opt("query"), 120, true));
    }

    static boolean validDraft(JSONObject input, ZoneId zone) {
        if (!AssignedTasks.validId(input.opt("id")) || !AssignedTasks.validId(input.opt("recordId"))
            || !(input.opt("requestKey") instanceof String) || !input.getString("requestKey").matches("[A-Za-z0-9_-]{20,64}")
            || !text(input.opt("time"), 16, false)) return false;
        try {
            LocalDateTime date = LocalDateTime.parse(input.getString("time"), INPUT_TIME);
            if (zone.getRules().getValidOffsets(date).size() != 1) return false;
        } catch (DateTimeParseException failure) { return false; }
        for (Group group : Group.values()) if (ids(input.optJSONArray(group.key)) == null) return false;
        if ("Physical Mode".equals(input.opt("mode"))) {
            JSONArray rooms = input.optJSONArray("rooms");
            if (input.length() != 9 || rooms == null || rooms.length() > ROOMS.size()) return false;
            Set<String> unique = new HashSet<>();
            for (int i = 0; i < rooms.length(); i++) if (!(rooms.opt(i) instanceof String) || !ROOMS.contains(rooms.getString(i)) || !unique.add(rooms.getString(i))) return false;
            return true;
        }
        return input.length() == 10 && "Virtual Mode".equals(input.opt("mode")) && PROVIDERS.contains(input.opt("provider"))
            && text(input.opt("connection"), 255, false);
    }

    static JSONObject options(Connection db, Accounts.Account account, JSONObject input, ZoneId zone) throws SQLException {
        Context context = context(db, account, input, false);
        if (context == null) return null;
        JSONObject result = new JSONObject().put("kind", "kickoff-options").put("projectId", input.getInt("id"))
            .put("recordId", input.getInt("recordId")).put("purchaseOrder", context.purchaseOrder).put("understanding", context.understanding)
            .put("kickoffStatus", context.status).put("timeZone", zone.getId()).put("rooms", new JSONArray(ROOMS)).put("providers", new JSONArray(PROVIDERS));
        String pattern = "%" + input.optString("query").trim().toLowerCase(Locale.ROOT).replace("!", "!!").replace("%", "!%").replace("_", "!_") + "%";
        for (Group group : Group.values()) {
            String sql = "SELECT l.LOGINID,l.FULL_NAME FROM LOGINMASTER l WHERE l.COMPANY=? AND LOWER(l.ROLE_TYPE) IN (" + group.roles + ")"
                + " AND CHAR_LENGTH(TRIM(l.FULL_NAME)) BETWEEN 1 AND 128 AND LOWER(l.FULL_NAME) LIKE ? ESCAPE '!'"
                + " AND NOT EXISTS(SELECT 1 FROM scm_mobile_account m WHERE m.LOGIN_ID=l.LOGINID AND m.COMPANY_CODE=? AND m.ENABLED=FALSE)"
                + " ORDER BY l.FULL_NAME,l.LOGINID LIMIT " + (PAGE + 1);
            try (PreparedStatement query = db.prepareStatement(sql)) {
                query.setString(1, account.companyName); query.setString(2, pattern); query.setString(3, account.companyCode);
                try (ResultSet row = query.executeQuery()) {
                    JSONArray people = new JSONArray();
                    while (people.length() < PAGE && row.next()) people.put(new JSONObject().put("id", row.getInt(1)).put("name", row.getString(2).trim()));
                    result.put(group.key, people).put(group.key + "More", people.length() == PAGE && row.next());
                }
            }
        }
        return result;
    }

    static JSONObject schedule(Connection db, Accounts.Account account, KickoffFiles.Upload upload) throws SQLException, IOException {
        db.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        db.setAutoCommit(false);
        boolean committing = false;
        try {
            // Serialize mobile allocation and retries. Legacy MAX+1 collisions are retried by Accounts.
            try (PreparedStatement lock = db.prepareStatement("SELECT ID FROM scm_mobile_kickoff_lock WHERE ID=1 FOR UPDATE"); ResultSet row = lock.executeQuery()) {
                if (!row.next()) throw new SQLException("SCM kickoff allocation is not provisioned");
            }
            JSONObject input = upload.details;
            Context context = context(db, account, input, true);
            if (context == null) { db.rollback(); return null; }
            String hash = fingerprint(input, upload);
            try (PreparedStatement query = db.prepareStatement("SELECT REQUEST_HASH,PROJECT_ID,RECORD_ID,MEETING_ID FROM scm_mobile_kickoff_submission"
                    + " WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REQUEST_KEY=?")) {
                bindActor(query, account); query.setString(3, input.getString("requestKey"));
                try (ResultSet row = query.executeQuery()) {
                    if (row.next()) {
                        boolean same = hash.equals(row.getString(1)) && row.getInt(2) == input.getInt("id") && row.getInt(3) == input.getInt("recordId");
                        JSONObject result = same ? scheduled(input, row.getInt(4)) : rejected("kickoff-conflict");
                        db.rollback();
                        return result;
                    }
                }
            }
            List<String> names = new ArrayList<>();
            for (Group group : Group.values()) {
                String selected = selectedNames(db, account, group, ids(input.getJSONArray(group.key)));
                if (selected == null) { db.rollback(); return rejected("kickoff-participants-unavailable"); }
                names.add(selected);
            }
            int id;
            try (PreparedStatement query = db.prepareStatement("SELECT SR_NO FROM ProjectKickOfMeeting ORDER BY SR_NO DESC LIMIT 1 FOR UPDATE"); ResultSet row = query.executeQuery()) {
                int last = row.next() ? row.getInt(1) : 0;
                if (last < 0 || last == Integer.MAX_VALUE) throw new SQLException("SCM meeting ID limit reached");
                id = last + 1;
            }
            upload.publish();
            String mode = input.getString("mode");
            try (PreparedStatement write = db.prepareStatement("INSERT INTO ProjectKickOfMeeting"
                    + " (SR_NO,ProjectHead,SalesManager,ProductionManager,Date,TypesMeeting,TypesOfRooms,VideoConferenceMeeting,GeneratedLink,UploadFile1,UploadFile2,Status,Po_Number,UD_number)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                write.setInt(1, id);
                String[] values = { names.get(0), names.get(1), names.get(2), LEGACY_TIME.format(LocalDateTime.parse(input.getString("time"), INPUT_TIME)), mode,
                    "Physical Mode".equals(mode) ? join(input.getJSONArray("rooms")) : "", input.optString("provider"), input.optString("connection"),
                    upload.agenda.storageName, upload.plan == null ? "" : upload.plan.storageName, "Meeting Scheduled", context.purchaseOrder, context.understanding };
                for (int i = 0; i < values.length; i++) write.setString(i + 2, values[i]);
                write.executeUpdate();
            }
            try (PreparedStatement link = db.prepareStatement("INSERT INTO scm_mobile_project_record (PROJECT_ID,COMPANY_CODE,RECORD_KIND,RECORD_ID) VALUES (?,?,'kickoff',?)");
                 PreparedStatement po = db.prepareStatement("UPDATE PurchaseOrder SET KOM_Status='Meeting Scheduled' WHERE SR_NO=?");
                 PreparedStatement receipt = db.prepareStatement("INSERT INTO scm_mobile_kickoff_submission"
                     + " (LOGIN_ID,COMPANY_CODE,REQUEST_KEY,REQUEST_HASH,PROJECT_ID,RECORD_ID,MEETING_ID) VALUES (?,?,?,?,?,?,?)")) {
                link.setInt(1, input.getInt("id")); link.setString(2, account.companyCode); link.setInt(3, id); link.executeUpdate();
                po.setInt(1, context.orderId);
                if (po.executeUpdate() != 1) throw new SQLException("SCM purchase order changed while scheduling");
                upload.metadata(db, account.companyCode, id);
                bindActor(receipt, account); receipt.setString(3, input.getString("requestKey")); receipt.setString(4, hash);
                receipt.setInt(5, input.getInt("id")); receipt.setInt(6, input.getInt("recordId")); receipt.setInt(7, id); receipt.executeUpdate();
            }
            committing = true;
            db.commit();
            upload.retain();
            return scheduled(input, id);
        } catch (SQLException | IOException | RuntimeException failure) {
            // An interrupted COMMIT may have succeeded. Preserve files for reconciliation in that case.
            if (committing) upload.retain();
            try { db.rollback(); } catch (SQLException rollback) { failure.addSuppressed(rollback); }
            throw failure;
        }
    }

    private static Context context(Connection db, Accounts.Account account, JSONObject input, boolean lock) throws SQLException {
        try (PreparedStatement query = db.prepareStatement("SELECT p.SR_NO,p.vlx_id,p.KOM_Status,u.ud_id" + CONTEXT + (lock ? " FOR UPDATE" : ""))) {
            bindActor(query, account); query.setInt(3, input.getInt("id")); query.setInt(4, input.getInt("recordId"));
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                Context context = new Context(row.getInt(1), ProjectRecords.text(row, "vlx_id"), ProjectRecords.text(row, "ud_id"), ProjectRecords.text(row, "KOM_Status"));
                return context.purchaseOrder.isEmpty() || context.understanding.isEmpty() || row.next() ? null : context;
            }
        }
    }

    private static String selectedNames(Connection db, Accounts.Account account, Group group, List<Integer> ids) throws SQLException {
        String sql = "SELECT l.FULL_NAME FROM LOGINMASTER l WHERE l.COMPANY=? AND LOWER(l.ROLE_TYPE) IN (" + group.roles + ")"
            + " AND l.LOGINID IN (" + String.join(",", Collections.nCopies(ids.size(), "?")) + ")"
            + " AND NOT EXISTS(SELECT 1 FROM scm_mobile_account m WHERE m.LOGIN_ID=l.LOGINID AND m.COMPANY_CODE=? AND m.ENABLED=FALSE)"
            + " ORDER BY l.LOGINID FOR UPDATE";
        try (PreparedStatement query = db.prepareStatement(sql)) {
            query.setString(1, account.companyName);
            for (int i = 0; i < ids.size(); i++) query.setInt(i + 2, ids.get(i));
            query.setString(ids.size() + 2, account.companyCode);
            try (ResultSet row = query.executeQuery()) {
                StringJoiner names = new StringJoiner(",");
                int count = 0;
                while (row.next()) {
                    String name = row.getString(1);
                    if (name == null || !text(name.trim(), 128, false)) return null;
                    names.add(name.trim()); count++;
                }
                return count == ids.size() && names.length() <= 255 ? names.toString() : null;
            }
        }
    }

    private static List<Integer> ids(JSONArray input) {
        if (input == null || input.length() < 1 || input.length() > PAGE) return null;
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!AssignedTasks.validId(input.opt(i)) || !unique.add(input.getInt(i))) return null;
        }
        List<Integer> sorted = new ArrayList<>(unique); Collections.sort(sorted); return sorted;
    }

    private static boolean text(Object raw, int max, boolean empty) {
        if (!(raw instanceof String)) return false;
        String value = (String) raw;
        return value.length() <= max && (empty || !value.trim().isEmpty()) && value.codePoints().noneMatch(Character::isISOControl);
    }

    private static String fingerprint(JSONObject input, KickoffFiles.Upload upload) {
        JSONArray values = new JSONArray().put(input.getInt("id")).put(input.getInt("recordId")).put(input.getString("time")).put(input.getString("mode"));
        for (Group group : Group.values()) values.put(new JSONArray(ids(input.getJSONArray(group.key))));
        if ("Physical Mode".equals(input.getString("mode"))) {
            List<String> rooms = new ArrayList<>(); for (Object room : input.getJSONArray("rooms")) rooms.add((String) room);
            Collections.sort(rooms); values.put(new JSONArray(rooms));
        } else values.put(input.getString("provider")).put(input.getString("connection"));
        values.put(upload.agenda.fingerprint()).put(upload.plan == null ? JSONObject.NULL : upload.plan.fingerprint());
        return Secrets.tokenHash(values.toString());
    }
    private static String join(JSONArray values) { StringJoiner joined = new StringJoiner(","); for (Object value : values) joined.add((String) value); return joined.toString(); }
    private static void bindActor(PreparedStatement query, Accounts.Account account) throws SQLException { query.setInt(1, account.id); query.setString(2, account.companyCode); }
    private static JSONObject scheduled(JSONObject input, int id) { return new JSONObject().put("kind", "kickoff-scheduled").put("projectId", input.getInt("id")).put("recordId", input.getInt("recordId")).put("meetingId", id); }
    private static JSONObject rejected(String reason) { return new JSONObject().put("kind", "rejected").put("reason", reason); }
    private static final class Context {
        final int orderId; final String purchaseOrder, understanding, status;
        Context(int id, String po, String ud, String status) { this.orderId = id; this.purchaseOrder = po; this.understanding = ud; this.status = status; }
    }
}
