package com.velox.itsm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class problemcategorymaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2469894830441779556L;

	@Id
	@Column(name = "PCAT_ID")
	private int PCAT_ID;

	@Column(name = "PCAT_NAME", columnDefinition = "NVARCHAR(500)")
	private String PCAT_NAME;

	@Column(name = "PSUB_CAT1", columnDefinition = "NVARCHAR(500)")
	private String PSUB_CAT1;
	
	@Column(name = "PSUB_CAT2", columnDefinition = "NVARCHAR(500)")
	private String PSUB_CAT2;

	public int getPCAT_ID() {
		return PCAT_ID;
	}

	public void setPCAT_ID(int pCAT_ID) {
		PCAT_ID = pCAT_ID;
	}

	public String getPCAT_NAME() {
		return PCAT_NAME;
	}

	public void setPCAT_NAME(String pCAT_NAME) {
		PCAT_NAME = pCAT_NAME;
	}

	public String getPSUB_CAT1() {
		return PSUB_CAT1;
	}

	public void setPSUB_CAT1(String pSUB_CAT1) {
		PSUB_CAT1 = pSUB_CAT1;
	}

	public String getPSUB_CAT2() {
		return PSUB_CAT2;
	}

	public void setPSUB_CAT2(String pSUB_CAT2) {
		PSUB_CAT2 = pSUB_CAT2;
	}

	@Override
	public String toString() {
		return "problemcategorymaster [PCAT_ID=" + PCAT_ID + ", PCAT_NAME=" + PCAT_NAME + ", PSUB_CAT1=" + PSUB_CAT1
				+ ", PSUB_CAT2=" + PSUB_CAT2 + "]";
	}
	
	

}
