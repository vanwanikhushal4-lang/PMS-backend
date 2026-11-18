package com.velox.itsm.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.dao.PmsDao;

@Service("PmsService")
@Transactional
public class PmsServiceImpl implements PmsService {
	

	@Autowired
	PmsDao pmsDao;

	
   
	
	@Override
	public JSONArray getAssigneProjectNames() {
		return pmsDao.getAssigneProjectNames();
	}

	
	@Override
	public JSONArray getProjectNames() {
		return pmsDao.getProductNames();
	}
	
	@Override
	public JSONArray getNameDetails() {
		// TODO Auto-generated method stub
		return pmsDao.getNameDetails();
	}

	@Override
	public JSONArray getDesignationNameDetails() {
		// TODO Auto-generated method stub
		return pmsDao.getDesignationNameDetails();
	}

	@Override
	public JSONArray getUserNameDetails(String desigName) {
		// TODO Auto-generated method stub
		return pmsDao.getUserNameDetails(desigName);
	}

	@Override
	public JSONArray getUserId(String userid) {
		// TODO Auto-generated method stub
		return pmsDao.getUserId(userid);
	}

	@Override
	public String saveNewRD(MultipartFile[] rdFile, MultipartFile[] maskedPOFile, String poNumber,
			String producSuiteNames, String Securitytool, String ProdManager, String functionName, String noteType,
			String username, String userid, String uname, MultipartFile[] scopeWork, MultipartFile[] rFPFile, MultipartFile[] otherFile) {
		// TODO Auto-generated method stub
		return pmsDao.saveNewRD(rdFile,maskedPOFile,poNumber, producSuiteNames, Securitytool, ProdManager,functionName, noteType,username,
				userid,uname,scopeWork,rFPFile,otherFile);
	}

	//UD
	@Override
	public String saveNewUD(MultipartFile[] udFile,MultipartFile[] otherFile,String poNumber,String producSuiteNames,String Securitytool,String ProdManager,String functionName,String noteType,
			String userid,String username,String uname,String Teamlead,String note,String Dev,String rd_id, String projectdesc, String projectobj, String projectscope, String funcreq, String nonfuncreq, String techreq, String startdate, String enddate) {
		return pmsDao.saveNewUD(udFile,otherFile,poNumber, producSuiteNames, Securitytool, ProdManager, functionName, noteType,
				userid,username,uname,Teamlead,note,Dev,rd_id,projectdesc,projectobj,projectscope,funcreq,nonfuncreq,techreq,startdate,enddate);
	}
	
	//03
	@Override
	public JSONArray getProjectHeadList() {
		// TODO Auto-generated method stub
		return pmsDao.getProjectHeadList();
	}
	
	//04
	@Override
	public String SavePKMeeting(String uname, String fullname, String crno, String tid, String projhead, String salemgr,
			String prodmgr, String startdate, String typeofmeet, String typeofrm, String roomCapacity,
			String meetingResource, String vpersonmeeting, String vpresourcemeeting, String meetingTypes,
			String meetingTypesvideo,MultipartFile[] uploadMom ,MultipartFile[]planUploadMom,String link, String poNumber) {
		return pmsDao.SavePKMeeting(uname,fullname,crno,tid,projhead,salemgr,prodmgr,startdate,typeofmeet,typeofrm,roomCapacity,meetingResource,vpersonmeeting,vpresourcemeeting,meetingTypes,meetingTypesvideo,uploadMom ,planUploadMom,link,poNumber);
	}
	
	// 1st Row
	
		@Override
		public JSONArray getProjectHead() {
			return pmsDao.getProjectHead();
		}


		@Override
		public JSONArray getSalesManager() {
			return pmsDao.getSalesManager();
			}


		@Override
		public JSONArray getProductionManager() {
			return pmsDao.getProductionManager();
		}


		@Override
		public JSONArray getroomdetails() {
			// TODO Auto-generated method stub
			return  pmsDao.getroomdetails();
		}


		@Override
		public JSONArray pendingdevtask(String uname, String company, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.pendingdevtask(uname,company,userfullname);
		}


		@Override
		public JSONArray ViewUDDocuments() {
			// TODO Auto-generated method stub
			return pmsDao.ViewUDDocuments();
		}


		@Override
		public JSONArray ViewRdPendingDetailsMD(String crno) {
			// TODO Auto-generated method stub
			return pmsDao.ViewRdPendingDetailsMD(crno);
		}


		@Override
		public JSONArray apprvlRdByMe() {
			// TODO Auto-generated method stub
			return pmsDao.apprvlRdByMe();
}


		@Override
		public JSONArray apprvlUdDocuments() {
			// TODO Auto-generated method stub
			return pmsDao.apprvlUdDocuments();
}


		@Override
		public JSONArray ViewUdPendingDetailsMD(String crno) {
			// TODO Auto-generated method stub
			return pmsDao.ViewUdPendingDetailsMD(crno);
		}
		
		
		@Override
		public String saveTaskDetails(String pONumb, String date, String customername, String productLicense,
				String implementorName, String implementorNumber, String cusImplementorEmail, String salesManagerName,
				String endCustomerName, String endCustomerNumber, String paymentTermsPO, String description, String alldata) {
			return pmsDao.saveTaskDetails(pONumb,date,customername,productLicense,implementorName,implementorNumber,cusImplementorEmail,salesManagerName,endCustomerName,endCustomerNumber,paymentTermsPO,description,alldata);
		}


		@Override
		public JSONArray getImplemetorFORMData(String crfId, String uname, String tid, String fullname) {
			// TODO Auto-generated method stub
			return pmsDao.getImplemetorFORMData(crfId,uname,tid,fullname);
		}


		@Override
		public JSONArray viewapprvlRdByMe(String crno) {
			// TODO Auto-generated method stub
			return pmsDao.viewapprvlRdByMe(crno);
		}


		@Override
		public JSONArray ViewUdApprovedByMD(String crno) {
			// TODO Auto-generated method stub
			return pmsDao.ViewUdApprovedByMD(crno);
		}


		@Override
		public JSONArray ApprovedUDByMD(String uname) {
			// TODO Auto-generated method stub
			return pmsDao.ApprovedUDByMD(uname);
		}


		@Override
		public JSONArray RejectedCMDetails(String uname, String company) {
			// TODO Auto-generated method stub
			return pmsDao.RejectedCMDetails(uname, company);
		}


		@Override
		public JSONArray getDevTaskData(String crno, String uname, String tid) {
			// TODO Auto-generated method stub
			return pmsDao.getDevTaskData(crno, uname, tid);
		}


		@Override
		public JSONArray getRdDetailsTable() {
			// TODO Auto-generated method stub
			return pmsDao.getRdDetailsTable();
		}


		@Override
		public JSONArray getUdDetailsTable() {
			// TODO Auto-generated method stub
			return pmsDao.getUdDetailsTable();
		}


		@Override
		public JSONArray getProjectKickMeetingTable() {
			// TODO Auto-generated method stub
			return pmsDao.getProjectKickMeetingTable();
		}


		@Override
		public String ApproveRdDetailsByMD(String crno, String status) {
			// TODO Auto-generated method stub
			return pmsDao.ApproveRdDetailsByMD(crno,status);
		}


		@Override
		public String ApproveUDDetailsByMD(String crno, String status,String uname,String prodManager) {
			// TODO Auto-generated method stub
			return pmsDao.ApproveUDDetailsByMD(crno, status,uname,prodManager);
		}


		@Override
		public JSONArray gettaskdetails() {
			// TODO Auto-generated method stub
			return pmsDao.gettaskdetails() ;
		}
		
		@Override
		public String saveDayWiseTask(String taskData, String userfullname) {
			return pmsDao.saveDayWiseTask(taskData, userfullname);
		}

		@Override
		public String saveMainTask(String functionName, String moduleName, String responsibility, String managerName,
				String teamLeader, String developer, String startdate, String enddate, String inputRemark,
				String description) {
			// TODO Auto-generated method stub
			return pmsDao.saveMainTask(functionName, moduleName, responsibility, managerName,
								teamLeader, developer, startdate, enddate, inputRemark,description);
		}


		@Override
		public JSONArray getDevTaskDetails(String uname) {
			// TODO Auto-generated method stub
			return pmsDao.getDevTaskDetails(uname);
		}

		
		@Override
		public JSONArray getDevAssignedTaskDetails(String crno, String tid) {
			
			return pmsDao.getDevAssignedTaskDetails( crno, tid);
		}


