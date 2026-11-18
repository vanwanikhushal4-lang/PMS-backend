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
public class problem_ticket_resolved implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 497949257964774922L;
	@Id
	@Column
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ASSIGN_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_RCA_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_FIXINPROCESS_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_RESOLVE_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_USER_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_SUBCAT1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_SUBCAT2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String PT_DESC;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String CAUSE_NOTES;
	@Column(columnDefinition = "TEXT")
	private String FIX_NOTES;
	@Column(columnDefinition = "TEXT")
	private String WORKAROUND;
	@Column(columnDefinition = "TEXT")
	private String RESOLVE_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLUTION_CODE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String  PT_CLOSEBY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_RESOLVED_ENGINEER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_ACTIVITY_TIME;
	
	
	public String getENGINEER_FULLNAME() {
		return ENGINEER_FULLNAME;
	}
	public void setENGINEER_FULLNAME(String eNGINEER_FULLNAME) {
		ENGINEER_FULLNAME = eNGINEER_FULLNAME;
	}
	public String getCURRENT_ACTIVITY_TIME() {
		return CURRENT_ACTIVITY_TIME;
	}
	public void setCURRENT_ACTIVITY_TIME(String cURRENT_ACTIVITY_TIME) {
		CURRENT_ACTIVITY_TIME = cURRENT_ACTIVITY_TIME;
	}
	public String getPT_ID() {
		return PT_ID;
	}
	public void setPT_ID(String pT_ID) {
		PT_ID = pT_ID;
	}
	public String getPT_ASSIGN_DATE() {
		return PT_ASSIGN_DATE;
	}
	public void setPT_ASSIGN_DATE(String pT_ASSIGN_DATE) {
		PT_ASSIGN_DATE = pT_ASSIGN_DATE;
	}
	public String getPT_RCA_DATE() {
		return PT_RCA_DATE;
	}
	public void setPT_RCA_DATE(String pT_RCA_DATE) {
		PT_RCA_DATE = pT_RCA_DATE;
	}
	public String getPT_FIXINPROCESS_DATE() {
		return PT_FIXINPROCESS_DATE;
	}
	public void setPT_FIXINPROCESS_DATE(String pT_FIXINPROCESS_DATE) {
		PT_FIXINPROCESS_DATE = pT_FIXINPROCESS_DATE;
	}
	public String getPT_RESOLVE_DATE() {
		return PT_RESOLVE_DATE;
	}
	public void setPT_RESOLVE_DATE(String pT_RESOLVE_DATE) {
		PT_RESOLVE_DATE = pT_RESOLVE_DATE;
	}
	public String getPT_USER_NAME() {
		return PT_USER_NAME;
	}
	public void setPT_USER_NAME(String pT_USER_NAME) {
		PT_USER_NAME = pT_USER_NAME;
	}
	public String getPT_USER_EMAIL() {
		return PT_USER_EMAIL;
	}
	public void setPT_USER_EMAIL(String pT_USER_EMAIL) {
		PT_USER_EMAIL = pT_USER_EMAIL;
	}
	public String getPT_USER_PHONE() {
		return PT_USER_PHONE;
	}
	public void setPT_USER_PHONE(String pT_USER_PHONE) {
		PT_USER_PHONE = pT_USER_PHONE;
	}
	public String getPT_USER_COMPANY() {
		return PT_USER_COMPANY;
	}
	public void setPT_USER_COMPANY(String pT_USER_COMPANY) {
		PT_USER_COMPANY = pT_USER_COMPANY;
	}
	public String getPT_USER_BRANCH() {
		return PT_USER_BRANCH;
	}
	public void setPT_USER_BRANCH(String pT_USER_BRANCH) {
		PT_USER_BRANCH = pT_USER_BRANCH;
	}
	public String getPT_USER_DEPARTMENT() {
		return PT_USER_DEPARTMENT;
	}
	public void setPT_USER_DEPARTMENT(String pT_USER_DEPARTMENT) {
		PT_USER_DEPARTMENT = pT_USER_DEPARTMENT;
	}
	public String getT_PROBLEM_CATEGORY() {
		return T_PROBLEM_CATEGORY;
	}
	public void setT_PROBLEM_CATEGORY(String t_PROBLEM_CATEGORY) {
		T_PROBLEM_CATEGORY = t_PROBLEM_CATEGORY;
	}
	public String getT_PROBLEM_SUBCAT1() {
		return T_PROBLEM_SUBCAT1;
	}
	public void setT_PROBLEM_SUBCAT1(String t_PROBLEM_SUBCAT1) {
		T_PROBLEM_SUBCAT1 = t_PROBLEM_SUBCAT1;
	}
	public String getT_PROBLEM_SUBCAT2() {
		return T_PROBLEM_SUBCAT2;
	}
	public void setT_PROBLEM_SUBCAT2(String t_PROBLEM_SUBCAT2) {
		T_PROBLEM_SUBCAT2 = t_PROBLEM_SUBCAT2;
	}
	public String getPT_SUBJECT() {
		return PT_SUBJECT;
	}
	public void setPT_SUBJECT(String pT_SUBJECT) {
		PT_SUBJECT = pT_SUBJECT;
	}
	public String getPT_DESC() {
		return PT_DESC;
	}
	public void setPT_DESC(String pT_DESC) {
		PT_DESC = pT_DESC;
	}
	public String getPT_PRIORITY() {
		return PT_PRIORITY;
	}
	public void setPT_PRIORITY(String pT_PRIORITY) {
		PT_PRIORITY = pT_PRIORITY;
	}
	public String getPROBLEM_STATUS() {
		return PROBLEM_STATUS;
	}
	public void setPROBLEM_STATUS(String pROBLEM_STATUS) {
		PROBLEM_STATUS = pROBLEM_STATUS;
	}
	public String getTP_NAME() {
		return TP_NAME;
	}
	public void setTP_NAME(String tP_NAME) {
		TP_NAME = tP_NAME;
	}
	public String getTP_EMAIL() {
		return TP_EMAIL;
	}
	public void setTP_EMAIL(String tP_EMAIL) {
		TP_EMAIL = tP_EMAIL;
	}
	public String getTP_PHONE() {
		return TP_PHONE;
	}
	public void setTP_PHONE(String tP_PHONE) {
		TP_PHONE = tP_PHONE;
	}
	public String getENGINEER_NAME() {
		return ENGINEER_NAME;
	}
	public void setENGINEER_NAME(String eNGINEER_NAME) {
		ENGINEER_NAME = eNGINEER_NAME;
	}
	public String getCAUSE_NOTES() {
		return CAUSE_NOTES;
	}
	public void setCAUSE_NOTES(String cAUSE_NOTES) {
		CAUSE_NOTES = cAUSE_NOTES;
	}
	public String getFIX_NOTES() {
		return FIX_NOTES;
	}
	public void setFIX_NOTES(String fIX_NOTES) {
		FIX_NOTES = fIX_NOTES;
	}
	public String getWORKAROUND() {
		return WORKAROUND;
	}
	public void setWORKAROUND(String wORKAROUND) {
		WORKAROUND = wORKAROUND;
	}
	public String getRESOLVE_NOTES() {
		return RESOLVE_NOTES;
	}
	public void setRESOLVE_NOTES(String rESOLVE_NOTES) {
		RESOLVE_NOTES = rESOLVE_NOTES;
	}
	public String getRESOLUTION_CODE() {
		return RESOLUTION_CODE;
	}
	public void setRESOLUTION_CODE(String rESOLUTION_CODE) {
		RESOLUTION_CODE = rESOLUTION_CODE;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	public String getPT_CLOSEBY_COMPANY() {
		return PT_CLOSEBY_COMPANY;
	}
	public void setPT_CLOSEBY_COMPANY(String pT_CLOSEBY_COMPANY) {
		PT_CLOSEBY_COMPANY = pT_CLOSEBY_COMPANY;
	}
	public String getPT_RESOLVED_ENGINEER_COMPANY() {
		return PT_RESOLVED_ENGINEER_COMPANY;
	}
	public void setPT_RESOLVED_ENGINEER_COMPANY(String pT_RESOLVED_ENGINEER_COMPANY) {
		PT_RESOLVED_ENGINEER_COMPANY = pT_RESOLVED_ENGINEER_COMPANY;
	}
	@Override
	public String toString() {
		return "problem_ticket_resolved [PT_ID=" + PT_ID + ", PT_ASSIGN_DATE=" + PT_ASSIGN_DATE + ", PT_RCA_DATE="
				+ PT_RCA_DATE + ", PT_FIXINPROCESS_DATE=" + PT_FIXINPROCESS_DATE + ", PT_RESOLVE_DATE="
				+ PT_RESOLVE_DATE + ", PT_USER_NAME=" + PT_USER_NAME + ", PT_USER_EMAIL=" + PT_USER_EMAIL
				+ ", PT_USER_PHONE=" + PT_USER_PHONE + ", PT_USER_COMPANY=" + PT_USER_COMPANY + ", PT_USER_BRANCH="
				+ PT_USER_BRANCH + ", PT_USER_DEPARTMENT=" + PT_USER_DEPARTMENT + ", T_PROBLEM_CATEGORY="
				+ T_PROBLEM_CATEGORY + ", T_PROBLEM_SUBCAT1=" + T_PROBLEM_SUBCAT1 + ", T_PROBLEM_SUBCAT2="
				+ T_PROBLEM_SUBCAT2 + ", PT_SUBJECT=" + PT_SUBJECT + ", PT_DESC=" + PT_DESC + ", PT_PRIORITY="
				+ PT_PRIORITY + ", PROBLEM_STATUS=" + PROBLEM_STATUS + ", TP_NAME=" + TP_NAME + ", TP_EMAIL=" + TP_EMAIL
				+ ", TP_PHONE=" + TP_PHONE + ", ENGINEER_NAME=" + ENGINEER_NAME + ", ENGINEER_FULLNAME="
				+ ENGINEER_FULLNAME + ", CAUSE_NOTES=" + CAUSE_NOTES + ", FIX_NOTES=" + FIX_NOTES + ", WORKAROUND="
				+ WORKAROUND + ", RESOLVE_NOTES=" + RESOLVE_NOTES + ", RESOLUTION_CODE=" + RESOLUTION_CODE
				+ ", SEVERITY=" + SEVERITY + ", PT_CLOSEBY_COMPANY=" + PT_CLOSEBY_COMPANY
				+ ", PT_RESOLVED_ENGINEER_COMPANY=" + PT_RESOLVED_ENGINEER_COMPANY + ", CURRENT_ACTIVITY_TIME="
				+ CURRENT_ACTIVITY_TIME + "]";
	}
	

	
	

}
