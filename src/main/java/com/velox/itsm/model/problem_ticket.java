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
public class problem_ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5904682574056744989L;
	@Id
	@Column
	private int PT_SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_REQUESTER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_REQUESTER_FULLNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_MAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REQUEST_MODE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
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
	private String PT_ATTACH_NAME;
	@Column(columnDefinition = "TEXT")
	private String ATTACHED_INCIDENTS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_RAISE_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSEDATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSEBY;
	@Column(columnDefinition = "TEXT")
	private String PT_CLOSEBY_FULLNAME;
	@Column(columnDefinition = "TEXT")
	private String P_CLOSED_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VIP_TICKET;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CURRENT_ACTIVITY_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_CLOSE_BY_COMPANY;
	
	public String getPT_REQUESTER_FULLNAME() {
		return PT_REQUESTER_FULLNAME;
	}
	public void setPT_REQUESTER_FULLNAME(String pT_REQUESTER_FULLNAME) {
		PT_REQUESTER_FULLNAME = pT_REQUESTER_FULLNAME;
	}
	public String getPT_CLOSEBY_FULLNAME() {
		return PT_CLOSEBY_FULLNAME;
	}
	public void setPT_CLOSEBY_FULLNAME(String pT_CLOSEBY_FULLNAME) {
		PT_CLOSEBY_FULLNAME = pT_CLOSEBY_FULLNAME;
	}
	public String getCURRENT_ACTIVITY_TIME() {
		return CURRENT_ACTIVITY_TIME;
	}
	public void setCURRENT_ACTIVITY_TIME(String cURRENT_ACTIVITY_TIME) {
		CURRENT_ACTIVITY_TIME = cURRENT_ACTIVITY_TIME;
	}
	public int getPT_SRNO() {
		return PT_SRNO;
	}
	public void setPT_SRNO(int pT_SRNO) {
		PT_SRNO = pT_SRNO;
	}
	public String getPT_ID() {
		return PT_ID;
	}
	public void setPT_ID(String pT_ID) {
		PT_ID = pT_ID;
	}
	public String getPT_DATE() {
		return PT_DATE;
	}
	public void setPT_DATE(String pT_DATE) {
		PT_DATE = pT_DATE;
	}
	public String getPT_REQUESTER() {
		return PT_REQUESTER;
	}
	public void setPT_REQUESTER(String pT_REQUESTER) {
		PT_REQUESTER = pT_REQUESTER;
	}
	public String getPT_MAIL() {
		return PT_MAIL;
	}
	public void setPT_MAIL(String pT_MAIL) {
		PT_MAIL = pT_MAIL;
	}
	public String getPT_PHONE() {
		return PT_PHONE;
	}
	public void setPT_PHONE(String pT_PHONE) {
		PT_PHONE = pT_PHONE;
	}
	public String getPT_COMPANY() {
		return PT_COMPANY;
	}
	public void setPT_COMPANY(String pT_COMPANY) {
		PT_COMPANY = pT_COMPANY;
	}
	public String getPT_BRANCH() {
		return PT_BRANCH;
	}
	public void setPT_BRANCH(String pT_BRANCH) {
		PT_BRANCH = pT_BRANCH;
	}
	public String getPT_DEPARTMENT() {
		return PT_DEPARTMENT;
	}
	public void setPT_DEPARTMENT(String pT_DEPARTMENT) {
		PT_DEPARTMENT = pT_DEPARTMENT;
	}
	public String getREQUEST_MODE() {
		return REQUEST_MODE;
	}
	public void setREQUEST_MODE(String rEQUEST_MODE) {
		REQUEST_MODE = rEQUEST_MODE;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
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
	public String getPT_ATTACH_NAME() {
		return PT_ATTACH_NAME;
	}
	public void setPT_ATTACH_NAME(String pT_ATTACH_NAME) {
		PT_ATTACH_NAME = pT_ATTACH_NAME;
	}
	public String getATTACHED_INCIDENTS() {
		return ATTACHED_INCIDENTS;
	}
	public void setATTACHED_INCIDENTS(String aTTACHED_INCIDENTS) {
		ATTACHED_INCIDENTS = aTTACHED_INCIDENTS;
	}
	public String getPROBLEM_STATUS() {
		return PROBLEM_STATUS;
	}
	public void setPROBLEM_STATUS(String pROBLEM_STATUS) {
		PROBLEM_STATUS = pROBLEM_STATUS;
	}
	public String getPT_RAISE_TIME() {
		return PT_RAISE_TIME;
	}
	public void setPT_RAISE_TIME(String pT_RAISE_TIME) {
		PT_RAISE_TIME = pT_RAISE_TIME;
	}
	public String getPT_CLOSEDATE() {
		return PT_CLOSEDATE;
	}
	public void setPT_CLOSEDATE(String pT_CLOSEDATE) {
		PT_CLOSEDATE = pT_CLOSEDATE;
	}
	public String getPT_CLOSEBY() {
		return PT_CLOSEBY;
	}
	public void setPT_CLOSEBY(String pT_CLOSEBY) {
		PT_CLOSEBY = pT_CLOSEBY;
	}
	public String getP_CLOSED_NOTES() {
		return P_CLOSED_NOTES;
	}
	public void setP_CLOSED_NOTES(String p_CLOSED_NOTES) {
		P_CLOSED_NOTES = p_CLOSED_NOTES;
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
	public String getPT_CLOSE_BY_COMAPNY() {
		return PT_CLOSE_BY_COMPANY;
	}
	public void setPT_CLOSE_BY_COMAPNY(String pT_CLOSE_BY_COMAPNY) {
		PT_CLOSE_BY_COMPANY = pT_CLOSE_BY_COMAPNY;
	}
	@Override
	public String toString() {
		return "problem_ticket [PT_SRNO=" + PT_SRNO + ", PT_ID=" + PT_ID + ", PT_DATE=" + PT_DATE + ", PT_REQUESTER="
				+ PT_REQUESTER + ", PT_REQUESTER_FULLNAME=" + PT_REQUESTER_FULLNAME + ", PT_MAIL=" + PT_MAIL
				+ ", PT_PHONE=" + PT_PHONE + ", PT_COMPANY=" + PT_COMPANY + ", PT_BRANCH=" + PT_BRANCH
				+ ", PT_DEPARTMENT=" + PT_DEPARTMENT + ", REQUEST_MODE=" + REQUEST_MODE + ", PRIORITY=" + PRIORITY
				+ ", T_PROBLEM_CATEGORY=" + T_PROBLEM_CATEGORY + ", T_PROBLEM_SUBCAT1=" + T_PROBLEM_SUBCAT1
				+ ", T_PROBLEM_SUBCAT2=" + T_PROBLEM_SUBCAT2 + ", PT_SUBJECT=" + PT_SUBJECT + ", PT_DESC=" + PT_DESC
				+ ", PT_ATTACH_NAME=" + PT_ATTACH_NAME + ", ATTACHED_INCIDENTS=" + ATTACHED_INCIDENTS
				+ ", PROBLEM_STATUS=" + PROBLEM_STATUS + ", PT_RAISE_TIME=" + PT_RAISE_TIME + ", PT_CLOSEDATE="
				+ PT_CLOSEDATE + ", PT_CLOSEBY=" + PT_CLOSEBY + ", PT_CLOSEBY_FULLNAME=" + PT_CLOSEBY_FULLNAME
				+ ", P_CLOSED_NOTES=" + P_CLOSED_NOTES + ", VIP_TICKET=" + VIP_TICKET + ", SEVERITY=" + SEVERITY
				+ ", CURRENT_ACTIVITY_TIME=" + CURRENT_ACTIVITY_TIME + ", PT_CLOSE_BY_COMPANY=" + PT_CLOSE_BY_COMPANY
				+ "]";
	}
	

	
	
	
	


}
