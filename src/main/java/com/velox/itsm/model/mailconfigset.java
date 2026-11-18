package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAILCONFIGSET")
public class mailconfigset implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -630647866161538328L;
	
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	@Column(name = "USER_TYPE", columnDefinition = "NVARCHAR(500)")
	private String USER_TYPE;
	
	@Column(name = "USER_NAME", columnDefinition = "NVARCHAR(500)")
	private String USER_NAME;
	
	@Column(name = "MAIL_AUTH", columnDefinition = "NVARCHAR(500)")
	private String MAIL_AUTH;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getUSER_TYPE() {
		return USER_TYPE;
	}

	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getMAIL_AUTH() {
		return MAIL_AUTH;
	}

	public void setMAIL_AUTH(String mAIL_AUTH) {
		MAIL_AUTH = mAIL_AUTH;
	}

	@Override
	public String toString() {
		return "mailconfigset [SR_NO=" + SR_NO + ", USER_TYPE=" + USER_TYPE + ", USER_NAME=" + USER_NAME
				+ ", MAIL_AUTH=" + MAIL_AUTH + "]";
	}

	public mailconfigset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
