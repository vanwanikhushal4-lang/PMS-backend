package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class compositemaster  implements Serializable{
	
	
	private static final long serialVersionUID = -2469894830441779556L;

	@Id
	@Column(name = "PCOM_ID")
	private int PCOM_ID;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String BRANCH;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String DEPARTMENT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String SUB_DEPARTMENT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String LOCATION;

	public int getPCOM_ID() {
		return PCOM_ID;
	}

	public void setPCOM_ID(int pCOM_ID) {
		PCOM_ID = pCOM_ID;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public String getBRANCH() {
		return BRANCH;
	}

	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getSUB_DEPARTMENT() {
		return SUB_DEPARTMENT;
	}

	public void setSUB_DEPARTMENT(String sUB_DEPARTMENT) {
		SUB_DEPARTMENT = sUB_DEPARTMENT;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	@Override
	public String toString() {
		return "problemcompositemaster [PCOM_ID=" + PCOM_ID + ", COMPANY=" + COMPANY + ", BRANCH=" + BRANCH
				+ ", DEPARTMENT=" + DEPARTMENT + ", SUB_DEPARTMENT=" + SUB_DEPARTMENT + ", LOCATION=" + LOCATION + "]";
	}

	
	
	

}
