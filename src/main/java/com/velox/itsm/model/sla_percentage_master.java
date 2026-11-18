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
@Table(name = "sla_percentage_master")
public class sla_percentage_master implements Serializable {
	
	@Id
	@Column
	private int SR_NO;
	@Column(name="COMPANY",columnDefinition="NVARCHAR(500)")
	private String COMPANY;
	@Column(name="SLA_PERCENTAGE",columnDefinition="NVARCHAR(500)")
	private String SLA_PERCENTAGE;
	
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

	public String getSLA_PERCENTAGE() {
		return SLA_PERCENTAGE;
	}

	public void setSLA_PERCENTAGE(String sLA_PERCENTAGE) {
		SLA_PERCENTAGE = sLA_PERCENTAGE;
	}

	@Override
	public String toString() {
		return "sla_template_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", SLA_PERCENTAGE=" + SLA_PERCENTAGE
				+ "]";
	}
	
	
}
