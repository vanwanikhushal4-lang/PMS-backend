package com.velox.itsm.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.velox.itsm.service.MailConfig;


@Controller
@RequestMapping("/MailConfig")
public class MailConfigController {

	@Autowired
	MailConfig mailConfig;

	@RequestMapping(value = { "/MailMasterListing" }, method = RequestMethod.POST)
	public JSONArray MailMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside MailMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = mailConfig.MailMasterListing(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("MailMasterListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	
	@RequestMapping(value = { "/sendmailsms" }, method = RequestMethod.POST)
	public void sendmailsms(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside sendmailsms method");
		
                
		String tomailsms = request.getParameter("tomailsms");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = mailConfig.sendmailsms(tomailsms);
			System.out.println("Result value: "+result);
			out.print(result);
		}
		catch(Exception e) {
			System.out.println("Exception in Asave Company: "+e);
		}
		
	}



	@RequestMapping(value = { "/smsConfg" }, method = RequestMethod.POST)
	public void smsConfg(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Inside getBranchList method");
		
           
		String cname = request.getParameter("cname");
		String cname1 = request.getParameter("cname1");
		String cnamevalue = request.getParameter("cnamevalue");
		String apiname = request.getParameter("apiname");
		String apiurl = request.getParameter("apiurl");
		String uname = request.getParameter("uname");
		String uservalue1 = request.getParameter("uservalue1");
		
		String userpswd = request.getParameter("userpswd");
		String pwdvalue1 = request.getParameter("pwdvalue1");
		String userID = request.getParameter("userID");
		String uidvalue = request.getParameter("uidvalue");
		String text1 = request.getParameter("text1");
		String textvalue = request.getParameter("textvalue");
		
		
		String active4 = request.getParameter("active4");
		String otherinput1 = request.getParameter("otherinput1");
		String otherinput2 = request.getParameter("otherinput2");
		String otherinput3 = request.getParameter("otherinput3");
		String otherinput4 = request.getParameter("otherinput4");
		String otherinput5 = request.getParameter("otherinput5");
		String otherinput6 = request.getParameter("otherinput6");
		String otherinput7 = request.getParameter("otherinput7");
		String otherinput8 = request.getParameter("otherinput8");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String result = mailConfig.smsConfg(cname,cnamevalue,apiname,apiurl,uname,uservalue1,userpswd,pwdvalue1,userID,uidvalue,text1,textvalue,active4,otherinput1,otherinput2,otherinput3,otherinput4,otherinput5,otherinput6,otherinput7,otherinput8,cname1);
			System.out.println("Result value: "+result);
			out.print(result);
		}
		catch(Exception e) {
			System.out.println("Exception in Asave Company: "+e);
		}
		
	}
@RequestMapping(value = { "/smsConfigListing" }, method = RequestMethod.POST)
public JSONArray smsConfigListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside smsConfigListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
		
		String userlist=null;
		JSONArray final_response = mailConfig.smsConfigListing(userlist);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("smsConfigListing SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
}

	
@RequestMapping(value = { "/SubmitMailDetails" }, method = RequestMethod.POST)
public JSONArray SubmitMailDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside SubmitMailDetails Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
				
		String host = request.getParameter("host");
		String cname = request.getParameter("cname");
		String PortNo=request.getParameter("port");
		int port=Integer.parseInt(PortNo);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String authentication = request.getParameter("authentication");
		String starttls = request.getParameter("starttls");
		System.out.println("cname is = " + cname);
		System.out.println("host is = " + host);
		System.out.println("port is = " + port);
		System.out.println("email is = " + email);
		System.out.println("password is = " + password);
		System.out.println("authentication is = " + authentication);
						
		String final_response = mailConfig.SubmitMailDetails(host, port, email, password, authentication,cname,starttls);

					
			out.print(final_response);
					
