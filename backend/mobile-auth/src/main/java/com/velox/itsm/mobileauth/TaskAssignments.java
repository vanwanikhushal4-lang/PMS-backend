package com.velox.itsm.mobileauth;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.util.HtmlUtils;

final class TaskAssignments {
    private static final String TASK_FIELDS = "SELECT t.STATUS,t.CUSTOMERNAME,t.PRODUCTSUIT,t.PRODUCTTOOL,"
        + "t.DEVELOPER_NAME,t.TEAM_LEADER,t.MANAGER_NAME,t.updateDate_Status" + AssignedTasks.SCOPED;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final String[] DRAFT_TEXT = {"module", "description", "start", "due", "priority", "weight", "candidate", "requestKey"};
    private static final List<String> FUNCTIONS = java.util.Arrays.asList("Development", "Testing", "POC", "UAT", "Implementation", "Go Live", "Other");
    static final List<String> RESPONSIBILITIES = java.util.Collections.unmodifiableList(java.util.Arrays.asList("Velox Solution", "End Customer"));
    private static final String GRANT = "INSERT INTO scm_mobile_task_access (LOGIN_ID,COMPANY_CODE,TASK_ID) VALUES (?,?,?)"
        + " ON DUPLICATE KEY UPDATE LOGIN_ID=?";

    private TaskAssignments() {}

    static JSONObject options(Connection db, Accounts.Account actor, int id, String search, boolean project) throws SQLException {
        if (TaskRoster.profileId(db, actor, actor.fullname) != actor.id) return null;
        if (project) {
            JSONObject found = Projects.detail(db, actor, id);
            if (found == null) return null;
            JSONObject item = found.getJSONObject("item");
            return TaskRoster.options(projectRoster(db, actor, item), search)
                .put("kind", "task-assignees").put("id", id).put("revision", JSONObject.NULL);
        }
        Task task = load(db, actor, id, false);
        if (task == null || !task.editable(actor)) return null;
        return TaskRoster.options(TaskRoster.forReassignment(db, actor, task), search)
            .put("kind", "task-assignees").put("id", id).put("revision", task.revision(id));
    }

    static boolean validDraft(JSONObject input) {
        if (input.has("id")) {
            if (input.length() != 1 + DRAFT_TEXT.length || !AssignedTasks.validId(input.opt("id"))) return false;
        } else if (input.length() != 3 + DRAFT_TEXT.length || !validContext(input.optJSONObject("context"))
                || !FUNCTIONS.contains(input.opt("function")) || !RESPONSIBILITIES.contains(input.opt("responsibility"))) {
            return false;
        }
        for (String key : DRAFT_TEXT) if (!(input.opt(key) instanceof String)) return false;
        String module = text(input, "module");
        String description = text(input, "description");
        java.time.LocalDate start = TaskDates.parse(text(input, "start")), due = TaskDates.parse(text(input, "due"));
        String priority = text(input, "priority");
        String weight = text(input, "weight");
        return !module.isEmpty() && module.length() <= 120 && !description.isEmpty() && description.length() <= 255
            && start != null && due != null && !due.isBefore(start)
            && ("Low".equals(priority) || "Normal".equals(priority) || "High".equals(priority) || "Immediate".equals(priority))
            && weight.matches("[0-9]{1,3}([.][0-9]{1,2})?") && new BigDecimal(weight).compareTo(HUNDRED) <= 0
            && token(input.opt("candidate")) && text(input, "requestKey").matches("[A-Za-z0-9_-]{20,64}");
    }

    static boolean token(Object value) { return value instanceof String && ((String)value).matches("[A-Za-z0-9_-]{43}"); }

    static boolean validContext(JSONObject context) {
        if (context == null || context.length() != 3) return false;
        for (String field : new String[]{"customer", "suite", "tool"}) {
            if (!(context.opt(field) instanceof String) || text(context, field).isEmpty() || context.getString(field).length() > 240)
                return false;
        }
        return true;
    }

    static JSONObject contexts(Connection db, Accounts.Account actor, String term) throws SQLException {
        if (!TaskRoster.standaloneProfile(db, actor)) return null;
        return TaskRoster.contexts(db, actor, term).put("kind", "task-contexts")
            .put("functions", new JSONArray(FUNCTIONS)).put("responsibilities", new JSONArray(RESPONSIBILITIES));
    }

    static JSONObject standaloneOptions(Connection db, Accounts.Account actor, JSONObject context, String term) throws SQLException {
        if (!TaskRoster.standaloneProfile(db, actor)) return null;
        List<TaskRoster.Candidate> roster = TaskRoster.forProject(db, actor, text(context, "customer"), text(context, "suite"), text(context, "tool"));
        if (roster.isEmpty()) return null;
        return TaskRoster.options(roster, term).put("kind", "task-assignees")
            .put("id", JSONObject.NULL).put("revision", JSONObject.NULL).put("context", context);
    }

