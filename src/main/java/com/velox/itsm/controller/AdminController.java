package com.velox.itsm.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/Admin")
@SessionAttributes("roles")
public class AdminController {

	
	
//	@RequestMapping(value = { "/HomeDashboard" }, method = RequestMethod.GET)
//	public String HomeDashboard(ModelMap model) {
//
//		return "/HomeDashboard";
//	}
	
	@RequestMapping(value = { "/AdminHome" }, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "/AdminDashboard";
	}
	
	
	
	
	
	
	
	
	//05/09/2024
	@RequestMapping(value = { "/HRHome" }, method = RequestMethod.GET)
	public String HRHome(ModelMap model) {

		return "/AdminHRDashboard";
	}
	//
	
	

	@RequestMapping(value = { "/msgtemp" }, method = RequestMethod.GET)
	public String msgtemp(ModelMap model) {

		return "/MSGTemp";
	}

	@RequestMapping(value = { "/EformMail" }, method = RequestMethod.GET)
	public String eformmailtemplate(ModelMap model) {

		return "/eformmailtemplate";
	}

	@RequestMapping(value = { "/manageAduser" }, method = RequestMethod.GET)
	public String manageAduser(ModelMap model) {
		System.out.println("here---");
		return "/ManageADUser";
	}

	@RequestMapping(value = { "/EmailServerIntegration" }, method = RequestMethod.GET)
	public String EmailServerIntegration(ModelMap model) {

		return "/EmailServerIntegration";
	}

	@RequestMapping(value = { "/AdIntegration" }, method = RequestMethod.GET)
	public String AdIntegration(ModelMap model) {

		return "/AdIntegration";
	}

	@RequestMapping(value = { "/PriceMaster" }, method = RequestMethod.GET)
	public String PriceMaster(ModelMap model) {

		return "/PriceMaster";

	}
	
	

	@RequestMapping(value = { "/ProjectNameMaster" }, method = RequestMethod.GET)
	public String ProjectNameMaster(ModelMap model) {

		return "/ProjectNameMaster";
	}

	@RequestMapping(value = { "/PMS" }, method = RequestMethod.GET)
	public String pmsmaster(ModelMap model) {

		return "/Pms/PublishProject";
	}
	
	@RequestMapping(value = { "/TaskAssigntoDev" }, method = RequestMethod.GET)
	public String taskassigng(ModelMap model) {

		return "/Pms/DirectTaskAssigning";
	}

	@RequestMapping(value = { "/countryMaster" }, method = RequestMethod.GET)
	public String countryMaster(ModelMap model) {

		return "/countryMaster";
	}

	@RequestMapping(value = { "/ProductMaster" }, method = RequestMethod.GET)
	public String ProductMaster(ModelMap model) {

		return "/ProductMaster";
	}

	@RequestMapping(value = { "/productsuitMaster" }, method = RequestMethod.GET)
	public String productsuitMaster(ModelMap model) {

		return "/productsuitMaster";
	}

	@RequestMapping(value = { "/securitysolutionCostMaster" }, method = RequestMethod.GET)
	public String uritysolutionCostMaster(ModelMap model) {

		return "/securitysolutionCostMaster";
	}

	@RequestMapping(value = { "/unitMaster" }, method = RequestMethod.GET)
	public String unitMaster(ModelMap model) {

		return "/unitMaster";
	}

	@RequestMapping(value = { "/OtherCostMaster" }, method = RequestMethod.GET)
	public String OtherCostMaster(ModelMap model) {

		return "/OtherCostMaster";
	}

	@RequestMapping(value = { "/WarrantyTracking" }, method = RequestMethod.GET)
	public String WarrantyTracking(ModelMap model) {

		return "/WarrantyTracking";
	}

	@RequestMapping(value = { "/TandCMaster" }, method = RequestMethod.GET)
	public String TandCMaster(ModelMap model) {

		return "/TandCMaster";
	}

