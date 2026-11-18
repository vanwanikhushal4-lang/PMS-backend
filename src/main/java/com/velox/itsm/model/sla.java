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
@Table(name = "SLA")
public class sla implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1425758294142903148L;
	@Id
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String START_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String STOP_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_START_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_END_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String START_END_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_DURATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String Actual_Working_Time;
	private String HOLD_TIME_CALCULATION;
	
	private String CALENDER_CALACULATION;
	
	public String getTICKET_ID() {
		return TICKET_ID;
	}
	public void setTICKET_ID(String tICKET_ID) {
		TICKET_ID = tICKET_ID;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	public String getTICKET_STATUS() {
		return TICKET_STATUS;
	}
	public void setTICKET_STATUS(String tICKET_STATUS) {
		TICKET_STATUS = tICKET_STATUS;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getSTOP_DATE() {
		return STOP_DATE;
	}
	public void setSTOP_DATE(String sTOP_DATE) {
		STOP_DATE = sTOP_DATE;
	}
	public String getELAPSED_TIME() {
		return ELAPSED_TIME;
	}
	public void setELAPSED_TIME(String eLAPSED_TIME) {
		ELAPSED_TIME = eLAPSED_TIME;
	}
	public String getSLA_TIME() {
		return SLA_TIME;
	}
	public void setSLA_TIME(String sLA_TIME) {
		SLA_TIME = sLA_TIME;
	}
	public String getSLA_STATUS() {
		return SLA_STATUS;
	}
	public void setSLA_STATUS(String sLA_STATUS) {
		SLA_STATUS = sLA_STATUS;
	}
	public String getHOLD_START_DATE() {
		return HOLD_START_DATE;
	}
	public void setHOLD_START_DATE(String hOLD_START_DATE) {
		HOLD_START_DATE = hOLD_START_DATE;
	}
	public String getHOLD_END_DATE() {
		return HOLD_END_DATE;
	}
	public void setHOLD_END_DATE(String hOLD_END_DATE) {
		HOLD_END_DATE = hOLD_END_DATE;
	}
	public String getHOLD_ELAPSED_TIME() {
		return HOLD_ELAPSED_TIME;
	}
	public void setHOLD_ELAPSED_TIME(String hOLD_ELAPSED_TIME) {
		HOLD_ELAPSED_TIME = hOLD_ELAPSED_TIME;
	}
	public String getSLA_TARGET() {
		return SLA_TARGET;
	}
	public void setSLA_TARGET(String sLA_TARGET) {
		SLA_TARGET = sLA_TARGET;
	}
	public String getSTART_END_TIME() {
		return START_END_TIME;
	}
	public void setSTART_END_TIME(String sTART_END_TIME) {
		START_END_TIME = sTART_END_TIME;
	}
	public String getHOLD_DURATION() {
		return HOLD_DURATION;
	}
	public void setHOLD_DURATION(String hOLD_DURATION) {
		HOLD_DURATION = hOLD_DURATION;
	}
	
	
	public String getActual_Working_Time() {
		return Actual_Working_Time;
	}
	public void setActual_Working_Time(String actual_Working_Time) {
		Actual_Working_Time = actual_Working_Time;
	}
	
	
	
	public String getHOLD_TIME_CALCULATION() {
		return HOLD_TIME_CALCULATION;
	}
	public void setHOLD_TIME_CALCULATION(String hOLD_TIME_CALCULATION) {
		HOLD_TIME_CALCULATION = hOLD_TIME_CALCULATION;
	}
	
	/**
	 * @return the cALENDER_CALACULATION
	 */
	public String getCALENDER_CALACULATION() {
		return CALENDER_CALACULATION;
	}
	/**
	 * @param cALENDER_CALACULATION the cALENDER_CALACULATION to set
	 */
	public void setCALENDER_CALACULATION(String cALENDER_CALACULATION) {
		CALENDER_CALACULATION = cALENDER_CALACULATION;
	}
	@Override
	public String toString() {
		return "sla [TICKET_ID=" + TICKET_ID + ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY + ", TICKET_STATUS="
				+ TICKET_STATUS + ", START_DATE=" + START_DATE + ", STOP_DATE=" + STOP_DATE + ", ELAPSED_TIME="
				+ ELAPSED_TIME + ", SLA_TIME=" + SLA_TIME + ", SLA_STATUS=" + SLA_STATUS + ", HOLD_START_DATE="
				+ HOLD_START_DATE + ", HOLD_END_DATE=" + HOLD_END_DATE + ", HOLD_ELAPSED_TIME=" + HOLD_ELAPSED_TIME
				+ ", SLA_TARGET=" + SLA_TARGET + ", START_END_TIME=" + START_END_TIME + ", HOLD_DURATION="
				+ HOLD_DURATION + ", Actual_Working_Time=" + Actual_Working_Time + ", HOLD_TIME_CALCULATION="
				+ HOLD_TIME_CALCULATION + ", CALENDER_CALACULATION=" + CALENDER_CALACULATION + "]";
	}



}
