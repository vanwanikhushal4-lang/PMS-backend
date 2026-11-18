package com.velox.itsm.dao;

import javax.transaction.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.stereotype.Repository;

import com.velox.itsm.ATM.ConstructDemo;
import com.velox.itsm.ATM.ConstructProblemDemo;
import com.velox.itsm.model.ADD_MAIL_TEMPLATE;
import com.velox.itsm.model.EFORM_MAIL_TEMPLATE;
import com.velox.itsm.model.Login;
import com.velox.itsm.model.SOFTWARE_RELEASE;
import com.velox.itsm.model.SOFTWARE_REQUEST;
import com.velox.itsm.model.SOFTWARE_TRANSFER;
import com.velox.itsm.model.departmentnames;
import com.velox.itsm.model.enggmaster;
import com.velox.itsm.model.loginmaster;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.problem_ticket;
import com.velox.itsm.model.problem_ticket_assigned;
import com.velox.itsm.model.service_request;
import com.velox.itsm.model.sms_config;
import com.velox.itsm.model.ticket;
import com.velox.itsm.model.ticket_assigned;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.usermaster;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;
import javax.mail.*;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

@Repository("EmailSMSDao")
@Transactional
public class EmailSMSDaoImpl implements EmailSMSDao {

	@Autowired
	SessionFactory sessionFactory;

	public String id;
	public int id1;

	public String name1 = "";
	public String status = "";
	public String site = "";
	public String category = "";
	public String subject = "";
	public String description = "";
	public String priority = "";
	public String priorityname1 = "";

	public String RaiseNCloseEmailSMS(int id, String username, String status, String site, String category,
			String subject, String enggname, String priority, String phone, String email) {

		System.out.println("enter in daoImpl method------------status==" + status + " priority==" + priority);
		String output = "";
		int srno = 1;
		String URL1 = "";
		String URL2 = "";
		String url12 = "";
		String holdperson = "";
		String closename = "";
		int crno = 1;
		// status="Raise";
		String crfRaisedBy = name1;
		String branch = site;
		category = category;
		String subCategory = "HDD";
		String riskType = priority;
		System.out.println("take a new values-------------------");
		try {

			Date date = null;
			date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String mysqldate = formatter.format(date);
			System.out.println("Sql Date---------------------" + formatter.format(date));

			Query query = sessionFactory.getCurrentSession().createQuery("from sms_config");

			List<sms_config> dataList = query.list();
			System.out.println("before user if" + dataList);
			for (sms_config dataList12 : dataList) {
				URL1 = dataList12.getURL();
				URL2 = dataList12.getPARAM();
				System.out.println("url1***-----------------" + URL1 + "\nurl2***-------------------" + URL2);
				String url = URL1.concat("?");
				url = url.concat(URL2);
				System.out.println("After concat***---------------------u1+u2===" + url);
				String Num = "";
				String Num1 = "";
				String NumU = "";
				String Num2 = "";
				String Num3 = "";

				System.out.println("sms sending when tricket is raised------------------------Status==" + status);

				if (status.equalsIgnoreCase("Raise")) {

					System.out.println("in raised....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select TP_PHONE from tpmaster where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getTP_PHONE();
						System.out.println("Numberaaaaaa:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					Num1 = Num1.replaceFirst(",", "");
					System.out.println("num1 in raise ticket::--------------------" + Num1);

					System.out.println("Now Msg generate in if statement Num1:::--------------------" + Num1);

					Num2 = phone;
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2;

					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20User%20has%20Raised%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "New" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

				}

				else if (status.equalsIgnoreCase("Assigned")) {
					System.out.println("in raised....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select E_PHONE from enggmaster where E_NAME='" + enggname + "'");
					List<enggmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
							.list();
					for (enggmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getE_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from tpmaster where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getTP_PHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							enggname.toUpperCase() + "%20Engineer%20has%20Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priority
									+ "%0aOn%20" + mysqldate);

				}

				else if (status.equalsIgnoreCase("Re-Assigned")) {

					System.out.println("in raised....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select E_PHONE from enggmaster where E_NAME='" + enggname + "'");
					List<enggmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
							.list();
					for (enggmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getE_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from tpmaster where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getTP_PHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							enggname.toUpperCase() + "%20Engineer%20has%20Re-Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "Re-Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priority
									+ "%0aOn%20" + mysqldate);

				}

				else if (status.equalsIgnoreCase("Hold")) {

					String arr[] = site.split(",");
					site = arr[0];
					holdperson = arr[1];

					System.out.println("in resolved....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from TPMASTER where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getTP_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select E_PHONE from enggmaster where E_NAME='" + enggname + "'");
					List<enggmaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
							.list();
					for (enggmaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getE_PHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							holdperson.toUpperCase() + "%20Hold%20Ticket-ID%20" + id + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + arr[0] + "%0aStatus :%20" + "Hold"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

				}

				else if (status.equalsIgnoreCase("Reopened")) {
					System.out.println("in resolved....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from TPMASTER where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getTP_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select E_PHONE from enggmaster where E_NAME='" + enggname + "'");
					List<enggmaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
							.list();
					for (enggmaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getE_PHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20User%20has%20Re-Open%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "Re-Open" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priority
									+ "%0aOn%20" + mysqldate);

				}

				else if (status.equalsIgnoreCase("Resolved")) {
					System.out.println("in resolved....................");

					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from TPMASTER where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getTP_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select E_PHONE from enggmaster where E_NAME='" + enggname + "'");
					List<enggmaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
							.list();
					for (enggmaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getE_PHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							enggname.toUpperCase() + "%20Engineer%20has%20Resolved%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "Resolved" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priority
									+ "%0aOn%20" + mysqldate);

				}

				else if (status.equalsIgnoreCase("Closed")) {
					System.out.println("in resolved....................priority=" + priority);
					String arr1[] = priority.split(",");
					System.out.println("in resolved....................arr[0]=" + arr1[0]);
					System.out.println("in resolved....................arr[1]=" + arr1[1]);

					priorityname1 = arr1[0];
					closename = arr1[1];
					System.out.println("in resolved....................");

					String[] parts = site.split(",");
					site = parts[0];
					// String tpname = parts[1];
					System.out.println("tp category==" + category);
					Query query2 = sessionFactory.getCurrentSession()
							.createSQLQuery("select TP_PHONE from TPMASTER where TP_DEPARTMENT='" + category + "'");
					List<tpmaster> UserNOs = query2.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
							.list();
					for (tpmaster UserNOs1 : UserNOs) {
						Num = UserNOs1.getTP_PHONE();
						System.out.println("Numberaaaaaaof enggggggg:::--------------------" + Num);
						Num1 = Num1 + "," + Num;

					}
					System.out.println("Num1=======" + Num1);
					// for user akash

					System.out.println("user username==" + username);
					Query query3 = sessionFactory.getCurrentSession()
							.createSQLQuery("Select PHONE from usermaster where NAME='" + username + "'");
					List<usermaster> UserNOsU = query3.setResultTransformer(Transformers.aliasToBean(usermaster.class))
							.list();
					for (usermaster UserNOs1U : UserNOsU) {
						NumU = UserNOs1U.getPHONE();
						System.out.println("Numberaaaaaaof user:::--------------------" + NumU);
						Num2 = Num2 + "," + NumU;

					}
					System.out.println("Num2=======" + Num2);
					Num3 = Num1 + "," + Num2 + "," + phone;
					Num3 = Num3.replaceFirst(",", "");
					Num1 = Num3;
					System.out.println("n1=n3=num3 in assigned ticket::--------------------" + Num3);

					System.out.println("Now Msg generate in if statement for engggg:::--------------------" + Num3);

					url = url.replace("spalert_msg",
							closename.toUpperCase() + "%20Ticket%20has%20Closed%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + site + "%0aStatus :%20"
									+ "Closed" + "%0aSubject :%20" + subject + "%0aPriority :%20" + priorityname1
									+ "%0aOn%20" + mysqldate);

				}

				url12 = url.replace("spalert_contact", Num1);
				if (url12.contains(" "))
					url12 = url12.replace(" ", "%20");
				System.out.println("url connect***--------------------" + url12);

			}

			System.out.println("email start----------------status==" + status);
			String hostname = "";
			int port = 587;
			String Senderid = "";
			String pass = "";
			String mailid = "";
			String usermail = "";
			String usermail1 = "";
			String ccusermail = "";
			String causermail = "";
			String auth = "";
			String authval = "";
			String a = "";

			Query query23 = sessionFactory.getCurrentSession().createQuery("from mail_config");

			List<mail_config> dataList12 = query23.list();
			System.out.println("before user if" + dataList12);
			for (mail_config dataList23 : dataList12) {
				hostname = dataList23.getHOST();
				port = dataList23.getPORT();
				Senderid = dataList23.getSENDERID();
				pass = dataList23.getPASSWRD();
				mailid = dataList23.getE_MAIL();
				auth = dataList23.getAUTHO();

				System.out.println("Sender email get----------------" + mailid);
			}

			if (auth.equalsIgnoreCase("Yes")) {
				authval = "true";
			} else if (auth.equalsIgnoreCase("No")) {
				authval = "false";
			} else {
				authval = "false";
			}

			final String Senderid1 = Senderid;
			final String pass1 = pass;
			//
			int count = 0;
			Properties props = new Properties();

			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.starttls.enable", "false");
			props.put("mail.smtp.auth", authval);
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.port", "" + port);

			System.out.println("all propert set----------------status=" + status);
//					
			final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// System.out.println("session value============"+session);
					System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
							+ " pass1=" + pass1);
					return new PasswordAuthentication(Senderid1, pass1);
				}
			});

			String nunknownmail = "";
			String usermail55 = "";
			String usermail66 = "";
			String cc = "";
			String tpname = "";

			if (status.equalsIgnoreCase("Raise")) {
				System.out.println("in raise mailll ========");
				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select TP_MAIL from tpmaster where TP_DEPARTMENT='" + category + "'"); // for
																												// to
																												// email
				List<tpmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(tpmaster.class)).list();
				for (tpmaster UserMails1 : UserMails) {
					usermail = UserMails1.getTP_MAIL();
					System.out.println("get email of tp---------------" + usermail);

					usermail1 = usermail1 + "," + usermail;
					System.out.println("email concat with comm---------------" + usermail1);
				}

				// for cc user
				nunknownmail = email;
				System.out.println("Email id TO==" + usermail1);
				System.out.println("Email id CC==" + nunknownmail);

			} // if close

			else if (status.equalsIgnoreCase("Assigned")) {
				System.out.println("in assign mailll========");
				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select E_MAIL from enggmaster where E_NAME='" + enggname + "'"); // for to
																											// email
				List<enggmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
						.list();
				for (enggmaster UserMails1 : UserMails) {
					usermail = UserMails1.getE_MAIL();
					System.out.println("get email of mayur---------------" + usermail);

					usermail1 = usermail1 + "," + usermail;
					System.out.println("email concat with comm---------------" + usermail1);
				}

				System.out.println("All Emails......" + usermail1 + " category=" + category);
				usermail1 = usermail1.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + usermail1);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'");
				List<tpmaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (tpmaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getTP_MAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + email;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC user mail====" + nunknownmail);
			}

			else if (status.equalsIgnoreCase("Reopened")) {
				System.out.println("in assign mailll========");
				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select E_MAIL from enggmaster where E_NAME='" + enggname + "'"); // for to
																											// email
				List<enggmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
						.list();
				for (enggmaster UserMails1 : UserMails) {
					usermail = UserMails1.getE_MAIL();
					System.out.println("get email of mayur---------------" + usermail);

					usermail1 = usermail1 + "," + usermail;
					System.out.println("email concat with comm---------------" + usermail1);
				}

				System.out.println("All Emails......" + usermail1 + " category=" + category);
				usermail1 = usermail1.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + usermail1);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'");
				List<tpmaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (tpmaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getTP_MAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + email;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC user mail====" + nunknownmail);
			}

			else if (status.equalsIgnoreCase("Closed")) {
				System.out.println("in assign mailll========");

				usermail1 = email;

				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select MAIL from usermaster where NAME='" + username + "'"); // for to email
				List<usermaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(usermaster.class))
						.list();
				for (usermaster UserMails1 : UserMails) {
					usermail = UserMails1.getMAIL();

					System.out.println("get email of mayur---------------" + usermail);

					cc = cc + "," + usermail;
					System.out.println("email concat with comm---------------" + cc);
				}

