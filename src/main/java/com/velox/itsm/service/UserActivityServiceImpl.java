package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.dao.UserActivityDao;

@Service("UserActivityService")
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	UserActivityDao userActvityDao;

	@Override
	public JSONArray getAllUserDetails(String LoginUser) {
		System.out.println("Inside getAllUserDetails ");

//		System.out.println("getAllUserDetails" + details);
//		JSONArray getAllUserDetails_dao_output = userActvityDao.getAllUserDetails(details);
//		System.out.println("From Service_IMPL_output response " + getAllUserDetails_dao_output);
		return userActvityDao.getAllUserDetails(LoginUser);
	}
	
	public JSONArray getUserDashboardData(String loginuser, String loginUserCompany) {
		JSONArray getTPDashboardData_dao_output = userActvityDao.getUserDashboardData(loginuser, loginUserCompany);
		return getTPDashboardData_dao_output;
	}
	

	@Override
	public String insertUserRaiseTicket(String fullname, String datepicker5, String phone, String emailid, String compname,
			String site, String category, String subcat1, String subcat2, String requestmode, String department, String subject,
			String description, String priority, String severity, MultipartFile empPic, String username, String vipuser ,String str1,String str2,String str3,String str4,String  str5,String asset_sub_category ,String asset_Ipaddress) {
		// TODO Auto-generated method stub
		return userActvityDao.insertUserRaiseTicket(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2,
				requestmode, department, subject, description, priority, severity, empPic, username, vipuser,str1,str2,str3,str4,str5, asset_sub_category , asset_Ipaddress);
	}

	@Override
	public JSONArray getUserTicketList(String userlist) {

		System.out.println("Inside getUserTicketList ");

		String controller_response = null;

		System.out.println("getUserTicketList" + userlist);
		JSONArray getUserTicketList_dao_output = userActvityDao.getUserTicketList(userlist);
		System.out.println("From Service_IMPL_output response " + getUserTicketList_dao_output);
		return getUserTicketList_dao_output;
	}

	@Override
	public JSONArray gatherUserTicketDetails(String ticketid) {
		// TODO Auto-generated method stub
		return userActvityDao.gatherUserTicketDetails(ticketid);
	}

	@Override
	public JSONArray getUserTicketID(String details,String selecttype) {

		System.out.println("Inside getUserTicketID ");

		String controller_response = null;

		System.out.println("getUserTicketID name" + details);
		JSONArray getUserTicketID_dao_output = userActvityDao.getUserTicketID(details,selecttype);
		System.out.println("From Service_IMPL_output response " + getUserTicketID_dao_output);
		return getUserTicketID_dao_output;
	}

	@Override
	public JSONArray getUserTicketTracking(String ticketid) {
		// TODO Auto-generated method stub
		return userActvityDao.getUserTicketTracking(ticketid);
	}

	@Override
	public JSONArray getUserTicketTrackingMessage(int ticketid) {
		// TODO Auto-generated method stub
		return userActvityDao.getUserTicketTrackingMessage(ticketid);
	}

	@Override
	public JSONArray getResolvedUserTicketList(String userlist) {

		System.out.println("getResolvedUserTicketList" + userlist);
		JSONArray getResolvedUserTicketList_dao_output = userActvityDao.getResolvedUserTicketList(userlist);
		System.out.println("From Service_IMPL_output response " + getResolvedUserTicketList_dao_output);
		return getResolvedUserTicketList_dao_output;
	}

	@Override
	public String closeUserResolvedTicket(String ticketid, String closereason) {
		// TODO Auto-generated method stub
		return userActvityDao.closeUserResolvedTicket(ticketid, closereason);
	}

	@Override
	public String UserReopenResolvedTicket(String  RequesterName, String RequesterCompany, String RequesterBranch, String RequesterDept, String RequesterSubDept, String RequesterLocation, String RequesterPhone, String RequesterEmail, String TicketID, String TicketStatus, String TicketRaiseDate, String Category, String SubCat1, String SubCat2, String Subject, String Priority, String Severity, String T_Description, String T_RequestMode, String ReopenReason, MultipartFile reopenPic) {
		// TODO Auto-generated method stub
		return userActvityDao.UserReopenResolvedTicket(RequesterName, RequesterCompany, RequesterBranch, RequesterDept, RequesterSubDept, RequesterLocation, RequesterPhone, RequesterEmail, TicketID, TicketStatus, TicketRaiseDate, Category, SubCat1, SubCat2, Subject, Priority, Severity, T_Description, T_RequestMode, ReopenReason, reopenPic);
	}

	@Override
	public JSONArray getClosedUserTicketList(String userlist) {

		System.out.println("Inside getClosedUserTicketList ");

		System.out.println("getClosedUserTicketList" + userlist);
		JSONArray getClosedUserTicketList_dao_output = userActvityDao.getClosedUserTicketList(userlist);
		System.out.println("From Service_IMPL_output response " + getClosedUserTicketList_dao_output);
		return getClosedUserTicketList_dao_output;
	}

	@Override
	public String UserPasswordreset(String user, String oldpass, String newpass, String cnfnewpass) {
		// TODO Auto-generated method stub
		return userActvityDao.UserPasswordreset(user, oldpass, newpass, cnfnewpass);
	}

	@Override
	public JSONArray getTicketActivityLog(String ticketid) {

		return userActvityDao.getTicketActivityLog(ticketid);
	}
	@Override
	public JSONArray PoRaiseByMeDetails(String uname, String company, String role) {
		// TODO Auto-generated method stub
		return userActvityDao.PoRaiseByMeDetails(uname,company, role);
	}
	@Override
	public String getUpdateCollnMangpprove(String crno,String status,String tid,String uname,String company,String aMnote) {
		
		return userActvityDao.getUpdateCollnMangpprove( crno, status, tid, uname, company,aMnote);
	}
	@Override
	public JSONArray getVlxProposalData(String crfId,String uname, String tid) {
		// TODO Auto-generated method stub
		return userActvityDao.getVlxProposalData(crfId,uname,tid);
	}
@Override
public JSONArray getApprovaalCollnMangData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getApprovaalCollnMangData(crfId,uname,tid);
}
	@Override
	public String insertServiceCatalogueRequest(String fullname, String datepicker5, String phone, String emailid,
			String compname, String site, String category, String subcat1, String subcat2, String requestmode,
			String department, String subject, String description, String priority, MultipartFile empPic,
			String username, String vipuser,String severity) {
		// TODO Auto-generated method stub
		return userActvityDao.insertServiceCatalogueRequest(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2,
				requestmode, department, subject, description, priority, empPic, username, vipuser,severity);
	}

	@Override
	public JSONArray getSelfHelpList(String selfhelplist) {
		
		JSONArray getSelfHelpList_dao_output = userActvityDao.getSelfHelpList(selfhelplist);
		return getSelfHelpList_dao_output;
	}

	@Override
	public JSONArray gatherSelfHelpDetails(String selfhelpid) {
		// TODO Auto-generated method stub
		return userActvityDao.gatherSelfHelpDetails(selfhelpid);
	}
	
	
	@Override
	public String insertServiceRequestCatalogueRequest(String fullname, String datepicker5, String phone,
			String emailid, String compname, String site, String category, String subcat1, String subcat2,
			String requestmode, String department, String subject, String description, String priority,
			MultipartFile empPic, String username, String vipuser,String approval1username,String groupname,String designationlevel1,String requesttype,String severity,String approve_level,String requestcost,String designationlevel2,String app_level_fullName,String approvel_level_email,String otheremailforbehalf,String assetTag,String assetName,String AssetCategory,String AssetStatus,String AssetCheck,String asset_sub_category,String asset_Ipaddress) {
		
		
		return userActvityDao.insertServiceRequestCatalogueRequest(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2,
				requestmode, department, subject, description, priority, empPic, username, vipuser, approval1username,groupname,designationlevel1,requesttype,severity,approve_level,requestcost,designationlevel2,app_level_fullName,approvel_level_email,otheremailforbehalf,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);
	
	}
	@Override
	public JSONArray gatherUserServiceRequest(String ticketid) {
	
		return userActvityDao.gatherUserServiceRequest(ticketid);
	}