    static JSONObject create(Connection db, Accounts.Account actor, JSONObject input, LocalDateTime when) throws SQLException {
        db.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        db.setAutoCommit(false);
        try {
            lockAllocator(db);
            JSONObject result = createLocked(db, actor, input, when);
            db.commit();
            return result;
        } catch (SQLException | RuntimeException failure) {
            db.rollback();
            throw failure;
        }
    }

    private static JSONObject createLocked(Connection db, Accounts.Account actor, JSONObject input, LocalDateTime when) throws SQLException {
        int projectId = input.optInt("id", 0);
        JSONObject context;
        String function;
        String responsibility;
        if (projectId > 0) {
            JSONObject found = Projects.detail(db, actor, projectId);
            if (found == null || TaskRoster.profileId(db, actor, actor.fullname) != actor.id) return null;
            context = found.getJSONObject("item");
            function = context.getString("function");
            responsibility = context.getString("responsibility");
        } else {
            if (!TaskRoster.standaloneProfile(db, actor)) return null;
            context = input.getJSONObject("context");
            function = text(input, "function");
            responsibility = text(input, "responsibility");
        }
        String customer = text(context, "customer"), suite = text(context, "suite"), tool = text(context, "tool");
        String requestKey = text(input, "requestKey");
        JSONArray normalized = new JSONArray().put(projectId);
        if (projectId == 0) normalized.put(customer).put(suite).put(tool).put(function).put(responsibility);
        for (String key : DRAFT_TEXT) normalized.put(text(input, key));
        String fingerprint = Secrets.tokenHash(normalized.toString());
        JSONObject receipt = receipt(db, actor, requestKey, fingerprint, projectId);
        if (receipt != null) return receipt;
        List<TaskRoster.Candidate> roster = projectId > 0 ? projectRoster(db, actor, context)
            : TaskRoster.forProject(db, actor, customer, suite, tool);
        if (projectId == 0 && roster.isEmpty()) return null;
        TaskRoster.Candidate assignee = TaskRoster.find(roster, text(input, "candidate"));
        if (assignee == null) return rejected("candidate-unavailable");
        BigDecimal weight = new BigDecimal(text(input, "weight"));
        String title = HtmlUtils.htmlEscape(text(input, "module"), "UTF-8");
        String description = HtmlUtils.htmlEscape(text(input, "description"), "UTF-8");
        if (title.length() > 255 || description.length() > 255) return rejected("invalid-task-draft");
        int taskId = nextId(db);
        if (weight.add(usedWeight(db, customer, tool, function)).compareTo(HUNDRED) > 0) return rejected("task-weight-limit");
        String businessId = customerReference(db, customer);
        try (PreparedStatement insert = db.prepareStatement(
                "INSERT INTO DaywiseTask (SR_NO,Task_ID,FUNCTION_NAME,RESPONSIBILITY,PRODUCTSUIT,CUSTOMERNAME,PRODUCTTOOL,"
                + " MODULE_NAME,ASSIGNBY,WEIGHTAGE,MANAGER_NAME,TEAM_LEADER,DEVELOPER_NAME,START_DATE,END_DATE,PRIORITY,"
                + " DESCRIPTION,STATUS,Assign_date,Assign_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'Pending',?,?)")) {
            insert.setInt(1, taskId);
            String[] values = { businessId, function, responsibility, suite, customer, tool,
                title, actor.fullname, weight.toPlainString(), assignee.manager, assignee.lead, assignee.name,
                legacyDate(input, "start"), legacyDate(input, "due"), text(input, "priority"), description,
                TaskProgress.date(when), TaskProgress.timestamp(when) };
            for (int i = 0; i < values.length; i++) insert.setString(i + 2, values[i]);
            insert.executeUpdate();
        }
        if (projectId > 0) {
            try (PreparedStatement link = db.prepareStatement("INSERT INTO scm_mobile_project_task (PROJECT_ID,COMPANY_CODE,TASK_ID) VALUES (?,?,?)")) {
                link.setInt(1, projectId);
                link.setString(2, actor.companyCode);
                link.setInt(3, taskId);
                link.executeUpdate();
            }
        }
        grant(db, actor, taskId, actor.id);
        grant(db, actor, taskId, assignee.id);
        grant(db, actor, taskId, TaskRoster.profileId(db, actor, assignee.lead));
        grant(db, actor, taskId, TaskRoster.profileId(db, actor, assignee.manager));
        try (PreparedStatement insert = db.prepareStatement(
                "INSERT INTO scm_mobile_task_submission (LOGIN_ID,COMPANY_CODE,REQUEST_KEY,REQUEST_HASH,TASK_ID) VALUES (?,?,?,?,?)")) {
            AssignedTasks.bind(insert, actor);
            insert.setString(3, requestKey);
            insert.setString(4, fingerprint);
            insert.setInt(5, taskId);
            insert.executeUpdate();
        }
        return created(projectId, taskId);
    }

