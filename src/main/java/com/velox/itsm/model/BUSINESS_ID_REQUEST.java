package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BUSINESS_ID_REQUEST")
public class BUSINESS_ID_REQUEST implements Serializable {

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
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAR_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAR_NAME_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String P_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DESC;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ATTACH_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAL_DESCRIPTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAL_NOTE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVAR_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_USERLNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_FULLNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_NOTE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BUSINESS_TYPE_ID;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DOMAIN;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BUSINESS_TYPE_ID_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REQUEST_TYPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TEMP_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GALUPDATE_USERNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GALUPDATE_FULLNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GALUPDATE_NOTE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GALUPDATE_APPROVAL_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String GROUPNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY_FULLNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_DATE;  
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DESCRIPTION;  
	
	
	// Getter and Setter Method
	
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
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getAPPROVAR_DATE() {
		return APPROVAR_DATE;
	}
	public void setAPPROVAR_DATE(String aPPROVAR_DATE) {
		APPROVAR_DATE = aPPROVAR_DATE;
	}
	public String getAPPROVAR_NAME_FULLNAME() {
		return APPROVAR_NAME_FULLNAME;
	}
	public void setAPPROVAR_NAME_FULLNAME(String aPPROVAR_NAME_FULLNAME) {
		APPROVAR_NAME_FULLNAME = aPPROVAR_NAME_FULLNAME;
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
	public String getT_BRANCH() {
		return T_BRANCH;
	}
	public void setT_BRANCH(String t_BRANCH) {
		T_BRANCH = t_BRANCH;
	}
	public String getT_COMPANY() {
		return T_COMPANY;
	}
	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}
	public String getT_DEPARTMENT() {
		return T_DEPARTMENT;
	}
	public void setT_DEPARTMENT(String t_DEPARTMENT) {
		T_DEPARTMENT = t_DEPARTMENT;
	}
	public String getT_DESC() {
		return T_DESC;
	}
	public void setT_DESC(String t_DESC) {
		T_DESC = t_DESC;
	}
	public String getT_PHONE() {
		return T_PHONE;
	}
	public void setT_PHONE(String t_PHONE) {
		T_PHONE = t_PHONE;
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
	public String getAPPROVAL_DESCRIPTION() {
		return APPROVAL_DESCRIPTION;
	}
	public void setAPPROVAL_DESCRIPTION(String aPPROVAL_DESCRIPTION) {
		APPROVAL_DESCRIPTION = aPPROVAL_DESCRIPTION;
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
	public String getAPPROVAR_NAME() {
		return APPROVAR_NAME;
	}
	public void setAPPROVAR_NAME(String aPPROVAR_NAME) {
		APPROVAR_NAME = aPPROVAR_NAME;
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
	public String getML_APPROVAR_NOTE() {
		return ML_APPROVAR_NOTE;
	}
	public void setML_APPROVAR_NOTE(String mL_APPROVAR_NOTE) {
		ML_APPROVAR_NOTE = mL_APPROVAR_NOTE;
	}

	public String getBUSINESS_TYPE_ID() {
		return BUSINESS_TYPE_ID;
	}
	public void setBUSINESS_TYPE_ID(String bUSINESS_TYPE_ID) {
		BUSINESS_TYPE_ID = bUSINESS_TYPE_ID;
	}
	public String getBUSINESS_TYPE_ID_NAME() {
		return BUSINESS_TYPE_ID_NAME;
	}
	public void setBUSINESS_TYPE_ID_NAME(String bUSINESS_TYPE_ID_NAME) {
		BUSINESS_TYPE_ID_NAME = bUSINESS_TYPE_ID_NAME;
	}
	public String getREQUEST_TYPE() {
		return REQUEST_TYPE;
	}
	public void setREQUEST_TYPE(String rEQUEST_TYPE) {
		REQUEST_TYPE = rEQUEST_TYPE;
	}
	public String getTEMP_DATE() {
		return TEMP_DATE;
	}
	public void setTEMP_DATE(String tEMP_DATE) {
		TEMP_DATE = tEMP_DATE;
	}
	
	public String getDOMAIN() {
		return DOMAIN;
	}
	public void setDOMAIN(String dOMAIN) {
		DOMAIN = dOMAIN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	public String getML_APPROVAR_USERLNAME() {
		return ML_APPROVAR_USERLNAME;
	}
	public void setML_APPROVAR_USERLNAME(String mL_APPROVAR_USERLNAME) {
		ML_APPROVAR_USERLNAME = mL_APPROVAR_USERLNAME;
	}
	public String getGALUPDATE_USERNAME() {
		return GALUPDATE_USERNAME;
	}
	public void setGALUPDATE_USERNAME(String gALUPDATE_USERNAME) {
		GALUPDATE_USERNAME = gALUPDATE_USERNAME;
	}
	public String getGALUPDATE_FULLNAME() {
		return GALUPDATE_FULLNAME;
	}
	public void setGALUPDATE_FULLNAME(String gALUPDATE_FULLNAME) {
		GALUPDATE_FULLNAME = gALUPDATE_FULLNAME;
	}
	public String getGALUPDATE_NOTE() {
		return GALUPDATE_NOTE;
	}
	public void setGALUPDATE_NOTE(String gALUPDATE_NOTE) {
		GALUPDATE_NOTE = gALUPDATE_NOTE;
	}
	public String getGALUPDATE_APPROVAL_DATE() {
		return GALUPDATE_APPROVAL_DATE;
	}
	public void setGALUPDATE_APPROVAL_DATE(String gALUPDATE_APPROVAL_DATE) {
		GALUPDATE_APPROVAL_DATE = gALUPDATE_APPROVAL_DATE;
	}
	
	
	public String getGROUPNAME() {
		return GROUPNAME;
	}
	public void setGROUPNAME(String gROUPNAME) {
		GROUPNAME = gROUPNAME;
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
	
	
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	// toString() method
	@Override
	public String toString() {
		return "BUSINESS_ID_REQUEST [SRNO=" + SRNO + ", T_ID=" + T_ID + ", STATUS=" + STATUS + ", APPROVAR_DATE="
				+ APPROVAR_DATE + ", APPROVAR_NAME_FULLNAME=" + APPROVAR_NAME_FULLNAME + ", P_ID=" + P_ID
				+ ", RAISED_DATE=" + RAISED_DATE + ", T_BRANCH=" + T_BRANCH + ", T_COMPANY=" + T_COMPANY
				+ ", T_DEPARTMENT=" + T_DEPARTMENT + ", T_DESC=" + T_DESC + ", T_PHONE=" + T_PHONE + ", T_REQUESTER="
				+ T_REQUESTER + ", T_REQUESTER_FULLNAME=" + T_REQUESTER_FULLNAME + ", EMAIL_ID=" + EMAIL_ID
				+ ", ATTACH_NAME=" + ATTACH_NAME + ", APPROVAL_DESCRIPTION=" + APPROVAL_DESCRIPTION + ", APPROVAL_NOTE="
				+ APPROVAL_NOTE + ", CLOSED_BY=" + CLOSED_BY + ", CLOSED_BY_FULLNAME=" + CLOSED_BY_FULLNAME
				+ ", CLOSED_DATE=" + CLOSED_DATE + ", APPROVAR_NAME=" + APPROVAR_NAME + ", PRIORITY=" + PRIORITY
				+ ", SEVERITY=" + SEVERITY + ", ML_APPROVAR_USERLNAME=" + ML_APPROVAR_USERLNAME
				+ ", ML_APPROVAR_FULLNAME=" + ML_APPROVAR_FULLNAME + ", ML_APPROVAR_DATE=" + ML_APPROVAR_DATE
				+ ", ML_APPROVAR_NOTE=" + ML_APPROVAR_NOTE + ", BUSINESS_TYPE_ID=" + BUSINESS_TYPE_ID + ", DOMAIN="
				+ DOMAIN + ", BUSINESS_TYPE_ID_NAME=" + BUSINESS_TYPE_ID_NAME + ", REQUEST_TYPE=" + REQUEST_TYPE
				+ ", TEMP_DATE=" + TEMP_DATE + ", GALUPDATE_USERNAME=" + GALUPDATE_USERNAME + ", GALUPDATE_FULLNAME="
				+ GALUPDATE_FULLNAME + ", GALUPDATE_NOTE=" + GALUPDATE_NOTE + ", GALUPDATE_APPROVAL_DATE="
				+ GALUPDATE_APPROVAL_DATE + ", GROUPNAME=" + GROUPNAME + ", RE_OPENED_BY=" + RE_OPENED_BY
				+ ", RE_OPENED_BY_FULLNAME=" + RE_OPENED_BY_FULLNAME + ", RE_OPENED_DATE=" + RE_OPENED_DATE
				+ ", DESCRIPTION=" + DESCRIPTION + "]";
	}
	
	
	
}
