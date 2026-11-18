package com.velox.itsm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.zxing.qrcode.decoder.Mode;

@Controller

@RequestMapping("/EForm")
@SessionAttributes("roles")
public class EFormController {
	
	@RequestMapping(value = {"/Softwarerequest"} ,method = RequestMethod.GET)
	public String softwareRequest(ModelMap model)
	{
		return "/Softwarerequest";
	}
	@RequestMapping(value = {"/PendingTOApproved"} ,method = RequestMethod.GET)
	public String PendingTOApproved(ModelMap model)
	{
		return "/PendingTOApproved";
	}
	@RequestMapping(value = {"/RequestApprove"} ,method = RequestMethod.GET)
	public String ApprovedUser(ModelMap model)
	{
		return "/RequestApprove";
	}
	@RequestMapping(value = {"/RequestApproveInTc"} ,method = RequestMethod.GET)
	public String RequestApproveInTc(ModelMap model)
	{
		return "/RequestApproveInTc";
	}
	@RequestMapping(value = {"/MySoftwareRequest"} ,method = RequestMethod.GET)
	public String MySoftwareRequest()
	{
		return "/MySoftwareRequest";
	}
	@RequestMapping(value = {"/SoftwareRequestTracking/{data}"} ,method = RequestMethod.GET)
	public String SoftwareRequestTracking(@PathVariable String data,Model model,HttpServletRequest httpServletRequest)
	{
//		model.addAttribute("data", data);
		httpServletRequest.setAttribute("data",data);
		return "/SoftwareRequestTracking";
	}
	@RequestMapping(value = {"/MyApprovedRequestInTc"} ,method = RequestMethod.GET)
	public String MyApprovedRequest(ModelMap model)
	{
		return "/MyApprovedRequestInTc";
	}
	@RequestMapping(value = {"/WorkInProgressBucket"} ,method = RequestMethod.GET)
	public String WorkInProgressBucket(ModelMap model)
	{
		return "/WorkInProgressBucket";
	}
	@RequestMapping(value = {"/SoftwareMaster"},method = RequestMethod.GET)
	public String SoftwareMaster(ModelMap modelMap)
	{
		return "/SoftwareMaster";
	}
//	SoftwareRelease
	@RequestMapping(value = {"/SoftwareRelease"},method = RequestMethod.GET)
	public String SoftwareRelease(ModelMap modelMap)
	{
		return "/SoftwareRelease";
	}
	@RequestMapping(value = {"/MyReleaseSoftwareRequest"},method = RequestMethod.GET)
	public String MyReleaseSoftwareRequest(ModelMap modelMap)
	{
		return "/MyReleaseSoftwareRequest";
	}

	@RequestMapping (value = {"/ApproveReleaseSoftware"},method = RequestMethod.GET)
	public String ApproveReleaseSoftware()
	{
		return "/ApproveReleaseSoftware";
	}
	
	@RequestMapping(value = {"/ReleaseRequestInTc"},method = RequestMethod.GET)
	public String ReleaseRequestInTc()
	{
		return "/ReleaseRequestInTc";
	}
	@RequestMapping(value = {"/NTReleaseRequestInTc"},method = RequestMethod.GET)
	public String NTReleaseRequestInTc()
	{
		return "/NTReleaseRequestInTc";
	}
	
	
	@RequestMapping(value = {"/RequestApproveInEng"},method = RequestMethod.GET)
	public String RequestApproveInEng()
	{
		return "/RequestApproveInEng";
	}
	@RequestMapping(value = {"/WorkInProgressBucketInEng"},method = RequestMethod.GET)
	public String WorkInProgressBucketInEng()
	{
		return "/WorkInProgressBucketInEng";
	}
	@RequestMapping(value = {"/PendingRequestMail"},method = RequestMethod.GET)
	public String PendingRequestMail()
	{
		return "/PendingRequestMail";
	}
	@RequestMapping(value = {"/RaiseTrasnferRequest"},method = RequestMethod.GET)
	public String RaiseTrasnferRequest()
	{
		return "/RaiseTrasnferRequest";
	}
	@RequestMapping(value = {"/PendingTransferRequest"},method = RequestMethod.GET)
	public String PendingTransferRequest()
	{
		return "/PendingTransferRequest";
	}
	@RequestMapping(value = {"/PendingTransferRequestInEng"},method = RequestMethod.GET)
	public String PendingTransferRequestInEng()
	{
		return "/PendingTransferRequestInEng";
	}
	@RequestMapping(value = {"/MyTransferRequest"},method = RequestMethod.GET)
	public String MyTransferRequest()
	{
		return "/MyTransferRequest";
	}
	@RequestMapping(value = {"/TransferApproveInTc"},method = RequestMethod.GET)
	public String TransferApproveInTc()
	{
		return "/TransferApproveInTc";
	}
	@RequestMapping(value = {"/WorkInProgressTransferBucket"},method = RequestMethod.GET)
	public String WorkInProgressTransferBucket()
	{
		return "/WorkInProgressTransferBucket";
	}
	
