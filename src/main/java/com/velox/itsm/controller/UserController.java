package com.velox.itsm.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("/User")
@SessionAttributes("roles")
public class UserController {
	
	
	
	@RequestMapping(value = { "/UserHome" }, method = RequestMethod.GET)
	public String userhome(ModelMap model) {

		return "/UserDashboard";
		//return null;
	}
	@RequestMapping(value = { "/Attack_Log" }, method = RequestMethod.GET)
	public String Attack_log() {

		return "/Attack_Log";
	}
	@RequestMapping(value = { "/ThreatExplorer" }, method = RequestMethod.GET)
	public String ThreatExplorer() {

		return "/ThreatExplorer";
	}
	
	
	@RequestMapping(value = { "/RejectMDDetails" }, method = RequestMethod.GET)
	public String RejectMDDetails(ModelMap model) {
		
		
		return "/MD/RejectMDDetails";
	}
	
	

	@RequestMapping(value = { "/ApprovedPo" }, method = RequestMethod.GET)
	public String ApprovedPo(ModelMap model) {
		
		return "/VeloxProposal/ApprovedPo";
		
	
	}
	
	
	@RequestMapping(value = { "/pendingApprSalesMng" }, method = RequestMethod.GET)
	public String pendingApprSalesMng(ModelMap model) {
		
		
		return "/VeloxProposal/pendingApprVlxPropSalesMng";
	}
	@RequestMapping(value = { "/pendingVlxProposal" }, method = RequestMethod.GET)
	public String pendingVlxPropMD(ModelMap model) {
		
		
		return "/MD/pendingVlxProposal";
	}
	
	@RequestMapping(value = { "/ApprovedMDDetails" }, method = RequestMethod.GET)
	public String approvedMDDetails(ModelMap model) {
		
		
		return "/MD/ApprovedMDDetails";
	}
	
	@RequestMapping(value = { "/ViewVlxProposalMDApproveDetails" }, method = RequestMethod.GET)
	public String ViewVlxProposalMDApproveDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "MD/ViewVlxProposalApproveDetails";
	}
	@RequestMapping(value = { "/ViewVlxProposalMDPendingDetails" }, method = RequestMethod.GET)
	public String viewVlxProposalMDPendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "MD/ViewVlxProposalPendingDetails";
	}
	
	@RequestMapping(value = { "/ViewVlxProposalMDRejectDetails" }, method = RequestMethod.GET)
	public String ViewVlxProposalMDRejectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "MD/ViewVlxProposalMDRejectDetails";
	}
	
	@RequestMapping(value = { "/ApprovedSalesMngDetails" }, method = RequestMethod.GET)
	public String approvedByMeSalesMngDetails(ModelMap model) {
		
		
		return "/VeloxProposal/ApprovedByMeSalesMngDetails";
	}
	@RequestMapping(value = { "/ViewVlxProposalApproveDetails" }, method = RequestMethod.GET)
	public String viewVlxProposalApproveDetails(ModelMap model) {
		
		
		return "/VeloxProposal/ViewVlxProposalApproveDetails";
	}
	@RequestMapping(value = { "/ViewVlxProposalPendingDetails" }, method = RequestMethod.GET)
	public String ViewVlxProposalPendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "VeloxProposal/ViewVlxProposalPendingDetails";
	}
	@RequestMapping(value = { "/vlxProposalSendByme" }, method = RequestMethod.GET)
	public String vlxProposalSendByme(ModelMap model) {
		
		
		return "/VeloxProposal/vlxProposalSendByme";
	}
	@RequestMapping(value = { "/ViewvlxProposalSendByme" }, method = RequestMethod.GET)
	public String ViewvlxProposalSendByme(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "VeloxProposal/ViewvlxProposalSendByme";
	}
	
	
	@RequestMapping(value = { "/ViewvlxPropasalApproved" }, method = RequestMethod.GET)
	public String ViewvlxPropasalApproved(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "VeloxProposal/ViewvlxPropasalApproved";
	}
	
	
	
	
	
	@RequestMapping(value = { "/UserRaiseTicket" }, method = RequestMethod.GET)
	public String userraiseticket(ModelMap model) {

		return "/RaiseUserTicket";
	}
	
	@RequestMapping(value = { "/ViewUserTickets" }, method = RequestMethod.GET)
	public	String viewusertickets(ModelMap model) {
		
		return "/ViewUserTickets";
	}
	
	@RequestMapping(value = { "/UserTrackingTicket" }, method = RequestMethod.GET)
	public	String usertrackingticket(ModelMap model) {
		
		return "/UserTrackingTicket";
	}
	
	@RequestMapping(value = { "/ResolveUserTickets" }, method = RequestMethod.GET)
	public	String resolveusertickets(ModelMap model) {
		
		return "/ResolveUserTickets";
	}
	
	@RequestMapping(value = { "/CloseUserTickets" }, method = RequestMethod.GET)
	public	String closeusertickets(ModelMap model) {
		
		return "/CloseUserTickets";
	}
	
