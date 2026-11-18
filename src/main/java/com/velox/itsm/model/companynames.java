package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANYMASTER")
public class companynames implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2758462706063482575L;
	@Id
	@Column(name = "C_ID")
	private int C_ID;
	@Column(name = "C_NAME", columnDefinition = "NVARCHAR(500)")
	private String C_NAME;
	@Column(name = "C_MAIL", columnDefinition = "NVARCHAR(500)")
	private String C_MAIL;

	public int getC_ID() {
		return C_ID;
	}

	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}

	public String getC_NAME() {
		return C_NAME;
	}

	public void setC_NAME(String c_NAME) {
		C_NAME = c_NAME;
	}

	public String getC_MAIL() {
		return C_MAIL;
	}

	public void setC_MAIL(String c_MAIL) {
		C_MAIL = c_MAIL;
	}

	@Override
	public String toString() {
		return "companynames [C_ID=" + C_ID + ", C_NAME=" + C_NAME + ", C_MAIL=" + C_MAIL + "]";
	}

	public companynames() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
