package com.velox.itsm.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

public interface PmsService {
	
	public JSONArray getAssigneProjectNames();
	
	public JSONArray  getProjectNames();
	
	public JSONArray getNameDetails();
	public JSONArray getDesignationNameDetails();
	public JSONArray getUserNameDetails(String desigName);
	public JSONArray getUserId(String userid);
	
	public String saveNewRD(MultipartFile[] rdFile, MultipartFile[] maskedPOFile, String poNumber, String producSuiteNames, String Securitytool,String ProdManager,
			String functionName,String noteType, String username, String userid, String uname, MultipartFile[] scopeWork, MultipartFile[] rFPFile, MultipartFile[] otherFile);

	public String saveNewUD(MultipartFile[] udFile,MultipartFile[] otherFile,String poNumber,String producSuiteNames,String Securitytool,String ProdManager,String functionName,String noteType,
			String userid,String username,String uname,String Teamlead,String note,String Dev, String rd_id, String projectdesc, String projectobj, String projectscope, String funcreq, String nonfuncreq, String techreq, String startdate, String enddate);
	
	public JSONArray getProjectHeadList();

	public String SavePKMeeting(String uname, String fullname, String crno, String tid, String projhead, String salemgr,
			String prodmgr, String startdate, String typeofmeet, String typeofrm, String roomCapacity,
			String meetingResource, String vpersonmeeting, String vpresourcemeeting, String meetingTypes,
			String meetingTypesvideo,MultipartFile[] uploadMom ,MultipartFile[]planUploadMom,String link, String poNumber);

	public JSONArray getProjectHead();

	public JSONArray getSalesManager();

	public JSONArray getProductionManager();

	public JSONArray getroomdetails();

	public JSONArray pendingdevtask(String uname, String company, String userfullname);

	public JSONArray ViewUDDocuments();

	public JSONArray ViewRdPendingDetailsMD(String crno);

	public JSONArray apprvlRdByMe();

	public JSONArray apprvlUdDocuments();

	public JSONArray ViewUdPendingDetailsMD(String crno);
	
	public String saveTaskDetails(String pONumb, String date, String customername, String productLicense,
			String implementorName, String implementorNumber, String cusImplementorEmail, String salesManagerName,
			String endCustomerName, String endCustomerNumber, String paymentTermsPO,String description, String alldata);
	
	public JSONArray getImplemetorFORMData(String crno, String uname, String tid, String fullname);

	public JSONArray viewapprvlRdByMe(String crno);

	public JSONArray ViewUdApprovedByMD(String crno);

	public JSONArray ApprovedUDByMD(String uname);

	public JSONArray RejectedCMDetails(String uname, String company);

	public JSONArray getDevTaskData(String crno, String uname, String tid);

	public JSONArray getRdDetailsTable();

	public JSONArray getUdDetailsTable();

	public JSONArray getProjectKickMeetingTable();

	public String ApproveRdDetailsByMD(String crno, String status);

	public String ApproveUDDetailsByMD(String crno, String status,String uname,String prodManager);

	public JSONArray gettaskdetails();

	public String saveDayWiseTask(String taskData, String userfullname);

	public String saveMainTask(String functionName, String moduleName, String responsibility, String managerName,
			String teamLeader, String developer, String startdate, String enddate, String inputRemark,
			String description);

	public JSONArray getDevTaskDetails(String uname);

	public String updateTaskStatus(String crno, String tid, String status, String remark,String Manager_Name,String Team_Leader,String Developer,String End_Date, String userfullname);

	public JSONArray getDevAssignedTaskDetails(String crno, String tid);

	public JSONArray getImplTaskList(String uname, String tStatus);

	public JSONArray getImplTaskDetails(String uname, String crno, String tid);

	public JSONArray pendingRdDocumentsBySI();

	public String ApproveRdDetailsBySI(String crno, String status);

	public JSONArray pendingUdDocumentsBySI();