	@RequestMapping(value = { "/ModuleMaster" }, method = RequestMethod.GET)
	public String ModuleMaster(ModelMap model) {

		return "/ModuleMaster";
	}

	@RequestMapping(value = { "/FunctionMaster" }, method = RequestMethod.GET)
	public String FunctionMaster(ModelMap model) {

		return "/FunctionMaster";
	}

	@RequestMapping(value = { "/SLACalender" }, method = RequestMethod.GET)
	public String SLACalender(ModelMap model) {

		return "/sla_calender";
	}

	@RequestMapping(value = { "/SLAWeekScheduler" }, method = RequestMethod.GET)
	public String SLAWeekScheduler(ModelMap model) {

		return "/sla_week_scheduler";
	}

	@RequestMapping(value = { "/vrops" }, method = RequestMethod.GET)
	public String vrops(ModelMap model) {

		return "/Vrops";
	}

	@RequestMapping(value = { "/UserMaster" }, method = RequestMethod.GET)
	public String usermaster(ModelMap model) {

		return "/AddUser";
	}

	@RequestMapping(value = { "/LoginMaster" }, method = RequestMethod.GET)
	public String LoginMaster(ModelMap model) {

		return "/LoginMaster";
	}

	@RequestMapping(value = { "/View_User_List" }, method = RequestMethod.GET)
	public String View_User_List(ModelMap model) {

		return "/View_User_List";
	}

	@RequestMapping(value = { "/AutoAssignTicket" }, method = RequestMethod.GET)
	public String AutoAssignTicket(ModelMap model) {

		return "/AutoAssignTicket";
	}

	@RequestMapping(value = { "/CompanyMaster" }, method = RequestMethod.GET)
	public String companymaster(ModelMap model) {

		return "/CompanyMaster";
	}

	@RequestMapping(value = { "/EnggMaster" }, method = RequestMethod.GET)
	public String enggmaster(ModelMap model) {

		return "/Engineermaster";
	}

	@RequestMapping(value = { "/TPMaster" }, method = RequestMethod.GET)
	public String tpmaster(ModelMap model) {

		return "/TPmaster";
	}

	@RequestMapping(value = { "/IT_HeadMaster" }, method = RequestMethod.GET)
	public String it_headmaster(ModelMap model) {

		return "/IT_Head_master";
	}

	@RequestMapping(value = { "/SiteMaster" }, method = RequestMethod.GET)
	public String sitemaster(ModelMap model) {

		return "/SiteMaster";
	}

	@RequestMapping(value = { "/CategoryMaster" }, method = RequestMethod.GET)
	public String categorymaster(ModelMap model) {

		return "/CategoryMaster";
	}

	@RequestMapping(value = { "/GroupMaster" }, method = RequestMethod.GET)
	public String groupmaster(ModelMap model) {

		return "/GroupMaster";
	}

	@RequestMapping(value = { "/DepartmentMaster" }, method = RequestMethod.GET)
	public String departmentmaster(ModelMap model) {

		return "/DepartmentMaster";
	}

	@RequestMapping(value = { "/PriorityMaster" }, method = RequestMethod.GET)
	public String prioritymaster(ModelMap model) {

		return "/PriorityMaster";
	}

	@RequestMapping(value = { "/RequestModeMaster" }, method = RequestMethod.GET)
	public String requestmodemaster(ModelMap model) {

		return "/RequestModeMaster";
	}

	@RequestMapping(value = { "/AdminMaster" }, method = RequestMethod.GET)
	public String adminmaster(ModelMap model) {

		return "/AdminMaster";
	}

	@RequestMapping(value = { "/MailMaster" }, method = RequestMethod.GET)
	public String mailmaster(ModelMap model) {

		return "/MailMaster";
	}

	@RequestMapping(value = { "/SMSMaster" }, method = RequestMethod.GET)
	public String SMSMaster(ModelMap model) {

		return "/SMSConfig";
	}

