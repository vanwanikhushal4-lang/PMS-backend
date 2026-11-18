package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class service_request_tracking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -485676528886341889L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBCATEGORY1;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBCATEGORY2;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBJECT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	
	private String MESSAGE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_RAISED_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_RAISED_BY_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVITY_DATE_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ATTACHMENT_NAME;

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

	public String getSEVERITY() {
		return SEVERITY;
	}

	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
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

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getSUBCATEGORY1() {
		return SUBCATEGORY1;
	}

	public void setSUBCATEGORY1(String sUBCATEGORY1) {
		SUBCATEGORY1 = sUBCATEGORY1;
	}

	public String getSUBCATEGORY2() {
		return SUBCATEGORY2;
	}

	public void setSUBCATEGORY2(String sUBCATEGORY2) {
		SUBCATEGORY2 = sUBCATEGORY2;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
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

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}

	public String getTICKET_RAISED_NAME() {
		return TICKET_RAISED_NAME;
	}

	public void setTICKET_RAISED_NAME(String tICKET_RAISED_NAME) {
		TICKET_RAISED_NAME = tICKET_RAISED_NAME;
	}

	public String getACTIVITY_DATE_TIME() {
		return ACTIVITY_DATE_TIME;
	}

	public void setACTIVITY_DATE_TIME(String aCTIVITY_DATE_TIME) {
		ACTIVITY_DATE_TIME = aCTIVITY_DATE_TIME;
	}

	public String getATTACHMENT_NAME() {
		return ATTACHMENT_NAME;
	}

	public void setATTACHMENT_NAME(String aTTACHMENT_NAME) {
		ATTACHMENT_NAME = aTTACHMENT_NAME;
	}

	public String getACTIVITY_COMPANY() {
		return ACTIVITY_COMPANY;
	}

	public void setACTIVITY_COMPANY(String aCTIVITY_COMPANY) {
		ACTIVITY_COMPANY = aCTIVITY_COMPANY;
	}

	public String getTICKET_RAISED_BY_COMPANY() {
		return TICKET_RAISED_BY_COMPANY;
	}

	public void setTICKET_RAISED_BY_COMPANY(String tICKET_RAISED_BY_COMPANY) {
		TICKET_RAISED_BY_COMPANY = tICKET_RAISED_BY_COMPANY;
	}

	@Override
	public String toString() {
		return "service_request_tracking [SR_NO=" + SR_NO + ", T_ID=" + T_ID + ", ACTIVITY_DATE=" + ACTIVITY_DATE
				+ ", ACTIVITY_NAME=" + ACTIVITY_NAME + ", ACTIVITY_COMPANY=" + ACTIVITY_COMPANY + ", CATEGORY="
				+ CATEGORY + ", SUBCATEGORY1=" + SUBCATEGORY1 + ", SUBCATEGORY2=" + SUBCATEGORY2 + ", SUBJECT="
				+ SUBJECT + ", STATUS=" + STATUS + ", PRIORITY=" + PRIORITY + ", MESSAGE=" + MESSAGE
				+ ", TICKET_RAISED_NAME=" + TICKET_RAISED_NAME + ", TICKET_RAISED_BY_COMPANY="
				+ TICKET_RAISED_BY_COMPANY + ", ACTIVITY_DATE_TIME=" + ACTIVITY_DATE_TIME + ", ATTACHMENT_NAME="
				+ ATTACHMENT_NAME + "]";
	}


}
