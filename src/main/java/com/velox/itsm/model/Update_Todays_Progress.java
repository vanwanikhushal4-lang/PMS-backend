package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Update_Todays_Progress" )
public class Update_Todays_Progress implements Serializable {
	
	@Id	
	@GeneratedValue
	private int SR_NO;
	
	private String TASK_ID ;
	public String getTASK_ID() {
		return TASK_ID;
	}
	public void setTASK_ID(String tASK_ID) {
		TASK_ID = tASK_ID;
	}


	private String FUNCTION_NAME ;
	private String MODULE_NAME ;
	private String CUSTOMER_NAME ;
	private String PRODUCT_NAME ;
	private String PRODUCT_SUITE ;
	private String TASK_DESC ;
	private String DATE ;
	private String TODAYS_PROGRESS ;
	private String FULL_NAME ;
	private String TASK_TYPE ;
	private String STATUS ;
	
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
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
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_SUITE() {
		return PRODUCT_SUITE;
	}
	public void setPRODUCT_SUITE(String pRODUCT_SUITE) {
		PRODUCT_SUITE = pRODUCT_SUITE;
	}
	public String getTASK_DESC() {
		return TASK_DESC;
	}
	public void setTASK_DESC(String tASK_DESC) {
		TASK_DESC = tASK_DESC;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getTODAYS_PROGRESS() {
		return TODAYS_PROGRESS;
	}
	public void setTODAYS_PROGRESS(String tODAYS_PROGRESS) {
		TODAYS_PROGRESS = tODAYS_PROGRESS;
	}
	
	public String getFULL_NAME() {
		return FULL_NAME;
	}
	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}
	public String getTASK_TYPE() {
		return TASK_TYPE;
	}
	public void setTASK_TYPE(String tASK_TYPE) {
		TASK_TYPE = tASK_TYPE;
	}
	@Override
	public String toString() {
		return "Update_Todays_Progress [SR_NO=" + SR_NO + ", TASK_ID=" + TASK_ID + ", FUNCTION_NAME=" + FUNCTION_NAME
				+ ", MODULE_NAME=" + MODULE_NAME + ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", PRODUCT_NAME=" + PRODUCT_NAME
				+ ", PRODUCT_SUITE=" + PRODUCT_SUITE + ", TASK_DESC=" + TASK_DESC + ", DATE=" + DATE
				+ ", TODAYS_PROGRESS=" + TODAYS_PROGRESS + ", FULL_NAME=" + FULL_NAME + ", TASK_TYPE=" + TASK_TYPE
				+ ", STATUS=" + STATUS + "]";
	}
	
	
	
	
}
