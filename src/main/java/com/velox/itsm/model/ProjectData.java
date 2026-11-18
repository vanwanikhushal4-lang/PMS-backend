package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class ProjectData {

	private static final long serialVersionUID = 4L;

	@Id
	@Column
	private int SR_NO;	
	
	private String PROJECTNAME;
	private String FUNCTION_NAME;
	private String RESPONSIBILITY;
	private String PRODUCTSUIT;
	private String PRODUCTTOOL;
	private String CUSTOMERNAME;
	private String SUBMITTEDBY;
	private String Task_ID;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getPROJECTNAME() {
		return PROJECTNAME;
	}
	public void setPROJECTNAME(String pROJECTNAME) {
		PROJECTNAME = pROJECTNAME;
	}
	public String getFUNCTION_NAME() {
		return FUNCTION_NAME;
	}
	public void setFUNCTION_NAME(String fUNCTION_NAME) {
		FUNCTION_NAME = fUNCTION_NAME;
	}
	public String getRESPONSIBILITY() {
		return RESPONSIBILITY;
	}
	public void setRESPONSIBILITY(String rESPONSIBILITY) {
		RESPONSIBILITY = rESPONSIBILITY;
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
	public String getSUBMITTEDBY() {
		return SUBMITTEDBY;
	}
	public void setSUBMITTEDBY(String sUBMITTEDBY) {
		SUBMITTEDBY = sUBMITTEDBY;
	}
	public String getTask_ID() {
		return Task_ID;
	}
	public void setTask_ID(String task_ID) {
		Task_ID = task_ID;
	}
	@Override
	public String toString() {
		return "ProjectData [SR_NO=" + SR_NO + ", PROJECTNAME=" + PROJECTNAME + ", FUNCTION_NAME=" + FUNCTION_NAME
				+ ", RESPONSIBILITY=" + RESPONSIBILITY + ", PRODUCTSUIT=" + PRODUCTSUIT + ", PRODUCTTOOL=" + PRODUCTTOOL
				+ ", CUSTOMERNAME=" + CUSTOMERNAME + ", SUBMITTEDBY=" + SUBMITTEDBY + ", Task_ID=" + Task_ID + "]";
	}
	
	
}
