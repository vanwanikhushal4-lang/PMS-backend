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
@Table(name="AUTO_CLOSE_DETAILS" )
public class auto_close_details implements Serializable  {

	public auto_close_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 7298274074230394757L;
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	@Override
	public String toString() {
		return "auto_close_details [SR_NO=" + SR_NO + ", TICKET_STATUS=" + TICKET_STATUS + ", TIME_FORMAT="
				+ TIME_FORMAT + ", CLOSED_TIME=" + CLOSED_TIME + ", CLOSED_REASON=" + CLOSED_REASON + ", TOTAL_SEC="
				+ TOTAL_SEC + "]";
	}
	
	@Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	
  @Column(name = "TICKET_STATUS", columnDefinition = "NVARCHAR(500)")
	private String TICKET_STATUS;
	
	@Column(name = "TIME_FORMAT", columnDefinition = "NVARCHAR(500)")
	private String TIME_FORMAT;
	
	@Column(name = "CLOSED_TIME", columnDefinition = "NVARCHAR(500)")
	private String CLOSED_TIME;
	
	@Column(name = "CLOSED_REASON", columnDefinition = "NVARCHAR(500)")
	private String CLOSED_REASON;
	
	@Column(name = "TOTAL_SEC", columnDefinition = "NVARCHAR(500)")
	private String TOTAL_SEC;
	
	public String getCLOSED_REASON() {
		return CLOSED_REASON;
	}
	public void setCLOSED_REASON(String cLOSED_REASON) {
		CLOSED_REASON = cLOSED_REASON;
	}
	public String getTOTAL_SEC() {
		return TOTAL_SEC;
	}
	public void setTOTAL_SEC(String tOTAL_SEC) {
		TOTAL_SEC = tOTAL_SEC;
	}
	
	
	
	
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
	public String getTICKET_STATUS() {
		return TICKET_STATUS;
	}
	public void setTICKET_STATUS(String tICKET_STATUS) {
		TICKET_STATUS = tICKET_STATUS;
	}
	public String getTIME_FORMAT() {
		return TIME_FORMAT;
	}
	public void setTIME_FORMAT(String tIME_FORMAT) {
		TIME_FORMAT = tIME_FORMAT;
	}
	public String getCLOSED_TIME() {
		return CLOSED_TIME;
	}
	public void setCLOSED_TIME(String cLOSED_TIME) {
		CLOSED_TIME = cLOSED_TIME;
	}
	
	
	
	
	
	
}
