package com.velox.itsm.dao;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.velox.itsm.model.Login;
import com.velox.itsm.model.auto_close_details;
import com.velox.itsm.model.auto_close_problem_details;
import com.velox.itsm.model.categorymaster;
import com.velox.itsm.model.companynames;
import com.velox.itsm.model.departmentnames;
import com.velox.itsm.model.enggmaster;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.mailconfigset;
import com.velox.itsm.model.prioritymaster;
import com.velox.itsm.model.request_mode_master;
import com.velox.itsm.model.sitenames;
import com.velox.itsm.model.subcategorymaster;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.usermaster;;

@Repository("autoCloseTicketDao")
@Transactional
public class AutoCloseTicketDaoImpl extends AbstractDao<Integer, mail_config> implements AutoCloseTicketDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String AutoClosedInsert(String TicketType, String TimeFormat, String Time,String rsn, String company) {
		
		//System.out.println("Inside MailConfigDaoImpl AutoClosedInsert method");
		String status = null;
		 String Stringcounttotal=null;
         String Stringcountinsert=null;
         String Stringcountupdate=null;

		try {
			//System.out.println("TicketType: "+TicketType+ "TimeFormat: "+TimeFormat+ "Time: "+Time);
			
			 int time_milisec = 0;
		        String proper_mil_sec = null;

		        if (TimeFormat.contains("Min")) {
		            String minn = null;
		            int minutess = 0;

		            minutess = Integer.parseInt(Time);
		          //  time_milisec = minutess * 60000;
		            time_milisec = minutess * 60;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        } else if (TimeFormat.contains("Hours")) {
		            String hrr = null;
		            int hrrr = 0;

		            hrrr = Integer.parseInt(Time);
//		            time_milisec = hrrr * 3600000;
		            time_milisec = hrrr * 3600;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Hr Converted to MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        } else if (TimeFormat.contains("Days")) {
		            String hrr = null;
		            int hrrr = 0;

		            hrrr = Integer.parseInt(Time);
		            //time_milisec = hrrr * 86400000;
		            time_milisec = hrrr * 86400;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Hr Converted to MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        }
		        
		        int counttotal=0;
		        int countupdate=0;
		        int countinsert=0;
		        try {
		        	
		           
		          //  String TicketType1 = TicketType.replace(" ", " ");
		            //System.out.println("TicketType1****"+TicketType1);
		            StringTokenizer str1 = new StringTokenizer(TicketType, ",");

		            while (str1.hasMoreTokens()) {
		                counttotal++;
		                String TicketType12 = str1.nextToken();
		                //System.out.println("Thread Tokens   " + TicketType12);
		                
		                try{
		                	Query query = sessionFactory.getCurrentSession().createQuery("from auto_close_details where TICKET_STATUS=:TICKET_STATUS and COMPANY=:COMPANY");
		        			query.setParameter("TICKET_STATUS", TicketType12);
		        			query.setParameter("COMPANY", company);
		        			auto_close_details data = (auto_close_details) query.uniqueResult();
		        			//System.out.println("DATA IS: "+data);
		                 
		                    if(data!=null)
		                    {
		                    	//System.out.println("INSIDE UPDATE");
		                    	Query query1 = sessionFactory.getCurrentSession().createQuery("update auto_close_details set "
		                    			+ "TIME_FORMAT =:TIME_FORMAT,CLOSED_TIME =:CLOSED_TIME,CLOSED_REASON =:CLOSED_REASON, TOTAL_SEC =:TOTAL_SEC, COMPANY=:COMPANY where TICKET_STATUS =:TICKET_STATUS and COMPANY=:COMPANY");
		                      
		                       query1.setParameter("TIME_FORMAT", TimeFormat);
		                       query1.setParameter("CLOSED_TIME", Time);
		                      query1.setParameter("CLOSED_REASON", rsn);
		                       query1.setParameter("TOTAL_SEC", proper_mil_sec);
		                       query1.setParameter("TICKET_STATUS", TicketType12);
		                      query1.setParameter("COMPANY", company);
		                       query1.executeUpdate();
		                       countupdate++;
		                    }
		                    else
		                    {
		                    	int srno=0;
		            			try {
		            				Criteria crit=sessionFactory.getCurrentSession().createCriteria(auto_close_details.class).setProjection(Projections.max("SR_NO"));
		            				Integer srno1= (Integer) crit.uniqueResult();
		            				
		            				//System.out.println(" SRNO IS: "+srno1);
		            				
		            				if(srno1 !=null)
		            				{
		            					srno=srno1.intValue();
		            					srno=srno+1;
		            					//System.out.println("IN IF SRNO IS: "+srno);
		            				}
		            				else {
		            					srno=1;
		            					//System.out.println("IN ELSE SRNO IS: "+srno);
		            				}
		            			} catch (Exception e) {
		            				// TODO Auto-generated catch block
		            				e.printStackTrace();
		            				//System.out.println(e);
		            			}
		                        
		            			auto_close_details auto_close_details1= new auto_close_details();
		            			
		            			auto_close_details1.setSR_NO(srno);;
		        		
		            			auto_close_details1.setTICKET_STATUS(TicketType12);;
		            			auto_close_details1.setTIME_FORMAT(TimeFormat);;
		            			auto_close_details1.setCLOSED_TIME(Time);
		            			auto_close_details1.setCLOSED_REASON(rsn);
		            			auto_close_details1.setTOTAL_SEC(proper_mil_sec);
		            			auto_close_details1.setCOMPANY(company);
		            			sessionFactory.getCurrentSession().persist(auto_close_details1);

		                       countinsert++;
		                    }
		                }
		                catch(Exception e1)
		                {
		                    e1.printStackTrace();
		                }

		            }
		            //System.out.println("****"+counttotal+","+countinsert+","+countupdate);
		           Stringcounttotal=String.valueOf(counttotal);
		           Stringcountinsert=String.valueOf(countinsert);
		           Stringcountupdate=String.valueOf(countupdate);
		           
		        } catch (Exception e) {
		            //System.out.println("Exception in GetBranch select query :" + e);
		        }
			
		
	} catch (Exception e) {
        //System.out.println("Exception in GetBranch select query :" + e);
    }
		return Stringcounttotal+","+Stringcountinsert+","+Stringcountupdate;	
}

	@Override
	public String AutoClosedProblemInsert(String TicketType, String TimeFormat, String Time, String rsn, String company) {
		//System.out.println("Inside ConfigDaoImpl AutoClosedProblemInsert method");
		String status = null;
		 String Stringcounttotal=null;
         String Stringcountinsert=null;
         String Stringcountupdate=null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);
			//System.out.println("TicketType: "+TicketType+ "TimeFormat: "+TimeFormat+ "Time: "+Time);
			
			 int time_milisec = 0;
		        String proper_mil_sec = null;

		        if (TimeFormat.contains("Min")) {
		            String minn = null;
		            int minutess = 0;

		            minutess = Integer.parseInt(Time);
		          //  time_milisec = minutess * 60000;
		            time_milisec = minutess * 60;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        } else if (TimeFormat.contains("Hours")) {
		            String hrr = null;
		            int hrrr = 0;

		            hrrr = Integer.parseInt(Time);
//		            time_milisec = hrrr * 3600000;
		            time_milisec = hrrr * 3600;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Hr Converted to MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        } else if (TimeFormat.contains("Days")) {
		            String hrr = null;
		            int hrrr = 0;

		            hrrr = Integer.parseInt(Time);
		            //time_milisec = hrrr * 86400000;
		            time_milisec = hrrr * 86400;
		            proper_mil_sec = String.valueOf(time_milisec);
		            //System.out.println("Hr Converted to MiliSec " + time_milisec);
		            //System.out.println("Min COnvert In MiliSec " + proper_mil_sec);

		        }
		        
		        int counttotal=0;
		        int countupdate=0;
		        int countinsert=0;
		        try {
		           
		            String TicketType1 = TicketType.replace(" ", "");
		            //System.out.println("TicketType1****"+TicketType1);
		            StringTokenizer str1 = new StringTokenizer(TicketType1, ",");

		            while (str1.hasMoreTokens()) {
		                counttotal++;
		                String TicketType12 = str1.nextToken();
		                //System.out.println("Thread Tokens   " + TicketType12);
		                
		                try{
		                	Query query =sessionFactory.getCurrentSession().createQuery("from auto_close_problem_details where TICKET_STATUS=:TICKET_STATUS");
		        			query.setParameter("TICKET_STATUS", TicketType12);
		        			auto_close_problem_details data = (auto_close_problem_details) query.uniqueResult();
		        			//System.out.println("DATA IS: "+data);
		                 
		                    if(data!=null)
		                    {
		                    	//System.out.println("INSIDE UPDATE");
		                    	Query query1 =sessionFactory.getCurrentSession().createQuery("update auto_close_problem_details set "
		                    			+ "TIME_FORMAT =:TIME_FORMAT,CLOSED_TIME =:CLOSED_TIME,CLOSED_REASON =:CLOSED_REASON, TOTAL_SEC =:TOTAL_SEC,COMPANY=:COMPANY where TICKET_STATUS =:TICKET_STATUS");
		                      
		                       query1.setParameter("TIME_FORMAT", TimeFormat);
		                       query1.setParameter("CLOSED_TIME", Time);
		                       query1.setParameter("CLOSED_REASON", rsn);
		                       query1.setParameter("TOTAL_SEC", proper_mil_sec);
		                       query1.setParameter("TICKET_STATUS", TicketType12);
		                       query1.setParameter("COMPANY", company);
		                       query1.executeUpdate();
		                       countupdate++;
		                    }
		                    else
		                    {
		                    	int srno=0;
		            			try {
		            				Criteria crit=sessionFactory.getCurrentSession().createCriteria(auto_close_problem_details.class).setProjection(Projections.max("SR_NO"));
		            				Integer srno1= (Integer) crit.uniqueResult();
		            				
		            				//System.out.println(" SRNO IS: "+srno1);
		            				
		            				if(srno1 !=null)
		            				{
		            					srno=srno1.intValue();
		            					srno=srno+1;
		            					//System.out.println("IN IF SRNO IS: "+srno);
		            				}
		            				else {
		            					srno=1;
		            					//System.out.println("IN ELSE SRNO IS: "+srno);
		            				}
		            			} catch (Exception e) {
		            				// TODO Auto-generated catch block
		            				e.printStackTrace();
		            				//System.out.println(e);
		            			}
		                        
		            			auto_close_problem_details auto_close_details1= new auto_close_problem_details();
		            			
		            			auto_close_details1.setSR_NO(srno);;
		        		
		            			auto_close_details1.setTICKET_STATUS(TicketType12);;
		            			auto_close_details1.setTIME_FORMAT(TimeFormat);;
		            			auto_close_details1.setCLOSED_TIME(Time);
		            			auto_close_details1.setCLOSED_REASON(rsn);
		            			auto_close_details1.setTOTAL_SEC(proper_mil_sec);
		            			auto_close_details1.setCOMPANY(company);
		            			getSession().persist(auto_close_details1);
		        				
		                       countinsert++;
		                    }
		                }
		                catch(Exception e1)
		                {
		                    e1.printStackTrace();
		                }

		            }
		            //System.out.println("****"+counttotal+","+countinsert+","+countupdate);
		           Stringcounttotal=String.valueOf(counttotal);
		           Stringcountinsert=String.valueOf(countinsert);
		           Stringcountupdate=String.valueOf(countupdate);
		           
		        } catch (Exception e) {
		            //System.out.println("Exception in GetBranch select query :" + e);
		        }
			
		
	} catch (Exception e) {
        //System.out.println("Exception in GetBranch select query :" + e);
    }
		return Stringcounttotal+","+Stringcountinsert+","+Stringcountupdate;
	}
}
