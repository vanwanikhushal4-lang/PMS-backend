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
@Table(name="HOLD_TIME")
public class hold_time implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 815462632540523577L;
	@Id
//	@Column
//	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String HOLD_STATUS;
	public String getHOLD_STATUS() {
		return HOLD_STATUS;
	}
	public void setHOLD_STATUS(String hOLD_STATUS) {
		HOLD_STATUS = hOLD_STATUS;
	}
	@Override
	public String toString() {
		return "hold_time [HOLD_STATUS=" + HOLD_STATUS + "]";
	}
	public hold_time() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
