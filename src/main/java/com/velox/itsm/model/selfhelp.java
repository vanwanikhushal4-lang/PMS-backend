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
@Table(name = "SELFHELP")
public class selfhelp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7135990570714856278L;
	@Id
	@Column
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PLATFORM;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String UPLOADED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String UPLOAD_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DOWNLOAD_COUNTER;
	@Column(columnDefinition = "TEXT")
	private String DESCRIPTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ATTACH_NAME;
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCATGORY() {
		return CATGORY;
	}
	public void setCATGORY(String cATGORY) {
		CATGORY = cATGORY;
	}
	public String getPLATFORM() {
		return PLATFORM;
	}
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
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
	public String getUPLOADED_BY() {
		return UPLOADED_BY;
	}
	public void setUPLOADED_BY(String uPLOADED_BY) {
		UPLOADED_BY = uPLOADED_BY;
	}
	public String getUPLOAD_DATE() {
		return UPLOAD_DATE;
	}
	public void setUPLOAD_DATE(String uPLOAD_DATE) {
		UPLOAD_DATE = uPLOAD_DATE;
	}
	public String getDOWNLOAD_COUNTER() {
		return DOWNLOAD_COUNTER;
	}
	public void setDOWNLOAD_COUNTER(String dOWNLOAD_COUNTER) {
		DOWNLOAD_COUNTER = dOWNLOAD_COUNTER;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getATTACH_NAME() {
		return ATTACH_NAME;
	}
	public void setATTACH_NAME(String aTTACH_NAME) {
		ATTACH_NAME = aTTACH_NAME;
	}
	@Override
	public String toString() {
		return "selfhelp [SRNO=" + SRNO + ", NAME=" + NAME + ", CATGORY=" + CATGORY + ", PLATFORM=" + PLATFORM
				+ ", COMPANY=" + COMPANY + ", BRANCH=" + BRANCH + ", DEPARTMENT=" + DEPARTMENT + ", UPLOADED_BY="
				+ UPLOADED_BY + ", UPLOAD_DATE=" + UPLOAD_DATE + ", DOWNLOAD_COUNTER=" + DOWNLOAD_COUNTER
				+ ", DESCRIPTION=" + DESCRIPTION + ", ATTACH_NAME=" + ATTACH_NAME + "]";
	}
	

	
}
