package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AD_INTEGRATION" )
public class AD_INTEGRATION  implements Serializable{
	
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


	public String getDOMAIN_NAME() {
		return DOMAIN_NAME;
	}


	public void setDOMAIN_NAME(String dOMAIN_NAME) {
		DOMAIN_NAME = dOMAIN_NAME;
	}


	public String getPASSWORD() {
		return PASSWORD;
	}


	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}


	public String getHOST() {
		return HOST;
	}


	public void setHOST(String hOST) {
		HOST = hOST;
	}


	public String getPORT() {
		return PORT;
	}


	public void setPORT(String pORT) {
		PORT = pORT;
	}


	public String getUSERNAME() {
		return USERNAME;
	}


	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}


	@Column(columnDefinition = "NVARCHAR(500)")
	private String DOMAIN_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOST;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PORT;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;

	public String getCOMPANY() {
		return COMPANY;
	}


	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}


	@Override
	public String toString() {
		return "AD_INTEGRATION [SR_NO=" + SR_NO + ", DOMAIN_NAME=" + DOMAIN_NAME + ", PASSWORD=" + PASSWORD + ", HOST="
				+ HOST + ", PORT=" + PORT + ", USERNAME=" + USERNAME + ", COMPANY=" + COMPANY + "]";
	}
	
}
