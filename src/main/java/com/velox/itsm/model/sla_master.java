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
@Table(name = "SLA_MASTER")
public class sla_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8931334366961679800L;
	@Id
  @Column
  private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY_NAME;
	@Column
	private int DAYS;
	@Column
	private int HOURS;
	@Column
	private int MINUTES;
	@Column
	private int SECONDS;
	@Column
	private  String HOLDTIME_STATUS;
	@Column
	private  String CALENDER_OR_WEEK_STATUS;
	@Column
	private String SLA_TARGET_ELAPSED_TIME;
	@Column
	private String SLA_TARGET_DURATION;

	public String getPRIORITY_NAME() {
		return PRIORITY_NAME;
	}

	public void setPRIORITY_NAME(String pRIORITY_NAME) {
		PRIORITY_NAME = pRIORITY_NAME;
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

	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public String getSEVERITY_NAME() {
		return SEVERITY_NAME;
	}

	public void setSEVERITY_NAME(String sEVERITY_NAME) {
		SEVERITY_NAME = sEVERITY_NAME;
	}

	public int getSR_NO() {
    return SR_NO;
  }

  public void setSR_NO(int sR_NO) {
    SR_NO = sR_NO;
  }
  
  

  public String getCALENDER_OR_WEEK_STATUS() {
	return CALENDER_OR_WEEK_STATUS;
}

public void setCALENDER_OR_WEEK_STATUS(String cALENDER_OR_WEEK_STATUS) {
	CALENDER_OR_WEEK_STATUS = cALENDER_OR_WEEK_STATUS;
}

public sla_master() {
		super();
		// TODO Auto-generated constructor stub
	}

public String getHOLDTIME_STATUS() {
	return HOLDTIME_STATUS;
}

public void setHOLDTIME_STATUS(String hOLDTIME_STATUS) {
	HOLDTIME_STATUS = hOLDTIME_STATUS;
}



public String getSLA_TARGET_ELAPSED_TIME() {
	return SLA_TARGET_ELAPSED_TIME;
}

public void setSLA_TARGET_ELAPSED_TIME(String sLA_TARGET_ELAPSED_TIME) {
	SLA_TARGET_ELAPSED_TIME = sLA_TARGET_ELAPSED_TIME;
}

public String getSLA_TARGET_DURATION() {
	return SLA_TARGET_DURATION;
}

public void setSLA_TARGET_DURATION(String sLA_TARGET_DURATION) {
	SLA_TARGET_DURATION = sLA_TARGET_DURATION;
}

@Override
public String toString() {
	return "sla_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", PRIORITY_NAME=" + PRIORITY_NAME
			+ ", SEVERITY_NAME=" + SEVERITY_NAME + ", DAYS=" + DAYS + ", HOURS=" + HOURS + ", MINUTES=" + MINUTES
			+ ", SECONDS=" + SECONDS + ", HOLDTIME_STATUS=" + HOLDTIME_STATUS + ", SLA_TARGET_ELAPSED_TIME="
			+ SLA_TARGET_ELAPSED_TIME + ", SLA_TARGET_DURATION=" + SLA_TARGET_DURATION + "]";
}




}
