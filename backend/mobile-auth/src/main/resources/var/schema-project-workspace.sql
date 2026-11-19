-- PROJECT_ID and TASK_ID refer to ProjectData.SR_NO and DaywiseTask.SR_NO.
-- Link verified records within a company. Legacy business references use separate sequences.
CREATE TABLE scm_mobile_project_task (
    PROJECT_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    TASK_ID INT NOT NULL,
    PRIMARY KEY (PROJECT_ID, COMPANY_CODE, TASK_ID)
);

CREATE TABLE scm_mobile_project_favorite (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    PROJECT_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, PROJECT_ID),
    FOREIGN KEY (LOGIN_ID, COMPANY_CODE, PROJECT_ID)
        REFERENCES scm_mobile_project_access (LOGIN_ID, COMPANY_CODE, PROJECT_ID) ON DELETE CASCADE
);