			System.out.println("SubmitMailDetails GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;
	
}
@RequestMapping(value = { "/updateMailConfigSave" }, method = RequestMethod.POST)
public JSONArray updateMailConfigSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside updateMailConfigSave Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	
	try {
		out = response.getWriter();
					
		String hostnameupdate = request.getParameter("hostnameupdate");
		String cnameupdate = request.getParameter("cnameupdate");
		int portnumberupdate = Integer. parseInt(request. getParameter("portnumberupdate"));
		String emailupdate = request.getParameter("emailupdate");
		String authenticationupdate = request.getParameter("authenticationupdate");
		String passwordupdate = request.getParameter("passwordupdate");
		int cr_no = Integer. parseInt(request. getParameter("cr_no"));
		String starttlsup = request.getParameter("starttlsup");
		
		System.out.println("hostnameupdate is = " + hostnameupdate);
		System.out.println("cnameupdate is = " + cnameupdate);
		System.out.println("portnumberupdate is = " + portnumberupdate);
		System.out.println("emailupdate is = " + emailupdate);
		System.out.println("authenticationupdate is = " + authenticationupdate);
		System.out.println("passwordupdate is = " + passwordupdate);
		System.out.println("cr_no is = " + cr_no);
		
		String final_response = mailConfig.updateMailConfigSave(hostnameupdate, portnumberupdate, emailupdate, authenticationupdate, passwordupdate, cr_no,cnameupdate,starttlsup);

		System.out.println("MastersControllerrrr reponse is = " + final_response);
					
			out.print(final_response);
					
			System.out.println("updateMailConfigSave GET SUCCESS");
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;
	
}
	@RequestMapping(value = { "/DeleteMail" }, method = RequestMethod.POST)
	public JSONArray DeleteMail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside DeleteMail Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int crno = Integer. parseInt(request. getParameter("crno"));
			
			System.out.println("crno is = " + crno);
			
			String final_response = mailConfig.DeleteMail(crno);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("DeleteMail GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
		
	}
	
	@RequestMapping(value = { "/EmailAuthListing" }, method = RequestMethod.POST)
	public JSONArray EmailAuthListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside EmailAuthListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = mailConfig.EmailAuthListing(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("EmailAuthListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getUserDetails" }, method = RequestMethod.POST)
	public JSONArray getUserDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	
		try {
			out = response.getWriter();
			String username = request.getParameter("username");
			
			System.out.println("username is = " + username);
			
			JSONArray final_response = mailConfig.getUserDetails(username);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("username GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/SubmitEmailAuthDetails" }, method = RequestMethod.POST)
	public JSONArray SubmitEmailAuthDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitEmailAuthDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
					
			String usertype = request.getParameter("usertype");
			String user = request.getParameter("user");
			String authentication = request.getParameter("authentication");
			
				
			System.out.println("usertype is = " + usertype);
			System.out.println("user is = " + user);
			System.out.println("authentication is = " + authentication);
							
			String final_response = mailConfig.SubmitEmailAuthDetails(usertype, user, authentication);

			System.out.println("MailConfigControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SubmitEmailAuthDetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
		
	}
	
	@RequestMapping(value = { "/updateEmailAuthSave" }, method = RequestMethod.POST)
	public JSONArray updateEmailAuthSave(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside updateEmailAuthSave Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
						
			String usertypeupdate = request.getParameter("usertypeupdate");
			String usernameupdate = request.getParameter("usernameupdate");
			String authenticationupdate = request.getParameter("authenticationupdate");
			int cr_no = Integer. parseInt(request. getParameter("cr_no"));
			
			System.out.println("usertypeupdate is = " + usertypeupdate);
			System.out.println("usernameupdate is = " + usernameupdate);
			System.out.println("authenticationupdate is = " + authenticationupdate);
			System.out.println("cr_no is = " + cr_no);
						
			String final_response = mailConfig.updateEmailAuthSave(usertypeupdate, usernameupdate, authenticationupdate, cr_no);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("updateEmailAuthSave GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/deletemailauth" }, method = RequestMethod.POST)
	public JSONArray deletemailauth(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deletemailauth Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int crno = Integer. parseInt(request. getParameter("crno"));
			
			System.out.println("crno is = " + crno);
			
			String final_response = mailConfig.deletemailauth(crno);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("deletemailauth GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
		
	}
}