@Override
	public JSONArray getServiceRequest(String servicerequest) {
		
		
		System.out.println("Inside getUserTicketList ");

		String controller_response = null;

		System.out.println("getUserTicketList" + servicerequest);
		JSONArray getUserTicketList_dao_output = userActvityDao.getServiceRequest(servicerequest);
		System.out.println("From Service_IMPL_output response " + getUserTicketList_dao_output);
		return getUserTicketList_dao_output;
	}

@Override
public JSONArray getServiceActivityLog(String ticketid) {
	return userActvityDao.getServiceActivityLog(ticketid);
}

@Override
public JSONArray getServiceActivityLog2(String ticketid) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public JSONArray getUserServiceTracking(String ticketid) {
	// TODO Auto-generated method stub
	return userActvityDao.getUserServiceTracking(ticketid);
}

@Override
public JSONArray ApprovedCollnMangDetails(String uname,String company, String role) {
	// TODO Auto-generated method stub
	return userActvityDao.ApprovedCollnMangDetails(uname,company,role);
}

@Override
public JSONArray getUserRequestID(String details) {
	System.out.println("Inside getUserTicketID ");

	String controller_response = null;

	System.out.println("getUserRequestID name" + details);
	JSONArray getUserTicketID_dao_output = userActvityDao.getUserRequestID(details);
	System.out.println("From Service_IMPL_output response " + getUserTicketID_dao_output);
	return getUserTicketID_dao_output;
}
//@Override
//public JSONArray getServiceActivityLog2(String ticketid) {
//	return userActvityDao.getServiceActivityLog(ticketid);
//}

@Override
public JSONArray getResolvedRequest(String userlist) {
	System.out.println("getResolvedRequest" + userlist);
	JSONArray getResolvedUserTicketList_dao_output = userActvityDao.getResolvedRequest(userlist);
	System.out.println("From Service_IMPL_output response " + getResolvedUserTicketList_dao_output);
	System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
	return getResolvedUserTicketList_dao_output;
	
}

@Override
public JSONArray gatherResolvedRequestsDetails(String ticketid) {
	// TODO Auto-generated method stub
	return userActvityDao.gatherResolvedRequestsDetails(ticketid);
}

@Override
public String closeUserResolvedRequest(String ticketid, String closereason) {
	// TODO Auto-generated method stub
	return userActvityDao.closeUserResolvedRequest(ticketid, closereason);
//
}

@Override
public JSONArray getUserRaisedRequest(String ticketlist) {
//	System.out.println("getAllVIPRaisedTicketList" + ticketlist);
	JSONArray getAllVIPRaisedTicketList_dao_output =  userActvityDao.getUserRaisedRequest(ticketlist);
//	System.out.println("From Service_IMPL_output response " + getAllVIPRaisedTicketList_dao_output);
	return getAllVIPRaisedTicketList_dao_output;
}


@Override
public JSONArray Getotherinformaion(String othercompany,String othername) {
	JSONArray getAllVIPRaisedTicketList_dao_output =  userActvityDao.Getotherinformaion(othercompany,othername);
	return getAllVIPRaisedTicketList_dao_output;
}
@Override
public JSONArray getServiceRequestDashboardData(String loginuser, String loginUserCompany) {

	JSONArray getAllVIPRaisedTicketList_dao_output =  userActvityDao.getUserRaisedRequest(loginuser,loginUserCompany);

	return getAllVIPRaisedTicketList_dao_output;
}

@Override
public JSONArray getServiceRequestListing(String chartdata) {
	JSONArray getAllVIPRaisedTicketList_dao_output =  userActvityDao.getServiceRequestListing(chartdata);

	return getAllVIPRaisedTicketList_dao_output;
	
}

@Override
public JSONArray getDashboardListingForTickets(String chartdata) {
	JSONArray getAllVIPRaisedTicketList_dao_output =  userActvityDao.getDashboardListingForTickets(chartdata);

	return getAllVIPRaisedTicketList_dao_output;
}


@Override
public JSONArray getAlldataAccordingsubject(String subject,String company) {

	return userActvityDao.getAlldataAccordingsubject(subject,company);
}

@Override
public JSONArray getallusernameforraiseonbehalf(String company) {

	return userActvityDao.getallusernameforraiseonbehalf(company);
}

@Override
public String inserRaiseOnBehalfTicket(String fullname, String datepicker5, String phone, String emailid,
		String compname, String site, String category, String subcat1, String subcat2, String requestmode,
		String department, String subject, String description, String priority, String severity, MultipartFile empPic,
		String usernameofraiseby, String vipuser, String t_request,String otherfullname,String assetTag,String assetName,String AssetCategory,String AssetStatus,String AssetCheck,String asset_sub_category ,String asset_Ipaddress) {
	
	
	
	
	return userActvityDao.inserRaiseOnBehalfTicket(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2,
			requestmode, department, subject, description, priority, severity, empPic, usernameofraiseby, vipuser,t_request,otherfullname,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);
}


@Override
public String insertServiceRequestCatalogueRequestOnBehalf(String fullname, String datepicker5, String phone,
		String emailid, String compname, String site, String category, String subcat1, String subcat2,
		String requestmode, String department, String subject, String description, String priority,
		MultipartFile empPic, String username, String vipuser, String approval1username, String groupname,
		String designationlevel1, String requesttype, String severity, String approve_level, String requestcost,
		String designationlevel2, String t_requester,String app_level1_fullname,String otheremailforbehalf,String assetTag,String assetName,String AssetCategory,String AssetStatus,String AssetCheck,String asset_sub_category,String asset_Ipaddress) {
	
	
	return userActvityDao.insertServiceRequestCatalogueRequestOnBehalf(fullname, datepicker5, phone, emailid, compname, site, category, subcat1, subcat2,
			requestmode, department, subject, description, priority, empPic, username, vipuser, approval1username,groupname,designationlevel1,requesttype,severity,approve_level,requestcost,designationlevel2,t_requester,app_level1_fullname,otheremailforbehalf,assetTag,assetName,AssetCategory,AssetStatus,AssetCheck,asset_sub_category,asset_Ipaddress);

}


@Override
public JSONArray getUserDetailsForUpdate(String loginUser) {
	return userActvityDao.getUserDetailsForUpdate(loginUser);
}

