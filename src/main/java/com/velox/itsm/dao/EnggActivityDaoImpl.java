package com.velox.itsm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.velox.itsm.model.historical_sla;
import com.velox.itsm.model.loginmaster;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.problem_sla;
import com.velox.itsm.model.problem_ticket;
import com.velox.itsm.model.problem_ticket_activity_log;
import com.velox.itsm.model.problem_ticket_assigned;
import com.velox.itsm.model.problem_ticket_resolved;
import com.velox.itsm.model.problem_ticket_tracking;
import com.velox.itsm.model.response_sla;
import com.velox.itsm.model.responseslamaster;
import com.velox.itsm.model.service_request;
import com.velox.itsm.model.service_request_activity_log;
import com.velox.itsm.model.service_request_historical_sla;
import com.velox.itsm.model.service_request_sla;
import com.velox.itsm.model.service_request_tracking;
import com.velox.itsm.model.sla;
import com.velox.itsm.model.ticket;
import com.velox.itsm.model.ticket_activity_log;
import com.velox.itsm.model.ticket_assigned;
import com.velox.itsm.model.ticket_resolved;
import com.velox.itsm.model.ticket_tag_master;
import com.velox.itsm.model.ticket_tracking;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.update_priority_severity;
import com.velox.itsm.model.ChangeManagement.EngineerCrfRequest;;

@Repository("enggActivityDao")
@Transactional
public class EnggActivityDaoImpl extends AbstractDao<Integer, mail_config> implements EnggActivityDao {
	HttpServletRequest request;
	HttpServletResponse response;

	@Autowired
	SessionFactory sessionFactory;
	
//	@Autowired
//	@Qualifier("sessionFactoryCM")
//	SessionFactory sessionFactoryCM;

	@Autowired
	Environment environment;

	@Autowired
	EmailSMSDao Inv;

	@Override
	public JSONArray getAllEngDetails(String LoginUser) {
		//System.out.println("Inside EngActivityDaoImpl getAllUserDetails method " + LoginUser);
		JSONArray array = new JSONArray();
		JSONObject jobj = null;
		
		String loginUserCompany = "";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("loginUserCompany****" + loginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			
			List<loginmaster> dataList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME = '" + LoginUser + "' and COMPANY = '" + loginUserCompany + "'").list();
			for (loginmaster sourceDrive : dataList) {
				jobj=new JSONObject();
				jobj.put("FULLNAME",sourceDrive.getFULL_NAME());
				jobj.put("USERNAME",sourceDrive.getUSERNAME());
				jobj.put("COMPANY",sourceDrive.getCOMPANY());
				jobj.put("BRANCH",sourceDrive.getBRANCH());
				jobj.put("DEPARTMENT",sourceDrive.getDEPARTMENT());
				jobj.put("SUB_DEPARTMENT",sourceDrive.getSUB_DEPARTMENT());
				jobj.put("LOCATION",sourceDrive.getLOCATION());
				jobj.put("EMAIL",sourceDrive.getEMAIL());
				jobj.put("PHONE",sourceDrive.getPHONE());
				jobj.put("VIP_LOGIN",sourceDrive.getVIP_LOGIN());
				
				array.put(jobj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}

	@Override
	public JSONArray getEnggDashboardData(String loginuser) {
		//System.out.println("Inside TPActivityDaoImpl getTPDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct STATUS,count(STATUS) from ticket t left join  ticket_assigned ta  ON t.T_ID=ta.T_ID where  (t.T_REQUESTER='"+loginuser+"'  and t.T_COMPANY='"+loginUserCompany+"') or (ENGINEER_NAME='"+ loginuser +"' and ENGINEER_COMPANY='"+loginUserCompany+"') or (ENGINEER_GROUP IN('"+ enggGroupList +"')) group by STATUS ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

				if (listData[0].toString().equals("Closed")) {
					record.put("color", "#5c5e5c");
				}
				if (listData[0].toString().equals("New")) {
					record.put("color", "#cf391f");
				}
				if (listData[0].toString().equals("Assigned")) {
					record.put("color", "#cf681f");
				}
				if (listData[0].toString().equals("Hold")) {
					record.put("color", "#2129cc");
				}
				if (listData[0].toString().equals("Re-Assigned")) {
					record.put("color", "#703912");
				}
				if (listData[0].toString().equals("Resolved")) {
					record.put("color", "#1d6b32");
				}

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}

	@Override
	public String insertEngRaiseTicket(String name1, String datepicker5, String phone, String emailid, String compname,
			String site, String category, String subcat1, String requestmode, String department, String subject,
			String description, String priority, String severity, MultipartFile empPic,String subDepartment,String location,String subcat2,String username,String vipuser, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,String  asset_sub_category ,String  asset_Ipaddress) {
		int id = 0;
		String status = "";
		String ticketTag="";
		String NewTicketID="";
		String fullname = "";
		//String emailid = "";
		//String phone = "";
		String LoginUser="";
		String loginUserCompany="";
		String fullnameOfLogin="";
		//System.out.println("EMPIC FILE NAME IN DAO_IMPL: " + empPic.getOriginalFilename());
		//System.out.println("EMPIC FILE SIZE IN DAO_IMPL: " + empPic.getSize());
		//System.out.println("EMPIC FILE SIZE IN DAO_IMPL: " + empPic.getSize());
		
		String loginRoleType="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginRoleType = session.getAttribute("role").toString();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			fullnameOfLogin= session.getAttribute("fullname").toString();
			//System.out.println("loginRoleType****" + loginRoleType);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {

			Integer srno1 = (Integer) sessionFactory.getCurrentSession().createCriteria(ticket.class)
					.setProjection(Projections.max("T_SRNO")).uniqueResult();
			//System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//System.out.println("IN ELSE SRNO IS: " + id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e);
		}

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		   LocalDateTime now = LocalDateTime.now();
		   //System.out.println(localdate.format(now));
		   String localDateNow=localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+id;
		//System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));


		String ext = "";
		String updatedFileName = null;
		try {

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//System.out.println("Directory is created!");
						} else {
							//System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//System.out.println("directory create exception" + e);
				}
				
				String fileName = empPic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
//				String pathOfFile = uploadedFile.getPath();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				
				//-------------------------------
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
//				uploadedFile.createNewFile();
//				FileOutputStream fos = new FileOutputStream(uploadedFile);
//				fos.write(empPic.getBytes());
//				fos.close();
//				//System.out.println("uploadedFile::::" + uploadedFile);
//				String fileName = empPic.getOriginalFilename();
//				//System.out.println("fileName::::" + fileName);
//				ext = FilenameUtils.getExtension(fileName);
//				//System.out.println("file_extension::::" + ext);
//				// File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//--------------------------------
				//System.out.println("destFile........" + destFile);
				// //System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//System.out.println("UPDATED FILE NAME: " + updatedFileName);

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}

			

			Date date2 = null;
			date2 = new Date();
			String timeFormat = "HH:mm:ss";
			String dateFormate = "dd-MM-yyyy";
			SimpleDateFormat sdf = null;
			SimpleDateFormat sdf2 = null;
			sdf = new SimpleDateFormat(timeFormat);
			sdf2 = new SimpleDateFormat(dateFormate);

			String cdate = sdf2.format(date2);
			String ctime = sdf.format(date2);

			String mysqldate = "";

			String tppname = null;
			String tppphn = null;
			String tppmail = null;
			String tppuname = null;
			String StrTID = "";

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);

			try {

				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

				mysqldate = formatter.format(date);
				//System.out.println("Date!!!!@@@@###$$$$" + formatter.format(date));

				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery("from ticket_tag_master where COMPANY='"+compname+"' and DEPARTMENT='"+department+"'").list();
				for (ticket_tag_master sourceDrive : tagList) {
					ticketTag=sourceDrive.getTICKET_TAG();
				}
				//System.out.println("TICKET TAG FOUND: "+ticketTag);
				NewTicketID=ticketTag+"INC"+id;
				
				ticket tickettable1 = new ticket();

				tickettable1.setT_SRNO(id);
				tickettable1.setT_ID(NewTicketID);
				tickettable1.setT_DATE(currenttime);
				tickettable1.setT_REQUESTER(username);
				tickettable1.setT_REQUESTER_FULLNAME(fullnameOfLogin);
				tickettable1.setT_MAIL(emailid);
				tickettable1.setT_PHONE(phone);
				tickettable1.setT_COMPANY(compname);
				tickettable1.setT_BRANCH(site);
				tickettable1.setT_CATEGORY(category);
				tickettable1.setT_SUBCAT1(subcat1);
				tickettable1.setT_SUBCAT2(subcat2);
				tickettable1.setT_SUBJECT(subject);
				tickettable1.setT_DESC(description);
				tickettable1.setSTATUS("New");
				tickettable1.setPRIORITY(priority);
				tickettable1.setSEVERITY(severity);
				tickettable1.setT_RAISE_TIME(currenttime);
              tickettable1.setREQUEST_MODE(requestmode);
              tickettable1.setT_DEPARTMENT(department);
              tickettable1.setVIP_TICKET(vipuser);
              tickettable1.setRAISED_BY_COMPANY(compname);
              tickettable1.setRAISED_BY_USERNAME(username);
              tickettable1.setRAISED_BY_FULLNAME(fullnameOfLogin);
              tickettable1.setASSETCHECK(assetCheck);
				System.out.println("asset name"+assetName);
				if (assetName == null||assetName.equals("")) {
					tickettable1.setASSET_NAME("NA");
					tickettable1.setASSET_IPADDRESS("NA");
					tickettable1.setASSET_SUBCATEGORY("NA");
				} else {
					tickettable1.setASSET_IPADDRESS(asset_Ipaddress);
					tickettable1.setASSET_SUBCATEGORY(asset_sub_category);
					tickettable1.setASSET_NAME(assetName);
				}

				if (assetStatus == null||assetStatus.equals("")) {
					tickettable1.setASSET_STATUS("NA");

				} else {

					tickettable1.setASSET_STATUS(assetStatus);
				}
				if (assetTag == null||assetTag.equals("")) {
					tickettable1.setASSET_TAG("NA");

				} else {

					tickettable1.setASSET_TAG(assetTag);
				}
				if (assetCategory == null||assetCategory.equals("")) {
					tickettable1.setCATEGORY("NA");

				} else {

					tickettable1.setCATEGORY(assetCategory);
				}
              if (updatedFileName == null) {
					tickettable1.setT_ATTACH_NAME("No File Available");
              } else {
            	  tickettable1.setT_ATTACH_NAME(updatedFileName);
              }
				sessionFactory.getCurrentSession().persist(tickettable1);

				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					//System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'").list();
				for(loginmaster lmc:lm)
				{
					fullname=lmc.getFULL_NAME();
				
				}
				
				ticket_activity_log ticketActivityLog = new ticket_activity_log();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(NewTicketID);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setSTATUS("New");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(username);
				ticketActivityLog.setT_SUBJECT(subject);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(description);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setT_COMPANY(compname);
				ticketActivityLog.setT_EMAIL(emailid);
				
				ticketActivityLog.setT_CONTACT_NO(phone);
				ticketActivityLog.setT_FULLNAME(fullname);
				
								
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
				
				
				////////////////////// INSERT IN TICKET TRACKING /////////////
				
				
				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_tracking.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					//System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						//System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						//System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}

				String msg = null;
//				msg = "Ticket ID <b> " + id + " </b> is <b> Raised</b> by " + name1 + " on " + currenttime;
//				msg = "Ticket ID " + id + " is Raised by " + name1 + " on " + currenttime;
				String FullName=getLoginMasterData();
				msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>New</td></tr>"
						+ "<tr><td>Raised By:</td><td>"+username+"["+FullName+"]</td></tr>";
				
				
				ticket_tracking tickettrack = new ticket_tracking();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(NewTicketID);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(username);
				tickettrack.setACTIVITY_NAME_COMPANY(compname);
				tickettrack.setCATEGORY(category);
				tickettrack.setSUBCATEGORY1(subcat1);
				tickettrack.setSUBCATEGORY2(subcat2);
				tickettrack.setSUBJECT(subject);
				tickettrack.setSTATUS("New");
				tickettrack.setPRIORITY(priority);
				tickettrack.setSEVERITY(severity);
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(username);
				tickettrack.setTICKET_RAISED_NAME_COMPANY(compname);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				
				
				if (updatedFileName == null) {
					tickettrack.setATTACHMENT_NAME("No File Available");
				} else {
					tickettrack.setATTACHMENT_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(tickettrack);
				status = "success";
				String st = "Raise";

				description = phone + "," + emailid;
			//	Inv.RaiseNCloseEmailSMS(id, username, "Raise", site, category, subject, description, priority, phone,
					//	emailid);

			} catch (Exception e1) {
				e1.printStackTrace();
				//System.out.println("Exception e1****" + e1);
			}
			
			int srno=0;
			try {
				String elapsedTime="";
				String TargetTime="";
				Criteria response=sessionFactory.getCurrentSession().createCriteria(response_sla.class).setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) response.uniqueResult();

				//System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					srno = srno1.intValue();
					srno = srno + 1;
					//System.out.println("IN IF SNO IS: " + srno);
				} else {
					srno = 1;
					//System.out.println("IN ELSE SNO IS: " + srno);
				}
				
				List<responseslamaster> list=sessionFactory.getCurrentSession().createQuery("from responseslamaster where COMPANY='"+compname+"' and PRIORITY_NAME='"+priority+"' and SEVERITY_NAME='"+severity+"'").list();
				
				for(responseslamaster sl:list)
				{
					elapsedTime=sl.getSLA_TARGET_ELAPSED_TIME();
					TargetTime=sl.getRESPONSE_SLA_TARGET_DURATION();
				}

				
				response_sla rsla=new response_sla();
				
				rsla.setSR_NO(srno);
				rsla.setTICKET_ID(NewTicketID);
				rsla.setTICKET_STATUS("New");
				rsla.setPRIORITY(priority);
				rsla.setSEVERITY(severity);
				rsla.setSTART_DATE(currenttime);
				rsla.setELAPSED_TIME("NA");
				if(elapsedTime.isEmpty())
				{
					rsla.setRESPONSE_SLA_ELAPSED_TIME("NA");
				}else
				{
					rsla.setRESPONSE_SLA_ELAPSED_TIME(elapsedTime);
				}
				if(TargetTime.isEmpty())
				{
					rsla.setRESPONSE_SLA_TARGET("NA");
				}
				else
				{
					rsla.setRESPONSE_SLA_TARGET(TargetTime);
				}
				
				
				rsla.setRESPONSE_SLA_STATUS("NA");
				rsla.setSTOP_DATE("NA");
				rsla.setRESPONSE_SLA_DURATION("NA");
				
				
				
				sessionFactory.getCurrentSession().persist(rsla);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
//////////////////////SLAA INSERT START///////////////////
			Query insernew=sessionFactory.getCurrentSession().createQuery("from sla where TICKET_ID='"+NewTicketID+"' ");
			List<sla> listOfTicket=insernew.list();
			if(listOfTicket.isEmpty())
			{
				sla insert=new sla();
				
				insert.setTICKET_ID(NewTicketID);
				insert.setTICKET_STATUS("New");
				insert.setPRIORITY(priority);
				insert.setSEVERITY(severity);
				insert.setSTART_DATE(currenttime);
				insert.setSTOP_DATE("NA");
				insert.setSTART_END_TIME("NA");
				insert.setELAPSED_TIME("NA");
				insert.setHOLD_START_DATE("NA");
				insert.setHOLD_END_DATE("NA");
				insert.setHOLD_ELAPSED_TIME("NA");
				insert.setHOLD_DURATION("NA");
				insert.setSLA_STATUS("NA");
				insert.setSLA_TARGET("NA");
				insert.setSLA_TIME("NA");
				insert.setActual_Working_Time("NA");
				
				sessionFactory.getCurrentSession().save(insert);
			}
	
	
	////////////////////// SLAA INSERT STOP///////////////////
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
			//System.out.println("Exception e1****" + e1);
		}

		
		
		try {
			if(status.equals("success"))
			Inv.EmailSMSTriggered(NewTicketID, "Raise");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status + "," + NewTicketID;

	}

	@Override
	public JSONArray getEngTicketID(String details) {

		//System.out.println("Inside EngActivityDaoImpl getEngTicketID method");

		String LoginUser = null;
		String groupName="NA";
		String updateGroupName="NA";
		String userCompany="";
		String LoginScope="";	
		int days = 0;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			userCompany=session.getAttribute("companyname").toString();
			LoginScope = session.getAttribute("loginscope").toString();

			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		String db_cname = null;
		JSONArray array = null;

		JSONArray array1 = null;
		String DBType = environment.getRequiredProperty("jdbc.url");

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);
			
			
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME AND COMPANY=:COMPANY");
			q1.setParameter("USERNAME", LoginUser);
			q1.setParameter("COMPANY", userCompany);
			
			loginMaster=q1.list();
			
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
			
			
			
			
			
			//System.out.println("groupName****" + groupName);
			updateGroupName=groupName.replaceAll(",", "','");

			List<Object[]> dataList = null;

			if (DBType.contains("oracle")) {
				//System.out.println("**************Oracle QUERY*********************");
				dataList = sessionFactory.getCurrentSession()
						.createSQLQuery(
								"Select * from(select T_ID,T_REQUESTER from TICKET " + "WHERE T_REQUESTER='" + LoginUser
										+ "' UNION select T_ID,ENGINEER_NAME from TICKET_ASSIGNED WHERE ENGINEER_NAME='"
										+ LoginUser + "')" + " order by  STR_TO_DATE(T_DATE ,'%d-%m-%Y %H:%i:%s') desc")
						.list();
			} else if (DBType.contains("mysql")) {
				//System.out.println("**************MySQL QUERY*********************");
//				dataList = sessionFactory.getCurrentSession()
//						.createSQLQuery("select tt.T_ID, tt.T_REQUESTER , tt.T_DATE ,tt.T_COMPANY as T_COMPANY , tt.T_BRANCH as T_BRANCH ,tt.T_DEPARTMENT as T_DEPARTMENT from ticket AS  tt    left JOIN ticket_assigned ta ON ta.T_ID=tt.T_ID  WHERE ((tt.T_REQUESTER='"+LoginUser+"' AND tt.T_COMPANY='"+userCompany+"') OR((ta.ENGINEER_NAME='"+LoginUser+"' AND ta.ENGINEER_COMPANY='"+userCompany+"')  	OR(ta.ENGINEER_GROUP in ('"+updateGroupName+"')) )AND ("+LoginScope+") ) ORDER BY STR_TO_DATE(tt.T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') desc ").list();
//			
//				dataList = sessionFactory.getCurrentSession()
//						.createSQLQuery("SELECT * FROM (SELECT  tt.T_ID AS T_ID,  tt.T_REQUESTER AS T_REQUESTER,tt.T_DATE AS T_DATE,  tt.T_COMPANY as T_COMPANY , tt.T_BRANCH as T_BRANCH ,  tt.T_DEPARTMENT as T_DEPARTMENT , ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,  ta.ENGINEER_GROUP AS ENGINEER_GROUP,  tt.T_RAISE_TIME AS T_RAISE_TIME FROM    ticket AS  tt    left JOIN   ticket_assigned ta   ON ta.T_ID=tt.T_ID    ) main WHERE ( ( T_REQUESTER='"+LoginUser+"'   AND T_COMPANY='"+userCompany+"' )   OR(((  ENGINEER_NAME='"+LoginUser+"'  AND ENGINEER_COMPANY='"+userCompany+"' )  OR (ENGINEER_GROUP IN ('"+updateGroupName+"'))   )  AND ("+LoginScope+") )  	) ORDER BY STR_TO_DATE(T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') desc ").list();
			
					if(!details.equals("all")) {
					
					if(details.equals("lastmonthFinal")) {
						days = 30;
					}else if(details.equals("lastthreemonth")) {
						days = 90;
					}else if(details.equals("lastsixmonth")) {
						days = 180;
					}
					System.out.println("querygfbvfrg");																																																																																								
					dataList = sessionFactory.getCurrentSession()
							.createSQLQuery("SELECT * FROM (SELECT  tt.T_ID AS T_ID,  tt.T_REQUESTER AS T_REQUESTER,tt.T_DATE AS T_DATE,  tt.T_COMPANY as T_COMPANY, tt.T_BRANCH as T_BRANCH, tt.T_DEPARTMENT as T_DEPARTMENT, ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,ta.ENGINEER_GROUP AS ENGINEER_GROUP,  tt.T_RAISE_TIME AS T_RAISE_TIME FROM    ticket AS  tt    left JOIN   ticket_assigned ta   ON ta.T_ID=tt.T_ID ) main WHERE  ( ( T_REQUESTER='"+LoginUser+"'   AND T_COMPANY='"+userCompany+"' )   OR(((  ENGINEER_NAME='"+LoginUser+"'  AND ENGINEER_COMPANY='"+userCompany+"' )  OR (ENGINEER_GROUP IN ('"+updateGroupName+"'))   )  AND ("+LoginScope+") ) )AND STR_TO_DATE(T_RAISE_TIME,'%d-%m-%Y %H:%i:%s')  >= NOW() - INTERVAL "+days+" DAY ORDER BY STR_TO_DATE(T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') desc ").list();
				}else {
															 
//					datalist = sessionFactory.getCurrentSession().createSQLQuery("select T_ID, T_REQUESTER from ticket where T_REQUESTER='" + LoginUser + "' and T_COMPANY='" + loginUserCompany + "' order by STR_TO_DATE(T_RAISE_TIME,'%d-%m-%Y %H:%i:%s') DESC").list();				
					
					dataList = sessionFactory.getCurrentSession()
							.createSQLQuery("SELECT * FROM (SELECT  tt.T_ID AS T_ID,  tt.T_REQUESTER AS T_REQUESTER,tt.T_DATE AS T_DATE,  tt.T_COMPANY as T_COMPANY , tt.T_BRANCH as T_BRANCH ,  tt.T_DEPARTMENT as T_DEPARTMENT , ta.ENGINEER_NAME AS ENGINEER_NAME,ta.ENGINEER_COMPANY AS ENGINEER_COMPANY,  ta.ENGINEER_GROUP AS ENGINEER_GROUP,  tt.T_RAISE_TIME AS T_RAISE_TIME FROM    ticket AS  tt    left JOIN   ticket_assigned ta   ON ta.T_ID=tt.T_ID    ) main WHERE ( ( T_REQUESTER='"+LoginUser+"'   AND T_COMPANY='"+userCompany+"' )   OR(((  ENGINEER_NAME='"+LoginUser+"'  AND ENGINEER_COMPANY='"+userCompany+"' )  OR (ENGINEER_GROUP IN ('"+updateGroupName+"'))   )  AND ("+LoginScope+") )  ) ORDER BY STR_TO_DATE(T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') desc ").list();	
				}
				
				//select tt.T_ID, tt.T_REQUESTER , tt.T_DATE  from ticket AS  tt    left JOIN ticket_assigned ta ON ta.T_ID=tt.T_ID  WHERE (tt.T_REQUESTER='"+LoginUser+"' AND tt.T_COMPANY='"+userCompany+"') OR ((ta.ENGINEER_NAME='"LoginUser"' AND ta.ENGINEER_COMPANY='"+userCompany+"') 	OR(ta.ENGINEER_GROUP in ('"+groupName+"'))  AND ta.T_USER_NAME<>'"+LoginUser+"' AND tt.T_COMPANY<>'"+userCompany+"' ORDER BY STR_TO_DATE(tt.T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') desc)) 
				
			}

			array1 = new JSONArray();
			for (Object[] sourceDrive : dataList) {
				array = new JSONArray();
				array.put(sourceDrive[0]);
				array1.put(array);
//				//System.out.println("db_cname: " + array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray getEngTicketTracking(String ticketid) {
		//System.out.println("Inside EnggActivityDaoImpl getEngTicketTracking method");
		JSONArray array1 = null;

		try {
			List<ticket> dataList = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+ticketid+"'").list();
			array1 = new JSONArray();
			for (ticket sourceDrive : dataList) {
				
				String department="";
				String sub_department="";
				String location="";
				List<loginmaster> loginDataList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME ='"+sourceDrive.getT_REQUESTER()+"' and COMPANY='"+sourceDrive.getT_COMPANY()+"'").list();
				for (loginmaster loginDrive : loginDataList) {
					department=loginDrive.getDEPARTMENT();
					sub_department=loginDrive.getSUB_DEPARTMENT();
					location=loginDrive.getLOCATION();
				}
				
				JSONObject arrayobj = new JSONObject();
				arrayobj.put("T_ID", sourceDrive.getT_ID());
				arrayobj.put("T_DATE", sourceDrive.getT_RAISE_TIME());
				arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
				arrayobj.put("T_MAIL", sourceDrive.getT_MAIL());
				arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
				arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);
				arrayobj.put("T_CATEGORY", sourceDrive.getT_CATEGORY());
				arrayobj.put("T_SUBCAT1", sourceDrive.getT_SUBCAT1());
				arrayobj.put("T_SUBCAT2", sourceDrive.getT_SUBCAT2());
				arrayobj.put("T_SUBJECT", sourceDrive.getT_SUBJECT());
				arrayobj.put("T_DESC", sourceDrive.getT_DESC());
				arrayobj.put("T_ATTACH1_NAME", sourceDrive.getT_ATTACH_NAME());
				arrayobj.put("T_ATTACH2_NAME", sourceDrive.getCLOSE_NOTES());
				arrayobj.put("STATUS", sourceDrive.getSTATUS());
				arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
				arrayobj.put("T_RAISE_TIME", sourceDrive.getT_RAISE_TIME());
				array1.put(arrayobj);
				
				Query queryticketTracking = sessionFactory.getCurrentSession().createQuery("from ticket_tracking where T_ID=:T_ID order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
				queryticketTracking.setParameter("T_ID", ticketid);
				List<ticket_tracking> ticketTracking = queryticketTracking.list();
				JSONArray array2 = new JSONArray();
				for (ticket_tracking sourceDrive1 : ticketTracking) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
					arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
					array2.put(arrayobjtemp);
				}
				arrayobj.put("STATUS_LOG", array2);
			}
			//System.out.println("db_cname: " + array1);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	
	}

	@Override
	public JSONArray getEngTicketTrackingMessage(int ticketid) {

		//System.out.println("Inside getEngTicketTrackingMessage method");
		String db_cname = null;
		JSONArray array = null;

		JSONArray array1 = null;
//		String db_username = null
//		String db_usertype = null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);

			List<ticket_tracking> dataList = sessionFactory.getCurrentSession()
					.createQuery("from ticket_tracking where T_ID=" + ticketid + " order by ACTIVITY_DATE asc").list();
			array1 = new JSONArray();
			for (ticket_tracking sourceDrive : dataList) {

				JSONObject arrayobj = new JSONObject();

				arrayobj.put("MESSAGE", sourceDrive.getMESSAGE());
				arrayobj.put("ATTACHMENT", sourceDrive.getATTACHMENT_NAME());

				array1.put(arrayobj);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}

	@Override
	public JSONArray getEngTicketList() {

		//System.out.println("Inside getEngTicketList method");

		String LoginUser = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;

		try {
			List<Object[]> dataList = sessionFactory.getCurrentSession().createQuery(
					"select T_ID, STATUS, T_SUBJECT, T_CATEGORY, T_SUBCAT1, PRIORITY, T_REQUESTER, T_COMPANY, T_BRANCH, T_RAISE_TIME from ticket where T_REQUESTER='" + LoginUser + "' order by T_RAISE_TIME desc").list();
			array1 = new JSONArray();
			for (Object[] sourceDrive : dataList) {
				srno = srno + 1;
				array = new JSONArray();

				array.put("<button class='btn btn-sm btn-info' id='viewTicket'  name='Doem' onclick='viewTicket(\""
						+ sourceDrive[0] + "\" )'><i class='fa fa-eye'></i></button>");
				array.put(sourceDrive[0]);
				array.put(sourceDrive[1]);
				array.put(sourceDrive[2]);
				array.put(sourceDrive[3]);
				array.put(sourceDrive[4]);
				array.put(sourceDrive[5]);
				array.put(sourceDrive[6]);
				array.put(sourceDrive[7]);
				array.put(sourceDrive[8]);
				array.put(sourceDrive[9]);
				array1.put(array);
			}
			//System.out.println("ARRAY OUTPUT: " + array1);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray gatherEngTicketDetails(String ticketid) {
		
		//System.out.println("Inside EnggActivityDaoImpl gatherEngTicketDetails method");
		JSONArray array1 = null;
		String A_ENGINEER_NAME = "";
		String T_STATUS = "";
		String SOLUTION = "";
		String RESOLVED_DATE = "";
		String CLOSEDBY = "";
		String CLOSED_DATE = "";
		String ENGINEER_NAME = "";
		String ENGINEER_ASSIGN_DATE = "";
		String ENGINEER_ASSIGN_STATUS = "";
		String TP_HOLD_NOTES = "";

		try {
			List<ticket> ticketList = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID ='"+ticketid+"'").list();

			Query query1 = sessionFactory.getCurrentSession().createQuery("from ticket_resolved where T_ID ='"+ticketid+"'");

			Query query2 = sessionFactory.getCurrentSession()
					.createQuery("from ticket_assigned where T_ID ='"+ticketid+"'");

			array1 = new JSONArray();

			for (ticket ticketDrive : ticketList) {

				JSONObject arrayobj = new JSONObject();

				ticket_resolved TRdata = (ticket_resolved) query1.uniqueResult();
				if (TRdata != null) {
					
					//System.out.println("TICKET RESOLVED DATA FOUND");

					A_ENGINEER_NAME = TRdata.getA_ENGINEER_NAME();
					T_STATUS = TRdata.getT_STATUS();
					SOLUTION = TRdata.getSOLUTION();
					RESOLVED_DATE = TRdata.getRESOLVED_DATE();
					CLOSEDBY = TRdata.getCLOSEDBY();
					CLOSED_DATE = TRdata.getCLOSED_DATE();

				} else {
					A_ENGINEER_NAME = "NA";
					T_STATUS = "NA";
					SOLUTION = "NA";
					RESOLVED_DATE = "NA";
					CLOSEDBY = "NA";
					CLOSED_DATE = "NA";
				}

				ticket_assigned TAdata = (ticket_assigned) query2.uniqueResult();
				if (TAdata != null) {
//					 for (ticket_assigned T_AssignedDrive : ticketassignedList) {
					//System.out.println("TICKET ASSIGNED DATA FOUND");
					ENGINEER_NAME = TAdata.getENGINEER_NAME();
					ENGINEER_ASSIGN_DATE = TAdata.getT_ASSIGN_DATE();
					ENGINEER_ASSIGN_STATUS = TAdata.getT_STATUS();
					TP_HOLD_NOTES = TAdata.getTP_HOLD_NOTES();
//					 } 
				} else {
					ENGINEER_NAME = "NA";
					ENGINEER_ASSIGN_DATE = "NA";
					ENGINEER_ASSIGN_STATUS = "NA";

				}

				///////////////// GET ADDITIONAL DATA OF REQUESTER //////////////
				String department="";
				String sub_department="";
				String location="";
				List<loginmaster> loginDataList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME ='"+ticketDrive.getT_REQUESTER()+"'").list();
				for (loginmaster loginDrive : loginDataList) {
					department=loginDrive.getDEPARTMENT();
					sub_department=loginDrive.getSUB_DEPARTMENT();
					location=loginDrive.getLOCATION();
				}

				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);
				arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
				arrayobj.put("T_MAIL", ticketDrive.getT_MAIL());
				arrayobj.put("T_CATEGORY", ticketDrive.getT_CATEGORY());
				arrayobj.put("T_SUBCAT1", ticketDrive.getT_SUBCAT1());
				arrayobj.put("T_SUBCAT2", ticketDrive.getT_SUBCAT2());
				arrayobj.put("T_SUBJECT", ticketDrive.getT_SUBJECT());
				arrayobj.put("T_DATE", ticketDrive.getT_RAISE_TIME());
				arrayobj.put("STATUS", ticketDrive.getSTATUS());
				arrayobj.put("T_ID", ticketDrive.getT_ID());
				arrayobj.put("T_DESC", ticketDrive.getT_DESC());
				arrayobj.put("PRIORITY", ticketDrive.getPRIORITY());
				arrayobj.put("SEVERITY", ticketDrive.getSEVERITY());
				arrayobj.put("ASSETCHECK", ticketDrive.getASSETCHECK());
				arrayobj.put("ASSETNAME", ticketDrive.getASSET_NAME());		
				arrayobj.put("ASSETSTATUS", ticketDrive.getASSET_STATUS());
				arrayobj.put("ASSETCATEGORY", ticketDrive.getCATEGORY());
				arrayobj.put("ASSETTAG", ticketDrive.getASSET_TAG());
				arrayobj.put("ASSETSUBCATEGORY", ticketDrive.getASSET_SUBCATEGORY());
				arrayobj.put("ASSET_IPADDRESS", ticketDrive.getASSET_IPADDRESS());
				
				
				String AttachName=ticketDrive.getT_ATTACH_NAME();
				//System.out.println("ATTACH NAME: "+ AttachName);
				try {
					if(AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("") ) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						//System.out.println("Null object found");
					}else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getT_ATTACH_NAME());
						//System.out.println("Object found");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println("IN CATCH BLOCK");
					arrayobj.put("T_ATTACH1_NAME", "No File Available");
					e.printStackTrace();
				}
				
				arrayobj.put("T_RAISE_TIME", ticketDrive.getT_RAISE_TIME());
				arrayobj.put("CLOSE_NOTES", ticketDrive.getCLOSE_NOTES());
				arrayobj.put("T_CLOSEBY", ticketDrive.getT_CLOSEBY());
				arrayobj.put("T_CLOSEDATE", ticketDrive.getT_CLOSEDATE());
				arrayobj.put("REQUEST_MODE", ticketDrive.getREQUEST_MODE());
				
				arrayobj.put("A_ENGINEER_NAME", A_ENGINEER_NAME);
				arrayobj.put("T_STATUS", T_STATUS);
				arrayobj.put("SOLUTION", SOLUTION);
				arrayobj.put("RESOLVED_DATE", RESOLVED_DATE);
				arrayobj.put("CLOSEDBY", CLOSEDBY);
				arrayobj.put("CLOSED_DATE", CLOSED_DATE);
				
				arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
				arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
				arrayobj.put("ENGINEER_ASSIGN_STATUS", ENGINEER_ASSIGN_STATUS);
				arrayobj.put("TP_HOLD_NOTES", TP_HOLD_NOTES);

				array1.put(arrayobj);
			}
			//System.out.println("db_cname: " + array1);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
		
		
		
	}

	public JSONArray getResolvedEngTicketList() {

		//System.out.println("Inside EngActivityDaoImpl getResolvedEngTicketList method");

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
			//System.out.println("loginUserCompany****" + loginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		JSONArray array = null;
		JSONArray array1 = null;

		try {
			
//	
//		Query query = sessionFactory.getCurrentSession().createQuery("from ticket_resolved R join R.ticket T AND T.STATUS= R.T_STATUS where R.T_STATUS='Resolved' AND R.T_USER_NAME=:username' ORDER BY R.RESOLVED_DATE DESC");
//        
//		query.setParameter("username", LoginUser);

			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT R.T_ID,R.T_STATUS,R.T_PRIORITY,R.T_SEVERITY,R.T_SUBJECT,T.T_COMPANY,T.T_BRANCH,T.T_DEPARTMENT,T.T_CATEGORY,T.T_SUBCAT1,T.T_SUBCAT2,R.T_USER_NAME, R.TP_NAME,R.RESOLVED_ENGINEER_NAME,R.RAISE_DATE,R.ASSIGN_DATE,R.RESOLVED_DATE ,COALESCE(T.T_REQUESTER_FULLNAME,'NA'),COALESCE(ta.TP_FULLNAME,'NA'),COALESCE(R.RESOLVED_ENGINEER_FULLNAME,'NA') from  TICKET_RESOLVED R JOIN TICKET T ON T.T_ID=R.T_ID left join ticket_assigned ta  on R.T_ID =ta.T_ID AND T.STATUS= R.T_STATUS and T.STATUS=ta.T_STATUS where R.T_STATUS='Resolved' AND R.T_USER_NAME='"+LoginUser+"' and R.T_USER_COMPANY='"+loginUserCompany+"' ORDER BY R.RESOLVED_DATE DESC").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				array = new JSONArray();

				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ listData[0].toString() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(
						"<button class='btn btn-sm btn-danger' id='closeTicket'  name='closeTicket' onclick='closeTicket(\""
								+ listData[0].toString() + "\")'><i class='fa fa-check'></i></button>");
				array.put(
						"<button class='btn btn-sm btn-warning' id='reopenTicket'  name='reopenTicket' onclick='reopenTicket(\""
								+ listData[0].toString() + "\")'><i class='fa fa-check'></i></button>");

				array.put(listData[0].toString());
				array.put(listData[1].toString());
				array.put(listData[2].toString());
				array.put(listData[3].toString());
				array.put(listData[4].toString());
				array.put(listData[5].toString());
				array.put(listData[6].toString());
				array.put(listData[7].toString());
				array.put(listData[8].toString());
				array.put(listData[9].toString());
				array.put(listData[10].toString());
				array.put(listData[11].toString());
				array.put(listData[17].toString());
				array.put(listData[12].toString());
				array.put(listData[18].toString());
				array.put(listData[13].toString());
				array.put(listData[19].toString());
				array.put(listData[14].toString());
				array.put(listData[15].toString());
				array.put(listData[16].toString());

				array1.put(array);
				//System.out.println("ARRAY OUTPUT: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}

	@Override
	public JSONArray getClosedEngTicketList() {

		//System.out.println("Inside EngActivityDaoImpl getClosedEngTicketList method");

		String LoginUser = null;
		String loginUserCompany = null;
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
		String DBType = environment.getRequiredProperty("jdbc.url");
		List<Object[]> l = null;

		try {
			if (DBType.contains("oracle")) {

				//System.out.println("****************************ORACLE QUERY****************************");
				l = sessionFactory.getCurrentSession().createSQLQuery(
						"Select * FROM (select T_ID,T_SUBJECT,T_CATEGORY,T_SUBCATEGORY,T_PRIORITY,T_STATUS as status1,T_USER_NAME as username,TP_NAME as tpname,A_ENGINEER_NAME,RESOLVED_ENGINEER_NAME,CLOSEDBY,RAISE_DATE,ASSIGN_DATE,RESOLVED_DATE,CLOSED_DATE from TICKET_RESOLVED UNION select A.T_ID,A.T_SUBJECT,A.T_CATEGORY,A.T_SUBCATEGORY,A.T_PRIORITY,A.T_STATUS as status1,A.T_USER_NAME as username,A.TP_NAME,A.ENGINEER_NAME,'NA',A.T_CLOSEBY,A.RAISE_DATE,A.ASSIGN_DATE,'NA',A.T_CLOSEDATE from TICKET_ASSIGNED A WHERE NOT EXISTS(SELECT B.T_ID FROM TICKET_RESOLVED B where A.T_ID=B.T_ID) ) WHERE A_ENGINEER_NAME ='"
								+ LoginUser + "' AND status1='Closed' ORDER BY T_ID DESC")
						.list();

			} else if (DBType.contains("mysql")) {

				//System.out.println("****************************MySQL QUERY****************************");
				l = sessionFactory.getCurrentSession().createSQLQuery(
						"SELECT * FROM(select t.T_ID, t.STATUS as status1,t.PRIORITY, t.SEVERITY,t.T_SUBJECT, t.T_COMPANY, t.T_BRANCH, t.T_DEPARTMENT,t.T_CATEGORY, t.T_SUBCAT1,t.T_SUBCAT2,COALESCE (ta.TP_NAME,'NA') ,COALESCE (ta.TP_FULLNAME ,'NA'),COALESCE ( ta.T_ASSIGN_TO,'NA'),COALESCE (ta.ENGINEER_NAME,'NA'),COALESCE (ta.ENGINEER_GROUP,'NA'),COALESCE (ta.ENGINEER_FULLNAME,'NA'), COALESCE(tr.RESOLVED_ENGINEER_NAME,'NA') AS RESOLVED_ENGINEER_NAME,COALESCE( tr.RESOLVED_ENGINEER_FULLNAME,'NA'),COALESCE(tr.RESOLVED_ENGINEER_COMPANY,'NA')AS RESOLVED_ENGINEER_COMPANY,COALESCE(t.T_CLOSEBY,'NA'),COALESCE(t.T_CLOSEBY_FULLNAME,'NA'), tr.RAISE_DATE,COALESCE(tr.ASSIGN_DATE,'NA'),COALESCE(tr.RESOLVED_DATE,'NA'),COALESCE(tr.CLOSED_DATE,'NA') AS CLOSED_DATE,t.VIP_TICKET AS VIP_TICKET  FROM ticket AS  t JOIN ticket_assigned AS ta  ON t.T_ID=ta.T_ID LEFT JOIN  ticket_resolved AS tr ON t.T_ID=tr.T_ID ) cc  WHERE (RESOLVED_ENGINEER_NAME ='"+LoginUser+"' and RESOLVED_ENGINEER_COMPANY ='"+loginUserCompany+"') AND VIP_TICKET!='true' AND status1='Closed' ORDER BY CLOSED_DATE DESC").list();

			}
			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				array = new JSONArray();

				array.put("<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ listData[0].toString() + "\")'><i class='fa fa-eye'></i></button>");

				array.put(listData[0]);
				array.put(listData[1]);
				array.put(listData[2]);
				array.put(listData[3]);
				array.put(listData[4]);
				array.put(listData[5]);
				array.put(listData[6]);
				array.put(listData[7]);
				array.put(listData[8]);
				array.put(listData[9]);
				array.put(listData[10]);
				array.put(listData[11]);
			
				array.put(listData[12]);
				if(listData[12].equals("Engineer"))
				{
					array.put(listData[14]);
				}	
				else
				{
					array.put(listData[15]);
				}
				array.put(listData[16]);
				array.put(listData[17]);
				array.put(listData[18]);
				
				array.put(listData[20]);
				array.put(listData[21]);
				array.put(listData[22]);
				array.put(listData[23]);
				array.put(listData[24]);
				array.put(listData[25]);
				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray getClosedEngVIPTicketList() {

		//System.out.println("Inside EngActivityDaoImpl getClosedEngVIPTicketList method");

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
		String DBType = environment.getRequiredProperty("jdbc.url");
		List<Object[]> l = null;

		try {
			if (DBType.contains("oracle")) {

				//System.out.println("****************************ORACLE QUERY****************************");
				l = sessionFactory.getCurrentSession().createSQLQuery(
						"Select * FROM (select T_ID,T_SUBJECT,T_CATEGORY,T_SUBCATEGORY,T_PRIORITY,T_STATUS as status1,T_USER_NAME as username,TP_NAME as tpname,A_ENGINEER_NAME,RESOLVED_ENGINEER_NAME,CLOSEDBY,RAISE_DATE,ASSIGN_DATE,RESOLVED_DATE,CLOSED_DATE from TICKET_RESOLVED UNION select A.T_ID,A.T_SUBJECT,A.T_CATEGORY,A.T_SUBCATEGORY,A.T_PRIORITY,A.T_STATUS as status1,A.T_USER_NAME as username,A.TP_NAME,A.ENGINEER_NAME,'NA',A.T_CLOSEBY,A.RAISE_DATE,A.ASSIGN_DATE,'NA',A.T_CLOSEDATE from TICKET_ASSIGNED A WHERE NOT EXISTS(SELECT B.T_ID FROM TICKET_RESOLVED B where A.T_ID=B.T_ID) ) WHERE A_ENGINEER_NAME ='"
								+ LoginUser + "' AND status1='Closed' ORDER BY T_ID DESC")
						.list();

			} else if (DBType.contains("mysql")) {

				//System.out.println("****************************MySQL QUERY****************************");
				l = sessionFactory.getCurrentSession().createSQLQuery(

"SELECT * FROM(select t.T_ID, t.STATUS as status1,t.PRIORITY, t.SEVERITY,t.T_SUBJECT, t.T_COMPANY, t.T_BRANCH, t.T_DEPARTMENT,t.T_CATEGORY, t.T_SUBCAT1,t.T_SUBCAT2,COALESCE (ta.TP_NAME,'NA') ,COALESCE (ta.TP_FULLNAME ,'NA'),COALESCE ( ta.T_ASSIGN_TO,'NA'),COALESCE (ta.ENGINEER_NAME,'NA'),COALESCE (ta.ENGINEER_GROUP,'NA'),COALESCE (ta.ENGINEER_FULLNAME,'NA'), COALESCE(tr.RESOLVED_ENGINEER_NAME,'NA') AS RESOLVED_ENGINEER_NAME,COALESCE( tr.RESOLVED_ENGINEER_FULLNAME,'NA'),COALESCE(tr.RESOLVED_ENGINEER_COMPANY,'NA')AS RESOLVED_ENGINEER_COMPANY,COALESCE(t.T_CLOSEBY,'NA'),COALESCE(t.T_CLOSEBY_FULLNAME,'NA'), tr.RAISE_DATE,COALESCE(tr.ASSIGN_DATE,'NA'),COALESCE(tr.RESOLVED_DATE,'NA'),COALESCE(tr.CLOSED_DATE,'NA') AS CLOSED_DATE,t.VIP_TICKET AS VIP_TICKET  FROM ticket AS  t JOIN ticket_assigned AS ta  ON t.T_ID=ta.T_ID LEFT JOIN  ticket_resolved AS tr ON t.T_ID=tr.T_ID ) cc  WHERE (RESOLVED_ENGINEER_NAME ='"+LoginUser+"' and RESOLVED_ENGINEER_COMPANY ='"+loginUserCompany+"') AND VIP_TICKET='true' AND status1='Closed' ORDER BY CLOSED_DATE DESC").list();

			}
			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				array = new JSONArray();

				array.put("<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ listData[0].toString() + "\")'><i class='fa fa-eye'></i></button>");


array.put(listData[0]);
				array.put(listData[1]);
				array.put(listData[2]);
				array.put(listData[3]);
				array.put(listData[4]);
				array.put(listData[5]);
				array.put(listData[6]);
				array.put(listData[7]);
				array.put(listData[8]);
				array.put(listData[9]);
				array.put(listData[10]);
				array.put(listData[11]);
			
				array.put(listData[12]);
				if(listData[12].equals("Engineer"))
				{
					array.put(listData[14]);
				}	
				else
				{
					array.put(listData[15]);
				}
				array.put(listData[16]);
				array.put(listData[17]);
				array.put(listData[18]);
				
				array.put(listData[20]);
				array.put(listData[21]);
				array.put(listData[22]);
				array.put(listData[23]);
				array.put(listData[24]);
				array.put(listData[25]);
				array1.put(array);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray getEngAssignTickets(String LoginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String LoginScope="";
		String loginUserCompany="";
		String output = "";
		String enggCategory="";
		String enggGroup="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
			for (loginmaster loginObj : loginset) {
				enggCategory=loginObj.getCATEGORY();
				enggGroup=loginObj.getGROUP_NAME().replace(",","','");
				//System.out.println("ENGG GROUP FOUND: "+enggGroup);
			}
			
			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_STATUS='Assigned' AND (VIP_TICKET!='true' OR VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY STR_TO_DATE(T_CURRENT_ACTIVITY_TIME,'%d-%m-%Y %H:%i:%s') DESC").list();
			array = new JSONArray();
			for (ticket_assigned newObj : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");
				array1.put(newObj.getT_ID());
				array1.put(newObj.getT_STATUS());
				array1.put(newObj.getT_PRIORITY());
				array1.put(newObj.getT_SEVERITY());
				array1.put(newObj.getT_SUBJECT());
				array1.put(newObj.getT_COMPANY());
				array1.put(newObj.getT_BRANCH());
				array1.put(newObj.getT_DEPARTMENT());
				array1.put(newObj.getT_CATEGORY());
				array1.put(newObj.getT_SUBCATEGORY1());
				array1.put(newObj.getT_SUBCATEGORY2());
				array1.put(newObj.getTP_NAME());
				if(newObj.getTP_FULLNAME() == null) {
					array1.put("NA");	
				}else
				{
					array1.put(newObj.getTP_FULLNAME());	
				}
			
				if(newObj.getT_ASSIGN_TO().equals("Engineer")){
					array1.put(newObj.getENGINEER_NAME());
				}
				else
				{
					array1.put(newObj.getENGINEER_GROUP());
				}
				 if(newObj.getENGINEER_FULLNAME() ==  null) {
						array1.put("NA");	
				 }
				 else 
				 {
				array1.put(newObj.getENGINEER_FULLNAME());
				 }
				array1.put(newObj.getT_RAISE_DATE());
				array1.put(newObj.getT_ASSIGN_DATE());
				
				array.put(array1);
			}
			//System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}
	
	@Override
	public JSONArray getEngAssignVIPTickets(String LoginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String LoginScope="";
		String loginUserCompany="";
		String output = "";
		String enggCategory="";
		String enggGroup="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginUserCompany = session.getAttribute("companyname").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
			for (loginmaster loginObj : loginset) {
				enggCategory=loginObj.getCATEGORY();
				enggGroup=loginObj.getGROUP_NAME().replace(",","','");
				//System.out.println("ENGG GROUP FOUND: "+enggGroup);
			}
			////System.out.println("dfgdfggdgfg ticket assigned");
			
			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_STATUS='Assigned' AND VIP_TICKET='true' AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY STR_TO_DATE(T_ASSIGN_DATE ,'%d-%m-%Y %H:%i:%s') asc").list();
																																																																								
			array = new JSONArray();
			for (ticket_assigned newObj : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");	

				array1.put(newObj.getT_ID());
				array1.put(newObj.getT_STATUS());
				array1.put(newObj.getT_PRIORITY());
				array1.put(newObj.getT_SEVERITY());
				array1.put(newObj.getT_SUBJECT());
				array1.put(newObj.getT_COMPANY());
				array1.put(newObj.getT_BRANCH());
				array1.put(newObj.getT_DEPARTMENT());
				array1.put(newObj.getT_CATEGORY());
				array1.put(newObj.getT_SUBCATEGORY1());
				array1.put(newObj.getT_SUBCATEGORY2());
				array1.put(newObj.getTP_NAME());
				if(newObj.getTP_FULLNAME() == null) {
					array1.put("NA");	
				}
				else {
					array1.put(newObj.getTP_FULLNAME());
				}
				
				
				if(newObj.getT_ASSIGN_TO().equals("Engineer")){
					array1.put(newObj.getENGINEER_NAME());
				}
				else
				{
					array1.put(newObj.getENGINEER_GROUP());
				}
				if(newObj.getENGINEER_FULLNAME() == null) {
					array1.put("NA");
				}
				else 
				{
					array1.put(newObj.getENGINEER_FULLNAME());	
				}
				
				array1.put(newObj.getT_RAISE_DATE());
				array1.put(newObj.getT_ASSIGN_DATE());
				
				array.put(array1);
			}
//			//System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}
//
//	@Override
//	public String ViewEngAssignTicketsT(String tid, String LoginUser) {
//		int ticketid = 0;
//		String raisedate = "";
//		String assigndate = "";
//		String priority = "";
//		String username = "";
//		String usermail = "";
//		String userphone = "";
//		String userbranch = "";
//		String tpname = "";
//		String tpemail = "";
//		String tpphone = "";
//		String usercompany = "";
//		String category = "";
//		String subcat = "";
//		String sub = "";
//		String filename = "NA";
//		String desc = "";
//		String status = "";
//		String engname = "";
//		String engemail = "";
//		String engbranch = "";
//		String engphone = "";
//		String requestmode = "";
//		String output = "";
//		try {
//
//			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession()
//					.createQuery(" FROM ticket_assigned Where T_ID='" + tid + "' ").list();
//			ticket_assigned newObj = dataSet.get(0);
//			try {
//				if ((newObj.getRAISE_DATE()) == null || (newObj.getRAISE_DATE()).contains("null")
//						|| (newObj.getRAISE_DATE()).equalsIgnoreCase("null") || (newObj.getRAISE_DATE()) == " "
//						|| (newObj.getRAISE_DATE()) == "") {
//					raisedate = "NA";
//				} else {
//					raisedate = newObj.getRAISE_DATE();
//				}
//				if ((newObj.getASSIGN_DATE()) == null || (newObj.getASSIGN_DATE()).contains("null")
//						|| (newObj.getASSIGN_DATE()).equalsIgnoreCase("null") || (newObj.getASSIGN_DATE()) == " "
//						|| (newObj.getASSIGN_DATE()) == "") {
//					assigndate = "NA";
//
//				} else {
//					assigndate = newObj.getASSIGN_DATE();
//				}
//				if ((newObj.getT_PRIORITY()) == null || (newObj.getT_PRIORITY()).contains("null")
//						|| (newObj.getT_PRIORITY()).equalsIgnoreCase("null") || (newObj.getT_PRIORITY()) == " "
//						|| (newObj.getT_PRIORITY()) == "") {
	
	
	
	
//					priority = "NA";
//				} else {
//					priority = newObj.getT_PRIORITY();
//				}
//				if ((newObj.getT_USER_NAME()) == null || (newObj.getT_USER_NAME()).contains("null")
//						|| (newObj.getT_USER_NAME()).equalsIgnoreCase("null") || (newObj.getT_USER_NAME()) == " "
//						|| (newObj.getT_USER_NAME()) == "") {
//
//					username = "NA";
//				} else {
//					username = newObj.getT_USER_NAME();
//				}
//				if ((newObj.getT_USER_EMAIL()) == null || (newObj.getT_USER_EMAIL()).contains("null")
//						|| (newObj.getT_USER_EMAIL()).equalsIgnoreCase("null") || (newObj.getT_USER_EMAIL()) == " "
//						|| (newObj.getT_USER_EMAIL()) == "") {
//					usermail = "NA";
//				} else {
//					usermail = newObj.getT_USER_EMAIL();
//				}
//				if ((newObj.getT_USER_PHONE()) == null || (newObj.getT_USER_PHONE()).contains("null")
//						|| (newObj.getT_USER_PHONE()).equalsIgnoreCase("null") || (newObj.getT_USER_PHONE()) == " "
//						|| (newObj.getT_USER_PHONE()) == "") {
//					userphone = "NA";
//				} else {
//					userphone = newObj.getT_USER_PHONE();
//				}
//				if ((newObj.getT_USER_BRANCH()) == null || (newObj.getT_USER_BRANCH()).contains("null")
//						|| (newObj.getT_USER_BRANCH()).equalsIgnoreCase("null") || (newObj.getT_USER_BRANCH()) == " "
//						|| (newObj.getT_USER_BRANCH()) == "") {
//					userbranch = "NA";
//				} else {
//					userbranch = newObj.getT_USER_BRANCH();
//				}
//				if ((newObj.getTP_NAME()) == null || (newObj.getTP_NAME()).contains("null")
//						|| (newObj.getTP_NAME()).equalsIgnoreCase("null") || (newObj.getTP_NAME()) == " "
//						|| (newObj.getTP_NAME()) == "") {
//
//					tpname = "NA";
//				} else {
//					tpname = newObj.getTP_NAME();
//				}
//				if ((newObj.getTP_EMAIL()) == null || (newObj.getTP_EMAIL()).contains("null")
//						|| (newObj.getTP_EMAIL()).equalsIgnoreCase("null") || (newObj.getTP_EMAIL()) == " "
//						|| (newObj.getTP_EMAIL()) == "") {
//
//					tpemail = "NA";
//				} else {
//					tpemail = newObj.getTP_EMAIL();
//				}
//				if ((newObj.getTP_PHONE()) == null || (newObj.getTP_PHONE()).contains("null")
//						|| (newObj.getTP_PHONE()).equalsIgnoreCase("null") || (newObj.getTP_PHONE()) == " "
//						|| (newObj.getTP_PHONE()) == "") {
//
//					tpphone = "NA";
//				} else {
//					tpphone = newObj.getTP_PHONE();
//				}
//				if ((newObj.getT_USER_COMPANY()) == null || (newObj.getT_USER_COMPANY()).contains("null")
//						|| (newObj.getT_USER_COMPANY()).equalsIgnoreCase("null") || (newObj.getT_USER_COMPANY()) == " "
//						|| (newObj.getT_USER_COMPANY()) == "") {
//
//					usercompany = "NA";
//				} else {
//					usercompany = newObj.getT_USER_COMPANY();
//				}
//				if ((newObj.getT_CATEGORY()) == null || (newObj.getT_CATEGORY()).contains("null")
//						|| (newObj.getT_CATEGORY()).equalsIgnoreCase("null") || (newObj.getT_CATEGORY()) == " "
//						|| (newObj.getT_CATEGORY()) == "") {
//
//					category = "NA";
//				} else {
//					category = newObj.getT_CATEGORY();
//				}
//				if ((newObj.getT_SUBCATEGORY()) == null || (newObj.getT_SUBCATEGORY()).contains("null")
//						|| (newObj.getT_SUBCATEGORY()).equalsIgnoreCase("null") || (newObj.getT_SUBCATEGORY()) == " "
//						|| (newObj.getT_SUBCATEGORY()) == "") {
//
//					subcat = "NA";
//				} else {
//					subcat = newObj.getT_SUBCATEGORY();
//				}
//				if ((newObj.getT_SUBJECT()) == null || (newObj.getT_SUBJECT()).contains("null")
//						|| (newObj.getT_SUBJECT()).equalsIgnoreCase("null") || (newObj.getT_SUBJECT()) == " "
//						|| (newObj.getT_SUBJECT()) == "") {
//
//					sub = "NA";
//				} else {
//					sub = newObj.getT_SUBJECT();
//				}
//				if ((newObj.getT_DESC()) == null || (newObj.getT_DESC()).contains("null")
//						|| (newObj.getT_DESC()).equalsIgnoreCase("null") || (newObj.getT_DESC()) == " "
//						|| (newObj.getT_DESC()) == "") {
//
//					desc = "NA";
//				} else {
//					desc = newObj.getT_DESC();
//				}
//				if ((newObj.getT_STATUS()) == null || (newObj.getT_STATUS()).contains("null")
//						|| (newObj.getT_STATUS()).equalsIgnoreCase("null") || (newObj.getT_STATUS()) == " "
//						|| (newObj.getT_STATUS()) == "") {
//
//					status = "NA";
//				} else {
//					status = newObj.getT_STATUS();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			List<enggmaster> dataSet2 = sessionFactory.getCurrentSession()
//					.createQuery(" FROM enggmaster Where E_NAME='" + LoginUser + "' ").list();
//			enggmaster newObjEngg = dataSet2.get(0);
//
//			try {
//				if ((newObjEngg.getE_NAME()) == null || (newObjEngg.getE_NAME()).contains("null")
//						|| (newObjEngg.getE_NAME()).equalsIgnoreCase("null") || (newObjEngg.getE_NAME()) == " "
//						|| (newObjEngg.getE_NAME()) == "") {
//					engname = "NA";
//				} else {
//					engname = newObjEngg.getE_NAME();
//				}
//				if ((newObjEngg.getE_BRANCH()) == null || (newObjEngg.getE_BRANCH()).contains("null")
//						|| (newObjEngg.getE_BRANCH()).equalsIgnoreCase("null") || (newObjEngg.getE_BRANCH()) == " "
//						|| (newObjEngg.getE_BRANCH()) == "") {
//					engbranch = "NA";
//
//				} else {
//					engbranch = newObjEngg.getE_BRANCH();
//				}
//				if ((newObjEngg.getE_MAIL()) == null || (newObjEngg.getE_MAIL()).contains("null")
//						|| (newObjEngg.getE_MAIL()).equalsIgnoreCase("null") || (newObjEngg.getE_MAIL()) == " "
//						|| (newObjEngg.getE_MAIL()) == "") {
//					engemail = "NA";
//				} else {
//					engemail = newObjEngg.getE_MAIL();
//				}
//				if ((newObjEngg.getE_PHONE()) == null || (newObjEngg.getE_PHONE()).contains("null")
//						|| (newObjEngg.getE_PHONE()).equalsIgnoreCase("null") || (newObjEngg.getE_PHONE()) == " "
//						|| (newObjEngg.getE_PHONE()) == "") {
//
//					engphone = "NA";
//				} else {
//					engphone = newObjEngg.getE_PHONE();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			List<ticket> dataSet3 = sessionFactory.getCurrentSession()
//					.createQuery(" FROM ticket WHERE T_ID='" + tid + "' ").list();
//			ticket newObjTicket = dataSet3.get(0);
//
//			try {
//				filename = newObjTicket.getT_ATTACH2_NAME();
//				//System.out.println("filename***" + filename);
//				if (filename == null || filename.contains("null") || filename.equalsIgnoreCase("null")
//						|| filename.equalsIgnoreCase("No File Available")) {
//					filename = "File Not Attached";
//				}
//				if ((newObjTicket.getREQUEST_MODE()) == null || (newObjTicket.getREQUEST_MODE()).contains("null")
//						|| (newObjTicket.getREQUEST_MODE()).equalsIgnoreCase("null")
//						|| (newObjTicket.getREQUEST_MODE()) == " " || (newObjTicket.getREQUEST_MODE()) == "") {
//
//					requestmode = "NA";
//				} else {
//					requestmode = newObjTicket.getREQUEST_MODE();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			output = tid + "," + engname + "," + engbranch + "," + engemail + "," + engphone + "," + username + ","
//					+ userbranch + "," + usermail + "," + userphone + "," + tpname + "," + tpemail + "," + tpphone + ","
//					+ tid + "," + raisedate + "," + assigndate + "," + priority + "," + sub + "," + desc + ","
//					+ usercompany + "," + category + "," + subcat + "," + filename + "," + requestmode;
//			//System.out.println("FinalData: " + output);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return output;
//	}

	@Override
	public JSONArray EditAssignTickets(String tid, String LoginUser) {
		//System.out.println("INSIDE EditAssignTickets");
		//System.out.println("TID: "+tid);
		//System.out.println("LOGIN USER: "+LoginUser);
		int ticketid = 0;
		String raisedate = "";
		String assigndate = "";
		String priority = "";
		String username = "";
		String usermail = "";
		String userphone = "";
		String userbranch = "";
		String tpname = "";
		String tpemail = "";
		String tpphone = "";
		String sol = "NA";
		String usercompany = "";
		String category = "";
		String subcat = "";
		String sub = "";
		String filename = "NA";
		String desc = "";
		String status = "";
		String engname = "";
		String engemail = "";
		String engbranch = "";
		String engphone = "";
		String requestmode = "";
		String output = "";
		String current_datee = "";
		JSONArray array = null;
		JSONArray array1 = null;
		String loginUserCompany = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("loginUserCompany****" + loginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
		
			List<ticket_assigned> ticketassigneddata = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_ID='" + tid+"'").list();
			
			List<loginmaster> enggdata = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='"+loginUserCompany+"'").list();
			
			List<ticket> ticketList = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='" + tid+"'").list();
			
			List<ticket_resolved> ticketresolveddata = sessionFactory.getCurrentSession().createQuery("from ticket_resolved where T_ID='" + tid+"'").list();
			
			array1 = new JSONArray();
			
			for (ticket_assigned TAssign : ticketassigneddata) {

				for (loginmaster EngData : enggdata) {
					
					for (ticket TicketData : ticketList) {

							JSONObject arrayobj = new JSONObject();
							/////////// TICKET DATA ////////////	
							arrayobj.put("tid", TicketData.getT_ID());
							arrayobj.put("raisedate", TAssign.getT_RAISE_DATE());
							arrayobj.put("assigndate", TAssign.getT_ASSIGN_DATE());
							arrayobj.put("priority", TAssign.getT_PRIORITY());
							arrayobj.put("severity", TAssign.getT_SEVERITY());
							arrayobj.put("requestmode", TicketData.getREQUEST_MODE());
							arrayobj.put("category", TAssign.getT_CATEGORY());
							arrayobj.put("subcat1", TAssign.getT_SUBCATEGORY1());
							arrayobj.put("subcat2", TAssign.getT_SUBCATEGORY2());
							arrayobj.put("sub", TAssign.getT_SUBJECT());
							arrayobj.put("desc", TAssign.getT_DESC());
							arrayobj.put("status", TAssign.getT_STATUS());
							
							//////////// REQUESTER DATA ////////////////
							arrayobj.put("username", TAssign.getT_USER_NAME());
							List<loginmaster> userList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + TAssign.getT_USER_NAME() + "' and COMPANY='" + TAssign.getT_COMPANY() + "'").list();
							for (loginmaster userDrive : userList) {
								arrayobj.put("usercompany", userDrive.getCOMPANY());
								arrayobj.put("userbranch", userDrive.getBRANCH());
								arrayobj.put("userdepartment", userDrive.getDEPARTMENT());
								arrayobj.put("usermail", userDrive.getEMAIL());
								arrayobj.put("userphone", userDrive.getPHONE());
								arrayobj.put("usersubdepartment", userDrive.getSUB_DEPARTMENT());
								arrayobj.put("userlocation", userDrive.getLOCATION());
							}
							
							//////////// TC DATA ////////////////
							arrayobj.put("tpname", TAssign.getTP_NAME());
							List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + TAssign.getTP_NAME() + "' and COMPANY='" + TAssign.getTP_COMPANY() + "'").list();
							for (loginmaster tpDrive : tpList) {
								arrayobj.put("tpcompany", tpDrive.getCOMPANY());
								arrayobj.put("tpbranch", tpDrive.getBRANCH());
								arrayobj.put("tpdepartment", tpDrive.getDEPARTMENT());
								arrayobj.put("tpemail", tpDrive.getEMAIL());
								arrayobj.put("tpphone", tpDrive.getPHONE());
								
								arrayobj.put("tpsubdepartment", tpDrive.getSUB_DEPARTMENT());
								arrayobj.put("tplocation", tpDrive.getLOCATION());
								arrayobj.put("tproletype", tpDrive.getROLE_TYPE());
							}
							
							/////////////// ENGG DATA ///////////
							arrayobj.put("engname", EngData.getUSERNAME());
							arrayobj.put("engcompany", EngData.getCOMPANY());
							arrayobj.put("engbranch", EngData.getBRANCH());
							arrayobj.put("engdepartment", EngData.getDEPARTMENT());
							arrayobj.put("engemail", EngData.getEMAIL());
							arrayobj.put("engphone", EngData.getPHONE());
							arrayobj.put("enggsubdepartment", EngData.getSUB_DEPARTMENT());
							arrayobj.put("engglocation", EngData.getLOCATION());
							
							
							for (ticket_resolved TResolved : ticketresolveddata) {
							if(TResolved.getSOLUTION().equals(null) || TResolved.getSOLUTION().equals("")) {
								arrayobj.put("sol", "NA");
							}else {
								arrayobj.put("sol", TResolved.getSOLUTION());
							}
							}				
							array1.put(arrayobj);
						
					}
					
				}
			}
			//System.out.println("ARRAY1: "+array1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	@Override
	public String UpdateAssignTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic)
	{
		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String SMSApi = "";
		String loginname = "";
		String loginUserCompany = "";
		String fullname = "";
		String emailid = "";
		String phone = "";
		String LoginUser="";
		try {
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			
			String loginRoleType="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginRoleType = session.getAttribute("role").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("loginRoleType****" + loginRoleType);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}

				///////////////// FILE UPLOAD STARTS //////////////
				String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
				//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
				DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
				LocalDateTime now = LocalDateTime.now();
				//System.out.println(localdate.format(now));
				String localDateNow=localdate.format(now);
				//String createnewfilename = UUID.randomUUID().toString();
				String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
				//System.out.println("createnewfilename***" + createnewfilename);
				//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
				
				String ext = "";
				String updatedFileName = null;
				
				
				try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
				File file = new File("C:\\ITHelpDesk\\");
				if (!file.exists()) {
					if (file.mkdir()) {
						//System.out.println("Directory is created!");
					} else {
						//System.out.println("Failed to create directory!");
					}
				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				
				//File uploadedFile =  empPic;
				File uploadedFile = new File(resolvePic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();
				//System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = resolvePic.getOriginalFilename();
				//System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//System.out.println("file_extension::::" + ext);
				//File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//System.out.println("destFile........" + destFile);
				////System.out.println("File........" + imagefilePath + File.separator +
				//fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//System.out.println("UPDATED FILE NAME: " + updatedFileName);
				
				try {
				FileUtils.copyFile(uploadedFile, destFile);
				File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
				//System.out.println("Could not copy file " + fileName);
				status = "error";
				ex.printStackTrace();
				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				
				///////////////// FILE UPLOAD ENDS //////////////

				try {
					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					loginname = session.getAttribute("username").toString();
				
					LoginUser = session.getAttribute("username").toString();
					loginUserCompany = session.getAttribute("companyname").toString();
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println(e);
				}

			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			//System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			
			
			
			String OLD_STATUS="";
			String T_COMPANY="";
			String T_BRANCH="";
			String T_DEPARTMENT="";
			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				List<ticket> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+tid+"'").list();
	    
				for(ticket oldstatus:gettingoldstatus) {
					OLD_STATUS=	oldstatus.getSTATUS();
					
					T_BRANCH=oldstatus.getT_BRANCH();
					T_COMPANY=oldstatus.getT_COMPANY();
					T_DEPARTMENT=	oldstatus.getT_DEPARTMENT();
				}
			
				
			}catch (Exception e) {
				//System.out.println(e);
			}

			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				if (dup.isEmpty()) {
					ticket_resolved queryTicketResolvedInsert = new ticket_resolved();
					queryTicketResolvedInsert.setT_ID(tid);
					queryTicketResolvedInsert.setRAISE_DATE(raisedate);
					queryTicketResolvedInsert.setASSIGN_DATE(assigndate);
					queryTicketResolvedInsert.setRESOLVED_DATE(currenttime11);
					queryTicketResolvedInsert.setT_USER_NAME(username);
					queryTicketResolvedInsert.setT_USER_EMAIL(useremail);
					queryTicketResolvedInsert.setT_USER_PHONE(userphone);
					queryTicketResolvedInsert.setT_USER_COMPANY(usercompany);
					queryTicketResolvedInsert.setT_USER_BRANCH(userbranch);
					queryTicketResolvedInsert.setT_CATEGORY(category);
					queryTicketResolvedInsert.setT_SUBCATEGORY1(subcat1);
					queryTicketResolvedInsert.setT_SUBCATEGORY2(subcat2);
					queryTicketResolvedInsert.setT_SUBJECT(sub);
					queryTicketResolvedInsert.setT_DESC(description);
					queryTicketResolvedInsert.setT_PRIORITY(priority);
					queryTicketResolvedInsert.setT_SEVERITY(severity);
					queryTicketResolvedInsert.setT_STATUS(status);
					queryTicketResolvedInsert.setTP_NAME(tcname);
					queryTicketResolvedInsert.setTP_EMAIL(tcemail);
					queryTicketResolvedInsert.setTP_PHONE(tcphone);
					queryTicketResolvedInsert.setA_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_COMPANY(engcompany);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_EMAIL(engemailid);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_PHONE(engphone);
					queryTicketResolvedInsert.setSOLUTION(solution);
					queryTicketResolvedInsert.setT_RESOLVED_TIME(currenttime11);
					queryTicketResolvedInsert.setCLOSEDBY("NA");
					queryTicketResolvedInsert.setCLOSED_DATE(null);
//					queryTicketResolvedInsert.setT_CLOSED_TIME(null);
					getSession().save(queryTicketResolvedInsert);

				} else {
					int f = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_resolved SET A_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_COMPANY='" + engcompany + "',T_STATUS='" + status+ "',T_RESOLVED_TIME='" + currenttime11 + "',RESOLVED_DATE='" + currenttime11+ "',SOLUTION='" + solution + "' WHERE T_ID='" + tid + "'").executeUpdate();
					if (f > 0) {
						//System.out.println("update in ticket ticket resolved****");

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession().createQuery("select max(SR_NO) from ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				// msg = e_name + " " + r_status + " Ticket On " + resolved_date;
				if (status.equals("Hold")) {
//					msg = "Engineer " + engname + " has " + status + " Ticket On " + currenttime;
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";
					
//					int idd = Integer.parseInt(tid);
//					Inv.RaiseNCloseEmailSMS(idd, username, "Hold", userbranch + "," + loginname, category, sub, engname,
//							priority, userphone, useremail);

				} else {
//					msg = "Engineer " + engname + " " + status + " Ticket On " + currenttime + " within "
//							+ raiseTime;
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";

//					int idd = Integer.parseInt(tid);
//					String aa = userbranch + "," + engname;
//					Inv.RaiseNCloseEmailSMS(idd, username, "Resolved", userbranch, category, sub, engname, priority,
//							userphone, useremail);
				}

//				int idd=Integer.parseInt(tid);
//				Inv.RaiseNCloseEmailSMS(idd,engname,status,userbranch,category,sub,username,priority,engphone,engemailid);

				ticket_tracking ticket_tracking = new ticket_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserCompany);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setTICKET_RAISED_NAME_COMPANY(usercompany);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				//System.out.println("insert in ticket tracking***");

				int i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket SET STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();

				i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_assigned SET T_STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();
				
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
				
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();
				
					//System.out.println(" actSrno1 IS: " + actSrno1);
				
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}

List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
				
				ticket_activity_log ticketActivityLog = new ticket_activity_log();
				
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setSTATUS(status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginname);
				ticketActivityLog.setT_SUBJECT(sub);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(solution);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(emailid);
				
				ticketActivityLog.setT_CONTACT_NO(phone);
				ticketActivityLog.setT_FULLNAME(fullname);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}
				
				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				
				///////////////////////////////////HISTORICAL SLA CODE START///////////////////////////////
				try {
					
					
					int SRNO1 = 0;
					try {
					
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO"));
						Integer SRNO2 = (Integer) crit.uniqueResult();
					
						//System.out.println(" SRNO1 IS: " + SRNO2);
					
						if (SRNO2 != null) {
							SRNO1 = SRNO2.intValue();
							SRNO1 = SRNO1 + 1;
							//System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
						} else {
							SRNO1 = 1;
							//System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//System.out.println(e);
					}
					
					
					if(OLD_STATUS.equals("Hold") && status.equals("Hold") || OLD_STATUS.equals("Hold") && !status.equals("Hold")  )
					{
						
						//System.out.println("INSIDE BOTH  HOLD  AND  OLD YES OR CURRENT NOT3 " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
				
						  Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO") ).add(Restrictions.eq("TICKET_ID", tid));

						 int maxsrno1=(int) criteriaformax.uniqueResult();
						 
						 //System.out.println("MAX NO is THAT " + maxsrno1);
					
										
							Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_END_DATE=:HOLD_END_DATE , TICKET_STATUS=:TICKET_STATUS WHERE SR_NO=:SR_NO");
							updathistoricalsla.setParameter("HOLD_END_DATE", currenttime);
							updathistoricalsla.setParameter("SR_NO",maxsrno1);
							updathistoricalsla.setParameter("TICKET_STATUS",status);
							
								

							//////////////////////////////CODE FOR FIND ELAPSE AND HOLD DURATION //////////////////////////////
							int check=	updathistoricalsla.executeUpdate();	
				
							
							String GETSTARTHOLDTIME="";
							String GETENDHOLDTIME="";
							//System.out.println("VALUE OF CHECK  " + check);
							if(check!=0) {
								
								//System.out.println("INSIDE ELAPSE IF BLOCK");
								Query QUERYFORBOTHDATE=sessionFactory.getCurrentSession().createQuery("from historical_sla where SR_NO='"+maxsrno1+"'");
								
								List<historical_sla> historicalvalue=QUERYFORBOTHDATE.list();
								for(historical_sla getvalue: historicalvalue) {
									
									GETENDHOLDTIME=	getvalue.getHOLD_END_DATE();
									GETSTARTHOLDTIME=	getvalue.getHOLD_START_DATE();
									
								}
								//System.out.println("GETENDHOLDTIME VALUE  "+ GETENDHOLDTIME);
								//System.out.println("GETSTARTHOLDTIME VALUE  "+ GETSTARTHOLDTIME);
								
								
								 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						            
						              
								  Date stratdate = sdf.parse(GETSTARTHOLDTIME);
						            Date enddate = sdf.parse(GETENDHOLDTIME);
						            
						        long duration = enddate.getTime()- stratdate.getTime();
						  
						           //System.out.println("difference_In_Time is   " + duration);
						          

									int diffInSeconds =(int) TimeUnit.MILLISECONDS.toSeconds(duration);
									long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
									long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
									long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
									
									
									//System.out.println("diffInDays: " + diffInDays);
									//System.out.println("diffInHours: " + diffInHours);
									//System.out.println("diffInMinutes: " + diffInMinutes);
									//System.out.println("diffInSeconds: " + diffInSeconds);
									
									///////////////// START DATE TO END DATE DURATION Starts///////
									int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
									long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
									long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
											- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
									long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
											- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
									
									String day_StartEndDate1 = "";
									String hours_StartEndDate1 = "";
									String minute_StartEndDate1 = "";
									String second_StartEndDate1 = "";

									if (day_StartEndDate != 0) {
										day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
									}
									if (hours_StartEndDate != 0) {
										hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
									}
									if (minute_StartEndDate != 0) {
										minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
									}
									if (second_StartEndDate != 0) {
										second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
									}

									String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
											+ second_StartEndDate1;
									//System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
									//System.out.println(" TOTAL ELAPS TIME  IS  " + diffInSeconds);
						            
						               if(!StartEndDateDuration.isEmpty() && diffInSeconds !=0) {
											
											Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
											updateelapsandduration.setParameter("HOLD_ELAPSED_TIME", Integer.valueOf(diffInSeconds).toString());
											updateelapsandduration.setParameter("SR_NO",maxsrno1);
											updateelapsandduration.setParameter("HOLD_DURATION",StartEndDateDuration);
										int check2=	updateelapsandduration.executeUpdate();
										
										//System.out.println("check2 value "+ check2);
						            	   
						               }
						               
							}
								

								if(OLD_STATUS.equals("Hold") && status.equals("Hold") ) {
									
									historical_sla historicalsla = new historical_sla();
									
									historicalsla.setSR_NO(SRNO1);
									historicalsla.setTICKET_ID(tid);
								
									historicalsla.setTICKET_STATUS(status);
								
									historicalsla.setSLA_STATUS("NA");
									historicalsla.setHOLD_START_DATE(currenttime);
									historicalsla.setHOLD_END_DATE("NA");
									historicalsla.setHOLD_ELAPSED_TIME("NA");
									
									historicalsla.setHOLD_DURATION("NA");
									
									historicalsla.setT_COMPANY(T_COMPANY);
									historicalsla.setT_BRANCH(T_BRANCH);
									historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
									sessionFactory.getCurrentSession().save(historicalsla);
									
									
								}
							
					}
					
					else if(!OLD_STATUS.equals("Hold") && status.equals("Hold") ){
						
						//System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
						historical_sla historicalsla = new historical_sla();
//						
						historicalsla.setSR_NO(SRNO1);
						historicalsla.setTICKET_ID(tid);
					
						historicalsla.setTICKET_STATUS(status);
					
						historicalsla.setSLA_STATUS("NA");
						historicalsla.setHOLD_START_DATE(currenttime);
						historicalsla.setHOLD_END_DATE("NA");
						historicalsla.setHOLD_ELAPSED_TIME("NA");
						
						historicalsla.setHOLD_DURATION("NA");
						
						historicalsla.setT_COMPANY(T_COMPANY);
						historicalsla.setT_BRANCH(T_BRANCH);
						historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
						sessionFactory.getCurrentSession().save(historicalsla);
				
					}
					
					
				}catch (Exception e) 
				{
					SMSApi="fail";
					//System.out.println(e);
				}
				
				SMSApi="success";
				
				///////////////////////////////////HISTORICAL SLA CODE STOP///////////////////////////////

				
				
				String HoldStartDate = simpleDateFormat.format(tdate);
				//System.out.println("currentHoldStartDate: " + HoldStartDate);
				Date HoldStartDate1 = simpleDateFormat.parse(HoldStartDate);
				//System.out.println(status+ "STAUS VALUE ");
				if (status.equals("Hold")) {
					List<sla> l = sessionFactory.getCurrentSession()
							.createQuery("from sla WHERE TICKET_ID='" + tid + "'").list();
					if (l.isEmpty()) {
						sla insertSLAObj = new sla();
						insertSLAObj.setTICKET_ID(tid);
						insertSLAObj.setPRIORITY(priority);
						insertSLAObj.setSEVERITY(severity);
						insertSLAObj.setTICKET_STATUS(status);
						insertSLAObj.setSTART_DATE(raisedate);
						insertSLAObj.setSTOP_DATE("NA");
						insertSLAObj.setELAPSED_TIME("NA");
						insertSLAObj.setSLA_TIME("NA");
						insertSLAObj.setSLA_STATUS("NA");
						insertSLAObj.setHOLD_START_DATE(HoldStartDate);
						insertSLAObj.setHOLD_END_DATE("NA");
						insertSLAObj.setHOLD_ELAPSED_TIME("NA");
						insertSLAObj.setSLA_TARGET("NA");
						insertSLAObj.setSTART_END_TIME("NA");
						insertSLAObj.setHOLD_DURATION("NA");
						getSession().save(insertSLAObj);
					} else {
						int i = sessionFactory.getCurrentSession().createQuery("UPDATE sla SET PRIORITY='" + priority
								+ "',SEVERITY='" + severity +"',TICKET_STATUS='" + status + "',START_DATE='" + raisedate
								+ "',STOP_DATE='NA',ELAPSED_TIME='NA',SLA_TIME='NA',SLA_STATUS='NA',HOLD_START_DATE='"
								+ HoldStartDate + "',HOLD_END_DATE='NA',HOLD_ELAPSED_TIME='NA' WHERE TICKET_ID='"+tid+"'").executeUpdate();
					}
				}
				SMSApi = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			if(SMSApi.equals("success"))
			Inv.EmailSMSTriggered(tid, status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return SMSApi;
	}

	@Override
	public String getvalueofmail(String eng_branchname, String t_id_s, String STReng, String t_status, String u_email,
			String tcmail, String username) {
		String tpemail = "";
		String host1;
		int port1;
		final String useremail1;
		final String pass;
		String output = "";
		try {
			Date date2 = null;
			date2 = new Date();
			String timeFormat = "h:mm a";
			String dateFormate = "dd-MMM-yyyy";
			SimpleDateFormat sdf = null;
			SimpleDateFormat sdf2 = null;
			sdf = new SimpleDateFormat(timeFormat);
			sdf2 = new SimpleDateFormat(dateFormate);

			String cdate = sdf2.format(date2);
			String ctime = sdf.format(date2);

			String host = "mail.smtp.host";
			List<tpmaster> listConfig = sessionFactory.getCurrentSession()
					.createQuery("from tpmaster where TP_NAME='" + STReng + "'").list();
			tpmaster newObj = new tpmaster();
			tpemail = newObj.getTP_MAIL();

			List<mail_config> listConfig1 = sessionFactory.getCurrentSession().createQuery("from mail_config").list();
			mail_config newMailObj = new mail_config();
			host1 = newMailObj.getHOST();
			port1 = newMailObj.getPORT();
			useremail1 = newMailObj.getE_MAIL();
			pass = newMailObj.getPASSWRD();

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put(" mail.smtp.ssl.trust", "*");
			if (host.contains("smtp.gmail.com")) {
				properties.put("mail.smtp.starttls.enable", "true");
			} else {
				//System.out.println("Other than gmail");
			}
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port1);

			javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties,
					new javax.mail.Authenticator() {

						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(useremail1, pass);
						}
					});

			if (t_status.equals("Pending For Re-assign")) {
				//System.out.println("inside first pending======with Tcmail===" + tcmail);

				try {
					//System.out.println("in try===");
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(useremail1));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tcmail));
//					la.run("Subject: Ticket " + t_status);
					//System.out.println("t_status====inside first pending======with Tcmail=========" + t_status);
//					la.run("Start to send mail");

					if (t_status.equals("Resolved")) {
						//System.out.println("1==");
						message.setSubject("Ticket Resolved");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Resolved by " + STReng + " of " + eng_branchname + " Site on " + cdate + " at "
								+ ctime + " pm..\r \nThanks And Regards,\r \nIT HELPDESK");

					} else if (t_status.equals("Pending For Re-assign")) {
						//System.out.println("2==");
						//System.out.println("inside first pending======with Tcmail=2==" + tcmail);
						message.setSubject("Ticket Pending");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Pending by " + STReng + " of " + eng_branchname
								+ " Site. \r \n Please Reassign to other Engineer.\r \nThanks And Regards,\r \nIT HELPDESK");

					}

					else {
						//System.out.println("3==");
						//System.out.println("in holdddddddddddddd" + tcmail);
						message.setSubject("Ticket Hold");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is kept on Hold by " + STReng + " of " + eng_branchname
								+ " Site .\r \nThanks And Regards,\r \nIT HELPDESK");

					}

					// message.setText("Dear sir, your Ticket of ID : " + t_id_s + " is Resolved by
					// " +STReng);
					Transport.send(message);
					//System.out.println("Mail Successfully send to " + tcmail);
//					la.run("Mail Successfully send to " + tcmail);
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println("Could not able to send mail beacause :" + e);
//					la.run("Could not able to send mail beacause :" + e.toString());
				}

			} else {
				//System.out.println("in 1st elseee part");
				//System.out.println("inside else to 1 pending for re=========");
				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(useremail1));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u_email));
					//System.out.println("u_email====inside else in holdddddddd pending for re===============" + u_email);
//					la.run("Subject: Ticket " + t_status);

//					la.run("Start to send mail");

					if (t_status.equals("Resolved")) {
						message.setSubject("Ticket Resolved");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Resolved by " + STReng + " of " + eng_branchname + " Branch on " + cdate + " at "
								+ ctime + " pm..\r \nThanks And Regards,\r \nIT HELPDESK");

					} else if (t_status.equals("Pending For Re-assign")) {
						//System.out.println("u_email====inside else to 1 pending for re=======2========" + u_email);
						message.setSubject("Ticket Pending");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Pending by " + STReng + " of " + eng_branchname
								+ " Branch. \r \n Please Reassign to other Engineer.\r \nThanks And Regards,\r \nIT HELPDESK");

					} else if (t_status.equals("Hold")) {
						//System.out.println("Hold check status========" + t_status);
						//System.out.println("in hold8888888888888888888888888888888888" + u_email);
						message.setSubject("Ticket Hold");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is kept on Hold by " + STReng + " of " + eng_branchname
								+ " Branch .\r \nThanks And Regards,\r \nIT HELPDESK");

					}

					// message.setText("Dear sir, your Ticket of ID : " + t_id_s + " is Resolved by
					// " +STReng);
					Transport.send(message);

					//System.out.println("Mail Successfully send to " + tcmail);
//					la.run("Mail Successfully send to " + u_email);
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println("Could not able to send mail beacause :" + e);
//					la.run("Could not able to send mail beacause :" + e.toString());
				}
				try {
					//System.out.println("in 2nd try****");
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(useremail1));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tcmail));
//					la.run("Subject: Ticket " + t_status);

//					la.run("Start to send mail");

					if (t_status.equals("Resolved")) {
						message.setSubject("Ticket Resolved");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Resolved by " + STReng + " of " + eng_branchname + " Branch on " + cdate + " at "
								+ ctime + " pm..\r \nThanks And Regards,\r \nIT HELPDESK");

					} else if (t_status.equals("Pending For Re-assign")) {
						//System.out.println("u_email====inside else to 1 pending for re======3=========" + u_email);
						message.setSubject("Ticket Pending");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is Pending by " + STReng + " of " + eng_branchname
								+ " Branch. \r \n Please Reassign to other Engineer.\r \nThanks And Regards,\r \nIT HELPDESK");

					} else {
						//System.out.println("in second try else****" + u_email);
						message.setSubject("Ticket Hold");
						message.setText("Dear Sir/Madam,\r \nPlease Check For\r \n Ticket Id:" + t_id_s
								+ " is kept on Hold by " + STReng + " of " + eng_branchname
								+ " Branch .\r \nThanks And Regards,\r \nIT HELPDESK");

					}

					// message.setText("Dear sir, your Ticket of ID : " + t_id_s + " is Resolved by
					// " +STReng);
					Transport.send(message);
					output = "success";
					//System.out.println("Mail Successfully send to " + tcmail);
//					la.run("Mail Successfully send to " + tcmail);
				} catch (Exception e) {
					output = "error";
					e.printStackTrace();
					//System.out.println("Could not able to send mail beacause :" + e);
//					la.run("Could not able to send mail beacause :" + e.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	@Override
	public JSONArray getReAssignedEngTickets(String LoginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggCategory="";
		String enggGroup="";
		String LoginScope="";
		String loginUserCompany="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		try {
			//////GET ENGINEERS DATA////
					List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
					for (loginmaster loginObj : loginset) {
						enggCategory=loginObj.getCATEGORY();
						enggGroup=loginObj.getGROUP_NAME().replace(",","','");
						//System.out.println("ENGG GROUP FOUND: "+enggGroup);
					}

			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession()
					.createQuery(" from ticket_assigned where T_STATUS='Re-Assigned'  AND (VIP_TICKET!='true' OR VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY STR_TO_DATE(T_CURRENT_ACTIVITY_TIME,'%d-%m-%Y %H:%i:%s') DESC").list();
			array = new JSONArray();
			for (ticket_assigned newObj : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");

				array1.put(newObj.getT_ID());
				array1.put(newObj.getT_STATUS());
				array1.put(newObj.getT_PRIORITY());
				array1.put(newObj.getT_SEVERITY());
				array1.put(newObj.getT_SUBJECT());
				array1.put(newObj.getT_COMPANY());
				array1.put(newObj.getT_BRANCH());
				array1.put(newObj.getT_DEPARTMENT());
				array1.put(newObj.getT_CATEGORY());
				array1.put(newObj.getT_SUBCATEGORY1());
				array1.put(newObj.getT_SUBCATEGORY2());
				array1.put(newObj.getTP_NAME());
				if(newObj.getTP_FULLNAME() == null) {
					array1.put("NA");	
				}else {
				array1.put(newObj.getTP_FULLNAME());
				}
				if(newObj.getT_ASSIGN_TO().equals("Engineer")){
					array1.put(newObj.getENGINEER_NAME());
				}
				else
				{
					array1.put(newObj.getENGINEER_GROUP());
				}
				if(newObj.getENGINEER_FULLNAME() == null) {
					array1.put("NA");
				}
				else {
				array1.put(newObj.getENGINEER_FULLNAME());
				}
				array1.put(newObj.getT_RAISE_DATE());
				array1.put(newObj.getT_ASSIGN_DATE());

				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

//
//	@Override
//	public JSONArray EditReAssinedTicketsDetails(String tid, String LoginUser) {
//		//System.out.println("____________INSIDE JAVA METHOD__________");
//		int ticketid = 0;
//		String E_NAME = null;
//		String E_BRANCH = null;
//		String E_PHONE = null;
//		String E_MAIL = null;
//		String TP_NAME = null;
//		String TP_BRANCH = null;
//		String TP_PHONE = null;
//		String TP_EMAIL = null;
//		String RAISE_DATE = null;
//		String ASSIGN_DATE = null;
//		String COMPANY = null;
//		String CATEGORY = null;
//		String SUB_CATEGORY = null;
//		String SUBJECT = null;
//		String PRIORITY = null;
//		String REQUEST_MODE = null;
//		String DESC = null;
//		String USERNAME = null;
//		String USERBRANCH = null;
//		String USERPHONE = null;
//		String USEREMAIL = null;
//		JSONArray array1 = new JSONArray();
//
//		try {
//			DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			Date date2 = new Date();
//			//System.out.println(dateFormat2.format(date2));
//			String currenttime = dateFormat2.format(date2);
//
//			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			Date date = new Date();
//			//System.out.println(dateFormat.format(date));
//			String current_datee = dateFormat.format(date);
//			JSONArray jsobject = new JSONArray();
//////////////////////////////////			Engineer Details first                 //////////////////////////////
//			Query query = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID = '" + tid + "'");
//			List<ticket> ticketList = query.list();
//
//			Query query1 = sessionFactory.getCurrentSession()
//					.createQuery("from enggmaster where E_NAME = '" + LoginUser + "'");
////			List<ticket_resolved> ticketresolvedList = query1.list();
//
//			Query query2 = sessionFactory.getCurrentSession()
//					.createQuery("from ticket_assigned where T_ID = '" + tid + "'");
////			List<ticket_assigned> ticketassignedList = query2.list();
//
//			array1 = new JSONArray();
//
//			for (ticket ticketDrive : ticketList) {
//
//				JSONArray arrayobj = new JSONArray();
//
//				enggmaster TRdata = (enggmaster) query1.uniqueResult();
//				if (TRdata != null) {
//					E_NAME = TRdata.getE_NAME();
//					E_BRANCH = TRdata.getE_BRANCH();
//					E_PHONE = TRdata.getE_PHONE();
//					E_MAIL = TRdata.getE_MAIL();
//				} else {
//					E_NAME = "NA";
//					E_BRANCH = "NA";
//					E_PHONE = "NA";
//					E_MAIL = "NA";
//				}
//
//				ticket Tdata = (ticket) query.uniqueResult();
//				if (Tdata != null) {
////					 for (ticket_assigned T_AssignedDrive : ticketassignedList) {
//					REQUEST_MODE = Tdata.getREQUEST_MODE();
////					 } 
//				} else {
//					REQUEST_MODE = "NA";
//				}
//
//				ticket_assigned TAdata = (ticket_assigned) query2.uniqueResult();
//				if (TAdata != null) {
////					 for (ticket_assigned T_AssignedDrive : ticketassignedList) {
//					TP_NAME = TAdata.getTP_NAME();
//					RAISE_DATE = TAdata.getRAISE_DATE();
//					ASSIGN_DATE = TAdata.getASSIGN_DATE();
//					COMPANY = TAdata.getT_USER_COMPANY();
//					CATEGORY = TAdata.getT_CATEGORY();
//					SUB_CATEGORY = TAdata.getT_SUBCATEGORY();
//					SUBJECT = TAdata.getT_SUBJECT();
//					PRIORITY = TAdata.getT_PRIORITY();
//					DESC = TAdata.getT_DESC();
//					USERNAME = TAdata.getT_USER_NAME();
//					USERBRANCH = TAdata.getT_USER_BRANCH();
//					USERPHONE = TAdata.getT_USER_PHONE();
//					USEREMAIL = TAdata.getT_USER_EMAIL();
////					 } 
//				} else {
//					TP_NAME = "NA";
//					RAISE_DATE = "NA";
//					ASSIGN_DATE = "NA";
//					COMPANY = "NA";
//					CATEGORY = "NA";
//					SUB_CATEGORY = "NA";
//					SUBJECT = "NA";
//					PRIORITY = "NA";
//					DESC = "NA";
//					USERNAME = "NA";
//					USERBRANCH = "NA";
//					USERPHONE = "NA";
//					USEREMAIL = "NA";
//				}
//				Query query3 = sessionFactory.getCurrentSession()
//						.createQuery("from tpmaster where TP_NAME = '" + TP_NAME + "'");
//				tpmaster TPdata = (tpmaster) query3.uniqueResult();
//				if (TPdata != null) {
////					 for (ticket_assigned T_AssignedDrive : ticketassignedList) {
//					TP_BRANCH = TPdata.getTP_BRANCH();
//					TP_PHONE = TPdata.getTP_PHONE();
//					TP_EMAIL = TPdata.getTP_MAIL();
//
////					 } 
//				} else {
//					TP_BRANCH = "NA";
//					TP_PHONE = "NA";
//					TP_EMAIL = "NA";
//				}
//				arrayobj.put(0, E_NAME);
//				arrayobj.put(1, E_BRANCH);
//				arrayobj.put(2, E_PHONE);
//				arrayobj.put(3, E_MAIL);
//				arrayobj.put(4, USERNAME);
//				arrayobj.put(5, USERBRANCH);
//				arrayobj.put(6, USERPHONE);
//				arrayobj.put(7, USEREMAIL);
//				arrayobj.put(8, TP_NAME);
//				arrayobj.put(9, TP_EMAIL);
//				arrayobj.put(10, TP_PHONE);
//				arrayobj.put(11, tid);
//				arrayobj.put(12, RAISE_DATE);
//				arrayobj.put(13, ASSIGN_DATE);
//				arrayobj.put(14, COMPANY);
//				arrayobj.put(15, CATEGORY);
//				arrayobj.put(16, SUB_CATEGORY);
//				arrayobj.put(17, SUBJECT);
//				arrayobj.put(18, PRIORITY);
//				arrayobj.put(19, REQUEST_MODE);
//				arrayobj.put(20, DESC);
//				array1.put(arrayobj);
//				//System.out.println("Array Values::::::::" + array1);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return array1;
//	}

	@Override
	public String UpdateReAssignEngTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile resolvePic) 
	{
	
		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String SMSApi = "";
		String loginname = "";
		String loginRoleType="";
		String loginUserCompany = "";
		String raiseTime = null;
		String currenttime = null;
		DateFormat dateFormat = null;
		String fullname = "";
		String emailid = "";
		String phone = "";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginname = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
		
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
		
		///////////////// FILE UPLOAD STARTS //////////////
			String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
			//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println(localdate.format(now));
			String localDateNow=localdate.format(now);
			//String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
			//System.out.println("createnewfilename***" + createnewfilename);
			//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
			
			String ext = "";
			String updatedFileName = null;
			
			
			try {
			String imagefilePath;
			imagefilePath = "C:\\ITHelpDesk\\";
			try {
				File file = new File("C:\\ITHelpDesk\\");
				if (!file.exists()) {
					if (file.mkdir()) {
						//System.out.println("Directory is created!");
					} else {
						//System.out.println("Failed to create directory!");
					}
				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}
			
			//File uploadedFile =  empPic;
			File uploadedFile = new File(resolvePic.getOriginalFilename());
			uploadedFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(uploadedFile);
			fos.write(resolvePic.getBytes());
			fos.close();
			//System.out.println("uploadedFile::::" + uploadedFile);
			String fileName = resolvePic.getOriginalFilename();
			//System.out.println("fileName::::" + fileName);
			ext = FilenameUtils.getExtension(fileName);
			//System.out.println("file_extension::::" + ext);
			// File destFile = new File(imagefilePath + File.separator + fileName);
			File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
			//System.out.println("destFile........" + destFile);
			// //System.out.println("File........" + imagefilePath + File.separator +
			// fileName);
			//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
			updatedFileName = createnewfilename + "." + ext;
			//System.out.println("UPDATED FILE NAME: " + updatedFileName);
			
			try {
				FileUtils.copyFile(uploadedFile, destFile);
				File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				FileInputStream fis = new FileInputStream(filee);
			} catch (IOException ex) {
				//System.out.println("Could not copy file " + fileName);
				status = "error";
				ex.printStackTrace();
			}
			} catch (Exception e) {
			//System.out.println("directory create exception" + e);
			}
			
			///////////////// FILE UPLOAD ENDS //////////////
		
		try {
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			//System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);

			
			String OLD_STATUS="";
			String T_COMPANY="";
			String T_BRANCH="";
			String T_DEPARTMENT="";
			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				List<ticket> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+tid+"'").list();
	    
				for(ticket oldstatus:gettingoldstatus) {
					OLD_STATUS=	oldstatus.getSTATUS();
					
					T_BRANCH=oldstatus.getT_BRANCH();
					T_COMPANY=oldstatus.getT_COMPANY();
					T_DEPARTMENT=	oldstatus.getT_DEPARTMENT();
				}
			
				
			}catch (Exception e) {
				//System.out.println(e);
			}
			
			try {
				List<ticket_resolved> dup = sessionFactory.getCurrentSession().createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				if (dup.isEmpty()) {
					ticket_resolved queryTicketResolvedInsert = new ticket_resolved();
					queryTicketResolvedInsert.setT_ID(tid);
					queryTicketResolvedInsert.setRAISE_DATE(raisedate);
					queryTicketResolvedInsert.setASSIGN_DATE(assigndate);
					queryTicketResolvedInsert.setRESOLVED_DATE(currenttime11);
					queryTicketResolvedInsert.setT_USER_NAME(username);
					queryTicketResolvedInsert.setT_USER_EMAIL(useremail);
					queryTicketResolvedInsert.setT_USER_PHONE(userphone);
					queryTicketResolvedInsert.setT_USER_COMPANY(usercompany);
					queryTicketResolvedInsert.setT_USER_BRANCH(userbranch);
					queryTicketResolvedInsert.setT_CATEGORY(category);
					queryTicketResolvedInsert.setT_SUBCATEGORY1(subcat1);
					queryTicketResolvedInsert.setT_SUBCATEGORY2(subcat2);
					queryTicketResolvedInsert.setT_SUBJECT(sub);
					queryTicketResolvedInsert.setT_DESC(description);
					queryTicketResolvedInsert.setT_PRIORITY(priority);
					queryTicketResolvedInsert.setT_SEVERITY(severity);
					queryTicketResolvedInsert.setT_STATUS(status);
					queryTicketResolvedInsert.setTP_NAME(tcname);
					queryTicketResolvedInsert.setTP_EMAIL(tcemail);
					queryTicketResolvedInsert.setTP_PHONE(tcphone);
					queryTicketResolvedInsert.setA_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_COMPANY(engcompany);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_EMAIL(engemailid);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_PHONE(engphone);
					queryTicketResolvedInsert.setSOLUTION(solution);
					queryTicketResolvedInsert.setT_RESOLVED_TIME(currenttime11);
					queryTicketResolvedInsert.setCLOSEDBY("NA");
					queryTicketResolvedInsert.setCLOSED_DATE(null);
//					queryTicketResolvedInsert.setT_CLOSED_TIME(null);
					getSession().save(queryTicketResolvedInsert);

				} else {
					int f = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_resolved SET A_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_COMPANY='" + engcompany + "',T_STATUS='" + status + "',T_RESOLVED_TIME='" + currenttime11 + "',RESOLVED_DATE='" + currenttime11 + "',SOLUTION='" + solution + "' WHERE T_ID='" + tid + "'").executeUpdate();
			if (f > 0) {
				//System.out.println("update in ticket ticket resolved****");

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				if (status.equals("Hold")) {
//					msg = "Engineer " + engname + " has " + status + " Ticket On " + currenttime;
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";
					
//					int idd = Integer.parseInt(tid);
//					Inv.RaiseNCloseEmailSMS(idd, username, "Hold", userbranch + "," + loginname, category, sub, engname,
//							priority, userphone, useremail);

				} else {
//					msg = "Engineer " + engname + " " + status + " Ticket On " + currenttime + " within "
//							+ raiseTime;
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";

//					int idd = Integer.parseInt(tid);
//					String aa = userbranch + "," + engname;
//					Inv.RaiseNCloseEmailSMS(idd, username, "Resolved", userbranch, category, sub, engname, priority,
//							userphone, useremail);
				}
				ticket_tracking ticket_tracking = new ticket_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserCompany);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setTICKET_RAISED_NAME_COMPANY(usercompany);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				//System.out.println("insert in ticket tracking***");

				int i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket SET STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();

				i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_assigned SET T_STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
			int ActSno = 0;
			try {
			
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();
			
				//System.out.println(" actSrno1 IS: " + actSrno1);
			
				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					//System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					//System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}
			
			List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+loginname+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
			ticket_activity_log ticketActivityLog = new ticket_activity_log();
			
			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setPRIORITY(priority);
			ticketActivityLog.setSEVERITY(severity);
			ticketActivityLog.setSTATUS(status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginname);
			ticketActivityLog.setT_SUBJECT(sub);
			ticketActivityLog.setT_DESC(description);
			ticketActivityLog.setCHANGE_NOTES1(solution);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_CATEGORY(category);
			ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
			ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
			ticketActivityLog.setT_COMPANY(loginUserCompany);
			ticketActivityLog.setT_EMAIL(emailid);
			
			ticketActivityLog.setT_CONTACT_NO(phone);
			ticketActivityLog.setT_FULLNAME(fullname);
			
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}
			
			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
//			int idd = Integer.parseInt(tid);
//			String p = userbranch + "," + loginname;
//			Inv.RaiseNCloseEmailSMS(idd, engname, status, p, category, sub, username, priority, userphone, useremail);
			
	try {
				
				///////////////////////////////////HISTORICAL SLA CODE START///////////////////////////////
				
					
					
					int SRNO1 = 0;
					try {
					
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO"));
						Integer SRNO2 = (Integer) crit.uniqueResult();
					
						//System.out.println(" SRNO1 IS: " + SRNO2);
					
						if (SRNO2 != null) {
							SRNO1 = SRNO2.intValue();
							SRNO1 = SRNO1 + 1;
							//System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
						} else {
							SRNO1 = 1;
							//System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//System.out.println(e);
					}
					
					
					if(OLD_STATUS.equals("Hold") && status.equals("Hold") || OLD_STATUS.equals("Hold") && !status.equals("Hold")  )
					{
						
						//System.out.println("INSIDE BOTH  HOLD  AND  OLD YES OR CURRENT NOT3 " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
				
						  Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO") ).add(Restrictions.eq("TICKET_ID", tid));

						 int maxsrno1=(int) criteriaformax.uniqueResult();
						 
						 //System.out.println("MAX NO is THAT " + maxsrno1);
					
										
							Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_END_DATE=:HOLD_END_DATE ,TICKET_STATUS=:TICKET_STATUS  WHERE SR_NO=:SR_NO");
							updathistoricalsla.setParameter("HOLD_END_DATE", currenttime);
							updathistoricalsla.setParameter("SR_NO",maxsrno1);
							updathistoricalsla.setParameter("TICKET_STATUS",status);
								

							//////////////////////////////CODE FOR FIND ELAPSE AND HOLD DURATION //////////////////////////////
							int check=	updathistoricalsla.executeUpdate();	
				
							
							String GETSTARTHOLDTIME="";
							String GETENDHOLDTIME="";
							//System.out.println("VALUE OF CHECK  " + check);
							if(check!=0) {
								
								//System.out.println("INSIDE ELAPSE IF BLOCK");
								Query QUERYFORBOTHDATE=sessionFactory.getCurrentSession().createQuery("from historical_sla where SR_NO='"+maxsrno1+"'");
								
								List<historical_sla> historicalvalue=QUERYFORBOTHDATE.list();
								for(historical_sla getvalue: historicalvalue) {
									
									GETENDHOLDTIME=	getvalue.getHOLD_END_DATE();
									GETSTARTHOLDTIME=	getvalue.getHOLD_START_DATE();
									
								}
								//System.out.println("GETENDHOLDTIME VALUE  "+ GETENDHOLDTIME);
								//System.out.println("GETSTARTHOLDTIME VALUE  "+ GETSTARTHOLDTIME);
								
								
								 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						            
						              
								  Date stratdate = sdf.parse(GETSTARTHOLDTIME);
						            Date enddate = sdf.parse(GETENDHOLDTIME);
						            
						        long duration = enddate.getTime()- stratdate.getTime();
						  
						           //System.out.println("difference_In_Time is   " + duration);
						          

									int diffInSeconds =(int) TimeUnit.MILLISECONDS.toSeconds(duration);
									long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
									long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
									long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
									
									
									//System.out.println("diffInDays: " + diffInDays);
									//System.out.println("diffInHours: " + diffInHours);
									//System.out.println("diffInMinutes: " + diffInMinutes);
									//System.out.println("diffInSeconds: " + diffInSeconds);
									
									///////////////// START DATE TO END DATE DURATION Starts///////
									int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
									long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
									long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
											- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
									long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
											- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
									
									String day_StartEndDate1 = "";
									String hours_StartEndDate1 = "";
									String minute_StartEndDate1 = "";
									String second_StartEndDate1 = "";

									if (day_StartEndDate != 0) {
										day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
									}
									if (hours_StartEndDate != 0) {
										hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
									}
									if (minute_StartEndDate != 0) {
										minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
									}
									if (second_StartEndDate != 0) {
										second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
									}

									String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
											+ second_StartEndDate1;
									//System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
									//System.out.println(" TOTAL ELAPS TIME  IS  " + diffInSeconds);
						            
						               if(!StartEndDateDuration.isEmpty() && diffInSeconds !=0) {
											
											Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
											updateelapsandduration.setParameter("HOLD_ELAPSED_TIME", Integer.valueOf(diffInSeconds).toString());
											updateelapsandduration.setParameter("SR_NO",maxsrno1);
											updateelapsandduration.setParameter("HOLD_DURATION",StartEndDateDuration);
										int check2=	updateelapsandduration.executeUpdate();
										
										//System.out.println("check2 value "+ check2);
						            	   
						               }
						               
							}

								if(OLD_STATUS.equals("Hold") && status.equals("Hold") ) {
									
									historical_sla historicalsla = new historical_sla();
									
									historicalsla.setSR_NO(SRNO1);
									historicalsla.setTICKET_ID(tid);
								
									historicalsla.setTICKET_STATUS(status);
								
									historicalsla.setSLA_STATUS("NA");
									historicalsla.setHOLD_START_DATE(currenttime);
									historicalsla.setHOLD_END_DATE("NA");
									historicalsla.setHOLD_ELAPSED_TIME("NA");
									
									historicalsla.setHOLD_DURATION("NA");
									
									historicalsla.setT_COMPANY(T_COMPANY);
									historicalsla.setT_BRANCH(T_BRANCH);
									historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
									sessionFactory.getCurrentSession().save(historicalsla);
									
									
								}
							
					}
					
					else if(!OLD_STATUS.equals("Hold") && status.equals("Hold") ){
						
						//System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
						historical_sla historicalsla = new historical_sla();
//						
						historicalsla.setSR_NO(SRNO1);
						historicalsla.setTICKET_ID(tid);
					
						historicalsla.setTICKET_STATUS(status);
					
						historicalsla.setSLA_STATUS("NA");
						historicalsla.setHOLD_START_DATE(currenttime);
						historicalsla.setHOLD_END_DATE("NA");
						historicalsla.setHOLD_ELAPSED_TIME("NA");
						
						historicalsla.setHOLD_DURATION("NA");
						
						historicalsla.setT_COMPANY(T_COMPANY);
						historicalsla.setT_BRANCH(T_BRANCH);
						historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
						sessionFactory.getCurrentSession().save(historicalsla);
				
					}
					
					SMSApi = "success";
				}catch (Exception e) 
				{
				//	status="error";
					//System.out.println(e);
				}
				
			//	status="success";
				
				///////////////////////////////////HISTORICAL SLA CODE END///////////////////////////////

				
	
			
			
			///////////////////// SLA STARTS////////////////////////
			try {
				//System.out.println("SLA STARTS");
				String HoldStartDate = simpleDateFormat.format(tdate);
				//System.out.println("currentHoldStartDate: " + HoldStartDate);
				Date HoldStartDate1 = simpleDateFormat.parse(HoldStartDate);
				//System.out.println("status::::::::" + status);
				String HoldEndDate = simpleDateFormat.format(tdate);
				//System.out.println("currentHoldStartDate: " + HoldEndDate);
				Date HoldEndDate1 = simpleDateFormat.parse(HoldEndDate);
				if (status.equals("Hold")) {
					//System.out.println("INSIDE SLA HOLD");
					Query max = sessionFactory.getCurrentSession()
							.createQuery("from sla WHERE TICKET_ID='" + tid + "'");
					List<sla> l = max.list();
					if (l.isEmpty()) {
						//System.out.println("IN SLA INSERT");
						sla insertSLAObj = new sla();
						insertSLAObj.setTICKET_ID(tid);
						insertSLAObj.setPRIORITY(priority);
						insertSLAObj.setSEVERITY(severity);
						insertSLAObj.setTICKET_STATUS(status);
						insertSLAObj.setSTART_DATE(raisedate);
						insertSLAObj.setSTOP_DATE("NA");
						insertSLAObj.setELAPSED_TIME("NA");
						insertSLAObj.setSLA_TIME("NA");
						insertSLAObj.setSLA_STATUS("NA");
						insertSLAObj.setHOLD_START_DATE(HoldStartDate);
						insertSLAObj.setHOLD_END_DATE("NA");
						insertSLAObj.setHOLD_ELAPSED_TIME("NA");
						insertSLAObj.setSLA_TARGET("NA");
						insertSLAObj.setSTART_END_TIME("NA");
						insertSLAObj.setHOLD_DURATION("NA");
						getSession().save(insertSLAObj);
					} else {
						//System.out.println("IN SLA UPDATE");
						sessionFactory.getCurrentSession().createQuery("UPDATE sla SET PRIORITY='" + priority
								+ "',SEVERITY='" + severity +"',TICKET_STATUS='" + status + "',START_DATE='" + raisedate
								+ "',STOP_DATE='NA',ELAPSED_TIME='NA',SLA_TIME='NA',SLA_STATUS='NA',HOLD_START_DATE='"
								+ HoldStartDate + "',HOLD_END_DATE='NA',HOLD_ELAPSED_TIME='NA' WHERE TICKET_ID='"
								+ tid + "'").executeUpdate();
					}
				} else if (status.equals("Resolved")) {
					//System.out.println("IN STATUS RESOLVED FOR REASSIGNED TICKETS");
					//System.out.println("SLA STARTS");

					String holdstartdate12 = null;

					Query query5 = sessionFactory.getCurrentSession()
							.createQuery("from sla WHERE TICKET_ID='"+tid+"'");
					sla sla5 = (sla) query5.uniqueResult();
					if (sla5 != null) {
						//System.out.println("IN SLA NOT NULL");
						holdstartdate12 = sla5.getHOLD_START_DATE();
						//System.out.println("HOLD START DATE: " + holdstartdate12);
					}
					//System.out.println("HOLD START DATE*********: " + holdstartdate12);

					if (holdstartdate12 != null) {
						String StartDate12 = holdstartdate12;
						Date HoldStartDate123 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(StartDate12);
						//System.out.println("HOLD START DATE: " + HoldStartDate);

						SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						Date tdate1 = new Date();
						String HoldEndDate12 = simpleDateFormat1.format(tdate1);
						//System.out.println("HOLD END DATE: " + HoldEndDate12);
						Date HoldEndDate123 = simpleDateFormat1.parse(HoldEndDate12);

						Date startDate12 = HoldStartDate123;// Set start date
						Date endDate12 = HoldEndDate1;// Set end date
						long duration = endDate12.getTime() - startDate12.getTime();

						long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
						long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
						long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
						long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

						//System.out.println("diffInDays: " + diffInDays);
						//System.out.println("diffInHours: " + diffInHours);
						//System.out.println("diffInMinutes: " + diffInMinutes);
						//System.out.println("diffInSeconds: " + diffInSeconds);

						String diffInSecondsToString = String.valueOf(diffInSeconds);

						Query query11 = sessionFactory.getCurrentSession()
								.createQuery("from sla where TICKET_ID='"+tid+"'");
						sla sla4 = (sla) query11.uniqueResult();
						if (sla4 != null) {
							//System.out.println("IN SLA UPDATE");

							Query query12 = sessionFactory.getCurrentSession().createQuery(
									"update sla set PRIORITY=:PRIORITY,SEVERITY=:SEVERITY,TICKET_STATUS=:TICKET_STATUS,START_DATE=:START_DATE,STOP_DATE=:STOP_DATE,ELAPSED_TIME=:ELAPSED_TIME,SLA_TIME=:SLA_TIME,SLA_STATUS=:SLA_STATUS,HOLD_START_DATE=:HOLD_START_DATE,HOLD_END_DATE=:HOLD_END_DATE,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME WHERE TICKET_ID=:TICKET_ID");

							query12.setParameter("PRIORITY", priority);
							query12.setParameter("SEVERITY", severity);
							query12.setParameter("TICKET_STATUS", status);
							query12.setParameter("START_DATE", raisedate);
							query12.setParameter("STOP_DATE", "NA");
							query12.setParameter("ELAPSED_TIME", "NA");
							query12.setParameter("SLA_TIME", "NA");
							query12.setParameter("SLA_STATUS", "NA");
							query12.setParameter("HOLD_START_DATE", holdstartdate12);
							query12.setParameter("HOLD_END_DATE", HoldEndDate12);
							query12.setParameter("HOLD_ELAPSED_TIME", diffInSecondsToString);
							query12.setParameter("TICKET_ID", tid);

							query12.executeUpdate();

						} else {
							//System.out.println("IN SLA INSERT");

							sla slainsert = new sla();

							slainsert.setTICKET_ID(tid);
							slainsert.setPRIORITY(priority);
							slainsert.setSEVERITY(severity);
							slainsert.setTICKET_STATUS(status);
							slainsert.setSTART_DATE(raisedate);
							slainsert.setSTOP_DATE("NA");
							slainsert.setELAPSED_TIME("NA");
							slainsert.setSLA_TIME("NA");
							slainsert.setSLA_STATUS("NA");
							slainsert.setHOLD_START_DATE(holdstartdate12);
							slainsert.setHOLD_END_DATE(HoldEndDate12);
							slainsert.setHOLD_ELAPSED_TIME(diffInSecondsToString);
							slainsert.setSLA_TARGET("NA");
							slainsert.setSTART_END_TIME("NA");
							slainsert.setHOLD_DURATION("NA");

							sessionFactory.getCurrentSession().save(slainsert);

						}
					}
				}
				SMSApi = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
					//////////////////////////SLA ENDS FOR
			////////////////////////// UpdateReAssignEngTickets/////////////////////
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(SMSApi.equals("success"))
			Inv.EmailSMSTriggered(tid, status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return SMSApi;
	}
	
	

	@Override
	public JSONArray getResolvedTickets(String LoginUser) {
		//System.out.println("INSIDE getResolvedTickets");
		JSONArray array = null;
		JSONArray array1 = null;
		String loginUserCompany="";
		List<Object[]> queryTicket1=null;
		int srno = 0;
		String newid="";
		String output = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
//			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
//			LoginScope = session.getAttribute("loginscope").toString();
//			//System.out.println("username****" + LoginUser);
//			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {

			List<String> ticket_id = sessionFactory.getCurrentSession().createQuery("select T_ID from ticket where STATUS='Resolved' and VIP_TICKET!='true'").list();
//System.out.println("TICKET ID: "+ticket_id);

for (int counter = 0; counter < ticket_id.size(); counter++) { 		      
    //System.out.println( "value of new id "+  ticket_id.get(counter)); 	
    
//    String  bb=ticket_id.get(counter);
    
   newid=newid.concat( "'"+ticket_id.get(counter)+"',");
   
 // newid.concat(str)
}
String NewTicketListTemp=newid;
String NewTicketListFinal="";
if (NewTicketListTemp.endsWith(",")) {
	NewTicketListFinal=NewTicketListTemp.substring(0, NewTicketListTemp.length() - 1);
	
	}
//System.out.println("FINAL TICKET LIST: "+NewTicketListFinal);
 queryTicket1 = sessionFactory.getCurrentSession()
		.createSQLQuery("select tr.T_ID ,tr.T_STATUS ,tr.T_PRIORITY,tr.T_SEVERITY,tr.T_SUBJECT,ta.T_COMPANY,ta.T_BRANCH,ta.T_DEPARTMENT,tr.T_CATEGORY,tr.T_SUBCATEGORY1,tr.T_SUBCATEGORY2,ta.TP_NAME,COALESCE(ta.TP_FULLNAME,'NA'),ta.ENGINEER_GROUP,ta.ENGINEER_NAME,COALESCE(ta.ENGINEER_FULLNAME,'NA'),tr.RESOLVED_ENGINEER_NAME as RESOLVED_ENGINEER_NAME,COALESCE(tr.RESOLVED_ENGINEER_FULLNAME,'NA'),tr.RAISE_DATE,ta.T_ASSIGN_DATE,tr.RESOLVED_DATE  as RESOLVED_DATE ,tr.RESOLVED_ENGINEER_COMPANY AS RESOLVED_ENGINEER_COMPANY,ta.T_ASSIGN_TO  from TICKET_RESOLVED as tr join ticket_assigned ta on ta.T_ID=tr.T_ID  where tr.T_STATUS='Resolved' and (RESOLVED_ENGINEER_NAME='"+LoginUser+"' and RESOLVED_ENGINEER_COMPANY='"+loginUserCompany+"') AND tr.T_ID IN ("+NewTicketListFinal+")  order by  STR_TO_DATE(RESOLVED_DATE ,'%d-%m-%Y %H:%i:%s') desc ").list();

		
////System.out.println("TICKET ID: "+ticket_id);
			/*
			 * Criteria queryTicket1 =
			 * sessionFactory.getCurrentSession().createCriteria(ticket_resolved.class);
			 * queryTicket1.add(Restrictions.eq("RESOLVED_ENGINEER_NAME", LoginUser));
			 * queryTicket1.add(Restrictions.eq("T_STATUS", "Resolved"));
			 * queryTicket1.add(Restrictions.in("T_ID", ticket_id));
			 * queryTicket1.addOrder(Order.desc("RESOLVED_DATE")); List<ticket_resolved>
			 * dataSet = queryTicket1.list();
			 */
			
			
			array = new JSONArray();
			for (Object[] listdata : queryTicket1) {
				srno = srno + 1;
				array1 = new JSONArray();
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ listdata[0] + "\")'><i class='fa fa-eye'></i></button>");
						
				array1.put(listdata[0]);
				array1.put(listdata[1]);
				array1.put(listdata[2]);
				array1.put(listdata[3]);
				array1.put(listdata[4]);
				array1.put(listdata[5]);
				array1.put(listdata[6]);
				array1.put(listdata[7]);
				array1.put(listdata[8]);
				array1.put(listdata[9]);
				array1.put(listdata[10]);
				array1.put(listdata[11]);
				array1.put(listdata[12]);
				if(listdata[22].equals("Engineer"))
				{
					array1.put(listdata[14]);
				}
				else
				{
					array1.put(listdata[13]);
				}
				array1.put(listdata[15]);
				array1.put(listdata[16]);
				array1.put(listdata[17]);
				array1.put(listdata[18]);
				array1.put(listdata[19]);
				array1.put(listdata[20]);
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}
	
	@Override
	public JSONArray getResolvedVIPTickets(String LoginUser) {
		//System.out.println("INSIDE getResolvedVIPTickets");
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String loginUserCompany = "";
		String newid="";
		List<Object[]> queryTicket1=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
//			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
//			LoginScope = session.getAttribute("loginscope").toString();
//			//System.out.println("username****" + LoginUser);
//			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {

			List<String> ticket_id = sessionFactory.getCurrentSession()
					.createQuery("select T_ID from ticket where STATUS='Resolved' and VIP_TICKET='true'").list();
			//System.out.println("TICKET ID: "+ticket_id);
			for (int counter = 0; counter < ticket_id.size(); counter++) { 		      
			    //System.out.println( "value of new id "+  ticket_id.get(counter)); 	
			    newid=newid.concat( "'"+ticket_id.get(counter)+"',");
			}
			String NewTicketListTemp=newid;
			String NewTicketListFinal="";
			if (NewTicketListTemp.endsWith(",")) {
				NewTicketListFinal=NewTicketListTemp.substring(0, NewTicketListTemp.length() - 1);
				
			}
			//System.out.println("FINAL TICKET LIST: "+NewTicketListFinal);
//			Criteria queryTicket1 = sessionFactory.getCurrentSession().createCriteria(ticket_resolved.class);
//			queryTicket1.add(Restrictions.eq("RESOLVED_ENGINEER_NAME", LoginUser));
//			queryTicket1.add(Restrictions.eq("RESOLVED_ENGINEER_COMPANY", loginUserCompany));
//			queryTicket1.add(Restrictions.eq("T_STATUS", "Resolved"));
//			queryTicket1.add(Restrictions.in("T_ID", ticket_id));
//			queryTicket1.addOrder(Order.desc("RESOLVED_DATE"));
//			List<ticket_resolved> dataSet = queryTicket1.list();
			
			queryTicket1 = sessionFactory.getCurrentSession().createSQLQuery("select tr.T_ID ,tr.T_STATUS ,tr.T_PRIORITY,tr.T_SEVERITY,tr.T_SUBJECT,ta.T_COMPANY,ta.T_BRANCH,ta.T_DEPARTMENT,tr.T_CATEGORY,tr.T_SUBCATEGORY1,tr.T_SUBCATEGORY2,ta.TP_NAME,COALESCE(ta.TP_FULLNAME,'NA'),ta.ENGINEER_GROUP,ta.ENGINEER_NAME,COALESCE(ta.ENGINEER_FULLNAME,'NA'),tr.RESOLVED_ENGINEER_NAME as RESOLVED_ENGINEER_NAME,COALESCE(tr.RESOLVED_ENGINEER_FULLNAME,'NA'),tr.RAISE_DATE,ta.T_ASSIGN_DATE,tr.RESOLVED_DATE  as RESOLVED_DATE ,tr.RESOLVED_ENGINEER_COMPANY AS RESOLVED_ENGINEER_COMPANY,ta.T_ASSIGN_TO  from ticket_resolved as tr join ticket_assigned ta on ta.T_ID=tr.T_ID  where tr.T_STATUS='Resolved' and (RESOLVED_ENGINEER_NAME='"+LoginUser+"' and RESOLVED_ENGINEER_COMPANY='"+loginUserCompany+"') AND tr.T_ID IN ("+NewTicketListFinal+")  order by  STR_TO_DATE(RESOLVED_DATE ,'%d-%m-%Y %H:%i:%s') desc ").list();


			array = new JSONArray();
			for (Object[] listdata : queryTicket1) {
				srno = srno + 1;
				array1 = new JSONArray();
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ listdata[0]+ "\")'><i class='fa fa-eye'></i></button>");

				array1.put(listdata[0]);
				array1.put(listdata[1]);
				array1.put(listdata[2]);
				array1.put(listdata[3]);
				array1.put(listdata[4]);
				array1.put(listdata[5]);
				array1.put(listdata[6]);
				array1.put(listdata[7]);
				array1.put(listdata[8]);
				array1.put(listdata[9]);
				array1.put(listdata[10]);
				array1.put(listdata[11]);
				array1.put(listdata[12]);
				if(listdata[22].equals("Engineer"))
				{
					array1.put(listdata[14]);
				}
				else
				{
					array1.put(listdata[13]);
				}
				array1.put(listdata[15]);
				array1.put(listdata[16]);
				array1.put(listdata[17]);
				array1.put(listdata[18]);
				array1.put(listdata[19]);
				array1.put(listdata[20]);
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}
	

//	@Override
//	public JSONArray getClosedTickets(String LoginUser) {
//		JSONArray array = null;
//		JSONArray array1 = null;
//		int srno = 0;
//		String output = "";
//		String ASSIGNED_ENGINEER_NAME = "NA";
//		String ASSIGNED_ENGINEER_DATE = "NA";
//		try {
//			array1 = new JSONArray();
//			List<ticket_assigned> dataSet1 = sessionFactory.getCurrentSession()
//					.createSQLQuery("FROM TICKET_ASSIGNED WHERE T_USER_NAME ='" + LoginUser
//							+ "' AND T_STATUS='Closed' ORDER BY T_CLOSEDATE DESC")
//					.list();
//			try {
//				for (ticket_assigned newObj : dataSet1) {
//					ASSIGNED_ENGINEER_NAME = newObj.getENGINEER_NAME();
//					ASSIGNED_ENGINEER_DATE = newObj.getASSIGN_DATE();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			List<Object[]> dataSet = sessionFactory.getCurrentSession().createSQLQuery(
//					"Select * FROM (select T_ID,T_SUBJECT,T_CATEGORY,T_SUBCATEGORY,T_PRIORITY,T_STATUS as status1,T_USER_NAME as username,TP_NAME as tpname,A_ENGINEER_NAME,RESOLVED_ENGINEER_NAME,CLOSEDBY,RAISE_DATE,ASSIGN_DATE,RESOLVED_DATE,CLOSED_DATE from TICKET_RESOLVED UNION  select A.T_ID,A.T_SUBJECT,A.T_CATEGORY,A.T_SUBCATEGORY,A.T_PRIORITY,A.T_STATUS as status1,A.T_USER_NAME as username,A.TP_NAME,A.ENGINEER_NAME,'NA',A.T_CLOSEBY,A.RAISE_DATE,A.ASSIGN_DATE,'NA',A.T_CLOSEDATE from TICKET_ASSIGNED A WHERE NOT EXISTS(SELECT B.T_ID FROM TICKET_RESOLVED B where A.T_ID=B.T_ID) )inn WHERE A_ENGINEER_NAME ='"
//							+ LoginUser + "' AND status1='Closed' ORDER BY T_ID DESC")
//					.list();
//			for (Object[] newObj : dataSet) {
//
//				array = new JSONArray();
//				array.put(
//						"<button class='btn btn-info' data-toggle='modal' data-target='#modelCompany' onclick='ViewTicket("
//								+ newObj[0].toString() + ")'><i class='fa fa-eye'></i></button>");
////               array.put("<button class='btn btn-danger' id='deletesms'  name='Doem' onclick='deleteTicket(" + newObj[0].toString() + ")'><i class='fa fa-trash'></i></button>");
//				array.put(newObj[0].toString());
//
//				if ((newObj[1].toString()) == null || (newObj[1].toString()).contains("null")
//						|| (newObj[1].toString()).equalsIgnoreCase("null") || (newObj[1].toString()) == " "
//						|| (newObj[1].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[1].toString());
//				}
//				if ((newObj[2].toString()) == null || (newObj[2].toString()).contains("null")
//						|| (newObj[2].toString()).equalsIgnoreCase("null") || (newObj[2].toString()) == ""
//						|| (newObj[2].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[2].toString());
//				}
//				if ((newObj[3].toString()) == null || (newObj[3].toString()).contains("null")
//						|| (newObj[3].toString()).equalsIgnoreCase("null") || (newObj[3].toString()) == " "
//						|| (newObj[3].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[3].toString());
//				}
//				if ((newObj[4].toString()) == null || (newObj[4].toString()).contains("null")
//						|| (newObj[4].toString()).equalsIgnoreCase("null") || (newObj[4].toString()) == " "
//						|| (newObj[4].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[4].toString());
//				}
//				if ((newObj[5].toString()) == null || (newObj[5].toString()).contains("null")
//						|| (newObj[5].toString()).equalsIgnoreCase("null") || (newObj[5].toString()) == " "
//						|| (newObj[5].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[5].toString());
//				}
//				if ((newObj[6].toString()) == null || (newObj[6].toString()).contains("null")
//						|| (newObj[6].toString()).equalsIgnoreCase("null") || (newObj[6].toString()) == " "
//						|| (newObj[6].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[6].toString());
//				}
//				if ((newObj[7].toString()) == null || (newObj[7].toString()).contains("null")
//						|| (newObj[7].toString()).equalsIgnoreCase("null") || (newObj[7].toString()) == " "
//						|| (newObj[7].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[7].toString());
//				}
//				if ((newObj[8].toString()) == null || (newObj[8].toString()).contains("null")
//						|| (newObj[8].toString()).equalsIgnoreCase("null") || (newObj[8].toString()) == " "
//						|| (newObj[8].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[8].toString());
//				}
//				if ((newObj[9].toString()) == null || (newObj[9].toString()).contains("null")
//						|| (newObj[9].toString()).equalsIgnoreCase("null") || (newObj[9].toString()) == " "
//						|| (newObj[9].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[9].toString());
//				}
//				if ((newObj[10].toString()) == null || (newObj[10].toString()).contains("null")
//						|| (newObj[10].toString()).equalsIgnoreCase("null") || (newObj[10].toString()) == " "
//						|| (newObj[10].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[10].toString());
//				}
//				if ((newObj[11].toString()) == null || (newObj[11].toString()).contains("null")
//						|| (newObj[11].toString()).equalsIgnoreCase("null") || (newObj[11].toString()) == " "
//						|| (newObj[11].toString()) == "") {
//					array.put(ASSIGNED_ENGINEER_DATE);
//				} else {
//					array.put(newObj[11].toString());
//				}
//				if ((newObj[12].toString()) == null || (newObj[12].toString()).contains("null")
//						|| (newObj[12].toString()).equalsIgnoreCase("null") || (newObj[12].toString()) == " "
//						|| (newObj[12].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[12].toString());
//				}
//				if ((newObj[13].toString()) == null || (newObj[13].toString()).contains("null")
//						|| (newObj[13].toString()).equalsIgnoreCase("null") || (newObj[13].toString()) == " "
//						|| (newObj[13].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[13].toString());
//				}
//				if ((newObj[14].toString()) == null || (newObj[14].toString()).contains("null")
//						|| (newObj[14].toString()).equalsIgnoreCase("null") || (newObj[14].toString()) == " "
//						|| (newObj[14].toString()) == "") {
//					array.put("NA");
//				} else {
//					array.put(newObj[14].toString());
//				}
//				array1.put(array);
//			}
//			//System.out.println("arrray111" + array1);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			//System.out.println("Exception In tryyy branch" + array1);
//		}
//		return array1;
//	}

	//rohit tiger
	@Override
	public JSONArray getHoldTickets() {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggGroup = "";
		String LoginUser = "";
		String loginUserCompany = "";
		String ASSIGNED_ENGINEER_NAME = "NA";
		String ASSIGNED_ENGINEER_DATE = "NA";
		
		try {
			String LoginScope = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				LoginScope = session.getAttribute("loginscope").toString();
				//System.out.println("username****" + LoginUser);
				//System.out.println("LoginScope****" + LoginScope);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
			for (loginmaster loginObj : loginset) {
				enggGroup=loginObj.getGROUP_NAME().replace(",", "','");
			}
			
			Query getData = sessionFactory.getCurrentSession().createSQLQuery("select * from (SELECT ta.T_ID,ta.T_STATUS STATUS,ta.T_PRIORITY as priority,ta.T_PRIORITY as severity,ta.T_SUBJECT as subject,ta.T_COMPANY as T_COMPANY,ta.T_BRANCH as T_BRANCH,ta.T_DEPARTMENT as T_DEPARTMENT,ta.T_CATEGORY as cat,ta.T_SUBCATEGORY1 as cat1,ta.T_SUBCATEGORY2 as cat2,COALESCE(ta.TP_NAME,'NA') as tc,COALESCE(ta.TP_FULLNAME,'NA') as tc_fullname,COALESCE(ta.ENGINEER_NAME,'NA') as ENGINEER_NAME,COALESCE(ta.ENGINEER_FULLNAME,'NA') as engfull,COALESCE(tr.RESOLVED_ENGINEER_NAME,'NA') as RESOLVED_ENGINEER_NAME,COALESCE(tr.RESOLVED_ENGINEER_FULLNAME,'NA') rfullname,COALESCE(ta.T_RAISE_DATE,'NA') as raise,COALESCE(ta.T_ASSIGN_DATE,'NA') as T_ASSIGN_DATE,COALESCE(tr.RESOLVED_DATE,'NA')as resolved_date,ta.ENGINEER_COMPANY as ENGINEER_COMPANY, ta.VIP_TICKET AS VIP_TICKET, ta.ENGINEER_GROUP AS ENGINEER_GROUP,ta.T_ASSIGN_TO FROM ticket_assigned ta left  JOIN  ticket_resolved tr ON ta.T_ID=tr.T_ID)as d where STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare') AND (VIP_TICKET!='true' OR VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR (ENGINEER_GROUP IN('"+enggGroup+"') and STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare'))) ORDER BY STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s') DESC");
			List<Object[]> listofHoldTicket=getData.list();
//			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession()
//			.createQuery( from ticket_assigned  Where T_STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare') AND (VIP_TICKET!='true' OR VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR (ENGINEER_GROUP IN('"+enggGroup+"') and T_STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare'))) ORDER BY STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s') DESC").list();
	array = new JSONArray();
	for (Object [] newObj : listofHoldTicket) {
		array1 = new JSONArray();

		array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""+ newObj[0].toString()+ "\")'><i class='fa fa-eye'></i></button>");
		array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='ResolveTicket(\""+ newObj[0].toString() + "\")'><i class='fa fa-edit'></i></button>");


		array1.put(newObj[0].toString());
array1.put(newObj[1].toString());
array1.put(newObj[2].toString());
array1.put(newObj[3].toString());
array1.put(newObj[4].toString());
array1.put(newObj[5].toString());
array1.put(newObj[6].toString());
array1.put(newObj[7].toString());
array1.put(newObj[8].toString());
array1.put(newObj[9].toString());
array1.put(newObj[10].toString());
array1.put(newObj[11].toString());

array1.put(newObj[12].toString());

if(newObj[23].toString().equals("Engineer"))
{
	array1.put(newObj[13].toString());
}
else
{
	array1.put(newObj[22].toString());
}

array1.put(newObj[14].toString());

array1.put(newObj[15].toString());
array1.put(newObj[16].toString());
array1.put(newObj[17].toString());

array1.put(newObj[18].toString());
if(newObj[19].toString().equals("NA"))
{
	array1.put(newObj[18].toString());
}
else
{
	array1.put(newObj[19].toString());
}
	
//array1.put(newObj[19].toString());
//
		array.put(array1);
	}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

//	@Override
//	public JSONArray EditHoldTickets(String tid, String LoginUser) {
//		int ticketid = 0;
//		String raisedate = "NA";
//		String assigndate = "NA";
//		String priority = "NA";
//		String username = "NA";
//		String usermail = "NA";
//		String userphone = "NA";
//		String userbranch = "NA";
//		String tpname = "NA";
//		String tpemail = "NA";
//		String tpphone = "NA";
//		String usercompany = "NA";
//		String category = "NA";
//		String subcat = "NA";
//		String sub = "NA";
//		String sol = "NA";
//		String desc = "NA";
//		String status = "NA";
//		String engname = "NA";
//		String engemail = "NA";
//		String engbranch = "NA";
//		String engphone = "NA";
//		String current_datee = "";
//		String output = "";
//		String requestmode = "";
//		JSONArray array = null;
//		JSONArray array1 = null;
//		try {
//			
//			List<ticket_assigned> ticketassigneddata = sessionFactory.getCurrentSession()
//					.createQuery("from ticket_assigned where T_ID=" + tid).list();
//			List<enggmaster> enggdata = sessionFactory.getCurrentSession()
//					.createQuery("from enggmaster where E_NAME='" + LoginUser + "'").list();
//			List<ticket> ticketList = sessionFactory.getCurrentSession()
//					.createQuery("from ticket where T_ID=" + tid).list();
//			List<ticket_resolved> ticketresolveddata = sessionFactory.getCurrentSession()
//					.createQuery("from ticket_resolved where T_ID=" + tid).list();
//			
//			array1 = new JSONArray();
//			
//			for (ticket_assigned TAssign : ticketassigneddata) {
//
//				for (enggmaster EngData : enggdata) {
//					
//					for (ticket TicketData : ticketList) {
//
//							JSONObject arrayobj = new JSONObject();
//														
//							arrayobj.put("raisedate", TAssign.getT_RAISE_DATE());
//							arrayobj.put("assigndate", TAssign.getT_ASSIGN_DATE());
//							arrayobj.put("priority", TAssign.getT_PRIORITY());
//							arrayobj.put("username", TAssign.getT_USER_NAME());
//							arrayobj.put("usermail", TAssign.getT_USER_EMAIL());
//							arrayobj.put("userphone", TAssign.getT_USER_PHONE());
//							arrayobj.put("userbranch", TAssign.getT_USER_BRANCH());
//							arrayobj.put("tpname", TAssign.getTP_NAME());
//							arrayobj.put("tpemail", TAssign.getTP_EMAIL());
//							arrayobj.put("tpphone", TAssign.getTP_PHONE());
//							
//							arrayobj.put("usercompany", TAssign.getT_USER_COMPANY());
//							arrayobj.put("category", TAssign.getT_CATEGORY());
//							arrayobj.put("subcat", TAssign.getT_SUBCATEGORY());
//							arrayobj.put("sub", TAssign.getT_SUBJECT());
//
//							arrayobj.put("desc", TAssign.getT_DESC());
//							arrayobj.put("status", TAssign.getT_STATUS());
//							arrayobj.put("engname", EngData.getE_NAME());
//							arrayobj.put("engbranch", EngData.getE_BRANCH());
//							arrayobj.put("engemail", EngData.getE_MAIL());
//							arrayobj.put("engphone", EngData.getE_PHONE());
//							arrayobj.put("tid", TicketData.getT_ID());
//							arrayobj.put("requestmode", TicketData.getREQUEST_MODE());
//							arrayobj.put("resolveddate", "NA");
//							
//							for (ticket_resolved TResolved : ticketresolveddata) {
//							if(TResolved.getSOLUTION().equals(null) || TResolved.getSOLUTION().equals("")) {
//								arrayobj.put("sol", "NA");
//							}else {
//								arrayobj.put("sol", TResolved.getSOLUTION());
//							}
//							}				
//							array1.put(arrayobj);
//						
//					}
//					
//				}
//			}
//			//System.out.println("ARRAY1: "+array1);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return array1;
//	}

	@Override
	public String UpdateHoldTickets(String tid, String status, String engname, String engcompany, String engsite, String engemailid, String engphone,String username, String usercompany, String userbranch, String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority, String severity, String sub, String description, String category, String subcat1, String subcat2, String solution, MultipartFile holdPic)
	{

		//System.out.println("IN UPDATE HOLD TICKETS");
		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String SMSApi = "";
		DateFormat dateFormat = null;
		String loginname="";
		String loginRoleType="";
		String loginUserCompany="";

		String fullname = "";
			String emailid = "";
			String phone = "";

//		String currenttime = null;
		
		///////////////// FILE UPLOAD STARTS //////////////
		String fileNameWithOutExt = FilenameUtils.removeExtension(holdPic.getOriginalFilename());
		//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(localdate.format(now));
		String localDateNow=localdate.format(now);
		//String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
		//System.out.println("createnewfilename***" + createnewfilename);
		//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
		
		String ext = "";
		String updatedFileName = null;
		try {
		String imagefilePath;
		imagefilePath = "C:\\ITHelpDesk\\";
		try {
		File file = new File("C:\\ITHelpDesk\\");
		if (!file.exists()) {
			if (file.mkdir()) {
				//System.out.println("Directory is created!");
			} else {
				//System.out.println("Failed to create directory!");
			}
		}
		} catch (Exception e) {
		//System.out.println("directory create exception" + e);
		}
		
		//File uploadedFile =  empPic;
		File uploadedFile = new File(holdPic.getOriginalFilename());
		uploadedFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(uploadedFile);
		fos.write(holdPic.getBytes());
		fos.close();
		//System.out.println("uploadedFile::::" + uploadedFile);
		String fileName = holdPic.getOriginalFilename();
		//System.out.println("fileName::::" + fileName);
		ext = FilenameUtils.getExtension(fileName);
		//System.out.println("file_extension::::" + ext);
		//File destFile = new File(imagefilePath + File.separator + fileName);
		File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
		//System.out.println("destFile........" + destFile);
		////System.out.println("File........" + imagefilePath + File.separator +
		//fileName);
		//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
		updatedFileName = createnewfilename + "." + ext;
		//System.out.println("UPDATED FILE NAME: " + updatedFileName);
		
		try {
		FileUtils.copyFile(uploadedFile, destFile);
		File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
		FileInputStream fis = new FileInputStream(filee);
		} catch (IOException ex) {
		//System.out.println("Could not copy file " + fileName);
		status = "error";
		ex.printStackTrace();
		}
		} catch (Exception e) {
		//System.out.println("directory create exception" + e);
		}
		
		///////////////// FILE UPLOAD ENDS //////////////
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginname = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			//System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			
			
			
			String OLD_STATUS="";
			String T_COMPANY="";
			String T_BRANCH="";
			String T_DEPARTMENT="";
			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				List<ticket> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+tid+"'").list();
	    
				for(ticket oldstatus:gettingoldstatus) {
					OLD_STATUS=	oldstatus.getSTATUS();
					
					T_BRANCH=oldstatus.getT_BRANCH();
					T_COMPANY=oldstatus.getT_COMPANY();
					T_DEPARTMENT=	oldstatus.getT_DEPARTMENT();
				}
			
				
			}catch (Exception e) {
				//System.out.println(e);
			}
			try {
				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				if (dup.isEmpty() ) {
					ticket_resolved queryTicketResolvedInsert = new ticket_resolved();
					queryTicketResolvedInsert.setT_ID(tid);
					queryTicketResolvedInsert.setRAISE_DATE(raisedate);
					queryTicketResolvedInsert.setASSIGN_DATE(assigndate);
					queryTicketResolvedInsert.setRESOLVED_DATE(currenttime11);
					queryTicketResolvedInsert.setT_USER_NAME(username);
					queryTicketResolvedInsert.setT_USER_EMAIL(useremail);
					queryTicketResolvedInsert.setT_USER_PHONE(userphone);
					queryTicketResolvedInsert.setT_USER_COMPANY(usercompany);
					queryTicketResolvedInsert.setT_USER_BRANCH(userbranch);
					queryTicketResolvedInsert.setT_CATEGORY(category);
					queryTicketResolvedInsert.setT_SUBCATEGORY1(subcat1);
					queryTicketResolvedInsert.setT_SUBCATEGORY2(subcat2);
					queryTicketResolvedInsert.setT_SUBJECT(sub);
					queryTicketResolvedInsert.setT_DESC(description);
					queryTicketResolvedInsert.setT_PRIORITY(priority);
					queryTicketResolvedInsert.setT_SEVERITY(severity);
					queryTicketResolvedInsert.setT_STATUS(status);
					queryTicketResolvedInsert.setTP_NAME(tcname);
					queryTicketResolvedInsert.setTP_EMAIL(tcemail);
					queryTicketResolvedInsert.setTP_PHONE(tcphone);
					queryTicketResolvedInsert.setA_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_COMPANY(engcompany);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_EMAIL(engemailid);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_PHONE(engphone);
					queryTicketResolvedInsert.setSOLUTION(solution);
					queryTicketResolvedInsert.setT_RESOLVED_TIME(currenttime11);
					queryTicketResolvedInsert.setCLOSEDBY("NA");
					queryTicketResolvedInsert.setCLOSED_DATE(null);
//					queryTicketResolvedInsert.setT_CLOSED_TIME(null);
					getSession().save(queryTicketResolvedInsert);

				} else {
					int f = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_resolved SET A_ENGINEER_NAME='" + loginname+ "',RESOLVED_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_COMPANY='" + engcompany + "',T_STATUS='" + status+ "',T_RESOLVED_TIME='" + currenttime11 + "',RESOLVED_DATE='" + currenttime11+ "',SOLUTION='" + solution + "' WHERE T_ID='" + tid + "'").executeUpdate();
					if (f > 0) {
						//System.out.println("update in ticket ticket resolved****");

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession().createQuery("select max(SR_NO) from ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				if (status.equals("Hold")) {
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime11+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";
					
//					int idd = Integer.parseInt(tid);
//					Inv.RaiseNCloseEmailSMS(idd, username, "Hold", userbranch + "," + loginname, category, sub, engname,
//							priority, userphone, useremail);

				} else {
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime11+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"</td></tr>";

//					int idd = Integer.parseInt(tid);
//					String aa = userbranch + "," + engname;
//					Inv.RaiseNCloseEmailSMS(idd, username, "Resolved", userbranch, category, sub, engname, priority,
//							userphone, useremail);
				}
				ticket_tracking ticket_tracking = new ticket_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime11);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserCompany);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setTICKET_RAISED_NAME_COMPANY(usercompany);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime11);
				
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				//System.out.println("insert in ticket tracking***");

				int i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket SET STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();

				i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_assigned SET T_STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
			int ActSno = 0;
			try {
			
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();
			
				//System.out.println(" actSrno1 IS: " + actSrno1);
			
				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					//System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					//System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}
			
			List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+loginname+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
			ticket_activity_log ticketActivityLog = new ticket_activity_log();
			
			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setPRIORITY(priority);
			ticketActivityLog.setSEVERITY(severity);
			ticketActivityLog.setSTATUS(status);
			ticketActivityLog.setT_DATETIME(currenttime11);
			ticketActivityLog.setT_CHANGEBY(loginname);
			ticketActivityLog.setT_SUBJECT(sub);
			ticketActivityLog.setT_DESC(description);
			ticketActivityLog.setCHANGE_NOTES1(solution);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_CATEGORY(category);
			ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
			ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
			
			ticketActivityLog.setT_COMPANY(loginUserCompany);
			ticketActivityLog.setT_EMAIL(emailid);
			
			ticketActivityLog.setT_CONTACT_NO(phone);
			ticketActivityLog.setT_FULLNAME(loginname);
			

			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}
			
			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			} catch (Exception e) {
				e.printStackTrace();
				SMSApi = "fail";
			}
//			int idd = Integer.parseInt(tid);
//			Inv.RaiseNCloseEmailSMS(idd, username, status, userbranch, category, sub, engname, priority, engphone,
//					engemailid);
			
			

			
			///////////////////////////////////HISTORICAL SLA CODE START///////////////////////////////
			try {
				
				
				int SRNO1 = 0;
				try {
				
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO"));
					Integer SRNO2 = (Integer) crit.uniqueResult();
				
					//System.out.println(" SRNO1 IS: " + SRNO2);
				
					if (SRNO2 != null) {
						SRNO1 = SRNO2.intValue();
						SRNO1 = SRNO1 + 1;
						//System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
					} else {
						SRNO1 = 1;
						//System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				
				
				if(OLD_STATUS.equals("Hold") && status.equals("Hold") || OLD_STATUS.equals("Hold") && !status.equals("Hold")  )
				{
					
					//System.out.println("INSIDE BOTH  HOLD  AND  OLD YES OR CURRENT NOT3 " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
			
					  Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO") ).add(Restrictions.eq("TICKET_ID", tid));

					 int maxsrno1=(int) criteriaformax.uniqueResult();
					 
					 //System.out.println("MAX NO is THAT " + maxsrno1);
				
									
						Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_END_DATE=:HOLD_END_DATE ,TICKET_STATUS=:TICKET_STATUS  WHERE SR_NO=:SR_NO");
						updathistoricalsla.setParameter("HOLD_END_DATE", currenttime11);
						updathistoricalsla.setParameter("SR_NO",maxsrno1);
						updathistoricalsla.setParameter("TICKET_STATUS",status);
							

						//////////////////////////////CODE FOR FIND ELAPSE AND HOLD DURATION //////////////////////////////
						int check=	updathistoricalsla.executeUpdate();	
			
						
						String GETSTARTHOLDTIME="";
						String GETENDHOLDTIME="";
						//System.out.println("VALUE OF CHECK  " + check);
						if(check!=0) {
							
							//System.out.println("INSIDE ELAPSE IF BLOCK");
							Query QUERYFORBOTHDATE=sessionFactory.getCurrentSession().createQuery("from historical_sla where SR_NO='"+maxsrno1+"'");
							
							List<historical_sla> historicalvalue=QUERYFORBOTHDATE.list();
							for(historical_sla getvalue: historicalvalue) {
								
								GETENDHOLDTIME=	getvalue.getHOLD_END_DATE();
								GETSTARTHOLDTIME=	getvalue.getHOLD_START_DATE();
								
							}
							//System.out.println("GETENDHOLDTIME VALUE  "+ GETENDHOLDTIME);
							//System.out.println("GETSTARTHOLDTIME VALUE  "+ GETSTARTHOLDTIME);
							
							
							 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					            
					              
							  Date stratdate = sdf.parse(GETSTARTHOLDTIME);
					            Date enddate = sdf.parse(GETENDHOLDTIME);
					            
					        long duration = enddate.getTime()- stratdate.getTime();
					  
					           //System.out.println("difference_In_Time is   " + duration);
					          

								int diffInSeconds =(int) TimeUnit.MILLISECONDS.toSeconds(duration);
								long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
								long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
								long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
								
								
								//System.out.println("diffInDays: " + diffInDays);
								//System.out.println("diffInHours: " + diffInHours);
								//System.out.println("diffInMinutes: " + diffInMinutes);
								//System.out.println("diffInSeconds: " + diffInSeconds);
								
								///////////////// START DATE TO END DATE DURATION Starts///////
								int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
								long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
								long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
										- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
								long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
										- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
								
								String day_StartEndDate1 = "";
								String hours_StartEndDate1 = "";
								String minute_StartEndDate1 = "";
								String second_StartEndDate1 = "";

								if (day_StartEndDate != 0) {
									day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
								}
								if (hours_StartEndDate != 0) {
									hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
								}
								if (minute_StartEndDate != 0) {
									minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
								}
								if (second_StartEndDate != 0) {
									second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
								}

								String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
										+ second_StartEndDate1;
								//System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
								//System.out.println(" TOTAL ELAPS TIME  IS  " + diffInSeconds);
					            
					               if(!StartEndDateDuration.isEmpty() && diffInSeconds !=0) {
										
										Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
										updateelapsandduration.setParameter("HOLD_ELAPSED_TIME", Integer.valueOf(diffInSeconds).toString());
										updateelapsandduration.setParameter("SR_NO",maxsrno1);
										updateelapsandduration.setParameter("HOLD_DURATION",StartEndDateDuration);
									int check2=	updateelapsandduration.executeUpdate();
									
									//System.out.println("check2 value "+ check2);
					            	   
					               }
					               
						}
							

							if(OLD_STATUS.equals("Hold") && status.equals("Hold") ) {
								
								historical_sla historicalsla = new historical_sla();
								
								historicalsla.setSR_NO(SRNO1);
								historicalsla.setTICKET_ID(tid);
							
								historicalsla.setTICKET_STATUS(status);
							
								historicalsla.setSLA_STATUS("NA");
								historicalsla.setHOLD_START_DATE(currenttime11);
								historicalsla.setHOLD_END_DATE("NA");
								historicalsla.setHOLD_ELAPSED_TIME("NA");
								
								historicalsla.setHOLD_DURATION("NA");
								
								historicalsla.setT_COMPANY(T_COMPANY);
								historicalsla.setT_BRANCH(T_BRANCH);
								historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
								sessionFactory.getCurrentSession().save(historicalsla);
								
								
							}
						
				}
				
				else if(!OLD_STATUS.equals("Hold") && status.equals("Hold") ){
					
					//System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
					historical_sla historicalsla = new historical_sla();
//					
					historicalsla.setSR_NO(SRNO1);
					historicalsla.setTICKET_ID(tid);
				
					historicalsla.setTICKET_STATUS(status);
				
					historicalsla.setSLA_STATUS("NA");
					historicalsla.setHOLD_START_DATE(currenttime11);
					historicalsla.setHOLD_END_DATE("NA");
					historicalsla.setHOLD_ELAPSED_TIME("NA");
					
					historicalsla.setHOLD_DURATION("NA");
					
					historicalsla.setT_COMPANY(T_COMPANY);
					historicalsla.setT_BRANCH(T_BRANCH);
					historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
					sessionFactory.getCurrentSession().save(historicalsla);
			
				}
				
				
			}catch (Exception e) 
			{
				SMSApi = "fail";
				//System.out.println(e);
			}
			
			SMSApi = "success";
			
			///////////////////////////////////HISTORICAL SLA CODE STOP///////////////////////////////

			
			/////////////////////SLA STARTS////////////////////////
			if (status.equals("Resolved")) {
				//System.out.println("IN STATUS RESOLVED FOR HOLD TICKETS");
				//System.out.println("SLA STARTS");

				String holdstartdate = null;

				Query query5 = sessionFactory.getCurrentSession().createQuery("from sla WHERE TICKET_ID='"+ tid+"'");
				sla sla5 = (sla) query5.uniqueResult();
				if (sla5 != null) {
					//System.out.println("IN SLA NOT NULL");
					holdstartdate = sla5.getHOLD_START_DATE();
					//System.out.println("HOLD START DATE: " + holdstartdate);
				}

				String StartDate1 = holdstartdate;
				Date HoldStartDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(StartDate1);
				//System.out.println("HOLD START DATE: " + HoldStartDate);

				SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date tdate1 = new Date();
				String HoldEndDate = simpleDateFormat1.format(tdate1);
				//System.out.println("HOLD END DATE: " + HoldEndDate);
				Date HoldEndDate1 = simpleDateFormat1.parse(HoldEndDate);

				Date startDate = HoldStartDate;// Set start date
				Date endDate = HoldEndDate1;// Set end date
				long duration = endDate.getTime() - startDate.getTime();

				long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
				long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);

				//System.out.println("diffInDays: " + diffInDays);
				//System.out.println("diffInHours: " + diffInHours);
				//System.out.println("diffInMinutes: " + diffInMinutes);
				//System.out.println("diffInSeconds: " + diffInSeconds);

				String diffInSecondsToString = String.valueOf(diffInSeconds);

				Query query11 = sessionFactory.getCurrentSession().createQuery("from sla where TICKET_ID='"+ tid+"'");
				sla sla4 = (sla) query11.uniqueResult();
				if (sla4 != null) {
					//System.out.println("IN SLA UPDATE");

					Query query12 = sessionFactory.getCurrentSession().createQuery(
							"update sla set PRIORITY=:PRIORITY,SEVERITY=:SEVERITY,TICKET_STATUS=:TICKET_STATUS,START_DATE=:START_DATE,STOP_DATE=:STOP_DATE,ELAPSED_TIME=:ELAPSED_TIME,SLA_TIME=:SLA_TIME,SLA_STATUS=:SLA_STATUS,HOLD_START_DATE=:HOLD_START_DATE,HOLD_END_DATE=:HOLD_END_DATE,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME WHERE TICKET_ID=:TICKET_ID");

					query12.setParameter("PRIORITY", priority);
					query12.setParameter("SEVERITY", severity);
					query12.setParameter("TICKET_STATUS", status);
					query12.setParameter("START_DATE", raisedate);
					query12.setParameter("STOP_DATE", "NA");
					query12.setParameter("ELAPSED_TIME", "NA");
					query12.setParameter("SLA_TIME", "NA");
					query12.setParameter("SLA_STATUS", "NA");
					query12.setParameter("HOLD_START_DATE", holdstartdate);
					query12.setParameter("HOLD_END_DATE", HoldEndDate);
					query12.setParameter("HOLD_ELAPSED_TIME", diffInSecondsToString);
					query12.setParameter("TICKET_ID", tid);

					query12.executeUpdate();

				} else {
					//System.out.println("IN SLA INSERT");

					sla slainsert = new sla();

					slainsert.setTICKET_ID(tid);
					slainsert.setPRIORITY(priority);
					slainsert.setSEVERITY(severity);
					slainsert.setTICKET_STATUS(status);
					slainsert.setSTART_DATE(raisedate);
					slainsert.setSTOP_DATE("NA");
					slainsert.setELAPSED_TIME("NA");
					slainsert.setSLA_TIME("NA");
					slainsert.setSLA_STATUS("NA");
					slainsert.setHOLD_START_DATE(holdstartdate);
					slainsert.setHOLD_END_DATE(HoldEndDate);
					slainsert.setHOLD_ELAPSED_TIME(diffInSecondsToString);
					slainsert.setSLA_TARGET("NA");
					slainsert.setSTART_END_TIME("NA");
					slainsert.setHOLD_DURATION("NA");

					sessionFactory.getCurrentSession().persist(slainsert);

				}
			}
/////////////////////SLA ENDS////////////////////////

			SMSApi = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(SMSApi.equals("success"))
			Inv.EmailSMSTriggered(tid, status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return SMSApi;
	}

	@Override
	public String Passwordreset(String user, String oldpass, String newpass, String confpass) {
		String output = "";
		
		
		String LoginUser = null;
		String companyname=null;
		System.out.println("oldpass"+oldpass);
		System.out.println("PassswordReset"+newpass);
		System.out.println("confirfpassword"+confpass);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			companyname = session.getAttribute("companyname").toString();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		String Pass=null;
		List<String> loginset = sessionFactory.getCurrentSession().createSQLQuery("SELECT PASSWORD FROM  loginmaster where USERNAME='"+LoginUser+"'AND COMPANY='"+companyname+"'").list();
		for (String loginObj : loginset) {
			
			 Pass=loginObj;
		}
		
		if (oldpass.equalsIgnoreCase(Pass)) {
			
		try {
//						Query ofdept=sessionFactory.getCurrentSession().createQuery("select PASSWORD fr");
						try {
							int i = sessionFactory
									.getCurrentSession().createQuery("update loginmaster set PASSWORD='"+confpass+"' where USERNAME= '" + LoginUser + "' and COMPANY='"+companyname+"'")
									.executeUpdate();
							if (i > 0) {
								output = "success";
							} else {
								output = "failed";
							}
							// con.commit();
						} catch (Exception e) {
							//System.out.println("update: " + e);
						}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		} else {
			output = "failed";

		}
		return output;
	}

	@Override
	public JSONArray getEngAssignProblemTickets(String loginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggGroup="";
		String LoginScope = null;
		String LoginUser = null;
		String companyname=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			companyname = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
				//////GET ENGINEERS DATA////
					List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"'AND COMPANY='"+companyname+"'").list();
					for (loginmaster loginObj : loginset) {
						enggGroup=loginObj.getGROUP_NAME().replace(",","','");
						//System.out.println("ENGG GROUP FOUND: "+enggGroup);
					}

					List<Object[]> problemTicketList = sessionFactory.getCurrentSession().createSQLQuery("select * from(select PT_ID,PROBLEM_STATUS,PRIORITY,SEVERITY,PT_SUBJECT,PT_USER_COMPANY as T_COMPANY,PT_USER_BRANCH as T_BRANCH,PT_USER_DEPARTMENT as T_DEPARTMENT,T_PROBLEM_CATEGORY,T_PROBLEM_SUBCAT1,T_PROBLEM_SUBCAT2,TP_NAME,TP_FULLNAME,PT_ASSIGN_TO,ENGINEER_NAME,ENGINEER_FULLNAME,ENGINEER_GROUP,PT_RAISE_DATE,PT_ASSIGN_DATE as ASSIGN_DATE ,PT_ENGINEER_COMPANY as PT_ENGINEER_COMPANY from problem_ticket_assigned) inn where PROBLEM_STATUS='Assigned' AND ("+LoginScope+") AND (ENGINEER_NAME='"+LoginUser+"' and PT_ENGINEER_COMPANY='"+companyname+"' OR (ENGINEER_GROUP IN ('"+enggGroup+"') and PROBLEM_STATUS='Assigned'  ) ) ORDER BY ASSIGN_DATE DESC").list();
			array = new JSONArray();
			for (Object[] listData : problemTicketList) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewProblemTicket(\""+ listData[0] +"\")'><i class='fa fa-eye'></i></button>");
				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateProblemTicket(\""+listData[0]+"\")'><i class='fa fa-edit'></i></button>");

				array1.put(listData[0]);
				array1.put(listData[1]);
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[11]);
				array1.put(listData[12]);
				array1.put(listData[13]);
				
				
				if(listData[13].equals("Engineer"))
				{
					array1.put(listData[14]);
				}
				else
				{
					array1.put(listData[16]);
				}
				array1.put(listData[15]);
				array1.put(listData[17]);
				array1.put(listData[18]);
				
				array.put(array1);

			}


		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public JSONArray gatherProblemTicketDetails(String ticketid) {
		//System.out.println("Inside EngineerActivityDaoImpl gatherProblemTicketDetails method");
		String TicketStatus = null;
		JSONArray array = null;

		JSONArray array1 = null;
		String ENGINEER_NAME = "";
		String ENGINEER_GROUP = "";
		String PT_ASSIGN_TO = "";
		String TP_NAME = "";
		String ENGINEER_ASSIGN_DATE = "";
		String ENGINEER_RESOLVED_DATE = "";
		String ENGINEER_RCA_DATE = "";
		String ENGINEER_FIXINPROCESS_DATE = "";
		String FIX_NOTES = "";
		String WORKAROUND = "";
		String CAUSE_NOTES = "";
		String RESOLVE_NOTES = "";
		String RESOLUTION_CODE = "";
		String TICKET_CLOSEBY = "";
		String TICKET_CLOSE_DATE = "";
		String TICKET_CLOSE_NOTES = "";

		String subdept=null;
	String location=null;
		//String Sub_Department
		
		try {

///////////// FROM PROBLEM TICKET TABLE //////////
			Query problemtickettable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket where PT_ID=:PT_ID");
			problemtickettable.setParameter("PT_ID", ticketid);
    		List<problem_ticket> ticketList = problemtickettable.list();
    		
///////////// FROM PROBLEM TICKET RESOLVED TABLE //////////
			Query query1 = sessionFactory.getCurrentSession().createQuery("from problem_ticket_resolved where PT_ID=:PT_ID");
			query1.setParameter("PT_ID", ticketid);
			
///////////// FROM PROBLEM TICKET ASSIGNED TABLE //////////			
			Query query2 = sessionFactory.getCurrentSession().createQuery("from problem_ticket_assigned where PT_ID=:PT_ID");
			query2.setParameter("PT_ID", ticketid);
			
			
			array1 = new JSONArray();

			for (problem_ticket ticketDrive : ticketList) {

				TicketStatus=ticketDrive.getPROBLEM_STATUS();
				//System.out.println("PROBLEM TICKET STATUS FOUND: "+TicketStatus);
				JSONObject arrayobj = new JSONObject();
				
				if(TicketStatus.equals("Assigned"))
				{
					//System.out.println("INSIDE PROBLEM TICKET STATUS: Assigned");
					problem_ticket_assigned TAdata = (problem_ticket_assigned) query2.uniqueResult();
					if (TAdata != null) {
						//System.out.println("PROBLEM TICKET ASSIGNED DATA FOUND");
						ENGINEER_NAME = TAdata.getENGINEER_NAME();
						ENGINEER_GROUP = TAdata.getENGINEER_GROUP();
						ENGINEER_ASSIGN_DATE = TAdata.getPT_ASSIGN_DATE();
						PT_ASSIGN_TO = TAdata.getPT_ASSIGN_TO();
						TP_NAME = TAdata.getTP_NAME();
						//////ADD ASSIGNED RELATED DATA////////
						arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
						arrayobj.put("ENGINEER_GROUP", ENGINEER_GROUP);
						arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
						arrayobj.put("PT_ASSIGN_TO", PT_ASSIGN_TO);
						arrayobj.put("TP_NAME", TP_NAME);
						
					}
				} else if(TicketStatus.equals("Root Cause Analysis"))
				{
					//System.out.println("INSIDE PROBLEM TICKET STATUS: Root Cause Analysis");
					problem_ticket_resolved TRdata = (problem_ticket_resolved) query1.uniqueResult();
					if (TRdata != null) {
						//System.out.println("PROBLEM TICKET RESOLVED DATA FOUND");
						ENGINEER_NAME = TRdata.getENGINEER_NAME();
						ENGINEER_ASSIGN_DATE = TRdata.getPT_ASSIGN_DATE();
						ENGINEER_RCA_DATE = TRdata.getPT_RCA_DATE();
						CAUSE_NOTES = TRdata.getCAUSE_NOTES();
						//////ADD RCA RELATED DATA////////
						arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
						arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
						arrayobj.put("ENGINEER_RCA_DATE", ENGINEER_RCA_DATE);
						arrayobj.put("CAUSE_NOTES", CAUSE_NOTES);
					}
				} else if(TicketStatus.equals("Fix In Process"))
				{
					//System.out.println("INSIDE PROBLEM TICKET STATUS: Fix In Process");
					problem_ticket_resolved TRdata = (problem_ticket_resolved) query1.uniqueResult();
					if (TRdata != null) {
						//System.out.println("PROBLEM TICKET RESOLVED DATA FOUND");
						ENGINEER_NAME = TRdata.getENGINEER_NAME();
						ENGINEER_ASSIGN_DATE = TRdata.getPT_ASSIGN_DATE();
						ENGINEER_RCA_DATE = TRdata.getPT_RCA_DATE();
						CAUSE_NOTES = TRdata.getCAUSE_NOTES();
						ENGINEER_FIXINPROCESS_DATE = TRdata.getPT_FIXINPROCESS_DATE();
						FIX_NOTES = TRdata.getFIX_NOTES();
						WORKAROUND = TRdata.getWORKAROUND();
						//////ADD FIX RELATED DATA////////
						arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
						arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
						arrayobj.put("ENGINEER_RCA_DATE", ENGINEER_RCA_DATE);
						arrayobj.put("CAUSE_NOTES", CAUSE_NOTES);
						arrayobj.put("ENGINEER_FIXINPROCESS_DATE", ENGINEER_FIXINPROCESS_DATE);
						arrayobj.put("FIX_NOTES", FIX_NOTES);
						arrayobj.put("WORKAROUND", WORKAROUND);
					}
				} else if(TicketStatus.equals("Resolved"))
				{
					//System.out.println("INSIDE PROBLEM TICKET STATUS: Resolved");
					problem_ticket_resolved TRdata = (problem_ticket_resolved) query1.uniqueResult();
					if (TRdata != null) {
						//System.out.println("PROBLEM TICKET RESOLVED DATA FOUND");
						ENGINEER_NAME = TRdata.getENGINEER_NAME();
						ENGINEER_ASSIGN_DATE = TRdata.getPT_ASSIGN_DATE();
						ENGINEER_RCA_DATE = TRdata.getPT_RCA_DATE();
						CAUSE_NOTES = TRdata.getCAUSE_NOTES();
						ENGINEER_FIXINPROCESS_DATE = TRdata.getPT_FIXINPROCESS_DATE();
						FIX_NOTES = TRdata.getFIX_NOTES();
						WORKAROUND = TRdata.getWORKAROUND();
						ENGINEER_RESOLVED_DATE = TRdata.getPT_RESOLVE_DATE();
						RESOLVE_NOTES = TRdata.getRESOLVE_NOTES();
						RESOLUTION_CODE = TRdata.getRESOLUTION_CODE();
						//////ADD RESOLVED RELATED DATA////////
						arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
						arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
						arrayobj.put("ENGINEER_RCA_DATE", ENGINEER_RCA_DATE);
						arrayobj.put("CAUSE_NOTES", CAUSE_NOTES);
						arrayobj.put("ENGINEER_FIXINPROCESS_DATE", ENGINEER_FIXINPROCESS_DATE);
						arrayobj.put("FIX_NOTES", FIX_NOTES);
						arrayobj.put("WORKAROUND", WORKAROUND);
						arrayobj.put("ENGINEER_RESOLVED_DATE", ENGINEER_RESOLVED_DATE);
						arrayobj.put("RESOLVE_NOTES", RESOLVE_NOTES);
						arrayobj.put("RESOLUTION_CODE", RESOLUTION_CODE);
					}
				} else if(TicketStatus.equals("Closed"))
				{
					//System.out.println("INSIDE PROBLEM TICKET STATUS: Closed");
					problem_ticket_resolved TRdata = (problem_ticket_resolved) query1.uniqueResult();
					if (TRdata != null) {
						//System.out.println("PROBLEM TICKET RESOLVED DATA FOUND");
						ENGINEER_NAME = TRdata.getENGINEER_NAME();
						ENGINEER_ASSIGN_DATE = TRdata.getPT_ASSIGN_DATE();
						ENGINEER_RCA_DATE = TRdata.getPT_RCA_DATE();
						CAUSE_NOTES = TRdata.getCAUSE_NOTES();
						ENGINEER_FIXINPROCESS_DATE = TRdata.getPT_FIXINPROCESS_DATE();
						FIX_NOTES = TRdata.getFIX_NOTES();
						WORKAROUND = TRdata.getWORKAROUND();
						ENGINEER_RESOLVED_DATE = TRdata.getPT_RESOLVE_DATE();
						RESOLVE_NOTES = TRdata.getRESOLVE_NOTES();
						RESOLUTION_CODE = TRdata.getRESOLUTION_CODE();
						
						TICKET_CLOSEBY = ticketDrive.getPT_CLOSEBY();
						TICKET_CLOSE_DATE = ticketDrive.getPT_CLOSEDATE();
						TICKET_CLOSE_NOTES = ticketDrive.getP_CLOSED_NOTES();
						//////ADD RESOLVED RELATED DATA////////
						arrayobj.put("ENGINEER_NAME", ENGINEER_NAME);
						arrayobj.put("ENGINEER_ASSIGN_DATE", ENGINEER_ASSIGN_DATE);
						arrayobj.put("ENGINEER_RCA_DATE", ENGINEER_RCA_DATE);
						arrayobj.put("CAUSE_NOTES", CAUSE_NOTES);
						arrayobj.put("ENGINEER_FIXINPROCESS_DATE", ENGINEER_FIXINPROCESS_DATE);
						arrayobj.put("FIX_NOTES", FIX_NOTES);
						arrayobj.put("WORKAROUND", WORKAROUND);
						arrayobj.put("ENGINEER_RESOLVED_DATE", ENGINEER_RESOLVED_DATE);
						arrayobj.put("RESOLVE_NOTES", RESOLVE_NOTES);
						arrayobj.put("RESOLUTION_CODE", RESOLUTION_CODE);
						
						arrayobj.put("TICKET_CLOSEBY", TICKET_CLOSEBY);
						arrayobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
						arrayobj.put("TICKET_CLOSE_NOTES", TICKET_CLOSE_NOTES);
					}

				}
				
				//////////////COMMON DATA FROM PROBLEM TICKET TABLE BELOW////////

				arrayobj.put("PT_REQUESTER", ticketDrive.getPT_REQUESTER());
				arrayobj.put("PT_COMPANY", ticketDrive.getPT_COMPANY());
				arrayobj.put("PT_BRANCH", ticketDrive.getPT_BRANCH());
				arrayobj.put("PT_DEPARTMENT", ticketDrive.getPT_DEPARTMENT());
				arrayobj.put("PT_PHONE", ticketDrive.getPT_PHONE());
				arrayobj.put("PT_MAIL", ticketDrive.getPT_MAIL());
				arrayobj.put("T_PROBLEM_CATEGORY", ticketDrive.getT_PROBLEM_CATEGORY());
				arrayobj.put("T_PROBLEM_SUBCAT1", ticketDrive.getT_PROBLEM_SUBCAT1());
				arrayobj.put("T_PROBLEM_SUBCAT2", ticketDrive.getT_PROBLEM_SUBCAT2());
				arrayobj.put("PT_SUBJECT", ticketDrive.getPT_SUBJECT());
				arrayobj.put("PT_DESC", ticketDrive.getPT_DESC());
				arrayobj.put("PT_DATE", ticketDrive.getPT_DATE());
				arrayobj.put("PROBLEM_STATUS", ticketDrive.getPROBLEM_STATUS());
				arrayobj.put("PT_ID", ticketDrive.getPT_ID());
				arrayobj.put("PRIORITY", ticketDrive.getPRIORITY());
				arrayobj.put("SEVERITY", ticketDrive.getSEVERITY());
				arrayobj.put("REQUEST_MODE", ticketDrive.getREQUEST_MODE());
				
				
				
				
				List<loginmaster> lm = sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"
						+ ticketDrive.getPT_COMPANY() + "' and USERNAME='" + ticketDrive.getPT_REQUESTER() + "'")
						.list();
			
				for (loginmaster lmc : lm) 
				{
					subdept=lmc.getSUB_DEPARTMENT();
					location=lmc.getLOCATION();
				}
				//System.out.println(subdept+"subdeptsubdept");
				//System.out.println("sdfggsdgdsgrg location"+location);
				arrayobj.put("Sub_Dept",subdept);
				arrayobj.put("Location",location);
				
				String AttachName=ticketDrive.getPT_ATTACH_NAME();
				//System.out.println("ATTACH NAME: "+ AttachName);
				try {
					if(AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("") ) {
						arrayobj.put("PT_ATTACH_NAME", "No File Available");
						//System.out.println("Null object found");
					}else {
						arrayobj.put("PT_ATTACH_NAME", ticketDrive.getPT_ATTACH_NAME());
						//System.out.println("FILE Object found");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println("IN CATCH BLOCK");
					arrayobj.put("PT_ATTACH_NAME", "No File Available");
					e.printStackTrace();
				}
				///////////// FOR INCIDENTS ATTACHED //////////////
				JSONArray IncidentArray1 = new JSONArray();
				JSONArray Singlearray =null;
				String attachedIncidents=ticketDrive.getATTACHED_INCIDENTS();
				//System.out.println("ATTACHED INC STRING: "+attachedIncidents);
				String[] IncidentArray =null;
				try {
				IncidentArray = attachedIncidents.split(",");
				//System.out.println("INCIDENT ARRAY LENGTH : "+IncidentArray.length);
				for (String singleIncident : IncidentArray)
				{
					singleIncident=singleIncident.replaceAll("'", "");
					//System.out.println("Fetching data for: "+singleIncident);
					List<Object[]> l= sessionFactory.getCurrentSession().createSQLQuery("Select T_ID,T_DATE,T_SUBJECT,T_REQUESTER,PRIORITY,SEVERITY,STATUS,T_CATEGORY FROM ticket WHERE T_ID='"+singleIncident+"'").list();
					
					for (Object[] listData : l) {
						
						Singlearray = new JSONArray();
										
						Singlearray.put("<button class='btn btn-sm btn-info' onclick='viewTicket(\""
								+ listData[0] + "\" )'><i class='fa fa-eye'></i></button>");
						Singlearray.put(listData[0].toString());
						Singlearray.put(listData[1].toString());
						Singlearray.put(listData[2].toString());
						Singlearray.put(listData[3].toString());
						Singlearray.put(listData[4].toString());
						
						Singlearray.put(listData[5].toString());
						Singlearray.put(listData[6].toString());
						Singlearray.put(listData[7].toString());
												
						IncidentArray1.put(Singlearray);
					}

				}
				}catch(Exception e) {
					//System.out.println("NO INCIDENTS ATTACHED: "+e);
//					e.printStackTrace();
				}
				//System.out.println("FINAL INCIDENT ARRAY: "+IncidentArray1);
				arrayobj.put("INCIDENTS_ATTACHED", IncidentArray1);
				array1.put(arrayobj);
			}
			//System.out.println("TOTAL DATA: " + array1);
			
			//Inv.RaiseNCloseEmailSMS(id,name1,st,site,category,subject,description,priority);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
	public String UpdateRCAProblemTicket(String tid, String causeNotes, MultipartFile RCAFilePic) {
		//System.out.println("INSIDE UpdateRCAProblemTicket DAO IMPL");
		String status="";
		String LoginUser = null;
		String loginRoleType="";
		String companyname =null;
		String fullnameOflogin="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			companyname = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			fullnameOflogin = session.getAttribute("fullname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			
/////////////////////////////////// FOR FILE UPLOAD /////////////////
			//System.out.println("RCAFilePic FILE NAME IN DAO_IMPL: " + RCAFilePic.getOriginalFilename());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + RCAFilePic.getSize());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + RCAFilePic.getSize());

			String fileNameWithOutExt = FilenameUtils.removeExtension(RCAFilePic.getOriginalFilename());
			//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
//String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + tid;
			//System.out.println("createnewfilename***" + createnewfilename);
//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//System.out.println("Directory is created!");
						} else {
							//System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//System.out.println("directory create exception" + e);
				}
                 
				String fileName = RCAFilePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
                //File uploadedFile =  empPic;
//				File uploadedFile = new File(RCAFilePic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(RCAFilePic.getBytes());
				fos.close();

//				String fileName = RCAFilePic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);

				//System.out.println("file_extension::::" + ext);
                //File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);

				updatedFileName = createnewfilename + "." + ext;

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}
////////////////////////////////////FILE UPLOAD ENDS ///////////////
			
			
			String currenttime = null;
			DateFormat dateFormat = null;

			//////////// FETCHING DATA FROM problem_ticket_assigned table ///////////
			String PT_RAISE_DATE="";
			String PT_USER_NAME="";
			String PT_USER_EMAIL="";
			String PT_USER_PHONE="";
			String PT_USER_COMPANY="";
			String PT_USER_BRANCH="";
			String PT_USER_DEPARTMENT="";
			String T_PROBLEM_CATEGORY="";
			String T_PROBLEM_SUBCAT1="";
			String T_PROBLEM_SUBCAT2="";
			String PT_SUBJECT="";
			String PT_DESC="";
			String PRIORITY="";
			String SEVERITY="";
//			String PROBLEM_STATUS="";
			String TP_NAME="";
			String TP_EMAIL="";
			String TP_PHONE="";
//			String ENGINEER_NAME="";
			String PT_ASSIGN_DATE="";
			String fullname = "";
			String emailid = "";
			String phone = "";
			String TP_FULLNAME = "";
			
			String CurrentStatus="Root Cause Analysis";
						
			Query problemticketassignedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_assigned where PT_ID=:PT_ID");
			problemticketassignedtable.setParameter("PT_ID", tid);
    		List<problem_ticket_assigned> ticketList = problemticketassignedtable.list();
    		for (problem_ticket_assigned ticketDrive : ticketList) {

				PT_RAISE_DATE=ticketDrive.getPT_RAISE_DATE();
				PT_USER_NAME=ticketDrive.getPT_USER_NAME();
				PT_USER_EMAIL=ticketDrive.getPT_USER_EMAIL();
				PT_USER_PHONE=ticketDrive.getPT_USER_PHONE();
				PT_USER_COMPANY=ticketDrive.getPT_USER_COMPANY();
				PT_USER_BRANCH=ticketDrive.getPT_USER_BRANCH();
				PT_USER_DEPARTMENT=ticketDrive.getPT_USER_DEPARTMENT();
				T_PROBLEM_CATEGORY=ticketDrive.getT_PROBLEM_CATEGORY();
				T_PROBLEM_SUBCAT1=ticketDrive.getT_PROBLEM_SUBCAT1();
				T_PROBLEM_SUBCAT2=ticketDrive.getT_PROBLEM_SUBCAT2();
				PT_SUBJECT=ticketDrive.getPT_SUBJECT();
				PT_DESC=ticketDrive.getPT_DESC();
				PRIORITY=ticketDrive.getPRIORITY();
				SEVERITY=ticketDrive.getSEVERITY();
//				PROBLEM_STATUS=ticketDrive.getPROBLEM_STATUS();
				TP_NAME=ticketDrive.getTP_NAME();
				TP_FULLNAME=ticketDrive.getTP_FULLNAME();
				TP_EMAIL=ticketDrive.getTP_EMAIL();
				TP_PHONE=ticketDrive.getTP_PHONE();
//				ENGINEER_NAME=ticketDrive.getENGINEER_NAME();
				PT_ASSIGN_DATE=ticketDrive.getPT_ASSIGN_DATE();
			}
    		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			currenttime = dateFormat.format(date);
			//System.out.println("CURRENT TIME: "+currenttime);

			///////////////////// INSERT OR UPDATE IN PROBLEM TICKET RESOLVED TABLE //////////////////
			try {
//				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
//						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				
				Query problemticketresolvedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_resolved where PT_ID=:PT_ID");
				problemticketresolvedtable.setParameter("PT_ID", tid);
	    		List<problem_ticket_resolved> resolvedticketList = problemticketresolvedtable.list();
	    		
				if (resolvedticketList.isEmpty()) {
					//System.out.println("IN INSERT PROBLEM TICKET RESOLVED");
					problem_ticket_resolved queryTicketResolvedInsert = new problem_ticket_resolved();
					queryTicketResolvedInsert.setPT_ID(tid);
					queryTicketResolvedInsert.setPT_ASSIGN_DATE(PT_ASSIGN_DATE);
					queryTicketResolvedInsert.setPT_RCA_DATE(currenttime);
//					queryTicketResolvedInsert.setPT_FIXINPROCESS_DATE();
//					queryTicketResolvedInsert.setPT_RESOLVE_DATE();
					queryTicketResolvedInsert.setPT_USER_NAME(PT_USER_NAME);
					queryTicketResolvedInsert.setPT_USER_EMAIL(PT_USER_EMAIL);
					queryTicketResolvedInsert.setPT_USER_PHONE(PT_USER_PHONE);
					queryTicketResolvedInsert.setPT_USER_COMPANY(PT_USER_COMPANY);
					queryTicketResolvedInsert.setPT_USER_BRANCH(PT_USER_BRANCH);
					queryTicketResolvedInsert.setPT_USER_DEPARTMENT(PT_USER_DEPARTMENT);
					queryTicketResolvedInsert.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
					queryTicketResolvedInsert.setPT_SUBJECT(PT_SUBJECT);
					queryTicketResolvedInsert.setPT_DESC(PT_DESC);
					queryTicketResolvedInsert.setPT_PRIORITY(PRIORITY);
					queryTicketResolvedInsert.setSEVERITY(SEVERITY);
					queryTicketResolvedInsert.setPROBLEM_STATUS(CurrentStatus);
					queryTicketResolvedInsert.setTP_NAME(TP_NAME);
					
					queryTicketResolvedInsert.setTP_EMAIL(TP_EMAIL);
					queryTicketResolvedInsert.setTP_PHONE(TP_PHONE);
					queryTicketResolvedInsert.setENGINEER_NAME(LoginUser);
					queryTicketResolvedInsert.setENGINEER_FULLNAME(fullnameOflogin);
					queryTicketResolvedInsert.setPT_RESOLVED_ENGINEER_COMPANY(companyname);
					queryTicketResolvedInsert.setCAUSE_NOTES(causeNotes);
					queryTicketResolvedInsert.setCURRENT_ACTIVITY_TIME(currenttime);
//					queryTicketResolvedInsert.setFIX_NOTES();
//					queryTicketResolvedInsert.setWORKAROUND();
//					queryTicketResolvedInsert.setRESOLVE_NOTES();
//					queryTicketResolvedInsert.setRESOLUTION_CODE();
					
					getSession().save(queryTicketResolvedInsert);

				} else {
					//System.out.println("IN UPDATE PROBLEM TICKET RESOLVED");
					int f = sessionFactory.getCurrentSession()
							.createQuery("UPDATE problem_ticket_resolved SET ENGINEER_NAME='" + LoginUser
									+ "',ENGINEER_FULLNAME='"+fullnameOflogin+"',PROBLEM_STATUS='" + CurrentStatus
									+ "',PT_RCA_DATE='" + currenttime + "',CURRENT_ACTIVITY_TIME='"+currenttime+"',CAUSE_NOTES='" + causeNotes + "', WHERE PT_ID='" + tid + "'")
							.executeUpdate();
					if (f > 0) {
						//System.out.println("update in problem ticket resolved****");

					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			///////////////////////// INSERT IN PROBLEM TICKET TRACKING TABLE /////////////////////
			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from problem_ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					//System.out.println("SRNO temp: "+temp);
					sno = temp+1;
				}
				//System.out.println("SRNO to insert: "+sno);
//				String msg = "Engineer " +ENGINEER_NAME+" changed status to "+CurrentStatus+" on "+currenttime;
				
				String msg = null;
				msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>"+CurrentStatus+"</td></tr>"
						+ "<tr><td>Engg Name:</td><td>"+LoginUser+"</td></tr>";

				problem_ticket_tracking p_ticket_tracking = new problem_ticket_tracking();
				p_ticket_tracking.setSR_NO(sno);
				p_ticket_tracking.setPT_ID(tid);
				p_ticket_tracking.setACTIVITY_DATE(currenttime);
				p_ticket_tracking.setACTIVITY_NAME(LoginUser);
				p_ticket_tracking.setACTIVITY_NAME_COMPANY(companyname);
				p_ticket_tracking.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
				p_ticket_tracking.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
				p_ticket_tracking.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
				p_ticket_tracking.setPT_SUBJECT(PT_SUBJECT);
				p_ticket_tracking.setPROBLEM_STATUS(CurrentStatus);
				p_ticket_tracking.setPRIORITY(PRIORITY);
				p_ticket_tracking.setSEVERITY(SEVERITY);
				p_ticket_tracking.setP_MESSAGE(msg);
				p_ticket_tracking.setPROBLEM_TICKET_RAISED_NAME(PT_USER_NAME);
				p_ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				if (updatedFileName == null) {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME("No File Available");
				} else {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME(updatedFileName);
				}
				
				getSession().save(p_ticket_tracking);
				//System.out.println("insert in problem ticket tracking***");

				/////////////////////////// UPDATE PROBLEM TICKET TABLE ////////////////
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket SET PROBLEM_STATUS='" + CurrentStatus+ "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
/////////////////////////// UPDATE PROBLEM TICKET ASSIGNED TABLE ////////////////
				int j = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket_assigned SET PROBLEM_STATUS='" + CurrentStatus + "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			///////////////////// INSERT IN PROBLEM TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
			
					Criteria critAct = sessionFactory.getCurrentSession().createCriteria(problem_ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) critAct.uniqueResult();
			
					//System.out.println(" actSrno1 IS: " + actSrno1);
			
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+companyname+"' and USERNAME='"+LoginUser+"'").list();
				for(loginmaster lmc:lm)
				{
					fullname=lmc.getFULL_NAME();
					emailid=lmc.getEMAIL();
					phone=lmc.getPHONE();
				}
				
				problem_ticket_activity_log problemticketActivityLog = new problem_ticket_activity_log();
			
				problemticketActivityLog.setSR_NO(ActSno);
				problemticketActivityLog.setPT_ID(tid);
				problemticketActivityLog.setPRIORITY(PRIORITY);
				problemticketActivityLog.setSEVERITY(SEVERITY);
				problemticketActivityLog.setPROBLEM_STATUS(CurrentStatus);
				problemticketActivityLog.setPT_DATETIME(currenttime);
				problemticketActivityLog.setPT_CHANGEBY(LoginUser);
				problemticketActivityLog.setPT_SUBJECT(PT_SUBJECT);
				problemticketActivityLog.setPT_DESC(PT_DESC);
				problemticketActivityLog.setRCA_NOTES(causeNotes);
				problemticketActivityLog.setROLE_TYPE(loginRoleType);
				problemticketActivityLog.setPT_CATEGORY(T_PROBLEM_CATEGORY);
				problemticketActivityLog.setPT_SUB_CATEGORY1(T_PROBLEM_SUBCAT1);
				problemticketActivityLog.setPT_SUB_CATEGORY2(T_PROBLEM_SUBCAT2);
				problemticketActivityLog.setPT_CONTACT_NO(phone);
				problemticketActivityLog.setPT_EMAIL(emailid);
				problemticketActivityLog.setPT_COMPANY(companyname);
				problemticketActivityLog.setPT_FULLNAME(fullname);
				
			
								
				if (updatedFileName == null) {
					problemticketActivityLog.setPT_ATTACH_NAME("No File Available");
				} else {
					problemticketActivityLog.setPT_ATTACH_NAME(updatedFileName);
				}
			
				sessionFactory.getCurrentSession().persist(problemticketActivityLog);
			
			//////////////////// FOR PROBLEM SLA //////////////////////
			try {
				String SLA_TYPE="";
				Query queryGetSLAData = sessionFactory.getCurrentSession().createQuery("FROM problem_sla where PT_ID=:PT_ID");
				queryGetSLAData.setParameter("PT_ID", tid);
	    		List<problem_sla> SLAData = queryGetSLAData.list();
	    		for (problem_sla SLADrive : SLAData) {
	    			SLA_TYPE=SLADrive.getSLA_TYPE();
	    			//System.out.println("SLA TYPE FOUND:"+SLA_TYPE);
	    		}
	    		if(!SLA_TYPE.equals("Not Set")) {
				Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,SEVERITY=:SEVERITY,PROBLEM_STATUS=:PROBLEM_STATUS,RCA_START_TIME=:RCA_START_TIME WHERE PT_ID=:PT_ID");
				querySLA.setParameter("PRIORITY", PRIORITY);
				querySLA.setParameter("SEVERITY", SEVERITY);
				querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
				querySLA.setParameter("RCA_START_TIME", currenttime);
				querySLA.setParameter("PT_ID", tid);
				
				querySLA.executeUpdate();
				
	    		}else {
	    			Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,SEVERITY=:SEVERITY,PROBLEM_STATUS=:PROBLEM_STATUS WHERE PT_ID=:PT_ID");
					querySLA.setParameter("PRIORITY", PRIORITY);
					querySLA.setParameter("SEVERITY", SEVERITY);
					querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
					querySLA.setParameter("PT_ID", tid);
					querySLA.executeUpdate();
	    		}
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////// FOR EMAIL/SMS ////////////////
			String Problem_ID=tid;
			String Problem_Status=CurrentStatus;
			String Problem_Subject=PT_SUBJECT;
			String Problem_Category=T_PROBLEM_CATEGORY;
			String Problem_Priority=PRIORITY;
			String Problem_Branch=PT_USER_BRANCH;
			String Problem_Department=PT_USER_DEPARTMENT;
//			String TP_NAME=TP_NAME;
//			String TP_EMAIL=TP_EMAIL;
//			String TP_PHONE=TP_PHONE;
			String ENGG_NAME=LoginUser;

			Inv.RaiseNCloseProblemEmailSMS(Problem_ID,Problem_Status);

			status="success";
			
		} catch (Exception e) {
			e.printStackTrace();
			status="failed";
		}
		return status;
	}

	@Override
	public JSONArray getEngRCAProblemTickets(String loginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggGroup="";
		String LoginScope = null;
		String LoginUser = null;
		String compantname=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			compantname = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
				List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+compantname+"'").list();
							for (loginmaster loginObj : loginset) {
								enggGroup=loginObj.getGROUP_NAME().replace(",","','");
								//System.out.println("ENGG GROUP FOUND: "+enggGroup);
							}
			
//			List<problem_ticket_resolved> dataSet = sessionFactory.getCurrentSession().createQuery("from problem_ticket_resolved where PROBLEM_STATUS='Root Cause Analysis' AND ENGINEER_NAME='" + loginUser + "' ORDER BY STR_TO_DATE(PT_ASSIGN_DATE, '%d-%m-%Y %H:%i:%s') DESC").list();
							List<Object[]> problemTicketList = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM (select tr.PT_ID,tr.PROBLEM_STATUS,tr.PT_PRIORITY,tr.SEVERITY,tr.PT_SUBJECT,tr.PT_USER_COMPANY as T_COMPANY,tr.PT_USER_BRANCH as T_BRANCH,tr.PT_USER_DEPARTMENT as T_DEPARTMENT,tr.T_PROBLEM_CATEGORY,tr.T_PROBLEM_SUBCAT1,tr.T_PROBLEM_SUBCAT2,tr.TP_NAME,ta.TP_FULLNAME,ta.PT_ASSIGN_TO,ta.ENGINEER_NAME,ta.ENGINEER_FULLNAME,ta.ENGINEER_GROUP,tr.ENGINEER_NAME as rca,tr.ENGINEER_FULLNAME as rcaf,tr.PT_ASSIGN_DATE,tr.PT_RCA_DATE AS RCA_DATE ,ta.PT_ENGINEER_COMPANY as PT_ENGINEER_COMPANY FROM problem_ticket_resolved tr JOIN  problem_ticket_assigned ta ON tr.PT_ID=ta.PT_ID) inn where PROBLEM_STATUS='Root Cause Analysis' AND ("+LoginScope+")  AND (ENGINEER_NAME='"+LoginUser+"' and PT_ENGINEER_COMPANY='"+compantname+"'  OR (ENGINEER_GROUP IN ('"+enggGroup+"') and  PROBLEM_STATUS='Root Cause Analysis' ) ) ORDER BY PT_ASSIGN_DATE DESC").list();				
			array = new JSONArray();
			for (Object[] listData : problemTicketList) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' "
						+ "onclick='ViewProblemTicket(\""+ listData[0] +"\")'><i class='fa fa-eye'></i></button>");
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateProblemTicket(\""+listData[0]+"\")'><i class='fa fa-edit'></i></button>");

				array1.put(listData[0]);
				array1.put(listData[1]);
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[11]);
				array1.put(listData[12]);
				
				
				if(listData[13].equals("Engineer"))
				{
					array1.put(listData[14]);
				}
				else
				{
					array1.put(listData[16]);
				}
				array1.put(listData[15]);
				array1.put(listData[17]);
				array1.put(listData[18]);
				array1.put(listData[19]);
				array1.put(listData[20]);
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public String UpdateFixProblemTicket(String tid, String causeNotes, String fixNotes, String workaroundNotes, MultipartFile FixFilePic) {
		//System.out.println("INSIDE UpdateFixProblemTicket DAO IMPL");
		String status="";
		String fullname = "";
		String emailid = "";
		String phone = "";
		
		String LoginUser = null;
		String loginUserComapany ="";
		String loginRoleType=null;
		String fullnameOflogin="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserComapany=session.getAttribute("companyname").toString();
			fullnameOflogin= session.getAttribute("fullname").toString();
				loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		try {
			
/////////////////////////////////// FOR FILE UPLOAD /////////////////
			//System.out.println("RCAFilePic FILE NAME IN DAO_IMPL: " + FixFilePic.getOriginalFilename());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + FixFilePic.getSize());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + FixFilePic.getSize());

			String fileNameWithOutExt = FilenameUtils.removeExtension(FixFilePic.getOriginalFilename());
			//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
//String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + tid;
			//System.out.println("createnewfilename***" + createnewfilename);
//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//System.out.println("Directory is created!");
						} else {
							//System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//System.out.println("directory create exception" + e);
				}
                
				String fileName = FixFilePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
                //File uploadedFile =  empPic;
//				File uploadedFile = new File(FixFilePic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(FixFilePic.getBytes());
				fos.close();
				
//				String fileName = FixFilePic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);
				

                //File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
			
				updatedFileName = createnewfilename + "." + ext;


//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}
////////////////////////////////////FILE UPLOAD ENDS ///////////////	
			
			String currenttime = null;
			DateFormat dateFormat = null;

			//////////// FETCHING DATA FROM problem_ticket_assigned table ///////////
			String PT_RAISE_DATE="";
			String PT_USER_NAME="";
			String PT_USER_EMAIL="";
			String PT_USER_PHONE="";
			String PT_USER_COMPANY="";
			String PT_USER_BRANCH="";
			String PT_USER_DEPARTMENT="";
			String T_PROBLEM_CATEGORY="";
			String T_PROBLEM_SUBCAT1="";
			String T_PROBLEM_SUBCAT2="";
			String PT_SUBJECT="";
			String PT_DESC="";
			String PRIORITY="";
//			String PROBLEM_STATUS="";
			String TP_NAME="";
			String TP_EMAIL="";
			String TP_PHONE="";
//			String ENGINEER_NAME="";
			String PT_ASSIGN_DATE="";
			String CurrentStatus="Fix In Process";
			String SEVERITY="";
						
			Query problemticketassignedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_assigned where PT_ID=:PT_ID");
			problemticketassignedtable.setParameter("PT_ID", tid);
    		List<problem_ticket_assigned> ticketList = problemticketassignedtable.list();
    		for (problem_ticket_assigned ticketDrive : ticketList) {

				PT_RAISE_DATE=ticketDrive.getPT_RAISE_DATE();
				PT_USER_NAME=ticketDrive.getPT_USER_NAME();
				PT_USER_EMAIL=ticketDrive.getPT_USER_EMAIL();
				PT_USER_PHONE=ticketDrive.getPT_USER_PHONE();
				PT_USER_COMPANY=ticketDrive.getPT_USER_COMPANY();
				PT_USER_BRANCH=ticketDrive.getPT_USER_BRANCH();
				PT_USER_DEPARTMENT=ticketDrive.getPT_USER_DEPARTMENT();
				T_PROBLEM_CATEGORY=ticketDrive.getT_PROBLEM_CATEGORY();
				T_PROBLEM_SUBCAT1=ticketDrive.getT_PROBLEM_SUBCAT1();
				T_PROBLEM_SUBCAT2=ticketDrive.getT_PROBLEM_SUBCAT2();
				PT_SUBJECT=ticketDrive.getPT_SUBJECT();
				PT_DESC=ticketDrive.getPT_DESC();
				PRIORITY=ticketDrive.getPRIORITY();
//				PROBLEM_STATUS=ticketDrive.getPROBLEM_STATUS();
				TP_NAME=ticketDrive.getTP_NAME();
				TP_EMAIL=ticketDrive.getTP_EMAIL();
				TP_PHONE=ticketDrive.getTP_PHONE();
//				ENGINEER_NAME=ticketDrive.getENGINEER_NAME();
				PT_ASSIGN_DATE=ticketDrive.getPT_ASSIGN_DATE();
				SEVERITY=ticketDrive.getSEVERITY();
			}
    		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			currenttime = dateFormat.format(date);
			//System.out.println("CURRENT TIME: "+currenttime);

			///////////////////// INSERT OR UPDATE IN PROBLEM TICKET RESOLVED TABLE //////////////////
			try {
//				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
//						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				
				Query problemticketresolvedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_resolved where PT_ID=:PT_ID");
				problemticketresolvedtable.setParameter("PT_ID", tid);
	    		List<problem_ticket_resolved> resolvedticketList = problemticketresolvedtable.list();
	    		
				if (resolvedticketList.isEmpty()) {
					//System.out.println("IN INSERT PROBLEM TICKET RESOLVED");
//					problem_ticket_resolved queryTicketResolvedInsert = new problem_ticket_resolved();
//					queryTicketResolvedInsert.setPT_ID(tid);
//					queryTicketResolvedInsert.setPT_ASSIGN_DATE(PT_ASSIGN_DATE);
//					queryTicketResolvedInsert.setPT_RCA_DATE(currenttime);
////					queryTicketResolvedInsert.setPT_FIXINPROCESS_DATE();
////					queryTicketResolvedInsert.setPT_RESOLVE_DATE();
//					queryTicketResolvedInsert.setPT_USER_NAME(PT_USER_NAME);
//					queryTicketResolvedInsert.setPT_USER_EMAIL(PT_USER_EMAIL);
//					queryTicketResolvedInsert.setPT_USER_PHONE(PT_USER_PHONE);
//					queryTicketResolvedInsert.setPT_USER_COMPANY(PT_USER_COMPANY);
//					queryTicketResolvedInsert.setPT_USER_BRANCH(PT_USER_BRANCH);
//					queryTicketResolvedInsert.setPT_USER_DEPARTMENT(PT_USER_DEPARTMENT);
//					queryTicketResolvedInsert.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
//					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
//					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
//					queryTicketResolvedInsert.setPT_SUBJECT(PT_SUBJECT);
//					queryTicketResolvedInsert.setPT_DESC(PT_DESC);
//					queryTicketResolvedInsert.setPT_PRIORITY(PRIORITY);
//					queryTicketResolvedInsert.setPROBLEM_STATUS(CurrentStatus);
//					queryTicketResolvedInsert.setTP_NAME(TP_NAME);
//					queryTicketResolvedInsert.setTP_EMAIL(TP_EMAIL);
//					queryTicketResolvedInsert.setTP_PHONE(TP_PHONE);
//					queryTicketResolvedInsert.setENGINEER_NAME(ENGINEER_NAME);
//					queryTicketResolvedInsert.setCAUSE_NOTES(causeNotes);
//					queryTicketResolvedInsert.setPT_FIXINPROCESS_DATE(fixNotes);
//					queryTicketResolvedInsert.setFIX_NOTES(fixNotes);
////					queryTicketResolvedInsert.setFIX_NOTES();
////					queryTicketResolvedInsert.setWORKAROUND();
////					queryTicketResolvedInsert.setRESOLVE_NOTES();
////					queryTicketResolvedInsert.setRESOLUTION_CODE();
//					
//					getSession().save(queryTicketResolvedInsert);

				} else {
					//System.out.println("IN UPDATE PROBLEM TICKET RESOLVED");
					int f = sessionFactory.getCurrentSession()
							.createQuery("UPDATE problem_ticket_resolved SET ENGINEER_NAME='" + LoginUser + "',ENGINEER_FULLNAME='"+fullnameOflogin+"',PROBLEM_STATUS='" + CurrentStatus + "',PT_FIXINPROCESS_DATE='" + currenttime + "',CAUSE_NOTES='" + causeNotes + "',FIX_NOTES='" + fixNotes + "',WORKAROUND='" + workaroundNotes + "',CURRENT_ACTIVITY_TIME='"+currenttime+"' WHERE PT_ID='" + tid + "'")
							.executeUpdate();
					if (f > 0) {
						//System.out.println("update in problem ticket resolved****");

					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			///////////////////////// INSERT IN PROBLEM TICKET TRACKING TABLE /////////////////////
			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from problem_ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					//System.out.println("SRNO temp: "+temp);
					sno = temp+1;
				}
				//System.out.println("SRNO to insert: "+sno);
//				String msg = "Engineer " +ENGINEER_NAME+" changed status to "+CurrentStatus+" on "+currenttime;

				String msg = null;
				msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>"+CurrentStatus+"</td></tr>"
						+ "<tr><td>Engg Name:</td><td>"+LoginUser+"</td></tr>";

				problem_ticket_tracking p_ticket_tracking = new problem_ticket_tracking();
				p_ticket_tracking.setSR_NO(sno);
				p_ticket_tracking.setPT_ID(tid);
				p_ticket_tracking.setACTIVITY_DATE(currenttime);
				p_ticket_tracking.setACTIVITY_NAME(LoginUser);
				p_ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserComapany);
				p_ticket_tracking.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
				p_ticket_tracking.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
				p_ticket_tracking.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
				p_ticket_tracking.setPT_SUBJECT(PT_SUBJECT);
				p_ticket_tracking.setPROBLEM_STATUS(CurrentStatus);
				p_ticket_tracking.setPRIORITY(PRIORITY);
				p_ticket_tracking.setP_MESSAGE(msg);
				p_ticket_tracking.setPROBLEM_TICKET_RAISED_NAME(PT_USER_NAME);
				p_ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				p_ticket_tracking.setSEVERITY(SEVERITY);
				
				if (updatedFileName == null) {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME("No File Available");
				} else {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME(updatedFileName);
				}
				
				getSession().save(p_ticket_tracking);
				//System.out.println("insert in problem ticket tracking***");

				/////////////////////////// UPDATE PROBLEM TICKET TABLE ////////////////
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket SET PROBLEM_STATUS='" + CurrentStatus+ "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
/////////////////////////// UPDATE PROBLEM TICKET ASSIGNED TABLE ////////////////
				int j = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket_assigned SET PROBLEM_STATUS='" + CurrentStatus + "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		///////////////////// INSERT IN PROBLEM TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
			
					Criteria critAct = sessionFactory.getCurrentSession().createCriteria(problem_ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) critAct.uniqueResult();
			
					//System.out.println(" actSrno1 IS: " + actSrno1);
			
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				
				
				List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserComapany+"' and USERNAME='"+LoginUser+"'").list();
				for(loginmaster lmc:lm)
				{
					fullname=lmc.getFULL_NAME();
					emailid=lmc.getEMAIL();
					phone=lmc.getPHONE();
				}
				
				problem_ticket_activity_log problemticketActivityLog = new problem_ticket_activity_log();
			
				
			//	//System.out.println("loginRoleType   "+loginRoleType);
				problemticketActivityLog.setSR_NO(ActSno);
				problemticketActivityLog.setPT_ID(tid);
				problemticketActivityLog.setPRIORITY(PRIORITY);
				problemticketActivityLog.setPROBLEM_STATUS(CurrentStatus);
				problemticketActivityLog.setPT_DATETIME(currenttime);
				problemticketActivityLog.setPT_CHANGEBY(LoginUser);
				problemticketActivityLog.setPT_SUBJECT(PT_SUBJECT);
				problemticketActivityLog.setPT_DESC(PT_DESC);
				problemticketActivityLog.setRCA_NOTES(causeNotes);
				problemticketActivityLog.setFIX_NOTES(fixNotes);
				problemticketActivityLog.setWORKAROUND_NOTES(workaroundNotes);
				problemticketActivityLog.setROLE_TYPE(loginRoleType);
				problemticketActivityLog.setPT_CATEGORY(T_PROBLEM_CATEGORY);
				problemticketActivityLog.setPT_SUB_CATEGORY1(T_PROBLEM_SUBCAT1);
				problemticketActivityLog.setPT_SUB_CATEGORY2(T_PROBLEM_SUBCAT2);
				problemticketActivityLog.setSEVERITY(SEVERITY);

				problemticketActivityLog.setPT_CONTACT_NO(phone);
			problemticketActivityLog.setPT_EMAIL(emailid);
			problemticketActivityLog.setPT_COMPANY(loginUserComapany);
			problemticketActivityLog.setPT_FULLNAME(fullname);	
			//	problemticketActivityLog.set
				
				if (updatedFileName == null) {
					problemticketActivityLog.setPT_ATTACH_NAME("No File Available");
				} else {
					problemticketActivityLog.setPT_ATTACH_NAME(updatedFileName);
				}
			
				sessionFactory.getCurrentSession().persist(problemticketActivityLog);
			
			////////////////////FOR PROBLEM SLA //////////////////////
			try {
				//System.out.println("IN CALCULATE PROBLEM SLA");
				////// GETTING SLA DATA ////////////
				String PROBLEM_STATUS="";
				String SLA_TYPE="";
				String RCA_TARGET_SECONDS="";
				String RCA_START_TIME="";
				String RCA_SLA_STATUS="NA";
				
				Query queryGetSLAData = sessionFactory.getCurrentSession().createQuery("FROM problem_sla where PT_ID=:PT_ID");
				queryGetSLAData.setParameter("PT_ID", tid);
	    		List<problem_sla> SLAData = queryGetSLAData.list();
	    		for (problem_sla SLADrive : SLAData) {

	    			SLA_TYPE=SLADrive.getSLA_TYPE();
	    			RCA_TARGET_SECONDS=SLADrive.getRCA_TARGET_SECONDS();
	    			RCA_START_TIME=SLADrive.getRCA_START_TIME();
	    		}
	    		//System.out.println("SLA_TYPE: "+SLA_TYPE);
	    		//System.out.println("RCA_TARGET_SECONDS: "+RCA_TARGET_SECONDS);
    			//System.out.println("RCA_START_TIME: "+RCA_START_TIME);
    			//System.out.println("RCA_END_TIME: "+currenttime);
    			
    			if(!SLA_TYPE.equals("Not Set")) {
    				//System.out.println("SLA_TYPE FOUND : "+SLA_TYPE);
	    		/////////////// CALCULATING SLA /////////////
	    			    			
	    			Date RCAstartdatetemp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(RCA_START_TIME);
	    			Date RCAenddatetemp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(currenttime);
	    			Date RCAstartDate = RCAstartdatetemp;// Set start date
					Date RCAendDate = RCAenddatetemp;// Set end date
					long RCAduration = RCAendDate.getTime() - RCAstartDate.getTime();

					long RCAdiffInSeconds = TimeUnit.MILLISECONDS.toSeconds(RCAduration);
					long RCAdiffInMinutes = TimeUnit.MILLISECONDS.toMinutes(RCAduration);
					long RCAdiffInHours = TimeUnit.MILLISECONDS.toHours(RCAduration);
					long RCAdiffInDays = TimeUnit.MILLISECONDS.toDays(RCAduration);

					//System.out.println("diffInDays: " + RCAdiffInDays);
					//System.out.println("diffInHours: " + RCAdiffInHours);
					//System.out.println("diffInMinutes: " + RCAdiffInMinutes);
					//System.out.println("diffInSeconds: " + RCAdiffInSeconds);
					
					///////////////// START DATE TO END DATE DURATION Starts///////
					int day_RCAStartEndDate = (int) TimeUnit.SECONDS.toDays(RCAdiffInSeconds);
					long hours_RCAStartEndDate = TimeUnit.SECONDS.toHours(RCAdiffInSeconds) - (day_RCAStartEndDate * 24);
					long minute_RCAStartEndDate = TimeUnit.SECONDS.toMinutes(RCAdiffInSeconds)
							- (TimeUnit.SECONDS.toHours(RCAdiffInSeconds) * 60);
					long second_RCAStartEndDate = TimeUnit.SECONDS.toSeconds(RCAdiffInSeconds)
							- (TimeUnit.SECONDS.toMinutes(RCAdiffInSeconds) * 60);

					String day_RCAStartEndDate1 = "";
					String hours_RCAStartEndDate1 = "";
					String minute_RCAStartEndDate1 = "";
					String second_RCAStartEndDate1 = "";

					if (day_RCAStartEndDate != 0) {
						day_RCAStartEndDate1 = Integer.toString(day_RCAStartEndDate) + " Days ";
					}
					if (hours_RCAStartEndDate != 0) {
						hours_RCAStartEndDate1 = Long.toString(hours_RCAStartEndDate) + " Hours ";
					}
					if (minute_RCAStartEndDate != 0) {
						minute_RCAStartEndDate1 = Long.toString(minute_RCAStartEndDate) + " Minutes ";
					}
					if (second_RCAStartEndDate != 0) {
						second_RCAStartEndDate1 = Long.toString(second_RCAStartEndDate) + " Seconds ";
					}

					String RCAStartEndDateDuration = day_RCAStartEndDate1 + hours_RCAStartEndDate1 + minute_RCAStartEndDate1
							+ second_RCAStartEndDate1;
					//System.out.println("RCA START & END DATE DURATION: " + RCAStartEndDateDuration);
					String RCA_ELAPSED_SECONDS=Long.toString(RCAdiffInSeconds);
					//System.out.println("RCA START & END DURATION IN SECONDS: " + RCA_ELAPSED_SECONDS);
					///////////////// START DATE TO END DATE DURATION Ends///////
					
					///////////// COMPARISON WITH TARGET SLA /////////////
					if(SLA_TYPE.equals("Advanced"))
					{
					if(RCAdiffInSeconds<=Integer.parseInt(RCA_TARGET_SECONDS))
					{RCA_SLA_STATUS="SLA Met";
					}
					else 
					{RCA_SLA_STATUS="SLA Breach";}
					}
					//System.out.println("RCA_SLA_STATUS: "+RCA_SLA_STATUS);

				///////////////// UPDATING SLA DATA ////////////
				Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,PROBLEM_STATUS=:PROBLEM_STATUS,RCA_END_TIME=:RCA_END_TIME,RCA_ELAPSED_TIME=:RCA_ELAPSED_TIME,RCA_ELAPSED_SECONDS=:RCA_ELAPSED_SECONDS,RCA_SLA_STATUS=:RCA_SLA_STATUS,FIX_START_TIME=:FIX_START_TIME WHERE PT_ID=:PT_ID");
				querySLA.setParameter("PRIORITY", PRIORITY);
				querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
				querySLA.setParameter("RCA_END_TIME", currenttime);
				querySLA.setParameter("RCA_ELAPSED_TIME", RCAStartEndDateDuration);
				querySLA.setParameter("RCA_ELAPSED_SECONDS", RCA_ELAPSED_SECONDS);
				querySLA.setParameter("RCA_SLA_STATUS", RCA_SLA_STATUS);
				querySLA.setParameter("FIX_START_TIME", currenttime);
				querySLA.setParameter("PT_ID", tid);
				
				querySLA.executeUpdate();
    			
    			} else {
    				//System.out.println("SLA_TYPE FOUND : "+SLA_TYPE);
    				Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,PROBLEM_STATUS=:PROBLEM_STATUS WHERE PT_ID=:PT_ID");
					querySLA.setParameter("PRIORITY", PRIORITY);
					querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
					querySLA.setParameter("PT_ID", tid);
					querySLA.executeUpdate();
    			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			///////////// FOR EMAIL/SMS ////////////////
			String Problem_ID=tid;
			String Problem_Status=CurrentStatus;
			String Problem_Subject=PT_SUBJECT;
			String Problem_Category=T_PROBLEM_CATEGORY;
			String Problem_Priority=PRIORITY;
			String Problem_Branch=PT_USER_BRANCH;
			String Problem_Department=PT_USER_DEPARTMENT;
//			String TP_NAME=TP_NAME;
//			String TP_EMAIL=TP_EMAIL;
//			String TP_PHONE=TP_PHONE;
			String ENGG_NAME=LoginUser;

			Inv.RaiseNCloseProblemEmailSMS(Problem_ID,Problem_Status);

			status="success";
			
		} catch (Exception e) {
			e.printStackTrace();
			status="failed";
		}
		return status;
	}

	@Override
	public JSONArray getEngFixInProcessProblemTickets(String loginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String LoginUser=null;
		String LoginScope=null;
		String enggGroup=null;
		String companyname=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			companyname = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
				List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' AND COMPANY='"+companyname+"'").list();
							for (loginmaster loginObj : loginset) {
								enggGroup=loginObj.getGROUP_NAME().replace(",","','");
								//System.out.println("ENGG GROUP FOUND: "+enggGroup);
							}
			
//			List<problem_ticket_resolved> dataSet = sessionFactory.getCurrentSession().createQuery("from problem_ticket_resolved where PROBLEM_STATUS='Root Cause Analysis' AND ENGINEER_NAME='" + loginUser + "' ORDER BY STR_TO_DATE(PT_ASSIGN_DATE, '%d-%m-%Y %H:%i:%s') DESC").list();
							List<Object[]> problemTicketList = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM (select tr.PT_ID,tr.PROBLEM_STATUS,tr.PT_PRIORITY,tr.SEVERITY,tr.PT_SUBJECT,tr.PT_USER_COMPANY as T_COMPANY,tr.PT_USER_BRANCH as T_BRANCH,tr.PT_USER_DEPARTMENT as T_DEPARTMENT,tr.T_PROBLEM_CATEGORY,tr.T_PROBLEM_SUBCAT1,tr.T_PROBLEM_SUBCAT2,tr.TP_NAME,ta.TP_FULLNAME,ta.PT_ASSIGN_TO,ta.ENGINEER_NAME as ass,ta.ENGINEER_FULLNAME as afn,ta.ENGINEER_GROUP,tr.ENGINEER_NAME,tr.ENGINEER_FULLNAME,tr.PT_ASSIGN_DATE,tr.PT_RCA_DATE,tr.PT_FIXINPROCESS_DATE as FIXINPROCESS_DATE ,ta.PT_ENGINEER_COMPANY as PT_ENGINEER_COMPANY FROM problem_ticket_resolved tr JOIN  problem_ticket_assigned ta ON tr.PT_ID=ta.PT_ID) inn where PROBLEM_STATUS='Fix In Process' AND ("+LoginScope+") AND ( PT_ENGINEER_COMPANY='"+companyname+"'  AND  ENGINEER_NAME='"+LoginUser+"' OR (ENGINEER_GROUP IN ('"+enggGroup+"') and PROBLEM_STATUS='Fix In Process'))  ORDER BY STR_TO_DATE(FIXINPROCESS_DATE,'%d-%m-%Y %H:%i:%s') DESC").list();				
			array = new JSONArray();
			for (Object[] listData : problemTicketList) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' "
						+ "onclick='ViewProblemTicket(\""+ listData[0] +"\")'><i class='fa fa-eye'></i></button>");
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateProblemTicket(\""+listData[0]+"\")'><i class='fa fa-edit'></i></button>");

				array1.put(listData[0]);
				array1.put(listData[1]);
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[11]);
				array1.put(listData[12]);
				if(listData[13].equals("Engineer"))
				{
					array1.put(listData[14]);
				}
				else
				{
					array1.put(listData[16]);
				}
				array1.put(listData[15]);
				array1.put(listData[17]);
				array1.put(listData[18]);
				array1.put(listData[19]);
				array1.put(listData[20]);
				array1.put(listData[21]);
				
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public String UpdateResolveProblemTicket(String tid, String causeNotes, String fixNotes,
			String workaroundNotes, String resolveNotes, MultipartFile ResolveFilePic) {
		//System.out.println("INSIDE UpdateFixProblemTicket DAO IMPL");
		String status="";
		String LoginUser = null;
		String loginRoleType="";
		String companyname=null;
		String fullnameOflogin="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			companyname = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			fullnameOflogin = session.getAttribute("fullname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			
/////////////////////////////////// FOR FILE UPLOAD /////////////////
			//System.out.println("RCAFilePic FILE NAME IN DAO_IMPL: " + ResolveFilePic.getOriginalFilename());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + ResolveFilePic.getSize());
			//System.out.println("RCAFilePic FILE SIZE IN DAO_IMPL: " + ResolveFilePic.getSize());

			String fileNameWithOutExt = FilenameUtils.removeExtension(ResolveFilePic.getOriginalFilename());
			//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
//String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + tid;
			//System.out.println("createnewfilename***" + createnewfilename);
//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//System.out.println("Directory is created!");
						} else {
							//System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//System.out.println("directory create exception" + e);
				}

				String fileName = ResolveFilePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
                //File uploadedFile =  empPic;
//				File uploadedFile = new File(ResolveFilePic.getOriginalFilename());   
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(ResolveFilePic.getBytes());
				fos.close();
				
//				String fileName = ResolveFilePic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);

                //File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				
				updatedFileName = createnewfilename + "." + ext;

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}
////////////////////////////////////FILE UPLOAD ENDS ///////////////
			
			String currenttime = null;
			DateFormat dateFormat = null;

			//////////// FETCHING DATA FROM problem_ticket_assigned table ///////////
			String PT_RAISE_DATE="";
			String PT_USER_NAME="";
			String PT_USER_EMAIL="";
			String PT_USER_PHONE="";
			String PT_USER_COMPANY="";
			String PT_USER_BRANCH="";
			String PT_USER_DEPARTMENT="";
			String T_PROBLEM_CATEGORY="";
			String T_PROBLEM_SUBCAT1="";
			String T_PROBLEM_SUBCAT2="";
			String PT_SUBJECT="";
			String PT_DESC="";
			String PRIORITY="";
//			String PROBLEM_STATUS="";
			String TP_NAME="";
			String TP_EMAIL="";
			String TP_PHONE="";
//			String ENGINEER_NAME="";
			String PT_ASSIGN_DATE="";
			String RESOLVE_ENGG_NAME="";
			String CurrentStatus="Resolved";
			String ResolutionCode="Standard";
			String SEVERITY="";
			String fullname = "";
			String emailid = "";
			String phone = "";
			String loginUserCompany = "";
						
			Query problemticketassignedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_assigned where PT_ID=:PT_ID");
			problemticketassignedtable.setParameter("PT_ID", tid);
    		List<problem_ticket_assigned> ticketList = problemticketassignedtable.list();
    		for (problem_ticket_assigned ticketDrive : ticketList) {

				PT_RAISE_DATE=ticketDrive.getPT_RAISE_DATE();
				PT_USER_NAME=ticketDrive.getPT_USER_NAME();
				PT_USER_EMAIL=ticketDrive.getPT_USER_EMAIL();
				PT_USER_PHONE=ticketDrive.getPT_USER_PHONE();
				PT_USER_COMPANY=ticketDrive.getPT_USER_COMPANY();
				PT_USER_BRANCH=ticketDrive.getPT_USER_BRANCH();
				PT_USER_DEPARTMENT=ticketDrive.getPT_USER_DEPARTMENT();
				T_PROBLEM_CATEGORY=ticketDrive.getT_PROBLEM_CATEGORY();
				T_PROBLEM_SUBCAT1=ticketDrive.getT_PROBLEM_SUBCAT1();
				T_PROBLEM_SUBCAT2=ticketDrive.getT_PROBLEM_SUBCAT2();
				PT_SUBJECT=ticketDrive.getPT_SUBJECT();
				PT_DESC=ticketDrive.getPT_DESC();
				PRIORITY=ticketDrive.getPRIORITY();
				SEVERITY=ticketDrive.getSEVERITY();
				
//				PROBLEM_STATUS=ticketDrive.getPROBLEM_STATUS();
				TP_NAME=ticketDrive.getTP_NAME();
				TP_EMAIL=ticketDrive.getTP_EMAIL();
				TP_PHONE=ticketDrive.getTP_PHONE();
//				ENGINEER_NAME=ticketDrive.getENGINEER_NAME();
				PT_ASSIGN_DATE=ticketDrive.getPT_ASSIGN_DATE();
			}
    		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			currenttime = dateFormat.format(date);
			//System.out.println("CURRENT TIME: "+currenttime);

			///////////////////// INSERT OR UPDATE IN PROBLEM TICKET RESOLVED TABLE //////////////////
			try {
//				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
//						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				
				Query problemticketresolvedtable = sessionFactory.getCurrentSession().createQuery("FROM problem_ticket_resolved where PT_ID=:PT_ID");
				problemticketresolvedtable.setParameter("PT_ID", tid);
	    		List<problem_ticket_resolved> resolvedticketList = problemticketresolvedtable.list();
	    		
				if (resolvedticketList.isEmpty()) {
					//System.out.println("IN INSERT PROBLEM TICKET RESOLVED");
//					problem_ticket_resolved queryTicketResolvedInsert = new problem_ticket_resolved();
//					queryTicketResolvedInsert.setPT_ID(tid);
//					queryTicketResolvedInsert.setPT_ASSIGN_DATE(PT_ASSIGN_DATE);
//					queryTicketResolvedInsert.setPT_RCA_DATE(currenttime);
////					queryTicketResolvedInsert.setPT_FIXINPROCESS_DATE();
////					queryTicketResolvedInsert.setPT_RESOLVE_DATE();
//					queryTicketResolvedInsert.setPT_USER_NAME(PT_USER_NAME);
//					queryTicketResolvedInsert.setPT_USER_EMAIL(PT_USER_EMAIL);
//					queryTicketResolvedInsert.setPT_USER_PHONE(PT_USER_PHONE);
//					queryTicketResolvedInsert.setPT_USER_COMPANY(PT_USER_COMPANY);
//					queryTicketResolvedInsert.setPT_USER_BRANCH(PT_USER_BRANCH);
//					queryTicketResolvedInsert.setPT_USER_DEPARTMENT(PT_USER_DEPARTMENT);
//					queryTicketResolvedInsert.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
//					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
//					queryTicketResolvedInsert.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
//					queryTicketResolvedInsert.setPT_SUBJECT(PT_SUBJECT);
//					queryTicketResolvedInsert.setPT_DESC(PT_DESC);
//					queryTicketResolvedInsert.setPT_PRIORITY(PRIORITY);
//					queryTicketResolvedInsert.setPROBLEM_STATUS(CurrentStatus);
//					queryTicketResolvedInsert.setTP_NAME(TP_NAME);
//					queryTicketResolvedInsert.setTP_EMAIL(TP_EMAIL);
//					queryTicketResolvedInsert.setTP_PHONE(TP_PHONE);
//					queryTicketResolvedInsert.setENGINEER_NAME(ENGINEER_NAME);
//					queryTicketResolvedInsert.setCAUSE_NOTES(causeNotes);
//					queryTicketResolvedInsert.setPT_FIXINPROCESS_DATE(fixNotes);
//					queryTicketResolvedInsert.setFIX_NOTES(fixNotes);
////					queryTicketResolvedInsert.setFIX_NOTES();
////					queryTicketResolvedInsert.setWORKAROUND();
////					queryTicketResolvedInsert.setRESOLVE_NOTES();
////					queryTicketResolvedInsert.setRESOLUTION_CODE();
//					
//					getSession().save(queryTicketResolvedInsert);

				} else {
					//System.out.println("IN UPDATE PROBLEM TICKET RESOLVED");
					int f = sessionFactory.getCurrentSession()
							.createQuery("UPDATE problem_ticket_resolved SET ENGINEER_NAME='" + LoginUser + "',ENGINEER_FULLNAME='"+fullnameOflogin+"',PROBLEM_STATUS='" + CurrentStatus + "',PT_RESOLVE_DATE='" + currenttime + "',CAUSE_NOTES='" + causeNotes + "',FIX_NOTES='" + fixNotes + "',WORKAROUND='" + workaroundNotes + "',RESOLVE_NOTES='" + resolveNotes + "',RESOLUTION_CODE='" + ResolutionCode + "',PT_RESOLVED_ENGINEER_COMPANY='"+companyname+"',current_activity_time='"+currenttime+"' WHERE PT_ID='" + tid + "'")
							.executeUpdate();
					if (f > 0) {
						//System.out.println("update in problem ticket resolved****");

					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			///////////////////////// INSERT IN PROBLEM TICKET TRACKING TABLE /////////////////////
			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from problem_ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					//System.out.println("SRNO temp: "+temp);
					sno = temp+1;
				}
				//System.out.println("SRNO to insert: "+sno);
//				String msg = "Engineer " +ENGINEER_NAME+" changed status to "+CurrentStatus+" on "+currenttime;
				
				String msg = null;
				msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>"+CurrentStatus+"</td></tr>"
						+ "<tr><td>Engg Name:</td><td>"+LoginUser+"</td></tr>";

				problem_ticket_tracking p_ticket_tracking = new problem_ticket_tracking();
				p_ticket_tracking.setSR_NO(sno);
				p_ticket_tracking.setPT_ID(tid);
				p_ticket_tracking.setACTIVITY_DATE(currenttime);
				p_ticket_tracking.setACTIVITY_NAME(LoginUser);
				p_ticket_tracking.setACTIVITY_NAME_COMPANY(companyname);
				p_ticket_tracking.setT_PROBLEM_CATEGORY(T_PROBLEM_CATEGORY);
				p_ticket_tracking.setT_PROBLEM_SUBCAT1(T_PROBLEM_SUBCAT1);
				p_ticket_tracking.setT_PROBLEM_SUBCAT2(T_PROBLEM_SUBCAT2);
				p_ticket_tracking.setPT_SUBJECT(PT_SUBJECT);
				p_ticket_tracking.setPROBLEM_STATUS(CurrentStatus);
				p_ticket_tracking.setPRIORITY(PRIORITY);
				p_ticket_tracking.setP_MESSAGE(msg);
				p_ticket_tracking.setPROBLEM_TICKET_RAISED_NAME(PT_USER_NAME);
				p_ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				p_ticket_tracking.setSEVERITY(SEVERITY);
				if (updatedFileName == null) {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME("No File Available");
				} else {
					p_ticket_tracking.setPROBLEM_ATTACHMENT_NAME(updatedFileName);
				}
				
				getSession().save(p_ticket_tracking);
				//System.out.println("insert in problem ticket tracking***");

				/////////////////////////// UPDATE PROBLEM TICKET TABLE ////////////////
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket SET PROBLEM_STATUS='" + CurrentStatus+ "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
/////////////////////////// UPDATE PROBLEM TICKET ASSIGNED TABLE ////////////////
				int j = sessionFactory.getCurrentSession().createQuery("UPDATE problem_ticket_assigned SET PROBLEM_STATUS='" + CurrentStatus + "',CURRENT_ACTIVITY_TIME='"+currenttime+"' Where PT_ID='" + tid + "'").executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			///////////////////// INSERT IN PROBLEM TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
			
					Criteria critAct = sessionFactory.getCurrentSession().createCriteria(problem_ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) critAct.uniqueResult();
			
					//System.out.println(" actSrno1 IS: " + actSrno1);
			
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				
				List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+companyname+"' and USERNAME='"+LoginUser+"'").list();
				for(loginmaster lmc:lm)
				{
					fullname=lmc.getFULL_NAME();
					emailid=lmc.getEMAIL();
					phone=lmc.getPHONE();
				}
				problem_ticket_activity_log problemticketActivityLog = new problem_ticket_activity_log();
			
				problemticketActivityLog.setSR_NO(ActSno);
				problemticketActivityLog.setPT_ID(tid);
				problemticketActivityLog.setPRIORITY(PRIORITY);
				problemticketActivityLog.setPROBLEM_STATUS(CurrentStatus);
				problemticketActivityLog.setPT_DATETIME(currenttime);
				problemticketActivityLog.setPT_CHANGEBY(LoginUser);
				problemticketActivityLog.setPT_SUBJECT(PT_SUBJECT);
				problemticketActivityLog.setPT_DESC(PT_DESC);
				problemticketActivityLog.setRCA_NOTES(causeNotes);
				problemticketActivityLog.setFIX_NOTES(fixNotes);
				problemticketActivityLog.setWORKAROUND_NOTES(workaroundNotes);
				problemticketActivityLog.setRESOLVE_NOTES(resolveNotes);
				problemticketActivityLog.setROLE_TYPE(loginRoleType);
				problemticketActivityLog.setPT_CATEGORY(T_PROBLEM_CATEGORY);
				problemticketActivityLog.setPT_SUB_CATEGORY1(T_PROBLEM_SUBCAT1);
				problemticketActivityLog.setPT_SUB_CATEGORY2(T_PROBLEM_SUBCAT2);
				problemticketActivityLog.setSEVERITY(SEVERITY);

				problemticketActivityLog.setPT_CONTACT_NO(phone);
			problemticketActivityLog.setPT_EMAIL(emailid);
			problemticketActivityLog.setPT_COMPANY(companyname);
			problemticketActivityLog.setPT_FULLNAME(fullname);
								
				if (updatedFileName == null) {
					problemticketActivityLog.setPT_ATTACH_NAME("No File Available");
				} else {
					problemticketActivityLog.setPT_ATTACH_NAME(updatedFileName);
				}
			
				sessionFactory.getCurrentSession().persist(problemticketActivityLog);
			
				////////////////////FOR PROBLEM SLA //////////////////////
			try {
				//System.out.println("IN CALCULATE PROBLEM SLA");
				////// GETTING SLA DATA ////////////
				String PROBLEM_STATUS="";
				String SLA_TYPE="";
				String FIX_TARGET_SECONDS="";
				String FIX_START_TIME="";
				String FIX_SLA_STATUS="NA";
				
				Query queryGetSLAData = sessionFactory.getCurrentSession().createQuery("FROM problem_sla where PT_ID=:PT_ID");
				queryGetSLAData.setParameter("PT_ID", tid);
	    		List<problem_sla> SLAData = queryGetSLAData.list();
	    		for (problem_sla SLADrive : SLAData) {

	    			SLA_TYPE=SLADrive.getSLA_TYPE();
	    			FIX_TARGET_SECONDS=SLADrive.getFIX_TARGET_SECONDS();
	    			FIX_START_TIME=SLADrive.getFIX_START_TIME();
	    		}
	    		//System.out.println("SLA_TYPE: "+SLA_TYPE);
	    		//System.out.println("FIX_TARGET_SECONDS: "+FIX_TARGET_SECONDS);
    			//System.out.println("FIX_START_TIME: "+FIX_START_TIME);
    			//System.out.println("FIX_END_TIME: "+currenttime);
    			
    			if(!SLA_TYPE.equals("Not Set")) {
    				//System.out.println("SLA_TYPE FOUND : "+SLA_TYPE);
	    		/////////////// CALCULATING SLA /////////////
	    			    			
	    			Date FIXstartdatetemp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(FIX_START_TIME);
	    			Date FIXenddatetemp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(currenttime);
	    			Date FIXstartDate = FIXstartdatetemp;// Set start date
					Date FIXendDate = FIXenddatetemp;// Set end date
					long FIXduration = FIXendDate.getTime() - FIXstartDate.getTime();

					long FIXdiffInSeconds = TimeUnit.MILLISECONDS.toSeconds(FIXduration);
					long FIXdiffInMinutes = TimeUnit.MILLISECONDS.toMinutes(FIXduration);
					long FIXdiffInHours = TimeUnit.MILLISECONDS.toHours(FIXduration);
					long FIXdiffInDays = TimeUnit.MILLISECONDS.toDays(FIXduration);

					//System.out.println("diffInDays: " + FIXdiffInDays);
					//System.out.println("diffInHours: " + FIXdiffInHours);
					//System.out.println("diffInMinutes: " + FIXdiffInMinutes);
					//System.out.println("diffInSeconds: " + FIXdiffInSeconds);
					
					///////////////// START DATE TO END DATE DURATION Starts///////
					int day_FIXStartEndDate = (int) TimeUnit.SECONDS.toDays(FIXdiffInSeconds);
					long hours_FIXStartEndDate = TimeUnit.SECONDS.toHours(FIXdiffInSeconds) - (day_FIXStartEndDate * 24);
					long minute_FIXStartEndDate = TimeUnit.SECONDS.toMinutes(FIXdiffInSeconds)
							- (TimeUnit.SECONDS.toHours(FIXdiffInSeconds) * 60);
					long second_FIXStartEndDate = TimeUnit.SECONDS.toSeconds(FIXdiffInSeconds)
							- (TimeUnit.SECONDS.toMinutes(FIXdiffInSeconds) * 60);

					String day_FIXStartEndDate1 = "";
					String hours_FIXStartEndDate1 = "";
					String minute_FIXStartEndDate1 = "";
					String second_FIXStartEndDate1 = "";

					if (day_FIXStartEndDate != 0) {
						day_FIXStartEndDate1 = Integer.toString(day_FIXStartEndDate) + " Days ";
					}
					if (hours_FIXStartEndDate != 0) {
						hours_FIXStartEndDate1 = Long.toString(hours_FIXStartEndDate) + " Hours ";
					}
					if (minute_FIXStartEndDate != 0) {
						minute_FIXStartEndDate1 = Long.toString(minute_FIXStartEndDate) + " Minutes ";
					}
					if (second_FIXStartEndDate != 0) {
						second_FIXStartEndDate1 = Long.toString(second_FIXStartEndDate) + " Seconds ";
					}

					String FIXStartEndDateDuration = day_FIXStartEndDate1 + hours_FIXStartEndDate1 + minute_FIXStartEndDate1
							+ second_FIXStartEndDate1;
					//System.out.println("FIX START & END DATE DURATION: " + FIXStartEndDateDuration);
					String FIX_ELAPSED_SECONDS=Long.toString(FIXdiffInSeconds);
					//System.out.println("FIX START & END DURATION IN SECONDS: " + FIX_ELAPSED_SECONDS);
					///////////////// START DATE TO END DATE DURATION Ends///////
					
					///////////// COMPARISON WITH TARGET SLA /////////////
					if(SLA_TYPE.equals("Advanced"))
					{
					if(FIXdiffInSeconds<=Integer.parseInt(FIX_TARGET_SECONDS))
					{FIX_SLA_STATUS="SLA Met";
					}
					else 
					{FIX_SLA_STATUS="SLA Breach";}
					}
					//System.out.println("RCA_SLA_STATUS: "+FIX_SLA_STATUS);

				///////////////// UPDATING SLA DATA ////////////
				Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,PROBLEM_STATUS=:PROBLEM_STATUS,FIX_END_TIME=:FIX_END_TIME,FIX_ELAPSED_TIME=:FIX_ELAPSED_TIME,FIX_ELAPSED_SECONDS=:FIX_ELAPSED_SECONDS,FIX_SLA_STATUS=:FIX_SLA_STATUS WHERE PT_ID=:PT_ID");
				querySLA.setParameter("PRIORITY", PRIORITY);
				querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
				querySLA.setParameter("FIX_END_TIME", currenttime);
				querySLA.setParameter("FIX_ELAPSED_TIME", FIXStartEndDateDuration);
				querySLA.setParameter("FIX_ELAPSED_SECONDS", FIX_ELAPSED_SECONDS);
				querySLA.setParameter("FIX_SLA_STATUS", FIX_SLA_STATUS);
				querySLA.setParameter("PT_ID", tid);
				
				querySLA.executeUpdate();
    			
    			} else {
    				//System.out.println("SLA_TYPE FOUND : "+SLA_TYPE);
    				Query querySLA = sessionFactory.getCurrentSession().createQuery("update problem_sla set PRIORITY=:PRIORITY,PROBLEM_STATUS=:PROBLEM_STATUS WHERE PT_ID=:PT_ID");
					querySLA.setParameter("PRIORITY", PRIORITY);
					querySLA.setParameter("PROBLEM_STATUS", CurrentStatus);
					querySLA.setParameter("PT_ID", tid);
					querySLA.executeUpdate();
    			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
///////////// FOR EMAIL/SMS ////////////////
			String Problem_ID=tid;
			String Problem_Status=CurrentStatus;
			String Problem_Subject=PT_SUBJECT;
			String Problem_Category=T_PROBLEM_CATEGORY;
			String Problem_Priority=PRIORITY;
			String Problem_Branch=PT_USER_BRANCH;
			String Problem_Department=PT_USER_DEPARTMENT;
//			String TP_NAME=TP_NAME;
//			String TP_EMAIL=TP_EMAIL;
//			String TP_PHONE=TP_PHONE;
			String ENGG_NAME=LoginUser;

			Inv.RaiseNCloseProblemEmailSMS(Problem_ID,Problem_Status);

			status="success";
			
		} catch (Exception e) {
			e.printStackTrace();
			status="failed";
		}
		return status;
	}

	@Override
	public JSONArray getAllProblemTicketListEng(String ticketList) {
		//System.out.println("INSIDE getAllProblemTicketListEng DAO IMPL");
		JSONArray array = null;
		JSONArray array1 = null;
		String output = "";
		String LoginUser="";
		String LoginScope="";
		String enggGroup="";
		String companyname=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			companyname = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' AND COMPANY='"+companyname+"'").list();
			for (loginmaster loginObj : loginset) {
				enggGroup=loginObj.getGROUP_NAME().replace(",","','");
				//System.out.println("ENGG GROUP FOUND: "+enggGroup);
			}
		try {

			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(
					"SELECT * FROM (SELECT ptr.PT_ID as T_ID, ptr.PROBLEM_STATUS as status1, ptr.PT_PRIORITY, ptr.SEVERITY,ptr.PT_SUBJECT,pta.PT_USER_COMPANY AS T_COMPANY,pta.PT_USER_BRANCH AS T_BRANCH, pta.PT_USER_DEPARTMENT AS T_DEPARTMENT, ptr.T_PROBLEM_CATEGORY,ptr.T_PROBLEM_SUBCAT1,ptr.T_PROBLEM_SUBCAT2, pta.PT_ASSIGN_TO,ptr.TP_NAME,pta.TP_FULLNAME, pta.ENGINEER_NAME AS ENGINEER_NAME,pta.ENGINEER_FULLNAME,ptr.ENGINEER_NAME as gfgddg,ptr.ENGINEER_FULLNAME as fgfg,pta.ENGINEER_GROUP AS ENGINEER_GROUP,pta.PT_ENGINEER_COMPANY as PT_ENGINEER_COMPANY,COALESCE(pta.PT_RAISE_DATE, 'NA'),COALESCE(ptr.PT_ASSIGN_DATE,'NA')as ASSIGN_DATE,COALESCE(ptr.PT_RCA_DATE,'NA'),COALESCE(ptr.PT_FIXINPROCESS_DATE,'NA'),COALESCE(ptr.PT_RESOLVE_DATE,'NA'),COALESCE(pta.PT_CLOSEDATE, 'NA') from  problem_ticket_assigned  pta LEFT JOIN problem_ticket_resolved  ptr ON ptr.PT_ID=pta.PT_ID ) main WHERE   ("+LoginScope+") AND ( ENGINEER_NAME='"+LoginUser+"'  and PT_ENGINEER_COMPANY='"+companyname+"' OR (ENGINEER_GROUP IN('"+enggGroup+"') )) order by  STR_TO_DATE(ASSIGN_DATE ,\r\n" + 
							"       '%d-%m-%Y %H:%i:%s') desc").list();
			array = new JSONArray();
			for (Object[] listData : l) {

				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' "
						+ "onclick='ViewProblemTicket(\""+ listData[0] +"\")'><i class='fa fa-eye'></i></button>");
							
				array1.put(listData[0]);
				array1.put(listData[1]);      
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[12]);
				array1.put(listData[13]);
				if(listData[11].equals("Engineer"))
				{
					array1.put(listData[14]);
				}
				else
				{
					array1.put(listData[18]);
				}
				array1.put(listData[15]);
				array1.put(listData[16]);
				array1.put(listData[17]);
				array1.put(listData[20]);
				array1.put(listData[21]);
				array1.put(listData[22]);
				array1.put(listData[23]);
				array1.put(listData[24]);
				array1.put(listData[25]);
				
				array.put(array1);

		
	
			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public JSONArray CheckENGTicketUpdateConflict(String ticketid,String CurrentStatus ,String priviousetpnaame, String priviouseemail,String currentselectgrp, String crrentselecengg, String currentatassignto) 
	{
		//System.out.println("INSIDE CheckENGTicketUpdateConflictforReassign DAO IMPL");
		JSONArray finalArray = new JSONArray();
		//System.out.println("TICKET ID TO CHECK: "+ticketid+"status"+CurrentStatus);
		//System.out.println("ASSIGN BY NAAME  "+ priviousetpnaame);
		//System.out.println("ASSIGN BY EMAIL    "+ priviouseemail);
		
		String LoginUser = null;
		String loginRoleType="";
		String ENGG_GROUP_NAME="";
		String PREVIOUS_ENG_STATUS="";
		String PREVIOUS_ENG_NAME="";
		String ASSIGNED_TICKET_STATUS="";
		String RESOLVED_TICKET_STATUS="";
		String PREVIOUS_ENG_SOLUTION="";
		String PREVIOUS_ENG_SOLUTION_DATE="";
		String Role_typevalu="";
		String PREVIOUSTPNAME="";
		String TPSTATUS="";
		String NOTES="";
		String TPASSIGNDATE="";
		String Assignenggname="";
		String Assigndatae="";
		String Tp_NAME="";
		String TP_COMPANY="";
		String TP_NOTES="";
		String resolve_enggname="";
		String resolveenggcompany="";
		String resolve_date="";
		String resolve_solution="";
		String resolvestatus="";
		String EnggGroup="";
		String EnggGroupFORSPLIT="";
		String ENggCOMPANYIS="";
		String loginUserCompany="";
		boolean groupfalse=false;
		boolean enggnameorcom=false;
		String engiorgroupforswal="";
		String priviouseengorgroupforswal="";
		String previousActivityDoneBy="";
		String PreviousActivityBy="";
		String Roll_Type="";
		String FullName="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster loginObj : loginset) {
			
			EnggGroupFORSPLIT=loginObj.getGROUP_NAME();
		//	//System.out.println("ENGG GROUP FOUND: "+enggGroup);
		}
	if(	currentatassignto.equals("Group")) {
		engiorgroupforswal=currentselectgrp;
	}
	else if(	currentatassignto.equals("Engineer")) {
	String splitselect[]=	crrentselecengg.split("~");
		engiorgroupforswal=splitselect[0]+"~"+splitselect[2];
	}
//////////////CHECK IF TICKET BELONGS TO GROUP
		try {
			Query queryticket_assigned = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_ID='" + ticketid+"'");
			ticket_assigned ticket_assigned_data = (ticket_assigned) queryticket_assigned.uniqueResult();
			if (ticket_assigned_data != null) {
				//System.out.println("IN TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = ticket_assigned_data.getT_ASSIGN_TO();
				ASSIGNED_TICKET_STATUS= ticket_assigned_data.getT_STATUS();
				Assignenggname=	ticket_assigned_data.getENGINEER_NAME();
				ENggCOMPANYIS=ticket_assigned_data.getENGINEER_COMPANY();
				Assigndatae=ticket_assigned_data.getT_ASSIGN_DATE();
				Tp_NAME=ticket_assigned_data.getTP_NAME();
				TP_COMPANY=	ticket_assigned_data.getTP_COMPANY();
				TP_NOTES=ticket_assigned_data.getTP_HOLD_NOTES();
				EnggGroup=ticket_assigned_data.getENGINEER_GROUP();
//				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULL_NAME from  loginmaster where COMPANY='"+TP_COMPANY+"' and USERNAME='"+Tp_NAME+"'");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					Roll_Type=obj[0].toString();
//					FullName=obj[1].toString();
//				}
//				
//					
//		Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) where T_ID='"+ticketid+"') ");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					Roll_Type=obj[0].toString();
//					FullName=obj[1].toString();
//					Tp_NAME=obj[2].toString();
//					
//				}
				
				
		Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,T_FULLNAME ,T_CHANGEBY from  ticket_activity_log where SR_NO=(select max(SR_NO)from ticket_activity_log where T_ID='"+ticketid+"') ");
				
				List<Object[]> listOfRU=qfor.list();
				for(Object[]  obj:listOfRU)
				{
					Roll_Type=obj[0].toString();
					FullName=obj[1].toString();
					Tp_NAME=obj[2].toString();
					
				}
				
				System.out.println("fullName ======"+FullName);
				System.out.println("Loginuser=========="+Roll_Type);
				if(ENGG_GROUP_NAME .equals("Group")) {
					
				priviouseengorgroupforswal=	EnggGroup;
				}else {
					priviouseengorgroupforswal=Assignenggname+"~"+ENggCOMPANYIS;
				}
				
				////GET INFO FROM TICKET RESOLVE///////////
				
				//if(ASSIGNED_TICKET_STATUS.equals("Work in Progress")) {
				Query QUERYTICKETASSIGN = sessionFactory.getCurrentSession().createQuery("from ticket_resolved where T_ID='" + ticketid+"'");
			List<ticket_resolved>  	 TICKETRESOLVEDATA2 = QUERYTICKETASSIGN.list();
				
				if (!TICKETRESOLVEDATA2.isEmpty()) {
					
					for(ticket_resolved TICKETRESOLVEDATA:TICKETRESOLVEDATA2 ) {
				
					resolve_enggname=	TICKETRESOLVEDATA.getRESOLVED_ENGINEER_NAME();
					resolveenggcompany=		TICKETRESOLVEDATA.getRESOLVED_ENGINEER_COMPANY();
					resolve_date=			TICKETRESOLVEDATA.getRESOLVED_DATE();
					resolve_solution=	TICKETRESOLVEDATA.getSOLUTION();
					resolvestatus=TICKETRESOLVEDATA.getT_STATUS();
					}
				}
				//}
			////GET INFO FROM TICKET RESOLVE///////////
				if (ENGG_GROUP_NAME.equals("Group")) {
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				String particulargroup[]=	EnggGroupFORSPLIT.split(",");
				for(String dumgroup:particulargroup) {
					
					if(dumgroup.equals(EnggGroup)) {
						groupfalse=true;
					}
				}
				
				}else if(ENGG_GROUP_NAME.equals("Engineer")) {
					
					if(Assignenggname.equals(LoginUser) && ENggCOMPANYIS.equals(loginUserCompany)) {
						
						enggnameorcom=	true;
					}
					
				}
				
				
				
				if (ENGG_GROUP_NAME.equals("Group")) {
					
					if(CurrentStatus.equals("Re-Assigned")) {
					
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) ||  (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Assigned") && groupfalse)|| ( CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && groupfalse) ) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							finalArray.put(Jobj);
							
						}
					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && groupfalse) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							finalArray.put(Jobj);
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								
								
								finalArray.put(Jobj);
						}else if((CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) || (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Assigned")  && groupfalse ) || ( CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && groupfalse)){
							
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							//fail
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							finalArray.put(Jobj);
							
						}
					}
					
				
						
						
						//passs
					}
				else {
					
					if(CurrentStatus.equals("Re-Assigned")) {
					
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom ) ||  (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Assigned") && enggnameorcom)|| ( CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && enggnameorcom) ) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							finalArray.put(Jobj);
							
						}
					
					

					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && enggnameorcom) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							finalArray.put(Jobj);
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								
								finalArray.put(Jobj);
						}else if((CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom ) || (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Assigned")  && enggnameorcom ) || ( CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && enggnameorcom)){
							
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							//fail
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					
				
						
						
						//passs
					}

					
				}
				
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	}

	
	
	//---vip pages-----
	
	@Override
	public JSONArray getVIPHoldTickets() {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggGroup = "";
		String LoginUser = "";
		String loginUserCompany = "";
		String ASSIGNED_ENGINEER_NAME = "NA";
		String ASSIGNED_ENGINEER_DATE = "NA";
		
		try {
			String LoginScope = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				LoginScope = session.getAttribute("loginscope").toString();
				//System.out.println("username****" + LoginUser);
				//System.out.println("LoginScope****" + LoginScope);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
		//////GET ENGINEERS DATA////
					List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
					for (loginmaster loginObj : loginset) {
						enggGroup=loginObj.getGROUP_NAME().replace(",", "','");
					}
					
			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession()
					.createQuery("from ticket_assigned  Where T_STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare') AND (VIP_TICKET='true' OR VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR (ENGINEER_GROUP IN('"+enggGroup+"') and T_STATUS IN ('Hold','Awaiting User Information','Pending With Vendor','Waiting for Spare'))) ORDER BY STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s') DESC").list();
			array = new JSONArray();
			for (ticket_assigned newObj : dataSet) {
				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='ResolveTicket(\""+ newObj.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");

				array1.put(newObj.getT_ID());
				array1.put(newObj.getT_STATUS());
				array1.put(newObj.getT_PRIORITY());
				array1.put(newObj.getT_SEVERITY());
				array1.put(newObj.getT_SUBJECT());
				array1.put(newObj.getT_COMPANY());
				array1.put(newObj.getT_BRANCH());
				array1.put(newObj.getT_DEPARTMENT());
				array1.put(newObj.getT_CATEGORY());
				array1.put(newObj.getT_SUBCATEGORY1());
				array1.put(newObj.getT_SUBCATEGORY2());
				array1.put(newObj.getTP_NAME());
				if(newObj.getTP_FULLNAME() == null) {
					array1.put("NA");
				}
				else 
				{
				array1.put(newObj.getTP_FULLNAME());
				}
				if(newObj.getT_ASSIGN_TO().equals("Engineer")){
				array1.put(newObj.getENGINEER_NAME());
				}
				else
				{
				array1.put(newObj.getENGINEER_GROUP());
				}
				if(newObj.getENGINEER_FULLNAME() == null ) {
					array1.put("NA");
				}
				else {
				array1.put(newObj.getENGINEER_FULLNAME());
				}
				array1.put(newObj.getT_RAISE_DATE());
				array1.put(newObj.getT_ASSIGN_DATE());

				array.put(array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	
	
	@Override
	public JSONArray getVIPReAssignedEngTickets(String LoginUser) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String output = "";
		String enggCategory="";
		String enggGroup="";
		String LoginScope="";
		String loginUserCompany="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		try {
			//////GET ENGINEERS DATA////
					List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
					for (loginmaster loginObj : loginset) {
						enggCategory=loginObj.getCATEGORY();
						enggGroup=loginObj.getGROUP_NAME().replace(",","','");
						//System.out.println("ENGG GROUP FOUND: "+enggGroup);
					}

			List<ticket_assigned> dataSet = sessionFactory.getCurrentSession()
					.createQuery("from ticket_assigned where T_STATUS='Re-Assigned' and VIP_TICKET='true' AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY T_ASSIGN_DATE DESC").list();
			array = new JSONArray();
			for (ticket_assigned newObj : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");

				array1.put(newObj.getT_ID());
				array1.put(newObj.getT_STATUS());
				array1.put(newObj.getT_PRIORITY());
				array1.put(newObj.getT_SEVERITY());
				array1.put(newObj.getT_SUBJECT());
				array1.put(newObj.getT_COMPANY());
				array1.put(newObj.getT_BRANCH());
				array1.put(newObj.getT_DEPARTMENT());
				array1.put(newObj.getT_CATEGORY());
				array1.put(newObj.getT_SUBCATEGORY1());
				array1.put(newObj.getT_SUBCATEGORY2());
				array1.put(newObj.getTP_NAME());
				if(newObj.getTP_FULLNAME() == null ) {
					
					array1.put("NA");
				}
				else {
					array1.put(newObj.getTP_FULLNAME());
				}
				
				if(newObj.getT_ASSIGN_TO().equals("Engineer")){
					array1.put(newObj.getENGINEER_NAME());
				}
				else
				{
					array1.put(newObj.getENGINEER_GROUP());
				}
				if(newObj.getENGINEER_FULLNAME() == null) {
					array1.put("NA");
				}
				else {
					array1.put(newObj.getENGINEER_FULLNAME());
				}
				
				array1.put(newObj.getT_RAISE_DATE());
				array1.put(newObj.getT_ASSIGN_DATE());
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public JSONArray CheckProblemUpdateConflict(String ticketid, String statusChange) {
		//System.out.println("INSIDE CheckProblemUpdateConflict DAO IMPL");
		JSONArray finalArray = new JSONArray();
		//System.out.println("PROBLEM TICKET ID TO CHECK: "+ticketid);
		//System.out.println("PROBLEM TICKET STATUS CHANGE: "+statusChange);
		
		String LoginUser = null;
		String loginRoleType="";
		String fullnameOflogin="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		try {
			////////////// CHECK IF TICKET BELONGS TO GROUP
			String ENGG_GROUP_NAME="";
			String PREVIOUS_ENG_STATUS="";
			String PREVIOUS_ENG_NAME="";
			String ASSIGNED_TICKET_STATUS="";
			String RESOLVED_TICKET_STATUS="";
			String TICKET_CLOSE_DATE="";
			String PREVIOUS_ENG_SOLUTION="";
			String PREVIOUS_ENG_SOLUTION_RCA_DATE="";
			String PREVIOUS_ENG_SOLUTION_FIX_DATE="";
			String PREVIOUS_ENG_SOLUTION_RESOLVE_DATE="";
			Query queryproblem_ticket_assigned = sessionFactory.getCurrentSession().createQuery("from problem_ticket_assigned where PT_ID='" + ticketid+"'");
			problem_ticket_assigned problem_ticket_assigned_data = (problem_ticket_assigned) queryproblem_ticket_assigned.uniqueResult();
			
			if (problem_ticket_assigned_data != null) {
				//System.out.println("IN PROBLEM TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = problem_ticket_assigned_data.getPT_ASSIGN_TO();
				ASSIGNED_TICKET_STATUS= problem_ticket_assigned_data.getPROBLEM_STATUS();
				TICKET_CLOSE_DATE= problem_ticket_assigned_data.getPT_CLOSEDATE();
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				//////////////// GETTING PREVIOUS ENGG DATA //////////////
				Query queryproblem_ticket_resolved = sessionFactory.getCurrentSession().createQuery("from problem_ticket_resolved where PT_ID='" + ticketid+"'");
				problem_ticket_resolved problem_ticket_resolved_data = (problem_ticket_resolved) queryproblem_ticket_resolved.uniqueResult();
				if (problem_ticket_resolved_data != null) {
					//System.out.println("IN TICKET RESOLVED DATA FOUND");
					PREVIOUS_ENG_NAME = problem_ticket_resolved_data.getENGINEER_NAME();
					RESOLVED_TICKET_STATUS = problem_ticket_resolved_data.getPROBLEM_STATUS();
//					PREVIOUS_ENG_SOLUTION = problem_ticket_resolved_data.getSOLUTION();
					PREVIOUS_ENG_SOLUTION_RCA_DATE = problem_ticket_resolved_data.getPT_RCA_DATE();
					PREVIOUS_ENG_SOLUTION_FIX_DATE = problem_ticket_resolved_data.getPT_FIXINPROCESS_DATE();
					PREVIOUS_ENG_SOLUTION_RESOLVE_DATE = problem_ticket_resolved_data.getPT_RESOLVE_DATE();
					//System.out.println("PREVIOUS_ENG_NAME FOUND: " + PREVIOUS_ENG_NAME);
					//System.out.println("PROBLEM_TICKET_STATUS FOUND: " + RESOLVED_TICKET_STATUS);
//					//System.out.println("PREVIOUS_ENG_SOLUTION FOUND: " + PREVIOUS_ENG_SOLUTION);
					//System.out.println("PREVIOUS_ENG_SOLUTION_RCA_DATE FOUND: " + PREVIOUS_ENG_SOLUTION_RCA_DATE);
					//System.out.println("PREVIOUS_ENG_SOLUTION_FIX_DATE FOUND: " + PREVIOUS_ENG_SOLUTION_FIX_DATE);
					//System.out.println("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE FOUND: " + PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
					
					////////////////// CHECK IF PREVIOUS & CURRENT ENGINEER IS SAME //////////
					if(PREVIOUS_ENG_NAME.equals(LoginUser)) {
						//System.out.println("ENGINEER MATCH FOUND");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Pass");
						Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
						Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//						Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
						Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
						Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
						Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
						Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
						finalArray.put(Jobj);
					}
					else {
						//System.out.println("ENGINEER MATCH NOT FOUND");
						
						/////////////// COMPARE ASSIGN & RESOLVED TICKET STATUS ///////////////
						if(statusChange.equals("Root Cause Analysis")) {
							//System.out.println("IN Root Cause Analysis");
							if(RESOLVED_TICKET_STATUS.equals(statusChange) || RESOLVED_TICKET_STATUS.equals("Fix In Process") || RESOLVED_TICKET_STATUS.equals("Resolved") || RESOLVED_TICKET_STATUS.equals("Closed")) {
							//System.out.println("STATUS MATCH FOUND");
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
							Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//							Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
							Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
							Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
							Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
							Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
							finalArray.put(Jobj);
							
							}
						} else if(statusChange.equals("Fix In Process")) {
							//System.out.println("IN Fix In Process");
							if(RESOLVED_TICKET_STATUS.equals(statusChange) || RESOLVED_TICKET_STATUS.equals("Resolved") || RESOLVED_TICKET_STATUS.equals("Closed")) {
								//System.out.println("STATUS MATCH FOUND");
								
								JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
								Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//								Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
								Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
								finalArray.put(Jobj);
								
							} else if(RESOLVED_TICKET_STATUS.equals("Root Cause Analysis")) {
								//System.out.println("STATUS MISMATCH FOUND");
								
								JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Warning");
								Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
								Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//								Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
								Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
								finalArray.put(Jobj);
							}
						} else if(statusChange.equals("Resolved")) {
							//System.out.println("IN Resolved");
							if(RESOLVED_TICKET_STATUS.equals(statusChange) || RESOLVED_TICKET_STATUS.equals("Closed")) {
								//System.out.println("STATUS MATCH FOUND");
								
								JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
								Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//								Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
								Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
								finalArray.put(Jobj);
								
							} else if(RESOLVED_TICKET_STATUS.equals("Fix In Process")) {
								//System.out.println("STATUS MISMATCH FOUND");
								
								JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Warning");
								Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
								Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//								Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
								Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
								Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
								finalArray.put(Jobj);
							}
						}

					}
				} else {
					//System.out.println("IN TICKET RESOLVED DATA NOT FOUND");
					JSONObject Jobj= new JSONObject();
					Jobj.put("STATUS", "Pass");
					Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
					Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//					Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
					Jobj.put("PREVIOUS_ENG_SOLUTION_RCA_DATE", PREVIOUS_ENG_SOLUTION_RCA_DATE);
					Jobj.put("PREVIOUS_ENG_SOLUTION_FIX_DATE", PREVIOUS_ENG_SOLUTION_FIX_DATE);
					Jobj.put("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE", PREVIOUS_ENG_SOLUTION_RESOLVE_DATE);
					Jobj.put("TICKET_CLOSE_DATE", TICKET_CLOSE_DATE);
					finalArray.put(Jobj);
				}
			} 
//			else {
//				//System.out.println("IN TICKET ASSIGNED NOT DATA FOUND");
//				JSONObject Jobj= new JSONObject();
//				Jobj.put("STATUS", "Pass");
//				Jobj.put("PREVIOUS_ENG_NAME", PREVIOUS_ENG_NAME);
//				Jobj.put("RESOLVED_TICKET_STATUS", RESOLVED_TICKET_STATUS);
//				Jobj.put("PREVIOUS_ENG_SOLUTION", PREVIOUS_ENG_SOLUTION);
//				Jobj.put("PREVIOUS_ENG_SOLUTION_DATE", PREVIOUS_ENG_SOLUTION_DATE);
//				finalArray.put(Jobj);
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	}

	
	@Override
	public JSONArray getenggAssingRequest(String LoginUser) {

		System.out.println("INSIDE GETASSIGN DAO ENGG");

		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String LoginScope = "";
		String output = "";
		String enggCategory = "";
		String enggGroup = "";
		String company = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		try {
			////// GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + company + "'")
					.list();
			for (loginmaster loginObj : loginset) {
				enggCategory = loginObj.getCATEGORY();
				enggGroup = loginObj.getGROUP_NAME().replace(",", "','");
				System.out.println("ENGG GROUP FOUND: " + enggGroup);
			}

			List<service_request> dataSet = sessionFactory.getCurrentSession().createQuery(
					"from service_request where ( ("+LoginScope+") AND (( STATUS in('Assigned','Hold','Re-Assigned','Awaiting User Information','Pending With Vendor','Reject','Resolved','Waiting for Spare')) AND ASSIGN_ENGG_COMPANY='"
							+ company + "' and  ASSIGN_ENGG_NAME='" + LoginUser + "' or ASSIGN_ENGG_GROUP in('"
							+ enggGroup
							+ "') and (STATUS in('Assigned','Hold','Re-Assigned','Awaiting User Information','Pending With Vendor','Reject','Resolved','Waiting for Spare')))) 	order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc")
					.list();
			array = new JSONArray();
			for (service_request sourceDrive : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				if(sourceDrive.getSTATUS().equals("Reject") ||sourceDrive.getSTATUS().equals("Resolved"))
				{
					array1.put(" ");
				}	
				else
				{
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");
				}
				array1.put(sourceDrive.getT_ID());
				
				array1.put(sourceDrive.getSTATUS());
				array1.put(sourceDrive.getPRIORITY());
				array1.put(sourceDrive.getSEVERITY());
				array1.put(sourceDrive.getT_SUBJECT());
				array1.put(sourceDrive.getT_COMPANY());
				array1.put(sourceDrive.getT_BRANCH());
				array1.put(sourceDrive.getT_DEPARTMENT());
				array1.put(sourceDrive.getT_CATEGORY());
				array1.put(sourceDrive.getT_SUBCAT1());
				array1.put(sourceDrive.getT_SUBCAT2());
				array1.put(sourceDrive.getTP_ASSIGN_BY_NAME());
				if(sourceDrive.getTP_ASSIGN_BY_FULLNAME() == null) 
				{
					array1.put("NA");	
				}else {
				array1.put(sourceDrive.getTP_ASSIGN_BY_FULLNAME());
				}
				if(sourceDrive.getASSIGN_TO().equals("Engineer"))
				{
					array1.put(sourceDrive.getASSIGN_ENGG_NAME());	
				}
				else
				{
					array1.put(sourceDrive.getASSIGN_ENGG_GROUP());
				}
				if(sourceDrive.getASSIGN_ENGG_FULLNAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getASSIGN_ENGG_FULLNAME());
				}
				if(sourceDrive.getREQUEST_TYPE()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getREQUEST_TYPE());
				}
				if(sourceDrive.getAPPROVAL_LEVEL()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getAPPROVAL_LEVEL());
				}
				if(sourceDrive.getLEVEL_1_APPROVER_NAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_1_APPROVER_NAME());
				}
				if(sourceDrive.getLEVEL_1_APPROVER_FULLNAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_1_APPROVER_FULLNAME());
				}
				
				if(sourceDrive.getLEVEL_1_STATUS()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_1_STATUS());
				}
				
				if(sourceDrive.getLEVEL_2_APPROVER_NAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_2_APPROVER_NAME());
				}
				
				if(sourceDrive.getLEVEL_2_APPROVER_FULLNAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_2_APPROVER_FULLNAME());
				}
				
				if(sourceDrive.getLEVEL_2_STATUS()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_2_STATUS());
				}
				array1.put(sourceDrive.getT_DATE());
				if(sourceDrive.getLEVEL_1_TIMESTAMP()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_1_TIMESTAMP());
				}
				if(sourceDrive.getLEVEL_2_TIMESTAMP()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_2_TIMESTAMP());
				}
				if(sourceDrive.getREQUEST_ASSIGN_DATE()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getREQUEST_ASSIGN_DATE());
				}
				
				array.put(array1);
			}
			
//			System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public JSONArray EditAssignRequest(String tid, String loginUser) {

		System.out.println("INSIDE EditAssignTickets");
		System.out.println("TID: " + tid);
		System.out.println("LOGIN USER: " + loginUser);
		int ticketid = 0;
		String raisedate = "";
		String assigndate = "";
		String priority = "";
		String username = "";
		String usermail = "";
		String userphone = "";
		String userbranch = "";
		String tpname = "";
		String tpemail = "";
		String tpphone = "";
		String sol = "NA";
		String usercompany = "";
		String category = "";
		String subcat = "";
		String sub = "";
		String filename = "NA";
		String desc = "";
		String status = "";
		String engname = "";
		String engemail = "";
		String engbranch = "";
		String engphone = "";
		String requestmode = "";
		String severity = "";
		String output = "";
		String current_datee = "";
		String assignByCompany = "";
		JSONArray array = null;
		JSONArray array1 = null;
		String loginUserCompany = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginUserCompany = session.getAttribute("companyname").toString();
			System.out.println("loginUserCompany****" + loginUserCompany);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		try {
//		
//			List<ticket_assigned> ticketassigneddata = sessionFactory.getCurrentSession()
//					.createQuery("from ticket_assigned where T_ID='" + tid+"'").list();
			List<loginmaster> enggdata = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + loginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();
			List<service_request> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from service_request where T_ID='" + tid + "'").list();
//			List<ticket_resolved> ticketresolveddata = sessionFactory.getCurrentSession()
//					.createQuery("from ticket_resolved where T_ID='" + tid+"'").list();
//			
			array1 = new JSONArray();

//			for (ticket_assigned TAssign : ticketassigneddata) {

			for (loginmaster EngData : enggdata) {

				for (service_request TicketData : ticketList) {

					JSONObject arrayobj = new JSONObject();
					/////////// TICKET DATA ////////////
					arrayobj.put("tid", TicketData.getT_ID());
					arrayobj.put("raisedate", TicketData.getT_DATE());
					arrayobj.put("assigndate", TicketData.getREQUEST_ASSIGN_DATE());
					arrayobj.put("priority", TicketData.getPRIORITY());
					arrayobj.put("severity", TicketData.getSEVERITY());
					arrayobj.put("requestmode", TicketData.getREQUEST_MODE());
					arrayobj.put("category", TicketData.getT_CATEGORY());
					arrayobj.put("subcat1", TicketData.getT_SUBCAT1());
					arrayobj.put("subcat2", TicketData.getT_SUBCAT2());
					arrayobj.put("sub", TicketData.getT_SUBJECT());
					arrayobj.put("desc", TicketData.getT_DESC());
					arrayobj.put("status", TicketData.getSTATUS());

					arrayobj.put("REQUESTTYPE", TicketData.getREQUEST_TYPE());
								arrayobj.put("APPROVALLEVEL", TicketData.getAPPROVAL_LEVEL());
								arrayobj.put("PROCESSINGGROUP", TicketData.getASSIGNED_GROUP());
					// arrayobj.put("assignByCompany",TicketData.getASSIGN_ENGG_COMPANY());

					//////////// REQUESTER DATA ////////////////
					arrayobj.put("username", TicketData.getT_REQUESTER());
					List<loginmaster> userList = sessionFactory
							.getCurrentSession().createQuery("from loginmaster where USERNAME='"
									+ TicketData.getT_REQUESTER() + "' and COMPANY='" + TicketData.getT_COMPANY() + "'")
							.list();
					for (loginmaster userDrive : userList) {
						arrayobj.put("usercompany", userDrive.getCOMPANY());
						arrayobj.put("userbranch", userDrive.getBRANCH());
						arrayobj.put("userdepartment", userDrive.getDEPARTMENT());
						arrayobj.put("usermail", userDrive.getEMAIL());
						arrayobj.put("userphone", userDrive.getPHONE());
						arrayobj.put("usersubdepartment", userDrive.getSUB_DEPARTMENT());
						arrayobj.put("userlocation", userDrive.getLOCATION());

					}

					// List<loginmaster> tpList=
					// sessionFactory.getCurrentSession().createQuery("from loginmaster where
					// ").list();

					//////////// TC DATA ////////////////
					System.out.println("dfgdgfg cheking tic data ");
					arrayobj.put("tpname", TicketData.getTP_ASSIGN_BY_NAME());
					// arrayobj.put("assignByCompany",TicketData.getASSIGN_ENGG_COMPANY());
					List<loginmaster> tpList = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + TicketData.getTP_ASSIGN_BY_NAME()
									+ "' and COMPANY='" + TicketData.getTP_ASSIGN_COMPANY() + "'")
							.list();
					for (loginmaster tpDrive : tpList) {
						arrayobj.put("tpcompany", tpDrive.getCOMPANY());
						arrayobj.put("tpbranch", tpDrive.getBRANCH());
						arrayobj.put("tpdepartment", tpDrive.getDEPARTMENT());
						arrayobj.put("tpemail", tpDrive.getEMAIL());
						arrayobj.put("tpphone", tpDrive.getPHONE());

						arrayobj.put("tpsubdepartment", tpDrive.getSUB_DEPARTMENT());
						arrayobj.put("tplocation", tpDrive.getLOCATION());
						arrayobj.put("role_type", tpDrive.getROLE_TYPE());

					}

					/////////////// ENGG DATA ///////////
					arrayobj.put("engname", EngData.getUSERNAME());
					arrayobj.put("engcompany", EngData.getCOMPANY());
					arrayobj.put("engbranch", EngData.getBRANCH());
					arrayobj.put("engdepartment", EngData.getDEPARTMENT());
					arrayobj.put("engemail", EngData.getEMAIL());
					arrayobj.put("engphone", EngData.getPHONE());
					arrayobj.put("enggsubdepartment", EngData.getSUB_DEPARTMENT());
					arrayobj.put("engglocation", EngData.getLOCATION());

//							for (ticket_resolved TResolved : ticketresolveddata) {
					/*
					 * if(TicketData.getENGG_NOTES()==null ||
					 * TicketData.getENGG_NOTES().equals(null) ||
					 * TicketData.getENGG_NOTES().equals("")) { arrayobj.put("sol", "NA"); }else {
					 * arrayobj.put("sol", TicketData.getENGG_NOTES()); }
					 */
//							}				
					array1.put(arrayobj);

				}

			}
//			}
			System.out.println("ARRAY1: " + array1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	@Override
	public String UpdateAssignRequests(String tid, String status, String engname, String engsite, String engemailid,
			String engphone, String username, String usercompany, String userbranch, String useremail, String userphone,
			String tcname, String tcemail, String tcphone, String raisedate, String assigndate, String priority,
			String sub, String description, String category, String subcat1, String subcat2, String solution,
			MultipartFile resolvePic, String severity, String assignTo, String enggcat, String enggassign,
			String engGroup,String userdepartment,String otheremail) {
		System.out.println("INSIDE  UpdateAssignRequests  CONTROLLER ");

		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String methodStatus = "";
		String loginname = "";
		String fullname = "";
		String emailid = "";
		String phone = "";
		String LoginUser = "";
		String loginUserCompany = "";

		try {
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			String fullNameOfLogin="";
			String fullNameOfEngg="";
			String loginRoleType = "";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginRoleType = session.getAttribute("role").toString();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				fullNameOfLogin= session.getAttribute("fullname").toString();
				System.out.println("loginRoleType****" + loginRoleType);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exceptioon e***" + e);
			}

			///////////////// FILE UPLOAD STARTS //////////////
			String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
			System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
			// String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + tid;
			System.out.println("createnewfilename***" + createnewfilename);
			// createnewfilename = createnewfilename.substring(0,
			// createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;
			String company = null;
			String EnggName = "";
			String EngCompany = "";
			String OLD_STATUS="";
			
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							System.out.println("Directory is created!");
						} else {
							System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					System.out.println("directory create exception" + e);
				}
				
				String fileName = resolvePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
//				String pathOfFile = uploadedFile.getPath();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();
				//--------------------------------------------
				// File uploadedFile = empPic;
//				File uploadedFile = new File(resolvePic.getOriginalFilename());
//				uploadedFile.createNewFile();
//				FileOutputStream fos = new FileOutputStream(uploadedFile);
//				fos.write(resolvePic.getBytes());
//				fos.close();
//				System.out.println("uploadedFile::::" + uploadedFile);
//				String fileName = resolvePic.getOriginalFilename();
//				System.out.println("fileName::::" + fileName);
//				ext = FilenameUtils.getExtension(fileName);
//				System.out.println("file_extension::::" + ext);
//				// File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//				System.out.println("destFile........" + destFile);
//				// System.out.println("File........" + imagefilePath + File.separator +
//				// fileName);
//				System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				//--------------------------------------------------------
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME: " + updatedFileName);

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				System.out.println("directory create exception" + e);
			}

			///////////////// FILE UPLOAD ENDS //////////////

			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginname = session.getAttribute("username").toString();
				company = session.getAttribute("companyname").toString();
				fullNameOfLogin = session.getAttribute("fullname").toString();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			

			List<service_request> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='"+tid+"'").list();
		    
			for(service_request oldstatus:gettingoldstatus) {
				OLD_STATUS=	oldstatus.getSTATUS();
			}
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			//////////////// update service request ////////////////////

			if (status.equals("Work in Progress")) {
				try {
				System.out.println("fullNameOfLogin  "+fullNameOfLogin);	
				System.out.println("engemailid  "+engemailid);
					System.out.println("New Status is :: " + status);
					Query query1 = sessionFactory.getCurrentSession()
							.createQuery("UPDATE service_request set STATUS=:st, RESOLVE_NOTE=:enote,RESOLVE_BY_EMAIL=:RESOLVE_BY_EMAIL, RESOLVE_BY_COMPANY=:RESOLVE_BY_COMPANY ,RESOLVE_BY_FULLNAME=:RESOLVE_BY_FULLNAME, RESOLVE_BY_NAME=:RESOLVE_BY_NAME , RESOLVE_DATE=:RESOLVE_DATE ,CURRENT_STATUS_ACTIVITY_TIME='"+currenttime+"' WHERE T_ID=:T_ID");
					query1.setParameter("RESOLVE_BY_COMPANY", company);
					query1.setParameter("RESOLVE_BY_NAME", loginname);
					query1.setParameter("RESOLVE_BY_FULLNAME", fullNameOfLogin);
					query1.setParameter("RESOLVE_BY_EMAIL", engemailid);
					
					query1.setParameter("RESOLVE_DATE", currenttime);
					query1.setParameter("st", status);
					query1.setParameter("enote", solution);

					query1.setParameter("T_ID", tid);

					query1.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (status.equals("Re-Assigned")) {
				System.out.println("fgsgfgfgfg    fg"+status);
				try {

					try {
						System.out.println("assigned Engg Name before split" + enggassign);
						String[] splitEng = enggassign.split("~");
						{
							EnggName = splitEng[0];
							System.out.println("after split" + splitEng[0]);
							fullNameOfEngg=splitEng[1];
							EngCompany = splitEng[2];
							System.out.println("aster split comp" + splitEng[2]);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("Engg Name after split" + EnggName);
					System.out.println("dfgdfgg Engg  Company" + EngCompany);
					System.out.println(" i am in else if condition ");

					Query q2 = sessionFactory.getCurrentSession().createQuery(
							"update service_request set STATUS=:STATUS,TP_ASSIGN_by_NAME=:TP_ASSIGN_by_NAME,TP_ASSIGN_BY_FULLNAME=:TP_ASSIGN_BY_FULLNAME,TP_ASSIGN_COMPANY=:TP_ASSIGN_COMPANY,TP_ASSIGN_BY_EMAIL=:TP_ASSIGN_BY_EMAIL,ASSIGN_TO=:ASSIGN_TO,ASSIGN_ENGG_NAME=:ASSIGN_ENGG_NAME,ASSIGN_ENGG_FULLNAME=:ASSIGN_ENGG_FULLNAME,ASSIGN_ENGG_EMAIL=:ASSIGN_ENGG_EMAIL,ASSIGN_ENGG_COMPANY=:ASSIGN_ENGG_COMPANY,ASSIGN_ENGG_GROUP=:ASSIGN_ENGG_GROUP,ASSIGN_ENGG_NOTE=:ASSIGN_ENGG_NOTE,REQUEST_ASSIGN_DATE=:REQUEST_ASSIGN_DATE,CURRENT_STATUS_ACTIVITY_TIME=:CURRENT_STATUS_ACTIVITY_TIME where T_ID=:T_ID");
					q2.setParameter("STATUS", status);
					q2.setParameter("TP_ASSIGN_by_NAME", loginname);
					q2.setParameter("CURRENT_STATUS_ACTIVITY_TIME", currenttime);
					
					q2.setParameter("TP_ASSIGN_BY_FULLNAME", fullNameOfLogin);
					q2.setParameter("TP_ASSIGN_BY_EMAIL", tcemail);
					q2.setParameter("TP_ASSIGN_COMPANY", company);
					q2.setParameter("ASSIGN_TO", assignTo);
					if (assignTo.equals("Engineer")) {
						q2.setParameter("ASSIGN_ENGG_NAME", EnggName);
						q2.setParameter("ASSIGN_ENGG_COMPANY", EngCompany);
						
						q2.setParameter("ASSIGN_ENGG_FULLNAME", fullNameOfEngg);
						q2.setParameter("ASSIGN_ENGG_EMAIL", otheremail);
						q2.setParameter("ASSIGN_ENGG_GROUP", "NA");
						
					} else if (assignTo.equals("Group")) {
						q2.setParameter("ASSIGN_ENGG_NAME", "NA");
						q2.setParameter("ASSIGN_ENGG_COMPANY", "NA");
						q2.setParameter("ASSIGN_ENGG_GROUP", engGroup);
						q2.setParameter("ASSIGN_ENGG_FULLNAME", "NA");
						q2.setParameter("ASSIGN_ENGG_EMAIL", "NA");
					}
					q2.setParameter("ASSIGN_ENGG_NOTE", solution);
					q2.setParameter("REQUEST_ASSIGN_DATE", currenttime);
					q2.setParameter("T_ID", tid);
					int i = q2.executeUpdate();
					System.out.println("sddfd updated successfully!" + i);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from service_request_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				String FullName="";
//				try {
//					System.out.println("assigned Engg Name before split" + enggassign);
//					String[] splitEng = enggassign.split("~");
//					{
//						EnggName = splitEng[0];
//						System.out.println("after split" + splitEng[0]);
//							
//						EngCompany = splitEng[2];
//						System.out.println("aster split comp" + splitEng[2]);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				System.out.println("EnggName"+EnggName+"enggcomp"+EngCompany);
				 String FullNameOFTo="";
				   Query forfullname=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+EngCompany+"' and USERNAME='"+EnggName+"'");
				   List<loginmaster> lm1=forfullname.list();
				   for(loginmaster lms:lm1)
				   {
					   FullNameOFTo= lms.getFULL_NAME();
				   }
				
				FullName = getLoginMasterData();
				if (status.equals("Work in Progress")) {

					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>"
							+ status + "</td></tr>" + "<tr><td>Engineer:</td><td>" + loginname + "["+FullName+"]</td></tr>";

//					int idd = Integer.parseInt(tid);
//					Inv.RaiseNCloseEmailSMS(idd, username, "Hold", userbranch + "," + loginname, category, sub, engname,
//							priority, userphone, useremail);

				} else if (status.equals("Re-Assigned")) {
//				msg = "Engineer " + engname + " " + status + " Ticket On " + currenttime + " within "
//							+ raiseTime;
					if (assignTo.equals("Engineer")) {
						msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>"
								+ status + "</td></tr>" + "<tr><td>Assigned By:</td><td>" + loginname + "["+FullName+"]</td></tr>"
								+ "<tr><td>Assigned To:</td><td>" + assignTo + "</td></tr>"
								+ "<tr><td>Engineer Name:</td><td>" + engname + "["+FullNameOFTo+"]</td></tr>";
					} else if (assignTo.equals("Group")) {
						msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>"
								+ status + "</td></tr>" + "<tr><td>Assigned By:</td><td>" + loginname + "["+FullName+"]</td></tr>"
								+ "<tr><td>Assigned To:</td><td>" + assignTo + "</td></tr>"
								+ "<tr><td>Group Name:</td><td>" + engGroup + "</td></tr>";
					}

//					int idd = Integer.parseInt(tid);
//					String aa = userbranch + "," + engname;
//					Inv.RaiseNCloseEmailSMS(idd, username, "Resolved", userbranch, category, sub, engname, priority,
//							userphone, useremail);
				}

//				int idd=Integer.parseInt(tid);
//				Inv.RaiseNCloseEmailSMS(idd,engname,status,userbranch,category,sub,username,priority,engphone,engemailid);

				List<loginmaster> lm = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where COMPANY='" + loginUserCompany + "' and USERNAME='" + LoginUser + "'")
						.list();
				for (loginmaster lmc : lm) {
					fullname = lmc.getFULL_NAME();
					emailid = lmc.getEMAIL();
					phone = lmc.getPHONE();
				}
				service_request_tracking ticket_tracking = new service_request_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				ticket_tracking.setACTIVITY_COMPANY(loginUserCompany);
				ticket_tracking.setTICKET_RAISED_BY_COMPANY(usercompany);
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				System.out.println("insert in ticket tracking***");

				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(service_request_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}

				service_request_activity_log ticketActivityLog = new service_request_activity_log();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSTATUS(status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginname);
				ticketActivityLog.setT_SUBJECT(sub);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(solution);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setCOMPANY(loginUserCompany);

				ticketActivityLog.setEMAIL(emailid);

				ticketActivityLog.setCONTACT_NO(phone);
				ticketActivityLog.setFULLNAME(fullname);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				methodStatus = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////SLA START///////////////////////
			try
			{
				
				Query query11 = sessionFactory.getCurrentSession()
						.createQuery("from service_request_sla where TICKET_ID=:TICKET_ID");
				query11.setParameter("TICKET_ID", tid);
				service_request_sla sla4 = (service_request_sla) query11.uniqueResult();
				if (sla4 != null) {
					System.out.println("IN SLA UPDATE");

					Query queryforstatus = sessionFactory.getCurrentSession().createQuery(
							"update service_request_sla set TICKET_STATUS=:TICKET_STATUS where  TICKET_ID=:TICKET_ID");
					queryforstatus.setParameter("TICKET_STATUS",status);
					queryforstatus.setParameter("TICKET_ID", tid);
					queryforstatus.executeUpdate();
					
				}
			}
			catch (Exception e) {
			 e.printStackTrace();
			}
			/////////////////////SLA END////////////////////////////
			
			//////////////////////////////HISTORICAL SLA START//////////////////////////
			try 
			{	
				int SRNO1 = 0;
				try {
				
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(service_request_historical_sla.class).setProjection(Projections.max("SR_NO"));
					Integer SRNO2 = (Integer) crit.uniqueResult();
				
					System.out.println(" SRNO1 IS: " + SRNO2);
				
					if (SRNO2 != null) {
						SRNO1 = SRNO2.intValue();
						SRNO1 = SRNO1 + 1;
						System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
					} else {
						SRNO1 = 1;
						System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}
				if( (( OLD_STATUS.equals("Hold") || OLD_STATUS.equals("Awaiting User Information") || OLD_STATUS.equals("Pending With Vendor") || OLD_STATUS.equals("Waiting for Spare") )&& status.equals("Hold") )|| (( OLD_STATUS.equals("Hold") || OLD_STATUS.equals("Awaiting User Information") || OLD_STATUS.equals("Pending With Vendor") || OLD_STATUS.equals("Waiting for Spare") ) && !status.equals("Hold") ) )
				{
					System.out.println("INSIDE BOTH  HOLD  AND  OLD YES OR CURRENT NOT3 " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
					
					  Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(service_request_historical_sla.class).setProjection(Projections.max("SR_NO") ).add(Restrictions.eq("TICKET_ID", tid));

					 int maxsrno1=(int) criteriaformax.uniqueResult();
					 
					 System.out.println("MAX NO is THAT " + maxsrno1);
				
									
						Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery("update service_request_historical_sla set HOLD_END_DATE=:HOLD_END_DATE,TICKET_STATUS=:TICKET_STATUS  WHERE SR_NO=:SR_NO");
						updathistoricalsla.setParameter("HOLD_END_DATE", currenttime);
						updathistoricalsla.setParameter("SR_NO",maxsrno1);
						updathistoricalsla.setParameter("TICKET_STATUS",status);
						
						int UpdateHistoricalSLa=updathistoricalsla.executeUpdate();
						String GETSTARTHOLDTIME="";
						String GETENDHOLDTIME="";
						System.out.println("VALUE OF CHECK  " + UpdateHistoricalSLa);
						if(UpdateHistoricalSLa!=0)
						{
							System.out.println("INSIDE ELAPSE IF BLOCK");
							Query QUERYFORBOTHDATE=sessionFactory.getCurrentSession().createQuery("from service_request_historical_sla where SR_NO='"+maxsrno1+"'");
							
							List<service_request_historical_sla> historicalvalue=QUERYFORBOTHDATE.list();
							for(service_request_historical_sla getvalue: historicalvalue) {
								
								GETENDHOLDTIME=	getvalue.getHOLD_END_DATE();
								GETSTARTHOLDTIME=	getvalue.getHOLD_START_DATE();
								
							}
							System.out.println("GETENDHOLDTIME VALUE  "+ GETENDHOLDTIME);
							System.out.println("GETSTARTHOLDTIME VALUE  "+ GETSTARTHOLDTIME);
							
							
							 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					            
					              
							  Date stratdate = sdf.parse(GETSTARTHOLDTIME);
					            Date enddate = sdf.parse(GETENDHOLDTIME);
					            
					        long duration = enddate.getTime()- stratdate.getTime();
					  
					           System.out.println("difference_In_Time is   " + duration);
					          

								int diffInSeconds =(int) TimeUnit.MILLISECONDS.toSeconds(duration);
								long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
								long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
								long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
								
								
								System.out.println("diffInDays: " + diffInDays);
								System.out.println("diffInHours: " + diffInHours);
								System.out.println("diffInMinutes: " + diffInMinutes);
								System.out.println("diffInSeconds: " + diffInSeconds);
								
								///////////////// START DATE TO END DATE DURATION Starts///////
								int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
								long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
								long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
										- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
								long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
										- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
								
								String day_StartEndDate1 = "";
								String hours_StartEndDate1 = "";
								String minute_StartEndDate1 = "";
								String second_StartEndDate1 = "";

								if (day_StartEndDate != 0) {
									day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
								}
								if (hours_StartEndDate != 0) {
									hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
								}
								if (minute_StartEndDate != 0) {
									minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
								}
								if (second_StartEndDate != 0) {
									second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
								}

								String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
										+ second_StartEndDate1;
								System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
								System.out.println(" TOTAL ELAPS TIME  IS  " + diffInSeconds);
					            
					               if(!StartEndDateDuration.isEmpty() && diffInSeconds !=0) {
										
										Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery("update service_request_historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
										updateelapsandduration.setParameter("HOLD_ELAPSED_TIME", Integer.valueOf(diffInSeconds).toString());
										updateelapsandduration.setParameter("SR_NO",maxsrno1);
										updateelapsandduration.setParameter("HOLD_DURATION",StartEndDateDuration);
									int check2=	updateelapsandduration.executeUpdate();
									
									System.out.println("check2 value "+ check2);
					            	   
					               }
					     
						}
						if(( OLD_STATUS.equals("Hold") || OLD_STATUS.equals("Awaiting User Information") || OLD_STATUS.equals("Pending With Vendor") || OLD_STATUS.equals("Waiting for Spare") ) && status.equals("Hold") ) {
							
							service_request_historical_sla historicalsla = new service_request_historical_sla();
							
							historicalsla.setSR_NO(SRNO1);
							historicalsla.setTICKET_ID(tid);
						
							historicalsla.setTICKET_STATUS(status);
						
							historicalsla.setSLA_STATUS("NA");
							historicalsla.setHOLD_START_DATE(currenttime);
							historicalsla.setHOLD_END_DATE("NA");
							historicalsla.setHOLD_ELAPSED_TIME("NA");
							
							historicalsla.setHOLD_DURATION("NA");								
							historicalsla.setT_COMPANY(usercompany);
							historicalsla.setT_BRANCH(userbranch);
							historicalsla.setT_DEPARTMENT(userdepartment);
							sessionFactory.getCurrentSession().save(historicalsla);
							
							
						}
				}
				else if(( !OLD_STATUS.equals("Hold") || !OLD_STATUS.equals("Awaiting User Information") || !OLD_STATUS.equals("Pending With Vendor") || !OLD_STATUS.equals("Waiting for Spare") ) && status.equals("Hold") ){
					
					System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
					service_request_historical_sla historicalsla = new service_request_historical_sla();
				
					historicalsla.setSR_NO(SRNO1);
					historicalsla.setTICKET_ID(tid);
				
					historicalsla.setTICKET_STATUS(status);
				
					historicalsla.setSLA_STATUS("NA");
					historicalsla.setHOLD_START_DATE(currenttime);
					historicalsla.setHOLD_END_DATE("NA");
					historicalsla.setHOLD_ELAPSED_TIME("NA");
					
					historicalsla.setHOLD_DURATION("NA");
					
					historicalsla.setT_COMPANY(usercompany);
					historicalsla.setT_BRANCH(userbranch);
					historicalsla.setT_DEPARTMENT(userdepartment);
					
					sessionFactory.getCurrentSession().save(historicalsla);
			
				}
				
			} catch (Exception e) {
			 e.printStackTrace();
			}
			/////////////////////////////HISTORICAL SLA END////////////////////////////
			
			String assign_TO="";
			String engGroupName="";
			String engName="";
			String userPh="";
			String enggcompanyc = "";
		
			Query ls=sessionFactory.openSession().createQuery("from service_request  where T_ID='"+tid+"'");
				List<service_request> list3 = ls.list();
			for(service_request str:list3)
			{
				 assign_TO = str.getASSIGN_TO();
				 engName = str.getASSIGN_ENGG_NAME();
				 userPh= str.getT_PHONE();
				 enggcompanyc = str.getASSIGN_ENGG_COMPANY();
				 engGroupName=str.getASSIGN_ENGG_GROUP();
			}
			status = "success";
			System.out.println("status+"+status);
			try {
				
				if(status.equals("success"))
				Inv.EmailSMSTriggeredForServiceRequest(tid, status,assign_TO,engName,userPh,enggcompanyc,engGroupName);
			}catch(Exception e)
			{
				e.printStackTrace();
			}

			
		} catch (Exception e) {
			methodStatus = "fail";
			e.printStackTrace();

		}

		return methodStatus;
	}


	public JSONArray getResolveRequest2(String loginUser) {
		//System.out.println("INSIDE getResolveRequest2");
		JSONArray array = null;
		JSONArray array1 = null;
		String loginUserCompany="";
		List<service_request> queryTicket1=null;
		int srno = 0;
		String newid="";
		String output = "";
		String LoginUser="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
//			LoginScope = session.getAttribute("loginscope").toString();
//			//System.out.println("username****" + LoginUser);
//			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {


 queryTicket1 = sessionFactory.getCurrentSession()
		.createQuery("from service_request where T_STATUS='Resolved' and T_REQUESTER='"+LoginUser+"' and T_COMPANY='"+loginUserCompany+"'").list();

			array = new JSONArray();
			for (service_request newObj : queryTicket1) {
				srno = srno + 1;
				array1 = new JSONArray();
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ newObj.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

				array1.put(newObj.getT_ID());

					array1.put(newObj.getT_SUBJECT());

					array1.put(newObj.getT_CATEGORY());

					array1.put(newObj.getT_SUBCAT1());

					array1.put(newObj.getT_SUBCAT2());
					
					array1.put(newObj.getSEVERITY());

					array1.put(newObj.getSTATUS());

					array1.put(newObj.getT_DATE());
	
					array1.put(newObj.getREQUEST_ASSIGN_DATE());
	
					array1.put(newObj.getRESOLVE_DATE());
	
					array1.put(newObj.getRESOLVE_BY_NAME());

					array1.put(newObj.getTP_ASSIGN_BY_NAME());

				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public String insertchangeps(String newseverity, String changenote, String oldpriority, String oldseverity,
			String newpriority, String ticketId, String ticketstatus, String engname, String engcompany, String t_branch,
			String subject2, String t_depatment, String t_company,String category,String subcat1,String subcat2,String usercompany,String username,String description) {

		String loginRoleType="";
		String status="";
		int id=0;

		String fullname = "";
			String emailid = "";
			String phone = "";
		String loginuser="";
String company=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginRoleType = session.getAttribute("role").toString();
			loginuser=session.getAttribute("username").toString();
			company=session.getAttribute("companyname").toString();
			//System.out.println("loginRoleType****" + loginRoleType);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
  
			Integer srno1 = (Integer) sessionFactory.getCurrentSession().createCriteria(update_priority_severity.class)
					.setProjection(Projections.max("SR_NO")).uniqueResult();
			//System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//System.out.println("IN ELSE SRNO IS: " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
			try {
		
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);

			try {

				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

//
//				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery("from ticket_tag_master where COMPANY='"+compname+"' and DEPARTMENT='"+department+"'").list();
//				for (ticket_tag_master sourceDrive : tagList) {
//					ticketTag=sourceDrive.getTICKET_TAG();
//				}
//				//System.out.println("TICKET TAG FOUND: "+ticketTag);
//				NewTicketID=ticketTag+"INC"+id;
				
				update_priority_severity tickettable1 = new update_priority_severity();

				tickettable1.setSR_NO(id);
				tickettable1.setT_ID(ticketId);
				tickettable1.setT_SUBJECT(subject2);
				tickettable1.setT_DEPARTMENT(t_depatment);
				tickettable1.setT_BRANCH(t_branch);
				tickettable1.setT_COMPANY(usercompany);
				tickettable1.setENGINEER_COMPANY(engcompany);
				tickettable1.setENGINEER_NAME(engname);
				tickettable1.setENGINEER_NOTES(changenote);
				tickettable1.setREQUEST_DATETIME(currenttime);
				tickettable1.setNEW_PRIORITY(newpriority);
				tickettable1.setNEW_SEVERITY(newseverity);
				tickettable1.setOLD_PRIORITY(oldpriority);
				tickettable1.setOLD_SEVERITY(oldseverity);
			    tickettable1.setSTATUS("Pending");
			
           	sessionFactory.getCurrentSession().persist(tickettable1);

           	status="success";

           	int ActSno = 0;
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				//System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					//System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					//System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}
			
			List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+company+"' and USERNAME='"+loginuser+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
			
			ticket_activity_log ticketActivityLog = new ticket_activity_log();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(ticketId);
			ticketActivityLog.setPRIORITY(newpriority);
			ticketActivityLog.setSEVERITY(newseverity);
			ticketActivityLog.setSTATUS("Pending");
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(engname);
			ticketActivityLog.setT_SUBJECT(subject2);
			ticketActivityLog.setT_DESC(description);
			ticketActivityLog.setCHANGE_NOTES1(changenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_ATTACH_NAME("No File Available");	
			ticketActivityLog.setT_CATEGORY(category);
			ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
			ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
			ticketActivityLog.setT_COMPANY(t_company);
			ticketActivityLog.setT_EMAIL(emailid);
			
			ticketActivityLog.setT_CONTACT_NO(phone);
			ticketActivityLog.setT_FULLNAME(fullname);
			
		

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			
			
			
			////////////////////// INSERT IN TICKET TRACKING /////////////
			
			
			int sno = 0;
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_tracking.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) crit.uniqueResult();

				//System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					sno = srno1.intValue();
					sno = sno + 1;
					//System.out.println("IN IF SNO IS: " + sno);
				} else {
					sno = 1;
					//System.out.println("IN ELSE SNO IS: " + sno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}

			String msg = null;


			msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
					+ "<tr><td>Request is:</td><td>Change Priority And Severity</td></tr>"
					+ "<tr><td>Status:</td><td>Pending</td></tr>"
					+ "<tr><td>Engineer Name:</td><td>"+engname+"</td></tr>"
					+ "<tr><td>Requested Priority:</td><td>"+newpriority+"</td></tr>"
					+ "<tr><td>Requested Severity:</td><td>"+newseverity+"</td></tr>";
		
			
			
			ticket_tracking tickettrack = new ticket_tracking();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(ticketId);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(engname);
			tickettrack.setACTIVITY_NAME_COMPANY(engcompany);
			tickettrack.setCATEGORY(category);
			tickettrack.setSUBCATEGORY1(subcat1);
			tickettrack.setSUBCATEGORY2(subcat2);
			tickettrack.setSUBJECT(subject2);
			tickettrack.setSTATUS("Pending");
			tickettrack.setPRIORITY(newpriority);
			tickettrack.setSEVERITY(newseverity);
			tickettrack.setMESSAGE(msg);
			tickettrack.setATTACHMENT_NAME("No File Available");
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setTICKET_RAISED_NAME(username);
			tickettrack.setTICKET_RAISED_NAME_COMPANY(usercompany);
			
	
			sessionFactory.getCurrentSession().persist(tickettrack);
			status = "success";
           	
           	
           	
           	
			} catch (Exception e1) {
				e1.printStackTrace();
				status="error";
				//System.out.println("Exception e1****" + e1);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			status="error";
			//System.out.println("Exception e1****" + e1);
		}

		return status ;

	
	}

	@Override
	public String insertraisecrf(String tid2, String company2, String branch2, String department2, String sub2,
			String des2, String engnote21,String severity,String priority) {

		String loginRoleType="";
		String status="";
		String username="";
		String engcompany="";
		String fullname = "";
		String emailid = "";
		String phone = "";
		int id=0;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginRoleType = session.getAttribute("role").toString();
			
			username = session.getAttribute("username").toString();
			engcompany = session.getAttribute("companyname").toString();
			//System.out.println("loginRoleType****" + loginRoleType);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
  
//			Integer srno1 = (Integer) sessionFactoryCM.getCurrentSession().createCriteria(EngineerCrfRequest.class).setProjection(Projections.max("SR_NO")).uniqueResult();
//			//System.out.println(" SRNO IS: " + srno1);
//
//			if (srno1 != null) {
//				id = srno1.intValue();
//				id = id + 1;
//				//System.out.println("IN IF SRNO IS: " + id);
//			} else {
//				id = 1;
//				//System.out.println("IN ELSE SRNO IS: " + id);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
			try {
		
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);

			try {

				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

//
//				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery("from ticket_tag_master where COMPANY='"+compname+"' and DEPARTMENT='"+department+"'").list();
//				for (ticket_tag_master sourceDrive : tagList) {
//					ticketTag=sourceDrive.getTICKET_TAG();
//				}
//				//System.out.println("TICKET TAG FOUND: "+ticketTag);
//				NewTicketID=ticketTag+"INC"+id;
				
				EngineerCrfRequest tickettable1 = new EngineerCrfRequest();
				tickettable1.setT_ID(tid2);
				tickettable1.setSR_NO(id);
				tickettable1.setCOMPANY(company2);
				tickettable1.setDEPARTMENT(department2);
				tickettable1.setBRANCH(branch2);
				tickettable1.setENGG_NAME(username);
				tickettable1.setENGG_COMPANY(engcompany);
				tickettable1.setENGG_NOTES(engnote21);
				tickettable1.setSUBJECT(sub2);
				tickettable1.setDESCRIPTION(des2);
				tickettable1.setENG_REQUEST_DATE_TIME(currenttime);
				
			    tickettable1.setSTATUS("Pending");
			
//			    sessionFactoryCM.getCurrentSession().persist(tickettable1);

           	status="success";

           	int ActSno = 0;
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				//System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					//System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					//System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}


List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+engcompany+"' and USERNAME='"+username+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
			
			
			ticket_activity_log ticketActivityLog = new ticket_activity_log();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid2);
			ticketActivityLog.setPRIORITY(priority);
			ticketActivityLog.setSEVERITY(severity);
			ticketActivityLog.setSTATUS("Pending");
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(username);
			ticketActivityLog.setT_SUBJECT(sub2);
			ticketActivityLog.setT_DESC(des2);
			ticketActivityLog.setCHANGE_NOTES1(engnote21);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_ATTACH_NAME("No File Available");	
			ticketActivityLog.setT_COMPANY(engcompany);
			ticketActivityLog.setT_EMAIL(emailid);
			
			ticketActivityLog.setT_CONTACT_NO(phone);
			ticketActivityLog.setT_FULLNAME(fullname);
			
		

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			
			} catch (Exception e1) {
				e1.printStackTrace();
				status="error";
				//System.out.println("Exception e1****" + e1);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			status="error";
			//System.out.println("Exception e1****" + e1);
		}

		return status ;

	
	}
	@Override
	public JSONArray getEnggProblemTicket(String loginuser) {
		//System.out.println("Inside TPActivityDaoImpl getTPDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****sdfgdsgd" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			
			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			//System.out.println("sfdgfsdgfgfdsgretertrt"+LoginScope);
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select DISTINCT A.PROBLEM_STATUS,COUNT(A.PROBLEM_STATUS) from problem_ticket  Pr join problem_ticket_assigned  A on Pr.PT_ID=A.PT_ID where(A.ENGINEER_NAME='"+loginuser+"'   AND A.PT_ENGINEER_COMPANY='"+loginUserCompany+"' ) or  A.ENGINEER_GROUP IN('"+enggGroupList+"')group by A.PROBLEM_STATUS  ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

				if (listData[0].toString().equals("Closed")) {
					record.put("color", "#5c5e5c");
				}
				if (listData[0].toString().equals("Root Cause Analysis")) {
					record.put("color", "#cf391f");
				}
				if (listData[0].toString().equals("Assigned")) {
					record.put("color", "#cf681f");
				}
				if (listData[0].toString().equals("Fix In Process")) {
					record.put("color", "#2129cc");
				}
				
				if (listData[0].toString().equals("Resolved")) {
					record.put("color", "#1d6b32");
				}

				array1.put(record);
				//System.out.println("db_cname: are given below " + array1);

			
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}

	@Override
	public JSONArray getPrblemListing(String ticketList) {

		//System.out.println("INSIDE getAllProblemTicketListEng DAO IMPL");
		JSONArray array = null;
		JSONArray array1 = null;
		String output = "";
		String LoginUser="";
		String LoginScope="";
		String enggGroup="";
		String companyname=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			companyname = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' AND COMPANY='"+companyname+"'").list();
			for (loginmaster loginObj : loginset) {
				enggGroup=loginObj.getGROUP_NAME().replace(",","','");
				//System.out.println("ENGG GROUP FOUND: "+enggGroup);
			}
		try {

			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(
					"Select * FROM (SELECT ptr.PT_ID as T_ID,ptr.PROBLEM_STATUS as status1,ptr.PT_PRIORITY,ptr.SEVERITY,ptr.PT_SUBJECT,pta.PT_USER_COMPANY AS T_COMPANY,pta.PT_USER_BRANCH AS T_BRANCH,pta.PT_USER_DEPARTMENT AS T_DEPARTMENT,ptr.T_PROBLEM_CATEGORY,ptr.T_PROBLEM_SUBCAT1,ptr.T_PROBLEM_SUBCAT2,ptr.PT_USER_NAME,ptr.TP_NAME,ptr.ENGINEER_NAME AS ENGINEER_NAME,pta.ENGINEER_GROUP AS ENGINEER_GROUP,COALESCE(pta.PT_RAISE_DATE,'NA'),COALESCE(ptr.PT_ASSIGN_DATE,'NA')as ASSIGN_DATE,COALESCE(ptr.PT_RCA_DATE,'NA'),COALESCE(ptr.PT_FIXINPROCESS_DATE,'NA'),COALESCE(ptr.PT_RESOLVE_DATE,'NA'),COALESCE(pta.PT_CLOSEDATE,'NA') from problem_ticket_resolved ptr JOIN problem_ticket_assigned pta ON ptr.PT_ID=pta.PT_ID UNION SELECT A.PT_ID AS T_ID,A.PROBLEM_STATUS as status1,A.PRIORITY,A.SEVERITY,A.PT_SUBJECT,A.PT_USER_COMPANY AS T_COMPANY,A.PT_USER_BRANCH AS T_BRANCH,A.PT_USER_DEPARTMENT AS T_DEPARTMENT,A.T_PROBLEM_CATEGORY,A.T_PROBLEM_SUBCAT1,A.T_PROBLEM_SUBCAT2,A.PT_USER_NAME,A.TP_NAME,A.ENGINEER_NAME AS ENGINEER_NAME,A.ENGINEER_GROUP AS ENGINEER_GROUP,COALESCE(A.PT_RAISE_DATE,'NA'),COALESCE(A.PT_ASSIGN_DATE,'NA') as ASSIGN_DATE,'NA','NA','NA',COALESCE(A.PT_CLOSEDATE,'NA') from problem_ticket_assigned A WHERE NOT EXISTS(SELECT B.PT_ID FROM problem_ticket_resolved B where A.PT_ID=B.PT_ID))inn WHERE ("+LoginScope+")  OR ENGINEER_NAME='"+LoginUser+"' OR ENGINEER_GROUP IN('"+enggGroup+"') order by  STR_TO_DATE(ASSIGN_DATE ,\r\n" + 
							"        '%d-%m-%Y %H:%i:%s') desc").list();
			array = new JSONArray();
			for (Object[] listData : l) {

				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' "
						+ "onclick='ViewProblemTicket(\""+ listData[0] +"\")'><i class='fa fa-eye'></i></button>");
							
				array1.put(listData[0]);
				array1.put(listData[1]);
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[11]);
				array1.put(listData[12]);
				array1.put(listData[13]);
				array1.put(listData[14]);
				array1.put(listData[15]);
				array1.put(listData[16]);
				array1.put(listData[17]);
				array1.put(listData[18]);
				array1.put(listData[19]);
				array1.put(listData[20]);
								
				array.put(array1);

			}

			//System.out.println("arrray111" + array);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	
	}

	@Override
	public JSONArray getAllIncidentTicketList(String loginuser, String status) {
		//System.out.println("Inside TPActivityDaoImpl getAllIncidentTicketList methodgjkjgjkk");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****ghkjkjhkdfgfdgfg" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			
			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println("Exceptioonnnnnnnnnnnnnn");
					List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(" select t.T_ID,ta.T_STATUS, t.T_COMPANY, t.T_BRANCH,t.T_DEPARTMENT,ta.T_PRIORITY,ta.T_SEVERITY, ta.T_SUBJECT,ta.T_CATEGORY,ta.T_SUBCATEGORY1,ta.T_SUBCATEGORY2,t.REQUEST_MODE,t.T_REQUESTER,t.T_RAISE_TIME, ta.TP_NAME,ta.T_ASSIGN_TO , ta.ENGINEER_NAME, ta.T_ASSIGN_DATE,tr.RESOLVED_ENGINEER_NAME,tr.T_RESOLVED_TIME,t.T_CLOSEBY,t.T_CLOSEDATE from  ticket t  left join ticket_assigned ta  on t.T_ID=ta.T_ID left join ticket_resolved  tr   on t.T_ID=tr.T_ID   where (t.T_REQUESTER='"+loginuser+"' and t.T_COMPANY='"+loginUserCompany+"' and t.STATUS='"+status+"'  ) or ( ta.ENGINEER_GROUP IN('"+ enggGroupList +"') and t.STATUS='"+status+"') or (ta.ENGINEER_NAME='"+ loginuser +"' and ta.ENGINEER_COMPANY='"+loginUserCompany+"' and t.STATUS='"+status+"')").list();


			array = new JSONArray();
			for (Object[] listData : l) {
				array1 = new JSONArray();
			
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				
				array.put(array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;
	}
	
	@Override
	public JSONArray getAllProblemTicketListDashboard(String loginuser, String status) {
		//System.out.println("Inside getAllProblemTicketListDashboard getTPDashboardData method");
		JSONArray array1 = null;
		JSONArray array =  new JSONArray();
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****fdtyty" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle excption
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			//System.out.println(" i am in getAllProblemTicketListDashboard");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select * from (select t.PT_ID,t.PROBLEM_STATUS as PROBLEM_STATUS,t.PT_COMPANY , t.PT_BRANCH,t.PT_DEPARTMENT ,t.PT_SUBJECT,t.REQUEST_MODE,t.PRIORITY,t.SEVERITY, t.T_PROBLEM_CATEGORY,t.T_PROBLEM_SUBCAT1, t.T_PROBLEM_SUBCAT2,t.PT_REQUESTER,t.PT_DATE,ta.TP_NAME, ta.PT_ASSIGN_TO,ta.ENGINEER_GROUP as ENGINEER_GROUP, ta.ENGINEER_NAME as s,ta.PT_ENGINEER_COMPANY as ENGINEER_COMPANY,ta.PT_ASSIGN_TIME,tr.ENGINEER_NAME, tr.PT_RESOLVE_DATE,tr.PT_FIXINPROCESS_DATE,tr.PT_RCA_DATE,t.PT_CLOSEBY,t.PT_CLOSEDATE from problem_ticket t LEFT JOIN problem_ticket_assigned ta on t.PT_ID=ta.PT_ID  left join problem_ticket_resolved tr on t.PT_ID=tr.PT_ID ) as  inn    where   (PROBLEM_STATUS='"+status+"' and ENGINEER_GROUP IN('"+ enggGroupList +"')) or (s='"+ loginuser +"' and ENGINEER_COMPANY='"+loginUserCompany+"' and PROBLEM_STATUS='"+status+"') ").list();
			
			//array1 =null;
			
			for (Object[] listData : l) {
				
				array1 = new JSONArray();
				
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
			
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
//				if ((listData[26]) == null || (listData[26].toString()).contains("null")
//						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
//						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
//					array1.put("-");
//				} else {
//					array1.put(listData[26]);
//				}
			
				array.put(array1);
				
				
			}
			
			//System.out.println("THIS IS ARRAY   "+array);	
			//System.out.println("THIS IS ARRAY1   "+array1);	
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}

		return array;
	}

	@Override
	public JSONArray getServiceRequestDashboardData(String loginuser) {

		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			//System.out.println("dghgdhdfdsgfg dfrdfewqre");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct STATUS,count(STATUS) from service_request where ( ASSIGN_ENGG_NAME='"+ loginuser +"' and ASSIGN_ENGG_COMPANY='"+loginUserCompany+"') or  (ASSIGN_ENGG_GROUP IN('"+ enggGroupList +"'))   or T_REQUESTER='"+loginuser+"' and  T_COMPANY='"+loginUserCompany+"' group by STATUS ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

				if (listData[0].toString().equals("Closed")) {
					record.put("color", "#5c5e5c");
				}
				if (listData[0].toString().equals("New")) {
					record.put("color", "#cf391f");
				}
				if (listData[0].toString().equals("Assigned")) {
					record.put("color", "#cf681f");
				}
				if (listData[0].toString().equals("Hold")) {
					record.put("color", "#2129cc");
				}
				if (listData[0].toString().equals("Re-Assigned")) {
					record.put("color", "#703912");
				}
				if (listData[0].toString().equals("Resolved")) {
					record.put("color", "#1d6b32");
				}

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
	}

	@Override
	public JSONArray getAllServiceRequestDashboard(String status) {
		


		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String loginuser="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser = session.getAttribute("username").toString();
			
			
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		array= new JSONArray();
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println("cdjchdhc");
		
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select   T_ID,STATUS,REQUEST_TYPE,PRIORITY,SEVERITY,T_SUBJECT,T_COMPANY,T_BRANCH,T_DEPARTMENT,T_CATEGORY,T_SUBCAT1,T_SUBCAT2,ASSIGNED_GROUP,T_REQUESTER,TP_ASSIGN_by_NAME,ASSIGN_TO,ASSIGN_ENGG_NAME,T_DATE,REQUEST_ASSIGN_DATE,RESOLVE_DATE ,COMPLETE_DATE, T_CLOSEBY,T_CLOSEDATE,LEVEL_1_TIMESTAMP,LEVEL_1_APPROVER_NAME,LEVEL_2_TIMESTAMP,LEVEL_2_APPROVER_NAME from service_request where (ASSIGN_ENGG_NAME='"+ loginuser +"' and ASSIGN_ENGG_COMPANY='"+loginUserCompany+"' and STATUS='"+status+"') or ASSIGN_ENGG_GROUP IN('"+ enggGroupList +"')and STATUS='"+status+"' or T_REQUESTER='"+loginuser+"'  and  T_COMPANY='"+loginUserCompany+"' and STATUS='"+status+"'").list();

		
			for (Object[] listData : l) {

				array1 = new JSONArray();
				

				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
				
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
				if ((listData[26]) == null || (listData[26].toString()).contains("null")
						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[26]);
				}
			
				
				array.put(array1);
			}
			//System.out.println("db_cnamedaf: " + array);
			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;

	}
	
	@Override
	public String insertEngRaiseTicketOnBehalf(String name1, String datepicker5, String phone, String emailid, String compname,
			String site, String category, String subcat1, String requestmode, String department, String subject,
			String description, String priority, String severity, MultipartFile empPic, String subDepartment,
			String location, String subcat2, String usernameofraisedby, String vipuser, String t_requester, String assetName, String assetCategory, String assetStatus, String assetCheck, String assetTag,	String  asset_sub_category ,String  asset_Ipaddress) {
		
		int id = 0;
		String status = "";
		String ticketTag="";
		String NewTicketID="";
		
		//System.out.println("EMPIC FILE NAME IN DAO_IMPL: " + empPic.getOriginalFilename());
		//System.out.println("EMPIC FILE SIZE IN DAO_IMPL: " + empPic.getSize());
		//System.out.println("EMPIC FILE SIZE IN DAO_IMPL: " + empPic.getSize());
		String loginname=null;
		String loginRoleType="";
		String loginUserCompany="";
		String FullNameOfLogin="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginRoleType = session.getAttribute("role").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginname=session.getAttribute("username").toString();
			FullNameOfLogin=session.getAttribute("fullname").toString();
			//System.out.println("loginRoleType****" + loginRoleType);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {

			Integer srno1 = (Integer) sessionFactory.getCurrentSession().createCriteria(ticket.class)
					.setProjection(Projections.max("T_SRNO")).uniqueResult();
			//System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//System.out.println("IN ELSE SRNO IS: " + id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e);
		}

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		   LocalDateTime now = LocalDateTime.now();
		   //System.out.println(localdate.format(now));
		   String localDateNow=localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+id;
		//System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));


		String ext = "";
		String updatedFileName = null;
		try {

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//System.out.println("Directory is created!");
						} else {
							//System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//System.out.println("directory create exception" + e);
				}
				String fileName = empPic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
//				String pathOfFile = uploadedFile.getPath();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//-----------------------------------------------------
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
//				uploadedFile.createNewFile();
//				FileOutputStream fos = new FileOutputStream(uploadedFile);
//				fos.write(empPic.getBytes());
//				fos.close();
//				//System.out.println("uploadedFile::::" + uploadedFile);
//				String fileName = empPic.getOriginalFilename();
//				//System.out.println("fileName::::" + fileName);
//				ext = FilenameUtils.getExtension(fileName);
//				//System.out.println("file_extension::::" + ext);
//				// File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//-----------------------------------------------------------
				//System.out.println("destFile........" + destFile);
				// //System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);				
				updatedFileName = createnewfilename + "." + ext;
				//System.out.println("UPDATED FILE NAME: " + updatedFileName);

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//System.out.println("directory create exception" + e);
			}

			

			Date date2 = null;
			date2 = new Date();
			String timeFormat = "HH:mm:ss";
			String dateFormate = "dd-MM-yyyy";
			SimpleDateFormat sdf = null;
			SimpleDateFormat sdf2 = null;
			sdf = new SimpleDateFormat(timeFormat);
			sdf2 = new SimpleDateFormat(dateFormate);

			String cdate = sdf2.format(date2);
			String ctime = sdf.format(date2);

			String mysqldate = "";

			String tppname = null;
			String tppphn = null;
			String tppmail = null;
			String tppuname = null;
			String StrTID = "";
			String fullnamel=null;
			String emailidl=null;
			String contactno=null;
		
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);

			try {

				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

				mysqldate = formatter.format(date);
				//System.out.println("Date!!!!@@@@###$$$$" + formatter.format(date));

				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery("from ticket_tag_master where COMPANY='"+compname+"' and DEPARTMENT='"+department+"'").list();
				for (ticket_tag_master sourceDrive : tagList) {
					ticketTag=sourceDrive.getTICKET_TAG();
				}
				//System.out.println("TICKET TAG FOUND: "+ticketTag);
				NewTicketID=ticketTag+"INC"+id;
				
				ticket tickettable1 = new ticket();

				tickettable1.setT_SRNO(id);
				tickettable1.setT_ID(NewTicketID);
				tickettable1.setT_DATE(currenttime);
				tickettable1.setT_REQUESTER(t_requester);
				tickettable1.setT_REQUESTER_FULLNAME(name1);
				tickettable1.setT_MAIL(emailid);
				tickettable1.setT_PHONE(phone);
				tickettable1.setT_COMPANY(compname);
				tickettable1.setT_BRANCH(site);
				tickettable1.setT_CATEGORY(category);
				tickettable1.setT_SUBCAT1(subcat1);
				tickettable1.setT_SUBCAT2(subcat2);
				tickettable1.setT_SUBJECT(subject);
				tickettable1.setT_DESC(description);
				tickettable1.setSTATUS("New");
				tickettable1.setPRIORITY(priority);
				tickettable1.setSEVERITY(severity);
				tickettable1.setT_RAISE_TIME(currenttime);
				tickettable1.setREQUEST_MODE(requestmode);
				tickettable1.setT_DEPARTMENT(department);
				tickettable1.setVIP_TICKET(vipuser);
				tickettable1.setRAISED_BY_USERNAME(usernameofraisedby);
				tickettable1.setRAISED_BY_FULLNAME(FullNameOfLogin);
				tickettable1.setRAISED_BY_COMPANY(loginUserCompany);
				tickettable1.setASSETCHECK(assetCheck);
				System.out.println("asset name"+assetName);
				if (assetName == null||assetName.equals("")) {
					tickettable1.setASSET_NAME("NA");
					tickettable1.setASSET_IPADDRESS("NA");
					tickettable1.setASSET_SUBCATEGORY("NA");

				} else {
					tickettable1.setASSET_IPADDRESS(asset_Ipaddress);
					tickettable1.setASSET_SUBCATEGORY(asset_sub_category);
					tickettable1.setASSET_NAME(assetName);
				}

				if (assetStatus == null||assetStatus.equals("")) {
					tickettable1.setASSET_STATUS("NA");

				} else {

					tickettable1.setASSET_STATUS(assetStatus);
				}
				if (assetTag == null||assetTag.equals("")) {
					tickettable1.setASSET_TAG("NA");

				} else {

					tickettable1.setASSET_TAG(assetTag);
				}
				if (assetCategory == null||assetCategory.equals("")) {
					tickettable1.setCATEGORY("NA");

				} else {

					tickettable1.setCATEGORY(assetCategory);
				}
              if (updatedFileName == null) {
					tickettable1.setT_ATTACH_NAME("No File Available");
              } else {
            	  tickettable1.setT_ATTACH_NAME(updatedFileName);
              }
				sessionFactory.getCurrentSession().persist(tickettable1);

				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					//System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}
				
				List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+loginname+"'").list();
				for(loginmaster lmc:lm)
				{
					fullnamel=lmc.getFULL_NAME();
					emailidl=lmc.getEMAIL();
					contactno=lmc.getPHONE();
				}
				
				ticket_activity_log ticketActivityLog = new ticket_activity_log();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(NewTicketID);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setSTATUS("New");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(usernameofraisedby);
				ticketActivityLog.setT_SUBJECT(subject);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(description);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setT_EMAIL(emailidl);
				ticketActivityLog.setT_CONTACT_NO(contactno);
				ticketActivityLog.setT_FULLNAME(fullnamel);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
								
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
				
				
				////////////////////// INSERT IN TICKET TRACKING /////////////
				
				
				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_tracking.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					//System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						//System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						//System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}

				String msg = null;
				
				String FullName=getLoginMasterData();
				msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>New</td></tr>"
						+ "<tr><td>Raised By:</td><td>"+usernameofraisedby+"["+FullName+"]  for "+t_requester+ "["+name1+"]</td></tr>";
				
				
				ticket_tracking tickettrack = new ticket_tracking();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(NewTicketID);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(usernameofraisedby);
				tickettrack.setACTIVITY_NAME_COMPANY(loginUserCompany);
				tickettrack.setCATEGORY(category);
				tickettrack.setSUBCATEGORY1(subcat1);
				tickettrack.setSUBCATEGORY2(subcat2);
				tickettrack.setSUBJECT(subject);
				tickettrack.setSTATUS("New");
				tickettrack.setPRIORITY(priority);
				tickettrack.setSEVERITY(severity);
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(t_requester);
				tickettrack.setTICKET_RAISED_NAME_COMPANY(compname);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				
				
				if (updatedFileName == null) {
					tickettrack.setATTACHMENT_NAME("No File Available");
				} else {
					tickettrack.setATTACHMENT_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(tickettrack);
				status = "success";
				String st = "Raise";

				description = phone + "," + emailid;
			//	Inv.RaiseNCloseEmailSMS(id, username, "Raise", site, category, subject, description, priority, phone,
					//	emailid);

			} catch (Exception e1) {
				e1.printStackTrace();
				//System.out.println("Exception e1****" + e1);
			}
			int srno=0;
			try {
				String elapsedTime="";
				String TargetTime="";
				Criteria response=sessionFactory.getCurrentSession().createCriteria(response_sla.class).setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) response.uniqueResult();

				//System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					srno = srno1.intValue();
					srno = srno + 1;
					//System.out.println("IN IF SNO IS: " + srno);
				} else {
					srno = 1;
					//System.out.println("IN ELSE SNO IS: " + srno);
				}
				
				List<responseslamaster> list=sessionFactory.getCurrentSession().createQuery("from responseslamaster where COMPANY='"+compname+"' and PRIORITY_NAME='"+priority+"' and SEVERITY_NAME='"+severity+"'").list();
				
				for(responseslamaster sl:list)
				{
					elapsedTime=sl.getSLA_TARGET_ELAPSED_TIME();
					TargetTime=sl.getRESPONSE_SLA_TARGET_DURATION();
				}

				
				response_sla rsla=new response_sla();
				
				rsla.setSR_NO(srno);
				rsla.setTICKET_ID(NewTicketID);
				rsla.setTICKET_STATUS("New");
				rsla.setPRIORITY(priority);
				rsla.setSEVERITY(severity);
				rsla.setSTART_DATE(currenttime);
				rsla.setELAPSED_TIME("NA");
				if(elapsedTime.isEmpty())
				{
					rsla.setRESPONSE_SLA_ELAPSED_TIME("NA");
				}else
				{
					rsla.setRESPONSE_SLA_ELAPSED_TIME(elapsedTime);
				}
				if(TargetTime.isEmpty())
				{
					rsla.setRESPONSE_SLA_TARGET("NA");
				}
				else
				{
					rsla.setRESPONSE_SLA_TARGET(TargetTime);
				}
				
				
				rsla.setRESPONSE_SLA_STATUS("NA");
				rsla.setSTOP_DATE("NA");
				rsla.setRESPONSE_SLA_DURATION("NA");
				
				
				
				sessionFactory.getCurrentSession().persist(rsla);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
//////////////////////SLAA INSERT START///////////////////
			Query insernew=sessionFactory.getCurrentSession().createQuery("from sla where TICKET_ID='"+NewTicketID+"' ");
			List<sla> listOfTicket=insernew.list();
			if(listOfTicket.isEmpty())
			{
				sla insert=new sla();
				
				insert.setTICKET_ID(NewTicketID);
				insert.setTICKET_STATUS("New");
				insert.setPRIORITY(priority);
				insert.setSEVERITY(severity);
				insert.setSTART_DATE(currenttime);
				insert.setSTOP_DATE("NA");
				insert.setSTART_END_TIME("NA");
				insert.setELAPSED_TIME("NA");
				insert.setHOLD_START_DATE("NA");
				insert.setHOLD_END_DATE("NA");
				insert.setHOLD_ELAPSED_TIME("NA");
				insert.setHOLD_DURATION("NA");
				insert.setSLA_STATUS("NA");
				insert.setSLA_TARGET("NA");
				insert.setSLA_TIME("NA");
				insert.setActual_Working_Time("NA");
				
				sessionFactory.getCurrentSession().save(insert);
			}
	
	
	////////////////////// SLAA INSERT STOP///////////////////
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
			//System.out.println("Exception e1****" + e1);
		}

		
		
		try {
			if(status.equals("success"))
			Inv.EmailSMSTriggered(NewTicketID, "Raise");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("STATIUS IS THAT  "+ status);
		
		return status + "," + NewTicketID;

	}

	@Override
	public JSONArray getEngAllWorkinProgressticketgernal(String LoginUser,String tickettype) {
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String LoginScope="";
		String loginUserCompany="";
		String output = "";
		String enggCategory="";
		String enggGroup="";
		List<Object[]> dataSet=null;
		try {
			//System.out.println(" inside getEngAllWorkinProgressticketgernal +++++++");
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			//////GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
			for (loginmaster loginObj : loginset) {
				enggCategory=loginObj.getCATEGORY();
				enggGroup=loginObj.getGROUP_NAME().replace(",","','");
				//System.out.println("ENGG GROUP FOUND: "+enggGroup);
			}
			if(tickettype.equals("NON_VIP")) {
		dataSet = sessionFactory.getCurrentSession().createSQLQuery("select tr.T_ID ,tr.T_STATUS ,tr.T_PRIORITY,tr.T_SEVERITY,tr.T_SUBJECT,ta.T_COMPANY,ta.T_BRANCH,ta.T_DEPARTMENT,tr.T_CATEGORY,tr.T_SUBCATEGORY1,tr.T_SUBCATEGORY2,ta.TP_NAME,COALESCE(ta.TP_FULLNAME,'NA'),ta.ENGINEER_GROUP,ta.ENGINEER_NAME,COALESCE(ta.ENGINEER_FULLNAME,'NA'), tr.RESOLVED_ENGINEER_NAME as RESOLVED_ENGINEER_NAME,COALESCE(tr.RESOLVED_ENGINEER_FULLNAME,'NA'),tr.RAISE_DATE,ta.T_ASSIGN_DATE,tr.RESOLVED_DATE  as RESOLVED_DATE, ta.T_ASSIGN_TO from ticket_assigned as ta join ticket_resolved tr on ta.T_ID=tr.T_ID  where tr.T_STATUS='Work In Progress' AND (ta.VIP_TICKET!='true' OR ta.VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s') DESC").list();
		
			}else if(tickettype.equals("VIP")) {
				
				dataSet = sessionFactory.getCurrentSession().createSQLQuery("select tr.T_ID ,tr.T_STATUS ,tr.T_PRIORITY,tr.T_SEVERITY,tr.T_SUBJECT,ta.T_COMPANY,ta.T_BRANCH,ta.T_DEPARTMENT,tr.T_CATEGORY,tr.T_SUBCATEGORY1,tr.T_SUBCATEGORY2,ta.TP_NAME,COALESCE(ta.TP_FULLNAME,'NA'),ta.ENGINEER_GROUP,ta.ENGINEER_NAME,COALESCE(ta.ENGINEER_FULLNAME,'NA'), tr.RESOLVED_ENGINEER_NAME as RESOLVED_ENGINEER_NAME,COALESCE(tr.RESOLVED_ENGINEER_FULLNAME,'NA'),tr.RAISE_DATE,ta.T_ASSIGN_DATE,tr.RESOLVED_DATE  as RESOLVED_DATE, ta.T_ASSIGN_TO from ticket_assigned as ta join ticket_resolved tr on ta.T_ID=tr.T_ID where tr.T_STATUS='Work In Progress' AND (ta.VIP_TICKET='true' OR ta.VIP_TICKET IS NULL) AND ("+LoginScope+") AND ((ENGINEER_NAME='"+LoginUser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') OR ENGINEER_GROUP IN ('"+enggGroup+"')) ORDER BY STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s') DESC").list();
			}
			array = new JSONArray();
			for (Object[] listData : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ listData[0]+ "\")'><i class='fa fa-eye'></i></button>");
				array1.put("<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+listData[0] + "\")'><i class='fa fa-edit'></i></button>");

				array1.put(listData[0]);
				array1.put(listData[1]);
				array1.put(listData[2]);
				array1.put(listData[3]);
				array1.put(listData[4]);
				array1.put(listData[5]);
				array1.put(listData[6]);
				array1.put(listData[7]);
				array1.put(listData[8]);
				array1.put(listData[9]);
				array1.put(listData[10]);
				array1.put(listData[11]);
				array1.put(listData[12]);
				if(listData[21].equals("Engineer"))
				{
					array1.put(listData[14]);
				}
				else
				{
					array1.put(listData[13]);
				}
				array1.put(listData[15]);
				array1.put(listData[16]);
				array1.put(listData[17]);
				array1.put(listData[18]);
				array1.put(listData[19]);
				array1.put(listData[20]);
//				array1.put(listData[9]);
//				array1.put(listData[10]);
//				array1.put(listData[11]);
//
//				array1.put(newObj.getTP_FULLNAME());
//				if(newObj.getT_ASSIGN_TO().equals("Engineer"))
//				{
//					array1.put(newObj.getENGINEER_NAME());
//				}
//				else
//				{
//					array1.put(newObj.getENGINEER_GROUP());
//				}
//				array1.put(newObj.getENGINEER_FULLNAME());
//				array1.put(newObj.getT_RAISE_DATE());
//				array1.put(newObj.getT_ASSIGN_DATE());
//				
				array.put(array1);
			}
			//System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exception In tryyy branch" + e);
		}
		return array;
	}

	@Override
	public String UpdateAllWorkInProgressTicket(String tid, String status, String engname, String engcompany,
			String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String severity, String sub, String description, String category,
			String subcat1, String subcat2, String solution, MultipartFile resolvePic,String assignTo, String enggcat, String enggassign, String engGroup, String userdepartment,String assignedEnggemail) {

	
		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String SMSApi = "";
		String loginname = "";
		String loginUserCompany = "";
		String fullname = "";
		String emailid = "";
		String phone = "";
		String LoginUser="";
		try {
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			
			String loginRoleType="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginRoleType = session.getAttribute("role").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("loginRoleType****" + loginRoleType);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}

				///////////////// FILE UPLOAD STARTS //////////////
				String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
				//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
				DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
				LocalDateTime now = LocalDateTime.now();
				//System.out.println(localdate.format(now));
				String localDateNow=localdate.format(now);
				//String createnewfilename = UUID.randomUUID().toString();
				String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
				//System.out.println("createnewfilename***" + createnewfilename);
				//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
				
				String ext = "";
				String updatedFileName = null;
				
				String fullnameoflogin="";
				try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
				File file = new File("C:\\ITHelpDesk\\");
				if (!file.exists()) {
					if (file.mkdir()) {
						//System.out.println("Directory is created!");
					} else {
						//System.out.println("Failed to create directory!");
					}
				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				
				String fileName = resolvePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
				//File uploadedFile =  empPic;
//				File uploadedFile = new File(resolvePic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();

//				String fileName = resolvePic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);
	
			
				//File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				
				updatedFileName = createnewfilename + "." + ext;
				
				
//				try {
//				FileUtils.copyFile(uploadedFile, destFile);
//				File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//				FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//				//System.out.println("Could not copy file " + fileName);
//					SMSApi = "fail";
//				ex.printStackTrace();
//				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				
				///////////////// FILE UPLOAD ENDS //////////////

				try {
					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					loginname = session.getAttribute("username").toString();
				
					LoginUser = session.getAttribute("username").toString();
					loginUserCompany = session.getAttribute("companyname").toString();
					fullnameoflogin= session.getAttribute("fullname").toString();
					
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println(e);
				}

			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			//System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			
			System.out.println("hii this is  status "+status);
			
			String OLD_STATUS="";
			String T_COMPANY="";
			String T_BRANCH="";
			String T_DEPARTMENT="";
			String engCompany2="";
			String engName2="";
			String FullNameOfEngg="";
			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				List<ticket> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+tid+"'").list();
	    
				for(ticket oldstatus:gettingoldstatus) {
					OLD_STATUS=	oldstatus.getSTATUS();
					
					T_BRANCH=oldstatus.getT_BRANCH();
					T_COMPANY=oldstatus.getT_COMPANY();
					T_DEPARTMENT=	oldstatus.getT_DEPARTMENT();
				}
			
				
			}catch (Exception e) {
				//System.out.println(e);
			}
		
			try {
				//System.out.println("ASSIGN TO VALUE IS THAT  " + assignTo);
				
				if(assignTo.equals("Engineer"))
				{
					String[] engData=enggassign.split("~");
					engName2=engData[0];
					FullNameOfEngg=engData[1];
					 engCompany2=engData[2];
				}
				
				//System.out.println("engName: "+engName2);
				//System.out.println("engCompany: "+engCompany2);
				
				
				
				
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				if(!status.equals("Re-Assigned")) {
				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				if (dup.isEmpty()) {
					ticket_resolved queryTicketResolvedInsert = new ticket_resolved();
					queryTicketResolvedInsert.setT_ID(tid);
					queryTicketResolvedInsert.setRAISE_DATE(raisedate);
					queryTicketResolvedInsert.setASSIGN_DATE(assigndate);
					queryTicketResolvedInsert.setRESOLVED_DATE(currenttime11);
					queryTicketResolvedInsert.setT_USER_NAME(username);
					queryTicketResolvedInsert.setT_USER_EMAIL(useremail);
					queryTicketResolvedInsert.setT_USER_PHONE(userphone);
					queryTicketResolvedInsert.setT_USER_COMPANY(usercompany);
					queryTicketResolvedInsert.setT_USER_BRANCH(userbranch);
					queryTicketResolvedInsert.setT_CATEGORY(category);
					queryTicketResolvedInsert.setT_SUBCATEGORY1(subcat1);
					queryTicketResolvedInsert.setT_SUBCATEGORY2(subcat2);
					queryTicketResolvedInsert.setT_SUBJECT(sub);
					queryTicketResolvedInsert.setT_DESC(description);
					queryTicketResolvedInsert.setT_PRIORITY(priority);
					queryTicketResolvedInsert.setT_SEVERITY(severity);
					queryTicketResolvedInsert.setT_STATUS(status);
					queryTicketResolvedInsert.setTP_NAME(tcname);
					queryTicketResolvedInsert.setTP_EMAIL(tcemail);
					queryTicketResolvedInsert.setTP_PHONE(tcphone);
					queryTicketResolvedInsert.setA_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setASSIGNED_ENGINEER_FULLNAME(fullnameoflogin);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_FULLNAME(fullnameoflogin);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_COMPANY(engcompany);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_EMAIL(engemailid);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_PHONE(engphone);
					queryTicketResolvedInsert.setSOLUTION(solution);
					queryTicketResolvedInsert.setT_RESOLVED_TIME(currenttime11);
					queryTicketResolvedInsert.setCURRENT_ACTIVITY_TIME(currenttime);
					queryTicketResolvedInsert.setCLOSEDBY("NA");
					queryTicketResolvedInsert.setCLOSED_DATE(null);
//					queryTicketResolvedInsert.setT_CLOSED_TIME(null);
					getSession().save(queryTicketResolvedInsert);

				} else {
					
					System.out.println("status is is s "+status);
					
					Query trQuery = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_resolved SET "
							+ "A_ENGINEER_NAME=:A_ENGINEER_NAME,RESOLVED_ENGINEER_NAME=:RESOLVED_ENGINEER_NAME,RESOLVED_ENGINEER_COMPANY=:RESOLVED_ENGINEER_COMPANY,"
							+ "T_STATUS=:T_STATUS,T_RESOLVED_TIME=:T_RESOLVED_TIME,RESOLVED_DATE=:RESOLVED_DATE,"
							+ "SOLUTION=:SOLUTION,RESOLVED_ENGINEER_FULLNAME=:RESOLVED_ENGINEER_FULLNAME,"
							+ "RESOLVED_ENGINEER_EMAIL=:RESOLVED_ENGINEER_EMAIL,CURRENT_ACTIVITY_TIME=:CURRENT_ACTIVITY_TIME,"
							+ "ASSIGNED_ENGINEER_FULLNAME=:ASSIGNED_ENGINEER_FULLNAME WHERE T_ID=:T_ID");
					trQuery.setParameter("A_ENGINEER_NAME",  loginname);
					trQuery.setParameter("RESOLVED_ENGINEER_NAME", loginname);
					trQuery.setParameter("RESOLVED_ENGINEER_COMPANY", engcompany);
					trQuery.setParameter("T_STATUS", status);
					trQuery.setParameter("T_RESOLVED_TIME",currenttime11);
					
					trQuery.setParameter("RESOLVED_DATE",currenttime11 );
					trQuery.setParameter("SOLUTION",solution );
					trQuery.setParameter("RESOLVED_ENGINEER_FULLNAME", fullnameoflogin);
					trQuery.setParameter("RESOLVED_ENGINEER_EMAIL", engemailid);
					trQuery.setParameter("CURRENT_ACTIVITY_TIME", currenttime);
					trQuery.setParameter("ASSIGNED_ENGINEER_FULLNAME",fullnameoflogin );
					trQuery.setParameter("T_ID",tid );
					
					int f = trQuery.executeUpdate();
					if(f>0)
					{
						System.out.println("Updated success ticket resolved : " +f);
						SMSApi="success";
					}
					else
					{
						System.out.println("Updated fail ticket resolved : " +f);
						SMSApi="fail";
			
					}
						
				}
				}else {
					
					System.out.println("fgh full name update ");
					Query query3 = sessionFactory.getCurrentSession().createQuery(
							"update ticket_assigned set T_USER_NAME=:T_USER_NAME,T_USER_EMAIL=:T_USER_EMAIL,T_USER_PHONE=:T_USER_PHONE,T_COMPANY=:T_COMPANY,T_BRANCH=:T_BRANCH,T_DEPARTMENT=:T_DEPARTMENT,T_CATEGORY=:T_CATEGORY,T_SUBCATEGORY1=:T_SUBCATEGORY1,T_SUBCATEGORY2=:T_SUBCATEGORY2,T_SUBJECT=:T_SUBJECT,T_DESC=:T_DESC,T_STATUS=:T_STATUS,T_PRIORITY=:T_PRIORITY,T_SEVERITY=:T_SEVERITY,T_ASSIGN_DATE=:T_ASSIGN_DATE,TP_NAME=:TP_NAME,TP_COMPANY=:TP_COMPANY,TP_EMAIL=:TP_EMAIL,TP_PHONE=:TP_PHONE,T_ASSIGN_TO=:T_ASSIGN_TO,ENGINEER_NAME=:ENGINEER_NAME,ENGINEER_COMPANY=:ENGINEER_COMPANY,ENGINEER_GROUP=:ENGINEER_GROUP,TP_HOLD_NOTES=:TP_HOLD_NOTES,TP_FULLNAME='"+fullnameoflogin+"',ENGINEER_FULLNAME=:ENGINEER_FULLNAME,T_CURRENT_ACTIVITY_TIME=:T_CURRENT_ACTIVITY_TIME,ENGINEER_EMAIL=:ENGINEER_EMAIL WHERE T_ID=:T_ID");

					
					System.out.println("TID======="+status+"TID================"+tid);
					Query query5 = sessionFactory.getCurrentSession().createQuery("update  ticket_resolved set RESOLVED_DATE='"+currenttime+"',CURRENT_ACTIVITY_TIME='"+currenttime+"',T_STATUS='" + status+ "'  where T_ID='"+tid+"' ");
				      int u=	query5.executeUpdate();
					if(u>0)
					{
						SMSApi="success";
					}
					else
					{
						SMSApi="fail";
					}
					
					
					//query3.setParameter("T_RAISE_DATE", raisedateupdateTD);
					query3.setParameter("T_USER_NAME", username);
					query3.setParameter("T_USER_EMAIL",useremail );
					query3.setParameter("T_USER_PHONE", userphone);
					query3.setParameter("T_COMPANY", usercompany);
					query3.setParameter("T_BRANCH", userbranch);
					query3.setParameter("T_DEPARTMENT",userdepartment );
					query3.setParameter("T_CATEGORY", category);
					query3.setParameter("T_SUBCATEGORY1", subcat1);
					query3.setParameter("T_SUBCATEGORY2", subcat2);
					query3.setParameter("T_SUBJECT", sub);
					query3.setParameter("T_DESC", description);
					query3.setParameter("T_STATUS", status);
					query3.setParameter("T_PRIORITY", priority);
					query3.setParameter("T_SEVERITY", severity);
					query3.setParameter("T_ASSIGN_DATE", currenttime);
					query3.setParameter("TP_NAME", loginname);
					query3.setParameter("TP_COMPANY",engcompany );
					query3.setParameter("TP_EMAIL", engemailid);
					query3.setParameter("TP_PHONE", engphone);
					query3.setParameter("T_ASSIGN_TO", assignTo);
					if(assignTo.contentEquals("Engineer")) {
						System.out.println("ghghghh "+FullNameOfEngg);
						query3.setParameter("ENGINEER_NAME", engName2);
						query3.setParameter("ENGINEER_FULLNAME", FullNameOfEngg);
						query3.setParameter("ENGINEER_COMPANY", engCompany2);
						query3.setParameter("ENGINEER_GROUP", "NA");
						query3.setParameter("ENGINEER_EMAIL", assignedEnggemail);
						
					}
					else if(assignTo.contentEquals("Group")) {
						query3.setParameter("ENGINEER_NAME", "NA");
						query3.setParameter("ENGINEER_GROUP", engGroup);
						query3.setParameter("ENGINEER_COMPANY", "NA");
						query3.setParameter("ENGINEER_EMAIL", "NA");
						query3.setParameter("ENGINEER_FULLNAME", "NA");
					}
					
					//System.out.println("tpholdnotes    " +solution);
					query3.setParameter("T_CURRENT_ACTIVITY_TIME", currenttime);
					query3.setParameter("TP_HOLD_NOTES", solution);
					query3.setParameter("T_ID", tid);

					query3.executeUpdate();

					//System.out.println("Query Updated");
					//System.out.println("done first query");
					
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession().createQuery("select max(SR_NO) from ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String FullName=getLoginMasterData();
				
				String msg = null;
				String groupORengg="";
				
				//System.out.println("va:lue off  "+ enggassign);
				if(status.equals("Re-Assigned")) {
				
					if(assignTo.contentEquals("Engineer")) {
						groupORengg=engName2;
						groupORengg+="["+FullNameOfEngg+"]";
						}
						else if(assignTo.contentEquals("Group")) {
						groupORengg=engGroup;
						}
						
						msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
						+ "<tr><td>Assigned By:</td><td>"+loginname+"["+FullName+"]</td></tr>"
						+ "<tr><td>Assigned To:</td><td>"+assignTo+"</td></tr>"
						+ "<tr><td>"+assignTo+" Name:</td><td>"+groupORengg+"</td></tr>";
				}
				
				else {
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"["+FullName+"]</td></tr>";
				}
				
				ticket_tracking ticket_tracking = new ticket_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserCompany);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setTICKET_RAISED_NAME_COMPANY(usercompany);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				//System.out.println("insert in ticket tracking***");
					System.out.println("before UPDATE ticket ");
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket SET STATUS='" + status
						+ "',CURRENT_ACTIVITY_TIME='"+currenttime+"' WHERE T_ID='" + tid + "'").executeUpdate();

		
				i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_assigned SET T_STATUS='" + status
						+ "',T_CURRENT_ACTIVITY_TIME='"+currenttime+"' WHERE T_ID='" + tid + "'").executeUpdate();
					if(i>0)
					{
						SMSApi="success";
					}else
					{
						SMSApi="fail";
					}
					
					
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
				
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();
				
					//System.out.println(" actSrno1 IS: " + actSrno1);
				
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}

List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
				
				ticket_activity_log ticketActivityLog = new ticket_activity_log();
				
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setSTATUS(status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginname);
				ticketActivityLog.setT_SUBJECT(sub);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(solution);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(emailid);
				
				ticketActivityLog.setT_CONTACT_NO(phone);
				ticketActivityLog.setT_FULLNAME(fullname);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}
				
				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				
				///////////////////////////////////HISTORICAL SLA CODE START///////////////////////////////
				try {
					
					
					int SRNO1 = 0;
					try {
					
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO"));
						Integer SRNO2 = (Integer) crit.uniqueResult();
					
						//System.out.println(" SRNO1 IS: " + SRNO2);
					
						if (SRNO2 != null) {
							SRNO1 = SRNO2.intValue();
							SRNO1 = SRNO1 + 1;
							//System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
						} else {
							SRNO1 = 1;
							//System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//System.out.println(e);
					}
					
					
					if( status.equals("Hold") || status.equals("Awaiting User Information") || status.equals("Pending With Vendor") || status.equals("Waiting for Spare") )
					{
						

						
						//System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
						historical_sla historicalsla = new historical_sla();
//						
						historicalsla.setSR_NO(SRNO1);
						historicalsla.setTICKET_ID(tid);
					
						historicalsla.setTICKET_STATUS(status);
					
						historicalsla.setSLA_STATUS("NA");
						historicalsla.setHOLD_START_DATE(currenttime);
						historicalsla.setHOLD_END_DATE("NA");
						historicalsla.setHOLD_ELAPSED_TIME("NA");
						
						historicalsla.setHOLD_DURATION("NA");
						
						historicalsla.setT_COMPANY(T_COMPANY);
						historicalsla.setT_BRANCH(T_BRANCH);
						historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
						sessionFactory.getCurrentSession().save(historicalsla);
				
					
					}
					
				
					
					
				}catch (Exception e) 
				{
					SMSApi="fail";
					//System.out.println(e);
				}
				
				SMSApi="success";
				
				///////////////////////////////////HISTORICAL SLA CODE STOP///////////////////////////////

				
//				
//				String HoldStartDate = simpleDateFormat.format(tdate);
//				//System.out.println("currentHoldStartDate: " + HoldStartDate);
//				Date HoldStartDate1 = simpleDateFormat.parse(HoldStartDate);
//				//System.out.println(status+ "STAUS VALUE ");
//				if (status.equals("Hold")) {
//					List<sla> l = sessionFactory.getCurrentSession()
//							.createQuery("from sla WHERE TICKET_ID='" + tid + "'").list();
//					if (l.isEmpty()) {
//						sla insertSLAObj = new sla();
//						insertSLAObj.setTICKET_ID(tid);
//						insertSLAObj.setPRIORITY(priority);
//						insertSLAObj.setSEVERITY(severity);
//						insertSLAObj.setTICKET_STATUS(status);
//						insertSLAObj.setSTART_DATE(raisedate);
//						insertSLAObj.setSTOP_DATE("NA");
//						insertSLAObj.setELAPSED_TIME("NA");
//						insertSLAObj.setSLA_TIME("NA");
//						insertSLAObj.setSLA_STATUS("NA");
//						insertSLAObj.setHOLD_START_DATE(HoldStartDate);
//						insertSLAObj.setHOLD_END_DATE("NA");
//						insertSLAObj.setHOLD_ELAPSED_TIME("NA");
//						insertSLAObj.setSLA_TARGET("NA");
//						insertSLAObj.setSTART_END_TIME("NA");
//						insertSLAObj.setHOLD_DURATION("NA");
//						getSession().save(insertSLAObj);
//					} else {
//						int i = sessionFactory.getCurrentSession().createQuery("UPDATE sla SET PRIORITY='" + priority
//								+ "',SEVERITY='" + severity +"',TICKET_STATUS='" + status + "',START_DATE='" + raisedate
//								+ "',STOP_DATE='NA',ELAPSED_TIME='NA',SLA_TIME='NA',SLA_STATUS='NA',HOLD_START_DATE='"
//								+ HoldStartDate + "',HOLD_END_DATE='NA',HOLD_ELAPSED_TIME='NA' WHERE TICKET_ID='"+tid+"'").executeUpdate();
//					}
//				}
				SMSApi = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			if(SMSApi.equals("success"))
			Inv.EmailSMSTriggered(tid, status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("STATUIS IS THAT  " + status);
		return SMSApi+"~"+status;
	
	}

	@Override
	public String UpdateAssignedHoldandReassignticket(String tid, String status, String engname, String engcompany,
			String engsite, String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String severity, String sub, String description, String category,
			String subcat1, String subcat2, String solution, MultipartFile resolvePic,String assignTo,String enggcat, String enggassign,String engGroup,String userdepartment,String engemail) 
	{
		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String SMSApi = "";
		String loginname = "";
		String loginUserCompany = "";
		String fullname = "";
		String emailid = "";
		String phone = "";
		String LoginUser="";
		try {
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			
			String loginRoleType="";
		
	

				///////////////// FILE UPLOAD STARTS //////////////
				String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
				//System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
				DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
				LocalDateTime now = LocalDateTime.now();
				//System.out.println(localdate.format(now));
				String localDateNow=localdate.format(now);
				//String createnewfilename = UUID.randomUUID().toString();
				String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
				//System.out.println("createnewfilename***" + createnewfilename);
				//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
				
				String ext = "";
				String updatedFileName = null;
				
				
				try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
				File file = new File("C:\\ITHelpDesk\\");
				if (!file.exists()) {
					if (file.mkdir()) {
						//System.out.println("Directory is created!");
					} else {
						//System.out.println("Failed to create directory!");
					}
				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				
				String fileName = resolvePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
				//File uploadedFile =  empPic;
//				File uploadedFile = new File(resolvePic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();
				
//				String fileName = resolvePic.getOriginalFilename(imagefilePath + File.separator + createnewfilename + "." + ext);
				
//				ext = FilenameUtils.getExtension(fileName);
	
				//File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				
				updatedFileName = createnewfilename + "." + ext;
				
				
//				try {
//				FileUtils.copyFile(uploadedFile, destFile);
//				File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//				FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//				//System.out.println("Could not copy file " + fileName);
//			//	status = "error";
//				ex.printStackTrace();
//				}
				} catch (Exception e) {
				//System.out.println("directory create exception" + e);
				}
				String fullNameloginname="";
				
				///////////////// FILE UPLOAD ENDS //////////////

				try {
					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					loginname = session.getAttribute("username").toString();
					loginRoleType = session.getAttribute("role").toString();
					LoginUser = session.getAttribute("username").toString();
					loginUserCompany = session.getAttribute("companyname").toString();
					fullNameloginname=session.getAttribute("fullname").toString();
				} catch (Exception e) {
					//status="error";
					e.printStackTrace();
					//System.out.println(e);
				}

			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			//System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			//System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			
			
			
			String OLD_STATUS="";
			String T_COMPANY="";
			String T_BRANCH="";
			String T_DEPARTMENT="";
			String engCompany2="";
			String engName2="";
			String newassigndate="";
			String new1priority="";
			String new1severity="";
			String new1category="";
			String newsubcate1="";
			String new1sub2="";
			String NameOfEng="";
			
			try {
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				
				
				
			/////////////getting data from TICKET ASSIGN START //////////////
				
				
				
//				List<ticket_assigned> ticket_assigne_data = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_ID='"+tid+"'").list();
//	    
//				for(ticket_assigned TICKET_ASSIGNDATA:ticket_assigne_data) {
//			
//					String new1priority="";
//					String new1severity="";
//					String new1category="";
//					String newsubcate1="";
//					String new1sub2="";
//					
//					TICKET_ASSIGNDATA.getT
//				}
//			
				
				/////////////////GET DATA TICKET ASSIGN END///////////////
				
				
				List<ticket> gettingoldstatus = sessionFactory.getCurrentSession().createQuery("from ticket where T_ID='"+tid+"'").list();
	    
				for(ticket oldstatus:gettingoldstatus) {
					OLD_STATUS=	oldstatus.getSTATUS();
					
				//	String new1priority="";
//					String new1severity="";
//					String new1category="";
//					String newsubcate1="";
//					String new1sub2="";
					
					T_BRANCH=oldstatus.getT_BRANCH();
					T_COMPANY=oldstatus.getT_COMPANY();
					T_DEPARTMENT=	oldstatus.getT_DEPARTMENT();
					new1sub2=oldstatus.getT_SUBCAT2();
					newsubcate1=oldstatus.getT_SUBCAT1();
					new1category=oldstatus.getT_CATEGORY();
					new1priority=oldstatus.getPRIORITY();
					new1severity=oldstatus.getSEVERITY();
					
				}
			
				
			}catch (Exception e) {
				//System.out.println(e);
			}
			
			try {
				
			
				if(assignTo.equals("Engineer"))
				{
					String[] engData=enggassign.split("~");
					engName2=engData[0];
					NameOfEng=engData[1];
					 engCompany2=engData[2];
				}
				
				//System.out.println("engName: "+engName2);
				//System.out.println("engCompany: "+engCompany2);
				
				
				///////////////GETTING OLD STATUS START//////////////
				
				if(status.equals("Work in Progress")) {
				List<ticket_resolved> dup = sessionFactory.getCurrentSession()
						.createQuery("FROM ticket_resolved WHERE T_ID='" + tid + "'").list();
				if (dup.isEmpty()) {
					ticket_resolved queryTicketResolvedInsert = new ticket_resolved();
					queryTicketResolvedInsert.setT_ID(tid);
					queryTicketResolvedInsert.setRAISE_DATE(raisedate);
					queryTicketResolvedInsert.setASSIGN_DATE(assigndate);
					queryTicketResolvedInsert.setRESOLVED_DATE(currenttime11);
					queryTicketResolvedInsert.setT_USER_NAME(username);
					queryTicketResolvedInsert.setT_USER_EMAIL(useremail);
					queryTicketResolvedInsert.setT_USER_PHONE(userphone);
					queryTicketResolvedInsert.setT_USER_COMPANY(usercompany);
					queryTicketResolvedInsert.setT_USER_BRANCH(userbranch);
					queryTicketResolvedInsert.setT_CATEGORY(category);
					queryTicketResolvedInsert.setT_SUBCATEGORY1(subcat1);
					queryTicketResolvedInsert.setT_SUBCATEGORY2(subcat2);
					queryTicketResolvedInsert.setT_SUBJECT(sub);
					queryTicketResolvedInsert.setT_DESC(description);
					queryTicketResolvedInsert.setT_PRIORITY(priority);
					queryTicketResolvedInsert.setT_SEVERITY(severity);
					queryTicketResolvedInsert.setT_STATUS(status);
					queryTicketResolvedInsert.setTP_NAME(tcname);
					queryTicketResolvedInsert.setTP_EMAIL(tcemail);
					queryTicketResolvedInsert.setTP_PHONE(tcphone);
					queryTicketResolvedInsert.setA_ENGINEER_NAME(loginname);
					
//					System.out.println("setRESOLVED_ENGINEER_NAME ="+NameOfEng);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_NAME(loginname);
					queryTicketResolvedInsert.setASSIGNED_ENGINEER_FULLNAME(fullNameloginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_FULLNAME(fullNameloginname);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_COMPANY(engcompany);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_EMAIL(engemailid);
//					System.out.println("engemailid ="+engemailid);
					queryTicketResolvedInsert.setRESOLVED_ENGINEER_PHONE(engphone);
					queryTicketResolvedInsert.setSOLUTION(solution);
					queryTicketResolvedInsert.setT_RESOLVED_TIME(currenttime11);
					queryTicketResolvedInsert.setCLOSEDBY("NA");
					queryTicketResolvedInsert.setCLOSED_DATE(null);
					queryTicketResolvedInsert.setCURRENT_ACTIVITY_TIME(currenttime11);
//					queryTicketResolvedInsert.setT_CLOSED_TIME(null);
					getSession().save(queryTicketResolvedInsert);

				} else {
					int f = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_resolved SET A_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_NAME='" + loginname + "',RESOLVED_ENGINEER_FULLNAME='"+fullNameloginname+"',RESOLVED_ENGINEER_COMPANY='" + engcompany + "',T_STATUS='" + status+ "',T_RESOLVED_TIME='" + currenttime11 + "',RESOLVED_DATE='" + currenttime11+ "',SOLUTION='" + solution + "',CURRENT_ACTIVITY_TIME='"+currenttime+"',ASSIGNED_ENGINEER_FULLNAME='"+fullNameloginname+"' WHERE T_ID='" + tid + "'").executeUpdate();
					if (f > 0) {
						//System.out.println("update in ticket ticket resolved****");

					}
				}
				}else if(status.equals("Re-Assigned")) {
					

					Query query3 = sessionFactory.getCurrentSession().createQuery(
							"update ticket_assigned set T_USER_NAME=:T_USER_NAME,T_USER_EMAIL=:T_USER_EMAIL,T_USER_PHONE=:T_USER_PHONE,T_COMPANY=:T_COMPANY,T_BRANCH=:T_BRANCH,T_DEPARTMENT=:T_DEPARTMENT,T_CATEGORY=:T_CATEGORY,T_SUBCATEGORY1=:T_SUBCATEGORY1,T_SUBCATEGORY2=:T_SUBCATEGORY2,T_SUBJECT=:T_SUBJECT,T_DESC=:T_DESC,T_STATUS=:T_STATUS,T_PRIORITY=:T_PRIORITY,T_SEVERITY=:T_SEVERITY,T_ASSIGN_DATE=:T_ASSIGN_DATE,TP_NAME=:TP_NAME,TP_COMPANY=:TP_COMPANY,TP_EMAIL=:TP_EMAIL,TP_PHONE=:TP_PHONE,T_ASSIGN_TO=:T_ASSIGN_TO,ENGINEER_NAME=:ENGINEER_NAME, ENGINEER_COMPANY=:ENGINEER_COMPANY,ENGINEER_GROUP=:ENGINEER_GROUP,TP_HOLD_NOTES=:TP_HOLD_NOTES,TP_FULLNAME='"+fullNameloginname+"',ENGINEER_FULLNAME=:ENGINEER_FULLNAME,ENGINEER_EMAIL=:ENGINEER_EMAIL,T_CURRENT_ACTIVITY_TIME=:T_CURRENT_ACTIVITY_TIME WHERE T_ID=:T_ID");

					
					Query query5 = sessionFactory.getCurrentSession().createQuery("update ticket_resolved set ASSIGN_DATE='"+currenttime+"',CURRENT_ACTIVITY_TIME='"+currenttime+"' where T_ID='"+tid+"'");
				      int u=	query5.executeUpdate();
					//query3.setParameter("T_RAISE_DATE", raisedateupdateTD);
					query3.setParameter("T_USER_NAME", username);
					query3.setParameter("T_USER_EMAIL",useremail );
					query3.setParameter("T_USER_PHONE", userphone);
					query3.setParameter("T_COMPANY", usercompany);
					query3.setParameter("T_BRANCH", userbranch);
					query3.setParameter("T_DEPARTMENT",userdepartment );
					query3.setParameter("T_CATEGORY", new1category);
					query3.setParameter("T_SUBCATEGORY1", newsubcate1);
					query3.setParameter("T_SUBCATEGORY2", new1sub2);
					query3.setParameter("T_SUBJECT", sub);
					query3.setParameter("T_DESC", description);
					query3.setParameter("T_STATUS", status);
					query3.setParameter("T_PRIORITY", new1priority);
					query3.setParameter("T_SEVERITY", new1severity);
					query3.setParameter("T_ASSIGN_DATE", currenttime);
					query3.setParameter("TP_NAME", loginname);
					query3.setParameter("TP_COMPANY",engcompany );
					query3.setParameter("TP_EMAIL", engemailid);
					query3.setParameter("TP_PHONE", engphone);
					query3.setParameter("T_ASSIGN_TO", assignTo);
					if(assignTo.contentEquals("Engineer")) {
						
						query3.setParameter("ENGINEER_NAME", engName2);
						query3.setParameter("ENGINEER_EMAIL", engemail);
						query3.setParameter("ENGINEER_FULLNAME", NameOfEng);
						query3.setParameter("ENGINEER_COMPANY", engCompany2);
						query3.setParameter("ENGINEER_GROUP", "NA");
					}
					else if(assignTo.contentEquals("Group")) {
						query3.setParameter("ENGINEER_NAME", "NA");
						query3.setParameter("ENGINEER_GROUP", engGroup);
						query3.setParameter("ENGINEER_COMPANY", "NA");
						query3.setParameter("ENGINEER_EMAIL", "NA");
						query3.setParameter("ENGINEER_FULLNAME", "NA");
					}
					
					//System.out.println("tpholdnotes    " +solution);
					query3.setParameter("T_CURRENT_ACTIVITY_TIME", currenttime);
					
					query3.setParameter("TP_HOLD_NOTES", solution);
					query3.setParameter("T_ID", tid);

					query3.executeUpdate();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession().createQuery("select max(SR_NO) from ticket_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}

				
				String msg = null;
				String groupORengg="";
				String FullName=getLoginMasterData();
				//System.out.println("va:lue off  "+ enggassign);
				if(status.equals("Re-Assigned")) {
					
					if(assignTo.contentEquals("Engineer")) {
						groupORengg=engName2;
						groupORengg+=NameOfEng;
						}
						else if(assignTo.contentEquals("Group")) {
						groupORengg=engGroup;
						}
						
						msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
						+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
						+ "<tr><td>Assigned By:</td><td>"+loginname+"["+FullName+"]</td></tr>"
						+ "<tr><td>Assigned To:</td><td>"+assignTo+"</td></tr>"
						+ "<tr><td>"+assignTo+" Name:</td><td>"+groupORengg+"</td></tr>";
				}
				
				else {
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer:</td><td>"+loginname+"["+FullName+"]</td></tr>";
				}
				ticket_tracking ticket_tracking = new ticket_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setACTIVITY_NAME_COMPANY(loginUserCompany);
				ticket_tracking.setCATEGORY(new1category);
				ticket_tracking.setSUBCATEGORY1(new1category);
				ticket_tracking.setSUBCATEGORY2(new1sub2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(new1priority);
				ticket_tracking.setSEVERITY(new1severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setTICKET_RAISED_NAME_COMPANY(usercompany);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				//System.out.println("insert in ticket tracking***");

				int i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket SET STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();

				i = sessionFactory.getCurrentSession().createQuery("UPDATE ticket_assigned SET T_STATUS='" + status
						+ "' WHERE T_ID='" + tid + "'").executeUpdate();
				
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {
				
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(ticket_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();
				
					//System.out.println(" actSrno1 IS: " + actSrno1);
				
					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						//System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						//System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println(e);
				}

List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
			}
				
				ticket_activity_log ticketActivityLog = new ticket_activity_log();
				
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setPRIORITY(new1priority);
				ticketActivityLog.setSEVERITY(new1severity);
				ticketActivityLog.setSTATUS(status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginname);
				ticketActivityLog.setT_SUBJECT(sub);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(solution);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_CATEGORY(new1category);
				ticketActivityLog.setT_SUB_CATEGORY1(newsubcate1);
				ticketActivityLog.setT_SUB_CATEGORY2(new1sub2);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(emailid);
				
				ticketActivityLog.setT_CONTACT_NO(phone);
				ticketActivityLog.setT_FULLNAME(fullname);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}
				
				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				
				///////////////////////////////////HISTORICAL SLA CODE START///////////////////////////////
				try {
					
					
					int SRNO1 = 0;
					try {
					
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO"));
						Integer SRNO2 = (Integer) crit.uniqueResult();
					
						//System.out.println(" SRNO1 IS: " + SRNO2);
					
						if (SRNO2 != null) {
							SRNO1 = SRNO2.intValue();
							SRNO1 = SRNO1 + 1;
							//System.out.println("IN IF SRNO2 IS: " + 	SRNO1);
						} else {
							SRNO1 = 1;
							//System.out.println("IN ELSE SRNO2 IS: " +SRNO1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//System.out.println(e);
					}
					
					
					if(( OLD_STATUS.equals("Hold") || OLD_STATUS.equals("Awaiting User Information") || OLD_STATUS.equals("Pending With Vendor") || OLD_STATUS.equals("Waiting for Spare") )&& ( !status.equals("Hold") )  )
					{
						
						//System.out.println("INSIDE BOTH  HOLD  AND  OLD YES OR CURRENT NOT3 " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
				
						  Criteria criteriaformax = sessionFactory.getCurrentSession().createCriteria(historical_sla.class).setProjection(Projections.max("SR_NO") ).add(Restrictions.eq("TICKET_ID", tid));

						 int maxsrno1=(int) criteriaformax.uniqueResult();
						 
						 //System.out.println("MAX NO is THAT " + maxsrno1);
					
										
							Query updathistoricalsla = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_END_DATE=:HOLD_END_DATE , TICKET_STATUS=:TICKET_STATUS WHERE SR_NO=:SR_NO");
							updathistoricalsla.setParameter("HOLD_END_DATE", currenttime);
							updathistoricalsla.setParameter("SR_NO",maxsrno1);
							updathistoricalsla.setParameter("TICKET_STATUS",status);
							
								

							//////////////////////////////CODE FOR FIND ELAPSE AND HOLD DURATION //////////////////////////////
							int check=	updathistoricalsla.executeUpdate();	
				
							
							String GETSTARTHOLDTIME="";
							String GETENDHOLDTIME="";
							//System.out.println("VALUE OF CHECK  " + check);
							if(check!=0) {
								
								//System.out.println("INSIDE ELAPSE IF BLOCK");
								Query QUERYFORBOTHDATE=sessionFactory.getCurrentSession().createQuery("from historical_sla where SR_NO='"+maxsrno1+"'");
								
								List<historical_sla> historicalvalue=QUERYFORBOTHDATE.list();
								for(historical_sla getvalue: historicalvalue) {
									
									GETENDHOLDTIME=	getvalue.getHOLD_END_DATE();
									GETSTARTHOLDTIME=	getvalue.getHOLD_START_DATE();
									
								}
								//System.out.println("GETENDHOLDTIME VALUE  "+ GETENDHOLDTIME);
								//System.out.println("GETSTARTHOLDTIME VALUE  "+ GETSTARTHOLDTIME);
								
								
								 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						            
						              
								  Date stratdate = sdf.parse(GETSTARTHOLDTIME);
						            Date enddate = sdf.parse(GETENDHOLDTIME);
						            
						        long duration = enddate.getTime()- stratdate.getTime();
						  
						           //System.out.println("difference_In_Time is   " + duration);
						          

									int diffInSeconds =(int) TimeUnit.MILLISECONDS.toSeconds(duration);
									long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
									long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);
									long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
									
									
									//System.out.println("diffInDays: " + diffInDays);
									//System.out.println("diffInHours: " + diffInHours);
									//System.out.println("diffInMinutes: " + diffInMinutes);
									//System.out.println("diffInSeconds: " + diffInSeconds);
									
									///////////////// START DATE TO END DATE DURATION Starts///////
									int day_StartEndDate = (int) TimeUnit.SECONDS.toDays(diffInSeconds);
									long hours_StartEndDate = TimeUnit.SECONDS.toHours(diffInSeconds) - (day_StartEndDate * 24);
									long minute_StartEndDate = TimeUnit.SECONDS.toMinutes(diffInSeconds)
											- (TimeUnit.SECONDS.toHours(diffInSeconds) * 60);
									long second_StartEndDate = TimeUnit.SECONDS.toSeconds(diffInSeconds)
											- (TimeUnit.SECONDS.toMinutes(diffInSeconds) * 60);
									
									String day_StartEndDate1 = "";
									String hours_StartEndDate1 = "";
									String minute_StartEndDate1 = "";
									String second_StartEndDate1 = "";

									if (day_StartEndDate != 0) {
										day_StartEndDate1 = Integer.toString(day_StartEndDate) + " Days ";
									}
									if (hours_StartEndDate != 0) {
										hours_StartEndDate1 = Long.toString(hours_StartEndDate) + " Hours ";
									}
									if (minute_StartEndDate != 0) {
										minute_StartEndDate1 = Long.toString(minute_StartEndDate) + " Minutes ";
									}
									if (second_StartEndDate != 0) {
										second_StartEndDate1 = Long.toString(second_StartEndDate) + " Seconds ";
									}

									String StartEndDateDuration = day_StartEndDate1 + hours_StartEndDate1 + minute_StartEndDate1
											+ second_StartEndDate1;
									//System.out.println("START & END DATE DURATION: " + StartEndDateDuration);
									//System.out.println(" TOTAL ELAPS TIME  IS  " + diffInSeconds);
						            
						               if(!StartEndDateDuration.isEmpty() && diffInSeconds !=0) {
											
											Query updateelapsandduration = sessionFactory.getCurrentSession().createQuery("update historical_sla set HOLD_DURATION=:HOLD_DURATION,HOLD_ELAPSED_TIME=:HOLD_ELAPSED_TIME  WHERE SR_NO=:SR_NO");
											updateelapsandduration.setParameter("HOLD_ELAPSED_TIME", Integer.valueOf(diffInSeconds).toString());
											updateelapsandduration.setParameter("SR_NO",maxsrno1);
											updateelapsandduration.setParameter("HOLD_DURATION",StartEndDateDuration);
										int check2=	updateelapsandduration.executeUpdate();
										
										//System.out.println("check2 value "+ check2);
						            	   
						               }
						               
							}
								

//								if(OLD_STATUS.equals("Hold") && status.equals("Hold") ) {
//									
//									historical_sla historicalsla = new historical_sla();
//									
//									historicalsla.setSR_NO(SRNO1);
//									historicalsla.setTICKET_ID(tid);
//								
//									historicalsla.setTICKET_STATUS(status);
//								
//									historicalsla.setSLA_STATUS("NA");
//									historicalsla.setHOLD_START_DATE(currenttime);
//									historicalsla.setHOLD_END_DATE("NA");
//									historicalsla.setHOLD_ELAPSED_TIME("NA");
//									
//									historicalsla.setHOLD_DURATION("NA");
//									
//									historicalsla.setT_COMPANY(T_COMPANY);
//									historicalsla.setT_BRANCH(T_BRANCH);
//									historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
//									sessionFactory.getCurrentSession().save(historicalsla);
//									
//									
//								}
							
					}
					
//					else if(!OLD_STATUS.equals("Hold") && status.equals("Hold") ){
//						
//						//System.out.println("INSIDE OLD not HOLD AND CURRENT IS  HOLD  " +"  OLD STATUS ==" + OLD_STATUS + " AND CURRENT  STATUS IS"+status);
//						historical_sla historicalsla = new historical_sla();
////						
//						historicalsla.setSR_NO(SRNO1);
//						historicalsla.setTICKET_ID(tid);
//					
//						historicalsla.setTICKET_STATUS(status);
//					
//						historicalsla.setSLA_STATUS("NA");
//						historicalsla.setHOLD_START_DATE(currenttime);
//						historicalsla.setHOLD_END_DATE("NA");
//						historicalsla.setHOLD_ELAPSED_TIME("NA");
//						
//						historicalsla.setHOLD_DURATION("NA");
//						
//						historicalsla.setT_COMPANY(T_COMPANY);
//						historicalsla.setT_BRANCH(T_BRANCH);
//						historicalsla.setT_DEPARTMENT(T_DEPARTMENT);
//						sessionFactory.getCurrentSession().save(historicalsla);
//				
//					}
					
					
				}catch (Exception e) 
				{
					SMSApi="fail";
					//System.out.println(e);
				}
				
				SMSApi="success";
				
				///////////////////////////////////HISTORICAL SLA CODE STOP///////////////////////////////

				
				
				String HoldStartDate = simpleDateFormat.format(tdate);
				//System.out.println("currentHoldStartDate: " + HoldStartDate);
				Date HoldStartDate1 = simpleDateFormat.parse(HoldStartDate);
				//System.out.println(status+ "STAUS VALUE ");
//				if (status.equals("Hold")) {
//					List<sla> l = sessionFactory.getCurrentSession()
//							.createQuery("from sla WHERE TICKET_ID='" + tid + "'").list();
//					if (l.isEmpty()) {
//						sla insertSLAObj = new sla();
//						insertSLAObj.setTICKET_ID(tid);
//						insertSLAObj.setPRIORITY(priority);
//						insertSLAObj.setSEVERITY(severity);
//						insertSLAObj.setTICKET_STATUS(status);
//						insertSLAObj.setSTART_DATE(raisedate);
//						insertSLAObj.setSTOP_DATE("NA");
//						insertSLAObj.setELAPSED_TIME("NA");
//						insertSLAObj.setSLA_TIME("NA");
//						insertSLAObj.setSLA_STATUS("NA");
//						insertSLAObj.setHOLD_START_DATE(HoldStartDate);
//						insertSLAObj.setHOLD_END_DATE("NA");
//						insertSLAObj.setHOLD_ELAPSED_TIME("NA");
//						insertSLAObj.setSLA_TARGET("NA");
//						insertSLAObj.setSTART_END_TIME("NA");
//						insertSLAObj.setHOLD_DURATION("NA");
//						getSession().save(insertSLAObj);
//					} else {
//						int i = sessionFactory.getCurrentSession().createQuery("UPDATE sla SET PRIORITY='" + priority
//								+ "',SEVERITY='" + severity +"',TICKET_STATUS='" + status + "',START_DATE='" + raisedate
//								+ "',STOP_DATE='NA',ELAPSED_TIME='NA',SLA_TIME='NA',SLA_STATUS='NA',HOLD_START_DATE='"
//								+ HoldStartDate + "',HOLD_END_DATE='NA',HOLD_ELAPSED_TIME='NA' WHERE TICKET_ID='"+tid+"'").executeUpdate();
//					}
//				}
				SMSApi = "success";
				//System.out.println("VALUE OF    STATUS  " +SMSApi);
			} catch (Exception e) {
				SMSApi="fail";
				e.printStackTrace();
			}
		} catch (Exception e) {
			SMSApi="fail";
			e.printStackTrace();
		}
		
		
		try {
			if(SMSApi.equals("success"))
			Inv.EmailSMSTriggered(tid, status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return SMSApi;
	}
	
	@Override
	public JSONArray CheckENGTicketUpdateConflictforReassign(String ticketid,String CurrentStatus , String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		//System.out.println("INSIDE CheckENGTicketUpdateConflictforReassign DAO IMPL");
		JSONArray finalArray = new JSONArray();
		//System.out.println("TICKET ID TO CHECK: "+ticketid+"status"+CurrentStatus);
		//System.out.println("ASSIGN BY NAAME  "+ priviousetpnaame);
		//System.out.println("ASSIGN BY EMAIL    "+ priviouseemail);
		
		String LoginUser = null;
		String loginRoleType="";
		String ENGG_GROUP_NAME="";
		String PREVIOUS_ENG_STATUS="";
		String PREVIOUS_ENG_NAME="";
		String ASSIGNED_TICKET_STATUS="";
		String RESOLVED_TICKET_STATUS="";
		String PREVIOUS_ENG_SOLUTION="";
		String PREVIOUS_ENG_SOLUTION_DATE="";
		String Role_typevalu="";
		String PREVIOUSTPNAME="";
		String TPSTATUS="";
		String NOTES="";
		String TPASSIGNDATE="";
		String Assignenggname="";
		String Assigndatae="";
		String Tp_NAME="";
		String TP_COMPANY="";
		String TP_NOTES="";
		String resolve_enggname="";
		String resolveenggcompany="";
		String resolve_date="";
		String resolve_solution="";
		String resolvestatus="";
		String EnggGroup="";
		String EnggGroupFORSPLIT="";
		String ENggCOMPANYIS="";
		String loginUserCompany="";
		boolean groupfalse=false;
		boolean enggnameorcom=false;
		String engiorgroupforswal="";
		String priviouseengorgroupforswal="";
		String previousActivityDoneBy="";
		String PreviousActivityBy="";
		String Roll_Type="";
		String FullName="";
		
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		
		List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster loginObj : loginset) {
			
			EnggGroupFORSPLIT=loginObj.getGROUP_NAME();
		//	//System.out.println("ENGG GROUP FOUND: "+enggGroup);
		}
	
		
	if(	currentatassignto.equals("Group")) {
		engiorgroupforswal=currentselectgrp;
	}
	else if(	currentatassignto.equals("Engineer")) {
	String splitselect[]=	crrentselecengg.split("~");
		engiorgroupforswal=splitselect[0]+"~"+splitselect[2];
	}
//////////////CHECK IF TICKET BELONGS TO GROUP
		try {
			Query queryticket_assigned = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_ID='" + ticketid+"'");
			ticket_assigned ticket_assigned_data = (ticket_assigned) queryticket_assigned.uniqueResult();
			if (ticket_assigned_data != null) {
				//System.out.println("IN TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = ticket_assigned_data.getT_ASSIGN_TO();
				ASSIGNED_TICKET_STATUS= ticket_assigned_data.getT_STATUS();
				Assignenggname=	ticket_assigned_data.getENGINEER_NAME();
				ENggCOMPANYIS=ticket_assigned_data.getENGINEER_COMPANY();
				Assigndatae=ticket_assigned_data.getT_ASSIGN_DATE();
				Tp_NAME=	ticket_assigned_data.getTP_NAME();
				TP_COMPANY=	ticket_assigned_data.getTP_COMPANY();
				TP_NOTES=ticket_assigned_data.getTP_HOLD_NOTES();
				EnggGroup=ticket_assigned_data.getENGINEER_GROUP();
				
//				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULL_NAME from  loginmaster where COMPANY='"+TP_COMPANY+"' and USERNAME='"+Tp_NAME+"'");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					Roll_Type=obj[0].toString();
//					FullName=obj[1].toString();
//				}
//				
//		Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) where T_ID='"+ticketid+"') ");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					Roll_Type=obj[0].toString();
//					FullName=obj[1].toString();
//					Tp_NAME=obj[2].toString();
//					
//				}
	Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,T_FULLNAME ,T_CHANGEBY from  ticket_activity_log where SR_NO=(select max(SR_NO)from ticket_activity_log where T_ID='"+ticketid+"') ");
				
				List<Object[]> listOfRU=qfor.list();
				for(Object[]  obj:listOfRU)
				{
					Roll_Type=obj[0].toString();
					FullName=obj[1].toString();
					Tp_NAME=obj[2].toString();
					
				}
				
				
				
				
				System.out.println("fullName ======"+FullName);
				System.out.println("Loginuser=========="+Roll_Type);
				if(ENGG_GROUP_NAME .equals("Group")) {
					
				priviouseengorgroupforswal=	EnggGroup;
				}else {
					priviouseengorgroupforswal=Assignenggname+"~"+ENggCOMPANYIS;
				}
				
				////GET INFO FROM TICKET RESOLVE///////////
				
				//if(ASSIGNED_TICKET_STATUS.equals("Work in Progress")) {
				Query QUERYTICKETASSIGN = sessionFactory.getCurrentSession().createQuery("from ticket_resolved where T_ID='" + ticketid+"'");
			List<ticket_resolved>  	 TICKETRESOLVEDATA2 = QUERYTICKETASSIGN.list();
				
				if (!TICKETRESOLVEDATA2.isEmpty()) {
					
					for(ticket_resolved TICKETRESOLVEDATA:TICKETRESOLVEDATA2 ) {
				
					resolve_enggname=	TICKETRESOLVEDATA.getRESOLVED_ENGINEER_NAME();
					resolveenggcompany=		TICKETRESOLVEDATA.getRESOLVED_ENGINEER_COMPANY();
					resolve_date=			TICKETRESOLVEDATA.getRESOLVED_DATE();
					resolve_solution=	TICKETRESOLVEDATA.getSOLUTION();
					resolvestatus=TICKETRESOLVEDATA.getT_STATUS();
					}
				}
				//}
			////GET INFO FROM TICKET RESOLVE///////////
				if (ENGG_GROUP_NAME.equals("Group")) {
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				String particulargroup[]=	EnggGroupFORSPLIT.split(",");
				for(String dumgroup:particulargroup) {
					
					if(dumgroup.equals(EnggGroup)) {
						groupfalse=true;
					}
				}
				
				}else if(ENGG_GROUP_NAME.equals("Engineer")) {
					
					if(Assignenggname.equals(LoginUser) && ENggCOMPANYIS.equals(loginUserCompany)) {
						
						enggnameorcom=	true;
					}
					
				}
				
				
				
				if (ENGG_GROUP_NAME.equals("Group")) {
					
					if(CurrentStatus.equals("Re-Assigned")) {
					
					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					
					

					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && groupfalse) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								
								
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								finalArray.put(Jobj);
						}else if(CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ){
							
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							//fail
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					
				
						
						
						//passs
					}
				else {
					
					if(CurrentStatus.equals("Re-Assigned")) {
					
					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					
					

					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && enggnameorcom) {
						
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								
								
								finalArray.put(Jobj);
						}else if(CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom ){
							
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							//fail
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					
				
						
						
						//passs
					}

					
				}
				
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	}

	@Override
	public JSONArray CheckENGConflictAfterWorInProgress(String ticketid, String CurrentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		//System.out.println("INSIDE CheckENGTicketUpdateConflictforReassign DAO IMPL");
		JSONArray finalArray = new JSONArray();
		//System.out.println("TICKET ID TO CHECK: "+ticketid+"status"+CurrentStatus);
		//System.out.println("ASSIGN BY NAAME  "+ priviousetpnaame);
		//System.out.println("ASSIGN BY EMAIL    "+ priviouseemail);
		
		String LoginUser = null;
		String loginRoleType="";
		String ENGG_GROUP_NAME="";
		String PREVIOUS_ENG_STATUS="";
		String PREVIOUS_ENG_NAME="";
		String ASSIGNED_TICKET_STATUS="";
		String RESOLVED_TICKET_STATUS="";
		String PREVIOUS_ENG_SOLUTION="";
		String PREVIOUS_ENG_SOLUTION_DATE="";
		String Role_typevalu="";
		String PREVIOUSTPNAME="";
		String TPSTATUS="";
		String NOTES="";
		String TPASSIGNDATE="";
		String Assignenggname="";
		String Assigndatae="";
		String Tp_NAME="";
		String TP_COMPANY="";
		String TP_NOTES="";
		String resolve_enggname="";
		String resolveenggcompany="";
		String resolve_date="";
		String resolve_solution="";
		String resolvestatus="";
		String EnggGroup="";
		String EnggGroupFORSPLIT="";
		String ENggCOMPANYIS="";
		String loginUserCompany="";
		boolean groupfalse=false;
		boolean enggnameorcom=false;
		String engiorgroupforswal="";
		String priviouseengorgroupforswal="";
		String previouslyactivityfullname="";
		String previouslyactivityroletype="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		
		List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster loginObj : loginset) {
			
			EnggGroupFORSPLIT=loginObj.getGROUP_NAME();
		//	//System.out.println("ENGG GROUP FOUND: "+enggGroup);
		}
	
		
	if(	currentatassignto.equals("Group")) {
		engiorgroupforswal=currentselectgrp;
	}
	else if(	currentatassignto.equals("Engineer")) {
	String splitselect[]=	crrentselecengg.split("~");
		engiorgroupforswal=splitselect[0]+"~"+splitselect[2];
	}
//////////////CHECK IF TICKET BELONGS TO GROUP
		try {
			Query queryticket_assigned = sessionFactory.getCurrentSession().createQuery("from ticket_assigned where T_ID='" + ticketid+"'");
			ticket_assigned ticket_assigned_data = (ticket_assigned) queryticket_assigned.uniqueResult();
			if (ticket_assigned_data != null) {
				//System.out.println("IN TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = ticket_assigned_data.getT_ASSIGN_TO();
				ASSIGNED_TICKET_STATUS= ticket_assigned_data.getT_STATUS();
				Assignenggname=	ticket_assigned_data.getENGINEER_NAME();
				ENggCOMPANYIS=ticket_assigned_data.getENGINEER_COMPANY();
				Assigndatae=ticket_assigned_data.getT_ASSIGN_DATE();
				Tp_NAME=	ticket_assigned_data.getTP_NAME();
				TP_COMPANY=	ticket_assigned_data.getTP_COMPANY();
				TP_NOTES=ticket_assigned_data.getTP_HOLD_NOTES();
				EnggGroup=ticket_assigned_data.getENGINEER_GROUP();
				
//				Query queryforprioussedata = sessionFactory.getCurrentSession().createQuery("select FULL_NAME,ROLE_TYPE from loginmaster where username='" + Tp_NAME+"'  and COMPANY='"+TP_COMPANY+"'");	
//				List<Object[]> loginmasterdata2 =  queryforprioussedata.list();
//				
//				for(Object[]  logindata5:loginmasterdata2) 
//				{
//					previouslyactivityfullname=logindata5[0].toString();
//					previouslyactivityroletype=logindata5[1].toString();
//				}
//				
//				System.out.println("previouslyactivityfullname   :::"+ previouslyactivityfullname);
//				System.out.println("previouslyactivityroletype  __ :::"+ previouslyactivityroletype);
				
//		Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,T_FULLNAME ,T_CHANGEBY from  ticket_activity_log where SR_NO=(select max(SR_NO)from  where T_ID='"+ticketid+"') ");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					previouslyactivityroletype=obj[0].toString();
//					previouslyactivityfullname=obj[1].toString();
//					Tp_NAME=obj[2].toString();
//					
//				}
				
				
				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,T_FULLNAME ,T_CHANGEBY from  ticket_activity_log where SR_NO=(select max(SR_NO)from ticket_activity_log where T_ID='"+ticketid+"') ");
						
						List<Object[]> listOfRU=qfor.list();
						for(Object[]  obj:listOfRU)
						{
							previouslyactivityroletype=obj[0].toString();
							previouslyactivityfullname=obj[1].toString();
							Tp_NAME=obj[2].toString();
							
						}
				System.out.println("");
				
				if(ENGG_GROUP_NAME .equals("Group")) {
				
				priviouseengorgroupforswal=	EnggGroup;
				}else {
					priviouseengorgroupforswal=Assignenggname+"~"+ENggCOMPANYIS;
				}
				
				////GET INFO FROM TICKET RESOLVE///////////
				
				//if(ASSIGNED_TICKET_STATUS.equals("Work in Progress")) {
				Query QUERYTICKETASSIGN = sessionFactory.getCurrentSession().createQuery("from ticket_resolved where T_ID='" + ticketid+"'");
			List<ticket_resolved>  	 TICKETRESOLVEDATA2 = QUERYTICKETASSIGN.list();
				
				if (!TICKETRESOLVEDATA2.isEmpty()) {
					
					for(ticket_resolved TICKETRESOLVEDATA:TICKETRESOLVEDATA2 ) {
				
					resolve_enggname=	TICKETRESOLVEDATA.getRESOLVED_ENGINEER_NAME();
					resolveenggcompany=		TICKETRESOLVEDATA.getRESOLVED_ENGINEER_COMPANY();
					resolve_date=			TICKETRESOLVEDATA.getRESOLVED_DATE();
					resolve_solution=	TICKETRESOLVEDATA.getSOLUTION();
					resolvestatus=TICKETRESOLVEDATA.getT_STATUS();
					}
				}
				//}
			////GET INFO FROM TICKET RESOLVE///////////
				if (ENGG_GROUP_NAME.equals("Group")) {
					
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				String particulargroup[]=	EnggGroupFORSPLIT.split(",");
				for(String dumgroup:particulargroup) {
					
					if(dumgroup.equals(EnggGroup)) {
						groupfalse=true;
					}
				}
				
				}else if(ENGG_GROUP_NAME.equals("Engineer")) {
					
					if(Assignenggname.equals(LoginUser) && ENggCOMPANYIS.equals(loginUserCompany)) {
						
						enggnameorcom=	true;
					}
					
				}
				
				
				
				if (ENGG_GROUP_NAME.equals("Group")) {
					System.out.println("the number is 1");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number is 2");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ) {
						System.out.println("the number is 3");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && groupfalse) {
						System.out.println("the number is 4");
						// action le
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && !groupfalse) {
						System.out.println("the number is 4");
						//no action
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if (CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && (ASSIGNED_TICKET_STATUS.equals("Rejected") || ASSIGNED_TICKET_STATUS.equals("Resolved") )) {
						// no action 
						System.out.println("the number is 4");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}
					else if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) {
						System.out.println("the number is 5");
						//action le
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
							
				
					}
					else  if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse ){
						//no action 
						System.out.println("the number is 6");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}		
					}
					else if(!CurrentStatus.equals("Re-Assigned")  ) {
						System.out.println("the number is 7");
						
						 if (!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //action le
							 System.out.println("the number is 8");
							 //NO
							 JSONObject Jobj= new JSONObject();
						
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
						 else if((!CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ){
							 //no action 
							 System.out.println("the number is 9 nn");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
							
				
							//Pass;
							
						}else if((!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse)) {
							// no action
							System.out.println("the number is 10");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}else if(!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse)
						{
							//no continiew
							System.out.println("the number is 11");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
					}
					
				
						
						
						//passs
					}
				else {
					System.out.println("the number is 1");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number is 2");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ) {
						System.out.println("the number is 3");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && groupfalse) {
						System.out.println("the number is 4");
						// action le
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && !groupfalse) {
						System.out.println("the number is 4");
						//no action
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if (CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && (ASSIGNED_TICKET_STATUS.equals("Rejected") || ASSIGNED_TICKET_STATUS.equals("Resolved") ) ) {
						// no action 
						System.out.println("the number is 4");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}
					else if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) {
						System.out.println("the number is 5");
						//action le
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
							
				
					}
					else  if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse ){
						//no action 
						System.out.println("the number is 6");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}		
					}
					else if(!CurrentStatus.equals("Re-Assigned")  ) {
						System.out.println("the number is 7");
						
						 if (!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //action le
							 System.out.println("the number is 8");
							 //NO
							 JSONObject Jobj= new JSONObject();
						
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
						 else if((!CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ){
							 //no action 
							 System.out.println("the number is 9");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
							
				
							//Pass;
							
						}else if((!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse)) {
							// continuew
							System.out.println("the number is 10");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}else if(!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse)
						{
							//no continiew
							System.out.println("the number is 11");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
					}
					
				
						
						
						//passs
					}

					
				}
				
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	}
	@Override
	public JSONArray CheckENGServiceRRequestUpdateConflict(String ticketid,String CurrentStatus ,String priviousetpnaame, String priviouseemail,String currentselectgrp, String crrentselecengg, String currentatassignto) {
		//System.out.println("INSIDE CheckENGTicketUpdateConflictforReassign DAO IMPL");
		JSONArray finalArray = new JSONArray();
		System.out.println("TICKET ID TO CHECK: "+ticketid+"status"+CurrentStatus);
		System.out.println("ASSIGN BY NAAME  "+ priviousetpnaame);
		System.out.println("ASSIGN BY EMAIL    "+ priviouseemail);
		
		String LoginUser = null;
		String loginRoleType="";
		String ENGG_GROUP_NAME="";
		String PREVIOUS_ENG_STATUS="";
		String PREVIOUS_ENG_NAME="";
		String ASSIGNED_TICKET_STATUS="";
		String RESOLVED_TICKET_STATUS="";
		String PREVIOUS_ENG_SOLUTION="";
		String PREVIOUS_ENG_SOLUTION_DATE="";
		String Role_typevalu="";
		String PREVIOUSTPNAME="";
		String TPSTATUS="";
		String NOTES="";
		String TPASSIGNDATE="";
		String Assignenggname="";
		String Assigndatae="";
		String Tp_NAME="";
		String TP_COMPANY="";
		String TP_NOTES="";
		String resolve_enggname="";
		String resolveenggcompany="";
		String resolve_date="";
		String resolve_solution="";
		String resolvestatus="";
		String EnggGroup="";
		String EnggGroupFORSPLIT="";
		String ENggCOMPANYIS="";
		String loginUserCompany="";
		boolean groupfalse=false;
		boolean enggnameorcom=false;
		String engiorgroupforswal="";
		String priviouseengorgroupforswal="";
		String previousActivityDoneBy="";
		String PreviousActivityBy="";
		String Roll_Type="";
		String FullName="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		
		List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster loginObj : loginset) {
			
			EnggGroupFORSPLIT=loginObj.getGROUP_NAME();
		//	//System.out.println("ENGG GROUP FOUND: "+enggGroup);
		}
	
		
	if(	currentatassignto.equals("Group")) {
		engiorgroupforswal=currentselectgrp;
	}
	else if(	currentatassignto.equals("Engineer")) {
	String splitselect[]=	crrentselecengg.split("~");
		engiorgroupforswal=splitselect[0]+"~"+splitselect[2];
	}
//////////////CHECK IF TICKET BELONGS TO GROUP
		try {
			Query queryticket_assigned = sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='" + ticketid+"'");
			service_request ticket_assigned_data = (service_request) queryticket_assigned.uniqueResult();
			if (ticket_assigned_data != null) {
				//System.out.println("IN TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = ticket_assigned_data.getASSIGN_TO();
				ASSIGNED_TICKET_STATUS= ticket_assigned_data.getSTATUS();
				Assignenggname=	ticket_assigned_data.getASSIGN_ENGG_NAME();
				ENggCOMPANYIS=ticket_assigned_data.getASSIGN_ENGG_COMPANY();
				Assigndatae=ticket_assigned_data.getREQUEST_ASSIGN_DATE();
				Tp_NAME=	ticket_assigned_data.getTP_ASSIGN_BY_NAME();
				TP_COMPANY=	ticket_assigned_data.getTP_ASSIGN_COMPANY();
				TP_NOTES=ticket_assigned_data.getASSIGN_ENGG_NOTE();
				EnggGroup=ticket_assigned_data.getASSIGN_ENGG_GROUP();
				
			//	Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULL_NAME from  loginmaster where COMPANY='"+TP_COMPANY+"' and USERNAME='"+Tp_NAME+"'");
				
//				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) where T_ID='"+ticketid+"') ");
//				
//				List<Object[]> listOfRU=qfor.list();
//				for(Object[]  obj:listOfRU)
//				{
//					Roll_Type=obj[0].toString();
//					FullName=obj[1].toString();
//					Tp_NAME=obj[2].toString();
//					
//				}
//				

				
				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) from service_request_activity_log where T_ID='"+ticketid+"') ");
				
				List<Object[]> listOfRU=qfor.list();
				for(Object[]  obj:listOfRU)
				{
					Roll_Type=obj[0].toString();
					FullName=obj[1].toString();
					Tp_NAME=obj[2].toString();
					
				}
				
				if(ENGG_GROUP_NAME .equals("Group")) {
					
				priviouseengorgroupforswal=	EnggGroup;
				}else {
					priviouseengorgroupforswal=Assignenggname+"~"+ENggCOMPANYIS;
				}
				
				////GET INFO FROM TICKET RESOLVE///////////
				
				//if(ASSIGNED_TICKET_STATUS.equals("Work in Progress")) {
				Query QUERYTICKETASSIGN = sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='" + ticketid+"'");
			List<service_request>  	 TICKETRESOLVEDATA2 = QUERYTICKETASSIGN.list();
				
				if (!TICKETRESOLVEDATA2.isEmpty()) {
					
					for(service_request TICKETRESOLVEDATA:TICKETRESOLVEDATA2 ) {
				
					resolve_enggname=	TICKETRESOLVEDATA.getRESOLVE_BY_NAME();
					resolveenggcompany=		TICKETRESOLVEDATA.getRESOLVE_BY_COMPANY();
					resolve_date=			TICKETRESOLVEDATA.getRESOLVE_DATE();
					resolve_solution=	TICKETRESOLVEDATA.getRESOLVE_NOTE();
					resolvestatus=TICKETRESOLVEDATA.getSTATUS();
					}
				}
				//}
			////GET INFO FROM TICKET RESOLVE///////////
				if (ENGG_GROUP_NAME.equals("Group")) {
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				String particulargroup[]=	EnggGroupFORSPLIT.split(",");
				for(String dumgroup:particulargroup) {
					
					if(dumgroup.equals(EnggGroup)) {
						groupfalse=true;
					}
				}
				
				}else if(ENGG_GROUP_NAME.equals("Engineer")) {
					
					if(Assignenggname.equals(LoginUser) && ENggCOMPANYIS.equals(loginUserCompany)) {
						
						enggnameorcom=	true;
					}
					
				}
				
				
				
				if (ENGG_GROUP_NAME.equals("Group")) {
					System.out.println("the number 1");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number 2");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) ||  (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Assigned") && groupfalse)|| ( CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && groupfalse) ) {
						System.out.println("the number 3");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							System.out.println("the number 4");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					
					

					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && groupfalse) {
						System.out.println("the number 5");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							System.out.println("the number 6");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						System.out.println("the number 7");
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								
								finalArray.put(Jobj);
						}else if((CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) || (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Assigned")  && groupfalse ) || ( CurrentStatus.equals("Work in Progress") &&  (ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && groupfalse))){
							
							System.out.println("the number 8");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							//fail
							
							System.out.println("the number 9");
							System.out.println("pre status "+ ASSIGNED_TICKET_STATUS );
							System.out.println("current status "+ CurrentStatus );
							System.out.println("current group is "+ groupfalse );
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					
				
						
						
						//passs
					}
				else {
					System.out.println("the number 10");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number 11");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom ) ||  (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Assigned") && enggnameorcom)|| ( CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && enggnameorcom) ) {
						System.out.println("the number 12");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							
							
							
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							System.out.println("the number 13");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					
					

					if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress") && enggnameorcom) {
						System.out.println("the number 14");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
					}
						else 
						{
							System.out.println("the number 15");
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
						}
					}
					else if(CurrentStatus.equals("Work in Progress")  ) {
						System.out.println("the number 16");
						 if (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //NO
								System.out.println("the number 17");
							 JSONObject Jobj= new JSONObject();
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
								Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
								
								finalArray.put(Jobj);
						}else if((CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && enggnameorcom ) || (CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Assigned")  && enggnameorcom ) || ( CurrentStatus.equals("Work in Progress") && ASSIGNED_TICKET_STATUS.equals("Hold") || ASSIGNED_TICKET_STATUS.equals("Waiting for Spare") || ASSIGNED_TICKET_STATUS.equals("Awaiting User Information") || ASSIGNED_TICKET_STATUS.equals("Pending With Vendor") && enggnameorcom)){
							System.out.println("the number 19");
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
				
							//Pass;
							
						}else {
							System.out.println("the number 20");
							//fail
							
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("RESOLVED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PREVIOUS_ACTIVITY_DONE_BY", Tp_NAME+"( "+ FullName+ " ) ");
							Jobj.put("PREVIOUS_ACTIVITY_BY",Roll_Type);
							finalArray.put(Jobj);
							
							
						}
					}
					
				
						
						
						//passs
					}

					
				}
				
			System.out.println("final array is    "+ finalArray);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	}


	@Override
	public JSONArray CheckENGConflictAfterWorInProgressServiceRequest(String ticketid, String CurrentStatus,String priviousetpnaame, String priviouseemail,String currentatassignto, String currentselectgrp, String crrentselecengg) {
		

		//System.out.println("INSIDE CheckENGTicketUpdateConflictforReassign DAO IMPL");
		JSONArray finalArray = new JSONArray();
		//System.out.println("TICKET ID TO CHECK: "+ticketid+"status"+CurrentStatus);
		//System.out.println("ASSIGN BY NAAME  "+ priviousetpnaame);
		//System.out.println("ASSIGN BY EMAIL    "+ priviouseemail);
		
		String LoginUser = null;
		String loginRoleType="";
		String ENGG_GROUP_NAME="";
		String PREVIOUS_ENG_STATUS="";
		String PREVIOUS_ENG_NAME="";
		String ASSIGNED_TICKET_STATUS="";
		String RESOLVED_TICKET_STATUS="";
		String PREVIOUS_ENG_SOLUTION="";
		String PREVIOUS_ENG_SOLUTION_DATE="";
		String Role_typevalu="";
		String PREVIOUSTPNAME="";
		String TPSTATUS="";
		String NOTES="";
		String TPASSIGNDATE="";
		String Assignenggname="";
		String Assigndatae="";
		String Tp_NAME="";
		String TP_COMPANY="";
		String TP_NOTES="";
		String resolve_enggname="";
		String resolveenggcompany="";
		String resolve_date="";
		String resolve_solution="";
		String resolvestatus="";
		String EnggGroup="";
		String EnggGroupFORSPLIT="";
		String ENggCOMPANYIS="";
		String loginUserCompany="";
		boolean groupfalse=false;
		boolean enggnameorcom=false;
		String engiorgroupforswal="";
		String priviouseengorgroupforswal="";
		String previouslyactivityfullname="";
		String previouslyactivityroletype="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginRoleType = session.getAttribute("role").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		
		List<loginmaster> loginset = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'").list();
		for (loginmaster loginObj : loginset) {
			
			EnggGroupFORSPLIT=loginObj.getGROUP_NAME();
		//	//System.out.println("ENGG GROUP FOUND: "+enggGroup);
		}
	
		
	if(	currentatassignto.equals("Group")) {
		engiorgroupforswal=currentselectgrp;
	}
	else if(	currentatassignto.equals("Engineer")) {
	String splitselect[]=	crrentselecengg.split("~");
		engiorgroupforswal=splitselect[0]+"~"+splitselect[2];
	}
//////////////CHECK IF TICKET BELONGS TO GROUP
		try {
			Query queryticket_assigned = sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='" + ticketid+"'");
			service_request ticket_assigned_data = (service_request) queryticket_assigned.uniqueResult();
			if (ticket_assigned_data != null) {
				//System.out.println("IN TICKET ASSIGNED DATA FOUND");
				ENGG_GROUP_NAME = ticket_assigned_data.getASSIGN_TO();
				ASSIGNED_TICKET_STATUS= ticket_assigned_data.getSTATUS();
				Assignenggname=	ticket_assigned_data.getASSIGN_ENGG_NAME();
				ENggCOMPANYIS=ticket_assigned_data.getASSIGN_ENGG_COMPANY();
				Assigndatae=ticket_assigned_data.getREQUEST_ASSIGN_DATE();
				Tp_NAME=	ticket_assigned_data.getTP_ASSIGN_BY_NAME();
				TP_COMPANY=	ticket_assigned_data.getTP_ASSIGN_COMPANY();
				TP_NOTES=ticket_assigned_data.getASSIGN_ENGG_NOTE();
				EnggGroup=ticket_assigned_data.getASSIGN_ENGG_GROUP();
				
				
//				Query queryforprioussedata = sessionFactory.getCurrentSession().createQuery("select FULL_NAME,ROLE_TYPE from loginmaster where username='" + Tp_NAME+"'  and COMPANY='"+TP_COMPANY+"'");	
//				List<Object[]> loginmasterdata2 =  queryforprioussedata.list();
//				
//				for(Object[]  logindata5:loginmasterdata2) 
//				{
//					previouslyactivityfullname=logindata5[0].toString();
//					previouslyactivityroletype=logindata5[1].toString();
//				}
//				
//				System.out.println("previouslyactivityfullname   :::"+ previouslyactivityfullname);
//				System.out.println("previouslyactivityroletype  __ :::"+ previouslyactivityroletype);
//				
//				
//				Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) where T_ID='"+ticketid+"') ");
//						
//						List<Object[]> listOfRU=qfor.list();
//						for(Object[]  obj:listOfRU)
//						{
//							previouslyactivityroletype=obj[0].toString();
//							previouslyactivityfullname=obj[1].toString();
//							Tp_NAME=obj[2].toString();
//							
//						}
//						
						
						Query qfor=sessionFactory.getCurrentSession().createSQLQuery("select ROLE_TYPE,FULLNAME ,T_CHANGEBY from  service_request_activity_log where SR_NO=(select max(SR_NO) from service_request_activity_log where T_ID='"+ticketid+"') ");
						
						List<Object[]> listOfRU=qfor.list();
						for(Object[]  obj:listOfRU)
						{
							previouslyactivityroletype=obj[0].toString();
							previouslyactivityfullname=obj[1].toString();
							Tp_NAME=obj[2].toString();
							
						}
				
				if(ENGG_GROUP_NAME .equals("Group")) {
				
				priviouseengorgroupforswal=	EnggGroup;
				}else {
					priviouseengorgroupforswal=Assignenggname+"~"+ENggCOMPANYIS;
				}
				
				////GET INFO FROM TICKET RESOLVE///////////
				
				//if(ASSIGNED_TICKET_STATUS.equals("Work in Progress")) {
				Query QUERYTICKETASSIGN = sessionFactory.getCurrentSession().createQuery("from service_request where T_ID='" + ticketid+"'");
				List<service_request>  	 TICKETRESOLVEDATA2 = QUERYTICKETASSIGN.list();
					
					if (!TICKETRESOLVEDATA2.isEmpty()) {
						
						for(service_request TICKETRESOLVEDATA:TICKETRESOLVEDATA2 ) {
					
						resolve_enggname=	TICKETRESOLVEDATA.getRESOLVE_BY_NAME();
						resolveenggcompany=		TICKETRESOLVEDATA.getRESOLVE_BY_COMPANY();
						resolve_date=			TICKETRESOLVEDATA.getRESOLVE_DATE();
						resolve_solution=	TICKETRESOLVEDATA.getRESOLVE_NOTE();
						resolvestatus=TICKETRESOLVEDATA.getSTATUS();
						}
					}

				//}
			////GET INFO FROM TICKET RESOLVE///////////
				if (ENGG_GROUP_NAME.equals("Group")) {
					
				//System.out.println("ENGG_GROUP_NAME FOUND: " + ENGG_GROUP_NAME);
				//System.out.println("ASSIGNED_TICKET_STATUS FOUND: " + ASSIGNED_TICKET_STATUS);
				
				String particulargroup[]=	EnggGroupFORSPLIT.split(",");
				for(String dumgroup:particulargroup) {
					
					if(dumgroup.equals(EnggGroup)) {
						groupfalse=true;
					}
				}
				
				}else if(ENGG_GROUP_NAME.equals("Engineer")) {
					
					if(Assignenggname.equals(LoginUser) && ENggCOMPANYIS.equals(loginUserCompany)) {
						
						enggnameorcom=	true;
					}
					
				}
				
				
				
				if (ENGG_GROUP_NAME.equals("Group")) {
					System.out.println("the number is 1");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number is 2");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ) {
						System.out.println("the number is 3");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && groupfalse) {
						System.out.println("the number is 4");
						// action le
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && !groupfalse) {
						System.out.println("the number is 4");
						//no action
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",groupfalse );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if (CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && (ASSIGNED_TICKET_STATUS.equals("Rejected") || ASSIGNED_TICKET_STATUS.equals("Resolved") )) {
						// no action 
						System.out.println("the number is 4");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}
					else if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) {
						System.out.println("the number is 5");
						//action le
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
							
				
					}
					else  if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse ){
						//no action 
						System.out.println("the number is 6");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",groupfalse );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}		
					}
					else if(!CurrentStatus.equals("Re-Assigned")  ) {
						System.out.println("the number is 7");
						
						 if (!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //action le
							 System.out.println("the number is 8");
							 //NO
							 JSONObject Jobj= new JSONObject();
						
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
						 else if((!CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ){
							 //no action 
							 System.out.println("the number is 9 nn");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
							
				
							//Pass;
							
						}else if((!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse)) {
							// no action
							System.out.println("the number is 10");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}else if(!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse)
						{
							//no continiew
							System.out.println("the number is 11");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",groupfalse );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
					}
					
				
						
						
						//passs
					}
				else {
					System.out.println("the number is 1");
					if(CurrentStatus.equals("Re-Assigned")) {
						System.out.println("the number is 2");
					if( (CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ) {
						System.out.println("the number is 3");
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && groupfalse) {
						System.out.println("the number is 4");
						// action le
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if(CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && !ASSIGNED_TICKET_STATUS.equals("Rejected") && !ASSIGNED_TICKET_STATUS.equals("Resolved") && !groupfalse) {
						System.out.println("the number is 4");
						//no action
							JSONObject Jobj= new JSONObject();
							Jobj.put("STATUS", "Fail");
							Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
							Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
							Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
							Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
							Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
						
							Jobj.put("ENGGGROUPTRUE",enggnameorcom );
							Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
							
							
							Jobj.put("currentengorgrpswal",engiorgroupforswal );
							Jobj.put("previouseassignto",ENGG_GROUP_NAME );
							Jobj.put("currentassignto",currentatassignto );
							Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
							Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
							
							
							finalArray.put(Jobj);
							
				
					}
					else if (CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress") && (ASSIGNED_TICKET_STATUS.equals("Rejected") || ASSIGNED_TICKET_STATUS.equals("Resolved") ) ) {
						// no action 
						System.out.println("the number is 4");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}
					else if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse ) {
						System.out.println("the number is 5");
						//action le
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
							
				
					}
					else  if(CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse ){
						//no action 
						System.out.println("the number is 6");
						JSONObject Jobj= new JSONObject();
						Jobj.put("STATUS", "Fail");
						Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
						Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
						Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
						Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
						Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
					
						Jobj.put("ENGGGROUPTRUE",enggnameorcom );
						Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
						
						
						Jobj.put("currentengorgrpswal",engiorgroupforswal );
						Jobj.put("previouseassignto",ENGG_GROUP_NAME );
						Jobj.put("currentassignto",currentatassignto );
						Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
						Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
						
						
						finalArray.put(Jobj);
					}		
					}
					else if(!CurrentStatus.equals("Re-Assigned")  ) {
						System.out.println("the number is 7");
						
						 if (!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Work in Progress")  )
						{
							 //action le
							 System.out.println("the number is 8");
							 //NO
							 JSONObject Jobj= new JSONObject();
						
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
						 else if((!CurrentStatus.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !ASSIGNED_TICKET_STATUS.equals("Work in Progress")) ){
							 //no action 
							 System.out.println("the number is 9");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
							
				
							//Pass;
							
						}else if((!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && groupfalse)) {
							// continuew
							System.out.println("the number is 10");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}else if(!CurrentStatus.equals("Re-Assigned") && ASSIGNED_TICKET_STATUS.equals("Re-Assigned") && !groupfalse)
						{
							//no continiew
							System.out.println("the number is 11");
							 JSONObject Jobj= new JSONObject();
								
								Jobj.put("STATUS", "Fail");
								Jobj.put("PREVIOUS_ENG_NAME", Assignenggname);
								Jobj.put("ASSIGNED_TICKET_STATUS", ASSIGNED_TICKET_STATUS);
								Jobj.put("PREVIOUS_ENG_SOLUTION", TP_NOTES );
								Jobj.put("PREVIOUS_ENG_SOLUTION_DATE",Assigndatae );
								Jobj.put("PREVIOUS_ENG_COMPANY",TP_COMPANY );
							
								Jobj.put("ENGGGROUPTRUE",enggnameorcom );
								Jobj.put("PRIVIGROUP",priviouseengorgroupforswal );
								
								
								Jobj.put("currentengorgrpswal",engiorgroupforswal );
								Jobj.put("previouseassignto",ENGG_GROUP_NAME );
								Jobj.put("currentassignto",currentatassignto );
								Jobj.put("previouslyactivityfullname",Tp_NAME+" ( "+previouslyactivityfullname +" )" );
								Jobj.put("previouslyactivityroletype",previouslyactivityroletype );
								
								
								finalArray.put(Jobj);
						}
					}
					
				
						
						
						//passs
					}

					
				}
				
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalArray;
	
		
	}
	@Override
	public JSONArray getenggWorkInProgressRequest(String loginUser) {

		System.out.println("INSIDE GETASSIGN DAO ENGG");

		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		String LoginScope = "";
		String output = "";
		String enggCategory = "";
		String enggGroup = "";
		String company = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		try {
			////// GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + loginUser + "' and COMPANY='" + company + "'")
					.list();
			for (loginmaster loginObj : loginset) {
				enggCategory = loginObj.getCATEGORY();
				enggGroup = loginObj.getGROUP_NAME().replace(",", "','");
				System.out.println("ENGG GROUP FOUND: " + enggGroup);
			}

			List<service_request> dataSet = sessionFactory.getCurrentSession()
					.createQuery("from service_request where ("+LoginScope+") AND  (STATUS='Work in Progress'  AND ASSIGN_ENGG_COMPANY='"
							+ company + "' and  ASSIGN_ENGG_NAME='" + loginUser + "' or ASSIGN_ENGG_GROUP in('"
							+ enggGroup + "') and STATUS='Work in Progress') )	order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc")
					.list();
			array = new JSONArray();
			for (service_request sourceDrive : dataSet) {
				srno = srno + 1;
				array1 = new JSONArray();

				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array1.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");

array1.put(sourceDrive.getT_ID());
				
				array1.put(sourceDrive.getSTATUS());
				array1.put(sourceDrive.getPRIORITY());
				array1.put(sourceDrive.getSEVERITY());
				array1.put(sourceDrive.getT_SUBJECT());
				array1.put(sourceDrive.getT_COMPANY());
				array1.put(sourceDrive.getT_BRANCH());
				array1.put(sourceDrive.getT_DEPARTMENT());
				array1.put(sourceDrive.getT_CATEGORY());
				array1.put(sourceDrive.getT_SUBCAT1());
				array1.put(sourceDrive.getT_SUBCAT2());
				if(sourceDrive.getTP_ASSIGN_BY_NAME() == null) {
			    	array1.put("NA");
			    	
			    }else {
			    	
			    	array1.put(sourceDrive.getTP_ASSIGN_BY_NAME());
			    }
			 if(sourceDrive.getTP_ASSIGN_BY_FULLNAME() == null) {
			    	array1.put("NA");
			    	
			    }else {
			    	
			    	array1.put(sourceDrive.getTP_ASSIGN_BY_FULLNAME());
			    }
				if(sourceDrive.getASSIGN_TO().equals("Engineer"))
				{
					array1.put(sourceDrive.getASSIGN_ENGG_NAME());	
				}
				else
				{
					array1.put(sourceDrive.getASSIGN_ENGG_GROUP());
				}
				if(sourceDrive.getASSIGN_ENGG_FULLNAME()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getASSIGN_ENGG_FULLNAME());
				}
				
				 if(sourceDrive.getREQUEST_TYPE()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getREQUEST_TYPE());
					}
					if(sourceDrive.getAPPROVAL_LEVEL()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getAPPROVAL_LEVEL());
					}
					if(sourceDrive.getLEVEL_1_APPROVER_NAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_1_APPROVER_NAME());
					}
					if(sourceDrive.getLEVEL_1_APPROVER_FULLNAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_1_APPROVER_FULLNAME());
					}
					
					if(sourceDrive.getLEVEL_1_STATUS()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_1_STATUS());
					}
					
					if(sourceDrive.getLEVEL_2_APPROVER_NAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_2_APPROVER_NAME());
					}
					
					if(sourceDrive.getLEVEL_2_APPROVER_FULLNAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_2_APPROVER_FULLNAME());
					}
					
					if(sourceDrive.getLEVEL_2_STATUS()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getLEVEL_2_STATUS());
					}
					if(sourceDrive.getRESOLVE_BY_NAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getRESOLVE_BY_NAME());
					}
					if(sourceDrive.getRESOLVE_BY_FULLNAME()==null)
					{
						array1.put("NA");
					}
					else
					{
						array1.put(sourceDrive.getRESOLVE_BY_FULLNAME());
					}
				
				
				array1.put(sourceDrive.getT_DATE());
				if(sourceDrive.getLEVEL_1_TIMESTAMP()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_1_TIMESTAMP());
				}
				if(sourceDrive.getLEVEL_2_TIMESTAMP()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getLEVEL_2_TIMESTAMP());
				}		
				if(sourceDrive.getREQUEST_ASSIGN_DATE()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getREQUEST_ASSIGN_DATE());
				}	
				if(sourceDrive.getRESOLVE_DATE()==null)
				{
					array1.put("NA");
				}
				else
				{
					array1.put(sourceDrive.getRESOLVE_DATE());
				}
				array.put(array1);
			}
			System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception In tryyy branch" + e);
		}
	
		
		return array;

	}

	@Override
	public String  UpdateAssignRequestsFromWIP(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup,String otheremail) {

		String mysqldate = "";
		String tppname = null;
		String tppphn = null;
		String tppmail = null;
		String tppuname = null;
		String tp_name_yes = "";
		String StrTID = "";
		String phoneNos = "";
		String methodStatus = "";
		String loginname = "";
		String fullname = "";
		String emailid = "";
		String phone = "";
		String LoginUser="";
		String loginUserCompany="";
		
		
		try {
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			String fullnameOfLogin="";
			String fullnameOfEngg="";
			String loginRoleType="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginRoleType = session.getAttribute("role").toString();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				fullnameOfLogin= session.getAttribute("fullname").toString();
				System.out.println("loginRoleType****" + loginRoleType);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exceptioon e***" + e);
			}

				///////////////// FILE UPLOAD STARTS //////////////
				String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
				System.out.println("FILENAME WITHOUT EXT: "+fileNameWithOutExt);
				DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(localdate.format(now));
				String localDateNow=localdate.format(now);
				//String createnewfilename = UUID.randomUUID().toString();
				String createnewfilename = fileNameWithOutExt+" "+localDateNow+"_"+tid;
				System.out.println("createnewfilename***" + createnewfilename);
				//createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
				
				String ext = "";
				String updatedFileName = null;
				String company=null;
				String EnggName="";
				String EngCompany="";
				String BranchForSla="";
				String DeptForSla="";
				try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
				File file = new File("C:\\ITHelpDesk\\");
				if (!file.exists()) {
					if (file.mkdir()) {
						System.out.println("Directory is created!");
					} else {
						System.out.println("Failed to create directory!");
					}
				}
				} catch (Exception e) {
				System.out.println("directory create exception" + e);
				}
				
				String fileName = resolvePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
//				String pathOfFile = uploadedFile.getPath();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();
				
				//-------------------------------------------
				//File uploadedFile =  empPic;
//				File uploadedFile = new File(resolvePic.getOriginalFilename());
//				uploadedFile.createNewFile();
//				FileOutputStream fos = new FileOutputStream(uploadedFile);
//				fos.write(resolvePic.getBytes());
//				fos.close();
//				System.out.println("uploadedFile::::" + uploadedFile);
//				String fileName = resolvePic.getOriginalFilename();
//				System.out.println("fileName::::" + fileName);
//				ext = FilenameUtils.getExtension(fileName);
//				System.out.println("file_extension::::" + ext);
//				//File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//				System.out.println("destFile........" + destFile);
//				//System.out.println("File........" + imagefilePath + File.separator +
//				//fileName);
//				System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				//-------------------------------------------------------------
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME: " + updatedFileName);
				
//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
				} catch (Exception e) {
				System.out.println("directory create exception" + e);
				}
				
				///////////////// FILE UPLOAD ENDS //////////////

				try {
					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					loginname = session.getAttribute("username").toString();
					company = session.getAttribute("companyname").toString();
				
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}

			
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			String fullName="";
			String EnggFullName="";
			Query forfullname=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
			List<loginmaster> ls=forfullname.list();
			for(loginmaster lm:ls)
			{
				fullName=lm.getFULL_NAME();
			}
			
			if(!status.equals("Re-Assigned")) {
				try {
					
					System.out.println("New Status is :: "+status);
				
					Query query1 = sessionFactory.getCurrentSession().createQuery("UPDATE service_request set STATUS=:st,RESOLVE_BY_FULLNAME=:RESOLVE_BY_FULLNAME,RESOLVE_BY_EMAIL=:RESOLVE_BY_EMAIL,RESOLVE_BY_NAME=:engg,RESOLVE_NOTE=:enote,RESOLVE_DATE=:rsoldate ,RESOLVE_BY_COMPANY=:RCOMPANY,CURRENT_STATUS_ACTIVITY_TIME=:CURRENT_STATUS_ACTIVITY_TIME WHERE T_ID=:T_ID");
					query1.setParameter("st", status);
					query1.setParameter("engg", LoginUser);
					query1.setParameter("RESOLVE_BY_FULLNAME", fullnameOfLogin);
					query1.setParameter("RESOLVE_BY_EMAIL", engemailid);
					
					query1.setParameter("enote", solution);
					query1.setParameter("rsoldate", currenttime);
					query1.setParameter("RCOMPANY", loginUserCompany);
					query1.setParameter("T_ID", tid);
					query1.setParameter("CURRENT_STATUS_ACTIVITY_TIME", currenttime);
					query1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(status.equals("Re-Assigned"))
			{
				try {

					System.out.println("New Status is ::  else Re-Assigned "+status);
					try {
						System.out.println("assigned Engg Name before split" + enggassign);
						String[] splitEng = enggassign.split("~");
						{
							EnggName = splitEng[0];
							fullnameOfEngg=splitEng[1];
							EngCompany = splitEng[2];
						
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
//						System.out.println("Engg Name after split"+EnggName);
//						System.out.println("dfgdfgg Engg  Company"+EngCompany);
//						System.out.println(" i am in else if condition ");
				
						Query q2 = sessionFactory.getCurrentSession().createQuery(
								"update service_request set STATUS=:STATUS,TP_ASSIGN_by_NAME=:TP_ASSIGN_by_NAME,TP_ASSIGN_BY_FULLNAME=:TP_ASSIGN_BY_FULLNAME,TP_ASSIGN_BY_EMAIL=:TP_ASSIGN_BY_EMAIL,TP_ASSIGN_COMPANY=:TP_ASSIGN_COMPANY,ASSIGN_TO=:ASSIGN_TO,ASSIGN_ENGG_NAME=:ASSIGN_ENGG_NAME,ASSIGN_ENGG_FULLNAME=:ASSIGN_ENGG_FULLNAME,ASSIGN_ENGG_EMAIL=:ASSIGN_ENGG_EMAIL,ASSIGN_ENGG_COMPANY=:ASSIGN_ENGG_COMPANY,ASSIGN_ENGG_GROUP=:ASSIGN_ENGG_GROUP,ASSIGN_ENGG_NOTE=:ASSIGN_ENGG_NOTE,REQUEST_ASSIGN_DATE=:REQUEST_ASSIGN_DATE,CURRENT_STATUS_ACTIVITY_TIME=:CURRENT_STATUS_ACTIVITY_TIME where T_ID=:T_ID");
						q2.setParameter("STATUS", status);
					
						q2.setParameter("TP_ASSIGN_BY_FULLNAME", fullnameOfLogin);
						q2.setParameter("TP_ASSIGN_BY_EMAIL", engemailid);
						
						q2.setParameter("TP_ASSIGN_by_NAME", loginname);
						q2.setParameter("TP_ASSIGN_COMPANY", company);
						q2.setParameter("CURRENT_STATUS_ACTIVITY_TIME", currenttime);
						q2.setParameter("ASSIGN_TO",assignTo);
						if(assignTo.equals("Engineer"))
						{	
							
							q2.setParameter("ASSIGN_ENGG_FULLNAME", fullnameOfEngg);
							q2.setParameter("ASSIGN_ENGG_EMAIL", otheremail);
							
							q2.setParameter("ASSIGN_ENGG_NAME", EnggName);
							q2.setParameter("ASSIGN_ENGG_COMPANY", EngCompany);
							q2.setParameter("ASSIGN_ENGG_GROUP","NA");
						}
						else if(assignTo.equals("Group"))
						{
							q2.setParameter("ASSIGN_ENGG_FULLNAME", "NA");
							q2.setParameter("ASSIGN_ENGG_EMAIL", "NA");
							q2.setParameter("ASSIGN_ENGG_NAME", "NA");
							q2.setParameter("ASSIGN_ENGG_COMPANY", "NA");
							q2.setParameter("ASSIGN_ENGG_GROUP",engGroup);
						}
						q2.setParameter("ASSIGN_ENGG_NOTE",solution);
						q2.setParameter("REQUEST_ASSIGN_DATE",currenttime);
						q2.setParameter("T_ID", tid);
						int i=q2.executeUpdate();
						System.out.println("sddfd updated successfully!"+i);
						
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			
			try {
				String FullNameOfTo="";
				Query forcheck=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+EngCompany+"' and USERNAME='"+EnggName+"'");
				List<loginmaster> lmstr=forcheck.list();
				for(loginmaster lm12:lmstr)
				{
					FullNameOfTo=lm12.getFULL_NAME();
				}
				String groupORengg = "";
				enggassign=EnggName;
				if (assignTo.contentEquals("Engineer")) {
					groupORengg = enggassign;
					groupORengg=groupORengg+" ["+FullNameOfTo+"]";
				} else if (assignTo.contentEquals("Group")) {
					groupORengg = engGroup;
				}
				//EnggFullName=LoginUser+"["+fullName+"]";
			
				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession().createQuery("select max(SR_NO) from service_request_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				String FullName=getLoginMasterData();
				if (!status.equals("Re-Assigned")) {
					System.out.println(" Full Name with Company of login user "+FullName);

					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+ "<tr><td>Engineer Name:</td><td>"+loginname+"["+FullName+"]</td></tr>";	
				} else if(status.equals("Re-Assigned")){
					msg = "<tr><td>TimeStamp:</td><td>"+currenttime+"</td></tr>"
							+ "<tr><td>Status:</td><td>"+status+"</td></tr>"
							+"<tr><td>Assigned By:</td><td>"+loginname+"["+FullName+"]</td></tr>"
							+"<tr><td>Assigned To:</td><td>"+assignTo+"</td></tr>"
							+ "<tr><td>"+assignTo+" Name:</td><td>"+groupORengg+"</td></tr>";		
					}
					
//				int idd=Integer.parseInt(tid);
//				Inv.RaiseNCloseEmailSMS(idd,engname,status,userbranch,category,sub,username,priority,engphone,engemailid);

				
			List<loginmaster> lm=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'").list();
			for(loginmaster lmc:lm)
			{
				fullname=lmc.getFULL_NAME();
				emailid=lmc.getEMAIL();
				phone=lmc.getPHONE();
				BranchForSla=lmc.getBRANCH();
				DeptForSla=lmc.getDEPARTMENT();
			}
				service_request_tracking ticket_tracking = new service_request_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				ticket_tracking.setACTIVITY_COMPANY(loginUserCompany);
				ticket_tracking.setTICKET_RAISED_BY_COMPANY(usercompany);
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				System.out.println("insert in ticket tracking***");
			
			
			
///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		int ActSno = 0;
		try {
		
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(service_request_activity_log.class).setProjection(Projections.max("SR_NO"));
			Integer actSrno1 = (Integer) crit.uniqueResult();
		
			System.out.println(" actSrno1 IS: " + actSrno1);
		
			if (actSrno1 != null) {
				ActSno = actSrno1.intValue();
				ActSno = ActSno + 1;
				System.out.println("IN IF ActSno IS: " + ActSno);
			} else {
				ActSno = 1;
				System.out.println("IN ELSE ActSno IS: " + ActSno);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		service_request_activity_log ticketActivityLog = new service_request_activity_log();
		
		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(tid);
		ticketActivityLog.setPRIORITY(priority);
		ticketActivityLog.setSTATUS(status);
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginname);
		ticketActivityLog.setT_SUBJECT(sub);
		ticketActivityLog.setT_DESC(description);
		ticketActivityLog.setCHANGE_NOTES1(solution);
		ticketActivityLog.setROLE_TYPE(loginRoleType);
		ticketActivityLog.setSEVERITY(severity);
		ticketActivityLog.setT_CATEGORY(category);
		ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
		ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
		ticketActivityLog.setCOMPANY(loginUserCompany);
		
		ticketActivityLog.setEMAIL(emailid);
		
		ticketActivityLog.setCONTACT_NO(phone);
		ticketActivityLog.setFULLNAME(fullname);
		
		

		if (updatedFileName == null) {
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
		}
		
		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		methodStatus="success";
			
			}
	
			
			
			
			catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////SRVICE REQUEST SLA START //////////////////
			try
			{
				Query query11 = sessionFactory.getCurrentSession()
						.createQuery("from service_request_sla where TICKET_ID=:TICKET_ID");
				query11.setParameter("TICKET_ID", tid);
				service_request_sla sla4 = (service_request_sla) query11.uniqueResult();
				if (sla4 != null) {
					System.out.println("IN SLA UPDATE");

					Query updatesla = sessionFactory.getCurrentSession().createQuery(
							"update service_request_sla set TICKET_STATUS=:TICKET_STATUS where  TICKET_ID=:TICKET_ID");
					updatesla.setParameter("TICKET_STATUS",status);
					updatesla.setParameter("TICKET_ID", tid);
					int i=updatesla.executeUpdate();
					System.out.println("Successfull if i is 1::::::::::"+i);
				
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}	
			///////////////////////////SERVICE REQUEST SLA END //////////////////
			
			///////////////////////////SERVICE HISTORICAL  SLA START //////////////////
			try
			{
				int SRNO1=0;
				System.out.println("Inside Histirical sla start");
				if(status.equals("Awaiting User Information")||status.equals("Hold")||status.equals("Pending With Vendor")||status.equals("Waiting for Spare"))
				{
					System.out.println("inside all 4 hold status");
					
					Criteria criteria=sessionFactory.getCurrentSession().createCriteria(service_request_historical_sla.class).setProjection(Projections.max("SR_NO"));
					Integer SRNO2=(Integer) criteria.uniqueResult();
					if(SRNO2!=null)
					{
						SRNO1=SRNO2.intValue();
						SRNO1 = SRNO1 + 1;
						
					}
					else
					{
						SRNO1=1;
						System.out.println("Inside else ");
					}
					service_request_historical_sla historicalsla = new service_request_historical_sla();
					
					historicalsla.setSR_NO(SRNO1);
					historicalsla.setTICKET_ID(tid);
				
					historicalsla.setTICKET_STATUS(status);
				
					historicalsla.setSLA_STATUS("NA");
					historicalsla.setHOLD_START_DATE(currenttime);
					historicalsla.setHOLD_END_DATE("NA");
					historicalsla.setHOLD_ELAPSED_TIME("NA");
					
					historicalsla.setHOLD_DURATION("NA");
					
					historicalsla.setT_COMPANY(loginUserCompany);
					historicalsla.setT_BRANCH(BranchForSla);
					historicalsla.setT_DEPARTMENT(DeptForSla);
				sessionFactory.getCurrentSession().save(historicalsla);
					 
					System.out.println("get success");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			///////////////////////////SRVICE HISTORICAL SLA END //////////////////
			
			String assign_TO="";
			String engGroupName="";
			String engName="";
			String userPh="";
			String enggcompanyc = "";
		
			Query ls1=sessionFactory.openSession().createQuery("from service_request  where T_ID='"+tid+"'");
				List<service_request> list3 = ls1.list();
			for(service_request str:list3)
			{
				 assign_TO = str.getASSIGN_TO();
				 engName = str.getASSIGN_ENGG_NAME();
				 userPh= str.getT_PHONE();
				 enggcompanyc = str.getASSIGN_ENGG_COMPANY();
				 engGroupName=str.getASSIGN_ENGG_GROUP();
			}
			methodStatus = "success";
			System.out.println("status+"+status);
			try {	
				if(methodStatus.equals("success"))
				Inv.EmailSMSTriggeredForServiceRequest(tid, status,assign_TO,engName,userPh,enggcompanyc,engGroupName);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}catch (Exception e) {
			methodStatus="fail";
		e.printStackTrace();
		}
		//System.out.println("Status is "+status);
		return methodStatus+"~"+status;
}
	
	@Override
	public JSONArray getTcWorkInProgressRequest(String loginUser) {


		System.out.println("INSIDE GETASSIGN DAO ENGG getTcWorkInProgressRequest  ");

//		JSONArray array = null;
		JSONArray array1 = null;
		int srno[] = {0};
		String LoginScope = "";
		String output = "";
		String enggCategory = "";
		String enggGroup = "";
		String company = "";
		String LoginUser="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			LoginUser = session.getAttribute("username").toString();
			System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		try {
			////// GET ENGINEERS DATA////
			List<loginmaster> loginset = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + loginUser + "' and COMPANY='" + company + "'")
					.list();
			for (loginmaster loginObj : loginset) {
				enggCategory = loginObj.getCATEGORY();
				enggGroup = loginObj.getGROUP_NAME().replace(",", "','");
				System.out.println("ENGG GROUP FOUND: " + enggGroup);
			}

			List<service_request> dataSet = sessionFactory.getCurrentSession()
					.createQuery("from service_request where ASSIGN_ENGG_NAME='"+loginUser+"' and  ASSIGN_ENGG_COMPANY='"+company+"' and STATUS='Work in Progress'	order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc")
					.list();
			array1 = new JSONArray();
//			for (service_request sourceDrive : dataSet) {
			array1=dataSet.stream().map(sourceDrive ->{
				srno[0] = srno[0] + 1;
			JSONArray array = new JSONArray();

				array.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelView' onclick='ViewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(
						"<button class='btn btn-info' data-toggle='modal' data-target='#modelUpdate' onclick='updateTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-edit'></i></button>");
 
				array.put(sourceDrive.getT_ID());
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getPRIORITY());
				array.put(sourceDrive.getSEVERITY());
				array.put(sourceDrive.getT_SUBJECT());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_CATEGORY());
				array.put(sourceDrive.getT_SUBCAT1());
				array.put(sourceDrive.getT_SUBCAT2());
				array.put(sourceDrive.getASSIGNED_GROUP());
				
			    if(sourceDrive.getTP_ASSIGN_BY_NAME() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getTP_ASSIGN_BY_NAME());
			    }
			    if(sourceDrive.getTP_ASSIGN_BY_FULLNAME() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getTP_ASSIGN_BY_FULLNAME());
			    }
			    
			    if(sourceDrive.getASSIGN_TO() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getASSIGN_TO());
			    }

			    if(sourceDrive.getASSIGN_ENGG_NAME() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getASSIGN_ENGG_NAME());
			    }
			    if(sourceDrive.getASSIGN_ENGG_FULLNAME() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getASSIGN_ENGG_FULLNAME());
			    }
			   
			    if(sourceDrive.getASSIGN_ENGG_GROUP() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getASSIGN_ENGG_GROUP());
			    }
			    if(sourceDrive.getRESOLVE_BY_NAME()== null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getRESOLVE_BY_NAME());
			    }
			    if(sourceDrive.getRESOLVE_BY_FULLNAME() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getRESOLVE_BY_FULLNAME());
			    }
			   
			    	
			    	array.put(sourceDrive.getT_DATE());
			    
			    if(sourceDrive.getREQUEST_ASSIGN_DATE() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	
			    	array.put(sourceDrive.getREQUEST_ASSIGN_DATE());
			    }
			    if(sourceDrive.getRESOLVE_DATE() == null) {
			    	array.put("NA");
			    	
			    }else {
			    	if(sourceDrive.getSTATUS().equals("Closed") || sourceDrive.getSTATUS().equals("Resolved")) {
			    		
			    		array.put(sourceDrive.getRESOLVE_DATE());
			    	}else {
			    		array.put("NA");
			    	}
			    }
//				array1.put(array);
			    return array;
			}).collect(JSONArray::new,JSONArray::put,JSONArray::put);
//			System.out.println("arrray111" + array);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception In tryyy branch" + e);
		}
	
		
		return array1;
	}
	
	
	@Override
	public String  UpdateFromWIPRequests(String tid, String status, String engname, String engsite,
			String engemailid, String engphone, String username, String usercompany, String userbranch,
			String useremail, String userphone, String tcname, String tcemail, String tcphone, String raisedate,
			String assigndate, String priority, String sub, String description, String category, String subcat1,
			String subcat2, String solution, MultipartFile resolvePic, String severity, String assignTo, String enggcat,
			String enggassign, String engGroup,String otheremail) {
		
		String methodStatus = "";
		try {
			String mysqldate = "";
			String tppname = null;
			String tppphn = null;
			String tppmail = null;
			String tppuname = null;
			String tp_name_yes = "";
			String StrTID = "";
			String phoneNos = "";
			
			String loginname = "";
			String fullname = "";
			String emailid = "";
			String phone = "";
			String LoginUser = "";
			String loginUserCompany = "";
			String resolveTime = null;
			long elapsedSeconds = 0;
			long elapsedMinutes = 0;
			long elapsedHours = 0;
			long elapsedDays = 0;
			String raiseTime = null;
			String currenttime = null;
			DateFormat dateFormat = null;
			String RoleType = "";
			System.out.println("inside UpdateFromWIPRequests DAO IMPL");
			String FullName = "";
String FullNameOFLogin="";
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginUserCompany = session.getAttribute("companyname").toString();
				loginname = session.getAttribute("username").toString();
				RoleType = session.getAttribute("role").toString();
				FullNameOFLogin = session.getAttribute("fullname").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
///////////////// FILE UPLOAD STARTS //////////////
			String fileNameWithOutExt = FilenameUtils.removeExtension(resolvePic.getOriginalFilename());
			System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
			// String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + tid;
			System.out.println("createnewfilename***" + createnewfilename);
			// createnewfilename = createnewfilename.substring(0,
			// createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;
			String company = null;
			String EnggName = "";
			String EngCompany = "";
			String OLD_STATUS = "";
			String BranchForSla = "";
			String DeptForSla = "";
			String fullnameOfEngg="";
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							System.out.println("Directory is created!");
						} else {
							System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					System.out.println("directory create exception" + e);
				}
				
				String fileName = resolvePic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
//				String pathOfFile = uploadedFile.getPath();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(resolvePic.getBytes());
				fos.close();
				//--------------------------------------------
				// File uploadedFile = empPic;
//				File uploadedFile = new File(resolvePic.getOriginalFilename());
//				uploadedFile.createNewFile();
//				FileOutputStream fos = new FileOutputStream(uploadedFile);
//				fos.write(resolvePic.getBytes());
//				fos.close();
//				System.out.println("uploadedFile::::" + uploadedFile);
//				String fileName = resolvePic.getOriginalFilename();
//				System.out.println("fileName::::" + fileName);
//				ext = FilenameUtils.getExtension(fileName);
//				System.out.println("file_extension::::" + ext);
//				// File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//				System.out.println("destFile........" + destFile);
//				// System.out.println("File........" + imagefilePath + File.separator +
//				// fileName);
//				System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				//-----------------------------------------------------
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME: " + updatedFileName);

//				try {
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
				///////////////// FILE UPLOAD ENDS //////////////
			} catch (Exception e) {
				System.out.println("directory create exception" + e);
			}

			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			System.out.println(dateFormat.format(date));
			currenttime = dateFormat.format(date);
			Date currentdate = dateFormat.parse(currenttime);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date tdate = new Date();
			String currenttime11 = simpleDateFormat.format(tdate);
			System.out.println("currenttime11***" + currenttime11);
			Date todaydate = simpleDateFormat.parse(currenttime11);
			String fullName = "";
			String EnggFullName = "";

			if (!status.equals("Re-Assigned")) {
				try {

					System.out.println("New Status is :: " + status);
					System.out.println("New Status is :: " + FullNameOFLogin);
					Query query1 = sessionFactory.getCurrentSession().createQuery(
							"UPDATE service_request set STATUS=:st,RESOLVE_BY_NAME=:engg,RESOLVE_BY_FULLNAME=:RESOLVE_BY_FULLNAME,RESOLVE_NOTE=:enote,RESOLVE_DATE=:rsoldate ,RESOLVE_BY_COMPANY=:RCOMPANY,CURRENT_STATUS_ACTIVITY_TIME=:CURRENT_STATUS_ACTIVITY_TIME,RESOLVE_BY_EMAIL=:RESOLVE_BY_EMAIL WHERE T_ID=:T_ID");
					query1.setParameter("st", status);
					query1.setParameter("engg", loginname);
					query1.setParameter("enote", solution);
					query1.setParameter("rsoldate", currenttime);
					query1.setParameter("RCOMPANY", loginUserCompany);
					query1.setParameter("T_ID", tid);
					query1.setParameter("RESOLVE_BY_FULLNAME", FullNameOFLogin);
					query1.setParameter("RESOLVE_BY_EMAIL", engemailid);
					query1.setParameter("CURRENT_STATUS_ACTIVITY_TIME", currenttime);
					query1.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (status.equals("Re-Assigned")) {
				try {	

					System.out.println("New Status is ::  else Re-Assigned " + status);
					try {
						System.out.println("assigned Engg Name before split" + enggassign);
						String[] splitEng = enggassign.split("~");
						{
							EnggName = splitEng[0];
							System.out.println("after split" + splitEng[0]);
							fullnameOfEngg=splitEng[1];
							EngCompany = splitEng[2];
							System.out.println("aster split comp" + splitEng[2]);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
//					System.out.println("Engg Name after split"+EnggName);
//					System.out.println("dfgdfgg Engg  Company"+EngCompany);
					System.out.println(" i am in else if condition ");

					Query q2 = sessionFactory.getCurrentSession().createQuery(
							"update service_request set STATUS=:STATUS,TP_ASSIGN_by_NAME=:TP_ASSIGN_by_NAME,TP_ASSIGN_BY_FULLNAME=:TP_ASSIGN_BY_FULLNAME,TP_ASSIGN_BY_EMAIL=:TP_ASSIGN_BY_EMAIL,TP_ASSIGN_COMPANY=:TP_ASSIGN_COMPANY,ASSIGN_TO=:ASSIGN_TO,ASSIGN_ENGG_NAME=:ASSIGN_ENGG_NAME,ASSIGN_ENGG_FULLNAME=:ASSIGN_ENGG_FULLNAME,ASSIGN_ENGG_EMAIL=:ASSIGN_ENGG_EMAIL,ASSIGN_ENGG_COMPANY=:ASSIGN_ENGG_COMPANY,ASSIGN_ENGG_GROUP=:ASSIGN_ENGG_GROUP,ASSIGN_ENGG_NOTE=:ASSIGN_ENGG_NOTE,REQUEST_ASSIGN_DATE=:REQUEST_ASSIGN_DATE,CURRENT_STATUS_ACTIVITY_TIME=:CURRENT_STATUS_ACTIVITY_TIME where T_ID=:T_ID");
					q2.setParameter("STATUS", status);
					
					
					q2.setParameter("TP_ASSIGN_BY_FULLNAME", FullNameOFLogin);
					
					q2.setParameter("TP_ASSIGN_by_NAME", loginname);
					q2.setParameter("TP_ASSIGN_COMPANY", company);
					q2.setParameter("CURRENT_STATUS_ACTIVITY_TIME", currenttime);
					q2.setParameter("TP_ASSIGN_BY_EMAIL", engemailid);
					q2.setParameter("ASSIGN_TO", assignTo);
					if (assignTo.equals("Engineer")) {
						q2.setParameter("ASSIGN_ENGG_NAME", EnggName);
						q2.setParameter("ASSIGN_ENGG_COMPANY", EngCompany);
						q2.setParameter("ASSIGN_ENGG_GROUP", "NA");
						q2.setParameter("ASSIGN_ENGG_FULLNAME", fullnameOfEngg);
						q2.setParameter("ASSIGN_ENGG_EMAIL", otheremail);
						
					} else if (assignTo.equals("Group")) {
						q2.setParameter("ASSIGN_ENGG_NAME", "NA");
						q2.setParameter("ASSIGN_ENGG_COMPANY", "NA");
						q2.setParameter("ASSIGN_ENGG_GROUP", engGroup);
						q2.setParameter("ASSIGN_ENGG_FULLNAME", "NA");
						q2.setParameter("ASSIGN_ENGG_EMAIL", "NA");
					}
					q2.setParameter("ASSIGN_ENGG_NOTE", solution);
					q2.setParameter("REQUEST_ASSIGN_DATE", currenttime);
					q2.setParameter("T_ID", tid);
					int i = q2.executeUpdate();
					System.out.println("sddfd updated successfully!" + i);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			try {
				String FullNameOfTo = "";
				Query forcheck = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where COMPANY='" + EngCompany + "' and USERNAME='" + EnggName + "'");
				List<loginmaster> lmstr = forcheck.list();
				for (loginmaster lm12 : lmstr) {
					FullNameOfTo = lm12.getFULL_NAME();
				}
				String groupORengg = "";
				enggassign = EnggName;
				if (assignTo.contentEquals("Engineer")) {
					groupORengg = enggassign;
					groupORengg = groupORengg + " [" + FullNameOfTo + "]";
				} else if (assignTo.contentEquals("Group")) {
					groupORengg = engGroup;
				}
				// EnggFullName=LoginUser+"["+fullName+"]";

				int sno = 0;
				List<Integer> l = sessionFactory.getCurrentSession()
						.createQuery("select max(SR_NO) from service_request_tracking").list();
				if (l.isEmpty()) {
					sno = 1;
				} else {
					int temp = Integer.parseInt(String.valueOf(l.get(0)));
					sno = temp + 1;
				}
				String msg = null;
				String FullNames = getLoginMasterData();
				if (!status.equals("Re-Assigned")) {
					System.out.println(" Full Name with Company of login user " + FullName);

					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>"
							+ status + "</td></tr>" + "<tr><td>Engineer Name:</td><td>" + loginname + "[" + FullNames
							+ "]</td></tr>";
				} else if (status.equals("Re-Assigned")) {
					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>"
							+ status + "</td></tr>" + "<tr><td>Assigned By:</td><td>" + loginname + "[" + FullNames
							+ "]</td></tr>" + "<tr><td>Assigned To:</td><td>" + assignTo + "</td></tr>" + "<tr><td>"
							+ assignTo + " Name:</td><td>" + groupORengg + "</td></tr>";
				}

//			int idd=Integer.parseInt(tid);
//			Inv.RaiseNCloseEmailSMS(idd,engname,status,userbranch,category,sub,username,priority,engphone,engemailid);

				List<loginmaster> lm = sessionFactory.getCurrentSession().createQuery(
						"from loginmaster where COMPANY='" + loginUserCompany + "' and USERNAME='" + loginname + "'")
						.list();
				for (loginmaster lmc : lm) {
					fullname = lmc.getFULL_NAME();
					emailid = lmc.getEMAIL();
					phone = lmc.getPHONE();
					BranchForSla = lmc.getBRANCH();
					DeptForSla = lmc.getDEPARTMENT();
				}
				service_request_tracking ticket_tracking = new service_request_tracking();
				ticket_tracking.setSR_NO(sno);
				ticket_tracking.setT_ID(tid);
				ticket_tracking.setACTIVITY_DATE(currenttime);
				ticket_tracking.setACTIVITY_NAME(loginname);
				ticket_tracking.setCATEGORY(category);
				ticket_tracking.setSUBCATEGORY1(subcat1);
				ticket_tracking.setSUBCATEGORY2(subcat2);
				ticket_tracking.setSUBJECT(sub);
				ticket_tracking.setSTATUS(status);
				ticket_tracking.setPRIORITY(priority);
				ticket_tracking.setSEVERITY(severity);
				ticket_tracking.setMESSAGE(msg);
				ticket_tracking.setTICKET_RAISED_NAME(username);
				ticket_tracking.setACTIVITY_DATE_TIME(currenttime);
				ticket_tracking.setACTIVITY_COMPANY(loginUserCompany);
				ticket_tracking.setTICKET_RAISED_BY_COMPANY(usercompany);
				if (updatedFileName == null) {
					ticket_tracking.setATTACHMENT_NAME("No File Available");
				} else {
					ticket_tracking.setATTACHMENT_NAME(updatedFileName);
				}
				getSession().save(ticket_tracking);
				System.out.println("insert in ticket tracking***");
///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				int ActSno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(service_request_activity_log.class).setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
				}

				service_request_activity_log ticketActivityLog = new service_request_activity_log();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setPRIORITY(priority);
				ticketActivityLog.setSTATUS(status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginname);
				ticketActivityLog.setT_SUBJECT(sub);
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setCHANGE_NOTES1(solution);
				ticketActivityLog.setROLE_TYPE(RoleType);
				ticketActivityLog.setSEVERITY(severity);
				ticketActivityLog.setT_CATEGORY(category);
				ticketActivityLog.setT_SUB_CATEGORY1(subcat1);
				ticketActivityLog.setT_SUB_CATEGORY2(subcat2);
				ticketActivityLog.setCOMPANY(loginUserCompany);

				ticketActivityLog.setEMAIL(emailid);

				ticketActivityLog.setCONTACT_NO(phone);
				ticketActivityLog.setFULLNAME(fullname);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				methodStatus = "success";

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			/////////////////////////// SRVICE REQUEST SLA START //////////////////
			try {
				Query query11 = sessionFactory.getCurrentSession()
						.createQuery("from service_request_sla where TICKET_ID=:TICKET_ID");
				query11.setParameter("TICKET_ID", tid);
				service_request_sla sla4 = (service_request_sla) query11.uniqueResult();
				if (sla4 != null) {
					System.out.println("IN SLA UPDATE");

					Query updatesla = sessionFactory.getCurrentSession().createQuery(
							"update service_request_sla set TICKET_STATUS=:TICKET_STATUS where  TICKET_ID=:TICKET_ID");
					updatesla.setParameter("TICKET_STATUS", status);
					updatesla.setParameter("TICKET_ID", tid);
					int i = updatesla.executeUpdate();
					System.out.println("Successfull if i is 1::::::::::" + i);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			///////////////////////////SERVICE REQUEST SLA END //////////////////

			////////////////////////// SERVICE REWQUEST HISTORICAL SLA START ////////////////////
			try
			{
				int SRNO1=0;
				System.out.println("Inside Histirical sla start");
				if(status.equals("Awaiting User Information")||status.equals("Hold")||status.equals("Pending With Vendor")||status.equals("Waiting for Spare"))
				{
					System.out.println("inside all 4 hold status");
					Criteria criteria=sessionFactory.getCurrentSession().createCriteria(service_request_historical_sla.class).setProjection(Projections.max("SR_NO"));
					Integer SRNO2=(Integer) criteria.uniqueResult();
					if(SRNO2!=null)
					{
						SRNO1=SRNO2.intValue();
						SRNO1 = SRNO1 + 1;
						
					}
					else
					{
						SRNO1=1;
						System.out.println("Inside else ");
					}
					service_request_historical_sla historicalsla = new service_request_historical_sla();
					
					historicalsla.setSR_NO(SRNO1);
					historicalsla.setTICKET_ID(tid);
					historicalsla.setTICKET_STATUS(status);
				
					historicalsla.setSLA_STATUS("NA");
					historicalsla.setHOLD_START_DATE(currenttime);
					historicalsla.setHOLD_END_DATE("NA");
					historicalsla.setHOLD_ELAPSED_TIME("NA");

					historicalsla.setHOLD_DURATION("NA");
					historicalsla.setT_COMPANY(loginUserCompany);
					historicalsla.setT_BRANCH(BranchForSla);
					historicalsla.setT_DEPARTMENT(DeptForSla);
					sessionFactory.getCurrentSession().save(historicalsla);
					 
					System.out.println("get success");
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			/////////////////////////SERVICE REQUEST HISTORICAL SAL END /////////////////////
			String assign_TO="";
			String engGroupName="";
			String engName="";
			String userPh="";
			String enggcompanyc = "";
		
			Query ls1=sessionFactory.openSession().createQuery("from service_request  where T_ID='"+tid+"'");
				List<service_request> list3 = ls1.list();
			for(service_request str:list3)
			{
				 assign_TO = str.getASSIGN_TO();
				 engName = str.getASSIGN_ENGG_NAME();
				 userPh= str.getT_PHONE();
				 enggcompanyc = str.getASSIGN_ENGG_COMPANY();
				 engGroupName=str.getASSIGN_ENGG_GROUP();
			}
			methodStatus = "success";
			System.out.println("status+"+status);
			
			try {	
				if(methodStatus.equals("success"))
				Inv.EmailSMSTriggeredForServiceRequest(tid, status,assign_TO,engName,userPh,enggcompanyc,engGroupName);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		} catch (Exception e) {
			methodStatus="fail";
			e.printStackTrace();
		}

		return methodStatus+"~"+status;

	}
	public  String  getLoginMasterData()
	{
		String FullName="";
		String loginUserCompany = "";
		String LoginUser="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginUserCompany = session.getAttribute("companyname").toString();
			LoginUser = session.getAttribute("username").toString();
			System.out.println("loginUserCompany****" + loginUserCompany);
			System.out.println("loginUser****"+LoginUser);
			Query forFullName=sessionFactory.getCurrentSession().createQuery("from loginmaster where COMPANY='"+loginUserCompany+"' and USERNAME='"+LoginUser+"'");
			List<loginmaster> listUser=forFullName.list();
			for(loginmaster lmg:listUser)
			{
				FullName=lmg.getFULL_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exceptioon e***" + e);
		}
		return FullName;
	}

	@Override
	public JSONArray getEnggDashboardDataticketgroup(String lastmonth)
	{


		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String userlogin="";
		
		try {
			
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			userlogin = session.getAttribute("username").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
		
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", userlogin);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
				
			 
			
			      System.out.println("lastnmonhhPPPPPPPPPPPPPPPPPPPPPP"+lastmonth);
		System.out.println("dghgdhdfdsgfg dfrsdffdfewqre");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct ENGINEER_GROUP,count(ENGINEER_GROUP) from ticket_assigned where   (ENGINEER_GROUP IN('"+ enggGroupList +"')) and  (STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  (STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s')))   group by ENGINEER_GROUP ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {
				
				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

			

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
	
		
	}

	@Override
	public JSONArray getEnggDashboardDataticketCategory(String lastmonth) {
		



		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String username="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			username = session.getAttribute("username").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
				
			 
			
			      System.out.println("lastnmonhh"+lastmonth);
			      String GroupofEng="";
					 Query getGroup=sessionFactory.getCurrentSession().createSQLQuery("select GROUP_NAME from loginmaster where USERNAME='"+username+"'and COMPANY='"+loginUserCompany+"' and ROLE_TYPE='Engineer'");
					 List<Object> ls=getGroup.list();
					 for(Object obj:ls)
						 {
						 GroupofEng=obj.toString();
						 }
					 System.out.println("group name4"+GroupofEng);
					 String FinalGroup=GroupofEng.replaceAll(",","','");
			System.out.println("dghgdhdfpppppppdsgfg dfrdfewqre");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct t.T_CATEGORY AS T_CATEGORY,count(t.T_CATEGORY) from ticket  AS t left JOIN ticket_assigned ta ON t.T_ID=ta.T_ID where   ((ta.ENGINEER_NAME='"+username+"'  AND ta.ENGINEER_COMPANY='"+loginUserCompany+"') OR(ta.ENGINEER_GROUP in ('"+FinalGroup+"')) or (t.T_REQUESTER='"+username+"' and  t.T_COMPANY='"+loginUserCompany+"')) and  (STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s') ) group by T_CATEGORY ").list();
//			or( ) or()
			array1 = new JSONArray();
			for (Object[] listData : l) {
				

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

			

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
	
		
	
	}

	@Override
	public JSONArray getEnggDashboardDataservicerequestgroup(String lastmonth) {
		

		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String username="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			username = session.getAttribute("username").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", username);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			//System.out.println("dghgdhdfdsgfg dfrdfewqre");

			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						 LocalDateTime datetime1 = LocalDateTime.now();  
						 String CurrentTime = localdate.format(datetime1);
						 LocalDateTime minusMonths = datetime1.minusMonths(1);
						 String lastmonthFinal = localdate.format(minusMonths);
//						 System.out.println("current time "+CurrentTime);
						 
//						 System.out.println("lastmonthFinal99"+lastmonthFinal);
						   System.out.println("LAST MONY?H&"+lastmonth);
						    
						 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
						 {
							 System.out.println("INSIDE NULL TRUE");
							 lastmonth=lastmonthFinal; 
							 System.out.println("lastmonth  ========"+lastmonth);
						 }
						 else if(lastmonth.equals("lastweek"))
						 {
							 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
							 String lastweek = localdate.format(minusWeeks);
							 lastmonth=lastweek;
							 System.out.println("week  ========"+lastmonth);
						 }
						 else if(lastmonth.equals("lastthreemonth"))
						 {
							 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
							 String lastthreemonth = localdate.format(minusthreeMonths);
							 lastmonth=lastthreemonth;
							 System.out.println("lastthreemonth  ========"+lastmonth);
						 }
							
						 
						
						      System.out.println("lastnmonhhtttt"+lastmonth);
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct ASSIGN_ENGG_GROUP,count(ASSIGN_ENGG_GROUP) from service_request where   (ASSIGN_ENGG_GROUP IN('"+ enggGroupList +"')) and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))      group by ASSIGN_ENGG_GROUP ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

			

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
	
		
	
		
		
	}


	
	

	@Override
	public JSONArray getEnggDashboardDaservicerequestcategory(String lastmonth) {
		

		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String username="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			username = session.getAttribute("username").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			//System.out.println("dghgdhdfdsgfg dfrdfewqre");
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
				String GroupofEng="";
			 Query getGroup=sessionFactory.getCurrentSession().createSQLQuery("select GROUP_NAME from loginmaster where USERNAME='"+username+"'and COMPANY='"+loginUserCompany+"' and ROLE_TYPE='Engineer'");
			 List<Object> ls=getGroup.list();
			 for(Object obj:ls)
				 {
				 GroupofEng=obj.toString();
				 }
			 System.out.println("group name4dsssssssssssssssss"+GroupofEng);
			 String FinalGroup=GroupofEng.replaceAll(",","','");
			      System.out.println("lastnmonhh"+lastmonth);
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct T_CATEGORY,count(T_CATEGORY) from service_request where (( T_REQUESTER='"+username+"' and  T_COMPANY='"+loginUserCompany+"') or(ASSIGN_ENGG_NAME='"+username+"' and ASSIGN_ENGG_COMPANY='"+loginUserCompany+"' )  or (ASSIGN_ENGG_GROUP in('"+FinalGroup+"')))and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))    group by T_CATEGORY ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

			

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
		
	}

	@Override
	public JSONArray priorityseverityserviceengg(String lastmonth) {
		

		
		String db_cname = null;
		JSONArray array = null;
		String  groupName="";
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginUser = "";
		String loginUserCompany = "";
		String LoginScope = "";
		JSONArray temparray=null;
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		 LocalDateTime datetime1 = LocalDateTime.now();  
		 String CurrentTime = localdate.format(datetime1);
		 LocalDateTime minusMonths = datetime1.minusMonths(1);
		 String lastmonthFinal = localdate.format(minusMonths);
//		 System.out.println("current time "+CurrentTime);
		 
		   System.out.println("THE VALUE IS  "+lastmonth);
		 if(lastmonth==null || lastmonth.equals("undefined")|| lastmonth.equals("lastmonth"))
		 {
			 lastmonth=lastmonthFinal; 
			 System.out.println("lastmonth  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastweek"))
		 {
			 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
			 String lastweek = localdate.format(minusWeeks);
			 lastmonth=lastweek;
			 System.out.println("week  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastthreemonth"))
		 {
			 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
			 String lastthreemonth = localdate.format(minusthreeMonths);
			 lastmonth=lastthreemonth;
			 System.out.println("week  ========"+lastmonth);
		 }
			 System.out.println("lastnmonhh"+lastmonth);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany=session.getAttribute("companyname").toString();
		
			
					List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			//
						Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
						q1.setParameter("USERNAME", LoginUser);
						q1.setParameter("COMPANY", loginUserCompany);
						q1.setParameter("ROLE_TYPE", "Engineer");
						loginMaster=q1.list();
						for (loginmaster lm : loginMaster) {
							groupName =	lm.getGROUP_NAME();
						}
		
						groupName=groupName.replaceAll(",", "','");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Exceptioonterfefrfg");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct PRIORITY,SEVERITY,count(T_ID) from service_request where ((T_REQUESTER='"+LoginUser+"' and T_COMPANY ='"+loginUserCompany+"') OR (ASSIGN_ENGG_NAME='"+LoginUser+"' AND ASSIGN_ENGG_COMPANY='"+loginUserCompany+"'  ) OR ASSIGN_ENGG_GROUP in ('"+groupName+"'))and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))   group by   PRIORITY,SEVERITY").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[2].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("priority", listData[0].toString());
				record.put("severity", listData[1].toString());
				record.put("y", statuscount);
				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	
		
	}

	@Override
	public JSONArray priorityseverityTicketdashboardengg(String lastmonth) {
		System.out.println("dghdfgdgfg");
		String db_cname = null;
		JSONArray array = null;
		String  groupName="";
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginUser = "";
		String loginUserCompany = "";
		String LoginScope = "";
		JSONArray temparray=null;
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		 LocalDateTime datetime1 = LocalDateTime.now();  
		 String CurrentTime = localdate.format(datetime1);
		 LocalDateTime minusMonths = datetime1.minusMonths(1);
		 String lastmonthFinal = localdate.format(minusMonths);
//		 System.out.println("current time "+CurrentTime);
		 
		   System.out.println("THE VALUE IS  "+lastmonth);
		 if(lastmonth==null || lastmonth.equals("undefined")|| lastmonth.equals("lastmonth"))
		 {
			 lastmonth=lastmonthFinal; 
			 System.out.println("lastmonth  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastweek"))
		 {
			 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
			 String lastweek = localdate.format(minusWeeks);
			 lastmonth=lastweek;
			 System.out.println("week  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastthreemonth"))
		 {
			 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
			 String lastthreemonth = localdate.format(minusthreeMonths);
			 lastmonth=lastthreemonth;
			 System.out.println("week  ========"+lastmonth);
		 }
			 System.out.println("lastnmonhh"+lastmonth);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany=session.getAttribute("companyname").toString();
		
			
					List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			//
						Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
						q1.setParameter("USERNAME", LoginUser);
						q1.setParameter("COMPANY", loginUserCompany);
						q1.setParameter("ROLE_TYPE", "Engineer");
						loginMaster=q1.list();
						for (loginmaster lm : loginMaster) {
							groupName =	lm.getGROUP_NAME();
						}
		
						groupName=groupName.replaceAll(",", "','");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			System.out.println("ExceptioonDCDSCFSDFC");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct PRIORITY,SEVERITY,count(t.T_ID) from ticket t left join ticket_assigned ta on t.T_ID=ta.T_ID where ((t.T_REQUESTER='"+LoginUser+"' and t.T_COMPANY ='"+loginUserCompany+"') OR (ta.ENGINEER_NAME='"+LoginUser+"' AND ta.ENGINEER_COMPANY='"+loginUserCompany+"'  ) OR ta.ENGINEER_GROUP in ('"+groupName+"')) and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))   group by   PRIORITY,SEVERITY").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[2].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("priority", listData[0].toString());
				record.put("severity", listData[1].toString());
				record.put("y", statuscount);
				array1.put(record);
				//System.out.println("db_cname: " + priority);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	
		
	
		
	}

	@Override
	public JSONArray priorityseverityProblemTicketdashboardengg(String lastmonth) {

		String db_cname = null;
		JSONArray array = null;
		String  groupName="";
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginUser = "";
		String loginUserCompany = "";
		String LoginScope = "";
		JSONArray temparray=null;
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		 LocalDateTime datetime1 = LocalDateTime.now();  
		 String CurrentTime = localdate.format(datetime1);
		 LocalDateTime minusMonths = datetime1.minusMonths(1);
		 String lastmonthFinal = localdate.format(minusMonths);
//		 System.out.println("current time "+CurrentTime);
		 
		   System.out.println("THE VALUE IS  "+lastmonth);
		 if(lastmonth==null || lastmonth.equals("undefined")|| lastmonth.equals("lastmonth"))
		 {
			 lastmonth=lastmonthFinal; 
			 System.out.println("lastmonth  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastweek"))
		 {
			 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
			 String lastweek = localdate.format(minusWeeks);
			 lastmonth=lastweek;
			 System.out.println("week  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastthreemonth"))
		 {
			 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
			 String lastthreemonth = localdate.format(minusthreeMonths);
			 lastmonth=lastthreemonth;
			 System.out.println("week  ========"+lastmonth);
		 }
			 System.out.println("lastnmonhh"+lastmonth);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany=session.getAttribute("companyname").toString();
		
			
					List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			//
						Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
						q1.setParameter("USERNAME", LoginUser);
						q1.setParameter("COMPANY", loginUserCompany);
						q1.setParameter("ROLE_TYPE", "Engineer");
						loginMaster=q1.list();
						for (loginmaster lm : loginMaster) {
							groupName =	lm.getGROUP_NAME();
						}
		
						groupName=groupName.replaceAll(",", "','");
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct t.PRIORITY,t.SEVERITY,count(t.PT_ID) from problem_ticket t left join problem_ticket_assigned ta on t.PT_ID=ta.PT_ID where ((t.PT_REQUESTER='"+LoginUser+"' and t.PT_COMPANY ='"+loginUserCompany+"') OR (ta.ENGINEER_NAME='"+LoginUser+"' AND ta.PT_ENGINEER_COMPANY='"+loginUserCompany+"'  ) OR ta.ENGINEER_GROUP in ('"+groupName+"')) and  (STR_TO_DATE(PT_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))   group by   t.PRIORITY,t.SEVERITY").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				System.out.println("listDatafvv");

				JSONObject record = new JSONObject();

				count = listData[2].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("priority", listData[0].toString());
				record.put("severity", listData[1].toString());
				record.put("y", statuscount);
				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	
		
	
		
	
	}

	@Override
	public JSONArray getEnggDashboardDaProblemcategory(String lastmonth) {

		

		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String username="";
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		 LocalDateTime datetime1 = LocalDateTime.now();  
		 String CurrentTime = localdate.format(datetime1);
		 LocalDateTime minusMonths = datetime1.minusMonths(1);
		 String lastmonthFinal = localdate.format(minusMonths);
		 String Role_Type="";
		 String GroupName="";
//		 System.out.println("current time "+CurrentTime);
		 
		   System.out.println("THE VALUE IS  "+lastmonth);
		 if(lastmonth==null || lastmonth.equals("undefined")|| lastmonth.equals("lastmonth"))
		 {
			 lastmonth=lastmonthFinal; 
			 System.out.println("lastmonth  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastweek"))
		 {
			 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
			 String lastweek = localdate.format(minusWeeks);
			 lastmonth=lastweek;
			 System.out.println("week  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastthreemonth"))
		 {
			 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
			 String lastthreemonth = localdate.format(minusthreeMonths);
			 lastmonth=lastthreemonth;
			 System.out.println("week  ========"+lastmonth);
		 }
			 System.out.println("lastnmonhh"+lastmonth);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			username = session.getAttribute("username").toString();
			Role_Type= session.getAttribute("role").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		System.out.println("Exceptiooncdssdc");
		Query getEngGroup=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+username+"' and COMPANY='"+loginUserCompany+"' and ROLE_TYPE='"+Role_Type+"'");
		List<loginmaster> list=getEngGroup.list();
		for(loginmaster ls :list)
		{
			GroupName=ls.getGROUP_NAME();
		}
		String EnggGroup = GroupName.replaceAll(",", "','");
		try {
			System.out.println("dghgdhdfdsgfg gdfgdgdfgdfggdf");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct T_PROBLEM_CATEGORY,count(T_PROBLEM_CATEGORY) from problem_ticket_assigned where ((ENGINEER_NAME='"+username+"' and PT_ENGINEER_COMPANY='"+loginUserCompany+"') or ENGINEER_GROUP in('"+EnggGroup+"')) and  (STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))    group by T_PROBLEM_CATEGORY ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

			

				array1.put(record);
				//System.out.println("db_cname: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	
		
	
	}

	@Override
	public JSONArray getEnggDashboardDataProblemticketgroup(String lastmonth) {
		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		String loginuser="";
		 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		 LocalDateTime datetime1 = LocalDateTime.now();  
		 String CurrentTime = localdate.format(datetime1);
		 LocalDateTime minusMonths = datetime1.minusMonths(1);
		 String lastmonthFinal = localdate.format(minusMonths);
		 System.out.println("current ffgfdsfdtime "+CurrentTime);
		 
		   System.out.println("THE VALUE IS of currwent month  "+lastmonth);
		 if(lastmonth==null || lastmonth.equals("undefined")|| lastmonth.equals("lastmonth"))
		 {
			 lastmonth=lastmonthFinal; 
			 System.out.println("lastmonth  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastweek"))
		 {
			 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
			 String lastweek = localdate.format(minusWeeks);
			 lastmonth=lastweek;
			 System.out.println("week  ========"+lastmonth);
		 }
		 else if(lastmonth.equals("lastthreemonth"))
		 {
			 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
			 String lastthreemonth = localdate.format(minusthreeMonths);
			 lastmonth=lastthreemonth;
			 System.out.println("lastthreemonth  ========"+lastmonth);
		 }
			 System.out.println("lastnmonhh"+lastmonth);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser = session.getAttribute("username").toString();
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		enggGroupList=groupName.replaceAll(",", "','");
		try {
		System.out.println("dghgdhdfdsgfg jkgjkkjg");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select distinct ENGINEER_GROUP,count(ENGINEER_GROUP) from problem_ticket_assigned where   (ENGINEER_GROUP IN('"+ enggGroupList +"')) and   (STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))     group by ENGINEER_GROUP ").list();

			array1 = new JSONArray();
			for (Object[] listData : l) {

				//System.out.println(listData[0].toString());

				JSONObject record = new JSONObject();

				count = listData[1].toString();
				statuscount = Integer.valueOf((String) count);
				record.put("name", listData[0].toString());
				record.put("y", statuscount);

				array1.put(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}


	
	@Override
	public JSONArray getIncidentGroupList(String loginuser,String lastmonth, String group) {
		//System.out.println("Inside TPActivityDaoImpl getAllIncidentTicketList methodgjkjgjkk");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****ghkjkjhkdfgfdgfg" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		
	
		enggGroupList=groupName.replaceAll(",", "','");
		try {
		
					List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select t.T_ID,ENGINEER_GROUP, t.T_COMPANY, t.T_BRANCH,t.T_DEPARTMENT,ta.T_PRIORITY,ta.T_SEVERITY, ta.T_SUBJECT,ta.T_CATEGORY,ta.T_SUBCATEGORY1,ta.T_SUBCATEGORY2,t.REQUEST_MODE,t.T_REQUESTER,t.T_RAISE_TIME, ta.TP_NAME,ta.T_ASSIGN_TO , ta.ENGINEER_NAME, ta.T_ASSIGN_DATE,tr.RESOLVED_ENGINEER_NAME,tr.T_RESOLVED_TIME,t.T_CLOSEBY,t.T_CLOSEDATE from  ticket t  left join ticket_assigned ta  on t.T_ID=ta.T_ID left join ticket_resolved  tr   on t.T_ID=tr.T_ID   where ENGINEER_GROUP=('"+group+"') AND (STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+"','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+CurrentTime+"','%d-%m-%Y %H:%i:%s'))").list();


			array = new JSONArray();
			for (Object[] listData : l) {
				array1 = new JSONArray();
			
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				
				array.put(array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}

	return array;
	}

	@Override
	public JSONArray getServiceGroupList(String loginuser, String lastmonth, String group) {
		


		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser = session.getAttribute("username").toString();
			
			
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		
		array= new JSONArray();
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			
			System.out.println("lastthreemonthaaa");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select T_ID,ASSIGN_ENGG_GROUP,REQUEST_TYPE,PRIORITY,SEVERITY,T_SUBJECT,T_COMPANY,T_BRANCH,T_DEPARTMENT,T_CATEGORY,T_SUBCAT1,T_SUBCAT2,ASSIGNED_GROUP,T_REQUESTER,TP_ASSIGN_by_NAME,ASSIGN_TO,ASSIGN_ENGG_NAME,T_DATE,REQUEST_ASSIGN_DATE,RESOLVE_DATE ,COMPLETE_DATE, T_CLOSEBY,T_CLOSEDATE,LEVEL_1_TIMESTAMP,LEVEL_1_APPROVER_NAME,LEVEL_2_TIMESTAMP,LEVEL_2_APPROVER_NAME from service_request where (ASSIGN_ENGG_GROUP='"+ group +"')  and   (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('"+lastmonth+"','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+CurrentTime+"','%d-%m-%Y %H:%i:%s'))").list();

		
			for (Object[] listData : l) {

				array1 = new JSONArray();
				//System.out.println(listData[0].toString());

				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
				
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
				if ((listData[26]) == null || (listData[26].toString()).contains("null")
						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[26]);
				}
			
				
				array.put(array1);
			}
			//System.out.println("db_cnamedaf: " + array);
			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;

	}

	
	@Override
	public JSONArray getProblemGroupList(String loginuser, String lastmonth, String group) {
		//System.out.println("Inside getProblemGroupList getTPDashboardData method");
		JSONArray array1 = null;
		JSONArray array =  new JSONArray();
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****fdtyty" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle excption
		}
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println(" i am in getProblemGroupList");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select * from (select t.PT_ID,ta.ENGINEER_GROUP as ENGINEER_GROUP,t.PT_COMPANY , t.PT_BRANCH,t.PT_DEPARTMENT ,t.PT_SUBJECT,t.REQUEST_MODE,t.PRIORITY,t.SEVERITY, t.T_PROBLEM_CATEGORY,t.T_PROBLEM_SUBCAT1, t.T_PROBLEM_SUBCAT2,t.PT_REQUESTER,t.PT_DATE,ta.TP_NAME, ta.PT_ASSIGN_TO, ta.ENGINEER_NAME as s,ta.PT_ENGINEER_COMPANY as ENGINEER_COMPANY,t.PROBLEM_STATUS as PROBLEM_STATUS,ta.PT_ASSIGN_TIME,tr.ENGINEER_NAME,tr.PT_FIXINPROCESS_DATE,tr.PT_RCA_DATE, tr.PT_RESOLVE_DATE,t.PT_CLOSEBY,t.PT_CLOSEDATE from problem_ticket t LEFT JOIN problem_ticket_assigned ta on t.PT_ID=ta.PT_ID  left join problem_ticket_resolved tr on t.PT_ID=tr.PT_ID ) as  inn    where ENGINEER_GROUP='"+group+"' and   (STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s') ) ").list();
			
			//array1 =null;
			
			for (Object[] listData : l) {
				
				array1 = new JSONArray();
				
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
			
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
//				if ((listData[26]) == null || (listData[26].toString()).contains("null")
//						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
//						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
//					array1.put("-");
//				} else {
//					array1.put(listData[26]);
//				}
			
				array.put(array1);
				
				
			}
			
			//System.out.println("THIS IS ARRAY   "+array);	
			//System.out.println("THIS IS ARRAY1   "+array1);	
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}

		return array;
	}

	
	@Override
	public JSONArray getIncidentCategoryListing(String loginuser, String lastmonth,String category) {
		//System.out.println("Inside TPActivityDaoImpl getIncidentCategoryListing methodgjkjgjkk");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****ghkjkjhkdfgfdgfg" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			
			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }

		
		
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println("ExceptioonRTTTTTnnqqqq");
					List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(" select t.T_ID,t.T_CATEGORY, t.T_COMPANY, t.T_BRANCH,t.T_DEPARTMENT,ta.T_PRIORITY,ta.T_SEVERITY, ta.T_SUBJECT,ta.T_STATUS,ta.T_SUBCATEGORY1,ta.T_SUBCATEGORY2,t.REQUEST_MODE,t.T_REQUESTER,t.T_RAISE_TIME, ta.TP_NAME,ta.T_ASSIGN_TO , ta.ENGINEER_NAME, ta.T_ASSIGN_DATE,tr.RESOLVED_ENGINEER_NAME,tr.T_RESOLVED_TIME,t.T_CLOSEBY,t.T_CLOSEDATE from  ticket t  left join ticket_assigned ta  on t.T_ID=ta.T_ID left join ticket_resolved  tr   on t.T_ID=tr.T_ID   where( ( t.T_CATEGORY='"+category+"' AND   ta.ENGINEER_NAME='"+loginuser+"' AND ta.ENGINEER_COMPANY='"+loginUserCompany+"') OR (  ta.ENGINEER_GROUP in ('"+enggGroupList+"')AND 	 t.T_CATEGORY='"+category+"') OR (t.T_CATEGORY='"+category+"' AND   t.T_REQUESTER='"+loginuser+"' AND t.T_COMPANY='"+loginUserCompany+"')) AND (STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+"','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+CurrentTime+"','%d-%m-%Y %H:%i:%s'))").list();


			array = new JSONArray();
			for (Object[] listData : l) {
				array1 = new JSONArray();
			
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				
				array.put(array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;
	}


	@Override
	public JSONArray getServiceRequestCategoryListing(String loginuser, String lastmonth, String category) {
		


		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser = session.getAttribute("username").toString();
			
			
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		
		array= new JSONArray();
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			
			System.out.println("lastyyyyyyy");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select T_ID,T_CATEGORY,REQUEST_TYPE,PRIORITY,SEVERITY,T_SUBJECT,T_COMPANY,T_BRANCH,T_DEPARTMENT,STATUS,T_SUBCAT1,T_SUBCAT2,ASSIGNED_GROUP,T_REQUESTER,TP_ASSIGN_by_NAME,ASSIGN_TO,ASSIGN_ENGG_NAME,T_DATE,REQUEST_ASSIGN_DATE,RESOLVE_DATE ,COMPLETE_DATE, T_CLOSEBY,T_CLOSEDATE,LEVEL_1_TIMESTAMP,LEVEL_1_APPROVER_NAME,LEVEL_2_TIMESTAMP,LEVEL_2_APPROVER_NAME from service_request where ( (ASSIGN_ENGG_NAME='"+ loginuser +"'and ASSIGN_ENGG_COMPANY='"+ loginUserCompany +"' AND T_CATEGORY='"+category+"')OR ASSIGN_ENGG_GROUP IN('"+ enggGroupList +"') AND  T_CATEGORY='"+category+"' OR T_REQUESTER='"+loginuser+"' and  T_COMPANY='"+loginUserCompany+"' and T_CATEGORY='"+category+"' ) and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))").list();

		
			for (Object[] listData : l) {

				array1 = new JSONArray();
				//System.out.println(listData[0].toString());

				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
				
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
				if ((listData[26]) == null || (listData[26].toString()).contains("null")
						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[26]);
				}
			
				
				array.put(array1);
			}
			//System.out.println("db_cnamedaf: " + array);
			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;

	}


	
	
	@Override
	public JSONArray getPrioritySeverityIncidentListing(String loginuser, String lastmonth,String priority,String severity) {
		//System.out.println("Inside TPActivityDaoImpl getIncidentCategoryListing methodgjkjgjkk");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****ghkjkjhkdfgfdgfg" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();
			
			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }

		
		
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println("ExceptioonRTTTTTnnddd");
					List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery(" select t.T_ID,ta.T_PRIORITY,ta.T_SEVERITY,t.T_CATEGORY, t.T_COMPANY, t.T_BRANCH,t.T_DEPARTMENT, ta.T_SUBJECT,ta.T_STATUS,ta.T_SUBCATEGORY1,ta.T_SUBCATEGORY2,t.REQUEST_MODE,t.T_REQUESTER,t.T_RAISE_TIME, ta.TP_NAME,ta.T_ASSIGN_TO , ta.ENGINEER_NAME, ta.T_ASSIGN_DATE,tr.RESOLVED_ENGINEER_NAME,tr.T_RESOLVED_TIME,t.T_CLOSEBY,t.T_CLOSEDATE from  ticket t  left join ticket_assigned ta  on t.T_ID=ta.T_ID left join ticket_resolved  tr   on t.T_ID=tr.T_ID   where( ( ta.T_PRIORITY='"+priority+"'AND ta.T_SEVERITY='"+severity+"' AND   ta.ENGINEER_NAME='"+loginuser+"' AND ta.ENGINEER_COMPANY='"+loginUserCompany+"') OR (  ta.ENGINEER_GROUP in ('"+enggGroupList+"')AND 	 ta.T_PRIORITY='"+priority+"' AND ta.T_SEVERITY='"+severity+"') OR (ta.T_PRIORITY='"+priority+"' AND ta.T_SEVERITY='"+severity+"' AND   t.T_REQUESTER='"+loginuser+"' AND t.T_COMPANY='"+loginUserCompany+"')) AND (STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+"','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(t.T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+CurrentTime+"','%d-%m-%Y %H:%i:%s'))").list();


			array = new JSONArray();
			for (Object[] listData : l) {
				array1 = new JSONArray();
			
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				
				array.put(array1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;
	}



	@Override
	public JSONArray getPrioritySeverityServiceListing(String loginuser, String lastmonth,String priority,
			String severity) {
		


		//System.out.println("Inside TPActivityDaoImpl getServiceRequestDashboardData method");
		JSONArray array1 = null;
		JSONArray array = null;
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser = session.getAttribute("username").toString();
			
			
			//System.out.println("LoginScope****" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		
		array= new JSONArray();
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			
			System.out.println("lasttsrfrefe");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select T_ID,PRIORITY,SEVERITY,T_CATEGORY,REQUEST_TYPE,T_SUBJECT,T_COMPANY,T_BRANCH,T_DEPARTMENT,STATUS,T_SUBCAT1,T_SUBCAT2,ASSIGNED_GROUP,T_REQUESTER,TP_ASSIGN_by_NAME,ASSIGN_TO,ASSIGN_ENGG_NAME,T_DATE,REQUEST_ASSIGN_DATE,RESOLVE_DATE ,COMPLETE_DATE, T_CLOSEBY,T_CLOSEDATE,LEVEL_1_TIMESTAMP,LEVEL_1_APPROVER_NAME,LEVEL_2_TIMESTAMP,LEVEL_2_APPROVER_NAME from service_request where ((T_REQUESTER='"+loginuser+"' and T_COMPANY ='"+loginUserCompany+"') OR (ASSIGN_ENGG_NAME='"+loginuser+"' AND ASSIGN_ENGG_COMPANY='"+loginUserCompany+"'  ) OR ASSIGN_ENGG_GROUP in ('"+enggGroupList+"'))and  (STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))  AND PRIORITY='"+priority+"'and SEVERITY='"+severity+"'").list();

		
			for (Object[] listData : l) {

				array1 = new JSONArray();
				//System.out.println(listData[0].toString());

				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
				
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
				if ((listData[26]) == null || (listData[26].toString()).contains("null")
						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[26]);
				}
			
				
				array.put(array1);
			}
			//System.out.println("db_cnamedaf: " + array);
			

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array;

	}




	@Override
	public JSONArray getPrioritySeverityProblemListing(String loginuser, String lastmonth, String priority,
			String severity) {
		//System.out.println("Inside getProblemGroupList getTPDashboardData method");
		JSONArray array1 = null;
		JSONArray array =  new JSONArray();
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****fdtyty" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle excption
		}
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println(" i am in gethchdchdProblemGroupList");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select * from (select t.PT_ID,t.PRIORITY as PRIORITY ,t.SEVERITY as SEVERITY,ta.ENGINEER_GROUP as ENGINEER_GROUP,t.PT_COMPANY as PT_COMPANY, t.PT_BRANCH,t.PT_DEPARTMENT ,t.PT_SUBJECT,t.REQUEST_MODE, t.T_PROBLEM_CATEGORY,t.T_PROBLEM_SUBCAT1, t.T_PROBLEM_SUBCAT2,t.PT_REQUESTER as PT_REQUESTER,t.PT_DATE,ta.TP_NAME, ta.PT_ASSIGN_TO, ta.ENGINEER_NAME as ENGINEER_NAMEss,ta.PT_ENGINEER_COMPANY as ENGINEER_COMPANY,t.PROBLEM_STATUS as PROBLEM_STATUS,ta.PT_ASSIGN_TIME,tr.ENGINEER_NAME,tr.PT_FIXINPROCESS_DATE,tr.PT_RCA_DATE, tr.PT_RESOLVE_DATE,t.PT_CLOSEBY,t.PT_CLOSEDATE from problem_ticket t LEFT JOIN problem_ticket_assigned ta on t.PT_ID=ta.PT_ID  left join problem_ticket_resolved tr on t.PT_ID=tr.PT_ID ) as  inn    where ((PT_REQUESTER='"+loginuser+"' and PT_COMPANY ='"+loginUserCompany+"') OR (ENGINEER_NAMEss='"+loginuser+"' AND ENGINEER_COMPANY='"+loginUserCompany+"'  ) OR ENGINEER_GROUP in ('"+enggGroupList+"')) and  (STR_TO_DATE(PT_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s')) and PRIORITY='"+priority+"'and SEVERITY='"+severity+"'").list();
			
			//array1 =null;
			
			for (Object[] listData : l) {
				
				array1 = new JSONArray();
				
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
			
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
//				if ((listData[26]) == null || (listData[26].toString()).contains("null")
//						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
//						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
//					array1.put("-");
//				} else {
//					array1.put(listData[26]);
//				}
			
				array.put(array1);
				
				
			}
			
			//System.out.println("THIS IS ARRAY   "+array);	
			//System.out.println("THIS IS ARRAY1   "+array1);	
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}

		return array;
	}


	@Override
	public JSONArray getCategoryProblemListing(String loginuser, String lastmonth, String category) {
		//System.out.println("Inside getProblemGroupList getTPDashboardData method");
		System.out.println("Inside getProblemGroupList getTPDashboardData method"+category);
		JSONArray array1 = null;
		JSONArray array =  new JSONArray();
		int statuscount = 0;
		String count = null;
		String LoginScope="";
		String loginUserCompany="";
		String groupName="";
		String enggGroupList="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("LoginScope****fdtyty" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		try {
			///////////////// GET ENGG GROUP DATA ////////////
			List<loginmaster> loginMaster=new ArrayList<loginmaster>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM loginmaster WHERE USERNAME= :USERNAME and COMPANY= :COMPANY and ROLE_TYPE= :ROLE_TYPE");
			q1.setParameter("USERNAME", loginuser);
			q1.setParameter("COMPANY", loginUserCompany);
			q1.setParameter("ROLE_TYPE", "Engineer");
			loginMaster=q1.list();
			for (loginmaster lm : loginMaster) {
				groupName =	lm.getGROUP_NAME();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle excption
		}
		try {
			 DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			 LocalDateTime datetime1 = LocalDateTime.now();  
			 String CurrentTime = localdate.format(datetime1);
			 LocalDateTime minusMonths = datetime1.minusMonths(1);
			 String lastmonthFinal = localdate.format(minusMonths);
//			 System.out.println("current time "+CurrentTime);
			 
//			 System.out.println("lastmonthFinal99"+lastmonthFinal);
			   System.out.println("LAST MONY?H&"+lastmonth);
			    
			 if(lastmonth==null||lastmonth.equals("undefined")||lastmonth.equals("lastmonth"))
			 {
				 System.out.println("INSIDE NULL TRUE");
				 lastmonth=lastmonthFinal; 
				 System.out.println("lastmonth  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastweek"))
			 {
				 LocalDateTime minusWeeks = datetime1.minusWeeks(1);
				 String lastweek = localdate.format(minusWeeks);
				 lastmonth=lastweek;
				 System.out.println("week  ========"+lastmonth);
			 }
			 else if(lastmonth.equals("lastthreemonth"))
			 {
				 LocalDateTime minusthreeMonths = datetime1.minusMonths(3);
				 String lastthreemonth = localdate.format(minusthreeMonths);
				 lastmonth=lastthreemonth;
				 System.out.println("lastthreemonth  ========"+lastmonth);
			 }
		enggGroupList=groupName.replaceAll(",", "','");
		try {
			System.out.println("iamingetProbldddc");
			List<Object[]> l = sessionFactory.getCurrentSession().createSQLQuery("select * from (select t.PT_ID, t.T_PROBLEM_CATEGORY,ta.ENGINEER_GROUP as ENGINEER_GROUP,t.PT_COMPANY , t.PT_BRANCH,t.PT_DEPARTMENT ,t.PT_SUBJECT,t.REQUEST_MODE,t.PRIORITY,t.SEVERITY,t.T_PROBLEM_SUBCAT1, t.T_PROBLEM_SUBCAT2,t.PT_REQUESTER,t.PT_DATE,ta.TP_NAME, ta.PT_ASSIGN_TO, ta.ENGINEER_NAME as s,ta.PT_ENGINEER_COMPANY as ENGINEER_COMPANY,t.PROBLEM_STATUS as PROBLEM_STATUS,ta.PT_ASSIGN_TIME,tr.ENGINEER_NAME,tr.PT_FIXINPROCESS_DATE,tr.PT_RCA_DATE, tr.PT_RESOLVE_DATE,t.PT_CLOSEBY,t.PT_CLOSEDATE from problem_ticket t LEFT JOIN problem_ticket_assigned ta on t.PT_ID=ta.PT_ID  left join problem_ticket_resolved tr on t.PT_ID=tr.PT_ID ) as  inn   where ((s='"+loginuser+"' and ENGINEER_COMPANY='"+loginUserCompany+"') or ENGINEER_GROUP in('"+enggGroupList+"') )and  (STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + lastmonth	+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(PT_ASSIGN_TIME,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ CurrentTime + "','%d-%m-%Y %H:%i:%s'))     and T_PROBLEM_CATEGORY='"+ category +"'").list();
			
			//array1 =null;
			
			for (Object[] listData : l) {
				
				array1 = new JSONArray();
				
				if ((listData[0]) == null || (listData[0].toString()).contains("null")
						|| (listData[0].toString()).equalsIgnoreCase("null") || (listData[0]) == " "
						|| (listData[0]) == "" || (listData[0]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[0]);
				}
				if ((listData[1]) == null || (listData[1].toString()).contains("null")
						|| (listData[1].toString()).equalsIgnoreCase("null") || (listData[1]) == " "
						|| (listData[1]) == "" || (listData[1]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[1]);
				}
				
				
				
				if ((listData[2]) == null || (listData[2].toString()).contains("null")
						|| (listData[2].toString()).equalsIgnoreCase("null") || (listData[2]) == " "
						|| (listData[2]) == "" || (listData[2]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[2]);
				}
				if ((listData[3]) == null || (listData[3].toString()).contains("null")
						|| (listData[3].toString()).equalsIgnoreCase("null") || (listData[3]) == " "
						|| (listData[3]) == "" || (listData[3]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[3]);
				}
				if ((listData[4]) == null || (listData[4].toString()).contains("null")
						|| (listData[4].toString()).equalsIgnoreCase("null") || (listData[4]) == " "
						|| (listData[4]) == "" || (listData[4]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[4]);
				}
				
				if ((listData[5]) == null || (listData[5].toString()).contains("null")
						|| (listData[5].toString()).equalsIgnoreCase("null") || (listData[5]) == " "
						|| (listData[5]) == "" || (listData[5]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[5]);
				}
				if ((listData[6]) == null || (listData[6].toString()).contains("null")
						|| (listData[6].toString()).equalsIgnoreCase("null") || (listData[6]) == " "
						|| (listData[6]) == "" || (listData[6]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[6]);
				}
				if ((listData[7]) == null || (listData[7].toString()).contains("null")
						|| (listData[7].toString()).equalsIgnoreCase("null") || (listData[7]) == " "
						|| (listData[7]) == "" || (listData[7]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[7]);
				}
				if ((listData[8]) == null || (listData[8].toString()).contains("null")
						|| (listData[8].toString()).equalsIgnoreCase("null") || (listData[8]) == " "
						|| (listData[8]) == "" || (listData[8]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[8]);
				}
				if ((listData[9]) == null || (listData[9].toString()).contains("null")
						|| (listData[9].toString()).equalsIgnoreCase("null") || (listData[9]) == " "
						|| (listData[9]) == "" || (listData[9]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[9]);
				}
				if ((listData[10]) == null || (listData[10].toString()).contains("null")
						|| (listData[10].toString()).equalsIgnoreCase("null") || (listData[10]) == " "
						|| (listData[10]) == "" || (listData[10]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[10]);
				}
				if ((listData[11]) == null || (listData[11].toString()).contains("null")
						|| (listData[11].toString()).equalsIgnoreCase("null") || (listData[11]) == " "
						|| (listData[11]) == "" || (listData[11]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[11]);
				}
				if ((listData[12]) == null || (listData[12].toString()).contains("null")
						|| (listData[12].toString()).equalsIgnoreCase("null") || (listData[12]) == " "
						|| (listData[12]) == "" || (listData[12]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[12]);
				}
				if ((listData[13]) == null || (listData[13].toString()).contains("null")
						|| (listData[13].toString()).equalsIgnoreCase("null") || (listData[13]) == " "
						|| (listData[13]) == "" || (listData[13]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[13]);
				}
			
				if ((listData[14]) == null || (listData[14].toString()).contains("null")
						|| (listData[14].toString()).equalsIgnoreCase("null") || (listData[14]) == " "
						|| (listData[14]) == "" || (listData[14]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[14]);
				}
				if ((listData[15]) == null || (listData[15].toString()).contains("null")
						|| (listData[15].toString()).equalsIgnoreCase("null") || (listData[15]) == " "
						|| (listData[15]) == "" || (listData[15]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[15]);
				}
				if ((listData[16]) == null || (listData[16].toString()).contains("null")
						|| (listData[16].toString()).equalsIgnoreCase("null") || (listData[16]) == " "
						|| (listData[16]) == "" || (listData[16]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[16]);
				}
				if ((listData[17]) == null || (listData[17].toString()).contains("null")
						|| (listData[17].toString()).equalsIgnoreCase("null") || (listData[17]) == " "
						|| (listData[17]) == "" || (listData[17]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[17]);
				}
				if ((listData[18]) == null || (listData[18].toString()).contains("null")
						|| (listData[18].toString()).equalsIgnoreCase("null") || (listData[18]) == " "
						|| (listData[18]) == "" || (listData[18]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[18]);
				}
				if ((listData[19]) == null || (listData[19].toString()).contains("null")
						|| (listData[19].toString()).equalsIgnoreCase("null") || (listData[19]) == " "
						|| (listData[19]) == "" || (listData[19]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[19]);
				}
				if ((listData[20]) == null || (listData[20].toString()).contains("null")
						|| (listData[20].toString()).equalsIgnoreCase("null") || (listData[20]) == " "
						|| (listData[20]) == "" || (listData[20]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[20]);
				}
				if ((listData[21]) == null || (listData[21].toString()).contains("null")
						|| (listData[21].toString()).equalsIgnoreCase("null") || (listData[21]) == " "
						|| (listData[21]) == "" || (listData[21]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[21]);
				}
				if ((listData[22]) == null || (listData[22].toString()).contains("null")
						|| (listData[22].toString()).equalsIgnoreCase("null") || (listData[22]) == " "
						|| (listData[22]) == "" || (listData[22]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[22]);
				}
				if ((listData[23]) == null || (listData[23].toString()).contains("null")
						|| (listData[23].toString()).equalsIgnoreCase("null") || (listData[23]) == " "
						|| (listData[23]) == "" || (listData[23]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[23]);
				}
				if ((listData[24]) == null || (listData[24].toString()).contains("null")
						|| (listData[24].toString()).equalsIgnoreCase("null") || (listData[24]) == " "
						|| (listData[24]) == "" || (listData[24]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[24]);
				}
				if ((listData[25]) == null || (listData[25].toString()).contains("null")
						|| (listData[25].toString()).equalsIgnoreCase("null") || (listData[25]) == " "
						|| (listData[25]) == "" || (listData[25]).toString().equalsIgnoreCase("NA")) {
					array1.put("-");
				} else {
					array1.put(listData[25]);
				}
//				if ((listData[26]) == null || (listData[26].toString()).contains("null")
//						|| (listData[26].toString()).equalsIgnoreCase("null") || (listData[26]) == " "
//						|| (listData[26]) == "" || (listData[26]).toString().equalsIgnoreCase("NA")) {
//					array1.put("-");
//				} else {
//					array1.put(listData[26]);
//				}
			
				array.put(array1);
				
				
			}
			
			//System.out.println("THIS IS ARRAY   "+array);	
			//System.out.println("THIS IS ARRAY1   "+array1);	
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("EXCEPTION INNNNN");
			//System.out.println(e);
		}

		return array;
	}

	
	// Engineer Report
	
	@Override
	public JSONArray GetEnggWiseReportSuccess(String FromDate, String ToDate) {
		String finalvalue = "";
		String finnalvaluegroup = "";
		String OR = "OR";
		int count = 0;
		int engname2lenth = 0;
		int id = 0;
		Query reportquery = null;
		String LoginScope = "",loginUserCompany="",loginuser="",groupname="";
		JSONArray array1 = new JSONArray();
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginScope = session.getAttribute("loginscope").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			loginuser=session.getAttribute("username").toString();
			groupname=session.getAttribute("GROUP").toString();
			
			//System.out.println("LoginScope****fdtyty" + LoginScope);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		
		System.out.println("daoimpl value FromDate " + FromDate);
		System.out.println("daoimpl value ToDate " + ToDate);
		String replaceAll = groupname.replaceAll(",", "','");
		System.out.println("@@@@@@@@@@@@@@@@@@@"+replaceAll);
		System.out.println("LoginScope value " + LoginScope);
		System.out.println("Enginnneerrrrrrr Report query ........");
		try {
			reportquery = sessionFactory.getCurrentSession().createSQLQuery(
					"select * from (Select TA.T_ID ,TA.T_USER_NAME as T_USER_NAME,COALESCE( TA.T_USER_FULLNAME,'-'), TA.T_COMPANY as T_COMPANY ,TA.T_ASSIGN_DATE as T_ASSIGN_DATE, TA.T_STATUS as T_STATUS ,TA.T_PRIORITY,TA.T_SEVERITY,TA.T_CATEGORY,TA.T_SUBCATEGORY1,TA.T_SUBCATEGORY2,TA.T_BRANCH as T_BRANCH,TA.T_DEPARTMENT as T_DEPARTMENT,TA.T_SUBJECT,COALESCE(TA.T_ASSIGN_TO ,'-'), COALESCE(TA.TP_NAME ,'-') as TP_NAME ,COALESCE(TA.TP_FULLNAME ,'-'),COALESCE (TA.TP_COMPANY ,'-')as TP_COMPANY,COALESCE (TA.T_ASSIGN_DATE ,'-'),COALESCE(TA.ENGINEER_NAME,'-') as ENGINEER_NAME, COALESCE(TA.ENGINEER_COMPANY,'-') as ENGINEER_COMPANY,TA.T_CLOSEDATE as T_CLOSEDATE,\r\n"
							+ "COALESCE(TA.ENGINEER_GROUP,'-') as GROUP_NAME,COALESCE( TR.RESOLVED_ENGINEER_NAME,'-') as RESOLVED_ENGINEER_NAME,COALESCE(TR.RESOLVED_ENGINEER_FULLNAME,'-'),COALESCE(TR.RESOLVED_ENGINEER_COMPANY ,'-') as  RESOLVED_ENGINEER_COMPANY, COALESCE(TR.T_RESOLVED_TIME,'-') "							
							+ "from Ticket_ASSIGNED TA  LEFT JOIN TICKET_RESOLVED TR ON TA.T_ID =TR.T_ID ) as main where ("+LoginScope+" and ( GROUP_NAME in('"+groupname+"') or ENGINEER_NAME='"+loginuser+"' )) and  ("
							+  "STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + FromDate
							+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_ASSIGN_DATE,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ ToDate
							+ "','%d-%m-%Y %H:%i:%s')) ORDER BY  STR_TO_DATE(T_ASSIGN_DATE ,'%d-%m-%Y %H:%i:%s') DESC");
			
			
//	First Query		
//			"select * from (Select Ticket.T_ID ,Ticket.RAISED_BY_USERNAME as  RAISED_BY_USERNAME,COALESCE( Ticket.RAISED_BY_FULLNAME,'-') ,Ticket.RAISED_BY_COMPANY as RAISED_BY_COMPANY ,Ticket.T_RAISE_TIME as T_RAISE_TIME ,Ticket.T_REQUESTER as T_REQUESTER ,COALESCE(Ticket.T_REQUESTER_FULLNAME,'-'),Ticket.T_COMPANY as T_COMPANYFIRST,Ticket.STATUS as STATUS,Ticket.PRIORITY,Ticket.SEVERITY,Ticket.T_CATEGORY,Ticket.T_SUBCAT1,Ticket.T_SUBCAT2,Ticket.T_COMPANY,Ticket.T_BRANCH ,Ticket.T_DEPARTMENT,Ticket.REQUEST_MODE ,Ticket.T_SUBJECT,COALESCE(TA.T_ASSIGN_TO ,'-'), COALESCE(TA.TP_NAME ,'-') as TP_NAME ,  COALESCE(TA.TP_FULLNAME ,'-'),COALESCE (TA.TP_COMPANY ,'-')as TP_COMPANY ,COALESCE (TA.T_ASSIGN_DATE ,'-'),COALESCE(TA.ENGINEER_NAME,'-') as ENGINEER_NAME ,COALESCE(TA.ENGINEER_NAME,'-'), COALESCE(TA.ENGINEER_COMPANY,'-' ) as ENGINEER_COMPANY ,\r\n"
//			+ "COALESCE(TA.ENGINEER_GROUP,'-') ,COALESCE( TR.RESOLVED_ENGINEER_NAME,'-') as RESOLVED_ENGINEER_NAME,COALESCE(TR.RESOLVED_ENGINEER_FULLNAME,'-'),COALESCE(TR.RESOLVED_ENGINEER_COMPANY ,'-') as  RESOLVED_ENGINEER_COMPANY, COALESCE(TR.T_RESOLVED_TIME,'-') ,COALESCE(Ticket.T_CLOSEBY ,'-') as T_CLOSEBY\r\n"
//			+ ",COALESCE(Ticket.T_CLOSEBY_FULLNAME,'-') ,COALESCE(Ticket.T_CLOSEBY_COMPANY,'-')  as T_CLOSEBY_COMPANY\r\n"
//			+ ", COALESCE(Ticket.T_CLOSEDATE,'-')  from Ticket LEFT JOIN  Ticket_ASSIGNED TA ON Ticket.T_ID=TA.T_ID  LEFT JOIN TICKET_RESOLVED TR ON TA.T_ID =TR.T_ID ) main where  ("
//			+ finalvalue + ") OR  (" + finnalvaluegroup + ") AND (STR_TO_DATE(T_RAISE_TIME,'%d-%m-%Y %H:%i:%s')>=STR_TO_DATE('" + FromDate
//			+ "','%d-%m-%Y %H:%i:%s') and  STR_TO_DATE(T_RAISE_TIME,'%d-%m-%Y %H:%i:%s')<= STR_TO_DATE('"+ ToDate
//			+ "','%d-%m-%Y %H:%i:%s')) ORDER BY  STR_TO_DATE(T_RAISE_TIME ,'%d-%m-%Y %H:%i:%s') DESC");

			reportquery.list();
			JSONArray array = null;
			array1 = new JSONArray();
			List<Object[]> reportquery2 = reportquery.list();
			for (Object[] listData : reportquery2) {

				id = id + 1;
				array = new JSONArray();
//				id = id + 1;
//				array = new JSONArray();

				array.put(id);
				array.put(listData[0].toString());
				array.put(listData[1].toString());
				array.put(listData[2].toString());
				array.put(listData[3].toString());
				array.put(listData[4].toString());
				// array.put(UserDept);
				array.put(listData[5].toString());
				array.put(listData[6].toString());
				array.put(listData[7].toString());
				array.put(listData[8].toString());
				array.put(listData[9].toString());
				array.put(listData[10].toString());
				array.put(listData[11].toString());
				array.put(listData[12].toString());
				array.put(listData[13].toString());
				array.put(listData[14].toString());
				array.put(listData[15]);
				array.put(listData[16]);
				array.put(listData[17]);
				array.put(listData[18]);
				array.put(listData[19]);
				array.put(listData[20]);
				if (listData[21] == null) {
					array.put("-");
				} else {
					array.put(listData[21]);
				}
				array.put(listData[22]);
				array.put(listData[23]);
				if (listData[24].toString().equals("NA")) {
					array.put("-");
				} else {
					array.put(listData[24]);
				}
				if (listData[25] == null || listData[25].equals("NA")) {
					array.put("-");
				} else {
					array.put(listData[25]);
				}
				array.put(listData[26]);
				System.out.println("array 26 " + listData[26].toString());

				array1.put(array);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}

}