	@RequestMapping(value = { "/EmailAuth" }, method = RequestMethod.GET)
	public String emailauth(ModelMap model) {

		return "/EmailAuth";
	}

	@RequestMapping(value = { "/AutoCloseTickets" }, method = RequestMethod.GET)
	public String autoclosetickets(ModelMap model) {

		return "/AutoCloseTickets";
	}

	@RequestMapping(value = { "/AutoCloseProblemTickets" }, method = RequestMethod.GET)
	public String autocloseproblemtickets(ModelMap model) {

		return "/AutoCloseProblemTickets";
	}

	@RequestMapping(value = { "/TicketOwner" }, method = RequestMethod.GET)
	public String TicketOwner(ModelMap model) {

		return "/AddTicketOwner";
	}

	@RequestMapping(value = { "/AuthenticationMaster" }, method = RequestMethod.GET)
	public String AuthenticationMaster(ModelMap model) {

		return "/AuthenticationMaster";
	}

	@RequestMapping(value = { "/EscMatrix" }, method = RequestMethod.GET)
	public String EscMatrix(ModelMap model) {

		return "/AddEscMatrix";
	}

	@RequestMapping(value = { "/SLAMaster" }, method = RequestMethod.GET)
	public String slamaster(ModelMap model) {

		return "/sla_defination";
	}

	@RequestMapping(value = { "/ResponseSLAMaster" }, method = RequestMethod.GET)
	public String ResponseSLAMaster(ModelMap model) {

		return "/ResponseSLAMaster";
	}

	@RequestMapping(value = { "/EscalationMaster" }, method = RequestMethod.GET)
	public String EscalationMaster(ModelMap model) {

		return "/escalation_master";
	}

	@RequestMapping(value = { "/ProblemCategoryMaster" }, method = RequestMethod.GET)
	public String problemcategorymaster(ModelMap model) {

		return "/ProblemCategoryMaster";
	}

	@RequestMapping(value = { "/CompositeMaster" }, method = RequestMethod.GET)
	public String CompositeMaster(ModelMap model) {

		return "/CompositeMaster";
	}

	@RequestMapping(value = { "/CustomerMaster" }, method = RequestMethod.GET)
	public String customerMaster(ModelMap model) {

		return "/customer_master";
	}
//    ADNAN CHANGES         ??/???????????????????????????????????????????????

	@RequestMapping(value = { "/ProposalMaster" }, method = RequestMethod.GET)
	public String ProposalMaster(ModelMap model) {

		return "/ProposalMaster";
	}

	@RequestMapping(value = { "/TicketTagMaster" }, method = RequestMethod.GET)
	public String TicketTagMaster(ModelMap model) {

		return "/TicketTagMaster";
	}

	@RequestMapping(value = { "/SeverityMaster" }, method = RequestMethod.GET)
	public String SeverityMaster(ModelMap model) {

		return "/SeverityMaster";
	}

	@RequestMapping(value = { "/SubjectMaster" }, method = RequestMethod.GET)
	public String SubjectMaster(ModelMap model) {

		return "/SubjectMaster";
	}

	@RequestMapping(value = { "/ServiceCatalogueMaster" }, method = RequestMethod.GET)
	public String ServiceCatalogueMaster(ModelMap model) {

		return "/ServiceCatalogueMaster";
	}

	@RequestMapping(value = { "/TemplateMaster" }, method = RequestMethod.GET)
	public String TemplateMaster(ModelMap model) {

		return "/TemplateMaster";
	}

	@RequestMapping(value = { "/DesignationMaster" }, method = RequestMethod.GET)
	public String DesignationMaster(ModelMap model) {

		return "/DesignationMaster";
	}

	@RequestMapping(value = { "/ServiceRequestFlow" }, method = RequestMethod.GET)
	public String ServiceRequestFlow(ModelMap model) {

		return "/ServiceRequestFlow";
	}

