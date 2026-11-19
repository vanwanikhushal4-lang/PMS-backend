package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class ProjectRecords {
    enum Kind {
        REQUIREMENT("requirement", "requirementDocument", "d.rd_id", "d.RDStatus", "''", new String[][]{
            {"purchaseOrder", "POnumber"}, {"suite", "productSuitName"}, {"tool", "securityTool"},
            {"function", "FunctionName"}, {"productManager", "productManager"}, {"submittedBy", "UserName"},
            {"designation", "Designation"}, {"description", "Description"}, {"requirementNote", "rdNote"}
        }),
        UNDERSTANDING("understanding", "UnderstandingDocument", "d.ud_id", "d.UDStatus", "''", new String[][]{
            {"purchaseOrder", "POnumber"}, {"requirementReference", "rd_id"}, {"suite", "productSuite"},
            {"tool", "securityTool"}, {"function", "FunctionName"}, {"productManager", "productManager"},
            {"teamLead", "Team_Leader"}, {"developers", "Developers"}, {"submittedBy", "Username"},
            {"designation", "Designation"}, {"start", "project_startDate"}, {"end", "project_endDate"},
            {"description", "Description"}, {"projectDescription", "projectDesc"}, {"objectives", "projectObj"},
            {"projectScope", "project_Scope"}, {"functional", "function_Requirement"},
            {"nonfunctional", "nonFunction_Requirement"}, {"technical", "technical_Requirement"},
            {"requirementNote", "rdNote"}, {"understandingNote", "udNote"}, {"rejectedBy", "rejectedByMD"},
            {"rejectedDate", "rejectedMDDate"}, {"rejectionReason", "rejectMDReason"}
        }),
        KICKOFF("kickoff", "ProjectKickOfMeeting", "''", "d.Status", "d.TypesMeeting", new String[][]{
            {"purchaseOrder", "Po_Number"}, {"understandingReference", "UD_number"}, {"projectHead", "ProjectHead"},
            {"salesManager", "SalesManager"}, {"productManager", "ProductionManager"},
            {"room", "TypesOfRooms"}, {"roomCapacity", "RoomCapacity"}, {"meetingResource", "MeetingResource"},
            {"attendees", "PersonInMetting"}, {"resources", "ResourceInMeeting"}, {"telephone", "TelephonicMeeting"},
            {"conference", "VideoConferenceMeeting"}, {"meetingLink", "GeneratedLink"}
        });

        final String key, table, reference, status, format;
        final String[][] details;
        Kind(String key, String table, String reference, String status, String format, String[][] details) {
            this.key = key; this.table = table; this.reference = reference; this.status = status; this.format = format;
            this.details = details;
        }

        String scopedFrom() {
            return " FROM scm_mobile_project_access a JOIN ProjectData p ON p.SR_NO=a.PROJECT_ID"
                + " JOIN scm_mobile_project_record l ON l.PROJECT_ID=a.PROJECT_ID AND l.COMPANY_CODE=a.COMPANY_CODE"
                + " JOIN " + table + " d ON d.SR_NO=l.RECORD_ID"
                + " WHERE a.LOGIN_ID=? AND a.COMPANY_CODE=? AND a.PROJECT_ID=? AND l.RECORD_KIND=?";
        }

        static Kind from(Object value) {
            for (Kind kind : values()) if (kind.key.equals(value)) return kind;
            return null;
        }
    }

    private ProjectRecords() {}

    static boolean validDetail(JSONObject input) {
        return input.length() == 3 && AssignedTasks.validId(input.opt("id")) && AssignedTasks.validId(input.opt("recordId"))
            && Kind.from(input.opt("scope")) != null;
    }

    static JSONObject list(Connection db, Accounts.Account account, int id) throws SQLException {
        if (Projects.detail(db, account, id) == null) return null;
        return new JSONObject().put("kind", "project-records").put("projectId", id)
            .put("requirements", group(db, account, id, Kind.REQUIREMENT))
            .put("understanding", group(db, account, id, Kind.UNDERSTANDING))
            .put("kickoff", group(db, account, id, Kind.KICKOFF));
    }

    private static JSONObject group(Connection db, Accounts.Account account, int id, Kind kind) throws SQLException {
        String sql = columns(kind) + kind.scopedFrom() + " ORDER BY d.SR_NO DESC LIMIT 21";
        try (PreparedStatement query = db.prepareStatement(sql)) {
            bindScope(query, account, id, kind);
            try (ResultSet rows = query.executeQuery()) {
                JSONArray items = new JSONArray();
                while (items.length() < 20 && rows.next()) items.put(summary(rows));
                return new JSONObject().put("items", items).put("hasMore", items.length() == 20 && rows.next());
            }
        }
    }

    static JSONObject detail(Connection db, Accounts.Account account, JSONObject input) throws SQLException {
        return detail(db, account, input, false);
    }

    static JSONObject detail(Connection db, Accounts.Account account, JSONObject input, boolean lock) throws SQLException {
        int project = input.getInt("id");
        Kind kind = Kind.from(input.get("scope"));
        StringBuilder sql = new StringBuilder(columns(kind));
        for (String[] field : kind.details) sql.append(", d.").append(field[1]);
        sql.append(kind.scopedFrom()).append(" AND l.RECORD_ID=?");
        if (lock) sql.append(" FOR UPDATE");
        try (PreparedStatement query = db.prepareStatement(sql.toString())) {
            bindScope(query, account, project, kind);
            query.setInt(5, input.getInt("recordId"));
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                JSONObject fields = new JSONObject();
                JSONArray snapshot = new JSONArray();
                for (String[] field : kind.details) {
                    String value = text(row, field[1]);
                    if (!value.isEmpty()) fields.put(field[0], value);
                    snapshot.put(value);
                }
                JSONObject item = summary(row);
                JSONObject response = new JSONObject().put("kind", "project-record-detail").put("projectId", project)
                    .put("scope", kind.key).put("item", item).put("fields", fields);
                if (ProjectReview.allowed(account, kind) && ProjectReview.pendingStatus(kind).equalsIgnoreCase(row.getString("RECORD_STATUS"))) {
                    JSONObject target = new JSONObject().put("scope", kind.key).put("id", project).put("recordId", item.getInt("id"));
                    Map<String, String> files = ProjectAttachments.filenames(db, account, ProjectAttachments.Target.parse(target, false));
                    if (files != null) response.put("review", ProjectReview.options(account, kind, project, item, snapshot, files));
                }
                return response;
            }
        }
    }

    static String columns(Kind kind) {
        return "SELECT d.SR_NO, " + kind.reference + " AS REFERENCE_CODE, " + kind.status + " AS RECORD_STATUS,"
            + " d.Date AS RECORD_DATE, " + kind.format + " AS MEETING_FORMAT";
    }

    static void bindScope(PreparedStatement query, Accounts.Account account, int id, Kind kind) throws SQLException {
        query.setInt(1, account.id);
        query.setString(2, account.companyCode);
        query.setInt(3, id);
        query.setString(4, kind.key);
    }

    static JSONObject summary(ResultSet row) throws SQLException {
        int id = row.getInt("SR_NO");
        String reference = text(row, "REFERENCE_CODE"), format = text(row, "MEETING_FORMAT");
        if (reference.isEmpty() && !format.isEmpty()) reference = "M-" + id;
        return new JSONObject().put("id", id)
            .put("reference", reference).put("date", text(row, "RECORD_DATE"))
            .put("status", text(row, "RECORD_STATUS")).put("format", format);
    }

    static String text(ResultSet row, String column) throws SQLException {
        String raw = row.getString(column);
        if (raw == null) return "";
        String value = raw.trim();
        switch (value.toLowerCase(Locale.ROOT)) {
            case "na": case "n/a": case "null": case "undefined": return "";
            default: return value;
        }
    }
}
