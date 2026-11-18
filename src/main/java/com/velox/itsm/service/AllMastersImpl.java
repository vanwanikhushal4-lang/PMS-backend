package com.velox.itsm.service;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.velox.itsm.dao.MasterDao;


@Service("AllMasters")
@Transactional
public class AllMastersImpl implements AllMasters {

	@Autowired
	MasterDao masterDao;
	
	
	
	
	

//	@Override
//	public String getParameter(String username) {
//
//		String ad_output = login_dao.getParameter(username);
//
//		return ad_output;
//	}

	@Override
	public JSONArray getCompanyDetails(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getCompanyNames(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray getrespup() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getrespup();
		
		return getProblemCategoryDetailsList_dao_output;
	}
	@Override
	public JSONArray getCompanydropdownlist() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getCompanydropdownlist();
		
		return getProblemCategoryDetailsList_dao_output;
	}
	@Override
	public JSONArray getCompositeCompanyList() {

		JSONArray getCompositeCompanyList = masterDao.getCompositeCompanyList();
		
		return getCompositeCompanyList;
	}

	
	@Override
	public JSONArray ViewAllADUsers(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.ViewAllADUsers(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	public String updateuser(String srno,String utype ,String name,String mail,String contact,String username,String cname)
	{
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		
		String company_dao_output = masterDao.updateuser(srno,utype, name, mail, contact, username,cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	

	
//	public String updateuser(String srno,String utype ,String name,String mail,String contact)
//	{
//		System.out.println("Inside getCompanyDetails ");
//		
//		String controller_response = null;
//	
//
//		
//		String company_dao_output = masterDao.updateuser(srno,utype, name, mail, contact);
//		System.out.println("From Service_IMPL_output response " + company_dao_output);
//		return company_dao_output;
//		
//
////		return controller_response;
//	}
	
	
	
	@Override
	public JSONArray getOwnNameDetails(String cname, String companyname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getOwnNameDetails(cname,companyname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public String testadIntegration(String username, String password, String hostname, String domainname, String port) {
		// TODO Auto-generated method stub
		String res=masterDao.testadIntegration(username,password,hostname,domainname,port);
		return res;
	}
	
    public String saveadIntegration(String username,String password,String hostname,String port,String domainname,String companyname){
		
		String res=masterDao.saveadIntegration(username,password,hostname,port,domainname,companyname);
		
		return res;
	}
    
    @Override
	public String FetchADusers(String company) {
		// TODO Auto-generated method stub
		return masterDao.FetchADusers(company);
	}
    
	
	@Override
	public String adduserEmail(String company,String mail,String subject,String folder,String port,String uname,String pass,String starttls)
		{
		

		return masterDao.adduserEmail(company,mail,subject,folder,port,uname,pass,starttls);
	}

	@Override
	public String adduserVrops(String uname,String pass,String surl,String certi,String host,String alerttype)
		{
		

		return masterDao.adduserVrops(  uname, pass, surl, certi, host, alerttype);
	}

	

	@Override
	public JSONArray addEmailIntDetails(String userlist) {
System.out.println("Inside addUserDetails ");
		
		String controller_response = null;
	

		System.out.println("addUserDetails" + userlist);
		JSONArray adduserlist_dao_output = masterDao.addEmailIntDetails(userlist);
		System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
		return adduserlist_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray addVropsIntDetails(String userlist) {
System.out.println("Inside addUserDetails ");
		
		String controller_response = null;
	

		System.out.println("addUserDetails" + userlist);
		JSONArray adduserlist_dao_output = masterDao.addVropsIntDetails(userlist);
		System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
		return adduserlist_dao_output;
		

//		return controller_response;
	}
	
	
	
	@Override
	public JSONArray getesc1NameDetails(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getesc1NameDetails(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray getesc2NameDetails(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getesc2NameDetails(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray getesc3NameDetails(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getesc3NameDetails(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	
	@Override
	public JSONArray getBranchDetails(String cname) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + cname);
		JSONArray company_dao_output = masterDao.getBranchNames(cname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray gettid(String sname,String fromdate,String todate ) {
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + sname);
		JSONArray company_dao_output = masterDao.gettid(sname,fromdate,todate);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}
	
	
	
	@Override
	public JSONArray getCategoryDetails(String catname) {
	System.out.println("Inside getCategoryDetails ");
		
//		String controller_response = null;
	

		System.out.println("Category name" + catname);
		JSONArray category_dao_output = masterDao.getCategoryDetails(catname);
		System.out.println("From Service_IMPL_output response " + category_dao_output);
		return category_dao_output;
		

//		return controller_response;
	}
	@Override
	public JSONArray getGroupDetails(String groupname) {
	System.out.println("Inside getGroupDetails ");
		System.out.println("GROUP name" + groupname);
		JSONArray group_dao_output = masterDao.getGroupDetails(groupname);
		System.out.println("From Service_IMPL_output response " + group_dao_output);
		return group_dao_output;
	}

	@Override
	public JSONArray getSiteDetails(String sname) {
	System.out.println("Inside getSiteDetails ");
		
		String controller_response = null;
	

		System.out.println("Site name" + sname);
		JSONArray site_dao_output = masterDao.getSiteNames(sname);
		System.out.println("From Service_IMPL_output response " + site_dao_output);
		return site_dao_output;
		

//		return controller_response;
	}

	@Override
	public JSONArray getDeptDetails(String dname) {
	System.out.println("Inside getDeptDetails ");
		
		String controller_response = null;
	

		System.out.println("Dept name" + dname);
		JSONArray dept_dao_output = masterDao.getDeptNames(dname);
		System.out.println("From Service_IMPL_output response " + dept_dao_output);
		return dept_dao_output;
		

//		return controller_response;
	}

	@Override
	public String adduser(String mail, String cno, String user, String pass, String fname, String lname,
			String cpass, String cname, String sname, String dname) {
		

		return masterDao.adduser(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname);
	}

	@Override
	public JSONArray addUserDetails(String userlist) {
System.out.println("Inside addUserDetails ");
		
		String controller_response = null;
	

		System.out.println("addUserDetails" + userlist);
		JSONArray adduserlist_dao_output = masterDao.addUserDetails(userlist);
		System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
		return adduserlist_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray ViewTicketOwner(String userlist) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.ViewTicketOwner(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	
	
	@Override
	public JSONArray ViewcloseTicket(String userlist) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.ViewcloseTicket(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	public JSONArray ViewAssignTicket(String userlist)
    {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.ViewAssignTicket(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	@Override
	public JSONArray getOwn1Details(String userlist) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.getOwn1Details(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	
	@Override
	public JSONArray ViewEscMatrix(String userlist) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.ViewEscMatrix(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
//	@Override
//	public JSONArray getOwn1Details(String userlist) {
//	System.out.println("Inside addUserDetails ");
//	
//	String controller_response = null;
//
//
//	System.out.println("addUserDetails" + userlist);
//	JSONArray adduserlist_dao_output = masterDao.getOwn1Details(userlist);
//	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
//	return adduserlist_dao_output;
//	
//
////	return controller_response;
//}
	
	
	@Override
	public JSONArray getesc1Details(String engname) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + engname);
	JSONArray adduserlist_dao_output = masterDao.getesc1Details(engname);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	@Override
	public JSONArray getesc2Details(String engname) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + engname);
	JSONArray adduserlist_dao_output = masterDao.getesc2Details(engname);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}
	
	
	@Override
	public JSONArray getesc3Details(String engname) {
	System.out.println("Inside addUserDetails ");
	
	String controller_response = null;


	System.out.println("addUserDetails" + engname);
	JSONArray adduserlist_dao_output = masterDao.getesc3Details(engname);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	

//	return controller_response;
}

	

	public String addTicketOwner(String company,String branch,String category,String ticowner,String esc1,String esc2,String esc3,String towneremail,String e1email,String e2email,String e3email,String townermob,String e1mob,String e2mob,String e3mob)
	{
		System.out.println("Inside addUserDetails ");
				
				String controller_response = null;
			

				
				String adduserlist_dao_output = masterDao.addTicketOwner( company, branch, category, ticowner, esc1, esc2, esc3, towneremail, e1email, e2email, e3email, townermob, e1mob, e2mob, e3mob);
				System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
				return adduserlist_dao_output;
				

//				return controller_response;
			}
	
	
	public String addEscalatorMatrix(String company,String branch,String category,String ticowner,String esc1,String esc2,String esc3,String towneremail,String e1email,String e2email,String e3email,String townermob,String e1mob,String e2mob,String e3mob,String priority,String mail,String sms,String t0,String t1,String t2,String t3,String tt0,String tt1,String tt2,String tt3)
	{
		System.out.println("Inside addUserDetails ");
				
				String controller_response = null;
			

				System.out.println("service imple= t2==="+t2);
				System.out.println("service imple= t3==="+t3);
				
				String adduserlist_dao_output = masterDao.addEscalatorMatrix( company, branch, category, ticowner, esc1, esc2, esc3, towneremail, e1email, e2email, e3email, townermob, e1mob, e2mob, e3mob, priority, mail, sms, t0, t1, t2,t3, tt0, tt1, tt2, tt3);
				System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
				return adduserlist_dao_output;
				

//				return controller_response;
			}
	
	
	public String addAutoAssignTicket(String category,String priority,int days,int hours,int minutes,int seconds, String company, String severity,String assign_TO, String group_Name)
    {
		System.out.println("Inside addUserDetails ");

				String adduserlist_dao_output = masterDao.addAutoAssignTicket(category,priority,days, hours, minutes, seconds, company, severity,assign_TO,group_Name);
				System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
				return adduserlist_dao_output;
			}
	
	@Override
	public JSONArray getCategoryDetailsforAutoAssignTickets(String catname) {
		JSONArray categorydetails = masterDao.getCategoryDetailsforAutoAssignTickets(catname);
		System.out.println("From Service_IMPL_output response " + categorydetails);
		return categorydetails;
	}
	
	@Override
	public JSONArray getGroupDetailsforAutoAssignTickets(String groupname) {
	System.out.println("Inside getGroupDetails ");
		System.out.println("GROUP name" + groupname);
		JSONArray group_dao_output = masterDao.getGroupDetails(groupname);
		System.out.println("From Service_IMPL_output response " + group_dao_output);
		return group_dao_output;
	}
	
	@Override
	public String updateAddUserSave(String mail, String cno, String user, String pass, String fname, String lname,
			String cpass, String cname, String sname, String dname, int cr_no) {
		
		return masterDao.updateAddUserSave(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, cr_no);
	}

	@Override
	public String deleteUser(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteUser(crno);
	}

	@Override
	public String addengg(String mail, String cno, String user, String pass, String fname, String lname, String cpass,
			String cname, String sname, String dname, String category, String englevel) {
	
		return masterDao.addengg(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, category, englevel);
	}

	@Override
	public JSONArray addEnggDetails(String userlist) {
System.out.println("Inside addEnggDetails ");
		
		String controller_response = null;
	

		System.out.println("addEnggDetails" + userlist);
		JSONArray addengglist_dao_output = masterDao.addEnggDetails(userlist);
		System.out.println("From Service_IMPL_output response " + addengglist_dao_output);
		return addengglist_dao_output;
		

//		return controller_response;
	}

	@Override
	public String updateAddEnggSave(String mail, String cno, String user, String pass, String fname, String lname,
			String cpass, String cname, String sname, String dname, String category, int cr_no, String englevel) {

		return masterDao.updateAddEnggSave(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, category, cr_no, englevel);
	}

	@Override
	public String deleteEngg(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteEngg(crno);
	}


	@Override
	public JSONArray addTPDetails(String userlist) {
System.out.println("Inside addTPDetails ");
		
		String controller_response = null;
	

		System.out.println("addTPDetails" + userlist);
		JSONArray addTPlist_dao_output = masterDao.addTPDetails(userlist);
		System.out.println("From Service_IMPL_output response " + addTPlist_dao_output);
		return addTPlist_dao_output;
		

//		return controller_response;
	}

	@Override
	public String addTP(String mail, String cno, String user, String pass, String fname, String lname, String cpass,
			String cname, String sname, String dname) {

		return masterDao.addTP(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname);
	}

	@Override
	public String updateAddTPSave(String mail, String cno, String user, String pass, String fname, String lname,
			String cpass, String cname, String sname, String dname, int cr_no) {
		
		return masterDao.updateAddTPSave(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, cr_no);
	}

	@Override
	public String deleteTP(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteTP(crno);
	}

	@Override
	public JSONArray addITHeadDetails(String userlist) {

System.out.println("Inside addITHeadDetails ");
		
		System.out.println("addITHeadDetails" + userlist);
		JSONArray addITHeadDetails_dao_output = masterDao.addITHeadDetails(userlist);
		System.out.println("From Service_IMPL_output response " + addITHeadDetails_dao_output);
		return addITHeadDetails_dao_output;
	}

	@Override
	public String addIT_Head(String cno, String user, String pass, String cpass) {
			
		return masterDao.addIT_Head(cno, user, pass, cpass);
	}

	@Override
	public String deleteIT_Head(int crno) {
		
				return masterDao.deleteIT_Head(crno);
	}

	@Override
	public JSONArray CompanyDetails(String userlist) {
		
System.out.println("Inside CompanyDetails ");
		
		System.out.println("CompanyDetails" + userlist);
		JSONArray CompanyDetails_dao_output = masterDao.CompanyDetails(userlist);
		System.out.println("From Service_IMPL_output response " + CompanyDetails_dao_output);
		return CompanyDetails_dao_output;
	}

	@Override
	public JSONArray updateCompanyMaster(int cr_no) {
		
		return masterDao.updateCompanyMaster(cr_no);
	}

	@Override
	public String addCompany(String company, String companyemail) {
		
		return masterDao.addCompany(company, companyemail);
	}

	@Override
	public String updatecompanySave(String companynameupdate, String companyemailupdate, int cr_no) {
		// TODO Auto-generated method stub
		return masterDao.updatecompanySave(companynameupdate, companyemailupdate, cr_no);
	}

	@Override
	public String deleteCompany(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteCompany(crno);
	}

	@Override
	public JSONArray SiteMasterListing(String userlist) {
		
		System.out.println("Inside SiteMasterListing ");
		
		System.out.println("SiteMasterListing" + userlist);
		JSONArray SiteMasterListing_dao_output = masterDao.SiteMasterListing(userlist);
		System.out.println("From Service_IMPL_output response " + SiteMasterListing_dao_output);
		return SiteMasterListing_dao_output;
	}

	@Override
	public String SubmitSiteDetails(String company, String branch) {
		// TODO Auto-generated method stub
		return masterDao.SubmitSiteDetails(company, branch);
	}

	@Override
	public String updateSiteMasterSave(String companynameupdate, String sitenameupdate, int cr_no) {
		// TODO Auto-generated method stub
		return masterDao.updateSiteMasterSave(companynameupdate, sitenameupdate, cr_no);
	}

	@Override
	public String deleteSite(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteSite(crno);
	}

	@Override
	public JSONArray CategoryDetails(String userlist) {
		System.out.println("Inside CategoryDetails ");
		
		System.out.println("CategoryDetails" + userlist);
		JSONArray CategoryDetails_dao_output = masterDao.CategoryDetails(userlist);
		System.out.println("From Service_IMPL_output response " + CategoryDetails_dao_output);
		return CategoryDetails_dao_output;
	}

	@Override
	public String addcategory(String category) {
		// TODO Auto-generated method stub
		return masterDao.addcategory(category);
	}

	@Override
	public String updateCategoryMasterSave(String categorynameupdate, int cr_no) {
		// TODO Auto-generated method stub
		return masterDao.updateCategoryMasterSave(categorynameupdate, cr_no);
	}

	@Override
	public String deleteCategory(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteCategory(crno);
	}

	@Override
	public String SubmitGroupDetails(String category, String group) {
		// TODO Auto-generated method stub
		return masterDao.SubmitGroupDetails(category, group);
	}

	@Override
	public JSONArray SubCategoryMasterListing(String userlist) {
		
System.out.println("Inside SubCategoryMasterListing ");
		
		System.out.println("CategoryMasterListing" + userlist);
		JSONArray SubCategoryMasterListing_dao_output = masterDao.SubCategoryMasterListing(userlist);
		System.out.println("From Service_IMPL_output response " + SubCategoryMasterListing_dao_output);
		return SubCategoryMasterListing_dao_output;
	}

	@Override
	public String updateGroupMasterSave(String categorynameupdate, String groupnameupdate, int cr_no) {
		// TODO Auto-generated method stub
		return masterDao.updateGroupMasterSave(categorynameupdate, groupnameupdate, cr_no);
	}

	@Override
	public String deleteGroup(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteGroup(crno);
	}

	@Override
	public JSONArray DepartmentDetails(String userlist) {
	
		System.out.println("DepartmentDetails" + userlist);
		JSONArray DepartmentDetails_dao_output = masterDao.DepartmentDetails(userlist);
		System.out.println("From Service_IMPL_output response " + DepartmentDetails_dao_output);
		return DepartmentDetails_dao_output;
	}

	@Override
	public String add_Department(String department) {
		
		return masterDao.add_Department(department);
	}

	@Override
	public String updateDepartmentMasterSave(String departmentnameupdate, int cr_no) {
		
		return masterDao.updateDepartmentMasterSave(departmentnameupdate, cr_no);
	}

	@Override
	public String DeleteDepartment(int crno) {
		
		return masterDao.DeleteDepartment(crno);
	}

	@Override
	public JSONArray PriorityDetails(String userlist) {
		
		System.out.println("PriorityDetails" + userlist);
		JSONArray PriorityDetails_dao_output = masterDao.PriorityDetails(userlist);
		System.out.println("From Service_IMPL_output response " + PriorityDetails_dao_output);
		return PriorityDetails_dao_output;
	}

	@Override
	public String addPriority(String priority, String company) {
		
		return masterDao.addPriority(priority, company);
				
	}

	@Override
	public String updatePriorityMasterSave(String companyName, String prioritynameupdate, int cr_no) {
		
		return masterDao.updatePriorityMasterSave(companyName, prioritynameupdate, cr_no);
				
	}

	@Override
	public String DeletePriority(int crno) {
		
		return masterDao.DeletePriority(crno);
	}

	@Override
	public JSONArray RequestModeDetails(String userlist) {
		
System.out.println("Inside RequestModeDetails ");
		
		System.out.println("RequestModeDetails" + userlist);
		JSONArray RequestModeDetails_dao_output = masterDao.RequestModeDetails(userlist);
		System.out.println("From Service_IMPL_output response " + RequestModeDetails_dao_output);
		return RequestModeDetails_dao_output;
	}

	@Override
	public String addRequestMode(String requestmode ,String company) {
		// TODO Auto-generated method stub
		return masterDao.addRequestMode(requestmode ,company);
	}

	@Override
	public String updateRequestModeSave(String requestmodeupdate, int cr_no , String companyupdate) {
		// TODO Auto-generated method stub
		return masterDao.updateRequestModeSave(requestmodeupdate, cr_no,companyupdate);
	}

	@Override
	public String DeleteRequestMode(int crno) {
		// TODO Auto-generated method stub
		return masterDao.DeleteRequestMode(crno);
	}

	@Override
	public JSONArray addAdminDetails(String userlist) {
		
		System.out.println("addAdminDetails" + userlist);
		JSONArray addAdminDetails_dao_output = masterDao.addAdminDetails(userlist);
		System.out.println("From Service_IMPL_output response " + addAdminDetails_dao_output);
		return addAdminDetails_dao_output;
	}

	@Override
	public String ADDAdminMaster(String cno, String user, String pass, String cpass) {
		// TODO Auto-generated method stub
		return masterDao.ADDAdminMaster(cno, user, pass, cpass);
	}

	@Override
	public String DeleteAdmin(int crno) {
		// TODO Auto-generated method stub
		return masterDao.DeleteAdmin(crno);
	}

	@Override
	public JSONArray getSubCategoryName(String subcatname) {
System.out.println("Inside getSubCategoryName ");
		
//		String controller_response = null;
	

		System.out.println("gSubCategoryName name" + subcatname);
		JSONArray subcategory_dao_output = masterDao.getSubCategoryName(subcatname);
		System.out.println("From Service_IMPL_output response " + subcategory_dao_output);
		return subcategory_dao_output;
		

//		return controller_response;
	}

	@Override
	public JSONArray getRequestModeName(String reqmode) {
//		
//System.out.println("Inside getRequestModeName ");
//				
//		System.out.println("reqmode name" + reqmode);
		JSONArray RequestMode_dao_output = masterDao.getRequestModeName(reqmode);
		System.out.println("From Service_IMPL_output response " + RequestMode_dao_output);
		return RequestMode_dao_output;
	}
	@Override
	public JSONArray getCustomerName() {
		
  //  System.out.println("Inside getCustomerName ");
				
		//System.out.println("reqmode name" + reqmode);
		JSONArray RequestMode_dao_output = masterDao.getCustomerName();
		//System.out.println("From Service_IMPL_output response " + RequestMode_dao_output);
		return RequestMode_dao_output;
	}
	
	@Override
	public String getProductName(String clientname) {
		

		
		
		return masterDao.getProductName(clientname);
	}

	@Override
	public JSONArray getPriorityName(String companyname) {
		
		System.out.println("companyname name" + companyname);
		JSONArray PriorityName_dao_output = masterDao.getPriorityName(companyname);
		System.out.println("From Service_IMPL_output response " + PriorityName_dao_output);
		return PriorityName_dao_output;
	}

	@Override
	public JSONArray getSubCategoryEnggName(String category,String Company,String Branch,String Department) {
		
		System.out.println("Inside getSubCategoryEnggName ");
			
			String controller_response = null;
		

			System.out.println("getSubCategoryEnggName name" + category);
			JSONArray getSubCategoryEnggName_dao_output = masterDao.getSubCategoryEnggName(category,Company,Branch,Department);
			System.out.println("From Service_IMPL_output response " + getSubCategoryEnggName_dao_output);
			return getSubCategoryEnggName_dao_output;

	}

	@Override
	public JSONArray BranchNameValues(String bname) {
System.out.println("Inside BranchNameValues ");
	
		System.out.println("BranchNameValues name" + bname);
		JSONArray BranchNameValues_dao_output = masterDao.BranchNameValues(bname);
		System.out.println("From Service_IMPL_output response " + BranchNameValues_dao_output);
		return BranchNameValues_dao_output;
	}

	@Override
	public JSONArray UserNameValues(String company, String branchname2, String department) {
		System.out.println("Inside UserNameValues ");
		
		JSONArray UserNameValues_dao_output = masterDao.UserNameValues(company,branchname2,department);
		System.out.println("From Service_IMPL_output response " + UserNameValues_dao_output);
		return UserNameValues_dao_output;
	}

	@Override
	public JSONArray EnggNameValues(String company, String branchname2) {
System.out.println("Inside EnggNameValues ");
		
		JSONArray EnggNameValues_dao_output = masterDao.EnggNameValues(company,branchname2);
		System.out.println("From Service_IMPL_output response " + EnggNameValues_dao_output);
		return EnggNameValues_dao_output;
	}

	@Override
	public JSONArray GroupNameValues(String categoryname,String company) {
System.out.println("Inside GroupNameValues ");
		
		System.out.println("GroupNameValues name" + categoryname);
		JSONArray GroupNameValues_dao_output = masterDao.GroupNameValues(categoryname,company);
		System.out.println("From Service_IMPL_output response " + GroupNameValues_dao_output);
		return GroupNameValues_dao_output;
	}

	@Override
	public JSONArray EnggNameValuesForSLA(String branchname, String companyname) {
System.out.println("Inside EnggNameValuesForSLA ");
		
	System.out.println("EnggNameValuesForSLA branchname" + branchname);
	System.out.println("EnggNameValuesForSLA companyname" + companyname);
		JSONArray EnggNameValuesForSLA_dao_output = masterDao.EnggNameValuesForSLA(branchname, companyname);
		System.out.println("From Service_IMPL_output response " + EnggNameValuesForSLA_dao_output);
		return EnggNameValuesForSLA_dao_output;
	}


	@Override
	public JSONArray getEscBranchDetails(String companyname) {
		System.out.println("Inside getEscBranchDetails ");
		
		String controller_response = null;
	

		System.out.println("Company name" + companyname);
		JSONArray company_dao_output = masterDao.getEscBranchNames(companyname);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
	}


	@Override
	public JSONArray AddMailListing(String userlist) {
System.out.println("Inside AddMailListing ");
		
		System.out.println("AddMailListing" + userlist);
		JSONArray AddMailListing_dao_output = masterDao.AddMailListing(userlist);
		System.out.println("From Service_IMPL_output response " + AddMailListing_dao_output);
		return AddMailListing_dao_output;
	}


	@Override
	public JSONArray adddetailsListing(String userlist) {
		System.out.println("Inside adddetailsListing ");
		
		System.out.println("adddetailsListing" + userlist);
		JSONArray adddetailsListing_dao_output = masterDao.adddetailsListing(userlist);
		System.out.println("From Service_IMPL_output response " + adddetailsListing_dao_output);
		return adddetailsListing_dao_output;
	}


	@Override
	public String SubmitEscalationDetails(String engLevel, int days, int hours, int minutes, int seconds,String companyname, String priority, String severity, String designation, String username) {
		// TODO Auto-generated method stub
		return masterDao.SubmitEscalationDetails(engLevel,days,hours,minutes,seconds,companyname,priority,severity,designation,username);
	}

	@Override
	public JSONArray EscalationMasterListing(String escMasterList) {
		System.out.println("EscalationMasterListing" + escMasterList);
		JSONArray EscalationMasterListing_dao_output = masterDao.EscalationMasterListing(escMasterList);
		System.out.println("From Service_IMPL_output response " + EscalationMasterListing_dao_output);
		return EscalationMasterListing_dao_output;
	}

	@Override
	public JSONArray getCompanyPriority(String company) {
	  return masterDao.getCompanyPriority(company);
	}
	
	@Override
  public JSONArray getCompanySeverity(String company) {
	  return masterDao.getCompanySeverity(company);
	}

	@Override
	public String deleteEscalation(String company, String level) {
		return masterDao.deleteEscalation(company,level);
	}


	@Override
	public String deleteAutoAssignMaster(String srno) {
		return masterDao.deleteAutoAssignMaster(srno);
	}


	@Override
	public JSONArray getProblemCategoryDetailsList(String catname) {
System.out.println("Inside getProblemCategoryDetailsList ");
		
System.out.println("Problem Category name" + catname);
		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getProblemCategoryDetailsList(catname);
		System.out.println("From Service_IMPL_output response " + getProblemCategoryDetailsList_dao_output);
		return getProblemCategoryDetailsList_dao_output;
	}


	@Override
	public JSONArray getProblemSubCategory1(String subcat1) {
		System.out.println("Inside getProblemSubCategory1 ");
		System.out.println("Problem getProblemSubCategory1 name" + subcat1);
				JSONArray getProblemSubCategory1_dao_output = masterDao.getProblemSubCategory1(subcat1);
				System.out.println("From Service_IMPL_output response " + getProblemSubCategory1_dao_output);
				return getProblemSubCategory1_dao_output;
	}


	@Override
	public JSONArray getProblemSubCategory2(String subcat2) {
		System.out.println("Inside getProblemSubCategory2 ");
		System.out.println("Problem getProblemSubCategory2 name" + subcat2);
				JSONArray getProblemSubCategory2_dao_output = masterDao.getProblemSubCategory2(subcat2);
				System.out.println("From Service_IMPL_output response " + getProblemSubCategory2_dao_output);
				return getProblemSubCategory2_dao_output;
	}


	@Override
	public String addProblemCategory(String category, String subcategory1, String subcategory2) {
		return masterDao.addProblemCategory(category,subcategory1,subcategory2);
	}


	@Override
	public JSONArray ProblemCategoryListing(String problemCatList) {
		System.out.println("Inside ProblemCategoryListing ");
		System.out.println("ProblemCategoryListing" + problemCatList);
		JSONArray ProblemCategoryListing_dao_output = masterDao.ProblemCategoryListing(problemCatList);
		System.out.println("From Service_IMPL_output response " + ProblemCategoryListing_dao_output);
		return ProblemCategoryListing_dao_output;
	}


	@Override
	public String deleteProblemCategory(int crno) {
		return masterDao.deleteProblemCategory(crno);
	}


	@Override
	public JSONArray getSubCategory1Name(String subcat1name) {
		System.out.println("getSubCategory1Name name" + subcat1name);
		JSONArray getSubCategory1Name_dao_output = masterDao.getSubCategory1Name(subcat1name);
		System.out.println("From Service_IMPL_output response " + getSubCategory1Name_dao_output);
		return getSubCategory1Name_dao_output;
	}


	@Override
	public JSONArray getSubCategory2Name(String subcat2name, String ProblemCategory) {
		System.out.println("getSubCategory2Name name");
		JSONArray getSubCategory2Name_dao_output = masterDao.getSubCategory2Name(subcat2name,ProblemCategory);
		System.out.println("From Service_IMPL_output response " + getSubCategory2Name_dao_output);
		return getSubCategory2Name_dao_output;
	}


	@Override
	public JSONArray ViewProblemcloseTicket(String userlist) {
		JSONArray ViewProblemcloseTicket_dao_output = masterDao.ViewProblemcloseTicket(userlist);
		System.out.println("From Service_IMPL_output response " + ViewProblemcloseTicket_dao_output);
		return ViewProblemcloseTicket_dao_output;
	}

	@Override
	public String addMFAType(String priority) {
		
		return masterDao.addMFAType(priority);
				
	}
	
	@Override
	public String updateTheme(String type, String value) {
		
		return masterDao.updateTheme(type, value);
	}

	@Override
	public JSONArray getThemeData(String nodata) {
		
		return masterDao.getThemeData(nodata);
	}


	@Override
	public JSONArray getINCSubCategory1Name(String Category, String companyname) {
//		System.out.println("getINCSubCategory1Name name" + Category);
		JSONArray getINCSubCategory1Name_dao_output = masterDao.getINCSubCategory1Name(Category,companyname);
//		System.out.println("From Service_IMPL_output response " + getINCSubCategory1Name_dao_output);
		return getINCSubCategory1Name_dao_output;
	}


	@Override
	public JSONArray getINCSubCategory2Name(String Category, String subcat1name, String companyname) {
//		System.out.println("getINCSubCategory2Name name" + Category);
		JSONArray getINCSubCategory2Name_dao_output = masterDao.getINCSubCategory2Name(Category,subcat1name,companyname);
		System.out.println("From Service_IMPL_output response " + getINCSubCategory2Name_dao_output);
		return getINCSubCategory2Name_dao_output;
	}
	
	@Override
	public JSONArray getCompositeBranchList() {
		
				JSONArray getProblemSubCategory1_dao_output = masterDao.getCompositeBranchList();
				
				return getProblemSubCategory1_dao_output;
	}
	 @Override
	  public JSONArray resplisting(String designationList) {
	    return masterDao.resplisting(designationList);
	  }
	  
	
	@Override
	public JSONArray getCompositeLocationList(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCompositeLocationList(subcat2);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public JSONArray getCompositeDepartment(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCompositeDepartment(subcat2);
			
				return getProblemSubCategory2_dao_output;
	}
	@Override
	public JSONArray getCompositeSubDepartment(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCompositeSubDepartment(subcat2);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public JSONArray CompositeListing(String problemCatList) {
		
		JSONArray ProblemCategoryListing_dao_output = masterDao.CompositeListing(problemCatList);
		
		return ProblemCategoryListing_dao_output;
	}
	@Override
	public String addComposite(String category, String subcategory1, String subcategory2,String department,String subDepartment) {
		return masterDao.addComposite(category,subcategory1,subcategory2,department,subDepartment);
	}
	
	@Override
	public String deleteComposite(int crno) {
		return masterDao.deleteComposite(crno);
	}

	@Override
	public JSONArray getBranchForLoginMaster(String company,String location) {
		
				JSONArray getProblemSubCategory1_dao_output = masterDao.getBranchForLoginMaster(company,location);
				
				return getProblemSubCategory1_dao_output;
	}

	
	@Override
	public JSONArray getLocationForLoginMaster(String companyname) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getLocationForLoginMaster(companyname);
			
				return getProblemSubCategory2_dao_output;
	}

	
	@Override
	public JSONArray getDepartmentForLoginMaster(String companyname,String branchName,String location) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getDepartmentForLoginMaster(companyname,branchName,location);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public JSONArray getSubDepartmentForLoginMaster(String companyname,String branchName,String location,String departmentName) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubDepartmentForLoginMaster(companyname,branchName,location, departmentName);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public String updateUserLoginMaster(String mail, String cno, String user, String pass, String fname, String lname,
			String cpass, String cname, String sname, String dname, String category, int cr_no, String englevel,String rtypeupdate,String row,String subdnameupdate,String vipLogin,String updatecategory,String updategroup, String designation,String visibilityupdate,String updateUserLoginMaster,String selectedSideBarValuesFinal) {

		return masterDao.updateUserLoginMaster(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, category, cr_no, englevel, rtypeupdate,row, subdnameupdate, vipLogin,updatecategory,updategroup,designation,visibilityupdate,updateUserLoginMaster,selectedSideBarValuesFinal);
	}
	@Override
	public JSONArray getCompanyDetailsForLoginMaster() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getCompanyDetailsForLoginMaster();
		
		return getProblemCategoryDetailsList_dao_output;
	}
	
	@Override
	public JSONArray getDepartmentForUserScope(String companyname,String branchName) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getDepartmentForUserScope(companyname,branchName);
			
				return getProblemSubCategory2_dao_output;
	}

	
	@Override
	public JSONArray getUserScopeForUpadte(String userlist ,String E_id) {

		String controller_response = null;
	

	
		JSONArray addengglist_dao_output = masterDao.getUserScopeForUpadte(userlist,E_id);
	
		return addengglist_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public String updateUserPassword(String mail, String cno, String user,String loginid) {

		return masterDao.updateUserPassword(mail, cno, user,loginid);
	}
	

	@Override
	public JSONArray getLoginMasterDetails(String userlist) {

		JSONArray addengglist_dao_output = masterDao.getLoginMasterDetails(userlist);
	
		return addengglist_dao_output;
		

//		return controller_response;
	}
	
	@Override
	public JSONArray getGroupForPerticularUser(String username,String company1) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getGroupForPerticularUser( username,company1);
			
				return getProblemSubCategory2_dao_output;
	}
	@Override
	public JSONArray getCategoryForPerticularUser(String username,String company) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCategoryForPerticularUser( username,company);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public String addUserInLoginMaster(String mail, String cno, String user, String pass, String fname, String lname, String cpass,
			String cname, String sname, String dname, String category, String englevel,String location, String rtype,String row,String vipLogin,String categoryMulti1,String groupMulti1, String designation,String visibility,String cat_with_company,String selectedSideBarValuesFinal,String gender) {
	
		return masterDao.addUserInLoginMaster(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, category, englevel, location,  rtype, row, vipLogin, categoryMulti1, groupMulti1, designation,visibility,cat_with_company,selectedSideBarValuesFinal,gender);
	}	@Override
	public JSONArray getCategoryForLoginMaster(String company) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCategoryForLoginMaster(company);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public String DeleteLoginMasterData(int crno) {
		// TODO Auto-generated method stub
		return masterDao.DeleteLoginMasterData(crno);
	}

	
	
	@Override
	public JSONArray getCompanyDetailsForTicketTagMaster() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getCompanyDetailsForTicketTagMaster();
		
		return getProblemCategoryDetailsList_dao_output;
	}
	
	@Override
	public JSONArray TicketTagDetails() {
		
		JSONArray CategoryDetails_dao_output = masterDao.TicketTagDetails();
		
		return CategoryDetails_dao_output;
	}
	
	@Override
	public JSONArray getDepartmentForTicketTagMaster(String companyname) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getDepartmentForTicketTagMaster(companyname);
			
				return getProblemSubCategory2_dao_output;
	}
	
	@Override
	public String addTicketTag(String company,String companyTag,String dname) {
		// TODO Auto-generated method stub
		return masterDao.addTicketTag( company, companyTag, dname);
	}
	
	@Override
	public String deleteTicketTag(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteTicketTag(crno);
	}
	
	@Override
	public String updateTicketTagyMasterSave(String categorynameupdate, int cr_no,String updatedname,String tagforsave) {
		// TODO Auto-generated method stub
		return masterDao.updateTicketTagyMasterSave(categorynameupdate, cr_no, updatedname, tagforsave);
	}
	
	@Override
	public JSONArray getGroupForLoginMaster(String company) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getGroupForLoginMaster( company);
			
				return getProblemSubCategory2_dao_output;
	}
	
	
	@Override
	public JSONArray getCategoryDetailsList(String catname,String company) {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getCategoryDetailsList(catname,company);
	
		return getProblemCategoryDetailsList_dao_output;
	}

	@Override
	public JSONArray getSubCategory1(String company,String category,String subcat1) {
		
				JSONArray getProblemSubCategory1_dao_output = masterDao.getSubCategory1(company,category,subcat1);
				
				return getProblemSubCategory1_dao_output;
	}


	@Override
	public JSONArray getSubCategory2(String company,String category,String subcategory1,String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubCategory2(company,category,subcategory1,subcat2);
				
				return getProblemSubCategory2_dao_output;
	}

	@Override
	public JSONArray getSubCategory1forcatalogue(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubCategory1forcatalogue(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	

	@Override
	public JSONArray getCategoryDetailsListforcatalogue(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getCategoryDetailsListforcatalogue(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	

	@Override
	public JSONArray getSubCategory2forcatalogue(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubCategory2forcatalogue(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	

	@Override
	public JSONArray getSubjectforcatforcatalogu(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubjectforcatforcatalogu(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	

	@Override
	public JSONArray getSeverityNameforcatalogue(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSeverityNameforcatalogue(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	

	@Override
	public JSONArray getPriorityNameforcatalogue(String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getPriorityNameforcatalogue(subcat2);
				
				return getProblemSubCategory2_dao_output;
	}
	
	


	
	
	@Override
	public JSONArray CategoryListing(String problemCatList) {
		
		JSONArray ProblemCategoryListing_dao_output = masterDao.CategoryListing(problemCatList);
		
		return ProblemCategoryListing_dao_output;
	}
	
	@Override
	public String addNewCategory(String company, String category, String subcategory1, String subcategory2,String priority,String severity) {
		return masterDao.addNewCategory(company,category,subcategory1,subcategory2,priority,severity);
	}

	@Override
	public String deleteCategoryFromMaster(int crno) {
		return masterDao.deleteCategoryFromMaster(crno);
	}
	public JSONArray getOutageCompanyName(String companyname) {
		JSONArray getOutageCompanyName_dao_output = masterDao.getOutageCompanyName(companyname);
		
		return getOutageCompanyName_dao_output;
	}
	
	public JSONArray getOutageBranchName(String companyname) {
		JSONArray getOutageBranchName_dao_output = masterDao.getOutageBranchName(companyname);
		
		return getOutageBranchName_dao_output;
	}

	@Override
	public JSONArray getOutageDepartmentName(String companyname, String branchName) {
		JSONArray getOutageDepartmentName_dao_output = masterDao.getOutageDepartmentName(companyname, branchName);
		
		return getOutageDepartmentName_dao_output;
	}

	@Override
	public JSONArray getSeverityName(String companyname) {
		JSONArray SeverityName_dao_output = masterDao.getSeverityName(companyname);
		return SeverityName_dao_output;
	}

	@Override
	public JSONArray getINCPriorityAndSeverityName(String Category, String subcat1name, String subcat2name, String companyname) {
		JSONArray getINCPriorityAndSeverityName_dao_output = masterDao.getINCPriorityAndSeverityName(Category,subcat1name,subcat2name,companyname);
		return getINCPriorityAndSeverityName_dao_output;
	}
	@Override
	public JSONArray getCompositecompanyDetails() {
	System.out.println("Inside getDeptDetails ");
		
		String controller_response = null;
	

		
		JSONArray comp_dao_output = masterDao.getCompositecompanyNames();
		System.out.println("From Service_IMPL_output response " + comp_dao_output);
		return comp_dao_output;
		

//		return controller_response;
	}
	
	
	@Override
	public JSONArray getprojectsuitList() {

		JSONArray getprojectsuitList = masterDao.getprojectsuitList();
		
		return getprojectsuitList;
	}
	
	@Override
	public JSONArray getprojectsuitListupd() {

		JSONArray getprojectsuitList = masterDao.getprojectsuitListupd();
		
		return getprojectsuitList;
	}

	@Override
	public JSONArray getprojectListupd() {

		JSONArray getprojectList = masterDao.getprojectListupd();
		
		return getprojectList;
	}
	@Override
	public JSONArray getprojectList() {

		JSONArray getprojectList = masterDao.getprojectList();
		
		return getprojectList;
	}
	@Override
	public JSONArray SeverityDetails(String userlist) {
		
		System.out.println("PriorityDetails" + userlist);
		return masterDao.SeverityDetails(userlist);
	}

	
	@Override
	public String addSeverity(String company, String Severity) {
		
		return masterDao.addSeverity(company, Severity);
				
	}
	

	
	@Override
	public String updateSeverityMasterSave(String companyName, String Severitynameupdate, int cr_no) {
		
		return masterDao.updateSeverityMasterSave(companyName, Severitynameupdate, cr_no);
				
	}

	@Override
	public String DeleteSeverity(int crno) {
		
		return masterDao.DeleteSeverity(crno);
	}

	@Override
	public JSONArray getSubject(String subject) {
		JSONArray getSubject_dao_output = masterDao.getSubject(subject);
		return getSubject_dao_output;
	}

	@Override
	public String addNewSubject(String company, String category, String subcategory1, String subcategory2,
			String subject) {
		return masterDao.addNewSubject(company,category,subcategory1,subcategory2,subject);
	}

	@Override
	public JSONArray SubjectListing(String subjectList) {
		JSONArray SubjectListing_dao_output = masterDao.SubjectListing(subjectList);
		return SubjectListing_dao_output;
	}

	@Override
	public String deleteSubject(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteSubject(crno);
	}

	@Override
	public JSONArray getINCSubject(String company, String Category, String subcat1name, String subcat2name) {
		JSONArray getINCSubject_dao_output = masterDao.getINCSubject(company,Category,subcat1name,subcat2name);
		return getINCSubject_dao_output;
	}

	@Override
	public String addNewServiceCatalogue(String company, String category, String subcategory1, String subcategory2,
			String subject, String priority, String severity, String servicerequesttype, String group_name, String approval_level, String designationlevel1, String designationlevel2,String requestcost,String SUBJECT_TYPE) {
		return masterDao.addNewServiceCatalogue(company,category,subcategory1,subcategory2,subject,priority,severity,  servicerequesttype,  group_name,  approval_level,  designationlevel1,  designationlevel2,requestcost,SUBJECT_TYPE);
	}
	@Override
	public JSONArray ServiceCatalogueListing(String subjectList) {
		JSONArray ServiceCatalogueListing_dao_output = masterDao.ServiceCatalogueListing(subjectList);
		return ServiceCatalogueListing_dao_output;
	}

	@Override
	public String deleteServiceCatalogue(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteServiceCatalogue(crno);
	}

	@Override
	public JSONArray getServiceCatalogueSubject(String subject,String company) {
		JSONArray getServiceCatalogueSubject_dao_output = masterDao.getServiceCatalogueSubject(subject,company);
		return getServiceCatalogueSubject_dao_output;
	}

	@Override
	public JSONArray getSelectedServiceCatalogueData(String subject, String company) {
		JSONArray getSelectedServiceCatalogueData_dao_output = masterDao.getSelectedServiceCatalogueData(subject,company);
		return getSelectedServiceCatalogueData_dao_output;
	}

	 @Override
	  public String addTemplate(String templates, String companies,String attributename) {
	    return masterDao.addTemplate(templates, companies,attributename);
	  }
	  
  
  @Override
  public JSONArray getTemplateDetails(String userlist) {
    return masterDao.getTemplateDetails(userlist);
  }
  
  @Override
  public JSONArray DesignationMasterListing(String designationList) {
    return masterDao.DesignationMasterListing(designationList);
  }
  
  @Override
  public String AddModule(String designation) {
    return masterDao.AddModule( designation);
  }
  
  @Override
	public JSONArray getModuleList() {
		return masterDao.getModuleNames();
	}
  @Override
  public String updateDesignationup(String company, String designation, int srno) {
    return masterDao.updateDesignationup(company, designation,srno);
  }
  @Override
	public JSONArray getModuleNameup() {
		return masterDao.getModuleNameup();
	}
  @Override
	public String setFunctionDetails(String moduleName, String functionName) {
		return masterDao.setFunctionModule(moduleName, functionName);
	}
  @Override
  public JSONArray funclist(String designationList) {
    return masterDao.funclist(designationList);
  }
  @Override
  public String Deletemodule(int srno) {
    return masterDao.Deletemodule(srno);
  }
  @Override
  public String Updateresponsibiity(String company,String designation, int srno,String roletype,String module,String function,String checker) {
    return masterDao.Updateresponsibiity(company,designation,srno,roletype,module,function,checker);
  }
  @Override
	public JSONArray getresp1() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getresp1();
		
		return getProblemCategoryDetailsList_dao_output;
	}
  @Override
  public String Deleteresp(int srno) {
    return masterDao.Deleteresp(srno);
  }
  
  @Override
 	public JSONArray getresp1up() {

 		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getresp1up();
 		
 		return getProblemCategoryDetailsList_dao_output;
 	}
  @Override
	public JSONArray getresp2up() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getresp2up();
		
		return getProblemCategoryDetailsList_dao_output;
	}
  @Override
  public String Deletetandc(int srno) {
    return masterDao.Deletetandc(srno);
  }
  @Override
  public JSONArray tandcMasterListing(String designationList) {
    return masterDao.tandcMasterListing(designationList);
  }
  @Override
  public String Addtandc(String tctype,String comments,String ddrname1) {
    return masterDao.Addtandc(tctype,comments,ddrname1);
  }
  @Override
 	public JSONArray getresp() {

 		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getresp();
 		
 		return getProblemCategoryDetailsList_dao_output;
 	}
  
  @Override
	public JSONArray getresp2() {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getresp2();
		
		return getProblemCategoryDetailsList_dao_output;
	}
  @Override
  public String UpdateModule(String designation, int srno) {
    return masterDao.UpdateModule(designation,srno);
  }
  @Override
  public String addDesignation(String company, String designation,String roletype,String module,String function,String checker) {
    return masterDao.addDesignation(company, designation,roletype,module,function,checker);
  }
  @Override
  public String updateDesignation(String company, String designation, int srno) {
    return masterDao.updateDesignation(company, designation,srno);
  }
  
  @Override
  public String deleteDesignation(int srno) {
    return masterDao.deleteDesignation(srno);
  }
  
  @Override
  public JSONArray getCompanyDesignation(String company) {
    return masterDao.getCompanyDesignation(company);
  }
  
  @Override
  public JSONArray getServiceRequestFlowListing(String requestFlowList) {
    return masterDao.getServiceRequestFlowListing(requestFlowList);
  }
  
  @Override
  public String addServiceRequestFlow(String company, String designation, String requestName, String approverName, String department) {
    return masterDao.addServiceRequestFlow(company, designation, requestName, approverName, department);
  }
  @Override
  public String updateServiceRequestFlow(int srno, String company, String designation, String requestName, String approverName, String department) {
    return masterDao.updateServiceRequestFlow(srno,company,designation,requestName,approverName,department);
  }
  @Override
  public String deleteServiceRequestFlow(int srno) {
    return masterDao.deleteServiceRequestFlow(srno);
  }
  
  @Override
  public JSONArray getApproverDetails(String company, String designation) {
    return masterDao.getApproverDetails(company, designation);
  }
  @Override
 	public String SaveCategory(String category, String subcategory1, String subcategory2 ,String priorityname, String severityname) {
 		String Category_Dao_Output = masterDao.SaveCategory(category,subcategory1,subcategory2 ,priorityname,severityname);
 		System.out.println("From Service_IMPL_output response " + Category_Dao_Output);
 		return Category_Dao_Output;
 	}


	@Override
	public JSONArray getTemplateCategoryList(String catname) {
		JSONArray Template_list = masterDao.getTemplateCategoryList(catname);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}
//	@Override
//	public JSONArray getTemplateSubCategoryList(String subcategory) {
//		JSONArray Template_list = masterDao.getTemplateSubCategoryList(subcategory);
//		System.out.println("From Service_IMPL_output response " + Template_list);
//		return Template_list;
//	}

	@Override
	public JSONArray TemplateCategoryListing(String templisting) {
		JSONArray Template_list = masterDao.TemplateCategoryListing(templisting);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}

	@Override
	public String deleteTemplateCategory(int crno) {
		return masterDao.deleteTemplateCategory(crno);
	}
	@Override
	public String adintegtestlist(String company) {
		System.out.println("company name" + company);
		String CompanyName_dao_output = masterDao.adintegtestlist(company);
		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
	}
	@Override
	public JSONArray getCompanyNames1(String company) {
		System.out.println("company name" + company);
		JSONArray CompanyName_dao_output = masterDao.getCompanyNames1(company);
		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
	}
	@Override
	public JSONArray getPriorityList(String company) {
		System.out.println("company name in prioritylist" + company);
		JSONArray CompanyName_dao_output = masterDao.getPriorityList(company);
		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
		
	}
	@Override
	public JSONArray getCategoryList(String company) {
		System.out.println("Category name getCategoryList" + company);
		JSONArray CompanyName_dao_output = masterDao.getCategoryList(company);
		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
	}
	@Override
	public JSONArray getCompanyNamesinEmail(String company) {
		System.out.println("company name" + company);
		JSONArray CompanyName_dao_output = masterDao.getCompanyNamesinEmail(company);
		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
	}
	@Override
	public String addPrioritytemplate(String Attribute1, String Templatedeatil) {
		return masterDao.addPrioritytemplate(Attribute1, Templatedeatil);
	}

	@Override
	public JSONArray prioritytemplatelist(String userlist) {
		
	System.out.println("Inside prioritytemplatelist ");
		
		System.out.println("prioritytemplatelist" + userlist);
		JSONArray CompanyDetails_dao_output = masterDao.prioritytemplatelist(userlist);
		System.out.println("From Service_IMPL_output response " + CompanyDetails_dao_output);
		return CompanyDetails_dao_output;
	}

	@Override
	public String deleteprioritytemplate(int crno) {
		return masterDao.deleteprioritytemplate(crno);
	}

	@Override
	public JSONArray updatePriorityTemplate(int cr_no) {
		return masterDao.updatePriorityTemplate(cr_no);
	}

	@Override
	public String updatepprioritytemplateSave(String companynameupdate, String companyemailupdate, int cr_no) {
		return masterDao.updatepprioritytemplateSave(companynameupdate, companyemailupdate, cr_no);
	}
	//16102021
	@Override
	public String Saveslapercentage(String company, String percentage) {
		
		return masterDao.Saveslapercentage( company,percentage);
				
	}

	@Override
	public JSONArray getSlaListing(String userlist) {
		
		System.out.println("getSlaListing" + userlist);
		JSONArray getSlaListing_dao_output = masterDao.getSlaListing(userlist);
		System.out.println("From Service_IMPL_output response " + getSlaListing_dao_output);
		return getSlaListing_dao_output;
	}
	@Override
	public String DeleteSlaTemplate(int crno) {
		
		return masterDao.DeleteSlaTemplate(crno);
	}

	@Override
	public String updateSlaTemplateMaster(int srno,String company, String percentage) {
		
		return masterDao.updateSlaTemplateMaster(srno,company,percentage);
	}
	@Override
	public JSONArray getTemplateCategoryList1(String subcat1) {
		JSONArray Template_list = masterDao.getTemplateCategoryList1(subcat1);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}
	@Override
	public JSONArray getTemplateSubCategoryList2(String subcat1) {
		JSONArray Template_list = masterDao.getTemplateSubCategoryList2(subcat1);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}
	@Override
	public String DeleteList(String company) {
		return masterDao.DeleteList(company);
	}	
	@Override
	public String UpdateAdIntegration(String company, String username, String password, String host, int port_no,
			String dName) {
		String AdIntegrationList = masterDao.UpdateAdIntegration(company,username,password,host,port_no,dName);
		return AdIntegrationList;
	}
	@Override
	public JSONArray CompanyCodeListing() {
		
		return masterDao.CompanyCodeListing();
	}
	@Override
	public String addCompanyCode(String company, String companycode) {
		
		return masterDao.addCompanyCode(company, companycode);
	}
	@Override
	public String updateCompanyCode(String company,String companycode,int srno) {
		return masterDao.updateCompanyCode(company, companycode, srno);
	}
	@Override
	public String deleteCompanyCode(int crno) {
		// TODO Auto-generated method stub
		return masterDao.deleteCompanyCode(crno);
	}
	@Override
	public JSONArray getSelfHelpList() {
		return masterDao.getSelfHelpList();
	}
	
	@Override
	public JSONArray getSelfHelpScopeList() {
		return masterDao.getSelfHelpScopeList();
	}

	@Override
	public String addSelfHelpMaster(String company, String branch, String department, String name, String description,
			String category, String platform, MultipartFile empPic) {
		return masterDao.addSelfHelpMaster(company, branch, department, name, description,category, platform, empPic);
	}
	
	@Override
	public String updateSelfHelpMaster(int srno, String company, String branch, String department, String name,
			String description, String category, String platform, MultipartFile empPic) {
		return masterDao.updateSelfHelpMaster(srno,company, branch, department, name, description,category, platform, empPic);
	}

	@Override
	public JSONArray gatherSelfHelpDetails(String selfhelpid) {
		return masterDao.gatherSelfHelpDetails(selfhelpid);
	}
	
	@Override
	public void updateSelfHelpDownloadCounter(String selfhelpid) {
		masterDao.updateSelfHelpDownloadCounter(selfhelpid);
	}
	
	@Override
	public JSONArray getSelfHelpCategory() {
		return masterDao.getSelfHelpCategory();
	}

	@Override
	public JSONArray getSelfHelpPlatform() {
		return masterDao.getSelfHelpPlatform();
	}
	
	@Override
	public JSONArray getTemplatePriorityList1(String subcat1) {
		JSONArray Template_list = masterDao.getTemplatePriorityList1(subcat1);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}
	@Override
	public JSONArray getTemplateSeverityList1(String severity) {
		JSONArray Template_list = masterDao.getTemplateSeverityList1(severity);
		System.out.println("From Service_IMPL_output response " + Template_list);
		return Template_list;
	}
	
	@Override
	public String Updatecategory(String Categoryupdate, String Subcategory1update, int srno, String Subcategory2update,
			String Priorityupdate, String Severityupdate) {
		
		return masterDao.Updatecategory(Categoryupdate, Subcategory1update, srno,Subcategory2update,Priorityupdate,Severityupdate);
	}

	@Override
	public String Updatecategorytemplate(String Categoryupdate, String Subcategory1update, int srno,
			String Subcategory2update, String Priorityupdate, String Severityupdate,String Companyupdate) {
		
		return masterDao.Updatecategorytemplate(Categoryupdate, Subcategory1update, srno,Subcategory2update,Priorityupdate,Severityupdate,Companyupdate);
	}
	
	@Override
	public String addgroup(String group, String company) {
		
		return masterDao.addgroup(group, company);
				
	}
	
	@Override
	public JSONArray getgroupList(String userlist) {
		
		System.out.println("getgroupList" + userlist);
		JSONArray PriorityDetails_dao_output = masterDao.getgroupList(userlist);
		System.out.println("From Service_IMPL_output response " + PriorityDetails_dao_output);
		return PriorityDetails_dao_output;
	}
	
	@Override
	public String updategroupMasterSave(String companyName, String prioritynameupdate, int cr_no) {
		
		return masterDao.updategroupMasterSave(companyName, prioritynameupdate, cr_no);
				
	}

	@Override
	public String Deletegroup(int crno) {
		
		return masterDao.Deletegroup(crno);
	}
	@Override	
	public JSONArray getGropupfromgroupmaster(String company) {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getGropupfromgroupmaster(company);
		
		return getProblemCategoryDetailsList_dao_output;
	}

	@Override
	public JSONArray getusernamebasisondesignation(String designation1, String company) {
		JSONArray getServiceCatalogueSubject_dao_output = masterDao.getusernamebasisondesignation(designation1,company);
		return getServiceCatalogueSubject_dao_output;
	
	}
	@Override
	public JSONArray getCategoryDetailsForAutoAssign(String company) {
//		System.out.println("Category name getCategoryList" + company);
		JSONArray CompanyName_dao_output = masterDao.getCategoryDetailsForAutoAssign(company);
//		System.out.println("From Service_IMPL_output response " + CompanyName_dao_output);
		return CompanyName_dao_output;
	}

	@Override
	public JSONArray getUserNamesOnDesignation(String company, String designation) {
		JSONArray getUserNamesOnDesignation_dao_output = masterDao.getUserNamesOnDesignation(company,designation);
		return getUserNamesOnDesignation_dao_output;
	}
	
	public JSONArray ViewAutoAssignTicket(String userlist)
    {
	System.out.println("Inside addUserDetails ");
	System.out.println("addUserDetails" + userlist);
	JSONArray adduserlist_dao_output = masterDao.ViewAutoAssignTicket(userlist);
	System.out.println("From Service_IMPL_output response " + adduserlist_dao_output);
	return adduserlist_dao_output;
	
}
	
	
	
	@Override
	public JSONArray getCompany() {
		
		JSONArray UserNameValues_dao_output = masterDao.getCompany();
//		System.out.println("From Service_IMPL_output response " + UserNameValues_dao_output);
		return UserNameValues_dao_output;
	}

	@Override
	public JSONArray getDepartment(String company, String branchname) {
		
		JSONArray UserNameValues_dao_output = masterDao.getDepartment(company,branchname);
		System.out.println("From Service_IMPL_output response " + UserNameValues_dao_output);
		return UserNameValues_dao_output;
		
	}
	
	


	@Override
	public JSONArray getCategoryDetailsforreport(String company) {
		
		JSONArray UserNameValues_dao_output = masterDao.getCategoryDetailsforreport(company);
		System.out.println("From Service_IMPL_output response " + UserNameValues_dao_output);
		return UserNameValues_dao_output;
		
	}
	@Override
	public String updateCompositeMaster(int srNo,String category, String subcategory1, String subcategory2,String department,String subDepartment) {
		return masterDao.updateCompositeMaster(srNo,category,subcategory1,subcategory2,department,subDepartment);
	}
	
	@Override
	public String getUserBulkUploadFile() {

		return masterDao.getUserBulkUploadFile();
	}

	@Override
	public String saveBulkUploadUserData(MultipartFile bulkUserData) {

		return masterDao.saveBulkUploadUserData(bulkUserData);
	}
	@Override
	public String updateSubjectMaster(int srNo, String company, String category, String subcategory1,
			String subcategory2, String subject) {
		
	return masterDao.updateSubjectMaster(srNo,company,category,subcategory1,subcategory2,subject);
	
	}

	@Override
	public String deleteAutoCloseTicket(int srNo) {
		return masterDao.deleteAutoCloseTicket(srNo);
	}

	@Override
	public JSONArray getAllPriorityMaster() {
		// TODO Auto-generated method stub
		return masterDao.getAllPriorityMaster();
	}

	@Override
	public JSONArray getAllSeverityMaster() {
		// TODO Auto-generated method stub
		return masterDao.getAllSeverityMaster();
	}
	@Override
	public String updateServiceCatalogue(String company, String category, String subcategory1, String subcategory2,
			String subject, String priority, String severity, String servicerequesttype, String group_name,
			String approval_level, String designationlevel1, String designationlevel2, String requestcost,String subjecttype,int srno) {
		return masterDao.updateServiceCatalogue(company,category,subcategory1,subcategory2,subject,priority,severity,  servicerequesttype,  group_name,  approval_level,  designationlevel1,  designationlevel2,requestcost,subjecttype,srno);
	}
	
	@Override
	public JSONArray getINCSubjectFORuser(String company)	{
		JSONArray getINCSubject_dao_output = masterDao.getINCSubjectFORuser(company);
		return getINCSubject_dao_output;
	}
	
	@Override
	public JSONArray getCategoryDetailsListForsubjecmaster(String catname,String company) {

		JSONArray getProblemCategoryDetailsList_dao_output = masterDao.getCategoryDetailsListForsubjecmaster(catname,company);
	
		return getProblemCategoryDetailsList_dao_output;
	}
	
	
	@Override
	public JSONArray getSubCategory1Forsubjecmaster(String company,String category,String subcat1) {
		
				JSONArray getProblemSubCategory1_dao_output = masterDao.getSubCategory1Forsubjecmaster(company,category,subcat1);
				
				return getProblemSubCategory1_dao_output;
	}
	
	
	


	@Override
	public JSONArray getSubCategory2Forsubjecmaster(String company,String category,String subcategory1,String subcat2) {
		
				JSONArray getProblemSubCategory2_dao_output = masterDao.getSubCategory2Forsubjecmaster(company,category,subcategory1,subcat2);
				
				return getProblemSubCategory2_dao_output;
	}

	@Override
	public JSONArray getRequestModeForRaiseOnBehalf(String company, String reqmode) {
		JSONArray getRequestModeForRaiseOnBehalf = masterDao.getRequestModeForRaiseOnBehalf(company,reqmode);
		
		return getRequestModeForRaiseOnBehalf;
	}

	@Override
	public String Deletemaiconfig(int crno) {
	String   getRequestModeForRaiseOnBehalf= masterDao.Deletemaiconfig(crno);
		
		return getRequestModeForRaiseOnBehalf;
	}

	@Override
	public JSONArray getGroupForLoginMasterAll() {
		
		return masterDao.getGroupForLoginMasterAll();
	}

	@Override
	public JSONArray getGroupForPerticularUserforticket(String username, String company1) {
		
		JSONArray getProblemSubCategory2_dao_output = masterDao.getGroupForPerticularUserforticket( username,company1);
		
		return getProblemSubCategory2_dao_output;
}

	@Override
	public JSONArray getCategoryDetailsforuScop2(String catname) {
		JSONArray category_dao_output = masterDao.getCategoryDetailsforuScop2(catname);
		System.out.println("From Service_IMPL_output response " + category_dao_output);
		return category_dao_output;
	}
public String AddMailTemp(String st,String subject,String mailbody, String company, String emailTrigger, String ticketType,String mailfooter)
	
	{
		System.out.println("Inside getCompanyDetails ");
		
		String controller_response = null;
	

		
		String company_dao_output = masterDao.AddMailTemp( st, subject, mailbody,company,emailTrigger,ticketType,mailfooter);
		System.out.println("From Service_IMPL_output response " + company_dao_output);
		return company_dao_output;
		

//		return controller_response;
	}


@Override
public JSONArray getStatusFormail() {
	JSONArray getProblemSubCategory2_dao_output = masterDao.getStatusFormail();
	
	return getProblemSubCategory2_dao_output;
}

@Override
public String updatemailtemplate(String srno,String st, String subject, String mailbody, String company, String emailTrigger,
		String ticketType,String mailfooter) {
	
	return masterDao.updatemailtemplate( srno,st, subject, mailbody,company,emailTrigger,ticketType,mailfooter);
	
	 

}

@Override
public JSONArray getFooterForUpdate(String srno) {
	return masterDao.getFooterForUpdate(srno);
}

@Override
public String DeleteEmailServerIntegration(String crno) {
	return masterDao.DeleteEmailServerIntegration(crno);
}

@Override
public String updateEmailServerIntegration(String company, String mail, String subject, String folder, String port,
		String uname, String pass,int crno,String starttlsup) {

	return masterDao.updateEmailServerIntegration(company,mail,subject,folder,port,uname,pass,crno,starttlsup);
}

@Override
public JSONArray getBranchForLoginMastersInsert(String company,String location) {
	return masterDao.getBranchForLoginMastersInsert(company,location);
}

@Override
public JSONArray getUserList(String userlist) {
	return masterDao.getUserList( userlist);
}
@Override
public String updateUserList(String mail, String cno, String user, String pass, String fname, String lname,
		String cpass, String cname, String sname, String dname, String category, int cr_no, String englevel,String rtypeupdate,String row,String subdnameupdate,String vipLogin,String updatecategory,String updategroup, String designation,String visibilityupdate) {

	return masterDao.updateUserList(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname, category, cr_no, englevel, rtypeupdate,row, subdnameupdate, vipLogin,updatecategory,updategroup,designation,visibilityupdate);
}


@Override
public JSONArray GetLocationForReport(String companyis) {
	
	return masterDao.GetLocationForReport(companyis);
}

@Override
public JSONArray GetUsersListForReportTp(String companyis, String locationis) {
	return masterDao.GetUsersListForReportTp(companyis,locationis);
}

@Override
public JSONArray getSLACalendarData(String companyname) {
	return masterDao.getSLACalendarData(companyname);
}

@Override
public String insertSLACalendarData(String companyname, String eventname, String eventdescription,
		String eventdate) {
	return masterDao.insertSLACalendarData(companyname,eventname,eventdescription,eventdate);
}

@Override
public String updateSLACalendarData(String companyname, String eventname, String eventdescription, String eventdate) {
	
	return masterDao.updateSLACalendarData(companyname,eventname,eventdescription,eventdate);
}

@Override
public String deleteSLACalendarData(String companyname, String eventname, String eventdescription, String eventdate) {

	return masterDao.deleteSLACalendarData(companyname,eventname,eventdescription,eventdate);
}

@Override
public JSONArray getSLAWeekScheduleData(String companyname) {

	return masterDao.getSLAWeekScheduleData(companyname);
}

@Override
public String insertUpdateSLAWeekScheduleData(String companyname, String finalArray) {
	
	return masterDao.insertUpdateSLAWeekScheduleData(companyname, finalArray);
}

@Override
public JSONArray getCompanyForReportInAdmin() {
	return masterDao.getCompanyForReportInAdmin();
}

@Override
public JSONArray getGroupForReport(String compname) {

	return masterDao.getGroupForReport(compname);
}

@Override
public JSONArray GetUserNameList(String vendorname, String groupName) {
	return masterDao.GetUserNameList(vendorname,groupName);
}

@Override
public JSONArray gettidForServiceRequest(String cname, String fromdate, String todate) {
	return masterDao.gettidForServiceRequest(cname,  fromdate,  todate);
}

@Override
public JSONArray GetGroupsForReport(String companyis) {
	// TODO Auto-generated method stub
	return masterDao.GetGroupsForReport(companyis);
}
@Override
public JSONArray getProblemTicketId(String cname, String fromdate, String todate) {
	return masterDao.getProblemTicketId(cname,fromdate,todate);
}

@Override
public JSONArray getAssetFromOfLoginUser(String loginuser) {
	// TODO Auto-generated method stub
	return masterDao.getAssetFromOfLoginUser(loginuser);
}

@Override
public JSONArray getsyncloglisting(String userlist) {
	// TODO Auto-generated method stub
	JSONArray adddetailsListing_dao_output = masterDao.getsyncloglisting(userlist);
return adddetailsListing_dao_output;
}

@Override
public String updatelogsync(String userlist) {
	
	return masterDao.updatelogsync(userlist);
}

@Override
public JSONArray getServiceCatalogueSubjectByType(String subjectType, String company) {
	// TODO Auto-generated method stub
	return masterDao.getServiceCatalogueSubjectByType( subjectType, company);
}


public String AddEFormMailTemp(String st,String subject,String mailbody, String company, String emailTrigger, String ticketType,String mailfooter)

{
	System.out.println("Inside getCompanyDetails ");
	
	String controller_response = null;


	
	String company_dao_output = masterDao.AddEFormMailTemp( st, subject, mailbody,company,emailTrigger,ticketType,mailfooter);
	System.out.println("From Service_IMPL_output response " + company_dao_output);
	return company_dao_output;
	

//	return controller_response;
}


@Override
public JSONArray AddEformMailListing(String userlist) {
System.out.println("Inside AddEformMailListing ");
	
	System.out.println("AddEformMailListing" + userlist);
	JSONArray AddMailListing_dao_output = masterDao.AddEformMailListing(userlist);
	System.out.println("From Service_IMPL_output response " + AddMailListing_dao_output);
	return AddMailListing_dao_output;
}

@Override
public String updatEformemailtemplate(String srno, String st, String subject, String mailbody, String company,
		String emailTrigger, String ticketType, String mailfooter) {
	// TODO Auto-generated method stub
	return masterDao.updatEformemailtemplate(srno,st,subject,mailbody,company,emailTrigger,ticketType,mailfooter);
}

@Override
public String DeleteEformmaiconfig(int crno) {
	// TODO Auto-generated method stub
	return masterDao.DeleteEformmaiconfig(crno);
}

@Override
public JSONArray getEmailFooterForUpdate(String srno) {
	// TODO Auto-generated method stub
	return masterDao.getEmailFooterForUpdate(srno);
}
@Override
public JSONArray getPID() {
	return masterDao.getPID();
	}

@Override
public JSONArray ApprovalGroup(String pid) {
	return masterDao.ApprovalGroup(pid);
}

@Override
public JSONArray getUserSelectedDetails(String approvalname,String fullName) {
	// TODO Auto-generated method stub
	return masterDao.getUserSelectedDetails(approvalname,fullName);
}

@Override
public JSONArray getProejctDetails(String pid) {
	// TODO Auto-generated method stub
	return masterDao.getProejctDetails(pid);
}

@Override
public JSONArray getProjectDetailsById(String pid) {
	return masterDao.getProjectDetailsById(pid);
}

@Override
public JSONArray getItGroupUser() {
	// TODO Auto-generated method stub
	return masterDao.getItGroupUser();
}
@Override
public String SaveSoftwareDetails(String sname, String productcode, String fromdate, String checkbox, Float scost,
		String rperiod) {
	return masterDao.SaveSoftwareDetails(sname,productcode,fromdate,checkbox,scost,rperiod);
}

@Override
public JSONArray getSoftwareDetailsInEform() {
	// TODO Auto-generated method stub
	return masterDao.getSoftwareDetailsInEform();
}

@Override
public String DeleteSoftwares(int crno) {
	return masterDao.DeleteSoftwares(crno);
}

@Override
public String UpdateSoftwareDetails(String sname, String productcode, String fromdate, String checkbox, String scost,
		String rperiod,int srno) {
	return masterDao.UpdateSoftwareDetails(sname,productcode,fromdate,checkbox,scost,rperiod,srno);
}

//business ID request
@Override
public JSONArray getBusinessUserSelectedDetails(String approvalname) {
	// TODO Auto-generated method stub
	return masterDao.getBusinessUserSelectedDetails(approvalname);
}

@Override
public JSONArray getScopeBasedCategory() {
	// TODO Auto-generated method stub
	return masterDao.getScopeBasedCategory();
}

@Override
public String getcompositeBulkUploadFile() {
	// TODO Auto-generated method stub
	return masterDao.getcompositeBulkUploadFile();
}

@Override
public String saveBulkUploadcomposite(MultipartFile bulkUserData) {
	// TODO Auto-generated method stub
	return masterDao.saveBulkUploadcomposite(bulkUserData);
}




@Override
public String ProductMaster(String productsuit, String productname, String unit,String ImplementerName)
{
	return masterDao.ProductMaster(productsuit,productname,unit,ImplementerName);
}

@Override
public String AddProductsuit(String productsuit)
{
	return masterDao.AddProductsuit(productsuit);
}
@Override
public JSONArray productmasterlisting(String subjectList) {
	
	return masterDao.productmasterlisting(subjectList);
}

@Override
public JSONArray productmasterlisting1(String subjectList) {
	
	return masterDao.productmasterlisting1(subjectList);
}

@Override
public String deleteProductMaster(int srno) {
	
	return  masterDao.deleteProductMaster(srno);
}

@Override
public String OtherCostMaster(String engType, String engineercost, String implementorCosttotal,
		String implemetationcost, String typepercentage, String costdata, String totalothercost) {
	// TODO Auto-generated method stub
	return  masterDao.deleteProductMaster(engType,engineercost,implementorCosttotal,implemetationcost,typepercentage,costdata,totalothercost);
}

@Override
public JSONArray otherocstmasterlisting(String subjectList) {
	// TODO Auto-generated method stub
	return  masterDao.otherocstmasterlisting(subjectList);
}

@Override
public String deleteOthercosrmaster(int srno) {
	// TODO Auto-generated method stub
	return  masterDao.deleteOthercosrmaster(srno);
}

@Override
public String Updateothercost(String engType, String engineercost, String implementorCosttotal,
		String implemetationcost, String typepercentage, String costdata, String totalothercost, int srno) {
	
	return masterDao.Updateothercost(engType, engineercost, implementorCosttotal,implemetationcost,typepercentage,costdata,totalothercost,srno);
}

@Override
public String updateproductmaster(String productsuitupdate, String securitysolutionupdate, String unitdataupdate,
		int srno,String updImplementerName) {
	
	return masterDao.updateproductmaster(productsuitupdate,securitysolutionupdate,unitdataupdate,srno,updImplementerName);
}


@Override
public JSONArray form3datalisting(String subjectList) {
	// TODO Auto-generated method stub
	return masterDao.form3datalisting(subjectList);
}

@Override
public String deleteFORM3(int srno) {
	// TODO Auto-generated method stub
	return masterDao.deleteFORM3(srno);
}

@Override
public String updateform3(String dateupdate, String projeimplementornameupdate, String customernameupdate,
		String projectnameupdate, String descriptionupdate, String responsiblityupdate, String targetdateupdate,
		String deliverydateupdate, int srno) {
	// TODO Auto-generated method stub
	return masterDao.updateform3(dateupdate,projeimplementornameupdate,customernameupdate,projectnameupdate,descriptionupdate,responsiblityupdate,targetdateupdate,deliverydateupdate,srno);
}


@Override
public JSONArray getproducutsuitList() {
	// TODO Auto-generated method stub
	return  masterDao.getproducutsuitList();
}

@Override
public JSONArray getunitdataList() {
	// TODO Auto-generated method stub
	return  masterDao.getunitdataList();
}

@Override
public JSONArray getsecuritysolutionList(String productsuit) {
	// TODO Auto-generated method stub
	return  masterDao.getsecuritysolutionList(productsuit);
}


@Override
public JSONArray unitmasterlisting(String subjectList) {
	
	return masterDao.unitmasterlisting(subjectList);
}
@Override
public String Addunit(String productsuit)
{
	return masterDao.Addunit(productsuit);
}


@Override
public JSONArray securitytoollisting(String subjectList) {
	
	return masterDao.securitytoollisting(subjectList);
}

@Override
public String Addsecuritytool(String productsuit)
{
	return masterDao.Addsecuritytool(productsuit);
}

@Override
public JSONArray Compositemasterlist(String problemCatList) {
	
	JSONArray ProblemCategoryListing_dao_output = masterDao.Compositemasterlist(problemCatList);
	
	return ProblemCategoryListing_dao_output;
}

@Override
public String addpricemaster(String productsuit,String productname,String pricetype,String cloudtype,String apexmode,String capexmode,String prepectual,String subscriptiontype,String licentype,String amcprice,String amctotal)
{
	return masterDao.addpricemaster(productsuit,productname,pricetype,cloudtype,apexmode,capexmode,prepectual,subscriptiontype,licentype,amcprice,amctotal);
}
@Override
public String updateproductsuitmaster(String productsuitupdate,int srno) {
	
	return masterDao.updateproductsuitmaster(productsuitupdate,srno);
}

@Override
public String deleteProductsuitMaster(int srno) {
	
	return  masterDao.deleteProductsuitMaster(srno);
}

@Override
public String updatesectool(String productsuitupdate,int srno) {
	
	return masterDao.updatesectool(productsuitupdate,srno);
}

@Override
public String deletesectool(int srno) {
	
	return  masterDao.deletesectool(srno);
}


@Override
public String updateunitmaster(String productsuitupdate,int srno) {
	
	return masterDao.updateunitmaster(productsuitupdate,srno);
}

@Override
public String deleteunitMaster(int srno) {
	
	return  masterDao.deleteunitMaster(srno);
}
@Override
public String Updatetandcmaster(String company, String designation, int srno) {
  return masterDao.Updatetandcmaster(company, designation,srno);
}

@Override
public String veloxproposaldetails(String veloxdata, String poinitiator, String poinitiatorno, String firstApprovername,
		String firstapprovercontact, String secondApprovername, String secondapprovercontact, String clientname,
		String description, String totalpriceforallproduct, String deploysupport, String clouddeploycharges,
		String subtotalB, String subtotalAB,String uname,String resoucesamount , String ATC,String Proposaltype ,String Perpetualyear ,String Subscriptionyear,
		String Amcsecondyear,String Amcthirdyear,String Amcfourthyear,String Amcfiveyear,String secondyearsubscription,
		String thirdyearsubscription,String fullPathVlxLogo,String fullPathVlxEnd,String fullPathSwachBharat,
		String IntegrationchargeYesNo,String IntegrationCharges,String Total_C,String GSTPERCENTAGE,String Grand_Total,String productsuitselect, String scanplusprodversion, String secureITprodversion,String enccustomername,String Letterhead,String signature,String fixedyear,
		String amcstartdate,String AMCmonthyear,String AMCMonth,String AMCYear,String amcenddate,String productsuitdetails,String securitysolutiondetails,
		String descforamc,String totalcostAMC,String GRANDTOTALFORAMC,String gstforamc,String gstdataforresource ,String grandtotalforresource,String subtotalAResource,String contactperson,String veloxdata1,String subscriptionANDperpetualYear ,String perpetualSubsAnnualperpType,String perpetualSubs3yearperpType,String deploysupport21 ,String clouddeploycharges21 , 
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21,String poreferenceno,String proposalFor, String partnerName ) {

	return masterDao.veloxproposaldetails(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,Subscriptionyear,
			Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription, fullPathVlxLogo, fullPathVlxEnd, fullPathSwachBharat,
			IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total, productsuitselect,  scanplusprodversion,  secureITprodversion,enccustomername, Letterhead, signature,fixedyear,
			amcstartdate,AMCmonthyear,AMCMonth,AMCYear,amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1, subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21 ,poreferenceno, proposalFor, partnerName);

}

@Override
public String ProjectnameMaster(String productsuit, String productname, String unit)
{
	return masterDao.ProjectnameMaster(productsuit,productname,unit);
}
@Override
public JSONArray projectmasterlist(String subjectList) {
	
	return masterDao.projectmasterlist(subjectList);
}

@Override
public String updateprojectmaster(String productsuitupdate, String securitysolutionupdate, String unitdataupdate,
		int srno) {
	
	return masterDao.updateprojectmaster(productsuitupdate,securitysolutionupdate,unitdataupdate,srno);
}

@Override
public String deleteProjectNameMaster(int srno) {
	
	return  masterDao.deleteProjectNameMaster(srno);
}


@Override
public String InsertForm3(String date, String projeimplementorname, String customername, String projectname,
		String serverAvail, String serverAvail_Responsibility, String server_startdate, String server_enddate,
		String installvlxlicenseate, String responsibilityvlxlicense, String startdatevlxlicense,
		String enddatevlxlicense, String uATTesting, String responsibilityuattesting,
		String startdateuattesting, String enddateuattesting, String productiongolive,
		String responsibilitygolive, String startdategolive, String enddategolive, String rollout,
		String responsibilityrollout, String startdaterollout, String enddaterollout, String demolive,
		String responsibilitydemo, String startdatedemo, String enddatedemo, String paymentterms,
		String responsibilitypaymentterms, String startdatepaymentterms, String enddatepaymentterms,
		String signoff, String responsibilitysignoff, String startdatesignoff, String enddatesignoff) {
	
	return  masterDao.InsertForm3(date,projeimplementorname,customername,projectname,serverAvail,serverAvail_Responsibility,server_startdate,server_enddate,installvlxlicenseate
			,responsibilityvlxlicense,startdatevlxlicense,enddatevlxlicense,uATTesting,responsibilityuattesting,startdateuattesting,enddateuattesting,productiongolive,
			responsibilitygolive,startdategolive,enddategolive,rollout,responsibilityrollout,startdaterollout,enddaterollout,demolive,responsibilitydemo,startdatedemo,enddatedemo,paymentterms,
			responsibilitypaymentterms,startdatepaymentterms,enddatepaymentterms,signoff,responsibilitysignoff,startdatesignoff,enddatesignoff);
}

public void setDataPDF() {}



@Override
public JSONArray getprodsuit() {
	
//  System.out.println("Inside getCustomerName ");
			
	//System.out.println("reqmode name" + reqmode);
	JSONArray RequestMode_dao_output = masterDao.getprodsuit();
	//System.out.println("From Service_IMPL_output response " + RequestMode_dao_output);
	return RequestMode_dao_output;
}


@Override
public JSONArray getlist(String crno,String uname,String tid) {
	
//  System.out.println("Inside getCustomerName ");
			
	//System.out.println("reqmode name" + reqmode);
	JSONArray RequestMode_dao_output = masterDao.getlist( crno, uname, tid);
	//System.out.println("From Service_IMPL_output response " + RequestMode_dao_output);
	return RequestMode_dao_output;
}

@Override
public JSONArray getsectool() {
	
//  System.out.println("Inside getCustomerName ");
			
	//System.out.println("reqmode name" + reqmode);
	JSONArray RequestMode_dao_output = masterDao.getsectool();
	//System.out.println("From Service_IMPL_output response " + RequestMode_dao_output);
	return RequestMode_dao_output;
}

@Override
public String addregistrationMaster(MultipartFile[] incocertificate, MultipartFile[] pancardfile,
		MultipartFile[] gstcertificate, MultipartFile[] msmed, MultipartFile[] cancelledcheque,
		MultipartFile[] turnovercertif, MultipartFile[] msmeddocument, String addrowdata, String categorytype,
		String distributorname, String partnername, String compname, String registerno, String address,
		String contact_personname, String mobno, String telpno, String md_Ceo_emailid, String sales_emailid,
		String support_email_id, String emailid_contact_person, String office_mailid, String city, String district,
		String state, String pincode, String country, String website, String panacno, String ownership,
		String scale_of_company, String gstin, String other_country, String dateofbussns, String currency, String year1,
		String year2, String year3, String rupees1, String rupees2, String rupees3, String gemportal_register,
		String msmedtype, String entrepreno, String ideclaration, String checker, String Authorizer,String uname,String company,String salesManager) {
	
	 return masterDao.addregistrationMaster(incocertificate,pancardfile,gstcertificate,msmed,cancelledcheque,turnovercertif,msmeddocument,
	addrowdata,categorytype,distributorname,partnername,compname,registerno,address,contact_personname,mobno,telpno,md_Ceo_emailid,sales_emailid,
	support_email_id,emailid_contact_person,office_mailid,city,district,state,pincode,country,website,panacno,ownership,
	scale_of_company,gstin,other_country,dateofbussns,currency,year1,year2,year3,rupees1,rupees2,rupees3,gemportal_register,
	msmedtype,entrepreno,ideclaration,checker,Authorizer, uname, company,salesManager);
}


@Override
public JSONArray getdistributorname() {
	
	return masterDao.getdistributorname();
}

@Override
public JSONArray getpartnername() {
	
	return  masterDao.getpartnername();
}

@Override
public JSONArray getcheckerName() {
	// TODO Auto-generated method stub
	return masterDao.getcheckerName();
}

@Override
public JSONArray getMakerName() {
	// TODO Auto-generated method stub
	return masterDao.getMakerName();
}

@Override
public JSONArray getproductnamelist(String selectedSuit) {
	// TODO Auto-generated method stub
	return masterDao.getproductnamelist(selectedSuit);
}

@Override
public JSONArray getproductsuitlist() {
	// TODO Auto-generated method stub
	return masterDao.getproductsuitlist();
}

@Override
public JSONArray getAuthorizername() {
	
	return masterDao.getAuthorizername();
}

@Override
public JSONArray getProposalName() {
	// TODO Auto-generated method stub
	return masterDao.getProposalName();
}
@Override
public String newCustomerDetails(String compname, String address, String city, String district, String pincode,
		String office_mailid)
{
	return masterDao.newCustomerDetails( compname,  address,  city,  district,  pincode,
			 office_mailid);
}


@Override
	public String setProposalMaster(String proposalName) {
		return masterDao.setProposalMaster(proposalName);
	}



@Override
public JSONArray getProposalIds(String proposaltype, String subscriptionyear,String perpetualyear,String fixedyear,String subscriptionANDperpetualYear) {
	// TODO Auto-generated method stub
	return masterDao.getProposalIds( proposaltype,  subscriptionyear, perpetualyear,fixedyear,subscriptionANDperpetualYear);
}
@Override
public JSONArray getProposalIdAttachment(String proposalids) {
	// TODO Auto-generated method stub
	return masterDao.getProposalIdAttachment( proposalids);
}


@Override
public JSONArray getimplementerList(String role) {
	// TODO Auto-generated method stub
	return masterDao.getimplementerList(role);
}

@Override
public JSONArray getAuthorizerNameAM() {
	// TODO Auto-generated method stub
	return masterDao.getAuthorizerNameAM();
}


@Override
public String RFsaveBulkUploadcomposite(MultipartFile bulkUserData) {
	// TODO Auto-generated method stub
	return masterDao.RFsaveBulkUploadcomposite(bulkUserData);
}

@Override
public String geRFtUserBulkUploadFile() {

	return masterDao.geRFtUserBulkUploadFile();
}

@Override
public String updateRegistrationMaster(MultipartFile[] incocertificate, MultipartFile[] pancardfile,
		MultipartFile[] gstcertificate, MultipartFile[] msmed, MultipartFile[] cancelledcheque,
		MultipartFile[] turnovercertif, MultipartFile[] msmeddocument, String addrowdata, String categorytype,
		String distributorname, String partnername, String compname, String registerno, String address,
		String contact_personname, String mobno, String telpno, String md_Ceo_emailid, String sales_emailid,
		String support_email_id, String emailid_contact_person, String office_mailid, String city, String district,
		String state, String pincode, String country, String website, String panacno, String ownership,
		String scale_of_company, String gstin, String other_country, String dateofbussns, String currency, String year1,
		String year2, String year3, String rupees1, String rupees2, String rupees3, String gemportal_register,
		String msmedtype, String entrepreno, String ideclaration, String checker, String Authorizer,String uname,String company,String salesManager,String tid,String msmedregester,MultipartFile[] commercialProp1,MultipartFile[] pucrhaseOrder1) {
	
	 return masterDao.updateRegistrationMaster(incocertificate,pancardfile,gstcertificate,msmed,cancelledcheque,turnovercertif,msmeddocument,
	addrowdata,categorytype,distributorname,partnername,compname,registerno,address,contact_personname,mobno,telpno,md_Ceo_emailid,sales_emailid,
	support_email_id,emailid_contact_person,office_mailid,city,district,state,pincode,country,website,panacno,ownership,
	scale_of_company,gstin,other_country,dateofbussns,currency,year1,year2,year3,rupees1,rupees2,rupees3,gemportal_register,
	msmedtype,entrepreno,ideclaration,checker,Authorizer, uname, company,salesManager, tid, msmedregester,commercialProp1,pucrhaseOrder1);
}

@Override
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
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21,String proposalFor, String partnerName){
	// TODO Auto-generated method stub
	

	return masterDao.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,proposalFor, partnerName );
}

@Override
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
		String IntegrationCharges21 ,String integrationcharge21 , String subtotalB21 , String totalc21 , String total18percentage21 , String grandtotal21 ,String resoucesamount21, String proposalFor, String partnerName){
	// TODO Auto-generated method stub
	

	return masterDao.commercialproposalUpdateDetailsMD(veloxdata,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,proposalFor, partnerName);
}


@Override
public JSONArray getProposalIdsforlist() {
	// TODO Auto-generated method stub
	return  masterDao.getProposalIdsforlist();
}

@Override
public JSONArray getsecuritysolutionListing() {
	// TODO Auto-generated method stub
	return  masterDao.getsecuritysolutionListing();
}

//06/06(Update)
@Override
public String veloxLicensedetails(String veloxdata, String sppliernamelicense, String clientname,
		String environmentKeyNo, String ponumber, String podate, String folderPath, String fullPathVlxLogo,
		String oEMAddress, String clientAddress, String endcostomername,String endCustomerEmail,String firstApprovername,String secondApprovername, String uname,String poID,String payment_recieved, String AMsignature,String licenseforname,String distributor, String partner1,String partner2, String submissionType, String licenseUploadfile) {
	
	 return masterDao.veloxLicensedetails(veloxdata,sppliernamelicense,clientname,environmentKeyNo,ponumber,podate,folderPath,fullPathVlxLogo,oEMAddress,clientAddress ,endcostomername, endCustomerEmail,firstApprovername, secondApprovername, uname,poID,payment_recieved, AMsignature,licenseforname,distributor, partner1,partner2, submissionType, licenseUploadfile);

}

@Override
public JSONArray getsecuritysolutionList2(String productsuit) {
	// TODO Auto-generated method stub
	return masterDao.getsecuritysolutionList2(productsuit);
}


@Override
public JSONArray getPOidList() {
	// TODO Auto-generated method stub
	return masterDao.getPOidList();
}

@Override
public JSONArray getPOidListData(String poID) {
	// TODO Auto-generated method stub
	return masterDao.getPOidListData(poID);
}

@Override
public JSONArray getAuthorizerNameBH() {
	// TODO Auto-generated method stub
	return masterDao.getAuthorizerNameBH();
}

@Override
public JSONArray getPoID(String getPoID) {
	// TODO Auto-generated method stub
	return masterDao.getPoID(getPoID);
}

@Override
public String manualProposalDetailsSubmit(MultipartFile[] manualProposalFile, String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername, String secondapprovercontact,
		String clientname, String description, String uname, String aTC, String proposaltype, String perpetualyear,
		String subscriptionyear, String productsuitselect, String scanplusprodversion, String secureITprodversion,
		String enccustomername, String fixedyear, String contactperson, String subscriptionANDperpetualYear,
		String manualAmount, String proposal_For, String PartnerName) {
	// TODO Auto-generated method stub
	return masterDao.manualProposalDetailsSubmit( manualProposalFile,poinitiator, poinitiatorno, firstApprovername,
			firstapprovercontact, secondApprovername, secondapprovercontact, clientname, description,
			 uname, aTC, proposaltype, perpetualyear, subscriptionyear,  productsuitselect, scanplusprodversion, secureITprodversion,
			enccustomername, fixedyear,contactperson, subscriptionANDperpetualYear ,manualAmount, proposal_For, PartnerName);
}


// 3/1 UD 

@Override
public JSONArray getFunctionName() {
	return masterDao.getFunctionName();
}

@Override
public JSONArray getDesignation() {
	// TODO Auto-generated method stub
	return masterDao.getDesignation();
	}

@Override
public JSONArray getUserName(String desigName) {
	// TODO Auto-generated method stub
	return masterDao.getUserName(desigName);
}

@Override
public String getUserID(String username) {
	// TODO Auto-generated method stub
	return masterDao.getUserID(username);
	}


@Override
public JSONArray generateEnvkey(String productSuitNameList,String proposalId) {
	// TODO Auto-generated method stub
	return masterDao.generateEnvkey(productSuitNameList,proposalId);
}

// 6/1
@Override
public JSONArray getTeamLeader() {
	return masterDao.getTeamLeader();
}

@Override
public JSONArray getDevelopers() {
	return masterDao.getDevelopers();
	}

@Override
public JSONArray apprvlRdDocuments() {
	// TODO Auto-generated method stub
	return masterDao.apprvlRdDocuments();
}

//
@Override
public String ManualproposalUpdateDetails(MultipartFile[] updateManualFile,String veloxdata,String manualamount ,String poinitiator, String poinitiatorno,
		String firstApprovername, String firstapprovercontact, String secondApprovername, String secondapprovercontact,
		String clientname, String description, String totalpriceforallproduct, String deploysupport,
		String clouddeploycharges, String subtotalB, String subtotalAB, String uname, String resoucesamount, String aTC,
		String proposaltype, String perpetualyear, String subscriptionyear, String amcsecondyear, String amcthirdyear,
		String amcfourthyear, String amcfiveyear, String secondyearsubscription, String thirdyearsubscription,
		String fullPathVlxLogo, String fullPathVlxEnd, String fullPathSwachBharat, String integrationchargeYesNo,
		String integrationCharges, String total_C, String gSTPERCENTAGE, String grand_Total, String productsuitselect,
		String scanplusprodversion, String secureITprodversion, String enccustomername, String letterhead,
		String signature, String fixedyear, String crno, String tid, String sInote, String amcstartdate,
		String aMCmonthyear, String aMCMonth, String aMCYear, String amcenddate, String productsuitdetails,
		String securitysolutiondetails, String descforamc, String totalcostAMC, String gRANDTOTALFORAMC,
		String gstforamc, String gstdataforresource, String grandtotalforresource, String subtotalAResource,
		String contactperson, String veloxdata1, String subscriptionANDperpetualYear,
		String perpetualSubsAnnualperpType, String perpetualSubs3yearperpType, String deploysupport21,
		String clouddeploycharges21, String integrationCharges21, String integrationcharge21, String subtotalB21,
		String totalc21, String total18percentage21, String grandtotal21, String resoucesamount21, String proposalfor,String partnername) {
	// TODO Auto-generated method stub
	return masterDao.ManualproposalUpdateDetails(updateManualFile,veloxdata,manualamount,poinitiator,poinitiatorno,firstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,aTC,proposaltype,perpetualyear,
			subscriptionyear,amcsecondyear,amcthirdyear,amcfourthyear,amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
			integrationchargeYesNo,integrationCharges,total_C,gSTPERCENTAGE,grand_Total,productsuitselect,scanplusprodversion,secureITprodversion,enccustomername,letterhead,signature,fixedyear,crno,tid,sInote,amcstartdate,
			amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,gstforamc,
			gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
			  integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21, proposalfor, partnername );
}


@Override
public String saveupload(MultipartFile[] manualProposalFile,String uname,String crno,String tid ) {
	// TODO Auto-generated method stub
	return masterDao.saveupload(manualProposalFile,uname,crno,tid);
}

@Override
public JSONArray getManagerList() {
	return masterDao.getManagerList();
}

@Override
public String updateVeloxLicensedetails(String veloxdata, String sppliernamelicense, String clientname,
		String environmentKeyNo, String ponumber, String podate, String folderPath, String fullPathVlxLogo,
		String oEMAddress, String clientAddress, String endcostomername, String endCustomerEmail,
		String firstApprovername, String secondApprovername, String uname, String poID, String payment_recieved,
		String crno, String tid, String AMsignature) {
	// TODO Auto-generated method stub
	return masterDao.updateVeloxLicensedetails(veloxdata, sppliernamelicense, clientname, environmentKeyNo,
			ponumber, podate, folderPath, fullPathVlxLogo, oEMAddress, clientAddress, endcostomername,
			endCustomerEmail, firstApprovername, secondApprovername, uname, poID, payment_recieved, crno, tid, AMsignature);
}

@Override
public String ClientMaster(String productSuit, String securitytool, String customerName, String prodManager, String functionName,String targetDate, String status, String role) {
	// TODO Auto-generated method stub
	return masterDao.ClientMaster(productSuit,securitytool, customerName, prodManager, functionName, targetDate, status, role);
}

@Override
public JSONArray getAccManagerList() {
	return masterDao.getAccManagerList();
}

@Override
public JSONArray Tlmasterlisting(String subjectList) {
	// TODO Auto-generated method stub
	return masterDao.Tlmasterlisting(subjectList);
}

@Override
public String saveTlMaster(String productsuit, String productname, String unit, String implementerName, String tlname, String developer, String customerName) {
	// TODO Auto-generated method stub
	return masterDao.saveTlMaster(productsuit,productname,unit,implementerName,tlname, developer, customerName);
}

@Override
public String deleteTlMaster(int srno) {
	// TODO Auto-generated method stub
	return masterDao.deleteTlMaster(srno);
}

@Override
public String updateTLMaster(String productsuitupdate, String securitysolutionupdate, String tlname, int srno,
		String updImplementerName) {
	// TODO Auto-generated method stub
	return masterDao.updateTLMaster(productsuitupdate,securitysolutionupdate,tlname,srno,updImplementerName);
}

@Override
public String DownloadBluckUploadfile() {
	// TODO Auto-generated method stub
	return masterDao.DownloadBluckUploadfile();
}

@Override
public String saveBulkUploadTaskFile(MultipartFile bulkUserData, String userfullname, String uname, String role) {
	// TODO Auto-generated method stub
	return masterDao.saveBulkUploadTaskFile(bulkUserData,userfullname,uname, role);
}

@Override
public JSONArray getTesterList() {
	// TODO Auto-generated method stub
	return masterDao.getTesterList();
}

@Override
public JSONArray getTeamLeaderByManager(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getTeamLeaderByManager( userfullname) ;
}

@Override
public JSONArray getDevelopersByManager(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersByManager(userfullname);
}

@Override
public JSONArray getDevelopersByTL(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersByTL( userfullname);
}

@Override
public JSONArray getAllClientList() {
	// TODO Auto-generated method stub
	return masterDao.getAllClientList();
}

@Override
public String updateClientMaster(String srno, String customer, String prodSuite, String prodTool, String managerName,
		String functionName, String toDateUpdate, String statusUpdate) {
	// TODO Auto-generated method stub
	return masterDao.updateClientMaster( srno,  customer,  prodSuite,  prodTool,  managerName, functionName,  toDateUpdate,  statusUpdate);
}

@Override
public String deleteClientDetails(int crno) {
	// TODO Auto-generated method stub
	return masterDao.deleteClientDetails( crno);
}

@Override
public String updateUserActivity(String username, String activities, String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.updateUserActivity( username, activities, userfullname);
}


//05/07
@Override
public JSONArray getCompletedProjectList(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedProjectList(userfullname,role);
}

//05/07
@Override
public JSONArray getCompletedManagerList(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedManagerList(userfullname,role);
}


//05/07
@Override
public JSONArray getCompletedTeamLeader(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedTeamLeader(userfullname,role);
}

@Override
public JSONArray CompletedManagerListDet(String projectNamesN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedManagerListDet(projectNamesN);
}

@Override
public JSONArray CompletedDetailsByCus(String projectNamesN, String prodmgrN, String teamLeaderNameN, String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCus(projectNamesN,prodmgrN,teamLeaderNameN,fnameN);
}

@Override
public JSONArray CompletedTLListDet(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedTLListDet(projectNamesN,prodmgrN);
}

@Override
public JSONArray CompletedBasedOnManager(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction) {
	// TODO Auto-generated method stub
	return masterDao.CompletedBasedOnManager(selectedCustomer,selectedMan,selectedTL,selectedFunction);
}

@Override
public JSONArray CompletedDetailsByCusAndMan(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusAndMan(projectNamesN,prodmgrN);
}

@Override
public JSONArray CompletedFunctionListDet(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedFunctionListDet(projectNamesN,prodmgrN,teamLeaderNameN,fnameN);
}

@Override
public JSONArray CompletedDetailsByCusManAndTL(String projectNamesN, String prodmgrN, String teamLeaderNameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusManAndTL(projectNamesN,prodmgrN,teamLeaderNameN);
}

@Override
public JSONArray CompletedDetailsBasedOnAll(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String FnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsBasedOnAll(projectNamesN,prodmgrN,teamLeaderNameN,FnameN);
}

@Override
public JSONArray CompletedManagerListDet1(String projectNamesN1,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedManagerListDet1(projectNamesN1,userfullname);
}

@Override
public JSONArray CompletedDetailsByCus1(String projectNamesN1, String prodmgrN1, String teamLeaderNameN1,
		String fnameN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCus1(projectNamesN1,prodmgrN1,teamLeaderNameN1,fnameN1,role,userfullname);
}

@Override
public JSONArray CompletedTLListDet1(String projectNamesN1, String prodmgrN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedTLListDet1(projectNamesN1,prodmgrN1,role,userfullname);
}

@Override
public JSONArray CompletedBasedOnManager1(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedBasedOnManager1(selectedCustomer,selectedMan,selectedTL,selectedFunction,role,userfullname);
}

@Override
public JSONArray CompletedDetailsByCusAndMan1(String projectNamesN1, String prodmgrN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusAndMan1(projectNamesN1,prodmgrN1,role,userfullname);
}

@Override
public JSONArray CompletedFunctionListDet1(String projectNamesN1, String prodmgrN1, String teamLeaderNameN1,
		String fnameN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedFunctionListDet1(projectNamesN1,prodmgrN1,teamLeaderNameN1,fnameN1,role,userfullname);
}

@Override
public JSONArray CompletedDetailsByCusManAndTL1(String projectNamesN1, String prodmgrN1, String teamLeaderNameN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusManAndTL1(projectNamesN1,prodmgrN1,teamLeaderNameN1,role,userfullname);
}

@Override
public JSONArray CompletedDetailsBasedOnAll1(String projectNamesN1, String prodmgrN1, String teamLeaderNameN1,
		String fnameN1,String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsBasedOnAll1(projectNamesN1,prodmgrN1,teamLeaderNameN1,fnameN1,role,userfullname);
}


//24/07
@Override
public JSONArray getSupportTeamLeader() {
	// TODO Auto-generated method stub
	return masterDao.getSupportTeamLeader();
}

//24/07
@Override
public JSONArray getSupport() {
	// TODO Auto-generated method stub
	return masterDao.getSupport();
}

@Override
public JSONArray getproducutsuitListSupport() {
	// TODO Auto-generated method stub
	return masterDao.getproducutsuitListSupport();
}

@Override
public JSONArray getimplementerListSupport() {
	// TODO Auto-generated method stub
	return masterDao.getimplementerListSupport();
}

@Override
public JSONArray getCustomerNameSupport() {
	// TODO Auto-generated method stub
	return masterDao.getCustomerNameSupport();
}

@Override
public JSONArray getFunctionNameSupport() {
	// TODO Auto-generated method stub
	return masterDao.getFunctionNameSupport();
}

@Override
public JSONArray getAllClientListSupport() {
	// TODO Auto-generated method stub
	return masterDao.getAllClientListSupport();
}

@Override
public JSONArray getsecuritysolutionListSupport(String productsuit) {
	// TODO Auto-generated method stub
	return masterDao.getsecuritysolutionListSupport(productsuit);
}

@Override
public String ClientMasterSupport(String productSuit, String securitytool, String customerName, String prodManager,
		String functionName, String targetDate, String status, String role) {
	// TODO Auto-generated method stub
	return masterDao.ClientMasterSupport(productSuit, securitytool, customerName, prodManager,
			functionName, targetDate, status, role);
}

@Override
public String updateClientMasterSupport(String srno, String customer, String prodSuite, String prodTool,
		String managerName, String toDateUpdate, String statusUpdate) {
	// TODO Auto-generated method stub
	return masterDao.updateClientMasterSupport(srno,customer, prodSuite, prodTool,
			managerName, toDateUpdate, statusUpdate);
}

@Override
public String deleteClientDetailsSupport(int crno) {
	// TODO Auto-generated method stub
	return masterDao.deleteClientDetailsSupport(crno);
}

@Override
public JSONArray getDevelopersSupport(String teamLead) {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersSupport(teamLead);
}

@Override
public JSONArray getDevelopersTLSupport() {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersTLSupport();
}

@Override
public JSONArray TlmasterlistingSupport(String subjectList) {
	// TODO Auto-generated method stub
	return masterDao.TlmasterlistingSupport(subjectList);
}

@Override
public String saveTlMasterSupport(String productsuit, String productname, String unit, String implementerName,
		String tlname, String developer, String customerName) {
	// TODO Auto-generated method stub
	return masterDao.saveTlMasterSupport(productsuit, productname, unit, implementerName,
			tlname, developer, customerName);
}

@Override
public String deleteTlMasterSupport(int srno) {
	// TODO Auto-generated method stub
	return masterDao.deleteTlMasterSupport(srno);
}

@Override
public String updateTLMasterSupport(String productsuitupdate, String securitysolutionupdate, String tlname, int srno,
		String updImplementerName) {
	// TODO Auto-generated method stub
	return masterDao.updateTLMasterSupport(productsuitupdate, securitysolutionupdate, tlname, srno,
			updImplementerName);
}

@Override
public JSONArray getTeamLeaderBySupportManager(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getTeamLeaderBySupportManager(userfullname);
}

@Override
public JSONArray getDevelopersBySupportManager(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersBySupportManager(userfullname);
}

@Override
public JSONArray getTeamLeadTL(String role,String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getTeamLeadTL(role,userfullname);
}


//17/08
@Override
public JSONArray getCompletedProjectListNew(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedProjectListNew(userfullname, role);
}

@Override
public JSONArray getCompletedTeamLeaderNew(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedTeamLeaderNew(userfullname, role);
}


@Override
public JSONArray CompletedManagerListDetNew(String projectNamesN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedManagerListDetNew(projectNamesN);
}
//

@Override
public JSONArray CompletedDetailsByCusNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusNew(projectNamesN,prodmgrN,teamLeaderNameN,fnameN,methodName);
}

@Override
public JSONArray CompletedTLListDetNew(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedTLListDetNew(projectNamesN,prodmgrN);
}

@Override
public JSONArray CompletedBasedOnManagerNew(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedBasedOnManagerNew(selectedCustomer,selectedMan,selectedTL,selectedFunction,methodName);
}

@Override
public JSONArray CompletedDetailsByCusAndManNew(String projectNamesN, String prodmgrN,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusAndManNew(projectNamesN,prodmgrN,methodName);
}

@Override
public JSONArray CompletedFunctionListDetNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN, String productTool) {
	// TODO Auto-generated method stub
	return masterDao.CompletedFunctionListDetNew(projectNamesN,prodmgrN,teamLeaderNameN,fnameN,productTool);
}

@Override
public JSONArray CompletedDetailsByCusManAndTLNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusManAndTLNew(projectNamesN,prodmgrN,teamLeaderNameN,methodName);
}

@Override
public JSONArray CompletedDetailsBasedOnAllNew(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String FnameN, String FnameNNewStatus,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsBasedOnAllNew(projectNamesN,prodmgrN,teamLeaderNameN,FnameN, FnameNNewStatus,methodName);
}





//20/08
@Override
public JSONArray CompletedStatusListDetNew(String projectNamesN, String prodmgrN, String teamLeaderNameN, String fnameN,
		String fnameNNewStatus,String productTool) {
	// TODO Auto-generated method stub
	return masterDao.CompletedStatusListDetNew(projectNamesN, prodmgrN, teamLeaderNameN, fnameN, fnameNNewStatus,productTool);
}


////20/08
@Override
public JSONArray CompletedDetailsByCusManTLNewAndFunction(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameNNew,String methodName) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusManTLNewAndFunction(projectNamesN, prodmgrN, teamLeaderNameN, fnameNNew,methodName);
}



//23/08

@Override
public JSONArray getCompletedProjectListTrack(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedProjectListTrack(userfullname,role);
}



@Override
public JSONArray getCompletedManagerListTrack(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedManagerListTrack(userfullname,role);
}


@Override
public JSONArray getCompletedTeamLeaderTrack(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedTeamLeaderTrack(userfullname, role);
}



@Override
public JSONArray CompletedManagerListDetTrack(String projectNamesNTrack) {
	// TODO Auto-generated method stub
	return masterDao.CompletedManagerListDetTrack(projectNamesNTrack);
}

@Override
public JSONArray CompletedDetailsByCusTrack(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusTrack(projectNamesN, prodmgrN,teamLeaderNameN,fnameN);
}

@Override
public JSONArray CompletedTLListDetTrack(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedTLListDetTrack(projectNamesN,prodmgrN);
}

@Override
public JSONArray CompletedBasedOnManagerTrack(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction) {
	// TODO Auto-generated method stub
	return masterDao.CompletedBasedOnManagerTrack(selectedCustomer, selectedMan, selectedTL, selectedFunction);
}

@Override
public JSONArray CompletedDetailsByCusAndManTrack(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusAndManTrack(projectNamesN, prodmgrN);
}

@Override
public JSONArray CompletedFunctionListDetTrack(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedFunctionListDetTrack(projectNamesN, prodmgrN, teamLeaderNameN, fnameN);
}

@Override
public JSONArray CompletedDetailsByCusManAndTLTrack(String projectNamesN, String prodmgrN, String teamLeaderNameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsByCusManAndTLTrack(projectNamesN, prodmgrN, teamLeaderNameN);
}

@Override
public JSONArray CompletedDetailsBasedOnAllTrack(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.CompletedDetailsBasedOnAllTrack(projectNamesN, prodmgrN, teamLeaderNameN, fnameN);
}


//31/08
@Override
public JSONArray getAllImplementorList() {
	// TODO Auto-generated method stub
	return masterDao.getAllImplementorList();
}

@Override
public JSONArray getProductToolListTotAct(String projectName, String pManager, String projectTL, String functionName,
		String productTool, String status) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolListTotAct(projectName,pManager,projectTL,functionName,productTool, status);
}

@Override
public JSONArray getProductToolByManagerTotAct(String projectNamesNNew, String prodmgrNNew,String pToolTotAct) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolByManagerTotAct(projectNamesNNew,prodmgrNNew,pToolTotAct);
}

@Override
public JSONArray getProductToolTotAct(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolTotAct(userfullname, role);
}


//13/09
@Override
public JSONArray getCustomerNameN() {
	// TODO Auto-generated method stub
	return masterDao.getCustomerNameN();
}


//10/10
@Override
public JSONArray getOnHoldProjectList(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getOnHoldProjectList(userfullname,role);
}


//10/10
@Override
public JSONArray getOnHoldManagerList(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getOnHoldManagerList(userfullname,role);
}



//10/10
@Override
public JSONArray getOnHoldTeamLeader(String userfullname,String role) {
	// TODO Auto-generated method stub
	return masterDao.getOnHoldTeamLeader(userfullname,role);
}

//10/10
@Override
public JSONArray OnHoldManagerListDet(String projectNamesN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldManagerListDet(projectNamesN);
}


//10/10
@Override
public JSONArray OnHoldDetailsByCus(String projectNamesN, String prodmgrN, String teamLeaderNameN, String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCus(projectNamesN,prodmgrN,teamLeaderNameN,fnameN);
}

//10/10
@Override
public JSONArray OnHoldTLListDet(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldTLListDet(projectNamesN,prodmgrN);
}



//10/10
@Override
public JSONArray OnHoldBasedOnManager(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldBasedOnManager(selectedCustomer,selectedMan,selectedTL,selectedFunction);
}


//10/10
@Override
public JSONArray OnHoldDetailsByCusAndMan(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCusAndMan(projectNamesN,prodmgrN);
}

//10/10
@Override
public JSONArray OnHoldFunctionListDet(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldFunctionListDet(projectNamesN,prodmgrN,teamLeaderNameN,fnameN);
}


//10/10
@Override
public JSONArray OnHoldDetailsByCusManAndTL(String projectNamesN, String prodmgrN, String teamLeaderNameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCusManAndTL(projectNamesN,prodmgrN,teamLeaderNameN);
}


//10/10
@Override
public JSONArray OnHoldDetailsBasedOnAll(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String FnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsBasedOnAll(projectNamesN,prodmgrN,teamLeaderNameN,FnameN);
}


//28/10
@Override
public JSONArray getEmployeesByMan(String uname) {
	return masterDao.getEmployeesByMan(uname);
	}



@Override
public String saveFeedback(String developerName, String projectName, String performanceRating, String feedbackComments,
		String suggestions, String role) {
	// TODO Auto-generated method stub
	return masterDao.saveFeedback(developerName,projectName, performanceRating,feedbackComments,
			suggestions, role);
}

@Override
public String saveClientFeedback1(String clientName, String projectName, String dateOfFeedback, String feedbackType,
		String feedbackDescription, String impactAssessment, String statusOfGrievance, String assignedTo,
		String resolutionDescription, String followUpDate,String clientResponse) {
	// TODO Auto-generated method stub
	return masterDao.saveClientFeedback1(clientName, projectName, dateOfFeedback,
			feedbackType, feedbackDescription, impactAssessment, statusOfGrievance,
			assignedTo, resolutionDescription, followUpDate, clientResponse);
}





//12/11
@Override
public JSONArray getDevelopersByManagerOnhold(String userfullname) {
	// TODO Auto-generated method stub
	return masterDao.getDevelopersByManagerOnhold(userfullname);
}


//12/11
@Override
public JSONArray OnHoldManagerListDetMan(String projectNamesN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldManagerListDetMan(projectNamesN);
}


//12/11
@Override
public JSONArray OnHoldDetailsByCusMan(String projectNamesN, String prodmgrN, String teamLeaderNameN, String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCusMan(projectNamesN, prodmgrN, teamLeaderNameN, fnameN);
}


//12/11
@Override
public JSONArray OnHoldTLListDetMan(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldTLListDetMan(projectNamesN, prodmgrN);
}


//12/11
@Override
public JSONArray OnHoldBasedOnManagerMan(String selectedCustomer, String selectedMan, String selectedTL,
		String selectedFunction) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldBasedOnManagerMan(selectedCustomer, selectedMan, selectedTL,
			selectedFunction);
}


//12/11
@Override
public JSONArray OnHoldDetailsByCusAndManOnhold(String projectNamesN, String prodmgrN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCusAndManOnhold(projectNamesN, prodmgrN);
}


//12/11
@Override
public JSONArray OnHoldFunctionListDetMan(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldFunctionListDetMan(projectNamesN, prodmgrN, teamLeaderNameN,
			fnameN);
}


//12/11
@Override
public JSONArray OnHoldDetailsByCusManAndTLMan(String projectNamesN, String prodmgrN, String teamLeaderNameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsByCusManAndTLMan(projectNamesN, prodmgrN, teamLeaderNameN);
}


//12/11
@Override
public JSONArray OnHoldDetailsBasedOnAllMan(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN) {
	// TODO Auto-generated method stub
	return masterDao.OnHoldDetailsBasedOnAllMan(projectNamesN, prodmgrN, teamLeaderNameN,
			fnameN);
}


//12/11
@Override
public JSONArray getCompletedProjectListNewMan(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedProjectListNewMan(userfullname, role);
}


//12/11
@Override
public JSONArray getProductToolTotActMan(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolTotActMan(userfullname, role);
}


//12/11
@Override
public JSONArray getCompletedTeamLeaderNewMan(String userfullname, String role) {
	// TODO Auto-generated method stub
	return masterDao.getCompletedTeamLeaderNewMan(userfullname, role);
}


//12/11
@Override
public JSONArray CompletedManagerListDetNewMan(String projectNamesN, String role) {
	// TODO Auto-generated method stub
	return masterDao.CompletedManagerListDetNewMan(projectNamesN, role);
}


//12/11
@Override
public JSONArray getProductToolListTotActMan(String projectName, String pManager, String projectTL, String functionName,
		String productTool, String status, String role) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolListTotActMan(projectName, pManager, projectTL, functionName,
			productTool, status, role);
}


//12/11
@Override
public JSONArray CompletedTLListDetNewMan(String projectNamesN, String prodtoolNNew) {
	// TODO Auto-generated method stub
	return masterDao.CompletedTLListDetNewMan(projectNamesN, prodtoolNNew);
}


//12/11
@Override
public JSONArray getProductToolByManagerTotActMan(String projectNamesNNew, String prodmgrNNew, String teamleaderNMan) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolByManagerTotActMan(projectNamesNNew, prodmgrNNew, teamleaderNMan);
}

//12/11
@Override
public JSONArray getProductToolListTotActManager(String projectName, String pManager, String projectTL,
		String functionName, String productTool, String status) {
	// TODO Auto-generated method stub
	return masterDao.getProductToolListTotActManager(projectName, pManager, projectTL,
			functionName, productTool, status);
}


//12/11
@Override
public JSONArray CompletedFunctionListDetNewMan(String projectNamesN, String prodmgrN, String teamLeaderNameN,
		String fnameN, String productTool) {
	// TODO Auto-generated method stub
	return masterDao.CompletedFunctionListDetNewMan(projectNamesN, prodmgrN, teamLeaderNameN,
			fnameN, productTool);
}



//08/11
@Override
public String bellNotification(String uname) {
	// TODO Auto-generated method stub
	return masterDao.bellNotification(uname);
}


//12/11
@Override
public JSONArray renderNotifications(String uname) {
	// TODO Auto-generated method stub
	return masterDao.renderNotifications(uname);
}


//16/11
@Override
public JSONArray getStatusForDeletedActivities(String productsuit) {
	// TODO Auto-generated method stub
	return masterDao.getStatusForDeletedActivities(productsuit);
}

@Override
public JSONArray getAllsecuritysolutionList() {
	// TODO Auto-generated method stub
	return masterDao.getAllsecuritysolutionList();
}

@Override
public String getproductnametoolN(String productSuite) {
	// TODO Auto-generated method stub
	return masterDao.getproductnametoolN( productSuite);
}

@Override
public JSONArray getproductsuitlistN() {
	// TODO Auto-generated method stub
	return masterDao.getproductsuitlistN();
}





//28/11
@Override
public String updateTLMasterSupportNew(String productsuitupdate, String securitysolutionupdate, String tlname, int srno,
		String updImplementerName, String assignedToupdate) {
	// TODO Auto-generated method stub
	return masterDao.updateTLMasterSupportNew(productsuitupdate, securitysolutionupdate, tlname, srno,
			updImplementerName, assignedToupdate);
}


//28/11
@Override
public JSONArray getTLForTLMaster() {
	// TODO Auto-generated method stub
	return masterDao.getTLForTLMaster();
}


//28/11
@Override
public JSONArray TlmasterlistingForTeamMaster(String subjectList) {
	// TODO Auto-generated method stub
	return masterDao.TlmasterlistingForTeamMaster(subjectList);
}


//28/11
@Override
public String updateTLMasterDeveloperNew(String productsuitupdate, String securitysolutionupdate, String tlname, int srno,
		String updImplementerName, String assignedToupdate) {
	// TODO Auto-generated method stub
	return masterDao.updateTLMasterDeveloperNew(productsuitupdate, securitysolutionupdate, tlname, srno,
			updImplementerName, assignedToupdate);
}



//28/11
@Override
public String saveTlMasterForMan(String productsuit, String productname, String unit, String implementerName,
		String tlname, String developer, String customerName) {
	// TODO Auto-generated method stub
	return masterDao.saveTlMasterForMan(productsuit, productname, unit, implementerName,
			tlname, developer, customerName);
}

@Override
public String uploadLicenseFile(MultipartFile[] licenseUploadfile) {
	// TODO Auto-generated method stub
	return masterDao.uploadLicenseFile(licenseUploadfile);
}




}
