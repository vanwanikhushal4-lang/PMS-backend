-- Apply after schema-projects.sql. Provision these grants from the verified SCM catalog for each account.
CREATE TABLE scm_mobile_project_create_context (
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    CUSTOMER VARCHAR(240) NOT NULL,
    PRODUCT_SUITE VARCHAR(240) NOT NULL,
    PRODUCT_TOOL VARCHAR(240) NOT NULL,
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);
CREATE INDEX scm_mobile_project_create_actor ON scm_mobile_project_create_context (LOGIN_ID, COMPANY_CODE);

CREATE TABLE scm_mobile_project_create_lock (ID INT NOT NULL PRIMARY KEY);
INSERT INTO scm_mobile_project_create_lock (ID) VALUES (1);

CREATE TABLE scm_mobile_project_submission (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    REQUEST_KEY VARCHAR(64) NOT NULL,
    REQUEST_HASH VARCHAR(43) NOT NULL,
    PROJECT_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, REQUEST_KEY),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);
