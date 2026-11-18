package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOFTWARE")
public class SOFTWARE  implements Serializable{

	private static final long serialVersionUID = -6548165025024405651L;
	@Id
	@Column
	private int SRNO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String S_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private Float S_COST;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String S_PERIOD;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FROM_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ACTIVE_CONDITION;
	
	
	
	
	
	public String getFROM_DATE() {
		return FROM_DATE;
	}
	public void setFROM_DATE(String fROM_DATE) {
		FROM_DATE = fROM_DATE;
	}
	public String getACTIVE_CONDITION() {
		return ACTIVE_CONDITION;
	}
	public void setACTIVE_CONDITION(String aCTIVE_CONDITION) {
		ACTIVE_CONDITION = aCTIVE_CONDITION;
	}
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	
	public String getS_PERIOD() {
		return S_PERIOD;
	}
	public void setS_PERIOD(String s_PERIOD) {
		S_PERIOD = s_PERIOD;
	}
	public Float getS_COST() {
		return S_COST;
	}
	public void setS_COST(Float s_COST) {
		S_COST = s_COST;
	}
	@Override
	public String toString() {
		return "SOFTWARE [SRNO=" + SRNO + ", S_NAME=" + S_NAME + ", S_COST=" + S_COST + ", S_PERIOD=" + S_PERIOD
				+ ", FROM_DATE=" + FROM_DATE + ", ACTIVE_CONDITION=" + ACTIVE_CONDITION + "]";
	}
	
	
}
