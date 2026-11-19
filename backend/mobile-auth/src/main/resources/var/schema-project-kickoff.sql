-- Apply after schema-project-workspace.sql and schema-project-publishing.sql.
-- The shared SCM meeting, purchase-order, record link and these receipts must use InnoDB.
CREATE TABLE scm_mobile_kickoff_lock (ID INT NOT NULL PRIMARY KEY);
INSERT INTO scm_mobile_kickoff_lock (ID) VALUES (1);

CREATE TABLE scm_mobile_kickoff_submission (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    REQUEST_KEY VARCHAR(64) NOT NULL,
    REQUEST_HASH VARCHAR(43) NOT NULL,
    PROJECT_ID INT NOT NULL,
    RECORD_ID INT NOT NULL,
    MEETING_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, REQUEST_KEY),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);

-- Legacy filename columns keep collision-resistant flat filenames for JSP interoperability.
-- Mobile metadata preserves each originally selected name without exposing storage filenames.
CREATE TABLE scm_mobile_kickoff_file (
    COMPANY_CODE VARCHAR(48) NOT NULL,
    MEETING_ID INT NOT NULL,
    FILE_KIND VARCHAR(32) NOT NULL,
    STORAGE_NAME VARCHAR(255) NOT NULL,
    ORIGINAL_NAME VARCHAR(160) NOT NULL,
    SIZE_BYTES BIGINT NOT NULL,
    CONTENT_HASH VARCHAR(43) NOT NULL,
    PRIMARY KEY (COMPANY_CODE, MEETING_ID, FILE_KIND),
    UNIQUE (STORAGE_NAME)
);