	public String ApproveUDDetailsBySI(String crno, String status);

	public JSONArray getPonumber();

	public JSONArray getproducSuite(String poNumber);

	public JSONArray getSecuritytool(String producsuite);

	public JSONArray getFunctionName();

	public JSONArray getselectrddetails(String selectrddetails);

	public JSONArray getRDDropdownValue();

	public JSONArray getimplformcdetails(String selectrddetails);

	public JSONArray ApprovedUDListImpl(String uname);

	public JSONArray getUDDetails(String crno, String uid, String uname);

	public JSONArray getRDdetails(String uid, String uname);

	public JSONArray submittedUdByMe(String uname);

	public String rejectUDbyMD(String crno, String company, String rejectreason, String sMnote, String uname,
			String tid);

	public JSONArray rejectedUdByMeDetails();

	public JSONArray getManagerByTool(String poNumber);

	public JSONArray getMaskedPOFile(String poNumber);

	public JSONArray getpmsdetails(String projectdata);

	public JSONArray getPoByCustomerName(String projName);

	public JSONArray getproductSuite();

	public JSONArray getSecuritytoolName(String producsuite);

	public JSONArray getProductManagerByTool(String suitname);

	public JSONArray getCustomerList(String suitname);

	public JSONArray scheduleMeetings();

	public JSONArray getScheduleMeetingData(String crno);

	public String Exportallpurchaseorder(String tableName, String fromDate, String toDate);

	public JSONArray PiechartPMS(String uname, String userfullname, String role);

	public JSONArray BarchartSCM(String uname, String userfullname, String role);

	public JSONArray getApprovePO(String approvePO);

	public String saveTaskWithoutPO(String functionName, String responsibility, String customerName, String productsuit,
			String productname, String teamLeader, String moduleName, String developer, String startdate,
			String enddate, String inputRemark, String description, String userfullname, String uname, String role, String selectMe, String testerName,String weightage,String supportteamLeader,String support);

	public JSONArray getMyTaskList(String uname, String userfullname, String role);

	public JSONArray getTesterTaskList(String uname, String userfullname);

	public JSONArray containerChartData(String uname, String userfullname, String role);

	public JSONArray cardDashboardData(String uname, String userfullname, String role);

	public JSONArray getAssignedTaskTL(String uname, String userfullname, String role);

	public JSONObject TeamMembers(String uname, String userfullname, String role);

	public JSONArray getTaskDetailList(String customername);

	public JSONArray getProductSuiteName(String module_name);

	public JSONArray getTaskdetails(String module_name, String customer_name);

	public JSONArray getLatestProjectList();

	public JSONArray getAssignedTaskTester(String uname, String userfullname);
	
	public JSONArray getprojectontrack();
	
	public JSONArray getTotalcompletedproject(String methodName,String role);
	
	public JSONArray getActivitiesdalayscount();
	
	public JSONArray getMgrDelaysActivities(String userfullname);
	
    public JSONArray getproductsuite(String projectNames);
	
	public JSONArray getproductmgrname(String projectmgrname,String productsuite);
	
	public JSONArray getfunctionname(String projectmgrname,String productsuite,String teamleader);
	
	public JSONArray getallfunctionname(String projectmgrname,String productsuite,String teamleader,String allfunction);
	
	public JSONArray getListdelayproject();
	
	public JSONArray getproductsuiteActontrack(String projectNames);
	
	public JSONArray getproductmgrnameActonTrack(String projectmgrname,String productsuite);
	
	public JSONArray getfunctionnameActonTrack(String projectmgrname,String productsuite,String teamleader);
	
	public JSONArray getallfunctionnameActonTracks(String projectmgrname,String productsuite,String teamleader,String allfunction);
	
	public JSONArray getPMactonTrack(String uname, String userfullname, String role);
	
public JSONArray getproductsuiteActontrackPM(String projectNames, String userfullname);
	