@Override
public String updateLoginUserProfile(String username, String cname, String site, String location, String dname,
		String subDepartment, String emailid, String cno, String designation) {
	
	return userActvityDao.updateLoginUserProfile(username,cname,site,location,dname,subDepartment,emailid,cno,designation);
}
@Override
public String ReopenResolvedServiceRequest(String requesterName, String requesterCompany, String requesterBranch,
		String requesterDept, String requesterSubDept, String requesterLocation, String requesterPhone,
		String requesterEmail, String ticketID, String ticketStatus, String ticketRaiseDate, String category,
		String subCat1, String subCat2, String subject, String priority, String severity, String t_Description,
		String t_RequestMode, String reopenReason, MultipartFile reopenPic) {
	
	return userActvityDao.ReopenResolvedServiceRequest(requesterName,requesterCompany,requesterBranch,requesterDept,requesterSubDept,requesterLocation,requesterPhone,
			requesterEmail,ticketID,ticketStatus,ticketRaiseDate,category,subCat1,subCat2,subject,priority,severity,t_Description,
			t_RequestMode,reopenReason,reopenPic);
}

@Override
public JSONArray chekingSLA(String company, String priority, String severity) {
	return userActvityDao.chekingSLA(company,priority,severity);
}

@Override
public JSONArray GetAssetinformaion(String othername) {
	return userActvityDao.GetAssetinformaion(othername);
}

@Override
public JSONArray getProblemTicketsListing(String othername,String  dates) {
	return userActvityDao.getProblemTicketsListing(othername,dates);
}

@Override
public JSONArray getIncidentCategoryListing(String chartdata,String lastmonth) {
	return  userActvityDao.getIncidentCategoryListing(chartdata,lastmonth);

	
	
}

@Override
public JSONArray getPieListForCategoryServiceRequest(String chartdata,String lastmonth) {
	// TODO Auto-generated method stub
	return userActvityDao.getPieListForCategoryServiceRequest(chartdata,lastmonth);
}

@Override
public JSONArray getIncidentPrioritySeverityListing(String priority, String severity, String lastmonth) {
	// TODO Auto-generated method stub
	return userActvityDao.getIncidentPrioritySeverityListing(priority,severity,lastmonth);
}

@Override
public JSONArray getServicePrioritySeverityListing(String priority, String severity, String lastmonth) {
	// TODO Auto-generated method stub
	return userActvityDao.getServicePrioritySeverityListing(priority,severity,lastmonth);
}

@Override
public JSONArray getallUserByLocationBased(String company, String location) {
	return userActvityDao.getallUserByLocationBased(company,location);
}

@Override
public String insertFormA(String dateforma, String salemangname, String distributorpartyname,
		String distributorprojectname, String distributortechpersonname, String distributorprsndesignation,
		String distributorcontactnumber, String distributoremailid, String partnerpartyname, String partnerprojectname,
		String partnertechpersonname, String partnerprsndesignation, String partnercontactnumber, String partneremailid,
		String customerpartyname, String customerprojectname, String customertechpersonname,
		String customerprsndesignation, String customercontactnumber, String customeremailid,
		String implementorpartyname, String implementorprojectname, String implementortechpersonname,
		String implementorprsndesignation, String implementorcontactnumber, String implementoremailid) {
	
	return userActvityDao.insertFormA(dateforma, salemangname, distributorpartyname, distributorprojectname, distributortechpersonname,
			distributorprsndesignation, distributorcontactnumber, distributoremailid, partnerpartyname, partnerprojectname, partnertechpersonname, partnerprsndesignation, partnercontactnumber, partneremailid, customerpartyname, customerprojectname, customertechpersonname,customerprsndesignation,customercontactnumber,customeremailid,
			implementorpartyname,implementorprojectname,implementortechpersonname,implementorprsndesignation,implementorcontactnumber,implementoremailid);
}

@Override
public String insertForm2(String form2date, String form2customername, String RPFTIMELINES, String potimeline,
		String firstinvoicegeneratedate, String radiosss, String projstartdate, String projenddate, String pymentterms,
		String projecthead) {
	
	
	return userActvityDao.insertForm2(form2date, form2customername, RPFTIMELINES, potimeline, firstinvoicegeneratedate,
			radiosss, projstartdate, projenddate, pymentterms, projecthead);
	
}


@Override
public JSONArray vlxProposalPendingDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalPendingDetails(uname,company,userfullname);
}
@Override
public JSONArray saleMngApprByMeDetails(String uname, String company , String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.saleMngApprByMeDetails(uname,company,userfullname);
}
@Override
public JSONArray getVlxProposalPendingData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalPendingData(crfId,uname,tid);
}
@Override
public JSONArray vlxPropApproveBymeDetails(String uname,String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxPropApproveBymeDetails(uname,company,userfullname);
}
@Override
public JSONArray vlxProposalMDPendingDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalMDPendingDetails(uname,company);
}

@Override
public String UpdateVlxPropSaleMangApprove(String crno,String status,String tid,String uname,String company,String SMnote) {
	
	return userActvityDao.UpdateVlxPropSaleMangApprove( crno, status, tid, uname, company,SMnote);
}
@Override
public JSONArray vlxProposalSendBymeDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalSendBymeDetails(uname,company);
}
@Override
public JSONArray getApprovaalSaleMngData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getApprovaalSaleMngData(crfId,uname,tid);
}

@Override
public JSONArray getVlxProposalApprovedData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalApprovedData(crfId,uname,tid);
}
@Override
public JSONArray getVlxProposalApprovalMDData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalApprovalMDData(crfId,uname,tid);
}
@Override
public JSONArray getVlxProposalApprovedMDData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalApprovedMDData(crfId,uname,tid);
}
@Override
public JSONArray vlxProposalRejectedSIDetails(String uname, String company,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalRejectedSIDetails(uname,company,fullname);
}
@Override
public String UpdateVlxPropMDApprove(String crno,String status,String tid,String uname,String company,String MDnote) {
	
	return userActvityDao.UpdateVlxPropMDApprove( crno, status, tid, uname, company,MDnote);
}

@Override
public JSONArray vlxProposalApproveDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalApproveDetails(uname,company);
}

@Override
public JSONArray getVlxProposalSIRejectedData(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalSIRejectedData( crno,  uname,  tid);
}


@Override
public JSONArray vlxPropRejectedBymeDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxPropRejectedBymeDetails(uname,company,userfullname);
}

@Override
public JSONArray getVlxProposalSMRejectedData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalSMRejectedData(crfId,uname,tid);
}
@Override
public String SMrejectVP(String crno, String company, String rejectreason, String sMnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.SMrejectVP( crno, company, rejectreason,sMnote,uname,tid);
}


@Override
public JSONArray SaleMngPending_RegistrationeDetails(String uname, String company,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.SaleMngPending_RegistrationeDetails(uname,company,fullname);
}

@Override
public JSONArray SalesIniraised_RegistrationDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.SalesIniraised_RegistrationDetails(uname,company);
}

@Override
public JSONArray pendingFORM3Details(String uname,String company,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.pendingFORM3Details(uname,company,fullname);
}
@Override
public JSONArray getPendingFORM3Data(String crfId,String uname, String tid,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.getPendingFORM3Data(crfId,uname,tid,fullname);
}

