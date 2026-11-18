package com.velox.itsm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class service_request 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8380164607008990047L;
	@Id
	@Column
	private int T_SRNO;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_DATE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_MAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_SUBCAT1;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_SUBCAT2;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "TEXT")
	private String T_ATTACH_NAME;
	@Column(columnDefinition = "TEXT")
	private String CLOSE_NOTES;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String SEVERITY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String REQUEST_MODE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_CLOSEBY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_CLOSEBY_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_CLOSEBY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RAISED_BY_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSET_SUBCATEGORY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSET_IPADDRESS;
	
	
	public String getASSET_SUBCATEGORY() {
		return ASSET_SUBCATEGORY;
	}
	public void setASSET_SUBCATEGORY(String aSSET_SUBCATEGORY) {
		ASSET_SUBCATEGORY = aSSET_SUBCATEGORY;
	}
	public String getASSET_IPADDRESS() {
		return ASSET_IPADDRESS;
	}
	public void setASSET_IPADDRESS(String aSSET_IPADDRESS) {
		ASSET_IPADDRESS = aSSET_IPADDRESS;
	}
	public String getRAISED_BY_EMAIL() {
		return RAISED_BY_EMAIL;
	}
	public void setRAISED_BY_EMAIL(String rAISED_BY_EMAIL) {
		RAISED_BY_EMAIL = rAISED_BY_EMAIL;
	}
	public String getT_REQUESTER_FULLNAME() {
		return T_REQUESTER_FULLNAME;
	}
	public void setT_REQUESTER_FULLNAME(String t_REQUESTER_FULLNAME) {
		T_REQUESTER_FULLNAME = t_REQUESTER_FULLNAME;
	}
	public String getT_CLOSEBY_FULLNAME() {
		return T_CLOSEBY_FULLNAME;
	}
	public void setT_CLOSEBY_FULLNAME(String t_CLOSEBY_FULLNAME) {
		T_CLOSEBY_FULLNAME = t_CLOSEBY_FULLNAME;
	}
	public String getLEVEL_1_APPROVER_FULLNAME() {
		return LEVEL_1_APPROVER_FULLNAME;
	}
	public void setLEVEL_1_APPROVER_FULLNAME(String lEVEL_1_APPROVER_FULLNAME) {
		LEVEL_1_APPROVER_FULLNAME = lEVEL_1_APPROVER_FULLNAME;
	}
	public String getLEVEL_2_APPROVER_FULLNAME() {
		return LEVEL_2_APPROVER_FULLNAME;
	}
	public void setLEVEL_2_APPROVER_FULLNAME(String lEVEL_2_APPROVER_FULLNAME) {
		LEVEL_2_APPROVER_FULLNAME = lEVEL_2_APPROVER_FULLNAME;
	}
	public String getASSIGN_ENGG_FULLNAME() {
		return ASSIGN_ENGG_FULLNAME;
	}
	public void setASSIGN_ENGG_FULLNAME(String aSSIGN_ENGG_FULLNAME) {
		ASSIGN_ENGG_FULLNAME = aSSIGN_ENGG_FULLNAME;
	}
	public String getTP_ASSIGN_BY_FULLNAME() {
		return TP_ASSIGN_BY_FULLNAME;
	}
	public void setTP_ASSIGN_BY_FULLNAME(String tP_ASSIGN_BY_FULLNAME) {
		TP_ASSIGN_BY_FULLNAME = tP_ASSIGN_BY_FULLNAME;
	}
	public String getRESOLVE_BY_FULLNAME() {
		return RESOLVE_BY_FULLNAME;
	}
	public void setRESOLVE_BY_FULLNAME(String rESOLVE_BY_FULLNAME) {
		RESOLVE_BY_FULLNAME = rESOLVE_BY_FULLNAME;
	}
	public String getRAISED_BY_FULLNAME() {
		return RAISED_BY_FULLNAME;
	}
	public void setRAISED_BY_FULLNAME(String rAISED_BY_FULLNAME) {
		RAISED_BY_FULLNAME = rAISED_BY_FULLNAME;
	}
	@Column(columnDefinition = "NVARCHAR(50)")
	private String T_CLOSEDATE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String VIP_TICKET;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String APPROVAL_LEVEL;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_DESIGNATION;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_APPROVER_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_APPROVER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_STATUS;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_NOTES;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_1_TIMESTAMP;  
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_DESIGNATION;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_APPROVER_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_APPROVER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_STATUS;  
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_NOTES;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String LEVEL_2_TIMESTAMP;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String  ASSIGNED_GROUP;
	@Column(columnDefinition = "NVARCHAR(50)")
    private String  REQUEST_TYPE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String REQUEST_COST;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSIGN_ENGG_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSIGN_ENGG_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSIGN_ENGG_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String REQUEST_ASSIGN_DATE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSIGN_ENGG_BRANCH;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String  ASSIGN_ENGG_COMPANY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String  ASSIGN_TO;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String  ASSIGN_ENGG_NOTE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_BY_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_BY_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_COMPANY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_BRANCH;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TP_ASSIGN_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String COMPLETE_BY_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String COMPLETE_DATE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String COMPLETE_BY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String COMPLETE_NOTE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RESOLVE_DATE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RESOLVE_BY_NAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RESOLVE_BY_EMAIL;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RESOLVE_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String  RESOLVE_NOTE;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String RESOLVE_BY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ASSIGN_ENGG_GROUP;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String CLOSE_BY_COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_STATUS_ACTIVITY_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RE_OPEN_DATE_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_TAG;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSETCHECK;


	public String getT_CLOSEBY_EMAIL() {
		return T_CLOSEBY_EMAIL;
	}
	public void setT_CLOSEBY_EMAIL(String t_CLOSEBY_EMAIL) {
		T_CLOSEBY_EMAIL = t_CLOSEBY_EMAIL;
	}
	public String getLEVEL_1_EMAIL() {
		return LEVEL_1_EMAIL;
	}
	public void setLEVEL_1_EMAIL(String lEVEL_1_EMAIL) {
		LEVEL_1_EMAIL = lEVEL_1_EMAIL;
	}
	public String getLEVEL_2_EMAIL() {
		return LEVEL_2_EMAIL;
	}
	public void setLEVEL_2_EMAIL(String lEVEL_2_EMAIL) {
		LEVEL_2_EMAIL = lEVEL_2_EMAIL;
	}
	public String getASSIGN_ENGG_EMAIL() {
		return ASSIGN_ENGG_EMAIL;
	}
	public void setASSIGN_ENGG_EMAIL(String aSSIGN_ENGG_EMAIL) {
		ASSIGN_ENGG_EMAIL = aSSIGN_ENGG_EMAIL;
	}
	public String getTP_ASSIGN_BY_EMAIL() {
		return TP_ASSIGN_BY_EMAIL;
	}
	public void setTP_ASSIGN_BY_EMAIL(String tP_ASSIGN_BY_EMAIL) {
		TP_ASSIGN_BY_EMAIL = tP_ASSIGN_BY_EMAIL;
	}
	public String getRESOLVE_BY_EMAIL() {
		return RESOLVE_BY_EMAIL;
	}
	public void setRESOLVE_BY_EMAIL(String rESOLVE_BY_EMAIL) {
		RESOLVE_BY_EMAIL = rESOLVE_BY_EMAIL;
	}
	public String getCURRENT_STATUS_ACTIVITY_TIME() {
		return CURRENT_STATUS_ACTIVITY_TIME;
	}
	public void setCURRENT_STATUS_ACTIVITY_TIME(String cURRENT_STATUS_ACTIVITY_TIME) {
		CURRENT_STATUS_ACTIVITY_TIME = cURRENT_STATUS_ACTIVITY_TIME;
	}
	public String getRE_OPEN_DATE_TIME() {
		return RE_OPEN_DATE_TIME;
	}
	public void setRE_OPEN_DATE_TIME(String rE_OPEN_DATE_TIME) {
		RE_OPEN_DATE_TIME = rE_OPEN_DATE_TIME;
	}
	public String getCLOSE_BY_COMPANY() {
		return CLOSE_BY_COMPANY;
	}
	public void setCLOSE_BY_COMPANY(String cLOSE_BY_COMPANY) {
		CLOSE_BY_COMPANY = cLOSE_BY_COMPANY;
	}
	public int getT_SRNO() {
		return T_SRNO;
	}
	public String getRESOLVE_DATE() {
		return RESOLVE_DATE;
	}
	public void setRESOLVE_DATE(String rESOLVE_DATE) {
		RESOLVE_DATE = rESOLVE_DATE;
	}
	public String getRESOLVE_BY_NAME() {
		return RESOLVE_BY_NAME;
	}
	public void setRESOLVE_BY_NAME(String rESOLVE_BY_NAME) {
		RESOLVE_BY_NAME = rESOLVE_BY_NAME;
	}
	public String getRESOLVE_NOTE() {
		return RESOLVE_NOTE;
	}
	public void setRESOLVE_NOTE(String rESOLVE_NOTE) {
		RESOLVE_NOTE = rESOLVE_NOTE;
	}
	public String getRESOLVE_BY_COMPANY() {
		return RESOLVE_BY_COMPANY;
	}
	public void setRESOLVE_BY_COMPANY(String rESOLVE_BY_COMPANY) {
		RESOLVE_BY_COMPANY = rESOLVE_BY_COMPANY;
	}
	public String getASSIGN_ENGG_GROUP() {
		return ASSIGN_ENGG_GROUP;
	}
	public void setASSIGN_ENGG_GROUP(String aSSIGN_ENGG_GROUP) {
		ASSIGN_ENGG_GROUP = aSSIGN_ENGG_GROUP;
	}
	public void setT_SRNO(int t_SRNO) {
		T_SRNO = t_SRNO;
	}
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getT_DATE() {
		return T_DATE;
	}
	public void setT_DATE(String t_DATE) {
		T_DATE = t_DATE;
	}
	public String getT_REQUESTER() {
		return T_REQUESTER;
	}
	public void setT_REQUESTER(String t_REQUESTER) {
		T_REQUESTER = t_REQUESTER;
	}
	public String getT_MAIL() {
		return T_MAIL;
	}
	public void setT_MAIL(String t_MAIL) {
		T_MAIL = t_MAIL;
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
	public String getT_CATEGORY() {
		return T_CATEGORY;
	}
	public void setT_CATEGORY(String t_CATEGORY) {
		T_CATEGORY = t_CATEGORY;
	}
	public String getT_SUBCAT1() {
		return T_SUBCAT1;
	}
	public void setT_SUBCAT1(String t_SUBCAT1) {
		T_SUBCAT1 = t_SUBCAT1;
	}
	public String getT_SUBCAT2() {
		return T_SUBCAT2;
	}
	public void setT_SUBCAT2(String t_SUBCAT2) {
		T_SUBCAT2 = t_SUBCAT2;
	}
	public String getT_SUBJECT() {
		return T_SUBJECT;
	}
	public void setT_SUBJECT(String t_SUBJECT) {
		T_SUBJECT = t_SUBJECT;
	}
	public String getT_DESC() {
		return T_DESC;
	}
	public void setT_DESC(String t_DESC) {
		T_DESC = t_DESC;
	}
	public String getT_ATTACH_NAME() {
		return T_ATTACH_NAME;
	}
	public void setT_ATTACH_NAME(String t_ATTACH_NAME) {
		T_ATTACH_NAME = t_ATTACH_NAME;
	}
	public String getCLOSE_NOTES() {
		return CLOSE_NOTES;
	}
	public void setCLOSE_NOTES(String cLOSE_NOTES) {
		CLOSE_NOTES = cLOSE_NOTES;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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
	public String getREQUEST_MODE() {
		return REQUEST_MODE;
	}
	public void setREQUEST_MODE(String rEQUEST_MODE) {
		REQUEST_MODE = rEQUEST_MODE;
	}
	public String getT_CLOSEBY() {
		return T_CLOSEBY;
	}
	public void setT_CLOSEBY(String t_CLOSEBY) {
		T_CLOSEBY = t_CLOSEBY;
	}
	public String getT_CLOSEDATE() {
		return T_CLOSEDATE;
	}
	public void setT_CLOSEDATE(String t_CLOSEDATE) {
		T_CLOSEDATE = t_CLOSEDATE;
	}
	public String getVIP_TICKET() {
		return VIP_TICKET;
	}
	public void setVIP_TICKET(String vIP_TICKET) {
		VIP_TICKET = vIP_TICKET;
	}
	public String getAPPROVAL_LEVEL() {
		return APPROVAL_LEVEL;
	}
	public void setAPPROVAL_LEVEL(String aPPROVAL_LEVEL) {
		APPROVAL_LEVEL = aPPROVAL_LEVEL;
	}
	public String getLEVEL_1_DESIGNATION() {
		return LEVEL_1_DESIGNATION;
	}
	public void setLEVEL_1_DESIGNATION(String lEVEL_1_DESIGNATION) {
		LEVEL_1_DESIGNATION = lEVEL_1_DESIGNATION;
	}
	public String getLEVEL_1_APPROVER_NAME() {
		return LEVEL_1_APPROVER_NAME;
	}
	public void setLEVEL_1_APPROVER_NAME(String lEVEL_1_APPROVER_NAME) {
		LEVEL_1_APPROVER_NAME = lEVEL_1_APPROVER_NAME;
	}
	public String getLEVEL_1_STATUS() {
		return LEVEL_1_STATUS;
	}
	public void setLEVEL_1_STATUS(String lEVEL_1_STATUS) {
		LEVEL_1_STATUS = lEVEL_1_STATUS;
	}
	public String getLEVEL_1_NOTES() {
		return LEVEL_1_NOTES;
	}
	public void setLEVEL_1_NOTES(String lEVEL_1_NOTES) {
		LEVEL_1_NOTES = lEVEL_1_NOTES;
	}
	public String getLEVEL_1_TIMESTAMP() {
		return LEVEL_1_TIMESTAMP;
	}
	public void setLEVEL_1_TIMESTAMP(String lEVEL_1_TIMESTAMP) {
		LEVEL_1_TIMESTAMP = lEVEL_1_TIMESTAMP;
	}
	public String getLEVEL_2_DESIGNATION() {
		return LEVEL_2_DESIGNATION;
	}
	public void setLEVEL_2_DESIGNATION(String lEVEL_2_DESIGNATION) {
		LEVEL_2_DESIGNATION = lEVEL_2_DESIGNATION;
	}
	public String getLEVEL_2_APPROVER_NAME() {
		return LEVEL_2_APPROVER_NAME;
	}
	public void setLEVEL_2_APPROVER_NAME(String lEVEL_2_APPROVER_NAME) {
		LEVEL_2_APPROVER_NAME = lEVEL_2_APPROVER_NAME;
	}
	public String getLEVEL_2_STATUS() {
		return LEVEL_2_STATUS;
	}
	public void setLEVEL_2_STATUS(String lEVEL_2_STATUS) {
		LEVEL_2_STATUS = lEVEL_2_STATUS;
	}
	public String getLEVEL_2_NOTES() {
		return LEVEL_2_NOTES;
	}
	public void setLEVEL_2_NOTES(String lEVEL_2_NOTES) {
		LEVEL_2_NOTES = lEVEL_2_NOTES;
	}
	public String getLEVEL_2_TIMESTAMP() {
		return LEVEL_2_TIMESTAMP;
	}
	public void setLEVEL_2_TIMESTAMP(String lEVEL_2_TIMESTAMP) {
		LEVEL_2_TIMESTAMP = lEVEL_2_TIMESTAMP;
	}
	public String getASSIGNED_GROUP() {
		return ASSIGNED_GROUP;
	}
	public void setASSIGNED_GROUP(String aSSIGNED_GROUP) {
		ASSIGNED_GROUP = aSSIGNED_GROUP;
	}
	public String getREQUEST_TYPE() {
		return REQUEST_TYPE;
	}
	public void setREQUEST_TYPE(String rEQUEST_TYPE) {
		REQUEST_TYPE = rEQUEST_TYPE;
	}
	public String getREQUEST_COST() {
		return REQUEST_COST;
	}
	public void setREQUEST_COST(String rEQUEST_COST) {
		REQUEST_COST = rEQUEST_COST;
	}
	public String getASSIGN_ENGG_NAME() {
		return ASSIGN_ENGG_NAME;
	}
	public void setASSIGN_ENGG_NAME(String aSSIGN_ENGG_NAME) {
		ASSIGN_ENGG_NAME = aSSIGN_ENGG_NAME;
	}
	public String getREQUEST_ASSIGN_DATE() {
		return REQUEST_ASSIGN_DATE;
	}
	public void setREQUEST_ASSIGN_DATE(String rEQUEST_ASSIGN_DATE) {
		REQUEST_ASSIGN_DATE = rEQUEST_ASSIGN_DATE;
	}
	public String getASSIGN_ENGG_BRANCH() {
		return ASSIGN_ENGG_BRANCH;
	}
	public void setASSIGN_ENGG_BRANCH(String aSSIGN_ENGG_BRANCH) {
		ASSIGN_ENGG_BRANCH = aSSIGN_ENGG_BRANCH;
	}
	public String getASSIGN_ENGG_COMPANY() {
		return ASSIGN_ENGG_COMPANY;
	}
	public void setASSIGN_ENGG_COMPANY(String aSSIGN_ENGG_COMPANY) {
		ASSIGN_ENGG_COMPANY = aSSIGN_ENGG_COMPANY;
	}
	public String getASSIGN_TO() {
		return ASSIGN_TO;
	}
	public void setASSIGN_TO(String aSSIGN_TO) {
		ASSIGN_TO = aSSIGN_TO;
	}
	public String getASSIGN_ENGG_NOTE() {
		return ASSIGN_ENGG_NOTE;
	}
	public void setASSIGN_ENGG_NOTE(String aSSIGN_ENGG_NOTE) {
		ASSIGN_ENGG_NOTE = aSSIGN_ENGG_NOTE;
	}
	public String getTP_ASSIGN_BY_NAME() {
		return TP_ASSIGN_BY_NAME;
	}
	public void setTP_ASSIGN_BY_NAME(String tP_ASSIGN_BY_NAME) {
		TP_ASSIGN_BY_NAME = tP_ASSIGN_BY_NAME;
	}
	public String getTP_ASSIGN_COMPANY() {
		return TP_ASSIGN_COMPANY;
	}
	public void setTP_ASSIGN_COMPANY(String tP_ASSIGN_COMPANY) {
		TP_ASSIGN_COMPANY = tP_ASSIGN_COMPANY;
	}
	public String getTP_ASSIGN_BRANCH() {
		return TP_ASSIGN_BRANCH;
	}
	public void setTP_ASSIGN_BRANCH(String tP_ASSIGN_BRANCH) {
		TP_ASSIGN_BRANCH = tP_ASSIGN_BRANCH;
	}
	public String getTP_ASSIGN_DEPARTMENT() {
		return TP_ASSIGN_DEPARTMENT;
	}
	public void setTP_ASSIGN_DEPARTMENT(String tP_ASSIGN_DEPARTMENT) {
		TP_ASSIGN_DEPARTMENT = tP_ASSIGN_DEPARTMENT;
	}
	public String getCOMPLETE_BY_NAME() {
		return COMPLETE_BY_NAME;
	}
	public void setCOMPLETE_BY_NAME(String cOMPLETE_BY_NAME) {
		COMPLETE_BY_NAME = cOMPLETE_BY_NAME;
	}
	public String getCOMPLETE_DATE() {
		return COMPLETE_DATE;
	}
	public void setCOMPLETE_DATE(String cOMPLETE_DATE) {
		COMPLETE_DATE = cOMPLETE_DATE;
	}
	public String getCOMPLETE_BY_COMPANY() {
		return COMPLETE_BY_COMPANY;
	}
	public void setCOMPLETE_BY_COMPANY(String cOMPLETE_COMPANY) {
		COMPLETE_BY_COMPANY = cOMPLETE_COMPANY;
	}
	public String getCOMPLETE_NOTE() {
		return COMPLETE_NOTE;
	}
	public void setCOMPLETE_NOTE(String cOMPLETE_NOTE) {
		COMPLETE_NOTE = cOMPLETE_NOTE;
	}
	public String getRAISED_BY_USERNAME() {
		return RAISED_BY_USERNAME;
	}
	public void setRAISED_BY_USERNAME(String rAISED_BY_USERNAME) {
		RAISED_BY_USERNAME = rAISED_BY_USERNAME;
	}
	public String getRAISED_BY_COMPANY() {
		return RAISED_BY_COMPANY;
	}
	public void setRAISED_BY_COMPANY(String rAISED_BY_COMPANY) {
		RAISED_BY_COMPANY = rAISED_BY_COMPANY;
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
	@Override
	public String toString() {
		return "service_request [T_SRNO=" + T_SRNO + ", T_ID=" + T_ID + ", T_DATE=" + T_DATE + ", T_REQUESTER="
				+ T_REQUESTER + ", T_REQUESTER_FULLNAME=" + T_REQUESTER_FULLNAME + ", T_MAIL=" + T_MAIL + ", T_PHONE="
				+ T_PHONE + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT
				+ ", T_CATEGORY=" + T_CATEGORY + ", T_SUBCAT1=" + T_SUBCAT1 + ", T_SUBCAT2=" + T_SUBCAT2
				+ ", T_SUBJECT=" + T_SUBJECT + ", T_DESC=" + T_DESC + ", T_ATTACH_NAME=" + T_ATTACH_NAME
				+ ", CLOSE_NOTES=" + CLOSE_NOTES + ", STATUS=" + STATUS + ", PRIORITY=" + PRIORITY + ", SEVERITY="
				+ SEVERITY + ", REQUEST_MODE=" + REQUEST_MODE + ", T_CLOSEBY=" + T_CLOSEBY + ", T_CLOSEBY_EMAIL="
				+ T_CLOSEBY_EMAIL + ", T_CLOSEBY_FULLNAME=" + T_CLOSEBY_FULLNAME + ", RAISED_BY_EMAIL="
				+ RAISED_BY_EMAIL + ", ASSET_SUBCATEGORY=" + ASSET_SUBCATEGORY + ", ASSET_IPADDRESS=" + ASSET_IPADDRESS
				+ ", T_CLOSEDATE=" + T_CLOSEDATE + ", VIP_TICKET=" + VIP_TICKET + ", APPROVAL_LEVEL=" + APPROVAL_LEVEL
				+ ", LEVEL_1_DESIGNATION=" + LEVEL_1_DESIGNATION + ", LEVEL_1_APPROVER_NAME=" + LEVEL_1_APPROVER_NAME
				+ ", LEVEL_1_EMAIL=" + LEVEL_1_EMAIL + ", LEVEL_1_APPROVER_FULLNAME=" + LEVEL_1_APPROVER_FULLNAME
				+ ", LEVEL_1_STATUS=" + LEVEL_1_STATUS + ", LEVEL_1_NOTES=" + LEVEL_1_NOTES + ", LEVEL_1_TIMESTAMP="
				+ LEVEL_1_TIMESTAMP + ", LEVEL_2_DESIGNATION=" + LEVEL_2_DESIGNATION + ", LEVEL_2_EMAIL="
				+ LEVEL_2_EMAIL + ", LEVEL_2_APPROVER_NAME=" + LEVEL_2_APPROVER_NAME + ", LEVEL_2_APPROVER_FULLNAME="
				+ LEVEL_2_APPROVER_FULLNAME + ", LEVEL_2_STATUS=" + LEVEL_2_STATUS + ", LEVEL_2_NOTES=" + LEVEL_2_NOTES
				+ ", LEVEL_2_TIMESTAMP=" + LEVEL_2_TIMESTAMP + ", ASSIGNED_GROUP=" + ASSIGNED_GROUP + ", REQUEST_TYPE="
				+ REQUEST_TYPE + ", REQUEST_COST=" + REQUEST_COST + ", ASSIGN_ENGG_NAME=" + ASSIGN_ENGG_NAME
				+ ", ASSIGN_ENGG_EMAIL=" + ASSIGN_ENGG_EMAIL + ", ASSIGN_ENGG_FULLNAME=" + ASSIGN_ENGG_FULLNAME
				+ ", REQUEST_ASSIGN_DATE=" + REQUEST_ASSIGN_DATE + ", ASSIGN_ENGG_BRANCH=" + ASSIGN_ENGG_BRANCH
				+ ", ASSIGN_ENGG_COMPANY=" + ASSIGN_ENGG_COMPANY + ", ASSIGN_TO=" + ASSIGN_TO + ", ASSIGN_ENGG_NOTE="
				+ ASSIGN_ENGG_NOTE + ", TP_ASSIGN_BY_NAME=" + TP_ASSIGN_BY_NAME + ", TP_ASSIGN_BY_EMAIL="
				+ TP_ASSIGN_BY_EMAIL + ", TP_ASSIGN_BY_FULLNAME=" + TP_ASSIGN_BY_FULLNAME + ", TP_ASSIGN_COMPANY="
				+ TP_ASSIGN_COMPANY + ", TP_ASSIGN_BRANCH=" + TP_ASSIGN_BRANCH + ", TP_ASSIGN_DEPARTMENT="
				+ TP_ASSIGN_DEPARTMENT + ", COMPLETE_BY_NAME=" + COMPLETE_BY_NAME + ", COMPLETE_DATE=" + COMPLETE_DATE
				+ ", COMPLETE_BY_COMPANY=" + COMPLETE_BY_COMPANY + ", COMPLETE_NOTE=" + COMPLETE_NOTE
				+ ", RESOLVE_DATE=" + RESOLVE_DATE + ", RESOLVE_BY_NAME=" + RESOLVE_BY_NAME + ", RESOLVE_BY_EMAIL="
				+ RESOLVE_BY_EMAIL + ", RESOLVE_BY_FULLNAME=" + RESOLVE_BY_FULLNAME + ", RESOLVE_NOTE=" + RESOLVE_NOTE
				+ ", RESOLVE_BY_COMPANY=" + RESOLVE_BY_COMPANY + ", ASSIGN_ENGG_GROUP=" + ASSIGN_ENGG_GROUP
				+ ", CLOSE_BY_COMPANY=" + CLOSE_BY_COMPANY + ", RAISED_BY_USERNAME=" + RAISED_BY_USERNAME
				+ ", RAISED_BY_FULLNAME=" + RAISED_BY_FULLNAME + ", RAISED_BY_COMPANY=" + RAISED_BY_COMPANY
				+ ", CURRENT_STATUS_ACTIVITY_TIME=" + CURRENT_STATUS_ACTIVITY_TIME + ", RE_OPEN_DATE_TIME="
				+ RE_OPEN_DATE_TIME + ", ASSET_TAG=" + ASSET_TAG + ", ASSET_NAME=" + ASSET_NAME + ", ASSET_CATEGORY="
				+ ASSET_CATEGORY + ", ASSET_STATUS=" + ASSET_STATUS + ", ASSETCHECK=" + ASSETCHECK + "]";
	}
	public String getASSET_CATEGORY() {
		return ASSET_CATEGORY;
	}
	public void setASSET_CATEGORY(String aSSET_CATEGORY) {
		ASSET_CATEGORY = aSSET_CATEGORY;
	}


}
