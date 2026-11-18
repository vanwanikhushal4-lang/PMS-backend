package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SOFTWARE_REQUEST")
public class SOFTWARE_REQUEST implements Serializable{

	private static final long serialVersionUID = 3125292147375419964L;
	@Id
	@Column
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_TAG;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY;
	@Column(columnDefinition = "TEXT")
	private String CLOSED_REASON;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSETCHECK;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUB_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String IP_ADDRESS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_ID;
	
	@Column(columnDefinition = "TEXT")
	private String GROUPNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RT_APPROVAL;
	@Column(columnDefinition = "TEXT")
	private String RT_APPROVAL_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_DATE;
	@Column(columnDefinition = "TEXT")
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
	private String S_COST;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String S_PERIOD;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_DESC;
	
	@Column(columnDefinition = "TEXT")
	private String RT_APPROVAL_DESCRIPTION;
	@Column(columnDefinition = "TEXT")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPENED_BY_FULLNAME;
	
	////////new column fortypecategory///////
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_NAME_CR;
	@Column(columnDefinition = "TEXT")
	private String CATEGORY_REQUEST;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVER_IP_CR;	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LAPTOP_IP_CR;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_STATUS_CR;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWNER_NAME_CR;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR;
	@Column(columnDefinition = "TEXT")
	private String ML_APPROVAR_NOTE;
	@Column(columnDefinition = "TEXT")
	private String ML_APPROVAR_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ML_APPROVAR_DATE;
	
	private String SERVER_IP_ADDRESS;
	

	public String getSERVER_IP_ADDRESS() {
		return SERVER_IP_ADDRESS;
	}

