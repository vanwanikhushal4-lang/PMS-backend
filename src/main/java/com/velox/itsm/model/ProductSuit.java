package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductSuitMaster" )
public class ProductSuit {
	
	@Id	
	private int SR_NO;
	
	private String PRODUCT_SUIT ;
	
	private int BulkUp_ID;

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

	public int getBulkUp_ID() {
		return BulkUp_ID;
	}

	public void setBulkUp_ID(int bulkUp_ID) {
		BulkUp_ID = bulkUp_ID;
	}

	@Override
	public String toString() {
		return "ProductSuit [SR_NO=" + SR_NO + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", BulkUp_ID=" + BulkUp_ID + "]";
	}

	



}