	@RequestMapping(value = {"/RaiseBussinessId"},method = RequestMethod.GET)
	public String RaiseBussinessId()
	{
		return "/RaiseBussinessId";
	}
	@RequestMapping(value = {"/NTAdminTransferApproveInTc"},method = RequestMethod.GET)
	public String NTAdminTransferApproveInTc()
	{
		return "/NTAdminTransferApproveInTc";
	}
	@RequestMapping(value = {"/NTAdminWorkInProgressTransferBucket"},method = RequestMethod.GET)
	public String NTAdminWorkInProgressTransferBucket()
	{
		return "/NTAdminWorkInProgressTransferBucket";
	}
	@RequestMapping(value = {"/ReleaseRequestInTcForResolve"},method = RequestMethod.GET)
	public String ReleaseRequestInTcForResolve()
	{
		return "/ReleaseRequestInTcForResolve";
	}
	@RequestMapping(value = {"/NTAdminRequestForResolve"},method = RequestMethod.GET)
	public String NTAdminRequestForResolve()
	{
		return "/NTAdminRequestForResolve";
	}
	
	/////////////////////////efrom business Request Tracking///////////////////////////
	
	@RequestMapping(value = {"/BusinessRequest"} ,method = RequestMethod.GET)
	public String BussnessRequest(ModelMap model)
	{
		return "/BusinessRequest";
	}
	
	@RequestMapping(value = {"/MyBusinessRequest"} ,method = RequestMethod.GET)
	public String MyBussnessRequest(ModelMap model)
	{
		return "/MyBusinessRequest";
	}  
	
	@RequestMapping(value = {"/BusinessRequestTracking"} ,method = RequestMethod.GET)
	public String MyBussnessRequestTracking(ModelMap model)
	{
		return "/BusinessRequestTracking";
	}  //PendingApprovalBusinessRequest
	
	@RequestMapping(value = {"/PendingApprovalBusinessRequest"} ,method = RequestMethod.GET)
	public String PendingApprovalBusinessRequest(ModelMap model)
	{
		return "/PendingApprovalBusinessRequest";
	}
	
	@RequestMapping(value = {"/GalUpdateBusinessRequest"} ,method = RequestMethod.GET)
	public String GalUpdateBusinessRequest(ModelMap model)
	{
		return "/GalUpdateBusinessRequest"; 
	}
	
	@RequestMapping(value = {"/MailAdminBusinessRequest"} ,method = RequestMethod.GET)
	public String MailAdminBusinessRequest(ModelMap model)
	{
		return "/MailAdminBusinessRequest";  
	}
	
	@RequestMapping(value = {"/MailAdminBucket"} ,method = RequestMethod.GET)
	public String MailAdminBucket(ModelMap model)
	{
		return "/MailAdminBucket";  
	}
	@RequestMapping(value = {"/SoftwareReleaseRequesttoApprove"} ,method = RequestMethod.GET)
	public String SoftwareReleaseRequesttoApprove(ModelMap model)
	{
		return "/SoftwareReleaseRequesttoApprove";  
	}
	
	
}
	
