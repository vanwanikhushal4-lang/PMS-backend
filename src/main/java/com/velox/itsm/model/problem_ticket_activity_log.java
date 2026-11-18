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
@Table(name = "problem_ticket_activity_log")
public class problem_ticket_activity_log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3962571036017016126L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_DATETIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CHANGEBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ROLE_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String PT_DESC;
	@Column(columnDefinition = "TEXT")
	private String CHANGE_NOTES;
	@Column(columnDefinition = "TEXT")
	private String RCA_NOTES;
	@Column(columnDefinition = "TEXT")
	private String FIX_NOTES;
	@Column(columnDefinition = "TEXT")
	private String WORKAROUND_NOTES;
	@Column(columnDefinition = "TEXT")
	private String RESOLVE_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ATTACH_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_SUB_CATEGORY1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_SUB_CATEGORY2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CONTACT_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_FULLNAME;


	public String getPT_COMPANY() {
		return PT_COMPANY;
	}
	public void setPT_COMPANY(String pT_COMPANY) {
		PT_COMPANY = pT_COMPANY;
	}
	public String getPT_EMAIL() {
		return PT_EMAIL;
	}
	public void setPT_EMAIL(String pT_EMAIL) {
		PT_EMAIL = pT_EMAIL;
	}
	public String getPT_CONTACT_NO() {
		return PT_CONTACT_NO;
	}
	public void setPT_CONTACT_NO(String pT_CONTACT_NO) {
		PT_CONTACT_NO = pT_CONTACT_NO;
	}
	public String getPT_FULLNAME() {
		return PT_FULLNAME;
	}
	public void setPT_FULLNAME(String pT_FULLNAME) {
		PT_FULLNAME = pT_FULLNAME;
	}
	public String getPT_CATEGORY() {
		return PT_CATEGORY;
	}
	public void setPT_CATEGORY(String pT_CATEGORY) {
		PT_CATEGORY = pT_CATEGORY;
	}
	public String getPT_SUB_CATEGORY1() {
		return PT_SUB_CATEGORY1;
	}
	public void setPT_SUB_CATEGORY1(String pT_SUB_CATEGORY1) {
		PT_SUB_CATEGORY1 = pT_SUB_CATEGORY1;
	}
	public String getPT_SUB_CATEGORY2() {
		return PT_SUB_CATEGORY2;
	}
	public void setPT_SUB_CATEGORY2(String pT_SUB_CATEGORY2) {
		PT_SUB_CATEGORY2 = pT_SUB_CATEGORY2;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getPT_ID() {
		return PT_ID;
	}
	public void setPT_ID(String pT_ID) {
		PT_ID = pT_ID;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getPROBLEM_STATUS() {
		return PROBLEM_STATUS;
	}
	public void setPROBLEM_STATUS(String pROBLEM_STATUS) {
		PROBLEM_STATUS = pROBLEM_STATUS;
	}
	public String getPT_DATETIME() {
		return PT_DATETIME;
	}
	public void setPT_DATETIME(String pT_DATETIME) {
		PT_DATETIME = pT_DATETIME;
	}
	public String getPT_CHANGEBY() {
		return PT_CHANGEBY;
	}
	public void setPT_CHANGEBY(String pT_CHANGEBY) {
		PT_CHANGEBY = pT_CHANGEBY;
	}
	public String getROLE_TYPE() {
		return ROLE_TYPE;
	}
	public void setROLE_TYPE(String rOLE_TYPE) {
		ROLE_TYPE = rOLE_TYPE;
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
	public String getCHANGE_NOTES() {
		return CHANGE_NOTES;
	}
	public void setCHANGE_NOTES(String cHANGE_NOTES) {
		CHANGE_NOTES = cHANGE_NOTES;
	}
	public String getRCA_NOTES() {
		return RCA_NOTES;
	}
	public void setRCA_NOTES(String rCA_NOTES) {
		RCA_NOTES = rCA_NOTES;
	}
	public String getFIX_NOTES() {
		return FIX_NOTES;
	}
	public void setFIX_NOTES(String fIX_NOTES) {
		FIX_NOTES = fIX_NOTES;
	}
	public String getWORKAROUND_NOTES() {
		return WORKAROUND_NOTES;
	}
	public void setWORKAROUND_NOTES(String wORKAROUND_NOTES) {
		WORKAROUND_NOTES = wORKAROUND_NOTES;
	}
	public String getRESOLVE_NOTES() {
		return RESOLVE_NOTES;
	}
	public void setRESOLVE_NOTES(String rESOLVE_NOTES) {
		RESOLVE_NOTES = rESOLVE_NOTES;
	}
	public String getPT_ATTACH_NAME() {
		return PT_ATTACH_NAME;
	}
	public void setPT_ATTACH_NAME(String pT_ATTACH_NAME) {
		PT_ATTACH_NAME = pT_ATTACH_NAME;
	}
	
	
	
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	@Override
	public String toString() {
		return "problem_ticket_activity_log [SR_NO=" + SR_NO + ", PT_ID=" + PT_ID + ", PRIORITY=" + PRIORITY
				+ ", PROBLEM_STATUS=" + PROBLEM_STATUS + ", PT_DATETIME=" + PT_DATETIME + ", PT_CHANGEBY=" + PT_CHANGEBY
				+ ", ROLE_TYPE=" + ROLE_TYPE + ", PT_SUBJECT=" + PT_SUBJECT + ", PT_DESC=" + PT_DESC + ", CHANGE_NOTES="
				+ CHANGE_NOTES + ", RCA_NOTES=" + RCA_NOTES + ", FIX_NOTES=" + FIX_NOTES + ", WORKAROUND_NOTES="
				+ WORKAROUND_NOTES + ", RESOLVE_NOTES=" + RESOLVE_NOTES + ", PT_ATTACH_NAME=" + PT_ATTACH_NAME
				+ ", SEVERITY=" + SEVERITY + ", PT_CATEGORY=" + PT_CATEGORY + ", PT_SUB_CATEGORY1=" + PT_SUB_CATEGORY1
				+ ", PT_SUB_CATEGORY2=" + PT_SUB_CATEGORY2 + ", PT_COMPANY=" + PT_COMPANY + ", PT_EMAIL=" + PT_EMAIL
				+ ", PT_CONTACT_NO=" + PT_CONTACT_NO + ", PT_FULLNAME=" + PT_FULLNAME + "]";
	}
	
}