		@Override
		public String updateTaskStatus(String crno, String tid, String status, String remark,String Manager_Name,String Team_Leader,String Developer,String End_Date, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.updateTaskStatus(crno, tid, status, remark,Manager_Name,Team_Leader,Developer,End_Date, userfullname);
		}
		
		@Override
		public JSONArray getImplTaskList(String uname, String tStatus) {
			// TODO Auto-generated method stub
			return pmsDao.getImplTaskList(uname, tStatus);
		}


		@Override
		public JSONArray getImplTaskDetails(String uname, String crno, String tid) {
			// TODO Auto-generated method stub
			return pmsDao.getImplTaskDetails(uname, crno, tid);
		}


		@Override
		public JSONArray pendingRdDocumentsBySI() {
			// TODO Auto-generated method stub
			return pmsDao.pendingRdDocumentsBySI();
		}


		@Override
		public String ApproveRdDetailsBySI(String crno, String status) {
			// TODO Auto-generated method stub
			return pmsDao.ApproveRdDetailsBySI(crno, status);
		}


		@Override
		public JSONArray pendingUdDocumentsBySI() {
			// TODO Auto-generated method stub
			return pmsDao.pendingUdDocumentsBySI();
		}


		@Override
		public String ApproveUDDetailsBySI(String crno, String status) {
			// TODO Auto-generated method stub
			return pmsDao.ApproveUDDetailsBySI(crno, status);
		}
		
		@Override
		public JSONArray getPonumber() {
			// TODO Auto-generated method stub
			return pmsDao.getPonumber();
		}


		@Override
		public JSONArray getproducSuite(String poNumber) {
			// TODO Auto-generated method stub
			return pmsDao.getproducSuite(poNumber);
		}


		@Override
		public JSONArray getSecuritytool(String producsuite) {
			// TODO Auto-generated method stub
			return pmsDao.getSecuritytool(producsuite);
		}


		@Override
		public JSONArray getFunctionName() {
			// TODO Auto-generated method stub
			return pmsDao.getFunctionName();
}


		@Override
		public JSONArray getselectrddetails(String selectrddetails) {
			// TODO Auto-generated method stub
			return pmsDao.getselectrddetails(selectrddetails);
		}


		@Override
		public JSONArray getRDDropdownValue() {
			// TODO Auto-generated method stub
			return pmsDao.getRDDropdownValue();
		}


		@Override
		public JSONArray getimplformcdetails(String selectrddetails) {
			// TODO Auto-generated method stub
			return pmsDao.getimplformcdetails(selectrddetails);
		}

		@Override
		public JSONArray ApprovedUDListImpl(String uname) {
			return pmsDao.ApprovedUDListImpl(uname);
		}


		@Override
		public JSONArray getUDDetails(String crno, String uid, String uname) {
			return pmsDao.getUDDetails(crno,uid, uname);
		}


		@Override
		public JSONArray getRDdetails(String uid, String uname) {
			return pmsDao.getRDdetails(uid, uname);
		}


		@Override
		public JSONArray submittedUdByMe(String uname) {
			// TODO Auto-generated method stub
			return pmsDao.submittedUdByMe(uname);
		}


		@Override
		public String rejectUDbyMD(String crno, String company, String rejectreason, String sMnote, String uname,
				String tid) {
			// TODO Auto-generated method stub
			return pmsDao.rejectUDbyMD(crno, company, rejectreason, sMnote,uname,tid);
		}


		@Override
		public JSONArray rejectedUdByMeDetails() {
			// TODO Auto-generated method stub
			return pmsDao.rejectedUdByMeDetails();
		}
	

		@Override
		public JSONArray getManagerByTool(String poNumber) {
			// TODO Auto-generated method stub
			return pmsDao.getManagerByTool(poNumber);
		}


		@Override
		public JSONArray getMaskedPOFile(String poNumber) {
			return pmsDao.getMaskedPOFile(poNumber);
		}


		@Override
		public JSONArray getpmsdetails(String projectdata) {
			// TODO Auto-generated method stub
			return pmsDao.getpmsdetails(projectdata);
		}


		@Override
		public JSONArray getPoByCustomerName(String projName) {
			return pmsDao.getPoByCustomerName(projName);
		}


		@Override
		public JSONArray getproductSuite() {
			// TODO Auto-generated method stub
			return pmsDao.getproductSuite();
		}


		@Override
		public JSONArray getSecuritytoolName(String producsuite) {
			// TODO Auto-generated method stub
			return pmsDao.getSecuritytoolName(producsuite);
		}


		@Override
		public JSONArray getProductManagerByTool(String suitname) {
			// TODO Auto-generated method stub
			return pmsDao.getProductManagerByTool(suitname);
		}


		@Override
		public JSONArray getCustomerList(String suitname) {
			// TODO Auto-generated method stub
			return pmsDao.getCustomerList(suitname);
		}


		@Override
		public JSONArray scheduleMeetings() {
			// TODO Auto-generated method stub
			return pmsDao.scheduleMeetings();
		}


		@Override
		public JSONArray getScheduleMeetingData(String crno) {
			// TODO Auto-generated method stub
			return pmsDao.getScheduleMeetingData(crno);
		}


		@Override
		public String Exportallpurchaseorder(String tableName, String fromDate, String toDate) {
			// TODO Auto-generated method stub
			return pmsDao.Exportallpurchaseorder(tableName, fromDate, toDate);
		}


		@Override
		public JSONArray PiechartPMS(String uname, String userfullname, String role) {
			return pmsDao.PiechartPMS(uname, userfullname, role);
		}


		@Override
		public JSONArray BarchartSCM(String uname, String userfullname, String role) {
			return pmsDao.BarchartSCM(uname, userfullname, role);
		}


		@Override
		public JSONArray getApprovePO(String approvePO) {
			// TODO Auto-generated method stub
			return pmsDao.getApprovePO(approvePO);
		}


		@Override
		public String saveTaskWithoutPO(String functionName, String responsibility, String customerName,
				String productsuit, String productname, String teamLeader, String moduleName, String developer,
				String startdate, String enddate, String inputRemark, String description, String userfullname, String uname, String role, String selectMe
				,String testerName,String weightage,String supportteamLeader,String support) {
			return pmsDao.saveTaskWithoutPO(functionName, responsibility, customerName, productsuit, productname,
					teamLeader, moduleName, developer, startdate, enddate, inputRemark, description, userfullname, uname,  role,  selectMe,testerName,weightage,supportteamLeader, support);
		}
		
		@Override
		public JSONArray getMyTaskList(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getMyTaskList(uname, userfullname, role);
		}


		@Override
		public JSONArray getTesterTaskList(String uname, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getTesterTaskList(uname, userfullname);
		}


		@Override
		public JSONArray containerChartData(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.containerChartData(uname, userfullname, role);
		}


		@Override
		public JSONArray cardDashboardData(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.cardDashboardData(uname, userfullname, role);
		}


		@Override
		public JSONArray getAssignedTaskTL(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getAssignedTaskTL(uname, userfullname, role);
		}


		@Override
		public JSONObject TeamMembers(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.TeamMembers( uname,  userfullname, role);
		}


		@Override
		public JSONArray getTaskDetailList(String customername) {
			// TODO Auto-generated method stub
			return pmsDao.getTaskDetailList(customername);
		}


		@Override
		public JSONArray getProductSuiteName(String module_name) {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteName(module_name);
		}


		@Override
		public JSONArray getTaskdetails(String module_name, String customer_name) {
			// TODO Auto-generated method stub
			return pmsDao.getTaskdetails(module_name,customer_name);
		}


		@Override
		public JSONArray getLatestProjectList() {
			// TODO Auto-generated method stub
			return pmsDao.getLatestProjectList();
		}


		@Override
		public JSONArray getAssignedTaskTester(String uname, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getAssignedTaskTester(uname, userfullname);
		}
		
		@Override
		public JSONArray getprojectontrack() {
			// TODO Auto-generated method stub
			return pmsDao.getprojectontrack();
		}
		
		@Override
		public JSONArray getTotalcompletedproject(String methodName,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTotalcompletedproject(methodName,role);
		}

