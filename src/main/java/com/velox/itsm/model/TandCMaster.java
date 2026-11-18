package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TandCMaster")
public class TandCMaster {
	  
	  private static final long serialVersionUID = -1722684944868971448L;
	  @Id
	  @Column
	  private int SR_NO;
	   
	  @Column(name = "TandC_Type", columnDefinition = "NVARCHAR(500)")
	  private String TandC_Type;

	  @Column(name = "Description", columnDefinition = "NVARCHAR(500)")
	  private String Description;

	  @Column(name = " ADD_Description_RoW", columnDefinition = "NVARCHAR(500)")
	  private String ADD_Description_RoW;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getTandC_Type() {
		return TandC_Type;
	}

	public void setTandC_Type(String tandC_Type) {
		TandC_Type = tandC_Type;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getADD_Description_RoW() {
		return ADD_Description_RoW;
	}

	public void setADD_Description_RoW(String aDD_Description_RoW) {
		ADD_Description_RoW = aDD_Description_RoW;
	}

	@Override
	public String toString() {
		return "TandCMaster [SR_NO=" + SR_NO + ", TandC_Type=" + TandC_Type + ", Description=" + Description
				+ ", ADD_Description_RoW=" + ADD_Description_RoW + "]";
	}

	 

	
	 
	  
}
