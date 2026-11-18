package com.velox.itsm.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UPDATE_PRIORITY_SEVERITY")
public class update_priority_severity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5926099023076233084L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_SUBJECT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OLD_PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String OLD_SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String NEW_PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String NEW_SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ENGINEER_COMPANY;
	@Column(columnDefinition = "TEXT")
	private String ENGINEER_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REQUEST_DATETIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TC_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TC_COMPANY;
	@Column(columnDefinition = "TEXT")
	private String TC_NOTES;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPROVE_DATETIME;
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getT_ID() {
		return T_ID;
	}
	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getT_COMPANY() {
		return T_COMPANY;
	}
	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}
	public String getT_BRANCH() {
		return T_BRANCH;
	}
	public void setT_BRANCH(String t_BRANCH) {
		T_BRANCH = t_BRANCH;
	}
	public String getT_DEPARTMENT() {
		return T_DEPARTMENT;
	}
	public void setT_DEPARTMENT(String t_DEPARTMENT) {
		T_DEPARTMENT = t_DEPARTMENT;
	}
	public String getT_SUBJECT() {
		return T_SUBJECT;
	}
	public void setT_SUBJECT(String t_SUBJECT) {
		T_SUBJECT = t_SUBJECT;
	}
	public String getOLD_PRIORITY() {
		return OLD_PRIORITY;
	}
	public void setOLD_PRIORITY(String oLD_PRIORITY) {
		OLD_PRIORITY = oLD_PRIORITY;
	}
	public String getOLD_SEVERITY() {
		return OLD_SEVERITY;
	}
	public void setOLD_SEVERITY(String oLD_SEVERITY) {
		OLD_SEVERITY = oLD_SEVERITY;
	}
	public String getNEW_PRIORITY() {
		return NEW_PRIORITY;
	}
	public void setNEW_PRIORITY(String nEW_PRIORITY) {
		NEW_PRIORITY = nEW_PRIORITY;
	}
	public String getNEW_SEVERITY() {
		return NEW_SEVERITY;
	}
	public void setNEW_SEVERITY(String nEW_SEVERITY) {
		NEW_SEVERITY = nEW_SEVERITY;
	}
	public String getENGINEER_NAME() {
		return ENGINEER_NAME;
	}
	public void setENGINEER_NAME(String eNGINEER_NAME) {
		ENGINEER_NAME = eNGINEER_NAME;
	}
	public String getENGINEER_COMPANY() {
		return ENGINEER_COMPANY;
	}
	public void setENGINEER_COMPANY(String eNGINEER_COMPANY) {
		ENGINEER_COMPANY = eNGINEER_COMPANY;
	}
	public String getENGINEER_NOTES() {
		return ENGINEER_NOTES;
	}
	public void setENGINEER_NOTES(String eNGINEER_NOTES) {
		ENGINEER_NOTES = eNGINEER_NOTES;
	}
	public String getREQUEST_DATETIME() {
		return REQUEST_DATETIME;
	}
	public void setREQUEST_DATETIME(String rEQUEST_DATETIME) {
		REQUEST_DATETIME = rEQUEST_DATETIME;
	}
	public String getTC_NAME() {
		return TC_NAME;
	}
	public void setTC_NAME(String tC_NAME) {
		TC_NAME = tC_NAME;
	}
	public String getTC_COMPANY() {
		return TC_COMPANY;
	}
	public void setTC_COMPANY(String tC_COMPANY) {
		TC_COMPANY = tC_COMPANY;
	}
	public String getTC_NOTES() {
		return TC_NOTES;
	}
	public void setTC_NOTES(String tC_NOTES) {
		TC_NOTES = tC_NOTES;
	}
	public String getAPPROVE_DATETIME() {
		return APPROVE_DATETIME;
	}
	public void setAPPROVE_DATETIME(String aPPROVE_DATETIME) {
		APPROVE_DATETIME = aPPROVE_DATETIME;
	}
	@Override
	public String toString() {
		return "update_priority_severity [SR_NO=" + SR_NO + ", T_ID=" + T_ID + ", STATUS=" + STATUS + ", T_COMPANY="
				+ T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT + ", T_SUBJECT=" + T_SUBJECT
				+ ", OLD_PRIORITY=" + OLD_PRIORITY + ", OLD_SEVERITY=" + OLD_SEVERITY + ", NEW_PRIORITY=" + NEW_PRIORITY
				+ ", NEW_SEVERITY=" + NEW_SEVERITY + ", ENGINEER_NAME=" + ENGINEER_NAME + ", ENGINEER_COMPANY="
				+ ENGINEER_COMPANY + ", ENGINEER_NOTES=" + ENGINEER_NOTES + ", REQUEST_DATETIME=" + REQUEST_DATETIME
				+ ", TC_NAME=" + TC_NAME + ", TC_COMPANY=" + TC_COMPANY + ", TC_NOTES=" + TC_NOTES
				+ ", APPROVE_DATETIME=" + APPROVE_DATETIME + "]";
	}
	
	
	

}
