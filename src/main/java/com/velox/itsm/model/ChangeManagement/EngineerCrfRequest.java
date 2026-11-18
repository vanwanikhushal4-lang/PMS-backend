package com.velox.itsm.model.ChangeManagement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="engineer_crf_request")
public class EngineerCrfRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
//	@Column
	private int SR_NO;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBJECT;
//	@Column(columnDefinition = "TEXT")
	private String DESCRIPTION;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGG_NAME;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGG_COMPANY;
//	@Column(columnDefinition = "TEXT")
	private String ENGG_NOTES;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVED_BY;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVED_DATE_TIME;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String REJECTED_BY;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String REJECTED_DATE_TIME;
//	@Column(columnDefinition = "TEXT")
	private String REJECT_REASON;
//	@Column(columnDefinition = "NVARCHAR(500)")
	private String  ENG_REQUEST_DATE_TIME;
	
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
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getENGG_NAME() {
		return ENGG_NAME;
	}
	public void setENGG_NAME(String eNGG_NAME) {
		ENGG_NAME = eNGG_NAME;
	}
	public String getENGG_COMPANY() {
		return ENGG_COMPANY;
	}
	public void setENGG_COMPANY(String eNGG_COMPANY) {
		ENGG_COMPANY = eNGG_COMPANY;
	}
	public String getENGG_NOTES() {
		return ENGG_NOTES;
	}
	public void setENGG_NOTES(String eNGG_NOTES) {
		ENGG_NOTES = eNGG_NOTES;
	}
	public String getAPPROVED_BY() {
		return APPROVED_BY;
	}
	public void setAPPROVED_BY(String aPPROVED_BY) {
		APPROVED_BY = aPPROVED_BY;
	}
	public String getAPPROVED_DATE_TIME() {
		return APPROVED_DATE_TIME;
	}
	public void setAPPROVED_DATE_TIME(String aPPROVED_DATE_TIME) {
		APPROVED_DATE_TIME = aPPROVED_DATE_TIME;
	}
	public String getREJECTED_BY() {
		return REJECTED_BY;
	}
	public void setREJECTED_BY(String rEJECTED_BY) {
		REJECTED_BY = rEJECTED_BY;
	}
	public String getREJECTED_DATE_TIME() {
		return REJECTED_DATE_TIME;
	}
	public void setREJECTED_DATE_TIME(String rEJECTED_DATE_TIME) {
		REJECTED_DATE_TIME = rEJECTED_DATE_TIME;
	}
	public String getREJECT_REASON() {
		return REJECT_REASON;
	}
	public void setREJECT_REASON(String rEJECT_REASON) {
		REJECT_REASON = rEJECT_REASON;
	}
	public String getENG_REQUEST_DATE_TIME() {
		return ENG_REQUEST_DATE_TIME;
	}
	public void setENG_REQUEST_DATE_TIME(String eNG_REQUEST_DATE_TIME) {
		ENG_REQUEST_DATE_TIME = eNG_REQUEST_DATE_TIME;
	}
	@Override
	public String toString() {
		return "EngineerCrfRequest [SR_NO=" + SR_NO + ", T_ID=" + T_ID + ", COMPANY=" + COMPANY + ", BRANCH=" + BRANCH
				+ ", DEPARTMENT=" + DEPARTMENT + ", STATUS=" + STATUS + ", SUBJECT=" + SUBJECT + ", DESCRIPTION="
				+ DESCRIPTION + ", ENGG_NAME=" + ENGG_NAME + ", ENGG_COMPANY=" + ENGG_COMPANY + ", ENGG_NOTES="
				+ ENGG_NOTES + ", APPROVED_BY=" + APPROVED_BY + ", APPROVED_DATE_TIME=" + APPROVED_DATE_TIME
				+ ", REJECTED_BY=" + REJECTED_BY + ", REJECTED_DATE_TIME=" + REJECTED_DATE_TIME + ", REJECT_REASON="
				+ REJECT_REASON + ", ENG_REQUEST_DATE_TIME=" + ENG_REQUEST_DATE_TIME + "]";
	}
	
	
	
	
}