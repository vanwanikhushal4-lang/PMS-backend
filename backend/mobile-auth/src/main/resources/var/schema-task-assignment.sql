-- Mobile writers serialize allocation because DaywiseTask uses manually assigned numeric IDs.
CREATE TABLE scm_mobile_task_create_lock (ID INT NOT NULL PRIMARY KEY);
INSERT INTO scm_mobile_task_create_lock (ID) VALUES (1);

CREATE TABLE scm_mobile_task_submission (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    REQUEST_KEY VARCHAR(64) NOT NULL,
    REQUEST_HASH VARCHAR(43) NOT NULL,
    TASK_ID INT NOT NULL,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, REQUEST_KEY),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);
