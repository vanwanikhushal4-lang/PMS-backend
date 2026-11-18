package com.velox.itsm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/TP")
@SessionAttributes("roles")
public class TPController {
	
	@RequestMapping(value = { "/TPHome" }, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "/TPDashboard";
	}
	
	@RequestMapping(value = { "/RaiseAssignTPTicket" }, method = RequestMethod.GET)
	public String raiseassigntpticket(ModelMap model) {

		return "/RaiseAssignTPTicket";
	}
	
	@RequestMapping(value = { "/ViewTPTickets" }, method = RequestMethod.GET)
	public String viewtptickets(ModelMap model) {

		return "/ViewTPTickets";
	}
	
	@RequestMapping(value = { "/ViewAllRaiseTickets" }, method = RequestMethod.GET)
	public String viewallraisetickets(ModelMap model) {

		return "/ViewAllRaiseTickets";
	}
	
	@RequestMapping(value = { "/ViewAllRaiseVIPTickets" }, method = RequestMethod.GET)
	public String viewallraiseVIPtickets(ModelMap model) {

		return "/ViewAllRaiseVIPTickets";
	}
	
	@RequestMapping(value = { "/ViewAllAutoRaiseTickets" }, method = RequestMethod.GET)
	public String viewallautoraisetickets(ModelMap model) {

		return "/ViewAllAutoRaiseTickets";
	}
	
	@RequestMapping(value = { "/TrackingAllTicket" }, method = RequestMethod.GET)
	public String trackingallticket(ModelMap model) {

		return "/TrackingAllTicket";
	}
	
	@RequestMapping(value = { "/ViewAssignedTickets" }, method = RequestMethod.GET)
	public String viewassignedtickets(ModelMap model) {

		return "/ViewAssignedTickets";
	}
	
	@RequestMapping(value = { "/ViewResolvedTickets" }, method = RequestMethod.GET)
	public String viewresolvedtickets(ModelMap model) {

		return "/ViewResolvedTickets";
	}
	
	@RequestMapping(value = { "/ViewClosedTickets" }, method = RequestMethod.GET)
	public String viewclosedtickets(ModelMap model) {

		return "/ViewClosedTickets";
	}
	
	@RequestMapping(value = { "/ViewClosedTicketsWithoutAssign" }, method = RequestMethod.GET)
	public String viewclosedticketswithoutassign(ModelMap model) {

		return "/ViewClosedTicketsWithoutAssign";
	}
	
	@RequestMapping(value = { "/ViewHoldTickets" }, method = RequestMethod.GET)
	public String viewholdtickets(ModelMap model) {

		return "/ViewHoldTickets";
	}
	
	@RequestMapping(value = { "/ViewPendingToReAssignTickets" }, method = RequestMethod.GET)
	public String viewpendingtoreassigntickets(ModelMap model) {

		return "/ViewPendingToReAssignTickets";
	}
	
	@RequestMapping(value = { "/ViewReAssignedTickets" }, method = RequestMethod.GET)
	public String viewreassignedtickets(ModelMap model) {

		return "/ViewReAssignedTickets";
	}
	
	@RequestMapping(value = { "/UserWiseReport" }, method = RequestMethod.GET)
	public String userwisereport(ModelMap model) {

		return "/UserWiseReport";
	}
	
	
	@RequestMapping(value = { "/TicketTrackingReport" }, method = RequestMethod.GET)
	public String TicketTrackingReport(ModelMap model) {

		return "/TicketTrackingReport";
	}
	
	
	@RequestMapping(value = { "/EnggWiseReport" }, method = RequestMethod.GET)
	public String enggwisereport(ModelMap model) {

		return "/EnggWiseReport";
	}
	
	@RequestMapping(value = { "/StatusWiseReport" }, method = RequestMethod.GET)
	public String statuswisereport(ModelMap model) {

		return "/StatusWiseReport";
	}
	@RequestMapping(value = { "/PriorityWiseReport" }, method = RequestMethod.GET)
	public String prioritywisereport(ModelMap model) {

		return "/PriorityWiseReport";
	}
	
	@RequestMapping(value = { "/CategoryWiseReport" }, method = RequestMethod.GET)
	public String categorywisereport(ModelMap model) {

		return "/CategoryWiseReport";
	}
	
	@RequestMapping(value = { "/GroupWiseReport" }, method = RequestMethod.GET)
	public String groupwisereport(ModelMap model) {

		return "/GroupWiseReport";
	}
	
	@RequestMapping(value = { "/CloseWithoutAssignReport" }, method = RequestMethod.GET)
	public String closewithoutassignreport(ModelMap model) {

		return "/CloseWithoutAssignReport";
	}
	
	@RequestMapping(value = { "/ResetTPPassw" }, method = RequestMethod.GET)
	public String resettppassw(ModelMap model) {

		return "/ResetTPPassw";
	}
	
	// aging analysis report------ by shital waman
	
		@RequestMapping(value = { "/AgingAnalysisReport" }, method = RequestMethod.GET)
		public String aginganalysisreport(ModelMap model) {

			return "/AgingAnalysisReport";
		}	
		
