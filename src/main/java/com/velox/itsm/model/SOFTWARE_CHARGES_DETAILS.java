package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SOFTWARE_CHARGES_DETAILS implements Serializable{

	private static final long serialVersionUID = -5097998098595866258L;
	
	@Id
	public int SR_NO;

	public String SOFTWARE_NAME;
	public String  RECOVERY_PERIOD;
	public String  APPLIED_DATE;
	public String COST_PER_MONTH;
	public String USED_BY;
	public String  USED_BY_FULLNAME;
	public String TO_DATE;
	public String PROJECT_ID;
	public String  ASSET_CODE;
	public String PERPOSE;
	public String DEPARTMENT;
	public String LOCATION;
	public String COMPANY;
	public String BRANCH;
	public String RELEASE_DATE;
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getSOFTWARE_NAME() {
		return SOFTWARE_NAME;
	}
	public void setSOFTWARE_NAME(String sOFTWARE_NAME) {
		SOFTWARE_NAME = sOFTWARE_NAME;
	}
	public String getRECOVERY_PERIOD() {
		return RECOVERY_PERIOD;
	}
	public void setRECOVERY_PERIOD(String rECOVERY_PERIOD) {
		RECOVERY_PERIOD = rECOVERY_PERIOD;
	}
	public String getAPPLIED_DATE() {
		return APPLIED_DATE;
	}
	public void setAPPLIED_DATE(String aPPLIED_DATE) {
		APPLIED_DATE = aPPLIED_DATE;
	}
	public String getCOST_PER_MONTH() {
		return COST_PER_MONTH;
	}
	public void setCOST_PER_MONTH(String cOST_PER_MONTH) {
		COST_PER_MONTH = cOST_PER_MONTH;
	}
	public String getUSED_BY() {
		return USED_BY;
	}
	public void setUSED_BY(String uSED_BY) {
		USED_BY = uSED_BY;
	}
	public String getUSED_BY_FULLNAME() {
		return USED_BY_FULLNAME;
	}
	public void setUSED_BY_FULLNAME(String uSED_BY_FULLNAME) {
		USED_BY_FULLNAME = uSED_BY_FULLNAME;
	}
	public String getTO_DATE() {
		return TO_DATE;
	}
	public void setTO_DATE(String tO_DATE) {
		TO_DATE = tO_DATE;
	}
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(String pROJECT_ID) {
		PROJECT_ID = pROJECT_ID;
	}
	public String getASSET_CODE() {
		return ASSET_CODE;
	}
	public void setASSET_CODE(String aSSET_CODE) {
		ASSET_CODE = aSSET_CODE;
	}
	public String getPERPOSE() {
		return PERPOSE;
	}
	public void setPERPOSE(String pERPOSE) {
		PERPOSE = pERPOSE;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getRELEASE_DATE() {
		return RELEASE_DATE;
	}
	public void setRELEASE_DATE(String rELEASE_DATE) {
		RELEASE_DATE = rELEASE_DATE;
	}
	
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getBRANCH() {
		return BRANCH;
	}
	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}
	@Override
	public String toString() {
		return "SOFTWARE_CHARGES_DETAILS [SR_NO=" + SR_NO + ", SOFTWARE_NAME=" + SOFTWARE_NAME + ", RECOVERY_PERIOD="
				+ RECOVERY_PERIOD + ", APPLIED_DATE=" + APPLIED_DATE + ", COST_PER_MONTH=" + COST_PER_MONTH
				+ ", USED_BY=" + USED_BY + ", USED_BY_FULLNAME=" + USED_BY_FULLNAME + ", TO_DATE=" + TO_DATE
				+ ", PROJECT_ID=" + PROJECT_ID + ", ASSET_CODE=" + ASSET_CODE + ", PERPOSE=" + PERPOSE + ", DEPARTMENT="
				+ DEPARTMENT + ", LOCATION=" + LOCATION + ", COMPANY=" + COMPANY + ", BRANCH=" + BRANCH
				+ ", RELEASE_DATE=" + RELEASE_DATE + "]";
	}
	
	
	
}
