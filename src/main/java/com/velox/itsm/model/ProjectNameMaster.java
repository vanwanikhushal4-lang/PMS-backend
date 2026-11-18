package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ProjectNameMaster" )
public class ProjectNameMaster {

	private static final long serialVersionUID = 4L;
	
	@Id	
	private int SR_NO;
	
	private String PRODUCT_SUIT ;
	private String SECURITY_SOLTION ;
	private String PROJECT_NAME ;
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
	public String getSECURITY_SOLTION() {
		return SECURITY_SOLTION;
	}
	public void setSECURITY_SOLTION(String sECURITY_SOLTION) {
		SECURITY_SOLTION = sECURITY_SOLTION;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	@Override
	public String toString() {
		return "ProjectNameMaster [SR_NO=" + SR_NO + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", SECURITY_SOLTION="
				+ SECURITY_SOLTION + ", PROJECT_NAME=" + PROJECT_NAME + "]";
	}
	
	
	
	
}