	public JSONArray getDevNameActonTrackPM(String producttool,String tlnames);
	
	public JSONArray getfunctionnameActonTrackforPM(String projectname,String Teamleadername,String Devname);
	
	public JSONArray getallfunctionnameActonTracksPM(String projectname,String tlname,String devname,String allfunction,String userfullname);
	
	public JSONArray getallfunctionnameActonTracksDly(String projectname,String tlname,String devname,String allfunction,String userfullname);
	
	public JSONArray getMgrTotalProject(String userfullname, String role);
	
	public JSONArray getprojectontrackMGR(String userfullname,String role);
	
	public JSONArray getprojectcompletedMGR(String userfullname,String role);
	
	public JSONArray getprojectdealyedMGR(String userfullname,String role);

	public JSONArray getAllActivities(String uname, String role, String designation);

	public JSONArray getAllActivitiesByProj(String projectName, String uname, String role, String designation);

	public JSONArray getAllActivitiesByMGR(String projectName, String projectmgrname, String uname, String role,
			String designation);

	public JSONArray getAllActivitiesByTL(String projectName, String projectmgrname, String teamleader, String uname,
			String role, String designation);

	public JSONArray getTeamLeaderTotalproject(String methodName, String userfullname, String role);

	public JSONArray getTeamLeaderTotalcompletedproject(String methodName, String userfullname, String role);

	public JSONArray getTeamLeaderDelayedProjectDetails(String fullname, String role, String designation,
			String delayedProjectName);

	public JSONArray getTeamLeaderActivityOnTrack(String uname, String userfullname, String role);

	public JSONArray getTeamLeaderFunctionName(String uname, String userfullname, String role);

	public JSONArray getTeamLeaderDetailsByProjectName(String uname, String role, String designation,
			String projectName);

	public JSONArray getTeamLeaderActivities(String uname, String role, String designation);

	public JSONArray getTeamLeaderAssignName(String fullname, String role, String designation);

	public JSONArray getTeamLeaderDetailsByAssignToName(String fullname, String role, String designation,
			String projectName, String assignto);

	public JSONArray getTeamLeaderDetailsByfunctionName(String fullname, String role, String designation,
			String functionName, String projectName, String assignTo);

	public JSONArray getTeamLeaderActivityDelayed(String uname, String userfullname, String role);

	public JSONArray getTeamLeaderDelayedProjectByProjectName(String fullname, String role, String designation,
			String projectName, String functionName, String assignToName);

	public JSONArray getTeamLeadActivitiesDelayedByProjectName(String projectNames, String fullname);

	public JSONArray getAssignToDelayedProjectByProjectName(String fullname, String role, String designation,
			String projectName, String assignTo);

	public JSONArray getActivitiesdalaysByProj(String projectName, String uname, String role, String designation);

	public JSONArray getActivitiesdalaysByMGR(String projectName, String projectmgrname, String uname, String role,
			String designation);

	public JSONArray getActivitiesdalaysByTL(String projectName, String projectmgrname, String teamleader, String uname,
			String role, String designation);

	public JSONArray getDelayedProjectByFunctionName(String fullname, String role, String designation,
			String delayFunctionName, String projectName, String assignTo);

	public JSONArray getTeamLeadAssignToActivitiesDelayedByProjectName(String projectNames, String fullname);

	public JSONArray getTeamLeaderFunctionNameByAssignTo(String uname, String userfullname, String role,
			String projectName, String assignToName);

	public JSONArray getproductmgrnameforDelayMD(String projectmgrname);

	public String updateModifyDate(String crno, String tid, String status, String remark, String end_Date,
			String fullname, String role, String designation);

	public JSONArray getMyCompletedTaskList(String uname, String userfullname, String role);

	public JSONArray getallMGRdelayActivity(String userfullname,String role);

	public JSONArray getImplReviseTaskDate(String uname, String tStatus, String role, String fullname);