@Override
public JSONArray getRaisedRegistraionlist(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRaisedRegistraionlist(crfId,uname,tid);
}

@Override
public String InsertForm3(String date, String projeimplementorname, String customername, String projectname,
		String serverAvail, String serverAvail_Responsibility, String server_startdate, String server_enddate,
		String installvlxlicenseate, String responsibilityvlxlicense, String startdatevlxlicense,
		String enddatevlxlicense, String uATTesting, String responsibilityuattesting, String startdateuattesting,
		String enddateuattesting, String productiongolive, String responsibilitygolive, String startdategolive,
		String enddategolive, String rollout, String responsibilityrollout, String startdaterollout,
		String enddaterollout, String demolive, String responsibilitydemo, String startdatedemo, String enddatedemo,
		String paymentterms, String responsibilitypaymentterms, String startdatepaymentterms,
		String enddatepaymentterms, String signoff, String responsibilitysignoff, String startdatesignoff,
		String enddatesignoff, String crno, String tid,String uname,String poNumber,String productLicense,String jsonImplFormC,String fullname,
		String CustImplementorName ,String CustImplementorNumber,String cusImplementorEmail,String SalesManagerName,String EndCustomerName,
		String EndCustomerNumber) {
	// TODO Auto-generated method stub
	return  userActvityDao.InsertForm3( date,  projeimplementorname,  customername,  projectname,
			 serverAvail,  serverAvail_Responsibility,  server_startdate,  server_enddate,
			 installvlxlicenseate,  responsibilityvlxlicense,  startdatevlxlicense,
			 enddatevlxlicense,  uATTesting,  responsibilityuattesting,  startdateuattesting,
			 enddateuattesting,  productiongolive,  responsibilitygolive,  startdategolive,
			 enddategolive,  rollout,  responsibilityrollout,  startdaterollout,
			 enddaterollout,  demolive,  responsibilitydemo,  startdatedemo,  enddatedemo,
			 paymentterms,  responsibilitypaymentterms,  startdatepaymentterms,
			 enddatepaymentterms,  signoff,  responsibilitysignoff,  startdatesignoff,
			 enddatesignoff,  crno,  tid, uname,poNumber, productLicense, jsonImplFormC, fullname,
			 CustImplementorName , CustImplementorNumber, cusImplementorEmail, SalesManagerName, EndCustomerName, EndCustomerNumber);
}

@Override
public String registFormCollnMangApprove(String crno,String status,String tid,String uname,String company) {
	
	return userActvityDao.registFormCollnMangApprove( crno, status, tid, uname, company);
}


@Override
public JSONArray CMapprovedRegistrationDetails(String uname, String company,String fullname,String role) {
	// TODO Auto-generated method stub
	return userActvityDao.CMapprovedRegistrationDetails(uname,company,fullname,role);
}

@Override
public JSONArray getApprovedCMRegistraionlist(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getApprovedCMRegistraionlist(crfId,uname,tid);
}


@Override
public JSONArray submittedFORM3Details(String uname,String company) {
	// TODO Auto-generated method stub
	return userActvityDao.submittedFORM3Details(uname,company);
}
@Override
public JSONArray getSubmittedFORM3Data(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getSubmittedFORM3Data(crfId,uname,tid);
}
@Override
public JSONArray getCheckerContactNo(String checkerApprovername) {
	System.out.println("Inside getAllUserDetails ");

//	System.out.println("getAllUserDetails" + details);
//	JSONArray getAllUserDetails_dao_output = userActvityDao.getAllUserDetails(details);
//	System.out.println("From Service_IMPL_output response " + getAllUserDetails_dao_output);
	return userActvityDao.getCheckerContactNo(checkerApprovername);
}

@Override
public JSONArray SaleMngFormABDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.SaleMngFormABDetails(uname,company,userfullname);
}
@Override
public JSONArray getDataSaleMngFormABDetails(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getDataSaleMngFormABDetails(crfId,uname,tid);
}

@Override
public JSONArray trackDetails(String fromDate,String toDate, String selecttype, String selectType2) {
	// TODO Auto-generated method stub
	return userActvityDao.trackDetails(fromDate,toDate,selecttype, selectType2);
}

@Override
public String insertPOFormAB(String loginuser, String loginUserCompany, String dateforma, String salemangname,
		String distributorpartyname, String distributorprojectname, String distributortechpersonname,
		String distributorprsndesignation, String distributorcontactnumber, String distributoremailid,
		String partnerpartyname, String partnerprojectname, String partnertechpersonname, String partnerprsndesignation,
		String partnercontactnumber, String partneremailid, String customerpartyname, String customerprojectname,
		String customertechpersonname, String customerprsndesignation, String customercontactnumber,
		String customeremailid, String implementorpartyname, String implementorprojectname,
		String implementortechpersonname, String implementorprsndesignation, String implementorcontactnumber,
		String implementoremailid, String form2date, String form2customername, String rPFTIMELINES, String potimeline,
		String firstinvoicegeneratedate, String radiosss, String projstartdate, String projenddate, String pymentterms,
		String projecthead, String formApoNo, String poform2No, String remarks, String chartpaymntno, String crno,
		String tid, String jsonImplFormC, String endcustomerpartyname, String endcustomerprojectname,
		String endcustomertechpersonname, String endcustomerprsndesignation, String endcustomercontactnumber,
		String endcustomeremailid,String sMnote, String potype) {
	// TODO Auto-generated method stub
	
	return userActvityDao.insertPOFormAB( 
			loginuser,loginUserCompany,dateforma, salemangname, distributorpartyname, distributorprojectname, distributortechpersonname,
			distributorprsndesignation, distributorcontactnumber, distributoremailid, partnerpartyname, partnerprojectname, partnertechpersonname, partnerprsndesignation, partnercontactnumber, partneremailid, customerpartyname, customerprojectname, customertechpersonname,customerprsndesignation,customercontactnumber,customeremailid,
			implementorpartyname,implementorprojectname,implementortechpersonname,implementorprsndesignation,implementorcontactnumber,implementoremailid,
			form2date, form2customername, rPFTIMELINES, potimeline, firstinvoicegeneratedate,radiosss, projstartdate, projenddate, pymentterms, 
			projecthead,  formApoNo, poform2No, remarks,chartpaymntno,crno,tid,jsonImplFormC,endcustomerpartyname,endcustomerprojectname,endcustomertechpersonname,endcustomerprsndesignation,endcustomercontactnumber,endcustomeremailid,sMnote,potype);
}

@Override
public JSONArray submittedFormABseniorMangDetails(String uname,String company,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.submittedFormABseniorMangDetails(uname,company,fullname);
}
@Override
public JSONArray getSubmittedFormABData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getSubmittedFormABData(crfId,uname,tid);
}

@Override
public String MDrejectVP(String crno, String company, String rejectreason, String MDnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.MDrejectVP(crno,company,rejectreason,MDnote,uname ,tid);
}

@Override
public JSONArray vlxProposalRejectDetails(String uname, String company) {
	// TODO Auto-generated method stub
	 return userActvityDao.vlxProposalRejectDetails(uname ,company);
}

