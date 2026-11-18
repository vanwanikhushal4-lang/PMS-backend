package com.velox.itsm.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.service.EnggActivityService;

@Controller
@RequestMapping("/EnggActivity")
public class EnggActivityController {

	@Autowired
	EnggActivityService enggActivityService;

	@RequestMapping(value = { "/getAllEngDetails" }, method = RequestMethod.POST)
	public JSONArray getAllEngDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getAllEngDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;
		String LoginUser = null;
		try {
//            HttpSession session = request.getSession(true);
			LoginUser = session.getAttribute("username").toString();
			System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		details = LoginUser;

		try {
			out = response.getWriter();

			JSONArray final_response = enggActivityService.getAllEngDetails(details);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getAllUserDetails GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	
	
	@RequestMapping(value = { "/getEnggDashboardData" }, method = RequestMethod.POST)
	public JSONArray getEnggDashboardData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String chartdata = null;
			JSONArray final_response = enggActivityService.getEnggDashboardData(loginuser);

			System.out.println("getTPDashboardData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	

	@RequestMapping(value = { "/insertEngRaiseTicket" }, method = RequestMethod.POST)
	public String insertEngRaiseTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap) {
		System.out.println("Inside insertEngRaiseTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name1 = request.getParameter("name1");
			//String datepicker5 = request.getParameter("datepicker5");
			String phone = request.getParameter("phone");
			String emailid = request.getParameter("emailid");
			String compname = request.getParameter("compname");
			String site = request.getParameter("site");
			String category = request.getParameter("category");
			String subcat1 = request.getParameter("subcat1");
			String subcat2 = request.getParameter("subcat2");
			String requestmode = request.getParameter("requestmode");
			String department = request.getParameter("department");
			String subject = request.getParameter("sub");
			String description = request.getParameter("description");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String subDepartment = request.getParameter("subDepartment");
			String location = request.getParameter("location");
			
			 String assetTag = request.getParameter("atag");
		        String assetName = request.getParameter("aname");
		        String AssetCategory = request.getParameter("acategory");
		        String AssetStatus = request.getParameter("astatus");	
		        String assetcheckboc=request.getParameter("assetCheck");
//		        System.out.println("dgdggfdfg gff dhghgyhgdh"+assetcheckboc);

				
		        String asset_sub_category = request.getParameter("asset_sub_category");	
String asset_Ipaddress=request.getParameter("asset_Ipaddress");
				String AssetCheck="";
				try {
					if(assetcheckboc==null)
					{
						AssetCheck="false";
					}
					if (assetcheckboc.equals("on")) {
						AssetCheck = "true";
					}
//					System.out.println(" selected value is " + assetcheckboc);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			System.out.println("EMPIC FILE NAME: " + empPic.getOriginalFilename());
			System.out.println("EMPIC FILE SIZE: " + empPic.getSize());
			 String username = request.getParameter("username");
			 String vipuser = request.getParameter("vipuser");
			
			
			  Date date = null;
              date = new Date();

              String dateFormate = "dd-MM-yyyy HH:mm:ss";

              SimpleDateFormat sdf2 = null;

              sdf2 = new SimpleDateFormat(dateFormate);
              System.out.println("hiiiiii");
              String cdate = sdf2.format(date);
              System.out.println("cdate: " + cdate);
//              insertEngRaiseTicketOnBehalf
			String final_response = enggActivityService.insertEngRaiseTicket(name1, cdate, phone, emailid,
					compname, site, category, subcat1, requestmode, department, subject, description, priority, severity, empPic,subDepartment,location,subcat2,username,vipuser,assetName,AssetCategory,AssetStatus,AssetCheck,assetTag,  asset_sub_category ,  asset_Ipaddress);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("insertUserRaiseTicket GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	@RequestMapping(value = { "/getEngTicketID" }, method = RequestMethod.POST)
	public JSONArray getUserTicketID(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserTicketID Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
//		String details = null;

		try {
			out = response.getWriter();
			
			String details = request.getParameter("lastmonth");

			JSONArray final_response = enggActivityService.getEngTicketID(details);

			System.out.println("UserActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketID GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getEngTicketTracking" }, method = RequestMethod.POST)
	public JSONArray getEngTicketTracking(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngTicketTracking Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String ticketid =request.getParameter("ticketid");

			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = enggActivityService.getEngTicketTracking(ticketid);

			System.out.println("userActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketTracking GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}


	@RequestMapping(value = { "/getEngTicketTrackingMessage" }, method = RequestMethod.POST)
	public JSONArray getUserTicketTrackingMessage(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		System.out.println("Inside getEngTicketTrackingMessage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			int ticketid = Integer.parseInt(request.getParameter("ticketid"));

			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = enggActivityService.getEngTicketTrackingMessage(ticketid);

			System.out.println("userActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getEngTicketTrackingMessage GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getEngTicketList" }, method = RequestMethod.POST)
	public JSONArray getEngTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = enggActivityService.getEngTicketList();

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/gatherEngTicketDetails" }, method = RequestMethod.POST)
	public JSONArray gatherEngTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside gatherEngTicketDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String ticketid = request.getParameter("ticketid");

			System.out.println("ticketid is = " + ticketid);

			JSONArray final_response = enggActivityService.gatherEngTicketDetails(ticketid);

			System.out.println("EngActivityControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("gatherEngTicketDetails GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getResolvedEngTicketList" }, method = RequestMethod.POST)
	public JSONArray getResolvedEngTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResolvedEngTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = enggActivityService.getResolvedEngTicketList();

			System.out.println("getResolvedEngTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getResolvedEngTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

	@RequestMapping(value = { "/getClosedEngTicketList" }, method = RequestMethod.POST)
	public JSONArray getClosedEngTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getClosedEngTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = enggActivityService.getClosedEngTicketList();

			System.out.println("getClosedEngTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getClosedUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	@RequestMapping(value = { "/getClosedEngVIPTicketList" }, method = RequestMethod.POST)
	public JSONArray getClosedEngVIPTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getClosedEngVIPTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			JSONArray final_response = enggActivityService.getClosedEngVIPTicketList();

			System.out.println("getClosedEngVIPTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getClosedEngVIPTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

	@RequestMapping(value = { "/getEngAssignTickets" }, method = RequestMethod.POST)
	public JSONArray getEngAssignTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getEngAssignTickets(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/getEngAssignVIPTickets" }, method = RequestMethod.POST)
	public JSONArray getEngAssignVIPTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignVIPTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getEngAssignVIPTickets(LoginUser);

			System.out.println("getEngAssignVIPTickets reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getEngAssignVIPTickets SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}

//	@RequestMapping(value = { "/ViewEngAssignTicketsT" }, method = RequestMethod.POST)
//	public void ViewEngAssignTicketsT(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		System.out.println("Inside ViewEngAssignTicketsT Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String sname = null;
//		try {
//			out = response.getWriter();
//			String tid = request.getParameter("id");
//			String LoginUser = session.getAttribute("username").toString();
//			out.print(enggActivityService.ViewEngAssignTicketsT(tid, LoginUser));
//
//			System.out.println("getUserTicketList SUCCESS");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			out.close();
//		}
//
//	}

	@RequestMapping(value = { "/EditAssignTickets" }, method = RequestMethod.POST)
	public JSONArray EditAssignTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside EditAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String tid = request.getParameter("id");
			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response=enggActivityService.EditAssignTickets(tid, LoginUser);
			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/UpdateAssignTickets" }, method = RequestMethod.POST)
	public void UpdateAssignTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("resolvePic") MultipartFile resolvePic, ModelMap modelMap) {
		System.out.println("Inside EditAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String status = request.getParameter("status");
			System.out.println("status****" + status);
			String solution = request.getParameter("solution");
			System.out.println("solution****" + solution);
			
			String tid = request.getParameter("tid");
			System.out.println("tid****" + tid);
			String engname = request.getParameter("engname");
			System.out.println("engname****" + engname);
			String engcompany = request.getParameter("engcompany");
			System.out.println("engcompany****" + engcompany);
			String engsite = request.getParameter("engsite");
			System.out.println("engsite****" + engsite);
			String engemailid = request.getParameter("engemailid");
			System.out.println("engemailid****" + engemailid);
			String engphone = request.getParameter("engphone");
			System.out.println("engphone****" + engphone);
			
			String username = request.getParameter("username");
			System.out.println("username****" + username);
			String usercompany = request.getParameter("usercompany");
			System.out.println("usercompany****" + usercompany);
			String userbranch = request.getParameter("usersite");
			System.out.println("userbranch****" + userbranch);
			String useremail = request.getParameter("useremail");
			System.out.println("useremail****" + useremail);
			String userphone = request.getParameter("userphone");
			System.out.println("userphone****" + userphone);
			
			String tcname = request.getParameter("tcname");
			System.out.println("tcname****" + tcname);
			String tcemail = request.getParameter("tcemail");
			System.out.println("tcemail****" + tcemail);
			String tcphone = request.getParameter("tcphone");
			System.out.println("tcphone****" + tcphone);
			
			String raisedate = request.getParameter("raisedate");
			System.out.println("raisedate****" + raisedate);
			String assigndate = request.getParameter("assigndate");
			System.out.println("assigndate****" + assigndate);
			String priority = request.getParameter("priority");
			System.out.println("priority****" + priority);
			String severity = request.getParameter("severity");
			System.out.println("severity****" + severity);
			String sub = request.getParameter("subject");
			System.out.println("sub****" + sub);
			String description = request.getParameter("description");
			System.out.println("descrption****" + description);
			
			String category = request.getParameter("category");
			System.out.println("category****" + category);
			String subcat1 = request.getParameter("subcat1");
			System.out.println("subcat1****" + subcat1);
			String subcat2 = request.getParameter("subcat2");
			System.out.println("subcat2****" + subcat2);
			
			System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
	        
//			String LoginUser = session.getAttribute("username").toString();
			
			out.print(enggActivityService.UpdateAssignTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
					username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
					priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic));

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	@RequestMapping(value = { "/getReAssignedEngTickets" }, method = RequestMethod.POST)
	public JSONArray getReAssignedEngTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getReAssignedEngTickets(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

//	@RequestMapping(value = { "/EditReAssinedTicketsDetails" }, method = RequestMethod.POST)
//	public void EditReAssinedTicketsDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		System.out.println("Inside ViewEngAssignTicketsT Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String sname = null;
//		try {
//			out = response.getWriter();
//			String tid = request.getParameter("id");
//			String LoginUser = session.getAttribute("username").toString();
//			out.print(enggActivityService.EditReAssinedTicketsDetails(tid, LoginUser));
//
//			System.out.println("getUserTicketList SUCCESS");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			out.close();
//		}
//
//	}

	@RequestMapping(value = { "/UpdateReAssignEngTickets" }, method = RequestMethod.POST)
	public void UpdateReAssignEngTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("resolvePic") MultipartFile resolvePic, ModelMap modelMap) {
		System.out.println("Inside EditAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String status = request.getParameter("status");
			System.out.println("status****" + status);
			String solution = request.getParameter("solution");
			System.out.println("solution****" + solution);
			
			String tid = request.getParameter("tid");
			System.out.println("tid****" + tid);
			String engname = request.getParameter("engname");
			System.out.println("engname****" + engname);
			String engcompany = request.getParameter("engcompany");
			System.out.println("engcompany****" + engcompany);
			String engsite = request.getParameter("engsite");
			System.out.println("engsite****" + engsite);
			String engemailid = request.getParameter("engemailid");
			System.out.println("engemailid****" + engemailid);
			String engphone = request.getParameter("engphone");
			System.out.println("engphone****" + engphone);
			
			String username = request.getParameter("username");
			System.out.println("username****" + username);
			String usercompany = request.getParameter("usercompany");
			System.out.println("usercompany****" + usercompany);
			String userbranch = request.getParameter("usersite");
			System.out.println("userbranch****" + userbranch);
			String useremail = request.getParameter("useremail");
			System.out.println("useremail****" + useremail);
			String userphone = request.getParameter("userphone");
			System.out.println("userphone****" + userphone);
			
			String tcname = request.getParameter("tcname");
			System.out.println("tcname****" + tcname);
			String tcemail = request.getParameter("tcemail");
			System.out.println("tcemail****" + tcemail);
			String tcphone = request.getParameter("tcphone");
			System.out.println("tcphone****" + tcphone);
			
			String raisedate = request.getParameter("raisedate");
			System.out.println("raisedate****" + raisedate);
			String assigndate = request.getParameter("assigndate");
			System.out.println("assigndate****" + assigndate);
			String priority = request.getParameter("priority");
			System.out.println("priority****" + priority);
			String severity = request.getParameter("severity");
			System.out.println("severity****" + severity);
			String sub = request.getParameter("subject");
			System.out.println("sub****" + sub);
			String description = request.getParameter("description");
			System.out.println("descrption****" + description);
			
			String category = request.getParameter("category");
			System.out.println("category****" + category);
			String subcat1 = request.getParameter("subcat1");
			System.out.println("subcat1****" + subcat1);
			String subcat2 = request.getParameter("subcat2");
			System.out.println("subcat2****" + subcat2);
			
			System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
		
			out.print(enggActivityService.UpdateReAssignEngTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
					username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
					priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic));

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	@RequestMapping(value = { "/getResolvedTickets" }, method = RequestMethod.POST)
	public JSONArray getResolvedTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getResolvedTickets(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	@RequestMapping(value = { "/getResolvedVIPTickets" }, method = RequestMethod.POST)
	public JSONArray getResolvedVIPTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResolvedVIPTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getResolvedVIPTickets(LoginUser);

			System.out.println("getResolvedVIPTickets reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getResolvedVIPTickets SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}

//	@RequestMapping(value = { "/getClosedTickets" }, method = RequestMethod.POST)
//	public JSONArray getClosedTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String sname = null;
//
//		try {
//			out = response.getWriter();
//
//			String LoginUser = session.getAttribute("username").toString();
//			JSONArray final_response = enggActivityService.getClosedTickets(LoginUser);
//
//			System.out.println("getUserTicketList reponse is = " + final_response);
//
//			out.print(final_response);
//
//			System.out.println("getUserTicketList SUCCESS");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			out.close();
//		}
////		return "Dashboard";
//		return null;
//
//	}

	@RequestMapping(value = { "/getHoldTickets" }, method = RequestMethod.POST)
	public JSONArray getHoldTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			JSONArray final_response = enggActivityService.getHoldTickets();
			System.out.println("getUserTicketList reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}

//	@RequestMapping(value = { "/EditHoldTickets" }, method = RequestMethod.POST)
//	public JSONArray EditHoldTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
//			HttpSession session) {
//		System.out.println("Inside ViewEngAssignTicketsT Controller@@@@@@@@@@@@ ");
//		PrintWriter out = null;
//		String sname = null;
//		try {
//			out = response.getWriter();
//			String tid = request.getParameter("id");
//			String LoginUser = session.getAttribute("username").toString();
//			
//			JSONArray final_response =enggActivityService.EditHoldTickets(tid, LoginUser);
//
//			System.out.println("getUserTicketList SUCCESS");
//			out.print(final_response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			out.close();
//		}
//		return null;
//	}

	@RequestMapping(value = { "/UpdateHoldTickets" }, method = RequestMethod.POST)
	public void UpdateHoldTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("holdPic") MultipartFile holdPic, ModelMap modelMap) {
		
		System.out.println("Inside UpdateHoldTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String status = request.getParameter("status");
			System.out.println("status****" + status);
			String solution = request.getParameter("solution");
			System.out.println("solution****" + solution);
			
			String tid = request.getParameter("tid");
			System.out.println("tid****" + tid);
			String engname = request.getParameter("engname");
			System.out.println("engname****" + engname);
			String engcompany = request.getParameter("engcompany");
			System.out.println("engcompany****" + engcompany);
			String engsite = request.getParameter("engsite");
			System.out.println("engsite****" + engsite);
			String engemailid = request.getParameter("engemailid");
			System.out.println("engemailid****" + engemailid);
			String engphone = request.getParameter("engphone");
			System.out.println("engphone****" + engphone);
			
			String username = request.getParameter("username");
			System.out.println("username****" + username);
			String usercompany = request.getParameter("usercompany");
			System.out.println("usercompany****" + usercompany);
			String userbranch = request.getParameter("usersite");
			System.out.println("userbranch****" + userbranch);
			String useremail = request.getParameter("useremail");
			System.out.println("useremail****" + useremail);
			String userphone = request.getParameter("userphone");
			System.out.println("userphone****" + userphone);
			
			String tcname = request.getParameter("tcname");
			System.out.println("tcname****" + tcname);
			String tcemail = request.getParameter("tcemail");
			System.out.println("tcemail****" + tcemail);
			String tcphone = request.getParameter("tcphone");
			System.out.println("tcphone****" + tcphone);
			
			String raisedate = request.getParameter("raisedate");
			System.out.println("raisedate****" + raisedate);
			String assigndate = request.getParameter("assigndate");
			System.out.println("assigndate****" + assigndate);
			String priority = request.getParameter("priority");
			System.out.println("priority****" + priority);
			String severity = request.getParameter("severity");
			System.out.println("severity****" + severity);
			String sub = request.getParameter("subject");
			System.out.println("sub****" + sub);
			String description = request.getParameter("description");
			System.out.println("descrption****" + description);
			
			String category = request.getParameter("category");
			System.out.println("category****" + category);
			String subcat1 = request.getParameter("subcat1");
			System.out.println("subcat1****" + subcat1);
			String subcat2 = request.getParameter("subcat2");
			System.out.println("subcat2****" + subcat2);
			
			System.out.println("EMPIC FILE NAME: "+holdPic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+holdPic.getSize());
			
			out.print(enggActivityService.UpdateHoldTickets(tid, status, engname, engcompany, engsite, engemailid, engphone,
					username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
					priority, severity, sub, description, category, subcat1, subcat2, solution, holdPic));

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	@RequestMapping(value = { "/Passwordreset" }, method = RequestMethod.POST)
	public void Passwordreset(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside ViewEngAssignTicketsT Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			System.out.println("inside passwordreset method***");
			String user = request.getParameter("user");
			String oldpass = request.getParameter("oldpass");
			String newpass = request.getParameter("newpass");
			String confpass = request.getParameter("cnfnewpass");
			out.print(enggActivityService.Passwordreset(user, oldpass, newpass, confpass));

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}
	
	/////////////////// FOR PROBLEM MANAGEMENT ///////////
	@RequestMapping(value = { "/getEngAssignProblemTickets" }, method = RequestMethod.POST)
	public JSONArray getEngAssignProblemTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignProblemTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getEngAssignProblemTickets(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/gatherProblemTicketDetails" }, method = RequestMethod.POST)
	public JSONArray gatherProblemTicketDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside gatherProblemTicketDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String ticketid = request. getParameter("ticketid");
				
			System.out.println("ticketid is = " + ticketid);
			JSONArray final_response = enggActivityService.gatherProblemTicketDetails(ticketid);
			System.out.println("ENGGActivityControllerrrr reponse is = " + final_response);
				out.print(final_response);
				System.out.println("gatherProblemTicketDetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/UpdateRCAProblemTicket" }, method = RequestMethod.POST)
	public void UpdateRCAProblemTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestParam("RCAFilePic") MultipartFile RCAFilePic,
			ModelMap modelMap) {
		
		System.out.println("Inside UpdateRCAProblemTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String tid = request.getParameter("tidRCA");
			System.out.println("tid****" + tid);
//			String assignedToEngg = request.getParameter("assignedToRCA");
//			System.out.println("assignedToEngg****" + assignedToEngg);
			String causeNotes = request.getParameter("causenotesRCA");
			System.out.println("solution****" + causeNotes);
			
			System.out.println("RCAFilePic FILE NAME: "+RCAFilePic.getOriginalFilename());
	        System.out.println("RCAFilePic FILE SIZE: "+RCAFilePic.getSize());
				        
			String LoginUser = session.getAttribute("username").toString();
			System.out.println("Logged in User****" + LoginUser);
//			if(assignedToEngg.equals(LoginUser)) {
//				System.out.println("user matched");
				out.print(enggActivityService.UpdateRCAProblemTicket(tid, causeNotes, RCAFilePic));
				System.out.println("UpdateRCAProblemTicket SUCCESS");
//			}else {
//				out.print("failed");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestMapping(value = { "/getEngRCAProblemTickets" }, method = RequestMethod.POST)
	public JSONArray getEngRCAProblemTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngRCAProblemTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getEngRCAProblemTickets(LoginUser);

			System.out.println("getEngRCAProblemTickets reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getEngRCAProblemTickets SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/UpdateFixProblemTicket" }, method = RequestMethod.POST)
	public void UpdateFixProblemTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestParam("FixFilePic") MultipartFile FixFilePic,
			ModelMap modelMap) {
		
		System.out.println("Inside UpdateFixProblemTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String tid = request.getParameter("tidRCA");
			System.out.println("tid****" + tid);
			String causeNotes = request.getParameter("causenotesRCA");
			System.out.println("causeNotes****" + causeNotes);
			String fixNotes = request.getParameter("fixnotesRCA");
			System.out.println("fixNotes****" + fixNotes);
			String workaroundNotes = request.getParameter("workaroundnotesRCA");
			System.out.println("fixNotes****" + workaroundNotes);
			
			System.out.println("FixFilePic FILE NAME: "+FixFilePic.getOriginalFilename());
	        System.out.println("FixFilePic FILE SIZE: "+FixFilePic.getSize());
				        
			String LoginUser = session.getAttribute("username").toString();
			System.out.println("Logged in User****" + LoginUser);

				out.print(enggActivityService.UpdateFixProblemTicket(tid, causeNotes, fixNotes, workaroundNotes, FixFilePic));
				System.out.println("UpdateFixProblemTicket SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestMapping(value = { "/getEngFixInProcessProblemTickets" }, method = RequestMethod.POST)
	public JSONArray getEngFixInProcessProblemTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngFixInProcessProblemTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getEngFixInProcessProblemTickets(LoginUser);

			System.out.println("getEngFixInProcessProblemTickets reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getEngFixInProcessProblemTickets SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	@RequestMapping(value = { "/UpdateResolveProblemTicket" }, method = RequestMethod.POST)
	public void UpdateResolveProblemTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session,
			@RequestParam("ResolveFilePic") MultipartFile ResolveFilePic,
			ModelMap modelMap) {
		
		System.out.println("Inside UpdateResolveProblemTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String tid = request.getParameter("tidRCA");
			System.out.println("tid****" + tid);
			String causeNotes = request.getParameter("causenotesRCA");
			System.out.println("causeNotes****" + causeNotes);
			String fixNotes = request.getParameter("fixnotesRCA");
			System.out.println("fixNotes****" + fixNotes);
			String workaroundNotes = request.getParameter("workaroundnotesRCA");
			System.out.println("fixNotes****" + workaroundNotes);
			String resolveNotes = request.getParameter("resolvenotesRCA");
			System.out.println("resolveNotes****" + resolveNotes);
			
			System.out.println("ResolveFilePic FILE NAME: "+ResolveFilePic.getOriginalFilename());
	        System.out.println("ResolveFilePic FILE SIZE: "+ResolveFilePic.getSize());
				        
			String LoginUser = session.getAttribute("username").toString();
			System.out.println("Logged in User****" + LoginUser);
		
				out.print(enggActivityService.UpdateResolveProblemTicket(tid, causeNotes, fixNotes, workaroundNotes, resolveNotes, ResolveFilePic));
				System.out.println("UpdateResolveProblemTicket SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestMapping(value = { "/getAllProblemTicketListEng" }, method = RequestMethod.POST)
	public JSONArray getAllProblemTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getAllProblemTicketListEng Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String ticketList = null;
			JSONArray final_response = enggActivityService.getAllProblemTicketListEng(ticketList);

			System.out.println("getAllProblemTicketListEng reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getAllProblemTicketListEng SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		return null;
	}

	@RequestMapping(value = { "/CheckENGTicketUpdateConflict" }, method = RequestMethod.POST)
	public JSONArray CheckENGTicketUpdateConflict(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("Inside CheckENGTicketUpdateConflict Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			String ticketid = request.getParameter("ticketid");
			String currentstaus = request.getParameter("CurrentStatus");
			
			String currentatassignto = request.getParameter("currentatassignto");
			String Crrentselecengg=request.getParameter("Crrentselecengg");
				String currentselectgrp=request.getParameter("currentselectgrp");
			String priviousetpnaame = request.getParameter("priviousetpnaame");
			String priviouseemail = request.getParameter("priviouseemail");
			System.out.println("ticketid****" + ticketid);
			
			out.print(enggActivityService.CheckENGTicketUpdateConflict(ticketid,currentstaus,priviousetpnaame,priviouseemail ,currentselectgrp,Crrentselecengg,currentatassignto));

			System.out.println("CheckENGTicketUpdateConflict SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
return null;
	}
	
	
	//---vip pages---
	
	
	@RequestMapping(value = { "/getVIPReAssignedEngTickets" }, method = RequestMethod.POST)
	public JSONArray getVIPReAssignedEngTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getVIPReAssignedEngTickets(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	
	
	
	@RequestMapping(value = { "/getVIPHoldTickets" }, method = RequestMethod.POST)
	public JSONArray getVIPHoldTickets(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAssignTickets Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			JSONArray final_response = enggActivityService.getVIPHoldTickets();
			System.out.println("getUserTicketList reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	
	@RequestMapping(value = { "/CheckProblemUpdateConflict" }, method = RequestMethod.POST)
	public JSONArray CheckProblemUpdateConflict(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("Inside CheckProblemUpdateConflict Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			String ticketid = request.getParameter("ticketid");
			String statusChange = request.getParameter("statusChange");
			System.out.println("ticketid****" + ticketid);
			System.out.println("statusChange****" + statusChange);
			
			out.print(enggActivityService.CheckProblemUpdateConflict(ticketid,statusChange));

			System.out.println("CheckProblemUpdateConflict SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
return null;
	}
	
	
	@RequestMapping(value = { "/getenggAssingRequest" }, method = RequestMethod.POST)
	public JSONArray getenggAssingRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getenggAssingRequest Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getenggAssingRequest(LoginUser);

			System.out.println("getenggAssingRequest reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getenggAssingRequest SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	
	
	@RequestMapping(value = { "/EditAssignRequest" }, method = RequestMethod.POST)
	public JSONArray EditAssignRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside EditAssignRequest Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			String tid = request.getParameter("id");
			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response=enggActivityService.EditAssignRequest(tid, LoginUser);
			out.print(final_response);

			System.out.println("EditAssignRequest SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
	
	
	
	
	@RequestMapping(value = { "/UpdateAssignRequests" }, method = RequestMethod.POST)
	public JSONArray UpdateAssignRequests(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam("resolvePic") MultipartFile resolvePic) {
		System.out.println("Inside UpdateAssignREquests Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		
		
			String engname = request.getParameter("engname");
			String engcompany=request.getParameter("engcompany");	
			String engsite = request.getParameter("engsite");
			String engdepartment=request.getParameter("engdepartment");
			String subdepartmentengg=request.getParameter("subdepartmentengg");
			String locationtpengg=request.getParameter("locationtpengg");	
			String engemailid = request.getParameter("engemailid");
			String engphone = request.getParameter("engphone");
	
			String username = request.getParameter("username");
			String usercompany = request.getParameter("usercompany");
			String userbranch = request.getParameter("usersite");
			String userdepartment=request.getParameter("userdepartment");
			String subdepartmentrequester=request.getParameter("subdepartmentrequester");
			String locationrequester=request.getParameter("locationrequester");
			String useremail = request.getParameter("useremail");
			String userphone = request.getParameter("userphone");
			String otheremail = request.getParameter("otheremail");
			
			
			String tcname = request.getParameter("tcname");	
			
			String tccompany=request.getParameter("tccompany");
			String tcsite=request.getParameter("tcsite");
			String tcdepartment=request.getParameter("tcdepartment");
			String subdepartmenttp=request.getParameter("subdepartmenttp");
			String locationtp=request.getParameter("locationtp");
			String tcemail = request.getParameter("tcemail");
			String tcphone = request.getParameter("tcphone");
			
			String tid = request.getParameter("tid1");
			String raisedate = request.getParameter("raisedate");
			String assigndate = request.getParameter("assigndate");
			String category = request.getParameter("category");
			String subcat1 = request.getParameter("subcat1");
			String subcat2 = request.getParameter("subcat2");
			String ticketstatus=request.getParameter("ticketstatus");		
			String priority = request.getParameter("priority");
			String severity=request.getParameter("severity");
			String sub = request.getParameter("subject");
			String requestmode=request.getParameter("requestmode");
			String description = request.getParameter("description");
			
		
			
			
			System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
			
			String ticketid = request.getParameter("tid1");
			System.out.println("ticketid****" + ticketid);
			String status = request.getParameter("status");	
			String solution = request.getParameter("solution");
			
			String assignTo=request.getParameter("assignTo");
			String enggcat=request.getParameter("enggcat");
			String enggassign=request.getParameter("enggassign");
			String engGroup=request.getParameter("engGroup");
		
			
			

//			String engcompany=request.getParameter("engcompany");	

//			String engdepartment=request.getParameter("engdepartment");
//			String subdepartmentengg=request.getParameter("subdepartmentengg");
//			String locationtpengg=request.getParameter("locationtpengg");	
			
			out.print(enggActivityService.UpdateAssignRequests(tid, status, engname, engsite, engemailid, engphone,
					username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
					priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,userdepartment,otheremail));

			System.out.println("UpdateAssignRequests SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
return null;
	}
	
	
	@RequestMapping(value = { "/getResolveRequest2" }, method = RequestMethod.POST)
	public JSONArray getResolvedRequest2(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResolvedRequest2 Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			JSONArray final_response = enggActivityService.getResolveRequest2(LoginUser);

			System.out.println("getUserTicketList reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getUserTicketList SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;

	}
	
	
	
	
	@RequestMapping(value = { "/insertchangeps" }, method = RequestMethod.POST)
	public String insertchangeps(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, ModelMap modelMap) {
		System.out.println("Inside insertchangeps Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			
			
			
			String newpriority = request.getParameter("newpriority");
			//String datepicker5 = request.getParameter("datepicker5");
			String newseverity = request.getParameter("newseverity");
			String changenote = request.getParameter("changenote");
			String oldpriority = request.getParameter("oldpriority");
			String oldseverity = request.getParameter("oldseverity");
			String subject = request.getParameter("subject");
			String ticketId = request.getParameter("ticketId");
			String ticketstatus = request.getParameter("ticketstatus");
			String engname = request.getParameter("engname");
			String engcompany = request.getParameter("engcompany");
			String t_branch = request.getParameter("usersite");
			String t_department = request.getParameter("userdepartment");
			String t_company = request.getParameter("tccompany");
			String category = request.getParameter("category");
			String subcat1 = request.getParameter("subcat1");
			String subcat2 = request.getParameter("subcat2");
			
			String usercompany = request.getParameter("usercompany");
			String username = request.getParameter("username");
			String description = request.getParameter("description");
			
			
		   
			
			
			
			System.out.println("newpriority: " + newpriority);
			System.out.println("newseverity: " + newseverity);
			System.out.println("changenote: " + changenote);
			
			System.out.println("oldpriority: " + oldpriority);
			System.out.println("newseverity: " + newseverity);
			System.out.println("oldseverity: " + oldseverity);
			System.out.println("subject: " + subject);
			System.out.println("ticketId: " + ticketId);
			System.out.println("ticketstatus: " + ticketstatus);
			System.out.println("engname: " + engname);
			System.out.println("engcompany: " + engcompany);
			System.out.println("t_branch " + t_branch);
			System.out.println("subject:" + subject);
			System.out.println("t_department: " + t_department);
			System.out.println("t_company: " + t_company);
		
		
			 
			
			
			String final_response = enggActivityService.insertchangeps(newseverity, changenote, oldpriority, oldseverity,
					newpriority, ticketId, ticketstatus, engname, engcompany, t_branch, subject, t_department,t_company,category,subcat1,subcat2,usercompany,username,description);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("insertUserRaiseTicket GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

	
	
	
	@RequestMapping(value = { "/insertraisecrf" }, method = RequestMethod.POST)
	public String insertraisecrf(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, ModelMap modelMap) {
		System.out.println("Inside insertraisecrf Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			
			String tid2 = request.getParameter("tid2");
			//String datepicker5 = request.getParameter("datepicker5");
			String company2 = request.getParameter("company2");
			String branch2 = request.getParameter("branch2");
			String department2 = request.getParameter("department2");
			String sub2 = request.getParameter("sub2");
			String des2 = request.getParameter("des2");
			String priority = request.getParameter("priority");
			String engnote21 = request.getParameter("engnote21");
			String severity = request.getParameter("severity");
		
			
			
			String final_response = enggActivityService.insertraisecrf(tid2,company2,branch2,department2,sub2,des2,engnote21,severity,priority);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("insertraisecrf GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	@RequestMapping(value = { "/getEnggProblemTicket" }, method = RequestMethod.POST)
	public JSONArray getEnggProblemTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String chartdata = null;
			JSONArray final_response = enggActivityService.getEnggProblemTicket(loginuser);

			System.out.println("getTPDashboardData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	
	
	@RequestMapping(value = { "/getAllIncidentTicketList" }, method = RequestMethod.POST)
	public JSONArray getAllIncidentTicketList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String status=request.getParameter("status");
			System.out.println("dfdfdfdfddf"+status);
			String chartdata = null;
			JSONArray final_response = enggActivityService.getAllIncidentTicketList(loginuser,status);

			System.out.println("getTPDashboardData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	
	@RequestMapping(value = { "/getAllProblemTicketListDashboard" }, method = RequestMethod.POST)
	public JSONArray getAllProblemTicketListDashboard(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getAllProblemTicketList Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String status=request.getParameter("status");
			System.out.println("statusdfgfsdgs"+status);
			String chartdata = null;
			JSONArray final_response = enggActivityService.getAllProblemTicketListDashboard(loginuser,status);

			System.out.println("getAllProblemTicketListDashboard reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	@RequestMapping(value = { "/getServiceRequestDashboardData" }, method = RequestMethod.POST)
	public JSONArray getServiceRequestDashboardData(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
			String loginuser=(String)session.getAttribute("username");
			String chartdata = null;
			JSONArray final_response = enggActivityService.getServiceRequestDashboardData(loginuser);

			System.out.println("getServiceRequestDashboardData reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	@RequestMapping(value = { "/getAllServiceRequestDashboard" }, method = RequestMethod.POST)
	public JSONArray getAllServiceRequestDashboard(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getAllServiceRequestDashboard Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;

		try {
			out = response.getWriter();
		///	String loginuser=(String)session.getAttribute("username");
			String status=request.getParameter("status");
			System.out.println("stats12"+status);
			String chartdata = null;
			JSONArray final_response = enggActivityService.getAllServiceRequestDashboard(status);

			System.out.println("getAllServiceRequestDashboard reponse is = " + final_response);

			out.print(final_response);

			System.out.println("getTPDashboardData SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}


	
	@RequestMapping(value = { "/insertEngRaiseTicketOnBehalf" }, method = RequestMethod.POST)
	public String insertEngRaiseTicketOnBehalf(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("empPic") MultipartFile empPic, ModelMap modelMap) {
		System.out.println("Inside insertEngRaiseTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String details = null;

		try {
			out = response.getWriter();

			String name1 = request.getParameter("otherfullname");
			//String datepicker5 = request.getParameter("datepicker5");
			String phone = request.getParameter("otherphone");
			String emailid = request.getParameter("otheremail");
			String compname = request.getParameter("othercompname");
			String site = request.getParameter("othersite");
			String category = request.getParameter("category");
			String subcat1 = request.getParameter("subcat1");
			String subcat2 = request.getParameter("subcat2");
			String requestmode = request.getParameter("requestmode");
			String department = request.getParameter("otherdepart");
			String subject = request.getParameter("sub");
			String description = request.getParameter("description");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String subDepartment = request.getParameter("othersubdepart");
			String location = request.getParameter("otherlocation");
			String t_requester = request.getParameter("otherusername");

			 String assetTag = request.getParameter("atag");
		        String assetName = request.getParameter("aname");
		        String AssetCategory = request.getParameter("acategory");
		        String AssetStatus = request.getParameter("astatus");	
		        String assetcheckboc=request.getParameter("assetCheck");
				
		        String asset_sub_category = request.getParameter("asset_sub_category");	
String asset_Ipaddress=request.getParameter("asset_Ipaddress");
//		        System.out.println("dgdggfdfg gff dhghgyhgdh"+assetcheckboc);
				String AssetCheck="";
				try {
					if(assetcheckboc==null)
					{
						AssetCheck="false";
					}
					if (assetcheckboc.equals("on")) {
						AssetCheck = "true";
					}
//					System.out.println(" selected value is " + assetcheckboc);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			
	    	
			System.out.println("name: " + name1);
			System.out.println("subDepartment: " + subDepartment);
			System.out.println("location: " + location);
			
			System.out.println("phone: " + phone);
			System.out.println("emailid: " + emailid);
			System.out.println("compname: " + compname);
			System.out.println("site: " + site);
			System.out.println("category: " + category);
			System.out.println("subcat1: " + subcat1);
			System.out.println("subcat2: " + subcat2);
			System.out.println("requestmode: " + requestmode);
			System.out.println("department " + department);
			System.out.println("subject:" + subject);
			System.out.println("description: " + description);
			System.out.println("priority:" + priority);
			System.out.println("severity:" + severity);
			System.out.println("EMPIC FILE NAME: " + empPic.getOriginalFilename());
			System.out.println("EMPIC FILE SIZE: " + empPic.getSize());
			 String usernameofraisedby = request.getParameter("username");
			 String vipuser = request.getParameter("vipuserother");
			
			
			  Date date = null;
              date = new Date();

              String dateFormate = "dd-MM-yyyy HH:mm:ss";

              SimpleDateFormat sdf2 = null;

              sdf2 = new SimpleDateFormat(dateFormate);
              System.out.println("hiiiiii");
              String cdate = sdf2.format(date);
              System.out.println("cdate: " + cdate);
			
			String final_response = enggActivityService.insertEngRaiseTicketOnBehalf(name1, cdate, phone, emailid,
					compname, site, category, subcat1, requestmode, department, subject, description, priority, severity, empPic,subDepartment,location,subcat2,usernameofraisedby,vipuser,t_requester,assetName,AssetCategory,AssetStatus,AssetCheck,assetTag,	  asset_sub_category ,  asset_Ipaddress);

			System.out.println("MastersControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("insertEngRaiseTicketOnBehalf GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}
	

	
	

	@RequestMapping(value = { "/getEngAllWorkinProgressticketgernal" }, method = RequestMethod.POST)
	public JSONArray getEngAllWorkinProgressticketgernal(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEngAllWorkinProgressticketgernal Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String LoginUser = session.getAttribute("username").toString();
			String tickettype =request.getParameter("tickettype");
			System.out.println("Ticket TYPE   "+ tickettype);
			JSONArray final_response = enggActivityService.getEngAllWorkinProgressticketgernal(LoginUser,tickettype);

			System.out.println("getEngAllWorkinProgressticketgernal reponse is = " + final_response);
			out.print(final_response);
			System.out.println("getEngAllWorkinProgressticketgernal SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
		return null;
	}
	

	@RequestMapping(value = { "/UpdateAllWorkInProgressTicket" }, method = RequestMethod.POST)
	public void UpdateAllWorkInProgressTicket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("resolvePic") MultipartFile resolvePic, ModelMap modelMap) {
		System.out.println("Inside UpdateAllWorkInProgressTicket Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
		try {
			out = response.getWriter();
			
			String status = request.getParameter("status");
			System.out.println("status****" + status);
			String solution = request.getParameter("solution");
			System.out.println("solution****" + solution);
			
			String tid = request.getParameter("tid");
			System.out.println("tid****" + tid);
			String engname = request.getParameter("engname");
			System.out.println("engname****" + engname);
			String engcompany = request.getParameter("engcompany");
			System.out.println("engcompany****" + engcompany);
			String engsite = request.getParameter("engsite");
			System.out.println("engsite****" + engsite);
			String engemailid = request.getParameter("engemailid");
			System.out.println("engemailid****" + engemailid);
			String engphone = request.getParameter("engphone");
			System.out.println("engphone****" + engphone);
			
			String username = request.getParameter("username");
			System.out.println("username****" + username);
			String usercompany = request.getParameter("usercompany");
			System.out.println("usercompany****" + usercompany);
			String userbranch = request.getParameter("usersite");
			System.out.println("userbranch****" + userbranch);
			String useremail = request.getParameter("useremail");
			System.out.println("useremail****" + useremail);
			String userphone = request.getParameter("userphone");
			System.out.println("userphone****" + userphone);
			
			String tcname = request.getParameter("tcname");
			System.out.println("tcname****" + tcname);
			String tcemail = request.getParameter("tcemail");
			System.out.println("tcemail****" + tcemail);
			String tcphone = request.getParameter("tcphone");
			System.out.println("tcphone****" + tcphone);
			
			String raisedate = request.getParameter("raisedate");
			System.out.println("raisedate****" + raisedate);
			String assigndate = request.getParameter("assigndate");
			System.out.println("assigndate****" + assigndate);
			String priority = request.getParameter("priority");
			System.out.println("priority****" + priority);
			String severity = request.getParameter("severity");
			System.out.println("severity****" + severity);
			String sub = request.getParameter("subject");
			System.out.println("sub****" + sub);
			String description = request.getParameter("description");
			System.out.println("descrption****" + description);
			
			String category = request.getParameter("category");
			System.out.println("category****" + category);
			String subcat1 = request.getParameter("subcat1");
			System.out.println("subcat1****" + subcat1);
			String subcat2 = request.getParameter("subcat2");
			System.out.println("subcat2****" + subcat2);
			String assignTo = request.getParameter("assignTo");
			String enggcat = request.getParameter("enggcat");
			String enggassign = request.getParameter("enggassign");
			String engGroup = request.getParameter("engGroup");
			String userdepartment = request.getParameter("userdepartment");
			String assignedEnggemail = request.getParameter("otheremail");
			
			System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
	        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
	        
//			String LoginUser = session.getAttribute("username").toString();
			
			out.print(enggActivityService.UpdateAllWorkInProgressTicket(tid, status, engname, engcompany, engsite, engemailid, engphone,
					username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
					priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic,assignTo,enggcat,enggassign,engGroup,userdepartment,assignedEnggemail));

			System.out.println("getUserTicketList SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}




@RequestMapping(value = { "/UpdateAssignedHoldandReassignticket" }, method = RequestMethod.POST)
public void UpdateAssignedHoldandReassignticket(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session, @RequestParam("resolvePic") MultipartFile resolvePic, ModelMap modelMap) {
	System.out.println("Inside UpdateAssignedHoldandReassignticket Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;
	try {
		out = response.getWriter();
//		engemailid
		String status = request.getParameter("status");
		System.out.println("status****" + status);
		String solution = request.getParameter("solution");
		System.out.println("solution****" + solution);
		
		String tid = request.getParameter("tid");
		System.out.println("tid****" + tid);
		String engname = request.getParameter("engname");
		System.out.println("engname****" + engname);
		String engcompany = request.getParameter("engcompany");
		System.out.println("engcompany****" + engcompany);
		String engsite = request.getParameter("engsite");
		System.out.println("engsite****" + engsite);
		String engemailid = request.getParameter("engemailid");
		System.out.println("engemailid****" + engemailid);
		String engphone = request.getParameter("engphone");
		System.out.println("engphone****" + engphone);
		
		String username = request.getParameter("username");
		System.out.println("username****" + username);
		String usercompany = request.getParameter("usercompany");
		System.out.println("usercompany****" + usercompany);
		String userbranch = request.getParameter("usersite");
		System.out.println("userbranch****" + userbranch);
		String useremail = request.getParameter("useremail");
		System.out.println("useremail****" + useremail);
		String userphone = request.getParameter("userphone");
		System.out.println("userphone****" + userphone);
		
		String tcname = request.getParameter("tcname");
		System.out.println("tcname****" + tcname);
		String tcemail = request.getParameter("tcemail");
		System.out.println("tcemail****" + tcemail);
		String tcphone = request.getParameter("tcphone");
		System.out.println("tcphone****" + tcphone);
		
		String raisedate = request.getParameter("raisedate");
		System.out.println("raisedate****" + raisedate);
		String assigndate = request.getParameter("assigndate");
		System.out.println("assigndate****" + assigndate);
		String priority = request.getParameter("priority");
		System.out.println("priority****" + priority);
		String severity = request.getParameter("severity");
		System.out.println("severity****" + severity);
		String sub = request.getParameter("subject");
		System.out.println("sub****" + sub);
		String description = request.getParameter("description");
		System.out.println("descrption****" + description);
		
		String category = request.getParameter("category");
		System.out.println("category****" + category);
		String subcat1 = request.getParameter("subcat1");
		System.out.println("subcat1****" + subcat1);
		String subcat2 = request.getParameter("subcat2");
		System.out.println("subcat2****" + subcat2);
		String assignTo = request.getParameter("assignTo");
		String enggcat = request.getParameter("enggcat");
		String enggassign = request.getParameter("enggassign");
		String engGroup = request.getParameter("engGroup");
		String userdepartment = request.getParameter("userdepartment");
		String engemail = request.getParameter("otheremail");
		
		System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
        
//		String LoginUser = session.getAttribute("username").toString();
		
		out.print(enggActivityService.UpdateAssignedHoldandReassignticket(tid, status, engname, engcompany, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, severity, sub, description, category, subcat1, subcat2, solution, resolvePic,assignTo,enggcat,enggassign,engGroup,userdepartment,engemail));

		System.out.println("UpdateAssignedHoldandReassignticket SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}

}


@RequestMapping(value = { "/CheckENGTicketUpdateConflictforReassign" }, method = RequestMethod.POST)
public JSONArray CheckENGTicketUpdateConflictforReassign(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	System.out.println("Inside CheckENGTicketUpdateConflict Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String ticketid = request.getParameter("ticketid");
		String currentstaus = request.getParameter("CurrentStatus");
	String priviousetpnaame=request.getParameter("priviousetpnaame");
		String priviouseemail=request.getParameter("priviouseemail");
		String currentatassignto = request.getParameter("currentatassignto");
		String Crrentselecengg=request.getParameter("Crrentselecengg");
			String currentselectgrp=request.getParameter("currentselectgrp");
		
	     
		System.out.println("ticketid****" + ticketid);
		
		out.print(enggActivityService.CheckENGTicketUpdateConflictforReassign(ticketid,currentstaus,priviousetpnaame,priviouseemail,currentatassignto,currentselectgrp,Crrentselecengg));

		System.out.println("CheckENGTicketUpdateConflictforReassign SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}
@RequestMapping(value = { "/CheckENGConflictAfterWorInProgress" }, method = RequestMethod.POST)
public JSONArray CheckENGConflictAfterWorInProgress(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	System.out.println("Inside CheckENGTicketUpdateConflict Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String ticketid = request.getParameter("ticketid");
		String CurrentStatus=request.getParameter("CurrentStatus");
		String priviousetpnaame=request.getParameter("priviousetpnaame");
		String priviouseemail=request.getParameter("priviouseemail");
		String currentatassignto = request.getParameter("currentatassignto");
		String Crrentselecengg=request.getParameter("Crrentselecengg");
		String currentselectgrp=request.getParameter("currentselectgrp");
		System.out.println("current assign to   is" + currentatassignto);
		System.out.println("ticketid****" + ticketid+"Status*******"+CurrentStatus);
		out.print(enggActivityService.CheckENGConflictAfterWorInProgress(ticketid,CurrentStatus,priviousetpnaame,priviouseemail,currentatassignto,currentselectgrp,Crrentselecengg));

		System.out.println("CheckENGTicketUpdateConflict SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}
@RequestMapping(value = { "/CheckENGServiceRRequestUpdateConflict" }, method = RequestMethod.POST)
public JSONArray CheckENGServiceRRequestUpdateConflict(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	System.out.println("Inside CheckENGServiceRRequestUpdateConflict Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String ticketid = request.getParameter("ticketid");
		String currentstaus = request.getParameter("CurrentStatus");
		
		String currentatassignto = request.getParameter("currentatassignto");
		String Crrentselecengg=request.getParameter("Crrentselecengg");
			String currentselectgrp=request.getParameter("currentselectgrp");
		String priviousetpnaame = request.getParameter("priviousetpnaame");
		String priviouseemail = request.getParameter("priviouseemail");
		System.out.println("ticketid****" + ticketid);
		
		out.print(enggActivityService.CheckENGServiceRRequestUpdateConflict(ticketid,currentstaus,priviousetpnaame,priviouseemail ,currentselectgrp,Crrentselecengg,currentatassignto));

		System.out.println("CheckENGTicketUpdateConflict  Service request SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}

@RequestMapping(value = { "/CheckENGConflictAfterWorInProgressServiceRequest" }, method = RequestMethod.POST)
public JSONArray CheckENGConflictAfterWorInProgressServiceRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	System.out.println("Inside CheckENGTicketUpdateConflict Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String ticketid = request.getParameter("ticketid");
		String CurrentStatus=request.getParameter("CurrentStatus");
		String priviousetpnaame=request.getParameter("priviousetpnaame");
		String priviouseemail=request.getParameter("priviouseemail");
		String currentatassignto = request.getParameter("currentatassignto");
		String Crrentselecengg=request.getParameter("Crrentselecengg");
		String currentselectgrp=request.getParameter("currentselectgrp");
		System.out.println("current assign to   is" + currentatassignto);
		System.out.println("ticketid****" + ticketid+"Status*******"+CurrentStatus);
		System.out.println("ticketid****" + ticketid+"Status*******"+CurrentStatus);
		out.print(enggActivityService.CheckENGConflictAfterWorInProgressServiceRequest(ticketid,CurrentStatus,priviousetpnaame,priviouseemail,currentatassignto,currentselectgrp,Crrentselecengg));

		System.out.println("CheckENGConflictAfterWorInProgressServiceRequest SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}
@RequestMapping(value = { "/getenggWorkInProgressRequest" }, method = RequestMethod.POST)
public JSONArray getenggWorkInProgressRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getenggWorkInProgressRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String LoginUser = session.getAttribute("username").toString();
		JSONArray final_response = enggActivityService.getenggWorkInProgressRequest(LoginUser);

		System.out.println("getenggAssingRequest reponse is = " + final_response);
		out.print(final_response);
		System.out.println("getenggAssingRequest SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
	return null;
}
@RequestMapping(value = { "/UpdateAssignRequestsFromWIP" }, method = RequestMethod.POST)
public String  UpdateAssignRequestsFromWIP(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam("resolvePic") MultipartFile resolvePic) {
	System.out.println("Inside UpdateAssignREquests Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
	
	
		String engname = request.getParameter("engname");
		String engcompany=request.getParameter("engcompany");	
		String engsite = request.getParameter("engsite");
		String engdepartment=request.getParameter("engdepartment");
		String subdepartmentengg=request.getParameter("subdepartmentengg");
		String locationtpengg=request.getParameter("locationtpengg");	
		String engemailid = request.getParameter("engemailid");
		String engphone = request.getParameter("engphone");

		String username = request.getParameter("username");
		String usercompany = request.getParameter("usercompany");
		String userbranch = request.getParameter("usersite");
		String userdepartment=request.getParameter("userdepartment");
		String subdepartmentrequester=request.getParameter("subdepartmentrequester");
		String locationrequester=request.getParameter("locationrequester");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");
		String otheremail = request.getParameter("otheremail");
		
		String tcname = request.getParameter("tcname");	
		
		String tccompany=request.getParameter("tccompany");
		String tcsite=request.getParameter("tcsite");
		String tcdepartment=request.getParameter("tcdepartment");
		String subdepartmenttp=request.getParameter("subdepartmenttp");
		String locationtp=request.getParameter("locationtp");
		String tcemail = request.getParameter("tcemail");
		String tcphone = request.getParameter("tcphone");
		
		String tid = request.getParameter("tid");
		String raisedate = request.getParameter("raisedate");
		String assigndate = request.getParameter("assigndate");
		String category = request.getParameter("category");
		String subcat1 = request.getParameter("subcat1");
		String subcat2 = request.getParameter("subcat2");
		String ticketstatus=request.getParameter("ticketstatus");		
		String priority = request.getParameter("priority");
		String severity=request.getParameter("severity");
		String sub = request.getParameter("subject");
		String requestmode=request.getParameter("requestmode");
		String description = request.getParameter("description");
		
	
		
		
		System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
		
		String ticketid = request.getParameter("ticketid");
		System.out.println("ticketid****" + ticketid);
		String status = request.getParameter("status");	
		String solution = request.getParameter("solution");
		
		String assignTo=request.getParameter("assignTo");
		String enggcat=request.getParameter("enggcat");
		String enggassign=request.getParameter("enggassign");
		String engGroup=request.getParameter("engGroup");
	
		
		

//		String engcompany=request.getParameter("engcompany");	

//		String engdepartment=request.getParameter("engdepartment");
//		String subdepartmentengg=request.getParameter("subdepartmentengg");
//		String locationtpengg=request.getParameter("locationtpengg");	
		
		out.print(enggActivityService.UpdateAssignRequestsFromWIP(tid, status, engname, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,otheremail));

		System.out.println("UpdateAssignRequests SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}

@RequestMapping(value = { "/getTcWorkInProgressRequest" }, method = RequestMethod.POST)
public JSONArray getTcWorkInProgressRequest(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getTcWorkInProgressRequest Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;

	try {
		out = response.getWriter();

		String LoginUser = session.getAttribute("username").toString();
		JSONArray final_response = enggActivityService.getTcWorkInProgressRequest(LoginUser);

		System.out.println("getenggAssingRequest reponse is = " + final_response);
		out.print(final_response);
		System.out.println("getenggAssingRequest SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
	return null;
}
@RequestMapping(value = { "/UpdateFromWIPRequests" }, method = RequestMethod.POST)
public String  UpdateFromWIPRequests(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam("resolvePic") MultipartFile resolvePic) {
	System.out.println("Inside UpdateAssignREquests Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		String engname = request.getParameter("engname");
		String engcompany=request.getParameter("engcompany");	
		String engsite = request.getParameter("engsite");
		String engdepartment=request.getParameter("engdepartment");
		String subdepartmentengg=request.getParameter("subdepartmentengg");
		String locationtpengg=request.getParameter("locationtpengg");	
		String engemailid = request.getParameter("engemailid");
		String engphone = request.getParameter("engphone");
		
		String username = request.getParameter("username");
		String usercompany = request.getParameter("usercompany");
		String userbranch = request.getParameter("usersite");
		String userdepartment=request.getParameter("userdepartment");
		String subdepartmentrequester=request.getParameter("subdepartmentrequester");
		String locationrequester=request.getParameter("locationrequester");
		String useremail = request.getParameter("useremail");
		String userphone = request.getParameter("userphone");

		
		String tcname = request.getParameter("tcname");	
		
		String tccompany=request.getParameter("tccompany");
		String tcsite=request.getParameter("tcsite");
		String tcdepartment=request.getParameter("tcdepartment");
		String subdepartmenttp=request.getParameter("subdepartmenttp");
		String locationtp=request.getParameter("locationtp");
		String tcemail = request.getParameter("tcemail");
		String tcphone = request.getParameter("tcphone");
		
		String tid = request.getParameter("tid");
		String raisedate = request.getParameter("raisedate");
		String assigndate = request.getParameter("assigndate");
		String category = request.getParameter("category");
		String subcat1 = request.getParameter("subcat1");
		String subcat2 = request.getParameter("subcat2");
		String ticketstatus=request.getParameter("ticketstatus");		
		String priority = request.getParameter("priority");
		String severity=request.getParameter("severity");
		String sub = request.getParameter("subject");
		String requestmode=request.getParameter("requestmode");
		String description = request.getParameter("description");
		String otheremail = request.getParameter("otheremail");
		
		System.out.println("EMPIC FILE NAME: "+resolvePic.getOriginalFilename());
        System.out.println("EMPIC FILE SIZE: "+resolvePic.getSize());
		
		String ticketid = request.getParameter("ticketid");
		System.out.println("ticketid****" + ticketid);
		String status = request.getParameter("status");	
		String solution = request.getParameter("solution");
		
		String assignTo=request.getParameter("assignTo");
		String enggcat=request.getParameter("enggcat");
		String enggassign=request.getParameter("enggassign");
		String engGroup=request.getParameter("engGroup");
	
		
		

//		String engcompany=request.getParameter("engcompany");	

//		String engdepartment=request.getParameter("engdepartment");
//		String subdepartmentengg=request.getParameter("subdepartmentengg");
//		String locationtpengg=request.getParameter("locationtpengg");	
		
		out.print(enggActivityService.UpdateFromWIPRequests(tid, status, engname, engsite, engemailid, engphone,
				username, usercompany, userbranch, useremail, userphone, tcname, tcemail, tcphone, raisedate, assigndate,
				priority, sub, description, category, subcat1, subcat2, solution, resolvePic,severity,assignTo,enggcat,enggassign,engGroup,otheremail));

		System.out.println("UpdateAssignRequests SUCCESS");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		out.close();
	}
return null;
}


@RequestMapping(value = { "/getEnggDashboardDataticketgroup" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDataticketgroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getEnggDashboardDataticketgroup Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
//		String loginuser=(String)session.getAttribute("lastmonthdates");
		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.getEnggDashboardDataticketgroup(chartdata);

		System.out.println("getEnggDashboardDataticketgroup reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getEnggDashboardDataticketgroup SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/getEnggDashboardDataticketCategory" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDataticketCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getEnggDashboardDataticketCategory Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String chartdata=request.getParameter("lastmonthdates");
		
		JSONArray final_response = enggActivityService.getEnggDashboardDataticketCategory(chartdata);

		System.out.println("getEnggDashboardDataticketCategory reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getTgetEnggDashboardDataticketCategoryPDashboardData SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/getEnggDashboardDataservicerequestgroup" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDataservicerequestgroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	try {
		out = response.getWriter();
		
		String chartdata = request.getParameter("lastmonthdates");
		System.out.println("dfhgdhhghghgdhdgh"+chartdata);
		JSONArray final_response = enggActivityService.getEnggDashboardDataservicerequestgroup(chartdata);

		System.out.println("getEnggDashboardDataservicerequestgroup reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getEnggDashboardDataservicerequestgroup SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/getEnggDashboardDaservicerequestcategory" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDaservicerequestcategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getTPDashboardData Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		
		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.getEnggDashboardDaservicerequestcategory(chartdata);

		System.out.println("getEnggDashboardDaservicerequestcategory reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getEnggDashboardDaservicerequestcategory SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}




@RequestMapping(value = { "/priorityseverityTicketdashboardengg" }, method = RequestMethod.POST)
public JSONArray priorityseverityTicketdashboardengg(ModelMap model, HttpServletRequest request, HttpServletResponse response,

		HttpSession session) {
	System.out.println("Inside priorityseverityTicketdashboardengg Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();

		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.priorityseverityTicketdashboardengg(chartdata);

		System.out.println("priorityseverityTicketdashboardengg reponse is = " + final_response);

		out.print(final_response);

		System.out.println("priorityseverityTicketdashboardengg SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/priorityseverityserviceengg" }, method = RequestMethod.POST)
public JSONArray priorityseverityserviceengg(ModelMap model, HttpServletRequest request, HttpServletResponse response,

		HttpSession session) {
	System.out.println("Inside priorityseverityserviceengg Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();

		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.priorityseverityserviceengg(chartdata);

		System.out.println("priorityseverityserviceengg reponse is = " + final_response);

		out.print(final_response);

		System.out.println("priorityseverityserviceengg SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
////////////////////////////////////PROBLEM DASHBOARD DATA START////////////////
@RequestMapping(value = { "/getEnggDashboardDataProblemticketgroup" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDataProblemticketgroup(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getEnggDashboardDataProblemticketgroup Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
//		String loginuser=(String)session.getAttribute("username");
		String chartdata = request.getParameter("lastmonthdates");
		System.out.println("chart data " +chartdata);
		JSONArray final_response = enggActivityService.getEnggDashboardDataProblemticketgroup(chartdata);

		System.out.println("getEnggDashboardDataservicerequestgroup reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getEnggDashboardDataservicerequestgroup SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/getEnggDashboardDaProblemcategory" }, method = RequestMethod.POST)
public JSONArray getEnggDashboardDaProblemcategory(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getEnggDashboardDaProblemcategory Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.getEnggDashboardDaProblemcategory(chartdata);

		System.out.println("getEnggDashboardDaProblemcategory reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getEnggDashboardDaProblemcategory SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
		}
//	return "Dashboard";
	return null;

}
@RequestMapping(value = { "/priorityseverityProblemTicketdashboardengg" }, method = RequestMethod.POST)
public JSONArray priorityseverityProblemTicketdashboardengg(ModelMap model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	System.out.println("Inside priorityseverityProblemTicketdashboardengg Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();

		String chartdata = request.getParameter("lastmonthdates");
		JSONArray final_response = enggActivityService.priorityseverityProblemTicketdashboardengg(chartdata);

//		System.out.println("priorityseverityProblemTicketdashboardengg reponse is = " + final_response);

		out.print(final_response);

//		System.out.println("priorityseverityProblemTicketdashboardengg SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}
//////////////////////////////////PROBLEM DASHBOARD DATA END//////////////////

@RequestMapping(value = { "/getIncidentGroupList" }, method = RequestMethod.POST)
public JSONArray getIncidentGroupList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getIncidentGroupList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String group=request.getParameter("group");
		System.out.println("dfdfdfdfddf"+group);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getIncidentGroupList(loginuser,lastmonth,group);

		System.out.println("getIncidentGroupList reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getIncidentGroupList SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/getServiceGroupList" }, method = RequestMethod.POST)
public JSONArray getServiceGroupList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getServiceGroupList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String group=request.getParameter("group");
		System.out.println("dfdfdfdfddf"+group);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getServiceGroupList(loginuser,lastmonth,group);

		System.out.println("getServiceGroupList reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getServiceGroupList SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}


@RequestMapping(value = { "/getProblemGroupList" }, method = RequestMethod.POST)
public JSONArray getProblemGroupList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getProblemGroupList Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String group=request.getParameter("group");
		System.out.println("dfdfdfdfddf"+group);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getProblemGroupList(loginuser,lastmonth,group);

		System.out.println("getProblemGroupList reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getProblemGroupList SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}
//	return "Dashboard";
	return null;

}

@RequestMapping(value = { "/getIncidentCategoryListing" }, method = RequestMethod.POST)
public JSONArray getIncidentCategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getIncidentCategoryListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String category=request.getParameter("category");
		System.out.println("dfdfdfdfddf"+category);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getIncidentCategoryListing(loginuser,lastmonth,category);

		System.out.println("getIncidentCategoryListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getIncidentCategoryListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;

}

@RequestMapping(value = { "/getServiceRequestCategoryListing" }, method = RequestMethod.POST)
public JSONArray getServiceRequestCategoryListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getServiceRequestCategoryListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String category=request.getParameter("category");
		System.out.println("dfdfdfdfddf"+category);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getServiceRequestCategoryListing(loginuser,lastmonth,category);

		System.out.println("getServiceRequestCategoryListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getServiceRequestCategoryListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;
}

@RequestMapping(value = { "/getPrioritySeverityIncidentListing" }, method = RequestMethod.POST)
public JSONArray getPrioritySeverityIncidentListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getPrioritySeverityIncidentListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String priority=request.getParameter("priority");
		String severity=request.getParameter("severity");
		System.out.println("dfdfdfdfddf"+priority);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getPrioritySeverityIncidentListing(loginuser,lastmonth,priority,severity);

		System.out.println("getPrioritySeverityIncidentListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getPrioritySeverityIncidentListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;
}
@RequestMapping(value = { "/getPrioritySeverityServiceListing" }, method = RequestMethod.POST)
public JSONArray getPrioritySeverityServiceListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getPrioritySeverityServiceListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String priority=request.getParameter("priority");
		String severity=request.getParameter("severity");
		System.out.println("dfdfdfdfddf"+priority);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getPrioritySeverityServiceListing(loginuser,lastmonth,priority,severity);

		System.out.println("getPrioritySeverityServiceListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getPrioritySeverityServiceListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;
}

@RequestMapping(value = { "/getPrioritySeverityProblemListing" }, method = RequestMethod.POST)
public JSONArray getPrioritySeverityProblemListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getPrioritySeverityProblemListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String loginuser=(String)session.getAttribute("username");
		String lastmonth=request.getParameter("lastmonth");
		String priority=request.getParameter("priority");
		String severity=request.getParameter("severity");
		System.out.println("dfdfdfdfddf"+priority);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getPrioritySeverityProblemListing(loginuser,lastmonth,priority,severity);

		System.out.println("getPrioritySeverityProblemListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getPrioritySeverityProblemListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;
}
@RequestMapping(value = { "/getCategoryProblemListing" }, method = RequestMethod.POST)
public JSONArray getCategoryProblemListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside getCategoryProblemListing Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();
		String category=request.getParameter("category");
		String lastmonth=request.getParameter("lastmonth");
		String loginuser=(String)session.getAttribute("username");
		
		System.out.println("dfdfdfdfddf"+category);
		String chartdata = null;
		JSONArray final_response = enggActivityService.getCategoryProblemListing(loginuser,lastmonth,category);

		System.out.println("getCategoryProblemListing reponse is = " + final_response);

		out.print(final_response);

		System.out.println("getCategoryProblemListing SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}


	return null;
}

// Engineer Report

@RequestMapping(value = { "/GetEnggWiseReportSuccess" }, method = RequestMethod.POST)
public JSONArray GetEnggWiseReportSuccess(ModelMap model, HttpServletRequest request, HttpServletResponse response,
		HttpSession session) {
	System.out.println("Inside GetEnggWiseReportSuccess Controller@@@@@@@@@@@@ ");
	PrintWriter out = null;
	String sname = null;

	try {
		out = response.getWriter();

		String FromDate = request.getParameter("FromDate");
		String ToDate = request.getParameter("ToDate");
//		String username = request.getParameter("username");
//		String status = request.getParameter("status");
	
		System.out.println("FromDate: " + FromDate);
		System.out.println("ToDate: " + ToDate);
//		System.out.println("enggname  : " + username);
//		System.out.println("status: " + status);

		JSONArray final_response = enggActivityService.GetEnggWiseReportSuccess(FromDate, ToDate);

		System.out.println("GetEnggWiseReportSuccess reponse is = " + final_response);

		out.print(final_response);

		System.out.println("GetEnggWiseReportSuccess SUCCESS");

	} catch (Exception e) {
		e.printStackTrace();
	}

	finally {
		out.close();
	}

	return null;

}


}