//	@RequestMapping(value = { "/ResetUserPassw" }, method = RequestMethod.GET)
//	public	String resetuserpassw(ModelMap model) {
//		
//		return "/ResetUserPassw";
//	}
//	
	@RequestMapping(value = { "/RaiseServiceCatalogue" }, method = RequestMethod.GET)
	public String RaiseServiceCatalogue(ModelMap model) {

		return "/RaiseServiceCatalogue";
	}
	
	@RequestMapping(value = { "/SelfHelpPortal" }, method = RequestMethod.GET)
	public String SelfHelpPortal(ModelMap model) {

		return "/SelfHelp";
	}
	@RequestMapping(value = { "/FORM3" }, method = RequestMethod.GET)
	public	String FORM3(ModelMap model) {
		
		return "/FORM3";
	}
	
	
	@RequestMapping(value = { "/VeloxProposal" }, method = RequestMethod.GET)
	public String veloxProposal(ModelMap model) {

		return "/VeloxProposal";
	}
	
	@RequestMapping(value = { "/VeloxLicense" }, method = RequestMethod.GET)
	public String VeloxLicense(ModelMap model) {

		return "/VeloxLicense";
	}
	
	
	
	@RequestMapping(value = { "/ViewCreatedVeloxLicense" }, method = RequestMethod.GET)
	public String CreatedVeloxLicense(ModelMap model) {

		return "/ViewCreatedVeloxLicense";
	}
	
	
	@RequestMapping(value = { "/ViewfulldetailsCreatedVeloxLicense" }, method = RequestMethod.GET)
	public String ViewfulldetailsCreatedVeloxLicense(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewfulldetailsCreatedVeloxLicense method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "ViewfulldetailsCreatedVeloxLicense";
	}
	
	
	@RequestMapping(value = { "/PurchaseOrder" }, method = RequestMethod.GET)
	public String purchaseOrder(ModelMap model) {

		return "/PurchaseOrder";
	}
	
	@RequestMapping(value = { "/ApprovedCollnMngDetails" }, method = RequestMethod.GET)
	public String ApprovedCollnMngDetails(ModelMap model) {
		System.out.println("Inside ApprovedCADetails method");
		
		return "CollectionManager/ApprovedCollnMngDetails";
	}
	@RequestMapping(value = { "/poRaisedByme" }, method = RequestMethod.GET)
	public String poRaisedByme(ModelMap model) {
		
		
		return "/SalesManager/poRaisedByme";
	}
	
	@RequestMapping(value = { "/ViewApprovedCollnManagDetails" }, method = RequestMethod.GET)
	public String viewApprovedCollnManagDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewApprovedCrfCMDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "CollectionManager/ViewApprovedCollnManagDetails";
	}
	
	@RequestMapping(value = { "/UserTrackingRequest" }, method = RequestMethod.GET)
	public String UserTrackingRequest(ModelMap model) {

		return "/UserTrackingRequest";
		
	}
	
	@RequestMapping(value = { "/ViewpoRaisedByme" }, method = RequestMethod.GET)
	public String viewpoRaisedByme(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewApprovedCrfCMDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "SalesManager/ViewpoRaisedByme";
	}
	@RequestMapping(value = { "/vlxProposalRejectedSI" }, method = RequestMethod.GET)
	public String vlxProposalRejectedSI(ModelMap model) {
		
		
		return "/VeloxProposal/vlxProposalRejectedSI";
	}
	@RequestMapping(value = { "/ViewVlxProposalRejectedSIDetails" }, method = RequestMethod.GET)
	public String ViewVlxProposalRejectedSIDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "VeloxProposal/ViewVlxProposalRejectedSIDetails";
	}
	
	@RequestMapping(value = { "/FeedbackRejectedSM" }, method = RequestMethod.GET)
	public String FeedbackRejectedSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside create user method");
		
		return "/VeloxProposal/FeedbackRejectedSM";
	}
	
	@RequestMapping(value = { "/pendingAppr" }, method = RequestMethod.GET)
	public String pendingAppr(ModelMap model) {
		
		
		return "/SalesManager/pendingApprsaleMng";
	}
	
	@RequestMapping(value = { "/pendingCustomer" }, method = RequestMethod.GET)
	public String pendingCustomer(ModelMap model) {
		
		
		return "/SalesManager/pendingCustomer";
	}
	
	@RequestMapping(value = { "/ApprovedPOByCM" }, method = RequestMethod.GET)
	public String ApprovedPOByCM(ModelMap model) {
		
		
		return "/SalesManager/ApprovedPOByCM";
	}
	