	@RequestMapping(value = { "/CatelogueTemplateMaster" })
	public String CatelogueTemplateMaster(ModelMap m) {
		return "/CatelogueTemplateMaster";
	}

	@RequestMapping(value = { "/PriorityTemplateMaster" }, method = RequestMethod.GET)
	public String PriorityTemplateMaster(ModelMap model) {

		return "/PriorityTemplateMaster";
	}

	@RequestMapping(value = { "/Sla_Percentage_Master" }, method = RequestMethod.GET)
	public String Sla_Percentage_Master(ModelMap model) {

		return "/Sla_Percentage_Master";
	}

	@RequestMapping(value = { "/CompanyCodeMaster" }, method = RequestMethod.GET)
	public String CompanyCodeMaster(ModelMap model) {

		return "/CompanyCodeMaster";
	}

	@RequestMapping(value = { "/SelfHelpMaster" }, method = RequestMethod.GET)
	public String SelfHelpMaster(ModelMap model) {

		return "/SelfHelpMaster";
	}

	@RequestMapping(value = { "/GroupMaster2" }, method = RequestMethod.GET)
	public String groupmaster2(ModelMap model) {

		return "/GroupMaster2";
	}

	@RequestMapping(value = { "/Service_Request_SLAMaster" }, method = RequestMethod.GET)
	public String Service_Request_SLAMaster(ModelMap model) {

		return "/Service_Request_SLAMaster";
	}

	@RequestMapping(value = { "/Service_Request_Response_SLAMaster" }, method = RequestMethod.GET)
	public String Service_Request_Response_SLAMaster(ModelMap model) {

		return "/ServiceRequestResponseSLAMaster";
	}

	@RequestMapping(value = { "/GroupWiseReportAdmin" }, method = RequestMethod.GET)
	public String GroupWiseReport(ModelMap model) {
		return "/GroupWiseReportInAdmin";

	}

	@RequestMapping(value = { "/ProfileWiseReport" }, method = RequestMethod.GET)
	public String CompanyWiseReport(ModelMap model) {
		return "/ProfileWiseReport";

	}
	

	
// 3/01/24
	@RequestMapping(value = { "/RequirementDoc" }, method = RequestMethod.GET)
	public String RequirementDoc(ModelMap model) {
		return "Pms/RequirementDoc";
	}
	
	
	@RequestMapping(value = { "/UnderstandingDoc" }, method = RequestMethod.GET)
	public String UnderstandingDoc(ModelMap model) {
		return "Pms/UnderstandingDoc";
	}
	
	//6/01/24
		@RequestMapping(value = { "/apprvlRdDocuments" }, method = RequestMethod.GET)
		public String apprvlRdDocuments(ModelMap model) {
			return "Pms/apprvlRdDocuments";
		}
		
		@RequestMapping(value = { "/apprvlUdDocuments" }, method = RequestMethod.GET)
		public String apprvlUdDocuments(ModelMap model) {
			return "Pms/apprvlUdDocuments";
		}

		@RequestMapping(value = { "/ViewRdPendingDetailsMD" }, method = RequestMethod.GET)
		public String ViewRdPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			
			String crno=request.getParameter("crno");
			String tid=request.getParameter("tid");
			
			return "Pms/ViewRdPendingDetailsMD";
		}
		
		@RequestMapping(value = { "/apprvlRdByMe" }, method = RequestMethod.GET)
		public String apprvlRdByMe(ModelMap model) {
			return "Pms/apprvlRdByMe";
		}
	
		
		@RequestMapping(value = { "/ViewUdPendingDetailsMD" }, method = RequestMethod.GET)
		public String ViewUdPendingDetailsMD(ModelMap model) {
			return "Pms/ViewUdPendingDetailsMD";
		}
		
		@RequestMapping(value = { "/viewapprvlRdByMe" }, method = RequestMethod.GET)
		public String viewapprvlRdByMe(ModelMap model) {
			return "Pms/viewapprvlRdByMe";
		}
		
		@RequestMapping(value = { "/ViewUdApprovedByMD" }, method = RequestMethod.GET)
		public String ViewUdApprovedByMD(ModelMap model) {
			return "Pms/ViewUdApprovedByMD";
		}
		
		//12/24
		@RequestMapping(value = { "/ViewRejectedCMDetails" }, method = RequestMethod.GET)
		public String ViewRejectedCMDetails(ModelMap model) {
			return "SalesManager/ViewRejectedCMDetails";
		}
		
