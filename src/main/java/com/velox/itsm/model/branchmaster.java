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
@Table(name="BRANCHMASTER" )
public class branchmaster implements Serializable  {

	public branchmaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250246661529451299L;
	@Id
	@Column(name = "B_ID")
	private int B_ID;
	@Column(name = "COMPANYNAME", columnDefinition = "NVARCHAR(500)")
	private String COMPANYNAME;
	@Column(name = "B_NAME", columnDefinition = "NVARCHAR(500)")
	private String B_NAME;
	public int getB_ID() {
		return B_ID;
	}
	public void setB_ID(int b_ID) {
		B_ID = b_ID;
	}
	public String getCOMPANYNAME() {
		return COMPANYNAME;
	}
	public void setCOMPANYNAME(String cOMPANYNAME) {
		COMPANYNAME = cOMPANYNAME;
	}
	public String getB_NAME() {
		return B_NAME;
	}
	public void setB_NAME(String b_NAME) {
		B_NAME = b_NAME;
	}
	@Override
	public String toString() {
		return "branchmaster [B_ID=" + B_ID + ", COMPANYNAME=" + COMPANYNAME + ", B_NAME=" + B_NAME + "]";
	}
	
}