    static JSONObject reassign(Connection db, Accounts.Account actor, int id, String revision, String candidateKey) throws SQLException {
        db.setAutoCommit(false);
        try {
            JSONObject result = reassignLocked(db, actor, id, revision, candidateKey);
            db.commit();
            return result;
        } catch (SQLException | RuntimeException failure) {
            db.rollback();
            throw failure;
        }
    }

    static boolean validReassignment(JSONObject item) {
        return item != null && item.length() == 3 && AssignedTasks.validId(item.opt("id"))
            && token(item.opt("revision")) && token(item.opt("candidate"));
    }

    static Map<Integer, JSONObject> bulkItems(JSONArray input) {
        if (input == null || input.length() < 2 || input.length() > 30) return null;
        Map<Integer, JSONObject> items = new TreeMap<>();
        for (int index = 0; index < input.length(); index++) {
            JSONObject item = input.optJSONObject(index);
            if (!validReassignment(item) || items.put(item.getInt("id"), item) != null) return null;
        }
        return items;
    }

    static JSONObject reassignBulk(Connection db, Accounts.Account actor, Map<Integer, JSONObject> items) throws SQLException {
        db.setAutoCommit(false);
        try {
            JSONArray changed = new JSONArray();
            for (Map.Entry<Integer, JSONObject> entry : items.entrySet()) {
                int id = entry.getKey();
                JSONObject item = entry.getValue();
                JSONObject result = reassignLocked(db, actor, id, item.getString("revision"), item.getString("candidate"));
                if (result == null || !"task-reassigned".equals(result.getString("kind"))) {
                    db.rollback();
                    return (result == null ? rejected("task-not-found") : result).put("taskId", id);
                }
                changed.put(id);
            }
            db.commit();
            return new JSONObject().put("kind", "tasks-reassigned").put("taskIds", changed);
        } catch (SQLException | RuntimeException failure) {
            db.rollback();
            throw failure;
        }
    }

    private static JSONObject reassignLocked(Connection db, Accounts.Account actor, int id, String revision, String candidateKey) throws SQLException {
        Task task = load(db, actor, id, true);
        if (task == null || !task.managed(actor) || TaskRoster.profileId(db, actor, actor.fullname) != actor.id) return null;
        if (!task.editable(actor) || !revision.equals(task.revision(id))) return rejected("task-assignment-conflict");
        List<TaskRoster.Candidate> candidates = TaskRoster.forReassignment(db, actor, task);
        TaskRoster.Candidate selected = TaskRoster.find(candidates, candidateKey);
        if (selected == null) return rejected("candidate-unavailable");
        try (PreparedStatement update = db.prepareStatement("UPDATE DaywiseTask SET DEVELOPER_NAME=? WHERE SR_NO=?")) {
            update.setString(1, selected.name);
            update.setInt(2, id);
            if (update.executeUpdate() != 1) throw new SQLException("SCM task could not be reassigned");
        }
        grant(db, actor, id, selected.id);
        return new JSONObject().put("kind", "task-reassigned").put("taskId", id);
    }

    private static List<TaskRoster.Candidate> projectRoster(Connection db, Accounts.Account actor, JSONObject project) throws SQLException {
        if (project.getString("function").isEmpty() || project.getString("responsibility").isEmpty()) return java.util.Collections.emptyList();
        return TaskRoster.forProject(db, actor, project.getString("customer"), project.getString("suite"), project.getString("tool"));
    }

    private static Task load(Connection db, Accounts.Account actor, int id, boolean lock) throws SQLException {
        try (PreparedStatement query = db.prepareStatement(TASK_FIELDS + " AND t.SR_NO=?" + (lock ? " FOR UPDATE" : ""))) {
            AssignedTasks.bind(query, actor);
            query.setInt(3, id);
            try (ResultSet row = query.executeQuery()) { return row.next() ? new Task(row) : null; }
        }
    }

    private static void grant(Connection db, Accounts.Account actor, int taskId, int loginId) throws SQLException {
        if (loginId <= 0) return;
        try (PreparedStatement insert = db.prepareStatement(GRANT)) {
            insert.setInt(1, loginId);
            insert.setString(2, actor.companyCode);
            insert.setInt(3, taskId);
            insert.setInt(4, loginId);
            insert.executeUpdate();
        }
    }

    private static void lockAllocator(Connection db) throws SQLException {
        try (PreparedStatement query = db.prepareStatement("SELECT ID FROM scm_mobile_task_create_lock WHERE ID=1 FOR UPDATE");
             ResultSet row = query.executeQuery()) {
            if (!row.next()) throw new SQLException("Mobile task allocation row is missing");
        }
    }

