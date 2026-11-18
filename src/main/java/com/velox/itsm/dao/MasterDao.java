package com.velox.itsm.dao;

import java.util.List;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;


public interface MasterDao {

	public JSONArray getCompanyNames(String cname);
	public JSONArray getrespup();
	public JSONArray getBranchNames(String cname);
	public JSONArray getEscBranchNames(String companyname);
	public JSONArray ViewTicketOwner(String cname);
	public String addTicketOwner(String company,String branch,String category,String ticowner,String esc1,String esc2,String esc3,String towneremail,String e1email,String e2email,String e3email,String townermob,String e1mob,String e2mob,String e3mob);
	public String addEscalatorMatrix(String company,String branch,String category,String ticowner,String esc1,String esc2,String esc3,String towneremail,String e1email,String e2email,String e3email,String townermob,String e1mob,String e2mob,String e3mob,String priority,String mail,String sms,String t0,String t1,String t2,String t3,String tt0,String tt1,String tt2,String tt3);
	public JSONArray getOwnNameDetails(String cname, String companyname);
	
	public String AddMailTemp(String st,String subject,String mailbody, String company, String emailTrigger, String ticketType, String mailfooter);
	
	public JSONArray ViewAllADUsers(String userlist);
	
	public String updateuser(String srno,String utype,String name,String mail,String contact,String username, String cname);
	
	
	public JSONArray gettid(String sname,String fromdate ,String todate);	
	
public String testadIntegration(String username,String password,String hostname,String domainname,String port);
	
public String FetchADusers(String company);

	public String saveadIntegration(String username,String password,String hostname,String port,String domainname, String companyname);
	
	public String adduserEmail(String company,String mail,String subject,String folder,String port,String uname,String pass,String starttls);
	public JSONArray addEmailIntDetails(String userlist);
	
	public String adduserVrops(String uname,String pass,String surl,String certi,String host,String alerttype);
	public JSONArray addVropsIntDetails(String userlist);
	
	
	public JSONArray getesc1NameDetails(String cname);
	
	
	public JSONArray getesc2NameDetails(String cname);
	public JSONArray getesc3NameDetails(String cname);
	public JSONArray ViewEscMatrix(String userlist);
	public String addAutoAssignTicket(String category,String priority,int days,int hours,int minutes,int seconds,String company,String severity, String assign_TO, String group_Name);
	public JSONArray getCategoryDetailsforAutoAssignTickets(String catname);
	public JSONArray getGroupDetailsforAutoAssignTickets(String groupname);
	public JSONArray ViewcloseTicket(String userlist);
	public JSONArray ViewAssignTicket(String userlist);
	public JSONArray getOwn1Details(String cname);
	public JSONArray getesc1Details(String engname);
	
    public JSONArray getesc2Details(String engname);
	
	public JSONArray getesc3Details(String engname);
	
	
	public JSONArray getCategoryDetails(String catname);
	public JSONArray getSubCategoryName(String subcatname);
	public JSONArray getRequestModeName(String reqmode);
	public JSONArray getCustomerName();
	public String getProductName(String clientname);
	public JSONArray getPriorityName(String companyname);
	public JSONArray getSiteNames(String sname);
	public JSONArray EnggNameValuesForSLA(String branchname,String companyname);
	public JSONArray getSubCategoryEnggName(String category,String Company,String Branch,String Department);
	public JSONArray GroupNameValues(String categoryname, String company);
	public JSONArray getDeptNames(String dname);
	public String adduser(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname);
	public JSONArray addUserDetails(String userlist);
	public String updateAddUserSave(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,int cr_no );
	public String deleteUser(int crno);
	public String addengg(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,String category, String englevel);
	public JSONArray addEnggDetails(String userlist);
	public String updateAddEnggSave(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,String category,int cr_no, String englevel );
	public String deleteEngg(int crno);
	public JSONArray addTPDetails(String userlist);
	public String addTP(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname);
	public String updateAddTPSave(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,int cr_no );
	public String deleteTP(int crno);
	public JSONArray addITHeadDetails(String userlist);
	public String addIT_Head(String cno,String user,String pass,String cpass);
	public String deleteIT_Head(int crno);
	public JSONArray CompanyDetails(String userlist);
	public JSONArray updateCompanyMaster(int cr_no);
	public String addCompany(String company,String companyemail);
	public String updatecompanySave(String companynameupdate,String companyemailupdate,int cr_no );
	public String deleteCompany(int crno);
	public JSONArray SiteMasterListing(String userlist);
	public String SubmitSiteDetails(String company,String branch);
	public String updateSiteMasterSave(String companynameupdate,String sitenameupdate,int cr_no );
	public String deleteSite(int crno);
	public JSONArray CategoryDetails(String userlist);
	public String addcategory(String category);
	public String updateCategoryMasterSave(String categorynameupdate,int cr_no );
	public String deleteCategory(int crno);
	public String SubmitGroupDetails(String category,String group);
	public JSONArray SubCategoryMasterListing(String userlist);
	public String updateGroupMasterSave(String categorynameupdate,String groupnameupdate,int cr_no );
	public String deleteGroup(int crno);
	public JSONArray DepartmentDetails(String userlist);
	public String add_Department(String department);
	public String updateDepartmentMasterSave(String departmentnameupdate,int cr_no );
	public String DeleteDepartment(int crno);
	public JSONArray PriorityDetails(String userlist);
	public String addPriority(String priority, String company);
	public String updatePriorityMasterSave(String companyName, String prioritynameupdate,int cr_no );
	public String DeletePriority(int crno);
	public JSONArray RequestModeDetails(String userlist);
	public String addRequestMode(String requestmode , String company);
	public String updateRequestModeSave(String requestmodeupdate,int cr_no , String companyupdate );
	public String DeleteRequestMode(int crno);
	public JSONArray addAdminDetails(String userlist);
	public String ADDAdminMaster(String cno,String user,String pass,String cpass);
	public String DeleteAdmin(int crno);
	public JSONArray BranchNameValues(String bname);
	public JSONArray UserNameValues(String company, String branchname2, String department);
	public JSONArray EnggNameValues(String company, String branchname2);
	public JSONArray AddMailListing(String userlist);
	public JSONArray adddetailsListing(String userlist);
	public String SubmitEscalationDetails(String engLevel, int days, int hours, int minutes, int seconds, String companyname, String priority, String severity, String designation, String username);
	public JSONArray EscalationMasterListing(String escMasterList);
	public JSONArray getCompanyPriority(String company);
	public JSONArray getCompanySeverity(String company);
	public String deleteEscalation(String company, String level);
	public String deleteAutoAssignMaster(String srno);
	
