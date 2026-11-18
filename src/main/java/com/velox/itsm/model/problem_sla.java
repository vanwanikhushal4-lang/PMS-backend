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
@Table(name = "problem_sla")
public class problem_sla implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6535467582725915327L;
	@Id
	@Column
	private String PT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROBLEM_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_TYPE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_TARGET_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_TARGET_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_TARGET_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_START_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_END_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_ELAPSED_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RCA_SLA_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_START_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_END_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_ELAPSED_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FIX_SLA_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_START_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_END_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_ELAPSED_SECONDS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TOTAL_SLA_STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	public String getPT_ID() {
		return PT_ID;
	}
	public void setPT_ID(String pT_ID) {
		PT_ID = pT_ID;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getPROBLEM_STATUS() {
		return PROBLEM_STATUS;
	}
	public void setPROBLEM_STATUS(String pROBLEM_STATUS) {
		PROBLEM_STATUS = pROBLEM_STATUS;
	}
	public String getSLA_TYPE() {
		return SLA_TYPE;
	}
	public void setSLA_TYPE(String sLA_TYPE) {
		SLA_TYPE = sLA_TYPE;
	}
	public String getRCA_TARGET_SECONDS() {
		return RCA_TARGET_SECONDS;
	}
	public void setRCA_TARGET_SECONDS(String rCA_TARGET_SECONDS) {
		RCA_TARGET_SECONDS = rCA_TARGET_SECONDS;
	}
	public String getRCA_TARGET() {
		return RCA_TARGET;
	}
	public void setRCA_TARGET(String rCA_TARGET) {
		RCA_TARGET = rCA_TARGET;
	}
	public String getFIX_TARGET_SECONDS() {
		return FIX_TARGET_SECONDS;
	}
	public void setFIX_TARGET_SECONDS(String fIX_TARGET_SECONDS) {
		FIX_TARGET_SECONDS = fIX_TARGET_SECONDS;
	}
	public String getFIX_TARGET() {
		return FIX_TARGET;
	}
	public void setFIX_TARGET(String fIX_TARGET) {
		FIX_TARGET = fIX_TARGET;
	}
	public String getTOTAL_TARGET_SECONDS() {
		return TOTAL_TARGET_SECONDS;
	}
	public void setTOTAL_TARGET_SECONDS(String tOTAL_TARGET_SECONDS) {
		TOTAL_TARGET_SECONDS = tOTAL_TARGET_SECONDS;
	}
	public String getTOTAL_TARGET() {
		return TOTAL_TARGET;
	}
	public void setTOTAL_TARGET(String tOTAL_TARGET) {
		TOTAL_TARGET = tOTAL_TARGET;
	}
	public String getRCA_START_TIME() {
		return RCA_START_TIME;
	}
	public void setRCA_START_TIME(String rCA_START_TIME) {
		RCA_START_TIME = rCA_START_TIME;
	}
	public String getRCA_END_TIME() {
		return RCA_END_TIME;
	}
	public void setRCA_END_TIME(String rCA_END_TIME) {
		RCA_END_TIME = rCA_END_TIME;
	}
	public String getRCA_ELAPSED_TIME() {
		return RCA_ELAPSED_TIME;
	}
	public void setRCA_ELAPSED_TIME(String rCA_ELAPSED_TIME) {
		RCA_ELAPSED_TIME = rCA_ELAPSED_TIME;
	}
	public String getRCA_ELAPSED_SECONDS() {
		return RCA_ELAPSED_SECONDS;
	}
	public void setRCA_ELAPSED_SECONDS(String rCA_ELAPSED_SECONDS) {
		RCA_ELAPSED_SECONDS = rCA_ELAPSED_SECONDS;
	}
	public String getRCA_SLA_STATUS() {
		return RCA_SLA_STATUS;
	}
	public void setRCA_SLA_STATUS(String rCA_SLA_STATUS) {
		RCA_SLA_STATUS = rCA_SLA_STATUS;
	}
	public String getFIX_START_TIME() {
		return FIX_START_TIME;
	}
	public void setFIX_START_TIME(String fIX_START_TIME) {
		FIX_START_TIME = fIX_START_TIME;
	}
	public String getFIX_END_TIME() {
		return FIX_END_TIME;
	}
	public void setFIX_END_TIME(String fIX_END_TIME) {
		FIX_END_TIME = fIX_END_TIME;
	}
	public String getFIX_ELAPSED_TIME() {
		return FIX_ELAPSED_TIME;
	}
	public void setFIX_ELAPSED_TIME(String fIX_ELAPSED_TIME) {
		FIX_ELAPSED_TIME = fIX_ELAPSED_TIME;
	}
	public String getFIX_ELAPSED_SECONDS() {
		return FIX_ELAPSED_SECONDS;
	}
	public void setFIX_ELAPSED_SECONDS(String fIX_ELAPSED_SECONDS) {
		FIX_ELAPSED_SECONDS = fIX_ELAPSED_SECONDS;
	}
	public String getFIX_SLA_STATUS() {
		return FIX_SLA_STATUS;
	}
	public void setFIX_SLA_STATUS(String fIX_SLA_STATUS) {
		FIX_SLA_STATUS = fIX_SLA_STATUS;
	}
	public String getTOTAL_START_TIME() {
		return TOTAL_START_TIME;
	}
	public void setTOTAL_START_TIME(String tOTAL_START_TIME) {
		TOTAL_START_TIME = tOTAL_START_TIME;
	}
	public String getTOTAL_END_TIME() {
		return TOTAL_END_TIME;
	}
	public void setTOTAL_END_TIME(String tOTAL_END_TIME) {
		TOTAL_END_TIME = tOTAL_END_TIME;
	}
	public String getTOTAL_ELAPSED_TIME() {
		return TOTAL_ELAPSED_TIME;
	}
	public void setTOTAL_ELAPSED_TIME(String tOTAL_ELAPSED_TIME) {
		TOTAL_ELAPSED_TIME = tOTAL_ELAPSED_TIME;
	}
	public String getTOTAL_ELAPSED_SECONDS() {
		return TOTAL_ELAPSED_SECONDS;
	}
	public void setTOTAL_ELAPSED_SECONDS(String tOTAL_ELAPSED_SECONDS) {
		TOTAL_ELAPSED_SECONDS = tOTAL_ELAPSED_SECONDS;
	}
	public String getTOTAL_SLA_STATUS() {
		return TOTAL_SLA_STATUS;
	}
	public void setTOTAL_SLA_STATUS(String tOTAL_SLA_STATUS) {
		TOTAL_SLA_STATUS = tOTAL_SLA_STATUS;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	@Override
	public String toString() {
		return "problem_sla [PT_ID=" + PT_ID + ", PRIORITY=" + PRIORITY + ", PROBLEM_STATUS=" + PROBLEM_STATUS
				+ ", SLA_TYPE=" + SLA_TYPE + ", RCA_TARGET_SECONDS=" + RCA_TARGET_SECONDS + ", RCA_TARGET=" + RCA_TARGET
				+ ", FIX_TARGET_SECONDS=" + FIX_TARGET_SECONDS + ", FIX_TARGET=" + FIX_TARGET
				+ ", TOTAL_TARGET_SECONDS=" + TOTAL_TARGET_SECONDS + ", TOTAL_TARGET=" + TOTAL_TARGET
				+ ", RCA_START_TIME=" + RCA_START_TIME + ", RCA_END_TIME=" + RCA_END_TIME + ", RCA_ELAPSED_TIME="
				+ RCA_ELAPSED_TIME + ", RCA_ELAPSED_SECONDS=" + RCA_ELAPSED_SECONDS + ", RCA_SLA_STATUS="
				+ RCA_SLA_STATUS + ", FIX_START_TIME=" + FIX_START_TIME + ", FIX_END_TIME=" + FIX_END_TIME
				+ ", FIX_ELAPSED_TIME=" + FIX_ELAPSED_TIME + ", FIX_ELAPSED_SECONDS=" + FIX_ELAPSED_SECONDS
				+ ", FIX_SLA_STATUS=" + FIX_SLA_STATUS + ", TOTAL_START_TIME=" + TOTAL_START_TIME + ", TOTAL_END_TIME="
				+ TOTAL_END_TIME + ", TOTAL_ELAPSED_TIME=" + TOTAL_ELAPSED_TIME + ", TOTAL_ELAPSED_SECONDS="
				+ TOTAL_ELAPSED_SECONDS + ", TOTAL_SLA_STATUS=" + TOTAL_SLA_STATUS + ", SEVERITY=" + SEVERITY + "]";
	}


}
