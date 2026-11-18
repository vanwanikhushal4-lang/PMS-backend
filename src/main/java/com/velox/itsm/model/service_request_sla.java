package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_request_sla")
public class service_request_sla implements Serializable{

	private static final long serialVersionUID = 8652151175318776449L;
	
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
	private String SERVICE_REQUEST_SLA_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVICE_REQUEST_SLA_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_START_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_END_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVICE_REQUEST_SLA_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String START_END_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_DURATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_CALENDER_WEEK_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String Actual_Working_Time;
	private String Hold_Calculation_type;
	private String CALENDER_CALACULATION;
	/**
	 * @return the tICKET_ID
	 */
	public String getTICKET_ID() {
		return TICKET_ID;
	}
	/**
	 * @param tICKET_ID the tICKET_ID to set
	 */
	public void setTICKET_ID(String tICKET_ID) {
		TICKET_ID = tICKET_ID;
	}
	/**
	 * @return the pRIORITY
	 */
	public String getPRIORITY() {
		return PRIORITY;
	}
	/**
	 * @param pRIORITY the pRIORITY to set
	 */
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	/**
	 * @return the sEVERITY
	 */
	public String getSEVERITY() {
		return SEVERITY;
	}
	/**
	 * @param sEVERITY the sEVERITY to set
	 */
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	/**
	 * @return the tICKET_STATUS
	 */
	public String getTICKET_STATUS() {
		return TICKET_STATUS;
	}
	/**
	 * @param tICKET_STATUS the tICKET_STATUS to set
	 */
	public void setTICKET_STATUS(String tICKET_STATUS) {
		TICKET_STATUS = tICKET_STATUS;
	}
	/**
	 * @return the sTART_DATE
	 */
	public String getSTART_DATE() {
		return START_DATE;
	}
	/**
	 * @param sTART_DATE the sTART_DATE to set
	 */
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	/**
	 * @return the sTOP_DATE
	 */
	public String getSTOP_DATE() {
		return STOP_DATE;
	}
	/**
	 * @param sTOP_DATE the sTOP_DATE to set
	 */
	public void setSTOP_DATE(String sTOP_DATE) {
		STOP_DATE = sTOP_DATE;
	}
	/**
	 * @return the eLAPSED_TIME
	 */
	public String getELAPSED_TIME() {
		return ELAPSED_TIME;
	}
	/**
	 * @param eLAPSED_TIME the eLAPSED_TIME to set
	 */
	public void setELAPSED_TIME(String eLAPSED_TIME) {
		ELAPSED_TIME = eLAPSED_TIME;
	}
	/**
	 * @return the sERVICE_REQUEST_SLA_TIME
	 */
	public String getSERVICE_REQUEST_SLA_TIME() {
		return SERVICE_REQUEST_SLA_TIME;
	}
	/**
	 * @param sERVICE_REQUEST_SLA_TIME the sERVICE_REQUEST_SLA_TIME to set
	 */
	public void setSERVICE_REQUEST_SLA_TIME(String sERVICE_REQUEST_SLA_TIME) {
		SERVICE_REQUEST_SLA_TIME = sERVICE_REQUEST_SLA_TIME;
	}
	/**
	 * @return the sERVICE_REQUEST_SLA_STATUS
	 */
	public String getSERVICE_REQUEST_SLA_STATUS() {
		return SERVICE_REQUEST_SLA_STATUS;
	}
	/**
	 * @param sERVICE_REQUEST_SLA_STATUS the sERVICE_REQUEST_SLA_STATUS to set
	 */
	public void setSERVICE_REQUEST_SLA_STATUS(String sERVICE_REQUEST_SLA_STATUS) {
		SERVICE_REQUEST_SLA_STATUS = sERVICE_REQUEST_SLA_STATUS;
	}
	/**
	 * @return the hOLD_START_DATE
	 */
	public String getHOLD_START_DATE() {
		return HOLD_START_DATE;
	}
	/**
	 * @param hOLD_START_DATE the hOLD_START_DATE to set
	 */
	public void setHOLD_START_DATE(String hOLD_START_DATE) {
		HOLD_START_DATE = hOLD_START_DATE;
	}
	/**
	 * @return the hOLD_END_DATE
	 */
	public String getHOLD_END_DATE() {
		return HOLD_END_DATE;
	}
	/**
	 * @param hOLD_END_DATE the hOLD_END_DATE to set
	 */
	public void setHOLD_END_DATE(String hOLD_END_DATE) {
		HOLD_END_DATE = hOLD_END_DATE;
	}
	/**
	 * @return the hOLD_ELAPSED_TIME
	 */
	public String getHOLD_ELAPSED_TIME() {
		return HOLD_ELAPSED_TIME;
	}
	/**
	 * @param hOLD_ELAPSED_TIME the hOLD_ELAPSED_TIME to set
	 */
	public void setHOLD_ELAPSED_TIME(String hOLD_ELAPSED_TIME) {
		HOLD_ELAPSED_TIME = hOLD_ELAPSED_TIME;
	}
	/**
	 * @return the sERVICE_REQUEST_SLA_TARGET
	 */
	public String getSERVICE_REQUEST_SLA_TARGET() {
		return SERVICE_REQUEST_SLA_TARGET;
	}
	/**
	 * @param sERVICE_REQUEST_SLA_TARGET the sERVICE_REQUEST_SLA_TARGET to set
	 */
	public void setSERVICE_REQUEST_SLA_TARGET(String sERVICE_REQUEST_SLA_TARGET) {
		SERVICE_REQUEST_SLA_TARGET = sERVICE_REQUEST_SLA_TARGET;
	}
	/**
	 * @return the sTART_END_TIME
	 */
	public String getSTART_END_TIME() {
		return START_END_TIME;
	}
	/**
	 * @param sTART_END_TIME the sTART_END_TIME to set
	 */
	public void setSTART_END_TIME(String sTART_END_TIME) {
		START_END_TIME = sTART_END_TIME;
	}
	/**
	 * @return the hOLD_DURATION
	 */
	public String getHOLD_DURATION() {
		return HOLD_DURATION;
	}
	/**
	 * @param hOLD_DURATION the hOLD_DURATION to set
	 */
	public void setHOLD_DURATION(String hOLD_DURATION) {
		HOLD_DURATION = hOLD_DURATION;
	}
	/**
	 * @return the actual_Working_Time
	 */
	public String getActual_Working_Time() {
		return Actual_Working_Time;
	}
	/**
	 * @param actual_Working_Time the actual_Working_Time to set
	 */
	public void setActual_Working_Time(String actual_Working_Time) {
		Actual_Working_Time = actual_Working_Time;
	}
	
