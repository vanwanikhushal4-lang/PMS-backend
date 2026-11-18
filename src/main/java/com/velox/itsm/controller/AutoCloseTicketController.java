package com.velox.itsm.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.velox.itsm.service.AutoCloseTicketService;

@Controller
@RequestMapping("/AutoCloseTicket")
public class AutoCloseTicketController {

	@Autowired
	AutoCloseTicketService autoCloseTicketService;

	@RequestMapping(value = { "/AutoClosedInsert" }, method = RequestMethod.POST)
	public JSONArray AutoClosedInsert(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside AutoClosedInsert Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String TicketType = request.getParameter("TicketType");
			String TimeFormat = request.getParameter("TimeFormat");
			String Time = request.getParameter("Time");
			String rsn = request.getParameter("rsn");
			String company = request.getParameter("companyName");

			System.out.println("TicketType is = " + TicketType);
			System.out.println("TimeFormat is = " + TimeFormat);
			System.out.println("Time is = " + Time);
			System.out.println("rsn is = " + rsn);
			
			String final_response = autoCloseTicketService.AutoClosedInsert(TicketType, TimeFormat, Time,rsn, company);

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
	
	@RequestMapping(value = { "/AutoClosedProblemInsert" }, method = RequestMethod.POST)
	public JSONArray AutoClosedProblemInsert(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside AutoClosedProblemInsert Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;

		try {
			out = response.getWriter();

			String TicketType = request.getParameter("TicketType");
			String TimeFormat = request.getParameter("TimeFormat");
			String Time = request.getParameter("Time");
			String rsn = request.getParameter("rsn");
			String company = request.getParameter("companyName");
			

			System.out.println("TicketType is = " + TicketType);
			System.out.println("TimeFormat is = " + TimeFormat);
			System.out.println("Time is = " + Time);
			System.out.println("rsn is = " + rsn);
			System.out.println("Company is = " + company);

			String final_response = autoCloseTicketService.AutoClosedProblemInsert(TicketType, TimeFormat, Time,rsn, company);

			System.out.println("MailConfigControllerrrr reponse is = " + final_response);

			out.print(final_response);

			System.out.println("AutoClosedProblemInsert GET SUCCESS");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;

	}

}