	public JSONArray getProblemCategoryDetailsList(String catname);
	public JSONArray getProblemSubCategory1(String subcat1);
	public JSONArray getProblemSubCategory2(String subcat2);
	public String addProblemCategory(String category, String subcategory1, String subcategory2);
	public JSONArray ProblemCategoryListing(String problemCatList);
	public String deleteProblemCategory(int crno);
	public JSONArray getSubCategory1Name(String subcat1name);
	public JSONArray getSubCategory2Name(String subcat2name, String problemCategory);
	public JSONArray ViewProblemcloseTicket(String userlist);
	public String addMFAType(String priority);
	public String updateTheme(String type, String value);
	public JSONArray getThemeData(String nodata);
	public JSONArray getINCSubCategory1Name(String Category, String companyname);
	public JSONArray getINCSubCategory2Name(String Category, String subcat2name, String companyname);
	
	//public String getParameter(String username);
	
	//public String addUser(String firstname,String lastname,String username,String emailid,String password,String phoneno,String conpassword,String branch,String project,String customer,String currUser);

	
	public JSONArray getCompositeCompanyList();
	public JSONArray getCompanydropdownlist();
	
	public JSONArray getCompositeBranchList();
	public JSONArray resplisting(String designationList);
	public JSONArray getCompositeLocationList(String subcat2);
	public JSONArray getCompositeDepartment(String subcat2);
	public JSONArray getCompositeSubDepartment(String subcat2);
	public JSONArray CompositeListing(String problemCatList);
	public String addComposite(String category, String subcategory1, String subcategory2,String department,String subDepartment);
	public String deleteComposite(int crno);
	public JSONArray getBranchForLoginMaster(String company, String location);
	public JSONArray getLocationForLoginMaster(String companyname);
	public JSONArray getDepartmentForLoginMaster(String companyname,String branchName,String location);
	public JSONArray getSubDepartmentForLoginMaster(String companyname,String branchName,String location,String departmentName);
	public String updateUserLoginMaster(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,String category,int cr_no, String englevel ,String rtypeupdate,String row,String subdnameupdate,String vipLogin,String updatecategory,String updategroup,String designation,String visibilityupdate, String updateUserLoginMaster, String selectedSideBarValuesFinal);
	public JSONArray getCompanyDetailsForLoginMaster();
	public JSONArray getDepartmentForUserScope(String companyname,String branchName);
	public JSONArray getLoginMasterDetails(String userlist);
	public String addUserInLoginMaster(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,String category, String englevel,String location, String rtype,String row,String vipLogin,String categoryMulti1,String groupMulti1, String designation,String visibility, String cat_with_company, String selectedSideBarValuesFinal,String gender);
	public String DeleteLoginMasterData(int crno);
	public JSONArray getGroupDetails(String groupname);
	public JSONArray getCompanyDetailsForTicketTagMaster();
	public JSONArray TicketTagDetails();
	public JSONArray getDepartmentForTicketTagMaster(String companyname);
	public String addTicketTag(String company,String companyTag,String dname);
	public String deleteTicketTag(int crno);
	public String updateTicketTagyMasterSave(String categorynameupdate,int cr_no ,String updatedname,String tagforsave);
	public JSONArray getCategoryForLoginMaster(String company);
	
	public JSONArray getGroupForLoginMaster(String company);
	public JSONArray getGroupForPerticularUser(String username, String company1);
	public JSONArray getCategoryForPerticularUser(String username,String company);
	public JSONArray getUserScopeForUpadte(String userlist,String E_id);
	public String updateUserPassword(String mail,String cno,String user,String loginid);
	public JSONArray getCategoryDetailsList(String catname, String company);
	public JSONArray getSubCategory1(String subcat1, String category, String subcat12);
	public JSONArray getSubCategory2(String subcat2, String category, String subcategory1, String subcat22);
	

	public JSONArray getCategoryDetailsListforcatalogue(String company);
	public JSONArray getSubCategory1forcatalogue(String company);
	public JSONArray getSubCategory2forcatalogue(String company);
	public JSONArray getSubjectforcatforcatalogu(String company);
	public JSONArray getSeverityNameforcatalogue(String company);
	
	public JSONArray getPriorityNameforcatalogue(String company);
	public JSONArray CategoryListing(String problemCatList);
	public String addNewCategory(String company, String category, String subcategory1, String subcategory2, String priority, String severity);
	public String deleteCategoryFromMaster(int crno);
	public JSONArray getOutageCompanyName(String companyname);
	public JSONArray getOutageBranchName(String companyname);
	public JSONArray getOutageDepartmentName(String companyname, String branchName);
	public JSONArray getSeverityName(String companyname);
	public JSONArray getINCPriorityAndSeverityName(String Category, String subcat1name, String subcat2name,String companyname);
	public JSONArray getCompositecompanyNames();
public String addSeverity(String company, String Severity);
	
