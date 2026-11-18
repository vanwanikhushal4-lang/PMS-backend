package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.dao.SLADao;

@Service("SLAService")
@Transactional
public class SLAServiceImpl implements SLAService {

	@Autowired
	SLADao slaDao;
	
	@Override
	public JSONArray getPriorityName(String company) {
System.out.println("Inside getPriorityName ");
		
		String controller_response = null;
	

		JSONArray priority_dao_output = slaDao.getPriorityName(company);
		System.out.println("From Service_IMPL_output response " + priority_dao_output);
		return priority_dao_output;
	}


	@Override
	public JSONArray getHoldTimeDetails(String hold) {
System.out.println("Inside getHoldTimeDetails ");
		
		String controller_response = null;
	

		System.out.println("getHoldTimeDetails name" + hold);
		JSONArray holdtime_dao_output = slaDao.getHoldTimeDetails(hold);
		System.out.println("From Service_IMPL_output response " + holdtime_dao_output);
		return holdtime_dao_output;
	}

	@Override
	public String checkStatus(String checkStatus) {
		
			// TODO Auto-generated method stub
			return slaDao.checkStatus(checkStatus);
	}


	@Override
	public JSONArray SLAMasterListing(String userlist) {

		System.out.println("SLAMasterListing" + userlist);
		JSONArray SLAMasterListing_dao_output = slaDao.SLAMasterListing(userlist);
		System.out.println("From Service_IMPL_output response " + SLAMasterListing_dao_output);
		return SLAMasterListing_dao_output;
	}


	@Override
	public String UpdateSLADetails(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no,String cnameupdate,String severityupdate, String checkStatusupdate,String checkcalenderstatusupdate) {
		
		return slaDao.UpdateSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate, sr_no, cnameupdate,severityupdate,checkStatusupdate,checkcalenderstatusupdate);
	}

	@Override
	public String deleteSLA(int sr_no) {
		// TODO Auto-generated method stub
		return slaDao.deleteSLA(sr_no);
	}



	@Override
	public String SubmitSLADetails(String priority, int days, int hours, int minutes, int seconds,String severity,String cname,String slastatus,String checkcalenderweekid) {
		// TODO Auto-generated method stub
		return slaDao.SubmitSLADetails(priority, days, hours, minutes, seconds,severity,cname,slastatus,checkcalenderweekid);
	}

	public JSONArray getSeverityName(String company) {
		System.out.println("Inside getPriorityName ");
				
				String controller_response = null;
			


				JSONArray severity_dao_output = slaDao.getSeverityName(company);
				System.out.println("From Service_IMPL_output response " + severity_dao_output);
				return severity_dao_output;
			}
	@Override
	public String SubmitResponseSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slatime) {
	
		return slaDao.SubmitResponseSLADetails(priority, days, hours, minutes, seconds,severity,cname,slatime);
	}


	@Override
	public JSONArray getResponseSLAMasterListing(String userlist) {
		return slaDao.getResponseSLAMasterListing(userlist);
	}


	@Override
	public String UpdateResponseSLADetails(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate,String cweek) {
	
		return slaDao.UpdateResponseSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate, sr_no, cnameupdate,severityupdate,cweek);
	}


	@Override
	public String deleteResponseSLA(int sr_no) {
		return slaDao.deleteResponseSLA(sr_no);
	}

	@Override
	public String SubmitServiceRequestSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slastatus,String slaweek) {
		return slaDao.SubmitServiceRequestSLADetails(priority, days, hours, minutes, seconds,severity,cname,slastatus,slaweek);
	}


	@Override
	public JSONArray getServiceRequestHoldTime(String hold) {
		System.out.println("getHoldTimeDetails name" + hold);
		JSONArray holdtime_dao_output = slaDao.getServiceRequestHoldTime(hold);
		System.out.println("From Service_IMPL_output response " + holdtime_dao_output);
		return holdtime_dao_output;
	}


	@Override
	public JSONArray ServiceRequestSLAMasterListing(String userlist) {

		System.out.println("SLAMasterListing" + userlist);
		JSONArray SLAMasterListing_dao_output = slaDao.ServiceRequestSLAMasterListing(userlist);
		System.out.println("From Service_IMPL_output response " + SLAMasterListing_dao_output);
		return SLAMasterListing_dao_output;
	}


	@Override
	public String deleteServiceRequestSLA(int sr_no) {
		return slaDao.deleteServiceRequestSLA(sr_no);
	}


	@Override
	public String UpdateServiceRequestSLADetails(String priorityupdate, int daysupdate, int hoursupdate,
			int minutesupdate, int secondsupdate, int sr_no, String cnameupdate, String severityupdate,
			String checkStatusupdate,String slaweek) {
		return slaDao.UpdateServiceRequestSLADetails(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate, sr_no, cnameupdate,severityupdate,checkStatusupdate,slaweek);
	}
	@Override
	public String SubmitResponseSLADetailsForSR(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname,String slaweek) {
	
		return slaDao.SubmitResponseSLADetailsForSR(priority, days, hours, minutes, seconds,severity,cname,slaweek);
	}


	@Override
	public JSONArray getResponseSLAMasterListingForSR(String userlist) {
		return slaDao.getResponseSLAMasterListingForSR(userlist);
	}


	@Override
	public String UpdateResponseSLADetailsForSR(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate,String slaweek) {
	
		return slaDao.UpdateResponseSLADetailsForSR(priorityupdate, daysupdate, hoursupdate, minutesupdate, secondsupdate, sr_no, cnameupdate,severityupdate,slaweek);
	}


	@Override
	public String deleteResponseSLAForSR(int sr_no) {
		return slaDao.deleteResponseSLAForSR(sr_no);
	}
	
	
}
