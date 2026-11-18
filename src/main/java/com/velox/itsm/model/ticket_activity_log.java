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
@Table(name = "ticket_activity_log")
public class ticket_activity_log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3962571036017016126L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
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
	private String T_ATTACH_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CATEGORY;
	
	public String getT_COMPANY() {
		return T_COMPANY;
	}
	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}
	public String getT_FULLNAME() {
		return T_FULLNAME;
	}
	public void setT_FULLNAME(String t_FULLNAME) {
		T_FULLNAME = t_FULLNAME;
	}
	public String getT_EMAIL() {
		return T_EMAIL;
	}
	public void setT_EMAIL(String t_EMAIL) {
		T_EMAIL = t_EMAIL;
	}
	public String getT_CONTACT_NO() {
		return T_CONTACT_NO;
	}
	public void setT_CONTACT_NO(String t_CONTACT_NO) {
		T_CONTACT_NO = t_CONTACT_NO;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CONTACT_NO;
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
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
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
		return "ticket_activity_log [SR_NO=" + SR_NO + ", T_ID=" + T_ID + ", PRIORITY=" + PRIORITY + ", SEVERITY="
				+ SEVERITY + ", STATUS=" + STATUS + ", T_DATETIME=" + T_DATETIME + ", T_CHANGEBY=" + T_CHANGEBY
				+ ", ROLE_TYPE=" + ROLE_TYPE + ", T_SUBJECT=" + T_SUBJECT + ", T_DESC=" + T_DESC + ", CHANGE_NOTES1="
				+ CHANGE_NOTES1 + ", CHANGE_NOTES2=" + CHANGE_NOTES2 + ", T_ATTACH_NAME=" + T_ATTACH_NAME
				+ ", T_CATEGORY=" + T_CATEGORY + ", T_COMPANY=" + T_COMPANY + ", T_FULLNAME=" + T_FULLNAME
				+ ", T_EMAIL=" + T_EMAIL + ", T_CONTACT_NO=" + T_CONTACT_NO + ", T_SUB_CATEGORY1=" + T_SUB_CATEGORY1
				+ ", T_SUB_CATEGORY2=" + T_SUB_CATEGORY2 + "]";
	}
	

}
