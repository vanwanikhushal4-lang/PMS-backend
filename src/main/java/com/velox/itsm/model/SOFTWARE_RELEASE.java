package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SOFTWARE_RELEASE implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PID;
	
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_NAME;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_NAME_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_DATE;
	@Column(columnDefinition = "TEXT")
	private String APPROVAL_NOTE;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_ID;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GROUPNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RT_APPROVAL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RT_APPROVAL_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RT_APPROVAL_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String S_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPLIED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_CODE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String IT_COMPIANCE_APPROVAL_DESC;
	
	@Column(columnDefinition = "TEXT")
	private String RT_APPROVAL_DESCRIPTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "TEXT")
	private String RE_OPENED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_NAME;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_NAME_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_DATE;
	
	@Column(columnDefinition = "TEXT")
	private String ATTACH_NAME;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String SERVER_IP;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String SERVER_OWNER;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String SERVER_HOST;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String LAP_DESK_ASSET_CODE;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String LAP_DESK_IP;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String LAP_DESK_STATUS;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String LAP_DESK_COMPUTER_NAME;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String NT_APPROVER_NAME;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String NT_APPROVER_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String NT_DESCRIPTION;
	@Column(columnDefinition = "NVARCHAR(200)")
	private String NT_APPROVER_DATE;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String MAIL_APPROVER_NAME;
	
	@Column(columnDefinition = "NVARCHAR(200)")
	private String MAIL_APPROVER_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String MAIL_DESCRIPTION;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String MAIL_APPROVER_DATE;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String REQUEST_CATEGORY;
	@Column(columnDefinition = "TEXT")
	private String CLOSE_REASON;
	public SOFTWARE_RELEASE() {
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
	public String getRAISED_DATE() {
		return RAISED_DATE;
	}
	public void setRAISED_DATE(String rAISED_DATE) {
		RAISED_DATE = rAISED_DATE;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getGROUPNAME() {
		return GROUPNAME;
	}
	public void setGROUPNAME(String gROUPNAME) {
		GROUPNAME = gROUPNAME;
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
	public String getRT_APPROVAL() {
		return RT_APPROVAL;
	}
	public void setRT_APPROVAL(String rT_APPROVAL) {
		RT_APPROVAL = rT_APPROVAL;
	}
	public String getRT_APPROVAL_FULLNAME() {
		return RT_APPROVAL_FULLNAME;
	}
	public void setRT_APPROVAL_FULLNAME(String rT_APPROVAL_FULLNAME) {
		RT_APPROVAL_FULLNAME = rT_APPROVAL_FULLNAME;
	}
	public String getRE_OPENED_DATE() {
		return RE_OPENED_DATE;
	}
	public void setRE_OPENED_DATE(String rE_OPENED_DATE) {
		RE_OPENED_DATE = rE_OPENED_DATE;
	}
	public String getRE_OPENED_BY() {
		return RE_OPENED_BY;
	}
	public void setRE_OPENED_BY(String rE_OPENED_BY) {
		RE_OPENED_BY = rE_OPENED_BY;
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
	public String getRT_APPROVAL_DATE() {
		return RT_APPROVAL_DATE;
	}
	public void setRT_APPROVAL_DATE(String rT_APPROVAL_DATE) {
		RT_APPROVAL_DATE = rT_APPROVAL_DATE;
	}
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public String getAPPLIED_DATE() {
		return APPLIED_DATE;
	}
	public void setAPPLIED_DATE(String aPPLIED_DATE) {
		APPLIED_DATE = aPPLIED_DATE;
	}
	public String getASSET_CODE() {
		return ASSET_CODE;
	}
	public void setASSET_CODE(String aSSET_CODE) {
		ASSET_CODE = aSSET_CODE;
	}
	public String getIT_COMPIANCE_APPROVAL_DESC() {
		return IT_COMPIANCE_APPROVAL_DESC;
	}
	public void setIT_COMPIANCE_APPROVAL_DESC(String iT_COMPIANCE_APPROVAL_DESC) {
		IT_COMPIANCE_APPROVAL_DESC = iT_COMPIANCE_APPROVAL_DESC;
	}
	public String getRT_APPROVAL_DESCRIPTION() {
		return RT_APPROVAL_DESCRIPTION;
	}
	public void setRT_APPROVAL_DESCRIPTION(String rT_APPROVAL_DESCRIPTION) {
		RT_APPROVAL_DESCRIPTION = rT_APPROVAL_DESCRIPTION;
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
	public String getRE_OPENED_BY_FULLNAME() {
		return RE_OPENED_BY_FULLNAME;
	}
	public void setRE_OPENED_BY_FULLNAME(String rE_OPENED_BY_FULLNAME) {
		RE_OPENED_BY_FULLNAME = rE_OPENED_BY_FULLNAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getT_DESC() {
		return T_DESC;
	}
	public void setT_DESC(String t_DESC) {
		T_DESC = t_DESC;
	}
	public String getIT_COMPIANCE_APPROVAL_NAME() {
		return IT_COMPIANCE_APPROVAL_NAME;
	}
	public void setIT_COMPIANCE_APPROVAL_NAME(String iT_COMPIANCE_APPROVAL_NAME) {
		IT_COMPIANCE_APPROVAL_NAME = iT_COMPIANCE_APPROVAL_NAME;
	}
	public String getIT_COMPIANCE_APPROVAL_NAME_FULLNAME() {
		return IT_COMPIANCE_APPROVAL_NAME_FULLNAME;
	}
	public void setIT_COMPIANCE_APPROVAL_NAME_FULLNAME(String iT_COMPIANCE_APPROVAL_NAME_FULLNAME) {
		IT_COMPIANCE_APPROVAL_NAME_FULLNAME = iT_COMPIANCE_APPROVAL_NAME_FULLNAME;
	}
	public String getIT_COMPIANCE_APPROVAL_DATE() {
		return IT_COMPIANCE_APPROVAL_DATE;
	}
	public void setIT_COMPIANCE_APPROVAL_DATE(String iT_COMPIANCE_APPROVAL_DATE) {
		IT_COMPIANCE_APPROVAL_DATE = iT_COMPIANCE_APPROVAL_DATE;
	}
	public String getATTACH_NAME() {
		return ATTACH_NAME;
	}
	public void setATTACH_NAME(String aTTACH_NAME) {
		ATTACH_NAME = aTTACH_NAME;
	}
	public String getSERVER_IP() {
		return SERVER_IP;
	}
	public void setSERVER_IP(String sERVER_IP) {
		SERVER_IP = sERVER_IP;
	}
	public String getSERVER_OWNER() {
		return SERVER_OWNER;
	}
	public void setSERVER_OWNER(String sERVER_OWNER) {
		SERVER_OWNER = sERVER_OWNER;
	}
	public String getSERVER_HOST() {
		return SERVER_HOST;
	}
	public void setSERVER_HOST(String sERVER_HOST) {
		SERVER_HOST = sERVER_HOST;
	}
	public String getLAP_DESK_ASSET_CODE() {
		return LAP_DESK_ASSET_CODE;
	}
	public void setLAP_DESK_ASSET_CODE(String lAP_DESK_ASSET_CODE) {
		LAP_DESK_ASSET_CODE = lAP_DESK_ASSET_CODE;
	}
	public String getLAP_DESK_IP() {
		return LAP_DESK_IP;
	}
	public void setLAP_DESK_IP(String lAP_DESK_IP) {
		LAP_DESK_IP = lAP_DESK_IP;
	}
	public String getLAP_DESK_STATUS() {
		return LAP_DESK_STATUS;
	}
	public void setLAP_DESK_STATUS(String lAP_DESK_STATUS) {
		LAP_DESK_STATUS = lAP_DESK_STATUS;
	}
	public String getLAP_DESK_COMPUTER_NAME() {
		return LAP_DESK_COMPUTER_NAME;
	}
	public void setLAP_DESK_COMPUTER_NAME(String lAP_DESK_COMPUTER_NAME) {
		LAP_DESK_COMPUTER_NAME = lAP_DESK_COMPUTER_NAME;
	}
	public String getNT_APPROVER_NAME() {
		return NT_APPROVER_NAME;
	}
	public void setNT_APPROVER_NAME(String nT_APPROVER_NAME) {
		NT_APPROVER_NAME = nT_APPROVER_NAME;
	}
	public String getNT_APPROVER_FULLNAME() {
		return NT_APPROVER_FULLNAME;
	}
	public void setNT_APPROVER_FULLNAME(String nT_APPROVER_FULLNAME) {
		NT_APPROVER_FULLNAME = nT_APPROVER_FULLNAME;
	}
	public String getNT_DESCRIPTION() {
		return NT_DESCRIPTION;
	}
	public void setNT_DESCRIPTION(String nT_DESCRIPTION) {
		NT_DESCRIPTION = nT_DESCRIPTION;
	}
	public String getNT_APPROVER_DATE() {
		return NT_APPROVER_DATE;
	}
	public void setNT_APPROVER_DATE(String nT_APPROVER_DATE) {
		NT_APPROVER_DATE = nT_APPROVER_DATE;
	}
	public String getMAIL_APPROVER_NAME() {
		return MAIL_APPROVER_NAME;
	}
	public void setMAIL_APPROVER_NAME(String mAIL_APPROVER_NAME) {
		MAIL_APPROVER_NAME = mAIL_APPROVER_NAME;
	}
	public String getMAIL_APPROVER_FULLNAME() {
		return MAIL_APPROVER_FULLNAME;
	}
	public void setMAIL_APPROVER_FULLNAME(String mAIL_APPROVER_FULLNAME) {
		MAIL_APPROVER_FULLNAME = mAIL_APPROVER_FULLNAME;
	}
	public String getMAIL_DESCRIPTION() {
		return MAIL_DESCRIPTION;
	}
	public void setMAIL_DESCRIPTION(String mAIL_DESCRIPTION) {
		MAIL_DESCRIPTION = mAIL_DESCRIPTION;
	}
	public String getMAIL_APPROVER_DATE() {
		return MAIL_APPROVER_DATE;
	}
	public void setMAIL_APPROVER_DATE(String mAIL_APPROVER_DATE) {
		MAIL_APPROVER_DATE = mAIL_APPROVER_DATE;
	}
	public String getREQUEST_CATEGORY() {
		return REQUEST_CATEGORY;
	}
	public void setREQUEST_CATEGORY(String rEQUEST_CATEGORY) {
		REQUEST_CATEGORY = rEQUEST_CATEGORY;
	}
	public String getCLOSE_REASON() {
		return CLOSE_REASON;
	}
	public void setCLOSE_REASON(String cLOSE_REASON) {
		CLOSE_REASON = cLOSE_REASON;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getPID() {
		return PID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	@Override
	public String toString() {
		return "SOFTWARE_RELEASE [SRNO=" + SRNO + ", T_ID=" + T_ID + ", PID=" + PID + ", APPROVAR_NAME=" + APPROVAR_NAME
				+ ", APPROVAR_NAME_FULLNAME=" + APPROVAR_NAME_FULLNAME + ", APPROVAR_DATE=" + APPROVAR_DATE
				+ ", APPROVAL_NOTE=" + APPROVAL_NOTE + ", CLOSED_BY=" + CLOSED_BY + ", CLOSED_BY_FULLNAME="
				+ CLOSED_BY_FULLNAME + ", CLOSED_DATE=" + CLOSED_DATE + ", RAISED_DATE=" + RAISED_DATE + ", EMAIL_ID="
				+ EMAIL_ID + ", GROUPNAME=" + GROUPNAME + ", T_REQUESTER=" + T_REQUESTER + ", T_REQUESTER_FULLNAME="
				+ T_REQUESTER_FULLNAME + ", T_PHONE=" + T_PHONE + ", RT_APPROVAL=" + RT_APPROVAL
				+ ", RT_APPROVAL_FULLNAME=" + RT_APPROVAL_FULLNAME + ", RE_OPENED_DATE=" + RE_OPENED_DATE
				+ ", RE_OPENED_BY=" + RE_OPENED_BY + ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY
				+ ", RT_APPROVAL_DATE=" + RT_APPROVAL_DATE + ", S_NAME=" + S_NAME + ", APPLIED_DATE=" + APPLIED_DATE
				+ ", ASSET_CODE=" + ASSET_CODE + ", IT_COMPIANCE_APPROVAL_DESC=" + IT_COMPIANCE_APPROVAL_DESC
				+ ", RT_APPROVAL_DESCRIPTION=" + RT_APPROVAL_DESCRIPTION + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH="
				+ T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT + ", RE_OPENED_BY_FULLNAME=" + RE_OPENED_BY_FULLNAME
				+ ", STATUS=" + STATUS + ", T_DESC=" + T_DESC + ", IT_COMPIANCE_APPROVAL_NAME="
				+ IT_COMPIANCE_APPROVAL_NAME + ", IT_COMPIANCE_APPROVAL_NAME_FULLNAME="
				+ IT_COMPIANCE_APPROVAL_NAME_FULLNAME + ", IT_COMPIANCE_APPROVAL_DATE=" + IT_COMPIANCE_APPROVAL_DATE
				+ ", ATTACH_NAME=" + ATTACH_NAME + ", SERVER_IP=" + SERVER_IP + ", SERVER_OWNER=" + SERVER_OWNER
				+ ", SERVER_HOST=" + SERVER_HOST + ", LAP_DESK_ASSET_CODE=" + LAP_DESK_ASSET_CODE + ", LAP_DESK_IP="
				+ LAP_DESK_IP + ", LAP_DESK_STATUS=" + LAP_DESK_STATUS + ", LAP_DESK_COMPUTER_NAME="
				+ LAP_DESK_COMPUTER_NAME + ", NT_APPROVER_NAME=" + NT_APPROVER_NAME + ", NT_APPROVER_FULLNAME="
				+ NT_APPROVER_FULLNAME + ", NT_DESCRIPTION=" + NT_DESCRIPTION + ", NT_APPROVER_DATE=" + NT_APPROVER_DATE
				+ ", MAIL_APPROVER_NAME=" + MAIL_APPROVER_NAME + ", MAIL_APPROVER_FULLNAME=" + MAIL_APPROVER_FULLNAME
				+ ", MAIL_DESCRIPTION=" + MAIL_DESCRIPTION + ", MAIL_APPROVER_DATE=" + MAIL_APPROVER_DATE
				+ ", REQUEST_CATEGORY=" + REQUEST_CATEGORY + ", CLOSE_REASON=" + CLOSE_REASON + "]";
	}

	
	
	
	
	
}
