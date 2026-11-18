package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface EFormService {

	public JSONArray getPID();
	public JSONArray ApprovalGroup(String pid);
	public JSONArray getUserSelectedDetails(String approvalname);
	public JSONArray getProejctDetails(String pid);
	public JSONArray getProjectDetailsById(String pid);
	public JSONArray getItGroupUser();
	public String insertSoftwareRequest(String fullname, String compname, String site, String department,
			String phone, String emailid, MultipartFile empPic, String pid, String itcompgroup, String approup,
			String dummy1, String dummy, String dumm2, Boolean assetCheck, String asset_Ipaddress, String aname, String atag, String astatus, String acategory, String asset_sub_category, String typecategory, String assetname, String ip, String st, String ipaddress, String ownername, String serverHostOrAssetCode);
	public JSONArray getPendingSoftwareReqauest();
	public JSONArray gatherSoftwareDetails(String id);
	public JSONArray GetSoftwareDetails(String pid);
	public String InsertRequestApprovedByItCompliance(String appByITComp, String status, String approvenote,
			String requestcategory, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String cost, String dummy, String rperiod, String licensekey);
	public JSONArray getPendingToApproveRequestByManager();
	public String InsertRequestApprovedByMAnager(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
	public JSONArray getPendingSoftwareReqauestInTc();
	
	public  JSONArray gatherSoftwareRequestDetails(String ticketid) ;
	public String InsertRequestApprovedByRemotSupport(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory);
	public JSONArray getUserRequestList();
	public JSONArray getRequestActivityLog(String ticketid, String type);
	public JSONArray getRequestID(String requestype);
	public JSONArray getUserRequestTracking(String ticketId, String reqType);
	public JSONArray getSoftwares();
	public String closeSoftwareRequestRequest(String ticketid, String closereason);
	public String closeSoftwareRequestTransfer(String ticketid,String closereason);
	public String RequestReopenResolvedTicket(String ticketid, String reopenreason, MultipartFile reopenPic);
	public JSONArray getWorkInProgressInTc();
	public JSONArray getLoginUserSoftwares();
	public String insertSoftwareRelease(String pid,String fullname,String approup, String compname, String site, String department, String phone,
			String emailid, MultipartFile empPic, String softwarename, String cost, String description,
			String asset_Ipaddress, String aname, String atag, String astatus, String acategory,
			String asset_sub_category, String server_IP, String server_ownername, String server_hostname);
	public JSONArray getUserReleaseRequestList();
	public JSONArray gatherSoftwareReleaseDetails(String id, String type);
	public JSONArray getPendingSoftwareRelease();
	public JSONArray getReleaseActivityLog(String ticketid);
	public JSONArray gatherSoftwareReleaseDetailsToApp(String id);
	public String InsertReleaseRequestAppByItCompliance(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String phone, String emailid, String pid, String request_category);
	public JSONArray getReleaseSoftwareInTc();
	public JSONArray getPendingSoftwareReqauestInEng();
	public JSONArray getWorkInProgressInEng();
	public String InsertReleseRequestByRemotSupport(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese,String requestcatassign);
	public JSONArray getPendingSoftwareReqauestforMailAdmin();
	public String InsertRequestApprovedByMailAdmin(String appByITComp, String status, String approvenote,
			String requestcategory, MultipartFile empPic, String softwarename, String companyRaisedBy,
			String raisedByName, String ticketid);
	public String insertSoftwareTransferRequest(String fullname, String compname, String site, String department,
			String phone, String emailid, MultipartFile empPic, String pid, String approup, String softwarename,
			String approup2, String appliedDate, String assetCode, String actionType, String toEmployee,
			String newassetCode, String currentDate, String asset_Ipaddress, String aname,
			String atag, String astatus, String acategory, String asset_sub_category, String description,
			String assetname, String compName, String from_asset);
	public JSONArray getPendingToApproveTransferRequestByManager();
	public JSONArray gatherTransferSoftwareDetails(String id);
	public String InsertTransferRequestApprovedByManager(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String softwarename, String companyRaisedBy, String ticketAssignst, String reqcat, String temployee
			);
	public JSONArray getPendingTransferReqauest();
	public JSONArray gatherTransferViewDetails(String id);
	public String InsertTransferRequestByItCompliance(String appByITComp, String status, String approvenote,
			String requestcategory, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String licensekey, String reqcat);
	
public JSONArray getUserTransferList();
	
	public JSONArray getPendingSoftwareTransferInTc();
	public String InsertTransferRequestApprovedByRemotSupport(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory);
	
	public JSONArray getWorkInProgressTransferInTc();
	public String InsertTransferRequestApprovedByRT(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory);
	public JSONArray getNTReleaseSoftwareInTc(String listingType);
	public String getSoftwareReleaseTicket(String softwareName, String reqType);
	public String closeReleaseRequestRequest(String ticketid, String closereason);
	public JSONArray getPendingServerSoftwareTransferInTc();
	
	public String InsertServerTransferRequestApprovedByNTAdmin(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory);
	public String InsertTransferRequestApprovedByNT(String appByITComp, String status, String approvenote, String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename, String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory);
	public JSONArray getWorkInProgressServerTransferInTc();
	public String InsertReleseRequestForResolution(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese, String requestcatassign);
	public JSONArray getReleaseSoftwareInTcForResolution();
	public String InsertReleseRequestByRemotSupportForResolve(String name, String companyname, String nameid,
			String reqid, String statusR, String note, MultipartFile empPic, String emailid, String pid,
			String companyRaisedBy, String raisedByName, String appByITComp, String softwarenamerelese,
			String requestcatassign);
	public String InsertTransferRequestApprovedBy2ndManager(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String companyRaisedBy, String raisedByName, String ticketidupdateTDassign,
			String reqcat, String temployee);
	public JSONArray GetSoftwareDetailOfLoginUser(String sname);
	
	
	
	//Busniess Request
	
	//Busniess Request
	
		public String insertBusinessRequest(String fullname,String compname,String site,String department,String phone,String emailid,String pid,String approup,String requestfor,String domain,String description,String rperiod,String typecategory,String newDate,MultipartFile empPic);
		
		public JSONArray getUserBusinessRequestList();
		
		public  JSONArray gatherBusinessRequestDetails(String ticketid);
		
		public JSONArray getBusinessRequestActivityLog(String ticketid);
		
		public JSONArray getBusinessRequestID(String requestype);
		
		public JSONArray getUserBusinessRequestTracking(String ticketid, String requesttype);
		
		public JSONArray getUserBusinessRaisedRequest(); //String ticketlist
		
		public  JSONArray gatherBusinesRequestRequestDetails(String ticketid) ;
		
		public JSONArray gatherBusinessActionDetails(String id);
		
		public String InsertBusinessRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
		
		public JSONArray getBusinessTicketRequestActivityLog(String ticketid);
		
		// Gal Update  Flow
		
		// show List
		
		public JSONArray getGalUpdateBusinessRequest();
		
		// insert galUpdate
		public String InsertBusinessRequestApprovedByGalUpdate(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
		
		// mail admin
		
		// show list
		public JSONArray getMailAdminBusinessRequest();
		
		// insert mail admin
		public String InsertBusinessRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
		
		public JSONArray getMailAdminBucket();
		
		// close Request 
		public String closeBusinessResolvedRequest(String ticketid, String closereason);
		
		//reopen
		public String RequestReopenResolvedBusinessTicket(String ticketid, String reopenreason, MultipartFile reopenPic);
		
		
		
		
		//get reopen ticket detail
		public  JSONArray getBusinessReopenRequestDetails(String ticketid) ;
		public JSONArray getReleasePendingToApproveRequestByManager();
		public JSONArray AssignSoftwareReleaseDetails(String id);
		public String InsertReleaseApprovedByMAnager(String appByITComp, String status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String softwarename, String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
		public JSONArray getReleasePendingToApproveRequestByITCompliance();
		public String SoftwareTransferReopenResolvedTicket(String raisedByName, String tid, String reopenreason,
				MultipartFile reopenPic);
		public JSONArray getSoftwaredetailsList();

		//END BusinEss ID 
		
		// SMTP Flow Start
		
		public JSONArray getUserSelectedDetails(String approvalname, String fullName);

		public String insertSoftwareRequest(String fullname, String compname, String site,
				String department, String phone, String emailid, String pid, String approup, String appserver,
				String appserverIp, String applicationServerloc, String servercityname, String noOfMail, String mailsize,
				String description, String expDate, MultipartFile empPic);
		public JSONArray getSMTPRequestList();
		public JSONArray gatherSMTPRequestDetails(String ticketid);
		public JSONArray getSMTPRequestActivityLog(String ticketid);
		public JSONArray getSMTPRequestID();
		public JSONArray getUserSMTPRequestTracking(String ticketid);
		public JSONArray getUserSMTPRaisedRequest();
		public JSONArray getSMTPPendingApprovalDetails(String ticketid);
		public JSONArray getSMTPPendingTicketRequestActivityLog(String ticketid);
		public JSONArray SMTPPendingActionDetails(String id);
		public String InsertSMTPRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
		
		// insert mail admin
		
		public JSONArray getMailAdminSMTPRequest();
		
			public String InsertSMTPRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
					String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
					String companyRaisedBy, String raisedByName, String ticketidupdateTDassign);
			
			public JSONArray getMailAdminSMTPBucket();
			
			// close Request 
			public String closeSMTPResolvedRequest(String ticketid, String closereason);
			
			//reopen
			
			public String RequestReopenResolvedSMTPTicket(String ticketid, String reopenreason, MultipartFile reopenPic);
			
			//get reopen ticket detail
			
			public  JSONArray getSMTPReopenRequestDetails(String ticketid) ;
			
			//mailadmin view ticket
			
			public  JSONArray gatherSMTPRequestRequestDetails(String ticketid) ;
			
			// Activity Log
			
			public JSONArray getSMTPActivityTicketRequestActivityLog(String ticketid);
		
		
		// SMTP Flow End
	
	
}
