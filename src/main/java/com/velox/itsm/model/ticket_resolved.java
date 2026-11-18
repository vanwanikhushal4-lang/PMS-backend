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
@Table(name = "TICKET_RESOLVED")
public class ticket_resolved implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6120131396386512245L;
	@Id
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RAISE_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_ACTIVITY_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSIGN_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSIGNED_ENGINEER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBCATEGORY1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBCATEGORY2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBJECT;
	@Column(columnDefinition = "TEXT")
	private String T_DESC;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String A_ENGINEER_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_ENGINEER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_ENGINEER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_ENGINEER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_ENGINEER_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESOLVED_ENGINEER_PHONE;
	@Column(columnDefinition = "TEXT")
	private String SOLUTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_RESOLVED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSEDBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSEDBY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CLOSED_DATE;
	
	public String getCURRENT_ACTIVITY_TIME() {
		return CURRENT_ACTIVITY_TIME;
	}
	public void setCURRENT_ACTIVITY_TIME(String cURRENT_ACTIVITY_TIME) {
		CURRENT_ACTIVITY_TIME = cURRENT_ACTIVITY_TIME;
	}
	
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getRAISE_DATE() {
		return RAISE_DATE;
	}
	public void setRAISE_DATE(String rAISE_DATE) {
		RAISE_DATE = rAISE_DATE;
	}
	public String getASSIGN_DATE() {
		return ASSIGN_DATE;
	}
	public void setASSIGN_DATE(String aSSIGN_DATE) {
		ASSIGN_DATE = aSSIGN_DATE;
	}
	public String getRESOLVED_DATE() {
		return RESOLVED_DATE;
	}
	public void setRESOLVED_DATE(String rESOLVED_DATE) {
		RESOLVED_DATE = rESOLVED_DATE;
	}
	public String getT_USER_NAME() {
		return T_USER_NAME;
	}
	public void setT_USER_NAME(String t_USER_NAME) {
		T_USER_NAME = t_USER_NAME;
	}
	public String getT_USER_EMAIL() {
		return T_USER_EMAIL;
	}
	public void setT_USER_EMAIL(String t_USER_EMAIL) {
		T_USER_EMAIL = t_USER_EMAIL;
	}
	public String getT_USER_PHONE() {
		return T_USER_PHONE;
	}
	public void setT_USER_PHONE(String t_USER_PHONE) {
		T_USER_PHONE = t_USER_PHONE;
	}
	public String getT_USER_COMPANY() {
		return T_USER_COMPANY;
	}
	public void setT_USER_COMPANY(String t_USER_COMPANY) {
		T_USER_COMPANY = t_USER_COMPANY;
	}
	public String getT_USER_BRANCH() {
		return T_USER_BRANCH;
	}
	public void setT_USER_BRANCH(String t_USER_BRANCH) {
		T_USER_BRANCH = t_USER_BRANCH;
	}
	public String getT_CATEGORY() {
		return T_CATEGORY;
	}
	public void setT_CATEGORY(String t_CATEGORY) {
		T_CATEGORY = t_CATEGORY;
	}
	public String getT_SUBCATEGORY1() {
		return T_SUBCATEGORY1;
	}
	public void setT_SUBCATEGORY1(String t_SUBCATEGORY1) {
		T_SUBCATEGORY1 = t_SUBCATEGORY1;
	}
	public String getT_SUBCATEGORY2() {
		return T_SUBCATEGORY2;
	}
	public void setT_SUBCATEGORY2(String t_SUBCATEGORY2) {
		T_SUBCATEGORY2 = t_SUBCATEGORY2;
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
	public String getT_PRIORITY() {
		return T_PRIORITY;
	}
	public void setT_PRIORITY(String t_PRIORITY) {
		T_PRIORITY = t_PRIORITY;
	}
	public String getT_SEVERITY() {
		return T_SEVERITY;
	}
	public void setT_SEVERITY(String t_SEVERITY) {
		T_SEVERITY = t_SEVERITY;
	}
	public String getT_STATUS() {
		return T_STATUS;
	}
	public void setT_STATUS(String t_STATUS) {
		T_STATUS = t_STATUS;
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
	public String getA_ENGINEER_NAME() {
		return A_ENGINEER_NAME;
	}
	public void setA_ENGINEER_NAME(String a_ENGINEER_NAME) {
		A_ENGINEER_NAME = a_ENGINEER_NAME;
	}
	public String getRESOLVED_ENGINEER_NAME() {
		return RESOLVED_ENGINEER_NAME;
	}
	public void setRESOLVED_ENGINEER_NAME(String rESOLVED_ENGINEER_NAME) {
		RESOLVED_ENGINEER_NAME = rESOLVED_ENGINEER_NAME;
	}
	public String getRESOLVED_ENGINEER_COMPANY() {
		return RESOLVED_ENGINEER_COMPANY;
	}
	public void setRESOLVED_ENGINEER_COMPANY(String rESOLVED_ENGINEER_COMPANY) {
		RESOLVED_ENGINEER_COMPANY = rESOLVED_ENGINEER_COMPANY;
	}
	public String getRESOLVED_ENGINEER_EMAIL() {
		return RESOLVED_ENGINEER_EMAIL;
	}
	public void setRESOLVED_ENGINEER_EMAIL(String rESOLVED_ENGINEER_EMAIL) {
		RESOLVED_ENGINEER_EMAIL = rESOLVED_ENGINEER_EMAIL;
	}
	public String getRESOLVED_ENGINEER_PHONE() {
		return RESOLVED_ENGINEER_PHONE;
	}
	public void setRESOLVED_ENGINEER_PHONE(String rESOLVED_ENGINEER_PHONE) {
		RESOLVED_ENGINEER_PHONE = rESOLVED_ENGINEER_PHONE;
	}
	public String getSOLUTION() {
		return SOLUTION;
	}
	public void setSOLUTION(String sOLUTION) {
		SOLUTION = sOLUTION;
	}
	public String getT_RESOLVED_TIME() {
		return T_RESOLVED_TIME;
	}
	public void setT_RESOLVED_TIME(String t_RESOLVED_TIME) {
		T_RESOLVED_TIME = t_RESOLVED_TIME;
	}
	public String getCLOSEDBY() {
		return CLOSEDBY;
	}
	public void setCLOSEDBY(String cLOSEDBY) {
		CLOSEDBY = cLOSEDBY;
	}
	public String getCLOSEDBY_COMPANY() {
		return CLOSEDBY_COMPANY;
	}
	public void setCLOSEDBY_COMPANY(String cLOSEDBY_COMPANY) {
		CLOSEDBY_COMPANY = cLOSEDBY_COMPANY;
	}
	public String getCLOSED_DATE() {
		return CLOSED_DATE;
	}
	public void setCLOSED_DATE(String cLOSED_DATE) {
		CLOSED_DATE = cLOSED_DATE;
	}
	public String getRESOLVED_ENGINEER_FULLNAME() {
		return RESOLVED_ENGINEER_FULLNAME;
	}
	public void setRESOLVED_ENGINEER_FULLNAME(String rESOLVED_ENGINEER_FULLNAME) {
		RESOLVED_ENGINEER_FULLNAME = rESOLVED_ENGINEER_FULLNAME;
	}
	
	public String getASSIGNED_ENGINEER_FULLNAME() {
		return ASSIGNED_ENGINEER_FULLNAME;
	}
	public void setASSIGNED_ENGINEER_FULLNAME(String aSSIGNED_ENGINEER_FULLNAME) {
		ASSIGNED_ENGINEER_FULLNAME = aSSIGNED_ENGINEER_FULLNAME;
	}
	@Override
	public String toString() {
		return "ticket_resolved [T_ID=" + T_ID + ", RAISE_DATE=" + RAISE_DATE + ", CURRENT_ACTIVITY_TIME="
				+ CURRENT_ACTIVITY_TIME + ", ASSIGN_DATE=" + ASSIGN_DATE + ", RESOLVED_DATE=" + RESOLVED_DATE
				+ ", T_USER_NAME=" + T_USER_NAME + ", T_USER_EMAIL=" + T_USER_EMAIL + ", T_USER_PHONE=" + T_USER_PHONE
				+ ", ASSIGNED_ENGINEER_FULLNAME=" + ASSIGNED_ENGINEER_FULLNAME + ", T_USER_COMPANY=" + T_USER_COMPANY
				+ ", T_USER_BRANCH=" + T_USER_BRANCH + ", T_CATEGORY=" + T_CATEGORY + ", T_SUBCATEGORY1="
				+ T_SUBCATEGORY1 + ", T_SUBCATEGORY2=" + T_SUBCATEGORY2 + ", T_SUBJECT=" + T_SUBJECT + ", T_DESC="
				+ T_DESC + ", T_PRIORITY=" + T_PRIORITY + ", T_SEVERITY=" + T_SEVERITY + ", T_STATUS=" + T_STATUS
				+ ", TP_NAME=" + TP_NAME + ", TP_EMAIL=" + TP_EMAIL
				+ ", TP_PHONE=" + TP_PHONE + ", A_ENGINEER_NAME=" + A_ENGINEER_NAME + ", RESOLVED_ENGINEER_FULLNAME="
				+ RESOLVED_ENGINEER_FULLNAME + ", RESOLVED_ENGINEER_NAME=" + RESOLVED_ENGINEER_NAME
				+ ", RESOLVED_ENGINEER_COMPANY=" + RESOLVED_ENGINEER_COMPANY + ", RESOLVED_ENGINEER_EMAIL="
				+ RESOLVED_ENGINEER_EMAIL + ", RESOLVED_ENGINEER_PHONE=" + RESOLVED_ENGINEER_PHONE + ", SOLUTION="
				+ SOLUTION + ", T_RESOLVED_TIME=" + T_RESOLVED_TIME + ", CLOSEDBY=" + CLOSEDBY + ", CLOSEDBY_COMPANY="
				+ CLOSEDBY_COMPANY + ", CLOSED_DATE=" + CLOSED_DATE + "]";
	}

}