	public String updateSeverityMasterSave(String companyName, String Severitynameupdate,int cr_no );
	public String DeleteSeverity(int crno);
	public JSONArray SeverityDetails(String userlist);
	public JSONArray getprojectsuitList();
	public JSONArray getprojectsuitListupd();
	public JSONArray getprojectListupd();
	public JSONArray getprojectList();
	public JSONArray getSubject(String subject);
	public String addNewSubject(String company, String category, String subcategory1, String subcategory2,
			String subject);
	public JSONArray SubjectListing(String subjectList);
	public String deleteSubject(int crno);
	public JSONArray getINCSubject(String company, String Category, String subcat1name, String subcat2name);
	public String addNewServiceCatalogue(String company, String category, String subcategory1, String subcategory2,
			String subject, String priority, String severity, String servicerequesttype, String group_name, String approval_level, String designationlevel1, String designationlevel2 ,String requestcost,String SUBJECT_TYPE);
	public JSONArray ServiceCatalogueListing(String subjectList);
	public String deleteServiceCatalogue(int crno);
	public JSONArray getServiceCatalogueSubject(String subject,String company);
	public JSONArray getSelectedServiceCatalogueData(String subject,String company);
	public String addTemplate(String templates, String companies, String attributename);
	public JSONArray getTemplateDetails(String userlist);
	public JSONArray DesignationMasterListing(String designationList);
	public String AddModule(String designation);
	public JSONArray getModuleNames();
	public JSONArray getModuleNameup();
	public String updateDesignationup(String company, String designation, int srno);
	public String setFunctionModule(String moduleName, String functionName);
	public JSONArray funclist(String designationList);
	public String Deletemodule(int srno);
	public String Updateresponsibiity(String company,String designation, int srno,String roletype,String module,String function,String checker);
	public JSONArray getresp1();
	public String Deleteresp(int srno);
	public JSONArray getresp1up();
	public JSONArray getresp2up();
	public String Deletetandc(int srno);
	public JSONArray tandcMasterListing(String designationList);
	public String Addtandc(String tctype,String comments,String ddrname1);
	public JSONArray getresp();
	public JSONArray getresp2();
	public String UpdateModule(String designation, int srno);
	public String addDesignation(String company, String designation,String roletype,String module,String function,String checker);
	
	public String updateDesignation(String company, String designation, int srno);
	public String deleteDesignation(int srno);
	public JSONArray getCompanyDesignation(String company);
  
  
	public JSONArray getServiceRequestFlowListing(String requestFlowList);
	public String addServiceRequestFlow(String company, String designation, String requestName, String approverName, String department);
	public String updateServiceRequestFlow(int srno, String company, String designation, String requestName, String approverName, String department);
	public String deleteServiceRequestFlow(int srno);
  
	public JSONArray getApproverDetails(String company, String designation);
	
	public String SaveCategory(String category, String subcategory1, String subcategory2, String priorityname, String severityname);
	public JSONArray getTemplateCategoryList(String catname);
	
//	public JSONArray getTemplateSubCategoryList(String subcategory);
	public JSONArray TemplateCategoryListing(String templisting);
	public String deleteTemplateCategory(int crno);
	public String adintegtestlist(String company);
	public JSONArray getCompanyNames1(String company);
	public JSONArray getPriorityList(String company);
	public JSONArray getCategoryList(String company);
	public JSONArray getCompanyNamesinEmail(String company);
	
	public String addPrioritytemplate(String attribute1, String templatedeatil);
	public JSONArray prioritytemplatelist(String userlist);
	public String deleteprioritytemplate(int crno);
	public JSONArray updatePriorityTemplate(int cr_no);
	public String updatepprioritytemplateSave(String companynameupdate, String companyemailupdate, int cr_no);
	
	public String Saveslapercentage(String company,String percentage );
	public JSONArray getSlaListing(String userlist);
	public String DeleteSlaTemplate(int crno);
	public String updateSlaTemplateMaster(int srno,String company, String percentage);
	
	public JSONArray getTemplateCategoryList1(String subcat1);
	public JSONArray getTemplateSubCategoryList2(String subcat2);
	public String DeleteList(String company);
	public String UpdateAdIntegration(String company, String username, String password, String host, int port_no,
			String dName);
	
	public String addCompanyCode(String company,String companycode);
	public JSONArray CompanyCodeListing();
	public String updateCompanyCode(String company,String companycode,int srno);
	public String deleteCompanyCode(int crno);
	
	public JSONArray getSelfHelpList();
	public JSONArray getSelfHelpScopeList();
	public JSONArray getSelfHelpCategory();
	public JSONArray getSelfHelpPlatform();

	public String addSelfHelpMaster(String company, String branch, String department, String name, String description,
			String category, String platform, MultipartFile empPic);

	public String updateSelfHelpMaster(int srno, String company, String branch, String department, String name,
			String description, String category, String platform, MultipartFile empPic);
	
	public JSONArray gatherSelfHelpDetails(String selfhelpid);
	public void updateSelfHelpDownloadCounter(String selfhelpid);
	
	public JSONArray getTemplatePriorityList1(String subcat1);
	public JSONArray getTemplateSeverityList1(String severity);
	

	public String Updatecategory(String categoryupdate, String subcategory1update, int srno, String subcategory2update,
			String priorityupdate, String severityupdate);
	
	public String Updatecategorytemplate(String categoryupdate, String subcategory1update, int srno, String subcategory2update,
			String priorityupdate, String severityupdate,String Companyupdate);
	
