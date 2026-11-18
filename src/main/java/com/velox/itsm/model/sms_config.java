package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SMS_CONFIG")
public class sms_config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8587889239012996519L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String API_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String URL;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PARAM;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getAPI_NAME() {
		return API_NAME;
	}

	public void setAPI_NAME(String aPI_NAME) {
		API_NAME = aPI_NAME;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getPARAM() {
		return PARAM;
	}

	public void setPARAM(String pARAM) {
		PARAM = pARAM;
	}

	public String getACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}

	
	@Override
	public String toString() {
		return "sms_config [SR_NO=" + SR_NO + ", API_NAME=" + API_NAME + ", URL=" + URL + ", PARAM=" + PARAM
				+ ", ACTIVE=" + ACTIVE + ", COMPANY=" + COMPANY + "]";
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public sms_config() {
		super();
		// TODO Auto-generated constructor stub
	}

}