		@Override
		public JSONArray getActivitiesdalayscount() {
			// TODO Auto-generated method stub
			return pmsDao.getActivitiesdalayscount();
		}
		@Override
		public JSONArray getMgrDelaysActivities(String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getMgrDelaysActivities(userfullname);
		}
		@Override
		public JSONArray getproductsuite(String projectNames) {
			// TODO Auto-generated method stub
			return pmsDao.getproductsuite(projectNames);
		}
		
		@Override
		public JSONArray getproductmgrname(String projectmgrname,String productsuite) {
			// TODO Auto-generated method stub
			return pmsDao.getproductmgrname(projectmgrname,productsuite);
		}
		
		@Override
		public JSONArray getfunctionname(String projectmgrname,String productsuite,String teamleader) {
			// TODO Auto-generated method stub
			return pmsDao.getfunctionname(projectmgrname,productsuite,teamleader);
		}
		
		@Override
		public JSONArray getallfunctionname(String projectmgrname,String productsuite,String teamleader,String allfunction) {
			// TODO Auto-generated method stub
			return pmsDao.getallfunctionname(projectmgrname,productsuite,teamleader,allfunction);
		}
		
		@Override
		public JSONArray getListdelayproject() {
			// TODO Auto-generated method stub
			return pmsDao.getListdelayproject();
		}
		
		@Override
		public JSONArray getproductsuiteActontrack(String projectNames) {
			// TODO Auto-generated method stub
			return pmsDao.getproductsuiteActontrack(projectNames);
		}
		
		@Override
		public JSONArray getproductmgrnameActonTrack(String projectmgrname,String productsuite) {
			// TODO Auto-generated method stub
			return pmsDao.getproductmgrnameActonTrack(projectmgrname,productsuite);
		}
		
		@Override
		public JSONArray getfunctionnameActonTrack(String projectmgrname,String productsuite,String teamleader) {
			// TODO Auto-generated method stub
			return pmsDao.getfunctionnameActonTrack(projectmgrname,productsuite,teamleader);
		}
		
		@Override
		public JSONArray getallfunctionnameActonTracks(String projectmgrname,String productsuite,String teamleader,String allfunction) {
			// TODO Auto-generated method stub
			return pmsDao.getallfunctionnameActonTracks(projectmgrname,productsuite,teamleader,allfunction);
		}
		
		
		@Override
		public JSONArray getPMactonTrack(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getPMactonTrack( uname,  userfullname, role);
		}
		@Override
		public JSONArray getproductsuiteActontrackPM(String projectNames, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getproductsuiteActontrackPM(projectNames, userfullname);
		}


		@Override
		public JSONArray getDevNameActonTrackPM(String producttool, String tlnames) {
			// TODO Auto-generated method stub
			return pmsDao.getDevNameActonTrackPM(producttool,tlnames);
		}


		@Override
		public JSONArray getfunctionnameActonTrackforPM(String projectname, String Teamleadername, String Devname) {
			// TODO Auto-generated method stub
			return pmsDao.getfunctionnameActonTrackforPM(projectname,Teamleadername,Devname);
		}


		@Override
		public JSONArray getallfunctionnameActonTracksPM(String projectname, String tlname, String devname,String allfunction,String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getallfunctionnameActonTracksPM(projectname,tlname,devname,allfunction,userfullname);
		}
		
		@Override
		public JSONArray getallfunctionnameActonTracksDly(String projectname, String tlname, String devname,String allfunction,String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getallfunctionnameActonTracksDly(projectname,tlname,devname,allfunction,userfullname);
		}
		@Override
		public JSONArray getMgrTotalProject(String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getMgrTotalProject(userfullname,role);
		}
		
		@Override
		public JSONArray getprojectontrackMGR(String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectontrackMGR(userfullname,role);
		}
		
		@Override
		public JSONArray getprojectcompletedMGR(String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectcompletedMGR(userfullname,role);
		}
		
		@Override
		public JSONArray getprojectdealyedMGR(String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectdealyedMGR(userfullname,role);
		}


		@Override
		public JSONArray getAllActivities(String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getAllActivities(uname, role, designation);
		}


		@Override
		public JSONArray getAllActivitiesByProj(String projectName, String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getAllActivitiesByProj( projectName, uname, role, designation);
		}


		@Override
		public JSONArray getAllActivitiesByMGR(String projectName, String projectmgrname, String uname, String role,
				String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getAllActivitiesByMGR( projectName, projectmgrname, uname, role, designation);
		}


		@Override
		public JSONArray getAllActivitiesByTL(String projectName, String projectmgrname, String teamleader,
				String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getAllActivitiesByTL( projectName, projectmgrname, teamleader, uname, role, designation);
		}


		@Override
		public JSONArray getTeamLeaderTotalproject(String methodName, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderTotalproject(methodName, userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderTotalcompletedproject(String methodName, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderTotalcompletedproject(methodName, userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderDelayedProjectDetails(String fullname, String role, String designation,
				String delayedProjectName) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderDelayedProjectDetails(fullname,role,designation,delayedProjectName);
		}


		@Override
		public JSONArray getTeamLeaderActivityOnTrack(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderActivityOnTrack(uname, userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderFunctionName(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderFunctionName(uname, userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderDetailsByProjectName(String uname, String role, String designation,
				String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderDetailsByProjectName(uname, role, designation, projectName);
		}


		@Override
		public JSONArray getTeamLeaderActivities(String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderActivities(uname, role, designation);
		}


		@Override
		public JSONArray getTeamLeaderAssignName(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderAssignName(fullname,role,designation);
		}


		@Override
		public JSONArray getTeamLeaderDetailsByAssignToName(String fullname, String role, String designation,
				String projectName, String assignto) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderDetailsByAssignToName(fullname, role, designation, projectName, assignto);
		}


		@Override
		public JSONArray getTeamLeaderDetailsByfunctionName(String fullname, String role, String designation,
				String functionName, String projectName, String assignTo) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderDetailsByfunctionName(fullname, role, designation,
				functionName,projectName,assignTo);
		}
		
		
		@Override
		public JSONArray getTeamLeaderActivityDelayed(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderActivityDelayed(uname, userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderDelayedProjectByProjectName(String fullname, String role, String designation,
				String projectName,String functionName,String assignToName) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderDelayedProjectByProjectName(fullname,role,designation,projectName,functionName,assignToName);
		}


		@Override
		public JSONArray getTeamLeadActivitiesDelayedByProjectName(String projectNames,String fullname) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeadActivitiesDelayedByProjectName(projectNames,fullname);
		}


		@Override
		public JSONArray getAssignToDelayedProjectByProjectName(String fullname, String role, String designation,
				String projectName, String assignTo) {
			// TODO Auto-generated method stub
			return pmsDao.getAssignToDelayedProjectByProjectName(fullname,role,designation,projectName,assignTo);
		}


		@Override
		public JSONArray getActivitiesdalaysByProj(String projectName, String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getActivitiesdalaysByProj( projectName, uname, role, designation);
		}


		@Override
		public JSONArray getActivitiesdalaysByMGR(String projectName, String projectmgrname, String uname, String role,
				String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getActivitiesdalaysByMGR( projectName, projectmgrname, uname, role, designation);
		}


		@Override
		public JSONArray getActivitiesdalaysByTL(String projectName, String projectmgrname, String teamleader,
				String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getActivitiesdalaysByTL( projectName, projectmgrname, teamleader, uname, role, designation);
		}


		@Override
		public JSONArray getDelayedProjectByFunctionName(String fullname, String role, String designation,
				String delayFunctionName, String projectName, String assignTo) {
			// TODO Auto-generated method stub
			return pmsDao.getDelayedProjectByFunctionName(fullname,role,designation,delayFunctionName,projectName,assignTo);
		}


		@Override
		public JSONArray getTeamLeadAssignToActivitiesDelayedByProjectName(String projectNames, String fullname) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeadAssignToActivitiesDelayedByProjectName(projectNames, fullname);
		}


		@Override
		public JSONArray getTeamLeaderFunctionNameByAssignTo(String uname, String userfullname, String role,
				String projectName, String assignToName) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderFunctionNameByAssignTo(uname,userfullname,role,projectName,assignToName);
		}


		@Override
		public JSONArray getproductmgrnameforDelayMD(String projectmgrname) {
			// TODO Auto-generated method stub
			return pmsDao.getproductmgrnameforDelayMD(projectmgrname);
		}


		@Override
		public String updateModifyDate(String crno, String tid, String status, String remark, String end_Date,
				String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.updateModifyDate(crno,tid,status,remark,end_Date,fullname,role,designation);
		}


		@Override
		public JSONArray getMyCompletedTaskList(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getMyCompletedTaskList( uname, userfullname, role);
		}


		@Override
		public JSONArray getallMGRdelayActivity(String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getallMGRdelayActivity( userfullname,role);
		}


		@Override
		public JSONArray getImplReviseTaskDate(String uname, String tStatus,String role, String fullname) {
			// TODO Auto-generated method stub
			return pmsDao.getImplReviseTaskDate(uname,tStatus,role,fullname);
		}


		@Override
		public String updateRevisedTaskDate(String crno, String tid, String status, String remark, String developer,
				String updateEnd_Date, String role, String uname) {
			// TODO Auto-generated method stub
			return pmsDao.updateRevisedTaskDate(crno, tid, status, remark, developer,updateEnd_Date, role, uname);
		}


		@Override
		public JSONArray getReviseTaskList(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getReviseTaskList( uname, userfullname, role);
		}


		@Override
		public JSONArray getprojectnameForMGR(String uname, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectnameForMGR( uname, userfullname, role);
		}


		@Override
		public JSONArray getDeveloperActivitiesByProjectName(String fullname, String role, String designation,
				String productsuitename) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperActivitiesByProjectName(fullname,role,designation,productsuitename);
		}


		@Override
		public JSONArray getDeveloperActivityOnTrack(String uname, String fullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperActivityOnTrack(uname,fullname,role);
		}


		@Override
		public JSONArray getDeveloperActivities(String uname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperActivities(uname,role,designation);
		}


		@Override
		public JSONArray getDeveloperFunctionNameByProjectName(String uname, String fullname, String role,
				String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperFunctionNameByProjectName(uname,fullname,role,projectName);
		}


		@Override
		public JSONArray getDeveloperActivitiesByFunctionName(String fullname, String role, String designation,
				String productsuitename, String functionName) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperActivitiesByFunctionName(fullname,role,designation,productsuitename,functionName);
		}


		@Override
		public JSONArray getDeveloperDelayActivities(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayActivities(fullname,role,designation);
		}


		@Override
		public JSONArray getDeveloperDelayActivity(String uname, String fullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayActivity(uname,fullname,role);
		}


		@Override
		public JSONArray getDeveloperDelayActByProjectName(String fullname, String role, String designation,
				String projectName, String functionName) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayActByProjectName(fullname,role,designation,projectName,functionName);
		}


