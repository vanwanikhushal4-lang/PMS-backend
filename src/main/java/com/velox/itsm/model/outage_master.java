package com.velox.itsm.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OUTAGE_MASTER")
public class outage_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5358059352167411886L;
	@Id
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(columnDefinition = "TEXT")
	private String MESSAGE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERROLE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MSG_DATETIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VISIBILITY;
	@Column
	private int DAYS;
	@Column
	private int HOURS;
	@Column
	private int MINUTES;
	@Column
	private int SECONDS;
	
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}
	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}
	public void setBRANCH_NAME(String bRANCH_NAME) {
		BRANCH_NAME = bRANCH_NAME;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	public String getMESSAGE() {
		return MESSAGE;
	}
	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getUSERROLE() {
		return USERROLE;
	}
	public void setUSERROLE(String uSERROLE) {
		USERROLE = uSERROLE;
	}
	public String getMSG_DATETIME() {
		return MSG_DATETIME;
	}
	public void setMSG_DATETIME(String mSG_DATETIME) {
		MSG_DATETIME = mSG_DATETIME;
	}
	public String getVISIBILITY() {
		return VISIBILITY;
	}
	public void setVISIBILITY(String vISIBILITY) {
		VISIBILITY = vISIBILITY;
	}
	public int getDAYS() {
		return DAYS;
	}
	public void setDAYS(int dAYS) {
		DAYS = dAYS;
	}
	public int getHOURS() {
		return HOURS;
	}
	public void setHOURS(int hOURS) {
		HOURS = hOURS;
	}
	public int getMINUTES() {
		return MINUTES;
	}
	public void setMINUTES(int mINUTES) {
		MINUTES = mINUTES;
	}
	public int getSECONDS() {
		return SECONDS;
	}
	public void setSECONDS(int sECONDS) {
		SECONDS = sECONDS;
	}
	
	@Override
	public String toString() {
		return "outage_master [SR_NO=" + SR_NO + ", COMPANY_NAME=" + COMPANY_NAME + ", BRANCH_NAME=" + BRANCH_NAME
				+ ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + ", SEVERITY=" + SEVERITY + ", MESSAGE=" + MESSAGE
				+ ", USERNAME=" + USERNAME + ", USERROLE=" + USERROLE + ", MSG_DATETIME=" + MSG_DATETIME
				+ ", VISIBILITY=" + VISIBILITY + ", DAYS=" + DAYS + ", HOURS=" + HOURS + ", MINUTES=" + MINUTES
				+ ", SECONDS=" + SECONDS + "]";
	}
	
	
	
	
	
		
}
