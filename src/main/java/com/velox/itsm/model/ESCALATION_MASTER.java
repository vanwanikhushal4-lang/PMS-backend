package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESCALATION_MASTER" )
public class ESCALATION_MASTER implements Serializable  {

	private static final long serialVersionUID = 4L;
	
	@Override
	public String toString() {
		return "ESCALATION_MASTER [SR_NO=" + SR_NO + ", COMPANY_NAME=" + COMPANY_NAME + ", BRANCH_NAME=" + BRANCH_NAME
				+ ", CATEGORY=" + CATEGORY + ", OWN_NAME=" + OWN_NAME + ", OWN_EMAIL=" + OWN_EMAIL + ", OWN_MOBILE="
				+ OWN_MOBILE + ", ES1_NAME=" + ES1_NAME + ", ES1_EMAIL=" + ES1_EMAIL + ", ES1_MOBILE=" + ES1_MOBILE
				+ ", ES2_NAME=" + ES2_NAME + ", ES2_EMAIL=" + ES2_EMAIL + ", ES2_MOBILE=" + ES2_MOBILE + ", ES3_NAME="
				+ ES3_NAME + ", ES3_EMAIL=" + ES3_EMAIL + ", ES3_MOBILE=" + ES3_MOBILE + "]";
	}

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

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getOWN_NAME() {
		return OWN_NAME;
	}

	public void setOWN_NAME(String oWN_NAME) {
		OWN_NAME = oWN_NAME;
	}

	public String getOWN_EMAIL() {
		return OWN_EMAIL;
	}

	public void setOWN_EMAIL(String oWN_EMAIL) {
		OWN_EMAIL = oWN_EMAIL;
	}

	public String getOWN_MOBILE() {
		return OWN_MOBILE;
	}

	public void setOWN_MOBILE(String oWN_MOBILE) {
		OWN_MOBILE = oWN_MOBILE;
	}

	public String getES1_NAME() {
		return ES1_NAME;
	}

	public void setES1_NAME(String eS1_NAME) {
		ES1_NAME = eS1_NAME;
	}

	public String getES1_EMAIL() {
		return ES1_EMAIL;
	}

	public void setES1_EMAIL(String eS1_EMAIL) {
		ES1_EMAIL = eS1_EMAIL;
	}

	public String getES1_MOBILE() {
		return ES1_MOBILE;
	}

	public void setES1_MOBILE(String eS1_MOBILE) {
		ES1_MOBILE = eS1_MOBILE;
	}

	public String getES2_NAME() {
		return ES2_NAME;
	}

	public void setES2_NAME(String eS2_NAME) {
		ES2_NAME = eS2_NAME;
	}

	public String getES2_EMAIL() {
		return ES2_EMAIL;
	}

	public void setES2_EMAIL(String eS2_EMAIL) {
		ES2_EMAIL = eS2_EMAIL;
	}

	public String getES2_MOBILE() {
		return ES2_MOBILE;
	}

	public void setES2_MOBILE(String eS2_MOBILE) {
		ES2_MOBILE = eS2_MOBILE;
	}

	public String getES3_NAME() {
		return ES3_NAME;
	}

	public void setES3_NAME(String eS3_NAME) {
		ES3_NAME = eS3_NAME;
	}

	public String getES3_EMAIL() {
		return ES3_EMAIL;
	}

	public void setES3_EMAIL(String eS3_EMAIL) {
		ES3_EMAIL = eS3_EMAIL;
	}

	public String getES3_MOBILE() {
		return ES3_MOBILE;
	}

	public void setES3_MOBILE(String eS3_MOBILE) {
		ES3_MOBILE = eS3_MOBILE;
	}

	@Id
	@Column
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	

	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_EMAIL;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_MOBILE;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_EMAIL;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_MOBILE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_MOBILE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_MOBILE;
	
	
	
	
}
