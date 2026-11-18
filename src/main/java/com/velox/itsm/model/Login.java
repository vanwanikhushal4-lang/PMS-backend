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
@Table(name="LOGIN" )
public class Login implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int USERID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERTYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PHONE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String LOGIN_TYPE;
	
	
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
	public String getUSERTYPE() {
		return USERTYPE;
	}
	public void setUSERTYPE(String uSERTYPE) {
		USERTYPE = uSERTYPE;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	
	public String getLOGIN_TYPE() {
		return LOGIN_TYPE;
	}
	public void setLOGIN_TYPE(String lOGIN_TYPE) {
		LOGIN_TYPE = lOGIN_TYPE;
	}
	
	@Override
	public String toString() {
		return "Login [USERID=" + USERID + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", USERTYPE="
				+ USERTYPE + ", PHONE=" + PHONE + ", LOGIN_TYPE=" + LOGIN_TYPE + "]";
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
}
