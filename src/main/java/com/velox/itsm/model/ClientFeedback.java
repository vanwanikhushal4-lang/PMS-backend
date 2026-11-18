package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ClientFeedback {
	
	@GeneratedValue
	@Id
	@Column
	private int SR_NO;
	
	private String CLIENT_NAME;
	private String PROJECT_NAME;
	private String FEEDBACK_DATE;
	private String FEEDBACK_TYPE;
	private String FEEDBACK_DESC;
	private String IMPACT;
	private String STATUS_OF_GRIEVANCE;
	private String ASSIGN_TO;
	private String RESOLUTION_DESC;
	private String FOLLOW_UP_DATE;
	private String CLIENT_RESPONSE;
	
	
	private String VIEW ;
	private String SUBMITTED_BY;
	private String SUBMITTED_DATE;
	
	public String getVIEW() {
		return VIEW;
	}
	public void setVIEW(String vIEW) {
		VIEW = vIEW;
	}
	public String getSUBMITTED_BY() {
		return SUBMITTED_BY;
	}
	public void setSUBMITTED_BY(String sUBMITTED_BY) {
		SUBMITTED_BY = sUBMITTED_BY;
	}
	public String getSUBMITTED_DATE() {
		return SUBMITTED_DATE;
	}
	public void setSUBMITTED_DATE(String sUBMITTED_DATE) {
		SUBMITTED_DATE = sUBMITTED_DATE;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}
	public void setCLIENT_NAME(String cLIENT_NAME) {
		CLIENT_NAME = cLIENT_NAME;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getFEEDBACK_DATE() {
		return FEEDBACK_DATE;
	}
	public void setFEEDBACK_DATE(String fEEDBACK_DATE) {
		FEEDBACK_DATE = fEEDBACK_DATE;
	}
	public String getFEEDBACK_TYPE() {
		return FEEDBACK_TYPE;
	}
	public void setFEEDBACK_TYPE(String fEEDBACK_TYPE) {
		FEEDBACK_TYPE = fEEDBACK_TYPE;
	}
	public String getFEEDBACK_DESC() {
		return FEEDBACK_DESC;
	}
	public void setFEEDBACK_DESC(String fEEDBACK_DESC) {
		FEEDBACK_DESC = fEEDBACK_DESC;
	}
	public String getIMPACT() {
		return IMPACT;
	}
	public void setIMPACT(String iMPACT) {
		IMPACT = iMPACT;
	}
	public String getSTATUS_OF_GRIEVANCE() {
		return STATUS_OF_GRIEVANCE;
	}
	public void setSTATUS_OF_GRIEVANCE(String sTATUS_OF_GRIEVANCE) {
		STATUS_OF_GRIEVANCE = sTATUS_OF_GRIEVANCE;
	}
	public String getASSIGN_TO() {
		return ASSIGN_TO;
	}
	public void setASSIGN_TO(String aSSIGN_TO) {
		ASSIGN_TO = aSSIGN_TO;
	}
	public String getRESOLUTION_DESC() {
		return RESOLUTION_DESC;
	}
	public void setRESOLUTION_DESC(String rESOLUTION_DESC) {
		RESOLUTION_DESC = rESOLUTION_DESC;
	}
	public String getFOLLOW_UP_DATE() {
		return FOLLOW_UP_DATE;
	}
	public void setFOLLOW_UP_DATE(String fOLLOW_UP_DATE) {
		FOLLOW_UP_DATE = fOLLOW_UP_DATE;
	}
	public String getCLIENT_RESPONSE() {
		return CLIENT_RESPONSE;
	}
	public void setCLIENT_RESPONSE(String cLIENT_RESPONSE) {
		CLIENT_RESPONSE = cLIENT_RESPONSE;
	}
	
	
	@Override
	public String toString() {
		return "ClientFeedback [SR_NO=" + SR_NO + ", CLIENT_NAME=" + CLIENT_NAME + ", PROJECT_NAME=" + PROJECT_NAME
				+ ", FEEDBACK_DATE=" + FEEDBACK_DATE + ", FEEDBACK_TYPE=" + FEEDBACK_TYPE + ", FEEDBACK_DESC="
				+ FEEDBACK_DESC + ", IMPACT=" + IMPACT + ", STATUS_OF_GRIEVANCE=" + STATUS_OF_GRIEVANCE + ", ASSIGN_TO="
				+ ASSIGN_TO + ", RESOLUTION_DESC=" + RESOLUTION_DESC + ", FOLLOW_UP_DATE=" + FOLLOW_UP_DATE
				+ ", CLIENT_RESPONSE=" + CLIENT_RESPONSE + ", VIEW=" + VIEW + ", SUBMITTED_BY=" + SUBMITTED_BY
				+ ", SUBMITTED_DATE=" + SUBMITTED_DATE + "]";
	}
	
	
	
	
	
}