//		18/24
		@RequestMapping(value = { "/pendingRdDocumentsBySI" }, method = RequestMethod.GET)
		public String pendingRdDocumentsSI(ModelMap model) {
			return "Pms/pendingRdDocumentsBySI";
		}
		
		@RequestMapping(value = { "/ViewpendingRdDocumentsBySI" }, method = RequestMethod.GET)
		public String ViewpendingRdDocumentsBySI(ModelMap model) {
			return "Pms/ViewpendingRdDocumentsBySI";
		}
		
		@RequestMapping(value = { "/pendingUdDocumentsBySI" }, method = RequestMethod.GET)
		public String pendingUdDocumentsBySI(ModelMap model) {
			return "Pms/pendingUdDocumentsBySI";
		}
		
		@RequestMapping(value = { "/ViewpendingUdBySI" }, method = RequestMethod.GET)
		public String ViewpendingUdBySI(ModelMap model) {
			return "Pms/ViewpendingUdBySI";
		}
		
		
		@RequestMapping(value = { "/ProjectMeeting" }, method = RequestMethod.GET)
		public String ProjectMeeting(ModelMap model) {

//			return "/Pms/PublishProject";
//			return "/Pms/ProjectKickOfMeeting";
			return "/Pms/ApprovedUDList";
		}
		
//		30/24
		@RequestMapping(value = { "/UdRaisedByMe" }, method = RequestMethod.GET)
		public String UdRaisedByMe(ModelMap model) {
			return "Pms/UdRaisedByMe";
		}
		
		@RequestMapping(value = { "/ViewUdSubmittedByMe" }, method = RequestMethod.GET)
		public String ViewUdSubmittedByMe(ModelMap model) {
			return "Pms/ViewUdSubmittedByMe";
		}
		
