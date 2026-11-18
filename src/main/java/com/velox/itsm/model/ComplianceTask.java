package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ComplianceTask {


		private static final long serialVersionUID = 4L;

		@Id
		@Column
		private int SR_NO;	
		
		private String PRODUCTSUIT;
		private String PRODUCTTOOL;
		private String CUSTOMERNAME;
		private String MODULE_NAME;
		private String SUB_MODULE_1;
		private String SUB_MODULE_2;
		private String MANAGER_NAME;
		private String TEAM_LEADER;
		private String DEVELOPER_NAME;
		private String REMARK;
		private String PRIORITY;
		private String DESCRIPTION;
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
		private String REF_NO;
		private String REOPEN_REASON;
		private String TEST_FAIL_REASON;
		private String TASK_ASSIGNBY;
		private String SOL_ID;
		private String F_HEAD;
		private String AM_DM;
		private String TESTED_DESCRIPTION;
		private String REVISED_DATE;
		private String REVISED_DATE_REASON;
		private String DATE_APPROVED_BY;
		private String REVISED_DATE_COUNT;
		private String DELAY_REASON; 
		private String REVISE_DATE_STATUS;
		private String DELAY_REASON_BY; 
		
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
		public String getSUB_MODULE_1() {
			return SUB_MODULE_1;
		}
		public void setSUB_MODULE_1(String sUB_MODULE_1) {
			SUB_MODULE_1 = sUB_MODULE_1;
		}
		public String getSUB_MODULE_2() {
			return SUB_MODULE_2;
		}
		public void setSUB_MODULE_2(String sUB_MODULE_2) {
			SUB_MODULE_2 = sUB_MODULE_2;
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
		
		public String getREF_NO() {
			return REF_NO;
		}
		public void setREF_NO(String rEF_NO) {
			REF_NO = rEF_NO;
		}
		
		public String getTEST_FAIL_REASON() {
			return TEST_FAIL_REASON;
		}
		public void setTEST_FAIL_REASON(String tEST_FAIL_REASON) {
			TEST_FAIL_REASON = tEST_FAIL_REASON;
		}
		
		public String getTASK_ASSIGNBY() {
			return TASK_ASSIGNBY;
		}
		public void setTASK_ASSIGNBY(String tASK_ASSIGNBY) {
			TASK_ASSIGNBY = tASK_ASSIGNBY;
		}
		
		public String getSOL_ID() {
			return SOL_ID;
		}
		public void setSOL_ID(String sOL_ID) {
			SOL_ID = sOL_ID;
		}
		public String getF_HEAD() {
			return F_HEAD;
		}
		public void setF_HEAD(String f_HEAD) {
			F_HEAD = f_HEAD;
		}
		public String getAM_DM() {
			return AM_DM;
		}
		public void setAM_DM(String aM_DM) {
			AM_DM = aM_DM;
		}
		public String getTESTED_DESCRIPTION() {
			return TESTED_DESCRIPTION;
		}
		public void setTESTED_DESCRIPTION(String tESTED_DESCRIPTION) {
			TESTED_DESCRIPTION = tESTED_DESCRIPTION;
		}
		public String getREVISED_DATE() {
			return REVISED_DATE;
		}
		public void setREVISED_DATE(String rEVISED_DATE) {
			REVISED_DATE = rEVISED_DATE;
		}
		public String getREVISED_DATE_REASON() {
			return REVISED_DATE_REASON;
		}
		public void setREVISED_DATE_REASON(String rEVISED_DATE_REASON) {
			REVISED_DATE_REASON = rEVISED_DATE_REASON;
		}
		public String getDATE_APPROVED_BY() {
			return DATE_APPROVED_BY;
		}
		public void setDATE_APPROVED_BY(String dATE_APPROVED_BY) {
			DATE_APPROVED_BY = dATE_APPROVED_BY;
		}
		public String getREVISED_DATE_COUNT() {
			return REVISED_DATE_COUNT;
		}
		public void setREVISED_DATE_COUNT(String rEVISED_DATE_COUNT) {
			REVISED_DATE_COUNT = rEVISED_DATE_COUNT;
		}
		public String getDELAY_REASON() {
			return DELAY_REASON;
		}
		public void setDELAY_REASON(String dELAY_REASON) {
			DELAY_REASON = dELAY_REASON;
		}
		public String getREVISE_DATE_STATUS() {
			return REVISE_DATE_STATUS;
		}
		public void setREVISE_DATE_STATUS(String rEVISE_DATE_STATUS) {
			REVISE_DATE_STATUS = rEVISE_DATE_STATUS;
		}
		public String getDELAY_REASON_BY() {
			return DELAY_REASON_BY;
		}
		public void setDELAY_REASON_BY(String dELAY_REASON_BY) {
			DELAY_REASON_BY = dELAY_REASON_BY;
		}
		@Override
		public String toString() {
			return "ComplianceTask [SR_NO=" + SR_NO + ", PRODUCTSUIT=" + PRODUCTSUIT + ", PRODUCTTOOL=" + PRODUCTTOOL
					+ ", CUSTOMERNAME=" + CUSTOMERNAME + ", MODULE_NAME=" + MODULE_NAME + ", SUB_MODULE_1="
					+ SUB_MODULE_1 + ", SUB_MODULE_2=" + SUB_MODULE_2 + ", MANAGER_NAME=" + MANAGER_NAME
					+ ", TEAM_LEADER=" + TEAM_LEADER + ", DEVELOPER_NAME=" + DEVELOPER_NAME + ", REMARK=" + REMARK
					+ ", PRIORITY=" + PRIORITY + ", DESCRIPTION=" + DESCRIPTION + ", STATUS=" + STATUS + ", ASSIGNBY="
					+ ASSIGNBY + ", SUBMITTED_DATE=" + SUBMITTED_DATE + ", DEV_ASSIGNED_DATE=" + DEV_ASSIGNED_DATE
					+ ", TL_ASSIGNED_DATE=" + TL_ASSIGNED_DATE + ", DEVELOPED_DATE=" + DEVELOPED_DATE + ", TESTED_DATE="
					+ TESTED_DATE + ", TASK_CLOSE_DATE=" + TASK_CLOSE_DATE + ", TASK_REOPEN_DATE=" + TASK_REOPEN_DATE
					+ ", TESTER_NAME=" + TESTER_NAME + ", TESTER_DESCRIPTION=" + TESTER_DESCRIPTION
					+ ", TESTED_FAILED_COUNT=" + TESTED_FAILED_COUNT + ", READY_TO_DELIVER_DATE="
					+ READY_TO_DELIVER_DATE + ", PATCH_URL=" + PATCH_URL + ", PREV_TESTER=" + PREV_TESTER
					+ ", ASSIGNED_DATE=" + ASSIGNED_DATE + ", TASKID=" + TASKID + ", REF_NO=" + REF_NO
					+ ", REOPEN_REASON=" + REOPEN_REASON + ", TEST_FAIL_REASON=" + TEST_FAIL_REASON + ", TASK_ASSIGNBY="
					+ TASK_ASSIGNBY + ", SOL_ID=" + SOL_ID + ", F_HEAD=" + F_HEAD + ", AM_DM=" + AM_DM
					+ ", TESTED_DESCRIPTION=" + TESTED_DESCRIPTION + ", REVISED_DATE=" + REVISED_DATE
					+ ", REVISED_DATE_REASON=" + REVISED_DATE_REASON + ", DATE_APPROVED_BY=" + DATE_APPROVED_BY
					+ ", REVISED_DATE_COUNT=" + REVISED_DATE_COUNT + ", DELAY_REASON=" + DELAY_REASON
					+ ", REVISE_DATE_STATUS=" + REVISE_DATE_STATUS + ", DELAY_REASON_BY=" + DELAY_REASON_BY + "]";
		}

}
