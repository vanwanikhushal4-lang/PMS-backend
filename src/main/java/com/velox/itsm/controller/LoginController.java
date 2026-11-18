package com.velox.itsm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.velox.itsm.ATM.ApplicationPropertyReader;
import com.velox.itsm.dao.EmailSMSDao;
import com.velox.itsm.dao.LoginDao;
import com.velox.itsm.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService LoginService;

	@Autowired
	LoginDao loginDao;

//	@Autowired
//	AuditLoginUserDao auditLoginsUserdao;

	@RequestMapping(value = { "/loginNew" }, method = RequestMethod.POST)
	public String getLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside Login Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();
			String username = request.getParameter("username");
			String Password = request.getParameter("password");
			String companycode = request.getParameter("companycode");

			String userfullname = null;
			System.out.println("Username is = " + username);
			System.out.println("Password is = " + Password);
			System.out.println("Company Code is = " + companycode);
			

			JSONArray final_response = LoginService.getAuthentication(username, Password,companycode);
			System.out.println("FINAL RESPONSE: " + final_response);
			System.out.println("FINAL RESPONSE LENGTH : " + final_response.length());
			System.out.println(final_response.getJSONObject(0).getString("USERNAME"));
			System.out.println(final_response.getJSONObject(0).getString("FULLNAME"));
			System.out.println(final_response.getJSONObject(0).getString("ROLE"));
			System.out.println(final_response.getJSONObject(0).getString("LOGIN_TYPE"));
			System.out.println(final_response.getJSONObject(0).getString("LOGIN_SCOPE"));
			System.out.println(final_response.getJSONObject(0).getString("STATUS"));
			
//			System.out.println(" loginBanch "+final_response.getJSONObject(0).getString("BRANCH"));
			//Syso
			
		//	System.out.println("DESIGNATION VALUE ::"+final_response.getJSONObject(0).getString("DESIGNATION"));
			
//			System.out.println(final_response.getJSONObject(0).getString("companyname"));
			///////////////// AUTHENTICATOR CHECK/////////////////

			String UType = final_response.getJSONObject(0).getString("ROLE");

