package com.velox.itsm.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.velox.itsm.model.AD_USER_MANAGE;
import com.velox.itsm.model.Login;
import com.velox.itsm.model.categorymaster;
import com.velox.itsm.model.companynames;
import com.velox.itsm.model.departmentnames;
import com.velox.itsm.model.enggmaster;
import com.velox.itsm.model.loginmaster;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.mailconfigset;
import com.velox.itsm.model.outage_master;
import com.velox.itsm.model.prioritymaster;
import com.velox.itsm.model.request_mode_master;
import com.velox.itsm.model.sitenames;
import com.velox.itsm.model.subcategorymaster;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.usermaster;;

@Repository("notificationDao")
@Transactional
public class NotificationDaoImpl extends AbstractDao<Integer, mail_config> implements NotificationDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Environment environment;
	
	@Override
	public JSONArray getUserNotification(String notify) {
		//System.out.println("Inside NotificationDaoImpl Notification_User method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;

		String DBType = environment.getRequiredProperty("jdbc.url");
		String LoginUser = null;
		String LoginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
			//System.out.println("companyname****" + LoginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			
			Query query = null;
			Query querycount = null;

			if (DBType.contains("oracle")) {

				//System.out.println("********************ORACLE QUERY*************************************");

				query = getSession().createSQLQuery("Select * From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) WHERE ROWNUM<=20");

				querycount = getSession().createSQLQuery("Select count(*) From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) ");
				
			} else if (DBType.contains("mysql")) {

				//System.out.println("********************MySQL QUERY*************************************");

query = getSession().createSQLQuery("SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number , @prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x,  (SELECT @prev_val \\:= '') y WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' AND t.TICKET_RAISED_NAME_COMPANY='"+LoginUserCompany+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1  ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
				
			//	querycount = getSession().createSQLQuery("SELECT COUNT(*) FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number , @prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') y  WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' AND t.TICKET_RAISED_NAME_COMPANY='"+LoginUserCompany+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1 ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
				
			}

			//System.out.println("inside getUserNotification");

//				query.setParameter("T_ID", ticketid);
			//System.out.println("NOTIFICATION FOR QUERY: " + query);
			System.out.println("THE RUUNING QUERY IS  THAT");
			List<Object[]> l = query.list();
		//	List<Object[]> J = querycount.list();

			if(DBType.contains("oracle")) {
				Number Counter = (Number)(querycount.uniqueResult());
				//System.out.println("NOTIFICATION COUNT long IS: " + Counter);

				array1 = new JSONArray();
				for (Object[] listData : l) {

					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
					arrayobj.put("MESSAGE", listData[3].toString());
					arrayobj.put("COUNTER", Counter);

					array1.put(arrayobj);

				}
			} else if(DBType.contains("mysql")) {
				
			//	BigInteger Counter = (BigInteger)(querycount.uniqueResult());
				//System.out.println("NOTIFICATION COUNT long IS: " + Counter);

			//	System.out.println("Counter __ == " + Counter);
				array1 = new JSONArray();
				Integer size = l.size();
				System.out.println("size is  "+ size);
				for (Object[] listData : l) {

					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
					arrayobj.put("MESSAGE", listData[3].toString());
					arrayobj.put("COUNTER", size);

					array1.put(arrayobj);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return array1;
	}
	
	@Override
	public JSONArray getTPNotification(String notify)
	{
		String DBType = environment.getRequiredProperty("jdbc.url");
	//System.out.println("Inside NotificationDaoImpl getTPNotification method");
	String status = null;
	JSONArray array = null;
	JSONArray array1 = null;

	String LoginUser = null;
	String LoginScope = null;
	String loginUserCompany = null;
	
	String LoginUserCompanyDB = null;
	String LoginUserBranchDB = null;
	String LoginUserDepartmentDB = null;
	
	try {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		LoginUser = session.getAttribute("username").toString();
		LoginScope = session.getAttribute("loginscope").toString();
		loginUserCompany = session.getAttribute("companyname").toString();
		//System.out.println("username****" + LoginUser);
	} catch (Exception e) {
		e.printStackTrace();
		//System.out.println("Exceptioon e***" + e);
	}
	try {
		List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster catDrive : catList) {
			LoginUserCompanyDB=catDrive.getCOMPANY();
			LoginUserBranchDB=catDrive.getBRANCH();
			LoginUserDepartmentDB=catDrive.getDEPARTMENT();

		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	Query query = null;
	Query querycount = null;
	try {
		

		//System.out.println("inside getTPNotification");

		if (DBType.contains("oracle")) {
			
			//System.out.println("********************************ORACLE QUERY******************************");
			query = getSession().createSQLQuery("Select * From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.STATUS IN('New','Closed','Hold','Resolved','Assigned','Re-Assigned')) inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) WHERE ROWNUM<=20");

			querycount = getSession().createSQLQuery("Select count(*) From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.STATUS IN('New','Closed','Hold','Resolved','Assigned','Re-Assigned')) inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC)");
			
		} else if (DBType.contains("mysql")) {
			
			//System.out.println("********************************MySQL QUERY*********************************");

//			///////// OLD QUERY////
//			 query = getSession().createSQLQuery("SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t, (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') y ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1 ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
//			
//			 querycount = getSession().createSQLQuery("SELECT count(T_ID) FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t, (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') y ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1 ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
//			 ///////////////////
			 
//			 query = getSession().createSQLQuery("SELECT T_ID1,ACT_DATE,T_STATUS,T_COMPANY,T_BRANCH,T_DEPARTMENT,REQUESTER FROM (SELECT * FROM (SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID ,t.T_ID AS T_ID1,t.ACTIVITY_DATE AS ACT_DATE, t.STATUS AS T_STATUS, tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH,tt.T_DEPARTMENT AS T_DEPARTMENT,tt.T_REQUESTER AS REQUESTER FROM TICKET_TRACKING t JOIN ticket tt ON t.T_ID=tt.T_ID, (SELECT @row_no \\:= 0) X, (SELECT @prev_val \\:= '') Y ORDER BY t.T_ID DESC, STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC) inn1 UNION SELECT * FROM(SELECT @row_no \\:= IF(@prev_val = SUBSTRING(pt.PT_ID,4), @row_no + 1, 1) AS row_number ,@prev_val \\:= SUBSTRING(pt.PT_ID,4) AS T_ID , pt.PT_ID AS T_ID1,pt.ACTIVITY_DATE AS ACT_DATE, pt.PROBLEM_STATUS AS T_STATUS, ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT as T_DEPARTMENT, ptt.PT_REQUESTER AS REQUESTER FROM PROBLEM_TICKET_TRACKING pt JOIN problem_ticket ptt ON pt.PT_ID=ptt.PT_ID,  (SELECT @row_no \\:= 0) X, (SELECT @prev_val \\:= '') Y ORDER BY SUBSTRING(pt.PT_ID,4) DESC, STR_TO_DATE(pt.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC) inn2) final WHERE  ("+LoginScope+" OR (T_COMPANY='"+LoginUserCompanyDB+"' AND T_BRANCH='"+LoginUserBranchDB+"' AND T_DEPARTMENT='"+LoginUserDepartmentDB+"') OR REQUESTER='"+LoginUser+"') AND row_number<=1 ORDER BY STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 50");
			 
		//	 query = getSession().createSQLQuery("SELECT * FROM(SELECT t1.T_ID,t1.ACTIVITY_DATE AS ACTIVITY_DATE,t1.STATUS,COALESCE(tt.VIP_TICKET,'NA'),tt.T_REQUESTER AS REQUESTER,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH,tt.T_DEPARTMENT AS T_DEPARTMENT FROM ticket_tracking t1 JOIN ticket tt ON t1.T_ID=tt.T_ID WHERE t1.ACTIVITY_DATE = (SELECT MAX(t2.ACTIVITY_DATE) FROM ticket_tracking t2 WHERE t2.T_ID = t1.T_ID) UNION SELECT t1.PT_ID,t1.ACTIVITY_DATE AS ACTIVITY_DATE,t1.PROBLEM_STATUS,COALESCE(tt.VIP_TICKET,'NA'),tt.PT_REQUESTER AS REQUESTER,tt.PT_COMPANY AS T_COMPANY,tt.PT_BRANCH AS T_BRANCH,tt.PT_DEPARTMENT AS T_DEPARTMENT FROM problem_ticket_tracking t1 JOIN problem_ticket tt ON t1.PT_ID=tt.PT_ID WHERE t1.ACTIVITY_DATE = (SELECT MAX(t2.ACTIVITY_DATE) FROM problem_ticket_tracking t2 WHERE t2.PT_ID = t1.PT_ID) ) main WHERE ("+LoginScope+" OR (T_COMPANY='"+LoginUserCompanyDB+"' AND T_BRANCH='"+LoginUserBranchDB+"' AND T_DEPARTMENT='"+LoginUserDepartmentDB+"') OR (REQUESTER='"+LoginUser+"' and T_COMPANY='"+LoginUserCompanyDB+"')) ORDER BY STR_TO_DATE(ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 50");
		//	 query = getSession().createSQLQuery("SELECT * FROM (SELECT 	track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date UNION SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date )main where ( ("+LoginScope+") OR (REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"') )   ORDER BY latest_date DESC limit 50");
			 //query = getSession().createSQLQuery("SELECT * FROM (SELECT 	track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date UNION SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date )main where ( ("+LoginScope+") OR (REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"') )   ORDER BY latest_date DESC limit 50");
			// querycount = getSession().createSQLQuery("SELECT COUNT(*) FROM (SELECT 	track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date UNION SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date )main where (  ("+LoginScope+") OR (REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"' ))" );
			// querycount = getSession().createSQLQuery("SELECT COUNT(*) FROM(SELECT t1.T_ID,t1.ACTIVITY_DATE AS ACTIVITY_DATE,t1.STATUS,COALESCE(tt.VIP_TICKET,'NA'),tt.T_REQUESTER AS REQUESTER,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH,tt.T_DEPARTMENT AS T_DEPARTMENT FROM ticket_tracking t1 JOIN ticket tt ON t1.T_ID=tt.T_ID WHERE t1.ACTIVITY_DATE = (SELECT MAX(t2.ACTIVITY_DATE) FROM ticket_tracking t2 WHERE t2.T_ID = t1.T_ID) UNION SELECT t1.PT_ID,t1.ACTIVITY_DATE AS ACTIVITY_DATE,t1.PROBLEM_STATUS,COALESCE(tt.VIP_TICKET,'NA'),tt.PT_REQUESTER AS REQUESTER,tt.PT_COMPANY AS T_COMPANY,tt.PT_BRANCH AS T_BRANCH,tt.PT_DEPARTMENT AS T_DEPARTMENT FROM problem_ticket_tracking t1 JOIN problem_ticket tt ON t1.PT_ID=tt.PT_ID WHERE t1.ACTIVITY_DATE = (SELECT MAX(t2.ACTIVITY_DATE) FROM problem_ticket_tracking t2 WHERE t2.PT_ID = t1.PT_ID) ) main WHERE ("+LoginScope+" OR (T_COMPANY='"+LoginUserCompanyDB+"' AND T_BRANCH='"+LoginUserBranchDB+"' AND T_DEPARTMENT='"+LoginUserDepartmentDB+"') OR (REQUESTER='"+LoginUser+"' and T_COMPANY='"+LoginUserCompanyDB+"'))");
			 query = getSession().createSQLQuery("SELECT * FROM ((SELECT 	track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date  order by SR_NO desc ) LIMIT 5000 UNION (SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date   order by SR_NO desc) LIMIT 5000 )main where ( ("+LoginScope+") OR (REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"') )   ORDER BY latest_date DESC limit 50");

		}

//			query.setParameter("T_ID", ticketid);
		//System.out.println("NOTIFICATION FOR QUERY: ++" + query);
		List<Object[]> l = query.list();
	//	List<Object[]> J = querycount.list();
		
		if(DBType.contains("oracle")) {
			Number Counter = (Number)(querycount.uniqueResult());
			//System.out.println("NOTIFICATION COUNT long IS: " + Counter);

			array1 = new JSONArray();
			for (Object[] listData : l) {

				////System.out.println("FIRST DATA: " + listData[0].toString());

				JSONObject arrayobj = new JSONObject();

				arrayobj.put("T_ID", listData[0]);
				arrayobj.put("ACTIVITY_DATE", listData[1].toString());
				arrayobj.put("STATUS", listData[2].toString());
				arrayobj.put("MESSAGE", listData[3].toString());
				arrayobj.put("COUNTER", Counter);

				array1.put(arrayobj);

			}
		} else if(DBType.contains("mysql")) {
		Integer	count=0;
//			BigInteger Counter = (BigInteger)(querycount.uniqueResult());
		//	Object Counter = querycount.uniqueResult();
			//int Counter=50;
		//	//System.out.println("NOTIFICATION COUNT long IS: " + count);

			array1 = new JSONArray();
			for (Object[] listData : l) {
			//	count=count+1;
			count=	l.size();
				////System.out.println("FIRST DATA: " + listData[0].toString());
			////System.out.println("COUNTER VALUE  "+ count);
				JSONObject arrayobj = new JSONObject();

				arrayobj.put("T_ID", listData[0]);
				arrayobj.put("ACTIVITY_DATE", listData[1].toString());
				arrayobj.put("STATUS", listData[2].toString());
				arrayobj.put("VIP_TICKET", listData[3].toString());
				
				arrayobj.put("COUNTER", count.toString());

				array1.put(arrayobj);

			}
		}
			
		

	} catch (Exception e) {
		e.printStackTrace();

	}

	return array1;
}
	@Override
	public JSONArray getEnggNotification(String notify) {
		//System.out.println("Inside NotificationDaoImpl getEnggNotification method");
		String DBType = environment.getRequiredProperty("jdbc.url");

		JSONArray array1 = null;
		String Owner = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String EnggGroup = null;
		String LoginScope = null;
		
//		String LoginUserCompanyDB = null;
//		String LoginUserBranchDB = null;
//		String LoginUserDepartmentDB = null;
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
			for (loginmaster catDrive : catList) {
//				LoginUserCompanyDB=catDrive.getCOMPANY();
//				LoginUserBranchDB=catDrive.getBRANCH();
//				LoginUserDepartmentDB=catDrive.getDEPARTMENT();
				EnggGroup=catDrive.getGROUP_NAME();
			}
			EnggGroup=EnggGroup.replaceAll(",", "','");
			//System.out.println("ENGG GROUP: "+EnggGroup);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try {
			
			Query query = null;
			Query querycount = null;
			//System.out.println("inside getEnggNotification");

			if (DBType.contains("oracle")) {
				//System.out.println("********************************ORACLE QUERY******************************");
				query = getSession().createSQLQuery("Select * From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE, inn.TICKET_RAISED_NAME FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY t.T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE,TICKET_RAISED_NAME FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"' UNION SELECT ROW_NUMBER() OVER (PARTITION BY t.T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE,t.TICKET_RAISED_NAME FROM TICKET_TRACKING t JOIN TICKET_ASSIGNED TA ON t.T_ID=TA.T_ID where TA.ENGINEER_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) WHERE ROWNUM<=20");

				querycount = getSession().createSQLQuery("Select count(*) From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE, inn.TICKET_RAISED_NAME FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY t.T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE,TICKET_RAISED_NAME FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"' UNION SELECT ROW_NUMBER() OVER (PARTITION BY t.T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE,t.TICKET_RAISED_NAME FROM TICKET_TRACKING t JOIN TICKET_ASSIGNED TA ON t.T_ID=TA.T_ID where TA.ENGINEER_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) ");
				
			} else if (DBType.contains("mysql")) {
				//System.out.println("********************************MySQL QUERY******************************");

//				query = getSession().createSQLQuery("SELECT top.T_ID,top.ACTIVITY_DATE,top.STATUS,top.MESSAGE,top.TICKET_RAISED_NAME FROM (SELECT row_number,inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE,inn.TICKET_RAISED_NAME FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE,t.TICKET_RAISED_NAME FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') prev WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn UNION SELECT row_number,inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE,inn.TICKET_RAISED_NAME FROM(SELECT @row_no1 \\:= IF(@prev_val1 = onn.T_ID, @row_no1 + 1, 1) AS row_number ,@prev_val1 \\:= onn.T_ID AS T_ID, onn.ACTIVITY_DATE,onn.STATUS,onn.MESSAGE,onn.TICKET_RAISED_NAME FROM(SELECT tt.T_ID ,tt.ACTIVITY_DATE, tt.STATUS,tt.MESSAGE,tt.TICKET_RAISED_NAME FROM TICKET_TRACKING tt JOIN TICKET_ASSIGNED TA ON tt.T_ID=TA.T_ID WHERE TA.ENGINEER_NAME ='"+LoginUser+"' ORDER BY tt.T_ID DESC,STR_TO_DATE(tt.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC) onn, (SELECT @row_no1 \\:= 0) x,(SELECT @prev_val1 \\:= '') y)inn)top WHERE top.row_number<=1 ORDER BY STR_TO_DATE(ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
//				
//				querycount = getSession().createSQLQuery("SELECT COUNT(*) FROM (SELECT row_number,inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE,inn.TICKET_RAISED_NAME FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE,t.TICKET_RAISED_NAME FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') y WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn UNION SELECT row_number,inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE,inn.TICKET_RAISED_NAME FROM(SELECT @row_no1 \\:= IF(@prev_val1 = onn.T_ID, @row_no1 + 1, 1) AS row_number ,@prev_val1 \\:= onn.T_ID AS T_ID, onn.ACTIVITY_DATE,onn.STATUS,onn.MESSAGE,onn.TICKET_RAISED_NAME FROM(SELECT tt.T_ID ,tt.ACTIVITY_DATE, tt.STATUS,tt.MESSAGE,tt.TICKET_RAISED_NAME FROM TICKET_TRACKING tt JOIN TICKET_ASSIGNED TA ON tt.T_ID=TA.T_ID WHERE TA.ENGINEER_NAME ='"+LoginUser+"' ORDER BY tt.T_ID DESC,STR_TO_DATE(tt.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC) onn, (SELECT @row_no1 \\:= 0) x, (SELECT @prev_val1 \\:= '') y)inn)top WHERE top.row_number<=1 ORDER BY STR_TO_DATE(ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
				
//				query = getSession().createSQLQuery("SELECT T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM (SELECT * FROM ( SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID , t.T_ID AS T_ID1,t.ACTIVITY_DATE AS ACT_DATE, t.STATUS AS T_STATUS,t.TICKET_RAISED_NAME AS RAISED_NAME FROM TICKET_TRACKING t ,(SELECT @row_no \\:= 0) X,(SELECT @prev_val \\:= '') prev WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' ORDER BY t.T_ID DESC,STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC )inn UNION SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no1 \\:= IF(@prev_val1 = onn.T_ID, @row_no1 + 1, 1) AS row_number ,@prev_val1 \\:= onn.T_ID AS T_ID, onn.T_ID AS T_ID1,onn.ACTIVITY_DATE AS ACT_DATE,onn.STATUS AS T_STATUS,onn.TICKET_RAISED_NAME AS RAISED_NAME FROM ( SELECT tt.T_ID ,tt.ACTIVITY_DATE, tt.STATUS,tt.TICKET_RAISED_NAME FROM TICKET_TRACKING tt JOIN TICKET_ASSIGNED TA ON tt.T_ID=TA.T_ID WHERE (TA.ENGINEER_NAME ='"+LoginUser+"' OR TA.ENGINEER_GROUP ='"+enggGroup+"') ORDER BY tt.T_ID DESC,STR_TO_DATE(tt.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC )onn, (SELECT @row_no1 \\:= 0) x,(SELECT @prev_val1 \\:= '') y )inn )top1 UNION SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no \\:= IF(@prev_val = SUBSTRING(pt.PT_ID,4), @row_no + 1, 1) AS row_number ,@prev_val \\:= SUBSTRING(pt.PT_ID,4) AS T_ID , pt.PT_ID AS T_ID1,pt.ACTIVITY_DATE AS ACT_DATE,pt.PROBLEM_STATUS AS T_STATUS,pt.PROBLEM_TICKET_RAISED_NAME AS RAISED_NAME,ta.ENGINEER_NAME AS ENGNAME FROM PROBLEM_TICKET_TRACKING pt JOIN PROBLEM_TICKET_ASSIGNED ta ON pt.PT_ID=ta.PT_ID ,(SELECT @row_no \\:= 0) X, (SELECT @prev_val \\:= '') Y ORDER BY SUBSTRING(pt.PT_ID,4) DESC, STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC) inn1 WHERE ENGNAME ='"+LoginUser+"' ) inn2) final WHERE final.row_number<=1 ORDER BY STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 30");
//				
//				querycount = getSession().createSQLQuery("SELECT COUNT(T_ID1) FROM (SELECT * FROM ( SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number ,@prev_val \\:= t.T_ID AS T_ID , t.T_ID AS T_ID1,t.ACTIVITY_DATE AS ACT_DATE, t.STATUS AS T_STATUS,t.TICKET_RAISED_NAME AS RAISED_NAME FROM TICKET_TRACKING t ,(SELECT @row_no \\:= 0) X,(SELECT @prev_val \\:= '') prev WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' ORDER BY t.T_ID DESC,STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC )inn UNION SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no1 \\:= IF(@prev_val1 = onn.T_ID, @row_no1 + 1, 1) AS row_number ,@prev_val1 \\:= onn.T_ID AS T_ID, onn.T_ID AS T_ID1,onn.ACTIVITY_DATE AS ACT_DATE,onn.STATUS AS T_STATUS,onn.TICKET_RAISED_NAME AS RAISED_NAME FROM ( SELECT tt.T_ID ,tt.ACTIVITY_DATE, tt.STATUS,tt.TICKET_RAISED_NAME FROM TICKET_TRACKING tt JOIN TICKET_ASSIGNED TA ON tt.T_ID=TA.T_ID WHERE (TA.ENGINEER_NAME ='"+LoginUser+"' OR TA.ENGINEER_GROUP ='"+enggGroup+"')  ORDER BY tt.T_ID DESC,STR_TO_DATE(tt.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC )onn, (SELECT @row_no1 \\:= 0) x,(SELECT @prev_val1 \\:= '') y )inn )top1 UNION SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT row_number,T_ID1,ACT_DATE,T_STATUS,RAISED_NAME FROM ( SELECT @row_no \\:= IF(@prev_val = SUBSTRING(pt.PT_ID,4), @row_no + 1, 1) AS row_number ,@prev_val \\:= SUBSTRING(pt.PT_ID,4) AS T_ID , pt.PT_ID AS T_ID1,pt.ACTIVITY_DATE AS ACT_DATE,pt.PROBLEM_STATUS AS T_STATUS,pt.PROBLEM_TICKET_RAISED_NAME AS RAISED_NAME,ta.ENGINEER_NAME AS ENGNAME FROM PROBLEM_TICKET_TRACKING pt JOIN PROBLEM_TICKET_ASSIGNED ta ON pt.PT_ID=ta.PT_ID ,(SELECT @row_no \\:= 0) X, (SELECT @prev_val \\:= '') Y ORDER BY SUBSTRING(pt.PT_ID,4) DESC, STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC) inn1 WHERE ENGNAME ='"+LoginUser+"' ) inn2) final WHERE final.row_number<=1 ORDER BY STR_TO_DATE(ACT_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 30");
				System.out.println("THIS IS QUERY  ");
				 query = getSession().createSQLQuery("SELECT * FROM ((SELECT track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date order by SR_NO desc) limit 5000  UNION ( SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date order by SR_NO desc  ) limit 5000 )main where ((REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"') OR (ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR (ENGINEER_GROUP IN('"+EnggGroup+"') AND ("+LoginScope+")) ) ORDER BY latest_date DESC limit 50 ");
					
				// querycount = getSession().createSQLQuery(" SELECT count(*) FROM (SELECT 	track.T_ID, track.ACTIVITY_DATE AS ACTIVITY_DATE,track.STATUS,COALESCE(tt.VIP_TICKET,'NA'), tt.T_REQUESTER AS REQUESTER,ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,tt.T_COMPANY AS T_COMPANY,tt.T_BRANCH AS T_BRANCH, tt.T_DEPARTMENT AS T_DEPARTMENT,latest_date FROM ticket_tracking track join ticket tt ON track.T_ID=tt.T_ID LEFT JOIN  ticket_assigned ta ON track.T_ID=ta.T_ID,(SELECT tin.T_ID, STATUS, MAX(STR_TO_DATE(tin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM ticket_tracking tin GROUP BY tin.T_ID) groupTicket WHERE  track.T_ID=groupTicket.T_ID AND STR_TO_DATE(track.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupTicket.latest_date UNION SELECT probTrack.PT_ID, probTrack.ACTIVITY_DATE AS ACTIVITY_DATE,  probTrack.PROBLEM_STATUS, COALESCE(ptt.VIP_TICKET,'NA'), ptt.PT_REQUESTER AS REQUESTER,pta.ENGINEER_NAME AS ENGINEER_NAME,pta.PT_ENGINEER_COMPANY AS ENGINEER_COMPANY,pta.ENGINEER_GROUP AS ENGINEER_GROUP,ptt.PT_COMPANY AS T_COMPANY,ptt.PT_BRANCH AS T_BRANCH,ptt.PT_DEPARTMENT AS T_DEPARTMENT,latest_date FROM problem_ticket_tracking probTrack JOIN  problem_ticket ptt ON probTrack.PT_ID=ptt.PT_ID LEFT JOIN  problem_ticket_assigned pta ON probTrack.PT_ID=pta.PT_ID,(SELECT ptin.PT_ID, ptin.PROBLEM_STATUS, MAX(STR_TO_DATE(ptin.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')) AS latest_date FROM problem_ticket_tracking ptin GROUP BY ptin.PT_ID) groupProblemTicket WHERE probTrack.PT_ID=groupProblemTicket.PT_ID AND STR_TO_DATE(probTrack.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s')=groupProblemTicket.latest_date )main where ((REQUESTER='"+LoginUser+"' AND T_COMPANY='"+loginUserCompany+"') OR (ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR (ENGINEER_GROUP IN('"+EnggGroup+"') AND ("+LoginScope+")) )");
				
			}

//				query.setParameter("T_ID", ticketid);
			//System.out.println("NOTIFICATION FOR QUERY: " + query);
			List<Object[]> l = query.list();
			//System.out.println("before count ");
		//	List<Object[]> J = querycount.list();
			if(DBType.contains("oracle")) {
				Number Counter = (Number)(querycount.uniqueResult());
				//System.out.println("NOTIFICATION COUNT long IS: " + Counter);
				array1 = new JSONArray();

				for (Object[] listData : l) {

					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					//System.out.println("NOTIFICATION COUNT FINAL IS: " + Counter);

					if (listData[3].toString().equals(LoginUser)) {
						Owner = "Self";
					} else {
						Owner = "Other";
					}

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
//					arrayobj.put("MESSAGE", listData[3].toString());
					arrayobj.put("COUNTER", Counter);
					arrayobj.put("OWNER", Owner);

					array1.put(arrayobj);

				}
			} else if (DBType.contains("mysql")) {

				Integer count=0;
//				BigInteger Counter = (BigInteger) querycount.uniqueResult();
			//	Object Counter = querycount.uniqueResult();
			//	//System.out.println("NOTIFICATION COUNT long IS: " + Counter);
				array1 = new JSONArray();

				for (Object[] listData : l) {
					count=l.size();
					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					////System.out.println("NOTIFICATION COUNT FINAL IS: " + count);

					if (listData[4].toString().equals(LoginUser)) {
						Owner = "Self";
					} else {
						Owner = "Other";
					}

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
					arrayobj.put("VIP_TICKET", listData[3].toString());
					arrayobj.put("COUNTER", count.toString());
					arrayobj.put("OWNER", Owner);

					array1.put(arrayobj);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
//System.out.println("ARRAY FINAL: "+array1);
		return array1;
}	
	@Override
	public JSONArray getTPOutage(String outage) {

		String DBType = environment.getRequiredProperty("jdbc.url");
		//System.out.println("Inside NotificationDaoImpl getTPOutage method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String ScopeDB = null;
		
		String companyDB = null;
		String branchDB = null;
		String departmentDB = null;
		
//		String LoginUserCompanyDB = null;
//		String LoginUserBranchDB = null;
//		String LoginUserDepartmentDB = null;

		////////////GET LOGGED IN SESSION USERNAME //////////////////
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("LoginUser****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			//////////////////////GET SCOPE OF LOGGED IN USER /////////////
			try {
				List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
				for (loginmaster catDrive : catList) {
//					//System.out.println("ENGG NAME: "+catDrive.getUSERNAME());
					ScopeDB=catDrive.getLOGIN_SCOPE();
//					LoginUserCompanyDB=catDrive.getCOMPANY();
//					LoginUserBranchDB=catDrive.getBRANCH();
//					LoginUserDepartmentDB=catDrive.getDEPARTMENT();
//					//System.out.println("LoginUserCompanyDB DB: "+LoginUserCompanyDB);
//					//System.out.println("LoginUserBranchDB DB: "+LoginUserBranchDB);
//					//System.out.println("LoginUserDepartmentDB DB: "+LoginUserDepartmentDB);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			///////////////////// GETTING OUTAGE DATA /////////////////////
		try {
			Query query = getSession().createQuery("from outage_master WHERE VISIBILITY='true' ORDER BY MSG_DATETIME DESC");
			List<outage_master> outageData = query.list();
			
					array1 = new JSONArray();
					for (outage_master outageDrive : outageData) {
						///////////////// LOOPING IN OUTAGE DATA //////////////
						companyDB=outageDrive.getCOMPANY_NAME();
						branchDB=outageDrive.getBRANCH_NAME();
						departmentDB=outageDrive.getDEPARTMENT_NAME();
//						//System.out.println("companyDB: "+companyDB);
//						//System.out.println("branchDB: "+branchDB);
//						//System.out.println("departmentDB: "+departmentDB);
						
					/////// SPLIT SCOPE STRING FOR 'OR' KEYWORD ///////////
						String[] SplitArray = ScopeDB.split("OR");
								/////// ITERATE STRING FOR 'OR' KEYWORD ///////////
						for (String splitString: SplitArray) { 
							//System.out.println("SPLIT STRING FOUND: "+splitString);
							String fetchCompany=StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
							String fetchBranch=StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
							String fetchDepartment=StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
							fetchBranch=fetchBranch.replaceAll("'", "");
							fetchDepartment=fetchDepartment.replaceAll("'", "");
							///////////////// COMPARE COMPANY //////////////////
//								 //System.out.println("FETCH COMPANY: "+fetchCompany); 
								 Boolean CompanyFlag=false;
								 if(fetchCompany==null)
								 {
									 CompanyFlag=false;
								 }
								 else if(fetchCompany.equals(companyDB))
								 {
									 CompanyFlag=true;
								 }
//								 //System.out.println("FETCH COMPANY FINAL: "+fetchCompany);
//								 //System.out.println("FETCH COMPANY FROM INPUT: "+companyDB);
//								 //System.out.println("FETCH COMPANY OF LOGIN USER: "+LoginUserCompanyDB);
//								 //System.out.println("FETCH COMPANY FLAG: "+CompanyFlag);
//								 //System.out.println("----------- COMPANY -----------------");
							 
								 ///////////////// COMPARE BRANCH //////////////////
								 Boolean BranchFlag=false;
								 //////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
									String[] branchPartsDB = branchDB.split(",");
									for (String singleBranchDB : branchPartsDB)
									{
//							            //System.out.println("singleBranchDB: "+singleBranchDB);
							            //////////////SPLIT BRANCH FROM USER SCOPE IF MULTIPLE FOUND /////////
							            String[] branchPartsScope = fetchBranch.split(",");
							            outer: for (String singleBranchScope : branchPartsScope)
										{
//								            //System.out.println("singleBranchScope: "+singleBranchScope);
								            if(singleBranchDB.equals(singleBranchScope))
								            {
								            	BranchFlag=true;
//								            	//System.out.println("COMMON BRANCH FOUND: "+singleBranchDB);
//								            	//System.out.println("COMMON BRANCH FOUND: "+singleBranchScope);
//								            	//System.out.println("---------- COMMON BRANCH DONE ------------: ");
												 break outer;
								            }
										}
									}
									
									///////////////// COMPARE DEPARTMENT //////////////////
									 Boolean DepartmentFlag=false;
									 //////////////SPLIT DEPARTMENT FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
										String[] departmentPartsDB = departmentDB.split(",");
										for (String singleDepartmentDB : departmentPartsDB)
										{
//								            //System.out.println("singleDepartmentDB: "+singleDepartmentDB);
								            //////////////SPLIT DEPARTMENT FROM USER SCOPE IF MULTIPLE FOUND /////////
								            String[] departmentPartsScope = fetchDepartment.split(",");
								            outer: for (String singleDepartmentScope : departmentPartsScope)
											{
//									            //System.out.println("singleDepartmentScope: "+singleDepartmentScope);
									            if(singleDepartmentDB.equals(singleDepartmentScope))
									            {
									            	DepartmentFlag=true;
//									            	//System.out.println("COMMON DEPARTMENT FOUND: "+singleDepartmentDB);
//									            	//System.out.println("COMMON DEPARTMENT FOUND: "+singleDepartmentScope);
//									            	//System.out.println("---------- COMMON DEPARTMENT DONE ------------: ");
													 break outer;
									            }
											}
										}
									
									
							 ///////////// COMPARISON DONE //////////////////

							 if(CompanyFlag && BranchFlag && DepartmentFlag) 
								{
								 	JSONObject arrayobj = new JSONObject();

									arrayobj.put("USERNAME", outageDrive.getUSERNAME());
									arrayobj.put("MESSAGE", outageDrive.getMESSAGE());
									arrayobj.put("SEVERITY", outageDrive.getSEVERITY());
									arrayobj.put("TIMESTAMP", outageDrive.getMSG_DATETIME());
									
									array1.put(arrayobj);
									
								}
						}

					}
		} catch (Exception e) {
			e.printStackTrace();

		}
		//System.out.println("ARRAY1: "+array1);
		return array1;
	}

	@Override
	public JSONArray getUserOutage(String outage) {
		String DBType = environment.getRequiredProperty("jdbc.url");
		//System.out.println("Inside NotificationDaoImpl getUserOutage method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;
		String LoginUser = null;
		String loginUserCompany = null;
				
		String UserCompanyDB = null;
		String UserBranchDB = null;
		String UserDepartmentDB = null;
		String OutageCompanyDB = null;
		String OutageBranchDB = null;
		String OutageDepartmentDB = null;

		////////////GET LOGGED IN SESSION USERNAME //////////////////
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("LoginUser****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			//////////////////////GET SCOPE OF LOGGED IN USER /////////////
			try {
				List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
				for (loginmaster catDrive : catList) {
					UserCompanyDB=catDrive.getCOMPANY();
					UserBranchDB=catDrive.getBRANCH();
					UserDepartmentDB=catDrive.getDEPARTMENT();
//					//System.out.println("USER COMPANY DB: "+UserCompanyDB);
//					//System.out.println("USER BRANCH DB: "+UserBranchDB);
//					//System.out.println("USER DEPARTMENT DB: "+UserDepartmentDB);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			///////////////////// GETTING OUTAGE DATA /////////////////////
		try {
			Query query = getSession().createQuery("from outage_master WHERE VISIBILITY='true' ORDER BY MSG_DATETIME DESC");
				List<outage_master> outageData = query.list();
			
					array1 = new JSONArray();
					for (outage_master outageDrive : outageData) {
						///////////////// LOOPING IN OUTAGE DATA //////////////
						OutageCompanyDB=outageDrive.getCOMPANY_NAME();
						OutageBranchDB=outageDrive.getBRANCH_NAME();
						OutageDepartmentDB=outageDrive.getDEPARTMENT_NAME();
//						//System.out.println("OutageCompanyDB: "+OutageCompanyDB);
//						//System.out.println("OutageBranchDB: "+OutageBranchDB);
//						//System.out.println("OutageDepartmentDB: "+OutageDepartmentDB);
						//System.out.println("------------------- START ---------------------");
						/////////////// COMPARE COMPANY /////////////////
						Boolean CompanyFlag=false;
						//System.out.println("USER COMPANY: "+UserCompanyDB);
						//System.out.println("OUTAGE COMPANY: "+OutageCompanyDB);
						if(UserCompanyDB.equals(OutageCompanyDB))
						{
							//System.out.println("****COMPANY MATCH FOUND****: "+OutageCompanyDB);
							CompanyFlag=true;
						}
						///////////////// COMPARE BRANCH //////////////////
						Boolean BranchFlag=false;
						
						//////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
						String[] branchPartsDB = OutageBranchDB.split(",");
						for (String singleBranchDB : branchPartsDB)
						{
							//System.out.println("USER BRANCH: "+UserBranchDB);
							//System.out.println("OUTAGE BRANCH: "+singleBranchDB);
							if(UserBranchDB.equals(singleBranchDB))
							{
								//System.out.println("****BRANCH MATCH FOUND****: "+singleBranchDB);
								BranchFlag=true;
							}
						}
						///////////////// COMPARE DEPARTMENT //////////////////
						Boolean DepartmentFlag=false;
						
						//////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
						String[] departmentPartsDB = OutageDepartmentDB.split(",");
						for (String singleDepartmentDB : departmentPartsDB)
						{
							//System.out.println("USER DEPARTMENT: "+UserDepartmentDB);
							//System.out.println("OUTAGE DEPARTMENT: "+singleDepartmentDB);
							if(UserDepartmentDB.equals(singleDepartmentDB))
							{
								//System.out.println("****DEPARTMENT MATCH FOUND****: "+singleDepartmentDB);
								DepartmentFlag=true;
							}
						}
						//System.out.println("------------------- END ---------------------");
						///////////// COMPARISON DONE //////////////////
						//System.out.println("CompanyFlag: "+CompanyFlag);
						//System.out.println("BranchFlag: "+BranchFlag);
						//System.out.println("DepartmentFlag: "+DepartmentFlag);
						if(CompanyFlag && BranchFlag && DepartmentFlag) 
						{
						 	JSONObject arrayobj = new JSONObject();

							arrayobj.put("USERNAME", outageDrive.getUSERNAME());
							arrayobj.put("MESSAGE", outageDrive.getMESSAGE());
							arrayobj.put("SEVERITY", outageDrive.getSEVERITY());
							arrayobj.put("TIMESTAMP", outageDrive.getMSG_DATETIME());
							
							array1.put(arrayobj);
							
						}

					}
		} catch (Exception e) {
			e.printStackTrace();

		}
		//System.out.println("ARRAY1: "+array1);
		return array1;
	}
	
	@Override
	public JSONArray getEnggOutage(String outage) {

		String DBType = environment.getRequiredProperty("jdbc.url");
		//System.out.println("Inside NotificationDaoImpl getEnggOutage method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String ScopeDB = null;
		
		String companyDB = null;
		String branchDB = null;
		String departmentDB = null;
		
		String LoginUserCompanyDB = null;
		String LoginUserBranchDB = null;
		String LoginUserDepartmentDB = null;

		////////////GET LOGGED IN SESSION USERNAME //////////////////
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("LoginUser****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			//////////////////////GET SCOPE OF LOGGED IN USER /////////////
			try {
				List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
				for (loginmaster catDrive : catList) {
//					//System.out.println("ENGG NAME: "+catDrive.getUSERNAME());
					ScopeDB=catDrive.getLOGIN_SCOPE();
					LoginUserCompanyDB=catDrive.getCOMPANY();
					LoginUserBranchDB=catDrive.getBRANCH();
					LoginUserDepartmentDB=catDrive.getDEPARTMENT();
//					//System.out.println("LoginUserCompanyDB DB: "+LoginUserCompanyDB);
//					//System.out.println("LoginUserBranchDB DB: "+LoginUserBranchDB);
//					//System.out.println("LoginUserDepartmentDB DB: "+LoginUserDepartmentDB);
//					//System.out.println("SCOPE DB: "+ScopeDB);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			///////////////////// GETTING OUTAGE DATA /////////////////////
		try {
			Query query = getSession().createQuery("from outage_master WHERE VISIBILITY='true' ORDER BY MSG_DATETIME DESC");
			List<outage_master> outageData = query.list();
			
					array1 = new JSONArray();
					for (outage_master outageDrive : outageData) {
						///////////////// LOOPING IN OUTAGE DATA //////////////
						companyDB=outageDrive.getCOMPANY_NAME();
						branchDB=outageDrive.getBRANCH_NAME();
						departmentDB=outageDrive.getDEPARTMENT_NAME();
//						//System.out.println("companyDB: "+companyDB);
//						//System.out.println("branchDB: "+branchDB);
//						//System.out.println("departmentDB: "+departmentDB);
						
					/////// SPLIT SCOPE STRING FOR 'OR' KEYWORD ///////////
						String[] SplitArray = ScopeDB.split("OR");
								/////// ITERATE STRING FOR 'OR' KEYWORD ///////////
						for (String splitString: SplitArray) { 
							//System.out.println("SPLIT STRING FOUND: "+splitString);
							String fetchCompany=StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
							String fetchBranch=StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
							String fetchDepartment=StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
							fetchBranch=fetchBranch.replaceAll("'", "");
							fetchDepartment=fetchDepartment.replaceAll("'", "");
							///////////////// COMPARE COMPANY //////////////////
//								 //System.out.println("FETCH COMPANY: "+fetchCompany); 
								 Boolean CompanyFlag=false;
								 if(fetchCompany==null)
								 {
									 CompanyFlag=false;
								 }
								 else if(fetchCompany.equals(companyDB) || fetchCompany.equals(LoginUserCompanyDB))
								 {
									 CompanyFlag=true;
								 }
//								 //System.out.println("FETCH COMPANY FINAL: "+fetchCompany);
//								 //System.out.println("FETCH COMPANY FROM INPUT: "+companyDB);
//								 //System.out.println("FETCH COMPANY FLAG: "+CompanyFlag);
//								 //System.out.println("----------- COMPANY -----------------");
							 
								 ///////////////// COMPARE BRANCH //////////////////
								 Boolean BranchFlag=false;
								 //////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
									String[] branchPartsDB = branchDB.split(",");
									for (String singleBranchDB : branchPartsDB)
									{
//							            //System.out.println("singleBranchDB: "+singleBranchDB);
							            //////////////SPLIT BRANCH FROM USER SCOPE IF MULTIPLE FOUND /////////
							            String[] branchPartsScope = fetchBranch.split(",");
							            outer: for (String singleBranchScope : branchPartsScope)
										{
//								            //System.out.println("singleBranchScope: "+singleBranchScope);
								            if(singleBranchDB.equals(singleBranchScope) || LoginUserBranchDB.equals(singleBranchDB))
								            {
								            	BranchFlag=true;
//								            	//System.out.println("COMMON BRANCH FOUND: "+singleBranchDB);
//								            	//System.out.println("COMMON BRANCH FOUND: "+singleBranchScope);
//								            	//System.out.println("---------- COMMON BRANCH DONE ------------: ");
												 break outer;
								            }
										}
									}
									
									///////////////// COMPARE DEPARTMENT //////////////////
									 Boolean DepartmentFlag=false;
									 //////////////SPLIT DEPARTMENT FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
										String[] departmentPartsDB = departmentDB.split(",");
										for (String singleDepartmentDB : departmentPartsDB)
										{
//								            //System.out.println("singleDepartmentDB: "+singleDepartmentDB);
								            //////////////SPLIT DEPARTMENT FROM USER SCOPE IF MULTIPLE FOUND /////////
								            String[] departmentPartsScope = fetchDepartment.split(",");
								            outer: for (String singleDepartmentScope : departmentPartsScope)
											{
//									            //System.out.println("singleDepartmentScope: "+singleDepartmentScope);
									            if(singleDepartmentDB.equals(singleDepartmentScope) || LoginUserDepartmentDB.equals(singleDepartmentDB))
									            {
									            	DepartmentFlag=true;
//									            	//System.out.println("COMMON DEPARTMENT FOUND: "+singleDepartmentDB);
//									            	//System.out.println("COMMON DEPARTMENT FOUND: "+singleDepartmentScope);
//									            	//System.out.println("---------- COMMON DEPARTMENT DONE ------------: ");
													 break outer;
									            }
											}
										}
									
									
							 ///////////// COMPARISON DONE //////////////////

							 if(CompanyFlag && BranchFlag && DepartmentFlag) 
								{
								 	JSONObject arrayobj = new JSONObject();

									arrayobj.put("USERNAME", outageDrive.getUSERNAME());
									arrayobj.put("MESSAGE", outageDrive.getMESSAGE());
									arrayobj.put("SEVERITY", outageDrive.getSEVERITY());
									arrayobj.put("TIMESTAMP", outageDrive.getMSG_DATETIME());
									
									array1.put(arrayobj);
									
								}
						}

					}
		} catch (Exception e) {
			e.printStackTrace();

		}
		//System.out.println("ARRAY1: "+array1);
		return array1;
	}

	@Override
	public JSONArray getITHeadOutage(String outage) {

		String DBType = environment.getRequiredProperty("jdbc.url");
		//System.out.println("Inside NotificationDaoImpl getUserOutage method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;
		String LoginUser = null;
		String loginUserCompany = null;
				
		String UserCompanyDB = null;
		String UserBranchDB = null;
		String UserDepartmentDB = null;
		String OutageCompanyDB = null;
		String OutageBranchDB = null;
		String OutageDepartmentDB = null;

		////////////GET LOGGED IN SESSION USERNAME //////////////////
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("LoginUser****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			//////////////////////GET SCOPE OF LOGGED IN USER /////////////
			try {
				List<loginmaster> catList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
				for (loginmaster catDrive : catList) {
					UserCompanyDB=catDrive.getCOMPANY();
					UserBranchDB=catDrive.getBRANCH();
					UserDepartmentDB=catDrive.getDEPARTMENT();
//					//System.out.println("USER COMPANY DB: "+UserCompanyDB);
//					//System.out.println("USER BRANCH DB: "+UserBranchDB);
//					//System.out.println("USER DEPARTMENT DB: "+UserDepartmentDB);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			///////////////////// GETTING OUTAGE DATA /////////////////////
		try {
			Query query = getSession().createQuery("from outage_master WHERE VISIBILITY='true' ORDER BY MSG_DATETIME DESC");
				List<outage_master> outageData = query.list();
			
					array1 = new JSONArray();
					for (outage_master outageDrive : outageData) {
						///////////////// LOOPING IN OUTAGE DATA //////////////
						OutageCompanyDB=outageDrive.getCOMPANY_NAME();
						OutageBranchDB=outageDrive.getBRANCH_NAME();
						OutageDepartmentDB=outageDrive.getDEPARTMENT_NAME();
//						//System.out.println("OutageCompanyDB: "+OutageCompanyDB);
//						//System.out.println("OutageBranchDB: "+OutageBranchDB);
//						//System.out.println("OutageDepartmentDB: "+OutageDepartmentDB);
						//System.out.println("------------------- START ---------------------");
						/////////////// COMPARE COMPANY /////////////////
						Boolean CompanyFlag=false;
						//System.out.println("USER COMPANY: "+UserCompanyDB);
						//System.out.println("OUTAGE COMPANY: "+OutageCompanyDB);
						if(UserCompanyDB.equals(OutageCompanyDB))
						{
							//System.out.println("****COMPANY MATCH FOUND****: "+OutageCompanyDB);
							CompanyFlag=true;
						}
						///////////////// COMPARE BRANCH //////////////////
						Boolean BranchFlag=false;
						
						//////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
						String[] branchPartsDB = OutageBranchDB.split(",");
						for (String singleBranchDB : branchPartsDB)
						{
							//System.out.println("USER BRANCH: "+UserBranchDB);
							//System.out.println("OUTAGE BRANCH: "+singleBranchDB);
							if(UserBranchDB.equals(singleBranchDB))
							{
								//System.out.println("****BRANCH MATCH FOUND****: "+singleBranchDB);
								BranchFlag=true;
							}
						}
						///////////////// COMPARE DEPARTMENT //////////////////
						Boolean DepartmentFlag=false;
						
						//////////////SPLIT BRANCH FROM OUTAGE MASTER IF MULTIPLE FOUND /////////
						String[] departmentPartsDB = OutageDepartmentDB.split(",");
						for (String singleDepartmentDB : departmentPartsDB)
						{
							//System.out.println("USER DEPARTMENT: "+UserDepartmentDB);
							//System.out.println("OUTAGE DEPARTMENT: "+singleDepartmentDB);
							if(UserDepartmentDB.equals(singleDepartmentDB))
							{
								//System.out.println("****DEPARTMENT MATCH FOUND****: "+singleDepartmentDB);
								DepartmentFlag=true;
							}
						}
						//System.out.println("------------------- END ---------------------");
						///////////// COMPARISON DONE //////////////////
						//System.out.println("CompanyFlag: "+CompanyFlag);
						//System.out.println("BranchFlag: "+BranchFlag);
						//System.out.println("DepartmentFlag: "+DepartmentFlag);
						if(CompanyFlag && BranchFlag && DepartmentFlag) 
						{
						 	JSONObject arrayobj = new JSONObject();

							arrayobj.put("USERNAME", outageDrive.getUSERNAME());
							arrayobj.put("MESSAGE", outageDrive.getMESSAGE());
							arrayobj.put("SEVERITY", outageDrive.getSEVERITY());
							arrayobj.put("TIMESTAMP", outageDrive.getMSG_DATETIME());
							
							array1.put(arrayobj);
							
						}

					}
		} catch (Exception e) {
			e.printStackTrace();

		}
		//System.out.println("ARRAY1: "+array1);
		return array1;
	
	}

	@Override
	public JSONArray getItHeadNotification(String notify) {

		//System.out.println("Inside NotificationDaoImpl Notification_User method");
		String status = null;
		JSONArray array = null;
		JSONArray array1 = null;

		String DBType = environment.getRequiredProperty("jdbc.url");
		String LoginUser = null;
		String LoginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
			//System.out.println("companyname****" + LoginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			
			Query query = null;
			Query querycount = null;

			if (DBType.contains("oracle")) {

				//System.out.println("********************ORACLE QUERY*************************************");

				query = getSession().createSQLQuery("Select * From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) WHERE ROWNUM<=20");

				querycount = getSession().createSQLQuery("Select count(*) From (SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM ( SELECT ROW_NUMBER() OVER (PARTITION BY T_ID ORDER BY TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) as num, t.T_ID, t.ACTIVITY_DATE, t.STATUS, t.MESSAGE FROM TICKET_TRACKING t where t.TICKET_RAISED_NAME ='"+LoginUser+"') inn WHERE  inn.num = 1 order by TO_TIMESTAMP(ACTIVITY_DATE,'DD/MM/YY HH24:MI:SS') DESC) ");
				
			} else if (DBType.contains("mysql")) {

				//System.out.println("********************MySQL QUERY*************************************");

query = getSession().createSQLQuery("SELECT inn.T_ID,inn.ACTIVITY_DATE,inn.STATUS,inn.MESSAGE FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number , @prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x,  (SELECT @prev_val \\:= '') y WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' AND t.TICKET_RAISED_NAME_COMPANY='"+LoginUserCompany+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1  ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
				
				querycount = getSession().createSQLQuery("SELECT COUNT(*) FROM(SELECT @row_no \\:= IF(@prev_val = t.T_ID, @row_no + 1, 1) AS row_number , @prev_val \\:= t.T_ID AS T_ID ,t.ACTIVITY_DATE, t.STATUS,t.MESSAGE FROM TICKET_TRACKING t , (SELECT @row_no \\:= 0) x, (SELECT @prev_val \\:= '') y  WHERE t.TICKET_RAISED_NAME ='"+LoginUser+"' AND t.TICKET_RAISED_NAME_COMPANY='"+LoginUserCompany+"' ORDER BY t.T_ID DESC,STR_TO_DATE(t.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC)inn WHERE row_number<=1 ORDER BY STR_TO_DATE(inn.ACTIVITY_DATE,'%d-%m-%Y %H:%i:%s') DESC LIMIT 20");
				
			}

			//System.out.println("inside getUserNotification");

//				query.setParameter("T_ID", ticketid);
			//System.out.println("NOTIFICATION FOR QUERY: " + query);
			List<Object[]> l = query.list();
			List<Object[]> J = querycount.list();

			if(DBType.contains("oracle")) {
				Number Counter = (Number)(querycount.uniqueResult());
				//System.out.println("NOTIFICATION COUNT long IS: " + Counter);

				array1 = new JSONArray();
				for (Object[] listData : l) {

					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
					arrayobj.put("MESSAGE", listData[3].toString());
					arrayobj.put("COUNTER", Counter);

					array1.put(arrayobj);

				}
			} else if(DBType.contains("mysql")) {
				
				BigInteger Counter = (BigInteger)(querycount.uniqueResult());
				//System.out.println("NOTIFICATION COUNT long IS: " + Counter);

				array1 = new JSONArray();
				for (Object[] listData : l) {

					//System.out.println("FIRST DATA: " + listData[0].toString());

					JSONObject arrayobj = new JSONObject();

					arrayobj.put("T_ID", listData[0]);
					arrayobj.put("ACTIVITY_DATE", listData[1].toString());
					arrayobj.put("STATUS", listData[2].toString());
					arrayobj.put("MESSAGE", listData[3].toString());
					arrayobj.put("COUNTER", Counter);

					array1.put(arrayobj);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return array1;
	
	}
}