//	ApprovedPOByCM
	
	
	@RequestMapping(value = { "/ApprovedCMRegistFormDetails" }, method = RequestMethod.GET)
	public String ApprovedCMRegistFormDetails(ModelMap model) {
		
		
		return "/CollectionManager/ApprovedCMRegistFormDetails";
	}
	
	
	

	
	
	@RequestMapping(value = { "/raisedCustomer" }, method = RequestMethod.GET)
	public String raisedCustomer(ModelMap model) {
		
		
		return "/SalesManager/raisedCustomer";
	}
	
	@RequestMapping(value = { "/ViewServiceRequest" }, method = RequestMethod.GET)
	public	String viewservicerequest(ModelMap model) {
		
		return "/ViewServiceRequest";
	}
	
	
	@RequestMapping(value = { "/ViewSaleMngPending_RegistrationeDetails" }, method = RequestMethod.GET)
	public String ViewSaleMngPending_RegistrationeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewSaleMngPending_RegistrationeDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "SalesManager/ViewSaleMngPending_RegistrationDetails";
	}
	
	
	@RequestMapping(value = { "/VieeRejectedByCM" }, method = RequestMethod.GET)
	public String VieeRejectedByCM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewSaleMngPending_RegistrationeDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "SalesManager/VieeRejectedByCM";
	}
	
	
	
	@RequestMapping(value = { "/ViewSaleIniRaised_RegistrationeDetails" }, method = RequestMethod.GET)
	public String ViewSaleIniRaised_RegistrationeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewSaleMngPending_RegistrationeDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "SalesManager/ViewSaleIniRaised_RegistrationeDetails";
	}
	@RequestMapping(value = { "/ViewApprovedSaleMngDetails" }, method = RequestMethod.GET)
	public String viewApprovedSaleMngDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewApprovedCrfCMDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "SalesManager/SalesMngApproved";
	}
	
	
	@RequestMapping(value = { "/getFORM3Submitteddetails" }, method = RequestMethod.GET)
	public String getFORM3Submitteddetails(ModelMap model) {
		
		
		return "/Implementor/getFORM3Submitteddetails";
	}
	
	
	@RequestMapping(value = { "/ViewSubmittedFORM3Details" }, method = RequestMethod.GET)
	public String ViewSubmittedFORM3Details(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewpendingFORM3Details method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "Implementor/ViewSubmittedFORM3Details";
	}
	
	
	@RequestMapping(value = { "/ViewResolvedResquest" }, method = RequestMethod.GET)
	public String viewResolvedTicket(ModelMap model) {

		return "/ViewResolvedResquest";
	}
	@RequestMapping(value = { "/UserRaisedRequest" }, method = RequestMethod.GET)
	public String userRaisedTicket(ModelMap model) {

		return "/UserRaisedRequest";
	}
	
	@RequestMapping(value = { "/UserRaiseTicketOnBehalf" }, method = RequestMethod.GET)
	public String UserRaiseTicketOnBehalf(ModelMap model) {

		return "/UserRaiseTicketOnBehalf";
	}
	
	@RequestMapping(value = { "/RaiseServiceCatalogueOnBehalf" }, method = RequestMethod.GET)
	public String RaiseServiceCatalogueOnBehalf(ModelMap model) {

		return "/RaiseServiceCatalogueOnBehalf";
	}
	@RequestMapping(value = { "/UpdateProfile" }, method = RequestMethod.GET)
	public String UpdateProfile(ModelMap model) {

		return "/UpdateProfile";
	}
	
	
	@RequestMapping(value = { "/ViewVPRejSMDetails" }, method = RequestMethod.GET)
	public String ViewVPRejSMDetails(ModelMap model) {
		
		
		return "/VeloxProposal/ViewVPRejSMDetails";
	}
	
	@RequestMapping(value = { "/pendingFORM3" }, method = RequestMethod.GET)
	public String pendingFORM3(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside pendingFORM3 method");
		
		
		return "Implementor/pendingFORM3";
	}
	
	@RequestMapping(value = { "/ViewpendingFORM3Details" }, method = RequestMethod.GET)
	public String ViewpendingFORM3Details(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewpendingFORM3Details method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "Implementor/ViewpendingFORM3Details";
//	return "Pms/PmsimplformCdetails";
	}
	
	@RequestMapping(value = { "/PMSProjectDetails" }, method = RequestMethod.GET)
	public String PMSProjectDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewpendingFORM3Details method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		String projectId=request.getParameter("projectId");
		System.out.println("projectId999999"+projectId);
		System.out.println("crn3o"+crno);
		System.out.println("tid5"+tid);
