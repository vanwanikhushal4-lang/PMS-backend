package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectKickOfMeeting")
public class ProjectKickOfMeeting {

	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column
	private int SR_NO;
	private String ProjectHead;
	private String SalesManager;
	private String ProductionManager;
	private String Date;
	private String TypesMeeting;
	private String TypesOfRooms;
	private String RoomCapacity;
	private String MeetingResource;
	private String PersonInMetting;
	private String ResourceInMeeting;
	private String TelephonicMeeting;
	private String VideoConferenceMeeting;
	private String UploadFile1;
	private String UploadFile2;
	private String Status;
	private String GeneratedLink;
	
	private String Po_Number;
	private String UD_number;
	
	public String getUploadFile2() {
		return UploadFile2;
	}
	public void setUploadFile2(String uploadFile2) {
		UploadFile2 = uploadFile2;
	}
	public String getUploadFile1() {
		return UploadFile1;
	}
	public void setUploadFile1(String uploadFile1) {
		this.UploadFile1 = uploadFile1;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getProjectHead() {
		return ProjectHead;
	}
	public void setProjectHead(String projectHead) {
		ProjectHead = projectHead;
	}
	public String getSalesManager() {
		return SalesManager;
	}
	public void setSalesManager(String salesManager) {
		SalesManager = salesManager;
	}
	public String getProductionManager() {
		return ProductionManager;
	}
	public void setProductionManager(String productionManager) {
		ProductionManager = productionManager;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTypesMeeting() {
		return TypesMeeting;
	}
	public void setTypesMeeting(String typesMeeting) {
		TypesMeeting = typesMeeting;
	}
	public String getTypesOfRooms() {
		return TypesOfRooms;
	}
	public void setTypesOfRooms(String typesOfRooms) {
		TypesOfRooms = typesOfRooms;
	}
	public String getRoomCapacity() {
		return RoomCapacity;
	}
	public void setRoomCapacity(String roomCapacity) {
		RoomCapacity = roomCapacity;
	}
	public String getMeetingResource() {
		return MeetingResource;
	}
	public void setMeetingResource(String meetingResource) {
		MeetingResource = meetingResource;
	}
	public String getPersonInMetting() {
		return PersonInMetting;
	}
	public void setPersonInMetting(String personInMetting) {
		PersonInMetting = personInMetting;
	}
	public String getResourceInMeeting() {
		return ResourceInMeeting;
	}
	public void setResourceInMeeting(String resourceInMeeting) {
		ResourceInMeeting = resourceInMeeting;
	}
	public String getTelephonicMeeting() {
		return TelephonicMeeting;
	}
	public void setTelephonicMeeting(String telephonicMeeting) {
		TelephonicMeeting = telephonicMeeting;
	}
	public String getVideoConferenceMeeting() {
		return VideoConferenceMeeting;
	}
	public void setVideoConferenceMeeting(String videoConferenceMeeting) {
		VideoConferenceMeeting = videoConferenceMeeting;
	}
	
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	public String getGeneratedLink() {
		return GeneratedLink;
	}
	public void setGeneratedLink(String generatedLink) {
		GeneratedLink = generatedLink;
	}
	
	
	
	public String getPo_Number() {
		return Po_Number;
	}
	public void setPo_Number(String po_Number) {
		Po_Number = po_Number;
	}
	public String getUD_number() {
		return UD_number;
	}
	public void setUD_number(String uD_number) {
		UD_number = uD_number;
	}
	
	
	@Override
	public String toString() {
		return "ProjectKickOfMeeting [SR_NO=" + SR_NO + ", ProjectHead=" + ProjectHead + ", SalesManager="
				+ SalesManager + ", ProductionManager=" + ProductionManager + ", Date=" + Date + ", TypesMeeting="
				+ TypesMeeting + ", TypesOfRooms=" + TypesOfRooms + ", RoomCapacity=" + RoomCapacity
				+ ", MeetingResource=" + MeetingResource + ", PersonInMetting=" + PersonInMetting
				+ ", ResourceInMeeting=" + ResourceInMeeting + ", TelephonicMeeting=" + TelephonicMeeting
				+ ", VideoConferenceMeeting=" + VideoConferenceMeeting + ", UploadFile1=" + UploadFile1
				+ ", UploadFile2=" + UploadFile2 + ", Status=" + Status + ", GeneratedLink=" + GeneratedLink
				+ ", Po_Number=" + Po_Number + ", UD_number=" + UD_number + "]";
	}
	
	
	
	
	

}
