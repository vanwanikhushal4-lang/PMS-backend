package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface UserActivityService {
	public JSONArray getAllUserDetails(String LoginUser);
	
	public String insertUserRaiseTicket(String fullname,String datepicker5,String phone,String emailid,String compname,String site,String category,String subcat1,String subcat2,String requestmode,String department,String subject,String description,String priority, String severity, MultipartFile empPic, String username, String vipuser, String assetTag, String assetName, String assetCategory, String assetStatus, String assetCheck,String asset_sub_category ,String asset_Ipaddress);
	public JSONArray getUserTicketList(String userlist);
	public JSONArray gatherUserTicketDetails(String ticketid);
	public JSONArray getUserTicketID(String details,String selecttype);
	public JSONArray getUserTicketTracking(String ticketid);
	public JSONArray getUserTicketTrackingMessage(int ticketid);
	public JSONArray getResolvedUserTicketList(String userlist);
	public String closeUserResolvedTicket(String ticketid, String closereason);
	public String UserReopenResolvedTicket(String  RequesterName, String RequesterCompany, String RequesterBranch, String RequesterDept, String RequesterSubDept, String RequesterLocation, String RequesterPhone, String RequesterEmail, String TicketID, String TicketStatus, String TicketRaiseDate, String Category, String SubCat1, String SubCat2, String Subject, String Priority, String Severity, String T_Description, String T_RequestMode, String ReopenReason, MultipartFile reopenPic);
	public JSONArray getClosedUserTicketList(String userlist);
	public String UserPasswordreset(String user,String oldpass,String newpass,String cnfnewpass);
	public JSONArray getVlxProposalData(String crfId,String uname,String tid);
	public JSONArray getUserDashboardData(String loginuser, String loginUserCompany);
	public JSONArray getTicketActivityLog(String ticketid);
	public String getUpdateCollnMangpprove(String crno,String status,String tid,String uname,String company,String aMnote);
	public JSONArray PoRaiseByMeDetails(String uname, String company, String role);
	public JSONArray getApprovaalCollnMangData(String crfId,String uname,String tid);
	public String insertServiceCatalogueRequest(String fullname,String datepicker5,String phone,String emailid,String compname,String site,String category,String subcat1,String subcat2,String requestmode,String department,String subject,String description,String priority, MultipartFile empPic, String username, String vipuser,String severity);
	public JSONArray getSelfHelpList(String selfhelplist);
	public JSONArray gatherSelfHelpDetails(String selfhelpid);
	
	public String insertServiceRequestCatalogueRequest(String fullname, String datepicker5, String phone,
			String emailid, String compname, String site, String category, String subcat1, String subcat2,
			String requestmode, String department, String subject, String description, String priority,
			MultipartFile empPic, String username, String vipuser,String approval1username,String groupname,String designationlevel1,String requesttype,String severity,String approve_level,String requestcost,String designationlevel2, String approve_level1_FullName, String approvel_level_email, String otheremailforbehalf,String assetTag,String assetName,String AssetCategory,String AssetStatus,String AssetCheck,String asset_sub_category,String asset_Ipaddress);
	public JSONArray getServiceRequest(String servicerequest);
	public JSONArray gatherUserServiceRequest(String ticketid);
	public JSONArray getServiceActivityLog(String ticketid);
	public JSONArray getServiceActivityLog2(String ticketid);
	public JSONArray getUserRequestID(String details);
	public JSONArray getUserServiceTracking(String ticketid);
	public JSONArray ApprovedCollnMangDetails(String uname,String company,String role);
	
	public JSONArray getResolvedRequest(String userlist);
	public JSONArray gatherResolvedRequestsDetails(String ticketid);
	public String closeUserResolvedRequest(String ticketid, String closereason);
	public JSONArray getUserRaisedRequest(String ticketlist);
	public JSONArray Getotherinformaion(String othercompany, String othername);
	
	public JSONArray getServiceRequestDashboardData(String loginuser, String loginUserCompany);
	public JSONArray getServiceRequestListing(String chartdata);
	public JSONArray getDashboardListingForTickets(String chartdata);
	public JSONArray getAlldataAccordingsubject(String subject, String company);
	public JSONArray getallusernameforraiseonbehalf(String company);
	public String inserRaiseOnBehalfTicket(String fullname, String datepicker5, String phone, String emailid,
			String compname, String site, String category, String subcat1, String subcat2, String requestmode,
			String department, String subject, String description, String priority, String severity,
			MultipartFile empPic, String usernameofraiseby, String vipuser, String t_request, String otherfullname, String assetTag, String assetName, String assetCategory, String assetStatus, String assetCheck, String asset_sub_category, String asset_Ipaddress);
	
	public String insertFormA(String dateforma,String salemangname, String distributorpartyname, String distributorprojectname, String distributortechpersonname,
			String distributorprsndesignation,String  distributorcontactnumber, String distributoremailid, String partnerpartyname,String  partnerprojectname,String  partnertechpersonname, String partnerprsndesignation,String  partnercontactnumber, String partneremailid,String  customerpartyname,String  customerprojectname,String  customertechpersonname,String customerprsndesignation,String customercontactnumber,String customeremailid,
			String implementorpartyname,String implementorprojectname,String implementortechpersonname,String implementorprsndesignation,String implementorcontactnumber,String implementoremailid);
	
	public String insertForm2(String form2date, String form2customername,String RPFTIMELINES,String potimeline, String firstinvoicegeneratedate,
			String radiosss, String projstartdate,String projenddate,String pymentterms, String projecthead);
	

	public String insertServiceRequestCatalogueRequestOnBehalf(String fullname, String datepicker5, String phone,
			String emailid, String compname, String site, String category, String subcat1, String subcat2,
			String requestmode, String department, String subject, String description, String priority,
			MultipartFile empPic, String username, String vipuser, String approval1username, String groupname,
			String designationlevel1, String requesttype, String severity, String approve_level, String requestcost,
			String designationlevel2, String t_requester, String app_level1_fullname, String otheremailforbehalf,String assetTag,String assetName,String AssetCategory,String AssetStatus,String AssetCheck,String asset_sub_category,String asset_Ipaddress);
	
	public JSONArray getUserDetailsForUpdate(String loginUser);
	public String updateLoginUserProfile(String username, String cname, String site, String location, String dname,
			String subDepartment, String emailid, String cno, String designation);
	public String ReopenResolvedServiceRequest(String requesterName, String requesterCompany, String requesterBranch,
			String requesterDept, String requesterSubDept, String requesterLocation, String requesterPhone,
			String requesterEmail, String ticketID, String ticketStatus, String ticketRaiseDate, String category,
			String subCat1, String subCat2, String subject, String priority, String severity, String t_Description,
			String t_RequestMode, String reopenReason, MultipartFile reopenPic);
	public JSONArray chekingSLA(String company, String priority, String severity);
	public JSONArray GetAssetinformaion(String othername);
	public JSONArray getProblemTicketsListing(String othername, String dates);
	public JSONArray getIncidentCategoryListing(String chartdata,String lastmonth);
	public JSONArray getPieListForCategoryServiceRequest(String chartdata,String lastmonth);
	public JSONArray getIncidentPrioritySeverityListing(String priority, String severity, String lastmonth);
	public JSONArray getServicePrioritySeverityListing(String priority, String severity, String lastmonth);
	public JSONArray getallUserByLocationBased(String company, String location);
	
	
	public JSONArray saleMngApprByMeDetails(String uname, String company,String userfullname);
	
	public JSONArray getApprovaalSaleMngData(String crfId,String uname,String tid);
	public JSONArray vlxProposalSendBymeDetails(String uname, String company);
	public JSONArray vlxProposalPendingDetails(String uname, String company,String userfullname);
	public JSONArray getVlxProposalPendingData(String crno, String uname, String tid);
	public String UpdateVlxPropSaleMangApprove(String crno, String status, String tid, String uname, String company, String sMnote);
	public JSONArray vlxPropApproveBymeDetails(String uname, String company,String userfullname);
	public JSONArray getVlxProposalApprovedData(String crno, String uname, String tid);
	public JSONArray vlxProposalMDPendingDetails(String uname, String company);
	public JSONArray getVlxProposalApprovalMDData(String crno, String uname, String tid);
	public String UpdateVlxPropMDApprove(String crno, String status, String tid, String uname, String company,String MDnote);
	public JSONArray vlxProposalApproveDetails(String uname, String company);
	public JSONArray getVlxProposalApprovedMDData(String crno, String uname, String tid);
	public JSONArray vlxProposalRejectedSIDetails(String uname, String company, String fullname);
	public JSONArray getVlxProposalSIRejectedData(String crno, String uname, String tid);
	
	public JSONArray vlxPropRejectedBymeDetails(String uname, String company,String userfullname);
	public JSONArray getVlxProposalSMRejectedData(String crno, String uname, String tid);
	public String SMrejectVP(String crno, String company, String rejectreason, String sMnote, String uname, String tid);
	public JSONArray SaleMngPending_RegistrationeDetails(String uname, String company, String fullname);
	public JSONArray pendingFORM3Details(String uname, String company,String fullname);
	public JSONArray getPendingFORM3Data(String crno, String uname, String tid,String fullname);
	public JSONArray SalesIniraised_RegistrationDetails(String uname, String company);
	public JSONArray getRaisedRegistraionlist(String crno, String uname, String tid);
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
			String EndCustomerNumber);
	public String registFormCollnMangApprove(String crno, String status, String tid, String uname, String company);
	public JSONArray CMapprovedRegistrationDetails(String uname, String company, String fullname, String role);
	public JSONArray getApprovedCMRegistraionlist(String crno, String uname, String tid);
	public JSONArray getSubmittedFORM3Data(String crno, String uname, String tid);
	public JSONArray submittedFORM3Details(String uname, String company);
	public JSONArray getCheckerContactNo(String checkerApprovername);
	public JSONArray getDataSaleMngFormABDetails(String crno, String uname, String tid);
	public JSONArray SaleMngFormABDetails(String uname, String company,String userfullname);
	public JSONArray trackDetails(String fromDate, String toDate,String selecttype, String selectType2);
	public JSONArray getSubmittedFormABData(String crno, String uname, String tid);
	public JSONArray submittedFormABseniorMangDetails(String uname, String company, String fullname);


	public String MDrejectVP(String crno, String company, String rejectreason, String mDnote, String uname, String tid);

	public JSONArray vlxProposalRejectDetails(String uname, String company);

	public JSONArray vlxProposalRejectedMDDetails(String uname, String company, String fullname);

	public JSONArray getVlxProposalMDRejectedData(String crno, String uname, String tid);
	
	public String insertPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
			String paymentterms, String prodliscense, String prodamount, String warrantystart, String warrantyend,
			String advaninvoice, MultipartFile[] advinvoicefile1, String loginuser, String loginUserCompany,
			String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
			String podate, String amcstartdate, String amcenddate, String productsuit, String securitytool,
			String warrantyMonth, String warrantyYear, String aMCMonth, String aMCYear, String sInote,
			String tennurestartdate, String tennureenddate, String tennureMonth, String tennureYear, String firstApprover,String SecondApprovername,String fixedyear,String subscriptionyear,String perpetualyear,MultipartFile[] massPOfile1,MultipartFile[] productFeaturedFileList, MultipartFile[] invoiceuploadfile,
			MultipartFile[] attendanceuploadFile, MultipartFile[] calculationuploadfile, String customerEmail, String subscriptionANDperpetualYear, String customerName);	
	
	public String insertPOFormAB(String loginuser, String loginUserCompany, String dateforma, String salemangname,
			String distributorpartyname, String distributorprojectname, String distributortechpersonname,
			String distributorprsndesignation, String distributorcontactnumber, String distributoremailid,
			String partnerpartyname, String partnerprojectname, String partnertechpersonname,
			String partnerprsndesignation, String partnercontactnumber, String partneremailid, String customerpartyname,
			String customerprojectname, String customertechpersonname, String customerprsndesignation,
			String customercontactnumber, String customeremailid, String implementorpartyname,
			String implementorprojectname, String implementortechpersonname, String implementorprsndesignation,
			String implementorcontactnumber, String implementoremailid, String form2date, String form2customername,
			String rPFTIMELINES, String potimeline, String firstinvoicegeneratedate, String radiosss,
			String projstartdate, String projenddate, String pymentterms, String projecthead, String formApoNo,
			String poform2No, String remarks, String chartpaymntno, String crno, String tid, String jsonImplFormC,
			String endcustomerpartyname, String endcustomerprojectname, String endcustomertechpersonname,
			String endcustomerprsndesignation, String endcustomercontactnumber, String endcustomeremailid,String sMnote, String potype);

	
	public String rejectRFtoACmgr(String crno, String company, String rejectreason, String mDnote, String uname, String tid);
	public JSONArray Rejectrfdetails(String uname, String company, String role);

	public JSONArray getfrom3details(String loginUser, String ponumber);

	public JSONArray getPoRaisedData(String crno, String uname, String tid);
	
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
			String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson);
	
	
	public JSONArray SendReviseProposalList(String uname, String company);

	public JSONArray getReviseProposalListData(String crno, String uname, String tid);

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
			String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21);

	public JSONArray reviseProposalSendBySIDetails(String uname, String company);

	public JSONArray getReviseProposalSIsendData(String crno, String uname, String tid);
	public JSONArray vlxProposalaprdetails(String uname, String company, String role,String userfullname);
	public JSONArray purchaseorderdetails(String uname, String company, String role);
	
	

	public JSONArray revisedProposalPendingListSM(String uname, String company, String userfullname);

	public JSONArray getRevisedProposalPendingDataSM(String crno, String uname, String tid);

	public JSONArray revisedProposalApproveListSM(String uname, String company, String userfullname);

	public JSONArray getRevisedProposalApprovedDataSM(String crno, String uname, String tid);

	public String UpdateRevisedPropSMApprove(String crno, String status, String tid, String uname, String company,
			String sMnote,String userfullname);

	public JSONArray revisedProposalRejectedListSM(String uname, String company, String userfullname);

	public JSONArray getRevisedProposalRejectedDataSM(String crno, String uname, String tid);

	public String RejectRevisedProposalSM(String crno, String company, String rejectreason, String sMnote, String uname,
			String tid);

	public JSONArray revisedProposalRejectedListSI(String uname, String company, String fullname);

	public JSONArray getRevisedProposalRejectedDataSI(String crno, String uname, String tid);

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
			String crno, String tid, String sInote, String amcstartdate, String aMCmonthyear, String aMCMonth, String aMCYear, String amcenddate, String productsuitdetails, String securitysolutiondetails, String descforamc, String totalcostAMC, String gRANDTOTALFORAMC, String gstforamc, String gstdataforresource, String grandtotalforresource, String subtotalAResource, String contactperson, String veloxdata1, String subscriptionANDperpetualYear, String perpetualSubsAnnualperpType, String perpetualSubs3yearperpType, String deploysupport21, String clouddeploycharges21, String integrationCharges21, String integrationcharge21, String subtotalB21, String totalc21, String total18percentage21, String grandtotal21, String resoucesamount21, String proposalFor, String PartnerName);
	
	public JSONArray revisedProposalPendingDetailsMD(String uname, String company);

	public JSONArray getRevisedProposalApprovalDataMD(String crno, String uname, String tid);

	public String UpdateRevisedProposalApproveMD(String crno, String status, String tid, String uname, String company);

	public JSONArray revisedProposalApproveListMD(String uname, String company);

	public JSONArray getRevisedProposalApprovedDataMD(String crno, String uname, String tid);

	public JSONArray updateRegistrationFormList(String uname, String company);

	public JSONArray getUpdateRegistrationFormData(String crno, String uname, String tid);
	
	public String SMrejectPO(String crno, String company, String rejectreason, String sMnote, String uname, String tid);
	
	public JSONArray PORejectedBymeDetails(String uname, String company,String userfullname);
	
	public JSONArray PORejectedSMDetails(String uname, String company,String userfullname);
	
	public JSONArray getPoRejectedSMData(String crno, String uname, String tid);

	public JSONArray getVlxProposalRejectedMDData(String crno, String uname, String tid);
	
	public String insertRejectedPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
			String paymentterms, String prodliscense, String prodamount, String warrantystart, String warrantyend,
			String advaninvoice, MultipartFile[] advinvoicefile1, String loginuser, String loginUserCompany,
			String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
			String podate, String amcstartdate, String amcenddate, String productsuit, String securitytool,
			String warrantyMonth, String warrantyYear, String aMCMonth, String aMCYear, String sInote,
			String tennurestartdate, String tennureenddate, String tennureMonth, String tennureYear, String firstApprover,String SecondApprovername,String fixedyear,String subscriptionyear,String perpetualyear,String crno,String tid,MultipartFile[] massPOfile1,MultipartFile[] productFeaturedFileList);

	public JSONArray getApprovedPoData(String crno, String uname, String tid);

	public JSONArray createdVeloxLicenseDetails(String uname, String company);

	public JSONArray getVlxLicenseData(String crno, String uname, String tid);

	public JSONArray getPoRejectedDataSM(String crno, String uname, String tid);

	public JSONArray proposalLicensePendingDetails(String uname, String company, String userfullname);

	public JSONArray getProposalLicenseDataSM(String crno, String uname, String tid);

	public String ApproveProposalLicenseSM(String crno, String status, String tid, String uname, String company,
			String sMnote);

	public JSONArray proposalLicenseApprovedDetailsSM(String uname, String company, String userfullname);

	public JSONArray getProposalLicenseApprovedDataSM(String crno, String uname, String tid);

	public JSONArray proposalLicensePendingDetailsBH(String uname, String company, String userfullname);

	public JSONArray getProposalLicenseDataBH(String crno, String uname, String tid);

	public String ApproveProposalLicenseBH(String crno, String status, String tid, String uname, String company,
			String bHnote);

	public JSONArray proposalLicenseApprovedDetailsBH(String uname, String company, String userfullname,String roletype );

	public JSONArray getProposalLicenseApprovedDataBH(String crno, String uname, String tid);

	public JSONArray manualProposalSendBymeDetailsSI(String uname, String company);

	public JSONArray getManualProposalDataSI(String crno, String uname, String tid);

	public JSONArray manualProposalPendingDetailsSM(String uname, String company, String userfullname);

	public JSONArray getManualProposalDataSM(String crno, String uname, String tid);

	public String ApproveManualProposalLicenseSM(String crno, String status, String tid, String uname, String company,
			String sMnote);

	public JSONArray manualProposalApprovedDetailsSM(String uname, String company, String userfullname);

	public JSONArray getManualProposalApprovedDataSM(String crno, String uname, String tid);

	public JSONArray manualProposalPendingDetailsMD(String uname, String company);

	public String ApproveManualProposalLicenseMD(String crno, String status, String tid, String uname, String company,
			String MDnote);

	public JSONArray manualProposalApprovedDetailsMD(String uname, String company);

	public JSONArray getManualProposalApprovedDataMD(String crno, String uname, String tid);

	public String SendMailwithattachment(String crno, String tid, String uname, String company, String clientname,
			String environmentKeyNo, String ponumber, String filenameStandard,String endCustomerEmail, String podate,String distributorEmail,String partnerEmail,String linkForEmail);
	
	public String SMrejectMannualVP(String crno, String company, String rejectreason, String sMnote, String uname,
			String tid);

	public JSONArray vlxMPropRejectedBymeDetails(String uname, String company, String userfullname);

	public String rejectedManualProposalByMD(String crno, String company, String rejectreason, String sMnote,
			String uname, String tid);

	public JSONArray ManualProposalRejectByMD(String uname, String company);

	public String rejectedByCM(String crno, String company, String rejectreason, String sMnote, String uname,
			String tid);

	public JSONArray ManualPropRejectedBySMList(String uname, String company, String userfullname);

	public String insertManualPurchaseOrder(MultipartFile[] pouploadfile1, String proddescrip, String customername,
			String paymentterms, String prodliscense, String prodamount, String loginuser, String loginUserCompany,
			String proposalType, String proposalids, String vpuploadfileProposal, String potype, String ponumber,
			String podate, String productsuit, String securitytool, String fixedyear, String Subscriptionyear, String Perpetualyear, String subscriptionANDperpetualYear, String tennurestartdate, String tennureenddate, String tennureMonth ,String tennureYear, String warrantystart, String warrantyend, String warrantyMonth, String  warrantyYear, String amcstartdate, String amcenddate, String AMCMonth, String AMCYear, String poReferenceNo);

	public String rejectedProposalLicenseBH(String crno, String company, String rejectreason, String sMnote,
			String uname, String tid);

	public JSONArray proposalLicenseRejectedDetailsBH(String uname, String company, String userfullname,
			String roletype);

	public String SMrejectLicense(String crno, String rejectreason, String sMnote, String uname, String tid);

	public JSONArray LicenseRejectedBySMList(String uname, String userfullname);

	public JSONArray ManualPoRaiseByMeDetails(String uname, String company);

	public JSONArray LicenseRejectedSIList(String uname, String userfullname);

	public JSONArray getPoRaisedManualPOData(String crno, String uname, String tid);

	public JSONArray getManualPoRaisedData(String crno, String tid);

	public JSONArray PORejectedByCMDetails(String uname, String company, String userfullname);

	public JSONArray getFORM3SubmitteddBySupportManager(String uname);

	public JSONArray SentMailByCMList(String uname, String company, String userfullname, String roletype);

	public JSONArray ReviseManualProposalSendBymeDetailsSI(String uname, String company);
	
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
			String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String manualAmount, MultipartFile[] manualReviseFile);

	public JSONArray reviseManualProposalSendBySIDetails(String uname, String company);

	public JSONArray revisedManualProposalPendingDetailsMD(String uname, String company);

	public JSONArray getReviseManualProposalApprovedDataMD(String crno, String uname, String tid);

	public JSONArray getManualReviseProposalApprovedDataSI(String crno, String uname, String tid);

	public JSONArray RevisemanualProposalApprovedDetailsMD(String uname, String company);

	public JSONArray getManualReviseProposalApprovedData(String crno, String uname, String tid);

	public String ApproveManualReviseProposalMD(String crno, String status, String tid, String uname, String company,
			String mDnote);

	public String UpdatePOdates(String crno, String wstartDate, String wendDate, String aMCstartDate, String aMCendDate,
			String uname);

	public String UpdatePOTenuredates(String crno, String tenureStartDate, String tenureEndDate, String uname);

	public String saveupload(MultipartFile[] invoiceFile, String uname, String crno, String tid);
	
	public String UpdatePOtypeDateManual(String crno, String proposalType, String fixedyear, String subscriptionyear,
			String perpetualyear, String subscriptionANDperpetualYear, String tennurestartdate, String tennureenddate,
			String tennureMonth, String tennureYear, String warrantystart, String warrantyend, String warrantyMonth,
			String warrantyYear, String amcstartdate, String amcenddate, String aMCMonth, String aMCYear, String poRefNo);

	public String rejectedReviseManualProposalByMD(String crno, String company, String rejectreason, String mDnote,
			String uname, String tid);

	public String updateReviseManualProposal(String uname, String company, MultipartFile[] manualReviseFile,
			String poinitiator, String amount, String poinitiatorno, String firstApprovername,
			String firstapprovercontact, String secondApprovername, String secondapprovercontact, String clientname,
			String description, String secureITprodversion, String proposaltype, String perpetualyear,
			String subscriptionyear, String productsuitselect, String scanplusprodversion, String fixedyear,
			String enccustomername, String crno, String tid, String sInote, String contactperson);
	
	public JSONArray getProjectDetails(String uname, String fullname, String role,String designation);

	public JSONArray getAllProjectList(String projectName);

	public JSONArray getDelayedProjectList(String role, String fullname, String designation);

	public JSONArray getTLProjectDetails(String uname, String fullname, String role, String designation, String tLname);

	public JSONArray getDevProjectDetails(String uname, String fullname, String role, String designation,
			String developerName);

	public JSONArray getProjectDetailsManager(String managerName);

	public JSONArray getProjectDetailsProgressMng(String fullname, String managerName);

	public JSONArray getTaskDetailsManager(String uname, String fullname, String role, String designation);

	public JSONArray getTaskDetailsTL(String fullname, String role, String designation);

	public JSONArray getTaskDetailsDev(String fullname, String role, String designation);

	public JSONArray ReviseManualProposalRejectDetailsSI(String uname, String company);

	public JSONArray trackLoginActivityDetails(String fromDate, String toDate, String selecttype, String selectType2);

	
	//01/08
	public JSONArray getTaskDetailsSupport(String uname, String fullname, String role, String designation);

	public JSONArray getProjectDetailsSupport(String uname, String fullname, String role, String designation);

	
	//09/08
	public JSONArray getTLProjectDetailsSupport(String uname, String fullname, String role, String designation,
			String tLname);

	public JSONArray getProjectDetailsSupport1(String uname, String fullname, String role, String designation);

	public JSONArray getDevProjectDetailsSupport(String uname, String fullname, String role, String designation,
			String developerName);

	public String uploadInvoice(MultipartFile[] invoicefile, String username, String fullname, String srno);

}
