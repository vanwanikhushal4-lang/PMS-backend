package com.velox.itsm.dao;

import org.json.JSONArray;

public interface SLADao {

	public JSONArray getPriorityName(String company);
	public JSONArray getHoldTimeDetails(String hold);
	public String checkStatus(String checkStatus);
	public JSONArray SLAMasterListing(String userlist);
	public String UpdateSLADetails(String priorityupdate,int daysupdate,int hoursupdate,int minutesupdate,int secondsupdate, int sr_no, String cnameupdate, String severityupdate,String checkStatusupdate,String checkcalenderstatusupdate);
	public String deleteSLA(int sr_no);
	public String SubmitSLADetails(String priority,int days, int hours,int minutes, int seconds, String severity, String cname , String slastatus,String checkcalenderweekid);
	public JSONArray getSeverityName(String company);
	public String SubmitResponseSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slatime);
	public JSONArray getResponseSLAMasterListing(String userlist);
	public String UpdateResponseSLADetails(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate, String cweek);
	public String deleteResponseSLA(int sr_no);
	public String SubmitServiceRequestSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slastatus, String slaweek);
	public JSONArray getServiceRequestHoldTime(String hold);
	public JSONArray ServiceRequestSLAMasterListing(String userlist);
	public String deleteServiceRequestSLA(int sr_no);
	public String UpdateServiceRequestSLADetails(String priorityupdate, int daysupdate, int hoursupdate,
			int minutesupdate, int secondsupdate, int sr_no, String cnameupdate, String severityupdate,
			String checkStatusupdate, String slaweek);
	public String SubmitResponseSLADetailsForSR(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slaweek);
	public JSONArray getResponseSLAMasterListingForSR(String userlist);
	public String UpdateResponseSLADetailsForSR(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate, String slaweek);
	public String deleteResponseSLAForSR(int sr_no);
}
