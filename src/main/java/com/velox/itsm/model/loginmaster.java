package com.velox.itsm.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOGINMASTER")
public class loginmaster implements Serializable {

	private static final long serialVersionUID = -6631147707364792372L;
	@Id
	@Column
	private int LOGINID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FULL_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUB_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOCATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOGIN_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ROLE_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LEVEL;
	@Column(columnDefinition = "TEXT")
	private String LOGIN_SCOPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIRST_LOGIN;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SECRETKEY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OTP;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HEADER_COLOR;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SIDEBAR_COLOR;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SMALL_FONT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VIP_LOGIN;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GROUP_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DESIGNATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VISIBILITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REPORTING_TO_MANAGER;	
	@Column(columnDefinition = "TEXT")
	private String CATEGORY_WITH_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String IDTYPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVE_STATUS; 
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SIDEBAR_SCOPE;
	
	@Column(columnDefinition = "NVARCHAR(25500)")
	private String USER_ACTIVITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEND_MAIL_DATE;
	
	
	//30/07
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_INACTIVE_DAYS;
	//
	
	
	
	//30/08
	@Column(columnDefinition = "NVARCHAR(500)")
	private String mailOTP;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TIMESTAMP;
	//
	
	
	
	
	//05/09/2024
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REGISTRATION_DATE;
	
	//
	private String VIEW_DESIGNATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	


	
	
	//05/09/2024
	public String getREGISTRATION_DATE() {
		return REGISTRATION_DATE;
	}

	public String getVIEW_DESIGNATION() {
		return VIEW_DESIGNATION;
	}

	public void setVIEW_DESIGNATION(String vIEW_DESIGNATION) {
		VIEW_DESIGNATION = vIEW_DESIGNATION;
	}

	public void setREGISTRATION_DATE(String rEGISTRATION_DATE) {
		REGISTRATION_DATE = rEGISTRATION_DATE;
	}
	//




	public String getMailOTP() {
		return mailOTP;
	}




	public void setMailOTP(String mailOTP) {
		this.mailOTP = mailOTP;
	}




	public String getTIMESTAMP() {
		return TIMESTAMP;
	}




	public void setTIMESTAMP(String tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}




	public String getTOTAL_INACTIVE_DAYS() {
		return TOTAL_INACTIVE_DAYS;
	}

	
	

	public void setTOTAL_INACTIVE_DAYS(String tOTAL_INACTIVE_DAYS) {
		TOTAL_INACTIVE_DAYS = tOTAL_INACTIVE_DAYS;
	}

	public String getSEND_MAIL_DATE() {
		return SEND_MAIL_DATE;
	}

	public void setSEND_MAIL_DATE(String sEND_MAIL_DATE) {
		SEND_MAIL_DATE = sEND_MAIL_DATE;
	}

	public String getUSER_ACTIVITY() {
		return USER_ACTIVITY;
	}

	public void setUSER_ACTIVITY(String uSER_ACTIVITY) {
		USER_ACTIVITY = uSER_ACTIVITY;
	}

