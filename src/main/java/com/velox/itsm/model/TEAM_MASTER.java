package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class TEAM_MASTER {
	
	@Id	
	private int SR_NO;
	
	private String PRODUCT_SUIT ;
	private String SOLUTION;
	private String F_HEAD;
	private String AM_DM;
	private String TEAM_LEADER;
	private String PHASE;
	private String SOL_ID;
	
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getPRODUCT_SUIT() {
		return PRODUCT_SUIT;
	}
	public void setPRODUCT_SUIT(String pRODUCT_SUIT) {
		PRODUCT_SUIT = pRODUCT_SUIT;
	}
	public String getSOLUTION() {
		return SOLUTION;
	}
	public void setSOLUTION(String sOLUTION) {
		SOLUTION = sOLUTION;
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
	public String getTEAM_LEADER() {
		return TEAM_LEADER;
	}
	public void setTEAM_LEADER(String tEAM_LEADER) {
		TEAM_LEADER = tEAM_LEADER;
	}
	
	public String getPHASE() {
		return PHASE;
	}
	public void setPHASE(String pHASE) {
		PHASE = pHASE;
	}
	
	public String getSOL_ID() {
		return SOL_ID;
	}
	public void setSOL_ID(String sOL_ID) {
		SOL_ID = sOL_ID;
	}
	@Override
	public String toString() {
		return "TEAM_MASTER [SR_NO=" + SR_NO + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", SOLUTION=" + SOLUTION + ", F_HEAD="
				+ F_HEAD + ", AM_DM=" + AM_DM + ", TEAM_LEADER=" + TEAM_LEADER + ", PHASE=" + PHASE + ", SOL_ID="
				+ SOL_ID + "]";
	}
	
	
	
}