				System.out.println("All Emails......" + cc + " category=" + category);
				cc = cc.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + cc);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'");
				List<tpmaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (tpmaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getTP_MAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + cc;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC user mail====" + nunknownmail);
			}

			else if (status.equalsIgnoreCase("Re-Assigned")) {
				System.out.println("in assign mailll========");
				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select E_MAIL from enggmaster where E_NAME='" + enggname + "'"); // for to
																											// email
				List<enggmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
						.list();
				for (enggmaster UserMails1 : UserMails) {
					usermail = UserMails1.getE_MAIL();
					System.out.println("get email of mayur---------------" + usermail);

					usermail1 = usermail1 + "," + usermail;
					System.out.println("email concat with comm---------------" + usermail1);
				}

				System.out.println("All Emails......" + usermail1 + " category=" + category);
				usermail1 = usermail1.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + usermail1);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'");
				List<tpmaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (tpmaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getTP_MAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + email;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC user mail====" + nunknownmail);
			}

			else if (status.equalsIgnoreCase("Hold")) {
				System.out.println("in assign mailll========");

				usermail1 = email;

				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select E_MAIL from enggmaster where E_NAME='" + enggname + "'"); // for to
																											// email
				List<enggmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(enggmaster.class))
						.list();
				for (enggmaster UserMails1 : UserMails) {
					cc = cc + "," + UserMails1.getE_MAIL();
					System.out.println("get email of mayur---------------" + cc);

					System.out.println("email concat with comm---------------" + cc);
				}

				System.out.println("All Emails......" + cc + " category=" + category);
				// usermail1 = usermail1.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + cc);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'");
				List<tpmaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(tpmaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (tpmaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getTP_MAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + cc;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC engg n self user mail====" + nunknownmail);
			}

			else if (status.equalsIgnoreCase("Resolved")) {
				System.out.println("in assign mailll========");

				// usermail1=email;

				Query query4 = sessionFactory.getCurrentSession()
						.createSQLQuery("select TP_MAIL from TPMASTER where TP_DEPARTMENT='" + category + "'"); // for
																												// to
																												// email
				List<tpmaster> UserMails = query4.setResultTransformer(Transformers.aliasToBean(tpmaster.class)).list();
				for (tpmaster UserMails1 : UserMails) {
					usermail1 = usermail1 + "," + UserMails1.getTP_MAIL();
					System.out.println("get email of mayur---------------" + usermail1);

					System.out.println("email concat with comm---------------" + usermail1);
				}

				System.out.println("All Emails......" + usermail1 + " category=" + category);
				// usermail1 = usermail1.replaceFirst(",", "");
				System.out.println("email replace with comm---------------" + usermail1);

				Query query3 = sessionFactory.getCurrentSession()
						.createSQLQuery("Select MAIL from usermaster where NAME='" + username + "'");
				List<usermaster> UserMails2 = query3.setResultTransformer(Transformers.aliasToBean(usermaster.class))
						.list();
				System.out.println("list ===" + UserMails2);
				for (usermaster UserMails1 : UserMails2) {
					nunknownmail = nunknownmail + "," + UserMails1.getMAIL();
					System.out.println("unknown email fetch ==================......" + nunknownmail);
					// break;

				}
				nunknownmail = nunknownmail + "," + email;
				nunknownmail = nunknownmail.replaceFirst(",", "");
//					nunknownmail=a;
				System.out.println("assigned To user mail====" + usermail1);
				System.out.println("assigned CC engg n self user mail====" + nunknownmail);
			}

			if (status.equalsIgnoreCase("Raise")) {
				status = "New";
			}

			String title = "";
			String mailbody = status + " Ticket Alert";
			String mainMSG = "";

			// dynamic title from DB

			try {

				System.out.println("Before Projection List ");
				// Session s = getSession();
				// System.out.println("s =" + s);

				List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
						.createQuery("from ADD_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

				for (ADD_MAIL_TEMPLATE a1 : dataList1) {
					String st = a1.getSTATUS();
					System.out.println("status from template==" + st);
					System.out.println("status from method==" + status);
					if (st.equals(status)) {
						System.out.println("Inside if block");

						title = a1.getSUBJECT();
						mailbody = a1.getMAILBODY();
						System.out.println("title==" + title);

						title = title.replaceAll("!", String.valueOf(id));

						title = title.replaceAll("#", status);
						title = title.replaceAll("@", priority);
						System.out.println("name==" + title);

						System.out.println("mailbody==" + mailbody);

						mailbody = mailbody.replaceAll("!", String.valueOf(id));

						mailbody = mailbody.replaceAll("#", status);
						mailbody = mailbody.replaceAll("@", priority);
						mailbody = mailbody.replaceAll("~", username);
						mailbody = mailbody.replaceAll("�", enggname);
						System.out.println("mailbody==" + mailbody);
						break;
					} else {
						System.out.println("Inside else block");
						if (status.equalsIgnoreCase("New")) {
							title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority;
						}
						if (status.equalsIgnoreCase("Reopened")) {
							title = "Ticket Status: Re-Open || Ticket ID: " + id + " || Priority : " + priority;
						} else if (status.equalsIgnoreCase("Closed")) {
							title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority;
						}

						else if (status.equalsIgnoreCase("Assigned")) {
							title = "Ticket Status: Assigned || Ticket ID: " + id + " || Priority : " + priority;
						} else if (status.equalsIgnoreCase("Re-Assigned")) {
							title = "Ticket Status: Re-Assigned || Ticket ID: " + id + " || Priority : " + priority;
						} else if (status.equalsIgnoreCase("Resolved")) {
							title = "Ticket Status: Resolved || Ticket ID: " + id + " || Priority : " + priority;
						} else if (status.equalsIgnoreCase("Hold")) {
							title = "Ticket Status: Hold || Ticket ID: " + id + " || Priority : " + priority;
						}
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			// end here

			if (status.equalsIgnoreCase("New")) {
				System.out.println("in raise status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Raised By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Raised  <br></td> <td>"
						+ id + "</td> <td>" + username.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "New" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>" + mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			if (status.equalsIgnoreCase("Reopened")) {
				System.out.println("in raise status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Raised By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Re-Open  <br></td> <td>"
						+ id + "</td> <td>" + username.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Re-Open" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>"
						+ mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			if (status.equalsIgnoreCase("Closed")) {
				System.out.println("in raise status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Closed By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Closed <br></td> <td>"
						+ id + "</td> <td>" + closename.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Closed" + "</td><td>" + subject + "</td><td>" + mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			else if (status.equalsIgnoreCase("Assigned")) {
				System.out.println("in assgn status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Assigned  <br></td> <td>"
						+ id + "</td> <td>" + enggname.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Assigned" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>"
						+ mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			else if (status.equalsIgnoreCase("Re-Assigned")) {
				System.out.println("in assgn status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Re-Assigned  <br></td> <td>"
						+ id + "</td> <td>" + enggname.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Re-Assigned" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>"
						+ mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			else if (status.equalsIgnoreCase("Resolved")) {
				System.out.println("in assgn status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Resolved  <br></td> <td>"
						+ id + "</td> <td>" + enggname.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Resolved" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>"
						+ mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			else if (status.equalsIgnoreCase("Hold")) {
				System.out.println("in res status cond=----------------");

				mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
						+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Name</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Hold <br></td> <td>"
						+ id + "</td> <td>" + holdperson.toUpperCase() + "</td> <td>" + category + "</td><td>" + site
						+ "</td><td>" + "Hold" + "</td><td>" + subject + "</td><td>" + priority + "</td><td>"
						+ mysqldate
						+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				System.out.println("message======" + mainMSG);
			}

			System.out.println("session value==" + session);
			Message message = new MimeMessage(session);
			//
			message.setFrom(new InternetAddress(mailid));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usermail1));
			InternetAddress[] parse = InternetAddress.parse(nunknownmail, true);
			// InternetAddress.parse(""+usermail1+"")
			message.addRecipients(Message.RecipientType.CC, parse);

//					 if(status.equalsIgnoreCase("Raise")){
//						 title="Ticket Status: New || Ticket ID: "+ id +" || Priority : "+priority ;
//					}
//					 if(status.equalsIgnoreCase("Reopened")){
//						 title="Ticket Status: Re-Open || Ticket ID: "+ id +" || Priority : "+priority ;
//						}
//					else if(status.equalsIgnoreCase("Closed")){
//						 title="Ticket Status: Closed || Ticket ID: "+ id +" || Priority : "+priority ;
//					}
//					
//					
//					else if(status.equalsIgnoreCase("Assigned")){
//						 title="Ticket Status: Assigned || Ticket ID: "+ id +" || Priority : "+priority ;
//					}
//					else if(status.equalsIgnoreCase("Re-Assigned")){
//						 title="Ticket Status: Re-Assigned || Ticket ID: "+ id +" || Priority : "+priority ;
//					r}
//					else if(status.equalsIgnoreCase("Resolved")){
//						 title="Ticket Status: Resolved || Ticket ID: "+ id +" || Priority : "+priority ;
//					}
//					else if(status.equalsIgnoreCase("Hold")){
//						 title="Ticket Status: Hold || Ticket ID: "+ id +" || Priority : "+priority ;
//					}

			message.setSubject(title);

			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setContent(mainMSG, "text/html");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			try {
				System.out.println("Thread is calling started.....");
				Thread t = new Thread(new ConstructDemo(url12, message));
				t.join();
				t.start();
				System.out.println("Thread is calling finished.....");
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e3) {
			e3.printStackTrace();
		}

		return output;
	}

	@Override
	public String RaiseNCloseProblemEmailSMS(String ticketID, String TicketStatus) {

		String CompForTemp = "";
		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession sessionForCompany = requestAttributes1.getRequest().getSession();
		CompForTemp = sessionForCompany.getAttribute("companyname").toString();
	
		System.out.println("loginUserCompany****" + CompForTemp);
		String EmailTrigger = "";
		String ticketType="";
		String mailFooter="";
		Query queryD= sessionFactory.getCurrentSession().createQuery(
				"from ADD_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + CompForTemp + "' ");
		List<ADD_MAIL_TEMPLATE> list = queryD.list();
		for (ADD_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		
		if (EmailTrigger.equals("Yes")&& ticketType.equals("Problem Ticket")) {
	
		status = TicketStatus;
		id = ticketID;
		System.out.println("Inside EmailSMSTriggered ");
		System.out.println("ticketID:" + ticketID + " TicketStatus:" + TicketStatus);

		String enggname = "NA";

		String sms_config_URL = "";
		String sms_config_Param = "";
		String url12 = "";
		String department = "NA";
		String company = "NA";
		String branch = "NA";
		String username = "NA";
		String url = "";
		String category = "";

		String branchforMail = "";
		String companyforMail = "";
		String departmentforMail = "";
		String suncat1forMail = "";
		String subcat2forMail = "";

		String subject = "";
		String priority = "";
		String severity = "";
		String mailIDForCC = "";
		String mailIDForTo = "";
		String ticketUserMailID = "";
		String engNameOrGrpName = "NA";

		String engPh = "";
		String tcPh = "";
		String userPh = "";
		String phonenum = "";
		String loginUserPh = "";
		String assignTo = "";
		String engGroup = "";
		String engName = "";
		String companyname1 = "";
		String EMAILFORTO = "";

		try {
			
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			username = session.getAttribute("username").toString();

			HttpSession session1 = requestAttributes.getRequest().getSession();
			companyname1 = session.getAttribute("companyname").toString();

			System.out.println("COMPANY NAME IS ::::::  " + companyname1);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		String loginUserMailID = "";
		String loginUserRole = "";
		try {
			List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession()
					.createQuery(
							"from loginmaster where USERNAME = '" + username + "' and COMPANY= '" + companyname1 + "'")
					.list();

			for (loginmaster lg : loginMaster1) {

				loginUserMailID = lg.getEMAIL();
				loginUserPh = lg.getPHONE();
				loginUserRole = lg.getROLE_TYPE();
			}
			System.out.println("loginUserMailID:" + loginUserMailID);

		} catch (Exception e) {
			e.printStackTrace();

		}

		try {

			Date date = null;
			date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String mysqldate = formatter.format(date);

			Query query = sessionFactory.getCurrentSession()
					.createQuery("from sms_config  where COMPANY='" + companyname1 + "'");

			List<sms_config> dataList = query.list();
			for (sms_config dataList12 : dataList) {
				sms_config_URL = dataList12.getURL();
				sms_config_Param = dataList12.getPARAM();
				System.out.println("sms_config_URL:" + sms_config_URL);
				System.out.println("sms_config_Param:" + sms_config_Param);
				url = sms_config_URL.concat("?");
				url = url.concat(sms_config_Param);

			}

			String verifiedTP = "";
			String TPMobNo = "";
			String verifiedTPMails = "";

			Query queryticketRaise = sessionFactory.getCurrentSession()
					.createQuery("from problem_ticket where PT_ID=:PT_ID");
			queryticketRaise.setParameter("PT_ID", ticketID);
			List<problem_ticket> ticketTracking = queryticketRaise.list();

			for (problem_ticket ticket : ticketTracking) {
				department = ticket.getPT_DEPARTMENT();
				company = ticket.getPT_COMPANY();
				branch = ticket.getPT_BRANCH();

				category = ticket.getT_PROBLEM_CATEGORY();
				branchforMail = ticket.getPT_BRANCH();
				subject = ticket.getPT_SUBJECT();
				priority = ticket.getPRIORITY();
				severity = ticket.getSEVERITY();
				ticketUserMailID = ticket.getPT_MAIL();
				companyforMail = ticket.getPT_COMPANY();
				departmentforMail = ticket.getPT_DEPARTMENT();
				suncat1forMail = ticket.getT_PROBLEM_SUBCAT1();
				subcat2forMail = ticket.getT_PROBLEM_SUBCAT2();

			}

			List<loginmaster> catList = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where ROLE_TYPE='Ticket Co-ordinator'").list();
			for (loginmaster catDrive : catList) {

				////// CHECK SCOPE /////
				System.out.println("----------- START----------");
				String ScopeDB = catDrive.getLOGIN_SCOPE();
				System.out.println("Ticket Co-ordinator NAME: " + catDrive.getUSERNAME());
				System.out.println("Ticket Co-ordinator SCOPE DB: " + ScopeDB);
				boolean userVerified = false;

				if (ScopeDB != null && branch != null && company != null && department != null) {
					if (ScopeDB.contains(company) && ScopeDB.contains(branch) && ScopeDB.contains(department)) {

						/////// SPLIT STRING FOR 'OR' KEYWORD ///////////
						String[] SplitArray = ScopeDB.split("OR");
						/////// ITERATE STRING FOR 'OR' KEYWORD ///////////
						for (String splitString : SplitArray) {
							System.out.println("SPLIT STRING FOUND: " + splitString);
							String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN (", ") AND");
							String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN (", ") AND");
							String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN (",
									"))");

							///////////////// COMPARE COMPANY //////////////////
							System.out.println("FETCH COMPANY: " + fetchCompany);
							Boolean CompanyFlag = false;
							if (fetchCompany == null) {
								CompanyFlag = false;
							} else if (fetchCompany.contains("'" + company + "'")) {
								CompanyFlag = true;
							}
							System.out.println("FETCH COMPANY FINAL: " + fetchCompany);
							System.out.println("FETCH COMPANY FROM INPUT: " + company);
							System.out.println("FETCH COMPANY FLAG: " + CompanyFlag);

							////////////////////// COMPARE BRANCH ////////////////
							Boolean BranchFlag = false;
							String finalBranch = "";
							if (fetchBranch == null) {
								finalBranch = "";
								BranchFlag = false;
								System.out.println("FETCH BRANCH NULL: " + finalBranch);
							} else if (fetchBranch.contains("'" + branch + "'")) {
								BranchFlag = true;

							} else {
								BranchFlag = false;

							}
							System.out.println("FETCH BRANCH FINAL: " + finalBranch);
							System.out.println("FETCH BRANCH FROM INPUT: " + branch);
							System.out.println("FETCH BRANCH FLAG: " + BranchFlag);

							////////////////////// COMPARE DEPARTMENT ////////////////
							System.out.println("FETCH DEPARTMENT: " + fetchDepartment);
							Boolean DepartmentFlag = false;
							String finalDepartment = "";
							if (fetchDepartment == null) {
								finalDepartment = "";
								DepartmentFlag = false;
								System.out.println("FETCH DEPARTMENT NULL: " + finalDepartment);
							} else if (fetchDepartment.contains("'" + department + "'")) {

								DepartmentFlag = true;

							} else {
								DepartmentFlag = false;

							}
							System.out.println("FETCH DEPARTMENT FINAL: " + finalDepartment);
							System.out.println("FETCH DEPARTMENT FROM INPUT: " + department);
							System.out.println("FETCH DEPARTMENT FLAG: " + DepartmentFlag);
							///////////// COMPARISON DONE //////////////////

							System.out.println("------------END----------------");
							if (DepartmentFlag == true && BranchFlag == true && CompanyFlag == true) {
								System.out.println();
								userVerified = true;

								break;

							} else {
								userVerified = false;

							}
						}
						if (userVerified == true) {

							verifiedTP = verifiedTP + catDrive.getUSERNAME() + ",";
							TPMobNo = TPMobNo + catDrive.getPHONE() + ",";
							verifiedTPMails = verifiedTPMails + catDrive.getEMAIL() + ",";

						}

					}

				}

			}
			verifiedTP = verifiedTP.substring(0, verifiedTP.lastIndexOf(","));
			TPMobNo = TPMobNo.substring(0, TPMobNo.lastIndexOf(","));
			verifiedTPMails = verifiedTPMails.substring(0, verifiedTPMails.lastIndexOf(","));

			if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Assigned")) {

				System.out.println("Inside Assigned Problem Ticket Scope");

				String engEmail = "";
				boolean grpFlag = false;
				String grpEmails = "";
				boolean grpbool = false;
				boolean branchbool=false;
				boolean departmentbool=false;
				boolean companybool=false;

				List<problem_ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
						.createQuery("from problem_ticket_assigned where PT_ID = '" + ticketID + "'").list();
				for (problem_ticket_assigned T_assigned : ticketAssigned) {

					assignTo = T_assigned.getPT_ASSIGN_TO();
					if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = T_assigned.getENGINEER_NAME();
						userPh = T_assigned.getPT_USER_PHONE();
						String enggcompany = T_assigned.getPT_ENGINEER_COMAPNY();
						engNameOrGrpName = engName;

						List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
								"from loginmaster where USERNAME = '" + engName + "' AND COMPANY='" + enggcompany + "'")
								.list();

						for (loginmaster lg : loginMaster) {

							engEmail = lg.getEMAIL();
							engPh = lg.getPHONE();
						}

					}

					// Status Reject Code

					else if (assignTo.equalsIgnoreCase("Group")) {
						System.out.println("inside group ***");
                        String loginscop="";
                     //   boolean scopecheck=false;
						engGroup = T_assigned.getENGINEER_GROUP();
						engNameOrGrpName = engGroup;
						System.out.println("ENG GROUP IS  " + engNameOrGrpName);
						List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

						for (loginmaster lg : loginMaster) {
							

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {

								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										 grpbool= true;
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
														

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															
															}
															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;
																
															}
														}
														
														
														
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;
												
											}
											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}
											
										}
										//if(scopecheck) {
							
										//}
									}
								}

							}

						}

						if (engEmail.contains(",")) {

							engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
						}

						if (engPh.contains(",")) {

							engPh = engPh.substring(0, engPh.lastIndexOf(","));
						}

					}

				}

				mailIDForTo = engEmail;
				mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

				phonenum = engPh + "," + TPMobNo + "," + userPh;
				System.out.println("all numbers====" + phonenum);

				url = url.replace("spalert_msg",
						engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
								+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
								+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
								+ priority + "%0aOn%20" + mysqldate);

			}
			// ROOT COUSE ANALYSIS CODE
			if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Root Cause Analysis")) {

				System.out.println("Inside Root Cause Analysis Problem Ticket Scope");

				String engEmail = "";
				boolean grpFlag = false;
				String grpEmails = "";
				boolean grpbool = false;
				boolean branchbool=false;
				boolean departmentbool=false;
				boolean companybool=false;

				List<problem_ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
						.createQuery("from problem_ticket_assigned where PT_ID = '" + ticketID + "'").list();
				for (problem_ticket_assigned T_assigned : ticketAssigned) {

					assignTo = T_assigned.getPT_ASSIGN_TO();
					if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = T_assigned.getENGINEER_NAME();
						userPh = T_assigned.getPT_USER_PHONE();
						String enggcompany = T_assigned.getPT_ENGINEER_COMAPNY();
						engNameOrGrpName = engName;

						List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
								"from loginmaster where USERNAME = '" + engName + "' AND COMPANY='" + enggcompany + "'")
								.list();

						for (loginmaster lg : loginMaster) {

							engEmail = lg.getEMAIL();
							engPh = lg.getPHONE();
						}

					}

					// Status Reject Code

					else if (assignTo.equalsIgnoreCase("Group")) {
						System.out.println("inside group ***");
                        String loginscop="";
                     //   boolean scopecheck=false;
						engGroup = T_assigned.getENGINEER_GROUP();
						engNameOrGrpName = engGroup;
						System.out.println("ENG GROUP IS  " + engNameOrGrpName);
						List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

						for (loginmaster lg : loginMaster) {
							

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {

								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										 grpbool= true;
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
														

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															
															}
															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;
																
															}
														}
														
														
														
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;
												
											}
											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}
											
										}
										//if(scopecheck) {
							
										//}
									}
								}

							}

						}

						if (engEmail.contains(",")) {

							engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
						}

						if (engPh.contains(",")) {

							engPh = engPh.substring(0, engPh.lastIndexOf(","));
						}

					}

				}

				mailIDForTo = engEmail;
				mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

				phonenum = engPh + "," + TPMobNo + "," + userPh;
				System.out.println("all numbers====" + phonenum);

				url = url.replace("spalert_msg",
						engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
								+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
								+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
								+ priority + "%0aOn%20" + mysqldate);

			}

			if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Fix In Process")) {

				System.out.println("Inside Fix In Process Problem Ticket Scope");

				String engEmail = "";
				boolean grpFlag = false;
				boolean grpbool = false;
				boolean branchbool=false;
				boolean departmentbool=false;
				boolean companybool=false;
				String grpEmails = "";

				List<problem_ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
						.createQuery("from problem_ticket_assigned where PT_ID = '" + ticketID + "'").list();
				for (problem_ticket_assigned T_assigned : ticketAssigned) {

					assignTo = T_assigned.getPT_ASSIGN_TO();
					if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = T_assigned.getENGINEER_NAME();
						userPh = T_assigned.getPT_USER_PHONE();
						String enggcompany = T_assigned.getPT_ENGINEER_COMAPNY();
						engNameOrGrpName = engName;

						List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
								"from loginmaster where USERNAME = '" + engName + "' AND COMPANY='" + enggcompany + "'")
								.list();

						for (loginmaster lg : loginMaster) {

							engEmail = lg.getEMAIL();
							engPh = lg.getPHONE();
						}

					}

					// Status Reject Code

					else if (assignTo.equalsIgnoreCase("Group")) {
						System.out.println("inside group ***");
                        String loginscop="";
                     //   boolean scopecheck=false;
						engGroup = T_assigned.getENGINEER_GROUP();
						engNameOrGrpName = engGroup;
						System.out.println("ENG GROUP IS  " + engNameOrGrpName);
						List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

						for (loginmaster lg : loginMaster) {
							

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {

								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										 grpbool= true;
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
														

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															
															}
															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;
																
															}
														}
														
														
														
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;
												
											}
											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}
											
										}
										//if(scopecheck) {
							
										//}
									}
								}

							}

						}

						if (engEmail.contains(",")) {

							engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
						}

						if (engPh.contains(",")) {

							engPh = engPh.substring(0, engPh.lastIndexOf(","));
						}

					}

				}

				mailIDForTo = engEmail;
				mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

				phonenum = engPh + "," + TPMobNo + "," + userPh;
				System.out.println("all numbers====" + phonenum);

				url = url.replace("spalert_msg",
						engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
								+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
								+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
								+ priority + "%0aOn%20" + mysqldate);

			}

			if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) {

				System.out.println("Inside Problem Resolved Ticket Scope");

				engName = "";

				String engEmail = "";
				boolean grpFlag = false;
				String grpEmails = "";
				boolean grpbool = false;
				boolean branchbool=false;
				boolean departmentbool=false;
				boolean companybool=false;

				List<problem_ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
						.createQuery("from problem_ticket_assigned where PT_ID = '" + ticketID + "'").list();
				for (problem_ticket_assigned T_assigned : ticketAssigned) {

					assignTo = T_assigned.getPT_ASSIGN_TO();
					if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = T_assigned.getENGINEER_NAME();
						userPh = T_assigned.getPT_USER_PHONE();
						String enggcompany = T_assigned.getPT_ENGINEER_COMAPNY();
						engNameOrGrpName = engName;

						List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
								"from loginmaster where USERNAME = '" + engName + "' AND COMPANY='" + enggcompany + "'")
								.list();

						for (loginmaster lg : loginMaster) {

							engEmail = lg.getEMAIL();
							engPh = lg.getPHONE();
						}

					} else if (assignTo.equalsIgnoreCase("Group")) {
						System.out.println("inside group ***");
                        String loginscop="";
                     //   boolean scopecheck=false;
						engGroup = T_assigned.getENGINEER_GROUP();
						engNameOrGrpName = engGroup;
						System.out.println("ENG GROUP IS  " + engNameOrGrpName);
						List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

						for (loginmaster lg : loginMaster) {
							

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {

								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										 grpbool= true;
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
														

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															
															}
															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;
																
															}
														}
														
														
														
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;
												
											}
											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}
											
										}
										//if(scopecheck) {
							
										//}
									}
								}

							}

						}

						if (engEmail.contains(",")) {

							engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
						}

						if (engPh.contains(",")) {

							engPh = engPh.substring(0, engPh.lastIndexOf(","));
						}

					}
				}

//					mailIDForTo = verifiedTPMails + "," + ticketUserMailID;
				//
//					mailIDForCC = loginUserMailID + "," + engEmail;

				mailIDForTo = verifiedTPMails;

				mailIDForCC = ticketUserMailID + "," + engEmail;

				phonenum = userPh + "," + TPMobNo + "," + engPh;
				url = url.replace("spalert_msg",
						username.toUpperCase() + "%20Engineer%20has%20Resolved%20Ticket-ID%20" + id
								+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
								+ "%0aStatus :%20" + "Resolved" + "%0aSubject :%20" + subject + "%0aPriority :%20"
								+ priority + "%0aOn%20" + mysqldate);

			}
			if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Closed")) {

				System.out.println("Inside Problem CLOSED Ticket Scope");

				engName = "";
				boolean grpbool = false;
				boolean branchbool=false;
				boolean departmentbool=false;
				boolean companybool=false;
				String engEmail = "";
				boolean grpFlag = false;
				String grpEmails = "";
				List<problem_ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
						.createQuery("from problem_ticket_assigned where PT_ID = '" + ticketID + "'").list();
				for (problem_ticket_assigned T_assigned : ticketAssigned) {

					assignTo = T_assigned.getPT_ASSIGN_TO();
					if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = T_assigned.getENGINEER_NAME();
						userPh = T_assigned.getPT_USER_PHONE();
						String enggcompany = T_assigned.getPT_ENGINEER_COMAPNY();
						engNameOrGrpName = engName;

						List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
								"from loginmaster where USERNAME = '" + engName + "' AND COMPANY='" + enggcompany + "'")
								.list();

						for (loginmaster lg : loginMaster) {

							engEmail = lg.getEMAIL();
							engPh = lg.getPHONE();
						}

					}

					else if (assignTo.equalsIgnoreCase("Group")) {
						System.out.println("inside group ***");
                        String loginscop="";
                     //   boolean scopecheck=false;
						engGroup = T_assigned.getENGINEER_GROUP();
						engNameOrGrpName = engGroup;
						System.out.println("ENG GROUP IS  " + engNameOrGrpName);
						List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

						for (loginmaster lg : loginMaster) {
							

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {

								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										 grpbool= true;
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
														

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																

																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															
															}
															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;
																
															}
														}
														
														
														
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;
												
											}
											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}
											
										}
										//if(scopecheck) {
							
										//}
									}
								}

							}

						}

						if (engEmail.contains(",")) {

							engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
						}

						if (engPh.contains(",")) {

							engPh = engPh.substring(0, engPh.lastIndexOf(","));
						}

					}

				}

				mailIDForTo = engEmail;
				mailIDForCC = ticketUserMailID + "," + verifiedTPMails;

				phonenum = userPh + "," + TPMobNo + "," + engPh;

				url = url.replace("spalert_msg",
						username.toUpperCase() + "%20Ticket%20has%20Closed%20Ticket-ID%20" + id
								+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
								+ "%0aStatus :%20" + "Closed" + "%0aSubject :%20" + subject + "%0aPriority :%20"
								+ priorityname1 + "%0aOn%20" + mysqldate);

			}

			System.out.println("TPMobNo:" + TPMobNo);
			System.out.println("verifiedTPMails:" + verifiedTPMails);
			System.out.println("mailIDForTo:" + mailIDForTo);
			System.out.println("mailIDForCC:" + mailIDForCC);

			System.out.println("finally phone numbers==" + phonenum);
			url12 = url.replace("spalert_contact", phonenum);
			if (url12.contains(" "))
				url12 = url12.replace(" ", "%20");
			System.out.println("url connect***--------------------" + url12);

			String hostname = "";
			int port = 587;
			String Senderid = "";
			String pass = "";
			String mailid = "";

			String auth = "";
			String authval = "";
			String starttls="";
			Query query23 = sessionFactory.getCurrentSession()
					.createQuery("from mail_config where COMPANY='" + companyname1 + "' ");

			List<mail_config> dataList12 = query23.list();
			System.out.println("before user if" + dataList12);
			for (mail_config dataList23 : dataList12) {
				hostname = dataList23.getHOST();
				port = dataList23.getPORT();
				Senderid = dataList23.getSENDERID();
				pass = dataList23.getPASSWRD();
				mailid = dataList23.getE_MAIL();
				auth = dataList23.getAUTHO();
				starttls=dataList23.getSTART_TLS();
			//	starttls=dataList23.get
					
				System.out.println("Sender email get----------------" + mailid+"-------------starttls"+starttls);
			}
			
			
			if (auth.equalsIgnoreCase("Yes")) {
				authval = "true";
			} else if (auth.equalsIgnoreCase("No")) {
				authval = "false";
			} else {
				authval = "false";
			}

			final String Senderid1 = Senderid;
			final String pass1 = pass;
			//
			int count = 0;
			Properties props = new Properties();

			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.starttls.enable", starttls);
			props.put("mail.smtp.auth", authval);
			props.put("mail.smtp.host", hostname);
			props.put("mail.smtp.port", "" + port);
			props.put("mail.smtp.sendpartial", "true");

			System.out.println("all propert set----------------status=" + status);
