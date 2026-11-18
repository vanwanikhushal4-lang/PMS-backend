package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SELFHELPMASTER")
public class selfhelpmaster implements Serializable {
	private static final long serialVersionUID = 7135990570714856278L;
	
	@Id
	@Column
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PLATFORM;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String UPLOADED_BY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String UPLOAD_DATE;
	@Column
	private int DOWNLOAD_COUNTER;
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
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getPLATFORM() {
		return PLATFORM;
	}
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
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
	public int getDOWNLOAD_COUNTER() {
		return DOWNLOAD_COUNTER;
	}
	public void setDOWNLOAD_COUNTER(int dOWNLOAD_COUNTER) {
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
}