//		31/24
		@RequestMapping(value = { "/RejectedUdDetails" }, method = RequestMethod.GET)
		public String RejectedUdDetails(ModelMap model) {
			return "Pms/RejectedUdDetails";
		}
		
		@RequestMapping(value = { "/ViewRejectedUdByMeDetails" }, method = RequestMethod.GET)
		public String ViewRejectedUdByMeDetails(ModelMap model) {
			return "Pms/ViewRejectedUdByMeDetails";
		}
		
		
		@RequestMapping(value = { "/ClientMaster" }, method = RequestMethod.GET)
		public String ClientMaster(ModelMap model) {

			return "/ClientMaster";

		}
		
		
		//01/08
		@RequestMapping(value = { "/ClientMasterSupport" }, method = RequestMethod.GET)
		public String ClientMasterSupport(ModelMap model) {

			return "/ClientMasterSupport";

		}
		//
		
		
		@RequestMapping(value = { "/scheduleMeetings" }, method = RequestMethod.GET)
		public String scheduleMeetings(ModelMap model) {

			return "/Pms/scheduleMeetings";
		}
		
		@RequestMapping(value = { "/ViewScheduleMeetings" }, method = RequestMethod.GET)
		public String ViewScheduleMeetings(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewScheduleMeetings method");

		String crno=request.getParameter("crno");


		return "/Pms/ViewScheduleMeetings";
		}
		
		@RequestMapping(value = { "/TLMaster" }, method = RequestMethod.GET)
		public String TLMaster(ModelMap model) {

			return "/TLMaster";
		}
		
		
		//02/08
		@RequestMapping(value = { "/TLMasterSupport" }, method = RequestMethod.GET)
		public String TLMasterSupport(ModelMap model) {

			return "/TLMasterSupport";
		}
		//

		@RequestMapping(value = { "/Activitydetails" }, method = RequestMethod.GET)
		public String Activitydetails(ModelMap model) {

			return "/Activitydetails";
		}
		
		@RequestMapping(value = { "/ActivityCompletedDetails" }, method = RequestMethod.GET)
		public String ActivityCompletedDetails(ModelMap model) {

			return "/ActivityCompletedDetails";
		}
		
		@RequestMapping(value = { "/ActivityReviseDetails" }, method = RequestMethod.GET)
		public String ActivityReviseDetails(ModelMap model) {

			return "/ActivityReviseDetails";
		}
		
		@RequestMapping(value = { "/MultipleDateUpdate" }, method = RequestMethod.GET)
		public String MultipleDateUpdate(ModelMap model) {

			return "/MultipleDateUpdate";
		}
		
		
		@RequestMapping(value = { "/MultipleDateUpdateMgr" }, method = RequestMethod.GET)
		public String MultipleDateUpdateMgr(ModelMap model) {

			return "/MultipleDateUpdateMgr";
		}
		
		
		//17/10
		@RequestMapping(value = { "/RequestForChangesInReviseDates" }, method = RequestMethod.GET)
		public String RequestForChangesInReviseDates(ModelMap model) {

			return "/RequestForChangesInReviseDates";
		}
		//
		
	// 18/05
	@RequestMapping(value = { "/treeMaster" }, method = RequestMethod.GET)
	public String treeMaster(ModelMap model) {

		return "Pms/treeMaster";
	}
	
	
	//18/05
	@RequestMapping(value = { "/ReassignTaskSide" }, method = RequestMethod.GET)
	public String ReassignTaskSide(ModelMap model) {

		return "/ReassignTaskSide";
	}
	
	@RequestMapping(value = { "/viewLoginActivities" }, method = RequestMethod.GET)
	public String viewLoginActivities(ModelMap model) {

		return "/viewLoginActivities";
	}
		
	@RequestMapping(value = { "/downloadMaskedPO" }, method = RequestMethod.GET)
	public String downloadMaskedPO(ModelMap model) {
System.out.println("inside controller downloadMaskedPO");
		return "/downloadMaskedPO";
	}
	
	
	
	//17/10
	@RequestMapping(value = { "/approvedReviseStartEndDates" }, method = RequestMethod.GET)
	public String approvedReviseStartEndDates(ModelMap model) {

		return "/approvedReviseStartEndDates";
	}
	
	
	// 11-11-2024
	
	@RequestMapping(value = { "/addCustomizationTask" }, method = RequestMethod.GET)
	public String customizationTask(ModelMap model) {

		return "/Pms/CustomizationTask";
	}
	
	@RequestMapping(value = { "/AssignCustomizationTask" }, method = RequestMethod.GET)
	public String AssignCustomizationTask(ModelMap model) {

		return "/AssignCustomizationTask";
	}
	
	@RequestMapping(value = { "/MyCustomizationTask" }, method = RequestMethod.GET)
	public String MyCustomizationTask(ModelMap model) {

		return "/MyCustomizationTask";
	}
	
	@RequestMapping(value = { "/MyCustomizationTestingTask" }, method = RequestMethod.GET)
	public String MyCustomizationTestingTask(ModelMap model) {

		return "/MyCustomizationTestingTask";
	}
	
	
	
	//14/11
	
		@RequestMapping(value = { "/ActivitiesUploadedToday" }, method = RequestMethod.GET)
		public String ActivitiesUploadeToday(ModelMap model) {

				return "/ActivitiesUploadedToday";

		}
		
		
		@RequestMapping(value = { "/ReadyToDeliverTask" }, method = RequestMethod.GET)
		public String RedyToDeliverTask(ModelMap model) {

			return "/ReadyToDeliverTask";
		}
		
		
		
		
		//17/10
		@RequestMapping(value = { "/deleteActivities" }, method = RequestMethod.GET)
		public String deleteActivities(ModelMap model) {

			return "/deleteActivities";
		}
		//
		
		@RequestMapping(value = { "/ClosedCustomizationTask" }, method = RequestMethod.GET)
		public String ClosedCustomizationTask(ModelMap model) {

			return "/Pms/ClosedCustomizationTask";
		}
		
		
		@RequestMapping(value = { "/OperationalDashboard" }, method = RequestMethod.GET)
		public String OperationalDashboard(ModelMap model) {

			return "/OperationalDashboard";
		}
		
		@RequestMapping(value = { "/OperationalDashboardUser" }, method = RequestMethod.GET)
		public String OperationalDashboardUser(ModelMap model) {

			return "/OperationalDashboardUser";
		}
		
		
		@RequestMapping(value = { "/ComplianceSubmit" }, method = RequestMethod.GET)
		public String ComplianceSubmit(ModelMap model) {

			return "/ComplianceSubmit";
		}
		
		
		@RequestMapping(value = { "/AssignRFPTask" }, method = RequestMethod.GET)
		public String AssignRFPTask(ModelMap model) {

			return "/AssignRFPTask";
		}
		
		
		@RequestMapping(value = { "/MyRFPTask" }, method = RequestMethod.GET)
		public String MyRFPTask(ModelMap model) {

			return "/MyRFPTask";
		}
		
		
		@RequestMapping(value = { "/MyRFPTestingTask" }, method = RequestMethod.GET)
		public String MyRFPTestingTask(ModelMap model) {

			return "/MyRFPTestingTask";
		}
		
		@RequestMapping(value = { "/ReadyToDeliverRFPTask" }, method = RequestMethod.GET)
		public String ReadyToDeliverRFPTask(ModelMap model) {

			return "/ReadyToDeliverRFPTask";
		}
		
		@RequestMapping(value = { "/MarkCloseRFPTask" }, method = RequestMethod.GET)
		public String MarkCloseRFPTask(ModelMap model) {

			return "/MarkCloseRFPTask";
		}
		
		@RequestMapping(value = { "/AllRFPTask" }, method = RequestMethod.GET)
		public String AllRFPTask(ModelMap model) {

			return "/AllRFPTask";
		}
		
		@RequestMapping(value = { "/TeamMaster" }, method = RequestMethod.GET)
		public String TeamMaster(ModelMap model) {

			return "/TeamMaster";
		}
		
		@RequestMapping(value = { "/Dashboard" }, method = RequestMethod.GET)
		public String Dashboard(ModelMap model) {

			return "/newDashboard";
		}
		
		@RequestMapping(value = { "/RFPupload" }, method = RequestMethod.GET)
		public String RFPupload(ModelMap model) {
			return "/RFPupload";
		}
		
		@RequestMapping(value = { "/AssignManagerRFPTask" }, method = RequestMethod.GET)
		public String AssignManagerRFPTask(ModelMap model) {

			return "/AssignManagerRFPTask";
		}
		
		@RequestMapping(value = { "/RFPDashboard" }, method = RequestMethod.GET)
		public String RFPDashboard(ModelMap model) {

			return "/RFPDashboard";
		}
		
		@RequestMapping(value = { "/ReviseRFPtaskDate" }, method = RequestMethod.GET)
		public String ReviseRFPtaskDate(ModelMap model) {

			return "/ReviseRFPdate";
		}
		
		@RequestMapping(value = { "/ApproveReviseRFPtaskDate" }, method = RequestMethod.GET)
		public String ApproveReviseRFPtaskDate(ModelMap model) {

			return "/ApproveReviseRFPtaskDate";
		}
}