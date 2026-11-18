package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AD_USER_MANAGE" )
public class AD_USER_MANAGE  implements Serializable{
	
	private static final long serialVersionUID = 4L;
	
	@Id
	@Column
	private int SR_NO;
	
  

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getCONFPASS() {
		return CONFPASS;
	}

	public void setCONFPASS(String cONFPASS) {
		CONFPASS = cONFPASS;
	}

	public String getUSERTYPE() {
		return USERTYPE;
	}

	public void setUSERTYPE(String uSERTYPE) {
		USERTYPE = uSERTYPE;
	}

	public String getDEPT() {
		return DEPT;
	}

	public void setDEPT(String dEPT) {
		DEPT = dEPT;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getB_NAME() {
		return B_NAME;
	}

	public void setB_NAME(String b_NAME) {
		B_NAME = b_NAME;
	}

	public String getPHONE_NO() {
		return PHONE_NO;
	}

	public void setPHONE_NO(String pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String NAME;
    
	 @Column(columnDefinition = "NVARCHAR(500)")
		private String COMPANY;
    @Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
    
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String EMAIL;
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String PASSWORD;
    
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String CONFPASS;
    
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String USERTYPE;
    
    
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String DEPT;
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String DOB;
    
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String B_NAME;
    
    @Column(columnDefinition = "NVARCHAR(500)")
  	private String PHONE_NO;


    @Column(columnDefinition = "NVARCHAR(500)")
  	private String DESIGNATION;



	public String getDESIGNATION() {
		return DESIGNATION;
	}

	public void setDESIGNATION(String dESIGNATION) {
		DESIGNATION = dESIGNATION;
	}

	@Override
	public String toString() {
		return "AD_USER_MANAGE [SR_NO=" + SR_NO + ", NAME=" + NAME + ", COMPANY=" + COMPANY + ", USERNAME=" + USERNAME
				+ ", EMAIL=" + EMAIL + ", PASSWORD=" + PASSWORD + ", CONFPASS=" + CONFPASS + ", USERTYPE=" + USERTYPE
				+ ", DEPT=" + DEPT + ", DOB=" + DOB + ", B_NAME=" + B_NAME + ", PHONE_NO=" + PHONE_NO + ", DESIGNATION="
				+ DESIGNATION + "]";
	}



    
    
	
	

	
}