//					
			final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					// System.out.println("session value============"+session);
					System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
							+ " pass1=" + pass1);
					return new PasswordAuthentication(Senderid1, pass1);
				}
			});

			String title = "";
			String mailbody = status + " Ticket Alert";
			String mainMSG = "";

			// dynamic title from DB

			try {

//				System.out.println("Before Projection List ");
				// Session s = getSession();
				// System.out.println("s =" + s);

				List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
						.createQuery("from ADD_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

				for (ADD_MAIL_TEMPLATE a1 : dataList1) {
					String st = a1.getSTATUS();
					System.out.println("status from template==" + st);
					System.out.println("status from method==" + status);
					if (st.equals(status)) {
						System.out.println("Inside if block");

						title = a1.getSUBJECT();
						mailbody = a1.getMAILBODY();
						// mailbody="Please find below details for Ticket ID:"
						System.out.println("title==" + title);

						title = title.replaceAll("!", String.valueOf(id));

						title = title.replaceAll("#", status);
						title = title.replaceAll("@", priority);
						title = title.replace("$", severity);
						System.out.println("name==" + title);

						System.out.println("mailbody==" + mailbody);

						mailbody = mailbody.replaceAll("!", String.valueOf(id));

						mailbody = mailbody.replaceAll("#", status);
						mailbody = mailbody.replaceAll("@", priority);
						mailbody = mailbody.replaceAll("~", username);
						mailbody = mailbody.replaceAll("�", enggname);
						System.out.println("mailbody==" + mailbody);
						break;
					} else {
						System.out.println("Inside else block");

						if (status.equalsIgnoreCase("Assigned")) {
							title = "Ticket Status: Assigned || Ticket ID: " + id + " || Priority : " + priority;
						}

						else if (status.equalsIgnoreCase("Root Cause Analysis")) {
							title = "Ticket Status: Root Cause Analysis || Ticket ID: " + id + " || Priority : "
									+ priority;
						}

						else if (status.equalsIgnoreCase("Fix In Process")) {
							title = "Ticket Status: Fix In Process || Ticket ID: " + id + " || Priority : " + priority;
						}

						else if (status.equalsIgnoreCase("Resolved")) {
							title = "Ticket Status: Resolved || Ticket ID: " + id + " || Priority : " + priority;
						}

						else if (status.equalsIgnoreCase("Closed")) {
							title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority;
						}

					}

				}

				if (engGroup == null || engGroup.contentEquals("")) {
					engGroup = "NA";
				}

				if (engName == null || engName.contentEquals("")) {
					engName = "All Engineers of Group";
				}

				if (status.equalsIgnoreCase("Assigned")) {

					System.out.println("in Assigned  Problem status cond=----------------");

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br>"
							+ "<h4 style='color:#1f497d; font-weight:100'><strong>Problem Ticket Details<strong></h4>"
							+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Problem Ticket Assigned</td>"
							+ "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
							+ "Assigned" + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
							+ id + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
							+ assignTo + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
							+ engGroup + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
							+ engName + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
							+ companyforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
							+ branch + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
							+ departmentforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
							+ category + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
							+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
							+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
							+ priority + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
							+ severity + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
							+ username + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
							+ subject + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
							+ mysqldate + "</td>" + "</tr>"+"</table>"
							+ mailFooter;

					System.out.println("Assigned message======" + mainMSG);

				}

				if (status.equalsIgnoreCase("Root Cause Analysis")) {

					System.out.println("in Root Cause Analysis  Problem status cond=----------------");

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br>"
							+ "<h4 style='color:#1f497d; font-weight:100'><strong>Problem Ticket Details<strong></h4>"
							+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'> Problem Ticket Root Cause Analysis</td>"
							+ "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
							+ "Root Cause Analysis" + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
							+ id + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
							+ companyforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
							+ branch + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
							+ departmentforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
							+ category + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
							+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
							+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
							+ priority + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
							+ severity + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
							+ username + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
							+ subject + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
							+ mysqldate + "</td>" + "</tr>"+"</table>"
							+ mailFooter;
					System.out.println("Root Cause Analysis message======" + mainMSG);

				}
				if (status.equalsIgnoreCase("Fix In Process")) {

					System.out.println("in Root Cause Analysis  Problem status cond=----------------");

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br>"
							+ "<h4 style='color:#1f497d; font-weight:100'><strong>Problem Ticket Details<strong></h4>"
							+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Problrm Ticket Fix In Process</td>"
							+ "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
							+ "Fix In Process" + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
							+ id + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
							+ companyforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
							+ branch + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
							+ departmentforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
							+ category + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
							+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
							+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
							+ priority + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
							+ severity + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
							+ username + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
							+ subject + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
							+ mysqldate + "</td>" + "</tr>"+"</table>"
							+ mailFooter;
					System.out.println("Root Cause Analysis message======" + mainMSG);

				}
				if (status.equalsIgnoreCase("Resolved")) {
					System.out.println("in problem Resolved status cond=----------------");

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br>"
							+ "<h4 style='color:#1f497d; font-weight:100'><strong>Problem Ticket Details<strong></h4>"
							+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Problrm Ticket Resolved</td>"
							+ "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
							+ "Resolved" + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
							+ id + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
							+ companyforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
							+ branch + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
							+ departmentforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
							+ category + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
							+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
							+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
							+ priority + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
							+ severity + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
							+ username + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
							+ subject + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
							+ mysqldate + "</td>" + "</tr>"+"</table>"
							+ mailFooter;
					System.out.println("Resolved message======" + mainMSG);
				}
				if (status.equalsIgnoreCase("Closed")) {

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br>"
							+ "<h4 style='color:#1f497d; font-weight:100'><strong>Problem Ticket Details<strong></h4>"
							+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Problrm Ticket Closed</td>"
							+ "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
							+ "Closed" + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
							+ id + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
							+ companyforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
							+ branch + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
							+ departmentforMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
							+ category + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
							+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
							+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
							+ priority + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
							+ severity + "<td/>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
							+ username + "</td>" + "</tr>" + "<tr>"
							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
							+ subject + "</td>" + "</tr>" + "<tr>"

							+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
							+ mysqldate + "</td>" + "</tr>"+"</table>"
							+ mailFooter;
					System.out.println("Closed message======" + mainMSG);

				}

				System.out.println("session value==" + session);
				Message message = new MimeMessage(session);

				System.out.println("MAIL ID FOR CHECKING ::: " + mailid);
				message.setFrom(new InternetAddress(mailid));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailIDForTo));
				InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);

				message.addRecipients(Message.RecipientType.CC, parse);

				message.setSubject(title);

				System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
				System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
				System.out.println("FINAL MAIL PARSE: " + parse);
				System.out.println("FINAL MAIL TITLE: " + title);

				BodyPart messageBodyPart = new MimeBodyPart();

				messageBodyPart.setContent(mainMSG, "text/html");

				System.out.println("FINAL MESSEGE " + mainMSG);

				Multipart multipart = new MimeMultipart();

				multipart.addBodyPart(messageBodyPart);

				message.setContent(multipart);

				try {
					System.out.println("Thread is calling started.....");
					System.out.println("URL BEFORE: " + url12);
					Thread t = new Thread(new ConstructDemo(url12, message));
					t.join();
					t.start();
					System.out.println("Thread is calling finished.....");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			// end here

		} catch (Exception e) {
			System.out.println("Exception in EmailSMSTriggered Dao Impl:" + e);
			e.printStackTrace();

		}
		System.out.println("Email Triggred successfully");
		}
		else
		{
			System.out.println("Email Note triggered");
		}
		return null;

	}

	private JSONArray getMailTemplateData(String Problem_ID, String problem_Status, String TP_NAME, String ENGG_NAME,
			String currentDate, String Problem_Priority, String Problem_Category, String Problem_Branch,
			String Problem_Subject) {
		System.out.println("INSIDE getMailTemplateData");
		JSONArray templateData = new JSONArray();
		String title = "";
		String mailbody = problem_Status + " Ticket Alert";
		String mainMSG = "";
		try {
			List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession().createQuery("from ADD_MAIL_TEMPLATE")
					.list();

			for (ADD_MAIL_TEMPLATE a1 : dataList1) {
				String st = a1.getSTATUS();
				System.out.println("status from template==" + st);
				System.out.println("status from method==" + problem_Status);
				if (st.equals(problem_Status)) {
					System.out.println("Inside template if block: " + problem_Status);

					title = a1.getSUBJECT();
					mailbody = a1.getMAILBODY();
					System.out.println("title==" + title);

					title = title.replaceAll("!", String.valueOf(Problem_ID));

					title = title.replaceAll("#", problem_Status);
					title = title.replaceAll("@", Problem_Priority);
					System.out.println("name==" + title);

					mailbody = mailbody.replaceAll("!", String.valueOf(Problem_ID));

					mailbody = mailbody.replaceAll("#", problem_Status);
					mailbody = mailbody.replaceAll("@", Problem_Priority);
					mailbody = mailbody.replaceAll("~", TP_NAME);
					mailbody = mailbody.replaceAll("�", ENGG_NAME);
					System.out.println("mailbody1==" + mailbody);
//		     	break;
				} else {
					System.out.println("Inside else block");
					if (problem_Status.equalsIgnoreCase("Assigned")) {
						title = "Ticket Status: " + problem_Status + " || Ticket ID: " + Problem_ID + " || Priority : "
								+ Problem_Priority;
					} else if (problem_Status.equalsIgnoreCase("Root Cause Analysis")) {
						title = "Ticket Status: " + problem_Status + " || Ticket ID: " + Problem_ID + " || Priority : "
								+ Problem_Priority;
					} else if (problem_Status.equalsIgnoreCase("Fix In Process")) {
						title = "Ticket Status: " + problem_Status + " || Ticket ID: " + Problem_ID + " || Priority : "
								+ Problem_Priority;
					} else if (problem_Status.equalsIgnoreCase("Resolved")) {
						title = "Ticket Status: " + problem_Status + " || Ticket ID: " + Problem_ID + " || Priority : "
								+ Problem_Priority;
					} else if (problem_Status.equalsIgnoreCase("Closed")) {
						title = "Ticket Status: " + problem_Status + " || Ticket ID: " + Problem_ID + " || Priority : "
								+ Problem_Priority;
					}
				}

				if (problem_Status.equals("Assigned")) {
					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket "
							+ problem_Status + "  <br></td> <td>" + Problem_ID + "</td> <td>" + ENGG_NAME.toUpperCase()
							+ "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch + "</td><td>"
							+ problem_Status + "</td><td>" + Problem_Subject + "</td><td>" + Problem_Priority
							+ "</td><td>" + currentDate
							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				} else if (problem_Status.equals("Root Cause Analysis")) {
					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket "
							+ problem_Status + "  <br></td> <td>" + Problem_ID + "</td> <td>" + ENGG_NAME.toUpperCase()
							+ "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch + "</td><td>"
							+ problem_Status + "</td><td>" + Problem_Subject + "</td><td>" + Problem_Priority
							+ "</td><td>" + currentDate
							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				} else if (problem_Status.equals("Fix In Process")) {
					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket "
							+ problem_Status + "  <br></td> <td>" + Problem_ID + "</td> <td>" + ENGG_NAME.toUpperCase()
							+ "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch + "</td><td>"
							+ problem_Status + "</td><td>" + Problem_Subject + "</td><td>" + Problem_Priority
							+ "</td><td>" + currentDate
							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				} else if (problem_Status.equals("Resolved")) {
					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket "
							+ problem_Status + "  <br></td> <td>" + Problem_ID + "</td> <td>" + ENGG_NAME.toUpperCase()
							+ "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch + "</td><td>"
							+ problem_Status + "</td><td>" + Problem_Subject + "</td><td>" + Problem_Priority
							+ "</td><td>" + currentDate
							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				} else if (problem_Status.equals("Closed")) {
//			mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>"+mailbody+"</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Engineer</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket "+problem_Status+"  <br></td> <td>" + Problem_ID  + "</td> <td>" + ENGG_NAME.toUpperCase() + "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch + "</td><td>" + problem_Status  + "</td><td>" + Problem_Subject  + "</td><td>" + Problem_Priority + "</td><td>" + currentDate + "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Closed By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Date</th></thead></tr>"
							+ "<tr> <td>Ticket " + problem_Status + " <br></td> <td>" + Problem_ID + "</td> <td>"
							+ TP_NAME.toUpperCase() + "</td> <td>" + Problem_Category + "</td><td>" + Problem_Branch
							+ "</td><td>" + problem_Status + "</td><td>" + Problem_Subject + "</td><td>" + currentDate
							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

				}
			}
			templateData.put(title);
			templateData.put(mailbody);
			templateData.put(mainMSG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return templateData;
	}
	public String EmailSMSTriggered(String ticketID, String TicketStatus) {

		String getCompForMail = "";
		System.out.println("ticket status====="+TicketStatus);
		System.out.println("Ticket Id  "+ ticketID);
		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession sessionForCompany = requestAttributes1.getRequest().getSession();
		getCompForMail = sessionForCompany.getAttribute("companyname").toString();
		System.out.println("Company from ticket :: "+getCompForMail);
		String NewTicket_Status="";
		if(TicketStatus.equals("Raise"))
		{
			 NewTicket_Status=TicketStatus.replace("Raise","New");
			 System.out.println("New Ticket Status is inside if"+NewTicket_Status);
		}
		
		else
		{
			NewTicket_Status=TicketStatus;
			System.out.println("New Ticket Status  inside else "+NewTicket_Status);
		}
		System.out.println("TICKERT ISTAUS IS   " +TicketStatus);
		String EmailTrigger = "";
		String ticketType="";
		String mailFooter="";
		String tempTicketType="Incident Ticket";
		System.out.println("Ticket status :::::"+NewTicket_Status);
	//	if()
		Query createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery("select T_COMPANY from ticket where T_ID='"+ticketID+"'");
		String companys="";
		List<String> list2 = createSQLQuery.list();
		for(String s:list2)
		{
			companys=s.toString();
		}
		
		System.out.println("Affan from ADD_MAIL_TEMPLATE where STATUS='" + NewTicket_Status + "' and COMPANY='" + companys + "' and TICKET_TYPE='"+tempTicketType+"'  "+companys);
	
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from ADD_MAIL_TEMPLATE where STATUS='" + NewTicket_Status + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
		List<ADD_MAIL_TEMPLATE> list = query.list();
		for (ADD_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		System.out.println("Emai trigger is:: "+EmailTrigger);
//		System.out.println("from ADD_MAIL_TEMPLATE where STATUS='" + NewTicket_Status + "' and COMPANY='" + companyis.toString() + "' and TICKET_TYPE='"+tempTicketType+"'  ");

		
		if (EmailTrigger.equals("Yes") && ticketType.equals("Incident Ticket") ) {
			
			status = TicketStatus;
			id = ticketID;
			System.out.println("Inside EmailSMSTriggered ");
			System.out.println("ticketID:" + ticketID + " TicketStatus:" + TicketStatus);

			String enggname = "NA";

			String sms_config_URL = "";
			String sms_config_Param = "";
			String url12 = "";
			String department = "NA";
			String company = "NA";
			String branch = "NA";
			String username = "NA";
			String url = "";
			String category = "";

			String branchforMail = "";
			String companyforMail = "";
			String departmentforMail = "";
			String suncat1forMail = "";
			String subcat2forMail = "";

			String subject = "";
			String priority = "";
			String mailIDForCC = "";
			String mailIDForTo = "";
			String ticketUserMailID = "";
			String engNameOrGrpName = "NA";

			String engPh = "";
			String tcPh = "";
			String userPh = "";
			String phonenum = "";
			String loginUserPh = "";
			String assignTo = "";
			String engGroup = "";
			String engName = "";
			String companyname1 = "";
			String EMAILFORTO = "";
			String severity = "";

			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				username = session.getAttribute("username").toString();

				HttpSession session1 = requestAttributes.getRequest().getSession();
				companyname1 = session.getAttribute("companyname").toString();

				System.out.println("COMPANY NAME IS ::::::  " + companyname1);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

			String loginUserMailID = "";
			String loginUserRole = "";
			try {
				List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + companyname1 + "'")
						.list();

				for (loginmaster lg : loginMaster1) {

					loginUserMailID = lg.getEMAIL();
					loginUserPh = lg.getPHONE();
					loginUserRole = lg.getROLE_TYPE();
				}
				System.out.println("loginUserMailID:" + loginUserMailID);

			} catch (Exception e) {
				e.printStackTrace();

			}

			try {

				Date date = null;
				date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String mysqldate = formatter.format(date);

				Query queryd = sessionFactory.getCurrentSession()
						.createQuery("from sms_config  where COMPANY='" + companyname1 + "'");

				List<sms_config> dataList = queryd.list();
				for (sms_config dataList12 : dataList) {
					sms_config_URL = dataList12.getURL();
					sms_config_Param = dataList12.getPARAM();
					System.out.println("sms_config_URL:" + sms_config_URL);
					System.out.println("sms_config_Param:" + sms_config_Param);
					url = sms_config_URL.concat("?");
					url = url.concat(sms_config_Param);

				}

				String verifiedTP = "";
				String TPMobNo = "";
				String verifiedTPMails = "";

				Query queryticketRaise = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID=:T_ID");
				queryticketRaise.setParameter("T_ID", ticketID);
				List<ticket> ticketTracking = queryticketRaise.list();

				for (ticket ticket : ticketTracking) {
					department = ticket.getT_DEPARTMENT();
					company = ticket.getT_COMPANY();
					branch = ticket.getT_BRANCH();

					category = ticket.getT_CATEGORY();
					branchforMail = ticket.getT_BRANCH();
					subject = ticket.getT_SUBJECT();
					priority = ticket.getPRIORITY();

					ticketUserMailID = ticket.getT_MAIL();
					companyforMail = ticket.getT_COMPANY();
					departmentforMail = ticket.getT_DEPARTMENT();
					suncat1forMail = ticket.getT_SUBCAT1();
					subcat2forMail = ticket.getT_SUBCAT2();
					severity = ticket.getSEVERITY();
				}
				List<loginmaster> catList = sessionFactory.getCurrentSession()
						.createQuery("from loginmaster where ROLE_TYPE='Ticket Co-ordinator' and VISIBILITY<>'Show ServiceRequest'").list();
				for (loginmaster catDrive : catList) {
					////// CHECK SCOPE /////
					System.out.println("----------- START----------");
					String ScopeDB = catDrive.getLOGIN_SCOPE();
					System.out.println("Ticket Co-ordinator NAME: " + catDrive.getUSERNAME());
					System.out.println("Ticket Co-ordinator SCOPE DB: " + ScopeDB);
					boolean userVerified = false;

					if (ScopeDB != null && branch != null && company != null && department != null) {
						if (ScopeDB.contains(company) && ScopeDB.contains(branch) && ScopeDB.contains(department)) {

							/////// SPLIT STRING FOR 'OR' KEYWORD ///////////
							String[] SplitArray = ScopeDB.split("OR");
							/////// ITERATE STRING FOR 'OR' KEYWORD ///////////
							for (String splitString : SplitArray) {
								System.out.println("SPLIT STRING FOUND: " + splitString);
								String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN (",
										") AND");
								String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN (",
										") AND");
								String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN (",
										"))");

								///////////////// COMPARE COMPANY //////////////////
								System.out.println("FETCH COMPANY: " + fetchCompany);
								Boolean CompanyFlag = false;
								if (fetchCompany == null) {
									CompanyFlag = false;
								} else if (fetchCompany.contains("'" + company + "'")) {
									CompanyFlag = true;
								}
								System.out.println("FETCH COMPANY FINAL: " + fetchCompany);
								System.out.println("FETCH COMPANY FROM INPUT: " + company);
								System.out.println("FETCH COMPANY FLAG: " + CompanyFlag);

								////////////////////// COMPARE BRANCH ////////////////
								Boolean BranchFlag = false;
								String finalBranch = "";
								if (fetchBranch == null) {
									finalBranch = "";
									BranchFlag = false;
									System.out.println("FETCH BRANCH NULL: " + finalBranch);
								} else if (fetchBranch.contains("'" + branch + "'")) {
									BranchFlag = true;

								} else {
									BranchFlag = false;

								}
								System.out.println("FETCH BRANCH FINAL: " + finalBranch);
								System.out.println("FETCH BRANCH FROM INPUT: " + branch);
								System.out.println("FETCH BRANCH FLAG: " + BranchFlag);

								////////////////////// COMPARE DEPARTMENT ////////////////
								System.out.println("FETCH DEPARTMENT: " + fetchDepartment);
								Boolean DepartmentFlag = false;
								String finalDepartment = "";
								if (fetchDepartment == null) {
									finalDepartment = "";
									DepartmentFlag = false;
									System.out.println("FETCH DEPARTMENT NULL: " + finalDepartment);
								} else if (fetchDepartment.contains("'" + department + "'")) {

									DepartmentFlag = true;

								} else {
									DepartmentFlag = false;

								}
								System.out.println("FETCH DEPARTMENT FINAL: " + finalDepartment);
								System.out.println("FETCH DEPARTMENT FROM INPUT: " + department);
								System.out.println("FETCH DEPARTMENT FLAG: " + DepartmentFlag);
								///////////// COMPARISON DONE //////////////////

								System.out.println("------------END----------------");
								if (DepartmentFlag == true && BranchFlag == true && CompanyFlag == true) {
									System.out.println();
									userVerified = true;

									break;

								} else {
									userVerified = false;

								}
							}
							if (userVerified == true) {

								verifiedTP = verifiedTP + catDrive.getUSERNAME() + ",";
								TPMobNo = TPMobNo + catDrive.getPHONE() + ",";
								verifiedTPMails = verifiedTPMails + catDrive.getEMAIL() + ",";

							}

						}

					}	
				}
				
				System.out.println("verifiedTP  *********** "+ verifiedTP);
				if(verifiedTP.length()>1) {
				verifiedTP = verifiedTP.substring(0, verifiedTP.lastIndexOf(","));
				
				TPMobNo = TPMobNo.substring(0, TPMobNo.lastIndexOf(","));
				verifiedTPMails = verifiedTPMails.substring(0, verifiedTPMails.lastIndexOf(","));
				}
				System.out.println("outside     ttt  raise " +TicketStatus  );
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Raise")) {

					System.out.println("inside ttt  raise " +TicketStatus  );
					url = url.replace("spalert_msg",
							username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

					System.out.println("Raise status url ::::::::::::" + url);

					if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) {
						if (verifiedTPMails != null && loginUserMailID != null
								&& verifiedTPMails.contains(loginUserMailID)) {
							if (verifiedTPMails.contains("," + loginUserMailID)) {
								verifiedTPMails.replaceAll("," + loginUserMailID, "");
							} else if (verifiedTPMails.contains(loginUserMailID + ",")) {
								verifiedTPMails.replaceAll(loginUserMailID + ",", "");
							}
						}

					}

					mailIDForCC = loginUserMailID;
					mailIDForTo = verifiedTPMails;

					phonenum = TPMobNo;
					System.out.println("phone number::::::::::::" + phonenum);

				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Hold")
						|| TicketStatus.equalsIgnoreCase("Awaiting User Information")
						|| TicketStatus.equalsIgnoreCase("Pending With Vendor")
						|| TicketStatus.equalsIgnoreCase("Waiting for Spare")) 
				{

					System.out.println("Inside Hold Ticket Scope");

					engName = "";

					String engEmail = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					boolean grpFlag = false;
					String grpEmails = "";
					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					List<ticket_assigned> ticketAssigned2 = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						EMAILFORTO = T_assigned.getTP_EMAIL();
					}
					System.out.println("EMAIL FOR TO  ++" + EMAILFORTO);

					mailIDForTo = EMAILFORTO;

					mailIDForCC = ticketUserMailID + "," + verifiedTPMails + "," + engEmail;

					phonenum = engPh + "," + TPMobNo + "," + userPh;

//				mailIDForTo =  ticketUserMailID;
//				
//				mailIDForCC = loginUserMailID;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Hold%20Ticket-ID%20" + id + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "Hold"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Work in Progress")) {

					System.out.println("Inside Work in Progress Ticket Scope");

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;

					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							engNameOrGrpName = engName;

							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						}

						// Status Reject Code

						else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					mailIDForTo = engEmail;
					mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

					phonenum = engPh + "," + TPMobNo + "," + userPh;
					System.out.println("all numbers====" + phonenum);

					url = url.replace("spalert_msg",
							engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected")) {

					System.out.println("Inside Rejected Ticket Scope");

					engName = "";

					String engEmail = "";

					boolean grpFlag = false;
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					String grpEmails = "";
					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}
					List<ticket_assigned> ticketAssigned2 = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						EMAILFORTO = T_assigned.getTP_EMAIL();
					}
					System.out.println("EMAIL FOR TO   ++" + EMAILFORTO);

					mailIDForTo = EMAILFORTO;

					mailIDForCC = ticketUserMailID + "," + verifiedTPMails + "," + engEmail;

					phonenum = engPh + "," + TPMobNo + "," + userPh;

//				mailIDForTo =  ticketUserMailID;
//				
//				mailIDForCC = loginUserMailID;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Hold%20Ticket-ID%20" + id + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "Reject"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Assigned")) {

					System.out.println("Inside Assigned Ticket Scope888");

					String engEmail = "";
					boolean grpFlag = false;
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					String grpEmails = "";

					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							engNameOrGrpName = engName;

							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						}

						// Status Reject Code

						else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					mailIDForTo = engEmail;
					mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

					phonenum = engPh + "," + TPMobNo + "," + userPh;
					System.out.println("all numbers====" + phonenum);

					url = url.replace("spalert_msg",
							engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) {

					System.out.println("Inside Resolved Ticket Scope");

					engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							engNameOrGrpName = engName;
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}
					}

