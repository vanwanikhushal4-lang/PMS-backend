package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SMTP_REQUEST")
public class SMTP_REQUEST implements Serializable{
	private static final long serialVersionUID = 3125292147375419964L;
	@Id
	@Column
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GROUPNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAR_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAR_NAME_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_DATE;
	@Column(columnDefinition = "TEXT")
	private String APPROVAL_NOTE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String P_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_ID;
	@Column(columnDefinition = "TEXT")
	private String ATTACH_NAME;

	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR;
	@Column(columnDefinition = "TEXT")
	private String ML_APPROVAR_NOTE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_DATE;
	@Column(columnDefinition = "TEXT")
	private String CLOSED_REASON;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String RE_OPENED_DATE;
	@Column(columnDefinition = "TEXT")
	private String RE_OPENED_REASON;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPLICATION_SERVER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPLICATION_SERVER_IP;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVER_LOCATION_CODE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAIL_CHECK;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAILS_PER_DAY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAIL_SIZE;
	@Column(columnDefinition = "TEXT")
	private String EXPIRY_DATE;
	@Column(columnDefinition = "TEXT")
	private String DESCRIPTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVER_LOCATION_CITY;
	public SMTP_REQUEST() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getGROUPNAME() {
		return GROUPNAME;
	}
	public void setGROUPNAME(String gROUPNAME) {
		GROUPNAME = gROUPNAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getAPPROVAR_NAME() {
		return APPROVAR_NAME;
	}
	public void setAPPROVAR_NAME(String aPPROVAR_NAME) {
		APPROVAR_NAME = aPPROVAR_NAME;
	}
	public String getAPPROVAR_NAME_FULLNAME() {
		return APPROVAR_NAME_FULLNAME;
	}
	public void setAPPROVAR_NAME_FULLNAME(String aPPROVAR_NAME_FULLNAME) {
		APPROVAR_NAME_FULLNAME = aPPROVAR_NAME_FULLNAME;
	}
	public String getAPPROVAR_DATE() {
		return APPROVAR_DATE;
	}
	public void setAPPROVAR_DATE(String aPPROVAR_DATE) {
		APPROVAR_DATE = aPPROVAR_DATE;
	}
	public String getAPPROVAL_NOTE() {
		return APPROVAL_NOTE;
	}
	public void setAPPROVAL_NOTE(String aPPROVAL_NOTE) {
		APPROVAL_NOTE = aPPROVAL_NOTE;
	}
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}
	public String getRAISED_DATE() {
		return RAISED_DATE;
	}
	public void setRAISED_DATE(String rAISED_DATE) {
		RAISED_DATE = rAISED_DATE;
	}
	public String getT_COMPANY() {
		return T_COMPANY;
	}
	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}
	public String getT_BRANCH() {
		return T_BRANCH;
	}
	public void setT_BRANCH(String t_BRANCH) {
		T_BRANCH = t_BRANCH;
	}
	public String getT_DEPARTMENT() {
		return T_DEPARTMENT;
	}
	public void setT_DEPARTMENT(String t_DEPARTMENT) {
		T_DEPARTMENT = t_DEPARTMENT;
	}
	public String getT_REQUESTER() {
		return T_REQUESTER;
	}
	public void setT_REQUESTER(String t_REQUESTER) {
		T_REQUESTER = t_REQUESTER;
	}
	public String getT_REQUESTER_FULLNAME() {
		return T_REQUESTER_FULLNAME;
	}
	public void setT_REQUESTER_FULLNAME(String t_REQUESTER_FULLNAME) {
		T_REQUESTER_FULLNAME = t_REQUESTER_FULLNAME;
	}
	public String getT_PHONE() {
		return T_PHONE;
	}
	public void setT_PHONE(String t_PHONE) {
		T_PHONE = t_PHONE;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getATTACH_NAME() {
		return ATTACH_NAME;
	}
	public void setATTACH_NAME(String aTTACH_NAME) {
		ATTACH_NAME = aTTACH_NAME;
	}
	public String getML_APPROVAR() {
		return ML_APPROVAR;
	}
	public void setML_APPROVAR(String mL_APPROVAR) {
		ML_APPROVAR = mL_APPROVAR;
	}
	public String getML_APPROVAR_NOTE() {
		return ML_APPROVAR_NOTE;
	}
	public void setML_APPROVAR_NOTE(String mL_APPROVAR_NOTE) {
		ML_APPROVAR_NOTE = mL_APPROVAR_NOTE;
	}
	public String getML_APPROVAR_FULLNAME() {
		return ML_APPROVAR_FULLNAME;
	}
	public void setML_APPROVAR_FULLNAME(String mL_APPROVAR_FULLNAME) {
		ML_APPROVAR_FULLNAME = mL_APPROVAR_FULLNAME;
	}
	public String getML_APPROVAR_DATE() {
		return ML_APPROVAR_DATE;
	}
	public void setML_APPROVAR_DATE(String mL_APPROVAR_DATE) {
		ML_APPROVAR_DATE = mL_APPROVAR_DATE;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	public String getCLOSED_BY() {
		return CLOSED_BY;
	}
	public void setCLOSED_BY(String cLOSED_BY) {
		CLOSED_BY = cLOSED_BY;
	}
	public String getCLOSED_BY_FULLNAME() {
		return CLOSED_BY_FULLNAME;
	}
	public void setCLOSED_BY_FULLNAME(String cLOSED_BY_FULLNAME) {
		CLOSED_BY_FULLNAME = cLOSED_BY_FULLNAME;
	}
	public String getCLOSED_DATE() {
		return CLOSED_DATE;
	}
	public void setCLOSED_DATE(String cLOSED_DATE) {
		CLOSED_DATE = cLOSED_DATE;
	}
	public String getCLOSED_REASON() {
		return CLOSED_REASON;
	}
	public void setCLOSED_REASON(String cLOSED_REASON) {
		CLOSED_REASON = cLOSED_REASON;
	}
	public String getRE_OPENED_BY() {
		return RE_OPENED_BY;
	}
	public void setRE_OPENED_BY(String rE_OPENED_BY) {
		RE_OPENED_BY = rE_OPENED_BY;
	}
	public String getRE_OPENED_BY_FULLNAME() {
		return RE_OPENED_BY_FULLNAME;
	}
	public void setRE_OPENED_BY_FULLNAME(String rE_OPENED_BY_FULLNAME) {
		RE_OPENED_BY_FULLNAME = rE_OPENED_BY_FULLNAME;
	}
	public String getRE_OPENED_DATE() {
		return RE_OPENED_DATE;
	}
	public void setRE_OPENED_DATE(String rE_OPENED_DATE) {
		RE_OPENED_DATE = rE_OPENED_DATE;
	}
	public String getRE_OPENED_REASON() {
		return RE_OPENED_REASON;
	}
	public void setRE_OPENED_REASON(String rE_OPENED_REASON) {
		RE_OPENED_REASON = rE_OPENED_REASON;
	}
	public String getAPPLICATION_SERVER() {
		return APPLICATION_SERVER;
	}
	public void setAPPLICATION_SERVER(String aPPLICATION_SERVER) {
		APPLICATION_SERVER = aPPLICATION_SERVER;
	}
	public String getAPPLICATION_SERVER_IP() {
		return APPLICATION_SERVER_IP;
	}
	public void setAPPLICATION_SERVER_IP(String aPPLICATION_SERVER_IP) {
		APPLICATION_SERVER_IP = aPPLICATION_SERVER_IP;
	}
	public String getSERVER_LOCATION_CODE() {
		return SERVER_LOCATION_CODE;
	}
	public void setSERVER_LOCATION_CODE(String sERVER_LOCATION_CODE) {
		SERVER_LOCATION_CODE = sERVER_LOCATION_CODE;
	}
	public String getSERVER_LOCATION_CITY() {
		return SERVER_LOCATION_CITY;
	}
	public void setSERVER_LOCATION_CITY(String sERVER_LOCATION_CITY) {
		SERVER_LOCATION_CITY = sERVER_LOCATION_CITY;
	}
	public String getMAILS_PER_DAY() {
		return MAILS_PER_DAY;
	}
	public void setMAILS_PER_DAY(String mAILS_PER_DAY) {
		MAILS_PER_DAY = mAILS_PER_DAY;
	}
	public String getMAIL_SIZE() {
		return MAIL_SIZE;
	}
	public void setMAIL_SIZE(String mAIL_SIZE) {
		MAIL_SIZE = mAIL_SIZE;
	}
	public String getEXPIRY_DATE() {
		return EXPIRY_DATE;
	}
	public void setEXPIRY_DATE(String eXPIRY_DATE) {
		EXPIRY_DATE = eXPIRY_DATE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMAIL_CHECK() {
		return MAIL_CHECK;
	}
	public void setMAIL_CHECK(String mAIL_CHECK) {
		MAIL_CHECK = mAIL_CHECK;
	}
	@Override
	public String toString() {
		return "SMTP_REQUEST [SRNO=" + SRNO + ", T_ID=" + T_ID + ", GROUPNAME=" + GROUPNAME + ", STATUS=" + STATUS
				+ ", APPROVAR_NAME=" + APPROVAR_NAME + ", APPROVAR_NAME_FULLNAME=" + APPROVAR_NAME_FULLNAME
				+ ", APPROVAR_DATE=" + APPROVAR_DATE + ", APPROVAL_NOTE=" + APPROVAL_NOTE + ", P_ID=" + P_ID
				+ ", RAISED_DATE=" + RAISED_DATE + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH
				+ ", T_DEPARTMENT=" + T_DEPARTMENT + ", T_REQUESTER=" + T_REQUESTER + ", T_REQUESTER_FULLNAME="
				+ T_REQUESTER_FULLNAME + ", T_PHONE=" + T_PHONE + ", EMAIL_ID=" + EMAIL_ID + ", ATTACH_NAME="
				+ ATTACH_NAME + ", ML_APPROVAR=" + ML_APPROVAR + ", ML_APPROVAR_NOTE=" + ML_APPROVAR_NOTE
				+ ", ML_APPROVAR_FULLNAME=" + ML_APPROVAR_FULLNAME + ", ML_APPROVAR_DATE=" + ML_APPROVAR_DATE
				+ ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY + ", CLOSED_BY=" + CLOSED_BY
				+ ", CLOSED_BY_FULLNAME=" + CLOSED_BY_FULLNAME + ", CLOSED_DATE=" + CLOSED_DATE + ", CLOSED_REASON="
				+ CLOSED_REASON + ", RE_OPENED_BY=" + RE_OPENED_BY + ", RE_OPENED_BY_FULLNAME=" + RE_OPENED_BY_FULLNAME
				+ ", RE_OPENED_DATE=" + RE_OPENED_DATE + ", RE_OPENED_REASON=" + RE_OPENED_REASON
				+ ", APPLICATION_SERVER=" + APPLICATION_SERVER + ", APPLICATION_SERVER_IP=" + APPLICATION_SERVER_IP
				+ ", SERVER_LOCATION_CODE=" + SERVER_LOCATION_CODE + ", MAIL_CHECK=" + MAIL_CHECK + ", MAILS_PER_DAY="
				+ MAILS_PER_DAY + ", MAIL_SIZE=" + MAIL_SIZE + ", EXPIRY_DATE=" + EXPIRY_DATE + ", DESCRIPTION="
				+ DESCRIPTION + ", SERVER_LOCATION_CITY=" + SERVER_LOCATION_CITY + "]";
	}
	
	

	
	
}
