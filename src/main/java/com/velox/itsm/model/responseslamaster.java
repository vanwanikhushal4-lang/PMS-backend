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
@Table(name = "responseslamaster")
public class responseslamaster implements Serializable {

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
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String RESPONSE_SLA_CALENDER_WEEK_STATUS;
	

	@Column(columnDefinition = "NVARCHAR(500)")
	private String  RESPONSE_SLA_TARGET_DURATION;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SLA_TARGET_ELAPSED_TIME;
	

	
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


/**
 * @return the rESPONSE_SLA_TARGET_DURATION
 */
public String getRESPONSE_SLA_TARGET_DURATION() {
	return RESPONSE_SLA_TARGET_DURATION;
}

/**
 * @param rESPONSE_SLA_TARGET_DURATION the rESPONSE_SLA_TARGET_DURATION to set
 */
public void setRESPONSE_SLA_TARGET_DURATION(String rESPONSE_SLA_TARGET_DURATION) {
	RESPONSE_SLA_TARGET_DURATION = rESPONSE_SLA_TARGET_DURATION;
}

public String getSLA_TARGET_ELAPSED_TIME() {
	return SLA_TARGET_ELAPSED_TIME;
}


public void setSLA_TARGET_ELAPSED_TIME(String sLA_TARGET_ELAPSED_TIME) {
	SLA_TARGET_ELAPSED_TIME = sLA_TARGET_ELAPSED_TIME;
}

public String getRESPONSE_SLA_CALENDER_WEEK_STATUS() {
	return RESPONSE_SLA_CALENDER_WEEK_STATUS;
}

public void setRESPONSE_SLA_CALENDER_WEEK_STATUS(String rESPONSE_SLA_CALENDER_WEEK_STATUS) {
	RESPONSE_SLA_CALENDER_WEEK_STATUS = rESPONSE_SLA_CALENDER_WEEK_STATUS;
}

@Override
public String toString() {
	return "responseslamaster [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", PRIORITY_NAME=" + PRIORITY_NAME
			+ ", SEVERITY_NAME=" + SEVERITY_NAME + ", DAYS=" + DAYS + ", HOURS=" + HOURS + ", MINUTES=" + MINUTES
			+ ", SECONDS=" + SECONDS + ", RESPONSE_SLA_CALENDER_WEEK_STATUS=" + RESPONSE_SLA_CALENDER_WEEK_STATUS
			+ ", RESPONSE_SLA_TARGET_DURATION=" + RESPONSE_SLA_TARGET_DURATION + ", SLA_TARGET_ELAPSED_TIME="
			+ SLA_TARGET_ELAPSED_TIME + "]";
}


}
