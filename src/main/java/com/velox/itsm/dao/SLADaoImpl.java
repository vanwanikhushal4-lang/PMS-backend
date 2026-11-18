package com.velox.itsm.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.velox.itsm.model.companynames;
import com.velox.itsm.model.hold_time;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.mailconfigset;
import com.velox.itsm.model.prioritymaster;
import com.velox.itsm.model.responseslamaster;
import com.velox.itsm.model.service_request_response_sla_master;
import com.velox.itsm.model.service_request_sla_master;
import com.velox.itsm.model.severitymaster;
import com.velox.itsm.model.sla;
import com.velox.itsm.model.sla_master;;

@Repository("SLADao")
@Transactional
public class SLADaoImpl extends AbstractDao<Integer, mail_config> implements SLADao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Environment environment;

	@Override
	public JSONArray getPriorityName(String company) {
		System.out.println("Inside SLADaoImpl getPriorityName method");

		JSONArray array = null;

		JSONArray array1 = null;
//		String db_username = null
//		String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			
			Query query = getSession().createQuery("select distinct PRIORITY from prioritymaster where COMPANY=:COMPANY ORDER BY PRIORITY asc");
	    	query.setParameter("COMPANY", company);
		  List Result  = query.list();
			
//			query.setParameter("u", username);
			array1 = new JSONArray();
//			for (prioritymaster sourceDrive : dataList) {
//				System.out.println("array = " + sourceDrive.getPRIORITY());
//				array = new JSONArray();
			
			for (int i = 0; i < Result.size(); i++) {
				array = new JSONArray();
				array.put(Result.get(i));
				array1.put(array);
			}

			//	array.put(sourceDrive.getPRIORITY());
//				db_username = sourceDrive.getUSERNAME();
//				db_usertype=  sourceDrive.getUSERTYPE();
				//array1.put(array);

			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
	public JSONArray getHoldTimeDetails(String hold) {

		System.out.println("Inside SLADaoImpl getHoldTimeDetails method");

		JSONArray array = null;

		JSONArray array1 = null;
//		String db_username = null
//		String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);

			List<hold_time> dataList = getSession().createQuery("from hold_time").list();
//			query.setParameter("u", username);
			array1 = new JSONArray();
			for (hold_time sourceDrive : dataList) {
				System.out.println("array = " + sourceDrive.getHOLD_STATUS());
				array = new JSONArray();

				array.put(sourceDrive.getHOLD_STATUS());
//				db_username = sourceDrive.getUSERNAME();
//				db_usertype=  sourceDrive.getUSERTYPE();
				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
	public String checkStatus(String checkStatus) {

		System.out.println("Inside MasterDaoImpl checkStatus method");
		String status = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			System.out.println("checkStatus: " + checkStatus);

			System.out.println("inside checkStatus");
			Query query = sessionFactory.getCurrentSession().createQuery("from hold_time");

			hold_time data = (hold_time) query.uniqueResult();
			if (data != null) {
				System.out.println("inside update checkStatus");
				Query query1 = sessionFactory.getCurrentSession()
						.createQuery("update hold_time set HOLD_STATUS =:HOLD_STATUS");

				query1.setParameter("HOLD_STATUS", checkStatus);

				int i = query1.executeUpdate();

				if (i == 0) {
					status = "error";
				} else {

					status = "success";
				}
			} else {
				hold_time holdtime1 = new hold_time();

				holdtime1.setHOLD_STATUS(checkStatus);

				sessionFactory.getCurrentSession().persist(holdtime1);
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return status;
	}

	@Override
	public JSONArray SLAMasterListing(String userlist) {

		System.out.println("Inside MailConfigDaoImpl SLAMasterListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
//	String db_username = null;
//	String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			List<sla_master> dataList = getSession().createQuery("from sla_master").list();
//			query.setParameter("u", username);
			System.out.println("datalist="+dataList);
			array1 = new JSONArray();
			for (sla_master sourceDrive : dataList) {
//		query.setParameter("ut", "Admin");
			//List<sla_master> dataList = query.list();
			//System.out.println("datalist="+dataList);
			//array1 = new JSONArray();
							srno = srno + 1;
				System.out.println("array = " + sourceDrive.getCOMPANY());
				
				array = new JSONArray();

				array.put(srno);
				array.put(
						"<button class='btn btn-info' id='Editbtn' onclick='EditSLA(\"" + sourceDrive.getPRIORITY_NAME()
						+ "\",\"" + sourceDrive.getDAYS() + "\",\"" + sourceDrive.getHOURS() + "\",\""
						+ sourceDrive.getMINUTES() + "\",\"" + sourceDrive.getSECONDS()
						+ "\",\"" + sourceDrive.getCOMPANY()
							+"\",\"" + sourceDrive.getSEVERITY_NAME() 
							+"\",\"" + sourceDrive.getSR_NO() 
							+"\",\"" + sourceDrive.getHOLDTIME_STATUS()
							+"\",\"" +sourceDrive.getCALENDER_OR_WEEK_STATUS()
							
							+ "\" )'"
							+ "><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
		array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteSLA(\""
				+ sourceDrive.getSR_NO() + "\" )'><i class='fa fa-trash'></i></button>");
		array.put(sourceDrive.getCOMPANY());
		
		array.put(sourceDrive.getPRIORITY_NAME());
		array.put(sourceDrive.getSEVERITY_NAME());
		array.put(sourceDrive.getDAYS());
		array.put(sourceDrive.getHOURS());
		array.put(sourceDrive.getMINUTES());
		array.put(sourceDrive.getSECONDS());
		array.put(sourceDrive.getSLA_TARGET_DURATION());
		array.put(sourceDrive.getSLA_TARGET_ELAPSED_TIME());
		array.put(sourceDrive.getHOLDTIME_STATUS());
		array.put(sourceDrive.getCALENDER_OR_WEEK_STATUS());

				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//	return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
	public String UpdateSLADetails(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate,String severityupdate,String checkStatusupdate,String checkcalenderstatusupdate) {

		System.out.println("Inside SLADaoImpl UpdateSLADetails method");
		String status = null;

		try {

			System.out.println("inside UpdateSLADetails");
			
			
			System.out.println("PRIORITY  " + priorityupdate);
			System.out.println("SEVERITY  "+ severityupdate);
			System.out.println("PRIORITY  "+ severityupdate);
			
			Query query1 = getSession().createQuery("from sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and DAYS = :DAYS and HOURS = :HOURS and MINUTES = :MINUTES and SECONDS = :SECONDS and SR_NO=:SR_NO and HOLDTIME_STATUS=:HOLDTIME_STATUS and CALENDER_OR_WEEK_STATUS=:CALENDER_OR_WEEK_STATUS ");
			query1.setParameter("COMPANY", cnameupdate);
			query1.setParameter("PRIORITY", priorityupdate);
			query1.setParameter("SEVERITY", severityupdate);
			query1.setParameter("DAYS", daysupdate);
			query1.setParameter("HOURS", hoursupdate);
			query1.setParameter("MINUTES", minutesupdate);
			query1.setParameter("SECONDS", secondsupdate);
			query1.setParameter("SR_NO", sr_no);
			query1.setParameter("HOLDTIME_STATUS", checkStatusupdate);
			query1.setParameter("CALENDER_OR_WEEK_STATUS", checkcalenderstatusupdate);
			
			List <sla_master> data =  query1.list();
			System.out.println("data:"+data);
			if (!data.isEmpty()) {
				
				  System.out.println("   in if block  :::::");

				status = "success";
			} 
			
			else if(data.isEmpty())
			{
				
            System.out.println("else   in if block  :::::");
            
              System.out.println("SRNO     "+ sr_no);
             
				Query queryfordublicate = getSession().createQuery("from sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and SR_NO !=:SR_NO ");
				queryfordublicate.setParameter("COMPANY", cnameupdate);
				queryfordublicate.setParameter("PRIORITY", priorityupdate);
				queryfordublicate.setParameter("SEVERITY", severityupdate); 
				queryfordublicate.setParameter("SR_NO", sr_no);
				/*
				 * queryfordublicate.setParameter("HOLDTIME_STATUS", checkStatusupdate);
				 * 
				 * queryfordublicate.setParameter("DAYS", daysupdate);
				 * queryfordublicate.setParameter("HOURS", hoursupdate);
				 * queryfordublicate.setParameter("MINUTES", minutesupdate);
				 * queryfordublicate.setParameter("SECONDS", secondsupdate);
				 */
				
				List <sla_master> data3 =  queryfordublicate.list();
				System.out.println("data:"+data3);
				if (!data3.isEmpty()) {
					
					status = "duplicate";
				}
				else {
					
					int numberOfDays=0;
					int numberOfHours=0;
					int numberOfMinutes=0;
					int numberOfSeconds=0;
				int elapsedtimes=0;
				int targettime=0;
				
				
				
					if(daysupdate!=0)
					{
						numberOfDays=daysupdate*86400;
					
					}
					else
					{
						daysupdate=0;
					}
					
					if(hoursupdate!=0)
					{
						numberOfHours=hoursupdate*60*60;
						
					}
					else
					{
						hoursupdate=0;
					}
					if(minutesupdate!=0)
					{
						numberOfMinutes=minutesupdate*60;
						
					}
					else
					{
						minutesupdate=0;
					}
					if(secondsupdate!=0)
					{
						secondsupdate=secondsupdate;
						
					}
					else
					{
						secondsupdate=0;
					}
					elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+secondsupdate;

					String elapsedTimeFinal=String.valueOf(elapsedtimes);
					String Response_SLA_Target_Time = "";
					String SLA_Target_Days = "";
					String SLA_Target_Hours = "";
					String SLA_Target_Minutes = "";
					String SLA_Target_Seconds = "";

					if (daysupdate != 0) {
						SLA_Target_Days = Integer.toString(daysupdate) + " Days ";
					}
					if (hoursupdate != 0) {
						SLA_Target_Hours = Integer.toString(hoursupdate) + " Hours ";
					}
					if (minutesupdate != 0) {
						SLA_Target_Minutes = Integer.toString(minutesupdate) + " Minutes ";
					}
					if (secondsupdate != 0) {
						SLA_Target_Seconds = Integer.toString(secondsupdate) + " Seconds ";
					}
					
				
					Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
					
					
					
					Query query = sessionFactory.getCurrentSession().createQuery(
							"update sla_master set DAYS = :DAYS,HOURS = :HOURS,MINUTES = :MINUTES,SECONDS = :SECONDS,PRIORITY_NAME = :PRIORITY_NAME,SEVERITY_NAME = :SEVERITY_NAME , HOLDTIME_STATUS=:HOLDTIME_STATUS ,SLA_TARGET_DURATION='"+Response_SLA_Target_Time+"' ,SLA_TARGET_ELAPSED_TIME='"+elapsedTimeFinal+"' ,CALENDER_OR_WEEK_STATUS=:CALENDER_OR_WEEK_STATUS where COMPANY = :COMPANY and SR_NO=:SR_NO ");
					
					query.setParameter("DAYS", daysupdate);
					query.setParameter("HOURS", hoursupdate);
					query.setParameter("MINUTES", minutesupdate);
					query.setParameter("SECONDS", secondsupdate);
					query.setParameter("PRIORITY_NAME", priorityupdate);
					query.setParameter("SEVERITY_NAME", severityupdate);
					query.setParameter("COMPANY", cnameupdate);
					query.setParameter("SR_NO", sr_no);
					query.setParameter("HOLDTIME_STATUS", checkStatusupdate);
					query.setParameter("CALENDER_OR_WEEK_STATUS", checkcalenderstatusupdate);
				
					
					int i = query.executeUpdate();
                   
				
					
					if (i == 0) {
						status = "error";
					} else {

						status = "success";
					}
					
					
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return status;
	}

	@Override
	public String deleteSLA(int sr_no) {

		System.out.println("Inside SLADaoImpl deleteSLA method");
		String status = null;

		try {

			System.out.println("inside deleteSLA");
			int i = sessionFactory.getCurrentSession()
					.createQuery("delete from sla_master where SR_NO = '" + sr_no + "'").executeUpdate();
			if (i == 0) {
				status = "error";
			} else {

				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return status;
	}

	@Override
	public String SubmitSLADetails(String priority, int days, int hours, int minutes, int seconds,String severity,String cname, String slastatus,String checkcalenderweekid) {

		System.out.println("Inside SLADaoImpl SubmitSLADetails method");
		String status = null;
		System.out.println("checkcalenderweekid   :: " + checkcalenderweekid);

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			System.out.println("priority: " + priority + "days: " + days + "hours: " + hours + "minutes: " + minutes
					+ "seconds: " + seconds+"Cname:"+cname+"severity:"+severity);

			System.out.println("inside SubmitSLADetails");
     //Adding Sr_no
      
      Criteria crit = sessionFactory.getCurrentSession().createCriteria(sla_master.class)
          .setProjection(Projections.max("SR_NO"));
      Integer srno1 = (Integer) crit.uniqueResult();
      int srno = 0;
      System.out.println(" SRNO IS: " + srno1);

      if (srno1 != null) {
        srno = srno1.intValue();
        srno = srno + 1;
        System.out.println("IN IF SRNO IS: " + srno);
      } else {
        srno = 1;
        System.out.println("IN ELSE SRNO IS: " + srno);
      }
      
      
			Query query = getSession().createQuery("from sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY");
			query.setParameter("COMPANY", cname);
			query.setParameter("PRIORITY", priority);
			query.setParameter("SEVERITY", severity);

			
			int numberOfDays=0;
			int numberOfHours=0;
			int numberOfMinutes=0;
			int numberOfSeconds=0;

		
			
		int elapsedtimes=0;
		int targettime=0;
		
		
		
			if(days!=0)
			{
				numberOfDays=days*86400;
			
			}
			else
			{
				days=0;
			}
			
			if(hours!=0)
			{
				numberOfHours=hours*60*60;
				
			}
			else
			{
				hours=0;
			}
			if(minutes!=0)
			{
				numberOfMinutes=minutes*60;
				
			}
			else
			{
				minutes=0;
			}
			if(seconds!=0)
			{
				seconds=seconds;
				
			}
			else
			{
				seconds=0;
			}
			elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+seconds;
			String elapsedTimeFinal=String.valueOf(elapsedtimes);
			String Response_SLA_Target_Time = "";
			String SLA_Target_Days = "";
			String SLA_Target_Hours = "";
			String SLA_Target_Minutes = "";
			String SLA_Target_Seconds = "";

			if (days != 0) {
				SLA_Target_Days = Integer.toString(days) + " Days ";
			}
			if (hours != 0) {
				SLA_Target_Hours = Integer.toString(hours) + " Hours ";
			}
			if (minutes != 0) {
				SLA_Target_Minutes = Integer.toString(minutes) + " Minutes ";
			}
			if (seconds != 0) {
				SLA_Target_Seconds = Integer.toString(seconds) + " Seconds ";
			}
			/////////////// Response SLA TARGET TIME Starts//////
			Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
			
				System.out.println("elapsedtimes in second"+elapsedtimes);
				System.out.println("Response_SLA_Target_Time in days"+Response_SLA_Target_Time);
				String finalelapsedTime=String.valueOf(elapsedtimes);
				
			sla_master data = (sla_master) query.uniqueResult();
			System.out.println("data:"+data);
			if (data != null) {
				status = "duplicate";
			} else {
				sla_master sla_master1 = new sla_master();

				sla_master1.setPRIORITY_NAME(priority);
				sla_master1.setCOMPANY(cname);
				sla_master1.setSEVERITY_NAME(severity);
				sla_master1.setDAYS(days);
				sla_master1.setHOURS(hours);
				sla_master1.setMINUTES(minutes);
				sla_master1.setSECONDS(seconds);
				sla_master1.setSR_NO(srno);
				sla_master1.setHOLDTIME_STATUS(slastatus);
				sla_master1.setSLA_TARGET_DURATION(Response_SLA_Target_Time);
				sla_master1.setSLA_TARGET_ELAPSED_TIME(finalelapsedTime);
				sla_master1.setCALENDER_OR_WEEK_STATUS(checkcalenderweekid);
				sessionFactory.getCurrentSession().persist(sla_master1);
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}
	@Override
	public JSONArray getSeverityName(String company) {
		System.out.println("Inside SLADaoImpl getPriorityName method");

		JSONArray array = null;

		JSONArray array1 = null;
//		String db_username = null
//		String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			
			Query query = getSession().createQuery("select distinct SEVERITY from severitymaster where COMPANY=:COMPANY ORDER BY SEVERITY asc");
			query.setParameter("COMPANY", company);
			List Result = query.list();
//			query.setParameter("u", username);
			array1 = new JSONArray();
			
			
			for (int i = 0; i < Result.size(); i++) {
				array = new JSONArray();
				array.put(Result.get(i));
				array1.put(array);
			}

//			for (severitymaster sourceDrive : dataList) {
//				System.out.println("array = " + sourceDrive.getSEVERITY());
//				array = new JSONArray();

			//	array.put(sourceDrive.getSEVERITY());
//				db_username = sourceDrive.getUSERNAME();
//				db_usertype=  sourceDrive.getUSERTYPE();
			//	array1.put(array);

			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}
	@Override
	public String SubmitResponseSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname,String slatime) {
		System.out.println("Inside SLADaoImpl SubmitSLADetails method");
		String status = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			System.out.println("priority: " + priority + "days: " + days + "hours: " + hours + "minutes: " + minutes
					+ "seconds: " + seconds+"Cname:"+cname+"severity:"+severity);

			System.out.println("inside SubmitSLADetails");
     //Adding Sr_no
      
      Criteria crit = sessionFactory.getCurrentSession().createCriteria(responseslamaster.class)
          .setProjection(Projections.max("SR_NO"));
      Integer srno1 = (Integer) crit.uniqueResult();
      int srno = 0;
      System.out.println(" SRNO IS: " + srno1);

      if (srno1 != null) {
        srno = srno1.intValue();
        srno = srno + 1;
        System.out.println("IN IF SRNO IS: " + srno);
      } else {
        srno = 1;
        System.out.println("IN ELSE SRNO IS: " + srno);
      }
      
      
			Query query = getSession().createQuery("from responseslamaster where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY");
			query.setParameter("COMPANY", cname);
			query.setParameter("PRIORITY", priority);
			query.setParameter("SEVERITY", severity);

			
			responseslamaster data = (responseslamaster) query.uniqueResult();
			System.out.println("data:"+data);
		
			int numberOfDays;
			int numberOfHours;
			int numberOfMinutes;
			int numberOfSeconds;

			numberOfDays =0 ;
			numberOfHours =0 ;
			numberOfMinutes = 0;
			numberOfSeconds =0 ;
			
		int elapsedtimes=0;
		int targettime=0;
		
		
		
			if(days!=0)
			{
				numberOfDays=days*86400;
			
			}
			else
			{
				days=0;
			}
			
			if(hours!=0)
			{
				numberOfHours=hours*60*60;
				
			}
			else
			{
				hours=0;
			}
			if(minutes!=0)
			{
				numberOfMinutes=minutes*60;
				
			}
			else
			{
				minutes=0;
			}
			if(seconds!=0)
			{
				seconds=seconds;
				
			}
			else
			{
				seconds=0;
			}
			elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+seconds;
			String elapsedTimeFinal=String.valueOf(elapsedtimes);
			String Response_SLA_Target_Time = "";
			String SLA_Target_Days = "";
			String SLA_Target_Hours = "";
			String SLA_Target_Minutes = "";
			String SLA_Target_Seconds = "";

			if (days != 0) {
				SLA_Target_Days = Integer.toString(days) + " Days ";
			}
			if (hours != 0) {
				SLA_Target_Hours = Integer.toString(hours) + " Hours ";
			}
			if (minutes != 0) {
				SLA_Target_Minutes = Integer.toString(minutes) + " Minutes ";
			}
			if (seconds != 0) {
				SLA_Target_Seconds = Integer.toString(seconds) + " Seconds ";
			}
			/////////////// Response SLA TARGET TIME Starts//////
			Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
			
				System.out.println("elapsedtimes in second"+elapsedtimes);
				System.out.println("Response_SLA_Target_Time in days"+Response_SLA_Target_Time);
			if (data != null) {
				status = "duplicate";
			} else {
				
				
				responseslamaster sla_master1 = new responseslamaster();

				sla_master1.setPRIORITY_NAME(priority);
				sla_master1.setCOMPANY(cname);
				sla_master1.setSEVERITY_NAME(severity);
				sla_master1.setDAYS(days);
				sla_master1.setHOURS(hours);
				sla_master1.setMINUTES(minutes);
				sla_master1.setSECONDS(seconds);
				sla_master1.setSR_NO(srno);
				sla_master1.setRESPONSE_SLA_TARGET_DURATION(Response_SLA_Target_Time);
				sla_master1.setSLA_TARGET_ELAPSED_TIME(elapsedTimeFinal);
				sla_master1.setRESPONSE_SLA_CALENDER_WEEK_STATUS(slatime);
				sessionFactory.getCurrentSession().persist(sla_master1);
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public JSONArray getResponseSLAMasterListing(String userlist) {

		System.out.println("Inside MailConfigDaoImpl SLAMasterListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
//	String db_username = null;
//	String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			List<responseslamaster> dataList = getSession().createQuery("from responseslamaster").list();

			System.out.println("datalist="+dataList);
			array1 = new JSONArray();
			for (responseslamaster sourceDrive : dataList) {

							srno = srno + 1;
				System.out.println("array = " + sourceDrive.getCOMPANY());
				
				array = new JSONArray();

				array.put(srno);
				array.put(
						"<button class='btn btn-info' id='Editbtn' onclick='EditSLA(\"" + sourceDrive.getPRIORITY_NAME()
						+ "\",\"" + sourceDrive.getDAYS() + "\",\"" + sourceDrive.getHOURS() + "\",\""
						+ sourceDrive.getMINUTES() + "\",\"" + sourceDrive.getSECONDS()
						+ "\",\"" + sourceDrive.getCOMPANY()
							+"\",\"" + sourceDrive.getSEVERITY_NAME() 
							+"\",\"" + sourceDrive.getSR_NO()+"\",\"" + sourceDrive.getRESPONSE_SLA_CALENDER_WEEK_STATUS()+"\")'"+ "><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
		array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteSLA(\""
				+ sourceDrive.getSR_NO() + "\" )'><i class='fa fa-trash'></i></button>");
		array.put(sourceDrive.getCOMPANY());
		
		array.put(sourceDrive.getPRIORITY_NAME());
		array.put(sourceDrive.getSEVERITY_NAME());
		array.put(sourceDrive.getDAYS());
		array.put(sourceDrive.getHOURS());
		array.put(sourceDrive.getMINUTES());
		array.put(sourceDrive.getSECONDS());
		array.put(sourceDrive.getSLA_TARGET_ELAPSED_TIME());
		array.put(sourceDrive.getRESPONSE_SLA_TARGET_DURATION());	
		array.put(sourceDrive.getRESPONSE_SLA_CALENDER_WEEK_STATUS());
		
				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return array1;
	}

	@Override
	public String UpdateResponseSLADetails(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate,String cweek) {
		System.out.println("Inside SLADaoImpl UpdateSLADetails method");
		int days=0;
		int hours=0;
		int minutes=0;
		int seconds=0;
		String status = null;

		try {

			System.out.println("inside UpdateSLADetails");
			
			
//			System.out.println("PRIORITY  " + priorityupdate);
//			System.out.println("SEVERITY  "+ severityupdate);
			System.out.println("cweek  sdffdsf"+ cweek);
			
			Query query1 = getSession().createQuery("from responseslamaster where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and DAYS = :DAYS and HOURS = :HOURS and MINUTES = :MINUTES and SECONDS = :SECONDS and SR_NO=:SR_NO and RESPONSE_SLA_CALENDER_WEEK_STATUS=:RESPONSE_SLA_CALENDER_WEEK_STATUS");
			query1.setParameter("COMPANY", cnameupdate);
			query1.setParameter("PRIORITY", priorityupdate);
			query1.setParameter("SEVERITY", severityupdate);
			query1.setParameter("DAYS", daysupdate);
			query1.setParameter("HOURS", hoursupdate);
			query1.setParameter("MINUTES", minutesupdate);
			query1.setParameter("SECONDS", secondsupdate);
			query1.setParameter("SR_NO", sr_no);
			query1.setParameter("RESPONSE_SLA_CALENDER_WEEK_STATUS", cweek);
			
			List <responseslamaster> data =  query1.list();
			System.out.println("data:"+data);
			if (!data.isEmpty()) {
				
				  System.out.println("   in if block  :::::");

				status = "success";
			} 
			
			else if(data.isEmpty())
			{
				
            System.out.println("else   in if block  :::::");
            
              System.out.println("SRNO     "+ sr_no);
             
				Query queryfordublicate = getSession().createQuery("from responseslamaster where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and SR_NO !=:SR_NO ");
				queryfordublicate.setParameter("COMPANY", cnameupdate);
				queryfordublicate.setParameter("PRIORITY", priorityupdate);
				queryfordublicate.setParameter("SEVERITY", severityupdate); 
				queryfordublicate.setParameter("SR_NO", sr_no);
			
				
				List <responseslamaster> data3 =  queryfordublicate.list();
				System.out.println("data:"+data3);
				if (!data3.isEmpty()) {
					
					status = "duplicate";
				}
				else {
					

					int numberOfDays;
					int numberOfHours;
					int numberOfMinutes;
					int numberOfSeconds;

					numberOfDays =0 ;
					numberOfHours =0 ;
					numberOfMinutes = 0;
					numberOfSeconds =0 ;
					
				int elapsedtimes=0;
				int targettime=0;
				
				
				
					if(daysupdate!=0)
					{
						numberOfDays=daysupdate*86400;
					
					}
					else
					{
						daysupdate=0;
					}
					
					if(hoursupdate!=0)
					{
						numberOfHours=hoursupdate*60*60;
						
					}
					else
					{
						hoursupdate=0;
					}
					if(minutesupdate!=0)
					{
						numberOfMinutes=minutesupdate*60;
						
					}
					else
					{
						minutesupdate=0;
					}
					if(secondsupdate!=0)
					{
						secondsupdate=secondsupdate;
						
					}
					else
					{
						secondsupdate=0;
					}
					elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+secondsupdate;
//					System.out.println(" elapsed time "+elapsedtimes);
//					System.out.println("fghfghh gh "+daysupdate);
//					System.out.println("dfgdfgd fgfd gfg"+hoursupdate);
//					System.out.println("fghfghghg fgh"+minutesupdate);
//					System.out.println("ftghfghg gfhg "+secondsupdate);
					String elapsedTimeFinal=String.valueOf(elapsedtimes);
					String Response_SLA_Target_Time = "";
					String SLA_Target_Days = "";
					String SLA_Target_Hours = "";
					String SLA_Target_Minutes = "";
					String SLA_Target_Seconds = "";

					if (daysupdate != 0) {
						SLA_Target_Days = Integer.toString(daysupdate) + " Days ";
					}
					if (hoursupdate != 0) {
						SLA_Target_Hours = Integer.toString(hoursupdate) + " Hours ";
					}
					if (minutesupdate != 0) {
						SLA_Target_Minutes = Integer.toString(minutesupdate) + " Minutes ";
					}
					if (secondsupdate != 0) {
						SLA_Target_Seconds = Integer.toString(secondsupdate) + " Seconds ";
					}
					
					/////////////// Response SLA TARGET TIME Starts//////
					Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
					
						
					System.out.println("dgdgggdrfg"+cweek);
					System.out.println(" response sla target in minuite"+Response_SLA_Target_Time);
					Query query = sessionFactory.getCurrentSession().createQuery(
							"update responseslamaster set DAYS = :DAYS,HOURS = :HOURS,MINUTES = :MINUTES,SECONDS = :SECONDS,PRIORITY_NAME = :PRIORITY_NAME,SEVERITY_NAME = :SEVERITY_NAME,RESPONSE_SLA_TARGET_DURATION=:TARGETTIME,SLA_TARGET_ELAPSED_TIME=:SECOND,RESPONSE_SLA_CALENDER_WEEK_STATUS=:RESPONSE_SLA_CALENDER_WEEK_STATUS  where COMPANY = :COMPANY and SR_NO=:SR_NO ");
					
					query.setParameter("DAYS", daysupdate);	
					query.setParameter("HOURS", hoursupdate);
					query.setParameter("MINUTES", minutesupdate);
					query.setParameter("SECONDS", secondsupdate);
					query.setParameter("PRIORITY_NAME", priorityupdate);
					query.setParameter("SEVERITY_NAME", severityupdate);
					
					query.setParameter("SECOND",elapsedTimeFinal);
					query.setParameter("TARGETTIME", Response_SLA_Target_Time);
					query.setParameter("COMPANY", cnameupdate);
					query.setParameter("RESPONSE_SLA_CALENDER_WEEK_STATUS", cweek);
					
					query.setParameter("SR_NO", sr_no);
					
					int i = query.executeUpdate();
                   
				
					
					if (i == 0) {
						status = "error";
					} else {

						status = "success";
					}
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return status;
	}

	@Override
	public String deleteResponseSLA(int sr_no) {

		System.out.println("Inside SLADaoImpl responseslamaster method");
		String status = null;

		try {

			System.out.println("inside deleteSLA");
			int i = sessionFactory.getCurrentSession()
					.createQuery("delete from responseslamaster where SR_NO = '" + sr_no + "'").executeUpdate();
			if (i == 0) {
				status = "error";
			} else {

				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

		return status;
	}
	@Override
	public JSONArray getServiceRequestHoldTime(String hold) {
		System.out.println("Inside SLADaoImpl getHoldTimeDetails method");

		JSONArray array = null;

		JSONArray array1 = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);

			List<hold_time> dataList = getSession().createQuery("from hold_time").list();

			array1 = new JSONArray();
			for (hold_time sourceDrive : dataList) {
				System.out.println("array = " + sourceDrive.getHOLD_STATUS());
				array = new JSONArray();

				array.put(sourceDrive.getHOLD_STATUS());

				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}


		return array1;
	}

	@Override
	public JSONArray ServiceRequestSLAMasterListing(String userlist) {


		System.out.println("Inside MailConfigDaoImpl ServiceRequestSLAMasterListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;


		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			List<service_request_sla_master> dataList = getSession().createQuery("from service_request_sla_master").list();
//			query.setParameter("u", username);
			System.out.println("datalist="+dataList);
			array1 = new JSONArray();
			for (service_request_sla_master sourceDrive : dataList) {

							srno = srno + 1;
				System.out.println("array = " + sourceDrive.getCOMPANY());
				
				array = new JSONArray();

				array.put(srno);
				array.put(
						"<button class='btn btn-info' id='Editbtn' onclick='EditSLA(\"" + sourceDrive.getPRIORITY_NAME()
						+ "\",\"" + sourceDrive.getDAYS() + "\",\"" + sourceDrive.getHOURS() + "\",\""
						+ sourceDrive.getMINUTES() + "\",\"" + sourceDrive.getSECONDS()
						+ "\",\"" + sourceDrive.getCOMPANY()
							+"\",\"" + sourceDrive.getSEVERITY_NAME() 
							+"\",\"" + sourceDrive.getSR_NO() 
							+"\",\"" + sourceDrive.getHOLDTIME_STATUS()+ "\",\""+sourceDrive.getSERVICE_SLA_CALENDER_WEEK_STATUS()+"\" )'"
							+ "><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
		array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteSLA(\""
				+ sourceDrive.getSR_NO() + "\" )'><i class='fa fa-trash'></i></button>");
		array.put(sourceDrive.getCOMPANY());
		
		array.put(sourceDrive.getPRIORITY_NAME());
		array.put(sourceDrive.getSEVERITY_NAME());
		array.put(sourceDrive.getDAYS());
		array.put(sourceDrive.getHOURS());
		array.put(sourceDrive.getMINUTES());
		array.put(sourceDrive.getSECONDS());
		array.put(sourceDrive.getHOLDTIME_STATUS());
		array.put(sourceDrive.getSERVICE_REQUEST_TARGET_TIME());
		array.put(sourceDrive.getSERVICE_REQUEST_TARGET_ELAPSED_TIME());
		array.put(sourceDrive.getSERVICE_SLA_CALENDER_WEEK_STATUS());
		array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//	return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	
	}
		@Override
	public String deleteServiceRequestSLA(int sr_no) {


			System.out.println("Inside SLADaoImpl deleteSLA method");
			String status = null;

			try {

				System.out.println("inside deleteSLA");
				int i = sessionFactory.getCurrentSession()
						.createQuery("delete from service_request_sla_master where SR_NO = '" + sr_no + "'").executeUpdate();
				if (i == 0) {
					status = "error";
				} else {

					status = "success";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return status;
		
	}

	@Override
	public String UpdateServiceRequestSLADetails(String priorityupdate, int daysupdate, int hoursupdate,
			int minutesupdate, int secondsupdate, int sr_no, String cnameupdate, String severityupdate,
			String checkStatusupdate,String slaweek) {


		System.out.println("Inside SLADaoImpl UpdateServiceRequestSLADetails method");
		String status = null;

		try {

			System.out.println("inside UpdateServiceRequestSLADetails");
			
			
			System.out.println("PRIORITY  " + priorityupdate);
			System.out.println("SEVERITY  "+ severityupdate);
			System.out.println("PRIORITY  "+ severityupdate);
			
			
			Query query1 = getSession().createQuery("from service_request_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and DAYS = :DAYS and HOURS = :HOURS and MINUTES = :MINUTES and SECONDS = :SECONDS and SR_NO=:SR_NO and HOLDTIME_STATUS=:HOLDTIME_STATUS and SERVICE_SLA_CALENDER_WEEK_STATUS=:SERVICE_SLA_CALENDER_WEEK_STATUS");
			query1.setParameter("COMPANY", cnameupdate);
			query1.setParameter("PRIORITY", priorityupdate);
			query1.setParameter("SEVERITY", severityupdate);
			query1.setParameter("DAYS", daysupdate);
			query1.setParameter("HOURS", hoursupdate);
			query1.setParameter("MINUTES", minutesupdate);
			query1.setParameter("SECONDS", secondsupdate);
			query1.setParameter("SR_NO", sr_no);
			query1.setParameter("HOLDTIME_STATUS", checkStatusupdate);
			query1.setParameter("SERVICE_SLA_CALENDER_WEEK_STATUS", slaweek);
			List <service_request_sla_master> data =  query1.list();
			System.out.println("data:"+data);
			if (!data.isEmpty()) {
				
				  System.out.println("   in if block  :::::");

				status = "success";
			} 
			
			else if(data.isEmpty())
			{
				
            System.out.println("else   in if block  :::::");
            
              System.out.println("SRNO     "+ sr_no);
             
				Query queryfordublicate = getSession().createQuery("from service_request_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and SR_NO !=:SR_NO ");
				queryfordublicate.setParameter("COMPANY", cnameupdate);
				queryfordublicate.setParameter("PRIORITY", priorityupdate);
				queryfordublicate.setParameter("SEVERITY", severityupdate); 
				queryfordublicate.setParameter("SR_NO", sr_no);
				
				/*
				 * queryfordublicate.setParameter("HOLDTIME_STATUS", checkStatusupdate);
				 * 
				 * queryfordublicate.setParameter("DAYS", daysupdate);
				 * queryfordublicate.setParameter("HOURS", hoursupdate);
				 * queryfordublicate.setParameter("MINUTES", minutesupdate);
				 * queryfordublicate.setParameter("SECONDS", secondsupdate);
				 */
				
				List <service_request_sla_master> data3 =  queryfordublicate.list();
				System.out.println("data:"+data3);
				if (!data3.isEmpty()) {
					
					status = "duplicate";
				}
				else {

					int numberOfDays;
					int numberOfHours;
					int numberOfMinutes;
					int numberOfSeconds;

					numberOfDays =0 ;
					numberOfHours =0 ;
					numberOfMinutes = 0;
					numberOfSeconds =0 ;
					
				int elapsedtimes=0;
				int targettime=0;
				
				
				
					if(daysupdate!=0)
					{
						numberOfDays=daysupdate*86400;
					
					}
					else
					{
						daysupdate=0;
					}
					
					if(hoursupdate!=0)
					{
						numberOfHours=hoursupdate*60*60;
						
					}
					else
					{
						hoursupdate=0;
					}
					if(minutesupdate!=0)
					{
						numberOfMinutes=minutesupdate*60;
						
					}
					else
					{
						minutesupdate=0;
					}
					if(secondsupdate!=0)
					{
						secondsupdate=secondsupdate;
						
					}
					else
					{
						secondsupdate=0;
					}
					elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+secondsupdate;

					String elapsedTimeFinal=String.valueOf(elapsedtimes);
					String Response_SLA_Target_Time = "";
					String SLA_Target_Days = "";
					String SLA_Target_Hours = "";
					String SLA_Target_Minutes = "";
					String SLA_Target_Seconds = "";

					if (daysupdate != 0) {
						SLA_Target_Days = Integer.toString(daysupdate) + " Days ";
					}
					if (hoursupdate != 0) {
						SLA_Target_Hours = Integer.toString(hoursupdate) + " Hours ";
					}
					if (minutesupdate != 0) {
						SLA_Target_Minutes = Integer.toString(minutesupdate) + " Minutes ";
					}
					if (secondsupdate != 0) {
						SLA_Target_Seconds = Integer.toString(secondsupdate) + " Seconds ";
					}
					
				
					Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
					
					
					Query query = sessionFactory.getCurrentSession().createQuery(
							"update service_request_sla_master set DAYS = :DAYS,HOURS = :HOURS,MINUTES = :MINUTES,SECONDS = :SECONDS,PRIORITY_NAME = :PRIORITY_NAME,SEVERITY_NAME = :SEVERITY_NAME , HOLDTIME_STATUS=:HOLDTIME_STATUS  , SERVICE_REQUEST_TARGET_ELAPSED_TIME='"+elapsedTimeFinal+"' ,SERVICE_REQUEST_TARGET_TIME='"+Response_SLA_Target_Time+"',SERVICE_SLA_CALENDER_WEEK_STATUS=:SERVICE_SLA_CALENDER_WEEK_STATUS   where COMPANY = :COMPANY and   SR_NO=:SR_NO  ");
					
					query.setParameter("DAYS", daysupdate);
					query.setParameter("HOURS", hoursupdate);
					query.setParameter("MINUTES", minutesupdate);
					query.setParameter("SECONDS", secondsupdate);
					query.setParameter("PRIORITY_NAME", priorityupdate);
					query.setParameter("SEVERITY_NAME", severityupdate);
					query.setParameter("COMPANY", cnameupdate);
					query.setParameter("SR_NO", sr_no);
					query.setParameter("HOLDTIME_STATUS", checkStatusupdate);
					query.setParameter("SERVICE_SLA_CALENDER_WEEK_STATUS", slaweek);
				
					int i = query.executeUpdate();
                   
				
					
					if (i == 0) {
						status = "error";
					} else {

						status = "success";
					}
					
					
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return status;
	
	}

	@Override
	public String SubmitServiceRequestSLADetails(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname, String slastatus,String slaweek) {


		System.out.println("Inside SLADaoImpl SubmitServiceRequestSLADetails method");
		String status = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			System.out.println("priority: " + priority + "days: " + days + "hours: " + hours + "minutes: " + minutes
					+ "seconds: " + seconds+"Cname:"+cname+"severity:"+severity);

			System.out.println("inside SubmitSLADetails");
     //Adding Sr_no
      
      Criteria crit = sessionFactory.getCurrentSession().createCriteria(service_request_sla_master.class)
          .setProjection(Projections.max("SR_NO"));
      Integer srno1 = (Integer) crit.uniqueResult();
      int srno = 0;
      System.out.println(" SRNO IS: " + srno1);

      if (srno1 != null) {
        srno = srno1.intValue();
        srno = srno + 1;
        System.out.println("IN IF SRNO IS: " + srno);
      } else {
        srno = 1;
        System.out.println("IN ELSE SRNO IS: " + srno);
      }
      
      
			Query query = getSession().createQuery("from service_request_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY");
			query.setParameter("COMPANY", cname);
			query.setParameter("PRIORITY", priority);
			query.setParameter("SEVERITY", severity);
	
			service_request_sla_master data = (service_request_sla_master) query.uniqueResult();
			System.out.println("data:"+data);
			int numberOfDays;
			int numberOfHours;
			int numberOfMinutes;
			int numberOfSeconds;

			numberOfDays =0 ;
			numberOfHours =0 ;
			numberOfMinutes = 0;
			numberOfSeconds =0 ;
			
		int elapsedtimes=0;
		int targettime=0;
		
		
		
			if(days!=0)
			{
				numberOfDays=days*86400;
			
			}
			else
			{
				days=0;
			}
			
			if(hours!=0)
			{
				numberOfHours=hours*60*60;
				
			}
			else
			{
				hours=0;
			}
			if(minutes!=0)
			{
				numberOfMinutes=minutes*60;
				
			}
			else
			{
				minutes=0;
			}
			if(seconds!=0)
			{
				seconds=seconds;
				
			}
			else
			{
				seconds=0;
			}
			elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+seconds;
			String elapsedTimeFinal=String.valueOf(elapsedtimes);
			String Response_SLA_Target_Time = "";
			String SLA_Target_Days = "";
			String SLA_Target_Hours = "";
			String SLA_Target_Minutes = "";
			String SLA_Target_Seconds = "";

			if (days != 0) {
				SLA_Target_Days = Integer.toString(days) + " Days ";
			}
			if (hours != 0) {
				SLA_Target_Hours = Integer.toString(hours) + " Hours ";
			}
			if (minutes != 0) {
				SLA_Target_Minutes = Integer.toString(minutes) + " Minutes ";
			}
			if (seconds != 0) {
				SLA_Target_Seconds = Integer.toString(seconds) + " Seconds ";
			}
			/////////////// Response SLA TARGET TIME Starts//////
			Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
			
				System.out.println("elapsedtimes in second"+elapsedtimes);
				System.out.println("Response_SLA_Target_Time in days"+Response_SLA_Target_Time);
				String finalelapsedTime=String.valueOf(elapsedtimes);
			
			if (data != null) {
				status = "duplicate";
			} else {
				service_request_sla_master sla_master1 = new service_request_sla_master();
				sla_master1.setPRIORITY_NAME(priority);
				sla_master1.setCOMPANY(cname);
				sla_master1.setSEVERITY_NAME(severity);
				sla_master1.setDAYS(days);
				sla_master1.setHOURS(hours);
				sla_master1.setMINUTES(minutes);
				sla_master1.setSECONDS(seconds);
				sla_master1.setSR_NO(srno);
				sla_master1.setHOLDTIME_STATUS(slastatus);
				sla_master1.setSERVICE_REQUEST_TARGET_ELAPSED_TIME(finalelapsedTime);
				sla_master1.setSERVICE_REQUEST_TARGET_TIME(Response_SLA_Target_Time);
				sla_master1.setSERVICE_SLA_CALENDER_WEEK_STATUS(slaweek);
				sessionFactory.getCurrentSession().persist(sla_master1);
				
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	
	}
	@Override
	public String SubmitResponseSLADetailsForSR(String priority, int days, int hours, int minutes, int seconds,
			String severity, String cname,String slaweek) {
		System.out.println("Inside SLADaoImpl SubmitSLADetails method");
		String status = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			System.out.println("priority: " + priority + "days: " + days + "hours: " + hours + "minutes: " + minutes
					+ "seconds: " + seconds+"Cname:"+cname+"severity:"+severity);

			System.out.println("inside SubmitSLADetails");
     //Adding Sr_no
      
      Criteria crit = sessionFactory.getCurrentSession().createCriteria(service_request_response_sla_master.class)
          .setProjection(Projections.max("SR_NO"));
      Integer srno1 = (Integer) crit.uniqueResult();
      int srno = 0;
      System.out.println(" SRNO IS: " + srno1);

      if (srno1 != null) {
        srno = srno1.intValue();
        srno = srno + 1;
        System.out.println("IN IF SRNO IS: " + srno);
      } else {
        srno = 1;
        System.out.println("IN ELSE SRNO IS: " + srno);
      }
      
      
			Query query = getSession().createQuery("from service_request_response_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY");
			query.setParameter("COMPANY", cname);
			query.setParameter("PRIORITY", priority);
			query.setParameter("SEVERITY", severity);
			service_request_response_sla_master data = (service_request_response_sla_master) query.uniqueResult();
			System.out.println("data:"+data);
		
			int numberOfDays;
			int numberOfHours;
			int numberOfMinutes;
			int numberOfSeconds;

			numberOfDays =0 ;
			numberOfHours =0 ;
			numberOfMinutes = 0;
			numberOfSeconds =0 ;
			
		int elapsedtimes=0;
		int targettime=0;
			if(days!=0)
			{
				numberOfDays=days*86400;
			
			}
			else
			{
				days=0;
			}
			
			if(hours!=0)
			{
				numberOfHours=hours*60*60;
				
			}
			else
			{
				hours=0;
			}
			if(minutes!=0)
			{
				numberOfMinutes=minutes*60;
				
			}
			else
			{
				minutes=0;
			}
			if(seconds!=0)
			{
				seconds=seconds;
				
			}
			else
			{
				seconds=0;
			}
			elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+seconds;
			String elapsedTimeFinal=String.valueOf(elapsedtimes);
			String Response_SLA_Target_Time = "";
			String SLA_Target_Days = "";
			String SLA_Target_Hours = "";
			String SLA_Target_Minutes = "";
			String SLA_Target_Seconds = "";

			if (days != 0) {
				SLA_Target_Days = Integer.toString(days) + " Days ";
			}
			if (hours != 0) {
				SLA_Target_Hours = Integer.toString(hours) + " Hours ";
			}
			if (minutes != 0) {
				SLA_Target_Minutes = Integer.toString(minutes) + " Minutes ";
			}
			if (seconds != 0) {
				SLA_Target_Seconds = Integer.toString(seconds) + " Seconds ";
			}
			/////////////// Response SLA TARGET TIME Starts//////
			Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
			
				System.out.println("elapsedtimes in second"+elapsedtimes);
				System.out.println("Response_SLA_Target_Time in days"+Response_SLA_Target_Time);
			if (data != null) {
				status = "duplicate";
			} else {
				
				
				service_request_response_sla_master sla_master1 = new service_request_response_sla_master();

				sla_master1.setPRIORITY_NAME(priority);
				sla_master1.setCOMPANY(cname);
				sla_master1.setSEVERITY_NAME(severity);
				sla_master1.setDAYS(days);
				sla_master1.setHOURS(hours);
				sla_master1.setMINUTES(minutes);
				sla_master1.setSECONDS(seconds);
				sla_master1.setSR_NO(srno);
				sla_master1.setRESPONSE_SLA_TARGET_DURATION(Response_SLA_Target_Time);
				sla_master1.setSLA_TARGET_ELAPSED_TIME(elapsedTimeFinal);
			sla_master1.setRESPONSE_SLA_CALENDER_WEEK_STATUS(slaweek);
			
				sessionFactory.getCurrentSession().persist(sla_master1);
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public JSONArray getResponseSLAMasterListingForSR(String userlist) {

		System.out.println("Inside MailConfigDaoImpl SLAMasterListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
//	String db_username = null;
//	String db_usertype = null;

		try {
			System.out.println("Before Projection List ");
			Session s = getSession();
			System.out.println("s =" + s);
			List<service_request_response_sla_master> dataList = getSession().createQuery("from service_request_response_sla_master").list();

			System.out.println("datalist="+dataList);
			array1 = new JSONArray();
			for (service_request_response_sla_master sourceDrive : dataList) {

							srno = srno + 1;
				System.out.println("array = " + sourceDrive.getCOMPANY());
				
				array = new JSONArray();

				array.put(srno);
				array.put(
						"<button class='btn btn-info' id='Editbtn' onclick='EditSLA(\"" + sourceDrive.getPRIORITY_NAME()
						+ "\",\"" + sourceDrive.getDAYS() + "\",\"" + sourceDrive.getHOURS() + "\",\""
						+ sourceDrive.getMINUTES() + "\",\"" + sourceDrive.getSECONDS()
						+ "\",\"" + sourceDrive.getCOMPANY()
							+"\",\"" + sourceDrive.getSEVERITY_NAME() 
							+"\",\"" + sourceDrive.getSR_NO() 
							+"\",\""+sourceDrive.getRESPONSE_SLA_CALENDER_WEEK_STATUS()+"\")'"
							+ "><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
		array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteSLA(\""
				+ sourceDrive.getSR_NO() + "\" )'><i class='fa fa-trash'></i></button>");
		array.put(sourceDrive.getCOMPANY());
		
		array.put(sourceDrive.getPRIORITY_NAME());
		array.put(sourceDrive.getSEVERITY_NAME());
		array.put(sourceDrive.getDAYS());
		array.put(sourceDrive.getHOURS());
		array.put(sourceDrive.getMINUTES());
		array.put(sourceDrive.getSECONDS());
		array.put(sourceDrive.getSLA_TARGET_ELAPSED_TIME());
		array.put(sourceDrive.getRESPONSE_SLA_TARGET_DURATION());	
		array.put(sourceDrive.getRESPONSE_SLA_CALENDER_WEEK_STATUS());	
				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return array1;
	}

	@Override
	public String UpdateResponseSLADetailsForSR(String priorityupdate, int daysupdate, int hoursupdate, int minutesupdate,
			int secondsupdate, int sr_no, String cnameupdate, String severityupdate,String slaweek) {
		System.out.println("Inside SLADaoImpl UpdateSLADetails method");
		int days=0;
		int hours=0;
		int minutes=0;
		int seconds=0;
		String status = null;

		try {

			System.out.println("inside UpdateSLADetails");
			
			
			System.out.println("PRIORITY  " + priorityupdate);
			System.out.println("SEVERITY  "+ severityupdate);
			System.out.println("PRIORITY  "+ severityupdate);
			
			Query query1 = getSession().createQuery("from service_request_response_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and DAYS = :DAYS and HOURS = :HOURS and MINUTES = :MINUTES and SECONDS = :SECONDS and SR_NO=:SR_NO and RESPONSE_SLA_CALENDER_WEEK_STATUS=:RESPONSE_SLA_CALENDER_WEEK_STATUS");
			query1.setParameter("COMPANY", cnameupdate);
			query1.setParameter("PRIORITY", priorityupdate);
			query1.setParameter("SEVERITY", severityupdate);
			query1.setParameter("DAYS", daysupdate);
			query1.setParameter("HOURS", hoursupdate);
			query1.setParameter("MINUTES", minutesupdate);
			query1.setParameter("SECONDS", secondsupdate);
			query1.setParameter("SR_NO", sr_no);
			query1.setParameter("RESPONSE_SLA_CALENDER_WEEK_STATUS", slaweek);
			
			List <responseslamaster> data =  query1.list();
			System.out.println("data:"+data);
			if (!data.isEmpty()) {
				
				  System.out.println("   in if block  :::::");

				status = "success";
			} 
			
			else if(data.isEmpty())
			{
				
            System.out.println("else   in if block  :::::");
            
              System.out.println("SRNO     "+ sr_no);
             
				Query queryfordublicate = getSession().createQuery("from service_request_response_sla_master where COMPANY=:COMPANY and PRIORITY_NAME=:PRIORITY and SEVERITY_NAME=:SEVERITY and SR_NO !=:SR_NO ");
				queryfordublicate.setParameter("COMPANY", cnameupdate);
				queryfordublicate.setParameter("PRIORITY", priorityupdate);
				queryfordublicate.setParameter("SEVERITY", severityupdate); 
				queryfordublicate.setParameter("SR_NO", sr_no);
			
				
				List <service_request_response_sla_master> data3 =  queryfordublicate.list();
				System.out.println("data:"+data3);
				if (!data3.isEmpty()) {
					
					status = "duplicate";
				}
				else {
					

					int numberOfDays;
					int numberOfHours;
					int numberOfMinutes;
					int numberOfSeconds;

					numberOfDays =0 ;
					numberOfHours =0 ;
					numberOfMinutes = 0;
					numberOfSeconds =0 ;
					
				int elapsedtimes=0;
				int targettime=0;
				
				
				
					if(daysupdate!=0)
					{
						numberOfDays=daysupdate*86400;
					
					}
					else
					{
						daysupdate=0;
					}
					
					if(hoursupdate!=0)
					{
						numberOfHours=hoursupdate*60*60;
						
					}
					else
					{
						hoursupdate=0;
					}
					if(minutesupdate!=0)
					{
						numberOfMinutes=minutesupdate*60;
						
					}
					else
					{
						minutesupdate=0;
					}
					if(secondsupdate!=0)
					{
						secondsupdate=secondsupdate;
						
					}
					else
					{
						secondsupdate=0;
					}
					elapsedtimes=numberOfDays+numberOfHours+numberOfMinutes+secondsupdate;

					String elapsedTimeFinal=String.valueOf(elapsedtimes);
					String Response_SLA_Target_Time = "";
					String SLA_Target_Days = "";
					String SLA_Target_Hours = "";
					String SLA_Target_Minutes = "";
					String SLA_Target_Seconds = "";

					if (daysupdate != 0) {
						SLA_Target_Days = Integer.toString(daysupdate) + " Days ";
					}
					if (hoursupdate != 0) {
						SLA_Target_Hours = Integer.toString(hoursupdate) + " Hours ";
					}
					if (minutesupdate != 0) {
						SLA_Target_Minutes = Integer.toString(minutesupdate) + " Minutes ";
					}
					if (secondsupdate != 0) {
						SLA_Target_Seconds = Integer.toString(secondsupdate) + " Seconds ";
					}
					
					/////////////// Response SLA TARGET TIME Starts//////
					Response_SLA_Target_Time = SLA_Target_Days + SLA_Target_Hours + SLA_Target_Minutes + SLA_Target_Seconds;
					
					System.out.println(" response sla target in minuite"+Response_SLA_Target_Time);
					Query query = sessionFactory.getCurrentSession().createQuery(
							"update service_request_response_sla_master set DAYS = :DAYS,HOURS = :HOURS,MINUTES = :MINUTES,SECONDS = :SECONDS,PRIORITY_NAME = :PRIORITY_NAME,SEVERITY_NAME = :SEVERITY_NAME,RESPONSE_SLA_TARGET_DURATION=:TARGETTIME,SLA_TARGET_ELAPSED_TIME=:SECOND ,RESPONSE_SLA_CALENDER_WEEK_STATUS=:RESPONSE_SLA_CALENDER_WEEK_STATUS where COMPANY = :COMPANY and SR_NO=:SR_NO ");
					
					query.setParameter("DAYS", daysupdate);
					query.setParameter("HOURS", hoursupdate);
					query.setParameter("MINUTES", minutesupdate);
					query.setParameter("SECONDS", secondsupdate);
					query.setParameter("PRIORITY_NAME", priorityupdate);
					query.setParameter("SEVERITY_NAME", severityupdate);
					
					query.setParameter("SECOND",elapsedTimeFinal);
					query.setParameter("TARGETTIME", Response_SLA_Target_Time);
					query.setParameter("COMPANY", cnameupdate);
					query.setParameter("SR_NO", sr_no);
					query.setParameter("RESPONSE_SLA_CALENDER_WEEK_STATUS", slaweek);
			
					int i = query.executeUpdate();
                   
				
					
					if (i == 0) {
						status = "error";
					} else {

						status = "success";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return status;
	}

	@Override
	public String deleteResponseSLAForSR(int sr_no) {

		System.out.println("Inside SLADaoImpl service_request_response_sla_master method");
		String status = null;

		try {

			System.out.println("inside deleteSLA");
			int i = sessionFactory.getCurrentSession()
					.createQuery("delete from service_request_response_sla_master where SR_NO = '" + sr_no + "'").executeUpdate();
			if (i == 0) {
				status = "error";
			} else {

				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

		return status;
	}

}
