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
@Table(name = "USERMASTER")
public class usermaster implements Serializable {

	private static final long serialVersionUID = -6454100424855196121L;

	@Id
	@Column
	private int USERID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CONFPASS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOGIN_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;

	public int getUSERID() {
		return USERID;
	}

	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getMAIL() {
		return MAIL;
	}

	public void setMAIL(String mAIL) {
		MAIL = mAIL;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
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

	public String getCONFPASS() {
		return CONFPASS;
	}

	public void setCONFPASS(String cONFPASS) {
		CONFPASS = cONFPASS;
	}

	
	public String getLOGIN_TYPE() {
		return LOGIN_TYPE;
	}

	public void setLOGIN_TYPE(String lOGIN_TYPE) {
		LOGIN_TYPE = lOGIN_TYPE;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	

	@Override
	public String toString() {
		return "usermaster [USERID=" + USERID + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", MAIL=" + MAIL
				+ ", PHONE=" + PHONE + ", NAME=" + NAME + ", COMPANY=" + COMPANY + ", BRANCH_NAME=" + BRANCH_NAME
				+ ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + ", CONFPASS=" + CONFPASS + ", LOGIN_TYPE=" + LOGIN_TYPE
				+ ", CATEGORY=" + CATEGORY + "]";
	}

	public usermaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
