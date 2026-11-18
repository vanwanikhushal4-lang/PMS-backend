package com.velox.itsm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sla_week_scheduler")
public class sla_week_scheduler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2929142448810027779L;
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	@Column(name = "COMPANY_NAME", columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	
	
	@Column(name = "MONDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String MONDAY_START_TIME;
	
	@Column(name = "MONDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String MONDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String MONDAY_ELAPSTIME;
	
	
	@Column(name = "TUESDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String TUESDAY_START_TIME;
	@Column(name = "TUESDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String TUESDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String TUESDAY_ELAPSTIME;
	
	@Column(name = "WEDNESDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String WEDNESDAY_START_TIME;
	@Column(name = "WEDNESDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String WEDNESDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String WEDNESDAY_ELAPSTIME;
	
	@Column(name = "THURSDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String THURSDAY_START_TIME;
	@Column(name = "THURSDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String THURSDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String THURSDAY_ELAPSTIME;
	
	@Column(name = "FRIDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String FRIDAY_START_TIME;
	@Column(name = "FRIDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String FRIDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String FRIDAY_ELAPSTIME;
	
	@Column(name = "SATURDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String SATURDAY_START_TIME;
	@Column(name = "SATURDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String SATURDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String SATURDAY_ELAPSTIME;
	
	@Column(name = "SUNDAY_START_TIME", columnDefinition = "NVARCHAR(50)")
	private String SUNDAY_START_TIME;
	@Column(name = "SUNDAY_END_TIME", columnDefinition = "NVARCHAR(50)")
	private String SUNDAY_END_TIME;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String SUNDAY_ELAPSTIME;
	
	
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
	public String getMONDAY_START_TIME() {
		return MONDAY_START_TIME;
	}
	public void setMONDAY_START_TIME(String mONDAY_START_TIME) {
		MONDAY_START_TIME = mONDAY_START_TIME;
	}
	public String getMONDAY_END_TIME() {
		return MONDAY_END_TIME;
	}
	public void setMONDAY_END_TIME(String mONDAY_END_TIME) {
		MONDAY_END_TIME = mONDAY_END_TIME;
	}
	public String getTUESDAY_START_TIME() {
		return TUESDAY_START_TIME;
	}
	public void setTUESDAY_START_TIME(String tUESDAY_START_TIME) {
		TUESDAY_START_TIME = tUESDAY_START_TIME;
	}
	public String getTUESDAY_END_TIME() {
		return TUESDAY_END_TIME;
	}
	public void setTUESDAY_END_TIME(String tUESDAY_END_TIME) {
		TUESDAY_END_TIME = tUESDAY_END_TIME;
	}
	public String getWEDNESDAY_START_TIME() {
		return WEDNESDAY_START_TIME;
	}
	public void setWEDNESDAY_START_TIME(String wEDNESDAY_START_TIME) {
		WEDNESDAY_START_TIME = wEDNESDAY_START_TIME;
	}
	public String getWEDNESDAY_END_TIME() {
		return WEDNESDAY_END_TIME;
	}
	public void setWEDNESDAY_END_TIME(String wEDNESDAY_END_TIME) {
		WEDNESDAY_END_TIME = wEDNESDAY_END_TIME;
	}
	public String getTHURSDAY_START_TIME() {
		return THURSDAY_START_TIME;
	}
	public void setTHURSDAY_START_TIME(String tHURSDAY_START_TIME) {
		THURSDAY_START_TIME = tHURSDAY_START_TIME;
	}
	public String getTHURSDAY_END_TIME() {
		return THURSDAY_END_TIME;
	}
	public void setTHURSDAY_END_TIME(String tHURSDAY_END_TIME) {
		THURSDAY_END_TIME = tHURSDAY_END_TIME;
	}
	public String getFRIDAY_START_TIME() {
		return FRIDAY_START_TIME;
	}
	public void setFRIDAY_START_TIME(String fRIDAY_START_TIME) {
		FRIDAY_START_TIME = fRIDAY_START_TIME;
	}
	public String getFRIDAY_END_TIME() {
		return FRIDAY_END_TIME;
	}
	public void setFRIDAY_END_TIME(String fRIDAY_END_TIME) {
		FRIDAY_END_TIME = fRIDAY_END_TIME;
	}
	public String getSATURDAY_START_TIME() {
		return SATURDAY_START_TIME;
	}
	public void setSATURDAY_START_TIME(String sATURDAY_START_TIME) {
		SATURDAY_START_TIME = sATURDAY_START_TIME;
	}
	public String getSATURDAY_END_TIME() {
		return SATURDAY_END_TIME;
	}
	public void setSATURDAY_END_TIME(String sATURDAY_END_TIME) {
		SATURDAY_END_TIME = sATURDAY_END_TIME;
	}
	public String getSUNDAY_START_TIME() {
		return SUNDAY_START_TIME;
	}
	public void setSUNDAY_START_TIME(String sUNDAY_START_TIME) {
		SUNDAY_START_TIME = sUNDAY_START_TIME;
	}
	public String getSUNDAY_END_TIME() {
		return SUNDAY_END_TIME;
	}
	public void setSUNDAY_END_TIME(String sUNDAY_END_TIME) {
		SUNDAY_END_TIME = sUNDAY_END_TIME;
	}
	public String getMONDAY_ELAPSTIME() {
		return MONDAY_ELAPSTIME;
	}
	public void setMONDAY_ELAPSTIME(String mONDAY_ELAPSTIME) {
		MONDAY_ELAPSTIME = mONDAY_ELAPSTIME;
	}
	public String getTUESDAY_ELAPSTIME() {
		return TUESDAY_ELAPSTIME;
	}
	public void setTUESDAY_ELAPSTIME(String tUESDAY_ELAPSTIME) {
		TUESDAY_ELAPSTIME = tUESDAY_ELAPSTIME;
	}
	public String getWEDNESDAY_ELAPSTIME() {
		return WEDNESDAY_ELAPSTIME;
	}
	public void setWEDNESDAY_ELAPSTIME(String wEDNESDAY_ELAPSTIME) {
		WEDNESDAY_ELAPSTIME = wEDNESDAY_ELAPSTIME;
	}
	public String getTHURSDAY_ELAPSTIME() {
		return THURSDAY_ELAPSTIME;
	}
	public void setTHURSDAY_ELAPSTIME(String tHURSDAY_ELAPSTIME) {
		THURSDAY_ELAPSTIME = tHURSDAY_ELAPSTIME;
	}
	public String getFRIDAY_ELAPSTIME() {
		return FRIDAY_ELAPSTIME;
	}
	public void setFRIDAY_ELAPSTIME(String fRIDAY_ELAPSTIME) {
		FRIDAY_ELAPSTIME = fRIDAY_ELAPSTIME;
	}
	public String getSATURDAY_ELAPSTIME() {
		return SATURDAY_ELAPSTIME;
	}
	public void setSATURDAY_ELAPSTIME(String sATURDAY_ELAPSTIME) {
		SATURDAY_ELAPSTIME = sATURDAY_ELAPSTIME;
	}
	public String getSUNDAY_ELAPSTIME() {
		return SUNDAY_ELAPSTIME;
	}
	public void setSUNDAY_ELAPSTIME(String sUNDAY_ELAPSTIME) {
		SUNDAY_ELAPSTIME = sUNDAY_ELAPSTIME;
	}
	@Override
	public String toString() {
		return "sla_week_scheduler [SR_NO=" + SR_NO + ", COMPANY_NAME=" + COMPANY_NAME + ", MONDAY_START_TIME="
				+ MONDAY_START_TIME + ", MONDAY_END_TIME=" + MONDAY_END_TIME + ", MONDAY_ELAPSTIME=" + MONDAY_ELAPSTIME
				+ ", TUESDAY_START_TIME=" + TUESDAY_START_TIME + ", TUESDAY_END_TIME=" + TUESDAY_END_TIME
				+ ", TUESDAY_ELAPSTIME=" + TUESDAY_ELAPSTIME + ", WEDNESDAY_START_TIME=" + WEDNESDAY_START_TIME
				+ ", WEDNESDAY_END_TIME=" + WEDNESDAY_END_TIME + ", WEDNESDAY_ELAPSTIME=" + WEDNESDAY_ELAPSTIME
				+ ", THURSDAY_START_TIME=" + THURSDAY_START_TIME + ", THURSDAY_END_TIME=" + THURSDAY_END_TIME
				+ ", THURSDAY_ELAPSTIME=" + THURSDAY_ELAPSTIME + ", FRIDAY_START_TIME=" + FRIDAY_START_TIME
				+ ", FRIDAY_END_TIME=" + FRIDAY_END_TIME + ", FRIDAY_ELAPSTIME=" + FRIDAY_ELAPSTIME
				+ ", SATURDAY_START_TIME=" + SATURDAY_START_TIME + ", SATURDAY_END_TIME=" + SATURDAY_END_TIME
				+ ", SATURDAY_ELAPSTIME=" + SATURDAY_ELAPSTIME + ", SUNDAY_START_TIME=" + SUNDAY_START_TIME
				+ ", SUNDAY_END_TIME=" + SUNDAY_END_TIME + ", SUNDAY_ELAPSTIME=" + SUNDAY_ELAPSTIME + "]";
	}

	
	
	
	
}
