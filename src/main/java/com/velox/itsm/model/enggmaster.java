package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENGGMASTER" )
public class enggmaster implements Serializable  {

	private static final long serialVersionUID = 5254625277234227091L;
	
	@Id
	@Column
	private int E_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_MAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_CATEGORY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENG_UNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENG_PWD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGG_EMAIL_PASSWORD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String E_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CONFPASS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGLEVEL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOGIN_TYPE;
	
	
	public int getE_ID() {
		return E_ID;
	}


	public void setE_ID(int e_ID) {
		E_ID = e_ID;
	}


	public String getE_NAME() {
		return E_NAME;
	}


	public void setE_NAME(String e_NAME) {
		E_NAME = e_NAME;
	}


	public String getE_COMPANY() {
		return E_COMPANY;
	}


	public void setE_COMPANY(String e_COMPANY) {
		E_COMPANY = e_COMPANY;
	}


	public String getE_BRANCH() {
		return E_BRANCH;
	}


	public void setE_BRANCH(String e_BRANCH) {
		E_BRANCH = e_BRANCH;
	}


	public String getE_MAIL() {
		return E_MAIL;
	}


	public void setE_MAIL(String e_MAIL) {
		E_MAIL = e_MAIL;
	}


	public String getE_PHONE() {
		return E_PHONE;
	}


	public void setE_PHONE(String e_PHONE) {
		E_PHONE = e_PHONE;
	}


	public String getE_CATEGORY() {
		return E_CATEGORY;
	}


	public void setE_CATEGORY(String e_CATEGORY) {
		E_CATEGORY = e_CATEGORY;
	}


	public String getENG_UNAME() {
		return ENG_UNAME;
	}


	public void setENG_UNAME(String eNG_UNAME) {
		ENG_UNAME = eNG_UNAME;
	}


	public String getENG_PWD() {
		return ENG_PWD;
	}


	public void setENG_PWD(String eNG_PWD) {
		ENG_PWD = eNG_PWD;
	}


	public String getENGG_EMAIL_PASSWORD() {
		return ENGG_EMAIL_PASSWORD;
	}


	public void setENGG_EMAIL_PASSWORD(String eNGG_EMAIL_PASSWORD) {
		ENGG_EMAIL_PASSWORD = eNGG_EMAIL_PASSWORD;
	}


	public String getE_DEPARTMENT() {
		return E_DEPARTMENT;
	}


	public void setE_DEPARTMENT(String e_DEPARTMENT) {
		E_DEPARTMENT = e_DEPARTMENT;
	}


	public String getCONFPASS() {
		return CONFPASS;
	}


	public void setCONFPASS(String cONFPASS) {
		CONFPASS = cONFPASS;
	}


	public String getENGLEVEL() {
		return ENGLEVEL;
	}


	public void setENGLEVEL(String eNGLEVEL) {
		ENGLEVEL = eNGLEVEL;
	}
	


	public String getLOGIN_TYPE() {
		return LOGIN_TYPE;
	}


	public void setLOGIN_TYPE(String lOGIN_TYPE) {
		LOGIN_TYPE = lOGIN_TYPE;
	}


	


	@Override
	public String toString() {
		return "enggmaster [E_ID=" + E_ID + ", E_NAME=" + E_NAME + ", E_COMPANY=" + E_COMPANY + ", E_BRANCH=" + E_BRANCH
				+ ", E_MAIL=" + E_MAIL + ", E_PHONE=" + E_PHONE + ", E_CATEGORY=" + E_CATEGORY + ", ENG_UNAME="
				+ ENG_UNAME + ", ENG_PWD=" + ENG_PWD + ", ENGG_EMAIL_PASSWORD=" + ENGG_EMAIL_PASSWORD
				+ ", E_DEPARTMENT=" + E_DEPARTMENT + ", CONFPASS=" + CONFPASS + ", ENGLEVEL=" + ENGLEVEL
				+ ", LOGIN_TYPE=" + LOGIN_TYPE + "]";
	}


	public enggmaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
