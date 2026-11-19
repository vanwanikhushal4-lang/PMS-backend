package com.velox.itsm.mobileauth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.metadata.ClassMetadata;
import org.json.JSONObject;

/** Writes through the SCM entity to share its ID generator with the JSP application. */
final class TaskProgress {
    private static final String ENTITY = "com.velox.itsm.model.Update_Todays_Progress";
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd.MM.uuuu", Locale.ROOT);
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm", Locale.ROOT);
    private static final String TASK = "SELECT t.STATUS, t.FUNCTION_NAME, t.MODULE_NAME, t.CUSTOMERNAME,"
        + " t.PRODUCTTOOL, t.PRODUCTSUIT, t.DESCRIPTION" + AssignedTasks.OWNED_HISTORY + " AND t.SR_NO=?";

    private TaskProgress() {}

    enum Result { SAVED, MISSING, DUPLICATE, CLOSED }

    static LocalDateTime localTime(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    static String date(LocalDateTime now) { return DATE.format(now); }
    static String timestamp(LocalDateTime now) { return TIMESTAMP.format(now); }

    static boolean hasEntry(Connection db, int taskId, String day) throws SQLException {
        try (PreparedStatement query = db.prepareStatement(
                "SELECT 1 FROM Update_Todays_Progress WHERE TASK_ID=? AND DATE=? LIMIT 1")) {
            query.setString(1, Integer.toString(taskId));
            query.setString(2, day);
            try (ResultSet row = query.executeQuery()) { return row.next(); }
        }
    }

    @SuppressWarnings("deprecation")
    static Result apply(Connection db, SessionFactory factory, Accounts.Account account,
                        int taskId, String note, LocalDateTime now) throws SQLException {
        // A null note is the separate completion operation.
        boolean completing = note == null;
        String day = date(now);
        try (Session session = factory.withOptions().connection(db).openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ClassMetadata mapping = factory.getClassMetadata(ENTITY);
                Result result = write(db, session, mapping, account, taskId, note, now, day);
                transaction.commit();
                return result;
            } catch (SQLException | RuntimeException failure) {
                if (transaction.getStatus().canRollback()) transaction.rollback();
                if (!completing && failure instanceof ConstraintViolationException
                        && visibleDuplicate(db, account, taskId, day)) return Result.DUPLICATE;
                if (failure instanceof SQLException) throw (SQLException) failure;
                throw new SQLException("SCM work log write failed", failure);
            }
        }
    }

    private static Result write(Connection db, Session session, ClassMetadata mapping, Accounts.Account account,
                                int taskId, String note, LocalDateTime now, String day) throws SQLException {
        boolean completing = note == null;
        Object entry;
        try (PreparedStatement query = db.prepareStatement(TASK + " FOR UPDATE")) {
            AssignedTasks.bind(query, account);
            query.setInt(4, taskId);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return Result.MISSING;
                if ("Completed".equalsIgnoreCase(row.getString("STATUS"))) return completing ? Result.SAVED : Result.CLOSED;
                entry = workLogEntry(mapping, row, account.fullname, taskId, note, day);
            }
        }
        if (!completing && hasEntry(db, taskId, day)) return Result.DUPLICATE;
        if (completing) {
            try (PreparedStatement update = db.prepareStatement("UPDATE DaywiseTask SET STATUS='Completed', TaskUpdateDate=? WHERE SR_NO=?")) {
                update.setString(1, timestamp(now));
                update.setInt(2, taskId);
                if (update.executeUpdate() != 1) throw new SQLException("SCM task was not updated");
            }
        }
        session.save(ENTITY, entry);
        session.flush();
        return Result.SAVED;
    }

    private static Object workLogEntry(ClassMetadata mapping, ResultSet task, String name, int id, String note, String day) throws SQLException {
        Object entry = LegacyRecord.create(mapping);
        boolean completing = note == null;
        mapping.setPropertyValue(entry, "TASK_ID", Integer.toString(id));
        mapping.setPropertyValue(entry, "FUNCTION_NAME", task.getString("FUNCTION_NAME"));
        mapping.setPropertyValue(entry, "MODULE_NAME", task.getString("MODULE_NAME"));
        mapping.setPropertyValue(entry, "CUSTOMER_NAME", task.getString("CUSTOMERNAME"));
        mapping.setPropertyValue(entry, "PRODUCT_NAME", task.getString(completing ? "PRODUCTSUIT" : "PRODUCTTOOL"));
        mapping.setPropertyValue(entry, "PRODUCT_SUITE", task.getString(completing ? "PRODUCTTOOL" : "PRODUCTSUIT"));
        mapping.setPropertyValue(entry, "TASK_DESC", task.getString("DESCRIPTION"));
        mapping.setPropertyValue(entry, "DATE", day);
        mapping.setPropertyValue(entry, "TODAYS_PROGRESS", completing ? "Task Completed" : note);
        mapping.setPropertyValue(entry, "FULL_NAME", name);
        mapping.setPropertyValue(entry, "TASK_TYPE", "General");
        mapping.setPropertyValue(entry, "STATUS", completing ? "Completed" : "In-Progress");
        return entry;
    }

    private static boolean visibleDuplicate(Connection db, Accounts.Account account, int taskId, String day) throws SQLException {
        try (PreparedStatement query = db.prepareStatement(TASK)) {
            AssignedTasks.bind(query, account);
            query.setInt(4, taskId);
            try (ResultSet row = query.executeQuery()) { return row.next() && hasEntry(db, taskId, day); }
        }
    }
}