//		return "Implementor/ViewpendingFORM3Details";
	return "Pms/PmsimplformCdetails";
	}
	
	
	
	@RequestMapping(value = { "/ViewCMapprovedRegistrationDetails" }, method = RequestMethod.GET)
	public String ViewCMapprovedRegistrationDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewSaleMngPending_RegistrationeDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "CollectionManager/ViewCMapprovedRegistrationDetails";
	}
	
	@RequestMapping(value = { "/pendingSMFormApp" }, method = RequestMethod.GET)
	public String pendingSMFormApp(ModelMap model) {
		
		
		return "/POForms/pendingSMFormApproval";
	}
	@RequestMapping(value = { "/ViewSaleMngFormABDetails" }, method = RequestMethod.GET)
	public String ViewSaleMngFormABDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewApprovedCrfCMDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "POForms/ViewSaleMngFormABDetails";
	}
	
	
	
	
	@RequestMapping(value = { "/submittedFormABDetails" }, method = RequestMethod.GET)
	public String submittedFormABDetails(ModelMap model) {
		System.out.println("Inside ApprovedCADetails method");
		
		return "POForms/submittedFormABDetails";
	}
	@RequestMapping(value = { "/ViewSubmittedFormABDetails" }, method = RequestMethod.GET)
	public String ViewSubmittedFormABDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewApprovedCrfCMDetails method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "POForms/ViewSubmittedFormABDetails";
	}
	
	
	@RequestMapping(value = { "/vlxProposalRejectedMD" }, method = RequestMethod.GET)
	public String vlxProposalRejectedMD(ModelMap model) {
		
		
		return "/VeloxProposal/vlxProposalRejectedMD";
	}

	@RequestMapping(value = { "/ViewVlxProposalRejectedMDDetails" }, method = RequestMethod.GET)
	public String ViewVlxProposalRejectedMDDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside ViewvlxProposalSendByme method");
		
		String crno=request.getParameter("crno");
		String tid=request.getParameter("tid");
		
		return "VeloxProposal/ViewVlxProposalRejectedMDDetails";
	}
	
	@RequestMapping(value = { "/RejectedCMRegistFormDetails" }, method = RequestMethod.GET)
	public String RejectedCMRegistFormDetail(ModelMap model) {
		
		
		return "/RejectedCMRegistFormDetails";
	}
	
	
	
	
	
////////////////////////Revise VLX Proposal 
	
	
@RequestMapping(value = { "/SendReviseCommercialProposal" }, method = RequestMethod.GET)
public String sendReviseCommercialProposal(ModelMap model) {


return "/ReviseProposal/SendReviseCommercialProposal";
}

@RequestMapping(value = { "/ReviseCommercialProposal" }, method = RequestMethod.GET)
public String reviseCommercialProposal(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ReviseCommercialProposal";
}

@RequestMapping(value = { "/ReviseCommercialProposalSendBySI" }, method = RequestMethod.GET)
public String reviseCommercialProposalSendBySI(ModelMap model) {


return "/ReviseProposal/ReviseCommercialProposalSendBySI";
}

@RequestMapping(value = { "/ViewReviseProposalSendBySI" }, method = RequestMethod.GET)
public String ViewReviseProposalSendBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ViewReviseProposalSendBySI";
}

	
@RequestMapping(value = { "/vlxProposalapr" }, method = RequestMethod.GET)
public String vlxProposalapr(ModelMap model) {
	
	
	return "/VeloxProposal/vlxProposalapr";
}


@RequestMapping(value = { "/purchaseorderapr" }, method = RequestMethod.GET)
public String purchaseorderapr(ModelMap model) {
	
	
	return "/VeloxProposal/purchaseorderapr";
}	



//////////////////////////////////////         Revise Proposal 2 2 version


@RequestMapping(value = { "/pendingRevisedProposalSMApproval" }, method = RequestMethod.GET)
public String pendingRevisedProposalSMApproval(ModelMap model) {


return "/ReviseProposal/pendingRevisedProposalSMApproval";
}

@RequestMapping(value = { "/ViewRevisedProposalPendingDetailsSM" }, method = RequestMethod.GET)
public String ViewRevisedProposalPendingDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ViewRevisedProposalPendingDetailsSM";
}

@RequestMapping(value = { "/ApprovedRevisedProposalSMDetails" }, method = RequestMethod.GET)
public String ApprovedRevisedProposalSMDetails(ModelMap model) {


return "/ReviseProposal/ApprovedRevisedProposalSMDetails";
}

@RequestMapping(value = { "/ViewRevisedProposalApproveDetailsSM" }, method = RequestMethod.GET)
public String ViewRevisedProposalApproveDetailsSM(ModelMap model) {


return "/ReviseProposal/ViewRevisedProposalApproveDetailsSM";
}


@RequestMapping(value = { "/RejectedRevisedProposalSM" }, method = RequestMethod.GET)
public String RejectedRevisedProposalSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside create user method");

return "/ReviseProposal/RejectedRevisedProposalSM";
}


