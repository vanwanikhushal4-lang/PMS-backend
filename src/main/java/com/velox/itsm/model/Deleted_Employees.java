package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Deleted_Employees")
public class Deleted_Employees implements Serializable
{
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
	private String SIDEBAR_SCOPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GENDER;

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
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

	public String getSIDEBAR_SCOPE() {
		return SIDEBAR_SCOPE;
	}

	public void setSIDEBAR_SCOPE(String sIDEBAR_SCOPE) {
		SIDEBAR_SCOPE = sIDEBAR_SCOPE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Deleted_Employees [LOGINID=" + LOGINID + ", FULL_NAME=" + FULL_NAME + ", USERNAME=" + USERNAME
				+ ", COMPANY=" + COMPANY + ", BRANCH=" + BRANCH + ", DEPARTMENT=" + DEPARTMENT + ", SUB_DEPARTMENT="
				+ SUB_DEPARTMENT + ", LOCATION=" + LOCATION + ", PASSWORD=" + PASSWORD + ", EMAIL=" + EMAIL + ", PHONE="
				+ PHONE + ", LOGIN_TYPE=" + LOGIN_TYPE + ", ROLE_TYPE=" + ROLE_TYPE + ", LEVEL=" + LEVEL
				+ ", LOGIN_SCOPE=" + LOGIN_SCOPE + ", FIRST_LOGIN=" + FIRST_LOGIN + ", SECRETKEY=" + SECRETKEY
				+ ", OTP=" + OTP + ", HEADER_COLOR=" + HEADER_COLOR + ", SIDEBAR_COLOR=" + SIDEBAR_COLOR
				+ ", SMALL_FONT=" + SMALL_FONT + ", VIP_LOGIN=" + VIP_LOGIN + ", CATEGORY=" + CATEGORY + ", GROUP_NAME="
				+ GROUP_NAME + ", DESIGNATION=" + DESIGNATION + ", VISIBILITY=" + VISIBILITY + ", REPORTING_TO_MANAGER="
				+ REPORTING_TO_MANAGER + ", CATEGORY_WITH_COMPANY=" + CATEGORY_WITH_COMPANY + ", IDTYPE=" + IDTYPE
				+ ", SIDEBAR_SCOPE=" + SIDEBAR_SCOPE + ", GENDER=" + GENDER + "]";
	}


	
	
	
	
	
}