@Override
public JSONArray vlxProposalRejectedMDDetails(String uname, String company,String fullname) {
	// TODO Auto-generated method stub
	return  userActvityDao.vlxProposalRejectedMDDetails(uname,company,fullname);
}

@Override
public JSONArray getVlxProposalMDRejectedData(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalMDRejectedData( crno,  uname,  tid);
}

@Override
public String insertPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
		String paymentterms, String prodliscense, String prodamount, String warrantystart, String warrantyend,
		String advaninvoice, MultipartFile[] advinvoicefile1, String loginuser, String loginUserCompany,
		String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
		String podate, String amcstartdate, String amcenddate, String productsuit, String securitytool,
		String warrantyMonth, String warrantyYear, String aMCMonth, String aMCYear, String sInote,
		String tennurestartdate, String tennureenddate, String tennureMonth, String tennureYear,String firstApprover,String SecondApprovername,String fixedyear,String subscriptionyear,String perpetualyear,MultipartFile[] massPOfile1,MultipartFile[] productFeaturedFileList,MultipartFile[] invoiceuploadfile, MultipartFile[] attendanceuploadFile, MultipartFile[] calculationuploadfile, String customerEmail, String subscriptionANDperpetualYear, String customerName) {
	// TODO Auto-generated method stub
	
	
	return userActvityDao.insertPurchaseOrder(pouploadfile1, proddescrip, customername, paymentterms, prodliscense,
			prodamount, warrantystart, warrantyend, advaninvoice, advinvoicefile1,loginuser,loginUserCompany, proposalType,proposalids,vpuploadfileProposal,
 potype, ponumber, podate, amcstartdate, amcenddate,  productsuit,
 securitytool,warrantyMonth,warrantyYear,aMCMonth,aMCYear,sInote,tennurestartdate,tennureenddate,tennureMonth,tennureYear,firstApprover,SecondApprovername, fixedyear, subscriptionyear, perpetualyear, massPOfile1,productFeaturedFileList,invoiceuploadfile,attendanceuploadFile,calculationuploadfile, customerEmail,subscriptionANDperpetualYear,customerName);
}
@Override
public String rejectRFtoACmgr(String crno, String company, String rejectreason, String MDnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.rejectRFtoACmgr(crno,company,rejectreason,MDnote,uname ,tid);
}

@Override
public JSONArray Rejectrfdetails(String uname, String company,String role) {
	// TODO Auto-generated method stub
	 return userActvityDao.Rejectrfdetails(uname ,company,role);
}

@Override
public JSONArray getfrom3details(String loginUser, String ponumber) {
	// TODO Auto-generated method stub
	 return userActvityDao.getfrom3details(loginUser ,ponumber);
}


@Override
public JSONArray getPoRaisedData (String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getPoRaisedData (crfId,uname,tid);
}

@Override
public String veloxproposalUpdateDetails(String veloxdata, String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername,
		String secondapprovercontact, String clientname, String description, String totalpriceforallproduct,
		String deploysupport, String clouddeploycharges, String subtotalB, String subtotalAB, String uname,
		String resoucesamount, String aTC, String proposaltype, String perpetualyear, String subscriptionyear,
		String amcsecondyear, String amcthirdyear, String amcfourthyear, String amcfiveyear,
		String secondyearsubscription, String thirdyearsubscription, String fullPathVlxLogo, String fullPathVlxEnd,
		String fullPathSwachBharat, String integrationchargeYesNo, String integrationCharges, String total_C,
		String gSTPERCENTAGE, String grand_Total, String productsuitselect, String scanplusprodversion,
		String secureITprodversion, String enccustomername, String letterhead, String signature, String fixedyear,
		String crno, String tid, String sInote,String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,
		String descforamc,String totalcostAMC,String GRANDTOTALFORAMC ,String gstforamc,
		String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson){
	// TODO Auto-generated method stub
	

	return userActvityDao.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson);
}



@Override
public JSONArray SendReviseProposalList(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.SendReviseProposalList(uname,company);
}

@Override
public JSONArray getReviseProposalListData(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getReviseProposalListData( crno,  uname,  tid);
}

@Override
public String submitReviseProposal(String veloxdata, String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername,
		String secondapprovercontact, String clientname, String description, String totalpriceforallproduct,
		String deploysupport, String clouddeploycharges, String subtotalB, String subtotalAB, String uname,
		String resoucesamount, String aTC, String proposaltype, String perpetualyear, String subscriptionyear,
		String amcsecondyear, String amcthirdyear, String amcfourthyear, String amcfiveyear,
		String secondyearsubscription, String thirdyearsubscription, String fullPathVlxLogo, String fullPathVlxEnd,
		String fullPathSwachBharat, String integrationchargeYesNo, String integrationCharges, String total_C,
		String gSTPERCENTAGE, String grand_Total, String productsuitselect, String scanplusprodversion,
		String secureITprodversion, String enccustomername, String letterhead, String signature, String fixedyear,
		String crno, String tid, String sInote,String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,
		String descforamc,String totalcostAMC,String GRANDTOTALFORAMC ,String gstforamc,
		String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson, String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21){
	// TODO Auto-generated method stub
	

	return userActvityDao.submitReviseProposal(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21);
}

@Override
public JSONArray reviseProposalSendBySIDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.reviseProposalSendBySIDetails(uname,company);
}

@Override
public JSONArray getReviseProposalSIsendData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getReviseProposalSIsendData(crfId,uname,tid);
}

@Override
public JSONArray vlxProposalaprdetails(String uname, String company,String role,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.vlxProposalaprdetails(uname,company,role,userfullname);
}

@Override
public JSONArray purchaseorderdetails(String uname, String company,String role) {
	// TODO Auto-generated method stub
	return userActvityDao.purchaseorderdetails(uname,company,role);
}


@Override
public JSONArray revisedProposalPendingListSM(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalPendingListSM(uname,company,userfullname);
}

@Override
public JSONArray getRevisedProposalPendingDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalPendingDataSM(crfId,uname,tid);
}

@Override
public JSONArray revisedProposalApproveListSM(String uname,String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalApproveListSM(uname,company,userfullname);
}


@Override
public JSONArray getRevisedProposalApprovedDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalApprovedDataSM(crfId,uname,tid);
}

@Override
public String UpdateRevisedPropSMApprove(String crno,String status,String tid,String uname,String company,String SMnote,String userfullname) {
	
	return userActvityDao.UpdateRevisedPropSMApprove( crno, status, tid, uname, company,SMnote,userfullname);
}

@Override
public JSONArray revisedProposalRejectedListSM(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalRejectedListSM(uname,company,userfullname);
}

@Override
public JSONArray getRevisedProposalRejectedDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalRejectedDataSM(crfId,uname,tid);
}

@Override
public String RejectRevisedProposalSM(String crno, String company, String rejectreason, String sMnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.RejectRevisedProposalSM( crno, company, rejectreason,sMnote,uname,tid);
}

@Override
public JSONArray revisedProposalRejectedListSI(String uname, String company,String fullname) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalRejectedListSI(uname,company,fullname);
}

@Override
public JSONArray getRevisedProposalRejectedDataSI(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalRejectedDataSI( crno,  uname,  tid);
}

