package com.velox.itsm.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SUBCATMASTER")
public class subcategorymaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519604694886893231L;
	@Id
	@Column
	private int SUB_ID;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String CAT_NAME;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String SUBCAT_NAME;

	public int getSUB_ID() {
		return SUB_ID;
	}

	public void setSUB_ID(int sUB_ID) {
		SUB_ID = sUB_ID;
	}

	public String getCAT_NAME() {
		return CAT_NAME;
	}

	public void setCAT_NAME(String cAT_NAME) {
		CAT_NAME = cAT_NAME;
	}

	public String getSUBCAT_NAME() {
		return SUBCAT_NAME;
	}

	public void setSUBCAT_NAME(String sUBCAT_NAME) {
		SUBCAT_NAME = sUBCAT_NAME;
	}

	@Override
	public String toString() {
		return "subcategorymaster [SUB_ID=" + SUB_ID + ", CAT_NAME=" + CAT_NAME + ", SUBCAT_NAME=" + SUBCAT_NAME + "]";
	}

	public subcategorymaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
