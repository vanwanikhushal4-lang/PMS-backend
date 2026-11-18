package com.velox.itsm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
//import com.sun.xml.internal.txw2.Document;
import com.velox.itsm.service.AllMasters;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/Master")
public class MasterController {

	@Autowired
	AllMasters AllMasters;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = { "/getCompanyDetails" }, method = RequestMethod.POST)
	public JSONArray getCompanyName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyDetails(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getrespup" }, method = RequestMethod.POST)
	public JSONArray getrespup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getrespup();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCompanyDetailsForLoginMasterup" }, method = RequestMethod.POST)
	public JSONArray getCompanydropdownlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanydropdownlist();

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/resplisting" }, method = RequestMethod.POST)
	public JSONArray resplisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designationList = null;
			JSONArray final_response = AllMasters.resplisting(designationList);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getCompositecompanyDetails" }, method = RequestMethod.POST)
	public JSONArray getCompositecompanyDetails(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositecompanyDetails();

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getprojectsuitList" }, method = RequestMethod.POST)
	public JSONArray getprojectsuitList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getprojectsuitList();

			// System.out.println("getCompositeCompanyList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeCompanyList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getprojectList" }, method = RequestMethod.POST)
	public JSONArray getprojectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getprojectList();

			// System.out.println("getCompositeCompanyList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeCompanyList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getprojectsuitListupd" }, method = RequestMethod.POST)
	public JSONArray getprojectsuitListupd(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getprojectsuitListupd();

			// System.out.println("getCompositeCompanyList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeCompanyList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getprojectListupd" }, method = RequestMethod.POST)
	public JSONArray getprojectListupd(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getprojectListupd();

			// System.out.println("getCompositeCompanyList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeCompanyList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	/// statrt

	@RequestMapping(value = { "/addregistrationMaster" }, method = RequestMethod.POST)
	public void addregistrationMaster(@RequestParam("incocertificate") MultipartFile[] incocertificate,

			@RequestParam("pancardfile") MultipartFile[] pancardfile,
			@RequestParam("gstcertificate") MultipartFile[] gstcertificate,
			@RequestParam("msmed") MultipartFile[] msmed,
			@RequestParam("cancelledcheque") MultipartFile[] cancelledcheque,
			@RequestParam("turnovercertif") MultipartFile[] turnovercertif,
			@RequestParam("msmeddocument") MultipartFile[] msmeddocument, @RequestParam("addrowdata") String addrowdata,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			// String addrowdata=request.getParameter("addrowdata");

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");

			System.out.println(" addrowdata addrowdata ::" + addrowdata);
			String categorytype = request.getParameter("categorytype");
			System.out.println("categorytype :" + categorytype);
			String distributorname = request.getParameter("distributorname");
			String partnername = request.getParameter("partnername");
			String compname = request.getParameter("compname");
			System.out.println("company name :" + compname);
			String registerno = request.getParameter("registerno");
			String address = request.getParameter("address");
			String contact_personname = request.getParameter("personname");
			String mobno = request.getParameter("mobno");
			String telpno = request.getParameter("telpno");
			String Md_Ceo_emailid = request.getParameter("Md_Ceo_emailid");
			String Sales_emailid = request.getParameter("Sales_emailid");
			String support_email_id = request.getParameter("support_email_id");
			String emailid_contact_person = request.getParameter("emailid_contact_person");
			String office_mailid = request.getParameter("office_mailid");
			String city = request.getParameter("city");
			String district = request.getParameter("district");
			String state = request.getParameter("state");
			String pincode = request.getParameter("pincode");
			String country = request.getParameter("country");
			System.out.println("country :" + country);
			String website = request.getParameter("website");
			String panacno = request.getParameter("panacno");
			String ownership = request.getParameter("ownership");
			System.out.println("ownership type :" + ownership);
			String scale_of_company = request.getParameter("scale_of_company");
			String gstin = request.getParameter("gstin");
			String other_country = request.getParameter("other_country");
			String dateofbussns = request.getParameter("dateofbussns");
			String currency = request.getParameter("currency");
			String year1 = request.getParameter("year1");
			String year2 = request.getParameter("year2");
			String year3 = request.getParameter("year3");
			String rupees1 = request.getParameter("rupees1");
			String rupees2 = request.getParameter("rupees2");
			String rupees3 = request.getParameter("rupees3");
			String gemportal_register = request.getParameter("gemportal1");
			String msmedtype = request.getParameter("msmedtype");
			String entrepreno = request.getParameter("entrepreno");
			String ideclaration = request.getParameter("ideclaration");
			String checker = request.getParameter("checker");
			String Authorizer = request.getParameter("Authorizer");
			
			String salesManager = request.getParameter("salesManager");
			String reg_msmed = request.getParameter("reg_msmed");
			
			System.out.println("checker :" + checker);
			System.out.println("Authorizer :" + Authorizer);

			// System.out.println("Email trigger "+emailTrigger+" TYPE:::::"+mailfooter);
			// System.out.println("company ::::"+company);
			out = response.getWriter();
			out.print(AllMasters.addregistrationMaster(incocertificate, pancardfile, gstcertificate, msmed,
					cancelledcheque, turnovercertif, msmeddocument, addrowdata, categorytype, distributorname,
					partnername, compname, registerno, address, contact_personname, mobno, telpno, Md_Ceo_emailid,
					Sales_emailid, support_email_id, emailid_contact_person, office_mailid, city, district, state,
					pincode, country, website, panacno, ownership, scale_of_company, gstin, other_country, dateofbussns,
					currency, year1, year2, year3, rupees1, rupees2, rupees3, gemportal_register, msmedtype, entrepreno,
					ideclaration, checker, Authorizer, uname, company,salesManager));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	// end

	@RequestMapping(value = { "/AddMailTemp" }, method = RequestMethod.POST)
	public void AddMailTemp(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String st = request.getParameter("st");
			String subject = request.getParameter("subject");
			String mailbody = request.getParameter("mailbody");
			String company = request.getParameter("company");
			String emailTrigger = request.getParameter("EmailTrigger");
			String ticketType = request.getParameter("ticketType");
			String mailfooter = request.getParameter("mailfooter");
			// System.out.println("Email trigger "+emailTrigger+" TYPE:::::"+mailfooter);
			// System.out.println("company ::::"+company);
			out = response.getWriter();
			out.print(AllMasters.AddMailTemp(st, subject, mailbody, company, emailTrigger, ticketType, mailfooter));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = { "/ViewAllADUsers" }, method = RequestMethod.POST)
	public JSONArray ViewAllADUsers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String cname = request.getParameter("companyname");
			// String uname = request.getParameter("username");
			out = response.getWriter();
			// System.out.println("cname:="+cname);
			JSONArray final_response = AllMasters.ViewAllADUsers(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/FetchADusers" }, method = RequestMethod.POST)
	public String FetchADusers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {

			String company = request.getParameter("company");
			// System.out.println("Company Name in sync"+company);
			out = response.getWriter();
			out.print(AllMasters.FetchADusers(company));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/AddMailListing" }, method = RequestMethod.POST)
	public JSONArray MailMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside AddMailListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.AddMailListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("AddMailListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public void updateuser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {

			HttpSession htt = request.getSession(true);
			String srno = request.getParameter("id");
			String utype = request.getParameter("utype");
			String name = request.getParameter("name");
			String mail = request.getParameter("mail");
			String contact = request.getParameter("contact");
			String username = request.getParameter("username");
			String cname = request.getParameter("cname");
			// System.out.println("srno cnt=" + srno);
			// System.out.println("utype cnt=" + utype);

			out = response.getWriter();
			out.print(AllMasters.updateuser(srno, utype, name, mail, contact, username, cname));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "/adddetails", method = RequestMethod.POST)
	public String adddetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hostname = request.getParameter("hostname");
		String portno = request.getParameter("portno");
		String domainname = request.getParameter("domainname");
		String companyname = request.getParameter("cmpnyname");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = AllMasters.saveadIntegration(username, password, hostname, portno, domainname, companyname);
			// System.out.println("Result value: "+result);
			out.print(result);
		} catch (Exception e) {
			// System.out.println("Exception in AdmiUserController saveNewuser method: "+e);
		} finally {
			out.close();
		}

		return "/ATM/ADMIN/AdIntegration";
	}

	@RequestMapping(value = { "/adddetailsListing" }, method = RequestMethod.POST)
	public JSONArray adddetailsListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adddetailsListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.adddetailsListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("adddetailsListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = "/adintegtest", method = RequestMethod.POST)
	public String adintegtest(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hostname = request.getParameter("hostname");
		String domainname = request.getParameter("domainname");
		String port = request.getParameter("port");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = AllMasters.testadIntegration(username, password, hostname, domainname, port);
			// System.out.println("Result value: "+result);
			out.print(result);
		} catch (Exception e) {
			// System.out.println("Exception in AdminController saveNewuser method: "+e);
		} finally {
			out.close();
		}

		return "/ATM/AdIntegration";
	}

	@RequestMapping(value = { "/addEmailIntDetails" }, method = RequestMethod.POST)
	public JSONArray addEmailIntDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addEmailIntDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addVropsIntDetails" }, method = RequestMethod.POST)
	public JSONArray addVropsIntDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addVropsIntDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/adduserVrops" }, method = RequestMethod.POST)
	public JSONArray adduserVrops(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside email Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String surl = request.getParameter("surl");
			String certi = request.getParameter("certi");
			String host = request.getParameter("host");
			String alerttype = request.getParameter("alerttype");

			String final_response = AllMasters.adduserVrops(uname, pass, surl, certi, host, alerttype);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/adduserEmail" }, method = RequestMethod.POST)
	public JSONArray adduserEmail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside email Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");

			String mail = request.getParameter("mail");
			String subject = request.getParameter("subject");

			String folder = request.getParameter("folder");
			String port = request.getParameter("port");

			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String starttls = null;

			String final_response = AllMasters.adduserEmail(company, mail, subject, folder, port, uname, pass,
					starttls);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getBranchDetails" }, method = RequestMethod.POST)
	public JSONArray getBranchDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getBranchDetails(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/gettid" }, method = RequestMethod.POST)
	public JSONArray gettid(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("companyis");
			String todate = request.getParameter("ToDate");
			String fromdate = request.getParameter("FromDate");
			System.out.println("the company name is cname" + cname);
			JSONArray final_response = AllMasters.gettid(cname, fromdate, todate);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getEscBranchDetails" }, method = RequestMethod.POST)
	public JSONArray getEscBranchDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getEscBranchDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String companyname = request.getParameter("companyname");
		// System.out.println("COMPANY NAME: "+companyname);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getEscBranchDetails(companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc1NameDetails" }, method = RequestMethod.POST)
	public JSONArray getesc1NameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("category");
			JSONArray final_response = AllMasters.getesc1NameDetails(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc3NameDetails" }, method = RequestMethod.POST)
	public JSONArray getesc3NameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("category");
			JSONArray final_response = AllMasters.getesc3NameDetails(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc2NameDetails" }, method = RequestMethod.POST)
	public JSONArray getesc2NameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("category");
			JSONArray final_response = AllMasters.getesc2NameDetails(cname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getOwnNameDetails" }, method = RequestMethod.POST)
	public JSONArray getOwnNameDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;
		String companyname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("category");
			companyname = request.getParameter("company");
			JSONArray final_response = AllMasters.getOwnNameDetails(cname, companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryDetails" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCategoryDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCategoryDetails(catname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getGroupDetails" }, method = RequestMethod.POST)
	public JSONArray getGroupDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getGroupDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String groupname = null;

		try {
			groupname = request.getParameter("compname");

			out = response.getWriter();

			JSONArray final_response = AllMasters.getGroupDetails(groupname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getGroupDetails NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getSubCategoryEnggName" }, method = RequestMethod.POST)
	public JSONArray getSubCategoryEnggName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategoryEnggName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String category = request.getParameter("categ");
			String Company = request.getParameter("Company");
			String Branch = request.getParameter("Branch");
			String Department = request.getParameter("Department");

			// System.out.println("category is = " + category);
			// System.out.println("Company is = " + Company);
			// System.out.println("Branch is = " + Branch);
			// System.out.println("Department is = " + Department);

			JSONArray final_response = AllMasters.getSubCategoryEnggName(category, Company, Branch, Department);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
			java.util.Set<String> set = new LinkedHashSet<String>();

			for (int i = 0; i < final_response.length(); i++) {
				set.add(final_response.get(i).toString());
			}

			List<String> list = new ArrayList<>(set.size());
			for (String lists : set) {
				list.add(lists);
			}

			JSONArray listofEngineer = new JSONArray();
			for (Object str : list) {
				listofEngineer.put(str.toString());
			}

			out.print(listofEngineer);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getRequestModeName" }, method = RequestMethod.POST)
	public JSONArray getRequestModeName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String reqmode = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getRequestModeName(reqmode);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCustomerName" }, method = RequestMethod.POST)
	public JSONArray getCustomerName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCustomerName();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getProductName" }, method = RequestMethod.POST)
	public void getProductName(HttpServletRequest request, HttpServletResponse response) {
		String clientname = request.getParameter("clientname");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String val = AllMasters.getProductName(clientname);

			out.print(val);
		} catch (Exception e54) {
			e54.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = { "/getRequestClientName" }, method = RequestMethod.POST)
	public JSONArray getRequestClientName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String reqmode = null;

		try {
			out = response.getWriter();

//			JSONArray final_response = AllMasters.getRequestModeName(reqmode);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

//				out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getPriorityName" }, method = RequestMethod.POST)
	public JSONArray getPriorityName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getPriorityName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			JSONArray final_response = AllMasters.getPriorityName(companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getPriorityName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getSeverityName" }, method = RequestMethod.POST)
	public JSONArray getSeverityName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSeverityName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			JSONArray final_response = AllMasters.getSeverityName(companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSeverityName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getSubCategoryName" }, method = RequestMethod.POST)
	public JSONArray getSubCategoryName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategoryName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String subcatname = request.getParameter("categ");

			// System.out.println();
			JSONArray final_response = AllMasters.getSubCategoryName(subcatname);
			;

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getSiteDetails" }, method = RequestMethod.POST)
	public JSONArray getSiteName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSiteDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");

			// System.out.println("companyname is = " + companyname);

			JSONArray final_response = AllMasters.getSiteDetails(companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/EnggNameValuesForSLA" }, method = RequestMethod.POST)
	public JSONArray EnggNameValuesForSLA(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside EnggNameValuesForSLA Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String branchname = request.getParameter("branchname");
			String companyname = request.getParameter("companyname");

			// System.out.println("branchname is = " + branchname);
			// System.out.println("companyname is = " + companyname);

			JSONArray final_response = AllMasters.EnggNameValuesForSLA(branchname, companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("EnggNameValuesForSLA GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getDepartmentDetails" }, method = RequestMethod.POST)
	public JSONArray getDeptName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String dname = null;
			JSONArray final_response = AllMasters.getDeptDetails(dname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/adduser" }, method = RequestMethod.POST)
	public JSONArray adduser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adduser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String mail = request.getParameter("mail");
			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String cpass = request.getParameter("cpass");
			String cname = request.getParameter("cname");
			String sname = request.getParameter("sname");
			String dname = request.getParameter("dname");

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);

			String final_response = AllMasters.adduser(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addTicketOwner" }, method = RequestMethod.POST)
	public JSONArray addTicketOwner(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adduser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String branch = request.getParameter("branch");
			String category = request.getParameter("category");
			String ticowner = request.getParameter("ticowner");
			String esc1 = request.getParameter("esc1");
			String esc2 = request.getParameter("esc2");
			String esc3 = request.getParameter("esc3");
			String towneremail = request.getParameter("towneremail");
			String e1email = request.getParameter("e1email");
			String e2email = request.getParameter("e2email");
			String e3email = request.getParameter("e3email");

			String townermob = request.getParameter("townermob");
			String e1mob = request.getParameter("e1mob");
			String e2mob = request.getParameter("e2mob");
			String e3mob = request.getParameter("e3mob");

			String final_response = AllMasters.addTicketOwner(company, branch, category, ticowner, esc1, esc2, esc3,
					towneremail, e1email, e2email, e3email, townermob, e1mob, e2mob, e3mob);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ViewTicketOwner" }, method = RequestMethod.POST)
	public JSONArray ViewTicketOwner(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String dname = request.getParameter("ticowner");
			JSONArray final_response = AllMasters.ViewTicketOwner(dname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getOwn1Details" }, method = RequestMethod.POST)
	public JSONArray getOwn1Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String dname = request.getParameter("ticowner");
			JSONArray final_response = AllMasters.getOwn1Details(dname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc1Details" }, method = RequestMethod.POST)
	public JSONArray getesc1Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String engname = request.getParameter("esc1");
			JSONArray final_response = AllMasters.getesc1Details(engname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc2Details" }, method = RequestMethod.POST)
	public JSONArray getesc2Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String engname = request.getParameter("esc2");
			JSONArray final_response = AllMasters.getesc2Details(engname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getesc3Details" }, method = RequestMethod.POST)
	public JSONArray getesc3Details(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String engname = request.getParameter("esc3");
			JSONArray final_response = AllMasters.getesc3Details(engname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addEscalatorMatrix" }, method = RequestMethod.POST)
	public JSONArray addEscalatorMatrix(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adduser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String branch = request.getParameter("branch");
			String category = request.getParameter("category");

			String priority = request.getParameter("priority");
			String mail = request.getParameter("mail");
			String sms = request.getParameter("sms");

			String ticowner = request.getParameter("ticowner");
			String esc1 = request.getParameter("esc1");
			String esc2 = request.getParameter("esc2");
			String esc3 = request.getParameter("esc3");
			String towneremail = request.getParameter("towneremail");
			String e1email = request.getParameter("e1email");
			String e2email = request.getParameter("e2email");
			String e3email = request.getParameter("e3email");

			String townermob = request.getParameter("townermob");
			String e1mob = request.getParameter("e1mob");
			String e2mob = request.getParameter("e2mob");
			String e3mob = request.getParameter("e3mob");

			String t0 = request.getParameter("t0");
			String t1 = request.getParameter("t1");
			String t2 = request.getParameter("t2");
			String t3 = request.getParameter("t3");

			// System.out.println("t2 val=="+t2);
			// System.out.println("t3 val=="+t3);

			String tt0 = request.getParameter("tt0");
			String tt1 = request.getParameter("tt1");
			String tt2 = request.getParameter("tt2");
			String tt3 = request.getParameter("tt3");

			String final_response = AllMasters.addEscalatorMatrix(company, branch, category, ticowner, esc1, esc2, esc3,
					towneremail, e1email, e2email, e3email, townermob, e1mob, e2mob, e3mob, priority, mail, sms, t0, t1,
					t2, t3, tt0, tt1, tt2, tt3);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addAutoAssignTicket" }, method = RequestMethod.POST)
	public JSONArray addAutoAssignTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adduser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));
			String Assign_TO = request.getParameter("Assign_TO");
			String Group_Name = request.getParameter("GroupName");

			String final_response = AllMasters.addAutoAssignTicket(category, priority, days, hours, minutes, seconds,
					company, severity, Assign_TO, Group_Name);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsforAutoAssignTickets" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsforAutoAssignTickets(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getCategoryDetailsforuScop2 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			catname = request.getParameter("company");
			JSONArray final_response = AllMasters.getCategoryDetailsforAutoAssignTickets(catname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getGroupDetailsforAutoAssignTickets" }, method = RequestMethod.POST)
	public JSONArray getGroupDetailsforAutoAssignTickets(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getGroupDetailsforAutoAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			catname = request.getParameter("company");
			JSONArray final_response = AllMasters.getGroupDetailsforAutoAssignTickets(catname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/ViewEscMatrix" }, method = RequestMethod.POST)
	public JSONArray ViewEscMatrix(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.ViewEscMatrix(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ViewAssignTicket" }, method = RequestMethod.POST)
	public JSONArray ViewAssignTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.ViewAssignTicket(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/ViewcloseTicket" }, method = RequestMethod.POST)
	public JSONArray ViewcloseTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.ViewcloseTicket(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addUserDetails" }, method = RequestMethod.POST)
	public JSONArray addUserDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addUserDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateAddUserSave" }, method = RequestMethod.POST)
	public JSONArray updateAddUserSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateAddUserSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mailupdate");
			String cno = request.getParameter("cnoupdate");
			String user = request.getParameter("userupdate");
			String pass = request.getParameter("passupdate");
			String fname = request.getParameter("fnameupdate");
			String lname = request.getParameter("lnameupdate");
			String cpass = request.getParameter("passupdate");
			String cname = request.getParameter("cnameupdate");
			String sname = request.getParameter("snameupdate");
			String dname = request.getParameter("dnameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateAddUserSave(mail, cno, user, pass, fname, lname, cpass, cname,
					sname, dname, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public JSONArray deleteUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.deleteUser(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addEngg" }, method = RequestMethod.POST)
	public JSONArray addEngg(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addEngg Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mail");
			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String cpass = request.getParameter("cpass");
			String cname = request.getParameter("cname");
			String sname = request.getParameter("sname");
			String dname = request.getParameter("dname");
			String category = request.getParameter("category");
			String englevel = request.getParameter("englevel");

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);
			// System.out.println("category is = " + category);
			// System.out.println("Engg Level is = " + englevel);

			String final_response = AllMasters.addengg(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname,
					category, englevel);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDENGG GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addEnggDetails" }, method = RequestMethod.POST)
	public JSONArray addEnggDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addEnggDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addEnggDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/updateAddEnggSave" }, method = RequestMethod.POST)
	public JSONArray updateAddEnggSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateAddEnggSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mailupdate");
			String cno = request.getParameter("cnoupdate");
			String user = request.getParameter("userupdate");
			String pass = request.getParameter("passupdate");
			String fname = request.getParameter("fnameupdate");
			String lname = request.getParameter("lnameupdate");
			String cpass = request.getParameter("passupdate");
			String cname = request.getParameter("cnameupdate");
			String sname = request.getParameter("snameupdate");
			String dname = request.getParameter("dnameupdate");
			String category = request.getParameter("categoryupdate");
			String englevel = request.getParameter("englevelupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);
			// System.out.println("category is = " + category);
			// System.out.println("englevel is = " + englevel);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateAddEnggSave(mail, cno, user, pass, fname, lname, cpass, cname,
					sname, dname, category, cr_no, englevel);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateAddEnggSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteEngineer" }, method = RequestMethod.POST)
	public JSONArray deleteEngg(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteEngg Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.deleteEngg(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("delete engg GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addTPMasterDetails" }, method = RequestMethod.POST)
	public JSONArray addTPMasterDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addTPMasterDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addTPDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addTPDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/ADDTPMaster" }, method = RequestMethod.POST)
	public JSONArray addTP(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mail");
			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String cpass = request.getParameter("cpass");
			String cname = request.getParameter("cname");
			String sname = request.getParameter("sname");
			String dname = request.getParameter("dname");

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);

			String final_response = AllMasters.addTP(mail, cno, user, pass, fname, lname, cpass, cname, sname, dname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDTP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateAddTPSave" }, method = RequestMethod.POST)
	public JSONArray updateAddTPSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateAddTPSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mailupdate");
			String cno = request.getParameter("cnoupdate");
			String user = request.getParameter("userupdate");
			String pass = request.getParameter("passupdate");
			String fname = request.getParameter("fnameupdate");
			String lname = request.getParameter("lnameupdate");
			String cpass = request.getParameter("passupdate");
			String cname = request.getParameter("cnameupdate");
			String sname = request.getParameter("snameupdate");
			String dname = request.getParameter("dnameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);

			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateAddTPSave(mail, cno, user, pass, fname, lname, cpass, cname, sname,
					dname, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateAddTPSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteTP" }, method = RequestMethod.POST)
	public JSONArray DeleteTP(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.deleteTP(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("delete TP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addITHeadMasterDetails" }, method = RequestMethod.POST)
	public JSONArray addITHeadMasterDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addITHeadMasterDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addITHeadDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addITHeadDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/ADDITHeadMaster" }, method = RequestMethod.POST)
	public JSONArray ADDITHeadMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ADDITHeadMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String cpass = request.getParameter("cpass");

			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("cpass is = " + cpass);

			String final_response = AllMasters.addIT_Head(cno, user, pass, cpass);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteITHead" }, method = RequestMethod.POST)
	public JSONArray DeleteITHead(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteITHead Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.deleteIT_Head(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteITHead GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/CompanyDetails" }, method = RequestMethod.POST)
	public JSONArray CompanyDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside CompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.CompanyDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CompanyDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/updateCompanyMaster" }, method = RequestMethod.POST)
	public JSONArray updateCompanyMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompanyMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("srno is = " + crno);

			JSONArray final_response = AllMasters.updateCompanyMaster(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateCompanyMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addcompany" }, method = RequestMethod.POST)
	public JSONArray addcompany(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addcompany Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String companyemail = request.getParameter("companyemail");

			// System.out.println("company is = " + company);
			// System.out.println("companyemail is = " + companyemail);

			String final_response = AllMasters.addCompany(company, companyemail);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updatecompanySave" }, method = RequestMethod.POST)
	public JSONArray updatecompanySave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updatecompanySave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String companynameupdate = request.getParameter("companynameupdate");
			String companyemailupdate = request.getParameter("companyemailupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("companynameupdate is = " + companynameupdate);
			// System.out.println(companyemailupdate);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updatecompanySave(companynameupdate, companyemailupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatecompanySave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deletecompany" }, method = RequestMethod.POST)
	public JSONArray deletecompany(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deletecompany Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteCompany(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteCompany GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/SiteMasterListing" }, method = RequestMethod.POST)
	public JSONArray SiteMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SiteMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.SiteMasterListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SiteMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/SubmitSiteDetails" }, method = RequestMethod.POST)
	public JSONArray SubmitSiteDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SubmitSiteDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String branch = request.getParameter("branch");

			// System.out.println("company is = " + company);
			// System.out.println("branch is = " + branch);

			String final_response = AllMasters.SubmitSiteDetails(company, branch);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateSiteMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateSiteMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateSiteMasterSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String companynameupdate = request.getParameter("companynameupdate");
			String sitenameupdate = request.getParameter("sitenameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("companynameupdate is = " + companynameupdate);
			// System.out.println("sitenameupdate is = " +sitenameupdate);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateSiteMasterSave(companynameupdate, sitenameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatecompanySave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deletesite" }, method = RequestMethod.POST)
	public JSONArray deletesite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deletesite Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteSite(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteCompany GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/CategoryDetails" }, method = RequestMethod.POST)
	public JSONArray CategoryDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside CategoryDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.CategoryDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SiteMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/addcategory" }, method = RequestMethod.POST)
	public JSONArray addcategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addcategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String category = request.getParameter("category");

			// System.out.println("category is = " + category);

			String final_response = AllMasters.addcategory(category);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addcategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateCategoryMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateCategoryMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCategoryMasterSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String categorynameupdate = request.getParameter("categorynameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("updateCategoryMasterSave is = " + categorynameupdate);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateCategoryMasterSave(categorynameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatecompanySave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deletecategory" }, method = RequestMethod.POST)
	public JSONArray deletecategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deletecategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteCategory(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteCompany GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/SubmitGroupDetails" }, method = RequestMethod.POST)
	public JSONArray SubmitGroupDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SubmitGroupDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String category = request.getParameter("category");
			String group = request.getParameter("group");

			// System.out.println("category is = " + category);
			// System.out.println("group is = " + group);

			String final_response = AllMasters.SubmitGroupDetails(category, group);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/GroupNameValues" }, method = RequestMethod.POST)
	public JSONArray GroupNameValues(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside GroupNameValues Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String categoryname = request.getParameter("categoryname");

			String company = request.getParameter("branchname");
			// System.out.println("categoryname is = " + categoryname);

			JSONArray final_response = AllMasters.GroupNameValues(categoryname, company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("GroupNameValues GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/SubCategoryMasterListing" }, method = RequestMethod.POST)
	public JSONArray SubCategoryMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SubCategoryMasterListing Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.SubCategoryMasterListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SiteMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/updateGroupMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateGroupMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateGroupMasterSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String categorynameupdate = request.getParameter("categorynameupdate");
			String groupnameupdate = request.getParameter("groupnameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("categorynameupdate is = " + categorynameupdate);
			// System.out.println("groupnameupdate is = " +groupnameupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updateGroupMasterSave(categorynameupdate, groupnameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateGroupMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deletegroup" }, method = RequestMethod.POST)
	public JSONArray deletegroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deletegroup Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteGroup(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteGroup GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DepartmentDetails" }, method = RequestMethod.POST)
	public JSONArray DepartmentDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DepartmentDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.DepartmentDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DepartmentDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/add_Department" }, method = RequestMethod.POST)
	public JSONArray add_Department(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside add_Department Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String department = request.getParameter("department");

			// System.out.println("department is = " + department);

			String final_response = AllMasters.add_Department(department);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateDepartmentMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateDepartmentMasterSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside updateDepartmentMasterSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String departmentnameupdate = request.getParameter("departmentnameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("departmentnameupdate is = " + departmentnameupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updateDepartmentMasterSave(departmentnameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateDepartmentMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteDepartment" }, method = RequestMethod.POST)
	public JSONArray DeleteDepartment(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteDepartment Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.DeleteDepartment(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteDepartment GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/PriorityDetails" }, method = RequestMethod.POST)
	public JSONArray PriorityDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside PriorityDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.PriorityDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("PriorityDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/addpriority" }, method = RequestMethod.POST)
	public JSONArray addpriority(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addpriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String priority = request.getParameter("priority");
			String company = request.getParameter("company");
			// System.out.println("priority is = " + priority);
			// System.out.println("company is = " + company);

			String final_response = AllMasters.addPriority(priority, company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updatePriorityMasterSave" }, method = RequestMethod.POST)
	public JSONArray updatePriorityMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updatePriorityMasterSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String prioritynameupdate = request.getParameter("prioritynameupdate");
			String companyName = request.getParameter("company");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("prioritynameupdate is = " + prioritynameupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updatePriorityMasterSave(companyName, prioritynameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatePriorityMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/Deletepriority" }, method = RequestMethod.POST)
	public JSONArray DeletePriority(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeletePriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.DeletePriority(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeletePriority GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/RequestModeDetails" }, method = RequestMethod.POST)
	public JSONArray RequestModeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside RequestModeDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.RequestModeDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("RequestModeDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/addRequestMode" }, method = RequestMethod.POST)
	public JSONArray addRequestMode(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addRequestMode Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String requestmode = request.getParameter("requestmode");

			// System.out.println("priority is = " + requestmode);

			String final_response = AllMasters.addRequestMode(requestmode, company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addRequestMode GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateRequestModeSave" }, method = RequestMethod.POST)
	public JSONArray updateRequestModeSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateRequestModeSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String requestmodeupdate = request.getParameter("requestmodeupdate");
			String companyupdate = request.getParameter("companyupdate");

			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("requestmodeupdate is = " + requestmodeupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updateRequestModeSave(requestmodeupdate, cr_no, companyupdate);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateRequestModeSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteRequestMode" }, method = RequestMethod.POST)
	public JSONArray DeleteRequestMode(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteRequestMode Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.DeleteRequestMode(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteRequestMode GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addAdminMasterDetails" }, method = RequestMethod.POST)
	public JSONArray addAdminMasterDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addAdminMasterDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.addAdminDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addAdminMasterDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/ADDAdminMaster" }, method = RequestMethod.POST)
	public JSONArray ADDAdminMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ADDAdminMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String cpass = request.getParameter("cpass");

			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("cpass is = " + cpass);

			String final_response = AllMasters.ADDAdminMaster(cno, user, pass, cpass);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDAdminMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteAdmin" }, method = RequestMethod.POST)
	public JSONArray DeleteAdmin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteAdmin Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.DeleteAdmin(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteAdmin GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/BranchNameValues" }, method = RequestMethod.POST)
	public JSONArray BranchNameValues(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside BranchNameValues Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String bname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.BranchNameValues(company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("BranchNameValues GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/UserNameValues" }, method = RequestMethod.POST)
	public JSONArray UserNameValues(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside UserNameValues Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String names = null;

		try {
			out = response.getWriter();
			String branchname = request.getParameter("branchname");
			String companyname = request.getParameter("company");
			String department = request.getParameter("departmentname");

			// System.out.println("branchname is = " + branchname);
			// System.out.println("branchname is = " + branchname);
			JSONArray final_response = AllMasters.UserNameValues(companyname, branchname, department);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("UserNameValues GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/EnggNameValues" }, method = RequestMethod.POST)
	public JSONArray EnggNameValues(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside EnggNameValues Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String names = null;

		try {
			out = response.getWriter();
			String SELECTEDCompany = request.getParameter("SELECTEDCompany");
			String SELECTEDLocation = request.getParameter("SELECTEDLocation");

			JSONArray final_response = AllMasters.EnggNameValues(SELECTEDCompany, SELECTEDLocation);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("EnggNameValues GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/DownloadFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) throws IOException {

		String filename1 = request.getParameter("filename");
		// System.out.println("filename1 "+filename1);

		String filename = "C:\\ITHelpDesk\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename "+file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		return responseEntity;
	}

	@RequestMapping(value = { "/SubmitEscalationDetails" }, method = RequestMethod.POST)
	public JSONArray SubmitSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SubmitEscalationDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String engLevel = request.getParameter("engLevel");
			String companyname = request.getParameter("cmpnyname");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String designation = request.getParameter("designation");
			String username = request.getParameter("username");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));

			// System.out.println("engLevel is = " + engLevel);
			// System.out.println("days is = " + days);
			// System.out.println("hours is = " + hours);
			// System.out.println("minutes is = " + minutes);
			// System.out.println("seconds is = " + seconds);

			String final_response = AllMasters.SubmitEscalationDetails(engLevel, days, hours, minutes, seconds,
					companyname, priority, severity, designation, username);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SubmitEscalationDetails GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/EscalationMasterListing" }, method = RequestMethod.POST)
	public JSONArray EscalationMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside EscalationMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String escMasterList = null;
			JSONArray final_response = AllMasters.EscalationMasterListing(escMasterList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SLAMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getCompanyPriority" }, method = RequestMethod.POST)
	public JSONArray getCompanyPriority(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyPriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("companyName");

			JSONArray final_response = AllMasters.getCompanyPriority(company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getCompanySeverity" }, method = RequestMethod.POST)
	public JSONArray getCompanySeverity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyPriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("companyName");

			JSONArray final_response = AllMasters.getCompanySeverity(company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteEscalation" }, method = RequestMethod.POST)
	public JSONArray deleteEscalation(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteEscalation Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = (request.getParameter("company"));
			String level = (request.getParameter("level"));
			// System.out.println("escalationLevel is = " + company);

			String final_response = AllMasters.deleteEscalation(company, level);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteSLA GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deleteAutoAssignMaster" }, method = RequestMethod.POST)
	public JSONArray deleteAutoAssignMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteAutoAssignMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String srno = (request.getParameter("srno"));

			// System.out.println("srno is = " + srno);

			String final_response = AllMasters.deleteAutoAssignMaster(srno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteAutoAssignMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getProblemCategoryDetailsList" }, method = RequestMethod.POST)
	public JSONArray getProblemCategoryDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getProblemCategoryDetailsList
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getProblemCategoryDetailsList(catname);

			// System.out.println("getProblemCategoryDetails reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("PROBLEM CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getProblemSubCategory1" }, method = RequestMethod.POST)
	public JSONArray getProblemSubCategory1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getProblemSubCategory1 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getProblemSubCategory1(subcat1);

			// System.out.println("getProblemSubCategory2 reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getProblemSubCategory1 NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getProblemSubCategory2" }, method = RequestMethod.POST)
	public JSONArray getProblemSubCategory2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getProblemSubCategory2 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getProblemSubCategory2(subcat2);

			// System.out.println("getProblemSubCategory2 reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getProblemSubCategory2 NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/addProblemCategory" }, method = RequestMethod.POST)
	public JSONArray addProblemCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addProblemCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");

			// System.out.println("category is = " + category);
			// System.out.println("subcategory1 is = " + subcategory1);
			// System.out.println("subcategory2 is = " + subcategory2);

			String final_response = AllMasters.addProblemCategory(category, subcategory1, subcategory2);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addProblemCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ProblemCategoryListing" }, method = RequestMethod.POST)
	public JSONArray ProblemCategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ProblemCategoryListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			String problemCatList = null;
			JSONArray final_response = AllMasters.ProblemCategoryListing(problemCatList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("ProblemCategoryListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteProblemCategory" }, method = RequestMethod.POST)
	public JSONArray deleteProblemCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteProblemCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			String final_response = AllMasters.deleteProblemCategory(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("deleteProblemCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getSubCategory1Name" }, method = RequestMethod.POST)
	public JSONArray getSubCategory1Name(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategory1Name Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subcat1name = request.getParameter("subcat1name");

			// System.out.println();
			JSONArray final_response = AllMasters.getSubCategory1Name(subcat1name);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSubCategory1Name GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getSubCategory2Name" }, method = RequestMethod.POST)
	public JSONArray getSubCategory2Name(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategory2Name Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subcat2name = request.getParameter("subcat2name");
			String ProblemCategory = request.getParameter("ProblemCategory");

			// System.out.println();
			JSONArray final_response = AllMasters.getSubCategory2Name(subcat2name, ProblemCategory);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSubCategory2Name GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ViewProblemcloseTicket" }, method = RequestMethod.POST)
	public JSONArray ViewProblemcloseTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ViewProblemcloseTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.ViewProblemcloseTicket(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ViewProblemcloseTicket SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/saveAuthenticatorType" }, method = RequestMethod.POST)
	public JSONArray saveAuthenticatorType(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside saveAuthenticatorType Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mfaType = request.getParameter("mfaType");

			// System.out.println("mfaType is = " + mfaType);

			String final_response = AllMasters.addMFAType(mfaType);

			// System.out.println("saveAuthenticatorType reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("saveAuthenticatorType GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateTheme" }, method = RequestMethod.POST)
	public JSONArray updateTheme(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateTheme Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String type = request.getParameter("type");
			String value = request.getParameter("value");

			// System.out.println("type is = " + type);
			// System.out.println("value is = " + value);

			String final_response = AllMasters.updateTheme(type, value);

			// System.out.println("THEME UPDATE reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getThemeData" }, method = RequestMethod.POST)
	public JSONArray getThemeData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getThemeData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String nodata = "";

			JSONArray final_response = AllMasters.getThemeData(nodata);
			// System.out.println("getThemeData reponse is = " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getINCSubCategory1Name" }, method = RequestMethod.POST)
	public JSONArray getINCSubCategory1Name(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getINCSubCategory1Name Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String Category = request.getParameter("Category");
			String companyname = request.getParameter("companyname");
			// System.out.println("comapny name "+ companyname);
			// System.out.println();
			JSONArray final_response = AllMasters.getINCSubCategory1Name(Category, companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getINCSubCategory1Name GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getINCSubCategory2Name" }, method = RequestMethod.POST)
	public JSONArray getINCSubCategory2Name(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getINCSubCategory2Name Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subcat1name = request.getParameter("subcat1name");
			String Category = request.getParameter("Category");
			String companyname = request.getParameter("companyname");

			// System.out.println();
			JSONArray final_response = AllMasters.getINCSubCategory2Name(Category, subcat1name, companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getINCSubCategory2Name GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getINCPriorityAndSeverityName" }, method = RequestMethod.POST)
	public JSONArray getINCPriorityAndSeverityName(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getINCPriorityAndSeverityName
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String Category = request.getParameter("Category");
			String subcat1name = request.getParameter("subcat1name");
			String subcat2name = request.getParameter("subcat2name");
			String companyname = request.getParameter("companyname");

			// System.out.println();
			JSONArray final_response = AllMasters.getINCPriorityAndSeverityName(Category, subcat1name, subcat2name,
					companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getINCPriorityAndSeverityName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getCompositeCompanyList" }, method = RequestMethod.POST)
	public JSONArray getCompositeCompanyList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositeCompanyList();

			// System.out.println("getCompositeCompanyList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeCompanyList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCompositeBranchList" }, method = RequestMethod.POST)
	public JSONArray getProblemCompositeBranchList(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCompositeBranchList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositeBranchList();

			// System.out.println("getCompositeBranchList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeBranchList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCompositeLocationList" }, method = RequestMethod.POST)
	public JSONArray getCompositeLocationList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeLocationList Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositeLocationList(subcat2);

			// System.out.println("getProblemCompositeLocationList reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getProblemCompositeLocationList NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCompositeDepartment" }, method = RequestMethod.POST)
	public JSONArray getCompositeDepartment(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeDepartment Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositeDepartment(subcat2);

			// System.out.println("getCompositeDepartment reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompositeDepartment NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCompositeSubDepartment" }, method = RequestMethod.POST)
	public JSONArray getProblemCompositeSubDepartment(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getProblemCompositeLocationList
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompositeSubDepartment(subcat2);

			// System.out.println("getProblemCompositeLocationList reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getProblemCompositeLocationList NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/CompositeListing" }, method = RequestMethod.POST)
	public JSONArray ProblemCompositeListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ProblemCompositeListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			String problemCatList = null;
			JSONArray final_response = AllMasters.CompositeListing(problemCatList);

			// System.out.println("ProblemCompositeListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("ProblemCompositeListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/addComposite" }, method = RequestMethod.POST)
	public JSONArray addProblemComposite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addComposite Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String branch = request.getParameter("branch");
			String location = request.getParameter("location");
			String department = request.getParameter("department");
			String subDepartment = request.getParameter("subDepartment");

			// System.out.println("company is = " + company);
			// System.out.println("branch is = " + branch);
			// System.out.println("location is = " + location);
			// System.out.println("department is = " + department);
			// System.out.println("subDepartment is = " + subDepartment);

			String final_response = AllMasters.addComposite(company, branch, location, department, subDepartment);

			// System.out.println("addComposite reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addComposite GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteComposite" }, method = RequestMethod.POST)
	public JSONArray deleteProblemComposite(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteComposite Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			String final_response = AllMasters.deleteComposite(crno);

			// System.out.println("deleteComposite reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("deleteComposite GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getBranchForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getBranchForLoginMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getBranchForLoginMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String companyname = request.getParameter("companyname");
		String location = request.getParameter("location");
		// System.out.println("companyname is = " + companyname+" location::"+location);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getBranchForLoginMaster(companyname, location);

			// System.out.println("getBranchForLoginMaster reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getBranchForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getLocationForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getLocationForLoginMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getProblemCompositeLocationList
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		String companyname = request.getParameter("companyname");
		String branchName = request.getParameter("branchName");
		// System.out.println("companyname is = " + companyname);
		// System.out.println("branch name::"+branchName);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getLocationForLoginMaster(companyname);

			// System.out.println("getProblemCompositeLocationList reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getProblemCompositeLocationList NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/DeleteLoginMasterData" }, method = RequestMethod.POST)
	public JSONArray DeleteLoginMasterData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteLoginMasterData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.DeleteLoginMasterData(crno);

			// System.out.println("DeleteLoginMasterData reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("delete DeleteLoginMasterData GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getDepartmentForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getDepartmentForLoginMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getProblemCompositeDepartment
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		String companyname = request.getParameter("companyname");

		// System.out.println("companyname is = in " + companyname);

		String branchName = request.getParameter("branchName");

		// System.out.println("branchName is = " + branchName);
		String location = request.getParameter("location");

		// System.out.println("location is = " + location);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getDepartmentForLoginMaster(companyname, branchName, location);

			// System.out.println("getProblemCompositeDepartment reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getProblemCompositeDepartment NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubDepartmentForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getSubDepartmentForLoginMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubDepartmentForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		String companyname = request.getParameter("companyname");

		// System.out.println("companyname is = " + companyname);

		String branchName = request.getParameter("branchName");

		// System.out.println("branchName is = " + branchName);
		String location = request.getParameter("location");

		// System.out.println("location is = " + location);
		String departmentName = request.getParameter("departmentName");

		// System.out.println("departmentName is = " + departmentName);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSubDepartmentForLoginMaster(companyname, branchName, location,
					departmentName);

			// System.out.println("getSubDepartmentForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubDepartmentForLoginMaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/updateUserLoginMaster" }, method = RequestMethod.POST)
	public JSONArray updateUserLoginMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateUserLoginMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String mail = request.getParameter("mailupdate");
			String cno = request.getParameter("cnoupdate");
			String user = request.getParameter("userupdate");
			String pass = request.getParameter("passupdate");
			String fname = request.getParameter("fnameupdate");
			String lname = request.getParameter("lnameupdate");
			String cpass = request.getParameter("passupdate");
			String cname = request.getParameter("cnameupdate");
			String sname = request.getParameter("snameupdate");
			String dname = request.getParameter("dnameupdate");
			String location = request.getParameter("locationupdate");
			String englevel = request.getParameter("englevelupdate");
			String rtypeupdate = request.getParameter("rtypeupdate");
			String subdnameupdate = request.getParameter("subdnameupdate");
			String vipLogin = request.getParameter("vipLogin");
			String updategroup = request.getParameter("updategroup");
			String updatecategory = request.getParameter("updatecategory");
			String designation = request.getParameter("designation");
			String groupMultiserupdate = request.getParameter("groupMultiserupdate");
			String visibilityupdate = request.getParameter("visibilityupdate");
			String row = request.getParameter("row");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			String OnlyCategroy = "";
			String string = "";
			if (!updatecategory.equals("NA")) {
				String[] str1 = updatecategory.split(",");
				List<String> list = new ArrayList<>();
				for (int i = 0; i < str1.length; i++) {
					String catw = str1[i];
					System.out.println(catw);
					String[] split = catw.split("~");
					list.add(split[1]);
				}

				for (int i = 0; i < list.size(); i++) {
					String findcat = list.get(i);
					if (OnlyCategroy.equals("")) {
						OnlyCategroy = findcat;
					} else {
						OnlyCategroy = OnlyCategroy + "," + findcat;
					}
				}
			}
			String finalvalue = "";
			if (rtypeupdate.equals("Ticket Co-ordinator")) {
				updategroup = groupMultiserupdate;
			} else if (rtypeupdate.equals("Engineer")) {
				String[] value1 = null;

				value1 = updategroup.split(",");
				for (String value2 : value1) {
					finalvalue = finalvalue.concat(value2.substring(0, value2.indexOf("~")) + ",");
				}

				updategroup = finalvalue.substring(0, finalvalue.length() - 1);
			}

			//// System.out.println("sdfgsdfdf dfgsd gfg "+finalvalue);
			// System.out.println("groupMultiserupdate is = " + groupMultiserupdate);
			// System.out.println("visibilityupdate is = " + visibilityupdate);

			// System.out.println("updategroup is = " + updategroup);
			// System.out.println("updatecategory is = " + updatecategory);
			// System.out.println("vipLogin is = " + vipLogin);
			// System.out.println("subdnameupdate is = " + subdnameupdate);
			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);
			// System.out.println("category is = " + location);
			// System.out.println("englevel is = " + englevel);
			// System.out.println("row:-" + row);

			String selectedSideBarValuesFinal = request.getParameter("selectedSideBarValuesFinal");
			String final_response = AllMasters.updateUserLoginMaster(mail, cno, user, pass, fname, lname, cpass, cname,
					sname, dname, location, cr_no, englevel, rtypeupdate, row, subdnameupdate, vipLogin, OnlyCategroy,
					updategroup, designation, visibilityupdate, updatecategory, selectedSideBarValuesFinal);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateAddEnggSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCompanyDetailsForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getCompanyDetailsForLoginMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyDetailsForLoginMaster();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getDepartmentForUserScope" }, method = RequestMethod.POST)
	public JSONArray getDepartmentForUserScope(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartmentForUserScope Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		// String subcat2 = null;

		String companyname = request.getParameter("companyname");

		// System.out.println("companyname is = " + companyname);

		String branchName = request.getParameter("branchName");

		// System.out.println("branchName is = " + branchName);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getDepartmentForUserScope(companyname, branchName);

			// System.out.println("getDepartmentForUserScope reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getDepartmentForUserScope NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getLoginMasterDetails" }, method = RequestMethod.POST)
	public JSONArray getLoginMasterDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getLoginMasterDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getLoginMasterDetails(userlist);
			out.print(final_response);
//			//System.out.println("getLoginMasterDetails reponse is = " + final_response);

			// System.out.println("getLoginMasterDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/addLoginMasterData" }, method = RequestMethod.POST)
	public JSONArray addLoginMasterData(@RequestParam("row") String row,
			@RequestParam("categoryMulti1") String categoryMulti1, @RequestParam("groupMulti1") String groupMulti1,
			@RequestParam("groupMultiservice") String groupMultiservice,
			@RequestParam("vipLoginVal") String vipLoginVal, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside addLoginMasterData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			// System.out.println("row OUTPUT: " +row);

			String mail = request.getParameter("mail");
			String cno = request.getParameter("cno");
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String cpass = request.getParameter("cpass");
			String cname = request.getParameter("cname");
			String sname = request.getParameter("sname");
			String dname = request.getParameter("dname");

			String englevel = request.getParameter("englevel");
			String location = request.getParameter("location");
			String subDepartment = request.getParameter("subDepartment");
			String rtype = request.getParameter("rtype");
			String designation = request.getParameter("designation");
			String visibility = request.getParameter("visibility");
			// String groupMultiser = request.getParameter("groupMultiser");
			String selectedSideBarValuesFinal = request.getParameter("selectedSideBarValuesFinal");
			
			
			String gender = request.getParameter("gender");

			String vipLogin = vipLoginVal;

			String str = "";

			if (rtype.equals("Ticket Co-ordinator")) {
				groupMulti1 = groupMultiservice;
			} else if (rtype.equals("Engineer")) {
				String[] value1 = null;
				String finalvalue = "";

				value1 = groupMulti1.split(",");
				for (String value2 : value1) {

					finalvalue = finalvalue.concat(value2.substring(0, value2.indexOf("~")) + ",");

				}

				finalvalue = finalvalue.substring(0, finalvalue.length() - 1);
				groupMulti1 = finalvalue;

				// System.out.println("FINAL TO FINAL VALUE IS "+ finalvalue);
				// System.out.println("FINAL VALUE "+ finalvalue);

			}
			// System.out.println("groupMultiservice is = " + groupMultiservice);
			 System.out.println("gender " + gender);
			// System.out.println("categoryMulti is = " + categoryMulti1);
			// System.out.println("groupMulti is = " + groupMulti1);
			// System.out.println("vipLogin is = " + vipLogin);
			 System.out.println("rtype is = " + rtype);
			// System.out.println("subDepartment is = " + subDepartment);
			// System.out.println("location is = " + location);
			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);

			// System.out.println("Engg Level is = " + englevel);
			String category = "";
			String FinalCategries = "";
			if (rtype.equals("Engineer")) {

				List<String> list = new ArrayList<>();
				String[] split = categoryMulti1.split(",");

				for (int i = 0; i < split.length; i++) {
					String fistCat = split[i];
					String[] split2 = fistCat.split("~");
					list.add(split2[1]);
				}

				for (int i = 0; i < list.size(); i++) {
					String findcat = list.get(i);
					if (FinalCategries.equals("")) {
						FinalCategries = findcat;
//					 System.out.println("B"+a);
					} else {
						FinalCategries = FinalCategries + "," + findcat;
					}
				}
			}
			String final_response = AllMasters.addUserInLoginMaster(mail, cno, user, pass, fname, lname, cpass, cname,
					sname, dname, subDepartment, englevel, location, rtype, row, vipLogin, FinalCategries, groupMulti1,
					designation, visibility, categoryMulti1, selectedSideBarValuesFinal,gender);

			// System.out.println("addLoginMasterData reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addLoginMasterData GET SUCCESS");

		} catch (Exception e) {
			// System.out.println("Exception in addLoginMasterData Controller:-"+e);
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCompanyDetailsForTicketTagMaster" }, method = RequestMethod.POST)
	public JSONArray getCompanyDetailsForTicketTagMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForTicketTagMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyDetailsForTicketTagMaster();

			// System.out.println("getCompanyDetailsForTicketTagMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForTicketTagMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/TicketTagDetails" }, method = RequestMethod.POST)
	public JSONArray TicketTagDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside TicketTagDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.TicketTagDetails();

			// System.out.println("TicketTagDetails reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("TicketTagDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/getDepartmentForTicketTagMaster" }, method = RequestMethod.POST)
	public JSONArray getDepartmentForTicketTagMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getDepartmentForTicketTagMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		String companyname = request.getParameter("companyname");

		// System.out.println("companyname is = " + companyname);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getDepartmentForTicketTagMaster(companyname);

			// System.out.println("getDepartmentForTicketTagMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getDepartmentForTicketTagMaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/deleteTicketTag" }, method = RequestMethod.POST)
	public JSONArray deleteTicketTag(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteTicketTag Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteTicketTag(crno);

			// System.out.println("deleteTicketTag reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteTicketTag GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addTicketTag" }, method = RequestMethod.POST)
	public JSONArray addTicketTag(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addTicketTag Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String cname = request.getParameter("cname");
			String ticketTag = request.getParameter("ticketTag");
			String dname = request.getParameter("dname");

			// System.out.println("cname is = " + cname);
			// System.out.println("ticketTag is = " + ticketTag);
			// System.out.println("dname is = " + dname);

			String final_response = AllMasters.addTicketTag(cname, ticketTag, dname);

			// System.out.println("MastersControllerrrr addTicketTag reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("addTicketTag GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateTicketTagyMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateTicketTagyMasterSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside updateTicketTagyMasterSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String updatecname = request.getParameter("updatecname");
			String updatedname = request.getParameter("updatedname");
			String tagforsave = request.getParameter("tagforsave");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("updatecname is = " + updatecname);
			// System.out.println("updatedname is = " + updatedname);
			// System.out.println("tagforsave is = " + tagforsave);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updateTicketTagyMasterSave(updatecname, cr_no, updatedname, tagforsave);

			// System.out.println("updateTicketTagyMasterSave reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("updateTicketTagyMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getCategoryForLoginMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCategoryForLoginMaster Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		// String subcat2 = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("companyname");
			JSONArray final_response = AllMasters.getCategoryForLoginMaster(company);

			// System.out.println("getCategoryForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryForLoginMaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getGroupForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getGroupForLoginMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getGroupForLoginMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("companyname");

			// System.out.println("");
			JSONArray final_response = AllMasters.getGroupForLoginMaster(company);

			// System.out.println("getGroupForLoginMaster reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getGroupForLoginMaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getGroupForPerticularUser" }, method = RequestMethod.POST)
	public JSONArray getGroupForPerticularUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getGroupForPerticularUser Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		// String subcat2 = null;

		String username = request.getParameter("username");

		String company1 = request.getParameter("company2");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getGroupForPerticularUser(username, company1);

			// System.out.println("getGroupForPerticularUser reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryForPerticularUser NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCategoryForPerticularUser" }, method = RequestMethod.POST)
	public JSONArray getCategoryForPerticularUser(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryForPerticularUser
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		String username = request.getParameter("username");
		String company = request.getParameter("company2");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCategoryForPerticularUser(username, company);

			// System.out.println("getCategoryForPerticularUser reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryForPerticularUser NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getUserScopeForUpadte" }, method = RequestMethod.POST)
	public JSONArray getUserScopeForUpadte(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getUserScopeForUpadte Controller@@@@@@@@@@@@ ");

		String username = request.getParameter("username");
		String E_id = request.getParameter("E_id");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getUserScopeForUpadte(username, E_id);

			// System.out.println("getUserScopeForUpadte reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getUserScopeForUpadte SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/updateUserPassword" }, method = RequestMethod.POST)
	public JSONArray updateUserPassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateUserPassword Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");
			String loginid = request.getParameter("loginid");

			// System.out.println("username is = " + username);
			// System.out.println("password is = " + password);
			// System.out.println("confirmPassword:-" + confirmPassword);
			// System.out.println("loginid:-" + loginid);

			String final_response = AllMasters.updateUserPassword(username, password, confirmPassword, loginid);

			// System.out.println("updateUserPasswors reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateUserPasswors GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsList" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCategoryDetailsList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("cname");
			//// System.out.println("edtgertyd");
			JSONArray final_response = AllMasters.getCategoryDetailsList(catname, company);

			// System.out.println("getCategoryDetailsList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCategoryDetailsList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsListforcatalogue" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsListforcatalogue(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryDetailsListforcatalogue
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getCategoryDetailsListforcatalogue(company);

			// System.out.println("getCategoryDetailsListforcatalogue reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryDetailsListforcatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory1forcatalogue" }, method = RequestMethod.POST)
	public JSONArray getSubCategory1forcatalogue(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubCategory1forcatalogue Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getSubCategory1forcatalogue(company);

			// System.out.println("getSubCategory1forcatalogue reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubCategory1forcatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory2forcatalogue" }, method = RequestMethod.POST)
	public JSONArray getSubCategory2forcatalogue(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubCategory2forcatalogue Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getSubCategory2forcatalogue(company);

			// System.out.println("getSubCategory2forcatalogue reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubCategory2forcatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubjectforcatforcatalogue" }, method = RequestMethod.POST)
	public JSONArray getSubjectforcatforcatalogu(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubjectforcatforcatalogu Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getSubjectforcatforcatalogu(company);

			// System.out.println("getSubjectforcatforcatalogu reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubjectforcatforcatalogu GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSeverityNameforcatalogue" }, method = RequestMethod.POST)
	public JSONArray getSeverityNameforcatalogue(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSeverityNameforcatalogue Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getSeverityNameforcatalogue(company);

			// System.out.println("getSeverityNameforcatalogue reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSeverityNameforcatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getPriorityNameforcatalogue" }, method = RequestMethod.POST)
	public JSONArray getPriorityNameforcatalogue(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getPriorityNameforcatalogue Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getPriorityNameforcatalogue(company);

			// System.out.println("getPriorityNameforcatalogue reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getPriorityNameforcatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory1" }, method = RequestMethod.POST)
	public JSONArray getSubCategory1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategory1 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String category = request.getParameter("category");
			JSONArray final_response = AllMasters.getSubCategory1(company, category, subcat1);

			// System.out.println("getSubCategory1 reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSubCategory1 NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory2" }, method = RequestMethod.POST)
	public JSONArray getSubCategory2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubCategory2 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");

			// System.out.println("dfghdghfghdfgh"+subcategory1+"ftgdg"+company+"sdfdf"+category);
			JSONArray final_response = AllMasters.getSubCategory2(company, category, subcategory1, subcat2);

			// System.out.println("getSubCategory2 reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSubCategory2 NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/CategoryListing" }, method = RequestMethod.POST)
	public JSONArray CategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside CategoryListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			String problemCatList = null;
			JSONArray final_response = AllMasters.CategoryListing(problemCatList);

			// System.out.println("CategoryListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("CategoryListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/addNewCategory" }, method = RequestMethod.POST)
	public JSONArray addNewCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addNewCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			// System.out.println("company is = " + company);
			// System.out.println("category is = " + category);
			// System.out.println("subcategory1 is = " + subcategory1);
			// System.out.println("subcategory2 is = " + subcategory2);
			// System.out.println("priority is = " + priority);
			// System.out.println("severity is = " + severity);
			String final_response = AllMasters.addNewCategory(company, category, subcategory1, subcategory2, priority,
					severity);

			// System.out.println("addNewCategory reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addNewCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public JSONArray deleteCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			String final_response = AllMasters.deleteCategoryFromMaster(crno);

			// System.out.println("deleteCategory reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("deleteCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getOutageCompanyName" }, method = RequestMethod.POST)
	public JSONArray getOutageCompanyName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getOutageCompanyName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String companyname = null;

			JSONArray final_response = AllMasters.getOutageCompanyName(companyname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("getOutageCompanyName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getOutageBranchName" }, method = RequestMethod.POST)
	public JSONArray getOutageBranchName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getOutageBranchName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String companyname = request.getParameter("companyname");
		// System.out.println("companyname is = " + companyname);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getOutageBranchName(companyname);

			// System.out.println("getOutageBranchName reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("getOutageBranchName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getOutageDepartmentName" }, method = RequestMethod.POST)
	public JSONArray getOutageDepartmentName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getOutageDepartmentName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String companyname = request.getParameter("companyname");
		String branchName = request.getParameter("branchName");
		// System.out.println("companyname is = " + companyname);
		// System.out.println("branchName is = " + branchName);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getOutageDepartmentName(companyname, branchName);

			// System.out.println("getOutageDepartmentName reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("getOutageDepartmentName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/SeverityDetails" }, method = RequestMethod.POST)
	public JSONArray SeverityDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SeverityDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.SeverityDetails(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SeverityDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/addSeverity" }, method = RequestMethod.POST)
	public JSONArray addSeverity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addpriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String severity = request.getParameter("Severity");
			String company = request.getParameter("company");
			// System.out.println("Severity is = " + severity);

			String final_response = AllMasters.addSeverity(company, severity);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateSeverityMasterSave" }, method = RequestMethod.POST)
	public JSONArray updateSeverityMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updatePriorityMasterSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String Severitynameupdate = request.getParameter("Severitynameupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));
			String companyName = request.getParameter("company");
			// System.out.println("Severitynameupdate is = " + Severitynameupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updateSeverityMasterSave(companyName, Severitynameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateSeverityMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DeleteSeverity" }, method = RequestMethod.POST)
	public JSONArray DeleteSeverity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeletePriority Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.DeleteSeverity(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteSeverity GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getSubject" }, method = RequestMethod.POST)
	public JSONArray getSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSubject(subject);

			// System.out.println("getSubject reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/addNewSubject" }, method = RequestMethod.POST)
	public JSONArray addNewSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addNewSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String subject = request.getParameter("subject");
			// System.out.println("company is = " + company);
			// System.out.println("category is = " + category);
			// System.out.println("subcategory1 is = " + subcategory1);
			// System.out.println("subcategory2 is = " + subcategory2);
			// System.out.println("subject is = " + subject);
			String final_response = AllMasters.addNewSubject(company, category, subcategory1, subcategory2, subject);

			// System.out.println("addNewSubject reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addNewSubject GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/SubjectListing" }, method = RequestMethod.POST)
	public JSONArray SubjectListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SubjectListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.SubjectListing(subjectList);

			// System.out.println("SubjectListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("SubjectListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteSubject" }, method = RequestMethod.POST)
	public JSONArray deleteSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteSubject(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteSubject GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getINCSubject" }, method = RequestMethod.POST)
	public JSONArray getINCSubject(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getINCSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String company = request.getParameter("company");
		String Category = request.getParameter("Category");
		String subcat1name = request.getParameter("subcat1name");
		String subcat2name = request.getParameter("subcat2name");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getINCSubject(company, Category, subcat1name, subcat2name);

			// System.out.println("getINCSubject reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getINCSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/addNewServiceCatalogue" }, method = RequestMethod.POST)
	public JSONArray addNewServiceCatalogue(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addNewServiceCatalogue Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String subject = request.getParameter("subject");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");

			String servicerequesttype = request.getParameter("servicestandard");
			String group_name = request.getParameter("groupselect");
			String levelone = request.getParameter("levelone");
			String leveltwo = request.getParameter("leveltwo");
			String Designationlevel2 = request.getParameter("Designarionlevel2");
			String Designationlevel1 = request.getParameter("Designarionlevel1");
			String SUBJECT_TYPE = request.getParameter("SUBJECT_TYPE");
			System.out.println("SUBJECT_TYPE IOS " + SUBJECT_TYPE);
			if (SUBJECT_TYPE == null || SUBJECT_TYPE == "") {
				SUBJECT_TYPE = "NA";
			}

			// System.out.println(" for checking 2");
			String requestcost = request.getParameter("requestcost");
			String Approval_level = "";
			// System.out.println(" for checking ");
			// System.out.println("servicerequesttype is = " + servicerequesttype);
			// System.out.println("group_name is = " + group_name);
			// System.out.println("levelone is = " + levelone);
			// System.out.println("leveltwo is = " + leveltwo);
			// System.out.println("Designationlevel1 is = " + Designationlevel1);
			// System.out.println("Designationlevel2 is = " + Designationlevel2);

			/*
			 * if(Designationlevel2.equals("")) { Approval_level="Level-1";
			 * Designationlevel2="NA"; } else { Approval_level="Level-2"; }
			 */

			if (servicerequesttype.equals("Non Standard")) {
				if (Designationlevel2.equals("")) {
					Approval_level = "Level-1";
					Designationlevel2 = "NA";
				} else {
					Approval_level = "Level-2";
				}
			} else {

				Approval_level = "NA";
				Designationlevel2 = "NA";
				Designationlevel1 = "NA";
			}

			// System.out.println("company is = " + company);
			// System.out.println("category is = " + category);
			// System.out.println("subcategory1 is = " + subcategory1);
			// System.out.println("subcategory2 is = " + subcategory2);
			// System.out.println("subject is = " + subject);
			// System.out.println("priority is = " + priority);
			// System.out.println("severity is = " + severity);
			String final_response = AllMasters.addNewServiceCatalogue(company, category, subcategory1, subcategory2,
					subject, priority, severity, servicerequesttype, group_name, Approval_level, Designationlevel1,
					Designationlevel2, requestcost, SUBJECT_TYPE);

			// System.out.println("addNewSubject reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addNewSubject GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ServiceCatalogueListing" }, method = RequestMethod.POST)
	public JSONArray ServiceCatalogueListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ServiceCatalogueListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.ServiceCatalogueListing(subjectList);

			// System.out.println("ServiceCatalogueListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("ServiceCatalogueListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteServiceCatalogue" }, method = RequestMethod.POST)
	public JSONArray deleteServiceCatalogue(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteServiceCatalogue Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteServiceCatalogue(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteServiceCatalogue GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getServiceCatalogueSubject" }, method = RequestMethod.POST)
	public JSONArray getServiceCatalogueSubject(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getServiceCatalogueSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";
		String company = request.getParameter("company");
		System.out.println("COMPANY NAME ::" + company);
//		String Category = request.getParameter("Category");
//		String subcat1name = request.getParameter("subcat1name");
//		String subcat2name = request.getParameter("subcat2name");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getServiceCatalogueSubject(subject, company);

			System.out.println("getServiceCatalogueSubject reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSelectedServiceCatalogueData" }, method = RequestMethod.POST)
	public JSONArray getSelectedServiceCatalogueData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getSelectedServiceCatalogueData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subject = request.getParameter("subject");
			String company = request.getParameter("company");

			System.out.println();
			JSONArray final_response = AllMasters.getSelectedServiceCatalogueData(subject, company);

			System.out.println("getSelectedServiceCatalogueData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getSelectedServiceCatalogueData GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTemplateDetails" }, method = RequestMethod.POST)
	public JSONArray getTemplateDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getTemplateDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			// System.out.println();
			// String userlist=null;
			String userlist = request.getParameter("attribute");
			// System.out.println("ATTRIBUTE VALUE "+userlist);
			JSONArray final_response = AllMasters.getTemplateDetails(userlist);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/addTemplate" }, method = RequestMethod.POST)
	public JSONArray addTemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		// System.out.println("addTemplate Controller");
		try {
			out = response.getWriter();
			String templates = request.getParameter("templates");
			String companies = request.getParameter("companies");
			String attributename = request.getParameter("attributename");
			String final_response = AllMasters.addTemplate(templates, companies, attributename);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/DesignationMasterListing" }, method = RequestMethod.POST)
	public JSONArray DesignationMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DesignationMasterListing Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designationList = null;
			JSONArray final_response = AllMasters.DesignationMasterListing(designationList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DesignationMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/AddModule" }, method = RequestMethod.POST)
	public JSONArray AddModule(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");

			String final_response = AllMasters.AddModule(designation);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getModuleName" }, method = RequestMethod.POST)
	public JSONArray getModuleName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = AllMasters.getModuleList();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/UpdateDesignationup" }, method = RequestMethod.POST)
	public JSONArray UpdateDesignationup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateDesignationup(company, designation, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getModuleNameup" }, method = RequestMethod.POST)
	public JSONArray getModuleNameup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = AllMasters.getModuleNameup();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/SetFunction" }, method = RequestMethod.POST)
	public String productFunction(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String moduleName = request.getParameter("moduleName");
			String functionName = request.getParameter("functionName");

			out = response.getWriter();
			out.print(AllMasters.setFunctionDetails(moduleName, functionName));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/funclist" }, method = RequestMethod.POST)
	public JSONArray funclist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DesignationMasterListing Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designationList = null;
			JSONArray final_response = AllMasters.funclist(designationList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DesignationMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/Deletemodule" }, method = RequestMethod.POST)
	public JSONArray Deletemodule(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			String final_response = AllMasters.Deletemodule(crno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getresp1" }, method = RequestMethod.POST)
	public JSONArray getresp1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getresp1();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/Deleteresp" }, method = RequestMethod.POST)
	public JSONArray Deleteresp(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			String final_response = AllMasters.Deleteresp(crno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/Updateresponsibiity" }, method = RequestMethod.POST)
	public JSONArray Updateresponsibiity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			String roletype = request.getParameter("roletype");
			String module = request.getParameter("module");
			String function = request.getParameter("function");
			String checker = request.getParameter("checker");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.Updateresponsibiity(company, designation, srno, roletype, module,
					function, checker);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getresp1up" }, method = RequestMethod.POST)
	public JSONArray getresp1up(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getresp1up();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getresp2up" }, method = RequestMethod.POST)
	public JSONArray getresp2up(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getresp2up();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/Deletetandc" }, method = RequestMethod.POST)
	public JSONArray Deletetandc(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			String final_response = AllMasters.Deletetandc(crno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/tandcMasterListing" }, method = RequestMethod.POST)
	public JSONArray tandcMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DesignationMasterListing Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designationList = null;
			JSONArray final_response = AllMasters.tandcMasterListing(designationList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DesignationMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/Addtandc" }, method = RequestMethod.POST)
	public JSONArray Addtandc(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String tctype = request.getParameter("tctype");
			String comments = request.getParameter("comments");
			String ddrname1 = request.getParameter("ddrname1");

			String final_response = AllMasters.Addtandc(tctype, comments, ddrname1);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getresp2" }, method = RequestMethod.POST)
	public JSONArray getresp2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getresp2();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getresp" }, method = RequestMethod.POST)
	public JSONArray getresp(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getresp();

			// System.out.println("getCompanyDetailsForLoginMaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyDetailsForLoginMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/UpdateModule" }, method = RequestMethod.POST)
	public JSONArray UpdateModule(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.UpdateModule(designation, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/AddDesignationMaster" }, method = RequestMethod.POST)
	public JSONArray AddDesignationMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			String roletype = request.getParameter("roletype");
			String module = request.getParameter("module");
			String function = request.getParameter("function");
			String checker = request.getParameter("checker");

			String final_response = AllMasters.addDesignation(company, designation, roletype, module, function,
					checker);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/UpdateDesignation" }, method = RequestMethod.POST)
	public JSONArray UpdateDesignation(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateDesignation(company, designation, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/DeleteDesignation" }, method = RequestMethod.POST)
	public JSONArray DeleteDesignation(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			String final_response = AllMasters.deleteDesignation(crno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getDesignationForLoginMaster" }, method = RequestMethod.POST)
	public JSONArray getDesignationForLoginMaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");

			// System.out.println("company name is " +company);
			JSONArray final_response = AllMasters.getCompanyDesignation(company);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getServiceRequestFlowListing" }, method = RequestMethod.POST)
	public JSONArray getServiceRequestFlowListing(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getServiceRequestFlowListing
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String requestFlowList = null;
			JSONArray final_response = AllMasters.getServiceRequestFlowListing(requestFlowList);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DesignationMasterListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/addServiceRequestFlow" }, method = RequestMethod.POST)
	public JSONArray addServiceRequestFlow(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String requestName = request.getParameter("request");
			String designation = request.getParameter("designation");
			String approverName = request.getParameter("approverName");
			String department = request.getParameter("department");

			String final_response = AllMasters.addServiceRequestFlow(company, designation, requestName, approverName,
					department);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/updateServiceRequestFlow" }, method = RequestMethod.POST)
	public JSONArray updateServiceRequestFlow(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String requestName = request.getParameter("request");
			String approverName = request.getParameter("approverName");
			String department = request.getParameter("department");
			String designation = request.getParameter("designation");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateServiceRequestFlow(srno, company, designation, requestName,
					approverName, department);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/deleteServiceRequestFlow" }, method = RequestMethod.POST)
	public JSONArray deleteServiceRequestFlow(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteServiceRequestFlow(srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getApproverDetails" }, method = RequestMethod.POST)
	public JSONArray getApproverDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String designation = request.getParameter("designation");
			JSONArray final_response = AllMasters.getApproverDetails(company, designation);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	// merging
	@RequestMapping(value = { "/SaveCategory" }, method = RequestMethod.POST)
	public JSONArray SaveCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside SaveCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String Priorityname = request.getParameter("Priorityname");
			String Severityname = request.getParameter("Severityname");

			// System.out.println("category is 3:48 = " + category);
			// System.out.println("subcategory1 is 3:48= " + subcategory1);

			String final_response = AllMasters.SaveCategory(category, subcategory1, subcategory2, Priorityname,
					Severityname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addProblemCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getTemplateCategoryList" }, method = RequestMethod.POST)
	public JSONArray getTemplateCategoryList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getTemplateCategoryList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getTemplateCategoryList(catname);

			// System.out.println("getProblemCategoryDetails reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("PROBLEM CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/TemplateCategoryListing" }, method = RequestMethod.POST)
	public JSONArray TemplateCategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside TemplateCategoryListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String templisting = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.TemplateCategoryListing(templisting);

			// System.out.println("getTemplateSubCategoryList reponse isdddddddddddd = " +
			// final_response);

			out.print(final_response);

			// System.out.println("TEMPLATE CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

//	@RequestMapping(value = { "/getTemplateSubCategoryList" }, method = RequestMethod.POST)
//	public JSONArray getTemplateSubCategoryList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		//System.out.println("Inside getTemplateSubCategoryList Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String subcategory= null;
//	
//
//		try {
//			out = response.getWriter();
//			
//			JSONArray final_response = AllMasters.getTemplateSubCategoryList(subcategory);
//
//			//System.out.println("getTemplateSubCategoryList reponse is = " + final_response);
//						
//				out.print(final_response);
//						
//				//System.out.println("TEMPLATE CATEGORY NAME GET SUCCESS");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			out.close();
//		}
//
//		return null;
//
//	}
	@RequestMapping(value = { "/deleteTemplateCategory" }, method = RequestMethod.POST)
	public String deleteTemplateCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteTemplateCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			String final_response = AllMasters.deleteTemplateCategory(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("deleteTemplateCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/adintegtestlist" }, method = RequestMethod.POST)
	public String adintegtestlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			// System.out.println("Company namrwedwdwd"+company);
			String final_response = AllMasters.adintegtestlist(company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCompanyNames1" }, method = RequestMethod.POST)
	public JSONArray getCompanyNames(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyNames1 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String company = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyNames1(company);
			// getPriorityName
			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompanyNames1 GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getPriorityList" }, method = RequestMethod.POST)
	public JSONArray getPriorityList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getPriorityList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("comp");

			// System.out.println();
			JSONArray final_response = AllMasters.getPriorityList(company);
			;

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryList" }, method = RequestMethod.POST)
	public JSONArray getCategoryList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCategoryList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("comp");

			// System.out.println();
			JSONArray final_response = AllMasters.getCategoryList(company);
			;

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCompanyNamesinEmail" }, method = RequestMethod.POST)
	public JSONArray getCompanyNamesinEmail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyNamesinEmail Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String company = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyNamesinEmail(company);
			// getPriorityName
			// System.out.println("MastersControllerrrr reponse is email = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCompanyNamesinEmail GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/addPrioritytemplate" }, method = RequestMethod.POST)
	public JSONArray addPrioritytemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addPrioritytemplate Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String Attribute1 = request.getParameter("Attribute1");
			String Templatedeatil = request.getParameter("Templatedeatil");

			// System.out.println("Attribute1 is = " + Attribute1);
			// System.out.println("Templatedeatil is = " + Templatedeatil);

			String final_response = AllMasters.addPrioritytemplate(Attribute1, Templatedeatil);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/prioritytemplatelist" }, method = RequestMethod.POST)
	public JSONArray prioritytemplatelist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside prioritytemplatelist Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.prioritytemplatelist(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("prioritytemplatelist SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/deleteprioritytemplate" }, method = RequestMethod.POST)
	public JSONArray deleteprioritytemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteprioritytemplate Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.deleteprioritytemplate(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteprioritytemplate GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updatePriorityTemplate" }, method = RequestMethod.POST)
	public JSONArray updatePriorityTemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updatePriorityTemplate Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("srno is = " + crno);

			JSONArray final_response = AllMasters.updatePriorityTemplate(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatePriorityTemplate GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updatepprioritytemplateSave" }, method = RequestMethod.POST)
	public JSONArray updatepprioritytemplateSave(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside updatepprioritytemplateSave Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String companynameupdate = request.getParameter("companynameupdate");
			String companyemailupdate = request.getParameter("companyemailupdate");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("companynameupdate is = " + companynameupdate);
			// System.out.println(companyemailupdate);
			// System.out.println("srno is = " + cr_no);

			String final_response = AllMasters.updatepprioritytemplateSave(companynameupdate, companyemailupdate,
					cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatepprioritytemplateSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/Saveslapercentage" }, method = RequestMethod.POST)
	public JSONArray Saveslapercentage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside Saveslapercentage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String percentage = request.getParameter("percentage");
			// System.out.println("Company is is = " + company);
			// System.out.println("percentage is = " + percentage);

			String final_response = AllMasters.Saveslapercentage(company, percentage);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getSlaListing" }, method = RequestMethod.POST)
	public JSONArray getSlaListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSlaListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getSlaListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSlaListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/DeleteSlaTemplate" }, method = RequestMethod.POST)
	public String DeleteSlaTemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteSlaTemplate Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.DeleteSlaTemplate(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeleteSlaTemplate GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateSlaTemplateMaster" }, method = RequestMethod.POST)
	public String updateSlaTemplateMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateSlaTemplateMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			int srno = Integer.parseInt(request.getParameter("srno"));
			// System.out.println("sdddddddddddddddd"+srno);
			String company = request.getParameter("company");
			String percentage = request.getParameter("percentage");

			// System.out.println("companyynameupdate is = " + company);

			String final_response = AllMasters.updateSlaTemplateMaster(srno, company, percentage);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateSlaTemplateMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getTemplateCategoryList1" }, method = RequestMethod.POST)
	public JSONArray getTemplateSubCategoryList1(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getTemplateSubCategoryList1 Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getTemplateCategoryList1(subcat1);

			// System.out.println("getTemplateSubCategoryList1 reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getTemplateSubCategoryList1 GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getTemplateSubCategoryList2" }, method = RequestMethod.POST)
	public JSONArray getTemplateSubCategoryList2(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getTemplateSubCategoryList2 Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String subcategory = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getTemplateSubCategoryList2(subcategory);

			// System.out.println("getTemplateSubCategoryList reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("TEMPLATE CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/UpdateAdIntegration" }, method = RequestMethod.POST)
	public String UpdateAdIntegration(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String host = request.getParameter("host");
			int port_no = Integer.parseInt(request.getParameter("port_no"));
			String dName = request.getParameter("dName");
			// System.out.println("cOMNPANY========="+company);
			// System.out.println("uSERNAME========="+username);
			// System.out.println("pASSWORD========="+password);
			// System.out.println("hOST========="+host);
			// System.out.println("pOERT_NO========="+port_no);
			// System.out.println("DOMAIN NMAE========="+dName);

			String final_response = AllMasters.UpdateAdIntegration(company, username, password, host, port_no, dName);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/DeleteList" }, method = RequestMethod.POST)
	public String DeleteList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside DeleteList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");

			// System.out.println("Company is = " + company);
			String final_response = AllMasters.DeleteList(company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("DeleteList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/CompanyCodeListing" }, method = RequestMethod.POST)
	public JSONArray CompanyCodeListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside CompanyCodeListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.CompanyCodeListing();

			// System.out.println("CompanyCodeListing reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CompanyCodeListing GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/addCompanyCode" }, method = RequestMethod.POST)
	public JSONArray addCompanyCode(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addCompanyCode Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("companyname");
			String companycode = request.getParameter("companycode");

			// System.out.println("company is = " + company);
			// System.out.println("companycode is = " + companycode);

			String final_response = AllMasters.addCompanyCode(company, companycode);

			// System.out.println("addCompanyCode reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addCompanyCode GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				    return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateCompanyCode" }, method = RequestMethod.POST)
	public JSONArray updateCompanyCode(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompanyCode Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String companyname = request.getParameter("companyname");
			String companycode = request.getParameter("companycode");
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.updateCompanyCode(companyname, companycode, srno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updatecompanySave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/deleteCompanyCode" }, method = RequestMethod.POST)
	public String deleteCompanyCode(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteCompanyCode Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			// System.out.println("srno is = " + srno);
			;
			String final_response = AllMasters.deleteCompanyCode(srno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteCompany GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getSelfHelpList" }, method = RequestMethod.POST)
	public JSONArray getSelfHelpList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSelfHelpList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSelfHelpList();

			// System.out.println("getSelfHelpList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSelfHelpList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSelfHelpScopeList" }, method = RequestMethod.POST)
	public JSONArray getSelfHelpScopeList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSelfHelpScopeList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSelfHelpScopeList();

			// System.out.println("getSelfHelpScopeList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSelfHelpScopeList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/gatherSelfHelpDetails" }, method = RequestMethod.POST)
	public JSONArray gatherSelfHelpDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSelfHelpList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String selfhelpid = request.getParameter("selfhelpid");

			JSONArray final_response = AllMasters.gatherSelfHelpDetails(selfhelpid);

			// System.out.println("getSelfHelpList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSelfHelpList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/addSelfHelpMaster" }, method = RequestMethod.POST)
	public String addSelfHelpMaster(ModelMap model, @RequestParam("empPic") MultipartFile empPic,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside addSelfHelpMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("cname");
			String branch = request.getParameter("branches");
			String department = request.getParameter("departments");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String category = request.getParameter("category");
			String platform = request.getParameter("platform");

			// System.out.println("Company is = " + company);
			// System.out.println("branch is = " + branch);
			// System.out.println("department is = " + department);
			// System.out.println("name is = " + name);
			// System.out.println("description is = " + description);
			// System.out.println("category is = " + category);
			// System.out.println("platform is = " + platform);
			// System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
			// System.out.println("EMPIC FILE SIZE: "+empPic.getSize());

			String final_response = AllMasters.addSelfHelpMaster(company, branch, department, name, description,
					category, platform, empPic);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("DeleteList GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/updateSelfHelpMaster" }, method = RequestMethod.POST)
	public String updateSelfHelpMaster(ModelMap model, @RequestParam("empPic1") MultipartFile empPic,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside updateSelfHelpMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("cnameupdate");
			String branch = request.getParameter("branchupdate");
			String department = request.getParameter("departmentupdate");
			String name = request.getParameter("nameupdate");
			String description = request.getParameter("descriptionupdate");
			String category = request.getParameter("categoryupdate");
			String platform = request.getParameter("platformupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no2"));

			// System.out.println("srno is = " + srno);
			// System.out.println("Company is = " + company);
			// System.out.println("branch is = " + branch);
			// System.out.println("department is = " + department);
			// System.out.println("name is = " + name);
			// System.out.println("description is = " + description);
			// System.out.println("category is = " + category);
			// System.out.println("platform is = " + platform);
			// System.out.println("EMPIC FILE NAME: "+empPic.getOriginalFilename());
			// System.out.println("EMPIC FILE SIZE: "+empPic.getSize());

			String final_response = AllMasters.updateSelfHelpMaster(srno, company, branch, department, name,
					description, category, platform, empPic);

			// System.out.println("updateSelfHelpMaster reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("updateSelfHelpMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/DownloadSelfHelpFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadSelfHelpFile(HttpServletRequest request) throws IOException {

		String selfhelpid = request.getParameter("selfhelpid");
		String filename1 = request.getParameter("filename");
		// System.out.println("filename1 " + filename1);

		String filename = "C:\\ITHelpDesk\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename " + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		// Increase download counter

		AllMasters.updateSelfHelpDownloadCounter(selfhelpid);

		return responseEntity;
	}

	@RequestMapping(value = { "/getSelfHelpCategory" }, method = RequestMethod.POST)
	public JSONArray getSelfHelpCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSelfHelpCategory Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSelfHelpCategory();

			// System.out.println("getSelfHelpCategory reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSelfHelpCategory GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSelfHelpPlatform" }, method = RequestMethod.POST)
	public JSONArray getSelfHelpPlatform(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getSelfHelpPlatform Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getSelfHelpPlatform();

			// System.out.println("getSelfHelpPlatform reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getSelfHelpPlatform GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getTemplatePriorityList1" }, method = RequestMethod.POST)
	public JSONArray getTemplatePriorityList1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getTemplatePriorityList1 Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getTemplatePriorityList1(subcat1);

			// System.out.println("getTemplatePriorityList1 reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getTemplatePriorityList1 GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getTemplateSeverityList1" }, method = RequestMethod.POST)
	public JSONArray getTemplateSeverityList1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getTemplateSeverityList1 Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getTemplateSeverityList1(subcat1);

			// System.out.println("getTemplateSeverityList1 reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getTemplateSeverityList1 GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/Updatecategory" }, method = RequestMethod.POST)
	public JSONArray Updatecategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			// System.out.println("inside Updatecategory controller");

			String Categoryupdate = request.getParameter("Categoryupdate");
			String Subcategory1update = request.getParameter("Subcategory1update");
			String Subcategory2update = request.getParameter("Subcategory2update");
			String Priorityupdate = request.getParameter("Priorityupdate");
			String Severityupdate = request.getParameter("Severityupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.Updatecategory(Categoryupdate, Subcategory1update, srno,
					Subcategory2update, Priorityupdate, Severityupdate);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/Updatecategorytemplate" }, method = RequestMethod.POST)
	public JSONArray Updatecategorytemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {

			// System.out.println("in side Updatecategorytemplate controller");
			out = response.getWriter();
			String Categoryupdate = request.getParameter("Categoryupdate");
			String Subcategory1update = request.getParameter("Subcategory1update");
			String Subcategory2update = request.getParameter("Subcategory2update");
			String Priorityupdate = request.getParameter("Priorityupdate");
			String Severityupdate = request.getParameter("Severityupdate");
			String Companyupdate = request.getParameter("Companyupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.Updatecategorytemplate(Categoryupdate, Subcategory1update, srno,
					Subcategory2update, Priorityupdate, Severityupdate, Companyupdate);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/addgroup" }, method = RequestMethod.POST)
	public JSONArray addgroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addgroup Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String group = request.getParameter("group");
			String company = request.getParameter("company");
			// System.out.println("group is = " + group);
			// System.out.println("company is = " + company);

			String final_response = AllMasters.addgroup(group, company);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("ADDITHeadMaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//						return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getgroupList" }, method = RequestMethod.POST)
	public JSONArray getgroupList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getgroupList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getgroupList(userlist);

			// System.out.println("getgroupList reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getgroupList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//						return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/Deletegroup" }, method = RequestMethod.POST)
	public JSONArray Deletegroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside Deletegroup Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);
			;
			String final_response = AllMasters.Deletegroup(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("DeletePriority GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//						return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updategroupMasterSave" }, method = RequestMethod.POST)
	public JSONArray updategroupMasterSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updategroupMasterSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String prioritynameupdate = request.getParameter("prioritynameupdate");
			String companyName = request.getParameter("company");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

			// System.out.println("prioritynameupdate is = " + prioritynameupdate);
			// System.out.println("cr_no is = " + cr_no);

			String final_response = AllMasters.updategroupMasterSave(companyName, prioritynameupdate, cr_no);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updategroupMasterSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//						return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getGropupfromgroupmaster" }, method = RequestMethod.POST)
	public JSONArray getGropupfromgroupmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getGropupfromgroupmaster Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getGropupfromgroupmaster(company);

			// System.out.println("getGropupfromgroupmaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getGropupfromgroupmaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getusernamebasisondesignation" }, method = RequestMethod.POST)
	public JSONArray getusernamebasisondesignation(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getServiceCatalogueSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";
		String designation1 = request.getParameter("designation1");
		String company = request.getParameter("company");
		System.out.println("designation1 NAME ::" + designation1);
		System.out.println("groupname1 NAME ::" + company);
		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getusernamebasisondesignation(designation1, company);

			System.out.println("getServiceCatalogueSubject reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsForAutoAssign" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsForAutoAssign(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryDetailsForAutoAssign
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String company = request.getParameter("comp");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCategoryDetailsForAutoAssign(company);

			// System.out.println("getCategoryDetailsForAutoAssign reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryDetailsForAutoAssign GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getUserNamesOnDesignation" }, method = RequestMethod.POST)
	public JSONArray getUserNamesOnDesignation(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getUserNamesOnDesignation Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("companyName");
			String designation = request.getParameter("designation");

			JSONArray final_response = AllMasters.getUserNamesOnDesignation(company, designation);

			// System.out.println("getUserNamesOnDesignation reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getUserNamesOnDesignation GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/ViewAutoAssignTicket" }, method = RequestMethod.POST)
	public JSONArray ViewAutoAssignTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside addUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.ViewAutoAssignTicket(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addUserDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCompany" }, method = RequestMethod.POST)
	public JSONArray getCompany(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompany Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String names = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompany();

			// System.out.println("getCompany reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCompany GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getDepartment" }, method = RequestMethod.POST)
	public JSONArray getDepartment(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getDepartment Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String names = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String branchname = request.getParameter("branchname");
			// System.out.println("COMPANY NMAE " +company);
			// System.out.println("BRANCH NMAE " +branchname);
			JSONArray final_response = AllMasters.getDepartment(company, branchname);

			// System.out.println("getDepartment reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getDepartment GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsforreport" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsforreport(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryDetailsforreport Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String names = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("companyname");
			String branchname = request.getParameter("branchname");
			// System.out.println("COMPANY NMAE " +company);
			// System.out.println("BRANCH NMAE " +branchname);
			JSONArray final_response = AllMasters.getCategoryDetailsforreport(company);

			// System.out.println("getDepartment reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getCategoryDetailsforreport GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//					return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateCompositeMaster" }, method = RequestMethod.POST)
	public JSONArray updateCompositeMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompositeMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String srno = request.getParameter("srno");
			int srNo = Integer.parseInt(srno);
			String company = request.getParameter("company");
			String branch = request.getParameter("branch");
			String location = request.getParameter("location");
			String department = request.getParameter("department");
			String subDepartment = request.getParameter("subDepartment");

			// System.out.println("company is = " + company);
			// System.out.println("branch is = " + branch);
			// System.out.println("location is = " + location);
			// System.out.println("department is = " + department);
			// System.out.println("subDepartment is = " + subDepartment);

			String final_response = AllMasters.updateCompositeMaster(srNo, company, branch, location, department,
					subDepartment);

			// System.out.println("addComposite reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addComposite GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteAutoCloseTicket" }, method = RequestMethod.POST)
	public JSONArray deleteAutoCloseTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteEscalation Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String srno = (request.getParameter("srno"));
			int srNo = Integer.parseInt(srno);
			// System.out.println("close ticket srrno= " + srNo);

			String final_response = AllMasters.deleteAutoCloseTicket(srNo);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("deleteSLA GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/DownloadUserBulkUploadFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadUserBulkUploadFile(HttpServletRequest request)
			throws IOException {

		String filename1 = AllMasters.getUserBulkUploadFile();
		// System.out.println("filename1 " + filename1);

		String filename = "C:\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename " + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		return responseEntity;
	}

	@RequestMapping(value = { "/DownloadBulkUploadFailedFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadBulkUploadFailedFile(HttpServletRequest request)
			throws IOException {

		String filename1 = request.getParameter("filename");
		// System.out.println("filename1 "+filename1);

		String filename = "C:\\HelpdeskUpload\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename "+file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		return responseEntity;
	}

	@RequestMapping(value = { "/updateSubjectMaster" }, method = RequestMethod.POST)
	public JSONArray updateSubjectMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompositeMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String srno = request.getParameter("srno");
			int srNo = Integer.parseInt(srno);
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String subject = request.getParameter("subject");

			String final_response = AllMasters.updateSubjectMaster(srNo, company, category, subcategory1, subcategory2,
					subject);

			// System.out.println("addComposite reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addComposite GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	//////////
	@RequestMapping(value = { "/getAllPriorityMaster" }, method = RequestMethod.POST)
	public JSONArray getAllPriorityMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getAllPriorityMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getAllPriorityMaster();

			// System.out.println("MastersControllerrrr reponse is of seviarity = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getPriorityName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getAllSeverityMaster" }, method = RequestMethod.POST)
	public JSONArray getAllSeverityMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getAllSeverityMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getAllSeverityMaster();

			// System.out.println("MastersControllerrrr reponse is of seviarity = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getPriorityName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/updateServiceCatalogue" }, method = RequestMethod.POST)
	public JSONArray updateServiceCatalogue(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		/// System.out.println("Inside updateServiceCatalogue Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {

			out = response.getWriter();
			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");
			String subcategory2 = request.getParameter("subcategory2");
			String subject = request.getParameter("subject");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");

			String servicerequesttype = request.getParameter("servicestandard");
			String group_name = request.getParameter("groupselect");
			String levelone = request.getParameter("levelone");
			String leveltwo = request.getParameter("leveltwo");
			String Designationlevel2 = request.getParameter("Designarionlevel2");
			String Designationlevel1 = request.getParameter("Designarionlevel1");
			String sr_no = request.getParameter("srno");
			int srno = Integer.parseInt(sr_no);
			// System.out.println(" for checking 2");
			String requestcost = request.getParameter("requestcost");
			String subjecttype = request.getParameter("subjecttype");
			// System.out.println("subject type in controller : " + subjecttype );
			String Approval_level = "";
			// System.out.println(" for checking ");
			// System.out.println("servicerequesttype is = " + servicerequesttype);
			// System.out.println("group_name is = " + group_name);
			// System.out.println("levelone is = " + levelone);
			// System.out.println("leveltwo is = " + leveltwo);
			// System.out.println("Designationlevel1 is = " + Designationlevel1);
			// System.out.println("Designationlevel2 is = " + Designationlevel2);

			/*
			 * if(Designationlevel2.equals("")) { Approval_level="Level-1";
			 * Designationlevel2="NA"; } else { Approval_level="Level-2"; }
			 */

			if (servicerequesttype.equals("Non Standard")) {
				if (Designationlevel2.equals("") || Designationlevel2.equals("null")) {
					// System.out.println("in side ++ ");
					Approval_level = "Level-1";
					Designationlevel2 = "NA";
				} else {
					Approval_level = "Level-2";
				}
			} else {

				Approval_level = "NA";
				Designationlevel2 = "NA";
				Designationlevel1 = "NA";
			}

			// System.out.println("company is = " + company);
			// System.out.println("category is = " + category);
			// System.out.println("subcategory1 is = " + subcategory1);
			// System.out.println("subcategory2 is = " + subcategory2);
			// System.out.println("subject is = " + subject);
			// System.out.println("priority is = " + priority);
			// System.out.println("severity is = " + severity);
			String final_response = AllMasters.updateServiceCatalogue(company, category, subcategory1, subcategory2,
					subject, priority, severity, servicerequesttype, group_name, Approval_level, Designationlevel1,
					Designationlevel2, requestcost, subjecttype, srno);

			// System.out.println("addNewSubject reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("addNewSubject GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getINCSubjectFORuser" }, method = RequestMethod.POST)
	public JSONArray getINCSubjectFORuser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getINCSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String company = request.getParameter("company");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getINCSubjectFORuser(company);

			// System.out.println("getINCSubjectFORuser reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getINCSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsListForsubjecmaster" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsListForsubjecmaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryDetailsListForsubjecmaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("cname");
			//// System.out.println("edtgertyd");
			JSONArray final_response = AllMasters.getCategoryDetailsListForsubjecmaster(catname, company);

			// System.out.println("getCategoryDetailsListForsubjecmaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getCategoryDetailsListForsubjecmaster GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory1Forsubjecmaster" }, method = RequestMethod.POST)
	public JSONArray getSubCategory1Forsubjecmaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubCategory1Forsubjecmaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat1 = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String category = request.getParameter("category");
			JSONArray final_response = AllMasters.getSubCategory1Forsubjecmaster(company, category, subcat1);

			// System.out.println("getSubCategory1Forsubjecmaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubCategory1Forsubjecmaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getSubCategory2Forsubjecmaster" }, method = RequestMethod.POST)
	public JSONArray getSubCategory2Forsubjecmaster(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getSubCategory2Forsubjecmaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subcat2 = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			String category = request.getParameter("category");
			String subcategory1 = request.getParameter("subcategory1");

			// System.out.println("subcategory1"+subcategory1+"company"+company+"category"+category);
			JSONArray final_response = AllMasters.getSubCategory2Forsubjecmaster(company, category, subcategory1,
					subcat2);

			// System.out.println("getSubCategory2Forsubjecmaster reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getSubCategory2Forsubjecmaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getRequestModeForRaiseOnBehalf" }, method = RequestMethod.POST)
	public JSONArray getRequestModeForRaiseOnBehalf(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String reqmode = null;

		try {
			out = response.getWriter();

			String company = request.getParameter("company");
			JSONArray final_response = AllMasters.getRequestModeForRaiseOnBehalf(company, reqmode);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/Deletemaiconfig" }, method = RequestMethod.POST)
	public JSONArray Deletemaiconfig(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.Deletemaiconfig(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/getGroupForLoginMasterAll" }, method = RequestMethod.POST)
	public JSONArray getGroupForLoginMasterAll(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getGroupForLoginMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		try {
			out = response.getWriter();
			// String company =request.getParameter("companyname");

			// System.out.println("");
			JSONArray final_response = AllMasters.getGroupForLoginMasterAll();

			// System.out.println("getGroupForLoginMaster reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getGroupForLoginMaster NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getGroupForPerticularUserforticket" }, method = RequestMethod.POST)
	public JSONArray getGroupForPerticularUserforticket(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getGroupForPerticularUserforuser
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		// String subcat2 = null;

		String username = request.getParameter("username");

		String company1 = request.getParameter("company2");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getGroupForPerticularUserforticket(username, company1);

			// System.out.println("getGroupForPerticularUserforuser reponse is = " +
			// final_response);

			out.print(final_response);

			// System.out.println("getGroupForPerticularUserforuser NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getCategoryDetailsforuScop2" }, method = RequestMethod.POST)
	public JSONArray getCategoryDetailsforuScop2(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside getCategoryDetailsforuScop2 Controller@@@@@@@@@@@@
		// ");
		PrintWriter out = null;
		String catname = null;

		try {
			out = response.getWriter();
			catname = request.getParameter("Categoryup");
			JSONArray final_response = AllMasters.getCategoryDetailsforuScop2(catname);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("CATEGORY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getStatusFormail" }, method = RequestMethod.POST)
	public JSONArray getStatusFormail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getStatusFormail();

			// System.out.println("getStatusFormail reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getStatusFormail GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/updatemailtemplate" }, method = RequestMethod.POST)
	public String updatemailtemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String srno = request.getParameter("srno");
			String st = request.getParameter("status");
			String subject = request.getParameter("subject");
			String mailbody = request.getParameter("mailbody");
			String company = request.getParameter("company");
			String emailTrigger = request.getParameter("emailtriggerup");
			String ticketType = request.getParameter("ticketType");
			String mailfooter = request.getParameter("mailfooter");
			// System.out.println("Email trigger " + emailTrigger + " TYPE:::::"+mailfooter
			// );
			// System.out.println("company ::::" + company);

			out = response.getWriter();
			out.print(AllMasters.updatemailtemplate(srno, st, subject, mailbody, company, emailTrigger, ticketType,
					mailfooter));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getFooterForUpdate" }, method = RequestMethod.POST)
	public JSONArray getFooterForUpdate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String srno = request.getParameter("srno");

			JSONArray final_response = AllMasters.getFooterForUpdate(srno);

			// System.out.println("getStatusFormail reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getStatusFormail GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/updateEmailServerIntegration" }, method = RequestMethod.POST)
	public void updateEmailServerIntegration(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String company = request.getParameter("company");

			String mail = request.getParameter("mail");
			String subject = request.getParameter("subject");

			String folder = request.getParameter("folder");
			String port = request.getParameter("port");

			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			int crno = Integer.parseInt(request.getParameter("srno"));
			String starttlsup = null;

			String final_response = AllMasters.updateEmailServerIntegration(company, mail, subject, folder, port, uname,
					pass, crno, starttlsup);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = { "/DeleteEmailServerIntegration" }, method = RequestMethod.POST)
	public JSONArray DeleteEmailServerIntegration(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside deleteUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String crno = request.getParameter("srno");
			String final_response = AllMasters.DeleteEmailServerIntegration(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getBranchForLoginMastersInsert" }, method = RequestMethod.POST)
	public JSONArray getBranchForLoginMastersInsert(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside deleteUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			String location = request.getParameter("location");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = AllMasters.getBranchForLoginMastersInsert(companyname, location);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getUserList" }, method = RequestMethod.POST)
	public JSONArray getUserList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getLoginMasterDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getUserList(userlist);
			out.print(final_response);
			// ;//System.out.println("getLoginMasterDetails reponse is = " +
			// final_response);

			// System.out.println("getLoginMasterDetails SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/updateUserList" }, method = RequestMethod.POST)
	public JSONArray updateUserList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();

			String mail = request.getParameter("mailupdate");
			String cno = request.getParameter("cnoupdate");
			String user = request.getParameter("userupdate");
			String pass = request.getParameter("passupdate");
			String fname = request.getParameter("fnameupdate");
			String lname = request.getParameter("lnameupdate");
			String cpass = request.getParameter("passupdate");
			String cname = request.getParameter("cnameupdate");
			String sname = request.getParameter("snameupdate");
			String dname = request.getParameter("dnameupdate");
			String location = request.getParameter("locationupdate");
			String englevel = request.getParameter("englevelupdate");
			String rtypeupdate = request.getParameter("rtypeupdate");
			String subdnameupdate = request.getParameter("subdnameupdate");
			String vipLogin = request.getParameter("vipLogin");
			String updategroup = request.getParameter("updategroup");
			String updatecategory = request.getParameter("updatecategory");
			String designation = request.getParameter("designation");
			String groupMultiserupdate = request.getParameter("groupMultiserupdate");
			String visibilityupdate = request.getParameter("visibilityupdate");
			String row = request.getParameter("row");
			int cr_no = Integer.parseInt(request.getParameter("cr_no"));

//		String[] category=updatecategory.split("~");
//		System.out.println("CORDINATOR GROUP IS " + category[1]);
			String finalvalue = "";
			if (rtypeupdate.equals("Ticket Co-ordinator")) {
				updategroup = groupMultiserupdate;
			} else if (rtypeupdate.equals("Engineer")) {
				String[] value1 = null;

				value1 = updategroup.split(",");
				for (String value2 : value1) {

					finalvalue = finalvalue.concat(value2.substring(0, value2.indexOf("~")) + ",");

				}

				updategroup = finalvalue.substring(0, finalvalue.length() - 1);
			}

			//// System.out.println("sdfgsdfdf dfgsd gfg "+finalvalue);
			// System.out.println("groupMultiserupdate is = " + groupMultiserupdate);
			// System.out.println("visibilityupdate is = " + visibilityupdate);

			// System.out.println("updategroup is = " + updategroup);
			// System.out.println("updatecategory is = " + updatecategory);
			// System.out.println("vipLogin is = " + vipLogin);
			// System.out.println("subdnameupdate is = " + subdnameupdate);
			// System.out.println("mail is = " + mail);
			// System.out.println("cno is = " + cno);
			// System.out.println("user is = " + user);
			// System.out.println("pass is = " + pass);
			// System.out.println("fname is = " + fname);
			// System.out.println("lname is = " + lname);
			// System.out.println("cpass is = " + cpass);
			// System.out.println("cname is = " + cname);
			// System.out.println("sname is = " + sname);
			// System.out.println("dname is = " + dname);
			// System.out.println("category is = " + location);
			// System.out.println("englevel is = " + englevel);
			// System.out.println("row:-" + row);

			String final_response = AllMasters.updateUserList(mail, cno, user, pass, fname, lname, cpass, cname, sname,
					dname, location, cr_no, englevel, rtypeupdate, row, subdnameupdate, vipLogin, updatecategory,
					updategroup, designation, visibilityupdate);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("updateAddEnggSave GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/GetLocationForReport" }, method = RequestMethod.POST)
	public void GetLocationForReport(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter Out = res.getWriter();

		System.out.println("inside GetLocationForReport");

		String companyis = req.getParameter("SELECTEDCompany");

		// System.out.println("the company is "+ companyis);
		Out.print(AllMasters.GetLocationForReport(companyis));

	}

	@RequestMapping(value = { "/GetUsersListForReportTp" }, method = RequestMethod.POST)
	public void GetUsersListForReportTp(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter Out = res.getWriter();

		System.out.println("inside GetUsersListForReportTp **");

		String companyis = req.getParameter("SELECTEDCompany");
		String locationis = req.getParameter("SELECTEDLocation");

		// System.out.println("the company is "+ companyis);
		Out.print(AllMasters.GetUsersListForReportTp(companyis, locationis));

	}

	@RequestMapping(value = { "/getSLACalendarData" }, method = RequestMethod.POST)
	public JSONArray getSLACalendarData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getSLACalendarData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			System.out.println("COMPNAME: " + companyname);
			JSONArray final_response = AllMasters.getSLACalendarData(companyname);

//		System.out.println("getSLACalendarData reponse is = " + final_response);

			out.print(final_response);

//		System.out.println("getSLACalendarData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/insertSLACalendarData" }, method = RequestMethod.POST)
	public String insertSLACalendarData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside insertSLACalendarData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			String eventname = request.getParameter("eventname");
			String eventdescription = request.getParameter("eventdescription");
			String eventdate = request.getParameter("eventdate");

			System.out.println("COMPNAME: " + companyname);
			System.out.println("eventname: " + eventname);
			System.out.println("eventdescription: " + eventdescription);
			System.out.println("eventdate: " + eventdate);

			String final_response = AllMasters.insertSLACalendarData(companyname, eventname, eventdescription,
					eventdate);
			System.out.println("FINAL RESPONSE INSERT: " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/updateSLACalendarData" }, method = RequestMethod.POST)
	public String updateSLACalendarData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside updateSLACalendarData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			String eventname = request.getParameter("eventname");
			String eventdescription = request.getParameter("eventdescription");
			String eventdate = request.getParameter("eventdate");

			System.out.println("COMPNAME: " + companyname);
			System.out.println("eventname: " + eventname);
			System.out.println("eventdescription: " + eventdescription);
			System.out.println("eventdate: " + eventdate);

			String final_response = AllMasters.updateSLACalendarData(companyname, eventname, eventdescription,
					eventdate);
			System.out.println("FINAL RESPONSE UPDATE: " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteSLACalendarData" }, method = RequestMethod.POST)
	public String deleteSLACalendarData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteSLACalendarData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			String eventname = request.getParameter("eventname");
			String eventdescription = request.getParameter("eventdescription");
			String eventdate = request.getParameter("eventdate");

			System.out.println("COMPNAME: " + companyname);
			System.out.println("eventname: " + eventname);
			System.out.println("eventdescription: " + eventdescription);
			System.out.println("eventdate: " + eventdate);

			String final_response = AllMasters.deleteSLACalendarData(companyname, eventname, eventdescription,
					eventdate);
			System.out.println("FINAL RESPONSE DELETE: " + final_response);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getSLAWeekScheduleData" }, method = RequestMethod.POST)
	public JSONArray getSLAWeekScheduleData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getSLAWeekScheduleData Controller Module");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			System.out.println("COMPNAME: " + companyname);
			JSONArray final_response = AllMasters.getSLAWeekScheduleData(companyname);

//		System.out.println("getSLACalendarData reponse is = " + final_response);

			out.print(final_response);

//		System.out.println("getSLACalendarData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/insertUpdateSLAWeekScheduleData" }, method = RequestMethod.POST)
	public JSONArray insertUpdateSLAWeekScheduleData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session
//		,@RequestParam("finalArray") JSONArray finalArray
	) {
		System.out.println("Inside insertUpdateSLAWeekScheduleData Controller Module");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String companyname = request.getParameter("companyname");
			String finalArray = request.getParameter("finalArray");
			System.out.println("COMPNAME: " + companyname);
			System.out.println("finalArray: " + finalArray);
			System.out.println("finalArray LENGTH: " + finalArray.length());

			String final_response = AllMasters.insertUpdateSLAWeekScheduleData(companyname, finalArray);

//		System.out.println("getSLACalendarData reponse is = " + final_response);

			out.print(final_response);

//		System.out.println("getSLACalendarData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getCompanyForReportInAdmin" }, method = RequestMethod.POST)
	public JSONArray getCompanyForReportInAdmin(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		System.out.println("inside getCompanyForReportInAdmin ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getCompanyForReportInAdmin();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/GetUserNameList" }, method = RequestMethod.POST)
	public JSONArray GetUserNameList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		System.out.println("inside getCompanyForReportInAdmin ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String vendorname = request.getParameter("vendorname");
			String groupName = request.getParameter("groupName");
			System.out.println("gttty" + groupName);
			JSONArray final_response = AllMasters.GetUserNameList(vendorname, groupName);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getGroupForReport" }, method = RequestMethod.POST)
	public JSONArray getGroupForReport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		System.out.println("inside getCompanyForReportInAdmindgdggfgsf ");
		PrintWriter out = null;
		String compname = "";
		try {
			out = response.getWriter();
			compname = request.getParameter("companyname");
			System.out.println("nasmeoif icomrgfv isw" + compname);
			JSONArray final_response = AllMasters.getGroupForReport(compname);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/gettidForServiceRequest" }, method = RequestMethod.POST)
	public JSONArray gettidForServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("companyis");
			String todate = request.getParameter("ToDate");
			String fromdate = request.getParameter("FromDate");
			System.out.println("the company name is cname" + cname);
			JSONArray final_response = AllMasters.gettidForServiceRequest(cname, fromdate, todate);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/GetGroupsForReport" }, method = RequestMethod.POST)
	public void GetGroupsForReport(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter Out = res.getWriter();

		System.out.println("inside GetGroupsForReport **");

		String companyis = req.getParameter("SELECTEDCompany");

		// System.out.println("the company is "+ companyis);
		Out.print(AllMasters.GetGroupsForReport(companyis));

	}

	@RequestMapping(value = { "/getProblemTicketId" }, method = RequestMethod.POST)
	public JSONArray getProblemTicketId(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			cname = request.getParameter("companyis");
			String todate = request.getParameter("ToDate");
			String fromdate = request.getParameter("FromDate");
			System.out.println("the company name is cname" + cname);
			JSONArray final_response = AllMasters.getProblemTicketId(cname, fromdate, todate);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getAssetFromOfLoginUser" }, method = RequestMethod.POST)
	public JSONArray getAssetFromOfLoginUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String cname = null;

		try {
			out = response.getWriter();
			String loginuser = request.getParameter("loginuser");
			System.out.println("dfsgfdgg fd" + loginuser);
			if (loginuser.equals("undefined")) {
				loginuser = session.getAttribute("username").toString();
				System.out.println("dfgdgdgfgdg" + loginuser);
			} else if (loginuser.equals("null")) {
				loginuser = session.getAttribute("username").toString();
				System.out.println("dfgdgdgfgdg" + loginuser);
			} else {
				loginuser = loginuser;
			}
			System.out.println("fgdfgfgfgfdght" + loginuser);
			JSONArray final_response = AllMasters.getAssetFromOfLoginUser(loginuser);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("COMPANY NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//	return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getsyncloglisting" }, method = RequestMethod.POST)
	public JSONArray getsyncloglisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getsyncloglisting Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.getsyncloglisting(userlist);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/updatelogsync" }, method = RequestMethod.POST)
	public JSONArray updatelogsync(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updatelogsync Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = request.getParameter("loginfo");
			String final_response = AllMasters.updatelogsync(userlist);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/getServiceCatalogueSubjectByType" }, method = RequestMethod.POST)
	public JSONArray getServiceCatalogueSubjectByType(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Inside getServiceCatalogueSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subjectType = request.getParameter("subcat2name");
		String company = request.getParameter("company");
		System.out.println("COMPANY NAME ::" + company);

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getServiceCatalogueSubjectByType(subjectType, company);

			System.out.println("getServiceCatalogueSubject reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/AddEFormMailTemp" }, method = RequestMethod.POST)
	public void AddEFormMailTemp(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String st = request.getParameter("st");
			String subject = request.getParameter("subject");
			String mailbody = request.getParameter("mailbody");
			String company = request.getParameter("company");
			String emailTrigger = request.getParameter("EmailTrigger");
			String ticketType = request.getParameter("ticketType");
			String mailfooter = request.getParameter("mailfooter");
			// System.out.println("Email trigger "+emailTrigger+" TYPE:::::"+mailfooter);
			// System.out.println("company ::::"+company);
			out = response.getWriter();
			out.print(
					AllMasters.AddEFormMailTemp(st, subject, mailbody, company, emailTrigger, ticketType, mailfooter));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = { "/AddEformMailListing" }, method = RequestMethod.POST)
	public JSONArray AddEformMailListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside AddMailListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String userlist = null;
			JSONArray final_response = AllMasters.AddEformMailListing(userlist);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("AddEformMailListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}

	@RequestMapping(value = { "/updatEformemailtemplate" }, method = RequestMethod.POST)
	public String updatEformemailtemplate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String srno = request.getParameter("srno");
			String st = request.getParameter("status");
			String subject = request.getParameter("subject");
			String mailbody = request.getParameter("mailbody");
			String company = request.getParameter("company");
			String emailTrigger = request.getParameter("emailtriggerup");
			String ticketType = request.getParameter("ticketType");
			String mailfooter = request.getParameter("mailfooter");
			// System.out.println("Email trigger " + emailTrigger + " TYPE:::::"+mailfooter
			// );
			// System.out.println("company ::::" + company);

			out = response.getWriter();
			out.print(AllMasters.updatEformemailtemplate(srno, st, subject, mailbody, company, emailTrigger, ticketType,
					mailfooter));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/DeleteEformmaiconfig" }, method = RequestMethod.POST)
	public JSONArray DeleteEformmaiconfig(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteEmailUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			// System.out.println("crno is = " + crno);

			String final_response = AllMasters.DeleteEformmaiconfig(crno);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}

	@RequestMapping(value = { "/getEmailFooterForUpdate" }, method = RequestMethod.POST)
	public JSONArray getEmailFooterForUpdate(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompanyDetailsForLoginMaster
		// Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String srno = request.getParameter("srno");

			JSONArray final_response = AllMasters.getEmailFooterForUpdate(srno);

			// System.out.println("getStatusFormail reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getStatusFormail GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getPID" }, method = RequestMethod.POST)
	public JSONArray getPID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getServiceCatalogueSubject Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getPID();

			System.out.println("getServiceCatalogueSubject reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/ApprovalGroup" }, method = RequestMethod.POST)
	public JSONArray ApprovalGroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside ApprovalGroghghgup Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String pid = request.getParameter("pid");
			JSONArray final_response = AllMasters.ApprovalGroup(pid);

			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getUserSelectedDetails" }, method = RequestMethod.POST)
	public JSONArray getUserSelectedDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserSelectedDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String apname = request.getParameter("approvalname");

			String[] split = apname.split("~");
			String approvalname = split[0];
			String fullName = split[1];
			System.out.println("gggggggg" + approvalname);
			JSONArray final_response = AllMasters.getUserSelectedDetails(approvalname, fullName);
			out.print(final_response);

//				System.out.println("getServiceCatalogueSubject NAME GET SUCCESS"+final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getProejctDetails" }, method = RequestMethod.POST)
	public JSONArray getProejctDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getProejctDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			String pid = request.getParameter("pid");
			JSONArray final_response = AllMasters.getProejctDetails(pid);
			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getProjectDetailsById" }, method = RequestMethod.POST)
	public JSONArray getProjectDetailsById(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getProejctDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			String pid = request.getParameter("pid");
			JSONArray final_response = AllMasters.getProjectDetailsById(pid);
			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/getItGroupUser" }, method = RequestMethod.POST)
	public JSONArray getItGroupUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getItGroupUser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getItGroupUser();
			out.print(final_response);

			System.out.println("getItGroupUser NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/SaveSoftwareDetails" }, method = RequestMethod.POST)
	public String SaveSoftwareDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String sname = request.getParameter("sname");
			String productcode = request.getParameter("pcode");
			String fromdate = request.getParameter("frmdate");
			String checkbox = request.getParameter("checkbox");
			String scost = request.getParameter("scost");
			float softwarecost = Float.parseFloat(scost);
			String rperiod = request.getParameter("rperiod");
			System.out.println("product Code" + productcode);
			String finals = AllMasters.SaveSoftwareDetails(sname, productcode, fromdate, checkbox, softwarecost,
					rperiod);
			out.print(finals);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getSoftwareDetailsInEform" }, method = RequestMethod.POST)
	public JSONArray getSoftwareDetailsInEform(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONArray finalresponse = AllMasters.getSoftwareDetailsInEform();
			System.out.println(finalresponse);
			out.print(finalresponse);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/UpdateSoftwareDetails" }, method = RequestMethod.POST)
	public String UpdateSoftwareDetails(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String sname = request.getParameter("sname");
			String productcode = request.getParameter("pcode");
			String fromdate = request.getParameter("frmdate");
			String checkbox = request.getParameter("checkbox");
			String scost = request.getParameter("scost");
			String rperiod = request.getParameter("rperiod");
			String sr_no1 = request.getParameter("srno");
			int srno = Integer.parseInt(sr_no1);
			System.out.println("product Code" + productcode);
			String finals = AllMasters.UpdateSoftwareDetails(sname, productcode, fromdate, checkbox, scost, rperiod,
					srno);
			out.print(finals);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/DeleteSoftwares" }, method = RequestMethod.DELETE)
	public String DeleteSoftwares(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String crno = request.getParameter("crno");
			int crnos = Integer.parseInt(crno);

			System.out.println("product Code" + crno);
			String finals = AllMasters.DeleteSoftwares(crnos);
			out.print(finals);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// business ID REQUEST

	@RequestMapping(value = { "/getBusinessUserSelectedDetails" }, method = RequestMethod.POST)
	public JSONArray getBusinessUserSelectedDetails(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getUserSelectedDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String subject = "";

		try {
			out = response.getWriter();
			String apname = request.getParameter("approvalname");
			String[] split = apname.split("~");
			String approvalname = split[0];
			System.out.println("gggggggg" + approvalname);
			JSONArray final_response = AllMasters.getBusinessUserSelectedDetails(approvalname);
			out.print(final_response);

			System.out.println("getServiceCatalogueSubject NAME GET SUCCESS" + final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getScopeBasedCategory" }, method = RequestMethod.POST)
	public void getScopeBasedCategory(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

//			System.out.println("product Code"+crno);
			JSONArray finals = AllMasters.getScopeBasedCategory();
			out.print(finals);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

// Bulk Upload code - get excel sheet

	@RequestMapping(value = { "/DownloadcompositeBulkUploadFile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadCategoryBulkUploadFile(HttpServletRequest request)
			throws IOException {

		String filename1 = AllMasters.getcompositeBulkUploadFile();
		System.out.println("filename1** " + filename1);

		String filename = "E:\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename " + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		// .contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}

	@RequestMapping(value = { "/saveBulkUploadUserData" }, method = RequestMethod.POST)
	public String saveBulkUploadCategoryData(ModelMap model, @RequestParam("bulkUserData") MultipartFile bulkUserData,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside saveBulkUploadUserData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			// System.out.println("bulkUserData FILE NAME:
			// "+bulkUserData.getOriginalFilename());
			// System.out.println("bulkUserData FILE SIZE: "+bulkUserData.getSize());

			String final_response = AllMasters.saveBulkUploadcomposite(bulkUserData);

			System.out.println("BulkUploadHelpdeskComposite reponse is = " + final_response);

			// System.out.println("saveBulkUploadUserData GET SUCCESS");

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/DownloadBulkUploadFailedComposite" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadBulkUploadFailedCategoryFile(HttpServletRequest request)
			throws IOException {

		String filename1 = request.getParameter("filename");
		// System.out.println("filename1 "+filename1);

		String filename = "C:\\HelpdeskUpload\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename "+file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		return responseEntity;
	}

	@RequestMapping(value = { "/ProductMaster" }, method = RequestMethod.POST)
	public String ProductMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("securitysolution");
			String unit = request.getParameter("unitdata");
			String ImplementerName = request.getParameter("ImplementerName");
			String finals = AllMasters.ProductMaster(productsuit, productname, unit, ImplementerName);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/AddProductsuit" }, method = RequestMethod.POST)
	public String AddProductsuit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("productsuit");

			String finals = AllMasters.AddProductsuit(productsuit);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/productmasterlisting" }, method = RequestMethod.POST)
	public JSONArray productmasterlisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.productmasterlisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/productmasterlisting1" }, method = RequestMethod.POST)
	public JSONArray productmasterlisting1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.productmasterlisting1(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/deleteProductMaster" }, method = RequestMethod.POST)
	public JSONArray deleteProductMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteProductMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteProductMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

// OtherCostMaster
	@RequestMapping(value = { "/OtherCostMaster" }, method = RequestMethod.POST)
	public String OtherCostMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String EngType = request.getParameter("engtype");
			String engineercost = request.getParameter("engineercost");
			String ImplementorCosttotal = request.getParameter("ImplementorCosttotal");
			String Implemetationcost = request.getParameter("Implemetationcost");
			String typepercentage = request.getParameter("typepercentage");
			String costdata = request.getParameter("costdata");
			String totalothercost = request.getParameter("totalothercost");
			String finals = AllMasters.OtherCostMaster(EngType, engineercost, ImplementorCosttotal, Implemetationcost,
					typepercentage, costdata, totalothercost);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/otherocstmasterlisting" }, method = RequestMethod.POST)
	public JSONArray otherocstmasterlisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.otherocstmasterlisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	// deleteOthercosrmaster

	@RequestMapping(value = { "/deleteOthercosrmaster" }, method = RequestMethod.POST)
	public JSONArray deleteOthercosrmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteOthercosrmaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteOthercosrmaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/updateproductmaster" }, method = RequestMethod.POST)
	public JSONArray updateproductmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
			String securitysolutionupdate = request.getParameter("securitysolutionupdate");
			String unitdataupdate = request.getParameter("unitdataupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));
			String updImplementerName = request.getParameter("updImplementerName");

			String final_response = AllMasters.updateproductmaster(productsuitupdate, securitysolutionupdate,
					unitdataupdate, srno, updImplementerName);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	/// Updateothercost

	@RequestMapping(value = { "/Updateothercost" }, method = RequestMethod.POST)
	public JSONArray Updateothercost(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String engtypeupdate = request.getParameter("engtypeupdate");
			String engineercostupdate = request.getParameter("engineercostupdate");
			String ImplementorCosttotalupdate = request.getParameter("ImplementorCosttotalupdate");
			String Implemetationcostupdate = request.getParameter("Implemetationcostupdate");
			String typepercentageupdate = request.getParameter("typepercentageupdate");
			String costdataupdate = request.getParameter("costdataupdate");
			String totalothercostupdate = request.getParameter("totalothercostupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.Updateothercost(engtypeupdate, engineercostupdate,
					ImplementorCosttotalupdate, Implemetationcostupdate, typepercentageupdate, costdataupdate,
					totalothercostupdate, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	// form3datalisting

	@RequestMapping(value = { "/form3datalisting" }, method = RequestMethod.POST)
	public JSONArray form3datalisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.form3datalisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

/// deleteFORM3

	@RequestMapping(value = { "/deleteFORM3" }, method = RequestMethod.POST)
	public JSONArray deleteFORM3(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteOthercosrmaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteFORM3(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

// updateform3

	@RequestMapping(value = { "/updateform3" }, method = RequestMethod.POST)
	public JSONArray updateform3(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String dateupdate = request.getParameter("dateupdate");
			String projeimplementornameupdate = request.getParameter("projeimplementornameupdate");
			String customernameupdate = request.getParameter("customernameupdate");
			String projectnameupdate = request.getParameter("projectnameupdate");
			String descriptionupdate = request.getParameter("descriptionupdate");
			String responsiblityupdate = request.getParameter("responsiblityupdate");
			String targetdateupdate = request.getParameter("targetdateupdate");
			String deliverydateupdate = request.getParameter("deliverydateupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateform3(dateupdate, projeimplementornameupdate, customernameupdate,
					projectnameupdate, descriptionupdate, responsiblityupdate, targetdateupdate, deliverydateupdate,
					srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/getproducutsuitList" }, method = RequestMethod.POST)
	public JSONArray getproducutsuitList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = AllMasters.getproducutsuitList();
			// System.out.println("getCompositeCompanyList reponse is = " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getunitdataList" }, method = RequestMethod.POST)
	public JSONArray getunitdataList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = AllMasters.getunitdataList();
			// System.out.println("getCompositeCompanyList reponse is = " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getsecuritysolutionList" }, method = RequestMethod.POST)
	public JSONArray getsecuritysolutionList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String productsuit = request.getParameter("productsuit");

			JSONArray finals = AllMasters.getsecuritysolutionList(productsuit);
			out.print(finals);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}
	
	@RequestMapping(value = { "/getsecuritysolutionList2" }, method = RequestMethod.POST)
	public JSONArray getsecuritysolutionList2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String productsuit = request.getParameter("productsuit");

			JSONArray finals = AllMasters.getsecuritysolutionList2(productsuit);
			out.print(finals);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/unitmasterlisting" }, method = RequestMethod.POST)
	public JSONArray unitmasterlisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.unitmasterlisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/Addunit" }, method = RequestMethod.POST)
	public String Addunit(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("Unit");

			String finals = AllMasters.Addunit(productsuit);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/securitytoollisting" }, method = RequestMethod.POST)
	public JSONArray securitytoollisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.securitytoollisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/Addsecuritytool" }, method = RequestMethod.POST)
	public String Addsecuritytool(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("securitysolution");

			String finals = AllMasters.Addsecuritytool(productsuit);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/Compositemasterlist" }, method = RequestMethod.POST)
	public JSONArray Compositemasterlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ProblemCompositeListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			String problemCatList = null;
			JSONArray final_response = AllMasters.Compositemasterlist(problemCatList);

			// System.out.println("ProblemCompositeListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("ProblemCompositeListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/addpricemaster" }, method = RequestMethod.POST)
	public JSONArray addpricemaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside adduser Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("productname");
			String pricetype = request.getParameter("pricetype");
			String cloudtype = request.getParameter("cloudtype");
			String apexmode = request.getParameter("apexmode");
			String capexmode = request.getParameter("capexmode");
			String prepectual = request.getParameter("prepectual");
			String subscriptiontype = request.getParameter("subscriptiontype");
			String licentype = request.getParameter("licentype");
			String amcprice = request.getParameter("amcprice");
			String amctotal = request.getParameter("amctotal");

			String final_response = AllMasters.addpricemaster(productsuit, productname, pricetype, cloudtype, apexmode,
					capexmode, prepectual, subscriptiontype, licentype, amcprice, amctotal);

			// System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//			return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/updateproductsuitmaster" }, method = RequestMethod.POST)
	public JSONArray updateproductsuitmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
//		      String securitysolutionupdate = request.getParameter("securitysolutionupdate");
//		      String unitdataupdate = request.getParameter("unitdataupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateproductsuitmaster(productsuitupdate, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/deleteProductsuitMaster" }, method = RequestMethod.POST)
	public JSONArray deleteProductsuitMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteProductMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteProductsuitMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/updatesectool" }, method = RequestMethod.POST)
	public JSONArray updatesectool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
//		      String securitysolutionupdate = request.getParameter("securitysolutionupdate");
//		      String unitdataupdate = request.getParameter("unitdataupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updatesectool(productsuitupdate, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/ deletesectool" }, method = RequestMethod.POST)
	public JSONArray deletesectool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteProductMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deletesectool(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/updateunitmaster" }, method = RequestMethod.POST)
	public JSONArray updateunitmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
//		      String securitysolutionupdate = request.getParameter("securitysolutionupdate");
//		      String unitdataupdate = request.getParameter("unitdataupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateunitmaster(productsuitupdate, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/deleteunitMaster" }, method = RequestMethod.POST)
	public JSONArray deleteunitMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteunitMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/Updatetandcmaster" }, method = RequestMethod.POST)
	public JSONArray Updatetandcmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String designation = request.getParameter("designation");
			String company = request.getParameter("company");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.Updatetandcmaster(company, designation, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/veloxproposaldetails" }, method = RequestMethod.POST)
	public String veloxproposaldetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			System.out.println("usernamemeeem login==" + uname);

			String veloxdata = request.getParameter("veloxdata");
			String poinitiator = request.getParameter("poinitiator");
			String poinitiatorno = request.getParameter("poinitiatorno");
			String FirstApprovername = request.getParameter("FirstApprovername");

			String firstapprovercontact = request.getParameter("firstapprovercontact");
			String secondApprovername = request.getParameter("secondApprovername");
			String secondapprovercontact = request.getParameter("secondapprovercontact");
			String clientname = request.getParameter("clientname");
			String Description = request.getParameter("Description");
			String totalpriceforallproduct = request.getParameter("totalpriceforallproduct");
			String deploysupport = request.getParameter("deploysupport");
			String clouddeploycharges = request.getParameter("clouddeploycharges");
			String subtotalB = request.getParameter("subtotalB");
			String resoucesamount = request.getParameter("resoucesamount");
			String ATC = request.getParameter("ATC");
			String subtotalAB = request.getParameter("subtotalAB");

			String Proposaltype = request.getParameter("Proposaltype");
			String Perpetualyear = request.getParameter("Perpetualyear");
			String Subscriptionyear = request.getParameter("Subscriptionyear");
			String Amcsecondyear = request.getParameter("Amcsecondyear");
			String Amcthirdyear = request.getParameter("Amcthirdyear");
			String Amcfourthyear = request.getParameter("Amcfourthyear");
			String Amcfiveyear = request.getParameter("Amcfiveyear");
			String secondyearsubscription = request.getParameter("secondyearsubscription");
			String thirdyearsubscription = request.getParameter("thirdyearsubscription");

			String productsuitselect = request.getParameter("productsuitselect");
			String Scanplusprodversion = request.getParameter("Scanplusprodversion");
			String SecureITprodversion = request.getParameter("SecureITprodversion");
			String enccustomername = request.getParameter("enccustomername");
			String fixedyear = request.getParameter("fixedyear");
			
			

			String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
			String fullPathVlxLogo = servletContext.getRealPath(folderPath);
			String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
			String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
			String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
			String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
			System.out.println("fullPath " + fullPathVlxLogo);
			System.out.println("signature " + signature);

			String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
			String IntegrationCharges = request.getParameter("integrationcharge");
			String Total_C = request.getParameter("totalc");
			String GSTPERCENTAGE = request.getParameter("total18percentage");
			String Grand_Total = request.getParameter("grandtotal");
			
			
			String amcstartdate = request.getParameter("amcstartdate");
			String AMCmonthyear = request.getParameter("AMCmonthyear");
			String AMCMonth = request.getParameter("AMCMonth");
			String AMCYear = request.getParameter("AMCYear");
			String amcenddate = request.getParameter("amcenddate");
			String productsuitdetails = request.getParameter("productsuitdetails");
			String securitysolutiondetails = request.getParameter("securitysolutiondetails");
			String descforamc = request.getParameter("descforamc");
			String totalcostAMC = request.getParameter("totalcostAMC");
			String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
			String gstforamc = request.getParameter("gstforamc");
			
			String subtotalAResource = request.getParameter("subtotalAResource");
			String gstdataforresource = request.getParameter("gstdataforresource");
			String grandtotalforresource = request.getParameter("grandtotalforresource");
			
			
			System.out.println("ATC controller impl amcstartdate" + amcstartdate);
			System.out.println("AMCmonthyear" + AMCmonthyear);
			System.out.println("ATC controller AMCMonth " + AMCMonth);
			
			System.out.println("ATC controller impl amcenddate" + amcenddate);
			System.out.println("ATC controller productsuitdetails " + productsuitdetails);
			System.out.println("ATC controller impl securitysolutiondetails" + securitysolutiondetails);
			
			System.out.println("descforamc" + descforamc);
			
			System.out.println("ATC controller impltotalcostAMC " + totalcostAMC);
			System.out.println("ATC controller implGRANDTOTALFORAMC " + GRANDTOTALFORAMC);
			System.out.println("ATC controller impl gstforamc" + gstforamc);
			System.out.println("ATC controller impl subtotalAResource" + subtotalAResource);
			System.out.println("ATC controller implgrandtotalforresource " + grandtotalforresource);
			System.out.println("ATC controller impl " + gstdataforresource);
		
			String contactperson = request.getParameter("contactperson");
			
			
			String veloxdata1 = request.getParameter("veloxdata1");
			String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
			String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
			String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
			String deploysupport21 = request.getParameter("deploysupport21");
			String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
			String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
			String integrationcharge21 = request.getParameter("integrationcharge21");
			String subtotalB21 = request.getParameter("subtotalB21");
			String totalc21 = request.getParameter("totalc21");
			String total18percentage21 = request.getParameter("total18percentage21");
			String grandtotal21 = request.getParameter("grandtotal21");
			String resoucesamount21 = request.getParameter("resoucesamount21");
			
			String poreferenceno = request.getParameter("poreferenceno");
			
			String proposalFor = request.getParameter("proposalFor");
			String partnerName = request.getParameter("partnerName");
			
			System.out.println("ATC controller impl " + ATC);
			
			
			
			String finals = AllMasters.veloxproposaldetails(veloxdata, poinitiator, poinitiatorno, FirstApprovername,
					firstapprovercontact, secondApprovername, secondapprovercontact, clientname, Description,
					totalpriceforallproduct, deploysupport, clouddeploycharges, subtotalB, subtotalAB, uname,
					resoucesamount, ATC, Proposaltype, Perpetualyear, Subscriptionyear, Amcsecondyear, Amcthirdyear,
					Amcfourthyear, Amcfiveyear, secondyearsubscription, thirdyearsubscription, fullPathVlxLogo,
					fullPathVlxEnd, fullPathSwachBharat, IntegrationchargeYesNo, IntegrationCharges, Total_C,
					GSTPERCENTAGE, Grand_Total, productsuitselect, Scanplusprodversion, SecureITprodversion,
					enccustomername, Letterhead, signature, fixedyear,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
					amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
					gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
					 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,poreferenceno,proposalFor, partnerName);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/ProjectnameMaster" }, method = RequestMethod.POST)
	public String ProjectnameMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("securitysolution");
			String unit = request.getParameter("unitdata");
			String finals = AllMasters.ProjectnameMaster(productsuit, productname, unit);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/projectmasterlist" }, method = RequestMethod.POST)
	public JSONArray projectmasterlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.projectmasterlist(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/updateprojectmaster" }, method = RequestMethod.POST)
	public JSONArray updateprojectmaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
			String securitysolutionupdate = request.getParameter("securitysolutionupdate");
			String unitdataupdate = request.getParameter("unitdataupdate");
			int srno = Integer.parseInt(request.getParameter("sr_no"));

			String final_response = AllMasters.updateprojectmaster(productsuitupdate, securitysolutionupdate,
					unitdataupdate, srno);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@RequestMapping(value = { "/deleteProjectNameMaster" }, method = RequestMethod.POST)
	public JSONArray deleteProjectNameMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteProductMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteProjectNameMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/InsertForm3" }, method = RequestMethod.POST)
	public String InsertForm3(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String date = request.getParameter("date");
			String projeimplementorname = request.getParameter("projeimplementorname");
			String customername = request.getParameter("customername");
			String projectname = request.getParameter("projectname");

			String serverAvail = request.getParameter("serverAvail");
			String ServerAvail_Responsibility = request.getParameter("Responsibility");
			String server_startdate = request.getParameter("startdate");
			String server_enddate = request.getParameter("enddate");
			String installvlxlicenseate = request.getParameter("installvlxlicense");
			String Responsibilityvlxlicense = request.getParameter("Responsibilityvlxlicense");
			String startdatevlxlicense = request.getParameter("startdatevlxlicense");
			String enddatevlxlicense = request.getParameter("enddatevlxlicense");
			String UATTesting = request.getParameter("UATTesting");
			String Responsibilityuattesting = request.getParameter("Responsibilityuattesting");
			String startdateuattesting = request.getParameter("startdateuattesting");
			String enddateuattesting = request.getParameter("enddateuattesting");
			String productiongolive = request.getParameter("productiongolive");
			String Responsibilitygolive = request.getParameter("Responsibilitygolive");
			String startdategolive = request.getParameter("startdategolive");
			String enddategolive = request.getParameter("enddategolive");
			String rollout = request.getParameter("rollout");
			String Responsibilityrollout = request.getParameter("Responsibilityrollout");
			String startdaterollout = request.getParameter("startdaterollout");
			String enddaterollout = request.getParameter("enddaterollout");
			String demolive = request.getParameter("demolive");
			String Responsibilitydemo = request.getParameter("Responsibilitydemo");
			String startdatedemo = request.getParameter("startdatedemo");
			String enddatedemo = request.getParameter("enddatedemo");
			String paymentterms = request.getParameter("paymentterms");
			String Responsibilitypaymentterms = request.getParameter("Responsibilitypaymentterms");
			String startdatepaymentterms = request.getParameter("startdatepaymentterms");
			String enddatepaymentterms = request.getParameter("enddatepaymentterms");
			String signoff = request.getParameter("signoff");
			String Responsibilitysignoff = request.getParameter("Responsibilitysignoff");
			String startdatesignoff = request.getParameter("startdatesignoff");
			String enddatesignoff = request.getParameter("enddatesignoff");

			String finals = AllMasters.InsertForm3(date, projeimplementorname, customername, projectname, serverAvail,
					ServerAvail_Responsibility, server_startdate, server_enddate, installvlxlicenseate,
					Responsibilityvlxlicense, startdatevlxlicense, enddatevlxlicense, UATTesting,
					Responsibilityuattesting, startdateuattesting, enddateuattesting, productiongolive,
					Responsibilitygolive, startdategolive, enddategolive, rollout, Responsibilityrollout,
					startdaterollout, enddaterollout, demolive, Responsibilitydemo, startdatedemo, enddatedemo,
					paymentterms, Responsibilitypaymentterms, startdatepaymentterms, enddatepaymentterms, signoff,
					Responsibilitysignoff, startdatesignoff, enddatesignoff);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/getprodsuit" }, method = RequestMethod.POST)
	public JSONArray getprodsuit(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getprodsuit();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getsectool" }, method = RequestMethod.POST)
	public JSONArray getsectool(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getsectool();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			// System.out.println("getRequestModeName GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//				return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getlist" }, method = RequestMethod.POST)
	public JSONArray getlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getCompositeCompanyList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		String crno = request.getParameter("crno");
		String tid = request.getParameter("tid");
//				int crno1=Integer.parseInt(crno);

		try {

			HttpSession htt = request.getSession(true);
			String uname = (String) htt.getAttribute("username");
			System.out.println("usernamemeeem login==" + uname);
			System.out.println("usernamemeeem login==" + crno);
			System.out.println("usernamemeeem tid login==" + tid);

			out = response.getWriter();
			JSONArray array = (JSONArray) AllMasters.getlist(crno, uname, tid);
			System.out.println("List value: " + array);
			out.print(array);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getdistributorname" }, method = RequestMethod.POST)
	public JSONArray getdistributorname(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = AllMasters.getdistributorname();
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getpartnername" }, method = RequestMethod.POST)
	public JSONArray getpartnername(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = AllMasters.getpartnername();
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	/// maker
	@RequestMapping(value = { "/getMakerName" }, method = RequestMethod.POST)
	public JSONArray getMakerName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getMakerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getMakerName();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	/// checker

	@RequestMapping(value = { "/getcheckerName" }, method = RequestMethod.POST)
	public JSONArray getcheckerName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getcheckerName();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getproductnamelist" }, method = RequestMethod.POST)
	public JSONArray getproductnamelist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		System.out.println("inside product name details :");

		String selectedSuit = request.getParameter("selectedSuit");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getproductnamelist(selectedSuit);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getproductsuitlist" }, method = RequestMethod.POST)
	public JSONArray getproductsuitlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		System.out.println("inside product suit details :");

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getproductsuitlist();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getAuthorizername" }, method = RequestMethod.POST)
	public JSONArray getAuthorizername(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			JSONArray final_response = AllMasters.getAuthorizername();
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}

	/// maker
	@RequestMapping(value = { "/getProposalName" }, method = RequestMethod.POST)
	public JSONArray getProposalName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getMakerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getProposalName();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/newCustomerDetails" }, method = RequestMethod.POST)
	public String newCustomerDetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String compname = request.getParameter("compname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String district = request.getParameter("district");
			String pincode = request.getParameter("pincode");
			String office_mailid = request.getParameter("office_mailid");

			String finals = AllMasters.newCustomerDetails(compname, address, city, district, pincode, office_mailid);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = { "/SetProposalMaster" }, method = RequestMethod.POST)
	public String setProposalMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;

		try {
			HttpSession htt = request.getSession(true);
			String proposalName = request.getParameter("proposalName");

			out = response.getWriter();
			out.print(AllMasters.setProposalMaster(proposalName));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	/// Get Proposal Id
	@RequestMapping(value = { "/getProposalIds" }, method = RequestMethod.POST)
	public JSONArray getProposalIds(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getMakerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String proposaltype = request.getParameter("proposaltype");
			String subscriptionyear = request.getParameter("subscriptionyear");
			String perpetualyear = request.getParameter("perpetualyear");
			String fixedyear = request.getParameter("fixedyear");
			String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");

			JSONArray final_response = AllMasters.getProposalIds(proposaltype, subscriptionyear, perpetualyear,
					fixedyear,subscriptionANDperpetualYear);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	/// Get Proposal Id
	@RequestMapping(value = { "/getProposalIdAttachment" }, method = RequestMethod.POST)
	public JSONArray getProposalIdAttachment(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getMakerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String proposalids = request.getParameter("proposalids");

			JSONArray final_response = AllMasters.getProposalIdAttachment(proposalids);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getimplementerList" }, method = RequestMethod.POST)
	public JSONArray getimplementerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;

		try {
			out = response.getWriter();
			String role = (String) session.getAttribute("role");
			JSONArray final_response = AllMasters.getimplementerList(role);
			// System.out.println("getCompositeCompanyList reponse is = " + final_response);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

		return null;

	}
	/// Authorizer

	@RequestMapping(value = { "/getAuthorizerNameAM" }, method = RequestMethod.POST)
	public JSONArray getAuthorizerNameAM(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getAuthorizerNameAM();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	
	
	//submit bulkupload
		@RequestMapping(value = { "/RFsaveBulkUpload" }, method = RequestMethod.POST)
		public String RFsaveBulkUploadcomposite(ModelMap model, @RequestParam("bulkUserData") MultipartFile bulkUserData,
				HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			// System.out.println("Inside saveBulkUploadUserData Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();

				// System.out.println("bulkUserData FILE NAME:
				// "+bulkUserData.getOriginalFilename());
				// System.out.println("bulkUserData FILE SIZE: "+bulkUserData.getSize());

				String final_response = AllMasters.RFsaveBulkUploadcomposite(bulkUserData);

				System.out.println("BulkUploadHelpdeskComposite reponse is = " + final_response);

				// System.out.println("saveBulkUploadUserData GET SUCCESS");

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;

		}
	
	
		//bulkupload for RF
		@RequestMapping(value = { "/DownloadRFfile" }, method = RequestMethod.GET)
		public ResponseEntity<InputStreamResource> RFDownloadUserBulkUploadFile(HttpServletRequest request)
				throws IOException {

			String filename1 = AllMasters.geRFtUserBulkUploadFile();
			// System.out.println("filename1 " + filename1);

			String filename = "C:\\".concat(filename1);

			File file = new File(filename);
			// System.out.println("filename " + file.getName());
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
					.contentLength(file.length())
					// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
					.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

			return responseEntity;
		}
		
	

		@RequestMapping(value = { "/updateRegistrationMaster" }, method = RequestMethod.POST)
		public void updateRegistrationMaster(@RequestParam("incocertificate") MultipartFile[] incocertificate,

				@RequestParam("pancardfile") MultipartFile[] pancardfile,
				@RequestParam("gstcertificate") MultipartFile[] gstcertificate,
				@RequestParam("msmed") MultipartFile[] msmed,
				@RequestParam("cancelledcheque") MultipartFile[] cancelledcheque,
				@RequestParam("turnovercertif") MultipartFile[] turnovercertif,
				@RequestParam("msmeddocument") MultipartFile[] msmeddocument,
				@RequestParam("commercialProp1") MultipartFile[] commercialProp1,
				@RequestParam("pucrhaseOrder1") MultipartFile[] pucrhaseOrder1,
				@RequestParam("addrowdata") String addrowdata,
				ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			PrintWriter out = null;

			try {
				HttpSession htt = request.getSession(true);
				// String addrowdata=request.getParameter("addrowdata");

				String uname = (String) session.getAttribute("username");
				String company = (String) session.getAttribute("usercompany");
				
				String tid = request.getParameter("tid");

//				System.out.println(" addrowdata addrowdata ::" + addrowdata);
				String categorytype = request.getParameter("categorytype");
//				System.out.println("categorytype :" + categorytype);
				String distributorname = request.getParameter("distributorname");
				String partnername = request.getParameter("partnername");
				String compname = request.getParameter("compname");
//				System.out.println("company name :" + compname);
				String registerno = request.getParameter("registerno");
//				System.out.println("registerno name :" + registerno);
				String address = request.getParameter("address");
//				System.out.println("address name :" + address);
				String contact_personname = request.getParameter("personname");
//				System.out.println("contact_personname name :" + contact_personname);
				String mobno = request.getParameter("mobno");
		
				String telpno = request.getParameter("telpno");
			
				String Md_Ceo_emailid = request.getParameter("Md_Ceo_emailid");
			
				String Sales_emailid = request.getParameter("Sales_emailid");
			
				String support_email_id = request.getParameter("support_email_id");
			
				String emailid_contact_person = request.getParameter("emailid_contact_person");
			
				String office_mailid = request.getParameter("office_mailid");
	
				String city = request.getParameter("city");
	
				String district = request.getParameter("district");
	
				String state = request.getParameter("state");
	
				String pincode = request.getParameter("pincode");
	
				String country = request.getParameter("country");

				String website = request.getParameter("website");
			
				String panacno = request.getParameter("panacno");
		
				String ownership = request.getParameter("ownership");

				String scale_of_company = request.getParameter("SCALE_OF_COMPANY");
			
				String gstin = request.getParameter("gstin");
		
				String other_country = request.getParameter("other_country");
			
				String dateofbussns = request.getParameter("dateofbussns");
		
				String currency = request.getParameter("currency");
	
				String year1 = request.getParameter("year1");
		
				String year2 = request.getParameter("year2");
			
				String year3 = request.getParameter("year3");
			
				String rupees1 = request.getParameter("rupees1");
		
				String rupees2 = request.getParameter("rupees2");
				
				String rupees3 = request.getParameter("rupees3");
				
				String gemportal_register = request.getParameter("gemportal1");
				
				
				String msmedregester = request.getParameter("msmedreg1");
			
				
				String msmedtype = request.getParameter("msmedtype");
			
		
				String entrepreno = request.getParameter("entrepreno");
			
				String ideclaration = request.getParameter("ideclaration");
			
				String checker = request.getParameter("checker");
		
				String Authorizer = request.getParameter("Authorizer");
			
				
				String salesManager = request.getParameter("salesManager");
			
			
				
				
				System.out.println("checker :" + checker);
				System.out.println("Authorizer :" + Authorizer);

				// System.out.println("Email trigger "+emailTrigger+" TYPE:::::"+mailfooter);
				// System.out.println("company ::::"+company);
				out = response.getWriter();
				out.print(AllMasters.updateRegistrationMaster(incocertificate, pancardfile, gstcertificate, msmed,
						cancelledcheque, turnovercertif, msmeddocument, addrowdata, categorytype, distributorname,
						partnername, compname, registerno, address, contact_personname, mobno, telpno, Md_Ceo_emailid,
						Sales_emailid, support_email_id, emailid_contact_person, office_mailid, city, district, state,
						pincode, country, website, panacno, ownership, scale_of_company, gstin, other_country, dateofbussns,
						currency, year1, year2, year3, rupees1, rupees2, rupees3, gemportal_register, msmedtype, entrepreno,
						ideclaration, checker, Authorizer, uname, company,salesManager, tid, msmedregester,commercialProp1,pucrhaseOrder1));

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}
		// end
		
		

@RequestMapping(value = {"/veloxproposalUpdateDetails"},method = RequestMethod.POST )
public String veloxproposalUpdateDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       System.out.println("Master controller veloxproposalUpdateDetails ");
   
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
		
		String proposalFor = request.getParameter("proposalFor");
		String PartnerName = request.getParameter("PartnerName");
		
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=AllMasters.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,
				fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,proposalFor,PartnerName);
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}




@RequestMapping(value = {"/commercialproposalUpdateDetailsMD"},method = RequestMethod.POST )
public String commercialproposalUpdateDetailsMD(HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		System.out.println("Master controller commercialproposalUpdateDetailsMD ");
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
       System.out.println("usernamemeeem login==" + uname);
       System.out.println("Master controller commercialproposalUpdateDetailsMD ");
   
		
		String veloxdata=request.getParameter("veloxdata");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
	   
		
		String proposalFor = request.getParameter("proposalFor");
		String PartnerName = request.getParameter("PartnerName");
//		String finals=userActivityService.veloxproposalUpdateDetails(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,
//				Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,crno,tid,SInote);
		String finals=AllMasters.commercialproposalUpdateDetailsMD(veloxdata,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,
				fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21,proposalFor,PartnerName );
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}


@RequestMapping(value = { "/getProposalIdsforlist" }, method = RequestMethod.POST)
public JSONArray getProposalIdsforlist(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;

	try {
		out = response.getWriter();
//		String productsuit = request.getParameter("productsuit");

		JSONArray finals = AllMasters.getProposalIdsforlist();
		out.print(finals);

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		if (out != null)
			out.close();
	}

	return null;

}

@RequestMapping(value = { "/getsecuritysolutionListing" }, method = RequestMethod.POST)
public JSONArray getsecuritysolutionListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;

	try {
		out = response.getWriter();
//		String productsuit = request.getParameter("productsuit");

		JSONArray finals = AllMasters.getsecuritysolutionListing();
		out.print(finals);

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		if (out != null)
			out.close();
	}

	return null;

}


// veloxLicensedetails


@RequestMapping(value = { "/veloxLicensedetails" }, method = RequestMethod.POST)
public String veloxLicensedetails(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	PrintWriter out = null;
	try {
		out = response.getWriter();

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		String veloxdata = request.getParameter("veloxdata");
		String sppliernamelicense = request.getParameter("sppliernamelicense");
		String clientname = request.getParameter("clientname");
		String EnvironmentKeyNo = request.getParameter("EnvironmentKeyNo");
		String ponumber = request.getParameter("ponumber");
		String podate = request.getParameter("podate");
		
		String OEMAddress = request.getParameter("OEMAddress");
		String clientAddress = request.getParameter("clientAddress");
		String endcostomername = request.getParameter("endcostomername");
		String endCustomerEmail = request.getParameter("endCustomerEmail");

		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
		String fullPathVlxLogo = servletContext.getRealPath(folderPath);
		
		String firstApprovername = request.getParameter("FirstApprovername");
		String secondApprovername = request.getParameter("SecondApprovername");
		String poID = request.getParameter("poID");
		String payment_recieved = request.getParameter("payment_recieved");
		
		String signaturePath =  "/WEB-INF/VeloxProposalPDF/signaturekale.png";
		String AMsignature = servletContext.getRealPath(signaturePath);
		
		//06/06
		String licenseforname=request.getParameter("licenseforname");
		
		String distributor=request.getParameter("distributor");
		String partner1=request.getParameter("partner1");
		String partner2=request.getParameter("partner2");
		String submissionType=request.getParameter("submissionType");
		String licenseUploadfile=request.getParameter("licenseUploadfile");
		System.out.println("submissionType :: "+submissionType+" fileee  "+licenseUploadfile);
		
		//06/06(Update)
		String finals = AllMasters.veloxLicensedetails(veloxdata, sppliernamelicense, clientname,EnvironmentKeyNo,
						ponumber, podate,folderPath,fullPathVlxLogo,OEMAddress,clientAddress ,endcostomername, endCustomerEmail,firstApprovername,secondApprovername,uname,poID,payment_recieved, 
						AMsignature,licenseforname,distributor, partner1,partner2,submissionType,licenseUploadfile);
		//
		
		out.print(finals);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;

}


@RequestMapping(value = { "/getPOidList" }, method = RequestMethod.POST)
public JSONArray getPOidList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		JSONArray final_response = AllMasters.getPOidList();

		System.out.println("MastersControllerrrr reponse is = " + final_response);

		out.print(final_response);
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
	return null;

}


@RequestMapping(value = { "/getPOidListData" }, method = RequestMethod.POST)
public void getPOidListData(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPOidListData method");
	
	 String poID=request.getParameter("POidList");
	

	PrintWriter out = null;
	try {
		
	

		out = response.getWriter();
		JSONArray array = (JSONArray) AllMasters.getPOidListData(poID);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/getAuthorizerNameBH" }, method = RequestMethod.POST)
public JSONArray getAuthorizerNameBH(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		JSONArray final_response = AllMasters.getAuthorizerNameBH();

		System.out.println("MastersControllerrrr reponse is = " + final_response);

		out.print(final_response);
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
	return null;

}



@RequestMapping(value = { "/getPoID" }, method = RequestMethod.POST)
public void getPoID(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPOidListData method");
	
	 String clientname=request.getParameter("clientname");
	

	PrintWriter out = null;
	try {
		
	

		out = response.getWriter();
		JSONArray array = (JSONArray) AllMasters.getPoID(clientname);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


@RequestMapping(value = { "/manualProposalDetailsSubmit" }, method = RequestMethod.POST)
public String manualProposalDetailsSubmit(@RequestParam("manualProposalFile") MultipartFile[] manualProposalFile,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	PrintWriter out = null;
	try {
		out = response.getWriter();

		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
		System.out.println("usernamemeeem login==" + uname);

		String veloxdata = request.getParameter("veloxdata");
	    
	    String Proposaltype = request.getParameter("Proposaltype");
		String Perpetualyear = request.getParameter("Perpetualyear");
		String Subscriptionyear = request.getParameter("Subscriptionyear");
		String fixedyear = request.getParameter("fixedyear");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String productsuitselect = request.getParameter("productsuitselect");
		String Scanplusprodversion = request.getParameter("Scanplusprodversion");
		String SecureITprodversion = request.getParameter("SecureITprodversion");
		String poinitiator = request.getParameter("poinitiator");
		String poinitiatorno = request.getParameter("poinitiatorno");
		String FirstApprovername = request.getParameter("FirstApprovername");
        String firstapprovercontact = request.getParameter("firstapprovercontact");
		String secondApprovername = request.getParameter("secondApprovername");
		String secondapprovercontact = request.getParameter("secondapprovercontact");
		String Description = request.getParameter("Description");
		String clientname = request.getParameter("clientname");
		String contactperson = request.getParameter("contactperson");
		String enccustomername = request.getParameter("enccustomername");
		String manualAmount = request.getParameter("manualAmount");
		String ATC = request.getParameter("ATC");
		
		
		//25/06
		String proposal_For=request.getParameter("proposal_For");
		String PartnerName=request.getParameter("PartnerName");
		
	
	    System.out.println("Proposaltype "+Proposaltype);
	    System.out.println("Description "+Description);
		System.out.println("manualProposalFile manualProposalFile manualProposalFile " + manualProposalFile);
		
		
		
		String finals = AllMasters.manualProposalDetailsSubmit( manualProposalFile,poinitiator, poinitiatorno, FirstApprovername,
				firstapprovercontact, secondApprovername, secondapprovercontact, clientname, Description,
				 uname, ATC, Proposaltype, Perpetualyear, Subscriptionyear,  productsuitselect, Scanplusprodversion, SecureITprodversion,
				enccustomername, fixedyear,contactperson, subscriptionANDperpetualYear ,manualAmount, proposal_For, PartnerName);
		out.print(finals);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;

}

// UD 3/1
/// 

@RequestMapping(value = { "/getFunctionName" }, method = RequestMethod.POST)
public JSONArray getFunctionName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();
	//	String moduleName = request.getParameter("moduleName");
		// System.out.println("ticketype:::"+location);
		JSONArray final_response = AllMasters.getFunctionName();

		out.print(final_response);

		// System.out.println("SITE NAME GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}


@RequestMapping(value = { "/getDesignation" }, method = RequestMethod.POST)
public JSONArray getDesignation(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();
//		String desigName = request.getParameter("designationName");
		JSONArray final_response = AllMasters.getDesignation();

		out.print(final_response);

		// System.out.println("SITE NAME GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}


@RequestMapping(value = { "/getUserName" }, method = RequestMethod.POST)
public JSONArray getUserName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();
		String desigName = request.getParameter("designation");
		JSONArray final_response = AllMasters.getUserName(desigName);

		out.print(final_response);

		// System.out.println("SITE NAME GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
} 


@RequestMapping(value = { "/getUserID" }, method = RequestMethod.POST)
public String getUserID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	try {
		out = response.getWriter();
		String username = request.getParameter("username");
		String final_response = AllMasters.getUserID(username);

		out.print(final_response);

		// System.out.println("SITE NAME GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}


@RequestMapping(value = { "/generateEnvkey" }, method = RequestMethod.POST)
public void generateEnvkey(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	System.out.println("Inside getPOidListData method");
	
	 String productSuitNameList=request.getParameter("productSuitNameList");
	 String proposalId=request.getParameter("proposalId");

	PrintWriter out = null;
	try {
		
	

		out = response.getWriter();
		JSONArray array = (JSONArray) AllMasters.generateEnvkey(productSuitNameList,proposalId);
		System.out.println("List value: "+array);
		out.print(array);
	}
	catch(Exception e) {
		System.out.println("Exception in getAttachmentCSData method: "+e);
	}
	
}


//6/01/24

@RequestMapping(value = { "/getTeamLeader" }, method = RequestMethod.POST)
public JSONArray getTeamLeader(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();
	//	String moduleName = request.getParameter("moduleName");
		// System.out.println("ticketype:::"+location);
		JSONArray final_response = AllMasters.getTeamLeader();

		out.print(final_response);

		// System.out.println("SITE NAME GET SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}



@RequestMapping(value = { "/getDevelopers" }, method = RequestMethod.POST)
public JSONArray getDevelopers(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {

	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();

		JSONArray final_response = AllMasters.getDevelopers();

		out.print(final_response);

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}

//06/24
@RequestMapping(value = { "/apprvlRdDocuments" }, method = RequestMethod.POST)
public JSONArray apprvlRdDocuments(ModelMap model, HttpServletRequest request,
		HttpServletResponse response, HttpSession session) {
	System.out.println("Inside  revisedProposalPendingDetailsMD Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		
		JSONArray final_response = AllMasters.apprvlRdDocuments();

		System.out.println("MastersControllerrrr reponse is = " + final_response);

		out.print(final_response);


	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//return "Dashboard";
	return null;

}

//12/1  Manual ProposalUpdateDetails
@RequestMapping(value = {"/ManualproposalUpdateDetails"},method = RequestMethod.POST )
public String ManualproposalUpdateDetails(@RequestParam("fileInput") MultipartFile[] updateManualFile,HttpServletRequest request, HttpServletResponse response,HttpSession session)
{
	PrintWriter out=null;
	try {
		out=response.getWriter();
		
		
		String uname = (String) session.getAttribute("username");
		String company = (String) session.getAttribute("usercompany");
  System.out.println("usernamemeeem login==" + uname);
  System.out.println("Master controller veloxproposalUpdateDetails ");
  System.out.println("Manual File"+updateManualFile);
		
		String veloxdata=request.getParameter("veloxdata");
		String manualamount = request.getParameter("manualAmount");
		String poinitiator=request.getParameter("poinitiator");
		String poinitiatorno=request.getParameter("poinitiatorno");
		String FirstApprovername=request.getParameter("FirstApprovername");
		
		String firstapprovercontact=request.getParameter("firstapprovercontact");
		String secondApprovername=request.getParameter("secondApprovername");
		String secondapprovercontact=request.getParameter("secondapprovercontact");
		String clientname=request.getParameter("clientname");
		String Description=request.getParameter("Description");
		String totalpriceforallproduct =request.getParameter("totalpriceforallproduct");
		String deploysupport =request.getParameter("deploysupport");
		String clouddeploycharges =request.getParameter("clouddeploycharges");
		String subtotalB =request.getParameter("subtotalB");
		String resoucesamount=request.getParameter("resoucesamount");
		String ATC=request.getParameter("ATC");
		String subtotalAB=request.getParameter("subtotalAB");
		
		String Proposaltype =request.getParameter("Proposaltype");
		String Perpetualyear=request.getParameter("Perpetualyear");
		String Subscriptionyear =request.getParameter("Subscriptionyear");					
		String Amcsecondyear=request.getParameter("Amcsecondyear");
		String Amcthirdyear=request.getParameter("Amcthirdyear");
		String Amcfourthyear=request.getParameter("Amcfourthyear");
		String Amcfiveyear=request.getParameter("Amcfiveyear");
		String secondyearsubscription=request.getParameter("secondyearsubscription");
		String thirdyearsubscription=request.getParameter("thirdyearsubscription");	
		
		   String productsuitselect=request.getParameter("productsuitselect");
		    String Scanplusprodversion=request.getParameter("Scanplusprodversion");
		    String SecureITprodversion=request.getParameter("SecureITprodversion");
		    String enccustomername=request.getParameter("enccustomername");
		    String fixedyear=request.getParameter("fixedyear");
		    
						
		
		
		String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
	    String fullPathVlxLogo = servletContext.getRealPath(folderPath);
	    String fullPathVlxEnd = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/end.png");
	    String fullPathSwachBharat = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/swachBharat.png");
	    String Letterhead = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/Letterhead.PNG");
	    String signature = servletContext.getRealPath("/WEB-INF/VeloxProposalPDF/signature.PNG");
	    System.out.println("fullPath "+fullPathVlxLogo);
	    System.out.println("signature "+signature);
	    
	    String IntegrationchargeYesNo = request.getParameter("IntegrationCharges");
	    String IntegrationCharges = request.getParameter("integrationcharge");
	    String Total_C=request.getParameter("totalc");
	    String GSTPERCENTAGE=request.getParameter("total18percentage");
	    String Grand_Total=request.getParameter("grandtotal");
		
		String crno =request.getParameter("crno");
		String tid =request.getParameter("tid");
		String SInote=request.getParameter("SInote");
		
		
		String amcstartdate = request.getParameter("amcstartdate");
		String AMCmonthyear = request.getParameter("AMCmonthyear");
		String AMCMonth = request.getParameter("AMCMonth");
		String AMCYear = request.getParameter("AMCYear");
		String amcenddate = request.getParameter("amcenddate");
		String productsuitdetails = request.getParameter("productsuitdetails");
		String securitysolutiondetails = request.getParameter("securitysolutiondetails");
		String descforamc = request.getParameter("descforamc");
		String totalcostAMC = request.getParameter("totalcostAMC");
		String GRANDTOTALFORAMC = request.getParameter("GRANDTOTALFORAMC");
		String gstforamc = request.getParameter("gstforamc");
		
		String subtotalAResource = request.getParameter("subtotalAResource");
		String gstdataforresource = request.getParameter("gstdataforresource");
		String grandtotalforresource = request.getParameter("grandtotalforresource");
		
		String contactperson = request.getParameter("contactperson");
					
	   
		String veloxdata1 = request.getParameter("veloxdata1");
		String subscriptionANDperpetualYear = request.getParameter("subscriptionANDperpetualYear");
		String perpetualSubsAnnualperpType = request.getParameter("perpetualSubsAnnualperpType");
		String perpetualSubs3yearperpType = request.getParameter("perpetualSubs3yearperpType");
		String deploysupport21 = request.getParameter("deploysupport21");
		String clouddeploycharges21 = request.getParameter("clouddeploycharges21");
		String IntegrationCharges21 = request.getParameter("IntegrationCharges21");
		String integrationcharge21 = request.getParameter("integrationcharge21");
		String subtotalB21 = request.getParameter("subtotalB21");
		String totalc21 = request.getParameter("totalc21");
		String total18percentage21 = request.getParameter("total18percentage21");
		String grandtotal21 = request.getParameter("grandtotal21");
		String resoucesamount21 = request.getParameter("resoucesamount21");
		
		String proposalfor = request.getParameter("proposalfor");
		String partnername = request.getParameter("partnername");
		

		String finals=AllMasters.ManualproposalUpdateDetails(updateManualFile,veloxdata,manualamount,poinitiator,poinitiatorno,FirstApprovername,firstapprovercontact,secondApprovername,secondapprovercontact,clientname,Description,totalpriceforallproduct,deploysupport,clouddeploycharges,subtotalB,subtotalAB,uname,resoucesamount,ATC,Proposaltype,Perpetualyear,
				Subscriptionyear,Amcsecondyear,Amcthirdyear,Amcfourthyear,Amcfiveyear,secondyearsubscription,thirdyearsubscription,fullPathVlxLogo,fullPathVlxEnd,fullPathSwachBharat,
				IntegrationchargeYesNo,IntegrationCharges,Total_C,GSTPERCENTAGE,Grand_Total,productsuitselect,Scanplusprodversion,SecureITprodversion,enccustomername,Letterhead,signature,
				fixedyear,crno,tid,SInote,amcstartdate,AMCmonthyear,AMCMonth,AMCYear,
				amcenddate,productsuitdetails,securitysolutiondetails,descforamc,totalcostAMC,GRANDTOTALFORAMC,gstforamc,
				gstdataforresource ,grandtotalforresource ,subtotalAResource,contactperson,veloxdata1 , subscriptionANDperpetualYear , perpetualSubsAnnualperpType, perpetualSubs3yearperpType, deploysupport21 , clouddeploycharges21 , 
				 IntegrationCharges21 , integrationcharge21 ,  subtotalB21 ,  totalc21 ,  total18percentage21 ,  grandtotal21 , resoucesamount21, proposalfor, partnername  );
		
		
		out.print(finals);
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
return null;

}



//22/1  updateVeloxLicensedetails

	@RequestMapping(value = { "/updateVeloxLicensedetails" }, method = RequestMethod.POST)
	public String updateVeloxLicensedetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String uname = (String) session.getAttribute("username");
			String company = (String) session.getAttribute("usercompany");
			System.out.println("usernamemeeem login==" + uname);

			String crno = request.getParameter("crno");
			String tid = request.getParameter("tid");
			
			String veloxdata = request.getParameter("veloxdata");
			String sppliernamelicense = request.getParameter("sppliernamelicense");
			String clientname = request.getParameter("clientname");
			String EnvironmentKeyNo = request.getParameter("EnvironmentKeyNo");
			String ponumber = request.getParameter("ponumber");
			String podate = request.getParameter("podate");

			String OEMAddress = request.getParameter("OEMAddress");
			String clientAddress = request.getParameter("clientAddress");
			String endcostomername = request.getParameter("endcostomername");
			String endCustomerEmail = request.getParameter("endCustomerEmail");

			String folderPath = "/WEB-INF/VeloxProposalPDF/veloxlogo.png";
			String fullPathVlxLogo = servletContext.getRealPath(folderPath);

			String firstApprovername = request.getParameter("FirstApprovername");
			String secondApprovername = request.getParameter("SecondApprovername");
			String poID = request.getParameter("poID");
			String payment_recieved = request.getParameter("payment_recieved");
			
			String signaturePath =  "/WEB-INF/VeloxProposalPDF/signaturekale.png";
			String AMsignature = servletContext.getRealPath(signaturePath);

			String finals = AllMasters.updateVeloxLicensedetails(veloxdata, sppliernamelicense, clientname,
					EnvironmentKeyNo, ponumber, podate, folderPath, fullPathVlxLogo, OEMAddress, clientAddress,
					endcostomername, endCustomerEmail, firstApprovername, secondApprovername, uname, poID,
					payment_recieved, crno, tid, AMsignature);

			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
//	5/2/24
	@RequestMapping(value = { "/ClientMaster" }, method = RequestMethod.POST)
	public String ClientMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productSuit = request.getParameter("productSuit");
			String securitytool = request.getParameter("Securitytool");
			String customerName = request.getParameter("customerName");
			String prodManager = request.getParameter("ProdManager");
			String functionName = request.getParameter("functionName");
			String targetDate = request.getParameter("targetDate");
			String status = request.getParameter("status");
			
			String role = (String) session.getAttribute("role");
			
			String finals = AllMasters.ClientMaster(productSuit, securitytool, customerName, prodManager, functionName,targetDate,status, role);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	//15.01

	@RequestMapping(value = { "/saveupload" }, method = RequestMethod.POST)
	public String saveupload(@RequestParam("manualProposalFile") MultipartFile[] manualProposalFile,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String uname = (String) session.getAttribute("username");
			String crno =request.getParameter("crno");
			String tid =request.getParameter("tid");
			
			System.out.println("manualProposalFile manualProposalFile manualProposalFile " + manualProposalFile);
			System.out.println("crno " + manualProposalFile);
			System.out.println("tid " + manualProposalFile);
			
			
			
			String finals = AllMasters.saveupload(manualProposalFile,uname,crno,tid );
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	//16/1

	@RequestMapping(value = { "/getManagerList" }, method = RequestMethod.POST)
	public JSONArray getManagerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getManagerList(); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getAccManagerList" }, method = RequestMethod.POST)
	public JSONArray getAccManagerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getAccManagerList();

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	@RequestMapping(value = { "/Tlmasterlisting" }, method = RequestMethod.POST)
	public JSONArray Tlmasterlisting(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String subjectList = null;
			JSONArray final_response = AllMasters.Tlmasterlisting(subjectList);
			out.print(final_response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/saveTlMaster" }, method = RequestMethod.POST)
	public String saveTlMaster(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		PrintWriter out = null;
		try {
			out = response.getWriter();

			String productsuit = request.getParameter("productsuit");
			String productname = request.getParameter("securitysolution");
			String unit = request.getParameter("unitdata");
			String ImplementerName = request.getParameter("ImplementerName");
			String Tlname = request.getParameter("Tlname");
			String developer = request.getParameter("developerName");
			String customerName = request.getParameter("customerName");
			
			String finals = AllMasters.saveTlMaster(productsuit, productname, unit, ImplementerName,Tlname, developer, customerName);
			out.print(finals);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	@RequestMapping(value = { "/deleteTlMaster" }, method = RequestMethod.POST)
	public JSONArray deleteTlMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteTlMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			int srno = Integer.parseInt(request.getParameter("srno"));

			String final_response = AllMasters.deleteTlMaster(srno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	@RequestMapping(value = { "/updateTLMaster" }, method = RequestMethod.POST)
	public JSONArray updateTLMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String productsuitupdate = request.getParameter("productsuitupdate");
			String securitysolutionupdate = request.getParameter("securitysolutionupdate");
			String tlname = request.getParameter("tlname");
			int srno = Integer.parseInt(request.getParameter("sr_no"));
			String updImplementerName = request.getParameter("updImplementerName");

			String final_response = AllMasters.updateTLMaster(productsuitupdate, securitysolutionupdate,
					tlname, srno, updImplementerName);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = { "/DownloadBluckUploadfile" }, method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> DownloadBluckUploadfile(HttpServletRequest request)
			throws IOException {

		String filename1 = AllMasters.DownloadBluckUploadfile();
		// System.out.println("filename1 " + filename1);

		String filename = "C:\\".concat(filename1);

		File file = new File(filename);
		// System.out.println("filename " + file.getName());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<InputStreamResource> responseEntity = ResponseEntity.ok().headers(headers)
				.contentLength(file.length())
				// .contentType(MediaType.parseMediaType("application/txt")).body(resource);
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);

		return responseEntity;
	}
	
	
	@RequestMapping(value = { "/saveBulkUploadTaskFile" }, method = RequestMethod.POST)
	public String saveBulkUploadTaskFile(ModelMap model, @RequestParam("bulkUserData") MultipartFile bulkUserData,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// System.out.println("Inside saveBulkUploadUserData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			// System.out.println("bulkUserData FILE NAME:
			// "+bulkUserData.getOriginalFilename());
			// System.out.println("bulkUserData FILE SIZE: "+bulkUserData.getSize());
			String userfullname = (String) session.getAttribute("fullname");
			String uname = (String) session.getAttribute("username");
			 String role = (String) session.getAttribute("role");
			 
			 
			 System.out.println("bulkUserData path  =>" + bulkUserData);
			String final_response = AllMasters.saveBulkUploadTaskFile(bulkUserData,userfullname,uname, role);

			System.out.println("saveBulkUploadTaskFile reponse is = " + final_response);

			// System.out.println("saveBulkUploadUserData GET SUCCESS");

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}
	
	

	@RequestMapping(value = { "/getTesterList" }, method = RequestMethod.POST)
	public JSONArray getTesterList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
		//	String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			JSONArray final_response = AllMasters.getTesterList();

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}	
	
	
	@RequestMapping(value = { "/getTeamLeaderByManager" }, method = RequestMethod.POST)
	public JSONArray getTeamLeaderByManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
		//	String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			String userfullname = (String) session.getAttribute("fullname");
			
			JSONArray final_response = AllMasters.getTeamLeaderByManager(userfullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/getDevelopersByManager" }, method = RequestMethod.POST)
	public JSONArray getDevelopersByManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
		//	String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			String userfullname = (String) session.getAttribute("fullname");
			
			JSONArray final_response = AllMasters.getDevelopersByManager(userfullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/getDevelopersByTL" }, method = RequestMethod.POST)
	public JSONArray getDevelopersByTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
		//	String moduleName = request.getParameter("moduleName");
			// System.out.println("ticketype:::"+location);
			String userfullname = (String) session.getAttribute("fullname");
			
			JSONArray final_response = AllMasters.getDevelopersByTL(userfullname);

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/getAllClientList" }, method = RequestMethod.POST)
	public JSONArray getAllClientList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside ProblemCompositeListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();

			JSONArray final_response = AllMasters.getAllClientList();

			// System.out.println("ProblemCompositeListing reponse is = " + final_response);
			out.print(final_response);
			// System.out.println("ProblemCompositeListing SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/updateClientMaster" }, method = RequestMethod.POST)
	public JSONArray updateClientMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompositeMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String srno = request.getParameter("srno");
			String customer = request.getParameter("customer");
			String prodSuite = request.getParameter("prodSuite");
			String prodTool = request.getParameter("prodTool");
			String managerName = request.getParameter("managerName");
			String functionName = request.getParameter("functionName");
			String toDateUpdate = request.getParameter("toDateUpdate");
			String statusUpdate = request.getParameter("statusUpdate");

			 System.out.println("company is = " + customer);
			 System.out.println("prodSuiteprodSuite is = " + prodSuite);
			// System.out.println("location is = " + location);
			// System.out.println("department is = " + department);
			// System.out.println("subDepartment is = " + subDepartment);

			String final_response = AllMasters.updateClientMaster(srno, customer, prodSuite, prodTool, managerName,
					functionName,toDateUpdate, statusUpdate);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/deleteClientDetails" }, method = RequestMethod.POST)
	public JSONArray deleteClientDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside deleteComposite Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			int crno = Integer.parseInt(request.getParameter("crno"));

			String final_response = AllMasters.deleteClientDetails(crno);
			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}
	
		
	@RequestMapping(value = { "/updateUserActivity" }, method = RequestMethod.POST)
	public JSONArray updateUserActivity(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println("Inside updateCompositeMaster Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String userfullname = (String) session.getAttribute("fullname");
			String username = request.getParameter("username");
			String activities = request.getParameter("activities");

			 System.out.println("company is" +username+ " = " + activities);
			// System.out.println("location is = " + location);
			// System.out.println("department is = " + department);
			// System.out.println("subDepartment is = " + subDepartment);

			String final_response = AllMasters.updateUserActivity(username, activities, userfullname);

			out.print(final_response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	
	
	//05/07
	@RequestMapping(value = { "/getCompletedProjectList" }, method = RequestMethod.POST)
	public JSONArray getCompletedProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = AllMasters.getCompletedProjectList(userfullname,role); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	//05/07
	@RequestMapping(value = { "/getCompletedManagerList" }, method = RequestMethod.POST)
	public JSONArray getCompletedManagerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			
			String userfullname = (String) session.getAttribute("fullname");
			
			String role = (String) session.getAttribute("role");

			JSONArray final_response = AllMasters.getCompletedManagerList(userfullname,role); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	//05/07
	@RequestMapping(value = { "/getCompletedTeamLeader" }, method = RequestMethod.POST)
	public JSONArray getCompletedTeamLeader(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String userfullname = (String) session.getAttribute("fullname");
			String role = (String) session.getAttribute("role");

			JSONArray final_response = AllMasters.getCompletedTeamLeader(userfullname,role); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	
	@RequestMapping(value = { "/CompletedManagerListDet" }, method = RequestMethod.POST)
	public JSONArray CompletedManagerListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			
			JSONArray final_response = AllMasters.CompletedManagerListDet(projectNamesN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	//05/07
	@RequestMapping(value = { "/CompletedDetailsByCus" }, method = RequestMethod.POST)
	public JSONArray CompletedDetailsByCus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			String teamLeaderNameN=request.getParameter("teamLeaderNameN");
			String FnameN=request.getParameter("FnameN");
			
			JSONArray final_response = AllMasters.CompletedDetailsByCus(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	//05/07
	@RequestMapping(value = { "/CompletedTLListDet" }, method = RequestMethod.POST)
	public JSONArray CompletedTLListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			
			String role = (String) session.getAttribute("role");
			
			JSONArray final_response = AllMasters.CompletedTLListDet(projectNamesN,prodmgrN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	@RequestMapping(value = { "/CompletedBasedOnManager" }, method = RequestMethod.POST)
	public JSONArray CompletedBasedOnManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String selectedCustomer=request.getParameter("projectNamesN");
			String selectedMan=request.getParameter("prodmgrN");
			String selectedTL=request.getParameter("teamLeaderNameN");
			String selectedFunction=request.getParameter("FnameN");
			
			JSONArray final_response = AllMasters.CompletedBasedOnManager(selectedCustomer,selectedMan,selectedTL,selectedFunction); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	@RequestMapping(value = { "/CompletedDetailsByCusAndMan" }, method = RequestMethod.POST)
	public JSONArray CompletedDetailsByCusAndMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			
			JSONArray final_response = AllMasters.CompletedDetailsByCusAndMan(projectNamesN,prodmgrN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	@RequestMapping(value = { "/CompletedFunctionListDet" }, method = RequestMethod.POST)
	public JSONArray CompletedFunctionListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			String teamLeaderNameN=request.getParameter("teamLeaderNameN");
			String FnameN=request.getParameter("FnameN");
			
			JSONArray final_response = AllMasters.CompletedFunctionListDet(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	@RequestMapping(value = { "/CompletedDetailsByCusManAndTL" }, method = RequestMethod.POST)
	public JSONArray CompletedDetailsByCusManAndTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			String teamLeaderNameN=request.getParameter("teamLeaderNameN");
			
			JSONArray final_response = AllMasters.CompletedDetailsByCusManAndTL(projectNamesN,prodmgrN,teamLeaderNameN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	@RequestMapping(value = { "/CompletedDetailsBasedOnAll" }, method = RequestMethod.POST)
	public JSONArray CompletedDetailsBasedOnAll(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String projectNamesN=request.getParameter("projectNamesN");
			String prodmgrN=request.getParameter("prodmgrN");
			String teamLeaderNameN=request.getParameter("teamLeaderNameN");
			String FnameN=request.getParameter("FnameN");
			
			JSONArray final_response = AllMasters.CompletedDetailsBasedOnAll(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

			out.print(final_response);

			// System.out.println("SITE NAME GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	
	
	
		//28/06
		@RequestMapping(value = { "/CompletedManagerListDet1" }, method = RequestMethod.POST)
		public JSONArray CompletedManagerListDet1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedManagerListDet1(projectNamesN1,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		@RequestMapping(value = { "/CompletedDetailsByCus1" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCus1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				String teamLeaderNameN1=request.getParameter("teamLeaderNameN1");
				String FnameN1=request.getParameter("FnameN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCus1(projectNamesN1,prodmgrN1,teamLeaderNameN1,FnameN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		
		@RequestMapping(value = { "/CompletedTLListDet1" }, method = RequestMethod.POST)
		public JSONArray CompletedTLListDet1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedTLListDet1(projectNamesN1,prodmgrN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		@RequestMapping(value = { "/CompletedBasedOnManager1" }, method = RequestMethod.POST)
		public JSONArray CompletedBasedOnManager1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String selectedCustomer=request.getParameter("projectNamesN1");
				String selectedMan=request.getParameter("prodmgrN1");
				String selectedTL=request.getParameter("teamLeaderNameN1");
				String selectedFunction=request.getParameter("FnameN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedBasedOnManager1(selectedCustomer,selectedMan,selectedTL,selectedFunction,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		@RequestMapping(value = { "/CompletedDetailsByCusAndMan1" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusAndMan1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusAndMan1(projectNamesN1,prodmgrN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		@RequestMapping(value = { "/CompletedFunctionListDet1" }, method = RequestMethod.POST)
		public JSONArray CompletedFunctionListDet1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				String teamLeaderNameN1=request.getParameter("teamLeaderNameN1");
				String FnameN1=request.getParameter("FnameN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedFunctionListDet1(projectNamesN1,prodmgrN1,teamLeaderNameN1,FnameN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		
		@RequestMapping(value = { "/CompletedDetailsByCusManAndTL1" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusManAndTL1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				String teamLeaderNameN1=request.getParameter("teamLeaderNameN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusManAndTL1(projectNamesN1,prodmgrN1,teamLeaderNameN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		@RequestMapping(value = { "/CompletedDetailsBasedOnAll1" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsBasedOnAll1(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN1=request.getParameter("projectNamesN1");
				String prodmgrN1=request.getParameter("prodmgrN1");
				String teamLeaderNameN1=request.getParameter("teamLeaderNameN1");
				String FnameN1=request.getParameter("FnameN1");
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.CompletedDetailsBasedOnAll1(projectNamesN1,prodmgrN1,teamLeaderNameN1,FnameN1,role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		//24/07
		@RequestMapping(value = { "/getSupportTeamLeader" }, method = RequestMethod.POST)
		public JSONArray getSupportTeamLeader(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
			//	String moduleName = request.getParameter("moduleName");
				// System.out.println("ticketype:::"+location);
				JSONArray final_response = AllMasters.getSupportTeamLeader();

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		//24/07
		@RequestMapping(value = { "/getSupport" }, method = RequestMethod.POST)
		public JSONArray getSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
//				String supportTeamLead = request.getParameter("supportteamLeader");

				JSONArray final_response = AllMasters.getSupport();

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		//01/08
		@RequestMapping(value = { "/getproducutsuitListSupport" }, method = RequestMethod.POST)
		public JSONArray getproducutsuitListSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;

			try {
				out = response.getWriter();
				JSONArray final_response = AllMasters.getproducutsuitListSupport();
				// System.out.println("getCompositeCompanyList reponse is = " + final_response);
				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				if (out != null)
					out.close();
			}

			return null;

		}
		
		
		
		@RequestMapping(value = { "/getimplementerListSupport" }, method = RequestMethod.POST)
		public JSONArray getimplementerListSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;

			try {
				out = response.getWriter();
				JSONArray final_response = AllMasters.getimplementerListSupport();
				// System.out.println("getCompositeCompanyList reponse is = " + final_response);
				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				if (out != null)
					out.close();
			}

			return null;

		}
		
		
		
		
		@RequestMapping(value = { "/getCustomerNameSupport" }, method = RequestMethod.POST)
		public JSONArray getCustomerNameSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();

				JSONArray final_response = AllMasters.getCustomerNameSupport();

				System.out.println("MastersControllerrrr reponse is = " + final_response);

				out.print(final_response);

				// System.out.println("getRequestModeName GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		
		
		
		
		@RequestMapping(value = { "/getFunctionNameSupport" }, method = RequestMethod.POST)
		public JSONArray getFunctionNameSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
			//	String moduleName = request.getParameter("moduleName");
				// System.out.println("ticketype:::"+location);
				JSONArray final_response = AllMasters.getFunctionNameSupport();

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		@RequestMapping(value = { "/getAllClientListSupport" }, method = RequestMethod.POST)
		public JSONArray getAllClientListSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			// System.out.println("Inside ProblemCompositeListing Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();

				JSONArray final_response = AllMasters.getAllClientListSupport();

				// System.out.println("ProblemCompositeListing reponse is = " + final_response);
				out.print(final_response);
				// System.out.println("ProblemCompositeListing SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			return null;
		}
		
		
		
		@RequestMapping(value = { "/getsecuritysolutionListSupport" }, method = RequestMethod.POST)
		public JSONArray getsecuritysolutionListSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;

			try {
				out = response.getWriter();
				String productsuit = request.getParameter("productsuit");

				JSONArray finals = AllMasters.getsecuritysolutionListSupport(productsuit);
				out.print(finals);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				if (out != null)
					out.close();
			}

			return null;

		}
		
		
		@RequestMapping(value = { "/ClientMasterSupport" }, method = RequestMethod.POST)
		public String ClientMasterSupport(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			PrintWriter out = null;
			try {
				out = response.getWriter();

				String productSuit = request.getParameter("productSuit");
				String securitytool = request.getParameter("Securitytool");
				String customerName = request.getParameter("customerName");
				String prodManager = request.getParameter("ProdManager");
				String functionName = request.getParameter("functionName");
				String targetDate = request.getParameter("targetDate");
				String status = request.getParameter("status");
				
				String role = (String) session.getAttribute("role");
				
				String finals = AllMasters.ClientMasterSupport(productSuit, securitytool, customerName, prodManager, functionName,targetDate,status, role);
				out.print(finals);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		}
		
		
		
		@RequestMapping(value = { "/updateClientMasterSupport" }, method = RequestMethod.POST)
		public JSONArray updateClientMasterSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			// System.out.println("Inside updateCompositeMaster Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();
				String srno = request.getParameter("srno");
				String customer = request.getParameter("customer");
				String prodSuite = request.getParameter("prodSuite");
				String prodTool = request.getParameter("prodTool");
				String managerName = request.getParameter("managerName");
//				String functionName = request.getParameter("functionName");
				String toDateUpdate = request.getParameter("toDateUpdate");
				String statusUpdate = request.getParameter("statusUpdate");

				 System.out.println("company is = " + customer);
				 System.out.println("prodSuiteprodSuite is = " + prodSuite);
				// System.out.println("location is = " + location);
				// System.out.println("department is = " + department);
				// System.out.println("subDepartment is = " + subDepartment);

				String final_response = AllMasters.updateClientMasterSupport(srno, customer, prodSuite, prodTool, managerName,
					toDateUpdate, statusUpdate);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
			return null;
		}
		
		
		
		
		@RequestMapping(value = { "/deleteClientDetailsSupport" }, method = RequestMethod.POST)
		public JSONArray deleteClientDetailsSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			// System.out.println("Inside deleteComposite Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String sname = null;

			try {
				out = response.getWriter();
				int crno = Integer.parseInt(request.getParameter("crno"));

				String final_response = AllMasters.deleteClientDetailsSupport(crno);
				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			return null;

		}
		
		
		
		@RequestMapping(value = { "/getDevelopersTLSupport" }, method = RequestMethod.POST)
		public JSONArray getDevelopersTLSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
			//	String moduleName = request.getParameter("moduleName");
				// System.out.println("ticketype:::"+location);
				JSONArray final_response = AllMasters.getDevelopersTLSupport();

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		@RequestMapping(value = { "/getDevelopersSupport" }, method = RequestMethod.POST)
		public JSONArray getDevelopersSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				String TeamLead = request.getParameter("TeamLead");

				JSONArray final_response = AllMasters.getDevelopersSupport(TeamLead);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		@RequestMapping(value = { "/TlmasterlistingSupport" }, method = RequestMethod.POST)
		public JSONArray TlmasterlistingSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			PrintWriter out = null;
			try {
				out = response.getWriter();

				String subjectList = null;
				JSONArray final_response = AllMasters.TlmasterlistingSupport(subjectList);
				out.print(final_response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			return null;
		}
		
		
		
		@RequestMapping(value = { "/saveTlMasterSupport" }, method = RequestMethod.POST)
		public String saveTlMasterSupport(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			PrintWriter out = null;
			try {
				out = response.getWriter();

				String productsuit = request.getParameter("productsuit");
				String productname = request.getParameter("securitysolution");
				String unit = request.getParameter("unitdata");
				String ImplementerName = request.getParameter("ImplementerName");
				String Tlname = request.getParameter("Tlname");
				String developer = request.getParameter("developerName");
				String customerName = request.getParameter("customerName");
				
				String finals = AllMasters.saveTlMasterSupport(productsuit, productname, unit, ImplementerName,Tlname, developer, customerName);
				out.print(finals);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		}
		
		
		
		@RequestMapping(value = { "/deleteTlMasterSupport" }, method = RequestMethod.POST)
		public JSONArray deleteTlMasterSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			System.out.println("Inside deleteTlMaster Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				int srno = Integer.parseInt(request.getParameter("srno"));

				String final_response = AllMasters.deleteTlMasterSupport(srno);
				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
			return null;

		}
		
		
		
		@RequestMapping(value = { "/updateTLMasterSupport" }, method = RequestMethod.POST)
		public JSONArray updateTLMasterSupport(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			PrintWriter out = null;

			try {
				out = response.getWriter();

				String productsuitupdate = request.getParameter("productsuitupdate");
				String securitysolutionupdate = request.getParameter("securitysolutionupdate");
				String tlname = request.getParameter("tlname");
				int srno = Integer.parseInt(request.getParameter("sr_no"));
				String updImplementerName = request.getParameter("updImplementerName");

				String final_response = AllMasters.updateTLMasterSupport(productsuitupdate, securitysolutionupdate,
						tlname, srno, updImplementerName);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return null;
		}
		
		
		
		
		
		
		@RequestMapping(value = { "/getTeamLeaderBySupportManager" }, method = RequestMethod.POST)
		public JSONArray getTeamLeaderBySupportManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
			//	String moduleName = request.getParameter("moduleName");
				// System.out.println("ticketype:::"+location);
				String userfullname = (String) session.getAttribute("fullname");
				
				
				JSONArray final_response = AllMasters.getTeamLeaderBySupportManager(userfullname);

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
			return null;
		}
		
		
		
		
		
		@RequestMapping(value = { "/getDevelopersBySupportManager" }, method = RequestMethod.POST)
		public JSONArray getDevelopersBySupportManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
			//	String moduleName = request.getParameter("moduleName");
				// System.out.println("ticketype:::"+location);
				String userfullname = (String) session.getAttribute("fullname");
				
				JSONArray final_response = AllMasters.getDevelopersBySupportManager(userfullname);

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				out.close();
			}
			return null;
		}
		
		//
		
		
		//08/08
		@RequestMapping(value = { "/getTeamLeadTL" }, method = RequestMethod.POST)
		public JSONArray getTeamLeadTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String role = (String) session.getAttribute("role");
				String userfullname = (String) session.getAttribute("userfullname");

				JSONArray final_response = AllMasters.getTeamLeadTL(role,userfullname); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		@RequestMapping(value = { "/getCompletedProjectListNew" }, method = RequestMethod.POST)
		public JSONArray getCompletedProjectListNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getCompletedProjectListNew(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		//05/07
		@RequestMapping(value = { "/getCompletedTeamLeaderNew" }, method = RequestMethod.POST)
		public JSONArray getCompletedTeamLeaderNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getCompletedTeamLeaderNew(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		//17/08
		@RequestMapping(value = { "/CompletedManagerListDetNew" }, method = RequestMethod.POST)
		public JSONArray CompletedManagerListDetNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				
				JSONArray final_response = AllMasters.CompletedManagerListDetNew(projectNamesN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		//17/08
		@RequestMapping(value = { "/CompletedDetailsByCusNew" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String FnameN=request.getParameter("FnameNNew");
				
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusNew(projectNamesN,prodmgrN,teamLeaderNameN,FnameN,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		//17/06
		@RequestMapping(value = { "/CompletedTLListDetNew" }, method = RequestMethod.POST)
		public JSONArray CompletedTLListDetNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				
				String role = (String) session.getAttribute("role");
				
				JSONArray final_response = AllMasters.CompletedTLListDetNew(projectNamesN,prodmgrN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		//17/08
		@RequestMapping(value = { "/CompletedBasedOnManagerNew" }, method = RequestMethod.POST)
		public JSONArray CompletedBasedOnManagerNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String selectedCustomer=request.getParameter("projectNamesNNew");
				String selectedMan=request.getParameter("prodmgrNNew");
				String selectedTL=request.getParameter("teamLeaderNameNNew");
				String selectedFunction=request.getParameter("FnameNNew");
				
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedBasedOnManagerNew(selectedCustomer,selectedMan,selectedTL,selectedFunction,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		//17/06
		@RequestMapping(value = { "/CompletedDetailsByCusAndManNew" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusAndManNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusAndManNew(projectNamesN,prodmgrN,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		//17/08
		@RequestMapping(value = { "/CompletedFunctionListDetNew" }, method = RequestMethod.POST)
		public JSONArray CompletedFunctionListDetNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String FnameN=request.getParameter("FnameNNew");
				String productTool = request.getParameter("pToolTotAct");
				
				JSONArray final_response = AllMasters.CompletedFunctionListDetNew(projectNamesN,prodmgrN,teamLeaderNameN,FnameN,productTool); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		
		
		
		
		
		//17/08
		@RequestMapping(value = { "/CompletedDetailsByCusManAndTLNew" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusManAndTLNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusManAndTLNew(projectNamesN,prodmgrN,teamLeaderNameN,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		
		
		
		//17/08
		@RequestMapping(value = { "/CompletedDetailsBasedOnAllNew" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsBasedOnAllNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String FnameN=request.getParameter("FnameNNew");
				String FnameNNewStatus=request.getParameter("FnameNNewStatus");
				
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedDetailsBasedOnAllNew(projectNamesN,prodmgrN,teamLeaderNameN,FnameN,FnameNNewStatus,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		//20/08
		@RequestMapping(value = { "/CompletedStatusListDetNew" }, method = RequestMethod.POST)
		public JSONArray CompletedStatusListDetNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String FnameN=request.getParameter("FnameNNew");
				String FnameNNewStatus=request.getParameter("FnameNNewStatus");
				String productTool = request.getParameter("pToolTotAct");
				
				JSONArray final_response = AllMasters.CompletedStatusListDetNew(projectNamesN,prodmgrN,teamLeaderNameN,FnameN,FnameNNewStatus,productTool); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		//20/08
		@RequestMapping(value = { "/CompletedDetailsByCusManTLNewAndFunction" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusManTLNewAndFunction(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNNew");
				String prodmgrN=request.getParameter("prodmgrNNew");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
				String FnameNNew=request.getParameter("FnameNNew");
				
				String methodName=request.getParameter("methodName");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusManTLNewAndFunction(projectNamesN,prodmgrN,teamLeaderNameN,FnameNNew,methodName); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		
		
		//23/08
		
		@RequestMapping(value = { "/getCompletedProjectListTrack" }, method = RequestMethod.POST)
		public JSONArray getCompletedProjectListTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getCompletedProjectListTrack(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//23/08
		@RequestMapping(value = { "/getCompletedManagerListTrack" }, method = RequestMethod.POST)
		public JSONArray getCompletedManagerListTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				
				String userfullname = (String) session.getAttribute("fullname");
				
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getCompletedManagerListTrack(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		
		//23/08
		@RequestMapping(value = { "/getCompletedTeamLeaderTrack" }, method = RequestMethod.POST)
		public JSONArray getCompletedTeamLeaderTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getCompletedTeamLeaderTrack(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		
		@RequestMapping(value = { "/CompletedManagerListDetTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedManagerListDetTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesNTrack=request.getParameter("projectNamesNTrack");
				
				JSONArray final_response = AllMasters.CompletedManagerListDetTrack(projectNamesNTrack); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		//
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedDetailsByCusTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNTrack");
				String FnameN=request.getParameter("FnameNTrack");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusTrack(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedTLListDetTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedTLListDetTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				
				String role = (String) session.getAttribute("role");
				
				JSONArray final_response = AllMasters.CompletedTLListDetTrack(projectNamesN,prodmgrN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedBasedOnManagerTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedBasedOnManagerTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String selectedCustomer=request.getParameter("projectNamesNTrack");
				String selectedMan=request.getParameter("prodmgrNTrack");
				String selectedTL=request.getParameter("teamLeaderNameNTrack");
				String selectedFunction=request.getParameter("FnameNTrack");
				
				JSONArray final_response = AllMasters.CompletedBasedOnManagerTrack(selectedCustomer,selectedMan,selectedTL,selectedFunction); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedDetailsByCusAndManTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusAndManTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusAndManTrack(projectNamesN,prodmgrN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedFunctionListDetTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedFunctionListDetTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNTrack");
				String FnameN=request.getParameter("FnameNTrack");
				
				JSONArray final_response = AllMasters.CompletedFunctionListDetTrack(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedDetailsByCusManAndTLTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsByCusManAndTLTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNTrack");
				
				JSONArray final_response = AllMasters.CompletedDetailsByCusManAndTLTrack(projectNamesN,prodmgrN,teamLeaderNameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		
		//23/08
		@RequestMapping(value = { "/CompletedDetailsBasedOnAllTrack" }, method = RequestMethod.POST)
		public JSONArray CompletedDetailsBasedOnAllTrack(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesNTrack");
				String prodmgrN=request.getParameter("prodmgrNTrack");
				String teamLeaderNameN=request.getParameter("teamLeaderNameNTrack");
				String FnameN=request.getParameter("FnameNTrack");
				
				JSONArray final_response = AllMasters.CompletedDetailsBasedOnAllTrack(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		//
		
		
		
		//31/08
		@RequestMapping(value = { "/getAllImplementorList" }, method = RequestMethod.POST)
		public JSONArray getAllImplementorList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;

			try {
				out = response.getWriter();
//				String role = (String) session.getAttribute("role");
				JSONArray final_response = AllMasters.getAllImplementorList();
				// System.out.println("getCompositeCompanyList reponse is = " + final_response);
				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				if (out != null)
					out.close();
			}

			return null;

		}
		
		//
		
		@RequestMapping(value = { "/getProductToolListTotAct" }, method = RequestMethod.POST)
		public JSONArray getProductToolListTotAct(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectName=request.getParameter("projectNamesNNew");
				String pManager=request.getParameter("prodmgrNNew");
				String projectTL=request.getParameter("teamLeaderNameNNew");
				String FunctionName=request.getParameter("FnameNNew");
				String ProductTool = request.getParameter("pToolTotAct");
				String status = request.getParameter("FnameNNewStatus");
			
				
				JSONArray final_response = AllMasters.getProductToolListTotAct(projectName,pManager,projectTL,FunctionName,ProductTool,status); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		@RequestMapping(value = { "/getProductToolByManagerTotAct" }, method = RequestMethod.POST)
		public JSONArray getProductToolByManagerTotAct(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesNNew = request.getParameter("projectNamesNNew");
				String prodmgrNNew = request.getParameter("prodmgrNNew");
				String pToolTotAct = request.getParameter("pToolTotAct");
				

				JSONArray final_response = AllMasters.getProductToolByManagerTotAct(projectNamesNNew,prodmgrNNew,pToolTotAct); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		

		@RequestMapping(value = { "/getProductToolTotAct" }, method = RequestMethod.POST)
		public JSONArray getProductToolTotAct(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");
				

				JSONArray final_response = AllMasters.getProductToolTotAct(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//13/09
		@RequestMapping(value = { "/getCustomerNameN" }, method = RequestMethod.POST)
		public JSONArray getCustomerNameN(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {
			// System.out.println("Inside getRequestModeName Controller@@@@@@@@@@@@ ");
			PrintWriter out = null;

			try {
				out = response.getWriter();

				JSONArray final_response = AllMasters.getCustomerNameN();

				System.out.println("MastersControllerrrr reponse is = " + final_response);

				out.print(final_response);

				// System.out.println("getRequestModeName GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}
//			return "Dashboard";
			return null;

		}
		
		//
		
		
		
		
		//10/10
		@RequestMapping(value = { "/getOnHoldProjectList" }, method = RequestMethod.POST)
		public JSONArray getOnHoldProjectList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getOnHoldProjectList(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		
		//10/10
		@RequestMapping(value = { "/getOnHoldManagerList" }, method = RequestMethod.POST)
		public JSONArray getOnHoldManagerList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				
				String userfullname = (String) session.getAttribute("fullname");
				
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getOnHoldManagerList(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		
		//10/10
		@RequestMapping(value = { "/getOnHoldTeamLeader" }, method = RequestMethod.POST)
		public JSONArray getOnHoldTeamLeader(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String userfullname = (String) session.getAttribute("fullname");
				String role = (String) session.getAttribute("role");

				JSONArray final_response = AllMasters.getOnHoldTeamLeader(userfullname,role); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldManagerListDet" }, method = RequestMethod.POST)
		public JSONArray OnHoldManagerListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				
				JSONArray final_response = AllMasters.OnHoldManagerListDet(projectNamesN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldDetailsByCus" }, method = RequestMethod.POST)
		public JSONArray OnHoldDetailsByCus(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				String teamLeaderNameN=request.getParameter("teamLeaderNameN");
				String FnameN=request.getParameter("FnameN");
				
				JSONArray final_response = AllMasters.OnHoldDetailsByCus(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldTLListDet" }, method = RequestMethod.POST)
		public JSONArray OnHoldTLListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				
				String role = (String) session.getAttribute("role");
				
				JSONArray final_response = AllMasters.OnHoldTLListDet(projectNamesN,prodmgrN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldBasedOnManager" }, method = RequestMethod.POST)
		public JSONArray OnHoldBasedOnManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String selectedCustomer=request.getParameter("projectNamesN");
				String selectedMan=request.getParameter("prodmgrN");
				String selectedTL=request.getParameter("teamLeaderNameN");
				String selectedFunction=request.getParameter("FnameN");
				
				JSONArray final_response = AllMasters.OnHoldBasedOnManager(selectedCustomer,selectedMan,selectedTL,selectedFunction); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldDetailsByCusAndMan" }, method = RequestMethod.POST)
		public JSONArray OnHoldDetailsByCusAndMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				
				JSONArray final_response = AllMasters.OnHoldDetailsByCusAndMan(projectNamesN,prodmgrN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldFunctionListDet" }, method = RequestMethod.POST)
		public JSONArray OnHoldFunctionListDet(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				String teamLeaderNameN=request.getParameter("teamLeaderNameN");
				String FnameN=request.getParameter("FnameN");
				
				JSONArray final_response = AllMasters.OnHoldFunctionListDet(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldDetailsByCusManAndTL" }, method = RequestMethod.POST)
		public JSONArray OnHoldDetailsByCusManAndTL(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				String teamLeaderNameN=request.getParameter("teamLeaderNameN");
				
				JSONArray final_response = AllMasters.OnHoldDetailsByCusManAndTL(projectNamesN,prodmgrN,teamLeaderNameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		//10/10
		@RequestMapping(value = { "/OnHoldDetailsBasedOnAll" }, method = RequestMethod.POST)
		public JSONArray OnHoldDetailsBasedOnAll(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
				
				String projectNamesN=request.getParameter("projectNamesN");
				String prodmgrN=request.getParameter("prodmgrN");
				String teamLeaderNameN=request.getParameter("teamLeaderNameN");
				String FnameN=request.getParameter("FnameN");
				
				JSONArray final_response = AllMasters.OnHoldDetailsBasedOnAll(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

				out.print(final_response);

				// System.out.println("SITE NAME GET SUCCESS");

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		
		
		
		
		//28/10
		@RequestMapping(value = { "/getEmployeesByMan" }, method = RequestMethod.POST)
		public JSONArray getEmployeesByMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
				HttpSession session) {

			PrintWriter out = null;
			String sname = null;
			try {
				out = response.getWriter();
//				String TeamLead = request.getParameter("TeamLead");
				
				String uname = (String) session.getAttribute("username");

				JSONArray final_response = AllMasters.getEmployeesByMan(uname);

				out.print(final_response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				out.close();
			}

			return null;
		}
		//
		
		
		
		
		//04/11
				@RequestMapping(value = { "/saveFeedback" }, method = RequestMethod.POST)
				public String saveFeedback(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
					PrintWriter out = null;
					try {
						out = response.getWriter();

						String developerName = request.getParameter("developerName");
						String projectName = request.getParameter("projectName");
						String performanceRating = request.getParameter("performanceRating");
						String feedbackComments = request.getParameter("feedbackComments");
						String suggestions = request.getParameter("suggestions");
						
						
						String role = (String) session.getAttribute("role");
						
						String finals = AllMasters.saveFeedback(developerName, projectName, performanceRating, feedbackComments, suggestions, role);
						out.print(finals);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;

				}
				//
				
				
				
				//04/11
						@RequestMapping(value = { "/saveClientFeedback1" }, method = RequestMethod.POST)
						public String saveClientFeedback1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
							PrintWriter out = null;
							try {
								out = response.getWriter();

								String clientName = request.getParameter("clientName");
								String projectName = request.getParameter("projectName");
								String dateOfFeedback = request.getParameter("dateOfFeedback");
								String feedbackType = request.getParameter("feedbackType");
								String feedbackDescription = request.getParameter("feedbackDescription");
								String impactAssessment = request.getParameter("impactAssessment");
								String statusOfGrievance = request.getParameter("statusOfGrievance");
								String assignedTo = request.getParameter("assignedTo");
								String resolutionDescription = request.getParameter("resolutionDescription");
								String followUpDate = request.getParameter("followUpDate");
								String clientResponse = request.getParameter("clientResponse");
								
								
								String role = (String) session.getAttribute("role");
								
								String finals = AllMasters.saveClientFeedback1(clientName, projectName, dateOfFeedback, feedbackType, feedbackDescription, impactAssessment,statusOfGrievance,assignedTo,resolutionDescription,followUpDate,clientResponse);
								out.print(finals);
							} catch (IOException e) {
								e.printStackTrace();
							}
							return null;

						}
						//
						
						
						
						
						//12/11
						@RequestMapping(value = { "/getDevelopersByManagerOnhold" }, method = RequestMethod.POST)
						public JSONArray getDevelopersByManagerOnhold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
							//	String moduleName = request.getParameter("moduleName");
								// System.out.println("ticketype:::"+location);
								String userfullname = (String) session.getAttribute("fullname");
								
								JSONArray final_response = AllMasters.getDevelopersByManagerOnhold(userfullname);

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}
							finally {
								out.close();
							}
							return null;
						}
						//
						
						
						
						//12/11
						
						@RequestMapping(value = { "/OnHoldManagerListDetMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldManagerListDetMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								
								JSONArray final_response = AllMasters.OnHoldManagerListDetMan(projectNamesN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldDetailsByCusMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldDetailsByCusMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								String teamLeaderNameN=request.getParameter("teamLeaderNameN");
								String FnameN=request.getParameter("FnameN");
								
								JSONArray final_response = AllMasters.OnHoldDetailsByCusMan(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldTLListDetMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldTLListDetMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								
								String role = (String) session.getAttribute("role");
								
								JSONArray final_response = AllMasters.OnHoldTLListDetMan(projectNamesN,prodmgrN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldBasedOnManagerMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldBasedOnManagerMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String selectedCustomer=request.getParameter("projectNamesN");
								String selectedMan=request.getParameter("prodmgrN");
								String selectedTL=request.getParameter("teamLeaderNameN");
								String selectedFunction=request.getParameter("FnameN");
								
								JSONArray final_response = AllMasters.OnHoldBasedOnManagerMan(selectedCustomer,selectedMan,selectedTL,selectedFunction); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldFunctionListDetMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldFunctionListDetMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								String teamLeaderNameN=request.getParameter("teamLeaderNameN");
								String FnameN=request.getParameter("FnameN");
								
								JSONArray final_response = AllMasters.OnHoldFunctionListDetMan(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldDetailsByCusManAndTLMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldDetailsByCusManAndTLMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								String teamLeaderNameN=request.getParameter("teamLeaderNameN");
								
								JSONArray final_response = AllMasters.OnHoldDetailsByCusManAndTLMan(projectNamesN,prodmgrN,teamLeaderNameN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/OnHoldDetailsByCusAndManOnhold" }, method = RequestMethod.POST)
						public JSONArray OnHoldDetailsByCusAndManOnhold(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								
								JSONArray final_response = AllMasters.OnHoldDetailsByCusAndManOnhold(projectNamesN,prodmgrN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						
						@RequestMapping(value = { "/OnHoldDetailsBasedOnAllMan" }, method = RequestMethod.POST)
						public JSONArray OnHoldDetailsBasedOnAllMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesN");
								String prodmgrN=request.getParameter("prodmgrN");
								String teamLeaderNameN=request.getParameter("teamLeaderNameN");
								String FnameN=request.getParameter("FnameN");
								
								JSONArray final_response = AllMasters.OnHoldDetailsBasedOnAllMan(projectNamesN,prodmgrN,teamLeaderNameN,FnameN); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						
						
						
						
						//12/11
						@RequestMapping(value = { "/getCompletedProjectListNewMan" }, method = RequestMethod.POST)
						public JSONArray getCompletedProjectListNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								
								String userfullname = (String) session.getAttribute("fullname");
								String role = (String) session.getAttribute("role");

								JSONArray final_response = AllMasters.getCompletedProjectListNewMan(userfullname,role); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						
						//
	
						
						
						
						
						//12/11
						@RequestMapping(value = { "/getProductToolTotActMan" }, method = RequestMethod.POST)
						public JSONArray getProductToolTotActMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String userfullname = (String) session.getAttribute("fullname");
								String role = (String) session.getAttribute("role");
								

								JSONArray final_response = AllMasters.getProductToolTotActMan(userfullname,role); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/getCompletedTeamLeaderNewMan" }, method = RequestMethod.POST)
						public JSONArray getCompletedTeamLeaderNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String userfullname = (String) session.getAttribute("fullname");
								String role = (String) session.getAttribute("role");

								JSONArray final_response = AllMasters.getCompletedTeamLeaderNewMan(userfullname,role); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/CompletedManagerListDetNewMan" }, method = RequestMethod.POST)
						public JSONArray CompletedManagerListDetNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesNNew");
								String role = (String) session.getAttribute("role");
								
								JSONArray final_response = AllMasters.CompletedManagerListDetNewMan(projectNamesN, role); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/getProductToolListTotActMan" }, method = RequestMethod.POST)
						public JSONArray getProductToolListTotActMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectName=request.getParameter("projectNamesNNew");
								String pManager=request.getParameter("prodmgrNNew");
								String projectTL=request.getParameter("teamLeaderNameNNew");
								String FunctionName=request.getParameter("FnameNNew");
								String ProductTool = request.getParameter("pToolTotAct");
								String status = request.getParameter("FnameNNewStatus");
								String role = (String) session.getAttribute("role");
							
								
								JSONArray final_response = AllMasters.getProductToolListTotActMan(projectName,pManager,projectTL,FunctionName,ProductTool,status,role); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/CompletedTLListDetNewMan" }, method = RequestMethod.POST)
						public JSONArray CompletedTLListDetNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesNNew");
								String prodtoolNNew=request.getParameter("prodtoolNNew");
								
								String role = (String) session.getAttribute("role");
								
								JSONArray final_response = AllMasters.CompletedTLListDetNewMan(projectNamesN,prodtoolNNew); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						
						
						
						
						//12/11
						@RequestMapping(value = { "/getProductToolListTotActManager" }, method = RequestMethod.POST)
						public JSONArray getProductToolListTotActManager(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectName=request.getParameter("projectNamesNNew");
								String pManager=request.getParameter("prodmgrNNew");
								String projectTL=request.getParameter("teamLeaderNameNNew");
								String FunctionName=request.getParameter("FnameNNew");
								String ProductTool = request.getParameter("pToolTotAct");
								String status = request.getParameter("FnameNNewStatus");
							
								
								JSONArray final_response = AllMasters.getProductToolListTotActManager(projectName,pManager,projectTL,FunctionName,ProductTool,status); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/getProductToolByManagerTotActMan" }, method = RequestMethod.POST)
						public JSONArray getProductToolByManagerTotActMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesNNew = request.getParameter("projectNamesNNew");
								String prodmgrNNew = request.getParameter("prodmgrNNew");
								String teamleaderNMan = request.getParameter("teamleaderNMan");
								

								JSONArray final_response = AllMasters.getProductToolByManagerTotActMan(projectNamesNNew,prodmgrNNew,teamleaderNMan); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//12/11
						@RequestMapping(value = { "/CompletedFunctionListDetNewMan" }, method = RequestMethod.POST)
						public JSONArray CompletedFunctionListDetNewMan(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
								
								String projectNamesN=request.getParameter("projectNamesNNew");
								String prodmgrN=request.getParameter("prodmgrNNew");
								String teamLeaderNameN=request.getParameter("teamLeaderNameNNew");
								String FnameN=request.getParameter("FnameNNew");
								String productTool = request.getParameter("pToolTotAct");
								
								JSONArray final_response = AllMasters.CompletedFunctionListDetNewMan(projectNamesN,prodmgrN,teamLeaderNameN,FnameN,productTool); // getTeamLeader

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						//
						
						
						
						//14/11
						@RequestMapping(value = { "/bellNotification" }, method = RequestMethod.POST)
						public JSONArray bellNotification(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							// System.out.println("Inside updateTheme Controller@@@@@@@@@@@@ ");
							PrintWriter out = null;

							try {
								out = response.getWriter();

								String type = request.getParameter("type");
								String value = request.getParameter("value");
								String uname = (String) session.getAttribute("username");

								String final_response = AllMasters.bellNotification(uname);

								out.print(final_response);

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}
							return null;
						}
						
						
						
						@RequestMapping(value = { "/renderNotifications" }, method = RequestMethod.POST)
						public JSONArray renderNotifications(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							// System.out.println("Inside updateTheme Controller@@@@@@@@@@@@ ");
							PrintWriter out = null;

							try {
								out = response.getWriter();

								String type = request.getParameter("type");
								String value = request.getParameter("value");
								String uname = (String) session.getAttribute("username");
								
								String role = (String) session.getAttribute("role");
								String userfullname = (String) session.getAttribute("fullname");
							
								JSONArray final_response = AllMasters.renderNotifications(uname);

								out.print(final_response);

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}
							return null;
						}
						
						
						
						
						//16/11
						@RequestMapping(value = { "/getStatusForDeletedActivities" }, method = RequestMethod.POST)
						public JSONArray getStatusForDeletedActivities(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;

							try {
								out = response.getWriter();
								String productsuit = request.getParameter("productsuit");
								JSONArray finals = AllMasters.getStatusForDeletedActivities(productsuit);
								out.print(finals);

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								if (out != null)
									out.close();
							}

							return null;

						}
						//
						
					
						
						
						@RequestMapping(value = { "/getAllsecuritysolutionList" }, method = RequestMethod.POST)
						public JSONArray getAllsecuritysolutionList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;

							try {
								out = response.getWriter();
//								String productsuit = request.getParameter("productsuit");

								JSONArray finals = AllMasters.getAllsecuritysolutionList();
								out.print(finals);

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								if (out != null)
									out.close();
							}

							return null;

						}
						
	
						
						
						//25/11
						@RequestMapping(value = { "/getproductnametoolN" }, method = RequestMethod.POST)
						public void getproductnametoolN(HttpServletRequest request, HttpServletResponse response) {
							String productSuite = request.getParameter("productSuite");
							PrintWriter out = null;
							try {
								out = response.getWriter();

								String val = AllMasters.getproductnametoolN(productSuite);

								out.print(val);
							} catch (Exception e54) {
								e54.printStackTrace();
							} finally {
								out.close();
							}
						}
						
						
						
						//25/11

						//25/11
						@RequestMapping(value = { "/getproductsuitlistN" }, method = RequestMethod.POST)
						public JSONArray getproductsuitlistN(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							// System.out.println("Inside getcheckerName Controller@@@@@@@@@@@@ ");
							PrintWriter out = null;

							System.out.println("inside product suit details :");

							try {
								out = response.getWriter();

								JSONArray final_response = AllMasters.getproductsuitlistN();

								System.out.println("MastersControllerrrr reponse is = " + final_response);

								out.print(final_response);
							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}
							return null;

						}
						
						
						
						
						
						//28/11
						@RequestMapping(value = { "/updateTLMasterSupportNew" }, method = RequestMethod.POST)
						public JSONArray updateTLMasterSupportNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							PrintWriter out = null;

							try {
								out = response.getWriter();

								String productsuitupdate = request.getParameter("productsuitupdate");
								String securitysolutionupdate = request.getParameter("securitysolutionupdate");
								String tlname = request.getParameter("tlname");
								int srno = Integer.parseInt(request.getParameter("sr_no"));
								String updImplementerName = request.getParameter("updImplementerName");
								String assignedToupdate = request.getParameter("assignedToupdate");

								String final_response = AllMasters.updateTLMasterSupportNew(productsuitupdate, securitysolutionupdate,
										tlname, srno, updImplementerName, assignedToupdate);

								out.print(final_response);

							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							return null;
						}
						//
						
						
						
						
						//28/11
						@RequestMapping(value = { "/getTLForTLMaster" }, method = RequestMethod.POST)
						public JSONArray getTLForTLMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {

							PrintWriter out = null;
							String sname = null;
							try {
								out = response.getWriter();
							//	String moduleName = request.getParameter("moduleName");
								// System.out.println("ticketype:::"+location);
								JSONArray final_response = AllMasters.getTLForTLMaster();

								out.print(final_response);

								// System.out.println("SITE NAME GET SUCCESS");

							} catch (Exception e) {
								e.printStackTrace();
							}

							finally {
								out.close();
							}

							return null;
						}
						
						
						
						
						//28/11
						@RequestMapping(value = { "/TlmasterlistingForTeamMaster" }, method = RequestMethod.POST)
						public JSONArray TlmasterlistingForTeamMaster(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							PrintWriter out = null;
							try {
								out = response.getWriter();

								String subjectList = null;
								JSONArray final_response = AllMasters.TlmasterlistingForTeamMaster(subjectList);
								out.print(final_response);
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								out.close();
							}
							return null;
						}
						
						
						
						//28/11
						@RequestMapping(value = { "/updateTLMasterDeveloperNew" }, method = RequestMethod.POST)
						public JSONArray updateTLMasterDeveloperNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
							PrintWriter out = null;

							try {
								out = response.getWriter();

								String productsuitupdate = request.getParameter("productsuitupdate");
								String securitysolutionupdate = request.getParameter("securitysolutionupdate");
								String tlname = request.getParameter("tlname");
								int srno = Integer.parseInt(request.getParameter("sr_no"));
								String updImplementerName = request.getParameter("updImplementerName");
								String assignedToupdate = request.getParameter("assignedToupdate");

								String final_response = AllMasters.updateTLMasterDeveloperNew(productsuitupdate, securitysolutionupdate,
										tlname, srno, updImplementerName, assignedToupdate);

								out.print(final_response);

							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							return null;
						}
						//
						
						
						//28/11
						@RequestMapping(value = { "/saveTlMasterForMan" }, method = RequestMethod.POST)
						public String saveTlMasterForMan(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
							PrintWriter out = null;
							try {
								out = response.getWriter();

								String productsuit = request.getParameter("productsuit");
								String productname = request.getParameter("securitysolution");
								String unit = request.getParameter("unitdata");
								String ImplementerName = request.getParameter("ImplementerName");
								String Tlname = request.getParameter("Tlname");
								String developer = request.getParameter("developerName");
								String customerName = request.getParameter("customerName");
								
								String finals = AllMasters.saveTlMasterForMan(productsuit, productname, unit, ImplementerName,Tlname, developer, customerName);
								out.print(finals);
							} catch (IOException e) {
								e.printStackTrace();
							}
							return null;

						}
						
						
						@RequestMapping(value = { "/uploadLicenseFile" }, method = RequestMethod.POST)
						public String uploadLicenseFile(@RequestParam("licenseUploadfile") MultipartFile[] licenseUploadfile, HttpServletRequest request, HttpServletResponse response,
								HttpSession session, ModelMap modelMap) {
							System.out.println("Inside uploadLicenseFile ");
							PrintWriter out = null;
							String details = null;
							
							try {
								out = response.getWriter();
								
								String final_response = AllMasters.uploadLicenseFile(licenseUploadfile);
								System.out.println("uploadLicenseFile reponse is = " + final_response);							
									out.print(final_response);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							finally {
								out.close();
							}
							return null;
						}
						
						
						
						
}