@Override
public String rejectedRevisedProposalUpdateSI(String veloxdata, String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername,
		String secondapprovercontact, String clientname, String description, String totalpriceforallproduct,
		String deploysupport, String clouddeploycharges, String subtotalB, String subtotalAB, String uname,
		String resoucesamount, String aTC, String proposaltype, String perpetualyear, String subscriptionyear,
		String amcsecondyear, String amcthirdyear, String amcfourthyear, String amcfiveyear,
		String secondyearsubscription, String thirdyearsubscription, String fullPathVlxLogo, String fullPathVlxEnd,
		String fullPathSwachBharat, String integrationchargeYesNo, String integrationCharges, String total_C,
		String gSTPERCENTAGE, String grand_Total, String productsuitselect, String scanplusprodversion,
		String secureITprodversion, String enccustomername, String letterhead, String signature, String fixedyear,
		String crno, String tid, String sInote,String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,
		String descforamc,String totalcostAMC,String GRANDTOTALFORAMC ,String gstforamc,
		String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson, String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String proposalFor, String PartnerName){
	// TODO Auto-generated method stub
	

	return userActvityDao.rejectedRevisedProposalUpdateSI(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21, proposalFor, PartnerName);
}


@Override
public JSONArray revisedProposalPendingDetailsMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalPendingDetailsMD(uname,company);
}

@Override
public JSONArray getRevisedProposalApprovalDataMD(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalApprovalDataMD(crfId,uname,tid);
}

@Override
public String UpdateRevisedProposalApproveMD(String crno,String status,String tid,String uname,String company) {
	
	return userActvityDao.UpdateRevisedProposalApproveMD( crno, status, tid, uname, company);
}

@Override
public JSONArray revisedProposalApproveListMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedProposalApproveListMD(uname,company);
}

@Override
public JSONArray getRevisedProposalApprovedDataMD(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getRevisedProposalApprovedDataMD(crfId,uname,tid);
}

@Override
public JSONArray updateRegistrationFormList(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.updateRegistrationFormList(uname,company);
}

@Override
public JSONArray getUpdateRegistrationFormData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getUpdateRegistrationFormData(crfId,uname,tid);
}

@Override
public String SMrejectPO(String crno, String company, String rejectreason, String sMnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.SMrejectPO( crno, company, rejectreason,sMnote,uname,tid);
}

@Override
public JSONArray PORejectedBymeDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.PORejectedBymeDetails(uname,company,userfullname);
}

@Override
public JSONArray PORejectedSMDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.PORejectedSMDetails(uname,company,userfullname);
}

@Override
public JSONArray getPoRejectedSMData (String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getPoRejectedSMData (crfId,uname,tid);
}

@Override
public JSONArray getVlxProposalRejectedMDData(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxProposalRejectedMDData(crfId,uname,tid);
}

@Override
public String insertRejectedPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
		String paymentterms, String prodliscense, String prodamount, String warrantystart, String warrantyend,
		String advaninvoice, MultipartFile[] advinvoicefile1, String loginuser, String loginUserCompany,
		String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
		String podate, String amcstartdate, String amcenddate, String productsuit, String securitytool,
		String warrantyMonth, String warrantyYear, String aMCMonth, String aMCYear, String sInote,
		String tennurestartdate, String tennureenddate, String tennureMonth, String tennureYear,String firstApprover,String SecondApprovername,String fixedyear,String subscriptionyear,String perpetualyear,String crno,String tid,MultipartFile[] massPOfile1,MultipartFile[] productFeaturedFileList) {
	// TODO Auto-generated method stub
	return userActvityDao.insertRejectedPurchaseOrder(pouploadfile1, proddescrip, customername, paymentterms, prodliscense,
			prodamount, warrantystart, warrantyend, advaninvoice, advinvoicefile1,loginuser,loginUserCompany, proposalType,proposalids,vpuploadfileProposal,
 potype, ponumber, podate, amcstartdate, amcenddate,  productsuit,
 securitytool,warrantyMonth,warrantyYear,aMCMonth,aMCYear,sInote,tennurestartdate,tennureenddate,tennureMonth,tennureYear,firstApprover,SecondApprovername, fixedyear, subscriptionyear, perpetualyear,crno,tid,massPOfile1, productFeaturedFileList);
}


@Override
public JSONArray getApprovedPoData (String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getApprovedPoData (crfId,uname,tid);
}

@Override
public JSONArray createdVeloxLicenseDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.createdVeloxLicenseDetails(uname,company);
}

@Override
public JSONArray getVlxLicenseData(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getVlxLicenseData(crno,uname,tid);
}

@Override
public JSONArray getPoRejectedDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getPoRejectedDataSM(crfId,uname,tid);
}

@Override
public JSONArray proposalLicensePendingDetails(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.proposalLicensePendingDetails(uname,company,userfullname);
}

@Override
public JSONArray getProposalLicenseDataSM(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getProposalLicenseDataSM(crno,uname,tid);
}

@Override
public String ApproveProposalLicenseSM(String crno,String status,String tid,String uname,String company,String SMnote) {
	
	return userActvityDao.ApproveProposalLicenseSM( crno, status, tid, uname, company,SMnote);
}

@Override
public JSONArray proposalLicenseApprovedDetailsSM(String uname,String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.proposalLicenseApprovedDetailsSM(uname,company,userfullname);
}

@Override
public JSONArray getProposalLicenseApprovedDataSM(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getProposalLicenseApprovedDataSM(crno,uname,tid);
}

@Override
public JSONArray proposalLicensePendingDetailsBH(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.proposalLicensePendingDetailsBH(uname,company,userfullname);
}


@Override
public JSONArray getProposalLicenseDataBH(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getProposalLicenseDataBH(crno,uname,tid);
}

@Override
public String ApproveProposalLicenseBH(String crno,String status,String tid,String uname,String company,String BHnote) {
	
	return userActvityDao.ApproveProposalLicenseBH( crno, status, tid, uname, company,BHnote);
}


@Override
public JSONArray proposalLicenseApprovedDetailsBH(String uname,String company,String userfullname,String roletype ) {
	// TODO Auto-generated method stub
	return userActvityDao.proposalLicenseApprovedDetailsBH(uname,company,userfullname, roletype );
}


@Override
public JSONArray getProposalLicenseApprovedDataBH(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getProposalLicenseApprovedDataBH(crno,uname,tid);
}
@Override
public JSONArray manualProposalSendBymeDetailsSI(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.manualProposalSendBymeDetailsSI(uname,company);
}

@Override
public JSONArray getManualProposalDataSI(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualProposalDataSI(crfId,uname,tid);
}
@Override
public JSONArray manualProposalPendingDetailsSM(String uname, String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.manualProposalPendingDetailsSM(uname,company,userfullname);
}
@Override
public JSONArray getManualProposalDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualProposalDataSM(crfId,uname,tid);
}

@Override
public String ApproveManualProposalLicenseSM(String crno,String status,String tid,String uname,String company,String SMnote) {
	
	return userActvityDao.ApproveManualProposalLicenseSM( crno, status, tid, uname, company,SMnote);
}

@Override
public JSONArray manualProposalApprovedDetailsSM(String uname,String company,String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.manualProposalApprovedDetailsSM(uname,company,userfullname);
}

