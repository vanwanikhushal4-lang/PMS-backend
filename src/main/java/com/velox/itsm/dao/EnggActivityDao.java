package com.velox.itsm.dao;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

public interface EnggActivityDao {
	public JSONArray getAllEngDetails(String details);
	public String insertEngRaiseTicket(String name1,String datepicker5,String phone,String emailid,String compname,String site,String category,String group,String requestmode,String department,String subject,String description,String priority, String severity, MultipartFile empPic,String subDepartment,String location,String subcat2,String username, String vipuser, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,String  asset_sub_category ,String  asset_Ipaddress);
//	public String insertUserRaiseAssignTicket(String name1,String datepicker5,String phone,String emailid,String compname,String site,String category,String group,String requestmode,String department,String subject,String description,String priority,String enggcat,String enggassignName, MultipartFile empPic1);
	
	public JSONArray getEnggDashboardData(String chartdata);

	
	public JSONArray getEngTicketList();
	public JSONArray gatherEngTicketDetails(String ticketid);
	public JSONArray getEngTicketID(String details);
	public JSONArray getEngTicketTracking(String ticketid);
	public JSONArray getEngTicketTrackingMessage(int ticketid);
	public JSONArray getResolvedEngTicketList();
	public JSONArray getClosedEngTicketList();
//	public String UserPasswordreset(String user,String oldpass,String newpass,String cnfnewpass);
	public JSONArray getEngAssignTickets(String userlist);
	public JSONArray getEngAssignVIPTickets(String userlist);

//	public String ViewEngAssignTicketsT(String tid, String LoginUser);

	public JSONArray EditAssignTickets(String tid, String LoginUser);

	public String UpdateAssignTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate,
			String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic);

	public String getvalueofmail(String eng_branchname, String t_id_s, String STReng, String t_status, String u_email,
			String tcmail, String username);

	public JSONArray getReAssignedEngTickets(String LoginUser);

//	public JSONArray EditReAssinedTicketsDetails(String tid, String LoginUser);

	public String UpdateReAssignEngTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic);

	public JSONArray getResolvedTickets(String LoginUser);

//	public JSONArray getClosedTickets(String LoginUser);

	public JSONArray getHoldTickets();

