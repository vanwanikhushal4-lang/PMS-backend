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
@Table(name="JOB" )
public class job implements Serializable  {

	public job() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	@Override
	public String toString() {
		return "job [SR_NO=" + SR_NO + ", TICKET_IDES1=" + TICKET_IDES1 + ", ES1=" + ES1 + ", ES2=" + ES2 + ", ES3="
				+ ES3 + ", ES4=" + ES4 + ", ASSIGN_NAME=" + ASSIGN_NAME + ", CDATE=" + CDATE + ", CURRENT_TIME="
				+ CURRENT_TIME + "]";
	}


	public int getSR_NO() {
		return SR_NO;
	}


	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}


	public int getTICKET_IDES1() {
		return TICKET_IDES1;
	}


	public void setTICKET_IDES1(int tICKET_IDES1) {
		TICKET_IDES1 = tICKET_IDES1;
	}


	public int getES1() {
		return ES1;
	}


	public void setES1(int eS1) {
		ES1 = eS1;
	}


	public int getES2() {
		return ES2;
	}


	public void setES2(int eS2) {
		ES2 = eS2;
	}


	public int getES3() {
		return ES3;
	}


	public void setES3(int eS3) {
		ES3 = eS3;
	}


	public int getES4() {
		return ES4;
	}


	public void setES4(int eS4) {
		ES4 = eS4;
	}


	public String getASSIGN_NAME() {
		return ASSIGN_NAME;
	}


	public void setASSIGN_NAME(String aSSIGN_NAME) {
		ASSIGN_NAME = aSSIGN_NAME;
	}


	public String getCDATE() {
		return CDATE;
	}


	public void setCDATE(String cDATE) {
		CDATE = cDATE;
	}


	public String getCURRENT_TIME() {
		return CURRENT_TIME;
	}


	public void setCURRENT_TIME(String cURRENT_TIME) {
		CURRENT_TIME = cURRENT_TIME;
	}
	@Column(name = "TICKET_ID")
	private int TICKET_IDES1;
	
	
	@Column(name = "ES1")
	private int ES1;
	
	@Column(name = "ES2")
	private int ES2;
	
	
	@Column(name = "ES3")
	private int ES3;
	
	
	@Column(name = "ES4")
	private int ES4;
	
	@Column(name = "ASSIGN_NAME", columnDefinition = "NVARCHAR(500)")
	private String ASSIGN_NAME;
	
	
	@Column(name = "CDATE", columnDefinition = "NVARCHAR(500)")
	private String CDATE;
	
	
	@Column(name = "CURRENT_TIME", columnDefinition = "NVARCHAR(500)")
	private String CURRENT_TIME;
	
}
