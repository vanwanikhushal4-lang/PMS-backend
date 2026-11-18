package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ADD_MAIL_TEMPLATE" )
public class ADD_MAIL_TEMPLATE  implements Serializable{
	
	private static final long serialVersionUID = 4L;
	
	@Id
	@Column
	private int SR_NO;

	@Column(columnDefinition = "NVARCHAR(500)")
	private String STATUS;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBJECT;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MAILBODY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL_TRIGGER;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_TYPE;
	@Column(columnDefinition = "TEXT")
	private String MAIL_FOOTER;
	
	
	
	public String getMAIL_FOOTER() {
		return MAIL_FOOTER;
	}


	public void setMAIL_FOOTER(String mAIL_FOOTER) {
		MAIL_FOOTER = mAIL_FOOTER;
	}


	public String getCOMPANY() {
		return COMPANY;
	}


	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}


	public String getEMAIL_TRIGGER() {
		return EMAIL_TRIGGER;
	}


	public void setEMAIL_TRIGGER(String eMAIL_TRIGGER) {
		EMAIL_TRIGGER = eMAIL_TRIGGER;
	}


	public int getSR_NO() {
		return SR_NO;
	}


	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}


	public String getSTATUS() {
		return STATUS;
	}


	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}


	public String getSUBJECT() {
		return SUBJECT;
	}


	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}


	public String getMAILBODY() {
		return MAILBODY;
	}


	public void setMAILBODY(String mAILBODY) {
		MAILBODY = mAILBODY;
	}


	public String getTICKET_TYPE() {
		return TICKET_TYPE;
	}


	public void setTICKET_TYPE(String tICKET_TYPE) {
		TICKET_TYPE = tICKET_TYPE;
	}


	@Override
	public String toString() {
		return "ADD_MAIL_TEMPLATE [SR_NO=" + SR_NO + ", STATUS=" + STATUS + ", SUBJECT=" + SUBJECT + ", MAILBODY="
				+ MAILBODY + ", COMPANY=" + COMPANY + ", EMAIL_TRIGGER=" + EMAIL_TRIGGER + ", TICKET_TYPE="
				+ TICKET_TYPE + ", MAIL_FOOTER=" + MAIL_FOOTER + "]";
	}


}
