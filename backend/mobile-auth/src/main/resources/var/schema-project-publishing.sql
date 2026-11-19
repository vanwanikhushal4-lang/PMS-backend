-- PurchaseOrder and FORM3 have no stable company key. Provision these links from verified records.
CREATE TABLE scm_mobile_purchase_order_access (
    LOGIN_ID INT NOT NULL,
    COMPANY_CODE VARCHAR(48) NOT NULL,
    PURCHASE_ORDER_ID INT NOT NULL,
    PROJECT_ID INT,
    PRIMARY KEY (LOGIN_ID, COMPANY_CODE, PURCHASE_ORDER_ID),
    FOREIGN KEY (LOGIN_ID) REFERENCES scm_mobile_account (LOGIN_ID) ON DELETE CASCADE
);

CREATE TABLE scm_mobile_purchase_order_form_c (
    COMPANY_CODE VARCHAR(48) NOT NULL,
    PURCHASE_ORDER_ID INT NOT NULL,
    FORM_C_ID INT NOT NULL,
    PRIMARY KEY (COMPANY_CODE, PURCHASE_ORDER_ID, FORM_C_ID)
);
