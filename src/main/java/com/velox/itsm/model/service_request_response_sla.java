package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_request_response_sla")
public class service_request_response_sla implements Serializable {

	private static final long serialVersionUID = 8420020490105798038L;	
	
	
	@Id
	
	private int SR_NO;
	
	
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
	private String RESPONSE_SLA_ELAPSED_TIME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESPONSE_SLA_STATUS;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESPONSE_SLA_TARGET;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESPONSE_SLA_DURATION;
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

	public String getRESPONSE_SLA_STATUS() {
		return RESPONSE_SLA_STATUS;
	}
	/**
	 * @param rESPONSE_SLA_STATUS the rESPONSE_SLA_STATUS to set
	 */
	public void setRESPONSE_SLA_STATUS(String rESPONSE_SLA_STATUS) {
		RESPONSE_SLA_STATUS = rESPONSE_SLA_STATUS;
	}
	/**
	 * @return the rESPONSE_SLA_TARGET
	 */
	public String getRESPONSE_SLA_TARGET() {
		return RESPONSE_SLA_TARGET;
	}
	/**
	 * @param rESPONSE_SLA_TARGET the rESPONSE_SLA_TARGET to set
	 */
	public void setRESPONSE_SLA_TARGET(String rESPONSE_SLA_TARGET) {
		RESPONSE_SLA_TARGET = rESPONSE_SLA_TARGET;
	}
	/**
	 * @return the rESPONSE_SLA_DURATION
	 */
	public String getRESPONSE_SLA_DURATION() {
		return RESPONSE_SLA_DURATION;
	}
	/**
	 * @param rESPONSE_SLA_DURATION the rESPONSE_SLA_DURATION to set
	 */
	public void setRESPONSE_SLA_DURATION(String rESPONSE_SLA_DURATION) {
		RESPONSE_SLA_DURATION = rESPONSE_SLA_DURATION;
	}
	/**
	 * @return the sR_NO
	 */
	public int getSR_NO() {
		return SR_NO;
	}
	/**
	 * @param sR_NO the sR_NO to set
	 */
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	/**
	 * @return the rESPONSE_SLA_ELAPSED_TIME
	 */
	public String getRESPONSE_SLA_ELAPSED_TIME() {
		return RESPONSE_SLA_ELAPSED_TIME;
	}


	public String getCALENDER_CALACULATION() {
		return CALENDER_CALACULATION;
	}
	public void setCALENDER_CALACULATION(String cALENDER_CALACULATION) {
		CALENDER_CALACULATION = cALENDER_CALACULATION;
	}
	public void setRESPONSE_SLA_ELAPSED_TIME(String rESPONSE_SLA_ELAPSED_TIME) {
		RESPONSE_SLA_ELAPSED_TIME = rESPONSE_SLA_ELAPSED_TIME;
	}
	@Override
	public String toString() {
		return "service_request_response_sla [SR_NO=" + SR_NO + ", TICKET_ID=" + TICKET_ID + ", PRIORITY=" + PRIORITY
				+ ", SEVERITY=" + SEVERITY + ", TICKET_STATUS=" + TICKET_STATUS + ", START_DATE=" + START_DATE
				+ ", STOP_DATE=" + STOP_DATE + ", ELAPSED_TIME=" + ELAPSED_TIME + ", RESPONSE_SLA_ELAPSED_TIME="
				+ RESPONSE_SLA_ELAPSED_TIME + ", RESPONSE_SLA_STATUS=" + RESPONSE_SLA_STATUS + ", RESPONSE_SLA_TARGET="
				+ RESPONSE_SLA_TARGET + ", RESPONSE_SLA_DURATION=" + RESPONSE_SLA_DURATION + ", CALENDER_CALACULATION="
				+ CALENDER_CALACULATION + "]";
	}

	
}