	///////////// PROBLEM MANAGEMENT //////////	
		@RequestMapping(value = { "/RaiseProblemTicket" }, method = RequestMethod.GET)
		public String raiseassigntpproblemticket(ModelMap model) {

			return "/RaiseAssignTPProblemTicket";
		}
		@RequestMapping(value = { "/ViewAllProblemTickets" }, method = RequestMethod.GET)
		public String ViewAllProblemTickets(ModelMap model) {

			return "/ViewAllProblemTickets";
		}
		@RequestMapping(value = { "/TrackingAllProblemTicket" }, method = RequestMethod.GET)
		public String TrackingAllProblemTicket(ModelMap model) {

			return "/TrackingAllProblemTicket";
		}
		
		@RequestMapping(value = { "/OutageMaster" }, method = RequestMethod.GET)
		public String OutageMaster(ModelMap model) {

			return "/OutageMaster";
		}
		
		
		//---for VIP--
		
		@RequestMapping(value = { "/ViewVIPAssignedTickets" }, method = RequestMethod.GET)
		public String viewVIPassignedtickets(ModelMap model) {

			return "/ViewVIPAssignedTickets";
		}
		


	@RequestMapping(value = { "/ViewVIPResolvedTickets" }, method = RequestMethod.GET)
		public String viewvipresolvedtickets(ModelMap model) {

			return "/ViewVIPResolvedTickets";
		}

	@RequestMapping(value = { "/ViewVIPClosedTickets" }, method = RequestMethod.GET)
		public String viewvipclosedtickets(ModelMap model) {

			return "/ViewVIPClosedTickets";
		}
		

	@RequestMapping(value = { "/ViewVIPClosedTicketsWithoutAssign" }, method = RequestMethod.GET)
		public String viewvipclosedticketswithoutassign(ModelMap model) {

			return "/ViewVIPClosedTicketsWithoutAssign";
		}

	@RequestMapping(value = { "/ViewVIPHoldTickets" }, method = RequestMethod.GET)
		public String viewvipholdtickets(ModelMap model) {

			return "/ViewVIPHoldTickets";
		}
		
	@RequestMapping(value = { "/ViewVIPRejectedTickets" }, method = RequestMethod.GET)
	public String ViewVIPRejectedTickets(ModelMap model) {

		return "/ViewVIPRejectedTickets";
	}
	
	@RequestMapping(value = { "/ViewRejectedTickets" }, method = RequestMethod.GET)
	public String ViewRejectedTickets(ModelMap model) {

		return "/ViewRejectedTickets";
	}

	@RequestMapping(value = { "/ViewVIPPendingToReAssignTickets" }, method = RequestMethod.GET)
		public String viewVIPpendingtoreassigntickets(ModelMap model) {

			return "/ViewVIPPendingToReAssignTickets";
		}
		

	@RequestMapping(value = { "/ViewVIPReAssignedTickets" }, method = RequestMethod.GET)
		public String viewVIPreassignedtickets(ModelMap model) {

			return "/ViewVIPReAssignedTickets";
		}

	@RequestMapping(value = { "/RaiseAssignOutageTicket" }, method = RequestMethod.GET)
	public String RaiseAssignOutageTicket(ModelMap model) {

		return "/RaiseAssignOutageTicket";
	}
	@RequestMapping(value = { "/RaiseRequestAprove" }, method = RequestMethod.GET)
	public String RaiseRequestAprove(ModelMap model) {

		return "/RaiseRequestAprove";
	}
	@RequestMapping(value = { "/SelfHelpPortal" }, method = RequestMethod.GET)
	public String SelfHelpPortal(ModelMap model) {

		return "/SelfHelp";
	}
	
	
	@RequestMapping(value = { "/ViewResolveAllRequest" }, method = RequestMethod.GET)
	public String ViewResolveAlldRequest(ModelMap model) {

		return "/ViewResolveAllRequest";
	}
	
	
	@RequestMapping(value = { "/ViewAllChangePrioritySeverity" }, method = RequestMethod.GET)
	public String ViewAllChangePrioritySeverity(ModelMap model) {

		return "/ViewAllChangePrioritySeverity";
	}
	@RequestMapping(value = { "/IncidentTicketReport" }, method = RequestMethod.GET)
	public String IncidentTicketReport(ModelMap model) {

		return "/IncidentTicketReport";
	}
		

	@RequestMapping(value = { "/ProblemTicketReport" }, method = RequestMethod.GET)
	public String ProblemTicketReport(ModelMap model) {

		return "/ProblemTicketReport";
	}
		

	@RequestMapping(value = { "/ServiceRequestReport" }, method = RequestMethod.GET)
	public String ServiceRequestReport(ModelMap model) {

		return "/ServiceRequestReport";
	}
	
	@RequestMapping(value = { "/RaiseAssignTPTicketOnBehalf" }, method = RequestMethod.GET)
	public String RaiseAssignTPTicketOnBehalf(ModelMap model) {

		return "/RaiseAssignTPTicketOnBehalf";
	}
	