	public String addgroup(String group, String company);
	public JSONArray getgroupList(String userlist);
	public String updategroupMasterSave(String companyName, String prioritynameupdate, int cr_no);
	public String Deletegroup(int crno);
	public JSONArray getGropupfromgroupmaster(String company);
	public JSONArray getusernamebasisondesignation(String designation1, String company);
	public JSONArray getCategoryDetailsForAutoAssign(String company);
	public JSONArray getUserNamesOnDesignation(String company, String designation);
	public JSONArray ViewAutoAssignTicket(String userlist);
	public JSONArray getCompany();
	public JSONArray getDepartment(String company, String branchname);
	public JSONArray getCategoryDetailsforreport(String company);
	public String updateCompositeMaster(int srNo, String category, String subcategory1, String subcategory2, String department,
			String subDepartment);
	public String getUserBulkUploadFile();
	public String saveBulkUploadUserData(MultipartFile bulkUserData);
	public String updateSubjectMaster(int srNo, String company, String category, String subcategory1,
			String subcategory2, String subject);
	public String deleteAutoCloseTicket(int srNo);
	public JSONArray getAllPriorityMaster();
	public JSONArray getAllSeverityMaster();
	public String updateServiceCatalogue(String company, String category, String subcategory1, String subcategory2,
			String subject, String priority, String severity, String servicerequesttype, String group_name,
			String approval_level, String designationlevel1, String designationlevel2, String requestcost,String subjecttype,int srno);
	public JSONArray getINCSubjectFORuser(String company);

	
	public JSONArray getSubCategory2Forsubjecmaster(String subcat2, String category, String subcategory1, String subcat22);
	public JSONArray getSubCategory1Forsubjecmaster(String company, String category, String subcat1);
	public JSONArray getCategoryDetailsListForsubjecmaster(String catname, String company);
	public JSONArray getRequestModeForRaiseOnBehalf(String company, String reqmode);

	public String Deletemaiconfig(int crno);
	public JSONArray getGroupForLoginMasterAll();
	public JSONArray getGroupForPerticularUserforticket(String username, String company1);
	public JSONArray getCategoryDetailsforuScop2(String catname);
	
	public JSONArray getStatusFormail();
	public String updatemailtemplate(String srno,String st, String subject, String mailbody, String company, String emailTrigger,
			String ticketType, String mailfooter);
	public JSONArray getFooterForUpdate(String srno);
	public String DeleteEmailServerIntegration(String crno);
	public String updateEmailServerIntegration(String company, String mail, String subject, String folder, String port,
			String uname, String pass,int crno,String starttlsup);
	
	public JSONArray getBranchForLoginMastersInsert(String company, String location);
	public JSONArray getUserList(String userlist);
	public String updateUserList(String mail,String cno,String user,String pass,String fname,String lname,String cpass,String cname,String sname,String dname,String category,int cr_no, String englevel ,String rtypeupdate,String row,String subdnameupdate,String vipLogin,String updatecategory,String updategroup,String designation,String visibilityupdate);
	public JSONArray GetLocationForReport(String companyis);
	public JSONArray GetUsersListForReportTp(String companyis, String locationis);
	public JSONArray getSLACalendarData(String companyname);
	public String insertSLACalendarData(String companyname, String eventname, String eventdescription,
			String eventdate);
	public String updateSLACalendarData(String companyname, String eventname, String eventdescription,
			String eventdate);
	public String deleteSLACalendarData(String companyname, String eventname, String eventdescription,
			String eventdate);
	public JSONArray getSLAWeekScheduleData(String companyname);
	public String insertUpdateSLAWeekScheduleData(String companyname, String finalArray);
	public JSONArray getCompanyForReportInAdmin();
	public JSONArray getGroupForReport(String compname);
	public JSONArray GetUserNameList(String vendorname, String groupName);
	public JSONArray gettidForServiceRequest(String cname, String fromdate, String todate);
	public JSONArray GetGroupsForReport(String companyis);
	public JSONArray getProblemTicketId(String cname, String fromdate, String todate);
	public JSONArray getAssetFromOfLoginUser(String loginuser);
	public JSONArray getsyncloglisting(String userlist);
	public String updatelogsync(String userlist);
	public JSONArray getServiceCatalogueSubjectByType(String subjectType, String company);
	public String AddEFormMailTemp(String st, String subject, String mailbody, String company, String emailTrigger,
			String ticketType, String mailfooter);
	public JSONArray AddEformMailListing(String userlist);
	public String updatEformemailtemplate(String srno, String st, String subject, String mailbody, String company,
			String emailTrigger, String ticketType, String mailfooter);
	public String DeleteEformmaiconfig(int crno);
	public JSONArray getEmailFooterForUpdate(String srno);
	public JSONArray getPID();
	public JSONArray ApprovalGroup(String pid);
	public JSONArray getUserSelectedDetails(String approvalname, String fullName);
	public JSONArray getProejctDetails(String pid);
	public JSONArray getProjectDetailsById(String pid);
	public JSONArray getItGroupUser();
	public String SaveSoftwareDetails(String sname, String productcode, String fromdate, String checkbox, Float scost,
			String rperiod);
	public JSONArray getSoftwareDetailsInEform();
	public String DeleteSoftwares(int crno);
	public String UpdateSoftwareDetails(String sname, String productcode, String fromdate, String checkbox,
			String scost, String rperiod,int crno);
	
	//Business Request
	
	public JSONArray getBusinessUserSelectedDetails(String approvalname);
	public JSONArray getScopeBasedCategory();
	
	// Bulk Upload Method
	
		public String getcompositeBulkUploadFile();
		public String saveBulkUploadcomposite(MultipartFile bulkUserData);
		

public String ProductMaster(String productsuit, String productname, String unit,String ImplementerName);
public String AddProductsuit(String productsuit);
		public JSONArray productmasterlisting(String subjectList);
		public JSONArray productmasterlisting1(String subjectList);
		public String deleteProductMaster(int srno);
		public String deleteProductMaster(String engType, String engineercost, String implementorCosttotal,
				String implemetationcost, String typepercentage, String costdata, String totalothercost);
		public JSONArray otherocstmasterlisting(String subjectList);
		public String deleteOthercosrmaster(int srno);
		public String Updateothercost(String engType, String engineercost, String implementorCosttotal,
				String implemetationcost, String typepercentage, String costdata, String totalothercost, int srno);

