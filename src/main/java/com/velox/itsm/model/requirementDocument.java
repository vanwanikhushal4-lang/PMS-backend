package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirementDocument")
public class requirementDocument {

	
	@Id
	@Column
	private int SR_NO;
	
	private String FunctionName;
	private String Designation;
	private String UserName;
	private String UserId;
	private String Description;
	private String addrowdetails;
	private String RDStatus;
	private String rdUpload;
	private String rd_id;
	private String maskedPOfile;
	private String productSuitName;
	private String securityTool;
	private String productManager;
	private String POnumber;
	private String rdNote;
	private String Date;
	private String ScopeWork_File;
	private String RFP_File;
	private String Other_File;
	
	
	
	public String getScopeWork_File() {
		return ScopeWork_File;
	}
	public void setScopeWork_File(String scopeWork_File) {
		ScopeWork_File = scopeWork_File;
	}
	public String getRFP_File() {
		return RFP_File;
	}
	public void setRFP_File(String rFP_File) {
		RFP_File = rFP_File;
	}
	public String getOther_File() {
		return Other_File;
	}
	public void setOther_File(String other_File) {
		Other_File = other_File;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getRd_id() {
		return rd_id;
	}
	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}
	public String getMaskedPOfile() {
		return maskedPOfile;
	}
	public void setMaskedPOfile(String maskedPOfile) {
		this.maskedPOfile = maskedPOfile;
	}
	public String getProductSuitName() {
		return productSuitName;
	}
	public void setProductSuitName(String productSuitName) {
		this.productSuitName = productSuitName;
	}
	public String getSecurityTool() {
		return securityTool;
	}
	public void setSecurityTool(String securityTool) {
		this.securityTool = securityTool;
	}
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public String getPOnumber() {
		return POnumber;
	}
	public void setPOnumber(String pOnumber) {
		POnumber = pOnumber;
	}
	public String getRdNote() {
		return rdNote;
	}
	public void setRdNote(String rdNote) {
		this.rdNote = rdNote;
	}
	public String getRdUpload() {
		return rdUpload;
	}
	public void setRdUpload(String rdUpload) {
		this.rdUpload = rdUpload;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getFunctionName() {
		return FunctionName;
	}
	public void setFunctionName(String functionName) {
		FunctionName = functionName;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAddrowdetails() {
		return addrowdetails;
	}
	public void setAddrowdetails(String addrowdetails) {
		this.addrowdetails = addrowdetails;
	}
	
	
	public String getRDStatus() {
		return RDStatus;
	}
	public void setRDStatus(String rDStatus) {
		RDStatus = rDStatus;
	}
	@Override
	public String toString() {
		return "requirementDocument [SR_NO=" + SR_NO + ", FunctionName=" + FunctionName + ", Designation=" + Designation
				+ ", UserName=" + UserName + ", UserId=" + UserId + ", Description=" + Description + ", addrowdetails="
				+ addrowdetails + ", RDStatus=" + RDStatus + ", rdUpload=" + rdUpload + ", rd_id=" + rd_id
				+ ", maskedPOfile=" + maskedPOfile + ", productSuitName=" + productSuitName + ", securityTool="
				+ securityTool + ", productManager=" + productManager + ", POnumber=" + POnumber + ", rdNote=" + rdNote
				+ ", Date=" + Date + ", ScopeWork_File=" + ScopeWork_File + ", RFP_File=" + RFP_File + ", Other_File="
				+ Other_File + "]";
	}
	
	
	
	
	
	
}