//	public JSONArray EditHoldTickets(String tid, String LoginUser);

	public String UpdateHoldTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,
			String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile holdPic);

	public String Passwordreset(String user, String oldpass, String newpass, String confpass);
	public JSONArray getEngAssignProblemTickets(String loginUser);
	public JSONArray gatherProblemTicketDetails(String ticketid);
	public String UpdateRCAProblemTicket(String tid, String causeNotes, MultipartFile RCAFilePic);
	public JSONArray getEngRCAProblemTickets(String loginUser);
	public String UpdateFixProblemTicket(String tid, String causeNotes, String fixNotes, String workaroundNotes, MultipartFile FixFilePic);
	public JSONArray getEngFixInProcessProblemTickets(String loginUser);
	public String UpdateResolveProblemTicket(String tid, String causeNotes, String fixNotes,
			String workaroundNotes, String resolveNotes, MultipartFile ResolveFilePic);
	public JSONArray getAllProblemTicketListEng(String ticketList);
	public JSONArray CheckENGTicketUpdateConflict(String ticketid, String currentStatus, String priviousetpnaame, String priviouseemail, String currentselectgrp, String crrentselecengg, String currentatassignto);
	
	//----vip pages--
	
	public JSONArray getVIPReAssignedEngTickets(String LoginUser);
	
	public JSONArray getVIPHoldTickets();
	public JSONArray getResolvedVIPTickets(String loginUser);
	public JSONArray getClosedEngVIPTicketList();
	public JSONArray CheckProblemUpdateConflict(String ticketid, String statusChange);
	
	public JSONArray getenggAssingRequest(String userlist);
	public JSONArray EditAssignRequest(String tid, String loginUser);
	public String UpdateAssignRequests(String tid, String status, String engname, String engsite, String engemailid,
			String engphone, String username, String usercompany, String userbranch, String useremail, String userphone,
			String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority,
			String sub, String description, String category, String subcat1, String subcat2, String solution,
			MultipartFile resolvePic,String severity, String assignTo, String enggcat, String enggassign, String engGroup,String userdepartment, String otheremail);
	public JSONArray getResolveRequest2(String loginUser);
	
	public String insertchangeps(String newseverity, String changenote, String oldpriority, String oldseverity,
			String newpriority, String ticketId, String ticketstatus, String engname, String engcompany, String t_branch,
			String subject2, String t_depatment, String t_company,String category,String subcat1,String subcat2,String usercompany,String username,String description);
	public String insertraisecrf(String tid2, String company2, String branch2, String department2, String sub2,
			String des2, String engnote21,String severity,String priority);
	
	
	public JSONArray getEnggProblemTicket(String loginuser);
	public JSONArray getPrblemListing(String ticketList);
	public JSONArray getAllIncidentTicketList(String loginuser, String status);
	public JSONArray getAllProblemTicketListDashboard(String loginuser, String status);
	public JSONArray getServiceRequestDashboardData(String loginuser);
	public JSONArray getAllServiceRequestDashboard(String status);
	public String insertEngRaiseTicketOnBehalf(String name1, String datepicker5, String phone, String emailid,
			String compname, String site, String category, String subcat1, String requestmode, String department,
			String subject, String description, String priority, String severity, MultipartFile empPic,
			String subDepartment, String location, String subcat2, String usernameofraisedby, String vipuser,
			String t_requester, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,	String  asset_sub_category ,String  asset_Ipaddress);
	public JSONArray getEngAllWorkinProgressticketgernal(String loginUser, String tickettype);
	
	public String UpdateAllWorkInProgressTicket(String tid, String status, String engname, String engcompany,
			String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String severity, String sub, String description, String category,
			String subcat1, String subcat2, String solution, MultipartFile resolvePic, String assignTo, String enggcat, String enggassign, String engGroup, String userdepartment, String assignedEnggemail);
	public String UpdateAssignedHoldandReassignticket(String tid, String status, String engname, String engcompany,
			String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String severity, String sub, String description, String category,
			String subcat1, String subcat2, String solution, MultipartFile resolvePic, String assignTo, String enggcat, String enggassign, String engGroup, String userdepartment, String engemail);
	public JSONArray CheckENGTicketUpdateConflictforReassign(String ticketid, String currentStatus, String priviousetpnaame, String priviouseemail, String currentatassignto, String currentselectgrp, String crrentselecengg);
	public JSONArray CheckENGConflictAfterWorInProgress(String ticketid, String currentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg);
	public JSONArray CheckENGServiceRRequestUpdateConflict(String ticketid, String currentstaus,
			String priviousetpnaame, String priviouseemail, String currentselectgrp, String crrentselecengg,
			String currentatassignto);
	public JSONArray CheckENGConflictAfterWorInProgressServiceRequest(String ticketid, String currentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg);
	
public JSONArray getenggWorkInProgressRequest(String loginUser);
	
	public String UpdateAssignRequestsFromWIP(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup, String otheremail);
	public JSONArray getTcWorkInProgressRequest(String loginUser);
	
	public String UpdateFromWIPRequests(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup, String otheremail);
	public JSONArray getEnggDashboardDataticketgroup(String loginuser);
	public JSONArray getEnggDashboardDataticketCategory(String loginuser);
	public JSONArray getEnggDashboardDataservicerequestgroup(String loginuser);
	public JSONArray getEnggDashboardDaservicerequestcategory(String loginuser);
	public JSONArray priorityseverityserviceengg(String chartdata);
	public JSONArray priorityseverityTicketdashboardengg(String chartdata);
	
	public JSONArray priorityseverityProblemTicketdashboardengg(String chartdata);
	public JSONArray getEnggDashboardDaProblemcategory(String loginuser);
	public JSONArray getEnggDashboardDataProblemticketgroup(String chartdata);
	public JSONArray getIncidentGroupList(String loginuser,String lastmonth, String group);
	public JSONArray getServiceGroupList(String loginuser, String lastmonth, String group);
	public JSONArray getProblemGroupList(String loginuser, String lastmonth, String group);
	public JSONArray getIncidentCategoryListing(String loginuser, String lastmonth, String category);
	public JSONArray getServiceRequestCategoryListing(String loginuser, String lastmonth, String category);
	public JSONArray getPrioritySeverityIncidentListing(String loginuser, String lastmonth, String priority,
			String severity);
	public JSONArray getPrioritySeverityServiceListing(String loginuser, String lastmonth, String priority,
			String severity);
	public JSONArray getPrioritySeverityProblemListing(String loginuser, String lastmonth, String priority,
			String severity);
	public JSONArray getCategoryProblemListing(String loginuser, String lastmonth, String category);
	
	//Engineer Report
	
	public JSONArray GetEnggWiseReportSuccess(String FromDate,String ToDate);
}
