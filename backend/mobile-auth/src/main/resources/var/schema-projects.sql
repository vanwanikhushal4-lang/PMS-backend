-- Apply after schema.sql. The mapped project and record IDs must be verified against SCM.
CREATE TABLE scm_mobile_project_access (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    PROJECT_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, PROJECT_ID),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);

CREATE TABLE scm_mobile_project_record (
    PROJECT_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    RECORD_KIND VARCHAR(16) NOT NULL CHECK (RECORD_KIND IN ('requirement', 'understanding', 'kickoff')),
    RECORD_ID INT NOT NULL,
    PRIMARY KEY (PROJECT_ID, COMPANY_CODE, RECORD_KIND, RECORD_ID)
);