@Override
public JSONArray getManualProposalApprovedDataSM(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualProposalApprovedDataSM(crfId,uname,tid);
}
@Override
public JSONArray manualProposalPendingDetailsMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.manualProposalPendingDetailsMD(uname,company);
}

@Override
public String ApproveManualProposalLicenseMD(String crno,String status,String tid,String uname,String company,String MDnote) {
	
	return userActvityDao.ApproveManualProposalLicenseMD( crno, status, tid, uname, company,MDnote);
}


@Override
public JSONArray manualProposalApprovedDetailsMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.manualProposalApprovedDetailsMD(uname,company);
}
@Override
public JSONArray getManualProposalApprovedDataMD(String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualProposalApprovedDataMD(crfId,uname,tid);
}

@Override
public String SendMailwithattachment(String crno, String tid, String uname, String company, String clientname,
		String environmentKeyNo, String ponumber, String filenameStandard,String endCustomerEmail, String podate,String distributorEmail,String partnerEmail,String linkForEmail) {
	// TODO Auto-generated method stub
	return  userActvityDao.SendMailwithattachment(crno,tid,uname,company,clientname,environmentKeyNo,ponumber,filenameStandard,endCustomerEmail, podate,distributorEmail, partnerEmail, linkForEmail);
}

@Override
public String SMrejectMannualVP(String crno, String company, String rejectreason, String sMnote, String uname,
		String tid) {
	return userActvityDao.SMrejectMannualVP( crno, company, rejectreason,sMnote,uname, tid);
}

@Override
public JSONArray vlxMPropRejectedBymeDetails(String uname, String company, String userfullname) {
	return userActvityDao.vlxMPropRejectedBymeDetails(uname,company,userfullname);
	}

@Override
public String rejectedManualProposalByMD(String crno, String company, String rejectreason, String sMnote, String uname,
		String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.rejectedManualProposalByMD(crno,company, rejectreason, sMnote,uname,tid);
}

@Override
public JSONArray ManualProposalRejectByMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.ManualProposalRejectByMD(uname,company);
}

@Override
public String rejectedByCM(String crno, String company, String rejectreason, String sMnote, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.rejectedByCM(crno,company, rejectreason, sMnote,uname,tid);
}

@Override
public JSONArray ManualPropRejectedBySMList(String uname, String company, String userfullname) {
	return userActvityDao.ManualPropRejectedBySMList(uname,company,userfullname);
}

@Override
public String insertManualPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
		String paymentterms, String prodliscense, String prodamount, String loginuser, String loginUserCompany,
		String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
		String podate, String productsuit, String securitytool, String fixedyear, String Subscriptionyear, String Perpetualyear, String subscriptionANDperpetualYear, String tennurestartdate, String tennureenddate, 
		String tennureMonth ,String tennureYear, String warrantystart, String warrantyend, String warrantyMonth, String  warrantyYear,
		String amcstartdate, String amcenddate, String AMCMonth, String AMCYear,String poReferenceNo) {
	// TODO Auto-generated method stub
	return userActvityDao.insertManualPurchaseOrder(pouploadfile1,proddescrip,customername,paymentterms,prodliscense,prodamount,loginuser,loginUserCompany
			,proposalType,proposalids,vpuploadfileProposal,potype,ponumber,podate,productsuit,securitytool, fixedyear, Subscriptionyear, Perpetualyear, subscriptionANDperpetualYear,  tennurestartdate, tennureenddate,
			tennureMonth, tennureYear, warrantystart, warrantyend, warrantyMonth, warrantyYear, amcstartdate,
			amcenddate, AMCMonth, AMCYear,poReferenceNo);
}

@Override
public String rejectedProposalLicenseBH(String crno, String company, String rejectreason, String sMnote, String uname,
		String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.rejectedProposalLicenseBH(crno,company, rejectreason, sMnote,uname,tid);
}

@Override
public JSONArray proposalLicenseRejectedDetailsBH(String uname, String company, String userfullname, String roletype) {
	// TODO Auto-generated method stub
	return userActvityDao.proposalLicenseRejectedDetailsBH(uname,company,userfullname, roletype );
}


@Override
public String SMrejectLicense(String crno, String rejectreason, String sMnote, String uname,
		String tid) {
	return userActvityDao.SMrejectLicense( crno, rejectreason,sMnote,uname, tid);
	}

@Override
public JSONArray LicenseRejectedBySMList(String uname, String userfullname) {
	return userActvityDao.LicenseRejectedBySMList(uname,userfullname);
	}

@Override
public JSONArray ManualPoRaiseByMeDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.ManualPoRaiseByMeDetails(uname,company);
}

@Override
public JSONArray LicenseRejectedSIList(String uname, String userfullname) {
	return userActvityDao.LicenseRejectedSIList(uname,userfullname);
}


@Override
public JSONArray getPoRaisedManualPOData (String crfId,String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getPoRaisedManualPOData (crfId,uname,tid);
}

@Override
public JSONArray getManualPoRaisedData(String crno, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualPoRaisedData(crno,tid);
}

@Override
public JSONArray PORejectedByCMDetails(String uname, String company, String userfullname) {
	// TODO Auto-generated method stub
	return userActvityDao.PORejectedByCMDetails(uname,company,userfullname);
}

@Override
public JSONArray getFORM3SubmitteddBySupportManager(String uname) {
	// TODO Auto-generated method stub
	return userActvityDao.getFORM3SubmitteddBySupportManager(uname);
}

@Override
public JSONArray SentMailByCMList(String uname, String company, String userfullname, String roletype) {
	// TODO Auto-generated method stub
	return userActvityDao.SentMailByCMList(uname, company, userfullname, roletype);
}

@Override
public JSONArray ReviseManualProposalSendBymeDetailsSI(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.ReviseManualProposalSendBymeDetailsSI(uname,company);
}

@Override
public String SubmitReviseManualProposal(String veloxdata, String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername,
		String secondapprovercontact, String clientname, String description, String totalpriceforallproduct,
		String deploysupport, String clouddeploycharges, String subtotalB, String subtotalAB, String uname,
		String resoucesamount, String aTC, String proposaltype, String perpetualyear, String subscriptionyear,
		String amcsecondyear, String amcthirdyear, String amcfourthyear, String amcfiveyear,
		String secondyearsubscription, String thirdyearsubscription, String fullPathVlxLogo, String fullPathVlxEnd,
		String fullPathSwachBharat, String integrationchargeYesNo, String integrationCharges, String total_C,
		String gSTPERCENTAGE, String grand_Total, String productsuitselect, String scanplusprodversion,
		String secureITprodversion, String enccustomername, String letterhead, String signature, String fixedyear,
		String crno, String tid, String sInote,String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,
		String descforamc,String totalcostAMC,String GRANDTOTALFORAMC ,String gstforamc,
		String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson, String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String manualAmount,MultipartFile[] manualReviseFile) {
	// TODO Auto-generated method stub
	

	return userActvityDao.SubmitReviseManualProposal(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21, manualAmount, manualReviseFile);
}

@Override
public JSONArray reviseManualProposalSendBySIDetails(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.reviseManualProposalSendBySIDetails(uname, company);
}

