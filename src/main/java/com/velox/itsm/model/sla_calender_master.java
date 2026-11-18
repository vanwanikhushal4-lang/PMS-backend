package com.velox.itsm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sla_calender_master")
public class sla_calender_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3874703333288861201L;
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	@Column(name = "C_NAME", columnDefinition = "NVARCHAR(500)")
	private String C_NAME;
	@Column(name = "C_DESCRIPTION", columnDefinition = "NVARCHAR(500)")
	private String C_DESCRIPTION;
	@Column(name = "C_DATE", columnDefinition = "NVARCHAR(500)")
	private String C_DATE;
	@Column(name = "COMPANY_NAME", columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getC_NAME() {
		return C_NAME;
	}
	public void setC_NAME(String c_NAME) {
		C_NAME = c_NAME;
	}
	public String getC_DESCRIPTION() {
		return C_DESCRIPTION;
	}
	public void setC_DESCRIPTION(String c_DESCRIPTION) {
		C_DESCRIPTION = c_DESCRIPTION;
	}
	public String getC_DATE() {
		return C_DATE;
	}
	public void setC_DATE(String c_DATE) {
		C_DATE = c_DATE;
	}
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}
	
	@Override
	public String toString() {
		return "sla_calender_master [SR_NO=" + SR_NO + ", C_NAME=" + C_NAME + ", C_DESCRIPTION=" + C_DESCRIPTION
				+ ", C_DATE=" + C_DATE + ", COMPANY_NAME=" + COMPANY_NAME + "]";
	}
	
	
	
	
}
