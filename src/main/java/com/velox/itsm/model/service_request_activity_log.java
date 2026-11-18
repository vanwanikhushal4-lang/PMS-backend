package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class service_request_activity_log implements Serializable
{
	private static final long serialVersionUID = 3962571036017016126L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DATETIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CHANGEBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ROLE_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "TEXT")
	private String CHANGE_NOTES1;
	@Column(columnDefinition = "TEXT")
	private String CHANGE_NOTES2;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CONTACT_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FULLNAME;


	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getCONTACT_NO() {
		return CONTACT_NO;
	}
	public void setCONTACT_NO(String cONTACT_NO) {
		CONTACT_NO = cONTACT_NO;
	}
	public String getFULLNAME() {
		return FULLNAME;
	}
	public void setFULLNAME(String fULLNAME) {
		FULLNAME = fULLNAME;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ATTACH_NAME;
	
	public String getT_CATEGORY() {
		return T_CATEGORY;
	}
	public void setT_CATEGORY(String t_CATEGORY) {
		T_CATEGORY = t_CATEGORY;
	}
	public String getT_SUB_CATEGORY1() {
		return T_SUB_CATEGORY1;
	}
	public void setT_SUB_CATEGORY1(String t_SUB_CATEGORY1) {
		T_SUB_CATEGORY1 = t_SUB_CATEGORY1;
	}
	public String getT_SUB_CATEGORY2() {
		return T_SUB_CATEGORY2;
	}
	public void setT_SUB_CATEGORY2(String t_SUB_CATEGORY2) {
		T_SUB_CATEGORY2 = t_SUB_CATEGORY2;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUB_CATEGORY1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUB_CATEGORY2;
	
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getT_DATETIME() {
		return T_DATETIME;
	}
	public void setT_DATETIME(String t_DATETIME) {
		T_DATETIME = t_DATETIME;
	}
	public String getT_CHANGEBY() {
		return T_CHANGEBY;
	}
	public void setT_CHANGEBY(String t_CHANGEBY) {
		T_CHANGEBY = t_CHANGEBY;
	}
	public String getROLE_TYPE() {
		return ROLE_TYPE;
	}
	public void setROLE_TYPE(String rOLE_TYPE) {
		ROLE_TYPE = rOLE_TYPE;
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
	public String getCHANGE_NOTES1() {
		return CHANGE_NOTES1;
	}
	public void setCHANGE_NOTES1(String cHANGE_NOTES1) {
		CHANGE_NOTES1 = cHANGE_NOTES1;
	}
	public String getCHANGE_NOTES2() {
		return CHANGE_NOTES2;
	}
	public void setCHANGE_NOTES2(String cHANGE_NOTES2) {
		CHANGE_NOTES2 = cHANGE_NOTES2;
	}
	public String getT_ATTACH_NAME() {
		return T_ATTACH_NAME;
	}
	public void setT_ATTACH_NAME(String t_ATTACH_NAME) {
		T_ATTACH_NAME = t_ATTACH_NAME;
	}
	@Override
	public String toString() {
		return "service_request_activity_log [SR_NO=" + SR_NO + ", T_ID=" + T_ID + ", PRIORITY=" + PRIORITY
				+ ", STATUS=" + STATUS + ", T_DATETIME=" + T_DATETIME + ", T_CHANGEBY=" + T_CHANGEBY + ", ROLE_TYPE="
				+ ROLE_TYPE + ", T_SUBJECT=" + T_SUBJECT + ", T_DESC=" + T_DESC + ", CHANGE_NOTES1=" + CHANGE_NOTES1
				+ ", CHANGE_NOTES2=" + CHANGE_NOTES2 + ", SEVERITY=" + SEVERITY + ", COMPANY=" + COMPANY + ", EMAIL="
				+ EMAIL + ", CONTACT_NO=" + CONTACT_NO + ", FULLNAME=" + FULLNAME + ", T_ATTACH_NAME=" + T_ATTACH_NAME
				+ ", T_CATEGORY=" + T_CATEGORY + ", T_SUB_CATEGORY1=" + T_SUB_CATEGORY1 + ", T_SUB_CATEGORY2="
				+ T_SUB_CATEGORY2 + "]";
	}
	
	
}