	public String updateRevisedTaskDate(String crno, String tid, String status, String remark, String developer,
			String updateEnd_Date, String role, String uname);

	public JSONArray getReviseTaskList(String uname, String userfullname, String role);

	public JSONArray getprojectnameForMGR(String uname, String userfullname, String role);

	public JSONArray getDeveloperActivitiesByProjectName(String fullname, String role, String designation,
			String productsuitename);

	public JSONArray getDeveloperActivityOnTrack(String uname, String fullname, String role);

	public JSONArray getDeveloperActivities(String uname, String role, String designation);

	public JSONArray getDeveloperFunctionNameByProjectName(String uname, String fullname, String role,
			String projectName);

	public JSONArray getDeveloperActivitiesByFunctionName(String fullname, String role, String designation,
			String productsuitename, String functionName);

	public JSONArray getDeveloperDelayActivities(String fullname, String role, String designation);

	public JSONArray getDeveloperDelayActivity(String uname, String fullname, String role);

	public JSONArray getDeveloperDelayActByProjectName(String fullname, String role, String designation,
			String projectName, String functionName);

	public JSONArray getDeveloperDelayActByProjectNameOnChange(String fullname, String role, String designation,
			String projectName);

	public JSONArray getDeveloperDelayActByFunctiontName(String fullname, String role, String designation,
			String projectName, String functionName);

	public JSONArray getAllActivitiesMGR(String userfullname, String role);

	public JSONArray getTeamLeaderByMGR(String userfullname);

	public JSONArray getActivitiesMGRByProj(String userfullname, String role, String projectName);

	public JSONArray getMGRTrackActivityByTL(String userfullname, String role, String projectName, String tlName);

	public JSONArray getMGRTrackActivityByDev(String userfullname, String role, String projectName, String tlName,
			String devName);

	public JSONArray getMGRdelayActivityByProj(String projectName, String userfullname, String role);

	public JSONArray getMGRdelayActivityByTL(String projectName, String tlname, String userfullname);

	public JSONArray getMGRdelayActivityByDev(String projectName, String tlname, String devname, String userfullname);

	public JSONArray getProjectListDeveloper(String methodName, String userfullname,String role);

	public JSONArray getDeveloperExtendedDateTasks(String fullname, String role, String designation);

	public JSONArray getDeveloperDelayedTasks(String fullname, String role, String designation);

	public String updateMultipleEndDate(String fullname, String role, String designation, String updatedDates);

	public String approveMultipleEndDate(String fullname, String role, String designation, String checkedIds);

	public JSONArray getProductSuiteTree();

	public JSONArray getSecuritySolutionTree(String product_suite);

	public String getTreeMasterDetails(String product_suite, String security_solution, String project_name);

	public JSONArray getTreeMasterListing();

	public String deleteTreeMaster(int srno);

	public String updatetreemaster(String productsuitupdate, String securitysolutionupdate, String projectnameupdate,
			int sr_no);

	public JSONArray gettreesuitList();

	public String UpdateManualPORaiseBySI(String crno, String proposalType, String fixedyear, String subscriptionyear,
			String perpetualyear, String subscriptionANDperpetualYear, String tennurestartdate, String tennureenddate,
			String tennureMonth, String tennureYear, String warrantystart, String warrantyend, String warrantyMonth,
			String warrantyYear, String amcstartdate, String amcenddate, String aMCMonth, String aMCYear,
			String poRefNo, String taskData, MultipartFile[] pouploadfile1);

	public String savefileUploadKey(MultipartFile[] fileUploadKey);

	//
	public String updateMultipleData(String checkedIds);

	//01/06
	public JSONArray getprojectonhold();

	public JSONArray getDeactivatedAccounts(String fullname, String role, String designation);

	public String activateAccounts(String fullname, String role, String designation, String checkedIds);

	
	//05/06
	public JSONArray getAllDeveloperList(String role);
	
	
	//07/06
	public JSONArray getReassignTaskSideDetails(String role, String fullname);

