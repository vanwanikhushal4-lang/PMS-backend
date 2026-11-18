package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TeamFeedback {
	
	@GeneratedValue
	@Id
	@Column
	private int SR_NO;
	private String EMP_NAME;
	private String PROJECT_NAME;
	private String RATINGS;
	private String FEEDBACK;
	private String SUGGESTION;
	
	
	
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
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getRATINGS() {
		return RATINGS;
	}
	public void setRATINGS(String rATINGS) {
		RATINGS = rATINGS;
	}
	public String getFEEDBACK() {
		return FEEDBACK;
	}
	public void setFEEDBACK(String fEEDBACK) {
		FEEDBACK = fEEDBACK;
	}
	public String getSUGGESTION() {
		return SUGGESTION;
	}
	public void setSUGGESTION(String sUGGESTION) {
		SUGGESTION = sUGGESTION;
	}
	
	
	@Override
	public String toString() {
		return "TeamFeedback [SR_NO=" + SR_NO + ", EMP_NAME=" + EMP_NAME + ", PROJECT_NAME=" + PROJECT_NAME
				+ ", RATINGS=" + RATINGS + ", FEEDBACK=" + FEEDBACK + ", SUGGESTION=" + SUGGESTION + ", VIEW=" + VIEW
				+ ", SUBMITTED_BY=" + SUBMITTED_BY + ", SUBMITTED_DATE=" + SUBMITTED_DATE + "]";
	}
	
	
	
	

}
