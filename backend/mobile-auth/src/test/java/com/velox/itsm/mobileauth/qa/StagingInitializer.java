package com.velox.itsm.mobileauth.qa;

import com.velox.itsm.mobileauth.Accounts;
import com.velox.itsm.mobileauth.AuthController;
import com.velox.itsm.mobileauth.AuthConfiguration;
import com.velox.itsm.mobileauth.AuthService;
import com.velox.itsm.mobileauth.Secrets;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.util.function.LongSupplier;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** Test-only Spring assembly. No external DB, real directory bind or external code delivery. */
public class StagingInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private boolean testDelivery;
    @Override public void onStartup(ServletContext context) throws ServletException {
        testDelivery = "/scm-auth-qa".equals(context.getContextPath()) || "/scm-auth-dates-qa".equals(context.getContextPath());
        if ("/scm-auth-strict".equals(context.getContextPath())) context.setInitParameter("spring.profiles.active", "scm-mobile-auth");
        super.onStartup(context);
    }
    @Override protected Class<?>[] getRootConfigClasses() { return null; }
    @Override protected Class<?>[] getServletConfigClasses() { return new Class<?>[]{ testDelivery ? QA.class : ProductionProfile.class }; }
    @Override protected String[] getServletMappings() { return new String[]{ "/" }; }
    @Override protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        long fileLimit = 10L * 1024 * 1024;
        registration.setMultipartConfig(new MultipartConfigElement("", fileLimit, 2 * fileLimit + 32_768, 0));
    }

    @Configuration @EnableWebMvc
    public static class QA {
        private static final String PASSWORD = "Stage-only-password-28";
        private static final String TOTP = "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ";

        @Bean(destroyMethod = "close") public AuthService stageAuth(ServletContext context) throws Exception {
            return createStage(context.getContextPath(), Paths.get(System.getProperty("scm.qa.inbox")), System::currentTimeMillis);
        }

        static AuthService createStage(String instance, Path inbox, LongSupplier clock) throws Exception {
            byte[] key = new byte[32]; new SecureRandom().nextBytes(key);
            Secrets secrets = new Secrets(key);
            JdbcDataSource db = new JdbcDataSource();
            db.setURL("jdbc:h2:mem:scm" + instance.replace('-', '_').replace('/', '_') + ";MODE=MySQL;DB_CLOSE_DELAY=-1");
            try (Connection connection = db.getConnection(); Statement sql = connection.createStatement()) {
                sql.execute("CREATE TABLE LOGINMASTER (LOGINID INT PRIMARY KEY, USERNAME VARCHAR(128), FULL_NAME VARCHAR(128), ROLE_TYPE VARCHAR(96), DESIGNATION VARCHAR(128), LOGIN_TYPE VARCHAR(12), EMAIL VARCHAR(254), PHONE VARCHAR(16), COMPANY VARCHAR(128), LOCATION VARCHAR(128), BRANCH VARCHAR(128), DEPARTMENT VARCHAR(128), SUB_DEPARTMENT VARCHAR(128), SIDEBAR_SCOPE VARCHAR(1000))");
                sql.execute("CREATE TABLE company_code_master (COMPANY_NAME VARCHAR(128), COMPANY_CODE VARCHAR(48))");
                sql.execute("INSERT INTO company_code_master VALUES ('QA Service Operations', 'QA-A'), ('QA Second Company', 'QA-B')");
                sql.execute("CREATE TABLE TICKET (T_ID VARCHAR(500), T_REQUESTER VARCHAR(128), T_COMPANY VARCHAR(128), STATUS VARCHAR(500))");
                sql.execute("CREATE TABLE TICKET_TRACKING (SR_NO INT PRIMARY KEY, T_ID VARCHAR(500), ACTIVITY_DATE VARCHAR(500), STATUS VARCHAR(500), MESSAGE VARCHAR(500), TICKET_RAISED_NAME VARCHAR(128), TICKET_RAISED_NAME_COMPANY VARCHAR(128))");
                sql.execute("INSERT INTO TICKET VALUES ('INC-381','alex','QA Service Operations','Assigned'), ('INC-409','alex','QA Service Operations','Resolved'), ('INC-434','alex','QA Service Operations','Assigned'), ('INC-381','alex','QA Second Company','Closed'), ('INC-402','sms','QA Service Operations','New')");
                sql.execute("INSERT INTO TICKET_TRACKING VALUES"
                    + " (1,'INC-381','31-10-2026 16:12:00','New','Requester reported a loan laptop unable to connect to Wi-Fi.','alex','QA Service Operations'),"
                    + " (2,'INC-381','03-11-2026 09:18:00','Assigned','Assigned to Workplace Support for Wi-Fi diagnostics.','alex','QA Service Operations'),"
                    + " (3,'INC-409','02-11-2026 11:40:00','Resolved','VPN access restored for the purchase approval portal.','alex','QA Service Operations'),"
                    + " (4,'INC-381','04-11-2026 10:20:00','Closed','Second company activity.','alex','QA Second Company'),"
                    + " (5,'INC-402','05-11-2026 10:20:00','New','Activity from another requester in the same company.','sms','QA Service Operations'),"
                    + " (6,'INC-402','05-11-2026 10:20:00','New','Tracking mistakenly names a different requester than the incident.','alex','QA Service Operations'),"
                    + " (7,'INC-434','date unavailable','Assigned',NULL,'alex','QA Service Operations'),"
                    + " (8,'INC-381','03-11-2026 09:18:00','Assigned','Workplace Support scheduled the Wi-Fi diagnostics.','alex','QA Service Operations')");
                try (PreparedStatement incident = connection.prepareStatement("INSERT INTO TICKET VALUES (?,'phone','QA Service Operations','New')");
                     PreparedStatement history = connection.prepareStatement("INSERT INTO TICKET_TRACKING VALUES (?,?,'01-11-2026 09:18:00','New',NULL,'phone','QA Service Operations')")) {
                    for (int i = 21; i < 42; i++) {
                        String id = "INC-QA-" + i;
                        incident.setString(1, id);
                        incident.addBatch();
                        history.setInt(1, i);
                        history.setString(2, id);
                        history.addBatch();
                    }
                    incident.executeBatch();
                    history.executeBatch();
                }
                for (String resource : new String[]{"/var/schema.sql", "/var/schema-projects.sql", "/var/schema-tasks.sql", "/var/schema-project-workspace.sql",
                        "/var/schema-task-assignment.sql", "/var/schema-project-creation.sql", "/var/schema-project-publishing.sql", "/var/schema-project-kickoff.sql"}) {
                    try (InputStream stream = QA.class.getResourceAsStream(resource); Scanner schema = new Scanner(stream, "UTF-8").useDelimiter("\\A")) {
                        for (String statement : schema.next().split(";")) if (!statement.trim().isEmpty()) sql.execute(statement);
                    }
                }
                String hash = secrets.passwordHash(PASSWORD);
                seed(connection, 1, "alex", "Alex Rao", "Sales Manager", "Non-AD", "alex@fixture.invalid", "+12025550101", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 2, "alex", "Alex Kim", "Engineer", "Non-AD", "alex-b@fixture.invalid", "+12025550102", "QA Second Company", "QA-B", "off", secrets.passwordHash("Second-company-fixture-only"), null, true);
                seed(connection, 3, "sms", "Nina Shah", "Ticket Co-ordinator", "Non-AD", "nina@fixture.invalid", "+12025550103", "QA Service Operations", "QA-A", "sms", hash, null, true);
                seed(connection, 4, "enroll", "Dev Singh", "Developer", "Non-AD", "dev@fixture.invalid", "+12025550104", "QA Service Operations", "QA-A", "totp", hash, null, true);
                seed(connection, 5, "totp", "Noor Paul", "Developer", "Non-AD", "noor@fixture.invalid", "+12025550105", "QA Service Operations", "QA-A", "totp", hash, secrets.encryptTotp(5, TOTP), true);
                seed(connection, 6, "directory", "Maya Sen", "Engineer", "AD", "dir@fixture.invalid", "+12025550106", "QA Service Operations", "QA-A", "off", null, null, true);
                seed(connection, 7, "disabled", "Ari Shah", "Developer", "Non-AD", "ari@fixture.invalid", "+12025550107", "QA Service Operations", "QA-A", "off", hash, null, false);
                seed(connection, 8, "phone", "Gia Gupta", "Implementor", "Non-AD", "gia@fixture.invalid", "+12025550108", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 9, "schedule-lead", "Leah Thomas", "Developer", "Non-AD", "leah@fixture.invalid", "+12025550109", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 10, "schedule-manager", "Raj Nair", "Implementor", "Non-AD", "raj@fixture.invalid", "+12025550110", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 11, "schedule-assignee", "Mira Desai", "Tester", "Non-AD", "mira@fixture.invalid", "+12025550111", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 12, "project-creator", "Anika Mehta", "Implementor", "Non-AD", "anika@fixture.invalid", "+12025550112", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 13, "publish-reviewer", "Samira Rao", "Implementor", "Non-AD", "samira@fixture.invalid", "+12025550113", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 14, "document-director", "Sonal Verma", "MD", "Non-AD", "sonal@fixture.invalid", "+12025550114", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 15, "document-project-head", "Riya Naik", "Head_Projects", "Non-AD", "riya@fixture.invalid", "+12025550115", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 16, "document-limited", "Neil Kapoor", "MD", "Non-AD", "neil@fixture.invalid", "+12025550116", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 17, "document-other-company", "Alok Mehta", "MD", "Non-AD", "alok@fixture.invalid", "+12025550117", "QA Second Company", "QA-B", "off", hash, null, true);
                seed(connection, 18, "requirements-sales", "Meera Shah", "Sales_Initiator", "Non-AD", "meera@fixture.invalid", "+12025550118", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 19, "kickoff-director", "Anil Sethi", "MD", "Non-AD", "anil@fixture.invalid", "+12025550119", "QA Service Operations", "QA-A", "off", hash, null, true);
                seed(connection, 20, "kickoff-other-head", "Foreign Project Head", "Head_Projects", "Non-AD", "head-b@fixture.invalid", "+12025550120", "QA Second Company", "QA-B", "off", hash, null, true);
                sql.execute("UPDATE LOGINMASTER SET SIDEBAR_SCOPE='Home,PMS,Requirement_Documents' WHERE LOGINID=14");
                sql.execute("UPDATE LOGINMASTER SET SIDEBAR_SCOPE='Home,PMS' WHERE LOGINID IN (15,17)");
                sql.execute("UPDATE LOGINMASTER SET SIDEBAR_SCOPE='Home,PMSArchive,Requirement_Documents_Archive' WHERE LOGINID=16");
                sql.execute("UPDATE LOGINMASTER SET SIDEBAR_SCOPE='Home,Requirement_Documents' WHERE LOGINID=18");
                sql.execute("UPDATE LOGINMASTER SET SIDEBAR_SCOPE='Home,PMS' WHERE LOGINID=19");
                sql.execute("UPDATE LOGINMASTER SET LOCATION='Pune', BRANCH='West office', DEPARTMENT='Commercial operations', SUB_DEPARTMENT='Delivery' WHERE LOGINID=1");
                sql.execute("UPDATE LOGINMASTER SET LOCATION='Chennai', BRANCH='South office', DEPARTMENT='Engineering' WHERE LOGINID=2");
                sql.execute("CREATE TABLE ProjectData (SR_NO INT PRIMARY KEY, PROJECTNAME VARCHAR(500), CUSTOMERNAME VARCHAR(500), FUNCTION_NAME VARCHAR(500), RESPONSIBILITY VARCHAR(500), PRODUCTSUIT VARCHAR(500), PRODUCTTOOL VARCHAR(500), Task_ID VARCHAR(500))");
                sql.execute("INSERT INTO ProjectData VALUES"
                    + " (41,'Purchase Approval Rollout','Riverside Works','Workflow configuration','Implementation planning','SCM Operations','Purchasing','PM-1041'),"
                    + " (43,'Workplace Wi-Fi Upgrade','Orchard Logistics','Site readiness','Survey and handover','Service Operations','Network Inventory','PM-1043'),"
                    + " (44,'VPN 100% Coverage','Riverside Works','Access rollout','Service desk transition','Service Operations','VPN Access','PM-1044'),"
                    + " (51,'Warehouse Inventory','Valley Logistics','Stock control','Warehouse onboarding','SCM Operations','Stock Review','PM-1051'),"
                    + " (52,'Unassigned Project','Valley Logistics',NULL,NULL,NULL,NULL,NULL)");
                sql.execute("INSERT INTO ProjectData VALUES (47,'Riverside change board','Riverside Works','Change review','Pilot readiness','Service Operations','VPN Access','PM-1047')");
                sql.execute("INSERT INTO scm_mobile_project_access VALUES (1,'QA-A',41), (1,'QA-A',43), (1,'QA-A',44), (2,'QA-B',51), (1,'QA-B',52)");
                sql.execute("INSERT INTO scm_mobile_project_access VALUES (14,'QA-A',47),(15,'QA-A',47),(16,'QA-A',47),(17,'QA-B',51)");
                sql.execute("INSERT INTO scm_mobile_project_access VALUES (18,'QA-A',44),(18,'QA-A',47)");
                sql.execute("INSERT INTO scm_mobile_project_access VALUES (19,'QA-A',44)");
                sql.execute("ALTER TABLE ProjectData ADD SUBMITTEDBY VARCHAR(128)");
                sql.execute("CREATE TABLE FunctionMaster (SR_NO INT PRIMARY KEY, MODULE VARCHAR(120), FUNCTION_NAME VARCHAR(240))");
                sql.execute("INSERT INTO FunctionMaster VALUES (1,'PMS','Access rollout'),(2,'PMS','Development'),(3,'PMS','Implementation'),(4,'PMS','Development planning')");
                sql.execute("INSERT INTO scm_mobile_project_create_context (LOGIN_ID,COMPANY_CODE,CUSTOMER,PRODUCT_SUITE,PRODUCT_TOOL) VALUES"
                    + " (8,'QA-A','Harbor Clinic','Endpoint Protection','Device Security'),"
                    + " (12,'QA-A','Harbor Clinic','Endpoint Protection','Device Security'),"
                    + " (12,'QA-A','Riverside Works','Service Operations','VPN Access'),"
                    + " (12,'QA-B','Valley Logistics','Service Operations','Warehouse access')");
                sql.execute("ALTER TABLE scm_mobile_project_submission ADD CHECK (REQUEST_KEY<>'qa-project-receipt-failure-0001')");
                sql.execute("CREATE TABLE requirementDocument (SR_NO INT PRIMARY KEY, rd_id VARCHAR(120), RDStatus VARCHAR(120), Date VARCHAR(120))");
                sql.execute("CREATE TABLE UnderstandingDocument (SR_NO INT PRIMARY KEY, ud_id VARCHAR(120), UDStatus VARCHAR(120), Date VARCHAR(120))");
                sql.execute("CREATE TABLE ProjectKickOfMeeting (SR_NO INT PRIMARY KEY, Status VARCHAR(120), Date VARCHAR(120), TypesMeeting VARCHAR(120))");
                sql.execute("INSERT INTO requirementDocument VALUES (61,'RD-61','RD Approved By MD','12-11-2026'), (62,'RD-62','Submitted','15-11-2026'), (63,'RD-63','Submitted','16-11-2026')");
                sql.execute("INSERT INTO UnderstandingDocument VALUES (71,'UD-71','UD Approved By MD','13-11-2026')");
                sql.execute("INSERT INTO ProjectKickOfMeeting VALUES (81,'Meeting Scheduled','19-11-2026 10:00','Video conference')");
                seedRecordDetails(sql);
                sql.execute("INSERT INTO scm_mobile_project_record VALUES (44,'QA-A','requirement',61), (44,'QA-A','understanding',71), (44,'QA-A','kickoff',81), (44,'QA-B','requirement',62), (51,'QA-B','requirement',63)");
                seedDocumentReview(sql);
                sql.execute("CREATE TABLE DaywiseTask (SR_NO INT PRIMARY KEY, STATUS VARCHAR(120), CUSTOMERNAME VARCHAR(120), PRODUCTSUIT VARCHAR(120), PRODUCTTOOL VARCHAR(120), DESCRIPTION VARCHAR(2000), MODULE_NAME VARCHAR(120), TEAM_LEADER VARCHAR(120), DEVELOPER_NAME VARCHAR(120), START_DATE VARCHAR(120), END_DATE VARCHAR(120), ASSIGNBY VARCHAR(128))");
                sql.execute("INSERT INTO DaywiseTask VALUES"
                    + " (201,'Pending','Riverside Works','Service Operations','VPN Access','Check access policies for the first pilot group.','Pilot readiness','Dev Singh','Noor Paul','16.11.2026','20.11.2026','Alex Rao'),"
                    + " (202,'Completed','Riverside Works','Service Operations','VPN Access','Record baseline connection results.','Connection tests','Dev Singh','Noor Paul','13.11.2026','15.11.2026','Alex Rao'),"
                    + " (203,'Pending','Orchard Logistics',NULL,NULL,'Assigned by a different user.','Different assigner',NULL,NULL,NULL,NULL,'Maya Sen'),"
                    + " (204,'Completed','Valley Logistics',NULL,NULL,'Isolated company queue.','Stock export',NULL,NULL,NULL,NULL,'Alex Kim'),"
                    + " (205,'Pending','Valley Logistics',NULL,NULL,'Grant belongs to another company.','Other company',NULL,NULL,NULL,NULL,'Alex Rao')");
                sql.execute("INSERT INTO scm_mobile_task_access VALUES (1,'QA-A',201), (1,'QA-A',202), (1,'QA-A',203), (2,'QA-B',204), (1,'QA-B',205)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateDate_Status VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD FUNCTION_NAME VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD TaskUpdateDate VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD MANAGER_NAME VARCHAR(128)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateStarts_Date VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateEnd_Date VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateDates_Reason VARCHAR(255)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateTimeDate VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD updateDateCount VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD dateUpdateBy VARCHAR(128)");
                sql.execute("ALTER TABLE DaywiseTask ADD Task_ID VARCHAR(255)");
                sql.execute("ALTER TABLE DaywiseTask ADD RESPONSIBILITY VARCHAR(500)");
                sql.execute("ALTER TABLE DaywiseTask ADD WEIGHTAGE VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD PRIORITY VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD Assign_date VARCHAR(120)");
                sql.execute("ALTER TABLE DaywiseTask ADD Assign_time VARCHAR(120)");
                sql.execute("INSERT INTO DaywiseTask (SR_NO,STATUS,CUSTOMERNAME,PRODUCTSUIT,PRODUCTTOOL,DESCRIPTION,MODULE_NAME,TEAM_LEADER,DEVELOPER_NAME,START_DATE,END_DATE,ASSIGNBY,updateDate_Status) VALUES"
                    + " (206,'Pending','Riverside Works','Service Operations','VPN Access','Check the second pilot group before rollout.','Pilot acceptance','Dev Singh','Alex Rao','16.11.2026','20.11.2026','Maya Sen','Date Approved'),"
                    + " (207,'Pending','Riverside Works',NULL,NULL,NULL,'Date revision requested',NULL,'Alex Rao',NULL,NULL,'Maya Sen','Date Requested'),"
                    + " (208,'Completed','Riverside Works',NULL,NULL,NULL,'Closed task',NULL,'Alex Rao',NULL,NULL,'Maya Sen',NULL),"
                    + " (209,'Pending','Riverside Works',NULL,NULL,NULL,'Different developer',NULL,'Alex Kim',NULL,NULL,'Maya Sen',NULL),"
                    + " (210,'Pending','Riverside Works','Service Operations','VPN Access','Confirm access for the support team.','Support handoff','Dev Singh','Gia Gupta','16.11.2026','20.11.2026','Maya Sen',NULL),"
                    + " (211,'Pending','Riverside Works','Service Operations','VPN Access','Fixture for a failed log insert.','Rollback fixture','Dev Singh','Gia Gupta',NULL,NULL,'Maya Sen',NULL),"
                    + " (212,'Pending','Riverside Works','Service Operations','VPN Access','Coordinate on-site testing.','Site handoff','Alex Rao','Noor Paul','02.12.2026','07.12.2026','Maya Sen',NULL)");
                sql.execute("UPDATE DaywiseTask SET MANAGER_NAME='Gia Gupta' WHERE SR_NO IN (206,212)");
                sql.execute("UPDATE DaywiseTask SET MANAGER_NAME='Alex Rao' WHERE SR_NO=211");
                sql.execute("INSERT INTO DaywiseTask (SR_NO,STATUS,CUSTOMERNAME,MODULE_NAME,TEAM_LEADER,DEVELOPER_NAME,MANAGER_NAME,START_DATE,END_DATE,"
                    + " ASSIGNBY,updateDate_Status,updateEnd_Date,updateDates_Reason) VALUES"
                    + " (193,'Pending','Harbor Clinic','Device readiness','Leah Thomas','Mira Desai','Raj Nair','18.11.2026','21.11.2026','Raj Nair',NULL,NULL,NULL),"
                    + " (194,'Pending','Harbor Clinic','Access validation','Leah Thomas','Mira Desai','Raj Nair','23.11.2026','25.11.2026','Raj Nair',NULL,NULL,NULL),"
                    + " (195,'Pending','Harbor Clinic','Network cutover','Leah Thomas','Mira Desai','Raj Nair','25.11.2026','29.11.2026','Raj Nair','Pending for approval','30.11.2026','JSP due date request'),"
                    + " (196,'Pending','Harbor Clinic','Failed history fixture','Leah Thomas','Mira Desai','Raj Nair','23.11.2026','25.11.2026','Raj Nair','Pending for approval','30.11.2026','Rollback test')");
                sql.execute("INSERT INTO scm_mobile_task_access (LOGIN_ID,COMPANY_CODE,TASK_ID)"
                    + " SELECT LOGINID,'QA-A',SR_NO FROM LOGINMASTER CROSS JOIN DaywiseTask WHERE LOGINID IN (9,10,11) AND SR_NO BETWEEN 193 AND 196");
                sql.execute("INSERT INTO scm_mobile_task_access VALUES (1,'QA-A',206), (1,'QA-A',207), (1,'QA-A',208), (1,'QA-A',209),"
                    + " (8,'QA-A',210), (8,'QA-A',211), (1,'QA-A',211), (1,'QA-A',212), (8,'QA-A',206), (8,'QA-A',212)");
                sql.execute("CREATE TABLE ReviseDateHistory (SR_NO INT PRIMARY KEY, TASK_ID VARCHAR(120), START_DATE VARCHAR(120), REVISE_START_DATE VARCHAR(120), END_DATE VARCHAR(120), REVISE_END_DATE VARCHAR(120), APPROVED_DATE VARCHAR(120), APPROVED_BY VARCHAR(128), REVISE_REASON VARCHAR(255), CHECK (TASK_ID NOT IN ('196','211')))");
                sql.execute("INSERT INTO scm_mobile_project_task VALUES"
                    + " (44,'QA-A',201), (44,'QA-A',202), (44,'QA-A',203), (44,'QA-A',205),"
                    + " (44,'QA-A',206), (44,'QA-B',207), (51,'QA-B',204), (52,'QA-A',201), (100,'QA-A',210)");
                sql.execute("CREATE TABLE Update_Todays_Progress (SR_NO INT PRIMARY KEY, TASK_ID VARCHAR(120), DATE VARCHAR(120), TODAYS_PROGRESS VARCHAR(255), STATUS VARCHAR(120), FULL_NAME VARCHAR(120), TASK_TYPE VARCHAR(120), FUNCTION_NAME VARCHAR(120), MODULE_NAME VARCHAR(120), CUSTOMER_NAME VARCHAR(120), PRODUCT_NAME VARCHAR(120), PRODUCT_SUITE VARCHAR(120), TASK_DESC VARCHAR(2000))");
                sql.execute("CREATE TABLE hibernate_sequence (next_val BIGINT)");
                sql.execute("INSERT INTO hibernate_sequence VALUES (1000)");
                sql.execute("ALTER TABLE Update_Todays_Progress ADD CHECK (TASK_ID <> '211' OR STATUS <> 'Completed')");
                sql.execute("INSERT INTO Update_Todays_Progress (SR_NO,TASK_ID,DATE,TODAYS_PROGRESS,STATUS,FULL_NAME,TASK_TYPE) VALUES"
                    + " (301,'206','16.11.2026','Verified pilot accounts and recorded rollout exceptions.','In-Progress','Alex Rao','General'),"
                    + " (302,'206','16.11.2026','Other workflow using the same task reference.','In-Progress','Maya Sen','RFP'),"
                    + " (303,'204','16.11.2026','Other company work log.','In-Progress','Alex Kim','General')");
                try (InputStream stream = QA.class.getResourceAsStream("/var/schema-task-progress.sql");
                     Scanner schema = new Scanner(stream, "UTF-8").useDelimiter("\\A")) {
                    for (String statement : schema.next().split(";")) if (!statement.trim().isEmpty()) sql.execute(statement);
                }
                try (PreparedStatement project = connection.prepareStatement("INSERT INTO ProjectData (SR_NO, PROJECTNAME) VALUES (?, 'Paging test project')");
                     PreparedStatement access = connection.prepareStatement("INSERT INTO scm_mobile_project_access VALUES (8,'QA-A',?)")) {
                    for (int id = 100; id < 133; id++) {
                        project.setInt(1, id);
                        project.addBatch();
                        access.setInt(1, id);
                        access.addBatch();
                    }
                    project.executeBatch();
                    access.executeBatch();
                }
                sql.execute("UPDATE ProjectData SET CUSTOMERNAME='Riverside Works', PRODUCTSUIT='Service Operations', PRODUCTTOOL='VPN Access', FUNCTION_NAME='Access rollout', RESPONSIBILITY='Delivery planning' WHERE SR_NO IN (100,101)");
                sql.execute("ALTER TABLE scm_mobile_project_task ADD CHECK (PROJECT_ID<>101)");
                sql.execute("UPDATE DaywiseTask SET MANAGER_NAME='Gia Gupta', FUNCTION_NAME='Access rollout', WEIGHTAGE='30.25', Task_ID='Riverside Works-18' WHERE SR_NO=210");
                sql.execute("CREATE TABLE TlMaster (Developer VARCHAR(128), Team_Leader VARCHAR(128), ImplementerName VARCHAR(128), Customer_name VARCHAR(128), PRODUCT_SUIT VARCHAR(128), SECURITY_SOLTION VARCHAR(128))");
                sql.execute("CREATE TABLE TlMasterSupport (Developer VARCHAR(128), Team_Leader VARCHAR(128), ImplementerName VARCHAR(128), Customer_name VARCHAR(128), PRODUCT_SUIT VARCHAR(128), SECURITY_SOLTION VARCHAR(128))");
                sql.execute("INSERT INTO TlMaster VALUES ('Dev Singh','Dev Singh','Gia Gupta','Riverside Works','Service Operations','VPN Access'),"
                    + " ('Noor Paul','Dev Singh','Gia Gupta','Riverside Works','Service Operations','VPN Access'),"
                    + " ('Alex Kim','Dev Singh','Gia Gupta','Riverside Works','Service Operations','VPN Access'),"
                    + " ('Ari Shah','Dev Singh','Gia Gupta','Riverside Works','Service Operations','VPN Access'),"
                    + " ('Dev Singh','Dev Singh','Gia Gupta','Harbor Clinic','Endpoint Protection','Device Security'),"
                    + " ('Noor Paul','Dev Singh','Gia Gupta','Harbor Clinic','Endpoint Protection','Device Security'),"
                    + " ('Dev Singh','Dev Singh','Anika Mehta','Harbor Clinic','Endpoint Protection','Device Security'),"
                    + " ('Ari Shah','Dev Singh','Gia Gupta','Disabled Roster','Service Operations','Email'),"
                    + " ('Noor Paul','Noor Paul','Maya Sen','Other Roster','Service Operations','Endpoint')");
                seedPublishing(sql);
                sql.execute("ALTER TABLE PurchaseOrder ADD MassPOFile VARCHAR(255)");
                sql.execute("ALTER TABLE PurchaseOrder ADD KOM_Status VARCHAR(120)");
                sql.execute("INSERT INTO scm_mobile_purchase_order_access VALUES (19,'QA-A',901,44)");
                sql.execute("ALTER TABLE PurchaseOrder ADD productFeaturedFileList VARCHAR(255)");
                sql.execute("ALTER TABLE PurchaseOrder ADD pouploadfile VARCHAR(255)");
                sql.execute("UPDATE PurchaseOrder SET MassPOFile='Riverside masked.pdf', productFeaturedFileList='Riverside – features.txt',"
                    + " pouploadfile='Unmasked PO.pdf' WHERE SR_NO=901");
                sql.execute("UPDATE PurchaseOrder SET MassPOFile='No File Available' WHERE SR_NO=904");
                for (String column : new String[]{"rdUpload", "maskedPOfile", "ScopeWork_File", "RFP_File", "Other_File"}) {
                    sql.execute("ALTER TABLE requirementDocument ADD " + column + " VARCHAR(255)");
                }
                for (String column : new String[]{"udFile", "Other_UDFile", "rdFile", "maskedPOFile", "ScopeWork_File", "RFP_File", "Other_File"}) {
                    sql.execute("ALTER TABLE UnderstandingDocument ADD " + column + " VARCHAR(255)");
                }
                sql.execute("UPDATE requirementDocument SET rdUpload='Requirements61.pdf', maskedPOfile='Riverside masked.pdf',"
                    + " ScopeWork_File='Scope61.txt', RFP_File='missing-rfp61.pdf', Other_File='Linked file.txt' WHERE SR_NO=61");
                sql.execute("UPDATE requirementDocument SET rdUpload='Unmasked PO.pdf' WHERE SR_NO=62");
                sql.execute("UPDATE UnderstandingDocument SET udFile='Understanding71.pdf', rdFile='Requirements61.pdf',"
                    + " Other_File='unrelated/private.txt' WHERE SR_NO=71");
            }
            AuthService.Directory directory = (company, username, password) -> "QA-A".equals(company) && "directory".equals(username) && "Synthetic-AD-only-22".equals(password);
            AuthService.Delivery deliver = (channel, destination, code) -> {
                try {
                    synchronized (inbox) {
                        Files.write(inbox, (channel + "\t" + destination + "\t" + code + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                } catch (java.io.IOException e) { throw new AuthService.Unavailable(); }
            };
            org.hibernate.cfg.Configuration hibernate = new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Class.forName("com.velox.itsm.model.Update_Todays_Progress"))
                .addAnnotatedClass(Class.forName("com.velox.itsm.model.ReviseDateHistory"))
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
            hibernate.getProperties().put(AvailableSettings.DATASOURCE, db);
            SessionFactory sessions = hibernate.buildSessionFactory();
            Path files = seedAttachmentFiles(inbox.toAbsolutePath().resolveSibling(inbox.getFileName() + "-attachments-"
                + instance.replaceAll("[^A-Za-z0-9_-]", "_")));
            return new AuthService(new Accounts(db, () -> sessions), secrets, directory, deliver, clock, files);
        }

        @Bean public AuthController stageController(AuthService auth) { return new LoopbackController(auth); }

        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver fixtureMultipartResolver() {
            CommonsMultipartResolver resolver = new CommonsMultipartResolver() {
                @Override public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {
                    return Boolean.getBoolean("scm.qa.commonsMultipart") && super.isMultipart(request);
                }
            };
            long limit = 10L * 1024 * 1024;
            resolver.setDefaultEncoding("UTF-8");
            resolver.setMaxUploadSize(2 * limit + 32_768);
            resolver.setMaxUploadSizePerFile(limit);
            resolver.setResolveLazily(true);
            return resolver;
        }
    }

    @Configuration @EnableWebMvc @Import({AuthController.class, AuthConfiguration.class})
    public static class ProductionProfile {}

    @org.springframework.web.bind.annotation.RestController
    @org.springframework.web.bind.annotation.RequestMapping("/mobile/v1/auth")
    public static class LoopbackController extends AuthController { LoopbackController(AuthService auth) { super(auth, true); } }

    private static Path seedAttachmentFiles(Path root) throws java.io.IOException {
        Files.createDirectories(root);
        Files.write(root.resolve("Riverside masked.pdf"), fixturePdf("Masked purchase order - Riverside pilot"));
        Files.write(root.resolve("Requirements61.pdf"), fixturePdf("Requirements for Riverside"));
        Files.write(root.resolve("Understanding71.pdf"), fixturePdf("Understanding for Riverside"));
        Files.write(root.resolve("Riverside agenda.pdf"), fixturePdf("Kickoff agenda for Riverside"));
        Files.write(root.resolve("Riverside meeting plan.pdf"), fixturePdf("Kickoff plan for Riverside"));
        Files.write(root.resolve("Unmasked PO.pdf"), fixturePdf("Unmasked fixture restricted to sales"));
        Files.write(root.resolve("Riverside – features.txt"), "VPN pilot; device policy validation.\n".getBytes(StandardCharsets.UTF_8));
        Files.write(root.resolve("Scope61.txt"), "Riverside pilot deployment scope.\n".getBytes(StandardCharsets.UTF_8));
        Path outside = root.resolveSibling(root.getFileName() + "-outside.txt");
        Files.write(outside, "Outside the attachment directory.".getBytes(StandardCharsets.UTF_8));
        try { Files.createSymbolicLink(root.resolve("Linked file.txt"), outside); }
        catch (UnsupportedOperationException | java.io.IOException ignored) { /* Symlink creation is optional on Windows fixtures. */ }
        return root;
    }

    private static void seedRecordDetails(Statement sql) throws java.sql.SQLException {
        for (String column : new String[]{"POnumber", "productSuitName", "securityTool", "FunctionName",
                "productManager", "UserName", "UserId", "Designation", "Description", "rdNote"}) {
            sql.execute("ALTER TABLE requirementDocument ADD " + column + " VARCHAR(2000)");
        }
        for (String column : new String[]{"POnumber", "rd_id", "productSuite", "securityTool", "FunctionName",
                "productManager", "Team_Leader", "Developers", "Username", "Designation", "project_startDate", "project_endDate",
                "Description", "projectDesc", "projectObj", "project_Scope", "function_Requirement", "nonFunction_Requirement",
                "technical_Requirement", "rdNote", "udNote", "rejectedByMD", "rejectedMDDate", "rejectMDReason"}) {
            sql.execute("ALTER TABLE UnderstandingDocument ADD " + column + " VARCHAR(2000)");
        }
        for (String column : new String[]{"Po_Number", "UD_number", "ProjectHead", "SalesManager", "ProductionManager",
                "TypesOfRooms", "RoomCapacity", "MeetingResource", "PersonInMetting", "ResourceInMeeting", "TelephonicMeeting",
                "VideoConferenceMeeting", "GeneratedLink", "UploadFile1", "UploadFile2"}) {
            sql.execute("ALTER TABLE ProjectKickOfMeeting ADD " + column + " VARCHAR(2000)");
        }
        sql.execute("UPDATE requirementDocument SET POnumber='PO-910', UserName='Alex Rao', Designation='NA',"
            + " rdNote='Validate VPN coverage on the first 24 devices.', Description='Pilot deployment requirements' WHERE SR_NO=61");
        sql.execute("UPDATE requirementDocument SET rdNote='Unlinked company material' WHERE SR_NO=62");
        sql.execute("UPDATE UnderstandingDocument SET POnumber='PO-910', rd_id='RD-61', Team_Leader='Dev Singh', Developers='Noor Paul',"
            + " project_startDate='19.11.2026', project_endDate='29.11.2026', projectDesc='Riverside VPN pilot',"
            + " projectObj='Verify remote access for the support team', project_Scope='Support laptops',"
            + " function_Requirement='Sign in through the company directory', technical_Requirement='Existing VPN cluster' WHERE SR_NO=71");
        sql.execute("UPDATE ProjectKickOfMeeting SET Po_Number='PO-910', UD_number='UD-71', ProjectHead='Anika Mehta',"
            + " VideoConferenceMeeting='Teams', GeneratedLink='https://meet.fixture.invalid/riverside-kickoff',"
            + " UploadFile1='Riverside agenda.pdf', UploadFile2='Riverside meeting plan.pdf' WHERE SR_NO=81");
        sql.execute("ALTER TABLE ProjectKickOfMeeting ADD CONSTRAINT fixture_kickoff_insert_failure CHECK (GeneratedLink <> 'fixture rollback')");
    }

    private static void seedDocumentReview(Statement sql) throws java.sql.SQLException {
        sql.execute("INSERT INTO requirementDocument (SR_NO,rd_id,RDStatus,Date,POnumber,UserName,rdNote) VALUES"
            + " (64,'RD-64','RD Pending For Approval','20-11-2026','PO-910','Alex Rao','Confirm the Riverside rollout requirements')");
        sql.execute("INSERT INTO UnderstandingDocument (SR_NO,ud_id,UDStatus,Date,POnumber,projectObj,rd_id) VALUES"
            + " (72,'UD-72','UD Pending For Approval','20-11-2026','PO-910','Validate the pilot schedule before enabling VPN access','RD-64'),"
            + " (73,'UD-73','UD Pending For Approval','21-11-2026','PO-910','Review the rollback steps for remote access','RD-64'),"
            + " (74,'UD-74','UD Pending For Approval','22-11-2026','PO-910','Review the staged access plan','RD-64'),"
            + " (75,'UD-75','UD Pending For Approval','23-11-2026',NULL,'Different project',NULL),"
            + " (76,'UD-76','UD Pending For Approval','24-11-2026',NULL,'Different company',NULL)");
        sql.execute("INSERT INTO scm_mobile_project_record VALUES (47,'QA-A','requirement',64), (47,'QA-A','understanding',72),"
            + " (47,'QA-A','understanding',73), (47,'QA-A','understanding',74), (43,'QA-A','understanding',75), (51,'QA-B','understanding',76)");
        sql.execute("UPDATE requirementDocument SET UserId='requirements-sales' WHERE SR_NO IN (61,62)");
        sql.execute("INSERT INTO requirementDocument (SR_NO,rd_id,RDStatus,Date,UserName,UserId,rdNote) VALUES"
            + " (65,'RD-65',NULL,'21-11-2026','Meera Shah','requirements-sales','Requirement in an unassigned project'),"
            + " (67,'RD-67','RD Approved By SI','22-11-2026','Meera Shah','requirements-sales','Use the approved access checklist'),"
            + " (68,'RD-68','RD Approved By MD','22-11-2026','Meera Shah','different-user','Submitted by a colleague with the same display name'),"
            + " (69,'RD-69',NULL,'23-11-2026','Meera Shah','requirements-sales','Document the device handoff before go-live')");
        sql.execute("INSERT INTO UnderstandingDocument (SR_NO,ud_id,UDStatus,Date,projectObj,rejectMDReason,rejectedByMD,rejectedMDDate) VALUES"
            + " (77,'UD-77','UD Approved By MD','21-11-2026','Authorize the test rollout',NULL,NULL,NULL),"
            + " (78,'UD-78','UD Rejected By MD','21-11-2026','Document the migration window','Add the rollback owner','document-project-head','23-11-2026 14:10'),"
            + " (79,'UD-79','UD Approved By SI','22-11-2026','Archive the original approval',NULL,NULL,NULL)");
        sql.execute("INSERT INTO scm_mobile_project_record VALUES (43,'QA-A','requirement',65),(47,'QA-A','requirement',67),"
            + " (47,'QA-A','requirement',68),(47,'QA-A','requirement',69),(47,'QA-A','understanding',77),"
            + " (47,'QA-A','understanding',78),(47,'QA-A','understanding',79)");
    }

    private static byte[] fixturePdf(String message) {
        String content = "BT /F1 18 Tf 48 710 Td (" + message + ") Tj ET\n";
        String[] objects = {
            "<< /Type /Catalog /Pages 2 0 R >>",
            "<< /Type /Pages /Kids [3 0 R] /Count 1 >>",
            "<< /Type /Page /Parent 2 0 R /MediaBox [0 0 600 760] /Contents 4 0 R /Resources << /Font << /F1 5 0 R >> >> >>",
            "<< /Length " + content.length() + " >>\nstream\n" + content + "endstream",
            "<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>"
        };
        StringBuilder file = new StringBuilder("%PDF-1.4\n");
        StringBuilder offsets = new StringBuilder("0000000000 65535 f \n");
        for (int i = 0; i < objects.length; i++) {
            offsets.append(String.format(java.util.Locale.ROOT, "%010d 00000 n \n", file.length()));
            file.append(i + 1).append(" 0 obj\n").append(objects[i]).append("\nendobj\n");
        }
        int crossReference = file.length();
        file.append("xref\n0 6\n").append(offsets).append("trailer\n<< /Size 6 /Root 1 0 R >>\nstartxref\n")
            .append(crossReference).append("\n%%EOF\n");
        return file.toString().getBytes(StandardCharsets.US_ASCII);
    }

    private static void seedPublishing(Statement sql) throws java.sql.SQLException {
        sql.execute("CREATE TABLE PurchaseOrder (SR_NO INT PRIMARY KEY, vlx_id VARCHAR(120), customername VARCHAR(120),"
            + " ProductSuitName VARCHAR(120), SecurityToolName VARCHAR(120), purchaseNumber VARCHAR(120), purchaseDate VARCHAR(120),"
            + " vlx_status VARCHAR(120), Form3_status VARCHAR(120), paymentterms VARCHAR(255), prodliscense VARCHAR(255))");
        sql.execute("INSERT INTO PurchaseOrder VALUES"
            + " (901,'PO-910','Riverside Works','Service Operations','VPN Access','RIV-104','16.11.2026','Purchase Order Approved','FORM3 Submitted','Net 30','Enterprise VPN'),"
            + " (902,'PO-911','Riverside Works','Service Operations','VPN Access','RIV-105','17.11.2026','Purchasing review',NULL,NULL,NULL),"
            + " (903,'PO-912','Unordered Lab','Service Operations','VPN Access','LAB-101','15.11.2026','Purchase Order Approved',NULL,NULL,NULL),"
            + " (904,'PO-913','Riverside Works','Endpoint Protection','Device Security','RIV-106','19.11.2026','Manual PO Raised By SI',NULL,NULL,NULL),"
            + " (905,'RF-914','Riverside Works','Service Operations','VPN Access',NULL,NULL,'Draft',NULL,NULL,NULL),"
            + " (906,'PO-914','Riverside Works','Service Operations','VPN Access','RIV-900','20.11.2026','Purchase Order Approved',NULL,NULL,NULL)");
        sql.execute("INSERT INTO scm_mobile_project_access VALUES (13,'QA-A',44)");
        sql.execute("INSERT INTO scm_mobile_purchase_order_access VALUES (13,'QA-A',901,44),(13,'QA-A',904,51),(13,'QA-A',905,NULL),(13,'QA-B',906,52)");
        String[] formColumns = ("PROJECT_NAME,T_Date,VP_status,SALES_MANAGER_NAME,CUSTOMER_IMPLEMENTOR_NAME,CUSTOMER_IMPLEMENTOR_CONTACT,"
            + "CUSTOMER_IMPLEMENTOR_EMAIL,END_CUSTOMER_NAME,END_CUSTOMER_CONTACT,product_license,SERVER_AVAILABILITY,SERVER_RESPONSIBILITY,"
            + "SERVER_STARTDATE,SERVER_ENDDATE,INSTALL_VELOX_LICENSE,RESPONSIBILTIY_VELOX_LICENSE,VELOX_LICENSE_STARTDATE,VELOX_LICENSE_ENDDATE,"
            + "UAT_TESTING,RESPONSIBILITY_UAT_TESTING,UAT_STARTDATE,UAT_ENDDATE,PRODUCT_GO_LIVE,RESPONSIBILITY_PRODUCTGOLIVE,"
            + "PRODUCT_GO_LIVE_STARTDATE,PRODUCT_GO_LIVE_ENDDATE,ROLLOUT,RSPOSINBILITY_ROLLOUT,ROLLOUT_STARTDATE,ROLLOUT_ENDDATE,"
            + "DEMO_LIVE,RESPONSIBILTY_DEMOLIVE,DEMOLIVE_STARTDATE,DEMOLIVE_ENDDATE,PAYMENT_TERMS,RESPONSIBILITY_PAYMENTTERMS,"
            + "PAYMENT_TERMS_STARTDATE,PAYMENT_TERMS_ENDDATE,SIGNOFF,RESPONSIBILTY_SIGNOFF,SIGNOFF_STARTDATE,SIGNOFF_ENDDATE").split(",");
        StringBuilder form = new StringBuilder("CREATE TABLE FORM3 (SR_NO INT PRIMARY KEY, VP_id VARCHAR(120)");
        for (String column : formColumns) form.append(",").append(column).append(" VARCHAR(255)");
        sql.execute(form.append(")").toString());
        sql.execute("INSERT INTO FORM3 (SR_NO,VP_id,PROJECT_NAME,T_Date,VP_status,product_license,CUSTOMER_IMPLEMENTOR_NAME,CUSTOMER_IMPLEMENTOR_EMAIL,"
            + " SERVER_AVAILABILITY,SERVER_RESPONSIBILITY,SERVER_STARTDATE,SERVER_ENDDATE,SIGNOFF,SIGNOFF_ENDDATE) VALUES"
            + " (81,'PO-910','Riverside%20VPN%20pilot','18.11.2026','FORM3 Submitted','Enterprise VPN','Dev Singh','dev+scm%40fixture.invalid',"
            + " 'Pilot%20servers%20ready','End Customer','16.11.2026','18.11.2026','Customer sign-off','29.11.2026'),"
            + " (82,'PO-910','Wrong company form',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),"
            + " (83,'PO-911','Wrong order reference',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),"
            + " (84,'PO-910','Unlinked duplicate form',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
        sql.execute("INSERT INTO scm_mobile_purchase_order_form_c VALUES ('QA-A',901,81),('QA-B',901,82),('QA-A',901,83)");
        sql.execute("INSERT INTO DaywiseTask (SR_NO,STATUS,CUSTOMERNAME,PRODUCTSUIT,PRODUCTTOOL,MODULE_NAME,FUNCTION_NAME,WEIGHTAGE,DEVELOPER_NAME,DESCRIPTION,Assign_date) VALUES"
            + " (181,'Completed','Riverside Works','Service Operations','VPN Access','Pilot tunnel checks','Development','25','Dev Singh','Tested pilot connectivity.','17.11.2026'),"
            + " (182,'Pending','Riverside Works','Service Operations','VPN Access','Confirm device groups','Development','49','Noor Paul',NULL,'18.11.2026'),"
            + " (183,'Completed','Riverside Works','Service Operations','VPN Access','Ungranted task','Development','10','Noor Paul',NULL,NULL),"
            + " (184,'Completed','Riverside Works','Service Operations','VPN Access','Wrong company task','Development','12','Noor Paul',NULL,NULL),"
            + " (185,'Completed','Unordered Lab','Service Operations','VPN Access','No accessible PO','Development','5','Noor Paul',NULL,NULL),"
            + " (186,'Completed','Over Limit','Service Operations','VPN Access','Above legacy threshold','Development','101','Noor Paul',NULL,NULL),"
            + " (187,'Completed','Riverside Works','Service Operations','VPN Access','Validate policy plan','Development planning','10.25','Dev Singh',NULL,'15.11.2026')");
        sql.execute("INSERT INTO scm_mobile_task_access VALUES (13,'QA-A',181),(13,'QA-A',182),(13,'QA-B',184),"
            + " (13,'QA-A',185),(13,'QA-A',186),(13,'QA-A',187)");
    }

    private static void seed(Connection db, int id, String username, String displayName, String role, String directory, String email, String phone,
                             String company, String code, String method, String hash, String totp, boolean enabled) throws Exception {
        try (PreparedStatement identity = db.prepareStatement("INSERT INTO LOGINMASTER (LOGINID, USERNAME, FULL_NAME, ROLE_TYPE, DESIGNATION, LOGIN_TYPE, EMAIL, PHONE, COMPANY) VALUES (?,?,?,?,?,?,?,?,?)")) {
            identity.setInt(1, id); identity.setString(2, username); identity.setString(3, displayName); identity.setString(4, role);
            identity.setString(5, "Operations"); identity.setString(6, directory); identity.setString(7, email); identity.setString(8, phone);
            identity.setString(9, company); identity.executeUpdate();
        }
        try (PreparedStatement profile = db.prepareStatement("INSERT INTO scm_mobile_account (LOGIN_ID,COMPANY_CODE,ENABLED,PASSWORD_HASH,MFA_MODE,TOTP_ENCRYPTED) VALUES (?,?,?,?,?,?)")) {
            profile.setInt(1, id); profile.setString(2, code); profile.setBoolean(3, enabled); profile.setString(4, hash);
            profile.setString(5, method); profile.setString(6, totp); profile.executeUpdate();
        }
    }
}