	public void setSERVER_IP_ADDRESS(String sERVER_IP_ADDRESS) {
		SERVER_IP_ADDRESS = sERVER_IP_ADDRESS;
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

	public String getASSET_NAME_CR() {
		return ASSET_NAME_CR;
	}
	
	public void setASSET_NAME_CR(String aSSET_NAME_CR) {
		ASSET_NAME_CR = aSSET_NAME_CR;
	}
	public String getCATEGORY_REQUEST() {
		return CATEGORY_REQUEST;
	}
	public void setCATEGORY_REQUEST(String cATEGORY_REQUEST) {
		CATEGORY_REQUEST = cATEGORY_REQUEST;
	}
	public String getSERVER_IP_CR() {
		return SERVER_IP_CR;
	}
	public void setSERVER_IP_CR(String sERVER_IP_CR) {
		SERVER_IP_CR = sERVER_IP_CR;
	}
	public String getLAPTOP_IP_CR() {
		return LAPTOP_IP_CR;
	}
	public void setLAPTOP_IP_CR(String lAPTOP_IP_CR) {
		LAPTOP_IP_CR = lAPTOP_IP_CR;
	}
	public String getASSET_STATUS_CR() {
		return ASSET_STATUS_CR;
	}
	public void setASSET_STATUS_CR(String aSSET_STATUS_CR) {
		ASSET_STATUS_CR = aSSET_STATUS_CR;
	}
	public String getOWNER_NAME_CR() {
		return OWNER_NAME_CR;
	}
	public void setOWNER_NAME_CR(String oWNER_NAME_CR) {
		OWNER_NAME_CR = oWNER_NAME_CR;
	}
	public String getRE_OPENED_BY_FULLNAME() {
		return RE_OPENED_BY_FULLNAME;
	}
	public void setRE_OPENED_BY_FULLNAME(String rE_OPENED_BY_FULLNAME) {
		RE_OPENED_BY_FULLNAME = rE_OPENED_BY_FULLNAME;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "TEXT")
	private String P_ID;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_NAME;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_NAME_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String APPROVAR_DATE;
	@Column(columnDefinition = "TEXT")
	private String APPROVAL_NOTE;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_NAME;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_NAME_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String IT_COMPIANCE_APPROVAL_DATE;
	@Column(columnDefinition = "TEXT")
	private String ATTACH_NAME;
	@Column(columnDefinition = "TEXT")
	private String LISENCE_KEY;

	private String SERVER_HOSTORCODE;
	
	
	public String getSERVER_HOSTORCODE() {
		return SERVER_HOSTORCODE;
	}

	public void setSERVER_HOSTORCODE(String sERVER_HOSTORCODE) {
		SERVER_HOSTORCODE = sERVER_HOSTORCODE;
	}

	public String getLISENCE_KEY() {
		return LISENCE_KEY;
	}

	public void setLISENCE_KEY(String lISENCE_KEY) {
		LISENCE_KEY = lISENCE_KEY;
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
	public String getSUB_CATEGORY() {
		return SUB_CATEGORY;
	}
	public void setSUB_CATEGORY(String sUB_CATEGORY) {
		SUB_CATEGORY = sUB_CATEGORY;
	}
	public String getIP_ADDRESS() {
		return IP_ADDRESS;
	}
	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}
	
	
	public String getGROUPNAME() {
		return GROUPNAME;
	}
	public void setGROUPNAME(String gROUPNAME) {
		GROUPNAME = gROUPNAME;
	}
	
	public String getASSET_TAG() {
		return ASSET_TAG;
	}
	public void setASSET_TAG(String aSSET_TAG) {
		ASSET_TAG = aSSET_TAG;
	}
	public String getASSET_NAME() {
		return ASSET_NAME;
	}
	public void setASSET_NAME(String aSSET_NAME) {
		ASSET_NAME = aSSET_NAME;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getASSET_STATUS() {
		return ASSET_STATUS;
	}
	public void setASSET_STATUS(String aSSET_STATUS) {
		ASSET_STATUS = aSSET_STATUS;
	}
	public String getASSETCHECK() {
		return ASSETCHECK;
	}
	public void setASSETCHECK(String aSSETCHECK) {
		ASSETCHECK = aSSETCHECK;
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
	public String getRT_APPROVAL_DATE() {
		return RT_APPROVAL_DATE;
	}
	public void setRT_APPROVAL_DATE(String rT_APPROVAL_DATE) {
		RT_APPROVAL_DATE = rT_APPROVAL_DATE;
	}
	public String getRT_APPROVAL_DESCRIPTION() {
		return RT_APPROVAL_DESCRIPTION;
	}
	public void setRT_APPROVAL_DESCRIPTION(String rT_APPROVAL_DESCRIPTION) {
		RT_APPROVAL_DESCRIPTION = rT_APPROVAL_DESCRIPTION;
	}
	
	
	public String getIT_COMPIANCE_APPROVAL_DESC() {
		return IT_COMPIANCE_APPROVAL_DESC;
	}
	public void setIT_COMPIANCE_APPROVAL_DESC(String iT_COMPIANCE_APPROVAL_DESC) {
		IT_COMPIANCE_APPROVAL_DESC = iT_COMPIANCE_APPROVAL_DESC;
	}
	
	
	
	
	public String getAPPROVAL_NOTE() {
		return APPROVAL_NOTE;
	}
	public void setAPPROVAL_NOTE(String aPPROVAL_NOTE) {
		APPROVAL_NOTE = aPPROVAL_NOTE;
	}
	
	
	
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public String getS_COST() {
		return S_COST;
	}
	public void setS_COST(String s_COST) {
		S_COST = s_COST;
	}
	public String getS_PERIOD() {
		return S_PERIOD;
	}
	public void setS_PERIOD(String s_PERIOD) {
		S_PERIOD = s_PERIOD;
	}
	public String getATTACH_NAME() {
		return ATTACH_NAME;
	}
	public void setATTACH_NAME(String aTTACH_NAME) {
		ATTACH_NAME = aTTACH_NAME;
	}
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
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
	public String getRAISED_DATE() {
		return RAISED_DATE;
	}
	public void setRAISED_DATE(String rAISED_DATE) {
		RAISED_DATE = rAISED_DATE;
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
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String p_ID) {
		P_ID = p_ID;
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

	
	public String getCLOSED_REASON() {
		return CLOSED_REASON;
	}

	public void setCLOSED_REASON(String cLOSED_REASON) {
		CLOSED_REASON = cLOSED_REASON;
	}

	@Override
	public String toString() {
		return "SOFTWARE_REQUEST [SRNO=" + SRNO + ", T_ID=" + T_ID + ", ASSET_TAG=" + ASSET_TAG + ", ASSET_NAME="
				+ ASSET_NAME + ", CATEGORY=" + CATEGORY + ", CLOSED_BY=" + CLOSED_BY + ", CLOSED_REASON="
				+ CLOSED_REASON + ", CLOSED_BY_FULLNAME=" + CLOSED_BY_FULLNAME + ", CLOSED_DATE=" + CLOSED_DATE
				+ ", ASSET_STATUS=" + ASSET_STATUS + ", ASSETCHECK=" + ASSETCHECK + ", SUB_CATEGORY=" + SUB_CATEGORY
				+ ", IP_ADDRESS=" + IP_ADDRESS + ", RAISED_DATE=" + RAISED_DATE + ", EMAIL_ID=" + EMAIL_ID
				+ ", GROUPNAME=" + GROUPNAME + ", T_REQUESTER=" + T_REQUESTER + ", T_REQUESTER_FULLNAME="
				+ T_REQUESTER_FULLNAME + ", T_PHONE=" + T_PHONE + ", RT_APPROVAL=" + RT_APPROVAL
				+ ", RT_APPROVAL_FULLNAME=" + RT_APPROVAL_FULLNAME + ", RE_OPENED_DATE=" + RE_OPENED_DATE
				+ ", RE_OPENED_BY=" + RE_OPENED_BY + ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY
				+ ", RT_APPROVAL_DATE=" + RT_APPROVAL_DATE + ", S_NAME=" + S_NAME + ", S_COST=" + S_COST + ", S_PERIOD="
				+ S_PERIOD + ", IT_COMPIANCE_APPROVAL_DESC=" + IT_COMPIANCE_APPROVAL_DESC + ", RT_APPROVAL_DESCRIPTION="
				+ RT_APPROVAL_DESCRIPTION + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT="
				+ T_DEPARTMENT + ", RE_OPENED_BY_FULLNAME=" + RE_OPENED_BY_FULLNAME + ", ASSET_NAME_CR=" + ASSET_NAME_CR
				+ ", CATEGORY_REQUEST=" + CATEGORY_REQUEST + ", SERVER_IP_CR=" + SERVER_IP_CR + ", LAPTOP_IP_CR="
				+ LAPTOP_IP_CR + ", ASSET_STATUS_CR=" + ASSET_STATUS_CR + ", OWNER_NAME_CR=" + OWNER_NAME_CR
				+ ", ML_APPROVAR=" + ML_APPROVAR + ", ML_APPROVAR_NOTE=" + ML_APPROVAR_NOTE + ", ML_APPROVAR_FULLNAME="
				+ ML_APPROVAR_FULLNAME + ", ML_APPROVAR_DATE=" + ML_APPROVAR_DATE + ", SERVER_IP_ADDRESS="
				+ SERVER_IP_ADDRESS + ", STATUS=" + STATUS + ", T_DESC=" + T_DESC + ", P_ID=" + P_ID
				+ ", APPROVAR_NAME=" + APPROVAR_NAME + ", APPROVAR_NAME_FULLNAME=" + APPROVAR_NAME_FULLNAME
				+ ", APPROVAR_DATE=" + APPROVAR_DATE + ", APPROVAL_NOTE=" + APPROVAL_NOTE
				+ ", IT_COMPIANCE_APPROVAL_NAME=" + IT_COMPIANCE_APPROVAL_NAME
				+ ", IT_COMPIANCE_APPROVAL_NAME_FULLNAME=" + IT_COMPIANCE_APPROVAL_NAME_FULLNAME
				+ ", IT_COMPIANCE_APPROVAL_DATE=" + IT_COMPIANCE_APPROVAL_DATE + ", ATTACH_NAME=" + ATTACH_NAME
				+ ", LISENCE_KEY=" + LISENCE_KEY + ", SERVER_HOSTORCODE=" + SERVER_HOSTORCODE + "]";
	}


}
