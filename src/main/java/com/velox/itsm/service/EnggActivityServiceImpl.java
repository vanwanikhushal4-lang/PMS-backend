package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.dao.EnggActivityDao;

@Service("EnggActivityService")
@Transactional
public class EnggActivityServiceImpl implements EnggActivityService {

	@Autowired
	EnggActivityDao enggActvityDao;

	@Override
	public JSONArray getAllEngDetails(String details) {
		System.out.println("Inside getAllUserDetails ");

		return enggActvityDao.getAllEngDetails(details);
	}
	
	
	@Override
	public JSONArray getEnggDashboardData(String chartdata) {
		System.out.println("getTPDashboardData" + chartdata);
		JSONArray getTPDashboardData_dao_output = enggActvityDao.getEnggDashboardData(chartdata);
		System.out.println("From Service_IMPL_output response " + getTPDashboardData_dao_output);
		return getTPDashboardData_dao_output;
	}
	

	@Override
	public String insertEngRaiseTicket(String name1, String datepicker5, String phone, String emailid, String compname,
			String site, String category, String group, String requestmode, String department, String subject,
			String description, String priority, String severity, MultipartFile empPic,String subDepartment,String location,String subcat2,String username,String vipuser, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,String  asset_sub_category ,String  asset_Ipaddress) {
		// TODO Auto-generated method stub
		return enggActvityDao.insertEngRaiseTicket(name1, datepicker5, phone, emailid, compname, site, category, group,
				requestmode, department, subject, description, priority, severity, empPic, subDepartment,location, subcat2, username, vipuser,assetName,assetCategory,assetStatus,assetCheck , assetTag,  asset_sub_category ,  asset_Ipaddress);
	}
	
	public JSONArray getEngTicketID(String details) {

		return enggActvityDao.getEngTicketID(details);
	}

	@Override
	public JSONArray getEngTicketTracking(String ticketid) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEngTicketTracking(ticketid);
	}


	@Override
	public JSONArray getEngTicketTrackingMessage(int ticketid) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEngTicketTrackingMessage(ticketid);
	}

	@Override
	public JSONArray getEngTicketList() {
		// TODO Auto-generated method stub
		return enggActvityDao.getEngTicketList();
	}

	@Override
	public JSONArray gatherEngTicketDetails(String ticketid) {
		// TODO Auto-generated method stub
		return enggActvityDao.gatherEngTicketDetails(ticketid);
	}

	@Override
	public JSONArray getResolvedEngTicketList() {
		// TODO Auto-generated method stub
		return enggActvityDao.getResolvedEngTicketList();
	}

	@Override
	public JSONArray getClosedEngTicketList() {
		// TODO Auto-generated method stub
		return enggActvityDao.getClosedEngTicketList();
	}

	@Override
	public JSONArray getEngAssignTickets(String userlist) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEngAssignTickets(userlist);
	}
	
	@Override
	public JSONArray getEngAssignVIPTickets(String userlist) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEngAssignVIPTickets(userlist);
	}

//	@Override
//	public String ViewEngAssignTicketsT(String tid, String LoginUser) {
//		// TODO Auto-generated method stub
//		return enggActvityDao.ViewEngAssignTicketsT(tid, LoginUser);
//	}

	@Override
	public JSONArray EditAssignTickets(String tid, String LoginUser) {
		// TODO Auto-generated method stub
		return enggActvityDao.EditAssignTickets(tid, LoginUser);
	}

	@Override
	public String UpdateAssignTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate,
			String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic) {
		// TODO Auto-generated method stub
		return enggActvityDao.UpdateAssignTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic);
	}

	@Override
	public JSONArray getReAssignedEngTickets(String LoginUser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getReAssignedEngTickets(LoginUser);
	}

