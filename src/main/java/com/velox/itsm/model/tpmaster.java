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
@Table(name = "TPMASTER")
public class tpmaster implements Serializable {

	private static final long serialVersionUID = -6654781195092334521L;

	@Id
	@Column
	private int TP_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_MAIL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_UNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_PWD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_EMAIL_PASSWORD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TP_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOGIN_TYPE;

	public int getTP_ID() {
		return TP_ID;
	}

	public void setTP_ID(int tP_ID) {
		TP_ID = tP_ID;
	}

	public String getTP_NAME() {
		return TP_NAME;
	}

	public void setTP_NAME(String tP_NAME) {
		TP_NAME = tP_NAME;
	}

	public String getTP_COMPANY() {
		return TP_COMPANY;
	}

	public void setTP_COMPANY(String tP_COMPANY) {
		TP_COMPANY = tP_COMPANY;
	}

	public String getTP_BRANCH() {
		return TP_BRANCH;
	}

	public void setTP_BRANCH(String tP_BRANCH) {
		TP_BRANCH = tP_BRANCH;
	}

	public String getTP_PHONE() {
		return TP_PHONE;
	}

	public void setTP_PHONE(String tP_PHONE) {
		TP_PHONE = tP_PHONE;
	}

	public String getTP_MAIL() {
		return TP_MAIL;
	}

	public void setTP_MAIL(String tP_MAIL) {
		TP_MAIL = tP_MAIL;
	}

	public String getTP_UNAME() {
		return TP_UNAME;
	}

	public void setTP_UNAME(String tP_UNAME) {
		TP_UNAME = tP_UNAME;
	}

	public String getTP_PWD() {
		return TP_PWD;
	}

	public void setTP_PWD(String tP_PWD) {
		TP_PWD = tP_PWD;
	}

	public String getTP_EMAIL_PASSWORD() {
		return TP_EMAIL_PASSWORD;
	}

	public void setTP_EMAIL_PASSWORD(String tP_EMAIL_PASSWORD) {
		TP_EMAIL_PASSWORD = tP_EMAIL_PASSWORD;
	}

	public String getTP_DEPARTMENT() {
		return TP_DEPARTMENT;
	}

	public void setTP_DEPARTMENT(String tP_DEPARTMENT) {
		TP_DEPARTMENT = tP_DEPARTMENT;
	}
	
	public String getLOGIN_TYPE() {
		return LOGIN_TYPE;
	}

	public void setLOGIN_TYPE(String lOGIN_TYPE) {
		LOGIN_TYPE = lOGIN_TYPE;
	}

	

	@Override
	public String toString() {
		return "tpmaster [TP_ID=" + TP_ID + ", TP_NAME=" + TP_NAME + ", TP_COMPANY=" + TP_COMPANY + ", TP_BRANCH="
				+ TP_BRANCH + ", TP_PHONE=" + TP_PHONE + ", TP_MAIL=" + TP_MAIL + ", TP_UNAME=" + TP_UNAME + ", TP_PWD="
				+ TP_PWD + ", TP_EMAIL_PASSWORD=" + TP_EMAIL_PASSWORD + ", TP_DEPARTMENT=" + TP_DEPARTMENT
				+ ", LOGIN_TYPE=" + LOGIN_TYPE + "]";
	}

	public tpmaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
