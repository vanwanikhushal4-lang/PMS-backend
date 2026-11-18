package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VROPS_INTEGRATION" )
public class VROPS_INTEGRATION implements Serializable
{

	@Override
	public String toString() {
		return "VROPS_INTEGRATION [SR_NO=" + SR_NO + ", ALERT_TYPE=" + ALERT_TYPE + ", USERNAME=" + USERNAME
				+ ", PASSWORD=" + PASSWORD + ", SERVICE_URL=" + SERVICE_URL + ", VERIFY_CERTIFICATE="
				+ VERIFY_CERTIFICATE + ", IGNORE_HOSTNAME=" + IGNORE_HOSTNAME + "]";
	}

	private static final long serialVersionUID = 4L;
	@Id
	@Column
	private int SR_NO;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ALERT_TYPE;
	

	public String getALERT_TYPE() {
		return ALERT_TYPE;
	}

	public void setALERT_TYPE(String aLERT_TYPE) {
		ALERT_TYPE = aLERT_TYPE;
	}

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
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

	public String getSERVICE_URL() {
		return SERVICE_URL;
	}

	public void setSERVICE_URL(String sERVICE_URL) {
		SERVICE_URL = sERVICE_URL;
	}

	public String getVERIFY_CERTIFICATE() {
		return VERIFY_CERTIFICATE;
	}

	public void setVERIFY_CERTIFICATE(String vERIFY_CERTIFICATE) {
		VERIFY_CERTIFICATE = vERIFY_CERTIFICATE;
	}

	public String getIGNORE_HOSTNAME() {
		return IGNORE_HOSTNAME;
	}

	public void setIGNORE_HOSTNAME(String iGNORE_HOSTNAME) {
		IGNORE_HOSTNAME = iGNORE_HOSTNAME;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVICE_URL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String VERIFY_CERTIFICATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String IGNORE_HOSTNAME;
	
	
	
}