@RequestMapping(value = { "/ViewRevisedProposalRejectedSMDetails" }, method = RequestMethod.GET)
public String ViewRevisedProposalRejectedSMDetails(ModelMap model) {


return "/ReviseProposal/ViewRevisedProposalRejectedSMDetails";
}

@RequestMapping(value = { "/revisedProposalRejectedSI" }, method = RequestMethod.GET)
public String revisedProposalRejectedSI(ModelMap model) {


return "/ReviseProposal/revisedProposalRejectedSI";
}

@RequestMapping(value = { "/ViewRevisedProposalRejectedSIDetails" }, method = RequestMethod.GET)
public String ViewRevisedProposalRejectedSIDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ViewRevisedProposalRejectedSIDetails";
}



/////////////////////////// Revise Proposal 3 3 version

@RequestMapping(value = { "/pendingRevisedProposalMD" }, method = RequestMethod.GET)
public String pendingRevisedProposalMD(ModelMap model) {


return "/ReviseProposal/pendingRevisedProposalMD";
}

@RequestMapping(value = { "/ViewRevisedProposalPendingDetailsMD" }, method = RequestMethod.GET)
public String ViewRevisedProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ViewRevisedProposalPendingDetailsMD";
}

@RequestMapping(value = { "/revisedProposalApprovedDetailsMD" }, method = RequestMethod.GET)
public String revisedProposalApprovedDetailsMD(ModelMap model) {


return "/ReviseProposal/revisedProposalApprovedDetailsMD";
}

@RequestMapping(value = { "/ViewRevisedProposalApproveDetailsMD" }, method = RequestMethod.GET)
public String ViewRevisedProposalApproveDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewRevisedProposalApproveDetailsMD method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseProposal/ViewRevisedProposalApproveDetailsMD";
}

@RequestMapping(value = { "/updateRegistrationFormBySI" }, method = RequestMethod.GET)
public String updateRegistrationBySI(ModelMap model) {
	
	
	return "/RegistrationMaster/updateRegistrationFormBySI";
}

@RequestMapping(value = { "/ViewUpdateRegistrationFormDetails" }, method = RequestMethod.GET)
public String ViewUpdateRegistrationFormDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewSaleMngPending_RegistrationeDetails method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "RegistrationMaster/ViewUpdateRegistrationFormDetails";
}
	
@RequestMapping(value = { "/PORejectedSM" }, method = RequestMethod.GET)
public String PORejectedSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/VeloxProposal/PORejectedSM";
}

@RequestMapping(value = { "/PurchaseOrderRejectedSI" }, method = RequestMethod.GET)
public String PurchaseOrderRejectedSI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/POReject/PurchaseOrderRejectedSI";
}

@RequestMapping(value = { "/ViewPurchaseOrderRejectSMDetails" }, method = RequestMethod.GET)
public String ViewPurchaseOrderRejectSMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/POReject/ViewPurchaseOrderRejectSMDetails";
}

@RequestMapping(value = { "/ViewApprovedPurchaseOrder" }, method = RequestMethod.GET)
public String ViewApprovedPurchaseOrder(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewApprovedPurchaseOrder method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "POForms/ViewApprovedPurchaseOrder";
}

@RequestMapping(value = { "/ViewPORejectedSMDetails" }, method = RequestMethod.GET)
public String ViewPORejectedSMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewPORejectedSMDetails method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "POForms/ViewPORejectedSMDetails";
}

@RequestMapping(value = { "/pendingProposalLicenseSM" }, method = RequestMethod.GET)
public String pendingProposalLicenseSM(ModelMap model) {
	
	
	return "/ProposalLicense/pendingProposalLicenseSM";
}

@RequestMapping(value = { "/ViewProposalLicensePendingDetails" }, method = RequestMethod.GET)
public String ViewProposalLicensePendingDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ProposalLicense/ViewProposalLicensePendingDetails";
}

@RequestMapping(value = { "/ApprovedProposalLicenseSMDetails" }, method = RequestMethod.GET)
public String ApprovedProposalLicenseSMDetails(ModelMap model) {
	
	
	return "/ProposalLicense/ApprovedProposalLicenseSMDetails";
}

@RequestMapping(value = { "/ViewProposalLicenseApprovedDetailsSM" }, method = RequestMethod.GET)
public String ViewProposalLicenseApprovedDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ProposalLicense/ViewProposalLicenseApprovedDetailsSM";
}


@RequestMapping(value = { "/pendingProposalLicenseBH" }, method = RequestMethod.GET)
public String pendingProposalLicenseBH(ModelMap model) {
	
	
	return "/ProposalLicense/pendingProposalLicenseBH";
}

@RequestMapping(value = { "/ViewProposalLicensePendingDetailsBH" }, method = RequestMethod.GET)
public String ViewProposalLicensePendingDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ProposalLicense/ViewProposalLicensePendingDetailsBH";
}


