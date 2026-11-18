package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAIL_CONFIG")
public class mail_config implements Serializable {

	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7143473575736883693L;
	
	@Id
	@Column(name = "SNO")
	private int SNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String START_TLS;
	public String getSTART_TLS() {
		return START_TLS;
	}

	public void setSTART_TLS(String sTART_TLS) {
		START_TLS = sTART_TLS;
	}

	@Column(name = "HOST", columnDefinition = "NVARCHAR(500)")
	private String HOST;
	@Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(name = "PORT")
	private int PORT;

	@Column(name = "E_MAIL", columnDefinition = "NVARCHAR(500)")
	private String E_MAIL;

	@Column(name = "PASSWRD", columnDefinition = "NVARCHAR(500)")
	private String PASSWRD;

	@Column(name = "AUTHO", columnDefinition = "NVARCHAR(500)")
	private String AUTHO;
	
	@Column(name = "SENDERID", columnDefinition = "NVARCHAR(500)")
	private String SENDERID;

	
	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public String getSENDERID() {
		return SENDERID;
	}

	public void setSENDERID(String sENDERID) {
		SENDERID = sENDERID;
	}

	public String getALERT_TRIGGER_TIME() {
		return ALERT_TRIGGER_TIME;
	}

	public void setALERT_TRIGGER_TIME(String aLERT_TRIGGER_TIME) {
		ALERT_TRIGGER_TIME = aLERT_TRIGGER_TIME;
	}

	@Column(name = "ALERT_TRIGGER_TIME", columnDefinition = "NVARCHAR(500)")
	private String ALERT_TRIGGER_TIME;


	public int getSNO() {
		return SNO;
	}

	public void setSNO(int sNO) {
		SNO = sNO;
	}

	public String getHOST() {
		return HOST;
	}

	public void setHOST(String hOST) {
		HOST = hOST;
	}

	public int getPORT() {
		return PORT;
	}

	public void setPORT(int pORT) {
		PORT = pORT;
	}

	public String getE_MAIL() {
		return E_MAIL;
	}

	public void setE_MAIL(String e_MAIL) {
		E_MAIL = e_MAIL;
	}

	public String getPASSWRD() {
		return PASSWRD;
	}

	public void setPASSWRD(String pASSWRD) {
		PASSWRD = pASSWRD;
	}

	public String getAUTHO() {
		return AUTHO;
	}

	public void setAUTHO(String aUTHO) {
		AUTHO = aUTHO;
	}

	

	public mail_config() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "mail_config [SNO=" + SNO + ", START_TLS=" + START_TLS + ", HOST=" + HOST + ", COMPANY=" + COMPANY
				+ ", PORT=" + PORT + ", E_MAIL=" + E_MAIL + ", PASSWRD=" + PASSWRD + ", AUTHO=" + AUTHO + ", SENDERID="
				+ SENDERID + ", ALERT_TRIGGER_TIME=" + ALERT_TRIGGER_TIME + "]";
	}

}
