package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Group_master")
public class Group_master2 implements Serializable {
	private static final long serialVersionUID = 3384274096268836681L;

	@Id
	private int SR_NO;
	
	@Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(name = "GROUP_NAME", columnDefinition = "NVARCHAR(500)")
	private String GROUP_NAME;
	
	
	
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



	public String getGROUP_NAME() {
		return GROUP_NAME;
	}


	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}



	@Override
	public String toString() {
		return "Group_master [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", GROUP_NAME=" + GROUP_NAME + "]";
	}

}
