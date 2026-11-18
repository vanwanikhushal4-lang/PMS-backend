package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_request_sla_master")
public class service_request_sla_master implements Serializable {
	
	
	public String getSERVICE_SLA_CALENDER_WEEK_STATUS() {
		return SERVICE_SLA_CALENDER_WEEK_STATUS;
	}

	public void setSERVICE_SLA_CALENDER_WEEK_STATUS(String sERVICE_SLA_CALENDER_WEEK_STATUS) {
		SERVICE_SLA_CALENDER_WEEK_STATUS = sERVICE_SLA_CALENDER_WEEK_STATUS;
	}

	private static final long serialVersionUID = -167470686563835291L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVICE_SLA_CALENDER_WEEK_STATUS;
	@Column
	private int DAYS;
	@Column
	private int HOURS;
	@Column
	private int MINUTES;
	@Column
	private int SECONDS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String  SERVICE_REQUEST_TARGET_TIME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SERVICE_REQUEST_TARGET_ELAPSED_TIME;
	
	private  String HOLDTIME_STATUS;

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

	
	public int getDAYS() {
		return DAYS;
	}

	public void setDAYS(int dAYS) {
		DAYS = dAYS;
	}

	public int getHOURS() {
		return HOURS;
	}

	public void setHOURS(int hOURS) {
		HOURS = hOURS;
	}

	
	public int getMINUTES() {
		return MINUTES;
	}

	
	public void setMINUTES(int mINUTES) {
		MINUTES = mINUTES;
	}

	public int getSECONDS() {
		return SECONDS;
	}

	
	public void setSECONDS(int sECONDS) {
		SECONDS = sECONDS;
	}

	
	public String getHOLDTIME_STATUS() {
		return HOLDTIME_STATUS;
	}

	public void setHOLDTIME_STATUS(String hOLDTIME_STATUS) {
		HOLDTIME_STATUS = hOLDTIME_STATUS;
	}

	
	public String getSERVICE_REQUEST_TARGET_TIME() {
		return SERVICE_REQUEST_TARGET_TIME;
	}

	
	public void setSERVICE_REQUEST_TARGET_TIME(String sERVICE_REQUEST_TARGET_TIME) {
		SERVICE_REQUEST_TARGET_TIME = sERVICE_REQUEST_TARGET_TIME;
	}


	public String getSERVICE_REQUEST_TARGET_ELAPSED_TIME() {
		return SERVICE_REQUEST_TARGET_ELAPSED_TIME;
	}

	
	public void setSERVICE_REQUEST_TARGET_ELAPSED_TIME(String sERVICE_REQUEST_TARGET_ELAPSED_TIME) {
		SERVICE_REQUEST_TARGET_ELAPSED_TIME = sERVICE_REQUEST_TARGET_ELAPSED_TIME;
	}

	@Override
	public String toString() {
		return "service_request_sla_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", PRIORITY_NAME="
				+ PRIORITY_NAME + ", SEVERITY_NAME=" + SEVERITY_NAME + ", SERVICE_SLA_CALENDER_WEEK_STATUS="
				+ SERVICE_SLA_CALENDER_WEEK_STATUS + ", DAYS=" + DAYS + ", HOURS=" + HOURS + ", MINUTES=" + MINUTES
				+ ", SECONDS=" + SECONDS + ", SERVICE_REQUEST_TARGET_TIME=" + SERVICE_REQUEST_TARGET_TIME
				+ ", SERVICE_REQUEST_TARGET_ELAPSED_TIME=" + SERVICE_REQUEST_TARGET_ELAPSED_TIME + ", HOLDTIME_STATUS="
				+ HOLDTIME_STATUS + "]";
	}
}
