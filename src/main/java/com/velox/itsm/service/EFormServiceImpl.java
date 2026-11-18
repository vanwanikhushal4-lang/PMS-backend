package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.dao.EFormDao;

@Service("/EForm")
public class EFormServiceImpl implements EFormService{

	@Autowired 
	EFormDao eFormDao;
	@Override
	public JSONArray getPID() {
		return eFormDao.getPID();
		}
	@Override
	public JSONArray ApprovalGroup(String pid) {
		return eFormDao.ApprovalGroup(pid);
	}

	@Override
	public JSONArray getUserSelectedDetails(String approvalname) {
		// TODO Auto-generated method stub
		return eFormDao.getUserSelectedDetails(approvalname);
	}

	@Override
	public JSONArray getProejctDetails(String pid) {
		// TODO Auto-generated method stub
		return eFormDao.getProejctDetails(pid);
	}

	@Override
	public JSONArray getProjectDetailsById(String pid) {
		return eFormDao.getProjectDetailsById(pid);
	}

	@Override
	public JSONArray getItGroupUser() {
		// TODO Auto-generated method stub
		return eFormDao.getItGroupUser();
	}

//	@Override
//	public String insertSoftwareRequest(String fullname, String compname, String site, String department,
//			String phone, String emailid, MultipartFile empPic, String pid, String itcompgroup, String approup,
//			String dummy1, String dummy, String dumm2, Boolean assetCheck, String asset_Ipaddress, String aname, String atag, String astatus, String acategory, String asset_sub_category) {
//		return eFormDao.insertSoftwareRequest(fullname, compname, site,  department, phone, emailid, empPic, pid, itcompgroup,approup,dummy1,dummy,dumm2,assetCheck,asset_Ipaddress,aname,atag,astatus,acategory,asset_sub_category);
//	}

	@Override
	public JSONArray getPendingSoftwareReqauest() {
		return eFormDao.getPendingSoftwareReqauest();
		
	}

	@Override
	public JSONArray gatherSoftwareDetails(String id) {
		// TODO Auto-generated method stub
		return eFormDao.gatherSoftwareDetails(id);
	}

	@Override
	public JSONArray GetSoftwareDetails(String pid) {
		// TODO Auto-generated method stub
		return eFormDao.GetSoftwareDetails(pid);
	}

	@Override
	public String InsertRequestApprovedByItCompliance(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String cost, String dummy, String rperiod,String licensekey) {
		// TODO Auto-generated method stub
		return eFormDao.InsertRequestApprovedByItCompliance(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,cost,dummy,rperiod, licensekey);
	}

	@Override
	public JSONArray getPendingToApproveRequestByManager() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingToApproveRequestByManager();
		
	}

	@Override
	public String InsertRequestApprovedByMAnager(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign) {
		return eFormDao.InsertRequestApprovedByMAnager(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign);
	}

	@Override
	public JSONArray getPendingSoftwareReqauestInTc() {
		return eFormDao.getPendingSoftwareReqauestInTc();
	}

	@Override
	public JSONArray gatherSoftwareRequestDetails(String ticketid) {
		return eFormDao.gatherSoftwareRequestDetails(ticketid);
	}

	@Override
	public String InsertRequestApprovedByRemotSupport(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign,String requestCartegory) {
		return eFormDao.InsertRequestApprovedByRemotSupport(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,requestCartegory);
	}

	@Override
	public JSONArray getUserRequestList() {
		// TODO Auto-generated method stub
		return eFormDao.getUserRequestList();
	}

	@Override
	public JSONArray getRequestActivityLog(String ticketid,String Type) {
		// TODO Auto-generated method stub
		return eFormDao.getRequestActivityLog(ticketid,Type);
	}

	@Override
	public JSONArray getRequestID(String requestType) {
		// TODO Auto-generated method stub
		return eFormDao.getRequestID(requestType);
	}

	@Override
	public JSONArray getUserRequestTracking(String ticketId,String reqType) {
		return eFormDao.getUserRequestTracking(ticketId,reqType);
	}

	@Override
	public JSONArray getSoftwares() {
		return eFormDao.getSoftwares();
	}

	@Override
	public String closeSoftwareRequestRequest(String ticketid, String closereason) {
		// TODO Auto-generated method stub
		return eFormDao.closeSoftwareRequestRequest(ticketid,closereason);
	}

	@Override
	public String RequestReopenResolvedTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
		// TODO Auto-generated method stub
		return eFormDao.RequestReopenResolvedTicket(ticketid,reopenreason,reopenPic);
	}

	@Override
	public JSONArray getWorkInProgressInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getWorkInProgressInTc();
	}

	@Override
	public JSONArray getLoginUserSoftwares() {
		return eFormDao.getLoginUserSoftwares();
	}

