package com.velox.itsm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("/Engg")
@SessionAttributes("roles")
public class EnggController {
	
	
	
	@RequestMapping(value = { "/EnggHome" }, method = RequestMethod.GET)
	public String engghome(ModelMap model) {

		return "/EnggDashboard";
	}
	
	@RequestMapping(value = { "/EngRaiseTicket" }, method = RequestMethod.GET)
	public String enggraiseTick(ModelMap model) {

		return "/RaiseEngTicket";
	}
	
	@RequestMapping(value = { "/EngTrackingTicket" }, method = RequestMethod.GET)
	public	String usertrackingticket(ModelMap model) {
		
		return "/EngTrackingTicket";
	}
	
	@RequestMapping(value = { "/ViewEngTickets" }, method = RequestMethod.GET)
	public	String viewusertickets(ModelMap model) {
		
		return "/ViewEngTickets";
	}
	
	@RequestMapping(value = { "/ResolveEngTickets" }, method = RequestMethod.GET)
	public	String resolveusertickets(ModelMap model) {
		
		return "/ResolveEngTickets";
	}
	
	@RequestMapping(value = { "/ClosedEngTickets" }, method = RequestMethod.GET)
	public	String ClosedEngTickets(ModelMap model) {
		
		return "/CloseEnggTickets";
	}
	
	@RequestMapping(value = { "/CloseEngTickets" }, method = RequestMethod.GET)
	public	String CloseEngTickets(ModelMap model) {
		
		return "/CloseEngTickets";
	}
	
	@RequestMapping(value = { "/CloseEngVIPTickets" }, method = RequestMethod.GET)
	public	String CloseEngVIPTickets(ModelMap model) {
		
		return "/CloseEngVIPTickets";
	}
	
	@RequestMapping(value = { "/ViewAllAssignedTickets" }, method = RequestMethod.GET)
	public String ViewAllAssignedTickets(ModelMap model) {

		return "/Engineer/ViewAssignedTicketsEng";
	}
	
	@RequestMapping(value = { "/ViewAllVIPAssignedTickets" }, method = RequestMethod.GET)
	public String ViewAllVIPAssignedTickets(ModelMap model) {

		return "/Engineer/ViewVIPAssignedTicketsEng";
	}

	@RequestMapping(value = { "/ViewReAssignedTickets" }, method = RequestMethod.GET)
	public String ViewReAssignedTickets(ModelMap model) {

		return "/Engineer/ReassignedEngTicket";
	}

	@RequestMapping(value = { "/ViewHoldTickets" }, method = RequestMethod.GET)
	public String ViewHoldTickets(ModelMap model) {

		return "/Engineer/ViewEngHoldTicket";
	}

	@RequestMapping(value = { "/ViewResolvedTickets" }, method = RequestMethod.GET)
	public String ViewResolvedTickets(ModelMap model) {

		return "/Engineer/ResolvedEngtickets";
	}
	
	@RequestMapping(value = { "/ViewResolvedVIPTickets" }, method = RequestMethod.GET)
	public String ViewResolvedVIPTickets(ModelMap model) {

		return "/Engineer/ResolvedEngVIPtickets";
	}

	@RequestMapping(value = { "/ViewClosedTickets" }, method = RequestMethod.GET)
	public String ViewClosedTickets(ModelMap model) {

		return "/Engineer/CloseEngTicket";
	}

	@RequestMapping(value = { "/ResetPassword" }, method = RequestMethod.GET)
	public String ResetPassword(ModelMap model) {

		return "/Engineer/ResetEngPassw";
	}
	
	/////////////// FOR PROBLEM MANAGEMENT /////////////
	@RequestMapping(value = { "/ViewAllAssignedProblemTickets" }, method = RequestMethod.GET)
	public String ViewAllAssignedProblemTickets(ModelMap model) {

		return "/Engineer/ViewAssignedProblemTicketsEng";
	}
	
	@RequestMapping(value = { "/ViewAllRCAProblemTickets" }, method = RequestMethod.GET)
	public String ViewAllRCAProblemTickets(ModelMap model) {

		return "/Engineer/ViewRCAProblemTicketsEng";
	}
	
	@RequestMapping(value = { "/ViewAllFixInProcessProblemTickets" }, method = RequestMethod.GET)
	public String ViewAllFixInProcessProblemTickets(ModelMap model) {

		return "/Engineer/ViewFixInProcessProblemTicketsEng";
	}
	
	@RequestMapping(value = { "/ViewAllProblemTicketsEng" }, method = RequestMethod.GET)
	public String ViewAllProblemTicketsEng(ModelMap model) {

		return "/Engineer/ViewAllProblemTicketsEng";
	}
		

@RequestMapping(value = { "/ViewVIPReAssignedTickets" }, method = RequestMethod.GET)
	public String ViewVIPReAssignedTickets(ModelMap model) {

		return "/Engineer/VIPReassignedEngTicket";
	}



@RequestMapping(value = { "/ViewVIPHoldTickets" }, method = RequestMethod.GET)
	public String ViewVIPHoldTickets(ModelMap model) {

		return "/Engineer/ViewVIPEngHoldTicket";
	}

@RequestMapping(value = { "/ViewAssignRequest" }, method = RequestMethod.GET)
public String ViewAssignRequest(ModelMap model) {

	return "/Engineer/ViewAssignRequest";
}
@RequestMapping(value = { "/SelfHelpPortal" }, method = RequestMethod.GET)
public String SelfHelpPortal(ModelMap model) {

	return "/SelfHelp";
}

@RequestMapping(value = { "/EngRaiseTicketOnBehalf" }, method = RequestMethod.GET)
public String EngRaiseTicketOnBehalf(ModelMap model) {

	return "/EngRaiseTicketOnBehalf";
}


@RequestMapping(value = { "/RaiseServiceCatalogueenggOnBehalf" }, method = RequestMethod.GET)
public String RaiseServiceCatalogueenggOnBehalf(ModelMap model) {

	return "/RaiseServiceCatalogueenggOnBehalf";
}


@RequestMapping(value = { "/ViewGenernalWorkInProgressTicket" }, method = RequestMethod.GET)
public String ViewGernalWorkInProgressTicket(ModelMap model) {

	return "/ViewGernalWorkInProgressTicket";
}

@RequestMapping(value = { "/ViewVipWorkInProgressTicket" }, method = RequestMethod.GET)
public String ViewVipWorkInProgressTicket(ModelMap model) {

	return "/ViewVipWorkInProgressTicket";
}
@RequestMapping(value = { "/ViewWorkinProgressServiceRequest" }, method = RequestMethod.GET)
public String ViewWorkinProgress(ModelMap model) {

	return "/ViewWorkinProgressServiceRequest";
}

@RequestMapping(value = { "/EngRaiseAndAsssignTicket" }, method = RequestMethod.GET)
public String EngRaiseAndAsssignTicket(ModelMap model) {

	return "/EngRaiseAndAsssignTicket";
}

@RequestMapping(value = { "/MyReport" }, method = RequestMethod.GET)
public String MyReport(ModelMap model) {

	return "/MyReport";
}

}