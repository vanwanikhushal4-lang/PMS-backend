package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class TlMasterSupport {
	
	@Id	
	private int SR_NO;
	
	private String PRODUCT_SUIT ;
	private String SECURITY_SOLTION;
	private String ImplementerName;
	private String Team_Leader;
	private String Developer;
	private String Customer_name;
	
	
	
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getDeveloper() {
		return Developer;
	}
	public void setDeveloper(String developer) {
		Developer = developer;
	}
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
	public String getImplementerName() {
		return ImplementerName;
	}
	public void setImplementerName(String implementerName) {
		ImplementerName = implementerName;
	}
	public String getTeam_Leader() {
		return Team_Leader;
	}
	public void setTeam_Leader(String team_Leader) {
		Team_Leader = team_Leader;
	}
	
	
	
	@Override
	public String toString() {
		return "TlMasterSupport [SR_NO=" + SR_NO + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", SECURITY_SOLTION="
				+ SECURITY_SOLTION + ", ImplementerName=" + ImplementerName + ", Team_Leader=" + Team_Leader
				+ ", Developer=" + Developer + ", Customer_name=" + Customer_name + "]";
	}
	
	
	
	
	
	

}
