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
@Table(name = "esc_master")
public class esc_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1850658081222424592L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ESCALATION_LEVEL;
	@Column
	private String ESCALATION_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MANAGEMENT_DESIGNATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MANAGEMENT_USERNAME;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getESCALATION_LEVEL() {
		return ESCALATION_LEVEL;
	}
	public void setESCALATION_LEVEL(String eSCALATION_LEVEL) {
		ESCALATION_LEVEL = eSCALATION_LEVEL;
	}
	public String getESCALATION_TIME() {
		return ESCALATION_TIME;
	}
	public void setESCALATION_TIME(String eSCALATION_TIME) {
		ESCALATION_TIME = eSCALATION_TIME;
	}
	public String getPRIORITY_NAME() {
		return PRIORITY_NAME;
	}
	public void setPRIORITY_NAME(String pRIORITY_NAME) {
		PRIORITY_NAME = pRIORITY_NAME;
	}
	public String getSEVERITY_NAME() {
		return SEVERITY_NAME;
	}
	public void setSEVERITY_NAME(String sEVERITY_NAME) {
		SEVERITY_NAME = sEVERITY_NAME;
	}
	public String getMANAGEMENT_DESIGNATION() {
		return MANAGEMENT_DESIGNATION;
	}
	public void setMANAGEMENT_DESIGNATION(String mANAGEMENT_DESIGNATION) {
		MANAGEMENT_DESIGNATION = mANAGEMENT_DESIGNATION;
	}
	public String getMANAGEMENT_USERNAME() {
		return MANAGEMENT_USERNAME;
	}
	public void setMANAGEMENT_USERNAME(String mANAGEMENT_USERNAME) {
		MANAGEMENT_USERNAME = mANAGEMENT_USERNAME;
	}
	@Override
	public String toString() {
		return "esc_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", ESCALATION_LEVEL=" + ESCALATION_LEVEL
				+ ", ESCALATION_TIME=" + ESCALATION_TIME + ", PRIORITY_NAME=" + PRIORITY_NAME + ", SEVERITY_NAME="
				+ SEVERITY_NAME + ", MANAGEMENT_DESIGNATION=" + MANAGEMENT_DESIGNATION + ", MANAGEMENT_USERNAME="
				+ MANAGEMENT_USERNAME + "]";
	}
	
	
}