//				mailIDForTo = verifiedTPMails + "," + ticketUserMailID;
//
//				mailIDForCC = loginUserMailID + "," + engEmail;

					mailIDForTo = verifiedTPMails;

					mailIDForCC = ticketUserMailID + "," + engEmail;

					phonenum = userPh + "," + TPMobNo + "," + engPh;
					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Engineer%20has%20Resolved%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Resolved" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				} else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("CLOSEDWITHOUTASSIGN")) {

					System.out.println("Inside CLOSEDWITHOUTASSIGN Ticket Scope");

					engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";

					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "' AND COMPANY='" + companyname1 + "'")
							.list();

					for (loginmaster lg : loginMaster) {

						engEmail = lg.getEMAIL();
						engPh = lg.getPHONE();

					}
					mailIDForTo = ticketUserMailID;
					mailIDForCC = verifiedTPMails;

					phonenum = userPh + "," + TPMobNo + "," + engPh;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Ticket%20has%20Closed%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Closed" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priorityname1 + "%0aOn%20" + mysqldate);

				} else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("CLOSED")) {

					System.out.println("Inside CLOSED Ticket Scope");

					engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;

					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							engNameOrGrpName = engName;
							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					mailIDForTo = engEmail;
					mailIDForCC = ticketUserMailID + "," + verifiedTPMails;

					phonenum = userPh + "," + TPMobNo + "," + engPh;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Ticket%20has%20Closed%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Closed" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priorityname1 + "%0aOn%20" + mysqldate);

				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Reopened")) {

					System.out.println("Inside reopen Ticket Scope");

					engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;

					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							engNameOrGrpName = engName;

							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					mailIDForTo = verifiedTPMails;
					mailIDForCC = loginUserMailID + "," + engEmail;

					phonenum = userPh + "," + TPMobNo + "," + engPh;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20User%20has%20Re-Open%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Re-Open" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);
				}

				else if (status.equalsIgnoreCase("Re-Assigned")) {

					engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;

					List<ticket_assigned> ticketAssigned = sessionFactory.getCurrentSession()
							.createQuery("from ticket_assigned where T_ID = '" + ticketID + "'").list();
					for (ticket_assigned T_assigned : ticketAssigned) {

						assignTo = T_assigned.getT_ASSIGN_TO();
						if (assignTo.equalsIgnoreCase("Engineer")) {
							engName = T_assigned.getENGINEER_NAME();
							userPh = T_assigned.getT_USER_PHONE();
							engNameOrGrpName = engName;

							String enggcompany = T_assigned.getENGINEER_COMPANY();
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						}

						else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							engGroup = T_assigned.getENGINEER_GROUP();
							engNameOrGrpName = engGroup;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					mailIDForTo = engEmail;
					mailIDForCC = verifiedTPMails + "," + ticketUserMailID;

					phonenum = userPh + "," + TPMobNo + "," + engPh;

					System.out.println("in Re-Assigned...");

					url = url.replace("spalert_msg",
							enggname.toUpperCase() + "%20Engineer%20has%20Re-Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Re-Assigned" + "%0aSubject :%20" + subject
									+ "%0aPriority :%20" + priority + "%0aOn%20" + mysqldate);

				}

				System.out.println("TPMobNo:" + TPMobNo);
				System.out.println("verifiedTPMails:" + verifiedTPMails);
				System.out.println("mailIDForTo:" + mailIDForTo);
				System.out.println("mailIDForCC:" + mailIDForCC);

				System.out.println("finally phone numbers==" + phonenum);
				url12 = url.replace("spalert_contact", phonenum);
				if (url12.contains(" "))
					url12 = url12.replace(" ", "%20");
				System.out.println("url connect***--------------------" + url12);

				String hostname = "";
				int port = 587;
				String Senderid = "";
				String pass = "";
				String mailid = "";

				String auth = "";
				String authval = "";
				String starttls="";

				Query query23 = sessionFactory.getCurrentSession()
						.createQuery("from mail_config where COMPANY='" + companyname1 + "' ");

				List<mail_config> dataList12 = query23.list();
				System.out.println("before user if" + dataList12);
				for (mail_config dataList23 : dataList12) {
					hostname = dataList23.getHOST();
					port = dataList23.getPORT();
					Senderid = dataList23.getSENDERID();
					pass = dataList23.getPASSWRD();
					mailid = dataList23.getE_MAIL();
					auth = dataList23.getAUTHO();
					starttls=dataList23.getSTART_TLS();
					System.out.println("start tls  " + starttls);

					System.out.println("Sender email get----------------" + mailid);
				}

				if (auth.equalsIgnoreCase("Yes")) {
					authval = "true";
				} else if (auth.equalsIgnoreCase("No")) {
					authval = "false";
				} else {
					authval = "false";
				}

				final String Senderid1 = Senderid;
				final String pass1 = pass;
				//
				int count = 0;
				Properties props = new Properties();

				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", starttls);
				props.put("mail.smtp.auth", authval);
				props.put("mail.smtp.host", hostname);
				props.put("mail.smtp.port", "" + port);
				props.put("mail.smtp.sendpartial", "true");
				props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
				System.out.println("all propert set----------------status=" + status);
//					
				final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						// System.out.println("session value============"+session);
						System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
								+ " pass1=" + pass1);
						return new PasswordAuthentication(Senderid1, pass1);
					}
				});

				if (status.equalsIgnoreCase("Raise")) {
					status = "New";
				}

				String title = "";
				String mailbody = status + " Ticket Alert";
				String mainMSG = "";

				// dynamic title from DB

				try {

					System.out.println("Before Projection List ");
					// Session s = getSession();
					// System.out.println("s =" + s);

					List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
							.createQuery("from ADD_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

					for (ADD_MAIL_TEMPLATE a1 : dataList1) {
						String st = a1.getSTATUS();
						System.out.println("status from template==" + st);
						System.out.println("status from method==" + status);
						if (st.equals(status)) {
							System.out.println("Inside if block");

							title = a1.getSUBJECT();
							mailbody = a1.getMAILBODY();
							System.out.println("title==" + title);

							title = title.replaceAll("!", String.valueOf(id));
							System.out.println("severity:: " + severity);
							title = title.replaceAll("#", status);
							title = title.replaceAll("@", priority);
							title = title.replace("$", severity);
							System.out.println("name==" + title);

							System.out.println("mailbody==" + mailbody);

							mailbody = mailbody.replaceAll("!", String.valueOf(id));

							mailbody = mailbody.replaceAll("#", status);
							mailbody = mailbody.replaceAll("@", priority);

							mailbody = mailbody.replaceAll("~", username);
							mailbody = mailbody.replaceAll("�", enggname);

							System.out.println("mailbody==" + mailbody);
							break;
						} else {
							System.out.println("Inside else block");
							if (status.equalsIgnoreCase("New")) {
								title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							}
							if (status.equalsIgnoreCase("Reopened")) {
								title = "Ticket Status: Re-Open || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Closed")) {
								title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("CLOSEDWITHOUTASSIGN")) {
								title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							}

							else if (status.equalsIgnoreCase("Assigned")) {
								title = "Ticket Status: Assigned || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Rejected")) {
								title = "Ticket Status: Reject || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Re-Assigned")) {
								title = "Ticket Status: Re-Assigned || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Resolved")) {
								title = "Ticket Status: Resolved || Ticket ID: " + id + " || Priority : " + priority;
							} else if (status != null && status.equalsIgnoreCase("Hold")
									|| status.equalsIgnoreCase("Awaiting User Information")
									|| status.equalsIgnoreCase("Pending With Vendor")
									|| status.equalsIgnoreCase("Waiting for Spare")) {
								title = "Ticket Status: " + status + "|| Ticket ID: " + id + " || Priority : "
										+ priority + "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Hold By Ticket Co-ordinator")) {
								title = "Ticket Status: Hold || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Work in Progress")) {
								title = "Ticket Status: Work in Progress || Ticket ID: " + id + " || Priority : "
										+ priority + "|| Severity : " + severity;
							}
						}

					}

					if (engGroup == null || engGroup.contentEquals("")) {
						engGroup = "NA";
					}

					if (engName == null || engName.contentEquals("")) {
						engName = "All Engineers of Group";
					}

					if (status.equalsIgnoreCase("New")) {
						System.out.println("in raise status cond=----------------");

						/*
						 * mainMSG =
						 * "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" +
						 * mailbody +
						 * "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Raised By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Raised  <br></td> <td>"
						 * + id + "</td> <td>" + username + "</td> <td>" + category + "</td><td>" +
						 * branch + "</td><td>" + "New" + "</td><td>" + subject + "</td><td>" + priority
						 * + "</td><td>" + mysqldate +
						 * "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>Thanks And Regards</span>,<br><span style='color:#1f497d; font-weight:100'>ITSM-Helpdesk Team</span>"
						 * ;
						 */

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Raised</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "New" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
				
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter ;

						System.out.println("Raised message======" + mainMSG);

					} else if (status != null && status.equalsIgnoreCase("Hold")
							|| status.equalsIgnoreCase("Awaiting User Information")
							|| status.equalsIgnoreCase("Pending With Vendor")
							|| status.equalsIgnoreCase("Waiting for Spare")) {

						System.out.println("Hold status mainMSG=----------------");

//					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
//							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Hold By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Hold <br></td> <td>"
//							+ id + "</td> <td>" + username + "</td> <td>" + category + "</td><td>"
//							+ branchforMail + "</td><td>" + "Hold" + "</td><td>" + subject + "</td><td>" + priority
//							+ "</td><td>" + mysqldate
//							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket "
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
							
						System.out.println("Hold message======" + mainMSG);

					} else if (status.equalsIgnoreCase("Rejected")) {

						System.out.println("Reject status mainMSG=----------------");

//						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
//								+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Hold By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Hold <br></td> <td>"
//								+ id + "</td> <td>" + username + "</td> <td>" + category + "</td><td>"
//								+ branchforMail + "</td><td>" + "Hold" + "</td><td>" + subject + "</td><td>" + priority
//								+ "</td><td>" + mysqldate
//								+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Reject</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Reject" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Hold message======" + mainMSG);

					}

					else if (status.equalsIgnoreCase("Work in Progress")) {

						System.out.println("Work in Progress status mainMSG=----------------");

//						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
//								+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Hold By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Hold <br></td> <td>"
//								+ id + "</td> <td>" + username + "</td> <td>" + category + "</td><td>"
//								+ branchforMail + "</td><td>" + "Hold" + "</td><td>" + subject + "</td><td>" + priority
//								+ "</td><td>" + mysqldate
//								+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket "
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("WORK IN PROGRS message======" + mainMSG);

					} else if (status.equalsIgnoreCase("Assigned")) {

						System.out.println("in assgn status cond=----------------");
//
//					mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
//							+ "</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d; font-weight:100'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Assigned By</th><th style='padding:5px'>Assigned To Engineer/Group</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Assigned  <br></td> <td>"
//							+ id + "</td> <td>" + username+ "</td> <td>" + engNameOrGrpName.toUpperCase()
//							+ "</td> <td>" + category + "</td><td>" + branchforMail + "</td><td>" + "Assigned"
//							+ "</td><td>" + subject + "</td><td>" + priority + "</td><td>" + mysqldate
//							+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Assigned" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;

						System.out.println("Assigned message======" + mainMSG);

					} else if (status.equalsIgnoreCase("Resolved")) {
						System.out.println("in assgn status cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Resolved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Resolved" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Resolved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					} else if (status.equalsIgnoreCase("Closed")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Closed</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Closed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);

					}
					// CLOSEDWITHOUTASSIGN code

					else if (status.equalsIgnoreCase("CLOSEDWITHOUTASSIGN")) {
						System.out.println("I AM IN CLOSEDWITHOUTASSIGN Messege");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Closed</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Closed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "--" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ "--" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ "--" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);

					}

					else if (status.equalsIgnoreCase("Reopened")) {

						System.out.println("in Reopened mainMSG cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Reopened</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Reopened" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Reopened By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}

					else if (status.equalsIgnoreCase("Re-Assigned")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Re-Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Re-Assigned" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroup + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Re-Assigned By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}

					System.out.println("session value==" + session);
					Message message = new MimeMessage(session);

					// System.out.println("MAIL ID FOR CHECKING ::: "+mailid);
					message.setFrom(new InternetAddress(mailid));
					message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailIDForTo));
					InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);
					System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
					System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
					System.out.println("FINAL MAIL PARSE: " + parse);
					System.out.println("FINAL MAIL TITLE: " + title);
					message.addRecipients(Message.RecipientType.BCC, parse);

					message.setSubject(title);

					BodyPart messageBodyPart = new MimeBodyPart();

					messageBodyPart.setContent(mainMSG, "text/html");

					Multipart multipart = new MimeMultipart();

					multipart.addBodyPart(messageBodyPart);

					message.setContent(multipart);

					try {
						System.out.println("Thread is calling started.....");
						Thread t = new Thread(new ConstructDemo(url12, message));
						t.join();
						t.start();
						System.out.println("Thread is calling finished.....");
					} catch (Exception e) {
						// TODO: handle exception
					}

				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

				// end here

			} catch (Exception e) {
				System.out.println("Exception in EmailSMSTriggered Dao Impl:" + e);
				e.printStackTrace();

			}
			System.out.println("Email triggerd Successfully!");

		} else {
			System.out.println("Email is not triggered00000");
		}
		return null;
	}
	@Override
	public String EmailSMSTriggeredForServiceRequest(String ticketID, String TicketStatus,String assignTo,String engName ,String userPh,String enggcompany1,String engGroupName) {
			
		String getCompForMail = "";
		System.out.println("enggname=="+engName);
		
		System.out.println("assign to"+assignTo);
		System.out.println("ticket status====="+TicketStatus);
		System.out.println("Ticket Id  "+ ticketID);
		
		
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			getCompForMail = session.getAttribute("companyname").toString();
			//System.out.println("loginUserCompany****" + loginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		System.out.println("Company from ticket :: "+getCompForMail);
		String EmailTrigger ="";
		String ticketType="";
		String mailFooter="";
		String tempTicketType="Service Request";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from ADD_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
		List<ADD_MAIL_TEMPLATE> list = query.list();
		for (ADD_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		System.out.println("Emai trigger is:: "+EmailTrigger);
		System.out.println("Company from ticket "+getCompForMail);
		if (EmailTrigger.equals("Yes") && ticketType.equals("Service Request") ) {
			System.out.println("hii i am in raise email**");
			status = TicketStatus;
			id = ticketID;
			System.out.println("Inside EmailTriggersed in service request ");
			System.out.println("ticketID:" + ticketID + " TicketStatus:" + TicketStatus);

			String enggname = "NA";

			String sms_config_URL = "";
			String sms_config_Param = "";
			String url12 = "";
			String department = "NA";
			String company = "NA";
			String branch = "NA";
			String username = "NA";
			String url = "";
			String category = "";

			String branchforMail = "";
			String companyforMail = "";
			String departmentforMail = "";
			String suncat1forMail = "";
			String subcat2forMail = "";

			String subject = "";
			String priority = "";
			String mailIDForCC = "";
			String mailIDForTo = "";
			String ticketUserMailID = "";
			String engNameOrGrpName = "NA";

			String engPh = "";
			String tcPh = "";
		
			String phonenum = "";
			String loginUserPh = "";
			//String assignTo = "";
			String engGroup = "";
			String companyname1 = "";
			String EMAILFORTO = "";
			String severity = "";
			String groupNameFromService="";
			String Request_TypeMail="";
			String Resolver_GroupMail="";
			String Total_ApprovalMail="";
			String L1_Approvel_DesigntnMail="";
			String L2_Approvel_DesigntnMail="";

			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				username = session.getAttribute("username").toString();

				HttpSession session1 = requestAttributes.getRequest().getSession();
				companyname1 = session.getAttribute("companyname").toString();

				System.out.println("COMPANY NAME IS ::::::  " + companyname1);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

			String loginUserMailID = "";
			String loginUserRole = "";
			try {
				List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + companyname1 + "'")
						.list();

				for (loginmaster lg : loginMaster1) {

					loginUserMailID = lg.getEMAIL();
					loginUserPh = lg.getPHONE();
					loginUserRole = lg.getROLE_TYPE();
				}
				System.out.println("loginUserMailID:" + loginUserMailID);

			} catch (Exception e) {
				e.printStackTrace();
			}
			try
			{
				Date date = null;
				date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String mysqldate = formatter.format(date);

				Query queryd = sessionFactory.getCurrentSession()
						.createQuery("from sms_config  where COMPANY='" + companyname1 + "'");

				List<sms_config> dataList = queryd.list();
				for (sms_config dataList12 : dataList) {
					sms_config_URL = dataList12.getURL();
					sms_config_Param = dataList12.getPARAM();
					System.out.println("sms_config_URL:" + sms_config_URL);
					System.out.println("sms_config_Param:" + sms_config_Param);
					url = sms_config_URL.concat("?");
					url = url.concat(sms_config_Param);

				}
				String verifiedTP = "";
				String TPMobNo = "";
				String verifiedTPMails = "";
				System.out.println("tickeyt id is ="+ticketID);
				List<service_request> queryticketRaise =sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='"+ticketID+"'").list();
				for (service_request ticket : queryticketRaise) {
					department = ticket.getT_DEPARTMENT();
					company = ticket.getT_COMPANY();
					branch = ticket.getT_BRANCH();
					category = ticket.getT_CATEGORY();
					branchforMail = ticket.getT_BRANCH();	
					subject = ticket.getT_SUBJECT();
					priority = ticket.getPRIORITY();
					ticketUserMailID = ticket.getT_MAIL();
					companyforMail = ticket.getT_COMPANY();
					departmentforMail = ticket.getT_DEPARTMENT();
					suncat1forMail = ticket.getT_SUBCAT1();
					subcat2forMail = ticket.getT_SUBCAT2();
					severity = ticket.getSEVERITY();
					groupNameFromService=ticket.getASSIGNED_GROUP();
				assignTo=ticket.getASSIGN_TO();
//				fdf
					 Request_TypeMail=ticket.getREQUEST_TYPE();
					 Resolver_GroupMail=ticket.getASSIGNED_GROUP();
					 Total_ApprovalMail=ticket.getAPPROVAL_LEVEL();
					 L1_Approvel_DesigntnMail=ticket.getLEVEL_1_DESIGNATION();
					 L2_Approvel_DesigntnMail=ticket.getLEVEL_2_DESIGNATION();
					 
				
				}
				 System.out.println("branch To***"+branch);
				 System.out.println("dept To***"+company);
				System.out.println("assign To***"+assignTo);
				System.out.println("group name is "+groupNameFromService);
				System.out.println("asssignto from sr"+assignTo);
				Boolean grpbools=false;
				List<loginmaster> catList = sessionFactory.getCurrentSession()
						.createQuery("from loginmaster where ROLE_TYPE='Ticket Co-ordinator' and GROUP_NAME like '%"+groupNameFromService+"%'  ").list();
				for (loginmaster catDrive : catList) {

					////// CHECK SCOPE /////
					System.out.println("----------- START----------");
					//String ScopeDB = catDrive.getLOGIN_SCOPE();
					String groupDB=catDrive.getGROUP_NAME();
					//Boolean userVerified = getLoginScopeForSplit(ScopeDB,ticketID);
					System.out.println("Ticket Co-ordinator NAME: " + catDrive.getUSERNAME());
					System.out.println("Ticket Co-ordinator SCOPE DB: " + groupDB);
					if (groupDB != null ) {

				 for(loginmaster data2:catList) {

					 System.out.println(" data2 LOGINUSER NAME " +   data2.getUSERNAME() );
						verifiedTP = verifiedTP + data2.getUSERNAME() + ",";
						TPMobNo = TPMobNo + data2.getPHONE() + ",";
						verifiedTPMails = verifiedTPMails + data2.getEMAIL() + ",";
					 
				    }


					}
					
				}
//				verifiedTP = verifiedTP.substring(0, verifiedTP.lastIndexOf(","));
			
			//	TPMobNo = TPMobNo.substring(0, TPMobNo.lastIndexOf(","));
				System.out.println("tpPhone is ="+TPMobNo);
				if(verifiedTPMails.endsWith(","))
				{
				verifiedTPMails = verifiedTPMails.substring(0, verifiedTPMails.lastIndexOf(","));
				}
				System.out.println("tp mails ="+verifiedTPMails);
				System.out.println("outside     ttt  raise " +TicketStatus  );
				
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("New")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Completed")) {
					System.out.println("inside ttt  raise " +TicketStatus  );
					url = url.replace("spalert_msg",
							username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

					System.out.println("Raise status url ::::::::::::" + url);
//
//					if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) 
//					{
//						if (verifiedTPMails != null && loginUserMailID != null && verifiedTPMails.contains(loginUserMailID)) 
//						{
//							if (verifiedTPMails.contains("," + loginUserMailID))
//							{
//								verifiedTPMails.replaceAll("," + loginUserMailID, "");
//								
//							} else if (verifiedTPMails.contains(loginUserMailID + ",")) 
//							{
//								verifiedTPMails.replaceAll(loginUserMailID + ",", "");
//							}
//						}
//
//					}
					
					if(TicketStatus.equalsIgnoreCase("New")){
					mailIDForCC = loginUserMailID;
					mailIDForTo = verifiedTPMails;

					phonenum = TPMobNo;
					System.out.println("phone number::::::::::::" + phonenum);
					}
					if(TicketStatus.equalsIgnoreCase("Completed")){
						mailIDForCC = verifiedTPMails;
						mailIDForTo = loginUserMailID;

						phonenum = TPMobNo;
						System.out.println("phone number::::::::::::" + phonenum);
						}

				}
				
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Hold")
						|| TicketStatus.equalsIgnoreCase("Awaiting User Information")
						|| TicketStatus.equalsIgnoreCase("Pending With Vendor")
						|| TicketStatus.equalsIgnoreCase("Waiting for Spare")) {

					System.out.println("Inside Hold Ticket Scope");
				
					String engEmail = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					boolean grpFlag = false;
					String grpEmails = "";
					List<String> gettingEngName = sessionFactory.getCurrentSession()
							.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
					
					for (String T_assigned : gettingEngName) {

						assignTo = T_assigned;
						System.out.println("asssign to=="+assignTo);
						if (assignTo.equalsIgnoreCase("Engineer")) {
						
							String enggcompany = enggcompany1;
							System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"+ enggcompany + "'")
									.list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
						//	String groupDB="";
                         //   boolean scopecheck=false;
						//	engGroup = T_assigned.getASSIGN_ENGG_GROUP();
							engNameOrGrpName = engGroupName;
							System.out.println("group name from serivce"+engGroup);
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();
							for (loginmaster lg : loginMaster) {
								

								String grp = lg.getGROUP_NAME();
								loginscop=lg.getLOGIN_SCOPE();
							if (grp != null && grp.contains(engGroup)) {
								
								String grpArray[] = grp.split(",");

								for (int i = 0; i < grpArray.length; i++) {
									String grpName = grpArray[i];
									if (grpName != null && grpName.equals(engGroup)) {
										grpbool=true;		
											
										String  splitscop[]=	loginscop.split("OR");
										
										for (String splitString : splitscop) {
									
											 branchbool=false;
											 departmentbool=false;
											 companybool=false;
											
											System.out.println("SPLIT STRING FOUND: " + splitString);
											String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
											String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
											String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
											
											System.out.println("scop company   "+ fetchCompany);
											System.out.println("scop branch   "+ fetchBranch);
											System.out.println("scop department   "+ fetchDepartment);

											System.out.println("ticket company   "+ company);
											System.out.println("ticket branch   "+ branch);
											System.out.println("ticket department   "+ department);
											
											
											if(fetchCompany.equals(company) ) 
											{
												System.out.println("company  match ");
												companybool=true;
												if(fetchBranch.contains(",")) {
												String splitbranch1[]=	fetchBranch.split("','");
												for(String splitbranch2:splitbranch1)
												{
													if(splitbranch2.equals(branch)) {
														System.out.println("brach match ");
														branchbool=true;
														
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{
																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}
																	
															}
															
														}
														else {
															System.out.println("else department ");
															if(department.equals(fetchDepartment))
															{
																departmentbool=true;
																
															}
														}
														
													}
													
												}
												}else {
													System.out.println("else branch  +++ ");
													if(branch.equals(fetchBranch)) {
														System.out.println("else branch ");
														branchbool=true;
														if(fetchDepartment.contains("','")) 
														{
															String splitdepartment1[]=	fetchDepartment.split("','");
															for(String splitdepartment2:splitdepartment1)
															{																
																if(splitdepartment2.equals(department)) {
																	System.out.println("department match ");
																	departmentbool=true;
																}																																
															}															
														}
														else {
															System.out.println("else department ++  ");
															if(department.equals(fetchDepartment))
															{
																System.out.println("else condition    ");
																departmentbool=true;																
															}
														}	
													}
												}
												System.out.println("INSIDE MATCH SCOP");
												//scopecheck=true;												
											}											
											System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
											if(grpbool && departmentbool && branchbool && companybool) {
												System.out.println("inside all condition is satisfied");
											engEmail = engEmail + lg.getEMAIL() + ",";
											engPh = engPh + lg.getPHONE() + ",";
											}											
										}	
									}
								}
							}							
						}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}
						}

					}
					String TPName="";
					String TPCompany="";
				
					for (service_request T_assigned : queryticketRaise) {

						 TPName=T_assigned.getTP_ASSIGN_BY_NAME();
						 TPCompany=T_assigned.getTP_ASSIGN_COMPANY();
						 
						//EMAILFORTO = T_assigned.getTP_EMAIL();
					}
					List<loginmaster> lmn = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME = '" +TPName + "' and COMPANY='"+TPCompany+"'").list();
					
					for (loginmaster T_assigned : lmn) {

						
						EMAILFORTO = T_assigned.getEMAIL();
					}
					System.out.println("get Email of tp name from login master");
					System.out.println("EMAIL FOR TO  ++" + EMAILFORTO);

					if(assignTo.equals("Ticket Co-ordinator")) {
						mailIDForTo = ticketUserMailID;
						System.out.println("Mail for to "+EMAILFORTO);						
						mailIDForCC = verifiedTPMails ;						
					}
					else {
						mailIDForTo = engEmail;
						System.out.println("Mail for to "+EMAILFORTO);					
						mailIDForCC = ticketUserMailID + "," + verifiedTPMails ;
						mailIDForTo = engEmail;
						System.out.println("Mail for to "+EMAILFORTO);						
						mailIDForCC = ticketUserMailID + "," + verifiedTPMails ;
					}
					System.out.println("MAil  for cc"+mailIDForCC);
					phonenum = engPh + "," + TPMobNo + "," + userPh;
					System.out.println("phone number =="+phonenum);

