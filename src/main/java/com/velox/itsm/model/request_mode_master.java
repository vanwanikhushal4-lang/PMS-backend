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
@Table(name = "REQUEST_MODE_MASTER")
public class request_mode_master implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4128074364583676470L;
	@Id
	@Column
	private int SR_NO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REQUEST_MODE;
	private String COMPANY;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getREQUEST_MODE() {
		return REQUEST_MODE;
	}

	public void setREQUEST_MODE(String rEQUEST_MODE) {
		REQUEST_MODE = rEQUEST_MODE;
	}

	
	public String getCOMPANY() {
		return COMPANY;
	}

	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}

	public request_mode_master() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "request_mode_master [SR_NO=" + SR_NO + ", REQUEST_MODE=" + REQUEST_MODE + ", COMPANY=" + COMPANY + "]";
	}

	
	
}