	//10/06
	public String reassinTaskToDeveloper(String fullname, String role, String designation, String selectedNames);

	//05/07
	public JSONArray ActivitiesCompletedcount(String role,String userfullname);

	//05/07
	public JSONArray getprojectonholdformgr(String role,String userfullname);

	//29/07
	public JSONArray getAssignedTaskMe(String uname, String userfullname);

	public JSONArray getMaskedPOList(String role);

	//17/08
	public JSONArray ActivitiesCompletedcountNew(String role, String userfullname, String methodName);
	
	public JSONArray totalprojectNamesList();

	public JSONArray totalprojectbyName(String selected_Project, String productSuite, String productTool, String managerName, String status);

	public JSONArray getProductSuiteTotalProj();

	public JSONArray getProductToolsTotalProj();

	public JSONArray getManagerTotalProj();

	public JSONArray getStatusTotalProj();

	public JSONArray getprodSuiteByProjName(String selected_Project);

	public JSONArray getprodToolByProdSuite(String selected_Project);

	public JSONArray getProductToolTotalAct();

	public JSONArray getManagerByProdTool(String selected_Project);

	public JSONArray getMangerNameTotalAct();

	public JSONArray getStatusByManager(String selected_Project);

	public JSONArray getStatusTotalProject();
	
	public JSONArray cmplteprojectList();

	public JSONArray getProductSuiteCmplteProj();

	public JSONArray productToolCmpltProj();

	public JSONArray getManagerCmplteProj();

	public JSONArray getprojectNameCmplteProject(String projectName);

	public JSONArray getTotalcompletedprojectList(String projectName, String productSuite, String productTool,
			String managerName);

	public JSONArray getproductSuiteCmplteProject(String productSuite);

	public JSONArray getmanagerCmplteProject(String productTool);

	public JSONArray getProductToolsCmplProj();
	
	public JSONArray onHoldprojectList();

	public JSONArray getProductSuiteonHoldProj();

	public JSONArray getProductToolsOnHoldProj();

	public JSONArray getManagerOnHoldProj();

	public JSONArray getprojectonholdDataTable(String projectName, String projectSuite, String projectTool,
			String managerName);

	public JSONArray getPSuiteonHold(String projectName);

	public JSONArray getPToolOnHold(String productSuite);

	public JSONArray getPManagerOnHold(String productTool);

	public JSONArray delayProjectList();

	public JSONArray getProductSuiteDelayProj();

	public JSONArray productToolDelayProj();

	public JSONArray getManagerDelayProj();

	public JSONArray getTotalDelayprojectList(String projectName, String productSuite, String productTool,
			String managerName);

	public JSONArray getProdSuiteByProject(String projectName);

	public JSONArray getDelayProdToolBySuite(String productSuite);

	public JSONArray getDelayManagerByTool(String productTool);

	
	//03/09/2024
	public JSONArray getEmployeeDataForHR();

	public JSONArray getEmployeeDataCount();

	//04/09
	public JSONArray getEmployeeCountsByRole();

	//05/09/2024
	public JSONArray getEmployeeDataOfNewEmps();

	
	//06/09/2024
	public JSONArray getTotalEmployees();

	public JSONArray getActiveEmpsOnPms();
	//

	//09/09
	public JSONArray getMaleEmps();

	//09/09
	public JSONArray getFemaleEmps();

	
	//11/09
	public JSONArray getAssigneProjectNames(String phaseName);

	
	//16/09
	public JSONArray getAssignTaskDetails(String selectrddetails);

	
	//10/10
	public JSONArray ActivitiesOnHoldcount(String role, String userfullname);

	//17/10
	public JSONArray getDeveloperExtendedStartEndDateTasks(String fullname, String role, String designation);

	//17/10
	public String updateMultipleStartEndDate(String fullname, String role, String designation, String updatedStartDates,
			String updatedEndDates, String updateDatesReason);