//				mailIDForTo =  ticketUserMailID;
//				
//				mailIDForCC = loginUserMailID;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Hold%20Ticket-ID%20" + id + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "Hold"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

			}	
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Work in Progress")) {

					System.out.println("Inside Work in Progress Ticket Scope");

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					System.out.println("hhhhhhhhhhhhhhhhhhhhh");
					List<String> gettingEngName = sessionFactory.getCurrentSession()
							.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
					
					for (String T_assigned : gettingEngName) {

						assignTo = T_assigned;
						System.out.println("asssign to=="+assignTo);
						if (assignTo.equalsIgnoreCase("Engineer")) {
//							engName = T_assigned.getASSIGN_ENGG_NAME();
//							userPh = T_assigned.getT_PHONE();
							String enggcompany = enggcompany1;		
							System.out.println("assign To=="+assignTo);
							System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
					//////////////
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'").list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}
						}

						else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
							//engGroup = T_assigned.getASSIGN_ENGG_GROUP();
							//engNameOrGrpName = engGroup;
							engNameOrGrpName = engGroupName;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {
									
									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											grpbool=true;		
												
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{															
																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
					
																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
						
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}

														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											
											
										}
									}
								}
								
							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}

					if(assignTo.equals("Ticket Co-ordinator")) {
						mailIDForTo = ticketUserMailID;
						System.out.println("Mail for to "+EMAILFORTO);
						
						mailIDForCC = verifiedTPMails;
						
					}
					else {
					mailIDForTo = engEmail;
					System.out.println("mail id for to "+mailIDForTo);
					
					mailIDForCC = verifiedTPMails + "," + ticketUserMailID;
					}
					System.out.println(" mail id for CC=="+mailIDForCC);
					phonenum = engPh + "," + TPMobNo + "," + userPh;
					System.out.println("all numbers====" + phonenum);

					url = url.replace("spalert_msg",
							engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected")) {

					System.out.println("Inside Rejected Ticket Scope");

					//engName = "";

					String engEmail = "";

					boolean grpFlag = false;
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					String grpEmails = "";
					
					
					List<String> gettingEngName = sessionFactory.getCurrentSession()
							.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
					
					for (String T_assigned : gettingEngName) {

						assignTo = T_assigned;

						System.out.println("asssign to=="+assignTo);
						if (assignTo.equalsIgnoreCase("Engineer")) {
						//	engName = T_assigned.getASSIGN_ENGG_NAME();
							//userPh = T_assigned.getT_PHONE();
							String enggcompany =enggcompany1;
							System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
					
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'").list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
                            
							//engGroup = T_assigned.getASSIGN_ENGG_GROUP();
							engNameOrGrpName = engGroupName;
							
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											 grpbool= true;
												String  splitscop[]=	loginscop.split("OR");
												
												for (String splitString : splitscop) {
											
													 branchbool=false;
													 departmentbool=false;
													 companybool=false;
													
													System.out.println("SPLIT STRING FOUND: " + splitString);
													String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
													String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
													String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
													
													System.out.println("scop company   "+ fetchCompany);
													System.out.println("scop branch   "+ fetchBranch);
													System.out.println("scop department   "+ fetchDepartment);

													System.out.println("ticket company   "+ company);
													System.out.println("ticket branch   "+ branch);
													System.out.println("ticket department   "+ department);
													
													
													if(fetchCompany.equals(company) ) 
													{
														System.out.println("company  match ");
														companybool=true;
														if(fetchBranch.contains(",")) {
														String splitbranch1[]=	fetchBranch.split("','");
														for(String splitbranch2:splitbranch1)
														{
															if(splitbranch2.equals(branch)) {
																System.out.println("brach match ");
																branchbool=true;
																
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	}
																	
																}
																else {
																	System.out.println("else department ");
																	if(department.equals(fetchDepartment))
																	{
																		departmentbool=true;
																		
																	}
																}
																
															}
															
														}
														}else {
															System.out.println("else branch  +++ ");
															if(branch.equals(fetchBranch)) {
																System.out.println("else branch ");
																branchbool=true;
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																		

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	
																	}
																	
																}
																else {
																	System.out.println("else department ++  ");
																	if(department.equals(fetchDepartment))
																	{
																		System.out.println("else condition    ");
																		departmentbool=true;
																		
																	}
																}
																
																
																
															}
														}
														System.out.println("INSIDE MATCH SCOP");
														//scopecheck=true;
														
													}
													
													System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
													if(grpbool && departmentbool && branchbool && companybool) {
														System.out.println("inside all condition is satisfied");
													engEmail = engEmail + lg.getEMAIL() + ",";
													engPh = engPh + lg.getPHONE() + ",";
													}
													
												}
											
										}
									}
								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}
					
					String TPName="";
					String TPCompany="";
//					for (service_request T_assigned : gettingEngName) {
//
//						 TPName=T_assigned.getTP_ASSIGN_BY_NAME();
//						 TPCompany=T_assigned.getTP_ASSIGN_COMPANY();
//						 
//						//EMAILFORTO = T_assigned.getTP_EMAIL();
//					}
					List<loginmaster> lmn = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME = '" +TPName + "' and COMPANY='"+TPCompany+"'").list();
					
					for (loginmaster T_assigned : lmn) {

						
						EMAILFORTO = T_assigned.getEMAIL();
					}
					System.out.println("get Email of tp name from login master");
				
					System.out.println("EMAIL FOR TO   ++" + EMAILFORTO);

					mailIDForTo = verifiedTPMails;

					mailIDForCC = ticketUserMailID + "," + engEmail;
					System.out.println("mail to cc"+mailIDForCC);
					

					phonenum = engPh + "," + TPMobNo + "," + userPh;

//				mailIDForTo =  ticketUserMailID;
//				
//				mailIDForCC = loginUserMailID;

					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Hold%20Ticket-ID%20" + id + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "Reject"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Assigned")) {

					System.out.println("Inside Assigned Ticket Scope888");

					String engEmail = "";
					boolean grpFlag = false;
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					String grpEmails = "";

					List<String> gettingEngName = sessionFactory.getCurrentSession()
							.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
					
					for (String T_assigned : gettingEngName) {

						assignTo = T_assigned;
						System.out.println("asssign to=="+assignTo);
						if (assignTo.equalsIgnoreCase("Engineer")) {
						engName = engName;
						System.out.println("engGroupName ==="+engName);
						//	userPh =userPh;
						//	String enggcompany = T_assigned.getASSIGN_ENGG_COMPANY();
							String enggcompany=enggcompany1;
							System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
					
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);

							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'").list();

							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						}

						else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group ***");
                            String loginscop="";
                         //   boolean scopecheck=false;
						
							engNameOrGrpName = engGroupName;
                            
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											 String  splitscop[]=	loginscop.split("OR");
												
												for (String splitString : splitscop) {
											
													 branchbool=false;
													 departmentbool=false;
													 companybool=false;
													
													System.out.println("SPLIT STRING FOUND: " + splitString);
													String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
													String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
													String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
													
													System.out.println("scop company   "+ fetchCompany);
													System.out.println("scop branch   "+ fetchBranch);
													System.out.println("scop department   "+ fetchDepartment);

													System.out.println("ticket company   "+ company);
													System.out.println("ticket branch   "+ branch);
													System.out.println("ticket department   "+ department);
													
													
													if(fetchCompany.equals(company) ) 
													{
														System.out.println("company  match ");
														companybool=true;
														if(fetchBranch.contains(",")) {
														String splitbranch1[]=	fetchBranch.split("','");
														for(String splitbranch2:splitbranch1)
														{
															if(splitbranch2.equals(branch)) {
																System.out.println("brach match ");
																branchbool=true;
																
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	}
																	
																}
																else {
																	System.out.println("else department ");
																	if(department.equals(fetchDepartment))
																	{
																		departmentbool=true;
																		
																	}
																}
																
															}
															
														}
														}else {
															System.out.println("else branch  +++ ");
															if(branch.equals(fetchBranch)) {
																System.out.println("else branch ");
																branchbool=true;
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																		

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	
																	}
																	
																}
																else {
																	System.out.println("else department ++  ");
																	if(department.equals(fetchDepartment))
																	{
																		System.out.println("else condition    ");
																		departmentbool=true;
																		
																	}
																}
															}
														}
														System.out.println("INSIDE MATCH SCOP");
														//scopecheck=true;
														
													}
													
													System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
													if(grpbool && departmentbool && branchbool && companybool) {
														System.out.println("inside all condition is satisfied");
													engEmail = engEmail + lg.getEMAIL() + ",";
													engPh = engPh + lg.getPHONE() + ",";
													}
													
												}
												//if(scopecheck) {
									
												//}
											
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}

					}
					if(assignTo.equals("Ticket Co-ordinator")) {
						mailIDForTo = ticketUserMailID;
						System.out.println("Mail for to "+EMAILFORTO);
						

						mailIDForCC = verifiedTPMails ;
						
					}
					else {
					mailIDForTo = engEmail;
					mailIDForCC = verifiedTPMails + "," + ticketUserMailID;
					}
					phonenum = engPh + "," + TPMobNo + "," + userPh;
					System.out.println("all numbers====" + phonenum);

					url = url.replace("spalert_msg",
							engNameOrGrpName.toUpperCase() + "%20has%20Assigned%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Assigned" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				}
				
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) {

					System.out.println("Inside Resolved Ticket Scope");

				//	engName = "";

					String engEmail = "";
					boolean grpFlag = false;
					String grpEmails = "";
					boolean grpbool = false;
					boolean branchbool=false;
					boolean departmentbool=false;
					boolean companybool=false;
					List<String> gettingEngName = sessionFactory.getCurrentSession()
							.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
					
					for (String T_assigned : gettingEngName) {

						assignTo = T_assigned;
						System.out.println("asssign to=="+assignTo);
						if (assignTo.equalsIgnoreCase("Engineer")) {
						
							String enggcompany = enggcompany1;
							System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
							//System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
					
							System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
											+ enggcompany + "'")
									.list();
							for (loginmaster lg : loginMaster) {

								engEmail = lg.getEMAIL();
								engPh = lg.getPHONE();
							}

						} else if (assignTo.equalsIgnoreCase("Group")) {
							System.out.println("inside group *** inside eng resolved");
                            String loginscop="";
                         //   boolean scopecheck=false;
							//engGroup = T_assigned.getASSIGN_ENGG_GROUP();
							engNameOrGrpName = engGroupName;
							System.out.println("ENG GROUP IS  " + engNameOrGrpName);
							List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
									.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

							for (loginmaster lg : loginMaster) {
								

									String grp = lg.getGROUP_NAME();
									loginscop=lg.getLOGIN_SCOPE();
								if (grp != null && grp.contains(engGroup)) {

									String grpArray[] = grp.split(",");

									for (int i = 0; i < grpArray.length; i++) {
										String grpName = grpArray[i];
										if (grpName != null && grpName.equals(engGroup)) {
											 grpbool= true;
											String  splitscop[]=	loginscop.split("OR");
											
											for (String splitString : splitscop) {
										
												 branchbool=false;
												 departmentbool=false;
												 companybool=false;
												
												System.out.println("SPLIT STRING FOUND: " + splitString);
												String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
												String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
												String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
												
												System.out.println("scop company   "+ fetchCompany);
												System.out.println("scop branch   "+ fetchBranch);
												System.out.println("scop department   "+ fetchDepartment);

												System.out.println("ticket company   "+ company);
												System.out.println("ticket branch   "+ branch);
												System.out.println("ticket department   "+ department);
												
												
												if(fetchCompany.equals(company) ) 
												{
													System.out.println("company  match ");
													companybool=true;
													if(fetchBranch.contains(",")) {
													String splitbranch1[]=	fetchBranch.split("','");
													for(String splitbranch2:splitbranch1)
													{
														if(splitbranch2.equals(branch)) {
															System.out.println("brach match ");
															branchbool=true;
															
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
															

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																}
																
															}
															else {
																System.out.println("else department ");
																if(department.equals(fetchDepartment))
																{
																	departmentbool=true;
																	
																}
															}
															
														}
														
													}
													}else {
														System.out.println("else branch  +++ ");
														if(branch.equals(fetchBranch)) {
															System.out.println("else branch ");
															branchbool=true;
															if(fetchDepartment.contains("','")) 
															{
																String splitdepartment1[]=	fetchDepartment.split("','");
																for(String splitdepartment2:splitdepartment1)
																{
																	

																	if(splitdepartment2.equals(department)) {
																		System.out.println("department match ");
																		departmentbool=true;
																	}
																		
																
																}
																
															}
															else {
																System.out.println("else department ++  ");
																if(department.equals(fetchDepartment))
																{
																	System.out.println("else condition    ");
																	departmentbool=true;
																	
																}
															}
															
															
															
														}
													}
													System.out.println("INSIDE MATCH SCOP");
													//scopecheck=true;
													
												}
												
												System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
												if(grpbool && departmentbool && branchbool && companybool) {
													System.out.println("inside all condition is satisfied");
												engEmail = engEmail + lg.getEMAIL() + ",";
												engPh = engPh + lg.getPHONE() + ",";
												}
												
											}
											//if(scopecheck) {
								
											//}
										}
									}

								}

							}

							if (engEmail.contains(",")) {

								engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
							}

							if (engPh.contains(",")) {

								engPh = engPh.substring(0, engPh.lastIndexOf(","));
							}

						}
					}