		public String updateproductmaster(String productsuitupdate, String securitysolutionupdate,
				String unitdataupdate, int srno,String updImplementerName);
		
		public JSONArray form3datalisting(String subjectList);
		public String deleteFORM3(int srno);
		public String updateform3(String dateupdate, String projeimplementornameupdate, String customernameupdate,
				String projectnameupdate, String descriptionupdate, String responsiblityupdate, String targetdateupdate,
				String deliverydateupdate, int srno);
		public JSONArray getproducutsuitList();
		public JSONArray getunitdataList();
		public JSONArray getsecuritysolutionList(String productsuit);
		
		 public String Addunit(String productsuit);
			public JSONArray unitmasterlisting(String subjectList);
			public JSONArray securitytoollisting(String subjectList);
			 public String Addsecuritytool(String productsuit);
			 public JSONArray Compositemasterlist(String problemCatList);
			 public String addpricemaster(String productsuit,String productname,String pricetype,String cloudtype,String apexmode,String capexmode,String prepectual,String subscriptiontype,String licentype,String amcprice,String amctotal);
			 public String updateproductsuitmaster(String productsuitupdate,int srno);
			 public String deleteProductsuitMaster(int srno);
			 public String updatesectool(String productsuitupdate,int srno);
			 public String deletesectool(int srno);
			 public String updateunitmaster(String productsuitupdate,int srno);
			 public String deleteunitMaster(int srno);
			 public String Updatetandcmaster(String company, String designation, int srno);
			 
			 public String veloxproposaldetails(String veloxdata, String poinitiator, String poinitiatorno,
						String firstApprovername, String firstapprovercontact, String secondApprovername,
						String secondapprovercontact, String clientname, String description, String totalpriceforallproduct,
						String deploysupport, String clouddeploycharges, String subtotalB, String subtotalAB, String uname,String resoucesamount , String ATC,String Proposaltype,String Perpetualyear,String Subscriptionyear,
						String Amcsecondyear,String Amcthirdyear,String Amcfourthyear,String Amcfiveyear,String secondyearsubscription,
						String thirdyearsubscription,String fullPathVlxLogo,String fullPathVlxEnd,String fullPathSwachBharat,
						String IntegrationchargeYesNo,String IntegrationCharges,String Total_C,String GSTPERCENTAGE,String Grand_Total, String productsuitselect, String scanplusprodversion, String secureITprodversion, String enccustomername, String letterhead, String signature, String fixedyear,
						String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,String descforamc,String totalcostAMC,String GRANDTOTALFORAMC,String gstforamc,
						String gstdataforresource ,String grandtotalforresource ,String subtotalAResource,String contactperson,String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
						String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21,String poreferenceno, String proposalFor, String partnerName );
			
			 
			 public String ProjectnameMaster(String productsuit, String productname, String unit);
			 public JSONArray projectmasterlist(String subjectList);
				public String updateprojectmaster(String productsuitupdate, String securitysolutionupdate,
						String unitdataupdate, int srno);				
				public String deleteProjectNameMaster(int srno);
				public String InsertForm3(String date, String projeimplementorname, String customername, String projectname,
						String serverAvail, String serverAvail_Responsibility, String server_startdate, String server_enddate,
						String installvlxlicenseate, String responsibilityvlxlicense, String startdatevlxlicense,
						String enddatevlxlicense, String uATTesting, String responsibilityuattesting,
						String startdateuattesting, String enddateuattesting, String productiongolive,
						String responsibilitygolive, String startdategolive, String enddategolive, String rollout,
						String responsibilityrollout, String startdaterollout, String enddaterollout, String demolive,
						String responsibilitydemo, String startdatedemo, String enddatedemo, String paymentterms,
						String responsibilitypaymentterms, String startdatepaymentterms, String enddatepaymentterms,
						String signoff, String responsibilitysignoff, String startdatesignoff, String enddatesignoff);	
				public JSONArray getprodsuit();
				public JSONArray getsectool();
				public JSONArray getlist(String crno,String uname,String tid);
				
				public String addregistrationMaster(MultipartFile[] incocertificate, MultipartFile[] pancardfile,
						MultipartFile[] gstcertificate, MultipartFile[] msmed, MultipartFile[] cancelledcheque,
						MultipartFile[] turnovercertif, MultipartFile[] msmeddocument, String addrowdata,
						String categorytype, String distributorname, String partnername, String compname,
						String registerno, String address, String contact_personname, String mobno, String telpno,
						String md_Ceo_emailid, String sales_emailid, String support_email_id,
						String emailid_contact_person, String office_mailid, String city, String district, String state,
						String pincode, String country, String website, String panacno, String ownership,
						String scale_of_company, String gstin, String other_country, String dateofbussns,
						String currency, String year1, String year2, String year3, String rupees1, String rupees2,
						String rupees3, String gemportal_register, String msmedtype, String entrepreno,
						String ideclaration,String checker, String Authorizer,String uname,String company,String salesManager);
			
				public JSONArray getdistributorname();
				public JSONArray getpartnername();
				public JSONArray getcheckerName();
				public JSONArray getMakerName();
				public JSONArray getproductnamelist(String selectedSuit);
				public JSONArray getAuthorizername();
				public JSONArray getProposalName();
				public String newCustomerDetails(String compname, String address, String city, String district,
						String pincode, String office_mailid);
				public String setProposalMaster(String proposalName);
				public JSONArray getproductsuitlist();
				public JSONArray getProposalIds(String proposaltype, String subscriptionyear, String perpetualyear,String fixedyear,String subscriptionANDperpetualYear);
				public JSONArray getProposalIdAttachment(String proposalids);
				public JSONArray getimplementerList(String role);
				public JSONArray getAuthorizerNameAM();
				public String RFsaveBulkUploadcomposite(MultipartFile bulkUserData);
				public String geRFtUserBulkUploadFile();
				
