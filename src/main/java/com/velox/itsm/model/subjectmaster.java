package com.velox.itsm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECTMASTER")
public class subjectmaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3874703333288861201L;
	@Id
	@Column(name = "SUB_ID")
	private int SUB_ID;
	@Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
	private String COMPANY;
	@Column(name = "CAT_NAME", columnDefinition = "NVARCHAR(500)")
	private String CAT_NAME;
	@Column(name = "SUB_CATEGORY1", columnDefinition = "NVARCHAR(500)")
	private String SUB_CATEGORY1;
	@Column(name = "SUB_CATEGORY2", columnDefinition = "NVARCHAR(500)")
	private String SUB_CATEGORY2;
	@Column(name = "SUBJECT", columnDefinition = "NVARCHAR(500)")
	private String SUBJECT;
	public int getSUB_ID() {
		return SUB_ID;
	}
	public void setSUB_ID(int sUB_ID) {
		SUB_ID = sUB_ID;
	}
	public String getCOMPANY() {
		return COMPANY;
	}
	public void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	public String getCAT_NAME() {
		return CAT_NAME;
	}
	public void setCAT_NAME(String cAT_NAME) {
		CAT_NAME = cAT_NAME;
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
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	@Override
	public String toString() {
		return "subjectmaster [SUB_ID=" + SUB_ID + ", COMPANY=" + COMPANY + ", CAT_NAME=" + CAT_NAME
				+ ", SUB_CATEGORY1=" + SUB_CATEGORY1 + ", SUB_CATEGORY2=" + SUB_CATEGORY2 + ", SUBJECT=" + SUBJECT
				+ "]";
	}
	
	
	
	
	
}