//				mailIDForTo = verifiedTPMails + "," + ticketUserMailID;
//
//				mailIDForCC = loginUserMailID + "," + engEmail;

					mailIDForTo = verifiedTPMails;

					mailIDForCC = ticketUserMailID + "," + engEmail;

					phonenum = userPh + "," + TPMobNo + "," + engPh;
					url = url.replace("spalert_msg",
							username.toUpperCase() + "%20Engineer%20has%20Resolved%20Ticket-ID%20" + id
									+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
									+ "%0aStatus :%20" + "Resolved" + "%0aSubject :%20" + subject + "%0aPriority :%20"
									+ priority + "%0aOn%20" + mysqldate);

				}
				 else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Closed")) {

						System.out.println("Inside CLOSED Ticket Scope");

						engName = "";

						String engEmail = "";
						boolean grpFlag = false;
						String grpEmails = "";
						boolean grpbool = false;
						boolean branchbool=false;
						boolean departmentbool=false;
						boolean companybool=false;

						List<service_request> gettingEngName = sessionFactory.getCurrentSession()
								.createQuery("from service_request where T_ID = '" + ticketID + "'").list();
						
						for (service_request T_assigned : gettingEngName) {

							assignTo = T_assigned.getASSIGN_TO();
							System.out.println("asssign to=="+assignTo);
							if (assignTo.equalsIgnoreCase("Engineer")) {
							//	engName = T_assigned.getASSIGN_ENGG_NAME();
								userPh = T_assigned.getT_PHONE();
								String enggcompany = enggcompany1;
								System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
						
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
												+ enggcompany + "'")
										.list();

								for (loginmaster lg : loginMaster) {

									engEmail = lg.getEMAIL();
									engPh = lg.getPHONE();
								}

							} else if (assignTo.equalsIgnoreCase("Group")) {
								System.out.println("inside group ***");
	                            String loginscop="";
	                         //   boolean scopecheck=false;
								engGroup = T_assigned.getASSIGN_ENGG_GROUP();
								engNameOrGrpName = engGroup;
								System.out.println("ENG GROUP IS  " + engNameOrGrpName);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

								for (loginmaster lg : loginMaster) {
									

										String grp = lg.getGROUP_NAME();
										loginscop=lg.getLOGIN_SCOPE();
									if (grp != null && grp.contains(engGroup)) {

										String grpArray[] = grp.split(",");

										for (int i = 0; i < grpArray.length; i++) {
											String grpName = grpArray[i];
											if (grpName != null && grpName.equals(engGroup)) {
												 grpbool= true;
												String  splitscop[]=	loginscop.split("OR");
												
												for (String splitString : splitscop) {
											
													 branchbool=false;
													 departmentbool=false;
													 companybool=false;
													
													System.out.println("SPLIT STRING FOUND: " + splitString);
													String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
													String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
													String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
													
													System.out.println("scop company   "+ fetchCompany);
													System.out.println("scop branch   "+ fetchBranch);
													System.out.println("scop department   "+ fetchDepartment);

													System.out.println("ticket company   "+ company);
													System.out.println("ticket branch   "+ branch);
													System.out.println("ticket department   "+ department);
													
													
													if(fetchCompany.equals(company) ) 
													{
														System.out.println("company  match ");
														companybool=true;
														if(fetchBranch.contains(",")) {
														String splitbranch1[]=	fetchBranch.split("','");
														for(String splitbranch2:splitbranch1)
														{
															if(splitbranch2.equals(branch)) {
																System.out.println("brach match ");
																branchbool=true;
																
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	}
																	
																}
																else {
																	System.out.println("else department ");
																	if(department.equals(fetchDepartment))
																	{
																		departmentbool=true;
																		
																	}
																}
																
															}
															
														}
														}else {
															System.out.println("else branch  +++ ");
															if(branch.equals(fetchBranch)) {
																System.out.println("else branch ");
																branchbool=true;
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																		

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	
																	}
																	
																}
																else {
																	System.out.println("else department ++  ");
																	if(department.equals(fetchDepartment))
																	{
																		System.out.println("else condition    ");
																		departmentbool=true;
																		
																	}
																}
																
																
																
															}
														}
														System.out.println("INSIDE MATCH SCOP");
														//scopecheck=true;
														
													}
													
													System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
													if(grpbool && departmentbool && branchbool && companybool) {
														System.out.println("inside all condition is satisfied");
													engEmail = engEmail + lg.getEMAIL() + ",";
													engPh = engPh + lg.getPHONE() + ",";
													}
													
												}
												//if(scopecheck) {
									
												//}
											}
										}

									}

								}

								if (engEmail.contains(",")) {

									engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
								}

								if (engPh.contains(",")) {

									engPh = engPh.substring(0, engPh.lastIndexOf(","));
								}

							}

						}
						if(assignTo.equals("Ticket Co-ordinator")) {
							mailIDForTo = ticketUserMailID;
							System.out.println("Mail for to "+EMAILFORTO);
							

							mailIDForCC = verifiedTPMails ;
							
						}else {
						mailIDForTo = engEmail;
						mailIDForCC = ticketUserMailID + "," + verifiedTPMails;
						}
						phonenum = userPh + "," + TPMobNo + "," + engPh;

						url = url.replace("spalert_msg",
								username.toUpperCase() + "%20Ticket%20has%20Closed%20Ticket-ID%20" + id
										+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
										+ "%0aStatus :%20" + "Closed" + "%0aSubject :%20" + subject + "%0aPriority :%20"
										+ priorityname1 + "%0aOn%20" + mysqldate);

					}
				 else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Reopened")) {

						System.out.println("Inside reopen Ticket Scope");

						//engName = "";

						String engEmail = "";
						boolean grpFlag = false;
						String grpEmails = "";
						boolean grpbool = false;
						boolean branchbool=false;
						boolean departmentbool=false;
						boolean companybool=false;

						List<service_request> gettingEngName = sessionFactory.getCurrentSession()
								.createQuery("from service_request where T_ID = '" + ticketID + "'").list();
						
						for (service_request T_assigned : gettingEngName) {

							assignTo = T_assigned.getASSIGN_TO();
							System.out.println("asssign to=="+assignTo);
							if (assignTo.equalsIgnoreCase("Engineer")) {
								//engName = T_assigned.getASSIGN_ENGG_NAME();
							//	userPh = T_assigned.getT_PHONE();
								String enggcompany = enggcompany1;
								System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
						
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
												+ enggcompany + "'")
										.list();

								for (loginmaster lg : loginMaster) {

									engEmail = lg.getEMAIL();
									engPh = lg.getPHONE();
								}
							} else if (assignTo.equalsIgnoreCase("Group")) {
								System.out.println("inside group ***");
	                            String loginscop="";
	                         //   boolean scopecheck=false;
							//	engGroup = T_assigned.getASSIGN_ENGG_GROUP();
								engNameOrGrpName = engGroupName;
								System.out.println("ENG GROUP IS  " + engNameOrGrpName);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();

								for (loginmaster lg : loginMaster) {
									

										String grp = lg.getGROUP_NAME();
										loginscop=lg.getLOGIN_SCOPE();
									if (grp != null && grp.contains(engGroup)) {

										String grpArray[] = grp.split(",");

										for (int i = 0; i < grpArray.length; i++) {
											String grpName = grpArray[i];
											if (grpName != null && grpName.equals(engGroup)) {
												 grpbool= true;
												String  splitscop[]=	loginscop.split("OR");
												
												for (String splitString : splitscop) {
											
													 branchbool=false;
													 departmentbool=false;
													 companybool=false;
													
													System.out.println("SPLIT STRING FOUND: " + splitString);
													String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
													String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
													String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
													
													System.out.println("scop company   "+ fetchCompany);
													System.out.println("scop branch   "+ fetchBranch);
													System.out.println("scop department   "+ fetchDepartment);

													System.out.println("ticket company   "+ company);
													System.out.println("ticket branch   "+ branch);
													System.out.println("ticket department   "+ department);
													if(fetchCompany.equals(company) ) 
													{
														System.out.println("company  match ");
														companybool=true;
														if(fetchBranch.contains(",")) {
														String splitbranch1[]=	fetchBranch.split("','");
														for(String splitbranch2:splitbranch1)
														{
															if(splitbranch2.equals(branch)) {
																System.out.println("brach match ");
																branchbool=true;
																
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	}
																	
																}
																else {
																	System.out.println("else department ");
																	if(department.equals(fetchDepartment))
																	{
																		departmentbool=true;
																		
																	}
																}
																
															}
															
														}
														}else {
															System.out.println("else branch  +++ ");
															if(branch.equals(fetchBranch)) {
																System.out.println("else branch ");
																branchbool=true;
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	
																	}
																	
																}
																else {
																	System.out.println("else department ++  ");
																	if(department.equals(fetchDepartment))
																	{
																		System.out.println("else condition    ");
																		departmentbool=true;
																		
																	}
																}
																
																
																
															}
														}
														System.out.println("INSIDE MATCH SCOP");
														//scopecheck=true;
														
													}
													
													System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
													if(grpbool && departmentbool && branchbool && companybool) {
														System.out.println("inside all condition is satisfied");
													engEmail = engEmail + lg.getEMAIL() + ",";
													engPh = engPh + lg.getPHONE() + ",";
													}
													
												}
												//if(scopecheck) {
									
												//}
											}
										}

									}

								}

								if (engEmail.contains(",")) {

									engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
								}

								if (engPh.contains(",")) {

									engPh = engPh.substring(0, engPh.lastIndexOf(","));
								}

							}

						}

						mailIDForTo = verifiedTPMails;
						mailIDForCC = loginUserMailID + "," + engEmail;

						phonenum = userPh + "," + TPMobNo + "," + engPh;

						url = url.replace("spalert_msg",
								username.toUpperCase() + "%20User%20has%20Re-Open%20Ticket-ID%20" + id
										+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
										+ "%0aStatus :%20" + "Re-Open" + "%0aSubject :%20" + subject + "%0aPriority :%20"
										+ priority + "%0aOn%20" + mysqldate);
					}
				 else if (status.equalsIgnoreCase("Re-Assigned")) {

					
						String engEmail = "";
						boolean grpFlag = false;
						String grpEmails = "";
						boolean grpbool = false;
						boolean branchbool=false;
						boolean departmentbool=false;
						boolean companybool=false;

						List<String> gettingEngName = sessionFactory.getCurrentSession()
								.createSQLQuery("select ASSIGN_TO from service_request where T_ID = '" + ticketID + "'").list();
						
						for (String T_assigned : gettingEngName) {

							assignTo = T_assigned;
							
							System.out.println("asssign to=="+assignTo);
							if (assignTo.equalsIgnoreCase("Engineer")) {
							
								String enggcompany =enggcompany1;
								System.out.println("Engg name ="+engName+"  =userPhone ="+userPh+" = eng comp"+enggcompany);
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
						
								System.out.println("ENGG COMPANY	S NAME :: " + enggcompany);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where USERNAME = '" + engName + "' AND COMPANY='"
												+ enggcompany + "'")
										.list();

								for (loginmaster lg : loginMaster) {

									engEmail = lg.getEMAIL();
									engPh = lg.getPHONE();
								}

							}

							else if (assignTo.equalsIgnoreCase("Group")) {
								System.out.println("inside group ***");
	                            String loginscop="";
	                         //   boolean scopecheck=false;
							//	engGroup = T_assigned.getASSIGN_ENGG_GROUP();
								engNameOrGrpName = engGroupName;
								System.out.println("ENG GROUP IS  " + engNameOrGrpName);
								List<loginmaster> loginMaster = sessionFactory.getCurrentSession()
										.createQuery("from loginmaster where ROLE_TYPE='Engineer'").list();
								for (loginmaster lg : loginMaster) {
									

										String grp = lg.getGROUP_NAME();
										loginscop=lg.getLOGIN_SCOPE();
									if (grp != null && grp.contains(engGroup)) {

										String grpArray[] = grp.split(",");

										for (int i = 0; i < grpArray.length; i++) {
											String grpName = grpArray[i];
											if (grpName != null && grpName.equals(engGroup)) {
												 grpbool= true;
												String  splitscop[]=	loginscop.split("OR");
												
												for (String splitString : splitscop) {
											
													 branchbool=false;
													 departmentbool=false;
													 companybool=false;
													
													System.out.println("SPLIT STRING FOUND: " + splitString);
													String fetchCompany = StringUtils.substringBetween(splitString, "T_COMPANY IN ('", "')");
													String fetchBranch = StringUtils.substringBetween(splitString, "T_BRANCH IN ('", "')");
													String fetchDepartment = StringUtils.substringBetween(splitString, "T_DEPARTMENT IN ('", "')");
													
													System.out.println("scop company   "+ fetchCompany);
													System.out.println("scop branch   "+ fetchBranch);
													System.out.println("scop department   "+ fetchDepartment);

													System.out.println("ticket company   "+ company);
													System.out.println("ticket branch   "+ branch);
													System.out.println("ticket department   "+ department);
													
													
													if(fetchCompany.equals(company) ) 
													{
														System.out.println("company  match ");
														companybool=true;
														if(fetchBranch.contains(",")) {
														String splitbranch1[]=	fetchBranch.split("','");
														for(String splitbranch2:splitbranch1)
														{
															if(splitbranch2.equals(branch)) {
																System.out.println("brach match ");
																branchbool=true;
																
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	}
																	
																}
																else {
																	System.out.println("else department ");
																	if(department.equals(fetchDepartment))
																	{
																		departmentbool=true;
																		
																	}
																}
																
															}
															
														}
														}else {
															System.out.println("else branch  +++ ");
															if(branch.equals(fetchBranch)) {
																System.out.println("else branch ");
																branchbool=true;
																if(fetchDepartment.contains("','")) 
																{
																	String splitdepartment1[]=	fetchDepartment.split("','");
																	for(String splitdepartment2:splitdepartment1)
																	{
																		

																		if(splitdepartment2.equals(department)) {
																			System.out.println("department match ");
																			departmentbool=true;
																		}
																			
																	
																	}
																	
																}
																else {
																	System.out.println("else department ++  ");
																	if(department.equals(fetchDepartment))
																	{
																		System.out.println("else condition    ");
																		departmentbool=true;
																		
																	}
																}
																
																
																
															}
														}
														System.out.println("INSIDE MATCH SCOP");
														//scopecheck=true;
														
													}
													
													System.out.println("LOOK CONDITIONS " + "group "+ grpbool+"   BRACH "+branchbool+ "  departemnt   "+ departmentbool+"   company "+companybool);
													if(grpbool && departmentbool && branchbool && companybool) {
														System.out.println("inside all condition is satisfied");
													engEmail = engEmail + lg.getEMAIL() + ",";
													engPh = engPh + lg.getPHONE() + ",";
													}
													
												}
												//if(scopecheck) {
									
												//}
											}
										}

									}

								}

								if (engEmail.contains(",")) {

									engEmail = engEmail.substring(0, engEmail.lastIndexOf(","));
								}

								if (engPh.contains(",")) {

									engPh = engPh.substring(0, engPh.lastIndexOf(","));
								}

							}

						}
						if(assignTo.equals("Ticket Co-ordinator")) {
							mailIDForTo = ticketUserMailID;
							System.out.println("Mail for to "+EMAILFORTO);
							

							mailIDForCC = verifiedTPMails ;
							
						}
						else {
						mailIDForTo = engEmail;
						mailIDForCC = verifiedTPMails + "," + ticketUserMailID;
						}
						phonenum = userPh + "," + TPMobNo + "," + engPh;

						System.out.println("in Re-Assigned...");

						url = url.replace("spalert_msg",
								enggname.toUpperCase() + "%20Engineer%20has%20Re-Assigned%20Ticket-ID%20" + id
										+ "%0aDetails:%0aType :%20" + category + "%0aBranch :%20" + branchforMail
										+ "%0aStatus :%20" + "Re-Assigned" + "%0aSubject :%20" + subject
										+ "%0aPriority :%20" + priority + "%0aOn%20" + mysqldate);

					}
				 else if (status.equalsIgnoreCase("Level 1 Approved")) {
						System.out.println("inside ttt  raise " +TicketStatus  );
						url = url.replace("spalert_msg",
								username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
										+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
										+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
										+ mysqldate);

						System.out.println("Raise status url ::::::::::::" + url);

						if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) {
							if (verifiedTPMails != null && loginUserMailID != null
									&& verifiedTPMails.contains(loginUserMailID)) {
								if (verifiedTPMails.contains("," + loginUserMailID)) {
									verifiedTPMails.replaceAll("," + loginUserMailID, "");
								} else if (verifiedTPMails.contains(loginUserMailID + ",")) {
									verifiedTPMails.replaceAll(loginUserMailID + ",", "");
								}
							}

						}

						mailIDForCC = loginUserMailID;
						mailIDForTo = verifiedTPMails;

						phonenum = TPMobNo;
						System.out.println("phone number::::::::::::" + phonenum);
						System.out.println("mailIDForCC== ="+mailIDForCC);
						System.out.println("mailIDForTo=="+mailIDForTo);
					}
				 else if (status.equalsIgnoreCase("Level 1 Rejected")) {
						System.out.println("inside ttt  raise " +TicketStatus  );
						url = url.replace("spalert_msg",
								username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
										+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
										+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
										+ mysqldate);

						System.out.println("Raise status url ::::::::::::" + url);

						if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) {
							if (verifiedTPMails != null && loginUserMailID != null
									&& verifiedTPMails.contains(loginUserMailID)) {
								if (verifiedTPMails.contains("," + loginUserMailID)) {
									verifiedTPMails.replaceAll("," + loginUserMailID, "");
								} else if (verifiedTPMails.contains(loginUserMailID + ",")) {
									verifiedTPMails.replaceAll(loginUserMailID + ",", "");
								}
							}

						}

						mailIDForCC = loginUserMailID;
						mailIDForTo = verifiedTPMails;

						phonenum = TPMobNo;
						System.out.println("phone number::::::::::::" + phonenum);

					}
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Level 2 Rejected")) {
					System.out.println("inside ttt  raise " +TicketStatus  );
					url = url.replace("spalert_msg",
							username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);

					System.out.println("Raise status url ::::::::::::" + url);

					if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) 
					{
						if (verifiedTPMails != null && loginUserMailID != null && verifiedTPMails.contains(loginUserMailID)) 
						{
							if (verifiedTPMails.contains("," + loginUserMailID))
							{
								verifiedTPMails.replaceAll("," + loginUserMailID, "");
								
							} else if (verifiedTPMails.contains(loginUserMailID + ",")) 
							{
								verifiedTPMails.replaceAll(loginUserMailID + ",", "");
							}
						}
					}

					mailIDForCC = loginUserMailID;
					mailIDForTo = verifiedTPMails;

					phonenum = TPMobNo;
					System.out.println("phone number::::::::::::" + phonenum);

				}
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Level 2 Approved")) {
					System.out.println("inside ttt  raise " +TicketStatus  );
					url = url.replace("spalert_msg",
							username + "%20User%20has%20Raised%20Ticket-ID%20" + ticketID + "%0aDetails:%0aType :%20"
									+ category + "%0aBranch :%20" + branchforMail + "%0aStatus :%20" + "New"
									+ "%0aSubject :%20" + subject + "%0aPriority :%20" + priority + "%0aOn%20"
									+ mysqldate);
					System.out.println("Raise status url ::::::::::::" + url);

					if (loginUserRole != null && loginUserRole.equalsIgnoreCase("Ticket Co-ordinator")) 
					{
						if (verifiedTPMails != null && loginUserMailID != null && verifiedTPMails.contains(loginUserMailID)) 
						{
							if (verifiedTPMails.contains("," + loginUserMailID))
							{
								verifiedTPMails.replaceAll("," + loginUserMailID, "");
								
							} else if (verifiedTPMails.contains(loginUserMailID + ",")) 
							{
								verifiedTPMails.replaceAll(loginUserMailID + ",", "");
							}
						}
					}
					mailIDForCC = loginUserMailID;
					mailIDForTo = verifiedTPMails;

					phonenum = TPMobNo;
					System.out.println("mailIdForCC=="+mailIDForCC);
					System.out.println("mailIDForTo=="+mailIDForTo);
					System.out.println("phone number::::::::::::" + phonenum);
					System.out.println("Level 2 Approved ");

				}
				
				System.out.println("TPMobNo:" + TPMobNo);
				System.out.println("verifiedTPMails:" + verifiedTPMails);
				System.out.println("mailIDForTo:" + mailIDForTo);
				System.out.println("mailIDForCC:" + mailIDForCC);

				System.out.println("finally phone numbers==" + phonenum);
				url12 = url.replace("spalert_contact", phonenum);
				if (url12.contains(" "))
					url12 = url12.replace(" ", "%20");
				System.out.println("url connect***--------------------" + url12);

				String hostname = "";
				int port = 587;
				String Senderid = "";
				String pass = "";
				String mailid = "";

				String auth = "";
				String authval = "";
				String starttls="";

				Query query23 = sessionFactory.getCurrentSession()
						.createQuery("from mail_config where COMPANY='" + companyname1 + "' ");

				List<mail_config> dataList12 = query23.list();
				System.out.println("before user if" + dataList12);
				for (mail_config dataList23 : dataList12) {
					hostname = dataList23.getHOST();
					port = dataList23.getPORT();
					Senderid = dataList23.getSENDERID();
					pass = dataList23.getPASSWRD();
					mailid = dataList23.getE_MAIL();
					auth = dataList23.getAUTHO();
					starttls=dataList23.getSTART_TLS();
					System.out.println("start tls  " + starttls);

					System.out.println("Sender email get----------------" + mailid);
				}
					
				if (auth.equalsIgnoreCase("Yes")) {
					authval = "true";
				} else if (auth.equalsIgnoreCase("No")) {
					authval = "false";
				} else {
					authval = "false";
				}

				final String Senderid1 = Senderid;
				final String pass1 = pass;

				int count = 0;
				Properties props = new Properties();

				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", starttls);
				props.put("mail.smtp.auth", authval);
				props.put("mail.smtp.host", hostname);
				props.put("mail.smtp.port", "" + port);
				props.put("mail.smtp.sendpartial", "true");
				
				System.out.println("all propert set----------------status=" + status);
