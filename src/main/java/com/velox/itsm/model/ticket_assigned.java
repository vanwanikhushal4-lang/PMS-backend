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
@Table(name = "TICKET_ASSIGNED")
public class ticket_assigned implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2155327010558132903L;
	@Id
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_RAISE_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_USER_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_FULLNAME;
	
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
	private String TP_FULLNAME;
	public String getT_USER_FULLNAME() {
		return T_USER_FULLNAME;
	}
	
	public String getENGINEER_FULLNAME() {
		return ENGINEER_FULLNAME;
	}

	public void setENGINEER_FULLNAME(String eNGINEER_FULLNAME) {
		ENGINEER_FULLNAME = eNGINEER_FULLNAME;
	}

	public void setT_USER_FULLNAME(String t_USER_FULLNAME) {
		T_USER_FULLNAME = t_USER_FULLNAME;
	}
	public String getTP_FULLNAME() {
		return TP_FULLNAME;
	}
	public void setTP_FULLNAME(String tP_FULLNAME) {
		TP_FULLNAME = tP_FULLNAME;
	}
	
	public String getT_CLOSEBY_FULLNAME() {
		return T_CLOSEBY_FULLNAME;
	}
	public void setT_CLOSEBY_FULLNAME(String t_CLOSEBY_FULLNAME) {
		T_CLOSEBY_FULLNAME = t_CLOSEBY_FULLNAME;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ASSIGN_TO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_GROUP;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ASSIGN_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEBY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CLOSEDATE;
	@Column(columnDefinition = "TEXT")
	private String TP_HOLD_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VIP_TICKET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_CURRENT_ACTIVITY_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_EMAIL;
	
	public String getENGINEER_EMAIL() {
		return ENGINEER_EMAIL;
	}
	public void setENGINEER_EMAIL(String eNGINEER_EMAIL) {
		ENGINEER_EMAIL = eNGINEER_EMAIL;
	}
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getT_RAISE_DATE() {
		return T_RAISE_DATE;
	}
	public void setT_RAISE_DATE(String t_RAISE_DATE) {
		T_RAISE_DATE = t_RAISE_DATE;
	}
	public String getT_USER_NAME() {
		return T_USER_NAME;
	}
	public void setT_USER_NAME(String t_USER_NAME) {
		T_USER_NAME = t_USER_NAME;
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
	public String getTP_COMPANY() {
		return TP_COMPANY;
	}
	public void setTP_COMPANY(String tP_COMPANY) {
		TP_COMPANY = tP_COMPANY;
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
	public String getT_ASSIGN_TO() {
		return T_ASSIGN_TO;
	}
	public void setT_ASSIGN_TO(String t_ASSIGN_TO) {
		T_ASSIGN_TO = t_ASSIGN_TO;
	}
	public String getENGINEER_NAME() {
		return ENGINEER_NAME;
	}
	public void setENGINEER_NAME(String eNGINEER_NAME) {
		ENGINEER_NAME = eNGINEER_NAME;
	}
	public String getENGINEER_COMPANY() {
		return ENGINEER_COMPANY;
	}
	public void setENGINEER_COMPANY(String eNGINEER_COMPANY) {
		ENGINEER_COMPANY = eNGINEER_COMPANY;
	}
	public String getENGINEER_GROUP() {
		return ENGINEER_GROUP;
	}
	public void setENGINEER_GROUP(String eNGINEER_GROUP) {
		ENGINEER_GROUP = eNGINEER_GROUP;
	}
	public String getT_ASSIGN_DATE() {
		return T_ASSIGN_DATE;
	}
	public void setT_ASSIGN_DATE(String t_ASSIGN_DATE) {
		T_ASSIGN_DATE = t_ASSIGN_DATE;
	}
	public String getT_CLOSEBY() {
		return T_CLOSEBY;
	}
	public void setT_CLOSEBY(String t_CLOSEBY) {
		T_CLOSEBY = t_CLOSEBY;
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
	public String getTP_HOLD_NOTES() {
		return TP_HOLD_NOTES;
	}
	public void setTP_HOLD_NOTES(String tP_HOLD_NOTES) {
		TP_HOLD_NOTES = tP_HOLD_NOTES;
	}
	public String getVIP_TICKET() {
		return VIP_TICKET;
	}
	public void setVIP_TICKET(String vIP_TICKET) {
		VIP_TICKET = vIP_TICKET;
	}
	
	public String getT_CURRENT_ACTIVITY_TIME() {
		return T_CURRENT_ACTIVITY_TIME;
	}
	public void setT_CURRENT_ACTIVITY_TIME(String t_CURRENT_ACTIVITY_TIME) {
		T_CURRENT_ACTIVITY_TIME = t_CURRENT_ACTIVITY_TIME;
	}

	@Override
	public String toString() {
		return "ticket_assigned [T_ID=" + T_ID + ", T_RAISE_DATE=" + T_RAISE_DATE + ", T_USER_NAME=" + T_USER_NAME
				+ ", T_USER_FULLNAME=" + T_USER_FULLNAME + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH
				+ ", T_DEPARTMENT=" + T_DEPARTMENT + ", T_USER_EMAIL=" + T_USER_EMAIL + ", T_USER_PHONE=" + T_USER_PHONE
				+ ", ENGINEER_FULLNAME=" + ENGINEER_FULLNAME + ", T_CATEGORY=" + T_CATEGORY + ", T_SUBCATEGORY1="
				+ T_SUBCATEGORY1 + ", T_SUBCATEGORY2=" + T_SUBCATEGORY2 + ", T_SUBJECT=" + T_SUBJECT + ", T_DESC="
				+ T_DESC + ", T_PRIORITY=" + T_PRIORITY + ", T_SEVERITY=" + T_SEVERITY + ", T_STATUS=" + T_STATUS
				+ ", TP_NAME=" + TP_NAME + ", TP_FULLNAME=" + TP_FULLNAME + ", TP_COMPANY=" + TP_COMPANY + ", TP_EMAIL="
				+ TP_EMAIL + ", TP_PHONE=" + TP_PHONE + ", T_ASSIGN_TO=" + T_ASSIGN_TO + ", ENGINEER_NAME="
				+ ENGINEER_NAME + ", ENGINEER_COMPANY=" + ENGINEER_COMPANY + ", ENGINEER_GROUP=" + ENGINEER_GROUP
				+ ", T_ASSIGN_DATE=" + T_ASSIGN_DATE + ", T_CLOSEBY=" + T_CLOSEBY + ", T_CLOSEBY_FULLNAME="
				+ T_CLOSEBY_FULLNAME + ", T_CLOSEBY_COMPANY=" + T_CLOSEBY_COMPANY + ", T_CLOSEDATE=" + T_CLOSEDATE
				+ ", TP_HOLD_NOTES=" + TP_HOLD_NOTES + ", VIP_TICKET=" + VIP_TICKET + ", T_CURRENT_ACTIVITY_TIME="
				+ T_CURRENT_ACTIVITY_TIME + ", ENGINEER_EMAIL=" + ENGINEER_EMAIL + "]";
	}
	

	
	
}
