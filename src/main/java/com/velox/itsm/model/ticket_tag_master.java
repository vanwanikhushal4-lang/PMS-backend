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
@Table(name = "ticket_tag_master")
public class ticket_tag_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829613674372392374L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TICKET_TAG;
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
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getTICKET_TAG() {
		return TICKET_TAG;
	}
	public void setTICKET_TAG(String tICKET_TAG) {
		TICKET_TAG = tICKET_TAG;
	}
	@Override
	public String toString() {
		return "ticket_tag_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", DEPARTMENT=" + DEPARTMENT
				+ ", TICKET_TAG=" + TICKET_TAG + "]";
	}
	
	
	
	
}
