package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class AD_SYNC_LOG implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	private int SRNO;
	private String ACTIVITY_START_DATE_TIME;
	private String ACTIVITY_END_DATE_TIME;
	private String USER_COUNT;
	private String STATUS;
	private String COMPANY;
	
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	public String getACTIVITY_START_DATE_TIME() {
		return ACTIVITY_START_DATE_TIME;
	}
	public void setACTIVITY_START_DATE_TIME(String aCTIVITY_START_DATE_TIME) {
		ACTIVITY_START_DATE_TIME = aCTIVITY_START_DATE_TIME;
	}
	public String getACTIVITY_END_DATE_TIME() {
		return ACTIVITY_END_DATE_TIME;
	}
	public void setACTIVITY_END_DATE_TIME(String aCTIVITY_END_DATE_TIME) {
		ACTIVITY_END_DATE_TIME = aCTIVITY_END_DATE_TIME;
	}
	public String getUSER_COUNT() {
		return USER_COUNT;
	}
	public void setUSER_COUNT(String uSER_COUNT) {
		USER_COUNT = uSER_COUNT;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	@Override
	public String toString() {
		return "AD_SYNC_LOG [SRNO=" + SRNO + ", ACTIVITY_START_DATE_TIME=" + ACTIVITY_START_DATE_TIME
				+ ", ACTIVITY_END_DATE_TIME=" + ACTIVITY_END_DATE_TIME + ", USER_COUNT=" + USER_COUNT + ", STATUS="
				+ STATUS + ", COMPANY=" + COMPANY + "]";
	}

	
	
	
	
	
	
	
	
	
	
}
