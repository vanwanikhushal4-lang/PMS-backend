package com.velox.itsm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICECATALOGUEMASTER")
public class servicecataloguemaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3501780649836587244L;
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
	@Column(name = "PRIORITY", columnDefinition = "NVARCHAR(500)")
	private String PRIORITY;
	@Column(name = "SEVERITY", columnDefinition = "NVARCHAR(500)")
	private String SEVERITY;
	@Column(name = "SERVICE_REQUEST_TYPE", columnDefinition = "NVARCHAR(500)")
	private String SERVICE_REQUEST_TYPE;
	@Column(name = "GROUP_NAME", columnDefinition = "NVARCHAR(500)")
	private String GROUP_NAME;
	@Column(name = "APPROVAL_LEVEL", columnDefinition = "NVARCHAR(500)")
	private String APPROVAL_LEVEL;
	@Column(name = "LEVEL_ONE_DESIGNATION", columnDefinition = "NVARCHAR(500)")
	private String LEVEL_ONE_DESIGNATION;
	@Column(name = "LEVEL_TWO_DESIGNATION", columnDefinition = "NVARCHAR(500)")
	private String LEVEL_TWO_DESIGNATION;
	@Column(name = "REQUEST_COST")
	private String  REQUEST_COST;
	private String SUBJECT_TYPE_CHECK;
	
	
	
	
	
	public String getSUBJECT_TYPE_CHECK() {
		return SUBJECT_TYPE_CHECK;
	}
	public void setSUBJECT_TYPE_CHECK(String sUBJECT_TYPE_CHECK) {
		SUBJECT_TYPE_CHECK = sUBJECT_TYPE_CHECK;
	}
	public String getREQUEST_COST() {
		return REQUEST_COST;
	}
	public void setREQUEST_COST(String requestcost) {
		REQUEST_COST = requestcost;
	}
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
	
	
	
	public String getSERVICE_REQUEST_TYPE() {
		return SERVICE_REQUEST_TYPE;
	}
	public void setSERVICE_REQUEST_TYPE(String sERVICE_REQUEST_TYPE) {
		SERVICE_REQUEST_TYPE = sERVICE_REQUEST_TYPE;
	}
	public String getGROUP_NAME() {
		return GROUP_NAME;
	}
	public void setGROUP_NAME(String gROUP_NAME) {
		GROUP_NAME = gROUP_NAME;
	}
	public String getAPPROVAL_LEVEL() {
		return APPROVAL_LEVEL;
	}
	public void setAPPROVAL_LEVEL(String aPPROVAL_LEVEL) {
		APPROVAL_LEVEL = aPPROVAL_LEVEL;
	}
	public String getLEVEL_ONE_DESIGNATION() {
		return LEVEL_ONE_DESIGNATION;
	}
	public void setLEVEL_ONE_DESIGNATION(String lEVEL_ONE_DESIGNATION) {
		LEVEL_ONE_DESIGNATION = lEVEL_ONE_DESIGNATION;
	}
	public String getLEVEL_TWO_DESIGNATION() {
		return LEVEL_TWO_DESIGNATION;
	}
	public void setLEVEL_TWO_DESIGNATION(String lEVEL_TWO_DESIGNATION) {
		LEVEL_TWO_DESIGNATION = lEVEL_TWO_DESIGNATION;
	}
	@Override
	public String toString() {
		return "servicecataloguemaster [SUB_ID=" + SUB_ID + ", COMPANY=" + COMPANY + ", CAT_NAME=" + CAT_NAME
				+ ", SUB_CATEGORY1=" + SUB_CATEGORY1 + ", SUB_CATEGORY2=" + SUB_CATEGORY2 + ", SUBJECT=" + SUBJECT
				+ ", PRIORITY=" + PRIORITY + ", SEVERITY=" + SEVERITY + ", SERVICE_REQUEST_TYPE=" + SERVICE_REQUEST_TYPE
				+ ", GROUP_NAME=" + GROUP_NAME + ", APPROVAL_LEVEL=" + APPROVAL_LEVEL + ", LEVEL_ONE_DESIGNATION="
				+ LEVEL_ONE_DESIGNATION + ", LEVEL_TWO_DESIGNATION=" + LEVEL_TWO_DESIGNATION + ", REQUEST_COST="
				+ REQUEST_COST + ", SUBJECT_TYPE_CHECK=" + SUBJECT_TYPE_CHECK + "]";
	}

	
	

	
	

	
	
	
	
	
	
}