//			if (final_response.getJSONObject(0).getString("STATUS").equals("Pass") && final_response.getJSONObject(0).getString("LASTLOGIN").equals("true")) {
				
			if (final_response.getJSONObject(0).getString("STATUS").equals("Pass") ) {
			System.out.println("IN MFA BLOCK");
				
				JSONArray FinalArray=new JSONArray();
				JSONArray MFAType_response = loginDao.checkMFAType(username, UType);

				JSONObject arrayobj = new JSONObject();

				arrayobj.put("USERNAME", final_response.getJSONObject(0).getString("USERNAME"));
				arrayobj.put("FULLNAME", final_response.getJSONObject(0).getString("FULLNAME"));
				arrayobj.put("ROLE", final_response.getJSONObject(0).getString("ROLE"));
				arrayobj.put("LOGIN_TYPE", final_response.getJSONObject(0).getString("LOGIN_TYPE"));
				arrayobj.put("LOGIN_SCOPE", final_response.getJSONObject(0).getString("LOGIN_SCOPE"));
				arrayobj.put("DB_VERIFICATION", "success");
				arrayobj.put("MFA_TYPE", MFAType_response.getJSONObject(0).getString("MFA_TYPE"));
				arrayobj.put("FIRST_LOGIN", MFAType_response.getJSONObject(0).getString("FIRST_LOGIN"));
				arrayobj.put("LASTLOGIN", final_response.getJSONObject(0).getString("LASTLOGIN"));
				arrayobj.put("VIEW_DESIGNATION", final_response.getJSONObject(0).getString("VIEW_DESIGNATION"));
				
				
				
				String mfaType= MFAType_response.getJSONObject(0).getString("MFA_TYPE");
				if(mfaType!=null && mfaType.equalsIgnoreCase("OFF")) {
					
					session.setAttribute("username", final_response.getJSONObject(0).getString("USERNAME"));
					session.setAttribute("fullname", final_response.getJSONObject(0).getString("FULLNAME"));
					session.setAttribute("role", final_response.getJSONObject(0).getString("ROLE"));
					session.setAttribute("logintype", final_response.getJSONObject(0).getString("LOGIN_TYPE"));
					session.setAttribute("loginscope", final_response.getJSONObject(0).getString("LOGIN_SCOPE"));
					session.setAttribute("companyname", final_response.getJSONObject(0).getString("companyname"));
					session.setAttribute("designation", final_response.getJSONObject(0).getString("DESIGNATION"));
					session.setAttribute("visibility", final_response.getJSONObject(0).getString("visibility"));
					session.setAttribute("loginBanch", final_response.getJSONObject(0).getString("BRANCH"));
					session.setAttribute("loginDepartment", final_response.getJSONObject(0).getString("DEPARTMENT"));
					session.setAttribute("GROUP", final_response.getJSONObject(0).getString("GROUP"));
					session.setAttribute("SIDEBARSCOPE", final_response.getJSONObject(0).getString("SIDEBARSCOPE"));
					session.setAttribute("VIEW_DESIGNATION", final_response.getJSONObject(0).getString("VIEW_DESIGNATION"));
					
					System.out.println(" loginBanch "+final_response.getJSONObject(0).getString("BRANCH"));
					System.out.println(" loginDepartment"+final_response.getJSONObject(0).getString("DEPARTMENT"));
					
					System.out.println("COMPANY NAME IS   "+ final_response.getJSONObject(0).getString("companyname"));

					System.out.println("VISIBILITY  IS   "+ final_response.getJSONObject(0).getString("visibility"));
					System.out.println("user tyyyyyypeeeeeeeee  IS   "+ final_response.getJSONObject(0).getString("ROLE"));
					
					 
				}
				 
				FinalArray.put(arrayobj);
				session.setMaxInactiveInterval(0);
				System.out.println("FinalArray in controller:-" + FinalArray);
				out.print(FinalArray);
				LoginService.setactivestatus(username,"Login");

//			}
//			else if (final_response.getJSONObject(0).getString("STATUS").equals("Pass") && final_response.getJSONObject(0).getString("LASTLOGIN").equals("false")) {
//			
//				JSONArray MFAType_response = loginDao.checkMFAType(username, UType);
//				JSONObject arrayobj = new JSONObject();
//				arrayobj.put("LASTLOGIN", "false"); 
//				arrayobj.put("ROLE", final_response.getJSONObject(0).getString("ROLE")); 
//				arrayobj.put("DB_VERIFICATION", "success");
//				
//				arrayobj.put("USERNAME", final_response.getJSONObject(0).getString("USERNAME"));
//				arrayobj.put("FULLNAME", final_response.getJSONObject(0).getString("FULLNAME"));
//				arrayobj.put("LOGIN_TYPE", final_response.getJSONObject(0).getString("LOGIN_TYPE"));
//				arrayobj.put("LOGIN_SCOPE", final_response.getJSONObject(0).getString("LOGIN_SCOPE"));
//				arrayobj.put("MFA_TYPE", MFAType_response.getJSONObject(0).getString("MFA_TYPE"));
//				arrayobj.put("FIRST_LOGIN", MFAType_response.getJSONObject(0).getString("FIRST_LOGIN"));
//				arrayobj.put("VIEW_DESIGNATION", final_response.getJSONObject(0).getString("VIEW_DESIGNATION"));
//				
//				
//				MFAType_response.put(arrayobj); 
//				out.print(MFAType_response);
//
//				System.out.println("Inn LASTLOGIN FALSE");
				
				
			} else if(final_response.getJSONObject(0).getString("STATUS").equals("Fail")) {
				JSONArray MFAType_response = new JSONArray();
				JSONObject arrayobj = new JSONObject();
				arrayobj.put("DB_VERIFICATION", "fail"); 
				MFAType_response.put(arrayobj); 
				out.print(MFAType_response);

				System.out.println("LOGIN FAILED");
			}
			 else if(final_response.getJSONObject(0).getString("STATUS").equals("nocompanycode")) {
					JSONArray MFAType_response = new JSONArray();
					JSONObject arrayobj = new JSONObject();
					arrayobj.put("DB_VERIFICATION", "nocompanycode");

					MFAType_response.put(arrayobj);

					out.print(MFAType_response);

					System.out.println("LOGIN FAILED");
				}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(out!=null)
			out.close();
		}
		return null; 
	}

	@RequestMapping(value = { "/LOGOUT" }, method = RequestMethod.GET)
	public String getLoggedOut(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside Logout Controller ");
		PrintWriter out = null;

//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = null;
		Date date = null;
//		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		try {
			String username = session.getAttribute("username").toString();
			System.out.println("username for logged out " + username);
			session.removeAttribute("username");
			session.removeAttribute("fullname");
			session.removeAttribute("role");
			session.removeAttribute("logintype");
			session.removeAttribute("loginscope");
			LoginService.setactivestatus(username,"Logout");
			session.invalidate();
		} catch (Exception e) {
			System.err.println("exception in date convert:" + e);
		}

		return "/login";

	}

	@RequestMapping(value = { "/setnewPassword" }, method = RequestMethod.GET)
	public String SetNewPassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		return "SetNewPassword";
	}

	@RequestMapping(value = { "/checkUserandType" }, method = RequestMethod.POST)
	public String checkUserandType(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkUserandType Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);

			String final_response = LoginService.checkUserandType(name, usertype);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkUserandType GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/sendOtpToPhone" }, method = RequestMethod.POST)
	public String sendOtpToPhone(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside sendOtpToPhone Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String number = request.getParameter("number");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("number: " + number);

			String final_response = LoginService.sendOtpToPhone(name, usertype, number);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("sendOtpToPhone GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/checkOTP" }, method = RequestMethod.POST)
	public String checkOTP(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String number = request.getParameter("number");
			String otp = request.getParameter("otp");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("number: " + number);
			System.out.println("otp: " + otp);

			String final_response = LoginService.checkOTP(name, usertype, number, otp);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkOTP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/Setpassword" }, method = RequestMethod.POST)
	public String Setpassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String pass = request.getParameter("pass");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("pass: " + pass);

			String final_response = LoginService.Setpassword(name, usertype, pass);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkOTP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	
	@RequestMapping(value = "/getParticularImage", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage() throws IOException {
		
		String path=ApplicationPropertyReader.QR_Code_Path;
		System.out.println("QR COde path:-"+path);
		
		RandomAccessFile f = new RandomAccessFile(path, "r");
		byte[] b = new byte[(int) f.length()];
		f.readFully(b);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);

	}
	
	

	@RequestMapping(value = { "/verifyOTP" }, method = RequestMethod.POST)
	public void verifyOTP(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside verifyOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("username");
			String usertype = request.getParameter("usertype");
			String otp = request.getParameter("otp");
			String FULLNAME = request.getParameter("FULLNAME");
			String LOGIN_TYPE = request.getParameter("LOGIN_TYPE");
			String LOGIN_SCOPE = request.getParameter("LOGIN_SCOPE");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("OTP: " + otp);
			System.out.println("FULLNAME:-" + FULLNAME);

			String OTP_final_response = loginDao.verifyOTP(name, usertype, otp);

			System.out.println("verifyOTP reponse is = " + OTP_final_response);
			

			if (OTP_final_response!=null && OTP_final_response.equalsIgnoreCase("success")) {
				
				session.setAttribute("username", name);
				session.setAttribute("fullname", FULLNAME);
				session.setAttribute("role", usertype);
				session.setAttribute("logintype", LOGIN_TYPE);
				session.setAttribute("loginscope", LOGIN_SCOPE);
				System.out.println("usertype Before out.print:-" + usertype);
				out.print(usertype);

			
			} else if (OTP_final_response!=null && OTP_final_response.equalsIgnoreCase("fail")) {
				out.print(OTP_final_response);
			}

		} catch (Exception e) {
			System.out.println("Exception in verifyOTP Controller" + e);
			e.printStackTrace();
		}

		finally {
			if (out != null)
				out.close();
		}

	}
	
	
	
	
	
	
	@RequestMapping(value = { "/sendMail" }, method = RequestMethod.POST)
	public String sendMail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
		
			System.out.println("name: " + name);
			
			JSONArray final_response = LoginService.sendMail(name);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkOTP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	
	
	
	//29/08
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.GET)
	public String forgetPassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) 
	{
		return "/forgetPassword";
	}
	
	//
	
	
	//29/08
	@RequestMapping(value = { "/checkUserandTypeVelox" }, method = RequestMethod.POST)
	public String checkUserandTypeVelox(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkUserandTypeVelox Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");

			System.out.println("name: " + name);

			String final_response = LoginService.checkUserandTypeVelox(name);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkUserandTypeVelox GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	//
	
	
	
	//30/08
	@RequestMapping(value = { "/sendOtpToMailID" }, method = RequestMethod.POST)
	public String sendOtpToMailID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside sendOtpToMailID Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String mailId = request.getParameter("mailId");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("mailId: " + mailId);

			String final_response = LoginService.sendOtpToMailID(name, usertype, mailId);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("sendOtpToMailID GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	//
	
	
	
	
	//30/08
	@RequestMapping(value = { "/checkOTPMail" }, method = RequestMethod.POST)
	public String checkOTPMail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String number = request.getParameter("number");
			String otp = request.getParameter("otp");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("number: " + number);
			System.out.println("otp: " + otp);

			String final_response = LoginService.checkOTPMail(name, usertype, number, otp);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkOTP GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	//
	
	
	
	
	//30/08
	@RequestMapping(value = { "/SetpasswordNew" }, method = RequestMethod.POST)
	public String SetpasswordNew(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkOTP Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");
			String usertype = request.getParameter("usertype");
			String pass = request.getParameter("pass");

			System.out.println("name: " + name);
			System.out.println("usertype: " + usertype);
			System.out.println("pass: " + pass);

			String final_response = LoginService.SetpasswordNew(name, usertype, pass);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkOTP GET SUCCESS");

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
	@RequestMapping(value = { "/getRegisterMail" }, method = RequestMethod.POST)
	public String getRegisterMail(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside checkUserandTypeVelox Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name = request.getParameter("name");

			System.out.println("name: " + name);

			String final_response = LoginService.getRegisterMail(name);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("checkUserandTypeVelox GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	//
	
	
	
	//02/09
	@RequestMapping(value = { "/backToLogin" }, method = RequestMethod.GET)
	public String backToLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) 
	{
		return "login";
	}
	//
	
	
	//Integration
	@RequestMapping(value = { "/event" }, method = RequestMethod.POST)
    public ResponseEntity<String> receiveEvent(
            @RequestBody Map<String, Object> payload) {

		LoginService.saveAuditEvent(payload);

        return ResponseEntity.ok("Event received successfully");
    }
	//Integration

}