	public String getHold_Calculation_type() {
		return Hold_Calculation_type;
	}
	public void setHold_Calculation_type(String hold_Calculation_type) {
		Hold_Calculation_type = hold_Calculation_type;
	}
	public String getSLA_CALENDER_WEEK_STATUS() {
		return SLA_CALENDER_WEEK_STATUS;
	}
	public void setSLA_CALENDER_WEEK_STATUS(String sLA_CALENDER_WEEK_STATUS) {
		SLA_CALENDER_WEEK_STATUS = sLA_CALENDER_WEEK_STATUS;
	}
	@Override
	public String toString() {
		return "service_request_sla [TICKET_ID=" + TICKET_ID + ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY
				+ ", TICKET_STATUS=" + TICKET_STATUS + ", START_DATE=" + START_DATE + ", STOP_DATE=" + STOP_DATE
				+ ", ELAPSED_TIME=" + ELAPSED_TIME + ", SERVICE_REQUEST_SLA_TIME=" + SERVICE_REQUEST_SLA_TIME
				+ ", SERVICE_REQUEST_SLA_STATUS=" + SERVICE_REQUEST_SLA_STATUS + ", HOLD_START_DATE=" + HOLD_START_DATE
				+ ", HOLD_END_DATE=" + HOLD_END_DATE + ", HOLD_ELAPSED_TIME=" + HOLD_ELAPSED_TIME
				+ ", SERVICE_REQUEST_SLA_TARGET=" + SERVICE_REQUEST_SLA_TARGET + ", START_END_TIME=" + START_END_TIME
				+ ", HOLD_DURATION=" + HOLD_DURATION + ", SLA_CALENDER_WEEK_STATUS=" + SLA_CALENDER_WEEK_STATUS
				+ ", Actual_Working_Time=" + Actual_Working_Time + ", Hold_Calculation_type=" + Hold_Calculation_type
				+ ", CALENDER_CALACULATION=" + CALENDER_CALACULATION + "]";
	}
	public String getCALENDER_CALACULATION() {
		return CALENDER_CALACULATION;
	}
	public void setCALENDER_CALACULATION(String cALENDER_CALACULATION) {
		CALENDER_CALACULATION = cALENDER_CALACULATION;
	}
	
	
	

}