@RequestMapping(value = { "/ApprovedProposalLicenseDetailsBH" }, method = RequestMethod.GET)
public String ApprovedProposalLicenseDetailsBH(ModelMap model) {
	
	
	return "/ProposalLicense/ApprovedProposalLicenseDetailsBH";
}


@RequestMapping(value = { "/ViewProposalLicenseApprovedDetailsBH" }, method = RequestMethod.GET)
public String ViewProposalLicenseApprovedDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ProposalLicense/ViewProposalLicenseApprovedDetailsBH";
}

@RequestMapping(value = { "/manualCommercialProposal" }, method = RequestMethod.GET)
public String manualCommercialProposal(ModelMap model) {
	
	
	return "/ManualProposal/manualCommercialProposal";
}

@RequestMapping(value = { "/manualCommProposalSendBySI" }, method = RequestMethod.GET)
public String manualCommProposalSendBySI(ModelMap model) {
	
	
	return "/ManualProposal/manualCommProposalSendBySI";
}

@RequestMapping(value = { "/ViewManualProposalSendBySI" }, method = RequestMethod.GET)
public String ViewManualProposalSendBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewManualProposalSendBySI method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ManualProposal/ViewManualProposalSendBySI";
}

@RequestMapping(value = { "/pendingManualProposalApprovalSM" }, method = RequestMethod.GET)
public String pendingManualProposalApprovalSM(ModelMap model) {
	
	
	return "/ManualProposal/pendingManualProposalApprovalSM";
}

@RequestMapping(value = { "/ViewManualProposalPendingDetailsSM" }, method = RequestMethod.GET)
public String ViewManualProposalPendingDetailsSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ManualProposal/ViewManualProposalPendingDetailsSM";
}

@RequestMapping(value = { "/ApprovedManualProposalDetailsSM" }, method = RequestMethod.GET)
public String ApprovedManualProposalDetailsSM(ModelMap model) {
	
	
	return "/ManualProposal/ApprovedManualProposalDetailsSM";
}

@RequestMapping(value = { "/ViewManualProposalApprovedDetailsSM" }, method = RequestMethod.GET)
public String ViewManualProposalApprovedDetailsSM(ModelMap model) {
	
	
	return "/ManualProposal/ViewManualProposalApprovedDetailsSM";
}

@RequestMapping(value = { "/pendingManualProposalApprovalMD" }, method = RequestMethod.GET)
public String pendingManualProposalApprovalMD(ModelMap model) {
	
	
	return "/ManualProposal/pendingManualProposalApprovalMD";
}

@RequestMapping(value = { "/ViewManualProposalPendingDetailsMD" }, method = RequestMethod.GET)
public String ViewManualProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ManualProposal/ViewManualProposalPendingDetailsMD";
}

@RequestMapping(value = { "/ApprovedManualProposalDetailsMD" }, method = RequestMethod.GET)
public String ApprovedManualProposalDetailsMD(ModelMap model) {
	
	
	return "/ManualProposal/ApprovedManualProposalDetailsMD";
}

@RequestMapping(value = { "/ViewManualProposalApprovedDetailsMD" }, method = RequestMethod.GET)
public String ViewManualProposalApprovedDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ManualProposal/ViewManualProposalApprovedDetailsMD";
}

//10/1  FeedbackRejectedSM
@RequestMapping(value = { "/FeedbackMannualRejectedSM" }, method = RequestMethod.GET)
public String FeedbackMannualRejectedSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/VeloxProposal/FeedbackMannualRejectedSM";
}
//12/24
@RequestMapping(value = { "/ManualProposalRejectByMD" }, method = RequestMethod.GET)
public String ManualProposalRejectByMD(ModelMap model) {

	return "MD/ManualProposalRejectByMD";
}

@RequestMapping(value = { "/ViewManualProposalRejectedDeatils" }, method = RequestMethod.GET)
public String ViewManualProposalRejectedDeatils(ModelMap model) {

	return "ManualProposal/ViewManualProposalRejectedDeatils";
}

@RequestMapping(value = { "/RejectedCMDetails" }, method = RequestMethod.GET)
public String RejectedCMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");

	return "/RejectedCMDetails";
}



//11/1 Manual Rej Details
@RequestMapping(value = { "/ViewVPManualRejSMDetails" }, method = RequestMethod.GET)
public String ViewVPManualRejSMDetails(ModelMap model) {	
	
	return "/ManualProposal/ViewVPManualRejSMDetails";
}

//rejected feedback to SI
@RequestMapping(value = { "/ManualRejectedFeedbackSI" }, method = RequestMethod.GET)
public String ManualRejectedFeedbackSM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/ManualProposal/ManualRejectedFeedbackSI";
}

//view details of Rej Feedback
@RequestMapping(value = { "/ViewManualRejSIDetails" }, method = RequestMethod.GET)
public String ViewManualRejSIDetails(ModelMap model) {	
	
	return "/ManualProposal/ViewManualRejSIDetails";
}

