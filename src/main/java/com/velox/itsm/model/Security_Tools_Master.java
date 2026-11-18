package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SECURITY_TOOLS_MASTER" )
public class Security_Tools_Master {
	
	
	@Id	
	private int SR_NO;
	
	private String SECURITY_TOOLS ;

	private int BulkUp_ID;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getSECURITY_TOOLS() {
		return SECURITY_TOOLS;
	}

	public void setSECURITY_TOOLS(String sECURITY_TOOLS) {
		SECURITY_TOOLS = sECURITY_TOOLS;
	}

	public int getBulkUp_ID() {
		return BulkUp_ID;
	}

	public void setBulkUp_ID(int bulkUp_ID) {
		BulkUp_ID = bulkUp_ID;
	}

	@Override
	public String toString() {
		return "Security_Tools_Master [SR_NO=" + SR_NO + ", SECURITY_TOOLS=" + SECURITY_TOOLS + ", BulkUp_ID="
				+ BulkUp_ID + "]";
	}
	
	

}
