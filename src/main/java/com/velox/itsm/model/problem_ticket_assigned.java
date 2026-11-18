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
public class problem_ticket_assigned implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1186530890732382293L;
	@Id
	@Column
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_RAISE_DATE;
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
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_EMAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ASSIGN_TO;
	public String getTP_FULLNAME() {
		return TP_FULLNAME;
	}
	public void setTP_FULLNAME(String tP_FULLNAME) {
		TP_FULLNAME = tP_FULLNAME;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_FULLNAME;
	public String getENGINEER_FULLNAME() {
		return ENGINEER_FULLNAME;
	}
	public void setENGINEER_FULLNAME(String eNGINEER_FULLNAME) {
		ENGINEER_FULLNAME = eNGINEER_FULLNAME;
	}
	public String getPT_ENGINEER_COMPANY() {
		return PT_ENGINEER_COMPANY;
	}
	public void setPT_ENGINEER_COMPANY(String pT_ENGINEER_COMPANY) {
		PT_ENGINEER_COMPANY = pT_ENGINEER_COMPANY;
	}
	public String getPT_CLOSE_BY_COMPANY() {
		return PT_CLOSE_BY_COMPANY;
	}
	public void setPT_CLOSE_BY_COMPANY(String pT_CLOSE_BY_COMPANY) {
		PT_CLOSE_BY_COMPANY = pT_CLOSE_BY_COMPANY;
	}
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_GROUP;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ASSIGN_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ASSIGN_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSEBY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSEDATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VIP_TICKET;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_TP_COMAPNY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ENGINEER_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSE_BY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_ACTIVITY_TIME;
	
	public String getTP_NAME_FULLNAME() {
		return TP_FULLNAME;
	}
	public void setTP_NAME_FULLNAME(String tP_NAME_FULLNAME) {
		TP_FULLNAME = tP_NAME_FULLNAME;
	}
	public String getENGINEER_NAME_FULLNAME() {
		return ENGINEER_FULLNAME;
	}
	public void setENGINEER_NAME_FULLNAME(String eNGINEER_NAME_FULLNAME) {
		ENGINEER_FULLNAME = eNGINEER_NAME_FULLNAME;
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
	public String getPT_RAISE_DATE() {
		return PT_RAISE_DATE;
	}
	public void setPT_RAISE_DATE(String pT_RAISE_DATE) {
		PT_RAISE_DATE = pT_RAISE_DATE;
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
	public String getPT_ASSIGN_TO() {
		return PT_ASSIGN_TO;
	}
	public void setPT_ASSIGN_TO(String pT_ASSIGN_TO) {
		PT_ASSIGN_TO = pT_ASSIGN_TO;
	}
	public String getENGINEER_NAME() {
		return ENGINEER_NAME;
	}
	public void setENGINEER_NAME(String eNGINEER_NAME) {
		ENGINEER_NAME = eNGINEER_NAME;
	}
	public String getENGINEER_GROUP() {
		return ENGINEER_GROUP;
	}
	public void setENGINEER_GROUP(String eNGINEER_GROUP) {
		ENGINEER_GROUP = eNGINEER_GROUP;
	}
	public String getPT_ASSIGN_DATE() {
		return PT_ASSIGN_DATE;
	}
	public void setPT_ASSIGN_DATE(String pT_ASSIGN_DATE) {
		PT_ASSIGN_DATE = pT_ASSIGN_DATE;
	}
	public String getPT_ASSIGN_TIME() {
		return PT_ASSIGN_TIME;
	}
	public void setPT_ASSIGN_TIME(String pT_ASSIGN_TIME) {
		PT_ASSIGN_TIME = pT_ASSIGN_TIME;
	}
	public String getPT_CLOSEBY() {
		return PT_CLOSEBY;
	}
	public void setPT_CLOSEBY(String pT_CLOSEBY) {
		PT_CLOSEBY = pT_CLOSEBY;
	}
	public String getPT_CLOSEDATE() {
		return PT_CLOSEDATE;
	}
	public void setPT_CLOSEDATE(String pT_CLOSEDATE) {
		PT_CLOSEDATE = pT_CLOSEDATE;
	}
	public String getVIP_TICKET() {
		return VIP_TICKET;
	}
	public void setVIP_TICKET(String vIP_TICKET) {
		VIP_TICKET = vIP_TICKET;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	public String getPT_TP_COMAPNY() {
		return PT_TP_COMAPNY;
	}
	public void setPT_TP_COMAPNY(String pT_TP_COMAPNY) {
		PT_TP_COMAPNY = pT_TP_COMAPNY;
	}
	public String getPT_ENGINEER_COMAPNY() {
		return PT_ENGINEER_COMPANY;
	}
	public void setPT_ENGINEER_COMAPNY(String pT_ENGINEER_COMAPNY) {
		PT_ENGINEER_COMPANY = pT_ENGINEER_COMAPNY;
	}
	public String getPT_CLOSE_BY_COMAPNY() {
		return PT_CLOSE_BY_COMPANY;
	}
	public void setPT_CLOSE_BY_COMAPNY(String pT_CLOSE_BY_COMAPNY) {
		PT_CLOSE_BY_COMPANY = pT_CLOSE_BY_COMAPNY;
	}
	@Override
	public String toString() {
		return "problem_ticket_assigned [PT_ID=" + PT_ID + ", PT_RAISE_DATE=" + PT_RAISE_DATE + ", PT_USER_NAME="
				+ PT_USER_NAME + ", PT_USER_EMAIL=" + PT_USER_EMAIL + ", PT_USER_PHONE=" + PT_USER_PHONE
				+ ", PT_USER_COMPANY=" + PT_USER_COMPANY + ", PT_USER_BRANCH=" + PT_USER_BRANCH
				+ ", PT_USER_DEPARTMENT=" + PT_USER_DEPARTMENT + ", T_PROBLEM_CATEGORY=" + T_PROBLEM_CATEGORY
				+ ", T_PROBLEM_SUBCAT1=" + T_PROBLEM_SUBCAT1 + ", T_PROBLEM_SUBCAT2=" + T_PROBLEM_SUBCAT2
				+ ", PT_SUBJECT=" + PT_SUBJECT + ", PT_DESC=" + PT_DESC + ", PRIORITY=" + PRIORITY + ", PROBLEM_STATUS="
				+ PROBLEM_STATUS + ", TP_NAME=" + TP_NAME + ", TP_FULLNAME=" + TP_FULLNAME + ", TP_EMAIL=" + TP_EMAIL
				+ ", TP_PHONE=" + TP_PHONE + ", PT_ASSIGN_TO=" + PT_ASSIGN_TO + ", ENGINEER_NAME=" + ENGINEER_NAME
				+ ", ENGINEER_FULLNAME=" + ENGINEER_FULLNAME + ", ENGINEER_GROUP=" + ENGINEER_GROUP
				+ ", PT_ASSIGN_DATE=" + PT_ASSIGN_DATE + ", PT_ASSIGN_TIME=" + PT_ASSIGN_TIME + ", PT_CLOSEBY="
				+ PT_CLOSEBY + ", PT_CLOSEDATE=" + PT_CLOSEDATE + ", VIP_TICKET=" + VIP_TICKET + ", SEVERITY="
				+ SEVERITY + ", PT_TP_COMAPNY=" + PT_TP_COMAPNY + ", PT_ENGINEER_COMPANY=" + PT_ENGINEER_COMPANY
				+ ", PT_CLOSE_BY_COMPANY=" + PT_CLOSE_BY_COMPANY + ", CURRENT_ACTIVITY_TIME=" + CURRENT_ACTIVITY_TIME
				+ "]";
	}
	
	
	
}
