package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESCALATION_MATRIX" )
public class ESCALATION_MATRIX implements Serializable  {

	private static final long serialVersionUID = 4L;
	

	@Id
	@Column
	private int SR_NO;
	
	

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

	public String getPRIORITY() {
		return PRIORITY;
	}

	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getSEND_MAIL() {
		return SEND_MAIL;
	}

	public void setSEND_MAIL(String sEND_MAIL) {
		SEND_MAIL = sEND_MAIL;
	}

	public String getSEND_SMS() {
		return SEND_SMS;
	}

	public void setSEND_SMS(String sEND_SMS) {
		SEND_SMS = sEND_SMS;
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

	public String getOWN_TIME() {
		return OWN_TIME;
	}

	public void setOWN_TIME(String oWN_TIME) {
		OWN_TIME = oWN_TIME;
	}

	public String getOWN_TIME_FORMAT() {
		return OWN_TIME_FORMAT;
	}

	public void setOWN_TIME_FORMAT(String oWN_TIME_FORMAT) {
		OWN_TIME_FORMAT = oWN_TIME_FORMAT;
	}

	public String getOWN_TIME_SEC() {
		return OWN_TIME_SEC;
	}

	public void setOWN_TIME_SEC(String oWN_TIME_SEC) {
		OWN_TIME_SEC = oWN_TIME_SEC;
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

	public String getES1_TIME() {
		return ES1_TIME;
	}

	public void setES1_TIME(String eS1_TIME) {
		ES1_TIME = eS1_TIME;
	}

	public String getES1_TIME_FORMAT() {
		return ES1_TIME_FORMAT;
	}

	public void setES1_TIME_FORMAT(String eS1_TIME_FORMAT) {
		ES1_TIME_FORMAT = eS1_TIME_FORMAT;
	}

	public String getES1_TIME_SEC() {
		return ES1_TIME_SEC;
	}

	public void setES1_TIME_SEC(String eS1_TIME_SEC) {
		ES1_TIME_SEC = eS1_TIME_SEC;
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

	public String getES2_TIME() {
		return ES2_TIME;
	}

	public void setES2_TIME(String eS2_TIME) {
		ES2_TIME = eS2_TIME;
	}

	public String getES2_TIME_SEC() {
		return ES2_TIME_SEC;
	}

	public void setES2_TIME_SEC(String eS2_TIME_SEC) {
		ES2_TIME_SEC = eS2_TIME_SEC;
	}

	public String getES2_TIME_FORMAT() {
		return ES2_TIME_FORMAT;
	}

	public void setES2_TIME_FORMAT(String eS2_TIME_FORMAT) {
		ES2_TIME_FORMAT = eS2_TIME_FORMAT;
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

	public String getES3_TIME() {
		return ES3_TIME;
	}

	public void setES3_TIME(String eS3_TIME) {
		ES3_TIME = eS3_TIME;
	}

	public String getES3_TIME_FORMAT() {
		return ES3_TIME_FORMAT;
	}

	public void setES3_TIME_FORMAT(String eS3_TIME_FORMAT) {
		ES3_TIME_FORMAT = eS3_TIME_FORMAT;
	}

	public String getES3_TIME_SEC() {
		return ES3_TIME_SEC;
	}

	public void setES3_TIME_SEC(String eS3_TIME_SEC) {
		ES3_TIME_SEC = eS3_TIME_SEC;
	}

	@Override
	public String toString() {
		return "ESCALATION_MATRIX [SR_NO=" + SR_NO + ", COMPANY_NAME=" + COMPANY_NAME + ", BRANCH_NAME=" + BRANCH_NAME
				+ ", PRIORITY=" + PRIORITY + ", CATEGORY=" + CATEGORY + ", SEND_MAIL=" + SEND_MAIL + ", SEND_SMS="
				+ SEND_SMS + ", OWN_NAME=" + OWN_NAME + ", OWN_EMAIL=" + OWN_EMAIL + ", ES3_NAME=" + ES3_NAME
				+ ", OWN_MOBILE=" + OWN_MOBILE + ", OWN_TIME=" + OWN_TIME + ", OWN_TIME_FORMAT=" + OWN_TIME_FORMAT
				+ ", OWN_TIME_SEC=" + OWN_TIME_SEC + ", ES1_NAME=" + ES1_NAME + ", ES1_EMAIL=" + ES1_EMAIL
				+ ", ES1_MOBILE=" + ES1_MOBILE + ", ES1_TIME=" + ES1_TIME + ", ES1_TIME_FORMAT=" + ES1_TIME_FORMAT
				+ ", ES1_TIME_SEC=" + ES1_TIME_SEC + ", ES2_NAME=" + ES2_NAME + ", ES2_EMAIL=" + ES2_EMAIL
				+ ", ES2_MOBILE=" + ES2_MOBILE + ", ES2_TIME=" + ES2_TIME + ", ES2_TIME_SEC=" + ES2_TIME_SEC
				+ ", ES2_TIME_FORMAT=" + ES2_TIME_FORMAT + ", ES3_EMAIL=" + ES3_EMAIL + ", ES3_MOBILE=" + ES3_MOBILE
				+ ", ES3_TIME=" + ES3_TIME + ", ES3_TIME_FORMAT=" + ES3_TIME_FORMAT + ", ES3_TIME_SEC=" + ES3_TIME_SEC
				+ "]";
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	

	@Column(columnDefinition = "NVARCHAR(500)")
	private String BRANCH_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEND_MAIL;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEND_SMS;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_EMAIL;
	
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_NAME;
	
	public String getES3_NAME() {
		return ES3_NAME;
	}

	public void setES3_NAME(String eS3_NAME) {
		ES3_NAME = eS3_NAME;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_MOBILE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_TIME_FORMAT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OWN_TIME_SEC;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_MOBILE;
	
	
	//--
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_TIME_FORMAT;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES1_TIME_SEC;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_NAME;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_MOBILE;
	
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_TIME;
	
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_TIME_SEC;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES2_TIME_FORMAT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_MOBILE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_TIME_FORMAT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ES3_TIME_SEC;
	
	
}