//	@Override
//	public JSONArray EditReAssinedTicketsDetails(String tid, String LoginUser) {
//		// TODO Auto-generated method stub
//		return enggActvityDao.EditReAssinedTicketsDetails(tid, LoginUser);
//	}

	@Override
	public String UpdateReAssignEngTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic) {
		// TODO Auto-generated method stub
		return enggActvityDao.UpdateReAssignEngTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic);
	}

	@Override
	public JSONArray getResolvedTickets(String LoginUser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getResolvedTickets(LoginUser);
	}

//	@Override
//	public JSONArray getClosedTickets(String LoginUser) {
//		// TODO Auto-generated method stub
//		return enggActvityDao.getClosedTickets(LoginUser);
//	}

	@Override
	public JSONArray getHoldTickets() {
		// TODO Auto-generated method stub
		return enggActvityDao.getHoldTickets();
	}

//	@Override
//	public JSONArray EditHoldTickets(String tid, String LoginUser) {
//		// TODO Auto-generated method stub
//		return enggActvityDao.EditHoldTickets(tid, LoginUser);
//	}

	@Override
	public String UpdateHoldTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile holdPic) {
		// TODO Auto-generated method stub
		return enggActvityDao.UpdateHoldTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, holdPic);
	}

	@Override
	public String Passwordreset(String user, String oldpass, String newpass, String confpass) {
		// TODO Auto-generated method stub
		return enggActvityDao.Passwordreset(user, oldpass, newpass, confpass);
	}

	@Override
	public JSONArray getEngAssignProblemTickets(String loginUser) {
		return enggActvityDao.getEngAssignProblemTickets(loginUser);
	}

	@Override
	public JSONArray gatherProblemTicketDetails(String ticketid) {
		System.out.println("Inside gatherProblemTicketDetails ");

		String controller_response = null;

		System.out.println("gatherProblemTicketDetails name" + ticketid);
		JSONArray gatherProblemTicketDetails_dao_output = enggActvityDao.gatherProblemTicketDetails(ticketid);
		System.out.println("From Service_IMPL_output response " + gatherProblemTicketDetails_dao_output);
		return gatherProblemTicketDetails_dao_output;
	}

	@Override
	public String UpdateRCAProblemTicket(String tid, String causeNotes, MultipartFile RCAFilePic) {
		return enggActvityDao.UpdateRCAProblemTicket(tid, causeNotes, RCAFilePic);
	}

	@Override
	public JSONArray getEngRCAProblemTickets(String loginUser) {
		return enggActvityDao.getEngRCAProblemTickets(loginUser);
	}

	@Override
	public String UpdateFixProblemTicket(String tid, String causeNotes, String fixNotes, String workaroundNotes, MultipartFile FixFilePic) {
		return enggActvityDao.UpdateFixProblemTicket(tid, causeNotes, fixNotes, workaroundNotes, FixFilePic);
	}

	@Override
	public JSONArray getEngFixInProcessProblemTickets(String loginUser) {
		return enggActvityDao.getEngFixInProcessProblemTickets(loginUser);
	}

	@Override
	public String UpdateResolveProblemTicket(String tid, String causeNotes, String fixNotes,
			String workaroundNotes, String resolveNotes, MultipartFile ResolveFilePic) {
		return enggActvityDao.UpdateResolveProblemTicket(tid, causeNotes, fixNotes, workaroundNotes, resolveNotes, ResolveFilePic);
	}

	@Override
	public JSONArray getAllProblemTicketListEng(String ticketList) {
		return enggActvityDao.getAllProblemTicketListEng(ticketList);
	}


	@Override
	public JSONArray CheckENGTicketUpdateConflict(String ticketid, String currentstaus, String priviousetpnaame, String priviouseemail,String currentselectgrp, String crrentselecengg, String currentatassignto) {
		return enggActvityDao.CheckENGTicketUpdateConflict(ticketid,currentstaus,priviousetpnaame, priviouseemail, currentselectgrp,  crrentselecengg,  currentatassignto);
	}
	
	
	@Override
	public JSONArray getVIPHoldTickets() {
		// TODO Auto-generated method stub
		return enggActvityDao.getVIPHoldTickets();
	}
	
	
	@Override
	public JSONArray getVIPReAssignedEngTickets(String LoginUser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getVIPReAssignedEngTickets(LoginUser);
	}


	@Override
	public JSONArray getResolvedVIPTickets(String loginUser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getResolvedVIPTickets(loginUser);
	}


	@Override
	public JSONArray getClosedEngVIPTicketList() {
		// TODO Auto-generated method stub
		return enggActvityDao.getClosedEngVIPTicketList();
	}


	@Override
	public JSONArray CheckProblemUpdateConflict(String ticketid, String statusChange) {
		// TODO Auto-generated method stub
		return enggActvityDao.CheckProblemUpdateConflict(ticketid,statusChange);
	}
	
	@Override
	public JSONArray getenggAssingRequest(String userlist) {
		
		return enggActvityDao.getenggAssingRequest(userlist);
	}


	@Override
	public JSONArray EditAssignRequest(String tid, String loginUser) {
		return enggActvityDao.EditAssignRequest(tid, loginUser);
	}


	@Override
	public String UpdateAssignRequests(String tid, String status, String engname, String engsite, String engemailid,
			String engphone, String username, String usercompany, String userbranch, String useremail, String userphone,
			String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority,
			String sub, String description, String category, String subcat1, String subcat2, String solution,
			MultipartFile resolvePic,String severity , String assignTo, String enggcat, String enggassign,
			String engGroup,String userdepartment,String otheremail) {
		return enggActvityDao.UpdateAssignRequests(tid, status, engname, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,userdepartment,otheremail);
	}

	@Override
	public JSONArray getResolveRequest2(String LoginUser) {
		
		return enggActvityDao.getResolveRequest2(LoginUser);

		
	}
	@Override
	public String insertchangeps(String newseverity, String changenote, String oldpriority, String oldseverity,
			String newpriority, String ticketId, String ticketstatus, String engname, String engcompany, String t_branch,
			String subject2, String t_department, String t_company,String category,String subcat1,String subcat2,String usercompany,String username,String description) {

		
		return enggActvityDao.insertchangeps( newseverity,  changenote,  oldpriority,  oldseverity,
				newpriority,  ticketId,  ticketstatus,  engname,  engcompany,  t_branch,
			 subject2,  t_department,  t_company, category, subcat1, subcat2, usercompany, username, description);
	}


	@Override
	public String insertraisecrf(String tid2, String company2, String branch2, String department2, String sub2,
			String des2, String engnote21, String severity, String priority) {
		
		return enggActvityDao.insertraisecrf( tid2,  company2,  branch2,  department2,  sub2,
			 des2,  engnote21,severity,priority);
	}
	@Override
	public JSONArray getEnggProblemTicket(String loginuser) {
		return enggActvityDao.getEnggProblemTicket(loginuser);
	}


	@Override
	public JSONArray getPrblemListing(String ticketList) {
		
		return enggActvityDao.getPrblemListing(ticketList);
	}


	@Override
	public JSONArray getAllIncidentTicketList(String loginuser, String status) {
		return enggActvityDao.getAllIncidentTicketList(loginuser,status);
	}


	@Override
	public JSONArray getAllProblemTicketListDashboard(String loginuser, String status) {
		return enggActvityDao.getAllProblemTicketListDashboard(loginuser,status);
	}


	@Override
	public JSONArray getServiceRequestDashboardData(String loginuser) {
		return enggActvityDao.getServiceRequestDashboardData(loginuser);
	}


	@Override
	public JSONArray getAllServiceRequestDashboard(String status) {
		
		return enggActvityDao.getAllServiceRequestDashboard(status);
	}
	

	@Override
	public String insertEngRaiseTicketOnBehalf(String name1, String datepicker5, String phone, String emailid,
			String compname, String site, String category, String subcat1, String requestmode, String department,
			String subject, String description, String priority, String severity, MultipartFile empPic,
			String subDepartment, String location, String subcat2, String usernameofraisedby, String vipuser,
			String t_requester, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,	String  asset_sub_category ,String  asset_Ipaddress) {
	
		
		return enggActvityDao.insertEngRaiseTicketOnBehalf(name1, datepicker5, phone, emailid, compname, site, category, subcat1,
				requestmode, department, subject, description, priority, severity, empPic, subDepartment,location, subcat2, usernameofraisedby, vipuser,t_requester,  assetName,  assetCategory,  assetStatus,  assetCheck,  assetTag,	  asset_sub_category ,  asset_Ipaddress);
	}


	@Override
	public JSONArray getEngAllWorkinProgressticketgernal(String loginUser,String tickettype) {
		return enggActvityDao.getEngAllWorkinProgressticketgernal(loginUser, tickettype);
		}


	@Override
	public String UpdateAllWorkInProgressTicket(String tid, String status, String engname, String engcompany,
			String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String severity, String sub, String description, String category,
			String subcat1, String subcat2, String solution, MultipartFile resolvePic,String assignTo, String enggcat, String enggassign, String engGroup, String userdepartment,String assignedEnggemail) {
		
		
		
		return enggActvityDao.UpdateAllWorkInProgressTicket(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic, assignTo,  enggcat,  enggassign,  engGroup,  userdepartment,assignedEnggemail);
	}

		


	@Override
	public String UpdateAssignedHoldandReassignticket(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate,
			String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic,String assignTo,String enggcat, String enggassign,String engGroup,String userdepartment,String engemail) {
		// TODO Auto-generated method stub
		return enggActvityDao.UpdateAssignedHoldandReassignticket(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic,assignTo,enggcat,enggassign,engGroup,userdepartment, engemail);
	}
	

	@Override
	public JSONArray CheckENGTicketUpdateConflictforReassign(String ticketid,String CurrentStatus ,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		return enggActvityDao.CheckENGTicketUpdateConflictforReassign(ticketid,CurrentStatus,  priviousetpnaame,  priviouseemail, currentatassignto,  currentselectgrp,  crrentselecengg);
	}

	@Override
	public JSONArray CheckENGConflictAfterWorInProgress(String ticketid, String currentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		return enggActvityDao.CheckENGConflictAfterWorInProgress(ticketid,currentStatus,priviousetpnaame,priviouseemail,currentatassignto,currentselectgrp,crrentselecengg);
	}
	@Override
	public JSONArray CheckENGServiceRRequestUpdateConflict(String ticketid, String currentstaus, String priviousetpnaame, String priviouseemail,String currentselectgrp, String crrentselecengg, String currentatassignto) {
		return enggActvityDao.CheckENGServiceRRequestUpdateConflict(ticketid,currentstaus,priviousetpnaame, priviouseemail, currentselectgrp,  crrentselecengg,  currentatassignto);
	}
	
	@Override
	public JSONArray CheckENGConflictAfterWorInProgressServiceRequest(String ticketid, String currentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		return enggActvityDao.CheckENGConflictAfterWorInProgressServiceRequest(ticketid,currentStatus,priviousetpnaame,priviouseemail,currentatassignto,currentselectgrp,crrentselecengg);
	}
	@Override
	public JSONArray getenggWorkInProgressRequest(String loginUser) {
		return enggActvityDao.getenggWorkInProgressRequest(loginUser);
	}


	@Override
	public String UpdateAssignRequestsFromWIP(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup,String otheremail) {
		
		return enggActvityDao.UpdateAssignRequestsFromWIP(tid, status, engname, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,otheremail);
	}


	@Override
	public JSONArray getTcWorkInProgressRequest(String loginUser) {
		return enggActvityDao.getTcWorkInProgressRequest(loginUser);
	}
	
	@Override
	public String UpdateFromWIPRequests(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup,String otheremail) {
		
		return enggActvityDao.UpdateFromWIPRequests(tid, status, engname, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,otheremail);
	}


	@Override
	public JSONArray getEnggDashboardDaservicerequestcategory(String loginuser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEnggDashboardDaservicerequestcategory(loginuser);
	}


	@Override
	public JSONArray getEnggDashboardDataservicerequestgroup(String loginuser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEnggDashboardDataservicerequestgroup(loginuser);
	}


	@Override
	public JSONArray getEnggDashboardDataticketCategory(String loginuser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEnggDashboardDataticketCategory(loginuser);
	}


	@Override
	public JSONArray getEnggDashboardDataticketgroup(String loginuser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEnggDashboardDataticketgroup(loginuser);
	}


	@Override
	public JSONArray priorityseverityserviceengg(String chartdata) {
		// TODO Auto-generated method stub
		return enggActvityDao.priorityseverityserviceengg(chartdata);
	}


	@Override
	public JSONArray priorityseverityTicketdashboardengg(String chartdata) {
		// TODO Auto-generated method stub
		return enggActvityDao.priorityseverityTicketdashboardengg(chartdata);
	}


	@Override
	public JSONArray priorityseverityProblemTicketdashboardengg(String chartdata) {
		// TODO Auto-generated method stub
		return enggActvityDao.priorityseverityProblemTicketdashboardengg(chartdata);
	}


	@Override
	public JSONArray getEnggDashboardDaProblemcategory(String loginuser) {
		// TODO Auto-generated method stub
		return enggActvityDao.getEnggDashboardDaProblemcategory(loginuser);
	}


	@Override
	public JSONArray getEnggDashboardDataProblemticketgroup(String chartdata) {
		return enggActvityDao.getEnggDashboardDataProblemticketgroup(chartdata);
	}


	@Override
	public JSONArray getIncidentGroupList(String loginuser,String lastmonth, String group) {
		// TODO Auto-generated method stub
		return enggActvityDao.getIncidentGroupList(loginuser,lastmonth,group);
	}

	@Override
	public JSONArray getServiceGroupList(String loginuser,String lastmonth, String group) {
		// TODO Auto-generated method stub
		return enggActvityDao.getServiceGroupList(loginuser,lastmonth,group);
	}


	@Override
	public JSONArray getProblemGroupList(String loginuser, String lastmonth, String group) {
		// TODO Auto-generated method stub
		return enggActvityDao.getProblemGroupList(loginuser,lastmonth,group);
	}


	@Override
	public JSONArray getIncidentCategoryListing(String loginuser, String lastmonth, String category) {
		// TODO Auto-generated method stub
		return enggActvityDao.getIncidentCategoryListing(loginuser,lastmonth,category);
	}



	@Override
	public JSONArray getServiceRequestCategoryListing(String loginuser, String lastmonth, String category) {
		// TODO Auto-generated method stub
		return enggActvityDao.getServiceRequestCategoryListing(loginuser,lastmonth,category);
	}
	
	@Override
	public JSONArray getPrioritySeverityIncidentListing(String loginuser, String lastmonth, String priority,
			String severity) {
		// TODO Auto-generated method stub
		return enggActvityDao.getPrioritySeverityIncidentListing(loginuser,lastmonth,priority,severity);
	}


	@Override
	public JSONArray getPrioritySeverityServiceListing(String loginuser, String lastmonth, String priority,
			String severity) {
		// TODO Auto-generated method stub
		return enggActvityDao.getPrioritySeverityServiceListing(loginuser,lastmonth,priority,severity);
	}


	@Override
	public JSONArray getPrioritySeverityProblemListing(String loginuser, String lastmonth, String priority,
			String severity) {
		// TODO Auto-generated method stub
		return enggActvityDao.getPrioritySeverityProblemListing(loginuser,lastmonth,priority,severity);
	}

	@Override
	public JSONArray getCategoryProblemListing(String loginuser, String lastmonth, String category) {
		// TODO Auto-generated method stub
		return enggActvityDao.getCategoryProblemListing(loginuser,lastmonth,category);
	}

// Engineer Report
	
	@Override
	public JSONArray GetEnggWiseReportSuccess(String FromDate, String ToDate) {
		// TODO Auto-generated method stub
		return enggActvityDao.GetEnggWiseReportSuccess(FromDate, ToDate);
	}

}
