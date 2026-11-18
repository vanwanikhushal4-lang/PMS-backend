package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP_CHECK")
public class otp_check implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2292050205789104957L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CONTACT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OTP;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USER_TYPE;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getCONTACT() {
		return CONTACT;
	}
	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	@Override
	public String toString() {
		return "otp_check [SR_NO=" + SR_NO + ", CONTACT=" + CONTACT + ", OTP=" + OTP + ", USER_TYPE=" + USER_TYPE + "]";
	}
	public otp_check() {
		super();
		// TODO Auto-generated constructor stub
	}
	public otp_check(int sR_NO, String cONTACT, String oTP, String uSER_TYPE) {
		super();
		SR_NO = sR_NO;
		CONTACT = cONTACT;
		OTP = oTP;
		USER_TYPE = uSER_TYPE;
	}
	
}
