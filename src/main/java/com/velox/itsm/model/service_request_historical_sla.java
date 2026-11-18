package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_request_historical_sla")
public class service_request_historical_sla implements Serializable{

	private static final long serialVersionUID = 53263288281388383L;
	
	@Id
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_ID;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_START_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_END_DATE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_ELAPSED_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_DURATION;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_BRANCH;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String T_DEPARTMENT;

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
	 * @return the sLA_STATUS
	 */
	public String getSLA_STATUS() {
		return SLA_STATUS;
	}

	/**
	 * @param sLA_STATUS the sLA_STATUS to set
	 */
	public void setSLA_STATUS(String sLA_STATUS) {
		SLA_STATUS = sLA_STATUS;
	}

	/**
	 * @return the t_COMPANY
	 */
	public String getT_COMPANY() {
		return T_COMPANY;
	}

	/**
	 * @param t_COMPANY the t_COMPANY to set
	 */
	public void setT_COMPANY(String t_COMPANY) {
		T_COMPANY = t_COMPANY;
	}

	/**
	 * @return the t_BRANCH
	 */
	public String getT_BRANCH() {
		return T_BRANCH;
	}

	/**
	 * @param t_BRANCH the t_BRANCH to set
	 */
	public void setT_BRANCH(String t_BRANCH) {
		T_BRANCH = t_BRANCH;
	}

	/**
	 * @return the t_DEPARTMENT
	 */
	public String getT_DEPARTMENT() {
		return T_DEPARTMENT;
	}

	/**
	 * @param t_DEPARTMENT the t_DEPARTMENT to set
	 */
	public void setT_DEPARTMENT(String t_DEPARTMENT) {
		T_DEPARTMENT = t_DEPARTMENT;
	}

	@Override
	public String toString() {
		return "service_request_historical_sla [SR_NO=" + SR_NO + ", TICKET_ID=" + TICKET_ID + ", TICKET_STATUS="
				+ TICKET_STATUS + ", HOLD_START_DATE=" + HOLD_START_DATE + ", HOLD_END_DATE=" + HOLD_END_DATE
				+ ", HOLD_ELAPSED_TIME=" + HOLD_ELAPSED_TIME + ", HOLD_DURATION=" + HOLD_DURATION + ", SLA_STATUS="
				+ SLA_STATUS + ", T_COMPANY=" + T_COMPANY + ", T_BRANCH=" + T_BRANCH + ", T_DEPARTMENT=" + T_DEPARTMENT
				+ "]";
	}

}
