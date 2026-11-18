package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class ComplianceUpload {

		private static final long serialVersionUID = 4L;

		@Id
		@Column
		private int SR_NO;	
		
		private String PRODUCTSUIT;
		private String PRODUCTTOOL;
		private String CUSTOMERNAME;
		private String MANAGER_NAME;
		private String TEAM_LEADER;
		private String COMPLIANCE_FILE;
		private String DESCRIPTION;
		private String ASSIGNBY;
		private String SUBMITTED_DATE;
		private String TL_ASSIGNED_DATE;
		private String REF_NO;
		private String STATUS;
		private String SALES_MANAGER;
		private String F_HEAD;
		private String AM_DM;
		
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

		public String getCOMPLIANCE_FILE() {
			return COMPLIANCE_FILE;
		}
		public void setCOMPLIANCE_FILE(String cOMPLIANCE_FILE) {
			COMPLIANCE_FILE = cOMPLIANCE_FILE;
		}
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		public void setDESCRIPTION(String dESCRIPTION) {
			DESCRIPTION = dESCRIPTION;
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
		public String getTL_ASSIGNED_DATE() {
			return TL_ASSIGNED_DATE;
		}
		public void setTL_ASSIGNED_DATE(String tL_ASSIGNED_DATE) {
			TL_ASSIGNED_DATE = tL_ASSIGNED_DATE;
		}
		
		public String getREF_NO() {
			return REF_NO;
		}
		public void setREF_NO(String rEF_NO) {
			REF_NO = rEF_NO;
		}
		
		public String getSTATUS() {
			return STATUS;
		}
		public void setSTATUS(String sTATUS) {
			STATUS = sTATUS;
		}
		public String getSALES_MANAGER() {
			return SALES_MANAGER;
		}
		public void setSALES_MANAGER(String sALES_MANAGER) {
			SALES_MANAGER = sALES_MANAGER;
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
		@Override
		public String toString() {
			return "ComplianceUpload [SR_NO=" + SR_NO + ", PRODUCTSUIT=" + PRODUCTSUIT + ", PRODUCTTOOL=" + PRODUCTTOOL
					+ ", CUSTOMERNAME=" + CUSTOMERNAME + ", MANAGER_NAME=" + MANAGER_NAME + ", TEAM_LEADER="
					+ TEAM_LEADER + ", COMPLIANCE_FILE=" + COMPLIANCE_FILE + ", DESCRIPTION=" + DESCRIPTION
					+ ", ASSIGNBY=" + ASSIGNBY + ", SUBMITTED_DATE=" + SUBMITTED_DATE + ", TL_ASSIGNED_DATE="
					+ TL_ASSIGNED_DATE + ", REF_NO=" + REF_NO + ", STATUS=" + STATUS + ", SALES_MANAGER="
					+ SALES_MANAGER + ", F_HEAD=" + F_HEAD + ", AM_DM=" + AM_DM + "]";
		}

		
		
		
	
	
}