    private static int nextId(Connection db) throws SQLException {
        try (PreparedStatement query = db.prepareStatement("SELECT SR_NO FROM DaywiseTask ORDER BY SR_NO DESC LIMIT 1 FOR UPDATE");
             ResultSet row = query.executeQuery()) {
            int last = row.next() ? row.getInt(1) : 0;
            if (last < 0 || last == Integer.MAX_VALUE) throw new SQLException("SCM task ID limit reached");
            return last + 1;
        }
    }

    private static BigDecimal usedWeight(Connection db, String customer, String tool, String function) throws SQLException {
        BigDecimal total = BigDecimal.ZERO;
        try (PreparedStatement query = db.prepareStatement(
                "SELECT WEIGHTAGE FROM DaywiseTask WHERE CUSTOMERNAME=? AND PRODUCTTOOL=? AND FUNCTION_NAME=?")) {
            query.setString(1, customer);
            query.setString(2, tool);
            query.setString(3, function);
            try (ResultSet rows = query.executeQuery()) {
                while (rows.next()) {
                    String weight = TaskRoster.label(rows, "WEIGHTAGE");
                    if (weight.matches("[0-9]{1,10}([.][0-9]{1,10})?")) total = total.add(new BigDecimal(weight));
                }
            }
        }
        return total;
    }

    private static String customerReference(Connection db, String customer) throws SQLException {
        // Match legacy customer numbering and advance past any retained references after a deletion.
        long count = 0;
        long last = 0;
        try (PreparedStatement query = db.prepareStatement("SELECT Task_ID FROM DaywiseTask WHERE CUSTOMERNAME=?")) {
            query.setString(1, customer);
            try (ResultSet rows = query.executeQuery()) {
                String prefix = customer + "-";
                while (rows.next()) {
                    count++;
                    String reference = TaskRoster.label(rows, "Task_ID");
                    if (reference.startsWith(prefix)) {
                        String number = reference.substring(prefix.length());
                        if (number.matches("[0-9]{1,10}")) last = Math.max(last, Long.parseLong(number));
                    }
                }
            }
        }
        return customer + "-" + (Math.max(last, count) + 1);
    }

    private static JSONObject receipt(Connection db, Accounts.Account actor, String key, String fingerprint, int projectId) throws SQLException {
        try (PreparedStatement query = db.prepareStatement(
                "SELECT TASK_ID,REQUEST_HASH FROM scm_mobile_task_submission WHERE LOGIN_ID=? AND COMPANY_CODE=? AND REQUEST_KEY=?")) {
            AssignedTasks.bind(query, actor);
            query.setString(3, key);
            try (ResultSet row = query.executeQuery()) {
                if (!row.next()) return null;
                return fingerprint.equals(row.getString("REQUEST_HASH")) ? created(projectId, row.getInt("TASK_ID"))
                    : rejected("task-assignment-conflict");
            }
        }
    }

    static JSONObject rejected(String reason) { return new JSONObject().put("kind", "rejected").put("reason", reason); }

    private static JSONObject created(int projectId, int taskId) {
        return new JSONObject().put("kind", "task-created").put("projectId", projectId == 0 ? JSONObject.NULL : projectId).put("taskId", taskId);
    }

    private static String legacyDate(JSONObject input, String key) {
        return TaskProgress.date(TaskDates.parse(text(input, key)).atStartOfDay());
    }
    private static String text(JSONObject input, String key) { return input.getString(key).trim(); }

    static boolean manages(Accounts.Account actor, String lead, String manager) {
        return TaskRoster.role(actor.fullname, TaskRoster.role(actor.role, "Implementor") ? manager : lead);
    }

    static final class Task {
        final String status, customer, suite, tool, assignee, lead, manager, dateStatus;

        Task(ResultSet row) throws SQLException {
            status = TaskRoster.label(row, "STATUS");
            customer = TaskRoster.label(row, "CUSTOMERNAME");
            suite = TaskRoster.label(row, "PRODUCTSUIT");
            tool = TaskRoster.label(row, "PRODUCTTOOL");
            assignee = TaskRoster.label(row, "DEVELOPER_NAME");
            lead = TaskRoster.label(row, "TEAM_LEADER");
            manager = TaskRoster.label(row, "MANAGER_NAME");
            dateStatus = TaskRoster.label(row, "updateDate_Status");
        }

        boolean managed(Accounts.Account actor) { return manages(actor, lead, manager); }
        boolean editable(Accounts.Account actor) { return managed(actor) && !status.isEmpty() && !"Completed".equalsIgnoreCase(status); }

        String revision(int id) {
            return Secrets.tokenHash(new JSONArray().put(id).put(status).put(assignee).put(lead).put(manager)
                .put(customer).put(suite).put(tool).put(dateStatus).toString());
        }
    }
}
