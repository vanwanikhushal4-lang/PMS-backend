package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ReviseDateHistory {
	
	@Id
	@Column
	@GeneratedValue
	private int SR_NO;	
	
	private String TASK_ID;
	private String START_DATE;
	private String REVISE_START_DATE;
	private String END_DATE;
	private String REVISE_END_DATE;
	private String APPROVED_DATE;
	private String APPROVED_BY;
	private String REVISE_REASON;
	
	
	public String getREVISE_REASON() {
		return REVISE_REASON;
	}
	public void setREVISE_REASON(String rEVISE_REASON) {
		REVISE_REASON = rEVISE_REASON;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getTASK_ID() {
		return TASK_ID;
	}
	public void setTASK_ID(String tASK_ID) {
		TASK_ID = tASK_ID;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getREVISE_START_DATE() {
		return REVISE_START_DATE;
	}
	public void setREVISE_START_DATE(String rEVISE_START_DATE) {
		REVISE_START_DATE = rEVISE_START_DATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getREVISE_END_DATE() {
		return REVISE_END_DATE;
	}
	public void setREVISE_END_DATE(String rEVISE_END_DATE) {
		REVISE_END_DATE = rEVISE_END_DATE;
	}
	public String getAPPROVED_DATE() {
		return APPROVED_DATE;
	}
	public void setAPPROVED_DATE(String aPPROVED_DATE) {
		APPROVED_DATE = aPPROVED_DATE;
	}
	public String getAPPROVED_BY() {
		return APPROVED_BY;
	}
	public void setAPPROVED_BY(String aPPROVED_BY) {
		APPROVED_BY = aPPROVED_BY;
	}
	
	
	@Override
	public String toString() {
		return "ReviseDateHistory [SR_NO=" + SR_NO + ", TASK_ID=" + TASK_ID + ", START_DATE=" + START_DATE
				+ ", REVISE_START_DATE=" + REVISE_START_DATE + ", END_DATE=" + END_DATE + ", REVISE_END_DATE="
				+ REVISE_END_DATE + ", APPROVED_DATE=" + APPROVED_DATE + ", APPROVED_BY=" + APPROVED_BY
				+ ", REVISE_REASON=" + REVISE_REASON + "]";
	}
	
	
	
	
	
	
	
	

}