		@Override
		public JSONArray getDeveloperDelayActByProjectNameOnChange(String fullname, String role, String designation,
				String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayActByProjectNameOnChange(fullname,role,designation,projectName);
		}


		@Override
		public JSONArray getDeveloperDelayActByFunctiontName(String fullname, String role, String designation,
				String projectName, String functionName) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayActByFunctiontName(fullname,role,designation,projectName,functionName);
		}


		@Override
		public JSONArray getAllActivitiesMGR(String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getAllActivitiesMGR( userfullname, role);
		}


		@Override
		public JSONArray getTeamLeaderByMGR(String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getTeamLeaderByMGR( userfullname);
		}


		@Override
		public JSONArray getActivitiesMGRByProj(String userfullname, String role, String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getActivitiesMGRByProj( userfullname, role, projectName);
		}


		@Override
		public JSONArray getMGRTrackActivityByTL(String userfullname, String role, String projectName, String tlName) {
			// TODO Auto-generated method stub
			return pmsDao.getMGRTrackActivityByTL( userfullname, role, projectName, tlName);
		}


		@Override
		public JSONArray getMGRTrackActivityByDev(String userfullname, String role, String projectName, String tlName,
				String devName) {
			// TODO Auto-generated method stub
			return pmsDao.getMGRTrackActivityByDev( userfullname, role, projectName, tlName, devName);
		}


		@Override
		public JSONArray getMGRdelayActivityByProj(String projectName, String userfullname, String role) {
			// TODO Auto-generated method stub
			return pmsDao.getMGRdelayActivityByProj( projectName, userfullname, role);
		}


		@Override
		public JSONArray getMGRdelayActivityByTL(String projectName, String tlname, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getMGRdelayActivityByTL( projectName, tlname, userfullname);
		}


		@Override
		public JSONArray getMGRdelayActivityByDev(String projectName, String tlname, String devname,
				String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getMGRdelayActivityByDev( projectName, tlname, devname,userfullname);
		}


		@Override
		public JSONArray getProjectListDeveloper(String methodName, String userfullname,String role) {
			// TODO Auto-generated method stub
			return pmsDao.getProjectListDeveloper( methodName, userfullname, role);
		}


		@Override
		public JSONArray getDeveloperExtendedDateTasks(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperExtendedDateTasks( fullname, role, designation);
		}


		@Override
		public JSONArray getDeveloperDelayedTasks(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperDelayedTasks( fullname, role, designation);
		}


		@Override
		public String updateMultipleEndDate(String fullname, String role, String designation, String updatedDates) {
			// TODO Auto-generated method stub
			return pmsDao.updateMultipleEndDate( fullname, role, designation, updatedDates);
		}


		@Override
		public String approveMultipleEndDate(String fullname, String role, String designation, String checkedIds) {
			// TODO Auto-generated method stub
			return pmsDao.approveMultipleEndDate( fullname, role, designation, checkedIds);
		}

		
		
		//18/05
		@Override
		public JSONArray getProductSuiteTree() {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteTree();
		}

		//18/05
		@Override
		public JSONArray getSecuritySolutionTree(String product_suite) {
			// TODO Auto-generated method stub
			return pmsDao.getSecuritySolutionTree(product_suite);
		}


		@Override
		public String getTreeMasterDetails(String product_suite, String security_solution, String project_name) {
			// TODO Auto-generated method stub
			return pmsDao.getTreeMasterDetails(product_suite,security_solution,project_name);
		}


		@Override
		public JSONArray getTreeMasterListing() {
			// TODO Auto-generated method stub
			return pmsDao.getTreeMasterListing();
		}


		@Override
		public String deleteTreeMaster(int srno) {
			// TODO Auto-generated method stub
			return pmsDao.deleteTreeMaster(srno);
		}


		@Override
		public String updatetreemaster(String productsuitupdate, String securitysolutionupdate,
				String projectnameupdate, int sr_no) {
			// TODO Auto-generated method stub
			return pmsDao.updatetreemaster(productsuitupdate,securitysolutionupdate,projectnameupdate,sr_no);
		}


		@Override
		public JSONArray gettreesuitList() {
			// TODO Auto-generated method stub
			return pmsDao.gettreesuitList();
		}


		@Override
		public String UpdateManualPORaiseBySI(String crno, String proposalType, String fixedyear,
				String subscriptionyear, String perpetualyear, String subscriptionANDperpetualYear,
				String tennurestartdate, String tennureenddate, String tennureMonth, String tennureYear,
				String warrantystart, String warrantyend, String warrantyMonth, String warrantyYear,
				String amcstartdate, String amcenddate, String AMCMonth, String AMCYear, String poRefNo,
				String taskData, MultipartFile[] pouploadfile1) {
			// TODO Auto-generated method stub
			return pmsDao.UpdateManualPORaiseBySI( crno,  proposalType,  fixedyear,
				 subscriptionyear,  perpetualyear,  subscriptionANDperpetualYear,
				tennurestartdate,tennureenddate,tennureMonth,tennureYear,warrantystart,warrantyend,
				warrantyMonth,warrantyYear,amcstartdate, amcenddate,AMCMonth,AMCYear,poRefNo,taskData,pouploadfile1);
		}


		@Override
		public String savefileUploadKey(MultipartFile[] fileUploadKey) {
			// TODO Auto-generated method stub
			return pmsDao.savefileUploadKey(fileUploadKey);
		}

		//
		@Override 
		public String updateMultipleData(String checkedIds) {
			return pmsDao.updateMultipleData(checkedIds); 
		}


		//01/06
		@Override
		public JSONArray getprojectonhold() {
			// TODO Auto-generated method stub
			return pmsDao.getprojectonhold();
		}


		@Override
		public JSONArray getDeactivatedAccounts(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeactivatedAccounts( fullname, role, designation);
		}


		@Override
		public String activateAccounts(String fullname, String role, String designation, String checkedIds) {
			// TODO Auto-generated method stub
			return pmsDao.activateAccounts( fullname, role, designation, checkedIds);
		}

		
		//05/06
		@Override
		public JSONArray getAllDeveloperList(String role) {
			// TODO Auto-generated method stub
			return pmsDao.getAllDeveloperList(role);
		}
		
		
		@Override
		public JSONArray getReassignTaskSideDetails(String role, String fullname) {
			// TODO Auto-generated method stub
			return pmsDao.getReassignTaskSideDetails(role, fullname);
		}


		//10/06
		@Override
		public String reassinTaskToDeveloper(String fullname, String role, String designation, String selectedNames) {
			// TODO Auto-generated method stub
			return pmsDao.reassinTaskToDeveloper(fullname,role,designation,selectedNames);
		}


		@Override
		public JSONArray ActivitiesCompletedcount(String role,String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.ActivitiesCompletedcount(role,userfullname);
		}


		@Override
		public JSONArray getprojectonholdformgr(String role,String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectonholdformgr(role,userfullname);
		}

		//29/07
		@Override
		public JSONArray getAssignedTaskMe(String uname, String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.getAssignedTaskMe(uname,userfullname);
		}


		@Override
		public JSONArray getMaskedPOList(String role) {
			// TODO Auto-generated method stub
			return pmsDao.getMaskedPOList( role);
		}


		//17/08
		@Override
		public JSONArray ActivitiesCompletedcountNew(String role, String userfullname, String methodName) {
			// TODO Auto-generated method stub
			return pmsDao.ActivitiesCompletedcountNew(role, userfullname, methodName);
		}
		
		@Override
		public JSONArray totalprojectNamesList() {
			// TODO Auto-generated method stub
			return pmsDao.totalprojectNamesList();
		}


		@Override
		public JSONArray totalprojectbyName(String selected_Project,String productSuite, String productTool, String managerName, String status) {
			// TODO Auto-generated method stub
			return pmsDao.totalprojectbyName(selected_Project,productSuite,productTool,managerName,status);
		}


		@Override
		public JSONArray getProductSuiteTotalProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteTotalProj();
		}


		@Override
		public JSONArray getProductToolsTotalProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductToolsTotalProj();
		}


		@Override
		public JSONArray getManagerTotalProj() {
			// TODO Auto-generated method stub
			return pmsDao.getManagerTotalProj();
		}


		@Override
		public JSONArray getStatusTotalProj() {
			// TODO Auto-generated method stub
			return pmsDao.getStatusTotalProj();
		}


		@Override
		public JSONArray getprodSuiteByProjName(String selected_Project) {
			// TODO Auto-generated method stub
			return pmsDao.getprodSuiteByProjName(selected_Project);
		}


		@Override
		public JSONArray getprodToolByProdSuite(String productSuite) {
			// TODO Auto-generated method stub
			return pmsDao.getprodToolByProdSuite(productSuite);
		}


		@Override
		public JSONArray getProductToolTotalAct() {
			// TODO Auto-generated method stub
			return pmsDao.getProductToolTotalAct();
		}


		@Override
		public JSONArray getManagerByProdTool(String productTool) {
			// TODO Auto-generated method stub
			return pmsDao.getManagerByProdTool(productTool);
		}


		@Override
		public JSONArray getMangerNameTotalAct() {
			// TODO Auto-generated method stub
			return pmsDao.getMangerNameTotalAct();
		}


		@Override
		public JSONArray getStatusByManager(String managerName) {
			// TODO Auto-generated method stub
			return pmsDao.getStatusByManager(managerName);
		}


		@Override
		public JSONArray getStatusTotalProject() {
			// TODO Auto-generated method stub
			return pmsDao.getStatusTotalProject();
		}
		
		@Override
		public JSONArray cmplteprojectList() {
			// TODO Auto-generated method stub
			return pmsDao.cmplteprojectList();
		}


		@Override
		public JSONArray getProductSuiteCmplteProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteCmplteProj();
		}


		@Override
		public JSONArray productToolCmpltProj() {
			// TODO Auto-generated method stub
			return pmsDao.productToolCmpltProj();
		}


		@Override
		public JSONArray getManagerCmplteProj() {
			// TODO Auto-generated method stub
			return pmsDao.getManagerCmplteProj();
		}


		@Override
		public JSONArray getprojectNameCmplteProject(String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectNameCmplteProject(projectName);
		}


		@Override
		public JSONArray getTotalcompletedprojectList(String projectName, String productSuite, String productTool,
				String managerName) {
			// TODO Auto-generated method stub
			return pmsDao.getTotalcompletedprojectList(projectName,productSuite,productTool,managerName);
		}


		@Override
		public JSONArray getproductSuiteCmplteProject(String productSuite) {
			// TODO Auto-generated method stub
			return pmsDao.getproductSuiteCmplteProject(productSuite);
		}


		@Override
		public JSONArray getmanagerCmplteProject(String productTool) {
			// TODO Auto-generated method stub
			return pmsDao.getmanagerCmplteProject(productTool);
		}


		@Override
		public JSONArray getProductToolsCmplProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductToolsCmplProj();
		}
		
		@Override
		public JSONArray onHoldprojectList() {
			// TODO Auto-generated method stub
			return pmsDao.onHoldprojectList();
		}


		@Override
		public JSONArray getProductSuiteonHoldProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteonHoldProj();
		}


		@Override
		public JSONArray getProductToolsOnHoldProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductToolsOnHoldProj();
		}


		@Override
		public JSONArray getManagerOnHoldProj() {
			// TODO Auto-generated method stub
			return pmsDao.getManagerOnHoldProj();
		}


		@Override
		public JSONArray getprojectonholdDataTable(String projectName, String projectSuite, String projectTool,
				String managerName) {
			// TODO Auto-generated method stub
			return pmsDao.getprojectonholdDataTable(projectName,projectSuite,projectTool,managerName);
		}


		@Override
		public JSONArray getPSuiteonHold(String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getPSuiteonHold(projectName);
		}


		@Override
		public JSONArray getPToolOnHold(String productSuite) {
			// TODO Auto-generated method stub
			return pmsDao.getPToolOnHold(productSuite);
		}


		@Override
		public JSONArray getPManagerOnHold(String productTool) {
			// TODO Auto-generated method stub
			return pmsDao.getPManagerOnHold(productTool);
		}


		@Override
		public JSONArray delayProjectList() {
			// TODO Auto-generated method stub
			return pmsDao.delayProjectList();
		}


		@Override
		public JSONArray getProductSuiteDelayProj() {
			// TODO Auto-generated method stub
			return pmsDao.getProductSuiteDelayProj();
		}


		@Override
		public JSONArray productToolDelayProj() {
			// TODO Auto-generated method stub
			return pmsDao.productToolDelayProj();
		}


		@Override
		public JSONArray getManagerDelayProj() {
			// TODO Auto-generated method stub
			return pmsDao.getManagerDelayProj();
		}


		@Override
		public JSONArray getTotalDelayprojectList(String projectName, String productSuite, String productTool,
				String managerName) {
			// TODO Auto-generated method stub
			return pmsDao.getTotalDelayprojectList( projectName, productSuite, productTool,managerName);
		}


		@Override
		public JSONArray getProdSuiteByProject(String projectName) {
			// TODO Auto-generated method stub
			return pmsDao.getProdSuiteByProject( projectName);
		}


		@Override
		public JSONArray getDelayProdToolBySuite(String productSuite) {
			// TODO Auto-generated method stub
			return pmsDao.getDelayProdToolBySuite( productSuite);
		}


		@Override
		public JSONArray getDelayManagerByTool(String productTool) {
			// TODO Auto-generated method stub
			return pmsDao.getDelayManagerByTool(productTool);
		}


		//03/09/2024
		@Override
		public JSONArray getEmployeeDataForHR() {
			// TODO Auto-generated method stub
			return pmsDao.getEmployeeDataForHR();
		}


		@Override
		public JSONArray getEmployeeDataCount() {
			// TODO Auto-generated method stub
			return pmsDao.getEmployeeDataCount();
		}


		//04/09
		@Override
		public JSONArray getEmployeeCountsByRole() {
			// TODO Auto-generated method stub
			return pmsDao.getEmployeeCountsByRole();
		}


		//05/09/2024
		@Override
		public JSONArray getEmployeeDataOfNewEmps() {
			// TODO Auto-generated method stub
			return pmsDao.getEmployeeDataOfNewEmps();
		}


		//06/09/2024
		@Override
		public JSONArray getTotalEmployees() {
			// TODO Auto-generated method stub
			return pmsDao.getTotalEmployees();
		}


		@Override
		public JSONArray getActiveEmpsOnPms() {
			// TODO Auto-generated method stub
			return pmsDao.getActiveEmpsOnPms();
		}


		//09/09
		@Override
		public JSONArray getMaleEmps() {
			// TODO Auto-generated method stub
			return pmsDao.getMaleEmps();
		}


		@Override
		public JSONArray getFemaleEmps() {
			// TODO Auto-generated method stub
			return pmsDao.getFemaleEmps();
		}


		//11/09
		@Override
		public JSONArray getAssigneProjectNames(String phaseName) {
			// TODO Auto-generated method stub
			return pmsDao.getAssigneProjectNames(phaseName);
		}


		//16/09
		@Override
		public JSONArray getAssignTaskDetails(String selectrddetails) {
			// TODO Auto-generated method stub
			return pmsDao.getAssignTaskDetails(selectrddetails);
		}

		
		//10/10
		@Override
		public JSONArray ActivitiesOnHoldcount(String role,String userfullname) {
			// TODO Auto-generated method stub
			return pmsDao.ActivitiesOnHoldcount(role,userfullname);
		}
		
		//17/10
		@Override
		public JSONArray getDeveloperExtendedStartEndDateTasks(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperExtendedStartEndDateTasks( fullname, role, designation);
		}
		
		
		//17/10
		@Override
		public String updateMultipleStartEndDate(String fullname, String role, String designation, String updatedStartDates, String updatedEndDates, String updateDatesReason) {
			// TODO Auto-generated method stub
			return pmsDao.updateMultipleStartEndDate( fullname, role, designation, updatedStartDates, updatedEndDates, updateDatesReason);
		}
		
		
		//17/10
		@Override
		public String approveMultipleStartEndDateMan(String fullname, String role, String designation, String checkedIds) {
			// TODO Auto-generated method stub
			return pmsDao.approveMultipleStartEndDateMan( fullname, role, designation, checkedIds);
		}
		
		//17/10
		@Override
		public JSONArray getDeveloperExtendedDateTasksMan(String fullname, String role, String designation) {
			// TODO Auto-generated method stub
			return pmsDao.getDeveloperExtendedDateTasksMan( fullname, role, designation);
		}


		//19/10
		@Override
		public JSONArray getListOfReviseDateHistory(String taskDetails) {
			// TODO Auto-generated method stub
			return pmsDao.getListOfReviseDateHistory(taskDetails);
		}
		
		
		//19/10
