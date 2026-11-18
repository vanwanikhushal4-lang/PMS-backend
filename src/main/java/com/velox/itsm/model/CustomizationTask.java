package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class CustomizationTask {


		private static final long serialVersionUID = 4L;

		@Id
		@Column
		private int SR_NO;	
		
		private String PRODUCTSUIT;
		private String PRODUCTTOOL;
		private String CUSTOMERNAME;
		private String MODULE_NAME;
		private String MANAGER_NAME;
		private String TEAM_LEADER;
		private String DEVELOPER_NAME;
		private String SUPPORT_MANAGER_NAME;	
		private String SUPPORT_TEAM_LEADER;
		private String END_DATE;
		private String REMARK;
		private String PRIORITY;
		private String DESCRIPTION;
		private String EXPECTED_OUTPUT;
		private String STATUS;
		private String ASSIGNBY;
		private String SUBMITTED_DATE;
		private String DEV_ASSIGNED_DATE;
		private String TL_ASSIGNED_DATE;
		private String DEVELOPED_DATE;
		private String TESTED_DATE;
		private String TASK_CLOSE_DATE;
		private String TASK_REOPEN_DATE;
		private String TESTER_NAME;
		private String TESTER_DESCRIPTION;
		private String TESTED_FAILED_COUNT;
		private String READY_TO_DELIVER_DATE;
		private String PATCH_URL;
		private String PREV_TESTER;
		private String ASSIGNED_DATE;
		private String TASKID;
		private String REOPEN_REASON;
		
		public int getSR_NO() {
			return SR_NO;
		}
		public void setSR_NO(int sR_NO) {
			SR_NO = sR_NO;
		}
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
		public String getCUSTOMERNAME() {
			return CUSTOMERNAME;
		}
		public void setCUSTOMERNAME(String cUSTOMERNAME) {
			CUSTOMERNAME = cUSTOMERNAME;
		}
		public String getMODULE_NAME() {
			return MODULE_NAME;
		}
		public void setMODULE_NAME(String mODULE_NAME) {
			MODULE_NAME = mODULE_NAME;
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
		public String getSUPPORT_MANAGER_NAME() {
			return SUPPORT_MANAGER_NAME;
		}
		public void setSUPPORT_MANAGER_NAME(String sUPPORT_MANAGER_NAME) {
			SUPPORT_MANAGER_NAME = sUPPORT_MANAGER_NAME;
		}
		public String getSUPPORT_TEAM_LEADER() {
			return SUPPORT_TEAM_LEADER;
		}
		public void setSUPPORT_TEAM_LEADER(String sUPPORT_TEAM_LEADER) {
			SUPPORT_TEAM_LEADER = sUPPORT_TEAM_LEADER;
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
		public String getPRIORITY() {
			return PRIORITY;
		}
		public void setPRIORITY(String pRIORITY) {
			PRIORITY = pRIORITY;
		}
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
		}
		public String getEXPECTED_OUTPUT() {
			return EXPECTED_OUTPUT;
		}
		public void setEXPECTED_OUTPUT(String eXPECTED_OUTPUT) {
			EXPECTED_OUTPUT = eXPECTED_OUTPUT;
		}
		public String getSTATUS() {
			return STATUS;
		}
		public void setSTATUS(String sTATUS) {
			STATUS = sTATUS;
		}
		public String getASSIGNBY() {
			return ASSIGNBY;
		}
		public void setASSIGNBY(String aSSIGNBY) {
			ASSIGNBY = aSSIGNBY;
		}
		public String getSUBMITTED_DATE() {
			return SUBMITTED_DATE;
		}
		public void setSUBMITTED_DATE(String sUBMITTED_DATE) {
			SUBMITTED_DATE = sUBMITTED_DATE;
		}
		public String getDEV_ASSIGNED_DATE() {
			return DEV_ASSIGNED_DATE;
		}
		public void setDEV_ASSIGNED_DATE(String dEV_ASSIGNED_DATE) {
			DEV_ASSIGNED_DATE = dEV_ASSIGNED_DATE;
		}
		public String getTL_ASSIGNED_DATE() {
			return TL_ASSIGNED_DATE;
		}
		public void setTL_ASSIGNED_DATE(String tL_ASSIGNED_DATE) {
			TL_ASSIGNED_DATE = tL_ASSIGNED_DATE;
		}
		public String getDEVELOPED_DATE() {
			return DEVELOPED_DATE;
		}
		public void setDEVELOPED_DATE(String dEVELOPED_DATE) {
			DEVELOPED_DATE = dEVELOPED_DATE;
		}
		public String getTESTED_DATE() {
			return TESTED_DATE;
		}
		public void setTESTED_DATE(String tESTED_DATE) {
			TESTED_DATE = tESTED_DATE;
		}
		public String getTASK_CLOSE_DATE() {
			return TASK_CLOSE_DATE;
		}
		public void setTASK_CLOSE_DATE(String tASK_CLOSE_DATE) {
			TASK_CLOSE_DATE = tASK_CLOSE_DATE;
		}
		public String getTASK_REOPEN_DATE() {
			return TASK_REOPEN_DATE;
		}
		public void setTASK_REOPEN_DATE(String tASK_REOPEN_DATE) {
			TASK_REOPEN_DATE = tASK_REOPEN_DATE;
		}
		public String getTESTER_NAME() {
			return TESTER_NAME;
		}
		public void setTESTER_NAME(String tESTER_NAME) {
			TESTER_NAME = tESTER_NAME;
		}
		
		public String getTESTER_DESCRIPTION() {
			return TESTER_DESCRIPTION;
		}
		public void setTESTER_DESCRIPTION(String tESTER_DESCRIPTION) {
			TESTER_DESCRIPTION = tESTER_DESCRIPTION;
		}
		
		public String getTESTED_FAILED_COUNT() {
			return TESTED_FAILED_COUNT;
		}
		public void setTESTED_FAILED_COUNT(String tESTED_FAILED_COUNT) {
			TESTED_FAILED_COUNT = tESTED_FAILED_COUNT;
		}
		
		public String getREADY_TO_DELIVER_DATE() {
			return READY_TO_DELIVER_DATE;
		}
		public void setREADY_TO_DELIVER_DATE(String rEADY_TO_DELIVER_DATE) {
			READY_TO_DELIVER_DATE = rEADY_TO_DELIVER_DATE;
		}
		
		public String getPATCH_URL() {
			return PATCH_URL;
		}
		public void setPATCH_URL(String pATCH_URL) {
			PATCH_URL = pATCH_URL;
		}
		
		public String getPREV_TESTER() {
			return PREV_TESTER;
		}
		public void setPREV_TESTER(String pREV_TESTER) {
			PREV_TESTER = pREV_TESTER;
		}
		
		public String getASSIGNED_DATE() {
			return ASSIGNED_DATE;
		}
		public void setASSIGNED_DATE(String aSSIGNED_DATE) {
			ASSIGNED_DATE = aSSIGNED_DATE;
		}
		
		public String getTASKID() {
			return TASKID;
		}
		public void setTASKID(String tASKID) {
			TASKID = tASKID;
		}
		
		public String getREOPEN_REASON() {
			return REOPEN_REASON;
		}
		public void setREOPEN_REASON(String rEOPEN_REASON) {
			REOPEN_REASON = rEOPEN_REASON;
		}
		@Override
		public String toString() {
			return "CustomizationTask [SR_NO=" + SR_NO + ", PRODUCTSUIT=" + PRODUCTSUIT + ", PRODUCTTOOL=" + PRODUCTTOOL
					+ ", CUSTOMERNAME=" + CUSTOMERNAME + ", MODULE_NAME=" + MODULE_NAME + ", MANAGER_NAME="
					+ MANAGER_NAME + ", TEAM_LEADER=" + TEAM_LEADER + ", DEVELOPER_NAME=" + DEVELOPER_NAME
					+ ", SUPPORT_MANAGER_NAME=" + SUPPORT_MANAGER_NAME + ", SUPPORT_TEAM_LEADER=" + SUPPORT_TEAM_LEADER
					+ ", END_DATE=" + END_DATE + ", REMARK=" + REMARK + ", PRIORITY=" + PRIORITY + ", DESCRIPTION="
					+ DESCRIPTION + ", EXPECTED_OUTPUT=" + EXPECTED_OUTPUT + ", STATUS=" + STATUS + ", ASSIGNBY="
					+ ASSIGNBY + ", SUBMITTED_DATE=" + SUBMITTED_DATE + ", DEV_ASSIGNED_DATE=" + DEV_ASSIGNED_DATE
					+ ", TL_ASSIGNED_DATE=" + TL_ASSIGNED_DATE + ", DEVELOPED_DATE=" + DEVELOPED_DATE + ", TESTED_DATE="
					+ TESTED_DATE + ", TASK_CLOSE_DATE=" + TASK_CLOSE_DATE + ", TASK_REOPEN_DATE=" + TASK_REOPEN_DATE
					+ ", TESTER_NAME=" + TESTER_NAME + ", TESTER_DESCRIPTION=" + TESTER_DESCRIPTION
					+ ", TESTED_FAILED_COUNT=" + TESTED_FAILED_COUNT + ", READY_TO_DELIVER_DATE="
					+ READY_TO_DELIVER_DATE + ", PATCH_URL=" + PATCH_URL + ", PREV_TESTER=" + PREV_TESTER
					+ ", ASSIGNED_DATE=" + ASSIGNED_DATE + ", TASKID=" + TASKID + ", REOPEN_REASON=" + REOPEN_REASON
					+ "]";
		}
	
		
		
	
	
}