				public String updateRegistrationMaster(MultipartFile[] incocertificate, MultipartFile[] pancardfile,
						MultipartFile[] gstcertificate, MultipartFile[] msmed, MultipartFile[] cancelledcheque,
						MultipartFile[] turnovercertif, MultipartFile[] msmeddocument, String addrowdata,
						String categorytype, String distributorname, String partnername, String compname,
						String registerno, String address, String contact_personname, String mobno, String telpno,
						String md_Ceo_emailid, String sales_emailid, String support_email_id,
						String emailid_contact_person, String office_mailid, String city, String district, String state,
						String pincode, String country, String website, String panacno, String ownership,
						String scale_of_company, String gstin, String other_country, String dateofbussns,
						String currency, String year1, String year2, String year3, String rupees1, String rupees2,
						String rupees3, String gemportal_register, String msmedtype, String entrepreno,
						String ideclaration,String checker, String Authorizer,String uname,String company,String salesManager,String tid,String msmedregester,MultipartFile[] commercialProp1,MultipartFile[] pucrhaseOrder1);
				
				
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
						String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson, String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
						String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String proposalFor, String partnerName);
				
				public String commercialproposalUpdateDetailsMD(String veloxdata, String poinitiator, String poinitiatorno,
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
						String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String proposalFor, String partnerName);
				
				public JSONArray getProposalIdsforlist();
				
				public JSONArray getsecuritysolutionListing();
				public String veloxLicensedetails(String veloxdata, String sppliernamelicense, String clientname,
						String environmentKeyNo, String ponumber, String podate, String folderPath,
						String fullPathVlxLogo, String oEMAddress, String clientAddress, String endcostomername,String endCustomerEmail,String firstApprovername,String secondApprovername, String uname,String poID, String payment_recieved, String AMsignature, String licenseforname,String distributor,String partner1,String partner2,String submissionType, String licenseUploadfile);
			
				public JSONArray getsecuritysolutionList2(String productsuit);
				public JSONArray getPOidList();
				public JSONArray getPOidListData(String poID);
				public JSONArray getAuthorizerNameBH();
				public JSONArray getPoID(String getPoID);
				
				public String manualProposalDetailsSubmit(MultipartFile[] manualProposalFile, String poinitiator,
						String poinitiatorno, String firstApprovername, String firstapprovercontact, String secondApprovername,
						String secondapprovercontact, String clientname, String description, String uname, String aTC,
						String proposaltype, String perpetualyear, String subscriptionyear, String productsuitselect,
						String scanplusprodversion, String secureITprodversion, String enccustomername, String fixedyear,
						String contactperson, String subscriptionANDperpetualYear, String manualAmount, String proposal_For, String PartnerName);
				
				
				// 3/1 UD
				public JSONArray getFunctionName();
				public JSONArray getDesignation();
				public JSONArray getUserName(String desigName);
				public String getUserID(String username);
				public JSONArray generateEnvkey(String productSuitNameList, String proposalId);
				
				// 6/1
				public JSONArray getTeamLeader();
				public JSONArray getDevelopers();
				public JSONArray apprvlRdDocuments();
				public String ManualproposalUpdateDetails(MultipartFile[] updateManualFile,String veloxdata,String manualamount,String poinitiator, String poinitiatorno,
						String firstApprovername, String firstapprovercontact, String secondApprovername,
						String secondapprovercontact, String clientname, String description,
						String totalpriceforallproduct, String deploysupport, String clouddeploycharges,
						String subtotalB, String subtotalAB, String uname, String resoucesamount, String aTC,
						String proposaltype, String perpetualyear, String subscriptionyear, String amcsecondyear,
						String amcthirdyear, String amcfourthyear, String amcfiveyear, String secondyearsubscription,
						String thirdyearsubscription, String fullPathVlxLogo, String fullPathVlxEnd,
						String fullPathSwachBharat, String integrationchargeYesNo, String integrationCharges,
						String total_C, String gSTPERCENTAGE, String grand_Total, String productsuitselect,
						String scanplusprodversion, String secureITprodversion, String enccustomername,
						String letterhead, String signature, String fixedyear, String crno, String tid, String sInote,
						String amcstartdate, String amcenddate, String productsuitdetails,
						String securitysolutiondetails, String descforamc, String totalcostAMC, String gstforamc,
						String gstdataforresource, String grandtotalforresource, String subtotalAResource,
						String contactperson, String veloxdata1, String subscriptionANDperpetualYear,
						String perpetualSubsAnnualperpType, String perpetualSubs3yearperpType, String deploysupport21,
						String clouddeploycharges21, String integrationcharge21, String subtotalB21, String totalc21,
						String total18percentage21, String grandtotal21, String resoucesamount21,String proposalfor,String partnername);
				
				public String saveupload(MultipartFile[] manualProposalFile,String uname,String crno,String tid);
				public JSONArray getManagerList();
				public String updateVeloxLicensedetails(String veloxdata, String sppliernamelicense, String clientname,
						String environmentKeyNo, String ponumber, String podate, String folderPath,
						String fullPathVlxLogo, String oEMAddress, String clientAddress, String endcostomername,
						String endCustomerEmail, String firstApprovername, String secondApprovername, String uname,
						String poID, String payment_recieved, String crno, String tid, String AMsignature);
				public String ClientMaster(String productSuit, String securitytool, String customerName,
						String prodManager, String functionName, String targetDate, String status, String role);
				public JSONArray getAccManagerList();
				public JSONArray Tlmasterlisting(String subjectList);
				public String saveTlMaster(String productsuit, String productname, String unit, String implementerName,
						String tlname, String developer, String customerName);
				public String deleteTlMaster(int srno);
				public String updateTLMaster(String productsuitupdate, String securitysolutionupdate, String tlname,
						int srno, String updImplementerName);
				public String DownloadBluckUploadfile();
				public String saveBulkUploadTaskFile(MultipartFile bulkUserData, String userfullname, String uname, String role);
				public JSONArray getTesterList();
				public JSONArray getTeamLeaderByManager(String userfullname);
				public JSONArray getDevelopersByManager(String userfullname);
				public JSONArray getDevelopersByTL(String userfullname);
				public JSONArray getAllClientList();
				public String updateClientMaster(String srno, String customer, String prodSuite, String prodTool,
						String managerName, String functionName, String toDateUpdate, String statusUpdate);
				public String deleteClientDetails(int crno);
				public String updateUserActivity(String username, String activities, String userfullname);
				
				
				//05/07
				public JSONArray getCompletedProjectList(String userfullname,String role);
				public JSONArray getCompletedManagerList(String userfullname,String role);
				public JSONArray getCompletedTeamLeader(String userfullname,String role);
				public JSONArray CompletedManagerListDet(String projectNamesN);
				public JSONArray CompletedDetailsByCus(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				public JSONArray CompletedTLListDet(String projectNamesN, String prodmgrN);
				public JSONArray CompletedBasedOnManager(String selectedCustomer, String selectedMan, String selectedTL,
						String selectedFunction);
				public JSONArray CompletedDetailsByCusAndMan(String projectNamesN, String prodmgrN);
				public JSONArray CompletedFunctionListDet(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				public JSONArray CompletedDetailsByCusManAndTL(String projectNamesN, String prodmgrN,
						String teamLeaderNameN);
				public JSONArray CompletedDetailsBasedOnAll(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String FnameN);
				public JSONArray CompletedManagerListDet1(String projectNamesN1,String userfullname);
				public JSONArray CompletedDetailsByCus1(String projectNamesN1, String prodmgrN1,
						String teamLeaderNameN1, String fnameN1,String role,String userfullname);
				public JSONArray CompletedTLListDet1(String projectNamesN1, String prodmgrN1,String role,String userfullname);
				public JSONArray CompletedBasedOnManager1(String selectedCustomer, String selectedMan,
						String selectedTL, String selectedFunction,String role,String userfullname);
				public JSONArray CompletedDetailsByCusAndMan1(String projectNamesN1, String prodmgrN1,String role,String userfullname);
				public JSONArray CompletedFunctionListDet1(String projectNamesN1, String prodmgrN1,
						String teamLeaderNameN1, String fnameN1,String role,String userfullname);
				public JSONArray CompletedDetailsByCusManAndTL1(String projectNamesN1, String prodmgrN1,
						String teamLeaderNameN1,String role,String userfullname);
				public JSONArray CompletedDetailsBasedOnAll1(String projectNamesN1, String prodmgrN1,
						String teamLeaderNameN1, String fnameN1,String role,String userfullname);
				
				//24/07
				public JSONArray getSupportTeamLeader();
				public JSONArray getSupport();
				public JSONArray getproducutsuitListSupport();
				public JSONArray getimplementerListSupport();
				public JSONArray getCustomerNameSupport();
				public JSONArray getFunctionNameSupport();
				public JSONArray getAllClientListSupport();
				public JSONArray getsecuritysolutionListSupport(String productsuit);
				public String ClientMasterSupport(String productSuit, String securitytool, String customerName,
						String prodManager, String functionName, String targetDate, String status, String role);
				public String updateClientMasterSupport(String srno, String customer, String prodSuite, String prodTool,
						String managerName, String toDateUpdate, String statusUpdate);
				public String deleteClientDetailsSupport(int crno);
				public JSONArray getDevelopersSupport(String teamLead);
				public JSONArray getDevelopersTLSupport();
				public JSONArray TlmasterlistingSupport(String subjectList);
				public String saveTlMasterSupport(String productsuit, String productname, String unit,
						String implementerName, String tlname, String developer, String customerName);
				public String deleteTlMasterSupport(int srno);
				public String updateTLMasterSupport(String productsuitupdate, String securitysolutionupdate,
						String tlname, int srno, String updImplementerName);
				public JSONArray getTeamLeaderBySupportManager(String userfullname);
				public JSONArray getDevelopersBySupportManager(String userfullname);
				
				//08/08
				public JSONArray getTeamLeadTL(String role,String userfullname);
				
				//17/08
				public JSONArray getCompletedProjectListNew(String userfullname, String role);
				public JSONArray getCompletedTeamLeaderNew(String userfullname, String role);
				public JSONArray CompletedManagerListDetNew(String projectNamesN);
				public JSONArray CompletedDetailsByCusNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN,String methodName);
				public JSONArray CompletedTLListDetNew(String projectNamesN, String prodmgrN);
				public JSONArray CompletedBasedOnManagerNew(String selectedCustomer, String selectedMan,
						String selectedTL, String selectedFunction,String methodName);
				public JSONArray CompletedDetailsByCusAndManNew(String projectNamesN, String prodmgrN,String methodName);
				public JSONArray CompletedFunctionListDetNew(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN, String productTool);
				public JSONArray CompletedDetailsByCusManAndTLNew(String projectNamesN, String prodmgrN,
						String teamLeaderNameN,String methodName);
				public JSONArray CompletedDetailsBasedOnAllNew(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String FnameN, String FnameNNewStatus,String methodName);
				
				
				
				
				//20/08
				public JSONArray CompletedStatusListDetNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN, String fnameNNewStatus, String productTool);
				public JSONArray CompletedDetailsByCusManTLNewAndFunction(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameNNew,String methodName);
				
				
				//23/08
				
				public JSONArray getCompletedProjectListTrack(String userfullname, String role);
				public JSONArray getCompletedManagerListTrack(String userfullname, String role);
				public JSONArray getCompletedTeamLeaderTrack(String userfullname, String role);
				
				
				
				
				public JSONArray CompletedManagerListDetTrack(String projectNamesNTrack);
				public JSONArray CompletedDetailsByCusTrack(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN);
				public JSONArray CompletedTLListDetTrack(String projectNamesN, String prodmgrN);
				public JSONArray CompletedBasedOnManagerTrack(String selectedCustomer, String selectedMan,
						String selectedTL, String selectedFunction);
				public JSONArray CompletedDetailsByCusAndManTrack(String projectNamesN, String prodmgrN);
				public JSONArray CompletedFunctionListDetTrack(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN);
				public JSONArray CompletedDetailsByCusManAndTLTrack(String projectNamesN, String prodmgrN,
						String teamLeaderNameN);
				public JSONArray CompletedDetailsBasedOnAllTrack(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN);
				
				//31/08
				public JSONArray getAllImplementorList();
				public JSONArray getProductToolListTotAct(String projectName, String pManager, String projectTL,
						String functionName, String productTool, String status);
				public JSONArray getProductToolByManagerTotAct(String projectNamesNNew, String prodmgrNNew,String pToolTotAct);
				public JSONArray getProductToolTotAct(String userfullname, String role);
				
				//13/09
				public JSONArray getCustomerNameN();
				public JSONArray getOnHoldProjectList(String userfullname, String role);
				public JSONArray getOnHoldManagerList(String userfullname, String role);
				public JSONArray getOnHoldTeamLeader(String userfullname, String role);
				public JSONArray OnHoldManagerListDet(String projectNamesN);
				public JSONArray OnHoldDetailsByCus(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				public JSONArray OnHoldTLListDet(String projectNamesN, String prodmgrN);
				public JSONArray OnHoldBasedOnManager(String selectedCustomer, String selectedMan, String selectedTL,
						String selectedFunction);
				public JSONArray OnHoldDetailsByCusAndMan(String projectNamesN, String prodmgrN);
				public JSONArray OnHoldFunctionListDet(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				public JSONArray OnHoldDetailsByCusManAndTL(String projectNamesN, String prodmgrN,
						String teamLeaderNameN);
				public JSONArray OnHoldDetailsBasedOnAll(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				
				//28/10
				public JSONArray getEmployeesByMan(String uname);
				
				
				public String saveFeedback(String developerName, String projectName, String performanceRating,
						String feedbackComments, String suggestions, String role);
				public String saveClientFeedback1(String clientName, String projectName, String dateOfFeedback,
						String feedbackType, String feedbackDescription, String impactAssessment,
						String statusOfGrievance, String assignedTo, String resolutionDescription, String followUpDate,
						String clientResponse);
				
				
				
				
				//12/11
				public JSONArray getDevelopersByManagerOnhold(String userfullname);
				
				//12/11
				public JSONArray OnHoldManagerListDetMan(String projectNamesN);
				
				//12/11
				public JSONArray OnHoldDetailsByCusMan(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				
				//12/11
				public JSONArray OnHoldTLListDetMan(String projectNamesN, String prodmgrN);
				
				//12/11
				public JSONArray OnHoldBasedOnManagerMan(String selectedCustomer, String selectedMan, String selectedTL,
						String selectedFunction);
				
				//12/11
				public JSONArray OnHoldDetailsByCusAndManOnhold(String projectNamesN, String prodmgrN);
				
				//12/11
				public JSONArray OnHoldFunctionListDetMan(String projectNamesN, String prodmgrN, String teamLeaderNameN,
						String fnameN);
				
				//12/11
				public JSONArray OnHoldDetailsByCusManAndTLMan(String projectNamesN, String prodmgrN,
						String teamLeaderNameN);
				
				//12/11
				public JSONArray OnHoldDetailsBasedOnAllMan(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN);
				
				//12/11
				public JSONArray getCompletedProjectListNewMan(String userfullname, String role);
				
				//12/11
				public JSONArray getProductToolTotActMan(String userfullname, String role);
				
				//12/11
				public JSONArray getCompletedTeamLeaderNewMan(String userfullname, String role);
				
				//12/11
				public JSONArray CompletedManagerListDetNewMan(String projectNamesN, String role);
				
				//12/11
				public JSONArray getProductToolListTotActMan(String projectName, String pManager, String projectTL,
						String functionName, String productTool, String status, String role);
				//12/11
				public JSONArray CompletedTLListDetNewMan(String projectNamesN, String prodtoolNNew);
				
				//12/11
				public JSONArray getProductToolByManagerTotActMan(String projectNamesNNew, String prodmgrNNew,
						String teamleaderNMan);
				
				//12/11
				public JSONArray getProductToolListTotActManager(String projectName, String pManager, String projectTL,
						String functionName, String productTool, String status);
				
				//12/11
				public JSONArray CompletedFunctionListDetNewMan(String projectNamesN, String prodmgrN,
						String teamLeaderNameN, String fnameN, String productTool);
				
				//08/11
				public String bellNotification(String uname);
				
				//12/11
				public JSONArray renderNotifications(String uname);
				
				//16/11
				public JSONArray getStatusForDeletedActivities(String productsuit);
				public JSONArray getAllsecuritysolutionList();
				public String getproductnametoolN(String productSuite);
				public JSONArray getproductsuitlistN();
				
				
				
				
				//28/11
				public String updateTLMasterSupportNew(String productsuitupdate, String securitysolutionupdate,
						String tlname, int srno, String updImplementerName, String assignedToupdate);
				
				//28/11
				public JSONArray getTLForTLMaster();
				
				//28/11
				public JSONArray TlmasterlistingForTeamMaster(String subjectList);
				
				//28/11
				public String updateTLMasterDeveloperNew(String productsuitupdate, String securitysolutionupdate,
						String tlname, int srno, String updImplementerName, String assignedToupdate);
				
				//28/11
				public String saveTlMasterForMan(String productsuit, String productname, String unit,
						String implementerName, String tlname, String developer, String customerName);
				public String uploadLicenseFile(MultipartFile[] licenseUploadfile);
				
				
				
				
				
				
			
}