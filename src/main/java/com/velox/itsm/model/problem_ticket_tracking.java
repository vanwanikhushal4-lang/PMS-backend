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

public class problem_ticket_tracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5452164581567321760L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_NAME_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_SUBCAT1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_PROBLEM_SUBCAT2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PT_SUBJECT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String P_MESSAGE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_TICKET_RAISED_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_DATE_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_ATTACHMENT_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;

	
	



	public String getACTIVITY_NAME_COMPANY() {
		return ACTIVITY_NAME_COMPANY;
	}




	public void setACTIVITY_NAME_COMPANY(String aCTIVITY_NAME_COMPANY) {
		ACTIVITY_NAME_COMPANY = aCTIVITY_NAME_COMPANY;
	}




	


	@Override
	public String toString() {
		return "problem_ticket_tracking [SR_NO=" + SR_NO + ", PT_ID=" + PT_ID + ", ACTIVITY_DATE=" + ACTIVITY_DATE
				+ ", ACTIVITY_NAME=" + ACTIVITY_NAME + ", ACTIVITY_NAME_COMPANY=" + ACTIVITY_NAME_COMPANY
				+ ", T_PROBLEM_CATEGORY=" + T_PROBLEM_CATEGORY + ", T_PROBLEM_SUBCAT1=" + T_PROBLEM_SUBCAT1
				+ ", T_PROBLEM_SUBCAT2=" + T_PROBLEM_SUBCAT2 + ", PT_SUBJECT=" + PT_SUBJECT + ", PROBLEM_STATUS="
				+ PROBLEM_STATUS + ", PRIORITY=" + PRIORITY + ", P_MESSAGE=" + P_MESSAGE
				+ ", PROBLEM_TICKET_RAISED_NAME=" + PROBLEM_TICKET_RAISED_NAME + ", ACTIVITY_DATE_TIME="
				+ ACTIVITY_DATE_TIME + ", PROBLEM_ATTACHMENT_NAME=" + PROBLEM_ATTACHMENT_NAME + ", SEVERITY=" + SEVERITY
				+ "]";
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




	public String getACTIVITY_DATE() {
		return ACTIVITY_DATE;
	}




	public void setACTIVITY_DATE(String aCTIVITY_DATE) {
		ACTIVITY_DATE = aCTIVITY_DATE;
	}




	public String getACTIVITY_NAME() {
		return ACTIVITY_NAME;
	}




	public void setACTIVITY_NAME(String aCTIVITY_NAME) {
		ACTIVITY_NAME = aCTIVITY_NAME;
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




	public String getPROBLEM_STATUS() {
		return PROBLEM_STATUS;
	}




	public void setPROBLEM_STATUS(String pROBLEM_STATUS) {
		PROBLEM_STATUS = pROBLEM_STATUS;
	}




	public String getPRIORITY() {
		return PRIORITY;
	}




	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}




	public String getP_MESSAGE() {
		return P_MESSAGE;
	}




	public void setP_MESSAGE(String p_MESSAGE) {
		P_MESSAGE = p_MESSAGE;
	}




	public String getPROBLEM_TICKET_RAISED_NAME() {
		return PROBLEM_TICKET_RAISED_NAME;
	}




	public void setPROBLEM_TICKET_RAISED_NAME(String pROBLEM_TICKET_RAISED_NAME) {
		PROBLEM_TICKET_RAISED_NAME = pROBLEM_TICKET_RAISED_NAME;
	}




	public String getACTIVITY_DATE_TIME() {
		return ACTIVITY_DATE_TIME;
	}




	public void setACTIVITY_DATE_TIME(String aCTIVITY_DATE_TIME) {
		ACTIVITY_DATE_TIME = aCTIVITY_DATE_TIME;
	}




	public String getPROBLEM_ATTACHMENT_NAME() {
		return PROBLEM_ATTACHMENT_NAME;
	}




	public void setPROBLEM_ATTACHMENT_NAME(String pROBLEM_ATTACHMENT_NAME) {
		PROBLEM_ATTACHMENT_NAME = pROBLEM_ATTACHMENT_NAME;
	}




	public String getSEVERITY() {
		return SEVERITY;
	}




	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}


	
	
}
