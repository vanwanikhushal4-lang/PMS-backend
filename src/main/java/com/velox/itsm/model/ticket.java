package com.velox.itsm.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3125292147375419964L;
	@Id
	@Column
	private int T_SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REOPENED_BY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REOPENED_BY_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_TAG;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSETCHECK;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_SUBCATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_IPADDRESS;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_MAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_BY_EMAIL;
	

	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBCAT1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBCAT2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ATTACH_NAME;
	@Column(columnDefinition = "TEXT")
	private String CLOSE_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_RAISE_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REQUEST_MODE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEDATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VIP_TICKET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OUTAGE_TICKET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PARENT_TICKET_ID;
	@Column(columnDefinition = "TEXT")
	private String ATTACHED_INCIDENTS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_USERNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISED_BY_FULLNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_ACTIVITY_TIME;

	
	public int getT_SRNO() {
		return T_SRNO;
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











	public String getREOPENED_BY_FULLNAME() {
		return REOPENED_BY_FULLNAME;
	}











	public void setREOPENED_BY_FULLNAME(String rEOPENED_BY_FULLNAME) {
		REOPENED_BY_FULLNAME = rEOPENED_BY_FULLNAME;
	}











	public String getREOPENED_BY_EMAIL() {
		return REOPENED_BY_EMAIL;
	}











	public void setREOPENED_BY_EMAIL(String rEOPENED_BY_EMAIL) {
		REOPENED_BY_EMAIL = rEOPENED_BY_EMAIL;
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











	public String getT_MAIL() {
		return T_MAIL;
	}











	public void setT_MAIL(String t_MAIL) {
		T_MAIL = t_MAIL;
	}











	public String getCLOSED_BY_EMAIL() {
		return CLOSED_BY_EMAIL;
	}











	public void setCLOSED_BY_EMAIL(String cLOSED_BY_EMAIL) {
		CLOSED_BY_EMAIL = cLOSED_BY_EMAIL;
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











	public String getT_RAISE_TIME() {
		return T_RAISE_TIME;
	}











	public void setT_RAISE_TIME(String t_RAISE_TIME) {
		T_RAISE_TIME = t_RAISE_TIME;
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











	public String getT_CLOSEBY_FULLNAME() {
		return T_CLOSEBY_FULLNAME;
	}











	public void setT_CLOSEBY_FULLNAME(String t_CLOSEBY_FULLNAME) {
		T_CLOSEBY_FULLNAME = t_CLOSEBY_FULLNAME;
	}











	public String getT_CLOSEBY_COMPANY() {
		return T_CLOSEBY_COMPANY;
	}











	public void setT_CLOSEBY_COMPANY(String t_CLOSEBY_COMPANY) {
		T_CLOSEBY_COMPANY = t_CLOSEBY_COMPANY;
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











	public String getOUTAGE_TICKET() {
		return OUTAGE_TICKET;
	}











	public void setOUTAGE_TICKET(String oUTAGE_TICKET) {
		OUTAGE_TICKET = oUTAGE_TICKET;
	}











	public String getPARENT_TICKET_ID() {
		return PARENT_TICKET_ID;
	}











	public void setPARENT_TICKET_ID(String pARENT_TICKET_ID) {
		PARENT_TICKET_ID = pARENT_TICKET_ID;
	}











	public String getATTACHED_INCIDENTS() {
		return ATTACHED_INCIDENTS;
	}











	public void setATTACHED_INCIDENTS(String aTTACHED_INCIDENTS) {
		ATTACHED_INCIDENTS = aTTACHED_INCIDENTS;
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











	public String getRAISED_BY_FULLNAME() {
		return RAISED_BY_FULLNAME;
	}











	public void setRAISED_BY_FULLNAME(String rAISED_BY_FULLNAME) {
		RAISED_BY_FULLNAME = rAISED_BY_FULLNAME;
	}











	public String getCURRENT_ACTIVITY_TIME() {
		return CURRENT_ACTIVITY_TIME;
	}











	public void setCURRENT_ACTIVITY_TIME(String cURRENT_ACTIVITY_TIME) {
		CURRENT_ACTIVITY_TIME = cURRENT_ACTIVITY_TIME;
	}











	@Override
	public String toString() {
		return "ticket [T_SRNO=" + T_SRNO + ", T_ID=" + T_ID + ", T_DATE=" + T_DATE + ", REOPENED_BY_FULLNAME="
				+ REOPENED_BY_FULLNAME + ", REOPENED_BY_EMAIL=" + REOPENED_BY_EMAIL + ", ASSET_TAG=" + ASSET_TAG
				+ ", ASSET_NAME=" + ASSET_NAME + ", CATEGORY=" + CATEGORY + ", ASSET_STATUS=" + ASSET_STATUS
				+ ", ASSETCHECK=" + ASSETCHECK + ", ASSET_SUBCATEGORY=" + ASSET_SUBCATEGORY + ", ASSET_IPADDRESS="
				+ ASSET_IPADDRESS + ", T_REQUESTER=" + T_REQUESTER + ", T_REQUESTER_FULLNAME=" + T_REQUESTER_FULLNAME
				+ ", T_MAIL=" + T_MAIL + ", CLOSED_BY_EMAIL=" + CLOSED_BY_EMAIL + ", T_PHONE=" + T_PHONE
				+ ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT
				+ ", T_CATEGORY=" + T_CATEGORY + ", T_SUBCAT1=" + T_SUBCAT1 + ", T_SUBCAT2=" + T_SUBCAT2
				+ ", T_SUBJECT=" + T_SUBJECT + ", T_DESC=" + T_DESC + ", T_ATTACH_NAME=" + T_ATTACH_NAME
				+ ", CLOSE_NOTES=" + CLOSE_NOTES + ", STATUS=" + STATUS + ", PRIORITY=" + PRIORITY + ", SEVERITY="
				+ SEVERITY + ", T_RAISE_TIME=" + T_RAISE_TIME + ", REQUEST_MODE=" + REQUEST_MODE + ", T_CLOSEBY="
				+ T_CLOSEBY + ", T_CLOSEBY_FULLNAME=" + T_CLOSEBY_FULLNAME + ", T_CLOSEBY_COMPANY=" + T_CLOSEBY_COMPANY
				+ ", T_CLOSEDATE=" + T_CLOSEDATE + ", VIP_TICKET=" + VIP_TICKET + ", OUTAGE_TICKET=" + OUTAGE_TICKET
				+ ", PARENT_TICKET_ID=" + PARENT_TICKET_ID + ", ATTACHED_INCIDENTS=" + ATTACHED_INCIDENTS
				+ ", RAISED_BY_USERNAME=" + RAISED_BY_USERNAME + ", RAISED_BY_COMPANY=" + RAISED_BY_COMPANY
				+ ", RAISED_BY_FULLNAME=" + RAISED_BY_FULLNAME + ", CURRENT_ACTIVITY_TIME=" + CURRENT_ACTIVITY_TIME
				+ "]";
	}
	
	
	
	
	


	
}