//16/24
@RequestMapping(value = { "/ViewApprovedUdbyMD" }, method = RequestMethod.GET)
public String ViewApprovedUdbyMD(ModelMap model) {
	System.out.println("Inside ViewApprovedUdbyMD method");

	return "CollectionManager/ViewApprovedUdbyMD";
}

// 18/1    ImplPendingTasks
@RequestMapping(value = { "/ImplPendingTasks" }, method = RequestMethod.GET)
public String ImplPendingTasks(ModelMap model) {
	System.out.println("Inside ImplPendingTasks method");

	return "Pms/ImplPendingTasks";
}

@RequestMapping(value = { "/ImplCompletedTasks" }, method = RequestMethod.GET)
public String ImplCompletedTasks(ModelMap model) {
	System.out.println("Inside ImplCompletedTasks method");

	return "Pms/ImplCompletedTasks";
}

//19/24
@RequestMapping(value = { "/ManualPurchaseOrder" }, method = RequestMethod.GET)
public String ManualPurchaseOrder(ModelMap model) {

	return "/ManualPurchaseOrder";
}

//20/24
@RequestMapping(value = { "/RejectedProposalLicenseDetailsBH" }, method = RequestMethod.GET)
public String RejectedProposalLicenseDetailsBH(ModelMap model) {
	
	
	return "/ProposalLicense/RejectedProposalLicenseDetailsBH";
}

@RequestMapping(value = { "/ViewProposalLicenseRejectedDetailsBH" }, method = RequestMethod.GET)
public String ViewProposalLicenseRejectedDetailsBH(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ProposalLicense/ViewProposalLicenseRejectedDetailsBH";
}

//20/1
@RequestMapping(value = { "/LicenseRejectedSM" }, method = RequestMethod.GET)
public String LicenseRejectedSM(ModelMap model) {
	
	
	return "/ProposalLicense/LicenseRejectedSM";
}  

@RequestMapping(value = { "/ViewLicenseRejSMDetails" }, method = RequestMethod.GET)
public String ViewLicenseRejSMDetails(ModelMap model) {
	
	
	return "/ProposalLicense/ViewLicenseRejSMDetails";
}

@RequestMapping(value = { "/ManualpoRaisedByme" }, method = RequestMethod.GET)
public String ManualpoRaisedByme(ModelMap model) {
	
	
	return "/SalesManager/ManualpoRaisedByme";
}

@RequestMapping(value = { "/ViewManualPoRaisedByme" }, method = RequestMethod.GET)
public String ViewManualPoRaisedByme(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewManualPoRaisedByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "SalesManager/ViewManualPoRaisedByme";
}

//SI  LicenseRejectedFeedbackSI
@RequestMapping(value = { "/LicenseRejectedFeedbackSI" }, method = RequestMethod.GET)
public String LicenseRejectedFeedbackSI(ModelMap model) {
	
	
	return "/ProposalLicense/LicenseRejectedFeedbackSI";
}

//ViewLicenseRejSIDetails
@RequestMapping(value = { "/ViewLicenseRejSIDetails" }, method = RequestMethod.GET)
public String ViewLicenseRejSIDetails(ModelMap model) {
	return "/ProposalLicense/ViewLicenseRejSIDetails";
}
//1/2/24
@RequestMapping(value = { "/PORejectedByCM" }, method = RequestMethod.GET)
public String PORejectedByCM(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/SalesManager/PORejectedByCM";
}

@RequestMapping(value = { "/ViewPORejectedByCMDetails" }, method = RequestMethod.GET)
public String ViewPORejectedByCMDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside create user method");
	
	return "/SalesManager/ViewPORejectedByCMDetails";
}


//3/2
@RequestMapping(value = { "/ApprovedLicenseList" }, method = RequestMethod.GET)
public String ApprovedLicenseList(ModelMap model) {	
	
	return "/ProposalLicense/ApprovedLicenseList";
}        


@RequestMapping(value = { "/ViewApprovedLicenseDetails" }, method = RequestMethod.GET)
public String ViewApprovedLicenseDetails(ModelMap model) {
	
	return "/ProposalLicense/ViewApprovedLicenseDetails"; 
}

//5/2/24
@RequestMapping(value = { "/getFORM3SubmitteddBySupportManager" }, method = RequestMethod.GET)
public String getFORM3SubmitteddBySupportManager(ModelMap model) {
	
	
	return "/Implementor/getFORM3SubmitteddBySupportManager";
}

@RequestMapping(value = { "/ViewFORM3SubmitteddBySupportManager" }, method = RequestMethod.GET)
public String ViewFORM3SubmitteddBySupportManager(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewFORM3SubmitteddBySupportManager method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "Implementor/ViewFORM3SubmitteddBySupportManager";
}

