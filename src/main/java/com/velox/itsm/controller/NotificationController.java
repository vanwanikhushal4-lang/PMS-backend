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

import com.velox.itsm.service.NotificationConfig;


@Controller
@RequestMapping("/NotificationConfig")
public class NotificationController {

	@Autowired
	NotificationConfig notificationConfig;

	@RequestMapping(value = { "/getUserNotification" }, method = RequestMethod.POST)
	public JSONArray getUserNotification(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserNotification Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String notify=null;
			JSONArray final_response = notificationConfig.getUserNotification(notify);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("Notification_User SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getTPNotification" }, method = RequestMethod.POST)
	public JSONArray getTPNotification(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPNotification Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String notify=null;
			JSONArray final_response = notificationConfig.getTPNotification(notify);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getTPNotification SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getEnggNotification" }, method = RequestMethod.POST)
	public JSONArray getEnggNotification(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEnggNotification Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String notify=null;
			JSONArray final_response = notificationConfig.getEnggNotification(notify);

			System.out.println("MastersControllerrrr reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("Notification_Engg SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getTPOutage" }, method = RequestMethod.POST)
	public JSONArray getTPOutage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getTPOutage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String outage=null;
			JSONArray final_response = notificationConfig.getTPOutage(outage);

			System.out.println("getTPOutage reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getTPOutage SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getUserOutage" }, method = RequestMethod.POST)
	public JSONArray getUserOutage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getUserOutage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String outage=null;
			JSONArray final_response = notificationConfig.getUserOutage(outage);

			System.out.println("getUserOutage reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getUserOutage SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
	@RequestMapping(value = { "/getEnggOutage" }, method = RequestMethod.POST)
	public JSONArray getEnggOutage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		System.out.println("Inside getEnggOutage Controller@@@@@@@@@@@@ ");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			String outage=null;
			JSONArray final_response = notificationConfig.getEnggOutage(outage);

			System.out.println("getEnggOutage reponse is = " + final_response);
						
				out.print(final_response);
						
				System.out.println("getEnggOutage SUCCESS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}

		return null;
	}
	
}