	public String getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}

	private String GENDER;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String last_login_time;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVE_USER;
	
	private String LOGIN_HISTORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	
	public String getGENDER() {
		return GENDER;
	}

	public String getLOGIN_HISTORY() {
		return LOGIN_HISTORY;
	}

	public void setLOGIN_HISTORY(String lOGIN_HISTORY) {
		LOGIN_HISTORY = lOGIN_HISTORY;
	}

	public String getACTIVE_USER() {
		return ACTIVE_USER;
	}

	public void setACTIVE_USER(String aCTIVE_USER) {
		ACTIVE_USER = aCTIVE_USER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLOGINID() {
		return LOGINID;
	}

	public void setLOGINID(int lOGINID) {
		LOGINID = lOGINID;
	}

	public String getFULL_NAME() {
		return FULL_NAME;
	}

	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public String getBRANCH() {
		return BRANCH;
	}

	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getSUB_DEPARTMENT() {
		return SUB_DEPARTMENT;
	}

	public void setSUB_DEPARTMENT(String sUB_DEPARTMENT) {
		SUB_DEPARTMENT = sUB_DEPARTMENT;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getLOGIN_TYPE() {
		return LOGIN_TYPE;
	}

	public void setLOGIN_TYPE(String lOGIN_TYPE) {
		LOGIN_TYPE = lOGIN_TYPE;
	}

	public String getROLE_TYPE() {
		return ROLE_TYPE;
	}

	public void setROLE_TYPE(String rOLE_TYPE) {
		ROLE_TYPE = rOLE_TYPE;
	}

	public String getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}

	public String getLOGIN_SCOPE() {
		return LOGIN_SCOPE;
	}

	public void setLOGIN_SCOPE(String lOGIN_SCOPE) {
		LOGIN_SCOPE = lOGIN_SCOPE;
	}

	public String getFIRST_LOGIN() {
		return FIRST_LOGIN;
	}

	public void setFIRST_LOGIN(String fIRST_LOGIN) {
		FIRST_LOGIN = fIRST_LOGIN;
	}

	public String getSECRETKEY() {
		return SECRETKEY;
	}

	public void setSECRETKEY(String sECRETKEY) {
		SECRETKEY = sECRETKEY;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public String getHEADER_COLOR() {
		return HEADER_COLOR;
	}

	public void setHEADER_COLOR(String hEADER_COLOR) {
		HEADER_COLOR = hEADER_COLOR;
	}

	public String getSIDEBAR_COLOR() {
		return SIDEBAR_COLOR;
	}

	public void setSIDEBAR_COLOR(String sIDEBAR_COLOR) {
		SIDEBAR_COLOR = sIDEBAR_COLOR;
	}

	public String getSMALL_FONT() {
		return SMALL_FONT;
	}

	public void setSMALL_FONT(String sMALL_FONT) {
		SMALL_FONT = sMALL_FONT;
	}

	public String getVIP_LOGIN() {
		return VIP_LOGIN;
	}

	public void setVIP_LOGIN(String vIP_LOGIN) {
		VIP_LOGIN = vIP_LOGIN;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getGROUP_NAME() {
		return GROUP_NAME;
	}

	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}

	public String getDESIGNATION() {
		return DESIGNATION;
	}

	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}

	public String getVISIBILITY() {
		return VISIBILITY;
	}

	public void setVISIBILITY(String vISIBILITY) {
		VISIBILITY = vISIBILITY;
	}

	public String getREPORTING_TO_MANAGER() {
		return REPORTING_TO_MANAGER;
	}

	public void setREPORTING_TO_MANAGER(String rEPORTING_TO_MANAGER) {
		REPORTING_TO_MANAGER = rEPORTING_TO_MANAGER;
	}

	public String getCATEGORY_WITH_COMPANY() {
		return CATEGORY_WITH_COMPANY;
	}

	public void setCATEGORY_WITH_COMPANY(String cATEGORY_WITH_COMPANY) {
		CATEGORY_WITH_COMPANY = cATEGORY_WITH_COMPANY;
	}

	public String getIDTYPE() {
		return IDTYPE;
	}

	public void setIDTYPE(String iDTYPE) {
		IDTYPE = iDTYPE;
	}

	public String getACTIVE_STATUS() {
		return ACTIVE_STATUS;
	}

	public void setACTIVE_STATUS(String aCTIVE_STATUS) {
		ACTIVE_STATUS = aCTIVE_STATUS;
	}

	public String getSIDEBAR_SCOPE() {
		return SIDEBAR_SCOPE;
	}

	public void setSIDEBAR_SCOPE(String sIDEBAR_SCOPE) {
		SIDEBAR_SCOPE = sIDEBAR_SCOPE;
	}

	@Override
	public String toString() {
		return "loginmaster [LOGINID=" + LOGINID + ", FULL_NAME=" + FULL_NAME + ", USERNAME=" + USERNAME + ", COMPANY="
				+ COMPANY + ", BRANCH=" + BRANCH + ", DEPARTMENT=" + DEPARTMENT + ", SUB_DEPARTMENT=" + SUB_DEPARTMENT
				+ ", LOCATION=" + LOCATION + ", PASSWORD=" + PASSWORD + ", EMAIL=" + EMAIL + ", PHONE=" + PHONE
				+ ", LOGIN_TYPE=" + LOGIN_TYPE + ", ROLE_TYPE=" + ROLE_TYPE + ", LEVEL=" + LEVEL + ", LOGIN_SCOPE="
				+ LOGIN_SCOPE + ", FIRST_LOGIN=" + FIRST_LOGIN + ", SECRETKEY=" + SECRETKEY + ", OTP=" + OTP
				+ ", HEADER_COLOR=" + HEADER_COLOR + ", SIDEBAR_COLOR=" + SIDEBAR_COLOR + ", SMALL_FONT=" + SMALL_FONT
				+ ", VIP_LOGIN=" + VIP_LOGIN + ", CATEGORY=" + CATEGORY + ", GROUP_NAME=" + GROUP_NAME
				+ ", DESIGNATION=" + DESIGNATION + ", VISIBILITY=" + VISIBILITY + ", REPORTING_TO_MANAGER="
				+ REPORTING_TO_MANAGER + ", CATEGORY_WITH_COMPANY=" + CATEGORY_WITH_COMPANY + ", IDTYPE=" + IDTYPE
				+ ", ACTIVE_STATUS=" + ACTIVE_STATUS + ", SIDEBAR_SCOPE=" + SIDEBAR_SCOPE + ", USER_ACTIVITY="
				+ USER_ACTIVITY + ", SEND_MAIL_DATE=" + SEND_MAIL_DATE + ", TOTAL_INACTIVE_DAYS=" + TOTAL_INACTIVE_DAYS
				+ ", mailOTP=" + mailOTP + ", TIMESTAMP=" + TIMESTAMP + ", REGISTRATION_DATE=" + REGISTRATION_DATE
				+ ", VIEW_DESIGNATION=" + VIEW_DESIGNATION + ", GENDER=" + GENDER + ", last_login_time="
				+ last_login_time + ", ACTIVE_USER=" + ACTIVE_USER + ", LOGIN_HISTORY=" + LOGIN_HISTORY + "]";
	}




	
	
	
	


	
	
	


	
	
	
}