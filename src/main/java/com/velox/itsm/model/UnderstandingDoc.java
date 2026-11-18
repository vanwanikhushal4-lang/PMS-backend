package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnderstandingDocument")
public class UnderstandingDoc {

	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column
	private int SR_NO;

	

	private String Designation;
	private String Username;
	private String UserID;
	private String Description;
	private String Date;
	private String newRow;
	private String UDStatus;
	private String udFile;
	private String Team_Leader;
	private String Developers;
	private String udNote;
	private String POnumber;
	private String ud_id;
	private String rd_id;
	private String productSuite;
	private String securityTool;
	private String productManager;
	private String FunctionName;
	private String rdNote;
	private String rdFile;
	private String maskedPOFile;
	
	private String ScopeWork_File;
	private String RFP_File;
	private String Other_File;
	
	private String projectDesc;
	private String projectObj;
	private String project_Scope;
	private String function_Requirement;
	private String nonFunction_Requirement;
	private String technical_Requirement;
	private String project_startDate;
	private String project_endDate;
	
	private String rejectMDReason;
	private String rejectedMDDate;
	private String rejectedByMD;
	
	private String Other_UDFile;
	
	
	
	
	
	public String getOther_UDFile() {
		return Other_UDFile;
	}
	public void setOther_UDFile(String other_UDFile) {
		Other_UDFile = other_UDFile;
	}
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
	public String getRejectMDReason() {
		return rejectMDReason;
	}
	public void setRejectMDReason(String rejectMDReason) {
		this.rejectMDReason = rejectMDReason;
	}
	public String getRejectedMDDate() {
		return rejectedMDDate;
	}
	public void setRejectedMDDate(String rejectedMDDate) {
		this.rejectedMDDate = rejectedMDDate;
	}
	public String getRejectedByMD() {
		return rejectedByMD;
	}
	public void setRejectedByMD(String rejectedByMD) {
		this.rejectedByMD = rejectedByMD;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getProjectObj() {
		return projectObj;
	}
	public void setProjectObj(String projectObj) {
		this.projectObj = projectObj;
	}
	public String getProject_Scope() {
		return project_Scope;
	}
	public void setProject_Scope(String project_Scope) {
		this.project_Scope = project_Scope;
	}
	public String getFunction_Requirement() {
		return function_Requirement;
	}
	public void setFunction_Requirement(String function_Requirement) {
		this.function_Requirement = function_Requirement;
	}
	public String getNonFunction_Requirement() {
		return nonFunction_Requirement;
	}
	public void setNonFunction_Requirement(String nonFunction_Requirement) {
		this.nonFunction_Requirement = nonFunction_Requirement;
	}
	public String getTechnical_Requirement() {
		return technical_Requirement;
	}
	public void setTechnical_Requirement(String technical_Requirement) {
		this.technical_Requirement = technical_Requirement;
	}
	public String getProject_startDate() {
		return project_startDate;
	}
	public void setProject_startDate(String project_startDate) {
		this.project_startDate = project_startDate;
	}
	public String getProject_endDate() {
		return project_endDate;
	}
	public void setProject_endDate(String project_endDate) {
		this.project_endDate = project_endDate;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getNewRow() {
		return newRow;
	}
	public void setNewRow(String newRow) {
		this.newRow = newRow;
	}
	public String getUDStatus() {
		return UDStatus;
	}
	public void setUDStatus(String uDStatus) {
		UDStatus = uDStatus;
	}
	public String getUdFile() {
		return udFile;
	}
	public void setUdFile(String udFile) {
		this.udFile = udFile;
	}
	public String getTeam_Leader() {
		return Team_Leader;
	}
	public void setTeam_Leader(String team_Leader) {
		Team_Leader = team_Leader;
	}
	public String getDevelopers() {
		return Developers;
	}
	public void setDevelopers(String developers) {
		Developers = developers;
	}
	public String getUdNote() {
		return udNote;
	}
	public void setUdNote(String udNote) {
		this.udNote = udNote;
	}
	public String getPOnumber() {
		return POnumber;
	}
	public void setPOnumber(String pOnumber) {
		POnumber = pOnumber;
	}
	public String getUd_id() {
		return ud_id;
	}
	public void setUd_id(String ud_id) {
		this.ud_id = ud_id;
	}
	public String getRd_id() {
		return rd_id;
	}
	public void setRd_id(String rd_id) {
		this.rd_id = rd_id;
	}
	public String getProductSuite() {
		return productSuite;
	}
	public void setProductSuite(String productSuite) {
		this.productSuite = productSuite;
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
	public String getFunctionName() {
		return FunctionName;
	}
	public void setFunctionName(String functionName) {
		FunctionName = functionName;
	}
	public String getRdNote() {
		return rdNote;
	}
	public void setRdNote(String rdNote) {
		this.rdNote = rdNote;
	}
	public String getRdFile() {
		return rdFile;
	}
	public void setRdFile(String rdFile) {
		this.rdFile = rdFile;
	}
	public String getMaskedPOFile() {
		return maskedPOFile;
	}
	public void setMaskedPOFile(String maskedPOFile) {
		this.maskedPOFile = maskedPOFile;
	}
	@Override
	public String toString() {
		return "UnderstandingDoc [SR_NO=" + SR_NO + ", Designation=" + Designation + ", Username=" + Username
				+ ", UserID=" + UserID + ", Description=" + Description + ", Date=" + Date + ", newRow=" + newRow
				+ ", UDStatus=" + UDStatus + ", udFile=" + udFile + ", Team_Leader=" + Team_Leader + ", Developers="
				+ Developers + ", udNote=" + udNote + ", POnumber=" + POnumber + ", ud_id=" + ud_id + ", rd_id=" + rd_id
				+ ", productSuite=" + productSuite + ", securityTool=" + securityTool + ", productManager="
				+ productManager + ", FunctionName=" + FunctionName + ", rdNote=" + rdNote + ", rdFile=" + rdFile
				+ ", maskedPOFile=" + maskedPOFile + ", ScopeWork_File=" + ScopeWork_File + ", RFP_File=" + RFP_File
				+ ", Other_File=" + Other_File + ", projectDesc=" + projectDesc + ", projectObj=" + projectObj
				+ ", project_Scope=" + project_Scope + ", function_Requirement=" + function_Requirement
				+ ", nonFunction_Requirement=" + nonFunction_Requirement + ", technical_Requirement="
				+ technical_Requirement + ", project_startDate=" + project_startDate + ", project_endDate="
				+ project_endDate + ", rejectMDReason=" + rejectMDReason + ", rejectedMDDate=" + rejectedMDDate
				+ ", rejectedByMD=" + rejectedByMD + ", Other_UDFile=" + Other_UDFile + "]";
	}
	
	
	

}	