package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_template_master")

public class category_template_master implements Serializable{

	private static final long serialVersionUID = 4L;
	
	@Id
	@Column
	private int SR_NO;
	
	private String CATEGORY;
	private String SUB_CATEGORY1;
	private String SUB_CATEGORY2;
	private String PRIORITY;
	private String SEVERITY;
	

	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getSUB_CATEGORY1() {
		return SUB_CATEGORY1;
	}
	public void setSUB_CATEGORY1(String sUB_CATEGORY1) {
		SUB_CATEGORY1 = sUB_CATEGORY1;
	}
	public String getSUB_CATEGORY2() {
		return SUB_CATEGORY2;
	}
	public void setSUB_CATEGORY2(String sUB_CATEGORY2) {
		SUB_CATEGORY2 = sUB_CATEGORY2;
	}
	public String getPRIORITY() {
		return PRIORITY;
	}
	public void setPRIORITY(String pRIORITY) {
		PRIORITY = pRIORITY;
	}
	public String getSEVERITY() {
		return SEVERITY;
	}
	public void setSEVERITY(String sEVERITY) {
		SEVERITY = sEVERITY;
	}
	@Override
	public String toString() {
		return "category_template_master [SR_NO=" + SR_NO + ", CATEGORY=" + CATEGORY + ", SUB_CATEGORY1="
				+ SUB_CATEGORY1 + ", SUB_CATEGORY2=" + SUB_CATEGORY2 + ", PRIORITY=" + PRIORITY + ", SEVERITY="
				+ SEVERITY + "]";
	}
	
	
	
}