	//17/10
	public String approveMultipleStartEndDateMan(String fullname, String role, String designation, String checkedIds);

	//17/10
	public JSONArray getDeveloperExtendedDateTasksMan(String fullname, String role, String designation);

	//19/10
	public JSONArray getListOfReviseDateHistory(String taskDetails);

	public JSONArray getListOfFeedback();

	public JSONArray getListOfClientFeedback();

	public JSONArray getAllFeedbackCounts();

	public JSONArray getTopThreePerformers();

	public JSONArray getEmployeesHiredThisMonth();

	public JSONArray getHiredComapreCounts();

	public String saveCustomizationTask(String customerName,
			String productsuit, String productname, String moduleName, String enddate, String priority,
			String description, String expectedOutput, String userfullname, String uname, String role,
			String designation);

	public JSONArray getCustomTaskData(String userfullname, String role, String designation);

	public JSONArray getCustomTaskList(String role, String fullname);

	public String assignCustomTaskToDeveloper(String fullname, String role, String designation, String selectedNames, String updatedDates);

	public JSONArray getMyCustomizationTaskList(String userfullname, String role, String designation);

	public JSONArray getCustomTaskDetails(String role, String userfullname, String designation, String crno);

	public String updateCustomTaskStatus(String crno, String status, String testerName, String testerDescription,
			String role, String userfullname, String designation);

	
	//21/10
//	public JSONArray getExcelExport(JSONArray jArray, String excelExportPath);
	
	
	
	//12/11
		public JSONArray getPMOnHoldProject(String uname, String userfullname, String role);

		//12/11
		public JSONArray getTeamLeaderByMGROnhold(String userfullname);

		//12/11
		public JSONArray getAllActivitiesMGROnhold(String userfullname, String role);

		
		//total
		public JSONArray ActivitiesCompletedcountNewMan(String role, String userfullname, String methodName);
		
		
		//14/11
		public JSONArray getActivitiesUploadedToday(String uname, String userfullname, String role);

		public JSONArray getCustomizationTestingTaskList(String userfullname, String role, String designation);

		public JSONArray getCustomTaskTestingDetails(String role, String userfullname, String designation, String crno);

		public String updateCustomTestingTaskStatus(String crno, String status, String role, String userfullname, String designation, String reopenReason);

		public JSONArray getCustomTaskTestingData(String userfullname, String role, String designation);

		public JSONArray getCustomTaskTestedList(String userfullname, String role, String designation);

		public JSONArray getCustomizationReadyTaskList(String userfullname, String role, String designation);

		public JSONArray getCustomTaskReadytoDeliverList(String userfullname, String role, String designation);

		public String updateReadyTaskStatus(String crno, String status, String role, String userfullname,
				String designation, String patchURL);
		
		
		//16/11
		public JSONArray getListForDeletedActivities(String prodSuit, String secTool, String custName,
				String projectStatus,String uname);

		//16/11
		public String deleteActivitiesData(String checkedIds);

		public JSONArray renderNotifications(String userfullname, String designation, String role);

		public String saveCustomTaskAddRow(String taskData, String userfullname, String role, String designation);

		
		//21/11
		public JSONArray getTodaysProgressModalData(String uname, String crno, String tid);
		
		//21/11
		public String saveTodaysProgress(String functionNameModal, String moduleNameModal, String customerNameModal,
				String productNameModal, String productSuiteNameModal, String taskDescModal, String dateModal,
				String progressModal, String crno, String userfullname);
		
		
		//26/11
		public JSONArray dashboardTableForHeadProject(String uname, String role, String designation);

		//29/11
		public String saveIssueCustomizationTask(String customerName, String productsuit, String productname,
				String moduleName, String enddate, String priority, String description, String expectedOutput,
				String userfullname, String uname, String role, String designation, String taskData);

		public JSONArray getClosedCustomTaskList(String userfullname, String role, String designation);