@Override
public JSONArray revisedManualProposalPendingDetailsMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.revisedManualProposalPendingDetailsMD(uname, company);
}

@Override
public JSONArray getReviseManualProposalApprovedDataMD(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getReviseManualProposalApprovedDataMD(crno,uname,tid);
}

@Override
public JSONArray getManualReviseProposalApprovedDataSI(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualReviseProposalApprovedData(crno, uname, tid);
}

@Override
public JSONArray RevisemanualProposalApprovedDetailsMD(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.RevisemanualProposalApprovedDetailsMD(uname,company);
}

@Override
public JSONArray getManualReviseProposalApprovedData(String crno, String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.getManualReviseProposalApprovedData(crno,uname,tid);
}

@Override
public String ApproveManualReviseProposalMD(String crno, String status, String tid, String uname, String company,
		String mDnote) {
	
	return userActvityDao.ApproveManualReviseProposalMD( crno, status, tid, uname, company,mDnote);
}

@Override
public String UpdatePOdates(String crno, String wstartDate, String wendDate, String aMCstartDate, String aMCendDate,
		String uname) {
	return userActvityDao.UpdatePOdates(crno, wstartDate, wendDate, aMCstartDate, aMCendDate,uname);
}

@Override
public String UpdatePOTenuredates(String crno, String tenureStartDate, String tenureEndDate, String uname) {
	return userActvityDao.UpdatePOTenuredates(crno, tenureStartDate, tenureEndDate, uname);
	}

@Override
public String saveupload(MultipartFile[] invoiceFile, String uname, String crno, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.saveupload(invoiceFile, uname, crno, tid);
}

@Override
public String UpdatePOtypeDateManual(String crno, String proposalType, String fixedyear, String subscriptionyear,
		String perpetualyear, String subscriptionANDperpetualYear, String tennurestartdate, String tennureenddate,
		String tennureMonth, String tennureYear, String warrantystart, String warrantyend, String warrantyMonth,
		String warrantyYear, String amcstartdate, String amcenddate, String aMCMonth, String aMCYear,String poRefNo) {
	// TODO Auto-generated method stub
	return userActvityDao.UpdatePOtypeDateManual(crno, proposalType,fixedyear, subscriptionyear, perpetualyear, subscriptionANDperpetualYear, tennurestartdate, tennureenddate,
			tennureMonth, tennureYear, warrantystart, warrantyend, warrantyMonth, warrantyYear, amcstartdate,
			amcenddate, aMCMonth, aMCYear,poRefNo);
}


@Override
public String rejectedReviseManualProposalByMD(String crno, String company, String rejectreason, String MDnote,
		String uname, String tid) {
	// TODO Auto-generated method stub
	return userActvityDao.rejectedReviseManualProposalByMD(crno,company,rejectreason,MDnote,uname,tid);
}

@Override
public String updateReviseManualProposal(String uname, String company, MultipartFile[] manualReviseFile,
		String poinitiator, String amount, String poinitiatorno, String firstApprovername, String firstapprovercontact,
		String secondApprovername, String secondapprovercontact, String clientname, String description,
		String secureITprodversion, String proposaltype, String perpetualyear, String subscriptionyear,
		String productsuitselect, String scanplusprodversion, String fixedyear, String enccustomername, String crno,
		String tid, String sInote, String contactperson) {
	// TODO Auto-generated method stub
	return userActvityDao.updateReviseManualProposal( uname,  company,  manualReviseFile,
			 poinitiator,  amount,  poinitiatorno,  firstApprovername, firstapprovercontact,
			 secondApprovername, secondapprovercontact, clientname,  description,
			 secureITprodversion,  proposaltype, perpetualyear, subscriptionyear,
			 productsuitselect,  scanplusprodversion,  fixedyear,  enccustomername,  crno,
			tid,  sInote,  contactperson);
}

@Override
public JSONArray getProjectDetails(String uname, String fullname, String role,String designation) {
	
	return userActvityDao.getProjectDetails(uname,fullname, role,designation);
	}

@Override
public JSONArray getAllProjectList(String projectName) {
	// TODO Auto-generated method stub
	return userActvityDao.getAllProjectList(projectName);
}

@Override
public JSONArray getDelayedProjectList(String role, String fullname, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getDelayedProjectList(role, fullname, designation);
}

@Override
public JSONArray getTLProjectDetails(String uname, String fullname, String role, String designation, String tLname) {
	// TODO Auto-generated method stub
	return userActvityDao.getTLProjectDetails(uname,  fullname,  role,  designation,  tLname);
}

@Override
public JSONArray getDevProjectDetails(String uname, String fullname, String role, String designation,
		String developerName) {
	// TODO Auto-generated method stub
	return userActvityDao.getDevProjectDetails(uname, fullname, role, designation, developerName);
}

@Override
public JSONArray getProjectDetailsManager(String managerName) {
	// TODO Auto-generated method stub
	return userActvityDao.getProjectDetailsManager(managerName);
}

@Override
public JSONArray getProjectDetailsProgressMng(String fullname, String managerName) {
	// TODO Auto-generated method stub
	return userActvityDao.getProjectDetailsProgressMng( fullname,  managerName);
}

@Override
public JSONArray getTaskDetailsManager(String uname, String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getTaskDetailsManager(uname, fullname, role, designation);
}

@Override
public JSONArray getTaskDetailsTL(String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getTaskDetailsTL(fullname, role, designation);
}

@Override
public JSONArray getTaskDetailsDev(String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getTaskDetailsDev( fullname, role, designation);
}

@Override
public JSONArray ReviseManualProposalRejectDetailsSI(String uname, String company) {
	// TODO Auto-generated method stub
	return userActvityDao.ReviseManualProposalRejectDetailsSI(uname, company);
}

@Override
public JSONArray trackLoginActivityDetails(String fromDate, String toDate, String selecttype, String selectType2) {
	// TODO Auto-generated method stub
	return userActvityDao.trackLoginActivityDetails(fromDate,toDate,selecttype,selectType2);
}

//01/08
@Override
public JSONArray getTaskDetailsSupport(String uname, String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getTaskDetailsSupport(uname, fullname, role, designation);
}

@Override
public JSONArray getProjectDetailsSupport(String uname, String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getProjectDetailsSupport(uname, fullname, role, designation);
}

@Override
public JSONArray getTLProjectDetailsSupport(String uname, String fullname, String role, String designation,
		String tLname) {
	// TODO Auto-generated method stub
	return userActvityDao.getTLProjectDetailsSupport(uname, fullname, role, designation, tLname);
}

@Override
public JSONArray getProjectDetailsSupport1(String uname, String fullname, String role, String designation) {
	// TODO Auto-generated method stub
	return userActvityDao.getProjectDetailsSupport1(uname, fullname, role, designation);
}

@Override
public JSONArray getDevProjectDetailsSupport(String uname, String fullname, String role, String designation,
		String developerName) {
	// TODO Auto-generated method stub
	return userActvityDao.getDevProjectDetailsSupport(uname, fullname, role, designation, developerName);
}

@Override
public String uploadInvoice(MultipartFile[] invoicefile, String username, String fullname, String srno) {
	// TODO Auto-generated method stub
	return userActvityDao.uploadInvoice(invoicefile, username, fullname, srno);
}



}
