package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MFA_TYPE")
public class TwoFactorAuthenticationType implements Serializable {

	private static final long serialVersionUID = -6454100424855196121L;

	@Id
	@Column
	private int SRNO;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String Authentication_Type;

	public int getSRNO() {
		return SRNO;
	}

	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}

	public String getAuthentication_Type() {
		return Authentication_Type;
	}

	public void setAuthentication_Type(String authentication_Type) {
		Authentication_Type = authentication_Type;
	}

}