//					
				final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						// System.out.println("session value============"+session);
						System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
								+ " pass1=" + pass1);
						return new PasswordAuthentication(Senderid1, pass1);
					}
				});
				String title = "";
				String mailbody = status + " Ticket Alert";
				String mainMSG = "";
				try
				{
					
					System.out.println("Before Projection List ");
					// Session s = getSession();
					// System.out.println("s =" + s);

					List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
							.createQuery("from ADD_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

					for (ADD_MAIL_TEMPLATE a1 : dataList1) {
						String st = a1.getSTATUS();
						System.out.println("status from template==" + st);
						System.out.println("status from method==" + status);
						if (st.equals(status)) {
							System.out.println("Inside if block");

							title = a1.getSUBJECT();
							mailbody = a1.getMAILBODY();
							System.out.println("title==" + title);

							title = title.replaceAll("!", String.valueOf(id));
							System.out.println("severity:: " + severity);
							title = title.replaceAll("#", status);
							title = title.replaceAll("@", priority);
							title = title.replace("$", severity);
							System.out.println("name==" + title);

							System.out.println("mailbody==" + mailbody);

							mailbody = mailbody.replaceAll("!", String.valueOf(id));

							mailbody = mailbody.replaceAll("#", status);
							mailbody = mailbody.replaceAll("@", priority);

							mailbody = mailbody.replaceAll("~", username);
							mailbody = mailbody.replaceAll("�", enggname);

							System.out.println("mailbody==" + mailbody);
							break;
						} else {
							System.out.println("Inside else block");
							if (status.equalsIgnoreCase("New")) {
								title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							}
							if (status.equalsIgnoreCase("Reopened")) {
								title = "Ticket Status: Re-Open || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Closed")) {
								title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("CLOSEDWITHOUTASSIGN")) {
								title = "Ticket Status: Closed || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							}

							else if (status.equalsIgnoreCase("Assigned")) {
								title = "Ticket Status: Assigned || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Rejected")) {
								title = "Ticket Status: Reject || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Re-Assigned")) {
								title = "Ticket Status: Re-Assigned || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Resolved")) {
								title = "Ticket Status: Resolved || Ticket ID: " + id + " || Priority : " + priority;
							} else if (status != null && status.equalsIgnoreCase("Hold")
									|| status.equalsIgnoreCase("Awaiting User Information")
									|| status.equalsIgnoreCase("Pending With Vendor")
									|| status.equalsIgnoreCase("Waiting for Spare")) {
								title = "Ticket Status: " + status + "|| Ticket ID: " + id + " || Priority : "
										+ priority + "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Hold By Ticket Co-ordinator")) {
								title = "Ticket Status: Hold || Ticket ID: " + id + " || Priority : " + priority
										+ "|| Severity : " + severity;
							} else if (status.equalsIgnoreCase("Work in Progress")) {
								title = "Ticket Status: Work in Progress || Ticket ID: " + id + " || Priority : "
										+ priority + "|| Severity : " + severity;
							}
						}

					}
					if (engGroupName == null || engGroupName.contentEquals("")) {
						engGroupName = "NA";
					}
					
					
					if (engName == null || engName.contentEquals("")) {
						engName = "All Engineers of Group";
					}
					if (status.equalsIgnoreCase("New")) {
					
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							mailFooter="<br><b>Admin-Team</b>";
//							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						System.out.println("in raise status cond=----------------");
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Raised</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "New" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Processing Group</strong></td><td style='padding:5px;'>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter ;

						System.out.println("Raised message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Completed")) {
						System.out.println("in raise status cond=----------------");
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Raised</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Completed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Processing Group</strong></td><td style='padding:5px;'>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter ;

						System.out.println("Raised message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Assigned")) {

						
						System.out.println("in assgn status cond=----------------"+engGroupName);
						
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Assigned" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assigned By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;

						System.out.println("Assigned message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Level 2 Approved")) {
						
						System.out.println("in Level 2 Approved status cond=----------------");
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Raised</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Level 2 Approved" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter ;
						System.out.println("Raised message======" + mainMSG);

					}
					
					else if (status.equalsIgnoreCase("Level 2 Rejected")) {
						System.out.println("in Level 1 Rejected status cond=----------------");

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Raised</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Level 2 Rejected" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter ;

						System.out.println("Raised message======" + mainMSG);

					}
					
					else if (status != null && status.equalsIgnoreCase("Hold")
							|| status.equalsIgnoreCase("Awaiting User Information")
							|| status.equalsIgnoreCase("Pending With Vendor")
							|| status.equalsIgnoreCase("Waiting for Spare")) {
						System.out.println("Hold status mainMSG=----------------"+status);
						System.out.println("Hold status mainMSG=----------------"+engName);
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket "
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
							
						System.out.println("Hold message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Rejected")) {

						System.out.println("Reject status mainMSG=----------------");

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Reject</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Rejected" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Hold message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Work in Progress")) {

						System.out.println("I am in work in proggress "+assignTo);
						System.out.println("I am in engGroupName "+engGroupName);
						System.out.println("I am in engName "+engName);
						
						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket "
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ status + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("WORK IN PROGRS message======" + mainMSG);

					}  else if (status.equalsIgnoreCase("Resolved")) {
						System.out.println("in assgn status cond=----------------");

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Resolved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Resolved" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Resolved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					} else if (status.equalsIgnoreCase("Closed")) {

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Closed</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Closed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);

					}
					else if (status.equalsIgnoreCase("Reopened")) {

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
							
							mailFooter="<br><b>Admin-Team</b>";
						}
						else
						{
						
							mailFooter=mailFooter;
						}
						System.out.println("in Reopened mainMSG cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Reopened</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Reopened" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Reopened By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+"<BR>"+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}

					else if (status.equalsIgnoreCase("Re-Assigned")) {

						if(Resolver_GroupMail.equals("HR-Onboarding Team") ||Resolver_GroupMail.equals("HR-Recruiter")||
								Resolver_GroupMail.equals("HR-Payroll")||Resolver_GroupMail.equals("HR-PF helpdesk")||Resolver_GroupMail.equals("HR-ESIC helpdesk")
								||Resolver_GroupMail.equals("HR-HRBP"))
						{
							mailFooter="<br><b>HR-Team</b>";
						}
						else if(Resolver_GroupMail.equals("Admin-Printing Stationery") ||
								Resolver_GroupMail.equals("Admin-Office stationery")||
								Resolver_GroupMail.equals("Admin-Conference booking")||
								Resolver_GroupMail.equals("Admin-Repair & Maintenance")||
								Resolver_GroupMail.equals("Admin-Travel desk")
								)
						{
					
							mailFooter="<br><b>Admin-Team<b>";
						}
						else
						{
							mailFooter=mailFooter;
						}
						System.out.println("in am in Re-Assigned");
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Ticket Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Ticket Re-Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Re-Assigned" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Ticket ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ assignTo + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ engGroupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
								+ engName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Re-Assigned By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Subject</strong></td> <td style='padding:5px;'>"
								+ subject + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ companyforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ departmentforMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Category</strong></td><td style='padding:5px;'>"
								+ category + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category1</strong></td><td style='padding:5px;'>"
								+ suncat1forMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Sub-Category2</strong></td><td style='padding:5px;'>"
								+ subcat2forMail + "</td>" + "</tr>" + "<tr>"
								+ Resolver_GroupMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Type</strong></td><td style='padding:5px;'>"
								+ Request_TypeMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Total Approvel</strong></td><td style='padding:5px;'>"
								+ Total_ApprovalMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L1 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L1_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>L2 Approver Designation</strong></td><td style='padding:5px;'>"
								+ L2_Approvel_DesigntnMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					System.out.println("session value==" + session);
					Message message = new MimeMessage(session);

					// System.out.println("MAIL ID FOR CHECKING ::: "+mailid);
					message.setFrom(new InternetAddress(mailid));
					message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailIDForTo));
					InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);
					System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
					System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
					System.out.println("FINAL MAIL PARSE: " + parse);
					System.out.println("FINAL MAIL TITLE: " + title);
					message.addRecipients(Message.RecipientType.BCC, parse);
					message.setSubject(title);
					BodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(mainMSG, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);

					try {
						System.out.println("Thread is calling started.....");
						Thread t = new Thread(new ConstructDemo(url12, message));
						t.join();
						t.start();
						System.out.println("Thread is calling finished.....");
					} catch (Exception e) {
						// TODO: handle exception
					}

				
				}catch (Exception e) {
					e.printStackTrace();
				}
				
		}
			catch (Exception e) {
			e.printStackTrace();
			
			}
			System.out.println("Email triggerd Successfully!");
		}
			
		else
		{
			System.out.println("Email is not triggerd");
		}
		
		
		return null;
	}
	@Override
	public void EmaiLSmsTriggerdInSoftwareRequest(String ticketID, String TicketStatus) {
		String getCompForMail = "";
		String username = "NA";

		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession sessionForCompany = requestAttributes1.getRequest().getSession();
		getCompForMail = sessionForCompany.getAttribute("companyname").toString();
		username = sessionForCompany.getAttribute("username").toString();
//		System.out.println("Company from ticket :: "+TicketStatus);
		String EmailTrigger ="";
		String ticketType="";
		String mailFooter="";
		String tempTicketType="Software Request";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from EFORM_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
//		System.out.println("sdddddddddddsafdafasssssssssss"+"from ADD_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
		List<EFORM_MAIL_TEMPLATE> list = query.list();
		for (EFORM_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		if (EmailTrigger.equals("Yes") && ticketType.equals("Software Request") ) {
			status = TicketStatus;
			id = ticketID;
			System.out.println("Inside EmailTriggersed in service request ");
			System.out.println("ticketID:" + ticketID + " TicketStatus:" + TicketStatus);

			String enggname = "NA";

			String sms_config_URL = "";
			String sms_config_Param = "";
			String url12 = "";
			String department = "NA";
			String company = "NA";
			String branch = "NA";
			
			String url = "";
			String category = "";

			String branchforMail = "";
			String companyforMail = "";
			String departmentforMail = "";
			String suncat1forMail = "";
			String subcat2forMail = "";

			String subject = "";
			String priority = "";
			String mailIDForCC = "";
			String mailIDForTo = "";
			String ticketUserMailID = "";
			String engNameOrGrpName = "NA";
			String engPh = "";
			String tcPh = "";
			String phonenum = "";
			String loginUserPh = "";
			String RaisedByName="";
			String RaisedByCompany="";
			String loginUserMailID = "";
			String loginUserRole = "";
			String PID="";
			String Softwarename="";
			String cost="";
			String rperiod="";
			String RequesterMail="";
			String Request_category="";
		
			try {
				String usernameofappname="";
				String groupName="";
				Date date = null;
				date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String mysqldate = formatter.format(date);
				List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
						.list();

				for (loginmaster lg : loginMaster1) {

					loginUserMailID = lg.getEMAIL();
					loginUserPh = lg.getPHONE();
					loginUserRole = lg.getROLE_TYPE();
				}
				List<SOFTWARE_REQUEST> lst=sessionFactory.getCurrentSession().createQuery("from SOFTWARE_REQUEST where T_ID='"+ticketID+"'").list();
				for(SOFTWARE_REQUEST l:lst)
				{
					department = l.getT_DEPARTMENT();
					company = l.getT_COMPANY();
					branch = l.getT_BRANCH();
					usernameofappname=l.getAPPROVAR_NAME();
					groupName=l.getGROUPNAME();
					RaisedByCompany=l.getT_COMPANY();
					RaisedByName=l.getT_REQUESTER();
					 RequesterMail = l.getEMAIL_ID();
					PID=l.getP_ID();
					Softwarename=l.getS_NAME();
					cost=l.getS_COST();
					rperiod=l.getS_PERIOD();
					Request_category=l.getCATEGORY_REQUEST();
					ticketUserMailID = l.getEMAIL_ID();
				
				}
				System.out.println("loginUserMailID:" + loginUserMailID);
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approval For Manager")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Re-Opened")) {
					
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + usernameofappname + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
						UsernameRoleForTo=ls.getROLE_TYPE();
					}

					//////////////////Requester email///
//					 String loginuseremail="";
//					 loginuseremail="dddddd";
//			 String ssss=loginuseremail;
//					
//					 List aa = sessionFactory.getCurrentSession().createSQLQuery("select  EMAIL from loginmaster where USERNAME='"+username+"' and COMPANY='"+getCompForMail+"'").list();
//
//			Object collect = aa.stream().filter(e->e!=null).map(s->s).collect(Collectors.toList());
//			
//			 ArrayList al1ss = new ArrayList();
//			 al1ss = (ArrayList) collect;
//			for (int i = 0; i < al1ss.size(); i++) {
//				
//			}
					///////Approvar Email
//				System.out.println("|ddddddddddddddddddddddddddddddddddddaf"+dd.toString());
					mailIDForTo = UsernameMailForTo;
//					mailIDForCC=dd.toString();
					mailIDForCC=RequesterMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Hold")) {
					
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + usernameofappname + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
						UsernameRoleForTo=ls.getROLE_TYPE();
					}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
//					System.out.println("aaaaaaaaaaaarfwstv ryety"+EngMail);
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					
					
					mailIDForCC = EngMail;
					mailIDForTo = UsernameMailForTo;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By Manager")) {
//					"Approved By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + RaisedByName + "'and COMPANY='" + RaisedByCompany + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
						UsernameRoleForTo=ls.getROLE_TYPE();
					}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME in('"+groupName+"') and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