@RequestMapping(value = { "/SentLicenseMailList" }, method = RequestMethod.GET)
public String SentLicenseMailList(ModelMap model) {	
	
	return "/ProposalLicense/SentLicenseMailList";
}


@RequestMapping(value = { "/ViewSentMailLicenseDetails" }, method = RequestMethod.GET)
public String ViewSentMailLicenseDetails(ModelMap model) {	
	
	return "/ProposalLicense/ViewSentMailLicenseDetails";
}


@RequestMapping(value = { "/ExportAllPO" }, method = RequestMethod.GET)
public String ExportAllPO(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	

	return "ExportAllPO/ExportAllPO";
}

//20/2/24
@RequestMapping(value = { "/SendReviseManualCommercialProposal" }, method = RequestMethod.GET)
public String SendReviseManualCommercialProposal(ModelMap model) {


return "/ReviseManualProposal/SendReviseManualCommercialProposal";
}

@RequestMapping(value = { "/ViewReviseManualProposalSendBySI" }, method = RequestMethod.GET)
public String ViewReviseManualProposalSendBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewManualProposalSendBySI method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ReviseManualProposal/ViewReviseManualProposalSendBySI";
}

//21/2/24
@RequestMapping(value = { "/ReviseManualProposalSendBySI" }, method = RequestMethod.GET)
public String ReviseManualProposalSendBySI(ModelMap model) {


return "/ReviseManualProposal/ReviseManualProposalSendBySI";
}

@RequestMapping(value = { "/pendingRevisedManualProposalMD" }, method = RequestMethod.GET)
public String pendingRevisedManualProposalMD(ModelMap model) {


return "/ReviseManualProposal/pendingRevisedManualProposalMD";
}

@RequestMapping(value = { "/ViewReviseManualProposalApprovedDetailsMD" }, method = RequestMethod.GET)
public String ViewReviseManualProposalApprovedDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewvlxProposalSendByme method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ReviseManualProposal/ViewReviseManualProposalApprovedDetailsMD";
}

@RequestMapping(value = { "/ViewRevisedManualProposalPendingDetailsMD" }, method = RequestMethod.GET)
public String ViewRevisedManualProposalPendingDetailsMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside ViewvlxProposalSendByme method");

String crno=request.getParameter("crno");
String tid=request.getParameter("tid");

return "ReviseManualProposal/ViewRevisedManualProposalPendingDetailsMD";
}

@RequestMapping(value = { "/revisedManualProposalApprovedDetailsMD" }, method = RequestMethod.GET)
public String revisedManualProposalApprovedDetailsMD(ModelMap model) {


return "/ReviseManualProposal/revisedManualProposalApprovedDetailsMD";
}

@RequestMapping(value = { "/ViewApprovedDetails" }, method = RequestMethod.GET)
public String ViewApprovedDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewApprovedDetails method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "/SalesManager/ViewApprovedDetails";
}


@RequestMapping(value = { "/revisedManualProposalRejectedSI" }, method = RequestMethod.GET)
public String revisedManualProposalRejectedSI(ModelMap model) {


return "/ReviseManualProposal/revisedManualProposalRejectedSI";
}

@RequestMapping(value = { "/ViewReviseManualProposalRejectByMD" }, method = RequestMethod.GET)
public String ViewReviseManualProposalRejectByMD(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewReviseManualProposalRejectByMD method");
	
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	
	return "ReviseManualProposal/ViewReviseManualProposalRejectByMD";
}

@RequestMapping(value = { "/ImplPendingDates" }, method = RequestMethod.GET)
public String ImplPendingDates(ModelMap model) {
	System.out.println("Inside ImplPendingDates method");

	return "Pms/ImplPendingDates";
}


@RequestMapping(value = { "/ViewpoRaisedBySI" }, method = RequestMethod.GET)
public String ViewpoRaisedBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewpoRaisedBySI method");
	String crno=request.getParameter("crno");
	String tid=request.getParameter("tid");
	return "SalesManager/ViewpoRaisedBySI";
}


@RequestMapping(value = { "/ViewManualPoRaisedBySI" }, method = RequestMethod.GET)
public String ViewManualPoRaisedBySI(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside ViewManualPoRaisedBySI method");
	
	return "SalesManager/ViewManualPoRaisedBySI";
}


@RequestMapping(value = { "/generalTasks" }, method = RequestMethod.GET)
public String generalTasks(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside generalTasks method");
	
	return "Tasks/generalTasks";
}


@RequestMapping(value = { "/rfpTasks" }, method = RequestMethod.GET)
public String rfpTasks(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside rfpTasks method");
	
	return "Tasks/rfpTasks";
}


@RequestMapping(value = { "/operationalTasks" }, method = RequestMethod.GET)
public String operationalTasks(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside operationalTasks method");
	
	return "Tasks/operationalTasks";
}



}