	@RequestMapping(value = { "/RaiseServiceCatalogueTpOnBehalf" }, method = RequestMethod.GET)
	public String RaiseServiceCatalogueTpOnBehalf(ModelMap model) {

		return "/RaiseServiceCatalogueTpOnBehalf";
	}
	@RequestMapping(value = { "/ViewWorkInProgressSr" }, method = RequestMethod.GET)
	public String ViewWorkInProgressSr(ModelMap model) {

		return "/ViewWorkInProgressSr";
	}
	
	@RequestMapping(value = { "/ServiceRequestUserWiseReport" }, method = RequestMethod.GET)
	public String ServiceRequestUserWiseReport(ModelMap model) {

		return "/ServiceRequestUserWiseReport";
	}
	
	@RequestMapping(value = { "/ServiceRequestEnggWiseReport" }, method = RequestMethod.GET)
	public String ServiceRequestEnggWiseReport(ModelMap model) {

		return "/ServiceRequestEnggWiseReport";
	}
	@RequestMapping(value = { "/ServiceRequestStatusWiseReport" }, method = RequestMethod.GET)
	public String ServiceRequestStatusWiseReport(ModelMap model) {

		return "/ServiceRequestStatusWiseReport";
	}
	@RequestMapping(value = { "/ServiceRequestAgingAnalysisReport" }, method = RequestMethod.GET)
	public String ServiceRequestAgingAnalysisReport(ModelMap model) {

		return "/ServiceRequestAgingAnalysisReport";
	}
	@RequestMapping(value = { "/ServiceRequestPriorityWiseReports" }, method = RequestMethod.GET)
	public String ServiceRequestPriorityWiseReports(ModelMap model) {

		return "/ServiceRequestPriorityWiseReports";
	}
	@RequestMapping(value = { "/ServiceRequestCategoryWiseReports" }, method = RequestMethod.GET)
	public String ServiceRequestCategoryWiseReports(ModelMap model) {

		return "/ServiceRequestCategoryWiseReports";
	}
	@RequestMapping(value = { "/ServiceRequestCloseWithoutAssignReport" }, method = RequestMethod.GET)
	public String ServiceRequestCloseWithoutAssignReport(ModelMap model) {

		return "/ServiceRequestCloseWithoutAssignReport";
	}
	@RequestMapping(value = { "/ServiceRequestTicketTrackingReport" }, method = RequestMethod.GET)
	public String ServiceRequestTicketTrackingReport(ModelMap model) {
		return "/ServiceRequestTicketTrackingReport";
	}
	
	@RequestMapping(value = { "/GroupWiseReportTicket" }, method = RequestMethod.GET)
	public String GroupWiseReportTicket(ModelMap model) {
		return "/GroupWiseReportTicket";
	}
	
	@RequestMapping(value = { "/ServiceRequestGroupWiseReport" }, method = RequestMethod.GET)
	public String ServiceRequestGroupWiseReportTicket(ModelMap model) {

		return "/ServiceRequestGroupWiseReport";
	}

	@RequestMapping(value = { "/ProblemUserWiseReport" }, method = RequestMethod.GET)
	public String ProblemUserWiseReport(ModelMap model) {

		return "/ProblemUserWiseReport";
	}
	
	@RequestMapping(value = { "/ProblemEnggWiseReport" }, method = RequestMethod.GET)
	public String ProblemEnggWiseReport(ModelMap model) {

		return "/ProblemEnggWiseReport";
	}
	
	@RequestMapping(value = { "/ProblemStatusWiseReport" }, method = RequestMethod.GET)
	public String ProblemStatusWiseReport(ModelMap model) {

		return "/ProblemStatusWiseReport";
	}
	@RequestMapping(value = { "/ProblemAgingAnalysisReport" }, method = RequestMethod.GET)
	public String ProblemAgingAnalysisReport(ModelMap model) {

		return "/ProblemAgingAnalysisReport";
	}
	@RequestMapping(value = { "/ProblemPriorityWiseReport" }, method = RequestMethod.GET)
	public String ProblemPriorityWiseReport(ModelMap model) {

		return "/ProblemPriorityWiseReport";
	}
	@RequestMapping(value = { "/ProblemCategoryWiseReport" }, method = RequestMethod.GET)
	public String ProblemCategoryWiseReport(ModelMap model) {
		return "/ProblemCategoryWiseReport";
	}
	@RequestMapping(value = { "/ProblemGroupWiseReport" }, method = RequestMethod.GET)
	public String ProblemGroupWiseReport(ModelMap model) {
		return "/ProblemGroupWiseReport";
	}
	@RequestMapping(value = { "/ProblemTicketTrackingReport" }, method = RequestMethod.GET)
	public String ProblemTicketTrackingReport(ModelMap model) {

		return "/ProblemTicketTrackingReport";
	}
	
	@RequestMapping(value = { "/SoftwareDetails" }, method = RequestMethod.GET)
	public String SoftwareDetails(ModelMap model) {

		return "/SoftwareDetails";
	}
	
	
	@RequestMapping(value = { "/deletecloseticket" }, method = RequestMethod.GET)
	public String deletecloseticket(ModelMap model) {

		return "/DeleteCloseTicket";
	}
}