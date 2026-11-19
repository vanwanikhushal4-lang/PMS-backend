-- Apply after schema.sql. TASK_ID refers to DaywiseTask.SR_NO.
CREATE TABLE scm_mobile_task_access (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    TASK_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, TASK_ID),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);
