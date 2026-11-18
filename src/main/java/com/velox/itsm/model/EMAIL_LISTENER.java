package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_LISTENER" )
public class EMAIL_LISTENER implements Serializable

{
	

	private static final long serialVersionUID = 4L;
	@Id
	@Column
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_FOLDER;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PORT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String USERNAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PASSWORD;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBJECT_RESTRICTION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	
	

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAIL_SERVER;
	
	public String getEMAIL_FOLDER() {
		return EMAIL_FOLDER;
	}

	public void setEMAIL_FOLDER(String eMAIL_FOLDER) {
		EMAIL_FOLDER = eMAIL_FOLDER;
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

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	
	
	public String getMAIL_SERVER() {
		return MAIL_SERVER;
	}

	public void setMAIL_SERVER(String mAIL_SERVER) {
		MAIL_SERVER = mAIL_SERVER;
	}

	public String getSUBJECT_RESTRICTION() {
		return SUBJECT_RESTRICTION;
	}

	public void setSUBJECT_RESTRICTION(String sUBJECT_RESTRICTION) {
		SUBJECT_RESTRICTION = sUBJECT_RESTRICTION;
	}

	@Override
	public String toString() {
		return "EMAIL_LISTENER [SR_NO=" + SR_NO + ", EMAIL_FOLDER=" + EMAIL_FOLDER + ", PORT=" + PORT + ", USERNAME="
				+ USERNAME + ", PASSWORD=" + PASSWORD + ", SUBJECT_RESTRICTION=" + SUBJECT_RESTRICTION
				+ ", COMPANY_NAME=" + COMPANY_NAME + ", MAIL_SERVER=" + MAIL_SERVER + "]";
	}
	
}