//						System.out.println("Enng MAil _"+EngMail);
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
//						System.out.println("Enng MAil _after"+EngMail);
					}
					
					mailIDForCC = EngMail;
					mailIDForTo = UsernameMailForTo;
				}else if(TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By Manager"))
				{

//					"Rejected By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String loginmail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:getgrp)
					{
						loginmail=ls.getEMAIL();
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					
					
//					loginuser mail
					mailIDForCC = loginmail;
					
//					/Requester mail
					mailIDForTo = RequesterMail;
				
				}else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By It Compliance")) {
//					"Approved By It Compliance"
					String UsernameMailForTo="";
					System.out.println("insidea appby itcompl "+groupName);
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + RaisedByName + "'and COMPANY='" + RaisedByCompany + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
				
					}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME ='"+groupName+"' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					
					if(EngMail.contains(","))
					{
//						System.out.println("Enng MAil _"+EngMail);
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
//						System.out.println("Enng MAil _after"+EngMail);
					}
					
					mailIDForCC = UsernameMailForTo+","+RequesterMail;
					System.out.println("asssssssssssssssssfgssssssss"+mailIDForCC);
					mailIDForTo = EngMail;
					System.out.println("kmsddsds dsdmail id of grouyp ieng "+EngMail);
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Work in Progress")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) 
				{
//					"Work in Progress"
					String UsernameMailForTo="";
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + RaisedByName + "'and COMPANY='" + RaisedByCompany + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
				
					}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));

					}
					mailIDForCC = EngMail;
				
					mailIDForTo = UsernameMailForTo;
				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By It Compliance")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By Mail Admin")) 
				{
					System.out.println("Rejected By It Compliance");
					String EngMail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By Mail Admin")) {
					System.out.println("Approved By Mail Admin");
					String mailadminmail="";
					String EngMail="";
				
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));

					}
					List<loginmaster> getgp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%Mail Admin%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgp)
					{
						mailadminmail=mailadminmail+ ls.getEMAIL()+",";
					}
					
					if(mailadminmail.contains(","))
					{
						mailadminmail=mailadminmail.substring(0, mailadminmail.lastIndexOf(","));

					}
					
					mailIDForCC = EngMail+","+mailadminmail;
				
					mailIDForTo = RequesterMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected")) {
					System.out.println("Rejeted");
					String getRaisedByMail="";
					String LogedInUserMail="";
					
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + RaisedByName + "'and COMPANY='" + RaisedByCompany + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						getRaisedByMail=ls.getEMAIL();
				
					}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:getgrp)
					{
						LogedInUserMail=ls.getEMAIL();
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					mailIDForCC = LogedInUserMail;
					mailIDForTo = getRaisedByMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Closed")) {
					System.out.println("Closed");
					String getRaisedByMail="";
					String LogedInUserMail="";
					String EngMail="";
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
				
				String hostname = "";
				int port = 587;
				String Senderid = "";
				String pass = "";
				String mailid = "";

				String auth = "";
				String authval = "";
				String starttls="";

				Query query23 = sessionFactory.getCurrentSession()
						.createQuery("from mail_config where COMPANY='" + getCompForMail + "' ");

				List<mail_config> dataList12 = query23.list();
				System.out.println("before user if" + dataList12);
				for (mail_config dataList23 : dataList12) {
					hostname = dataList23.getHOST();
					port = dataList23.getPORT();
					Senderid = dataList23.getSENDERID();
					pass = dataList23.getPASSWRD();
					mailid = dataList23.getE_MAIL();
					auth = dataList23.getAUTHO();
					starttls=dataList23.getSTART_TLS();
					System.out.println("start tls  " + starttls);

					System.out.println("Sender email get----------------" + mailid);
				}
					
				if (auth.equalsIgnoreCase("Yes")) {
					authval = "true";
				} else if (auth.equalsIgnoreCase("No")) {
					authval = "false";
				} else {
					authval = "false";
				}

				final String Senderid1 = Senderid;
				final String pass1 = pass;

				int count = 0;
				Properties props = new Properties();

				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", starttls);
				props.put("mail.smtp.auth", authval);
				props.put("mail.smtp.host", hostname);
				props.put("mail.smtp.port", "" + port);
				props.put("mail.smtp.sendpartial", "true");
				
				System.out.println("all propert set----------------status=" + status);
//					
				final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						// System.out.println("session value============"+session);
						System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
								+ " pass1=" + pass1);
						return new PasswordAuthentication(Senderid1, pass1);
					}
				});
				String title = "";
				String severity="";
				String mailbody = status + " Ticket Alert";
				String mainMSG = "";
				try
				{
					
					System.out.println("Before Projection List ");
					// Session s = getSession();
					// System.out.println("s =" + s);

					List<ADD_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
							.createQuery("from ADD_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

					for (ADD_MAIL_TEMPLATE a1 : dataList1) {
						String st = a1.getSTATUS();
						System.out.println("status from template==" + st);
						System.out.println("status from method==" + status);
						if (st.equals(status)) {
							System.out.println("Inside if block");

							title = a1.getSUBJECT();
							mailbody = a1.getMAILBODY();
							System.out.println("title==" + title);
							System.out.println("mailbody====" + mailbody);

							title = title.replaceAll("!", String.valueOf(id));
//							System.out.println("severity:: " + severity);
							title = title.replaceAll("#", status);
							title = title.replaceAll("@","P5");
							title = title.replace("$", "Information");
							System.out.println("name==" + title);

							System.out.println("mailbody==" + mailbody);

							mailbody = mailbody.replaceAll("!", String.valueOf(id));

							mailbody = mailbody.replaceAll("#", status);
//							mailbody = mailbody.replaceAll("@", priority);

							mailbody = mailbody.replaceAll("~", username);
							mailbody = mailbody.replaceAll("�", enggname);

							System.out.println("mailbody==" + mailbody);
							break;
						} else {
							System.out.println("Inside else block");
							if (status.equalsIgnoreCase("New")) {
								title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority
										;
							}
							
						}

					}
					
					
					if (status.equalsIgnoreCase("Approval For Manager")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Raised Request</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5"+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Re-Opened")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Re-Opened</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5"+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Approved By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
//								+ "NA" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Rejected By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Rejected By Manager message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Approved By It Compliance")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
//								+ "NA" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Hold")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request On Hold</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
//								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
//								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Work in Progress")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Work in Progress</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>WIP By</strong></td> <td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}

					else if (status.equalsIgnoreCase("Rejected By It Compliance")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Resolved"))
					{

						System.out.println("in  Resolved status cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Resolved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Resolved" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ getCompForMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Resolved By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Closed"))
					{

						System.out.println("in  Closed status cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Closed</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Closed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ getCompForMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
							

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Approved By Mail Admin"))
					{

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
//								+ "NA" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					System.out.println("session value==" + session);
					Message message = new MimeMessage(session);

					// System.out.println("MAIL ID FOR CHECKING ::: "+mailid);
					message.setFrom(new InternetAddress(mailid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailIDForTo));
					InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);
					System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
					System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
					System.out.println("FINAL MAIL PARSE: " + parse);
					System.out.println("FINAL MAIL TITLE: " + title);
					message.addRecipients(Message.RecipientType.CC, parse);
					message.setSubject(title);
//					Packet pa=new Packet();
					BodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(mainMSG, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);

					try {
						System.out.println("Thread is calling started.....");
						Thread t = new Thread(new ConstructDemo(url12, message));
						t.join();
						t.start();
						System.out.println("Thread is calling finished.....");
					} catch (Exception e) {
						// TODO: handle exception
					}
					
			} 
				catch (Exception e) {
				e.printStackTrace();
			}
				System.out.println("Email triggerd successfully!!!");
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			System.out.println("Email is not triggerd ");
		}
		
		
	
		
	}

	@Override
	public void EmaiLSmsTriggerdInSoftwareRelease(String ticketID, String TicketStatus) {

		String getCompForMail = "";
		String username = "NA";

		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession sessionForCompany = requestAttributes1.getRequest().getSession();
		getCompForMail = sessionForCompany.getAttribute("companyname").toString();
		username = sessionForCompany.getAttribute("username").toString();
		System.out.println("Company from ticket ssssssssssssssss:: "+TicketStatus);
		String EmailTrigger ="";
		String ticketType="";
		String mailFooter="";
		String tempTicketType="Software Release";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from EFORM_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
//		System.out.println("sdddddddddddsafdafasssssssssss"+"from ADD_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
		List<EFORM_MAIL_TEMPLATE> list = query.list();
		for (EFORM_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		if (EmailTrigger.equals("Yes") && ticketType.equals("Software Release") ) {
			status = TicketStatus;
			id = ticketID;
			System.out.println("Inside EmailTriggersed in service request ");
			System.out.println("ticketID:" + ticketID + " TicketStatus:" + TicketStatus);

			String enggname = "NA";

			String sms_config_URL = "";
			String sms_config_Param = "";
			String url12 = "";
			String department = "NA";
			String company = "NA";
			String branch = "NA";
			
			String url = "";
			String category = "";

			String branchforMail = "";
			String companyforMail = "";
			String departmentforMail = "";
			String suncat1forMail = "";
			String subcat2forMail = "";

			String subject = "";
			String priority = "";
			String mailIDForCC = "";
			String mailIDForTo = "";
			
			String engNameOrGrpName = "NA";
			String engPh = "";
			String tcPh = "";
			String phonenum = "";
			String loginUserPh = "";
			String RaisedByName="";
			String RaisedByCompany="";
			String loginUserMailID = "";
			String loginUserRole = "";
			String PID="";
			String Softwarename="";
			String cost="";
			String rperiod="";
			String RequesterMail="";
			String Request_category="";
			String assetCode="";
			try {
				String usernameofappname="";
				String groupName="";
				Date date = null;
				date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String mysqldate = formatter.format(date);
				List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
						.list();

				for (loginmaster lg : loginMaster1) {

					loginUserMailID = lg.getEMAIL();
					loginUserPh = lg.getPHONE();
					loginUserRole = lg.getROLE_TYPE();
				}
				List<SOFTWARE_RELEASE> lst=sessionFactory.getCurrentSession().createQuery("from SOFTWARE_RELEASE where T_ID='"+ticketID+"'").list();
				for(SOFTWARE_RELEASE l:lst)
				{
					department = l.getT_DEPARTMENT();
					company = l.getT_COMPANY();
					branch = l.getT_BRANCH();
//					usernameofappname=l.getAPPROVAR_NAME();
					groupName=l.getGROUPNAME();
					RaisedByCompany=l.getT_COMPANY();
					RaisedByName=l.getT_REQUESTER();
					 RequesterMail = l.getEMAIL_ID();
//					PID=l.getP_ID();
					Softwarename=l.getS_NAME();
					assetCode=l.getASSET_CODE();
					Request_category=l.getREQUEST_CATEGORY();
				}
				System.out.println("loginUserMailID:" + loginUserMailID);
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approval For Manager")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Re-Opened")) {
					
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					 List list2 = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where USERNAME = '" + usernameofappname + "'and COMPANY='3i Infotech'")
							.list();
					for(Object ls:list2)
					{
						UsernameMailForTo=ls.toString();
						
					}
					//////////////////Requester email///
					mailIDForCC = RequesterMail;
					
					///////Approvar Email
					mailIDForTo = UsernameMailForTo;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Hold") ) {
					
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String EngMail="";
				
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
//					System.out.println("aaaaaaaaaaaarfwstv ryety"+EngMail);
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = RequesterMail;
					mailIDForTo = EngMail;
				
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By Manager")) {
//					"Approved By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String EngMail="";
					 List list2 = sessionFactory.getCurrentSession().createSQLQuery(
								"select EMAIL from loginmaster where USERNAME = '" + usernameofappname + "'and COMPANY='3i Infotech'")
								.list();
						for(Object ls:list2)
						{
							UsernameMailForTo=ls.toString();
							
						}
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME in('"+groupName+"') and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
//						System.out.println("Enng MAil _"+EngMail);
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
//						System.out.println("Enng MAil _after"+EngMail);
					}
					
					mailIDForCC = EngMail;
					mailIDForTo = UsernameMailForTo;
				}else if(TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By Manager"))
				{

//					"Rejected By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String loginmail="";
					
					 List list2 = sessionFactory.getCurrentSession().createSQLQuery(
								"select EMAIL from loginmaster where USERNAME = '" + username + "'and COMPANY='3i Infotech'")
								.list();
						for(Object ls:list2)
						{
							UsernameMailForTo=ls.toString();
						}
					mailIDForCC = loginmail;
					
//					/Requester mail
					mailIDForTo = RequesterMail;
				
				}else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By IT Compliance")) {
//					"Approved By It Compliance"
					String UsernameMailForTo="";
					System.out.println("insidea appby itcompl "+groupName);
					String EngMail="";
					String itcompliaancegroup="";
					List  sss = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where  GROUP_NAME like'%IT Compliance%' and COMPANY='3i Infotech'")
							.list();
					for(Object ls:sss)
					{
						itcompliaancegroup=itcompliaancegroup+ ls.toString()+",";
					}
					System.out.println("sssssssssss d"+itcompliaancegroup.toString());
					
					
					if(itcompliaancegroup.toString().contains(","))
					{
						itcompliaancegroup=itcompliaancegroup.substring(0, itcompliaancegroup.lastIndexOf(","));
//						System.out.println("Enng MAil _after"+EngMail);
					}
					
					List  getgrp = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where  GROUP_NAME like'%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(Object ls:getgrp)
					{
						EngMail=EngMail+ ls.toString()+",";
					}
//					System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa d"+EngMail.toString());
					if(EngMail.toString().contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = itcompliaancegroup+","+RequesterMail;
//					System.out.println("asssssssssssssssssfgssssssss"+mailIDForCC);
					mailIDForTo = EngMail;
					System.out.println("kmsddsds dsdmail id of grouyp ieng "+EngMail);
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Work in Progress")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) {
//					"Work in Progress"
					String UsernameMailForTo="";
					String EngMail="";
		
					List  getgrp = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where  GROUP_NAME like'%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(Object ls:getgrp)
					{
						EngMail=EngMail+ ls.toString()+",";
					}
//					System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa d"+EngMail.toString());
					if(EngMail.toString().contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = EngMail;
				
					mailIDForTo = RequesterMail;
				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By It Compliance")) {
					System.out.println("Rejected By It Compliance");
					String EngMail="";
					
					List  getgrp = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where  GROUP_NAME like'%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(Object ls:getgrp)
					{
						EngMail=EngMail+ ls.toString()+",";
					}
					if(EngMail.toString().contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
							else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Closed")) {
					System.out.println("Closed");
					String getRaisedByMail="";
					String LogedInUserMail="";
					String EngMail="";
					List  getgrp = sessionFactory.getCurrentSession().createSQLQuery(
							"select EMAIL from loginmaster where  GROUP_NAME like'%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(Object ls:getgrp)
					{
						EngMail=EngMail+ ls.toString()+",";
					}
					if(EngMail.toString().contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
				
				String hostname = "";
				int port = 587;
				String Senderid = "";
				String pass = "";
				String mailid = "";

				String auth = "";
				String authval = "";
				String starttls="";

				Query query23 = sessionFactory.getCurrentSession()
						.createQuery("from mail_config where COMPANY='" + getCompForMail + "' ");

				List<mail_config> dataList12 = query23.list();
				System.out.println("before user if" + dataList12);
				for (mail_config dataList23 : dataList12) {
					hostname = dataList23.getHOST();
					port = dataList23.getPORT();
					Senderid = dataList23.getSENDERID();
					pass = dataList23.getPASSWRD();
					mailid = dataList23.getE_MAIL();
					auth = dataList23.getAUTHO();
					starttls=dataList23.getSTART_TLS();
					System.out.println("start tls  " + starttls);

					System.out.println("Sender email get----------------" + mailid);
				}
					
				if (auth.equalsIgnoreCase("Yes")) {
					authval = "true";
				} else if (auth.equalsIgnoreCase("No")) {
					authval = "false";
				} else {
					authval = "false";
				}

				final String Senderid1 = Senderid;
				final String pass1 = pass;

				int count = 0;
				Properties props = new Properties();

				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", starttls);
				props.put("mail.smtp.auth", authval);
				props.put("mail.smtp.host", hostname);
				props.put("mail.smtp.port", "" + port);
				props.put("mail.smtp.sendpartial", "true");
				
				System.out.println("all propert set----------------status=" + status);
//					
				final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						// System.out.println("session value============"+session);
						System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
								+ " pass1=" + pass1);
						return new PasswordAuthentication(Senderid1, pass1);
					}
				});
				String title = "";
				String severity="";
				String mailbody = status + " Ticket Alert";
				String mainMSG = "";
				try
				{
					
					System.out.println("Before Projection List ");
					// Session s = getSession();
					// System.out.println("s =" + s);

					List<EFORM_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

					for (EFORM_MAIL_TEMPLATE a1 : dataList1) {
						String st = a1.getSTATUS();
						System.out.println("status from template==" + st);
						System.out.println("status from method==" + status);
						if (st.equals(status)) {
							System.out.println("Inside if block");

							title = a1.getSUBJECT();
							mailbody = a1.getMAILBODY();
							System.out.println("title==" + title);
							System.out.println("mailbody====" + mailbody);

							title = title.replaceAll("!", String.valueOf(id));
//							System.out.println("severity:: " + severity);
							title = title.replaceAll("#", status);
							title = title.replaceAll("@","P5");
							title = title.replace("$", "Information");
							System.out.println("name==" + title);

							System.out.println("mailbody==" + mailbody);

							mailbody = mailbody.replaceAll("!", String.valueOf(id));

							mailbody = mailbody.replaceAll("#", status);
//							mailbody = mailbody.replaceAll("@", priority);

							mailbody = mailbody.replaceAll("~", username);
							mailbody = mailbody.replaceAll("�", enggname);

							System.out.println("mailbody==" + mailbody);
							break;
						} else {
							System.out.println("Inside else block");
							if (status.equalsIgnoreCase("New")) {
								title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority
										;
							}
							
						}

					}
					
					
					if (status.equalsIgnoreCase("Approval For Manager")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Raised Request</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5"+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Re-Opened")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Re-Opened</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5"+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Approved By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Assigned</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
//								+ "NA" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Rejected By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Rejected By Manager message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Approved By IT Compliance")) {
						//affanmalik
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Category</strong></td><td style='padding:5px;'>"
								+ Request_category + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
//								+ assetCode + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Hold")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request On Hold</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
//								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
//								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Work in Progress")) {
						//affanmalik
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Category</strong></td><td style='padding:5px;'>"
								+ Request_category + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>WIP By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}

					else if (status.equalsIgnoreCase("Rejected By It Compliance")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Resolved"))
					{
						//affanmalik
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Category</strong></td><td style='padding:5px;'>"
								+ Request_category + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
//								+ assetCode + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Resolved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Closed"))
					{
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
//								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request Category</strong></td><td style='padding:5px;'>"
								+ Request_category + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
//								+ assetCode + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed"
								+ " By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
//						System.out.println("app by remote  message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Approved By Mail Admin"))
					{

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
//								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Engineer Name</strong></td> <td style='padding:5px;'>"
//								+ "NA" + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ "P5" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ "Information" + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ cost + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Recovery Period</strong></td><td style='padding:5px;'>"
								+ rperiod + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					System.out.println("session value==" + session);
					Message message = new MimeMessage(session);

					// System.out.println("MAIL ID FOR CHECKING ::: "+mailid);
					message.setFrom(new InternetAddress(mailid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailIDForTo));
					InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);
					System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
					System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
					System.out.println("FINAL MAIL PARSE: " + parse);
					System.out.println("FINAL MAIL TITLE: " + title);
					message.addRecipients(Message.RecipientType.CC, parse);
					message.setSubject(title);
//					Packet pa=new Packet();
					BodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(mainMSG, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);

					try {
						System.out.println("Thread is calling started.....");
						Thread t = new Thread(new ConstructDemo(url12, message));
						t.join();
						t.start();
						System.out.println("Thread is calling finished.....");
					} catch (Exception e) {
						// TODO: handle exception
					}
					
			} 
				catch (Exception e) {
				e.printStackTrace();
			}
				System.out.println("Email triggerd successfully!!!");
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			System.out.println("Email is not triggerd ");
		}
		
	}

	@Override
	public void EmaiLSmsTriggerdInSoftwareTransfer(String ticketID, String TicketStatus) {

		String getCompForMail = "";
		String username = "NA";
		

		ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpSession sessionForCompany = requestAttributes1.getRequest().getSession();
		getCompForMail = sessionForCompany.getAttribute("companyname").toString();
		username = sessionForCompany.getAttribute("username").toString();
		System.out.println("Company from ticket :: "+TicketStatus);
		String EmailTrigger ="";
		String ticketType="";
		String mailFooter="";
		String tempTicketType="Software Transfer";
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from EFORM_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
//		System.out.println("sdddddddddddsafdafasssssssssss"+"from ADD_MAIL_TEMPLATE where STATUS='" + TicketStatus + "' and COMPANY='" + getCompForMail + "' and TICKET_TYPE='"+tempTicketType+"'  ");
		List<EFORM_MAIL_TEMPLATE> list = query.list();
		for (EFORM_MAIL_TEMPLATE mt : list) {
			EmailTrigger = mt.getEMAIL_TRIGGER();
			ticketType=mt.getTICKET_TYPE();
			mailFooter=mt.getMAIL_FOOTER();
		}
		if (EmailTrigger.equals("Yes") && ticketType.equals("Software Transfer") ) {
			status = TicketStatus;
			id = ticketID;
			String enggname = "NA";

			String sms_config_URL = "";
			String sms_config_Param = "";
			String url12 = "";
			String department = "NA";
			String company = "NA";
			String branch = "NA";
			
			String url = "";
			String category = "";

			String branchforMail = "";
			String companyforMail = "";
			String departmentforMail = "";
			String suncat1forMail = "";
			String subcat2forMail = "";

			String subject = "";
			String priority = "";
			String mailIDForCC = "";
			String mailIDForTo = "";
			String ticketUserMailID = "";
			String engNameOrGrpName = "NA";
			String engPh = "";
			String tcPh = "";
			String phonenum = "";
			String loginUserPh = "";
			String RaisedByName="";
			String RaisedByCompany="";
			String loginUserMailID = "";
			String loginUserRole = "";
			String PID="";
			String Softwarename="";
			String severity="";
			String cost="";
			String rperiod="";
			String RequesterMail="";
			String Request_category="";
			String To_emp_Manager="";
			String TO_Employee="";
			String fromasset="";
			String toAsset="";
			try {
				String usernameofappname="";
				String groupName="";
				Date date = null;
				date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String mysqldate = formatter.format(date);
				List<loginmaster> loginMaster1 = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
						.list();

				for (loginmaster lg : loginMaster1) {

					loginUserMailID = lg.getEMAIL();
					loginUserPh = lg.getPHONE();
					loginUserRole = lg.getROLE_TYPE();
				}
				List<SOFTWARE_TRANSFER> lst=sessionFactory.getCurrentSession().createQuery("from SOFTWARE_TRANSFER where T_ID='"+ticketID+"'").list();
				for(SOFTWARE_TRANSFER l:lst)
				{
					department = l.getT_DEPARTMENT();
					company = l.getT_COMPANY();
					branch = l.getT_BRANCH();
					usernameofappname=l.getAPPROVAR_NAME();
					groupName=l.getGROUPNAME();
					RaisedByCompany=l.getT_COMPANY();
					RaisedByName=l.getT_REQUESTER();
					 RequesterMail = l.getEMAIL_ID();
					PID=l.getP_ID();
					Softwarename=l.getS_NAME();
					Request_category=l.getCATEGORY_REQUEST();
					TO_Employee =l.getTO_EMPLOYEE();
					To_emp_Manager= l.getTO_EMP_APPROVAR_NAME();
					fromasset= l.getCURRENT_USER_ASSET();
					toAsset = l.getNEW_ASSET_CODE();
					priority=l.getPRIORITY();
					severity=l.getSEVERITY();
				}
				if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approval For Manager")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Re-Opened")) {
					
					String ManagerMail="";
					String  UsernameRoleForTo="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + usernameofappname + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						ManagerMail=ls.getEMAIL();
					}

					//////////////////Requester email///
					mailIDForCC = RequesterMail;
					
					///////Approvar Email
					mailIDForTo = ManagerMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Hold") ) {
					System.out.println("insidedfffffffffffffffffffff");
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						UsernameMailForTo=ls.getEMAIL();
						UsernameRoleForTo=ls.getROLE_TYPE();
					}

					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
//					System.out.println("aaaaaaaaaaaarfwstv ryety"+EngMail);
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
			
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By Manager")) {
//					"Approved By Manager"
					String loginusernamager="";
					String  UsernameRoleForTo="";
					String touserManagermail="";
					String EngMail="";
					List<loginmaster> loginMaster = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:loginMaster)
					{
						loginusernamager=ls.getEMAIL();
					}
//					String str="";
//			 sessionFactory.getCurrentSession().createSQLQuery("select  EMAIL from loginmaster where USERNAME='"+To_emp_Manager+"' and COMPANY='"+getCompForMail+"'").list().stream().map(e->e).forEach(e-> str= e.toString());
//				System.out.println("sfsdfffffffffffffffffff"+str);
					
					
					List<loginmaster> s = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + To_emp_Manager + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:s)
					{
						touserManagermail=ls.getEMAIL();
					}
					mailIDForCC = loginusernamager+","+RequesterMail;
					mailIDForTo = touserManagermail;
				}else if(TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By Manager"))
				{

//					"Rejected By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String loginmail="";
					String	EngMail="";
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:getgrp)
					{
						loginmail=ls.getEMAIL();
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					
				
//					loginuser mail
					mailIDForCC = loginmail;
					
//					/Requester mail
					mailIDForTo = RequesterMail;
				
				}
				else if(TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By Second Manager"))
				{

//					"Rejected By Manager"
					String UsernameMailForTo="";
					String  UsernameRoleForTo="";
					String loginmail="";
					String EngMail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:getgrp)
					{
						loginmail=ls.getEMAIL();
					}
					List<loginmaster> sss = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like'%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:sss)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));

					}

					mailIDForCC = loginmail;
					mailIDForTo = RequesterMail+","+EngMail;
				}
				else if(TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By Second Manager"))

				{
					String loginmail="";


					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where USERNAME = '" + username + "'and COMPANY='" + getCompForMail + "'")
							.list();
					for(loginmaster ls:getgrp)
					{
						loginmail=ls.getEMAIL();
					}

					mailIDForCC = loginmail;

					mailIDForTo = RequesterMail;
				
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Approved By It Compliance")) {
//					"Approved By It Compliance"
				
					System.out.println("insidea appby itcompl "+groupName);
					String EngMail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME ='"+groupName+"' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					
					mailIDForCC = RequesterMail;
					mailIDForTo = EngMail;
				}
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Work in Progress")||TicketStatus != null && TicketStatus.equalsIgnoreCase("Resolved")) {
//					"Work in Progress"
					String UsernameMailForTo="";
					String EngMail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
						}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));

					}
					mailIDForCC = EngMail;
				
					mailIDForTo = RequesterMail;
				}

				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Rejected By It Compliance")) {
					System.out.println("Rejected By It Compliance");
					String EngMail="";
					
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
							
				else if (TicketStatus != null && TicketStatus.equalsIgnoreCase("Closed")) {
					System.out.println("Closed");
					String getRaisedByMail="";
					String LogedInUserMail="";
					String EngMail="";
					List<loginmaster> getgrp = sessionFactory.getCurrentSession().createQuery(
							"from loginmaster where  GROUP_NAME like '%"+groupName+"%' and COMPANY='3i Infotech'")
							.list();
					for(loginmaster ls:getgrp)
					{
						EngMail=EngMail+ ls.getEMAIL()+",";
//						System.out.println("then EMAIL is "+EngMail);
//						UsernameRoleForToV=ls.getROLE_TYPE();
					}
					
					if(EngMail.contains(","))
					{
						EngMail=EngMail.substring(0, EngMail.lastIndexOf(","));
					}
					
					mailIDForCC = EngMail;
					mailIDForTo = RequesterMail;
				}
				
				String hostname = "";
				int port = 587;
				String Senderid = "";
				String pass = "";
				String mailid = "";

				String auth = "";
				String authval = "";
				String starttls="";

				Query query23 = sessionFactory.getCurrentSession()
						.createQuery("from mail_config where COMPANY='" + getCompForMail + "' ");

				List<mail_config> dataList12 = query23.list();
				System.out.println("before user if" + dataList12);
				for (mail_config dataList23 : dataList12) {
					hostname = dataList23.getHOST();
					port = dataList23.getPORT();
					Senderid = dataList23.getSENDERID();
					pass = dataList23.getPASSWRD();
					mailid = dataList23.getE_MAIL();
					auth = dataList23.getAUTHO();
					starttls=dataList23.getSTART_TLS();
					System.out.println("start tls  " + starttls);

					System.out.println("Sender email get----------------" + mailid);
				}
					
				if (auth.equalsIgnoreCase("Yes")) {
					authval = "true";
				} else if (auth.equalsIgnoreCase("No")) {
					authval = "false";
				} else {
					authval = "false";
				}

				final String Senderid1 = Senderid;
				final String pass1 = pass;

				int count = 0;
				Properties props = new Properties();

				props.put("mail.smtp.ssl.trust", "*");
				props.put("mail.smtp.starttls.enable", starttls);
				props.put("mail.smtp.auth", authval);
				props.put("mail.smtp.host", hostname);
				props.put("mail.smtp.port", "" + port);
				props.put("mail.smtp.sendpartial", "true");
				
				System.out.println("all propert set----------------status=" + status);
//					
				final Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						// System.out.println("session value============"+session);
						System.out.println("In ready class call to auth check----------------Senderid1=" + Senderid1
								+ " pass1=" + pass1);
						return new PasswordAuthentication(Senderid1, pass1);
					}
				});
				String title = "";
			
				String mailbody = status + " Ticket Alert";
				String mainMSG = "";
				try
				{
					
					System.out.println("Before Projection List ");
					// Session s = getSession();
					// System.out.println("s =" + s);

					List<EFORM_MAIL_TEMPLATE> dataList1 = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_MAIL_TEMPLATE").list();
//							query.setParameter("c", cname);

					for (EFORM_MAIL_TEMPLATE a1 : dataList1) {
						String st = a1.getSTATUS();
						System.out.println("status from template==" + st);
						System.out.println("status from method==" + status);
						if (st.equals(status)) {
							System.out.println("Inside if block");

							title = a1.getSUBJECT();
							mailbody = a1.getMAILBODY();
							System.out.println("title==" + title);
							System.out.println("mailbody====" + mailbody);

							title = title.replaceAll("!", String.valueOf(id));
//							System.out.println("severity:: " + severity);
							title = title.replaceAll("#", status);
							title = title.replaceAll("@","P5");
							title = title.replace("$", "Information");
							System.out.println("name==" + title);

							System.out.println("mailbody==" + mailbody);

							mailbody = mailbody.replaceAll("!", String.valueOf(id));

							mailbody = mailbody.replaceAll("#", status);
//							mailbody = mailbody.replaceAll("@", priority);

							mailbody = mailbody.replaceAll("~", username);
							mailbody = mailbody.replaceAll("�", enggname);

							System.out.println("mailbody==" + mailbody);
							break;
						} else {
							System.out.println("Inside else block");
							if (status.equalsIgnoreCase("New")) {
								title = "Ticket Status: New || Ticket ID: " + id + " || Priority : " + priority
										;
							}
							
						}

					}
					
					
					if (status.equalsIgnoreCase("Approval For Manager")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Raised Request</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Re-Opened")) {

						
						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Re-Opened</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"	+ 
								 "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Approved By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority+ "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Rejected By Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Rejected By Manager message======" + mainMSG);
					}
					////////////////////////////////////////
					if (status.equalsIgnoreCase("Approved By Second Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Rejected By Manager message======" + mainMSG);
					}
					if (status.equalsIgnoreCase("Rejected By Second Manager")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Cost</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Rejected By Manager message======" + mainMSG);
					}
					////////////////////////////////////////
					
					if (status.equalsIgnoreCase("Approved By It Compliance")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Approved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
							
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Approved By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Hold")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request On Hold</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Assign To</strong></td> <td style='padding:5px;'>"
								+ "GROUP" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Hold By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}
					else if (status.equalsIgnoreCase("Work in Progress")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Work in Progress</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+ groupName + "</td>" + "</tr>" + "<tr>"
							
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>WIP By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("Closed message======" + mainMSG);
					}

					else if (status.equalsIgnoreCase("Rejected By It Compliance")) {

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Rejected</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ TicketStatus + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ ticketID + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Raised By</strong></td><td style='padding:5px;'>"
								+ RaisedByName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Rejected By</strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"

								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ company + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+mailFooter;
						System.out.println("app by remote  message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Resolved"))
					{

						System.out.println("in  Resolved status cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Resolved</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Resolved" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Group Name</strong></td> <td style='padding:5px;'>"
								+groupName + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+ priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"+
								 "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Resolved By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ getCompForMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					}
					else if(status.equalsIgnoreCase("Closed"))
					{

						System.out.println("in  Closed status cond=----------------");

						mainMSG = "<span style='color:#1f497d; font-weight:100'>Dear Sir/Madam,<br> <br>" + mailbody
								+ "</span><br><br>"
								+ "<h4 style='color:#1f497d; font-weight:100'><strong>Request Details<strong></h4>"
								+ "<table border='1' style='border-collapse:collapse;text-align:left'>  " + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Action</strong></td><td style='padding:5px;'>Request Closed</td>"
								+ "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Status</strong></td> <td style='padding:5px;'>"
								+ "Closed" + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Request ID</strong></td><td style='padding:5px;'>"
								+ id + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Priority</strong></td><td style='padding:5px;'>"
								+priority + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Severity</strong></td><td style='padding:5px;'>"
								+ severity + "<td/>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Project ID</strong></td> <td style='padding:5px;'>"
								+ PID + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Software Name</strong></td><td style='padding:5px;'>"
								+ Softwarename + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>From Asset</strong></td><td style='padding:5px;'>"
								+ fromasset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>To Asset</strong></td><td style='padding:5px;'>"
								+ toAsset + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Transfer Employee</strong></td><td style='padding:5px;'>"
								+ TO_Employee + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Closed By </strong></td><td style='padding:5px;'>"
								+ username + "</td>" + "</tr>" + "<tr>"+
								"<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Company</strong></td><td style='padding:5px;'>"
								+ getCompForMail + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Branch</strong></td><td style='padding:5px;'>"
								+ branch + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Department</strong></td><td style='padding:5px;'>"
								+ department + "</td>" + "</tr>" + "<tr>"
								+ "<td style='padding:5px;background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><strong>Activity Date</strong></td> <td style='padding:5px;'>"
								+ mysqldate + "</td>" + "</tr>"+"</table>"
								+ mailFooter;
						System.out.println("Resolved message======" + mainMSG);
					}
					System.out.println("session value==" + session);
					Message message = new MimeMessage(session);

					// System.out.println("MAIL ID FOR CHECKING ::: "+mailid);
					message.setFrom(new InternetAddress(mailid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailIDForTo));
					InternetAddress[] parse = InternetAddress.parse(mailIDForCC, true);
					System.out.println("FINAL MAIL ID TO LIST: " + mailIDForTo);
					System.out.println("FINAL MAIL ID CC LIST: " + mailIDForCC);
					System.out.println("FINAL MAIL PARSE: " + parse);
					System.out.println("FINAL MAIL TITLE: " + title);
					message.addRecipients(Message.RecipientType.CC, parse);
					message.setSubject(title);
//					Packet pa=new Packet();
					BodyPart messageBodyPart = new MimeBodyPart();	
					messageBodyPart.setContent(mainMSG, "text/html");
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);

					try {
						System.out.println("Thread is calling started.....");
						Thread t = new Thread(new ConstructDemo(url12, message));
						t.join();
						t.start();
						System.out.println("Thread is calling finished.....");
					} catch (Exception e) {
						// TODO: handle exception
					}
					
			} 
				catch (Exception e) {
				e.printStackTrace();
			}
				System.out.println("Email triggerd successfully!!!");
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
		{
			System.out.println("Email is not triggerd ");
		}
		
	}
	
	
	
}
