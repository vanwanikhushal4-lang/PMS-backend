package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class USER_SOFTWARE_MAP implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5882247080484352300L;
	@Id
	private int SRNO;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String APPLIED_DATE;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String  USERNAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PROJECT_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String PRODUCT_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String ASSET_CODE;
	private String STATUS;
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	public String getAPPLIED_DATE() {
		return APPLIED_DATE;
	}
	public void setAPPLIED_DATE(String aPPLIED_DATE) {
		APPLIED_DATE = aPPLIED_DATE;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(String pROJECT_ID) {
		PROJECT_ID = pROJECT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getASSET_CODE() {
		return ASSET_CODE;
	}
	public void setASSET_CODE(String aSSET_CODE) {
		ASSET_CODE = aSSET_CODE;
	}
	public int getSRNO() {
		return SRNO;
	}
	public void setSRNO(int sRNO) {
		SRNO = sRNO;
	}
	@Override
	public String toString() {
		return "USER_SOFTWARE_MAP [SRNO=" + SRNO + ", APPLIED_DATE=" + APPLIED_DATE + ", USERNAME=" + USERNAME
				+ ", PROJECT_ID=" + PROJECT_ID + ", PRODUCT_NAME=" + PRODUCT_NAME + ", ASSET_CODE=" + ASSET_CODE
				+ ", STATUS=" + STATUS + "]";
	}
	
}
