package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTO_ASSIGN_TICKET" )
public class AUTO_ASSIGN_TICKET implements Serializable  {

	private static final long serialVersionUID = 4L;
	
	@Id
	@Column
	private int SR_NO;
	
	@Column(columnDefinition= "NVARCHAR(500)")
	private String COMPANY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	
	public String getAssign_To() {
		return Assign_To;
	}

	public void setAssign_To(String assign_To) {
		Assign_To = assign_To;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String CATEGORY;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String Assign_To;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String Group_Name;
	
	public String getGroup_Name() {
		return Group_Name;
	}

	public void setGroup_Name(String group_Name) {
		Group_Name = group_Name;
	}

	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSIGN_TIME;

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

	public String getPRIORITY() {
		return PRIORITY;
	}

	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}

	public String getSEVERITY() {
		return SEVERITY;
	}

	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getASSIGN_TIME() {
		return ASSIGN_TIME;
	}

	public void setASSIGN_TIME(String aSSIGN_TIME) {
		ASSIGN_TIME = aSSIGN_TIME;
	}

	@Override
	public String toString() {
		return "AUTO_ASSIGN_TICKET [SR_NO=" + SR_NO + ", COMPANY=" + COMPANY + ", PRIORITY=" + PRIORITY + ", SEVERITY="
				+ SEVERITY + ", CATEGORY=" + CATEGORY + ", Assign_To=" + Assign_To + ", Group_Name=" + Group_Name
				+ ", ASSIGN_TIME=" + ASSIGN_TIME + "]";
	}

	


}