//	@Override
//	public String insertSoftwareRelease(String fullname, String compname, String site, String department, String phone,
//			String emailid, MultipartFile empPic, String softwarename, String cost, String description,
//			String asset_Ipaddress, String aname, String atag, String astatus, String acategory,
//			String asset_sub_category) {
//		// TODO Auto-generated method stub
//		return eFormDao.insertSoftwareRelease(fullname, compname, site,  department, phone, emailid, empPic, softwarename,cost,description,asset_Ipaddress,aname,atag,astatus,acategory,asset_sub_category);
//	}

	@Override
	public JSONArray getUserReleaseRequestList() {
		// TODO Auto-generated method stub
		return eFormDao.getUserReleaseRequestList();
	}

	@Override
	public JSONArray gatherSoftwareReleaseDetails(String id,String type) {
		// TODO Auto-generated method stub
		return eFormDao.gatherSoftwareReleaseDetails(id,type);
	}

	@Override
	public JSONArray getPendingSoftwareRelease() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingSoftwareRelease();
	}

	@Override
	public JSONArray getReleaseActivityLog(String ticketid) {
		// TODO Auto-generated method stub
		return eFormDao.getReleaseActivityLog(ticketid);
	}

	@Override
	public JSONArray gatherSoftwareReleaseDetailsToApp(String id) {
		return eFormDao.gatherSoftwareReleaseDetailsToApp(id);
	}

	@Override
	public String InsertReleaseRequestAppByItCompliance(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String companyRaisedBy, String RaisedByName, String ticketidupdateTDassign,String Request_category) {
		
		return eFormDao.InsertReleaseRequestAppByItCompliance(appByITComp, status, approvenote,empPic,companyRaisedBy,RaisedByName,ticketidupdateTDassign,Request_category);
	}

	@Override
	public JSONArray getReleaseSoftwareInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getReleaseSoftwareInTc();
	}

	@Override
	public String insertSoftwareRequest(String fullname, String compname, String site, String department, String phone,
			String emailid, MultipartFile empPic, String pid, String itcompgroup, String approup, String dummy1,
			String dummy, String dumm2, Boolean assetCheck, String asset_Ipaddress, String aname, String atag,
			String astatus, String acategory, String asset_sub_category, String typecategory, String assetname,
			String ip, String st, String ipaddress, String ownername,String ServerhostOrCOde) {
		// TODO Auto-generated method stub
		return eFormDao.insertSoftwareRequest(fullname, compname, site, department, phone, emailid, empPic, pid, itcompgroup, approup, dummy1, dummy, dumm2, assetCheck, asset_Ipaddress, aname, atag, astatus, acategory, asset_sub_category,typecategory,assetname, ip, st  ,ipaddress ,ownername,ServerhostOrCOde);
	}

	@Override
	public JSONArray getPendingSoftwareReqauestInEng() {
	
		return eFormDao.getPendingSoftwareReqauestInEng();
	}

	@Override
	public JSONArray getWorkInProgressInEng() {
		// TODO Auto-generated method stub
		return eFormDao.getWorkInProgressInEng();
	}

	@Override
	public String InsertReleseRequestByRemotSupport(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese,String requestcatassign) {
		// TODO Auto-generated method stub
		return eFormDao.InsertReleseRequestByRemotSupport(name,companyname,nameid,reqid,statusR,note, empPic,emailid,pid,companyRaisedBy,raisedByName,appByITComp,softwarenamerelese,requestcatassign);

	}

	@Override
	public JSONArray getPendingSoftwareReqauestforMailAdmin() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingSoftwareReqauestforMailAdmin();
	}

	@Override
	public String InsertRequestApprovedByMailAdmin(String appByITComp, String status, String approvenote,
			String requestcategory, MultipartFile empPic, String softwarename, String companyRaisedBy,
			String raisedByName, String ticketid) {
		// TODO Auto-generated method stub
		return eFormDao.InsertRequestApprovedByMailAdmin(appByITComp, status, approvenote,requestcategory,empPic,softwarename,companyRaisedBy,raisedByName,ticketid);
	}

	@Override
	public String insertSoftwareTransferRequest(String fullname, String compname, String site, String department,
			String phone, String emailid, MultipartFile empPic, String pid, String approup, String softwarename,
			String approup2, String appliedDate, String assetCode, String actionType, String toEmployee,
			String newassetCode, String currentDate, String  typecategory, String description,
			String assetname, String ip, String st, String ipaddress, String ownername,String hostnme,String compName,String from_asset) {
		// TODO Auto-generated method stub
		return eFormDao.insertSoftwareTransferRequest(fullname, compname, site,  department, phone,
        		emailid, empPic, pid,approup, softwarename,approup,appliedDate,assetCode,actionType,
        		toEmployee,newassetCode,currentDate,typecategory,description,assetname, ip, st  ,ipaddress ,ownername,hostnme,compName,from_asset);
	}

	@Override
	public JSONArray getPendingToApproveTransferRequestByManager() {
	
		return eFormDao.getPendingToApproveTransferRequestByManager();
	}

	@Override
	public JSONArray gatherTransferSoftwareDetails(String id) {
		// TODO Auto-generated method stub
		return eFormDao.gatherTransferSoftwareDetails(id);
	}
	@Override
	public String InsertTransferRequestApprovedByManager(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String softwarename, String companyRaisedBy, String raisedByName
	,String reqcat,String temployee) {
		// TODO Auto-generated method stub
		return eFormDao.InsertTransferRequestApprovedByManager(appByITComp, status, approvenote,empPic, softwarename,companyRaisedBy,raisedByName,reqcat,temployee);
	}
	@Override
	public JSONArray getPendingTransferReqauest() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingTransferReqauest();
	}
	@Override
	public JSONArray gatherTransferViewDetails(String id) {
		// TODO Auto-generated method stub
		return eFormDao.gatherTransferViewDetails(id);
	}
	@Override
	public String InsertTransferRequestByItCompliance(String appByITComp, String status, String approvenote,
			String requestcategory, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String licensekey,String reqcat) {
		// TODO Auto-generated method stub
		return eFormDao.InsertTransferRequestByItCompliance(appByITComp, status, approvenote,requestcategory,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,licensekey,reqcat);
	}

	@Override
	public JSONArray getUserTransferList() {
		// TODO Auto-generated method stub
		return eFormDao.getUserTransferList();
	}
	@Override
	public JSONArray getPendingSoftwareTransferInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingSoftwareTransferInTc();
	}
	
	@Override
	public String InsertTransferRequestApprovedByRemotSupport(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory) {
		// TODO Auto-generated method stub
		return eFormDao.InsertTransferRequestApprovedByRemotSupport(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,requestCartegory);
	}
	@Override
	public JSONArray getWorkInProgressTransferInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getWorkInProgressTransferInTc();
	}
	@Override
	public String InsertTransferRequestApprovedByRT(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory) {
		// TODO Auto-generated method stub
		return eFormDao.InsertTransferRequestApprovedByRT(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,requestCartegory);
	}
	@Override
	public String closeSoftwareRequestTransfer(String ticketid, String closereason) {
		// TODO Auto-generated method stub
		return eFormDao.closeSoftwareRequestTransfer(ticketid,closereason);
	}
	@Override
	public String insertSoftwareRelease(String pid,String approup,String fullname, String compname, String site, String department, String phone,
			String emailid, MultipartFile empPic, String softwarename, String applieddate, String description,
			String assetcode, String typecategory, String AssetCodeDL, String Ip_AddressDL, String StatusDL,
			String computerNameDL, String server_IP, String server_ownername, String server_hostname) {
		// TODO Auto-generated method stub
		return eFormDao.insertSoftwareRelease(pid,approup,fullname, compname, site,  department, phone, emailid,
				empPic, softwarename,applieddate,description,assetcode,typecategory ,
				AssetCodeDL,Ip_AddressDL,StatusDL,computerNameDL,server_IP,server_ownername,server_hostname);
	}
	@Override
	public JSONArray getNTReleaseSoftwareInTc(String listingType) {
		
		return eFormDao.getNTReleaseSoftwareInTc(listingType);
	}
	@Override
	public String getSoftwareReleaseTicket(String softwareName,String reqType ) {
		// TODO Auto-generated method stub
		return eFormDao.getSoftwareReleaseTicket(softwareName,reqType);
	}
	@Override
	public String closeReleaseRequestRequest(String ticketid, String closereason) {
		// TODO Auto-generated method stub
		return eFormDao.closeReleaseRequestRequest(ticketid,closereason);
	}
	@Override
	public JSONArray getPendingServerSoftwareTransferInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getPendingServerSoftwareTransferInTc();
	}
	@Override
	public String InsertServerTransferRequestApprovedByNTAdmin(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory) {
		
		return eFormDao.InsertServerTransferRequestApprovedByNTAdmin(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,requestCartegory);
	}
	@Override
	public String InsertTransferRequestApprovedByNT(String appByITComp, String status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign, String requestCartegory) {
		
		return eFormDao.InsertTransferRequestApprovedByNT(appByITComp, status, approvenote,approvalName,empPic,phone, emailid, pid, softwarename,companyRaisedBy,raisedByName,ticketidupdateTDassign,requestCartegory);
	}
	@Override
	public JSONArray getWorkInProgressServerTransferInTc() {
		// TODO Auto-generated method stub
		return eFormDao.getWorkInProgressServerTransferInTc();
	}
	@Override
	public String InsertReleseRequestForResolution(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese, String requestcatassign) {
		// TODO Auto-generated method stub
		return eFormDao.InsertReleseRequestForResolution(name,companyname,nameid,reqid,statusR,note, empPic,emailid,pid,companyRaisedBy,raisedByName,appByITComp,softwarenamerelese,requestcatassign);
	}
	@Override
	public JSONArray getReleaseSoftwareInTcForResolution() {
		// TODO Auto-generated method stub
		return eFormDao.getReleaseSoftwareInTcForResolution();
	}
	@Override
	public String InsertReleseRequestByRemotSupportForResolve(String name, String companyname, String nameid,
			String reqid, String statusR, String note, MultipartFile empPic, String emailid, String pid,
			String companyRaisedBy, String raisedByName, String appByITComp, String softwarenamerelese,
			String requestcatassign) {
		return eFormDao.InsertReleseRequestByRemotSupportForResolve(name,companyname,nameid,reqid,statusR,note, empPic,emailid,pid,companyRaisedBy,raisedByName,appByITComp,softwarenamerelese,requestcatassign);
	}
	@Override
	public String InsertTransferRequestApprovedBy2ndManager(String appByITComp, String status, String approvenote,
			MultipartFile empPic, String softwarename, String companyRaisedBy, String raisedByName
	,String reqcat,String temployee) {
		// TODO Auto-generated method stub
		return eFormDao.InsertTransferRequestApprovedBy2ndManager(appByITComp, status, approvenote,empPic, softwarename,companyRaisedBy,raisedByName,reqcat,temployee);
	}
	@Override
	public JSONArray GetSoftwareDetailOfLoginUser(String sname) {
		// TODO Auto-generated method stub
		return eFormDao.GetSoftwareDetailOfLoginUser(sname);
	}
	
	// Busniess Request
	
		@Override
		public String insertBusinessRequest(String fullname,String compname,String site,String department,String phone,String emailid,String pid,String approup,String requestfor,String domain,String description,String rperiod,String typecategory,String newDate,MultipartFile empPic) {
			return eFormDao.insertBusinessRequest( fullname, compname, site, department, phone, emailid, pid, approup, requestfor, domain, description, rperiod, typecategory, newDate, empPic);
		}

		@Override
		public JSONArray getUserBusinessRequestList() {
			// TODO Auto-generated method stub
			return eFormDao.getUserBusinessRequestList();
		}

		@Override
		public JSONArray gatherBusinessRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.gatherBusinessRequestDetails(ticketid);
		}

		@Override
		public JSONArray getBusinessRequestActivityLog(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getBusinessRequestActivityLog(ticketid);
		}

		@Override
		public JSONArray getBusinessRequestID(String requestype) {
			// TODO Auto-generated method stub
			return eFormDao.getBusinessRequestID(requestype);
		}

		@Override
		public JSONArray getUserBusinessRequestTracking(String ticketid, String requesttype) {
			// TODO Auto-generated method stub
			return eFormDao.getUserBusinessRequestTracking(ticketid, requesttype);
		}

		@Override
		public JSONArray getUserBusinessRaisedRequest() {
			// TODO Auto-generated method stub
			return eFormDao.getUserBusinessRaisedRequest();
		}

		@Override
		public JSONArray gatherBusinesRequestRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.gatherBusinesRequestRequestDetails(ticketid);
		}

		@Override
		public JSONArray gatherBusinessActionDetails(String id) {
			// TODO Auto-generated method stub
			return eFormDao.gatherBusinessActionDetails(id);
		}

		@Override
		public String InsertBusinessRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertBusinessRequestApprovedByMAnager(appByITComp, Status, approvenote, approvalName, empPic, phone, emailid, pid, companyRaisedBy, raisedByName, ticketidupdateTDassign);
		}

		@Override
		public JSONArray getBusinessTicketRequestActivityLog(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getBusinessTicketRequestActivityLog(ticketid);
		}

		@Override
		public JSONArray getGalUpdateBusinessRequest() {
			// TODO Auto-generated method stub
			return eFormDao.getGalUpdateBusinessRequest();
		}

		@Override
		public JSONArray getMailAdminBusinessRequest() {
			// TODO Auto-generated method stub
			return eFormDao.getMailAdminBusinessRequest();
		}

		@Override
		public JSONArray getMailAdminBucket() {
			// TODO Auto-generated method stub
			return eFormDao.getMailAdminBucket();
		}

		@Override
		public String InsertBusinessRequestApprovedByGalUpdate(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
				String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertBusinessRequestApprovedByGalUpdate(appByITComp, Status, approvenote, approvalName, empPic, phone, emailid, pid, companyRaisedBy, raisedByName, ticketidupdateTDassign);
		}

		@Override
		public String InsertBusinessRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
				String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertBusinessRequestApprovedByMailAdmin(appByITComp, Status, approvenote, approvalName, empPic, phone, emailid, pid, companyRaisedBy, raisedByName, ticketidupdateTDassign);
		}

		@Override
		public String closeBusinessResolvedRequest(String ticketid, String closereason) {
			// TODO Auto-generated method stub
			return eFormDao.closeBusinessResolvedRequest(ticketid, closereason);
		}

		@Override
		public String RequestReopenResolvedBusinessTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
			// TODO Auto-generated method stub
			return eFormDao.RequestReopenResolvedBusinessTicket(ticketid, reopenreason, reopenPic);
		}

		@Override
		public JSONArray getBusinessReopenRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getBusinessReopenRequestDetails(ticketid);
		}

		//END BUSINESS ID
		
		@Override
		public JSONArray getReleasePendingToApproveRequestByManager() {
			// TODO Auto-generated method stub
			return eFormDao.getReleasePendingToApproveRequestByManager() ;
		}
		@Override
		public JSONArray AssignSoftwareReleaseDetails(String id) {
			// TODO Auto-generated method stub
			return eFormDao.AssignSoftwareReleaseDetails(id);
		}
		@Override
		public String InsertReleaseApprovedByMAnager(String appByITComp, String status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String softwarename, String companyRaisedBy, String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertReleaseApprovedByMAnager(appByITComp, status, approvenote,
					approvalName, empPic, phone, emailid, pid, softwarename, companyRaisedBy, raisedByName,
					ticketidupdateTDassign);
		}
		
		@Override
	public JSONArray getReleasePendingToApproveRequestByITCompliance(){
			// TODO Auto-generated method stub
			return eFormDao.getReleasePendingToApproveRequestByITCompliance();
		}
		@Override
		public String SoftwareTransferReopenResolvedTicket(String raisedByName, String tid, String reopenreason,
				MultipartFile reopenPic) {
			// TODO Auto-generated method stub
			return eFormDao.SoftwareTransferReopenResolvedTicket(raisedByName,tid,reopenreason,reopenPic);
			}
		@Override
		public JSONArray getSoftwaredetailsList() {
			// TODO Auto-generated method stub
			return eFormDao.getSoftwaredetailsList();
		}
		
		// SMTP Flow Start
		
		@Override
		public JSONArray getUserSelectedDetails(String approvalname, String fullName) {
			// TODO Auto-generated method stub
			return eFormDao.getUserSelectedDetails(approvalname, fullName);
		}

		@Override
		public String insertSoftwareRequest(String fullname, String compname, String site, String department, String phone,
				String emailid, String pid, String approup, String appserver, String appserverIp,
				String applicationServerloc, String servercityname, String noOfMail, String mailsize, String description,
				String expDate, MultipartFile empPic) {
			// TODO Auto-generated method stub
			return eFormDao.insertSoftwareRequest(fullname, compname, site, department, phone, emailid, pid, approup, appserver, appserverIp, applicationServerloc, servercityname, noOfMail, mailsize, description, expDate, empPic);
		}

		@Override
		public JSONArray getSMTPRequestList() {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPRequestList();
		}

		@Override
		public JSONArray gatherSMTPRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.gatherSMTPRequestDetails(ticketid);
		}

		@Override
		public JSONArray getSMTPRequestActivityLog(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPRequestActivityLog(ticketid);
		}

		@Override
		public JSONArray getSMTPRequestID() {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPRequestID();
		}

		@Override
		public JSONArray getUserSMTPRequestTracking(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getUserSMTPRequestTracking(ticketid);
		}

		@Override
		public JSONArray getUserSMTPRaisedRequest() {
			// TODO Auto-generated method stub
			return eFormDao.getUserSMTPRaisedRequest();
		}

		@Override
		public JSONArray getSMTPPendingApprovalDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPPendingApprovalDetails(ticketid);
		}

		@Override
		public JSONArray getSMTPPendingTicketRequestActivityLog(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPPendingTicketRequestActivityLog(ticketid);
		}

		@Override
		public JSONArray SMTPPendingActionDetails(String id) {
			// TODO Auto-generated method stub
			return eFormDao.SMTPPendingActionDetails(id);
		}

		@Override
		public String InsertSMTPRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
				String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertSMTPRequestApprovedByMAnager(appByITComp, Status, approvenote, approvalName, empPic, phone, emailid, pid, companyRaisedBy, raisedByName, ticketidupdateTDassign);
		}

		@Override
		public JSONArray getMailAdminSMTPRequest() {
			// TODO Auto-generated method stub
			return eFormDao.getMailAdminSMTPRequest();
		}

		@Override
		public String InsertSMTPRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
				String raisedByName, String ticketidupdateTDassign) {
			// TODO Auto-generated method stub
			return eFormDao.InsertSMTPRequestApprovedByMailAdmin(appByITComp, Status, approvenote, approvalName, empPic, phone, emailid, pid, companyRaisedBy, raisedByName, ticketidupdateTDassign);
		}

		@Override
		public JSONArray getMailAdminSMTPBucket() {
			// TODO Auto-generated method stub
			return eFormDao.getMailAdminSMTPBucket();
		}

		@Override
		public String closeSMTPResolvedRequest(String ticketid, String closereason) {
			// TODO Auto-generated method stub
			return eFormDao.closeSMTPResolvedRequest(ticketid, closereason);
		}

		@Override
		public String RequestReopenResolvedSMTPTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
			// TODO Auto-generated method stub
			return eFormDao.RequestReopenResolvedSMTPTicket(ticketid, reopenreason, reopenPic);
		}

		@Override
		public JSONArray getSMTPReopenRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPReopenRequestDetails(ticketid);
		}

		@Override
		public JSONArray gatherSMTPRequestRequestDetails(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.gatherSMTPRequestRequestDetails(ticketid);
		}

		@Override
		public JSONArray getSMTPActivityTicketRequestActivityLog(String ticketid) {
			// TODO Auto-generated method stub
			return eFormDao.getSMTPActivityTicketRequestActivityLog(ticketid);
		}

		
		
		// SMTP Flow End
		
		
}
