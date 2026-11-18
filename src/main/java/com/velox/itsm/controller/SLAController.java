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

import com.velox.itsm.service.SLAService;


@Controller
@RequestMapping("/SLA")
public class SLAController {

	@Autowired
	SLAService slaService;
		
	@RequestMapping(value = { "/getPriorityName" }, method = RequestMethod.POST)
	public JSONArray getPriorityName(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getPriorityName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
	

		try {
			out = response.getWriter();
			String company = request.getParameter("companyName");
			JSONArray final_response = slaService.getPriorityName(company);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("COMPANY NAME GET SUCCESS");
			
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
		System.out.println("Inside getPriorityName Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String pname = null;
	

		try {
			out = response.getWriter();
			
			String company = request.getParameter("companyName");
			JSONArray final_response = slaService.getSeverityName(company);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("COMPANY NAME GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	@RequestMapping(value = { "/getHoldTimeDetails" }, method = RequestMethod.POST)
	public JSONArray getHoldTimeDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getHoldTimeDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String hold = null;
	

		try {
			out = response.getWriter();
			
			JSONArray final_response = slaService.getHoldTimeDetails(hold);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("COMPANY NAME GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	
	@RequestMapping(value = { "/SubmitHoldDetails" }, method = RequestMethod.POST)
	public JSONArray SubmitHoldDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitHoldDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
					
			String checkStatus = request.getParameter("checkStatus");
			
			System.out.println("checkStatus is = " + checkStatus);
			
							
			String final_response = slaService.checkStatus(checkStatus);

			System.out.println("MailConfigControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("AutoClosedInsert GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
		
	}
	
	@RequestMapping(value = { "/SLAMasterListing" }, method = RequestMethod.POST)
	public JSONArray SLAMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SLAMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = slaService.SLAMasterListing(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SLAMasterListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}
	
	@RequestMapping(value = { "/UpdateSLADetails" }, method = RequestMethod.POST)
	public JSONArray UpdateSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside UpdateSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
						
			String priorityupdate = request.getParameter("priorityupdate");
			String cnameupdate = request.getParameter("cnameupdate");
			String severityupdate = request.getParameter("severityupdate");
			String checkStatusupdate = request.getParameter("checkStatusupdate");
			String checkcalenderupdate = request.getParameter("checkcalenderupdate");
			int daysupdate = Integer. parseInt(request. getParameter("daysupdate"));
			int hoursupdate = Integer. parseInt(request. getParameter("hoursupdate"));
			int minutesupdate = Integer. parseInt(request. getParameter("minutesupdate"));
			int secondsupdate = Integer. parseInt(request. getParameter("secondsupdate"));
			int sr_no = Integer. parseInt(request. getParameter("sr_no"));
			System.out.println("priorityupdate is = " + priorityupdate);
			System.out.println("severitytyupdate is = " + severityupdate);
			System.out.println("cnameupdate is = " + cnameupdate);
			System.out.println("daysupdate is = " + daysupdate);
			System.out.println("hoursupdate is = " + hoursupdate);
			System.out.println("minutesupdate is = " + minutesupdate);
			System.out.println("secondsupdate is = " + secondsupdate);
			
			String final_response = slaService.UpdateSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate,sr_no,cnameupdate,severityupdate,checkStatusupdate,checkcalenderupdate);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UpdateSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/deleteSLA" }, method = RequestMethod.POST)
	public JSONArray deleteSLA(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteSLA Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int sr_no = Integer.parseInt(request. getParameter("sr_no"));
			
			System.out.println("sr_no is = " + sr_no);
			
			String final_response = slaService.deleteSLA(sr_no);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("deleteSLA GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/SubmitSLADetails" }, method = RequestMethod.POST)
	public JSONArray SubmitSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String slastatus = request.getParameter("slastatus");
			String checkcalenderweekid = request.getParameter("checkcalenderweekid");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String cname = request.getParameter("cname");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));
				
			System.out.println("priority is = " + priority);
			System.out.println("days is = " + days);
			System.out.println("hours is = " + hours);
			System.out.println("minutes is = " + minutes);
			System.out.println("seconds is = " + seconds);
	
			
				
			String final_response = slaService.SubmitSLADetails(priority, days, hours, minutes, seconds,severity,cname,slastatus,checkcalenderweekid);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SubmitSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/SubmitResponseSLADetails" }, method = RequestMethod.POST)
	public JSONArray SubmitResponseSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitResponseSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
		
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String cname = request.getParameter("cname");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));
				String slatime=request.getParameter("checkweekorcalenderstatus");
			System.out.println("priority is = " + priority);
			System.out.println("days is = " + days);
			System.out.println("hours is = " + hours);
			System.out.println("minutes is = " + minutes);
			System.out.println("seconds is = " + seconds);
	
			
				
			String final_response = slaService.SubmitResponseSLADetails(priority, days, hours, minutes, seconds,severity,cname,slatime);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SubmitResponseSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getResponseSLAMasterListing" }, method = RequestMethod.POST)
	public JSONArray getResponseSLAMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResponseSLAMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = slaService.getResponseSLAMasterListing(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getResponseSLAMasterListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}
	
	@RequestMapping(value = { "/UpdateResponseSLADetails" }, method = RequestMethod.POST)
	public JSONArray UpdateResponseSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside UpdateResponseSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
						
			String priorityupdate = request.getParameter("priorityupdate");
			String cnameupdate = request.getParameter("cnameupdate");
			String severityupdate = request.getParameter("severityupdate");
			String cweek = request.getParameter("cweek");
			int daysupdate = Integer. parseInt(request. getParameter("daysupdate"));
			int hoursupdate = Integer. parseInt(request. getParameter("hoursupdate"));
			int minutesupdate = Integer. parseInt(request. getParameter("minutesupdate"));
			int secondsupdate = Integer. parseInt(request. getParameter("secondsupdate"));
			int sr_no = Integer. parseInt(request. getParameter("sr_no"));
			System.out.println("sdfdfdfdf"+cweek);
			String final_response = slaService.UpdateResponseSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate,sr_no,cnameupdate,severityupdate,cweek);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UpdateSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/deleteResponseSLA" }, method = RequestMethod.POST)
	public JSONArray deleteResponseSLA(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteSLA Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int sr_no = Integer.parseInt(request. getParameter("sr_no"));
			
			System.out.println("sr_no is = " + sr_no);
			
			String final_response = slaService.deleteResponseSLA(sr_no);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("deleteSLA GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/SubmitServiceRequestSLADetails" }, method = RequestMethod.POST)
	public JSONArray SubmitServiceRequestSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitServiceRequestSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String slastatus = request.getParameter("slastatus");
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String cname = request.getParameter("cname");
			String slaweek=request.getParameter("slaweek");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));
				
			System.out.println("priority is = " + priority);
			System.out.println("days is = " + days);
			System.out.println("hours is = " + hours);
			System.out.println("minutes is = " + minutes);
			System.out.println("seconds is = " + seconds);
	
			
				
			String final_response = slaService.SubmitServiceRequestSLADetails(priority, days, hours, minutes, seconds,severity,cname,slastatus,slaweek);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SubmitSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/getServiceRequestHoldTime" }, method = RequestMethod.POST)
	public JSONArray getServiceRequestHoldTime(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getHoldTimeDetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String hold = null;
	

		try {
			out = response.getWriter();
			
			JSONArray final_response = slaService.getServiceRequestHoldTime(hold);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("COMPANY NAME GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;

	}
	@RequestMapping(value = { "/ServiceRequestSLAMasterListing" }, method = RequestMethod.POST)
	public JSONArray ServiceRequestSLAMasterListing(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SLAMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = slaService.ServiceRequestSLAMasterListing(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SLAMasterListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}
	@RequestMapping(value = { "/deleteServiceRequestSLA" }, method = RequestMethod.POST)
	public JSONArray deleteServiceRequestSLA(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteServiceRequestSLA Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int sr_no = Integer.parseInt(request. getParameter("sr_no"));
			
			System.out.println("sr_no is = " + sr_no);
			
			String final_response = slaService.deleteServiceRequestSLA(sr_no);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("deleteSLA GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/UpdateServiceRequestSLADetails" }, method = RequestMethod.POST)
	public JSONArray UpdateServiceRequestSLADetails(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside UpdateSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
						
			String priorityupdate = request.getParameter("priorityupdate");
			String cnameupdate = request.getParameter("cnameupdate");
			String severityupdate = request.getParameter("severityupdate");
			String checkStatusupdate = request.getParameter("checkStatusupdate");
			String slaweek = request.getParameter("slaweek");
			
			int daysupdate = Integer. parseInt(request. getParameter("daysupdate"));
			int hoursupdate = Integer. parseInt(request. getParameter("hoursupdate"));
			int minutesupdate = Integer. parseInt(request. getParameter("minutesupdate"));
			int secondsupdate = Integer. parseInt(request. getParameter("secondsupdate"));
			int sr_no = Integer. parseInt(request. getParameter("sr_no"));
			System.out.println("priorityupdate is = " + priorityupdate);
			System.out.println("severitytyupdate is = " + severityupdate);
			System.out.println("cnameupdate is = " + cnameupdate);
			System.out.println("daysupdate is = " + daysupdate);
			System.out.println("hoursupdate is = " + hoursupdate);
			System.out.println("minutesupdate is = " + minutesupdate);
			System.out.println("secondsupdate is = " + secondsupdate);
			
			String final_response = slaService.UpdateServiceRequestSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate,sr_no,cnameupdate,severityupdate,checkStatusupdate,slaweek);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UpdateSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/SubmitResponseSLADetailsForSR" }, method = RequestMethod.POST)
	public JSONArray SubmitResponseSLADetailsForSR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside SubmitResponseSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
		
			String priority = request.getParameter("priority");
			String severity = request.getParameter("severity");
			String cname = request.getParameter("cname");
			String slaweek = request.getParameter("slaweek");
			int days = Integer.parseInt(request.getParameter("days"));
			int hours = Integer.parseInt(request.getParameter("hours"));
			int minutes = Integer.parseInt(request.getParameter("minutes"));
			int seconds = Integer.parseInt(request.getParameter("seconds"));
				
			System.out.println("priority is = " + priority);
			System.out.println("days is = " + days);
			System.out.println("hours is = " + hours);
			System.out.println("minutes is = " + minutes);
			System.out.println("seconds is = " + seconds);
	
			
				
			String final_response = slaService.SubmitResponseSLADetailsForSR(priority, days, hours, minutes, seconds,severity,cname,slaweek);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("SubmitResponseSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
	@RequestMapping(value = { "/getResponseSLAMasterListingForSR" }, method = RequestMethod.POST)
	public JSONArray getResponseSLAMasterListingFor(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getResponseSLAMasterListing Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			
			String userlist=null;
			JSONArray final_response = slaService.getResponseSLAMasterListingForSR(userlist);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getResponseSLAMasterListing SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
	}
	
	@RequestMapping(value = { "/UpdateResponseSLADetailsForSR" }, method = RequestMethod.POST)
	public JSONArray UpdateResponseSLADetailsForSR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside UpdateResponseSLADetails Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
						
			String priorityupdate = request.getParameter("priorityupdate");
			String cnameupdate = request.getParameter("cnameupdate");
			String severityupdate = request.getParameter("severityupdate");
			String slaweek = request.getParameter("slaweek");
			int daysupdate = Integer. parseInt(request. getParameter("daysupdate"));
			int hoursupdate = Integer. parseInt(request. getParameter("hoursupdate"));
			int minutesupdate = Integer. parseInt(request. getParameter("minutesupdate"));
			int secondsupdate = Integer. parseInt(request. getParameter("secondsupdate"));
			int sr_no = Integer. parseInt(request. getParameter("sr_no"));
			System.out.println("priorityupdate is = " + priorityupdate);
			System.out.println("severitytyupdate is = " + severityupdate);
			System.out.println("cnameupdate is = " + cnameupdate);
			System.out.println("daysupdate is = " + daysupdate);
			System.out.println("hoursupdate is = " + hoursupdate);
			System.out.println("minutesupdate is = " + minutesupdate);
			System.out.println("secondsupdate is = " + secondsupdate);
			
			String final_response = slaService.UpdateResponseSLADetailsForSR(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate,sr_no,cnameupdate,severityupdate,slaweek);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("UpdateSLADetails GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	@RequestMapping(value = { "/deleteResponseSLAForSR" }, method = RequestMethod.POST)
	public JSONArray deleteResponseSLAForSR(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside deleteSLA Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		String sname = null;
	

		try {
			out = response.getWriter();
			int sr_no = Integer.parseInt(request. getParameter("sr_no"));
			
			System.out.println("sr_no is = " + sr_no);
			
			String final_response = slaService.deleteResponseSLAForSR(sr_no);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("deleteSLA GET SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
//		return "Dashboard";
		return null;
		
	}
	
}