		public JSONArray getOperationalTaskList(String userfullname, String role, String designation);

		public JSONArray getPonumberSMapproved();

		public JSONArray getCustomTaskDataByMGR(String userfullname, String role, String designation);

		public String updateOpTask(String userfullname, String role, String designation, int sr_no, String developer,
				String testerName, String plannedDate, String statusUpdate);
		
		
		
		//06/12
		public JSONArray getOperationalTaskListFirst(String userfullname, String role, String designation);

		//06/12
		public JSONArray getOperationalTaskListSecond(String userfullname, String role, String designation);

		//06/12
		public JSONArray getOperationalTaskListThird(String userfullname, String role, String designation);
		
		
		//06/12
		public JSONArray getAllProductSuites(String userfullname);

		
		//09/12
		public JSONArray getAllData(String userfullname);

		public JSONArray getHeadPersons();

		public JSONArray getSalesTeam();

		public JSONArray getAllManagers();

		public JSONArray getTaskChart(String uname, String userfullname, String role, String solution);

		public JSONArray getOperationalTaskUserList(String userfullname, String role, String designation);

		public JSONArray getOperationalTaskTeamWise(String userfullname, String role, String designation);

		public JSONArray getPendingAssignTask(String userfullname, String role, String designation);

		public JSONArray getDueForTodayTask(String userfullname, String role, String designation);

		public JSONArray getSolutionNames(String userfullname, String role);

		public JSONArray getOpTaskByCustomer(String role, String designation, String customer, String userfullname);

		public JSONArray getOpTaskBySolution(String role, String designation, String solution, String userfullname);

		public JSONArray getDetailsBySelectedDate(String role, String designation, String clickDate,
				String userfullname);

		public JSONArray getDetailsByCount(String role, String designation, String userfullname, String data,
				String countType);

		public String DownloadComplianceSheet();

		public String submitCompliance(String productSuit, String securitytool, String customerName, String refNO,
				 String complianceFile, String role, String userfullname,
				String designation, String description, String salesManager);

		public String saveComplianceFile(MultipartFile bulkUserData, String userfullname, String uname, String role, String productSuit, String securitytool, String customerName, String refNO, String Srno);

		public JSONArray getComplianceList();

		public String deleteCompEntry(int crno);

		public JSONArray getRFPTaskList(String role, String fullname);

		public String assignRFPTaskToDeveloper(String fullname, String role, String designation, String selectedNames,
				String updatedDates);

		public JSONArray getRFPTaskDataByMGR(String userfullname, String role, String designation);

		public String saveRFPTaskAddRow(String taskData, String userfullname, String role, String designation);

		public String updateRFPTask(String userfullname, String role, String designation, int sr_no, String developer,
				String testerName, String statusUpdate, String targetDate);

		public JSONArray getMyRFPTaskList(String userfullname, String role, String designation);

		public JSONArray getRFPTaskTestingData(String userfullname, String role, String designation);

		public JSONArray getRFPTaskDetails(String role, String userfullname, String designation, String crno);

		public String updateRFPTaskStatus(String crno, String status, String testerName, String testerDescription,
				String role, String userfullname, String designation);

		public JSONArray getRFPTestingTaskList(String userfullname, String role, String designation);

		public JSONArray getRFPTestingDetails(String role, String userfullname, String designation, String crno);

		public String updateRFPTestingTaskStatus(String crno, String status, String role, String userfullname,
				String designation, String testerFailDesc,String testerPassDesc);

		public JSONArray getRFPTaskTestedList(String userfullname, String role, String designation);

		public JSONArray getRFPReadyTaskList(String userfullname, String role, String designation);

		public JSONArray getRFPTaskReadytoDeliverList(String userfullname, String role, String designation);

		public String updateReadyRFPTaskStatus(String crno, String status, String role, String userfullname,
				String designation, String patchURL);

