package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DaywiseTask {

	private static final long serialVersionUID = 4L;

	@Id
	@Column
	private int SR_NO;	
	
	private String FUNCTION_NAME;
	private String MODULE_NAME;
	private String RESPONSIBILITY;
	private String MANAGER_NAME;
	private String TEAM_LEADER;
	private String DEVELOPER_NAME;
	private String START_DATE;
	private String END_DATE;
	private String REMARK;
	private String STATUS;
	private String PRIORITY;
	private String SUB_MODULE_NAME;
	private String WEIGHTAGE="0";
	private String TESTER_NAME;
	private String ASSIGNBY;
	private String Assign_date;
	private String Assign_time;
	private String TaskUpdateDate;
	private String Task_ID;
	private String updateDateCount;
	private String updateTimeDate;
	
	//17/10
	private String updateStarts_Date;
	private String updateDates_Reason;
	
	
	public String getAssign_time() {
		return Assign_time;
	}
	public void setAssign_time(String assign_time) {
		Assign_time = assign_time;
	}
	//17/10
	public String getUpdateDates_Reason() {
		return updateDates_Reason;
	}
	public void setUpdateDates_Reason(String updateDates_Reason) {
		this.updateDates_Reason = updateDates_Reason;
	}
	//17/10
	public String getUpdateStarts_Date() {
		return updateStarts_Date;
	}
	public void setUpdateStarts_Date(String updateStarts_Date) {
		this.updateStarts_Date = updateStarts_Date;
	}
	//

	private String updateEnd_Date;
	private String updateDate_Status;
	private String dateUpdateBy;
	
	
	
	
	//12/11
	private String ONE_TIME;
	
	
	
	
	public String getONE_TIME() {
		return ONE_TIME;
	}
	public void setONE_TIME(String oNE_TIME) {
		ONE_TIME = oNE_TIME;
	}
	public String getDateUpdateBy() {
		return dateUpdateBy;
	}
	public void setDateUpdateBy(String dateUpdateBy) {
		this.dateUpdateBy = dateUpdateBy;
	}
	public String getUpdateDate_Status() {
		return updateDate_Status;
	}
	public void setUpdateDate_Status(String updateDate_Status) {
		this.updateDate_Status = updateDate_Status;
	}
	public String getUpdateTimeDate() {
		return updateTimeDate;
	}
	public void setUpdateTimeDate(String updateTimeDate) {
		this.updateTimeDate = updateTimeDate;
	}
	public String getUpdateEnd_Date() {
		return updateEnd_Date;
	}
	public void setUpdateEnd_Date(String updateEnd_Date) {
		this.updateEnd_Date = updateEnd_Date;
	}
	public String getUpdateDateCount() {
		return updateDateCount;
	}
	public void setUpdateDateCount(String updateDateCount) {
		this.updateDateCount = updateDateCount;
	}
	public String getTask_ID() {
		return Task_ID;
	}
	public void setTask_ID(String task_ID) {
		Task_ID = task_ID;
	}
	public String getTaskUpdateDate() {
		return TaskUpdateDate;
	}
	public void setTaskUpdateDate(String taskUpdateDate) {
		TaskUpdateDate = taskUpdateDate;
	}
	public String getAssign_date() {
		return Assign_date;
	}
	public void setAssign_date(String assign_date) {
		Assign_date = assign_date;
	}
	public String getASSIGNBY() {
		return ASSIGNBY;
	}
	public void setASSIGNBY(String aSSIGNBY) {
		ASSIGNBY = aSSIGNBY;
	}
	
	public String getSUB_MODULE_NAME() {
		return SUB_MODULE_NAME;
	}
	public void setSUB_MODULE_NAME(String sUB_MODULE_NAME) {
		SUB_MODULE_NAME = sUB_MODULE_NAME;
	}
	public String getWEIGHTAGE() {
		return WEIGHTAGE;
	}
	public void setWEIGHTAGE(String wEIGHTAGE) {
		WEIGHTAGE = wEIGHTAGE;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}

	private String PRODUCTSUIT;
	private String PRODUCTTOOL;
	private String CUSTOMERNAME;
	public String getCUSTOMERNAME() {
		return CUSTOMERNAME;
	}
	public void setCUSTOMERNAME(String cUSTOMERNAME) {
		CUSTOMERNAME = cUSTOMERNAME;
	}

	private String DESCRIPTION;
	
	public String getPRODUCTSUIT() {
		return PRODUCTSUIT;
	}
	public void setPRODUCTSUIT(String pRODUCTSUIT) {
		PRODUCTSUIT = pRODUCTSUIT;
	}
	public String getPRODUCTTOOL() {
		return PRODUCTTOOL;
	}
	public void setPRODUCTTOOL(String pRODUCTTOOL) {
		PRODUCTTOOL = pRODUCTTOOL;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
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
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getTESTER_NAME() {
		return TESTER_NAME;
	}
	public void setTESTER_NAME(String tESTER_NAME) {
		TESTER_NAME = tESTER_NAME;
	}
	
	
	@Override
	public String toString() {
		return "DaywiseTask [SR_NO=" + SR_NO + ", FUNCTION_NAME=" + FUNCTION_NAME + ", MODULE_NAME=" + MODULE_NAME
				+ ", RESPONSIBILITY=" + RESPONSIBILITY + ", MANAGER_NAME=" + MANAGER_NAME + ", TEAM_LEADER="
				+ TEAM_LEADER + ", DEVELOPER_NAME=" + DEVELOPER_NAME + ", START_DATE=" + START_DATE + ", END_DATE="
				+ END_DATE + ", REMARK=" + REMARK + ", STATUS=" + STATUS + ", PRIORITY=" + PRIORITY
				+ ", SUB_MODULE_NAME=" + SUB_MODULE_NAME + ", WEIGHTAGE=" + WEIGHTAGE + ", TESTER_NAME=" + TESTER_NAME
				+ ", ASSIGNBY=" + ASSIGNBY + ", Assign_date=" + Assign_date + ", Assign_time=" + Assign_time
				+ ", TaskUpdateDate=" + TaskUpdateDate + ", Task_ID=" + Task_ID + ", updateDateCount=" + updateDateCount
				+ ", updateTimeDate=" + updateTimeDate + ", updateStarts_Date=" + updateStarts_Date
				+ ", updateDates_Reason=" + updateDates_Reason + ", updateEnd_Date=" + updateEnd_Date
				+ ", updateDate_Status=" + updateDate_Status + ", dateUpdateBy=" + dateUpdateBy + ", ONE_TIME="
				+ ONE_TIME + ", PRODUCTSUIT=" + PRODUCTSUIT + ", PRODUCTTOOL=" + PRODUCTTOOL + ", CUSTOMERNAME="
				+ CUSTOMERNAME + ", DESCRIPTION=" + DESCRIPTION + "]";
	}


	
	
	
	
	
	
	
	

	
	
	
}
