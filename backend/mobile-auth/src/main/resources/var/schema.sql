-- Apply explicitly to the database containing the SCM identity tables.
-- No legacy table is modified by this migration.
CREATE TABLE scm_mobile_account (
    LOGIN_ID INT NOT NULL PRIMARY KEY,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    ENABLED BOOLEAN NOT NULL DEFAULT FALSE,
    PASSWORD_HASH VARCHAR(320),
    MFA_MODE VARCHAR(12) NOT NULL,
    TOTP_ENCRYPTED VARCHAR(320),
    LAST_TOTP_STEP BIGINT NOT NULL DEFAULT -1,
    REVISION BIGINT NOT NULL DEFAULT 1
);
