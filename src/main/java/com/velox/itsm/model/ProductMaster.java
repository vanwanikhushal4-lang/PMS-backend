package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ProductMaster" )
public class ProductMaster implements Serializable {

	private static final long serialVersionUID = 4L;
	
	@Id	
	private int SR_NO;
	
	private String PRODUCT_SUIT ;
	private String SECURITY_SOLTION ;
	private String UNIT ;
	private String Security_Tools ;
	private String Qty ;
	private int BulkUp_ID;
	private String ImplementerName;
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
	public String getUNIT() {
		return UNIT;
	}
	public void setUNIT(String uNIT) {
		UNIT = uNIT;
	}
	public String getSecurity_Tools() {
		return Security_Tools;
	}
	public void setSecurity_Tools(String security_Tools) {
		Security_Tools = security_Tools;
	}
	public String getQty() {
		return Qty;
	}
	public void setQty(String qty) {
		Qty = qty;
	}
	public int getBulkUp_ID() {
		return BulkUp_ID;
	}
	public void setBulkUp_ID(int bulkUp_ID) {
		BulkUp_ID = bulkUp_ID;
	}
	public String getImplementerName() {
		return ImplementerName;
	}
	public void setImplementerName(String implementerName) {
		ImplementerName = implementerName;
	}
	@Override
	public String toString() {
		return "ProductMaster [SR_NO=" + SR_NO + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", SECURITY_SOLTION="
				+ SECURITY_SOLTION + ", UNIT=" + UNIT + ", Security_Tools=" + Security_Tools + ", Qty=" + Qty
				+ ", BulkUp_ID=" + BulkUp_ID + ", ImplementerName=" + ImplementerName + "]";
	}
	
	
	
	
	

	
	
}
