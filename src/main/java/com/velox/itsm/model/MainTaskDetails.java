package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MainTaskDetails {

	private static final long serialVersionUID = 4L;

	@Id
	@Column
	private int SR_NO;
	
	private String T_NO;
	private String FUNCTION_NAME;
	private String MODULE_NAME;
	private String RESPONSIBILITY;
	private String MANAGER_NAME;
	private String TEAM_LEADER;
	private String DEVELOPER_NAME;
	private String START_DATE;
	private String END_DATE;
	private String REMARK;
	private String DESCRIPTION;
	private String STATUS;
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	
	public String getT_NO() {
		return T_NO;
	}
	public void setT_NO(String t_NO) {
		T_NO = t_NO;
	}
	public String getFUNCTION_NAME() {
		return FUNCTION_NAME;
	}
	public void setFUNCTION_NAME(String fUNCTION_NAME) {
		FUNCTION_NAME = fUNCTION_NAME;
	}
	public String getMODULE_NAME() {
		return MODULE_NAME;
	}
	public void setMODULE_NAME(String mODULE_NAME) {
		MODULE_NAME = mODULE_NAME;
	}
	public String getRESPONSIBILITY() {
		return RESPONSIBILITY;
	}
	public void setRESPONSIBILITY(String rESPONSIBILITY) {
		RESPONSIBILITY = rESPONSIBILITY;
	}
	public String getMANAGER_NAME() {
		return MANAGER_NAME;
	}
	public void setMANAGER_NAME(String mANAGER_NAME) {
		MANAGER_NAME = mANAGER_NAME;
	}
	public String getTEAM_LEADER() {
		return TEAM_LEADER;
	}
	public void setTEAM_LEADER(String tEAM_LEADER) {
		TEAM_LEADER = tEAM_LEADER;
	}
	public String getDEVELOPER_NAME() {
		return DEVELOPER_NAME;
	}
	public void setDEVELOPER_NAME(String dEVELOPER_NAME) {
		DEVELOPER_NAME = dEVELOPER_NAME;
	}
	public String getSTART_DATE() {
		return START_DATE;
	}
	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}
	public String getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	@Override
	public String toString() {
		return "MainTaskDetails [SR_NO=" + SR_NO + ", T_NO=" + T_NO + ", FUNCTION_NAME=" + FUNCTION_NAME
				+ ", MODULE_NAME=" + MODULE_NAME + ", RESPONSIBILITY=" + RESPONSIBILITY + ", MANAGER_NAME="
				+ MANAGER_NAME + ", TEAM_LEADER=" + TEAM_LEADER + ", DEVELOPER_NAME=" + DEVELOPER_NAME + ", START_DATE="
				+ START_DATE + ", END_DATE=" + END_DATE + ", REMARK=" + REMARK + ", DESCRIPTION=" + DESCRIPTION
				+ ", STATUS=" + STATUS + "]";
	}
	
	
	
}
