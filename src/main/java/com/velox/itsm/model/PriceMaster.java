package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PriceMaster {

	
	
	private static final long serialVersionUID = -2469894830441779556L;

	@Id
	@Column(name = "Id")
	private int Id;
	
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String PRODUCT_SUIT;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String PRODUCT_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String PRICE_TYPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String CLOUD_TYPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String APEXMODE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
    private String CAPEXMODE;

	@Column(columnDefinition = "NVARCHAR(500)")
    private String PREPECTUAL;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String SUBSCRIPTIONTYPE;
    
    @Column(columnDefinition = "NVARCHAR(500)")
    private String LICENTYPE;
    
    @Column(columnDefinition = "NVARCHAR(500)")
    private String AMCPRICE;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String AMCTOTAL;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPRODUCT_SUIT() {
		return PRODUCT_SUIT;
	}

	public void setPRODUCT_SUIT(String pRODUCT_SUIT) {
		PRODUCT_SUIT = pRODUCT_SUIT;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getPRICE_TYPE() {
		return PRICE_TYPE;
	}

	public void setPRICE_TYPE(String pRICE_TYPE) {
		PRICE_TYPE = pRICE_TYPE;
	}

	public String getCLOUD_TYPE() {
		return CLOUD_TYPE;
	}

	public void setCLOUD_TYPE(String cLOUD_TYPE) {
		CLOUD_TYPE = cLOUD_TYPE;
	}

	public String getAPEXMODE() {
		return APEXMODE;
	}

	public void setAPEXMODE(String aPEXMODE) {
		APEXMODE = aPEXMODE;
	}

	public String getCAPEXMODE() {
		return CAPEXMODE;
	}

	public void setCAPEXMODE(String cAPEXMODE) {
		CAPEXMODE = cAPEXMODE;
	}

	public String getPREPECTUAL() {
		return PREPECTUAL;
	}

	public void setPREPECTUAL(String pREPECTUAL) {
		PREPECTUAL = pREPECTUAL;
	}

	public String getSUBSCRIPTIONTYPE() {
		return SUBSCRIPTIONTYPE;
	}

	public void setSUBSCRIPTIONTYPE(String sUBSCRIPTIONTYPE) {
		SUBSCRIPTIONTYPE = sUBSCRIPTIONTYPE;
	}

	public String getLICENTYPE() {
		return LICENTYPE;
	}

	public void setLICENTYPE(String lICENTYPE) {
		LICENTYPE = lICENTYPE;
	}

	public String getAMCPRICE() {
		return AMCPRICE;
	}

	public void setAMCPRICE(String aMCPRICE) {
		AMCPRICE = aMCPRICE;
	}

	public String getAMCTOTAL() {
		return AMCTOTAL;
	}

	public void setAMCTOTAL(String aMCTOTAL) {
		AMCTOTAL = aMCTOTAL;
	}

	@Override
	public String toString() {
		return "PriceMaster [Id=" + Id + ", PRODUCT_SUIT=" + PRODUCT_SUIT + ", PRODUCT_NAME=" + PRODUCT_NAME
				+ ", PRICE_TYPE=" + PRICE_TYPE + ", CLOUD_TYPE=" + CLOUD_TYPE + ", APEXMODE=" + APEXMODE
				+ ", CAPEXMODE=" + CAPEXMODE + ", PREPECTUAL=" + PREPECTUAL + ", SUBSCRIPTIONTYPE=" + SUBSCRIPTIONTYPE
				+ ", LICENTYPE=" + LICENTYPE + ", AMCPRICE=" + AMCPRICE + ", AMCTOTAL=" + AMCTOTAL + "]";
	}


	
	

}