		public JSONArray markAsCloseList(String userfullname, String role, String designation);

		public JSONArray getRFPTaskClosedList(String userfullname, String role, String designation);

		public String updateCloseRFPTaskStatus(String crno, String status, String role, String userfullname,
				String designation, String patchURL);

		public JSONArray getAllRFPTaskList(String userfullname, String role, String designation);

		public JSONArray getRFPTaskDetailsAll(String role, String userfullname, String designation, String crno);

		public JSONArray getAllAssignToList(String role);

		public JSONArray getRFPTaskListFirst(String userfullname, String role, String designation);

		public JSONArray getRFPTaskListThird(String userfullname, String role, String designation);

		public JSONArray getRFPDetailsByCount(String role, String designation, String userfullname, String data,
				String countType);

		public JSONArray getRFPTaskByHead(String role, String designation, String fHead, String userfullname);

		public JSONArray getRFPTaskBySolution(String role, String designation, String solution, String userfullname);

		public JSONArray getFHList(String role);

		public JSONArray getAllTLList(String role);

		public String saveTeamMaster(String productsuit, String productname, String functionalHead, String am_dmName,
				String tlname, String mappedWith, String userfullname, String phaseType);

		public JSONArray getTeamMasterList(String role);

		public JSONArray getSolutionChart();

		public JSONArray getSolutionwiseTeam();

		public JSONArray getTeamChart(String chartName);

		public JSONArray getTaskCount(String tableName, String getFrom);

		public JSONArray getRFPManagerTaskList(String role, String fullname);

		public JSONArray getRFPTaskAssignedByMGR(String userfullname, String role, String designation);

		public String assignRFPTaskByTL(String fullname, String role, String designation, String selectedNames,
				String updatedDates);

		public JSONArray getTaskByName(String selectedName, String type);

		public JSONArray getTaskByDeveloper(String userfullname, String role, String designation, String value, String getFrom);

		public JSONArray getRFPTaskByDev(String fHead, String value);

		public JSONArray getRFPTaskByCountDev( String data, String countType, String value);

		public JSONArray getTillTodayTask(String userfullname, String role, String designation, String value,String getFrom);

		public JSONArray getRFPTaskByDevTillDate(String fHead);

		public JSONArray getRFPTestedDetails(String role, String userfullname, String designation, String crno);

		public JSONArray getListForReviseDate(String fullname, String role, String designation);

		public String updateReviseDate(String fullname, String role, String designation, String updatedEndDates,
				String updateDatesReason);

		public JSONArray getReviedDateTasksList(String fullname, String role, String designation);

		public String approveRevisedRFPDate(String fullname, String role, String designation, String checkedIds);

		public String saveDelayReason(String crno, String myDelayReason, String fullname);

		public JSONArray getProjectsByTL(String userfullname, String role, String designation);

		public JSONArray getTaskLists(String userfullname, String role, String designation, String type, String value);

		public JSONArray getRFPCardCounts(String userfullname, String role, String designation, String value);

		public String assignTicket(String id, String branch, String flag, String ip_add, String mail_msg,
				String problem, String subject, String r_date);

		public JSONArray getMyTaskListMobileDevice( String userfullname);

		public JSONArray getTaskDetailsMobile(String crno);

		public JSONArray getCompletedTaskListMobile(String userfullname);

		public JSONArray getAssignedTaskByMeMobile(String userfullname);

		public String saveTaskFromMobDevice(String functionName, String responsibility, String customerName,
				String productsuit, String productname, String userfullname, String projectName);

		public JSONArray getSavedProjectData();

		public JSONArray getGeneralTasksList(String uname, String userfullname, String role);

		public JSONArray getRfpTasksList(String uname, String userfullname, String role);

		public JSONArray getOperationalTasksList(String uname, String userfullname, String role);

		public JSONArray getGeneralTaskDetails(String crno, String tid);

		public JSONArray getTaskAssignedBySelf(int start, int length);




}