//		@Override
//		public JSONArray getExcelExport(JSONArray jArray,String excelExportPath) {
//			// TODO Auto-generated method stub
//			return pmsDao.getExcelExport(jArray, excelExportPath);
//		}
		
		
		//06/11
				@Override
				public JSONArray getListOfFeedback() {
					// TODO Auto-generated method stub
					return pmsDao.getListOfFeedback();
				}


				//06/11
				@Override
				public JSONArray getListOfClientFeedback() {
					// TODO Auto-generated method stub
					return pmsDao.getListOfClientFeedback();
				}


				//06/11
				@Override
				public JSONArray getAllFeedbackCounts() {
					// TODO Auto-generated method stub
					return pmsDao.getAllFeedbackCounts();
				}


				//06/11
				@Override
				public JSONArray getTopThreePerformers() {
					// TODO Auto-generated method stub
					return pmsDao.getTopThreePerformers();
				}
				
				
				
				//07/11
				@Override
				public JSONArray getEmployeesHiredThisMonth() {
					// TODO Auto-generated method stub
					return pmsDao.getEmployeesHiredThisMonth();
				}


				//07/11
				@Override
				public JSONArray getHiredComapreCounts() {
					// TODO Auto-generated method stub
					return pmsDao.getHiredComapreCounts();
				}


				@Override
				public String saveCustomizationTask(String customerName,
						String productsuit, String productname, String moduleName, String enddate, String priority,
						String description, String expectedOutput, String userfullname, String uname, String role,
						String designation) {
					// TODO Auto-generated method stub
					return pmsDao.saveCustomizationTask(customerName,
							productsuit, productname, moduleName, enddate, priority,
							description,  expectedOutput, userfullname, uname, role,
							designation);
				}


				@Override
				public JSONArray getCustomTaskData(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskData( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomTaskList(String role, String fullname) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskList( role, fullname);
				}


				@Override
				public String assignCustomTaskToDeveloper(String fullname, String role, String designation,
						String selectedNames, String updatedDates) {
					// TODO Auto-generated method stub
					return pmsDao.assignCustomTaskToDeveloper( fullname,  role,  designation,selectedNames, updatedDates);
				}


				@Override
				public JSONArray getMyCustomizationTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getMyCustomizationTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomTaskDetails(String role, String userfullname, String designation,
						String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskDetails( role, userfullname, designation, crno) ;
				}


				@Override
				public String updateCustomTaskStatus(String crno, String status, String testerName,
						String testerDescription, String role, String userfullname, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.updateCustomTaskStatus( crno, status, testerName,testerDescription, role, userfullname, designation) ;
				}
				
				
				
				//12/11
				@Override
				public JSONArray getPMOnHoldProject(String uname, String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getPMOnHoldProject(uname, userfullname, role);
				}


				//12/11
				@Override
				public JSONArray getTeamLeaderByMGROnhold(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getTeamLeaderByMGROnhold(userfullname);
				}


				//12/11
				@Override
				public JSONArray getAllActivitiesMGROnhold(String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getAllActivitiesMGROnhold(userfullname, role);
				}


				//12/11
				@Override
				public JSONArray ActivitiesCompletedcountNewMan(String role, String userfullname, String methodName) {
					// TODO Auto-generated method stub
					return pmsDao.ActivitiesCompletedcountNewMan(role, userfullname, methodName);
				}
				
				
				//14/11
				@Override
				public JSONArray getActivitiesUploadedToday(String uname, String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getActivitiesUploadedToday(uname,userfullname,role);
				}


				@Override
				public JSONArray getCustomizationTestingTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomizationTestingTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomTaskTestingDetails(String role, String userfullname, String designation,
						String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskTestingDetails( role, userfullname, designation,crno);
				}


				@Override
				public String updateCustomTestingTaskStatus(String crno, String status,String role, String userfullname, String designation, String reopenReason) {
					// TODO Auto-generated method stub
					return pmsDao.updateCustomTestingTaskStatus( crno, status, role, userfullname, designation, reopenReason);
				}


				@Override
				public JSONArray getCustomTaskTestingData(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskTestingData( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomTaskTestedList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskTestedList( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomizationReadyTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomizationReadyTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getCustomTaskReadytoDeliverList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskReadytoDeliverList( userfullname, role, designation);
				}


				@Override
				public String updateReadyTaskStatus(String crno, String status, String role, String userfullname,
						String designation, String patchURL) {
					// TODO Auto-generated method stub
					return pmsDao.updateReadyTaskStatus( crno, status, role, userfullname,
							 designation, patchURL);
				}
				
				
				
				//16/11
				@Override
				public JSONArray getListForDeletedActivities(String prodSuit, String secTool, String custName,
						String projectStatus, String uname) {
					// TODO Auto-generated method stub
					return pmsDao.getListForDeletedActivities(prodSuit, secTool, custName,
							projectStatus,uname);
				}


				//16/11
				@Override
				public String deleteActivitiesData(String checkedIds) {
					// TODO Auto-generated method stub
					return pmsDao.deleteActivitiesData(checkedIds);
				}


				@Override
				public JSONArray renderNotifications(String userfullname, String designation, String role) {
					// TODO Auto-generated method stub
					return pmsDao.renderNotifications( userfullname,  designation,  role);
				}


				@Override
				public String saveCustomTaskAddRow(String taskData, String userfullname, String role,
						String designation) {
					// TODO Auto-generated method stub
					return pmsDao.saveCustomTaskAddRow( taskData, userfullname, role, designation);
				}
				
				
				//21/11
				@Override
				public JSONArray getTodaysProgressModalData(String uname, String crno, String tid) {
					// TODO Auto-generated method stub
					return pmsDao.getTodaysProgressModalData( uname,  crno,  tid);
				}
				
				//21/11
				@Override
				public String saveTodaysProgress(String functionNameModal, String moduleNameModal, String customerNameModal,
						String productNameModal, String productSuiteNameModal, String taskDescModal, String dateModal,
						String progressModal, String crno, String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.saveTodaysProgress( functionNameModal,  moduleNameModal,  customerNameModal,
							 productNameModal,  productSuiteNameModal,  taskDescModal,  dateModal,
							 progressModal, crno, userfullname);
				}
				
				
				
				//26/11
				@Override
				public JSONArray dashboardTableForHeadProject(String uname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.dashboardTableForHeadProject(uname, role, designation);
				}


				//25/11
				@Override
				public String saveIssueCustomizationTask(String customerName, String productsuit, String productname,
						String moduleName, String enddate, String priority, String description, String expectedOutput,
						String userfullname, String uname, String role, String designation, String taskData) {
					// TODO Auto-generated method stub
					return pmsDao.saveIssueCustomizationTask( customerName,  productsuit,  productname,
							 moduleName,  enddate,  priority,  description,  expectedOutput,
							 userfullname,  uname,  role,  designation,  taskData);
				}


				@Override
				public JSONArray getClosedCustomTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getClosedCustomTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getOperationalTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getPonumberSMapproved() {
					// TODO Auto-generated method stub
					return pmsDao.getPonumberSMapproved();
				}


				@Override
				public JSONArray getCustomTaskDataByMGR(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getCustomTaskDataByMGR( userfullname, role, designation);
				}


				@Override
				public String updateOpTask(String userfullname, String role, String designation, int sr_no,
						String developer, String testerName, String plannedDate, String statusUpdate) {
					// TODO Auto-generated method stub
					return pmsDao.updateOpTask( userfullname, role, designation, sr_no,
							 developer, testerName, plannedDate, statusUpdate);
				}
				
				
				
				
				//06/12
				@Override
				public JSONArray getOperationalTaskListFirst(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskListFirst( userfullname, role, designation);
				}


				//06/12
				@Override
				public JSONArray getOperationalTaskListSecond(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskListSecond( userfullname, role, designation);
				}


				//06/12
				@Override
				public JSONArray getOperationalTaskListThird(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskListThird( userfullname, role, designation);
				}
				
				
				
				//06/12
				@Override
				public JSONArray getAllProductSuites(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getAllProductSuites(userfullname);
				}
				
				
				
				//09/12
				@Override
				public JSONArray getAllData(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getAllData(userfullname);
				}


				@Override
				public JSONArray getHeadPersons() {
					// TODO Auto-generated method stub
					return pmsDao.getHeadPersons();
				}


				@Override
				public JSONArray getSalesTeam() {
					// TODO Auto-generated method stub
					return pmsDao.getSalesTeam();
				}


				@Override
				public JSONArray getAllManagers() {
					// TODO Auto-generated method stub
					return pmsDao.getAllManagers();
				}


				@Override
				public JSONArray getTaskChart(String uname, String userfullname, String role, String solution) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskChart( uname, userfullname, role, solution);
				}


				@Override
				public JSONArray getOperationalTaskUserList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskUserList( userfullname, role, designation);
				}


				@Override
				public JSONArray getOperationalTaskTeamWise(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTaskTeamWise( userfullname, role, designation);
				}


				@Override
				public JSONArray getPendingAssignTask(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getPendingAssignTask( userfullname, role, designation);
				}


				@Override
				public JSONArray getDueForTodayTask(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getDueForTodayTask( userfullname, role, designation);
				}


				@Override
				public JSONArray getSolutionNames(String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getSolutionNames( userfullname, role);
				}


				@Override
				public JSONArray getOpTaskByCustomer(String role, String designation, String customer,String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getOpTaskByCustomer( role, designation, customer, userfullname);
				}


				@Override
				public JSONArray getOpTaskBySolution(String role, String designation, String solution,
						String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getOpTaskBySolution( role, designation, solution,userfullname);
				}


				@Override
				public JSONArray getDetailsBySelectedDate(String role, String designation, String clickDate,
						String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getDetailsBySelectedDate( role, designation, clickDate,userfullname);
				}


				@Override
				public JSONArray getDetailsByCount(String role, String designation, String userfullname, String data,
						String countType) {
					// TODO Auto-generated method stub
					return pmsDao.getDetailsByCount( role, designation, userfullname, data, countType);
				}


				@Override
				public String DownloadComplianceSheet() {
					// TODO Auto-generated method stub
					return pmsDao.DownloadComplianceSheet( );
				}


				@Override
				public String submitCompliance(String productSuit, String securitytool, String customerName,
						String refNO, String complianceFile, String role,
						String userfullname, String designation, String description, String salesManager) {
					// TODO Auto-generated method stub
					return pmsDao.submitCompliance( productSuit, securitytool, customerName,refNO, complianceFile, role,
							 userfullname, designation, description,salesManager);
				}


				@Override
				public String saveComplianceFile(MultipartFile bulkUserData, String userfullname, String uname,
						String role, String productSuit, String securitytool, String customerName, String refNO, String Srno) {
					// TODO Auto-generated method stub
					return pmsDao.saveComplianceFile( bulkUserData, userfullname, uname,role,productSuit, securitytool, customerName, refNO, Srno);
				}


				@Override
				public JSONArray getComplianceList() {
					// TODO Auto-generated method stub
					return pmsDao.getComplianceList();
				}


				@Override
				public String deleteCompEntry(int crno) {
					// TODO Auto-generated method stub
					return pmsDao.deleteCompEntry(crno);
				}


				@Override
				public JSONArray getRFPTaskList(String role, String fullname) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskList( role, fullname);
				}


				@Override
				public String assignRFPTaskToDeveloper(String fullname, String role, String designation,
						String selectedNames, String updatedDates) {
					// TODO Auto-generated method stub
					return pmsDao.assignRFPTaskToDeveloper( fullname, role, designation, selectedNames, updatedDates);
				}


				@Override
				public JSONArray getRFPTaskDataByMGR(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskDataByMGR( userfullname, role, designation);
				}


				@Override
				public String saveRFPTaskAddRow(String taskData, String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.saveRFPTaskAddRow( taskData, userfullname, role, designation);
				}


				@Override
				public String updateRFPTask(String userfullname, String role, String designation, int sr_no,
						String developer, String testerName, String statusUpdate, String targetDate) {
					// TODO Auto-generated method stub
					return pmsDao.updateRFPTask( userfullname, role, designation, sr_no, developer, testerName, statusUpdate,targetDate);
				}


				@Override
				public JSONArray getMyRFPTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getMyRFPTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskTestingData(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskTestingData( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskDetails(String role, String userfullname, String designation, String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskDetails( role, userfullname, designation, crno);
				}


				@Override
				public String updateRFPTaskStatus(String crno, String status, String testerName,
						String testerDescription, String role, String userfullname, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.updateRFPTaskStatus( crno, status, testerName, testerDescription, role, userfullname, designation);
				}


				@Override
				public JSONArray getRFPTestingTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTestingTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTestingDetails(String role, String userfullname, String designation,
						String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTestingDetails( role, userfullname, designation, crno);
				}


				@Override
				public String updateRFPTestingTaskStatus(String crno, String status, String role, String userfullname,
						String designation, String testerFailDesc, String testerPassDesc) {
					// TODO Auto-generated method stub
					return pmsDao.updateRFPTestingTaskStatus( crno, status, role, userfullname, designation, testerFailDesc, testerPassDesc);
				}


				@Override
				public JSONArray getRFPTaskTestedList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskTestedList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPReadyTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPReadyTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskReadytoDeliverList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskReadytoDeliverList( userfullname, role, designation);
				}


				@Override
				public String updateReadyRFPTaskStatus(String crno, String status, String role, String userfullname,
						String designation, String patchURL) {
					// TODO Auto-generated method stub
					return pmsDao.updateReadyRFPTaskStatus( crno, status, role, userfullname,designation, patchURL);
				}


				@Override
				public JSONArray markAsCloseList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.markAsCloseList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskClosedList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskClosedList( userfullname, role, designation);
				}


				@Override
				public String updateCloseRFPTaskStatus(String crno, String status, String role, String userfullname,
						String designation, String patchURL) {
					// TODO Auto-generated method stub
					return pmsDao.updateCloseRFPTaskStatus( crno, status, role, userfullname, designation, patchURL);
				}


				@Override
				public JSONArray getAllRFPTaskList(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getAllRFPTaskList( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskDetailsAll(String role, String userfullname, String designation,
						String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskDetailsAll( role, userfullname, designation,crno);
				}


				@Override
				public JSONArray getAllAssignToList(String role) {
					// TODO Auto-generated method stub
					return pmsDao.getAllAssignToList( role);
				}


				@Override
				public JSONArray getRFPTaskListFirst(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskListFirst( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPTaskListThird(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskListThird( userfullname, role, designation);
				}


				@Override
				public JSONArray getRFPDetailsByCount(String role, String designation, String userfullname, String data,
						String countType) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPDetailsByCount( role, designation, userfullname, data, countType);
				}


				@Override
				public JSONArray getRFPTaskByHead(String role, String designation, String fHead,
						String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskByHead( role, designation, fHead, userfullname);
				}


				@Override
				public JSONArray getRFPTaskBySolution(String role, String designation, String solution,
						String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskBySolution( role, designation, solution,userfullname);
				}


				@Override
				public JSONArray getFHList(String role) {
					// TODO Auto-generated method stub
					return pmsDao.getFHList( role);
				}


				@Override
				public JSONArray getAllTLList(String role) {
					// TODO Auto-generated method stub
					return pmsDao.getAllTLList( role);
				}


				@Override
				public String saveTeamMaster(String productsuit, String productname, String functionalHead,
						String am_dmName, String tlname, String mappedWith, String userfullname, String phaseType) {
					// TODO Auto-generated method stub
					return pmsDao.saveTeamMaster( productsuit, productname, functionalHead, am_dmName, tlname, mappedWith, userfullname, phaseType);
				}


				@Override
				public JSONArray getTeamMasterList(String role) {
					// TODO Auto-generated method stub
					return pmsDao.getTeamMasterList( role);
				}


				@Override
				public JSONArray getSolutionChart() {
					// TODO Auto-generated method stub
					return pmsDao.getSolutionChart();
				}


				@Override
				public JSONArray getSolutionwiseTeam() {
					// TODO Auto-generated method stub
					return pmsDao.getSolutionwiseTeam();
				}


				@Override
				public JSONArray getTeamChart(String chartName) {
					// TODO Auto-generated method stub
					return pmsDao.getTeamChart( chartName);
				}


				@Override
				public JSONArray getTaskCount(String tableName, String getFrom) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskCount( tableName, getFrom);
				}


				@Override
				public JSONArray getRFPManagerTaskList(String role, String fullname) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPManagerTaskList( role, fullname);
				}


				@Override
				public JSONArray getRFPTaskAssignedByMGR(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskAssignedByMGR( userfullname, role, designation);
				}


				@Override
				public String assignRFPTaskByTL(String fullname, String role, String designation, String selectedNames,
						String updatedDates) {
					// TODO Auto-generated method stub
					return pmsDao.assignRFPTaskByTL( fullname, role, designation, selectedNames,updatedDates);
				}


				@Override
				public JSONArray getTaskByName(String selectedName, String type) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskByName( selectedName, type);
				}


				@Override
				public JSONArray getTaskByDeveloper(String userfullname, String role, String designation, String value,String getFrom) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskByDeveloper( userfullname, role, designation, value,getFrom);
				}


				@Override
				public JSONArray getRFPTaskByDev(String fHead, String value) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskByDev( fHead, value);
				}


				@Override
				public JSONArray getRFPTaskByCountDev(String data,String countType, String value) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskByCountDev( data,countType, value);
				}


				@Override
				public JSONArray getTillTodayTask(String userfullname, String role, String designation, String value, String getFrom) {
					// TODO Auto-generated method stub
					return pmsDao.getTillTodayTask( userfullname, role, designation, value, getFrom);
				}


				@Override
				public JSONArray getRFPTaskByDevTillDate(String fHead) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTaskByDevTillDate( fHead);
				}


				@Override
				public JSONArray getRFPTestedDetails(String role, String userfullname, String designation,
						String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPTestedDetails( role, userfullname, designation,crno);
				}


				@Override
				public JSONArray getListForReviseDate(String fullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getListForReviseDate( fullname, role, designation);
				}


				@Override
				public String updateReviseDate(String fullname, String role, String designation, String updatedEndDates,
						String updateDatesReason) {
					// TODO Auto-generated method stub
					return pmsDao.updateReviseDate( fullname, role, designation, updatedEndDates, updateDatesReason);
				}


				@Override
				public JSONArray getReviedDateTasksList(String fullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getReviedDateTasksList( fullname, role, designation);
				}


				@Override
				public String approveRevisedRFPDate(String fullname, String role, String designation,
						String checkedIds) {
					// TODO Auto-generated method stub
					return pmsDao.approveRevisedRFPDate( fullname, role, designation,checkedIds);
				}


				@Override
				public String saveDelayReason(String crno, String myDelayReason, String fullname) {
					// TODO Auto-generated method stub
					return pmsDao.saveDelayReason( crno, myDelayReason, fullname);
				}


				@Override
				public JSONArray getProjectsByTL(String userfullname, String role, String designation) {
					// TODO Auto-generated method stub
					return pmsDao.getProjectsByTL( userfullname, role, designation);
				}


				@Override
				public JSONArray getTaskLists(String userfullname, String role, String designation, String type, String value) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskLists( userfullname, role, designation,type ,value);
				}


				@Override
				public JSONArray getRFPCardCounts(String userfullname, String role, String designation, String value) {
					// TODO Auto-generated method stub
					return pmsDao.getRFPCardCounts( userfullname, role, designation, value);
				}


				@Override
				public String assignTicket(String id, String branch, String flag, String ip_add, String mail_msg,
						String problem, String subject, String r_date) {
					// TODO Auto-generated method stub
					return pmsDao.assignTicket( id, branch, flag, ip_add, mail_msg, problem,  subject,  r_date);
				}


				@Override
				public JSONArray getMyTaskListMobileDevice(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getMyTaskListMobileDevice(userfullname);
				}


				@Override
				public JSONArray getTaskDetailsMobile(String crno) {
					// TODO Auto-generated method stub
					return pmsDao.getTaskDetailsMobile(crno);
				}


				@Override
				public JSONArray getCompletedTaskListMobile(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getCompletedTaskListMobile( userfullname);
				}


				@Override
				public JSONArray getAssignedTaskByMeMobile(String userfullname) {
					// TODO Auto-generated method stub
					return pmsDao.getAssignedTaskByMeMobile( userfullname);
				}


				@Override
				public String saveTaskFromMobDevice(String functionName, String responsibility, String customerName,
						String productsuit, String productname, String userfullname, String projectName) {
					// TODO Auto-generated method stub
					return pmsDao.saveTaskFromMobDevice( functionName, responsibility, customerName,
							 productsuit, productname, userfullname, projectName);
				}


				@Override
				public JSONArray getSavedProjectData() {
					// TODO Auto-generated method stub
					return pmsDao.getSavedProjectData();
				}


				@Override
				public JSONArray getGeneralTasksList(String uname, String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getGeneralTasksList(uname, userfullname, role);
				}


				@Override
				public JSONArray getRfpTasksList(String uname, String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getRfpTasksList(uname, userfullname, role);
				}


				@Override
				public JSONArray getOperationalTasksList(String uname, String userfullname, String role) {
					// TODO Auto-generated method stub
					return pmsDao.getOperationalTasksList(uname, userfullname, role);
				}


				@Override
				public JSONArray getGeneralTaskDetails(String crno, String tid) {
					// TODO Auto-generated method stub
					return pmsDao.getGeneralTaskDetails(crno, tid);
				}
				
				
				@Override
				 public JSONArray getTaskAssignedBySelf(int start, int length) {
				    return pmsDao.getTaskAssignedBySelf(start,length);
				}
				
				
				

		
}
