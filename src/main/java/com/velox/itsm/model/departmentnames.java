package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTMASTER")
public class departmentnames implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;

	@Column(name = "DEPARTMENT", columnDefinition = "NVARCHAR(500)")
	private String DEPARTMENT;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	@Override
	public String toString() {
		return "deptartmentnames [SR_NO=" + SR_NO + ", DEPARTMENT=" + DEPARTMENT + "]";
	}

	public departmentnames() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
