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
@Table(name = "PRIORITYMASTER")
public class prioritymaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column
	private int SR_NO;
	
	@Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getPRIORITY() {
		return PRIORITY;
	}

	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	
	public String getCOMPANY() {
		return COMPANY;
	}
	
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	
	@Override
	public String toString() {
		return "prioritymaster [SR_NO=" + SR_NO + ", PRIORITY=" + PRIORITY + "]";
	}

	public prioritymaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
