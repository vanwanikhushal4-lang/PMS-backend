package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/** Requester views of legacy incidents. The caller supplies the verified account. */
final class PersonalIncidents {
    private static final int ACTIVITY_LIMIT = 20;
    private static final DateTimeFormatter LEGACY_DATE =
        DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss", Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter WIRE_DATE =
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss", Locale.ROOT);
    private static final String STATUS_COUNTS =
        "SELECT NULLIF(TRIM(STATUS), '') AS NAME, COUNT(*) AS QUANTITY FROM TICKET"
        + " WHERE T_REQUESTER=? AND T_COMPANY=? GROUP BY NULLIF(TRIM(STATUS), '') ORDER BY QUANTITY DESC, NAME";
    // The incident tracking table stores local wall-clock dates as text, without a zone.
    private static final String DATE_SORT = "CASE WHEN TRIM(t.ACTIVITY_DATE) REGEXP"
        + " '^[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}$'"
        + " THEN CONCAT(SUBSTRING(TRIM(t.ACTIVITY_DATE),7,4),SUBSTRING(TRIM(t.ACTIVITY_DATE),4,2),"
        + " SUBSTRING(TRIM(t.ACTIVITY_DATE),1,2),SUBSTRING(TRIM(t.ACTIVITY_DATE),12,8)) END";
    private static final String LATEST_ACTIVITY =
        "SELECT T_ID, ACTIVITY_DATE, STATUS, MESSAGE FROM ("
        + " SELECT scoped.*, ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY DATE_SORT DESC, SR_NO DESC) AS RANK_NO FROM ("
        + " SELECT t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE, t.SR_NO, " + DATE_SORT + " AS DATE_SORT"
        + " FROM TICKET_TRACKING t WHERE t.TICKET_RAISED_NAME=? AND t.TICKET_RAISED_NAME_COMPANY=?"
        + " AND t.T_ID IS NOT NULL AND TRIM(t.T_ID)<>''"
        + " AND EXISTS (SELECT 1 FROM TICKET i WHERE i.T_ID=t.T_ID AND i.T_REQUESTER=t.TICKET_RAISED_NAME"
        + " AND i.T_COMPANY=t.TICKET_RAISED_NAME_COMPANY)"
        + " ) scoped) ranked WHERE RANK_NO=1 ORDER BY DATE_SORT DESC, SR_NO DESC LIMIT " + ACTIVITY_LIMIT;

    private PersonalIncidents() {}

    static JSONObject read(Connection db, String username, String company) throws SQLException {
        JSONArray statuses = new JSONArray();
        try (PreparedStatement statement = requesterQuery(db, STATUS_COUNTS, username, company);
             ResultSet rows = statement.executeQuery()) {
            while (rows.next()) statuses.put(new JSONObject().put("status", nullable(rows.getString("NAME")))
                .put("count", rows.getLong("QUANTITY")));
        }
        JSONArray activity = new JSONArray();
        try (PreparedStatement statement = requesterQuery(db, LATEST_ACTIVITY, username, company);
             ResultSet rows = statement.executeQuery()) {
            while (rows.next()) activity.put(new JSONObject().put("incidentId", rows.getString("T_ID"))
                .put("date", activityDate(rows.getString("ACTIVITY_DATE")))
                .put("status", nullable(rows.getString("STATUS")))
                .put("message", nullable(rows.getString("MESSAGE"))));
        }
        return new JSONObject().put("kind", "workspace").put("statuses", statuses).put("activity", activity);
    }

    private static PreparedStatement requesterQuery(Connection db, String sql, String username, String company) throws SQLException {
        PreparedStatement statement = db.prepareStatement(sql);
        try {
            statement.setString(1, username);
            statement.setString(2, company);
            return statement;
        } catch (SQLException e) {
            statement.close();
            throw e;
        }
    }

    private static Object activityDate(String value) {
        if (value == null) return JSONObject.NULL;
        try { return LocalDateTime.parse(value.trim(), LEGACY_DATE).format(WIRE_DATE); }
        catch (DateTimeParseException e) { return JSONObject.NULL; }
    }

    private static Object nullable(String value) {
        return value == null || value.trim().isEmpty() ? JSONObject.NULL : value.trim();
    }
}
