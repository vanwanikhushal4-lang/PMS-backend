package com.velox.itsm.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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

import com.google.gson.FieldNamingStrategy;
import com.velox.itsm.model.BUSINESS_ID_REQUEST;
import com.velox.itsm.model.EFORM_ACTIVITY_LOG;
import com.velox.itsm.model.EFORM_BUSINESS_REQUEST_ACTIVITYLOG;
import com.velox.itsm.model.EFORM_BUSINESS_REQUEST_TRACKING;
import com.velox.itsm.model.EFORM_REQUEST_TRACKING;
import com.velox.itsm.model.SMTP_REQUEST;
import com.velox.itsm.model.SMTP_REQUEST_ACTIVITYLOG;
import com.velox.itsm.model.SMTP_REQUEST_TRACKING;
import com.velox.itsm.model.SOFTWARE;
import com.velox.itsm.model.SOFTWARE_CHARGES_DETAILS;
import com.velox.itsm.model.SOFTWARE_RELEASE;
import com.velox.itsm.model.SOFTWARE_REQUEST;
import com.velox.itsm.model.SOFTWARE_TRANSFER;
import com.velox.itsm.model.USER_SOFTWARE_MAP;
import com.velox.itsm.model.companynames;
import com.velox.itsm.model.loginmaster;
import com.velox.itsm.model.selfhelpmaster;
import com.velox.itsm.model.service_request_activity_log;
import com.velox.itsm.model.service_request_tracking;
import com.velox.itsm.model.ticket;
import com.velox.itsm.model.ticket_activity_log;
import com.velox.itsm.model.ticket_tag_master;
import com.velox.itsm.model.ticket_tracking;

import oracle.net.aso.c;

@Repository("EFormDao")

@Transactional
public class EFormDaoImpl implements EFormDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	EmailSMSDao Inv;
//	@Autowired
//	@Qualifier("sessionFactoryITAsset")
//	SessionFactory sessionFactoryITAsset;
	@Autowired
	Environment environment;

//	@Autowired
//	@Qualifier("sessionFactoryPROJECLAIMS")
//	SessionFactory sessionFactoryPROJECLAIMS;

	@Override
	public JSONArray getPID() {
//		 System.out.println("Inside adddetailsListing method DAO getPID");
//		JSONArray array = null;
////
//		JSONArray array1 = null;
//		String loginuser="";
//		String loginuser1=null;
//		
////		
//		DateFormat dateFormat = null;
//		dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//		Date date = null;
//		date = new Date();
//		//////System.out.println(dateFormat.format(date));
//		String currenttime = dateFormat.format(date);
//
//		try {
//			
//			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//					.getRequestAttributes();
//			HttpSession session = requestAttributes.getRequest().getSession();
//			loginuser = session.getAttribute("username").toString();
//			
//		//System.out.println("thisi s query location");
//			Query dataList = sessionFactoryPROJECLAIMS.getCurrentSession().createSQLQuery("select distinct ORDERNO from PROJ_RES_ECLAIMS_VIEW where EMPLOYEEID='"+loginuser+"' and  TO_DATE >='"+currenttime+"'");
//			List <Object> list= dataList.list();	
//			array1 = new JSONArray();
//			for (Object sourceDrive : list) {
//				array = new JSONArray();
//				array.put(sourceDrive);
//				array1.put(array);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//System.out.println("array1 of the ;ist is "+array1);
		return null;//array1;

	}

	@Override
	public JSONArray ApprovalGroup(String pid) {
		// System.out.println("Inside adddetailsListing method DAO fghghghghhg");
//		JSONArray array = null;
//
//		JSONArray array1 = null;
//			String loginuser="";
//			DateFormat dateFormat = null;
//			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			Date date = null;
//			String company="";
//			date = new Date();
//			//////System.out.println(dateFormat.format(date));
//			String currenttime = dateFormat.format(date);
//			try {
//
//					
//					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//							.getRequestAttributes();
//					HttpSession session = requestAttributes.getRequest().getSession();
//					loginuser = session.getAttribute("username").toString();
//					company=session.getAttribute("companyname").toString();
//					
//					array1 = new JSONArray();
//					System.out.println("sd!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				Query dataList = sessionFactoryPROJECLAIMS.getCurrentSession().createSQLQuery("select "
//						+ "distinct EMPLOYEEID  from PROJ_RES_ECLAIMS_VIEW where ORDERNO='"+pid+"' and ACCESSROLE='Editor' and EMPLOYEEID !='"+loginuser+"'");
//			
//				List <Object> list= dataList.list();
//				//System.out.println("dfgfgfgfgfgfg adata list======="+dataList.list());
//				for(Object str1:list)
//				{
//					array = new JSONArray();
//					//System.out.println("kaaam dsdd "+str1.toString());
////					if(str1!=null || dtr1)
//					
//					if(str1.equals(loginuser))
//					{
////						//System.out.println("kaaam "+str1.toString());
//						Query getId=sessionFactory.getCurrentSession().createSQLQuery("select REPORTING_TO_MANAGER from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
//						
//						List<Object> listOfEngg=getId.list();
//						if(!(listOfEngg==null)&&!listOfEngg.get(0).equals("NA"))
//						{
////							//System.out.println("fgfgggsfgfggfdgf dfghfg"+listOfEngg.toString());
//						for(Object names:listOfEngg)
//						{
//							String manager = names.toString();
//							String substring = manager.substring(3, manager.indexOf("OU")-1);
//							Query fullname = sessionFactory.getCurrentSession().createSQLQuery("select  USERNAME  from loginmaster where FULL_NAME='"+substring+"'");
//							List <Object> listoffullname= fullname.list();
//														String finalname="";
//							String str=substring.toString();
//								for (Object obj : listoffullname) {
//									finalname = obj.toString();
//									finalname = finalname.concat("~"+str );
//								}					
//							array.put(finalname);							
//							array1.put(array);
//						}
//						}
////						else if()
//						else
//						{
//							Query fullname = sessionFactory.getCurrentSession().createSQLQuery("select  COALESCE(FULL_NAME,'NA')  from loginmaster where USERNAME='"+str1+"'");
//							List <Object> listoffullname= fullname.list();	
//							String str=str1.toString();
//							if (!listoffullname.isEmpty()) {
//								
//								for (Object obj : listoffullname) {
//							
//									str = str.concat("~" + obj);
//									
//								}
//							}
//							else
//							{
//								continue;
////								str=str.concat("~" +"NA");
//							}
//							array.put(str);
//							array1.put(array);
//						}
//					
//						}
//					else
//						{
////							//System.out.println("FGHHJFGHFGHGH DGHGHGFH GH ");
//							Query fullname = sessionFactory.getCurrentSession().createSQLQuery("select  COALESCE(FULL_NAME,'NA')  from loginmaster where USERNAME='"+str1+"' ");
//							List <Object> listoffullname= fullname.list();	
//							String str=str1.toString();
//							if (!listoffullname.isEmpty()) {
//								for (Object obj : listoffullname) {
////									int 	count=0;	
////									if(obj.toString().equals("NA"))
////									{
////										//System.out.println("this iss continue"+count++);
////										continue;
////									}
////									else
////									{
//									str = str.concat("~" + obj);
////									}
//								}
//							}
//							else
//							{
//								str=str.concat("~" +"NA");
//							}
//							array.put(str);
//							array1.put(array);
//							
//						}
//					}
//
//					
//				
//			
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				
//			}
		//// System.out.println("array1 of the ;ist is "+array1);
		return null;//array1;

	}

	@Override
	public JSONArray getUserSelectedDetails(String approvalname) {
		// System.out.println("Inside getUserSelectedDetails method DAO fghghghghhg");

		JSONArray array1 = null;
		String loginuser = "";
		try {

			Query dataList = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + approvalname + "'");
			List<loginmaster> list = dataList.list();

			array1 = new JSONArray();
			for (loginmaster sourceDrive : list) {
				JSONObject array = new JSONObject();
				array.put("COMPANY", sourceDrive.getCOMPANY());
				array.put("BRANCH", sourceDrive.getBRANCH());
				array.put("DEPARTMENT", sourceDrive.getDEPARTMENT());
				array.put("FULLNAME", sourceDrive.getFULL_NAME());
				array.put("EMAIL", sourceDrive.getEMAIL());
				array.put("ROLL_TYPE", sourceDrive.getROLE_TYPE());
//				//System.out.println("arra ia1 is "+array1);
				array1.put(array);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
////System.out.println("array1 of the ;ist is "+array1);
		return array1;
	}

	@Override
	public JSONArray getProejctDetails(String pid) {
//System.out.println("inside getAssetFromOfLoginUser daoImpl");

		JSONArray array1 = null;
		JSONArray array = null;

		try {

//			Query getasset = sessionFactoryITAsset.getCurrentSession()
//					.createSQLQuery("select ASSET_NAME from hw_asset where PID ='" + pid + "' group by ASSIGNED_ID");
//			List<Object> list = getasset.list();
//			array1 = new JSONArray();
//			for (Object sourceDrive : list) {
//
//				array = new JSONArray();
//				array.put(sourceDrive);
//
//				array1.put(array);
//			}
////			"select ASSET_NAME,ASSET_TAG,ASSET_STATUS,ASSET_TYPE,CATEGORY,SUB_CATEGORY from hw_asset where PID ='" + pid+ "' group by ASSIGNED_ID");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray getProjectDetailsById(String pid) {
//System.out.println("inside getAssetFromOfLoginUser daoImpl");

		JSONArray array1 = null;

		try {

//			Query getasset = sessionFactoryITAsset.getCurrentSession().createSQLQuery(
//					"select ASSET_NAME,ASSET_TAG,ASSET_STATUS,ASSET_TYPE,CATEGORY,SUB_CATEGORY from hw_asset where ASSET_NAME ='"
//							+ pid + "' group by ASSET_NAME");
//			List<Object[]> list = getasset.list();
//			array1 = new JSONArray();
//			for (Object[] sourceDrive : list) {
//
//				JSONObject array = new JSONObject();
//				array.put("assetnames", sourceDrive[0]);
//				array.put("assettag", sourceDrive[1]);
//				array.put("assetstatus", sourceDrive[2]);
//				array.put("assettype", sourceDrive[3]);
//				array.put("category", sourceDrive[4]);
//				array.put("subcategory", sourceDrive[5]);
//				array1.put(array);
//			}
//			"select ASSET_NAME,ASSET_TAG,ASSET_STATUS,ASSET_TYPE,CATEGORY,SUB_CATEGORY from hw_asset where PID ='" + pid+ "' group by ASSIGNED_ID");

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public JSONArray getItGroupUser() {

//System.out.println("inside getAssetFromOfLoginUser daoImpl");

		JSONArray array1 = null;
		JSONArray array = null;
		try {

			Query getasset = sessionFactory.getCurrentSession().createSQLQuery(
					"select USERNAME,FULL_NAME from loginmaster where GROUP_NAME ='IT Compliance' group by USERNAME");
			List<Object[]> list = getasset.list();
			array1 = new JSONArray();
			for (Object[] sourceDrive : list) {

				array = new JSONArray();
				array.put(sourceDrive[0] + "~" + sourceDrive[1]);

				array1.put(array);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;

	}

	@Override
	public String insertSoftwareRequest(String fullname, String compname, String site, String department, String phone,
			String emailid, MultipartFile empPic, String pid, String softwarename, String cost, String description,
			String approvalname, String rperiod, Boolean assetCheck, String asset_Ipaddress, String aname, String atag,
			String astatus, String acategory, String asset_sub_category, String typecategory, String assetname_cr,
			String ip_cr, String status_cr, String ipaddress_cr, String ownername_cr, String ServerhostOrCOde) {
		int id = 0;
		String status = "";
		String ticketTag = "";
		String NewTicketID = "";
		String[] split = approvalname.split("~");
		String appovalname = split[0];
		String approval_fullname = split[1];
		System.out.println("hnghngh"+appovalname);
		System.out.println("hnghngefrvdvdh"+approval_fullname);
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(SOFTWARE_REQUEST.class)
					.setProjection(Projections.max("SRNO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			//// System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//// System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//// System.out.println("IN ELSE SRNO IS: " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		String localDateNow = localdate.format(now);
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String statusOFTicket = "Pending For Managers Approval";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			String string = session.getAttribute("GROUP").toString();
//			//System.out.println("group namme is dfdfed "+string);
			Date currentdate = dateFormat.parse(currenttime);

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

				String fileName = empPic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
//	            File uploadedFile =  empPic;
//				File uploadedFile = new File(empPic.getOriginalFilename());
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();

//				String fileName = empPic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);


				// File destFile = new File(imagefilePath + File.separator + fileName);
//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);

				updatedFileName = createnewfilename + "." + ext;


//				try {
//
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//// System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			//////////////////////////////// UPDATE LOGINMASSTER PHONE NUMBER////////////
			int updatephone = sessionFactory.getCurrentSession()
					.createQuery("update loginmaster set PHONE='" + phone + "' where USERNAME='" + loginuser + "'")
					.executeUpdate();

			List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery(
					"from ticket_tag_master where COMPANY='" + compname + "' and DEPARTMENT='" + department + "'")
					.list();
			for (ticket_tag_master sourceDrive : tagList) {
				ticketTag = sourceDrive.getTICKET_TAG();
			}
			NewTicketID = ticketTag + "EF-" + id;
			SOFTWARE_REQUEST sr = new SOFTWARE_REQUEST();
			sr.setT_ID(NewTicketID);
			sr.setT_REQUESTER(loginuser);
			sr.setT_REQUESTER_FULLNAME(fullname);
			sr.setRAISED_DATE(currenttime);
			sr.setSRNO(id);
			sr.setT_COMPANY(compname);
			sr.setT_BRANCH(site);
			sr.setT_DEPARTMENT(department);
			sr.setEMAIL_ID(emailid);
			sr.setT_PHONE(phone);
			sr.setP_ID(pid);
			sr.setS_PERIOD(rperiod);
			sr.setS_COST(cost);
			sr.setS_NAME(softwarename);

			sr.setAPPROVAR_NAME(appovalname);
			sr.setAPPROVAR_NAME_FULLNAME(approval_fullname);

			String assrtCheck = String.valueOf(assetCheck);
			sr.setASSETCHECK(assrtCheck);
			sr.setASSET_NAME(aname);
			sr.setASSET_TAG(atag);
			sr.setCATEGORY(acategory);
			sr.setSUB_CATEGORY(asset_sub_category);
			sr.setIP_ADDRESS(asset_Ipaddress);
			sr.setASSET_STATUS(astatus);
			sr.setT_DESC(description);
			sr.setSTATUS(statusOFTicket);
			sr.setPRIORITY("P5");
			sr.setSEVERITY("Information");
			sr.setCATEGORY_REQUEST(typecategory);
			if (typecategory.equals("Server")) {
				sr.setSERVER_IP_ADDRESS(ipaddress_cr);
				sr.setASSET_NAME_CR("NA");
				sr.setLAPTOP_IP_CR("NA");
				sr.setASSET_STATUS_CR("NA");
				sr.setOWNER_NAME_CR(ownername_cr);
				sr.setSERVER_IP_CR(ip_cr);
//					sr.
				sr.setSERVER_HOSTORCODE(ServerhostOrCOde);
			} else if (typecategory.equals("Desktop") || typecategory.equals("Laptop")) {
				sr.setASSET_NAME_CR(assetname_cr);
				sr.setLAPTOP_IP_CR(ip_cr);
				sr.setASSET_STATUS_CR(status_cr);
				sr.setOWNER_NAME_CR("NA");
				sr.setSERVER_IP_CR("NA");
			}
			if (updatedFileName == null) {
				sr.setATTACH_NAME("No File Available");
			} else {
				sr.setATTACH_NAME(updatedFileName);
			}
//				//System.out.println("sfgfgfdggfdgd gf g"+updatedFileName);
			sessionFactory.getCurrentSession().persist(sr);
			status = "success";

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
//		String loginMasterData = getLoginMasterData();

		String msg = null;
//		System.out.println("dfgdfgdgdgdf");
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + statusOFTicket
				+ "</td></tr>" + "<tr><td>Raised By:</td><td>" + loginuser + "  [" + fullname + "]</td></tr>"
				+ "</td></tr>" + "<tr><td>Send To:</td><td>" + appovalname + "  [" + approval_fullname + "]</td></tr>" ;
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(NewTicketID);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);
//		tickettrack.setCATEGORY(category);
//		tickettrack.setSUBCATEGORY1(subCat1);
//		tickettrack.setSUBCATEGORY2(subCat2);
//		tickettrack.setSUBJECT(subject);
		tickettrack.setSTATUS(statusOFTicket);
		tickettrack.setPRIORITY("P5");
		tickettrack.setTICKET_TYPE("Software Request");

		tickettrack.setSEVERITY("Information");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(loginuser);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(compname);
		tickettrack.setTICKET_RAISED_BY_COMPANY(compname);

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(NewTicketID);
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSTATUS(statusOFTicket);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
//		ticketActivityLog.setT_SUBJECT(subject);
			ticketActivityLog.setT_DESC(description);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(description);
//		ticketActivityLog.setT_CATEGORY(category);
//		ticketActivityLog.setT_SUB_CATEGORY1(subCat1);
			ticketActivityLog.setTICKET_TYPE("Software Request");
			ticketActivityLog.setSEVERITY("Information");
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String ticketStatus="New";
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(NewTicketID, ticketStatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "," + NewTicketID;
	}

	@Override
	public JSONArray getPendingSoftwareReqauest() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='IT Compliance' and STATUS='Approved By Manager' or  STATUS='Hold'  ORDER BY STR_TO_DATE(APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;
	}

	@Override
	public JSONArray gatherSoftwareDetails(String id) {

		//// System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");
//		String db_cname = null;
//		JSONArray array = null;

		JSONArray array1 = null;

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}

		try {
			List<SOFTWARE_REQUEST> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_REQUEST where T_ID='" + id + "'").list();

			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();

			array1 = new JSONArray();

			for (SOFTWARE_REQUEST ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {

					JSONObject arrayobj = new JSONObject();

//					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
//					arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
//					arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
//					arrayobj.put("T_DEPARTMENT", ticketDrive.getT_DEPARTMENT());
//					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
//					arrayobj.put("T_MAIL", ticketDrive.getT_MAIL());
//					arrayobj.put("VIP_LOGIN", ticketDrive.getVIP_TICKET());
//					
//					arrayobj.put("T_CATEGORY", ticketDrive.getT_CATEGORY());
//					arrayobj.put("T_SUBCAT1", ticketDrive.getT_SUBCAT1());
//					arrayobj.put("T_SUBCAT2", ticketDrive.getT_SUBCAT2());
//					arrayobj.put("T_SUBJECT", ticketDrive.getT_SUBJECT());
//					arrayobj.put("T_DATE", ticketDrive.getT_RAISE_TIME());
//					arrayobj.put("STATUS", ticketDrive.getSTATUS());
//					arrayobj.put("T_ID", ticketDrive.getT_ID());
//					arrayobj.put("T_DESC", ticketDrive.getT_DESC());
//					arrayobj.put("PRIORITY", ticketDrive.getPRIORITY());
//					arrayobj.put("SEVERITY", ticketDrive.getSEVERITY());
//					arrayobj.put("REQUEST_MODE", ticketDrive.getREQUEST_MODE());
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME", ticketDrive.getT_REQUESTER_FULLNAME());
					arrayobj.put("COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", ticketDrive.getT_DEPARTMENT());
					arrayobj.put("EMAIL", ticketDrive.getEMAIL_ID());
					arrayobj.put("PID", ticketDrive.getP_ID());
					arrayobj.put("T_ID", ticketDrive.getT_ID());
					arrayobj.put("DESC", ticketDrive.getT_DESC());
					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("STATUS", ticketDrive.getSTATUS());
					arrayobj.put("RCAT", ticketDrive.getCATEGORY_REQUEST());
					arrayobj.put("LICENSEKEY", ticketDrive.getLISENCE_KEY());
					arrayobj.put("SNAME", ticketDrive.getS_NAME());
					arrayobj.put("COST", ticketDrive.getS_COST());
					arrayobj.put("RPERIOD", ticketDrive.getS_PERIOD());
					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());
					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());

					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER()
									+ "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster t_requesrterdetailsnew : t_requesrterdetails) {

						arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());

					}

					array1.put(arrayobj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}

	@Override
	public JSONArray GetSoftwareDetails(String sname) {
		JSONArray array = null;
		JSONArray array1 = null;
		JSONObject arrayobj = null;
		float Cost = 0;
		String Costs=null;
		// System.out.println("inside GetSoftwareDetails");

		try {
			array1 = new JSONArray();
			if (!sname.contains("->")) {
				// System.out.println("inside ->"+sname);
				Query getDetls = sessionFactory.getCurrentSession()
						.createQuery("from SOFTWARE where S_NAME=:S_NAME and ACTIVE_CONDITION='TRUE'");
				getDetls.setParameter("S_NAME", sname);
				List<SOFTWARE> list = getDetls.list();
				for (SOFTWARE req : list) {
					arrayobj = new JSONObject();
					Cost = req.getS_COST();
					if (Cost != 0) {
						Cost = Cost / 12;
						Costs= new DecimalFormat("##.##").format(Cost);
						if(!Costs.contains(".")) {
							Costs=Costs+".00";
						}
						
					} else {
						Costs= new DecimalFormat("##.##").format(Cost);
						Costs = Costs;
					}
					arrayobj.put("COST", Costs);
					arrayobj.put("PERIOD", req.getS_PERIOD());
					array1.put(arrayobj);
				}
			} else {
				// System.out.println("hi this is else bloack");
				List<USER_SOFTWARE_MAP> getSoftDetls = sessionFactory.getCurrentSession()
						.createQuery("from USER_SOFTWARE_MAP where PRODUCT_NAME='" + sname + "'").list();
//				List<Object[]> list = ;
				for (USER_SOFTWARE_MAP listOfdetls : getSoftDetls) {
					arrayobj = new JSONObject();
					arrayobj.put("COST", listOfdetls.getAPPLIED_DATE());
					arrayobj.put("PERIOD", listOfdetls.getASSET_CODE());
					array1.put(arrayobj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	@Override
	public String InsertRequestApprovedByItCompliance(String appByITCompName, String Status, String approvenote,
			String requestcategory, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String CompanyRaisedBy, String RaisedByName, String tid, String licensekey) {

		int id = 0;

		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();

			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		//System.out.println("HIIII"+requestcategory);
		try

		{
			Query createQuery = sessionFactory.getCurrentSession()
					.createSQLQuery("select S_NAME from SOFTWARE where S_NAME like '%365%'");
			List list = createQuery.list();
			String mname = list.toString();

			if (!Status.equals("Hold") && !Status.equals("Rejected By It Compliance")) {
//				//System.out.println("hi thisis inside ");
				if (requestcategory.equals("Server") && !(mname.contains(softwarename))) {
					FinalGroup = "NT Admin";
//					Status = "Pending Approval By NT Admin";

//				//System.out.println("inside server"+FinalGroup);
				} else if ((requestcategory.equals("Laptop") || requestcategory.equals("Desktop"))
						&& !(mname.contains(softwarename))) {
//				//System.out.println("inside laptop"+requestcategory);
					FinalGroup = "Remote Support";
				} else if ((requestcategory.equals("Laptop") || requestcategory.equals("Desktop")
						|| requestcategory.equals("Server")) && mname.contains(softwarename)) {
//				//System.out.println("inside  SOFTWARE contains office 365");
//					Status = "Pending Approval By MAIL Admin";
					FinalGroup = "Mail Admin";
				}
			} else {
				FinalGroup = "IT Compliance";
			}

			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_REQUEST set IT_COMPIANCE_APPROVAL_NAME=:IT_COMPIANCE_APPROVAL_NAME,IT_COMPIANCE_APPROVAL_NAME_FULLNAME='"
							+ FullNameOfLogin
							+ "',IT_COMPIANCE_APPROVAL_DATE=:IT_COMPIANCE_APPROVAL_DATE,STATUS=:STATUS,IT_COMPIANCE_APPROVAL_DESC=:IT_COMPIANCE_APPROVAL_DESC,GROUPNAME=:GROUPNAME,LISENCE_KEY=:LISENCE_KEY where T_ID=:T_ID");
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_NAME", appByITCompName);
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DESC", approvenote);
			updatesr.setParameter("GROUPNAME", FinalGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("LISENCE_KEY", licensekey);

			updatesr.setParameter("T_ID", tid);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String msg = null;
		String[] split = Status.split(" ");
		String approvalStatus = split[0];
//		String currentStatus="";
		
		//msg for Approved
		
		if(Status.equals("Approved By It Compliance"))
		{
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
				"<tr><td>Status:</td><td>" + Status+ "</td></tr>" + 
				"<tr><td>Approved By:</td><td>" + appByITCompName + "  ["
				+ FullNameOfLogin + "]</td></tr>" + "<tr>" +
				"<tr><td>Send To:</td><td> Group </td></tr>" + 
				"<tr><td>Group Name:</td><td>" + FinalGroup+ "</td></tr>" + 
				"<tr>";
		}
		//msg for Hold
		else if(Status.equals("Hold"))
		{
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
					"<tr><td>Status:</td><td>Hold</td></tr>" + 
					"<tr><td>Hold By:</td><td>" + appByITCompName + "  ["
					+ FullNameOfLogin + "]</td></tr>" + "<tr>";
		}
		//msg for Rejected
		else
		{
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
					"<tr><td>Status:</td><td>Rejected by IT Compliance</td></tr>" + 
					"<tr><td>Rejected By:</td><td>" + appByITCompName + "  ["
					+ FullNameOfLogin + "]</td></tr>" + "<tr>";
					
			
		}
		if (status.equals("success")) {
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(tid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);

			tickettrack.setSTATUS(Status);

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(RaisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(CompanyRaisedBy);
			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setTICKET_TYPE("Software Request");

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);
		}
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}
			if (status.equals("success")) {
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(appByITCompName);

				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");
				ticketActivityLog.setTICKET_TYPE("Software Request");
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
try {	
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getPendingToApproveRequestByManager() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_REQUEST where APPROVAR_NAME='"
				+ loginuser
				+ "' and STATUS in('Pending For Managers Approval','Re-Opened') ORDER bY STR_TO_DATE(RAISED_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public String InsertRequestApprovedByMAnager(String appByITCompname, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String RaisedByName, String tid) {

		int id = 0;
		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
				// //System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			// System.out.println("FDullanrme "+FullNameOfLogin);
//			String appByITCompName, String status, String approvenote,
//			String approvalName, MultipartFile empPic,
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_REQUEST set APPROVAR_NAME_FULLNAME=:APPROVAR_NAME_FULLNAME,APPROVAR_DATE=:APPROVAR_DATE,APPROVAL_NOTE=:APPROVAL_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS,P_ID=:P_ID where T_ID=:T_ID");
			updatesr.setParameter("APPROVAR_NAME_FULLNAME", FullNameOfLogin);
			updatesr.setParameter("APPROVAR_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("APPROVAL_NOTE", approvenote);
			updatesr.setParameter("GROUPNAME", "IT Compliance");
			updatesr.setParameter("P_ID", pid);
			updatesr.setParameter("T_ID", tid);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();

			// System.out.println(e);
		}
		String msg = null;
		String currStatus = "";

		String[] split = Status.split(" ");
		String approve = split[0];
		if(Status.equals("Approved By Manager"))
		{
								
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
				"<tr><td>Status:</td><td>" + Status + "</td></tr>" + 
				"<tr><td>" + approve + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin+ "]</td></tr>" + 
				"<tr><td>Send to: Group</td><td>" + "<tr><td>Group Name: IT Compliance</td><td>" ;
		}
		else
		{
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status: Rejected By Manager</td><td>"
					+ "<tr><td>Manager Name:</td><td>" + loginuser + "  [" + FullNameOfLogin+ "]</td></tr>" ;
			
		}
		
		if (status.equals("success")) {
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(tid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);
			tickettrack.setSTATUS(Status);
			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setTICKET_TYPE("Software Request");

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(RaisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

		}
		;
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {
				
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception ess) {
// TODO Auto-generated catch block
				ess.printStackTrace();
				// System.out.println(ess);
			}

			if (status.equals("success")) {
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginuser);

				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setROLE_TYPE(loginRoleType);

				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setTICKET_TYPE("Software Request");
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(tid, Status);
		}catch(Exception es)
		{
			es.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getPendingSoftwareReqauestInTc() {

		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='Remote Support' and CATEGORY_REQUEST!='Server'  and ( STATUS  ='Approved By It Compliance' or STATUS='Approved By Mail Admin' or(STATUS='Hold' and RT_APPROVAL='"
						+ loginuser
						+ "' )) ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Approved By Mail Admin")
					|| sourceDrive.getSTATUS().equals("Approved By It Compliance")
					|| sourceDrive.getSTATUS().equals("Hold")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
//			else {
//				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray gatherSoftwareRequestDetails(String ticketid) {
		// System.out.println("inside gatherSoftwareRequestDetails");
		JSONArray array = null;
		JSONArray array1 = null;
		String loginuser = null;
		String Company = null;
		String department = "";

		String sub_department = "";
		String location = "";
		String emailId = "";
		String ContactNo = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			Company = session.getAttribute("companyname").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			array = new JSONArray();
			Query getLoginmasterdata = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + loginuser + "' and COMPANY='" + Company + "'");

			Query getData = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_REQUEST where T_ID='" + ticketid + "'");

			List<SOFTWARE_REQUEST> list = getData.list();
			for (SOFTWARE_REQUEST ticketDrive : list) {
				JSONObject arrayobj = new JSONObject();
				Query getDataa = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"
						+ ticketDrive.getT_REQUESTER() + "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'");
				List<loginmaster> listOfuser = getDataa.list();
				for (loginmaster loginDrive : listOfuser) {
					department = loginDrive.getDEPARTMENT();
					sub_department = loginDrive.getSUB_DEPARTMENT();
					location = loginDrive.getLOCATION();
					emailId = loginDrive.getEMAIL();
					ContactNo = loginDrive.getPHONE();
				}
				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);
				arrayobj.put("ASSETNAME", ticketDrive.getASSET_NAME());
				arrayobj.put("ASSETSTATUS", ticketDrive.getASSET_STATUS());
				arrayobj.put("ASSETCATEGORY", ticketDrive.getCATEGORY());
				arrayobj.put("ASSETTAG", ticketDrive.getASSET_TAG());
				arrayobj.put("ASSETSUBCATEGORY", ticketDrive.getSUB_CATEGORY());
				arrayobj.put("ASSET_IPADDRESS", ticketDrive.getIP_ADDRESS());
				arrayobj.put("RCAT", ticketDrive.getCATEGORY_REQUEST());
				if (emailId.isEmpty() || emailId == null) {
					arrayobj.put("EMAIL", "NA");
				} else {
					arrayobj.put("EMAIL", emailId);
				}
				if (ContactNo.isEmpty() || ContactNo == null) {
					arrayobj.put("PHONE", "NA");
				} else {
					arrayobj.put("PHONE", ContactNo);
				}
				arrayobj.put("T_ID", ticketDrive.getT_ID());
				arrayobj.put("STATUS", ticketDrive.getSTATUS());
				arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
				arrayobj.put("P_ID", ticketDrive.getP_ID());
				arrayobj.put("SOFTWARE_NAME", ticketDrive.getS_NAME());
				arrayobj.put("COST", ticketDrive.getS_COST());
				arrayobj.put("R_PERIOD", ticketDrive.getS_PERIOD());
				arrayobj.put("DESC", ticketDrive.getT_DESC());

				arrayobj.put("SERVER_IP_ADDRESS", ticketDrive.getSERVER_IP_ADDRESS());
				arrayobj.put("OWNER_NAME_CR", ticketDrive.getOWNER_NAME_CR());
				arrayobj.put("SERVER_HOSTORCODE", ticketDrive.getSERVER_HOSTORCODE());

				String AttachName = ticketDrive.getATTACH_NAME();
//				//System.out.println("Attachement name"+AttachName);
				try {
					if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						//// System.out.println("Null object found");
					} else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
						//// System.out.println("Object found");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//// System.out.println("IN CATCH BLOCK");
//					arrayobj.put("T_ATTACH1_NAME", "No File Available");
					e.printStackTrace();
				}
				array.put(arrayobj);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return array;
	}

	@Override
	public String InsertRequestApprovedByRemotSupport(String appByITCompName, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String CompanyRaisedBy, String RaisedByName, String tid, String requestCartegory) {

		int id = 0;
	

		String status = "";
		String FullNameOfLogin = "";
//		T_REQUESTER_FULLNAME,ASSET_NAME from SOFTWARE_REQUEST,SERVER_HOSTORCODE

		String RaisedBy = "";
		String raisedByFullName = "";
		String Asset_NameITAM = "";
		String Server_assetName = "";
		String Asset_NameCustom = "";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String companyRB = "";
		String branchRB="";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String AssignGroup = null;
		String departmentRB = null;
		String LocationRB = null;
		String software_cost = null;
		String recovery_preriod = null;
		String companylogin=null;
		try {
			Query createQuery = sessionFactory.getCurrentSession().createQuery("select T_REQUESTER,"
					+ "T_REQUESTER_FULLNAME,ASSET_NAME,ASSET_NAME_CR, COALESCE(SERVER_HOSTORCODE,'NA'),S_COST,S_PERIOD from SOFTWARE_REQUEST where T_ID='"
					+ tid + "'");
//			System.out.println("dfgfdgfdgfdgdfgf"+createQuery);
			List<Object[]> list2 = createQuery.list();
			for (Object[] sl : list2) {
//				System.out.println("@@@@@@@@@@@@@@@@@@@"+sl[0].toString());
				RaisedBy = sl[0].toString();
				raisedByFullName = sl[1].toString();
				Asset_NameITAM = sl[2].toString();
				Asset_NameCustom = sl[3].toString();
				Server_assetName = sl[4].toString();
				software_cost = sl[5].toString();
				recovery_preriod = sl[6].toString();
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
		
			loginRoleType = session.getAttribute("role").toString();
			companylogin = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			
			
			Date currentdate = dateFormat.parse(currenttime);

			
			try {
			Query listOfmasterdata = sessionFactory.getCurrentSession()
						.createSQLQuery("select LOCATION,DEPARTMENT,COMPANY,BRANCH from loginmaster where USERNAME='" + RaisedBy+ "' and COMPANY='3i Infotech'");
			List<Object[]> list=	listOfmasterdata.list();
				for (Object[] obj : list) {
					LocationRB =obj[0].toString();
					departmentRB = obj[1].toString();
					companyRB = obj[2].toString();
					branchRB = obj[3].toString();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (!requestCartegory.equals("Server")) {
			AssignGroup = "Remote Support";
		} else {
			AssignGroup = "NT Admin";
		}
		try {
			Query getLoginData = sessionFactory.getCurrentSession()
					.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
							+ "' and COMPANY='" + companylogin + "'");
			List<Object[]> list = getLoginData.list();
			for (Object[] obj : list) {
				EMAIL = obj[0].toString();
				PHONE = obj[1].toString();
			}
//			//System.out.println("FDullanrme "+FullNameOfLogin);
//			String approvalName, MultipartFile empPic,
			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_REQUEST set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_FULLNAME='"
							+ FullNameOfLogin
							+ "',RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", appByITCompName);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("GROUPNAME", AssignGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", approvenote);

			updatesr.setParameter("T_ID", tid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
				if (Status.equals("Resolved")) {
					int sno = 0;
					try {
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(USER_SOFTWARE_MAP.class)
								.setProjection(Projections.max("SRNO"));
						Integer srno1 = (Integer) crit.uniqueResult();
						if (srno1 != null) {
							sno = srno1.intValue();
							sno = sno + 1;
							// System.out.println("IN IF SNO IS: " + sno);
						} else {
							sno = 1;
							// System.out.println("IN ELSE SNO IS: " + sno);
						}
					} catch (Exception e) {

						e.printStackTrace();
						// System.out.println(e);
					}
					USER_SOFTWARE_MAP mp = new USER_SOFTWARE_MAP();
					mp.setUSERNAME(RaisedBy + "~" + raisedByFullName);
					mp.setAPPLIED_DATE(currenttime);
					mp.setPRODUCT_NAME(softwarename);
					mp.setPROJECT_ID(pid);
					mp.setSTATUS("NA");
					if (requestCartegory.equals("Server")) {
						mp.setASSET_CODE(Server_assetName);
					} else if (!requestCartegory.equals("Server")) {
						if (Asset_NameCustom.equals(Asset_NameITAM)) {
							mp.setASSET_CODE(Asset_NameITAM);
						} else if (!Asset_NameCustom.equals(Asset_NameITAM)) {
							mp.setASSET_CODE(Asset_NameCustom);
						}
					}
					mp.setSRNO(sno);
					sessionFactory.getCurrentSession().save(mp);

					int srno = 0;
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(SOFTWARE_CHARGES_DETAILS.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();
					if (srno1 != null) {
						srno = srno1.intValue();
						srno = srno + 1;
						// System.out.println("IN IF SNO IS: " + sno);
					} else {
						srno = 1;
						// System.out.println("IN ELSE SNO IS: " + sno);
					}
					SOFTWARE_CHARGES_DETAILS scd = new SOFTWARE_CHARGES_DETAILS();
					scd.setSOFTWARE_NAME(softwarename);
					scd.setSR_NO(srno);
					scd.setAPPLIED_DATE(currenttime);
					scd.setPROJECT_ID(pid);
					scd.setUSED_BY(RaisedBy);
					scd.setUSED_BY_FULLNAME(raisedByFullName);
					scd.setCOST_PER_MONTH(software_cost);
					scd.setRELEASE_DATE("NA");
					scd.setDEPARTMENT(departmentRB);
					scd.setCOMPANY(companyRB);
					scd.setBRANCH(branchRB);
					scd.setLOCATION(LocationRB);
					scd.setRECOVERY_PERIOD(recovery_preriod);
//					sessionFactory.getSessionFactoryOptions().
					if (requestCartegory.equals("Server")) {
						scd.setASSET_CODE(Server_assetName);

					} else if (!requestCartegory.equals("Server")) {
						if (Asset_NameCustom.equals(Asset_NameITAM)) {
							scd.setASSET_CODE(Asset_NameITAM);
						} else if (!Asset_NameCustom.equals(Asset_NameITAM)) {
							scd.setASSET_CODE(Asset_NameCustom);
						}
					}
					Serializable save = sessionFactory.getCurrentSession().save(scd);
//					System.out.println(" SNO IS: " + Integer.parseInt(save.toString()));

				}

			} else {
				status = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}

		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + Status + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>" + "<tr>";
		if (status.equals("success")) {
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(tid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);

			tickettrack.setSTATUS(Status);

			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(RaisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(companylogin);
			tickettrack.setTICKET_RAISED_BY_COMPANY(CompanyRaisedBy);
			tickettrack.setTICKET_TYPE("Software Request");

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}
			sessionFactory.getCurrentSession().persist(tickettrack);
		}
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}
			if (status.equals("success")) {
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(appByITCompName);

				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				System.out.println("EMAILLLLLLLL"+EMAIL);
				System.out.println("PHONE"+PHONE);
				
				//		ticketActivityLog.setCHANGE_NOTES1(approvenote);
				
System.out.println("Logintype"+loginRoleType);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setT_COMPANY(companylogin);
				ticketActivityLog.setT_EMAIL(EMAIL);
				
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
				ticketActivityLog.setTICKET_TYPE("Software Request");
				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
try {	
			if(status.equals("success"))
				//System.out.println("Statudd sd sd "+Status);
			Inv.EmaiLSmsTriggerdInSoftwareRequest(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getUserRequestList() {

		// System.out.println("Inside EFORm Activity Dao Impl ");
		JSONArray array = null;
		String loginuser = "";
		String loginUSerGroup = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginUSerGroup = session.getAttribute("GROUP").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		String currentGroup = "Mail Admin";
		String mailAdminvar = "NA";
		if (!loginUSerGroup.equals("NA")) {
			if (loginUSerGroup.contains(currentGroup)) {
				mailAdminvar = currentGroup;
			}
		} else {
			mailAdminvar = "NA";
		}

		if (mailAdminvar.equals("Mail Admin")) {

			Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_REQUEST where T_REQUESTER='"
					+ loginuser
					+ "'or  S_NAME like'%Microsoft Office%' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
			List<SOFTWARE_REQUEST> req = query.list();
			for (SOFTWARE_REQUEST sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(sourceDrive.getT_ID());
//				if(sourceDrive.getSTATUS().equals("Resolved"))
//				{
//					array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//				}
//				else
//				{
//					array.put(" ");
//				}
				if (  (sourceDrive.getSTATUS().equals("Rejected By It Compliance")) && (sourceDrive.getT_REQUESTER().equals(loginuser))
						|| sourceDrive.getSTATUS().equals("Rejected By Manager")
						|| sourceDrive.getSTATUS().equals("Rejected")
						|| sourceDrive.getSTATUS().equals("Rejected By Mail Admin")) {
					array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					array.put(" ");
				}
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
				array.put(sourceDrive.getRT_APPROVAL());
				array.put(sourceDrive.getRT_APPROVAL_FULLNAME());

				array.put(sourceDrive.getCLOSED_BY());
				array.put(sourceDrive.getCLOSED_BY_FULLNAME());
				array.put(sourceDrive.getRE_OPENED_BY());
				array.put(sourceDrive.getRE_OPENED_BY_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
				array.put(sourceDrive.getAPPROVAR_DATE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRT_APPROVAL_DATE());
				array.put(sourceDrive.getCLOSED_DATE());
				array.put(sourceDrive.getRE_OPENED_DATE());
				array1.put(array);
			}

		} else {
			Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_REQUEST where T_REQUESTER='"
					+ loginuser + "' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
			List<SOFTWARE_REQUEST> req = query.list();
			for (SOFTWARE_REQUEST sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(sourceDrive.getT_ID());
//				if(sourceDrive.getS_NAME().contains("Microsoft Office"))
//				{
//					array.put(sourceDrive.getS_NAME());
//				}
//				else
//				{
//					array.put(" ");
//				}
				if (sourceDrive.getSTATUS().equals("Rejected By Mail Admin")
						|| sourceDrive.getSTATUS().equals("Rejected By It Compliance")
						|| sourceDrive.getSTATUS().equals("Rejected By Manager")
						|| sourceDrive.getSTATUS().equals("Rejected")) {
					array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					array.put(" ");
				}
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
				array.put(sourceDrive.getRT_APPROVAL());
				array.put(sourceDrive.getRT_APPROVAL_FULLNAME());
				array.put(sourceDrive.getCLOSED_BY());
				array.put(sourceDrive.getCLOSED_BY_FULLNAME());
				array.put(sourceDrive.getRE_OPENED_BY());
				array.put(sourceDrive.getRE_OPENED_BY_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
				array.put(sourceDrive.getAPPROVAR_DATE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRT_APPROVAL_DATE());
				array.put(sourceDrive.getCLOSED_DATE());
				array.put(sourceDrive.getRE_OPENED_DATE());
				array1.put(array);
			}

		}

		return array1;

	}

	@Override
	public JSONArray getRequestActivityLog(String ticketid, String type) {

		// System.out.println("Inside UserActivityDaoImpl getUserTicketTracking
		// method"+type);
		JSONArray array = new JSONArray();
		try {
			if (type.equals("Software Request")) { // System.out.println("inside dao imple dd");
				Query queryticketActivity = sessionFactory.getCurrentSession().createQuery(
						"from EFORM_ACTIVITY_LOG where T_ID=:T_ID and TICKET_TYPE='Software Request' order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
				queryticketActivity.setParameter("T_ID", ticketid);
				List<EFORM_ACTIVITY_LOG> ticketActivity = queryticketActivity.list();
				for (EFORM_ACTIVITY_LOG sourceDrive : ticketActivity) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
					arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
					arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
					arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
					arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
					arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
					arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
					arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());

					arrayobjtemp.put("FULLNAME", sourceDrive.getT_FULLNAME());
					arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
					array.put(arrayobjtemp);
				}

			} else if (type.equals("Software Transfer")) {
				// System.out.println("TI_ID"+ticketid);

				Query queryticketActivity = sessionFactory.getCurrentSession().createQuery(
						"from EFORM_ACTIVITY_LOG where T_ID=:T_ID and TICKET_TYPE='Software Transfer' order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
				queryticketActivity.setParameter("T_ID", ticketid);
				List<EFORM_ACTIVITY_LOG> ticketActivity = queryticketActivity.list();
				for (EFORM_ACTIVITY_LOG sourceDrive : ticketActivity) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
					arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
					arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
					arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
					arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
					arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
					arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
					arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//					arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//					arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//					arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
					arrayobjtemp.put("FULLNAME", sourceDrive.getT_FULLNAME());
					arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
					array.put(arrayobjtemp);
				}

			} else if (type.equals("Software Release")) {
				// System.out.println("ddddddddddddddddddddddd"+ticketid);

				Query queryticketActivity = sessionFactory.getCurrentSession().createQuery(
						"from EFORM_ACTIVITY_LOG where T_ID=:T_ID and TICKET_TYPE='Software Release' order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
				queryticketActivity.setParameter("T_ID", ticketid);
				List<EFORM_ACTIVITY_LOG> ticketActivity = queryticketActivity.list();
				for (EFORM_ACTIVITY_LOG sourceDrive : ticketActivity) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
					arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
					arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
					arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
					arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
					arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
					arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
					arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//				arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//				arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//				arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
					arrayobjtemp.put("FULLNAME", sourceDrive.getT_FULLNAME());
					arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
					array.put(arrayobjtemp);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;

	}

	@Override
	public JSONArray getRequestID(String requestType) {
		String LoginUser = null;
		String loginUserCompany = null;
		String FinalGroup = null;
		String GroupOfTc = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			String GROUPNAME = session.getAttribute("GROUP").toString();
			// System.out.println("usernamesdfdffdfdffmeeem" + GROUPNAME);

			if (!GROUPNAME.equals("NA")) {
				if (GROUPNAME.contains(",")) {
					// System.out.println("inside if with , condition");
					String[] split = GROUPNAME.split(",");
					for (int i = 0; i < split.length; i++) {

						if (split[i].equals("IT Compliance") || split[i].equals("Remote Support")
								|| split[i].equals("NT Admin") || split[i].equals("Mail Admin")) {
							FinalGroup = split[i];
						}
					}
				} else {
					FinalGroup = GROUPNAME;
					// System.out.println("group nsame is "+FinalGroup);

				}
			} else {
				FinalGroup = "NA";
			}
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}
		JSONArray array = null;
		JSONArray array1 = null;
		// System.out.println("final groupddddddddddddddddddddddddddddddddddddddd
		// "+FinalGroup);
		if (requestType.equals("softwareRequest")) {
			if (!(FinalGroup.isEmpty()) && FinalGroup.equals("IT Compliance")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Remote Support")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("NT Admin")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")) {
				// System.out.println("sdddd inside allllll");
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_REQUEST GROUP BY T_ID  ORDER BY SRNO DESC").list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}

//		else if(!(FinalGroup.isEmpty())&&FinalGroup.equals("IT Compliance"))
//		{
//			//System.out.println("sdddd inside alsssssssssssssslllll");
//			try {
//				List<Object> dataList = sessionFactory.getCurrentSession().createQuery("select T_ID from SOFTWARE_REQUEST GROUP BY T_ID  ORDER BY SRNO DESC").list();
//				array1 = new JSONArray();
//				for (Object sourceDrive : dataList) {
//					array = new JSONArray();
//					array.put(sourceDrive);
//					array1.put(array);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			}
//		}
//		else if(!(FinalGroup.isEmpty())&&FinalGroup.equals("Remote Support"))
//		{
//			//System.out.println("inside Remote Support");
//			try {
//			List<Object> dataList = sessionFactory.getCurrentSession().createQuery("select T_ID from SOFTWARE_REQUEST where CATEGORY_REQUEST='Laptop' or CATEGORY_REQUEST='Desktop' GROUP BY T_ID  ORDER BY SRNO DESC").list();
//			array1 = new JSONArray();
//			for (Object sourceDrive : dataList) {
//				array = new JSONArray();
//				array.put(sourceDrive);
//				array1.put(array);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//			
//		}
//		else if(!(FinalGroup.isEmpty())&&FinalGroup.equals("NT Admin"))
//		{
//			//System.out.println("inside NT Admin");
//			try {
//			List<Object> dataList = sessionFactory.getCurrentSession().createQuery("select T_ID from SOFTWARE_REQUEST where CATEGORY_REQUEST='Server' GROUP BY T_ID  ORDER BY SRNO DESC").list();
//			array1 = new JSONArray();
//			for (Object sourceDrive : dataList) {
//				array = new JSONArray();
//				array.put(sourceDrive);
//				array1.put(array);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//			
//			
//		}
//		else if(!(FinalGroup.isEmpty())&&FinalGroup.equals("NT Admin") && !(FinalGroup.isEmpty())&&FinalGroup.equals("Mail Admin"))
//		{
//			//System.out.println("inside NT Admin");
//			try {
//			List<Object> dataList = sessionFactory.getCurrentSession().createQuery("select T_ID from SOFTWARE_REQUEST where CATEGORY_REQUEST='Server' or S_NAME like '%365%'  GROUP BY T_ID  ORDER BY SRNO DESC").list();
//			array1 = new JSONArray();
//			for (Object sourceDrive : dataList) {
//				array = new JSONArray();
//				array.put(sourceDrive);
//				array1.put(array);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//		}
			else if (!(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")) {
				// System.out.println("inside mail Aadmindddddddd"+FinalGroup);
				try {

					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_REQUEST where S_NAME like '%365%' || (T_REQUESTER='"
									+ LoginUser + "' and T_COMPANY='" + loginUserCompany
									+ "') GROUP BY T_ID  ORDER BY SRNO DESC")
							.list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			} else {
				// System.out.println("inside all ticket");
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_REQUEST where T_REQUESTER='" + LoginUser
									+ "' and T_COMPANY='" + loginUserCompany
									+ "' order by STR_TO_DATE(RAISED_DATE,'%d-%m-%Y %H:%i:%s') DESC")
							.list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} else if (requestType.equals("SoftwareRelease")) {
			if (!(FinalGroup.isEmpty()) && FinalGroup.equals("IT Compliance")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Remote Support")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("NT Admin")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")) {
				// System.out.println("sdddd inside allllll");
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_RELEASE GROUP BY T_ID  ORDER BY SRNO DESC").list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			} else {
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_RELEASE where T_REQUESTER='" + LoginUser
									+ "' and T_COMPANY='" + loginUserCompany
									+ "' order by STR_TO_DATE(RAISED_DATE,'%d-%m-%Y %H:%i:%s') DESC")
							.list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} else if (requestType.equals("SoftwareTransfer")) {
			if (!(FinalGroup.isEmpty()) && FinalGroup.equals("IT Compliance")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Remote Support")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("NT Admin")
					|| !(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")) {
				// System.out.println("sdddd inside allllll");
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_TRANSFER GROUP BY T_ID  ORDER BY SRNO DESC").list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			} else {

				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from SOFTWARE_TRANSFER where T_REQUESTER='" + LoginUser
									+ "' and T_COMPANY='" + loginUserCompany
									+ "' order by STR_TO_DATE(RAISED_DATE,'%d-%m-%Y %H:%i:%s') DESC")
							.list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}

		return array1;

	}

	@Override
	public JSONArray getUserRequestTracking(String ticketid, String reqType) {

		//// System.out.println("Inside UserActivityDaoImpl getUserTicketTracking
		//// method");
		JSONArray array1 = null;

		try {
			if (reqType.equals("softwareRequest")) {
				String TypeOfTicket = "Software Request";
				List<SOFTWARE_REQUEST> dataList = sessionFactory.getCurrentSession()
						.createQuery("from SOFTWARE_REQUEST where T_ID='" + ticketid + "'").list();
				array1 = new JSONArray();
				for (SOFTWARE_REQUEST sourceDrive : dataList) {

					String department = "";
					String sub_department = "";
					String location = "";
					List<loginmaster> loginDataList = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME ='" + sourceDrive.getT_REQUESTER()
									+ "' and COMPANY ='" + sourceDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster loginDrive : loginDataList) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
					}

					JSONObject arrayobj = new JSONObject();
					arrayobj.put("T_ID", sourceDrive.getT_ID());
					arrayobj.put("T_DATE", sourceDrive.getRAISED_DATE());
					arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
					arrayobj.put("T_MAIL", sourceDrive.getEMAIL_ID());
					arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
					arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
//				arrayobj.put("T_CATEGORY", sourceDrive.getT_CATEGORY());
//				arrayobj.put("T_SUBCAT1", sourceDrive.getT_SUBCAT1());
//				arrayobj.put("T_SUBCAT2", sourceDrive.getT_SUBCAT2());
					arrayobj.put("T_SUBJECT", sourceDrive.getT_DESC());
					arrayobj.put("T_DESC", sourceDrive.getT_DESC());
					arrayobj.put("T_ATTACH1_NAME", sourceDrive.getATTACH_NAME());
//				arrayobj.put("T_ATTACH2_NAME", sourceDrive.getCLOSE_NOTES());
					arrayobj.put("STATUS", sourceDrive.getSTATUS());
					arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobj.put("SEVERITY", sourceDrive.getSEVERITY());
//				arrayobj.put("T_RAISE_TIME", sourceDrive.getR);
					array1.put(arrayobj);

					Query queryticketTracking = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_REQUEST_TRACKING where T_ID=:T_ID and TICKET_TYPE='" + TypeOfTicket
									+ "' order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
					queryticketTracking.setParameter("T_ID", ticketid);
					List<EFORM_REQUEST_TRACKING> ticketTracking = queryticketTracking.list();
					JSONArray array2 = new JSONArray();
					for (EFORM_REQUEST_TRACKING sourceDrive1 : ticketTracking) {
						JSONObject arrayobjtemp = new JSONObject();
						arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
						arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
						arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
						array2.put(arrayobjtemp);
					}
					arrayobj.put("STATUS_LOG", array2);
				}
			} else if (reqType.equals("SoftwareRelease")) {
				String TypeOfTicket = "Software Release";
				List<SOFTWARE_RELEASE> dataList = sessionFactory.getCurrentSession()
						.createQuery("from SOFTWARE_RELEASE where T_ID='" + ticketid + "'").list();
				array1 = new JSONArray();
				for (SOFTWARE_RELEASE sourceDrive : dataList) {

					String department = "";
					String sub_department = "";
					String location = "";
					List<loginmaster> loginDataList = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME ='" + sourceDrive.getT_REQUESTER()
									+ "' and COMPANY ='" + sourceDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster loginDrive : loginDataList) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
					}

					JSONObject arrayobj = new JSONObject();
					arrayobj.put("T_ID", sourceDrive.getT_ID());
					arrayobj.put("T_DATE", sourceDrive.getRAISED_DATE());
					arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
					arrayobj.put("T_MAIL", sourceDrive.getEMAIL_ID());
					arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
					arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
//					arrayobj.put("T_CATEGORY", sourceDrive.getT_CATEGORY());
//					arrayobj.put("T_SUBCAT1", sourceDrive.getT_SUBCAT1());
//					arrayobj.put("T_SUBCAT2", sourceDrive.getT_SUBCAT2());
					arrayobj.put("T_SUBJECT", sourceDrive.getT_DESC());
					arrayobj.put("T_DESC", sourceDrive.getT_DESC());
					arrayobj.put("T_ATTACH1_NAME", sourceDrive.getATTACH_NAME());
//					arrayobj.put("T_ATTACH2_NAME", sourceDrive.getCLOSE_NOTES());
					arrayobj.put("STATUS", sourceDrive.getSTATUS());
					arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobj.put("SEVERITY", sourceDrive.getSEVERITY());
//					arrayobj.put("T_RAISE_TIME", sourceDrive.getR);
					array1.put(arrayobj);

					Query queryticketTracking = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_REQUEST_TRACKING where T_ID=:T_ID and TICKET_TYPE='" + TypeOfTicket
									+ "' order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
					queryticketTracking.setParameter("T_ID", ticketid);
					List<EFORM_REQUEST_TRACKING> ticketTracking = queryticketTracking.list();
					JSONArray array2 = new JSONArray();
					for (EFORM_REQUEST_TRACKING sourceDrive1 : ticketTracking) {
						JSONObject arrayobjtemp = new JSONObject();
						arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
						arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
						arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
						array2.put(arrayobjtemp);
					}
					arrayobj.put("STATUS_LOG", array2);
				}
			}

			else if (reqType.equals("SoftwareTransfer")) {
				String TypeOfTicket = "Software Transfer";
				List<SOFTWARE_TRANSFER> dataList = sessionFactory.getCurrentSession()
						.createQuery("from SOFTWARE_TRANSFER where T_ID='" + ticketid + "'").list();
				array1 = new JSONArray();
				for (SOFTWARE_TRANSFER sourceDrive : dataList) {

					String department = "";
					String sub_department = "";
					String location = "";
					List<loginmaster> loginDataList = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME ='" + sourceDrive.getT_REQUESTER()
									+ "' and COMPANY ='" + sourceDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster loginDrive : loginDataList) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
					}

					JSONObject arrayobj = new JSONObject();
					arrayobj.put("T_ID", sourceDrive.getT_ID());
					arrayobj.put("T_DATE", sourceDrive.getRAISED_DATE());
					arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
					arrayobj.put("T_MAIL", sourceDrive.getEMAIL_ID());
					arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
					arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
//					arrayobj.put("T_CATEGORY", sourceDrive.getT_CATEGORY());
//					arrayobj.put("T_SUBCAT1", sourceDrive.getT_SUBCAT1());
//					arrayobj.put("T_SUBCAT2", sourceDrive.getT_SUBCAT2());
					arrayobj.put("T_SUBJECT", sourceDrive.getDESCRIPTION());
					arrayobj.put("T_DESC", sourceDrive.getDESCRIPTION());
					arrayobj.put("T_ATTACH1_NAME", sourceDrive.getT_ATTACH_NAME());
//					arrayobj.put("T_ATTACH2_NAME", sourceDrive.getCLOSE_NOTES());
					arrayobj.put("STATUS", sourceDrive.getSTATUS());
					arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobj.put("SEVERITY", sourceDrive.getSEVERITY());
//					arrayobj.put("T_RAISE_TIME", sourceDrive.getR);
					array1.put(arrayobj);

					Query queryticketTracking = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_REQUEST_TRACKING where T_ID=:T_ID and TICKET_TYPE='" + TypeOfTicket
									+ "' order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
					queryticketTracking.setParameter("T_ID", ticketid);
					List<EFORM_REQUEST_TRACKING> ticketTracking = queryticketTracking.list();
					JSONArray array2 = new JSONArray();
					for (EFORM_REQUEST_TRACKING sourceDrive1 : ticketTracking) {
						JSONObject arrayobjtemp = new JSONObject();
						arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
						arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
						arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
						array2.put(arrayobjtemp);
					}
					arrayobj.put("STATUS_LOG", array2);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}

	@Override
	public JSONArray getSoftwares() {

//System.out.println("inside getAssetFromOfLoginUser daoImpl");

		JSONArray array1 = null;
		JSONArray array = null;

		try {

			Query getasset = sessionFactory.getCurrentSession().createSQLQuery(
					"select distinct S_NAME from software where ACTIVE_CONDITION='TRUE' group by S_NAME");
			List<Object> list = getasset.list();
			array1 = new JSONArray();
			for (Object sourceDrive : list) {
				array = new JSONArray();
				array.put(sourceDrive);
				array1.put(array);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;

	}

	@Override
	public String closeSoftwareRequestRequest(String ticketid, String closereason) {
		String status = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String Fullname = null;
		String role_Type = null;
		try {

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// //System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

			// System.out.println("INSIDE EFORMACTIVITY CLOSESOFTWAREREQUESTREQUEST DAO
			// IMPL"+ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type = session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
				// //System.out.println("Exceptioon e***" + e);
			}
			try {

				int updateRequest = sessionFactory.getCurrentSession()
						.createQuery("update SOFTWARE_REQUEST set CLOSED_BY='" + LoginUser + "',CLOSED_BY_FULLNAME='"
								+ Fullname + "',CLOSED_DATE='" + currenttime + "',STATUS='Closed' where T_ID='"
								+ ticketid + "'")
						.executeUpdate();

				// System.out.println("update SOFTWARE_REQUEST set CLOSED_BY"+updateRequest);
				if (updateRequest > 0) {
					status = "success";
				} else {
					status = "error";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					// System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						// System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						// System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					// System.out.println(e);
				}
				if (status.equals("success")) {

					String msg = null;

					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
							+ "<tr><td>Status:</td><td>Closed</td></tr>" + "<tr><td>Closed By:</td><td>" + LoginUser
							+ "  [" + Fullname + "]</td></tr>";
					EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

					tickettrack.setSR_NO(sno);
					tickettrack.setT_ID(ticketid);
					tickettrack.setACTIVITY_DATE(currenttime);
					tickettrack.setACTIVITY_NAME(LoginUser);
					tickettrack.setSTATUS("Closed");
					tickettrack.setMESSAGE(msg);
					tickettrack.setTICKET_RAISED_NAME(LoginUser);
					tickettrack.setACTIVITY_DATE_TIME(currenttime);
					tickettrack.setACTIVITY_COMPANY(loginUserCompany);
					tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
					tickettrack.setTICKET_TYPE("Software Request");
					tickettrack.setPRIORITY("P5");
					tickettrack.setSEVERITY("Information");
					sessionFactory.getCurrentSession().persist(tickettrack);
					status = "success";

					//////////////////// INSERT IN TICKET ACTIVITY log/////////////////

					int ActSno = 0;
					try {
						String EMAIL = null;
						String contactNo = null;
						Query getdata = sessionFactory.getCurrentSession()
								.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + LoginUser
										+ "' and COMPANY='" + loginUserCompany + "'");
						List<Object[]> obj = getdata.list();
						for (Object[] object : obj) {
							EMAIL = object[0].toString();
							contactNo = object[1].toString();
						}
						try {

							Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
									.setProjection(Projections.max("SR_NO"));
							Integer actSrno1 = (Integer) crit.uniqueResult();

							// System.out.println(" actSrno1 IS: " + actSrno1);

							if (actSrno1 != null) {
								ActSno = actSrno1.intValue();
								ActSno = ActSno + 1;
								// System.out.println("IN IF ActSno IS: " + ActSno);
							} else {
								ActSno = 1;
								// System.out.println("IN ELSE ActSno IS: " + ActSno);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							// System.out.println(e);
						}

						EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

						ticketActivityLog.setSR_NO(ActSno);
						ticketActivityLog.setT_ID(ticketid);
						ticketActivityLog.setSTATUS("Closed");
						ticketActivityLog.setT_DATETIME(currenttime);
						ticketActivityLog.setT_CHANGEBY(LoginUser);
						ticketActivityLog.setPRIORITY("P5");
						ticketActivityLog.setSEVERITY("Information");

						ticketActivityLog.setT_DESC(closereason);
						ticketActivityLog.setROLE_TYPE(role_Type);
						ticketActivityLog.setCHANGE_NOTES1(closereason);
						ticketActivityLog.setT_COMPANY(loginUserCompany);
						ticketActivityLog.setT_EMAIL(EMAIL);

						ticketActivityLog.setT_CONTACT_NO(contactNo);
						ticketActivityLog.setT_FULLNAME(Fullname);
						ticketActivityLog.setTICKET_TYPE("Software Request");

						sessionFactory.getCurrentSession().persist(ticketActivityLog);
						status = "success";

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

try {
			
			String ticketstatus="Closed";
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketid, ticketstatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
return status + "," + ticketid;
	}

	@Override
	public String RequestReopenResolvedTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
		// System.out.println("INSIDE EFORM DAO IMPL RequestReopenResolvedTicket");
		String status = "";

		String LoginUser = "";
		String loginUserCompany = "";
		String Fullname = "";
		String role_Type = "";
		try {

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// //System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

			// System.out.println("INSIDE EFORMACTIVITY CLOSESOFTWAREREQUESTREQUEST DAO
			// IMPL" + ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type = session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
				// //System.out.println("Exceptioon e***" + e);
			}

			Query update = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_RELEASE set STATUS='Re-Opened',RE_OPENED_DATE='" + currenttime
							+ "',RE_OPENED_BY='" + LoginUser + "',T_DESC=:T_DESC where T_ID='" + ticketid
							+ "'");
			update.setParameter("T_DESC", reopenreason);
			int updateReq =update.executeUpdate();
			try {
				if (updateReq > 0) {
					int sno = 0;
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
								.setProjection(Projections.max("SR_NO"));
						Integer srno1 = (Integer) crit.uniqueResult();

						// System.out.println(" SNO IS: " + srno1);

						if (srno1 != null) {
							sno = srno1.intValue();
							sno = sno + 1;
							// System.out.println("IN IF SNO IS: " + sno);
						} else {
							sno = 1;
							// System.out.println("IN ELSE SNO IS: " + sno);
						}
					} catch (Exception e) {

						e.printStackTrace();
						// System.out.println(e);
					}

					String msg = null;

					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
							+ "<tr><td>Status:</td><td>Re-Opened</td></tr>" + "<tr><td>Re-Opened By:</td><td>"
							+ LoginUser + "  [" + Fullname + "]</td></tr>";
					EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

					tickettrack.setSR_NO(sno);
					tickettrack.setT_ID(ticketid);
					tickettrack.setACTIVITY_DATE(currenttime);
					tickettrack.setACTIVITY_NAME(LoginUser);

					tickettrack.setSTATUS("Re-Opened");
					tickettrack.setPRIORITY("P5");
					tickettrack.setSEVERITY("Information");
					tickettrack.setMESSAGE(msg);
					tickettrack.setTICKET_TYPE("Software Release");
					tickettrack.setTICKET_RAISED_NAME(LoginUser);
					tickettrack.setACTIVITY_DATE_TIME(currenttime);
					tickettrack.setACTIVITY_COMPANY(loginUserCompany);
					tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);

					sessionFactory.getCurrentSession().persist(tickettrack);
					status = "success";
					///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

					int ActSno = 0;
					try {
						String EMAIL = null;
						String contactNo = null;
						Query getdata = sessionFactory.getCurrentSession()
								.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + LoginUser
										+ "' and COMPANY='" + loginUserCompany + "'");
						List<Object[]> obj = getdata.list();
						for (Object[] object : obj) {
							EMAIL = object[0].toString();
							contactNo = object[1].toString();
						}
						try {

							Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
									.setProjection(Projections.max("SR_NO"));
							Integer actSrno1 = (Integer) crit.uniqueResult();

							// System.out.println(" actSrno1 IS: " + actSrno1);

							if (actSrno1 != null) {
								ActSno = actSrno1.intValue();
								ActSno = ActSno + 1;
								// System.out.println("IN IF ActSno IS: " + ActSno);
							} else {
								ActSno = 1;
								// System.out.println("IN ELSE ActSno IS: " + ActSno);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							// System.out.println(e);
						}
						EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
						ticketActivityLog.setSR_NO(ActSno);
						ticketActivityLog.setT_ID(ticketid);
						ticketActivityLog.setSTATUS("Re-Opened");
						ticketActivityLog.setT_DATETIME(currenttime);
						ticketActivityLog.setT_CHANGEBY(LoginUser);
						ticketActivityLog.setPRIORITY("P5");
						ticketActivityLog.setSEVERITY("Information");
						ticketActivityLog.setT_DESC(reopenreason);
						ticketActivityLog.setROLE_TYPE(role_Type);
						ticketActivityLog.setCHANGE_NOTES1(reopenreason);
						ticketActivityLog.setT_COMPANY(loginUserCompany);
						ticketActivityLog.setT_EMAIL(EMAIL);
						ticketActivityLog.setTICKET_TYPE("Software Release");
						ticketActivityLog.setT_CONTACT_NO(contactNo);
						ticketActivityLog.setT_FULLNAME(Fullname);
						sessionFactory.getCurrentSession().persist(ticketActivityLog);
						status = "success";
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			// TODO: handle exception
	
}
		
	try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketid, "Re-Opened");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	return status;
	}

	@Override
	public JSONArray getWorkInProgressInTc() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='Remote Support' and STATUS in('Work in Progress','Resolved') and CATEGORY_REQUEST<>'Server'   ORDER bY STR_TO_DATE(RT_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Work in Progress")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray getLoginUserSoftwares() {
		// System.out.println("hi this is gor");
		String username = "";
		JSONArray array = null;
		JSONArray array1 = null;
		String FullName = "";
//		String Finaluser="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			username = session.getAttribute("username").toString();
			FullName = session.getAttribute("fullname").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			array = new JSONArray();
		System.out.println("listinghtrhrt");
			String str = username + "~" + FullName;
			Query getproject = sessionFactory.getCurrentSession().createQuery(
					"select PRODUCT_NAME from USER_SOFTWARE_MAP where USERNAME ='" + str + "' and STATUS<>'Released'");
			List list = getproject.list();
//			//System.out.println("fghfghaaaaaaaaaaaaaaaaaaaaaaaa"+list.toString());
			for (Object list2 : list) {
				array1 = new JSONArray();
				array1.put(list2);
				array.put(array1);
			}
			// System.out.println("arrau outpiiut"+array);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return array;
	}

	@Override
	public String insertSoftwareRelease(String pid, String approup, String fullname, String compname, String site,
			String department, String phone, String emailid, MultipartFile empPic, String softwarename,
			String applieddate, String description, String assetcode, String typecategory, String AssetCodeDL,
			String Ip_AddressDL, String StatusDL, String computerNameDL, String server_IP, String server_ownername,
			String server_hostname) {
		String username = "";
		String Fullname = "";
		String NewTicketID = "";
		int id = 0;
		String status = "";
		String ticketTag = "";
		String loginRoleType = "";
		String[] split = approup.split("~");
		String appovalname = split[0];
		String approval_fullname = split[1];
		;

		// System.out.println("Inside EFORM DAO IMPl ");
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			username = session.getAttribute("username").toString();
			Fullname = session.getAttribute("fullname").toString();
			loginRoleType = session.getAttribute("role").toString();
		} catch (Exception e) {

		}
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(SOFTWARE_RELEASE.class)
					.setProjection(Projections.max("SRNO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			//// System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//// System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//// System.out.println("IN ELSE SRNO IS: " + id);
			}

			String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());

			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();

			String localDateNow = localdate.format(now);

			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;

			String ext = "";

			String updatedFileName = null;
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			String currenttime = dateFormat.format(date);
			try {

				try {
					String imagefilePath;
					imagefilePath = "C:\\ITHelpDesk\\";
					try {
						File file = new File("C:\\ITHelpDesk\\");
						if (!file.exists()) {
							if (file.mkdir()) {
								//// System.out.println("Directory is created!");
							} else {
								//// System.out.println("Failed to create directory!");
							}
						}
					} catch (Exception e) {
						//// System.out.println("directory create exception" + e);
					}

					String fileName = empPic.getOriginalFilename();
					ext = FilenameUtils.getExtension(fileName);
					
//	                File uploadedFile =  empPic;
//					File uploadedFile = new File(empPic.getOriginalFilename());
					File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					uploadedFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(uploadedFile);
					fos.write(empPic.getBytes());
					fos.close();

//					String fileName = empPic.getOriginalFilename();
//					ext = FilenameUtils.getExtension(fileName);


					// File destFile = new File(imagefilePath + File.separator + fileName);
//					File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);

					updatedFileName = createnewfilename + "." + ext;


//					try {
//
//						FileUtils.copyFile(uploadedFile, destFile);
//						File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//						FileInputStream fis = new FileInputStream(filee);
//					} catch (IOException ex) {
//						//// System.out.println("Could not copy file " + fileName);
//						status = "error";
//						ex.printStackTrace();
//					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery(
						"from ticket_tag_master where COMPANY='" + compname + "' and DEPARTMENT='" + department + "'")
						.list();
				for (ticket_tag_master sourceDrive : tagList) {
					ticketTag = sourceDrive.getTICKET_TAG();
				}
				NewTicketID = ticketTag + "EF-" + id;
				SOFTWARE_RELEASE sr = new SOFTWARE_RELEASE();
				sr.setT_ID(NewTicketID);
				sr.setT_REQUESTER(username);
				sr.setT_REQUESTER_FULLNAME(Fullname);
				sr.setRAISED_DATE(currenttime);
				sr.setSRNO(id);
				sr.setT_COMPANY(compname);
				sr.setT_BRANCH(site);
				sr.setT_DEPARTMENT(department);
				sr.setEMAIL_ID(emailid);
				sr.setPID(pid);
				sr.setT_PHONE(phone);
				sr.setASSET_CODE(assetcode);
				sr.setS_NAME(softwarename);
				sr.setAPPLIED_DATE(applieddate);
				sr.setT_DESC(description);
				sr.setPRIORITY("P5");
				sr.setSEVERITY("Medium");
				sr.setSERVER_HOST(server_hostname);
				sr.setSERVER_IP(server_IP);
				sr.setSERVER_OWNER(server_ownername);
				sr.setLAP_DESK_ASSET_CODE(AssetCodeDL);
				sr.setLAP_DESK_COMPUTER_NAME(computerNameDL);
				sr.setREQUEST_CATEGORY(typecategory);
				sr.setLAP_DESK_IP(Ip_AddressDL);
				sr.setAPPROVAR_NAME(appovalname);
				sr.setAPPROVAR_NAME_FULLNAME(approval_fullname);

				sr.setLAP_DESK_STATUS(StatusDL);
				// sr.setGROUPNAME("IT Compliance");
				sr.setSTATUS("Pending For Managers Approval");
				if (updatedFileName == null) {
					sr.setATTACH_NAME("No File Available");
				} else {
					sr.setATTACH_NAME(updatedFileName);
				}
				sessionFactory.getCurrentSession().persist(sr);
				status = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			int sno = 0;
			try {
				Criteria crittt = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno11 = (Integer) crittt.uniqueResult();
				// System.out.println(" SNO IS: " + srno1);
				if (srno11 != null) {
					sno = srno11.intValue();
					sno = sno + 1;
					// System.out.println("IN IF SNO IS: " + sno);
				} else {
					sno = 1;
					// System.out.println("IN ELSE SNO IS: " + sno);
				}
			} catch (Exception e) {

				e.printStackTrace();
				// System.out.println(e);
			}
//		String loginMasterData = getLoginMasterData();

			String msg = null;

//			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
//					+ "<tr><td>Status:</td><td>Approval For Manager</td></tr>" + "<tr><td>Raised By:</td><td>"
//					+ username + "  [" + fullname + "]</td></tr>";
			
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
			"<tr><td>Status:</td><td>Approval For Manager</td></tr>" + "<tr><td>Raised By:</td><td>" + username + "  [" + fullname + "]</td></tr>"
					+ "</td></tr>" + "<tr><td>Send To:</td><td>" + appovalname + "  [" + approval_fullname + "]</td></tr>";
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(NewTicketID);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(username);
			tickettrack.setTICKET_TYPE("Software Release");

			tickettrack.setSTATUS("Pending For Managers Approval");
			tickettrack.setPRIORITY("P5");

			tickettrack.setSEVERITY("Medium");
			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(username);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(compname);
			tickettrack.setTICKET_RAISED_BY_COMPANY(compname);

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

			int ActSno = 0;
			try {

				try {

					Criteria critt = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
							.setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) critt.uniqueResult();

					// System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						// System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						// System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
// TODO Auto-generated catch block
					e.printStackTrace();
					// System.out.println(e);
				}

				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(NewTicketID);
				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSTATUS("Pending For Managers Approval");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(username);
				ticketActivityLog.setTICKET_TYPE("Software Release");
				ticketActivityLog.setT_DESC(description);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setCHANGE_NOTES1(description);

				ticketActivityLog.setSEVERITY("Medium");
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

			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(NewTicketID, "Pending For Managers Approval");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return status + "," + NewTicketID;
	}

	@Override
	public JSONArray getUserReleaseRequestList() {

		// System.out.println("Inside EFORm Activity Dao Impl ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_RELEASE where T_REQUESTER='"
				+ loginuser + "' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
		List<SOFTWARE_RELEASE> req = query.list();
		for (SOFTWARE_RELEASE sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put(sourceDrive.getT_ID());
//			if(sourceDrive.getSTATUS().equals("Resolved"))
//			{
//				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}
//			else
//			{
//				array.put(" ");
//			}
			if (sourceDrive.getSTATUS().equals("Rejected By IT Compliance")
					|| sourceDrive.getSTATUS().equals("Rejected By Manager")
					|| sourceDrive.getSTATUS().equals("Rejected")) {
				array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put(" ");
			}
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_DATE());

			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRT_APPROVAL());
			array.put(sourceDrive.getRT_APPROVAL_FULLNAME());
			array.put(sourceDrive.getRT_APPROVAL_DATE());

//			array.put(sourceDrive.getCLOSED_BY());
//			array.put(sourceDrive.getCLOSED_BY_FULLNAME());
//			array.put(sourceDrive.getRE_OPENED_BY());
//			array.put(sourceDrive.getRE_OPENED_BY_FULLNAME());
//			
//			
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
//			array.put(sourceDrive.getRT_APPROVAL_DATE());
//			array.put(sourceDrive.getCLOSED_DATE());
//			array.put(sourceDrive.getRE_OPENED_DATE());
			array1.put(array);
		}
		return array1;

	}

	@Override
	public JSONArray gatherSoftwareReleaseDetails(String id, String type) {

		// System.out.println("Inside TPActivityDaoImpl gatherSoftwareReleaseDetails
		// method");

		JSONArray array1 = null;
		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}

		try {

			List<SOFTWARE_RELEASE> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_RELEASE where T_ID='" + id + "' ").list();

			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();

			array1 = new JSONArray();
			for (SOFTWARE_RELEASE ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {

					JSONObject arrayobj = new JSONObject();

					arrayobj.put("PID", ticketDrive.getPID());
					arrayobj.put("REQUEST_CATEGORY", ticketDrive.getREQUEST_CATEGORY());
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME", ticketDrive.getT_REQUESTER_FULLNAME());
					arrayobj.put("COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", ticketDrive.getT_DEPARTMENT());
					arrayobj.put("EMAIL", ticketDrive.getEMAIL_ID());
					arrayobj.put("PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("T_ID", ticketDrive.getT_ID());
					arrayobj.put("P_ID", ticketDrive.getPID());
					arrayobj.put("APPLIEDDATE", ticketDrive.getAPPLIED_DATE());
					arrayobj.put("ASSETCODE", ticketDrive.getASSET_CODE());
					arrayobj.put("DESC", ticketDrive.getT_DESC());
					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("STATUS", ticketDrive.getSTATUS());
					arrayobj.put("SNAME", ticketDrive.getS_NAME());

					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());

					arrayobj.put("APPLIEDDATE", ticketDrive.getAPPLIED_DATE());
					arrayobj.put("ASSETCODE", ticketDrive.getASSET_CODE());
					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());

					arrayobj.put("LAP_DES_ASSET_CODE", ticketDrive.getLAP_DESK_ASSET_CODE());
					arrayobj.put("LAP_DESK_COMPUTER_NAME", ticketDrive.getLAP_DESK_COMPUTER_NAME());
					arrayobj.put("LAP_DESK_IP", ticketDrive.getLAP_DESK_IP());
					arrayobj.put("LAP_DESK_STATUS", ticketDrive.getLAP_DESK_STATUS());

					arrayobj.put("REQUEST_CATEGORY", ticketDrive.getREQUEST_CATEGORY());
					arrayobj.put("SERVER_HOST", ticketDrive.getSERVER_HOST());
					arrayobj.put("SERVER_IP", ticketDrive.getSERVER_IP());
					arrayobj.put("SERVER_OWNER", ticketDrive.getSERVER_OWNER());
					String AttachName = ticketDrive.getATTACH_NAME();
					try {
						if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
							arrayobj.put("T_ATTACH_NAME", "No File Available");
							//// System.out.println("Null object found");
						} else {
							arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());

						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//// System.out.println("IN CATCH BLOCK");
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						e.printStackTrace();
					}
					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER()
									+ "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster t_requesrterdetailsnew : t_requesrterdetails) {

						arrayobj.put("SUB_DEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("LOCATION", t_requesrterdetailsnew.getLOCATION());

					}
					array1.put(arrayobj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}

	@Override
	public JSONArray getPendingSoftwareRelease() {
		// System.out.println("INSIDE EFORM DAOI MPL GETPENDINGSOFTWARERELEASE");
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;

		List<SOFTWARE_RELEASE> listOfPdngRequest = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_RELEASE where GROUPNAME='IT Compliance' and STATUS='Approval For IT Compliance' order by STR_TO_DATE(RAISED_DATE ,'%d-%m-%Y %H:%i:%s') desc")
				.list();
		array1 = new JSONArray();
		for (SOFTWARE_RELEASE sourceDrive : listOfPdngRequest) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);
		}
		return array1;
	}

	@Override
	public JSONArray getReleaseActivityLog(String ticketid) {

		//// System.out.println("Inside UserActivityDaoImpl getUserTicketTracking
		//// method");
		JSONArray array = new JSONArray();
		try {
			Query queryticketActivity = sessionFactory.getCurrentSession().createQuery(
					"from EFORM_ACTIVITY_LOG where T_ID=:T_ID and TICKET_TYPE='Software Release' order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
			queryticketActivity.setParameter("T_ID", ticketid);
			List<EFORM_ACTIVITY_LOG> ticketActivity = queryticketActivity.list();
			for (EFORM_ACTIVITY_LOG sourceDrive : ticketActivity) {
				JSONObject arrayobjtemp = new JSONObject();
				arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
				arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
				arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
				arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
				arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
				arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
				arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
				arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
				arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
				arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//				arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//				arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//				arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
				arrayobjtemp.put("FULLNAME", sourceDrive.getT_FULLNAME());
				arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
				array.put(arrayobjtemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;

	}

	@Override
	public String InsertReleaseRequestAppByItCompliance(String appByITComp, String Status, String approvenote,
			MultipartFile empPic, String companyRaisedBy, String raisedByName, String tid, String Request_category) {
		// System.out.println("inside InsertReleaseRequestAppByItCompliance dao impl");
		int id = 0;

		String status = "";
		String FullNameOfLogin = "";
//	String CurrentStatus="Approved";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//	String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//	createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
		String Group_Name = null;
		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (Request_category.equals("Server")) {
			Group_Name = "NT Admin";

		} else if (!Request_category.equals("Server")) {
			Group_Name = "Remote Support";
		}
		int executeUpdate=0;
		try {

			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_RELEASE set IT_COMPIANCE_APPROVAL_NAME=:IT_COMPIANCE_APPROVAL_NAME,IT_COMPIANCE_APPROVAL_NAME_FULLNAME='"
							+ FullNameOfLogin
							+ "',IT_COMPIANCE_APPROVAL_DATE=:IT_COMPIANCE_APPROVAL_DATE,STATUS=:STATUS,IT_COMPIANCE_APPROVAL_DESC=:IT_COMPIANCE_APPROVAL_DESC,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_NAME", appByITComp);
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DESC", approvenote);
			updatesr.setParameter("GROUPNAME", Group_Name);

			updatesr.setParameter("T_ID", tid);

			 executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		int sno = 0;
		if (executeUpdate > 0) {
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String[] split = Status.split(" ");
		String approve = split[0];
		String msg = null;
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + approve + " By:</td><td>" + appByITComp + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();
		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setPRIORITY("P4");
		tickettrack.setSEVERITY("Medium");
		tickettrack.setTICKET_TYPE("Software Release");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);
		status = "success";
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
//TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(appByITComp);
			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setPRIORITY("P3");
			ticketActivityLog.setSEVERITY("Medium");
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Release");
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return status + "~" + tid;
	}

	@Override
	public JSONArray getReleaseSoftwareInTc() {
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_RELEASE where GROUPNAME='Remote Support' and REQUEST_CATEGORY<>'Server' and STATUS in('Approved By IT Compliance','Hold')ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_RELEASE> req = query.list();
		for (SOFTWARE_RELEASE sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			if (sourceDrive.getSTATUS().equals("Approved By IT Compliance") || sourceDrive.getSTATUS().equals("Hold")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");

			} else if (sourceDrive.getSTATUS().equals("Released")) {
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());// array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());

			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
//			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);
		}
		return array1;

	}

	@Override
	public JSONArray getPendingSoftwareReqauestInEng() {

//		//System.out.println("sdfdffdsf inside getPendingSoftwareReqauestInEng");
		JSONArray array = null;
		String loginuser = "";
		String company = "";

		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='NT Admin' and  CATEGORY_REQUEST='Server' and (STATUS  ='Approved By It Compliance' or STATUS='Approved By Mail Admin'  or(STATUS='Hold' and RT_APPROVAL='"
						+ loginuser
						+ "' )) ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Approved By It Compliance") || sourceDrive.getSTATUS().equals("Hold")||sourceDrive.getSTATUS().equals("Approved By Mail Admin")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
//			else {
//				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray getWorkInProgressInEng() {

//		//System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='NT Admin' and STATUS in('Work in Progress','Resolved')  ORDER bY STR_TO_DATE(RT_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Work in Progress")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else if(sourceDrive.getSTATUS().equals("Resolved")){
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
			else 
			{
				array.put(" ");
			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;
	}

	@Override
	public String InsertReleseRequestByRemotSupport(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese, String requestcatassign) {
		// TODO Auto-generated method stub
		// System.out.println("controller calling software relese method DAOlmpl start
		// point");
		int id = 0;
		String status = "";
		String FullNameOfLogin = "";
//		String CurrentStatus="Approved";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);

			// System.out.println("controller calling software relese method DAOlmpl middle
			// point select phone, email");
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String groupName = "";
			if (requestcatassign.equals("Server")) {
				groupName = "NT Admin";
			} else {
				groupName = "Remote Support";
			}
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_RELEASE set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,RT_APPROVAL_FULLNAME=:RT_APPROVAL_FULLNAME,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", statusR);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", note);
			updatesr.setParameter("GROUPNAME", groupName);
			updatesr.setParameter("RT_APPROVAL_FULLNAME", FullNameOfLogin);

			updatesr.setParameter("T_ID", reqid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status.equals("success")) {
			int sno = 0;
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) crit.uniqueResult();

//			//System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					sno = srno1.intValue();
					sno = sno + 1;
					// System.out.println("IN IF SNO IS: " + sno);
				} else {
					sno = 1;
					// System.out.println("IN ELSE SNO IS: " + sno);
				}
			} catch (Exception e) {

				e.printStackTrace();
				// System.out.println(e);
			}
			String msg = null;
			if (statusR.equals("Hold")) {
				String[] StatusSplit = statusR.split(" ");

				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + statusR
						+ "</td></tr>" + "<tr><td>" + StatusSplit[0] + " By:</td><td>" + loginuser + "  ["
						+ FullNameOfLogin + "]</td></tr>";

			} else {
				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + statusR
						+ "</td></tr>" + "<tr><td>WIP By:</td><td>" + loginuser + "  [" + FullNameOfLogin
						+ "]</td></tr>";
			}
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();
			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(reqid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);

			tickettrack.setSTATUS(statusR);

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(raisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
			tickettrack.setPRIORITY("P3");
			tickettrack.setSEVERITY("Medium");
			tickettrack.setTICKET_TYPE("Software Release");

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);
			status = "success";
			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

			int ActSno = 0;
			try {
				try {

					// System.out.println("controller calling software relese method DAOlmpl middle
					// tracking point");

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
							.setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					// System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						// System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						// System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// System.out.println(e);
				}

				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(reqid);
				ticketActivityLog.setSTATUS(statusR);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginuser);
				ticketActivityLog.setT_DESC(note);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setCHANGE_NOTES1(note);
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setPRIORITY("P3");
				ticketActivityLog.setSEVERITY("Medium");
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
				ticketActivityLog.setTICKET_TYPE("Software Release");
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				status = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(reqid, statusR);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
return status + "~" + reqid;
	}

	@Override
	public JSONArray getPendingSoftwareReqauestforMailAdmin() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_REQUEST where GROUPNAME='Mail Admin' and STATUS='Approved By It Compliance'   ORDER BY STR_TO_DATE(APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_REQUEST> req = query.list();
		for (SOFTWARE_REQUEST sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);
		}
		return array1;

	}

	@Override
	public String InsertRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
			String requestcategory, MultipartFile empPic, String softwarename, String companyRaisedBy,
			String raisedByName, String ticketid) {
		int id = 0;
		String status = "";
		String FullNameOfLogin = "";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String groupName= "";
		

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();

			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
//				Query createQuery = sessionFactory.getCurrentSession().createQuery("select T_REQUESTER,"
//						+ "T_REQUESTER_FULLNAME,ASSET_NAME,ASSET_NAME_CR, SERVER_HOSTORCODE,P_ID from SOFTWARE_REQUEST where T_ID='"+ticketid+"'");
//				List<Object[]> list2 = createQuery.list();
//				for(Object[] sl:list2)
//				{
//					RaisedBy=sl[0].toString();
//					raisedByFullName=sl[1].toString();
//					Asset_NameITAM=sl[2].toString();
//					Asset_NameCustom=sl[3].toString();
//					Server_assetName=sl[4].toString();
//					Pid=sl[5].toString();
//				}				

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		//System.out.println("HIIII"+requestcategory);
		if(requestcategory.equals("Server"))
		{
			groupName="NT Admin";
		
		}
		else
		{
			groupName="Remote Support";
		}
		try

		{
			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_REQUEST set ML_APPROVAR=:ML_APPROVAR,ML_APPROVAR_FULLNAME='"
							+ FullNameOfLogin
							+ "',ML_APPROVAR_DATE=:ML_APPROVAR_DATE,STATUS=:STATUS,ML_APPROVAR_NOTE=:ML_APPROVAR_NOTE,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("ML_APPROVAR", loginuser);
			updatesr.setParameter("ML_APPROVAR_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("ML_APPROVAR_NOTE", approvenote);
			updatesr.setParameter("GROUPNAME", groupName);
			updatesr.setParameter("T_ID", ticketid);

			updatesr.setParameter("T_ID", ticketid);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
//					if(Status.equals("Resolved")) {
//						int sno=0;
//						try {
//							Criteria crit = sessionFactory.getCurrentSession().createCriteria(USER_SOFTWARE_MAP.class)
//									.setProjection(Projections.max("SRNO"));
//							Integer srno1 = (Integer) crit.uniqueResult();
//							if (srno1 != null) {
//								sno = srno1.intValue();
//								sno = sno + 1;
//								//System.out.println("IN IF SNO IS: " + sno);
//							} else {
//								sno = 1;
//								//System.out.println("IN ELSE SNO IS: " + sno);
//							}
//						} catch (Exception e) {
//
//							e.printStackTrace();
//							//System.out.println(e);
//						}
//						USER_SOFTWARE_MAP mp=new USER_SOFTWARE_MAP();
//						mp.setUSERNAME(RaisedBy+"~"+raisedByFullName);
//						mp.setAPPLIED_DATE(currenttime);
//						mp.setPRODUCT_NAME(softwarename);
//						mp.setPROJECT_ID(Pid);
//						mp.setSTATUS("NA");
//						if(requestcategory.equals("Server"))
//						{
//							mp.setASSET_CODE(Server_assetName);
//						}
//						else if(!requestcategory.equals("Server"))
//						{
//							if(Asset_NameCustom.equals(Asset_NameITAM))
//							{
//								mp.setASSET_CODE(Asset_NameITAM);
//							}
//							else if(!Asset_NameCustom.equals(Asset_NameITAM))
//							{
//								mp.setASSET_CODE(Asset_NameCustom);
//							}
//						}
//						mp.setSRNO(sno);
//						sessionFactory.getCurrentSession().save(mp);
//						
//					}
			} else {
				status = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		if (status.equals("success")) {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) crit.uniqueResult();

				// System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					sno = srno1.intValue();
					sno = sno + 1;
					// System.out.println("IN IF SNO IS: " + sno);
				} else {
					sno = 1;
					// System.out.println("IN ELSE SNO IS: " + sno);
				}
			} catch (Exception e) {

				e.printStackTrace();
				// System.out.println(e);
			}

			String msg = null;
			String[] split = Status.split(" ");
			String approvalStatus = split[0];
			
			//msg for Approve 
			if(Status.equals("Approved By Mail Admin")) 
			{
				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" +
						"<tr><td>Status:</td><td>" + Status+ "</td></tr>" + 
						"<tr><td>" + approvalStatus + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin+ "]</td></tr>" +
						"<tr><td>Send To:</td><td>Group</td></tr>" +
						"<tr><td>Group Name:</td><td>" + groupName + "</td></tr>";
				
				
			}
			//msg for Reject
			else
			{
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + 
			"<tr><td>Status:</td><td>Rejected By Mail Admin</td></tr>" + 
			"<tr><td>Mail Admin Name:</td><td>" + loginuser + "  [" + FullNameOfLogin+ "]</td></tr>";
			}
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(ticketid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);

			tickettrack.setSTATUS(Status);

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(raisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setTICKET_TYPE("Software Request");

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

			int ActSno = 0;
			try {
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
							.setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit.uniqueResult();

					// System.out.println(" actSrno1 IS: " + actSrno1);

					if (actSrno1 != null) {
						ActSno = actSrno1.intValue();
						ActSno = ActSno + 1;
						// System.out.println("IN IF ActSno IS: " + ActSno);
					} else {
						ActSno = 1;
						// System.out.println("IN ELSE ActSno IS: " + ActSno);
					}
				} catch (Exception e) {
// TODO Auto-generated catch block
					e.printStackTrace();
					// System.out.println(e);
				}

				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(ticketid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginuser);
				ticketActivityLog.setTICKET_TYPE("Software Request");
				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setROLE_TYPE(loginRoleType);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");

				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);

				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
try {

			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		return status + "~" + ticketid;

	}

	@Override
	public String insertSoftwareTransferRequest(String fullname, String compname, String site, String department,
			String phone, String emailid, MultipartFile empPic, String pid, String approup, String softwarename,
			String approup2, String appliedDate, String assetCode, String actionType, String toEmployee,
			String newassetCode, String new_AppliedDate, String typecategory, String description, String assetname,
			String ip, String st, String ipaddress, String ownername, String hostname, String computername,
			String from_asset) {

		// System.out.println("appoval"+approup);
//		//System.out.println("shostname"+hostname+"dfgfdgdgfggfg =assetnaem"+assetname+"dd ip=="+ip+"st =="
//				+st+"fggfffg"+ipaddress+"ownfer name"+ownername+"fgff======hoisatname"+hostname+
//				"sssssssssssssssssssssssssssssstype category"+typecategory);
		int id = 0;
		String status = "";
		String ticketTag = "";
		String NewTicketID = "";
		String[] split = approup.split("~");
		String appovalname = split[0];
		// System.out.println("appovalname"+appovalname);
		// System.out.println("appoval"+approup);
		String approval_fullname = split[1];
		String Status = "Pending For Managers Approval";
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(SOFTWARE_TRANSFER.class)
					.setProjection(Projections.max("SRNO"));
			Integer srno1 = (Integer) crit.uniqueResult();
			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//// System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//// System.out.println("IN ELSE SRNO IS: " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());

		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();

		String localDateNow = localdate.format(now);

		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			String string = session.getAttribute("GROUP").toString();
//			//System.out.println("group namme is dfdfed "+string);
			Date currentdate = dateFormat.parse(currenttime);

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
						} else {
						}
					}
				} catch (Exception e) {

				}

				String fileName = empPic.getOriginalFilename();
				ext = FilenameUtils.getExtension(fileName);
				
				File uploadedFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();

//				String fileName = empPic.getOriginalFilename();
//				ext = FilenameUtils.getExtension(fileName);


//				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);

				updatedFileName = createnewfilename + "." + ext;


//				try {
//
//					FileUtils.copyFile(uploadedFile, destFile);
//					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					FileInputStream fis = new FileInputStream(filee);
//				} catch (IOException ex) {
//					//// System.out.println("Could not copy file " + fileName);
//					status = "error";
//					ex.printStackTrace();
//				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery(
					"from ticket_tag_master where COMPANY='" + compname + "' and DEPARTMENT='" + department + "'")
					.list();
			for (ticket_tag_master sourceDrive : tagList) {
				ticketTag = sourceDrive.getTICKET_TAG();
			}
			NewTicketID = ticketTag + "EF-" + id;
			SOFTWARE_TRANSFER sr = new SOFTWARE_TRANSFER();

			sr.setT_ID(NewTicketID);
			sr.setT_REQUESTER(loginuser);
			sr.setT_REQUESTER_FULLNAME(fullname);
			sr.setRAISED_DATE(currenttime);
			sr.setSRNO(id);
			sr.setT_COMPANY(compname);
			sr.setT_BRANCH(site);
			sr.setT_DEPARTMENT(department);
			sr.setEMAIL_ID(emailid);
			sr.setT_PHONE(phone);
			sr.setP_ID(pid);
			sr.setS_NAME(softwarename);
			sr.setAPPROVAR_NAME(appovalname);
			sr.setAPPROVAR_NAME_FULLNAME(approval_fullname);
			sr.setREQUEST_CATREGORY(typecategory);
			String[] split3 = from_asset.split("~");
			String loginasset = split3[0];
			sr.setCURRENT_USER_ASSET(loginasset);
			if (typecategory.equals("Server")) {
				sr.setSERVER_IP(ipaddress);
				sr.setSERVER_HOST_CODE(hostname);
				sr.setSERVER_OWNER(ownername);
				sr.setASSET_NAME_CR("NA");
				sr.setASSET_STATUS_CR("NA");
				sr.setLAPTOP_IP_CR("NA");
				;
				sr.setCOMPUTER_NAME_CR("NA");
			} else if (!typecategory.equals("Server")) {
				sr.setSERVER_IP("NA");
				sr.setSERVER_HOST_CODE("NA");
				sr.setSERVER_OWNER("NA");
				sr.setASSET_NAME_CR(assetname);
				sr.setASSET_STATUS_CR(ip);
				sr.setLAPTOP_IP_CR(st);
				sr.setCOMPUTER_NAME_CR(computername);
			}

			sr.setDESCRIPTION(description);
			sr.setSTATUS(Status);
			sr.setPRIORITY("P5");
			sr.setSEVERITY("Information");
			sr.setCATEGORY_REQUEST(actionType);
			String[] split2 = toEmployee.split("~");
			sr.setTO_EMPLOYEE(split2[0]);

			String[] split4 = newassetCode.split("~");
			String touserassetname = split4[0];
//			//System.out.println("newasset aid "+touserassetname);
			sr.setNEW_ASSET_CODE(touserassetname);
			sr.setNEW_ASSET_DATE(new_AppliedDate);

//				sr.setASSET_NAME_CR("NA");
//				sr.setLAPTOP_IP_CR("NA");
//				sr.setASSET_STATUS_CR("NA");
//				sr.setOWNER_NAME_CR(ownername_cr);
//				sr.setSERVER_IP_CR(ip_cr);
//			}
//			else if(typecategory.equals("Desktop")||typecategory.equals("Laptop"))
//			{
//				sr.setASSET_NAME_CR(assetname_cr);
//				sr.setLAPTOP_IP_CR(ip_cr);
//				sr.setASSET_STATUS_CR(status_cr);
//				sr.setOWNER_NAME_CR("NA");
//				sr.setSERVER_IP_CR("NA");
//			}
			if (updatedFileName == null) {
				sr.setT_ATTACH_NAME("No File Available");
			} else {
				sr.setT_ATTACH_NAME(updatedFileName);
			}
//			//System.out.println("sfgfgfdggfdgd gf g"+updatedFileName);
			sessionFactory.getCurrentSession().persist(sr);
			status = "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		int sno = 0;
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();
			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
//		String loginMasterData = getLoginMasterData();

		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>Raised By:</td><td>" + loginuser + "  [" + fullname + "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(NewTicketID);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);
//		tickettrack.setCATEGORY(category);
//		tickettrack.setSUBCATEGORY1(subCat1);
//		tickettrack.setSUBCATEGORY2(subCat2);
//		tickettrack.setSUBJECT(subject);
		tickettrack.setSTATUS(Status);
		tickettrack.setPRIORITY("P4");
		tickettrack.setTICKET_TYPE("Software Transfer");

		tickettrack.setSEVERITY("Medium");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(loginuser);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(compname);
		tickettrack.setTICKET_RAISED_BY_COMPANY(compname);

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);
		status = "success";
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(NewTicketID);
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
//		ticketActivityLog.setT_SUBJECT(subject);

			ticketActivityLog.setT_DESC(description);
			//// System.out.println("ffdvfdv"+description);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(description);
//		ticketActivityLog.setT_CATEGORY(category);
//		ticketActivityLog.setT_SUB_CATEGORY1(subCat1);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setSEVERITY("Medium");
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
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
try {		
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(NewTicketID, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "," + NewTicketID;
	}

	@Override
	public JSONArray getPendingToApproveTransferRequestByManager() {

		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();

		} catch (Exception e) {

		}
		int srno = 0;
//		//System.out.println("ffffffffffffffffffffffffffffffffffff");
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_TRANSFER where (APPROVAR_NAME='"
				+ loginuser + "' and STATUS in('Pending For Managers Approval','Re-Opened'))or ( TO_EMP_APPROVAR_NAME='"
				+ loginuser
				+ "' and STATUS='Pending For Managers Approval' and GROUPNAME='NA') ORDER bY STR_TO_DATE(RAISED_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);

			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Approval For Manager")||sourceDrive.getSTATUS().equals("Re-Opened")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put(" ");
			}
			if (sourceDrive.getSTATUS().equals("Approved By Manager")) {

				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicketApprovedBy2ndmanager(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put(" ");
			}
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		// System.out.println("arrayadfdaffdfdf"+array1);
		return array1;

	}

	@Override
	public JSONArray gatherTransferSoftwareDetails(String id) {

		//// System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");
//		String db_cname = null;
//		JSONArray array = null;

		JSONArray array1 = null;

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}

		try {
			List<SOFTWARE_TRANSFER> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_TRANSFER where T_ID='" + id + "'").list();

			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();

			array1 = new JSONArray();

			for (SOFTWARE_TRANSFER ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {

					JSONObject arrayobj = new JSONObject();
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME", ticketDrive.getT_REQUESTER_FULLNAME());
					arrayobj.put("COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", ticketDrive.getT_DEPARTMENT());
					arrayobj.put("EMAIL", ticketDrive.getEMAIL_ID());
					arrayobj.put("PID", ticketDrive.getP_ID());
					arrayobj.put("T_ID", ticketDrive.getT_ID());
					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("STATUS", ticketDrive.getSTATUS());

					arrayobj.put("SNAME", ticketDrive.getS_NAME());
					arrayobj.put("NEWASSETCODE", ticketDrive.getNEW_ASSET_CODE());
					arrayobj.put("NEWDATE", ticketDrive.getNEW_ASSET_DATE());
					arrayobj.put("CATREQUEST", ticketDrive.getCATEGORY_REQUEST());
					arrayobj.put("TOEMPLOYEE", ticketDrive.getTO_EMPLOYEE());

					arrayobj.put("CURRENT_UASSET", ticketDrive.getCURRENT_USER_ASSET());
					arrayobj.put("CREQ", ticketDrive.getREQUEST_CATREGORY());
					arrayobj.put("LD_ASSETNAME", ticketDrive.getASSET_NAME_CR());
					arrayobj.put("LD_STATUS", ticketDrive.getASSET_STATUS_CR());
					arrayobj.put("LD_IP", ticketDrive.getLAPTOP_IP_CR());
					arrayobj.put("LD_COPMUTER_NAME", ticketDrive.getCOMPUTER_NAME_CR());
					arrayobj.put("SERVER_HOSTCODE", ticketDrive.getSERVER_HOST_CODE());
					arrayobj.put("SERVER_IP", ticketDrive.getSERVER_IP());
					arrayobj.put("SERVER_OWNER", ticketDrive.getSERVER_OWNER());
					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());

					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());

					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER()
									+ "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster t_requesrterdetailsnew : t_requesrterdetails) {

						arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());

					}
					arrayobj.put("DESC", ticketDrive.getDESCRIPTION());

					array1.put(arrayobj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}

	@Override
	public String InsertTransferRequestApprovedByManager(String appByITComp, String Status, String approvenote,
			MultipartFile empPic, String CompanyRaisedBy, String raisedByName, String tid, String reqcat,
			String toemployee) {

		int id = 0;
		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String GROUP_NAME = null;

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			String toEmpManager = "";
			String toEmpManagerFullName = "";
			String GROUPNAME = "NA";
			if (raisedByName.equals(toemployee)) {
				GROUPNAME = "IT Compliance";
			} else {
				GROUPNAME = "NA";
				if (!Status.equals("Rejected By Manager"))
					
				{
//					System.out.println("dsfvdfvdfvdvg");
//					Query getId = sessionFactory.getCurrentSession()
//							.createSQLQuery("select REPORTING_TO_MANAGER from loginmaster where USERNAME='" + toemployee
//									+ "' and COMPANY='" + company + "'");
//					System.out.println("dsfvdfvdfvdvASDXSg"+getId);
//					List<Object> listOfEngg = getId.list();
//					System.out.println("dsfvdfvdfDFvdvg"+listOfEngg);
//					if (!(listOfEngg == null) && !listOfEngg.get(0).equals("NA")) {
//						for (Object names : listOfEngg) {
//							String manager = names.toString();
//							toEmpManagerFullName = manager.substring(3, manager.indexOf("OU") - 1);
//							Query fullname = sessionFactory.getCurrentSession()
//									.createSQLQuery("select  USERNAME  from loginmaster where FULL_NAME='"
//											+ toEmpManagerFullName + "' and  COMPANY='3i Infotech'");
//							Object fullmgname = fullname.list().get(0);
//							toEmpManager = fullmgname.toString();
//						}
					
//					toEmpManager= "1002805";
//					}
				}
			}

			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_TRANSFER set APPROVAR_NAME=:APPROVAR_NAME,APPROVAR_NAME_FULLNAME=:APPROVAR_NAME_FULLNAME,APPROVAR_DATE=:APPROVAR_DATE,APPROVAL_NOTE=:APPROVAL_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS,TO_EMP_APPROVAR_NAME=:TO_EMP_APPROVAR_NAME,TO_EMP_APPROVAR_NAME_FULLNAME=:TO_EMP_APPROVAR_NAME_FULLNAME where T_ID=:T_ID");
			updatesr.setParameter("APPROVAR_NAME_FULLNAME", FullNameOfLogin);
			updatesr.setParameter("APPROVAR_NAME", loginuser);
			updatesr.setParameter("APPROVAR_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("APPROVAL_NOTE", approvenote);

			updatesr.setParameter("GROUPNAME", GROUPNAME);
			if (GROUPNAME.equals("NA")) {
				// System.out.println("inmside elkse group namew NA");
				updatesr.setParameter("TO_EMP_APPROVAR_NAME", "1002805" );  //toEmpManage
				updatesr.setParameter("TO_EMP_APPROVAR_NAME_FULLNAME", "SHRADDHA DALVI" ); //toEmpManagerFullName
			} else {
				updatesr.setParameter("TO_EMP_APPROVAR_NAME", "NA");
				updatesr.setParameter("TO_EMP_APPROVAR_NAME_FULLNAME", "NA");
			}
			updatesr.setParameter("T_ID", tid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		if(status.equals("success"))
		{
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String msg = null;
		String currStatus = "";
		
		String[] split = Status.split(" ");
		String approve = split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + approve + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);
		tickettrack.setSTATUS(Status);
		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setTICKET_TYPE("Software Transfer");

		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY("3i Infotech");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}
//		String currStatus="";
//		if(Status.equals("Pending Approval By ITCompl"))
//		{
//			currStatus="Approved By Manager";
//		}
//		else
//		{
//			currStatus=Status;
//		}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);

			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);

			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		try {
			
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;
//	
	}

	@Override
	public JSONArray getPendingTransferReqauest() {

//		//System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_TRANSFER where GROUPNAME='IT Compliance' and STATUS='Approved By Manager' or STATUS='Approved By Second Manager' or STATUS='Hold'  ORDER BY STR_TO_DATE(APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray gatherTransferViewDetails(String ticketid) {

		// System.out.println("inside gatherTransferViewDetails");
		JSONArray array = null;
		JSONArray array1 = null;
		String loginuser = null;
		String Company = null;
		String department = "";

		String sub_department = "";
		String location = "";
		String emailId = "";
		String ContactNo = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			Company = session.getAttribute("companyname").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			array = new JSONArray();
			Query getLoginmasterdata = sessionFactory.getCurrentSession()
					.createQuery("from loginmaster where USERNAME='" + loginuser + "' and COMPANY='" + Company + "'");

			Query getData = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_TRANSFER where T_ID='" + ticketid + "'");

			List<SOFTWARE_TRANSFER> list = getData.list();
			for (SOFTWARE_TRANSFER ticketDrive : list) {
				JSONObject arrayobj = new JSONObject();
				Query getDataa = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"
						+ ticketDrive.getT_REQUESTER() + "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'");
				List<loginmaster> listOfuser = getDataa.list();
				for (loginmaster loginDrive : listOfuser) {
					department = loginDrive.getDEPARTMENT();
					sub_department = loginDrive.getSUB_DEPARTMENT();
					location = loginDrive.getLOCATION();
					emailId = loginDrive.getEMAIL();
					ContactNo = loginDrive.getPHONE();
				}
				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);

//				arrayobj.put("ASSETNAME", ticketDrive.getASSET_NAME());		
//				arrayobj.put("ASSETSTATUS", ticketDrive.getASSET_STATUS());
//				arrayobj.put("ASSETCATEGORY", ticketDrive.getCATEGORY());
//				arrayobj.put("ASSETTAG", ticketDrive.getASSET_TAG());
//				arrayobj.put("ASSETSUBCATEGORY", ticketDrive.getSUB_CATEGORY());
//				arrayobj.put("ASSET_IPADDRESS", ticketDrive.getIP_ADDRESS());
				arrayobj.put("CURRENT_UASSET", ticketDrive.getCURRENT_USER_ASSET());
				arrayobj.put("CREQ", ticketDrive.getREQUEST_CATREGORY());
				arrayobj.put("LD_ASSETNAME", ticketDrive.getASSET_NAME_CR());
				arrayobj.put("LD_STATUS", ticketDrive.getASSET_STATUS_CR());
				arrayobj.put("LD_IP", ticketDrive.getLAPTOP_IP_CR());
				arrayobj.put("LD_COPMUTER_NAME", ticketDrive.getCOMPUTER_NAME_CR());
				arrayobj.put("SERVER_HOSTCODE", ticketDrive.getSERVER_HOST_CODE());
				arrayobj.put("SERVER_IP", ticketDrive.getSERVER_IP());
				arrayobj.put("SERVER_OWNER", ticketDrive.getSERVER_OWNER());
				arrayobj.put("RCAT", ticketDrive.getCATEGORY_REQUEST());

				if (emailId.isEmpty() || emailId == null) {
					arrayobj.put("EMAIL", "NA");
				} else {
					arrayobj.put("EMAIL", emailId);
				}
				if (ContactNo.isEmpty() || ContactNo == null) {
					arrayobj.put("PHONE", "NA");
				} else {
					arrayobj.put("PHONE", ContactNo);
				}
				arrayobj.put("T_ID", ticketDrive.getT_ID());
				arrayobj.put("STATUS", ticketDrive.getSTATUS());
				arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
				arrayobj.put("P_ID", ticketDrive.getP_ID());
				arrayobj.put("SOFTWARE_NAME", ticketDrive.getS_NAME());
				arrayobj.put("NEW_ASSSET", ticketDrive.getNEW_ASSET_CODE());

				arrayobj.put("NEW_DATE", ticketDrive.getNEW_ASSET_DATE());

				arrayobj.put("CATEGORY_REQUEST", ticketDrive.getCATEGORY_REQUEST());
				arrayobj.put("CURRENT_USER_ASSET", ticketDrive.getCURRENT_USER_ASSET());
				arrayobj.put("TO_EMP", ticketDrive.getTO_EMPLOYEE());
				arrayobj.put("DESC", ticketDrive.getDESCRIPTION());
				String AttachName = ticketDrive.getT_ATTACH_NAME();
				// System.out.println("Attachement name"+AttachName);
				try {
					if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						//// System.out.println("Null object found");
					} else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getT_ATTACH_NAME());
						//// System.out.println("Object found");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//// System.out.println("IN CATCH BLOCK");
//					arrayobj.put("T_ATTACH1_NAME", "No File Available");
					e.printStackTrace();
				}
				array.put(arrayobj);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return array;

	}

	@Override
	public String InsertTransferRequestByItCompliance(String appByITComp, String Status, String approvenote,
			String requestcategory, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String tid, String licensekey, String reqcat) {

		int id = 0;

		String status = "";
		String FullNameOfLogin = "";
		String GROUP_NAME = "";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();

			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		int executeUpdate=0;
//		//System.out.println("HIIII"+requestcategory);
		try {

			if (Status.equals("Approved By It Compliance") && reqcat.equals("Server")) {
				GROUP_NAME = "NT Admin";
			} else if (Status.equals("Approved By It Compliance") && !reqcat.equals("Server")) {
				GROUP_NAME = "Remote Support";
			}
//			//System.out.println("licencse key"+licensekey);
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_TRANSFER set IT_COMPIANCE_APPROVAL_NAME=:IT_COMPIANCE_APPROVAL_NAME,IT_COMPIANCE_APPROVAL_NAME_FULLNAME='"
							+ FullNameOfLogin
							+ "',IT_COMPIANCE_APPROVAL_DATE=:IT_COMPIANCE_APPROVAL_DATE,STATUS=:STATUS,IT_COMPIANCE_APPROVAL_DESC=:IT_COMPIANCE_APPROVAL_DESC,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_NAME", loginuser);

			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("IT_COMPIANCE_APPROVAL_DESC", approvenote);
			updatesr.setParameter("GROUPNAME", GROUP_NAME);

			updatesr.setParameter("T_ID", tid);
			 executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int sno = 0;
		if(executeUpdate>0) {
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}

		String msg = null;
		String[] split = Status.split(" ");
		String approvalStatus = split[0];
		String currentStatus = "";

		if (Status.equals("Pending Approval By RMT Support")) {
			currentStatus = "Approved By IT Compliance";
		} else {
			currentStatus = Status;
		}
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + currentStatus
				+ "</td></tr>" + "<tr><td>" + approvalStatus + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setTICKET_TYPE("Software Transfer");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);

			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);

			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		return status + "~" + tid;

	}

	@Override
	public JSONArray getUserTransferList() {

		// System.out.println("Inside EFORm Activity Dao Impl ");
		JSONArray array = null;
		String loginuser = "";
		String loginUSerGroup = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginUSerGroup = session.getAttribute("GROUP").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		String currentGroup = "Mail Admin";
		String mailAdminvar = "NA";
		if (!loginUSerGroup.equals("NA")) {
			if (loginUSerGroup.contains(currentGroup)) {
				mailAdminvar = currentGroup;
			}
		} else {
			mailAdminvar = "NA";
		}

		if (mailAdminvar.equals("Mail Admin")) {

			Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_TRANSFER where T_REQUESTER='"
					+ loginuser
					+ "'or  S_NAME like'%Microsoft Office%' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
			List<SOFTWARE_TRANSFER> req = query.list();
			for (SOFTWARE_TRANSFER sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(sourceDrive.getT_ID());
//				getUserTransferList
				if ( sourceDrive.getSTATUS().equals("Rejected By It Compliance")||
						
						 sourceDrive.getSTATUS().equals("Rejected By Second Manager")
						|| sourceDrive.getSTATUS().equals("Rejected")) {

					array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					array.put(" ");
				}
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getTO_EMP_APPROVAR_NAME());
				array.put(sourceDrive.getTO_EMP_APPROVAR_NAME_FULLNAME());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
				array.put(sourceDrive.getRT_APPROVAL());
				array.put(sourceDrive.getRT_APPROVAL_FULLNAME());
				array.put(sourceDrive.getCLOSED_BY());
				array.put(sourceDrive.getCLOSED_BY_FULLNAME());
				array.put(sourceDrive.getRE_OPENED_BY());
				array.put(sourceDrive.getRE_OPENED_BY_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
				array.put(sourceDrive.getAPPROVAR_DATE());
				array.put(sourceDrive.getTO_EMP_APPROVAR_DATE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRT_APPROVAL_DATE());
				array.put(sourceDrive.getCLOSED_DATE());
				array.put(sourceDrive.getRE_OPENED_DATE());
				array1.put(array);
			}

		} else {
			Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_TRANSFER where T_REQUESTER='"
					+ loginuser + "' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
			List<SOFTWARE_TRANSFER> req = query.list();
			for (SOFTWARE_TRANSFER sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(sourceDrive.getT_ID());
//				if(sourceDrive.getS_NAME().contains("Microsoft Office"))
//				{
//					array.put(sourceDrive.getS_NAME());
//				}
//				else
//				{
//					array.put(" ");
//				}
				if (sourceDrive.getSTATUS().equals("Rejected By It Compliance")
						|| sourceDrive.getSTATUS().equals("Rejected By Manager")
						|| sourceDrive.getSTATUS().equals("Rejected")) {
					array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					array.put(" ");
				}
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
				array.put(sourceDrive.getRT_APPROVAL());
				array.put(sourceDrive.getRT_APPROVAL_FULLNAME());
				array.put(sourceDrive.getCLOSED_BY());
				array.put(sourceDrive.getCLOSED_BY_FULLNAME());
				array.put(sourceDrive.getRE_OPENED_BY());
				array.put(sourceDrive.getRE_OPENED_BY_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
				array.put(sourceDrive.getAPPROVAR_DATE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRT_APPROVAL_DATE());
				array.put(sourceDrive.getCLOSED_DATE());
				array.put(sourceDrive.getRE_OPENED_DATE());
				array1.put(array);
			}

		}

		return array1;

	}

	@Override
	public JSONArray getPendingSoftwareTransferInTc() {

		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_TRANSFER where GROUPNAME='Remote Support' and STATUS  ='Approved By It Compliance' or(STATUS='Hold' and RT_APPROVAL='"
						+ loginuser + "') ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Approved By It Compliance") || sourceDrive.getSTATUS().equals("Hold")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put(" ");
			}
//			else {
//				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public String InsertTransferRequestApprovedByRemotSupport(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String tid, String requestCartegory) {

		int id = 0;

		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String AssignGroup = "Remote Support";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
//			String LoginFullName="";

			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
//				//System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

//			//System.out.println("FDullanrme "+FullNameOfLogin);
//			String approvalName, MultipartFile empPic,
			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_TRANSFER set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_FULLNAME='"
							+ FullNameOfLogin
							+ "',RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("GROUPNAME", AssignGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", approvenote);
			updatesr.setParameter("T_ID", tid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
//					//System.out.println("insidew suvvess");
				status = "success";
			} else {
//					//System.out.println("|inisdeis eeorre");
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		if(status.equals("success"))
		{
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}

		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + Status + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setTICKET_TYPE("Software Transfer");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(appByITComp);
			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");

			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
try {	
			if(status.equals("success"))
				//System.out.println("Statudd sd sd "+Status);
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getWorkInProgressTransferInTc() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_TRANSFER where GROUPNAME='Remote Support' and STATUS in('Work in Progress','Resolved')  ORDER bY STR_TO_DATE(RT_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Work in Progress")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public String InsertTransferRequestApprovedByRT(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String tid, String requestCartegory) {
		// System.out.println("inside dsao u=impl ");

		int id = 0;

		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String AssignGroup = "Remote Support";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
//			String LoginFullName="";

			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
//				//System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			System.out.println("FDullanrme "+FullNameOfLogin);
//			String approvalName, MultipartFile empPic,

			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_TRANSFER set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_FULLNAME='"
							+ FullNameOfLogin
							+ "',RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("GROUPNAME", AssignGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", approvenote);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			}

			else {
				status = "error";
			}
			// System.out.println("sfgfgsdfgfgf"+Status);
			if (Status.equals("Resolved")) {
				//////////////// DATA FROM SOFTWARFE TRANSFER START////////
				// System.out.println("inside success and update usm");
				String software_name = "";
				String AssetCode = "";
				String newAppdate = "";
				String TransferEmp = "";
				Query getTdata = sessionFactory.getCurrentSession().createSQLQuery(
						"select S_NAME,NEW_ASSET_CODE,NEW_ASSET_DATE,TO_EMPLOYEE from SOFTWARE_TRANSFER where T_ID='"
								+ tid + "'");
				List<Object[]> list = getTdata.list();
				for (Object[] obj : list) {
					software_name = obj[0].toString();
					AssetCode = obj[1].toString();
					newAppdate = obj[2].toString();
					TransferEmp = obj[3].toString();
				}
				//////////////// DATA FROM SOFTWARFE TRANSFER END/////////
				 System.out.println("IN ELSE SNO IS: ");
				List FULLNAMEOFTE = sessionFactory.getCurrentSession()
						.createSQLQuery("select FULL_NAME from loginmaster where USERNAME='" + TransferEmp
								+ "'and COMPANY='3i Infotech'")
						.list();
				String FullName = FULLNAMEOFTE.get(0).toString();
//				String final = FullName.toString();
				// System.out.println("inside dao impl "+FullName);
				String UsernameTE = TransferEmp + "~" + FullName;
				 System.out.println("insdide daio impl ///"+software_name);
				int executeUpdate2 = sessionFactory.getCurrentSession()
						.createQuery("update USER_SOFTWARE_MAP set APPLIED_DATE='" + newAppdate + "',ASSET_CODE='"
								+ AssetCode + "',USERNAME='" + UsernameTE + "' where PRODUCT_NAME='" + software_name
								+ "'")
						.executeUpdate();
				if (executeUpdate2 > 0) {
					// System.out.println("dfgdtgdfg insdie successs");
					status = "success";
				} else {
					status = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		 System.out.println("IN ELSE SNO IS: ");
		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + Status + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setTICKET_TYPE("Software Transfer");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");

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
			if(status.equals("success"))
				System.out.println("Statudd sd sd "+Status);
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public String closeSoftwareRequestTransfer(String ticketid, String closereason) {
		String status = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String Fullname = null;
		String role_Type = null;
		try {

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// //System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

			// System.out.println("INSIDE EFORMACTIVITY CLOSESOFTWAREREQUESTTRANSFER DAO
			// IMPL"+ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type = session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
				// //System.out.println("Exceptioon e***" + e);
			}
			try {

				int updateRequest = sessionFactory.getCurrentSession()
						.createQuery("update SOFTWARE_TRANSFER set CLOSED_BY='" + LoginUser + "',CLOSED_BY_FULLNAME='"
								+ Fullname + "',CLOSED_DATE='" + currenttime + "',STATUS='Closed' where T_ID='"
								+ ticketid + "'")
						.executeUpdate();

				// System.out.println("update SOFTWARE_TRANSFER set CLOSED_BY"+updateRequest);
				if (updateRequest > 0) {
					status = "success";
				} else {
					status = "error";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					// System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						// System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						// System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					// System.out.println(e);
				}

				String msg = null;

				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
						+ "<tr><td>Status:</td><td>Closed</td></tr>" + "<tr><td>Closed By:</td><td>" + LoginUser + "  ["
						+ Fullname + "]</td></tr>";
				EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(ticketid);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(LoginUser);
				tickettrack.setSTATUS("Closed");
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(LoginUser);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				tickettrack.setACTIVITY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_TYPE("Software Transfer");
				tickettrack.setPRIORITY("P5");
				tickettrack.setSEVERITY("Information");
				sessionFactory.getCurrentSession().persist(tickettrack);
				status = "success";

				//////////////////// INSERT IN TICKET ACTIVITY log/////////////////

				int ActSno = 0;
				try {
					String EMAIL = null;
					String contactNo = null;
					Query getdata = sessionFactory.getCurrentSession()
							.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + LoginUser
									+ "' and COMPANY='" + loginUserCompany + "'");
					List<Object[]> obj = getdata.list();
					for (Object[] object : obj) {
						EMAIL = object[0].toString();
						contactNo = object[1].toString();
					}
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
								.setProjection(Projections.max("SR_NO"));
						Integer actSrno1 = (Integer) crit.uniqueResult();

						// System.out.println(" actSrno1 IS: " + actSrno1);

						if (actSrno1 != null) {
							ActSno = actSrno1.intValue();
							ActSno = ActSno + 1;
							// System.out.println("IN IF ActSno IS: " + ActSno);
						} else {
							ActSno = 1;
							// System.out.println("IN ELSE ActSno IS: " + ActSno);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						// System.out.println(e);
					}

					EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

					ticketActivityLog.setSR_NO(ActSno);
					ticketActivityLog.setT_ID(ticketid);
					ticketActivityLog.setSTATUS("Closed");
					ticketActivityLog.setT_DATETIME(currenttime);
					ticketActivityLog.setT_CHANGEBY(LoginUser);
					ticketActivityLog.setPRIORITY("P5");
					ticketActivityLog.setSEVERITY("Information");

					ticketActivityLog.setT_DESC(closereason);
					ticketActivityLog.setROLE_TYPE(role_Type);
					ticketActivityLog.setCHANGE_NOTES1(closereason);
					ticketActivityLog.setT_COMPANY(loginUserCompany);
					ticketActivityLog.setT_EMAIL(EMAIL);

					ticketActivityLog.setT_CONTACT_NO(contactNo);
					ticketActivityLog.setT_FULLNAME(Fullname);
					ticketActivityLog.setTICKET_TYPE("Software Transfer");

					sessionFactory.getCurrentSession().persist(ticketActivityLog);
					status = "success";
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

try {
			
			String ticketstatus="Closed";
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(ticketid, ticketstatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
return status + "," + ticketid;
	}

	@Override
	public JSONArray getNTReleaseSoftwareInTc(String listingType) {
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// System.out.println("listing ztype "+listingType);

		if (listingType.equals("bucket_for_wip")) {
			System.out.println("bucket for WIP");

			int srno = 0;
			array1 = new JSONArray();
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from SOFTWARE_RELEASE where GROUPNAME='NT Admin' and STATUS in('Approved By IT Compliance','Hold') and REQUEST_CATEGORY='Server' ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
			List<SOFTWARE_RELEASE> req = query.list();
			for (SOFTWARE_RELEASE sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				if (sourceDrive.getSTATUS().equals("Approved By IT Compliance")) {
					array.put(
							"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else if (sourceDrive.getSTATUS().equals("Resovled")) {
					array.put(
							"<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				}
				array.put(sourceDrive.getT_ID());
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());// array.put(sourceDrive.getAPPROVAL_NOTE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
				array.put(sourceDrive.getRAISED_DATE());

				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRAISED_DATE());
				array1.put(array);
			}
		} else if (listingType.equals("bucket_for_resolve")) {
			System.out.println("inside bucjet for resolve");
			int srno = 0;
			array1 = new JSONArray();
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from SOFTWARE_RELEASE where GROUPNAME='NT Admin' and STATUS in('Work in Progress','Resolved','Closed') and REQUEST_CATEGORY='Server' ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
			List<SOFTWARE_RELEASE> req = query.list();
			for (SOFTWARE_RELEASE sourceDrive : req) {
				array = new JSONArray();
				srno = srno + 1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				if (sourceDrive.getSTATUS().equals("Work in Progress")) {
					array.put(
							"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else if (sourceDrive.getSTATUS().equals("Resolved")) {
					array.put(
							"<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					array.put(" ");
				}
				array.put(sourceDrive.getT_ID());
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());// array.put(sourceDrive.getAPPROVAL_NOTE());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
				array.put(sourceDrive.getRAISED_DATE());

				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
				array.put(sourceDrive.getRAISED_DATE());
				array1.put(array);
			}

		}
		return array1;

	}

	@Override
	public String getSoftwareReleaseTicket(String softwareName, String reqType) {
		// TODO Auto-generated method stub
		// System.out.println("INSIDE TICKET
		// RELEASE"+softwareName+"fgfffffffffff"+reqType);
		JSONArray array = null;
		String loginuser = "";
		String status = "";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (reqType.equals("Software_Release")) {
			Query createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(
					"select S_NAME from SOFTWARE_RELEASE where T_REQUESTER='" + loginuser + "' and STATUS<>'Released'");
			List RaisedsoftwareName = createSQLQuery.list();

			if (!createSQLQuery.list().isEmpty()) {

				if (RaisedsoftwareName.contains(softwareName)) {
					status = "TICKET_FOUND";
				} else {
					status = "TICKETNOTFOUND";
				}
			} else {
				status = "TICKETNOTFOUND";
			}
		} else if (reqType.equals("Software_Request")) {
			// System.out.println("gtfgggggggggggggg"+reqType);
			Query createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(
					"select S_NAME from SOFTWARE_REQUEST where T_REQUESTER='" + loginuser + "' and STATUS<>'Resolved'");
			List RaisedsoftwareName = createSQLQuery.list();

			if (!createSQLQuery.list().isEmpty()) {
				if (RaisedsoftwareName.contains(softwareName)) {
					status = "TICKET_FOUND";
				} else {
					status = "TICKETNOTFOUND";
				}
			} else {
				status = "TICKETNOTFOUND";
			}
		} else if (reqType.equals("Software_Transfer")) {

			Query createSQLQuery = sessionFactory.getCurrentSession()
					.createSQLQuery("select S_NAME from SOFTWARE_TRANSFER  where T_REQUESTER='" + loginuser
							+ "' and STATUS<>'Resolved'");
			List RaisedsoftwareName = createSQLQuery.list();

			if (!createSQLQuery.list().isEmpty()) {

				if (RaisedsoftwareName.contains(softwareName)) {
					status = "TICKET_FOUND";
				} else {
					status = "TICKETNOTFOUND";
				}
			} else {
				status = "TICKETNOTFOUND";
			}

		}

		return status;

	}

	@Override
	public String closeReleaseRequestRequest(String ticketid, String closereason) {

		String status = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String Fullname = null;
		String role_Type = null;
		try {

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// //System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

//			//System.out.println("INSIDE EFORMACTIVITY CLOSESOFTWAREREQUESTREQUEST DAO IMPL"+ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type = session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
				// //System.out.println("Exceptioon e***" + e);
			}
			try {
				Query  updateRequest = sessionFactory.getCurrentSession()
						.createQuery("update SOFTWARE_RELEASE set CLOSED_BY='" + LoginUser + "',CLOSED_BY_FULLNAME='"+ Fullname + "',CLOSED_DATE='" + currenttime + "',STATUS='Closed',CLOSE_REASON=:T_DESC where T_ID='" + ticketid + "'");
				updateRequest.setParameter("T_DESC", closereason);
				int updateReq =updateRequest.executeUpdate();
				if (updateReq > 0) {
					status = "success";
				} else {
					status = "error";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					// System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						// System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						// System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					// System.out.println(e);
				}

				String msg = null;

				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
						+ "<tr><td>Status:</td><td>Closed</td></tr>" + "<tr><td>Closed By:</td><td>" + LoginUser + "  ["
						+ Fullname + "]</td></tr>";
				EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(ticketid);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(LoginUser);
				tickettrack.setSTATUS("Closed");
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(LoginUser);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				tickettrack.setACTIVITY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_TYPE("Software Release");
				tickettrack.setPRIORITY("P5");
				tickettrack.setSEVERITY("Information");
				sessionFactory.getCurrentSession().persist(tickettrack);
				status = "success";

				//////////////////// INSERT IN TICKET ACTIVITY log/////////////////

				int ActSno = 0;
				try {
					String EMAIL = null;
					String contactNo = null;
					Query getdata = sessionFactory.getCurrentSession()
							.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + LoginUser
									+ "' and COMPANY='" + loginUserCompany + "'");
					List<Object[]> obj = getdata.list();
					for (Object[] object : obj) {
						EMAIL = object[0].toString();
						contactNo = object[1].toString();
					}
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
								.setProjection(Projections.max("SR_NO"));
						Integer actSrno1 = (Integer) crit.uniqueResult();

						// System.out.println(" actSrno1 IS: " + actSrno1);

						if (actSrno1 != null) {
							ActSno = actSrno1.intValue();
							ActSno = ActSno + 1;
							// System.out.println("IN IF ActSno IS: " + ActSno);
						} else {
							ActSno = 1;
							// System.out.println("IN ELSE ActSno IS: " + ActSno);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						// System.out.println(e);
					}

					EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

					ticketActivityLog.setSR_NO(ActSno);
					ticketActivityLog.setT_ID(ticketid);
					ticketActivityLog.setSTATUS("Closed");
					ticketActivityLog.setT_DATETIME(currenttime);
					ticketActivityLog.setT_CHANGEBY(LoginUser);
					ticketActivityLog.setPRIORITY("P5");
					ticketActivityLog.setSEVERITY("Information");

					ticketActivityLog.setT_DESC(closereason);
					ticketActivityLog.setROLE_TYPE(role_Type);
					ticketActivityLog.setCHANGE_NOTES1(closereason);
					ticketActivityLog.setT_COMPANY(loginUserCompany);
					ticketActivityLog.setT_EMAIL(EMAIL);

					ticketActivityLog.setT_CONTACT_NO(contactNo);
					ticketActivityLog.setT_FULLNAME(Fullname);
					ticketActivityLog.setTICKET_TYPE("Software Release");

					sessionFactory.getCurrentSession().persist(ticketActivityLog);
					status = "success";
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

try {

		String ticketstatus = "Closed";
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(ticketid, ticketstatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
return status;

	}

	@Override
	public JSONArray getPendingServerSoftwareTransferInTc() {

		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}

		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_TRANSFER where GROUPNAME='NT Admin' and STATUS  ='Approved By It Compliance' and REQUEST_CATREGORY='Server' or(STATUS='Hold' and RT_APPROVAL='"
						+ loginuser
						+ "' and REQUEST_CATREGORY='Server' ) ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Approved By It Compliance") || sourceDrive.getSTATUS().equals("Hold")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put(" ");
			}
//			else {
//				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;
	}

	@Override
	public String InsertServerTransferRequestApprovedByNTAdmin(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String tid, String requestCartegory) {
		int id = 0;

		String status = "";
		String FullNameOfLogin = "";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String AssignGroup = "NT Admin";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
//			String LoginFullName="";

			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

//			//System.out.println("FDullanrme "+FullNameOfLogin);
//			String approvalName, MultipartFile empPic,
			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_TRANSFER set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_FULLNAME='"
							+ FullNameOfLogin
							+ "',RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("GROUPNAME", AssignGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", approvenote);
			updatesr.setParameter("T_ID", tid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
//					//System.out.println("insidew suvvess");
				status = "success";
			} else {
//					//System.out.println("|inisdeis eeorre");
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}

		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + Status + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setTICKET_TYPE("Software Transfer");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(appByITComp);

			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");

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
			if(status.equals("success"))
				//System.out.println("Statudd sd sd "+Status);
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public String InsertTransferRequestApprovedByNT(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String raisedByName, String tid, String requestCartegory) {
		int id = 0;

		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String AssignGroup = "NT Admin";

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
//			String LoginFullName="";

			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
//				//System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);

			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

//			//System.out.println("FDullanrme "+FullNameOfLogin);
//			String approvalName, MultipartFile empPic,

			Query updatesr = sessionFactory.getCurrentSession()
					.createQuery("update SOFTWARE_TRANSFER set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_FULLNAME='"
							+ FullNameOfLogin
							+ "',RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("GROUPNAME", AssignGroup);
			updatesr.setParameter("T_ID", tid);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", approvenote);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			}

			else {
				status = "error";
			}
			// System.out.println("sfgfgsdfgfgf"+Status);
			if (Status.equals("Resolved")) {
				//////////////// DATA FROM SOFTWARFE TRANSFER START////////
				// System.out.println("inside success and update usm");
				String software_name = "";
				String AssetCode = "";
				String newAppdate = "";
				String TransferEmp = "";
				Query getTdata = sessionFactory.getCurrentSession().createSQLQuery(
						"select S_NAME,NEW_ASSET_CODE,NEW_ASSET_DATE,TO_EMPLOYEE from SOFTWARE_TRANSFER where T_ID='"
								+ tid + "'");

				List<Object[]> list = getTdata.list();
				for (Object[] obj : list) {
					software_name = obj[0].toString();
					AssetCode = obj[1].toString();
					newAppdate = obj[2].toString();
					TransferEmp = obj[3].toString();
				}
				//////////////// DATA FROM SOFTWARFE TRANSFER END/////////

				List FULLNAMEOFTE = sessionFactory.getCurrentSession()
						.createSQLQuery("select FULL_NAME from loginmaster where USERNAME='" + TransferEmp
								+ "'and COMPANY='3i Infotech'")
						.list();
				String FullName = FULLNAMEOFTE.get(0).toString();
//				String final = FullName.toString();
				// System.out.println("inside dao impl "+FullName);
				String UsernameTE = TransferEmp + "~" + FullName;
				// System.out.println("insdide daio impl ///"+software_name);
				int executeUpdate2 = sessionFactory.getCurrentSession()
						.createQuery("update USER_SOFTWARE_MAP set APPLIED_DATE='" + newAppdate + "',ASSET_CODE='"
								+ AssetCode + "',USERNAME='" + UsernameTE + "' where PRODUCT_NAME='" + software_name
								+ "'")
						.executeUpdate();
				if (executeUpdate2 > 0) {
					// System.out.println("dfgdtgdfg insdie successs");
					status = "success";
				} else {
					status = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}

		String msg = null;

		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + Status + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(tid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);

		tickettrack.setPRIORITY("P5");
		tickettrack.setSEVERITY("Information");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setTICKET_TYPE("Software Transfer");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(tid);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);

			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Transfer");
			ticketActivityLog.setPRIORITY("P5");
			ticketActivityLog.setSEVERITY("Information");

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
			if(status.equals("success"))
				//System.out.println("Statudd sd sd "+Status);
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getWorkInProgressServerTransferInTc() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_TRANSFER where GROUPNAME='NT Admin' and STATUS in('Work in Progress','Resolved') and REQUEST_CATREGORY='Server'  ORDER bY STR_TO_DATE(RT_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_TRANSFER> req = query.list();
		for (SOFTWARE_TRANSFER sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");

			if (sourceDrive.getSTATUS().equals("Work in Progress")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			} else {
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}

			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());

			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray getReleaseSoftwareInTcForResolution() {

		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_RELEASE where GROUPNAME='Remote Support' and REQUEST_CATEGORY<>'Server' and STATUS in('Work in Progress','Resolved')ORDER bY STR_TO_DATE(IT_COMPIANCE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_RELEASE> req = query.list();
		for (SOFTWARE_RELEASE sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			if (sourceDrive.getSTATUS().equals("Work in Progress")) {
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");

			} else if (sourceDrive.getSTATUS().equals("Resolved")) {
				array.put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());// array.put(sourceDrive.getAPPROVAL_NOTE());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
//			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DESC());
			array.put(sourceDrive.getRAISED_DATE());

			array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_DATE());
//			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);
		}
		return array1;
	}

	@Override
	public String InsertReleseRequestForResolution(String name, String companyname, String nameid, String reqid,
			String statusR, String note, MultipartFile empPic, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String appByITComp, String softwarenamerelese, String requestcatassign) {

		// TODO Auto-generated method stub
		// System.out.println("controller calling software relese method DAOlmpl start
		// point");
		int id = 0;
		String status = "";
		String FullNameOfLogin = "";
		String CurrentStatus = "Approved";
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);

			// System.out.println("controller calling software relese method DAOlmpl middle
			// point select phone, email");
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			String groupName = "";
			// "update SOFTWARE_RELEASE set
			// IT_COMPIANCE_APPROVAL_NAME=:IT_COMPIANCE_APPROVAL_NAME,IT_COMPIANCE_APPROVAL_NAME_FULLNAME='"+FullNameOfLogin+"',IT_COMPIANCE_APPROVAL_DATE=:IT_COMPIANCE_APPROVAL_DATE,STATUS=:STATUS,IT_COMPIANCE_APPROVAL_DESC=:IT_COMPIANCE_APPROVAL_DESC,GROUPNAME=:GROUPNAME
			// where T_ID=:T_ID"
			if (requestcatassign.equals("Server")) {
				groupName = "NT Admin";
			} else {
				groupName = "Remote Support";
			}
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_RELEASE set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,RT_APPROVAL_FULLNAME=:RT_APPROVAL_FULLNAME,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", statusR);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", note);
			updatesr.setParameter("GROUPNAME", groupName);
			updatesr.setParameter("RT_APPROVAL_FULLNAME", FullNameOfLogin);

			updatesr.setParameter("T_ID", reqid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
				try {

					if (statusR.equals("Resolved")) {
						Query updateSoftware = sessionFactory.getCurrentSession().createQuery(
								"update USER_SOFTWARE_MAP set STATUS=:STATUS where PRODUCT_NAME=:PRODUCT_NAME");

						updateSoftware.setParameter("PRODUCT_NAME", softwarenamerelese);
						updateSoftware.setParameter("STATUS", "Released");

						int executeUpdates = updateSoftware.executeUpdate();

						if (executeUpdates > 0) {
							status = "success";
						} else {
							status = "error";
						}
					}

				} catch (Exception e) {
				}
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String[] StatusSplit = statusR.split(" ");
		String msg = null;
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + statusR
				+ "</td></tr>" + "<tr><td>" + StatusSplit[0] + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();
		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(reqid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(statusR);

		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setPRIORITY("P3");
		tickettrack.setSEVERITY("Medium");
		tickettrack.setTICKET_TYPE("Software Release");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);
		status = "success";
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(reqid);
			ticketActivityLog.setSTATUS(statusR);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
			ticketActivityLog.setT_DESC(note);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(note);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setPRIORITY("P3");
			ticketActivityLog.setSEVERITY("Medium");
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Release");
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(reqid, statusR);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
return status + "~" + reqid;

	}

	@Override
	public String InsertReleseRequestByRemotSupportForResolve(String name, String companyname, String nameid,
			String reqid, String statusR, String note, MultipartFile empPic, String emailid, String pid,
			String companyRaisedBy, String raisedByName, String appByITComp, String softwarenamerelese,
			String requestcatassign) {

		// TODO Auto-generated method stub
		// System.out.println("controller calling software relese method DAOlmpl start
		// point");
		int id = 0;
		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String PHONE = null;
		String EMAIL = null;
		String FinalGroup = "";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);

			// System.out.println("controller calling software relese method DAOlmpl middle
			// point select phone, email");
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			String groupName = "";
			// "update SOFTWARE_RELEASE set
			// IT_COMPIANCE_APPROVAL_NAME=:IT_COMPIANCE_APPROVAL_NAME,IT_COMPIANCE_APPROVAL_NAME_FULLNAME='"+FullNameOfLogin+"',IT_COMPIANCE_APPROVAL_DATE=:IT_COMPIANCE_APPROVAL_DATE,STATUS=:STATUS,IT_COMPIANCE_APPROVAL_DESC=:IT_COMPIANCE_APPROVAL_DESC,GROUPNAME=:GROUPNAME
			// where T_ID=:T_ID"
			if (requestcatassign.equals("Server")) {
				groupName = "NT Admin";
			} else {
				groupName = "Remote Support";
			}
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_RELEASE set RT_APPROVAL=:RT_APPROVAL,RT_APPROVAL_DATE=:RT_APPROVAL_DATE,RT_APPROVAL_DESCRIPTION=:RT_APPROVAL_DESCRIPTION,STATUS=:STATUS,RT_APPROVAL_FULLNAME=:RT_APPROVAL_FULLNAME,GROUPNAME=:GROUPNAME where T_ID=:T_ID");
			updatesr.setParameter("RT_APPROVAL", loginuser);
			updatesr.setParameter("RT_APPROVAL_DATE", currenttime);
			updatesr.setParameter("STATUS", statusR);
			updatesr.setParameter("RT_APPROVAL_DESCRIPTION", note);
			updatesr.setParameter("GROUPNAME", groupName);
			updatesr.setParameter("RT_APPROVAL_FULLNAME", FullNameOfLogin);

			updatesr.setParameter("T_ID", reqid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
				try {

					if (statusR.equals("Resolved")) {
						Query updateSoftware = sessionFactory.getCurrentSession().createQuery(
								"update USER_SOFTWARE_MAP set STATUS=:STATUS where PRODUCT_NAME=:PRODUCT_NAME");

						updateSoftware.setParameter("PRODUCT_NAME", softwarenamerelese);
						updateSoftware.setParameter("STATUS", "Released");

						int executeUpdates = updateSoftware.executeUpdate();

						if (executeUpdates > 0) {
							status = "success";
						} else {
							status = "error";
						}
					}

				} catch (Exception e) {
				}
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String[] StatusSplit = statusR.split(" ");
		String msg = null;
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + statusR
				+ "</td></tr>" + "<tr><td>" + StatusSplit[0] + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";
		EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();
		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(reqid);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(statusR);

		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
		tickettrack.setPRIORITY("P3");
		tickettrack.setSEVERITY("Medium");
		tickettrack.setTICKET_TYPE("Software Release");

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);
		status = "success";
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}

			EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(reqid);
			ticketActivityLog.setSTATUS(statusR);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
			ticketActivityLog.setT_DESC(note);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(note);
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);
			ticketActivityLog.setPRIORITY("P3");
			ticketActivityLog.setSEVERITY("Medium");
			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setTICKET_TYPE("Software Release");
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			status = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

	try {
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRelease(reqid, statusR);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
return status + "~" + reqid;

	}

	@Override
	public String InsertTransferRequestApprovedBy2ndManager(String appByITComp, String Status, String approvenote,
			MultipartFile empPic, String CompanyRaisedBy, String raisedByName, String tid, String reqcat,
			String toemployee) {

		int id = 0;
		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";
		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;
		String GROUP_NAME = null;

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_TRANSFER set TO_EMP_APPROVAR_DATE=:TO_EMP_APPROVAR_DATE,TO_EMP_APPROVAR_NOTE=:TO_EMP_APPROVAR_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS where T_ID=:T_ID");

			updatesr.setParameter("TO_EMP_APPROVAR_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("TO_EMP_APPROVAR_NOTE", approvenote);

			updatesr.setParameter("GROUPNAME", "IT Compliance");

			updatesr.setParameter("T_ID", tid);

			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;

		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println(e);
		}
		String msg = null;

		if (status.equals("success")) {
			String[] split = Status.split(" ");
			String approve = split[0];
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
					+ "</td></tr>" + "<tr><td>" + approve + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
					+ "]</td></tr>";
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(tid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);
			tickettrack.setSTATUS(Status);
			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setTICKET_TYPE("Software Transfer");

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(raisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY("3i Infotech");

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

		}
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception e) {
// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println(e);
			}
			if (status.equals("success")) {
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginuser);

				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setROLE_TYPE(loginRoleType);

				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setTICKET_TYPE("Software Transfer");
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			
			
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(tid, Status);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return status + "~" + tid;

	}

	@Override
	public JSONArray GetSoftwareDetailOfLoginUser(String sname) {

		JSONArray array = null;
		JSONArray array1 = null;
		JSONObject arrayobj = null;
	System.out.println("hi this is else bloack"+sname);
		List<USER_SOFTWARE_MAP> getSoftDetls = sessionFactory.getCurrentSession()
				.createQuery("from USER_SOFTWARE_MAP where PRODUCT_NAME='" + sname + "'").list();
//		List<Object[]> list = ;
		for (USER_SOFTWARE_MAP listOfdetls : getSoftDetls) {
			array1 = new JSONArray();
			arrayobj = new JSONObject();
			String[] lisrt = listOfdetls.getAPPLIED_DATE().split(" ");
			arrayobj.put("COST", lisrt[0]);
			arrayobj.put("PERIOD", listOfdetls.getASSET_CODE());
			array1.put(arrayobj);
		}
		return array1;
	}

	// Business Request

	@Override
	public String insertBusinessRequest(String fullname,String compname,String site,String department,String phone,String emailid,String pid,String approup,String requestfor,String domain,String description,String rperiod,String typecategory,String newDate,MultipartFile empPic) 
	{
		// MultipartFile empPic, String approvalname
		System.out.println("insert data successful start");
		int id=0;
		
		String companyName="";
		String status="";
		String MyStatus = "Approval For Manager";
		String ticketTag = "";
		String NewTicketID = "";
//		String[] split = approup.split("~");
//		String appovalname=split[0];
//		String approval_fullname=split[1];
		try
		{
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(BUSINESS_ID_REQUEST.class)
					.setProjection(Projections.max("SRNO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			//System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				id = srno1.intValue();
				id = id + 1;
				//System.out.println("IN IF SRNO IS: " + id);
			} else {
				id = 1;
				//System.out.println("IN ELSE SRNO IS: " + id);
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		System.out.println("FILENAME WITHOUT EXT vvvv: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		System.out.println("createnewfilename***bbbb" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser="";
		String loginRoleType="";
		//System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
				
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			 String string = session.getAttribute("GROUP").toString();
			 companyName = session.getAttribute("companyname").toString();
			 
			 System.out.println("userName is : " + loginuser);
			 System.out.println("userName is : " + companyName);
//			System.out.println("group namme is dfdfed "+string);
			Date currentdate = dateFormat.parse(currenttime);
		
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

//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
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
				System.out.println("UPDATED FILE NAME business: " + updatedFileName);

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
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		try 
		{
			
			 System.out.println("userName is : " + loginuser);
			 System.out.println("companyName is : " + companyName);
			 
			 // Update the Phone number 
			 sessionFactory.getCurrentSession().createQuery("update loginmaster set PHONE='"+phone+"' where COMPANY='"+companyName+"'and USERNAME='"+loginuser+"'").executeUpdate();
			 
			List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery(
					"from ticket_tag_master where COMPANY='" + compname + "' and DEPARTMENT='" + department + "'")
					.list();
			for (ticket_tag_master sourceDrive : tagList) {
				ticketTag = sourceDrive.getTICKET_TAG();
			}

			
				NewTicketID = ticketTag + "EF-" + id;
				
				BUSINESS_ID_REQUEST sr = new BUSINESS_ID_REQUEST();
				
				sr.setT_ID(NewTicketID);
				sr.setT_REQUESTER(loginuser);
				sr.setT_REQUESTER_FULLNAME(fullname);
				sr.setRAISED_DATE(currenttime);
				sr.setSRNO(id);
				sr.setT_COMPANY(compname);
				sr.setT_BRANCH(site);
				sr.setT_DEPARTMENT(department);
				sr.setEMAIL_ID(emailid);
				sr.setT_PHONE(phone);
				sr.setP_ID(pid);		
				sr.setBUSINESS_TYPE_ID(requestfor);
				sr.setDOMAIN(domain);
				sr.setBUSINESS_TYPE_ID_NAME(rperiod); 
				sr.setREQUEST_TYPE(typecategory);
				
				String[] split = approup.split("~");
				String Appname=split[0];
				String AppFullname=split[1];
				
				sr.setAPPROVAR_NAME(Appname);
				sr.setAPPROVAR_NAME_FULLNAME(AppFullname);
				
				System.out.println("this is product approup(Approval name) " + approup);

				sr.setT_DESC(description);
				sr.setSTATUS(MyStatus);
				sr.setPRIORITY("P2");
				sr.setSEVERITY("Medium");
				
//				String REQTYPE =  sr.getREQUEST_TYPE();
				if(typecategory.equals("Temporary")) {
					sr.setTEMP_DATE(newDate);
				}else {
					sr.setTEMP_DATE("NA");
					
				}
//				sr.setTEMP_DATE(newDate);
				if(updatedFileName==null)
				{
					sr.setATTACH_NAME("No File Available");
				}else
				{
					sr.setATTACH_NAME(updatedFileName);
				}
				System.out.println("sfgfgfdggfdgd gf g"+updatedFileName);
					
						sessionFactory.getCurrentSession().persist(sr);
					
						status = "success";
				
				System.out.println("insert data successful end");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Ticket Tracking strat");
		
		
//		Criteria crit = sessionFactory.getCurrentSession().createCriteria(BUSINESS_ID_REQUEST.class)
//				.setProjection(Projections.max("SRNO"));
//		Integer srno1 = (Integer) crit.uniqueResult();
//
//		//System.out.println(" SRNO IS: " + srno1);
//
//		if (srno1 != null) {
//			id = srno1.intValue();
//			id = id + 1;
//			//System.out.println("IN IF SRNO IS: " + id);
//		} else {
//			id = 1;
//			//System.out.println("IN ELSE SRNO IS: " + id);
//		}

		
		////////////////////////////////////////////////////////////////////////////////////////////
		if(status.equals("success")) {
		int sno = 0;
		try {
		
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
//		String loginMasterData = getLoginMasterData();
		
		String msg = null;
		
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
				+ "<tr><td>Status:</td><td>Approval For Manager</td></tr>" + "<tr><td>Raised By:</td><td>" + loginuser+"  ["+fullname+ "]</td></tr>";
		EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(NewTicketID);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);
		tickettrack.setSTATUS(MyStatus);
		tickettrack.setPRIORITY("P2");		
		tickettrack.setSEVERITY("Medium");
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(loginuser);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(compname);
		tickettrack.setTICKET_RAISED_BY_COMPANY(compname);
		
		
		System.out.println("MyStatus : "+ MyStatus);
		
		
		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			
			
			tickettrack.setATTACHMENT_NAME(updatedFileName);
			
			System.out.println("insert business sid ticket tracking : " + updatedFileName );
			System.out.println("insert business sid ticket tracking tttt: " + tickettrack );
		}
		
			sessionFactory.getCurrentSession().persist(tickettrack);
		
		}
//		sessionFactory.getCurrentSession().persist(tickettrack);
		
		System.out.println("Ticket Tracking done");
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		System.out.println("Ticket Activity Start ");
		int ActSno = 0;
		try
		{
		
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
					.setProjection(Projections.max("SR_NO"));
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

		EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();

		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(NewTicketID);
		ticketActivityLog.setPRIORITY("P2");
		ticketActivityLog.setSTATUS(MyStatus); //New
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginuser);
		ticketActivityLog.setT_DESC(description);
		ticketActivityLog.setROLE_TYPE(loginRoleType);
		ticketActivityLog.setCHANGE_NOTES1(description);
		ticketActivityLog.setSEVERITY("Medium");
		ticketActivityLog.setT_COMPANY(compname);
		ticketActivityLog.setT_EMAIL(emailid);

		ticketActivityLog.setT_CONTACT_NO(phone);
		ticketActivityLog.setT_FULLNAME(fullname);

		if (updatedFileName == null) {
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			System.out.println("activity log attach : " + updatedFileName);
			System.out.println("activity log attach hhhh : " + ticketActivityLog);
			
		}

		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		
		}	
	catch (Exception e) {
		e.printStackTrace();
	}
	
		System.out.println("Ticket Activity done");
		try {
			String ticketStatus="New";
			if(status.equals(MyStatus))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(NewTicketID, ticketStatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("END THE bUSSINESS METHOD");
		
		return status+","+NewTicketID;
				
	}

	@Override
	public JSONArray getUserBusinessRequestList() {
		
		System.out.println("Inside EFORM Business Dao Impl ");
		JSONArray array=null;
		String loginuser="";
		String company="";
		JSONArray array1=null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//			company = session.getAttribute("c").toString();
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		int srno=0;
		array1=new JSONArray();
		Query query=sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_REQUESTER='"+loginuser+"' OR STATUS='Rejected By Manager' OR STATUS='Rejected By GalUpdate' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
		List<BUSINESS_ID_REQUEST> req=query.list();
		for(BUSINESS_ID_REQUEST sourceDrive:req)
		{
			array = new JSONArray();
			srno=srno+1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
		
//			if(sourceDrive.getSTATUS().equals("Resolved"))
//			{
////				array.put("<button class='btn btn-sm btn-danger' id='actionTicket'  name='Doem' onclick='actionTicket(\""
////						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//			}
//			else
//			{
//				array.put(" ");
//			}
			if(sourceDrive.getSTATUS().equals("Rejected By Manager")||sourceDrive.getSTATUS().equals("Rejected By GalUpdate"))
			{
				array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
						+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			}
			else
			{
				array.put(" ");
			}
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			
			array.put(sourceDrive.getBUSINESS_TYPE_ID());
			array.put(sourceDrive.getBUSINESS_TYPE_ID_NAME());
			array.put(sourceDrive.getREQUEST_TYPE());
			array.put(sourceDrive.getDOMAIN());
			
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
//			array.put(sourceDrive.getT_DESC());
			
			array.put(sourceDrive.getAPPROVAR_NAME());
			array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
			array.put(sourceDrive.getAPPROVAR_DATE());
//			array.put(sourceDrive.getAPPROVAL_NOTE());
			
			array.put(sourceDrive.getGALUPDATE_USERNAME());
			array.put(sourceDrive.getGALUPDATE_FULLNAME());
			array.put(sourceDrive.getGALUPDATE_APPROVAL_DATE());
//			array.put(sourceDrive.getGALUPDATE_NOTE());
			
			array.put(sourceDrive.getML_APPROVAR_USERLNAME());
			array.put(sourceDrive.getML_APPROVAR_FULLNAME());
			array.put(sourceDrive.getML_APPROVAR_DATE());
//			array.put(sourceDrive.getML_APPROVAR_NOTE());
			
			array.put(sourceDrive.getTEMP_DATE());
//			array.put(sourceDrive.getRAISED_DATE());
			array.put(sourceDrive.getAPPROVAR_DATE());
			array.put(sourceDrive.getCLOSED_DATE());
			array1.put(array);
		}
		return array1;
	}

	
	
	
	@Override
	public JSONArray gatherBusinessRequestDetails(String ticketid) {
		System.out.println("inside gatherBusinessRequestDetails");
		JSONArray array=null;
		JSONArray array1=null;
		String loginuser=null;
		String Company=null;
		String department = "";
		
		String sub_department = "";
		String location = "";
		String emailId="";
		String ContactNo="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			Company=session.getAttribute("companyname").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			array=new JSONArray();
			Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
			
			Query getData=sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_ID='"+ticketid+"'");
			
			List<BUSINESS_ID_REQUEST> list=getData.list();
			for(BUSINESS_ID_REQUEST ticketDrive:list)
			{
				JSONObject arrayobj=new JSONObject();
				Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
				List<loginmaster> listOfuser=getDataa.list();
				for (loginmaster loginDrive : listOfuser) {
					department = loginDrive.getDEPARTMENT();
					sub_department = loginDrive.getSUB_DEPARTMENT();
					location = loginDrive.getLOCATION();
					emailId=loginDrive.getEMAIL();
					ContactNo= loginDrive.getPHONE();									
				}
				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);

				if(emailId.isEmpty()||emailId==null)
				{
					arrayobj.put("EMAIL", "NA");
				}
				else
				{
					arrayobj.put("EMAIL", emailId);
				}
				if(ContactNo.isEmpty()||ContactNo==null)
				{
					arrayobj.put("PHONE", "NA");
				}
				else
				{
					arrayobj.put("PHONE",ContactNo);
				}
				arrayobj.put("T_ID",ticketDrive.getT_ID());
				arrayobj.put("STATUS",ticketDrive.getSTATUS());
				arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
				arrayobj.put("P_ID", ticketDrive.getP_ID());				
				arrayobj.put("BUSINESS_TYPE_ID", ticketDrive.getBUSINESS_TYPE_ID());
				arrayobj.put("BUSINESS_TYPE_ID_NAME", ticketDrive.getBUSINESS_TYPE_ID_NAME());
				arrayobj.put("REQUEST_TYPE", ticketDrive.getREQUEST_TYPE());
				arrayobj.put("DOMAIN", ticketDrive.getDOMAIN());
				arrayobj.put("APPROVAR_NAME", ticketDrive.getAPPROVAR_NAME());
				
//				arrayobj.put("APPROVAR_NAME_GALUPDATE_NAME", loginDrive.);
//				arrayobj.put("APPROVAR_NAME_GALUPDATE", ticketDrive.getAPPROVAR_NAME_FULLNAME());
				
				arrayobj.put("APPROVAR_NAME_MAILADMIN_NAME", ticketDrive.getAPPROVAR_NAME());
				arrayobj.put("APPROVAR_NAME_MAILADMIN_FULLNAME", ticketDrive.getAPPROVAR_NAME_FULLNAME());
				
				
				arrayobj.put("DESC", ticketDrive.getT_DESC());
				String AttachName = ticketDrive.getATTACH_NAME();
				System.out.println("Attachement name"+AttachName);
				try {
					if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						//System.out.println("Null object found");
					} else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
						//System.out.println("Object found");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println("IN CATCH BLOCK");
//					arrayobj.put("T_ATTACH1_NAME", "No File Available");
					e.printStackTrace();
				}
				array.put(arrayobj);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return array;
	}

	@Override
	public JSONArray getBusinessRequestActivityLog(String ticketid) {
		//System.out.println("Inside UserActivityDaoImpl getUserTicketTracking method");
				JSONArray array = new JSONArray();
				System.out.println("inside business activivty log dao" + ticketid);
				try {
					Query queryticketActivity = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_BUSINESS_REQUEST_ACTIVITYLOG where T_ID=:T_ID order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
					queryticketActivity.setParameter("T_ID", ticketid);
					List<EFORM_BUSINESS_REQUEST_ACTIVITYLOG> ticketActivity = queryticketActivity.list();
					for (EFORM_BUSINESS_REQUEST_ACTIVITYLOG sourceDrive : ticketActivity) {
						JSONObject arrayobjtemp = new JSONObject();
						arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
						arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
						arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
						arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
						arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
						arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
						arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
						arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
						arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
						arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
						arrayobjtemp.put("FULLNAME",sourceDrive.getT_FULLNAME());
						arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
						array.put(arrayobjtemp);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("inside business activivty log end dao" + array);
				return array;
	}

	@Override
	public JSONArray getBusinessRequestID(String requestype) {
		String LoginUser = null;
		String loginUserCompany = null;
		  String FinalGroup=null;
          String GroupOfTc=null;
          System.out.println("value of request type " + requestype);
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			 String GROUPNAME = session.getAttribute("GROUP").toString();
	            System.out.println("usernamesdfdffdfdffmeeem" + GROUPNAME);
	          
	            if(!GROUPNAME.equals("NA"))
				{
					if(GROUPNAME.contains(","))
					{
						System.out.println("inside if with , condition");
					String[] split = GROUPNAME.split(",");
					for (int i = 0; i < split.length; i++) {

						if (split[i].equals("Mail Admin"))
						{
							FinalGroup = split[i];
							}
					}
					}else
					{
						FinalGroup=GROUPNAME;
					System.out.println("group nsame is "+FinalGroup);

					}	
				}
				else
				{
					FinalGroup="NA";
				}
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		JSONArray array = null;
		JSONArray array1 = null;
	
			if (!(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")){
				
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from BUSINESS_ID_REQUEST GROUP BY T_ID  ORDER BY SRNO DESC").list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

			} else {
				try {
					List<Object> dataList = sessionFactory.getCurrentSession()
							.createQuery("select T_ID from BUSINESS_ID_REQUEST where T_REQUESTER='" + LoginUser
									+ "' and T_COMPANY='" + loginUserCompany
									+ "' order by STR_TO_DATE(RAISED_DATE,'%d-%m-%Y %H:%i:%s') DESC")
							.list();
					array1 = new JSONArray();
					for (Object sourceDrive : dataList) {
						array = new JSONArray();
						array.put(sourceDrive);
						array1.put(array);
						
						System.out.println("value of array 1 in dao impl " + array1);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
//			}
		}
		return array1;
	}

	@Override
	public JSONArray getUserBusinessRequestTracking(String ticketid, String requesttype) {
		System.out.println("inside dao IMPL request data");
		//System.out.println("Inside UserActivityDaoImpl getUserTicketTracking method");
		JSONArray array1 = null;

		try {
			System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking");
			List<BUSINESS_ID_REQUEST> dataList = sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_ID='" + ticketid + "'").list();
		
				
				array1 = new JSONArray();
				for (BUSINESS_ID_REQUEST sourceDrive : dataList) {
	
					String department = "";
					String sub_department = "";
					String location = "";
					List<loginmaster> loginDataList = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME ='" + sourceDrive.getT_REQUESTER() + "' and COMPANY ='" + sourceDrive.getT_COMPANY() + "'").list();
					for (loginmaster loginDrive : loginDataList) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
					}
	
					JSONObject arrayobj = new JSONObject();
					arrayobj.put("T_ID", sourceDrive.getT_ID());
					arrayobj.put("T_DATE", sourceDrive.getRAISED_DATE());
					arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
					arrayobj.put("T_MAIL", sourceDrive.getEMAIL_ID());
					arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
					arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
					arrayobj.put("T_DESC", sourceDrive.getT_DESC());					
					arrayobj.put("T_ATTACH1_NAME", sourceDrive.getATTACH_NAME());
					arrayobj.put("STATUS", sourceDrive.getSTATUS());
					arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobj.put("SEVERITY", sourceDrive.getSEVERITY());
	
					array1.put(arrayobj);
					
					System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking JSON OBJ ARRAY 1"+array1);
	
					Query queryticketTracking = sessionFactory.getCurrentSession()
							.createQuery("from EFORM_BUSINESS_REQUEST_TRACKING where T_ID=:T_ID  order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
					queryticketTracking.setParameter("T_ID", ticketid);
					List<EFORM_BUSINESS_REQUEST_TRACKING> ticketTracking = queryticketTracking.list();
					JSONArray array2 = new JSONArray();
					for (EFORM_BUSINESS_REQUEST_TRACKING sourceDrive1 : ticketTracking) {
						JSONObject arrayobjtemp = new JSONObject();
						arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
						arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
						arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
						array2.put(arrayobjtemp);
						
						System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking JSON OBJ ARRAY 2"+array2);
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
	public JSONArray getUserBusinessRaisedRequest() {
		System.out.println("Inside UserBusinessActivityDaoImpl getUserRaisedticket method");

				String LoginUser = null;
				String LoginScope = null;				
				String company=null;
				String status = null;
				String designation = null;
				try {
					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					LoginUser = session.getAttribute("username").toString();		
					designation = session.getAttribute("designation").toString();
					LoginScope = session.getAttribute("loginscope").toString();
					company = session.getAttribute("companyname").toString();
					
					
					System.out.println("usernameBusiness****" + LoginUser);
					System.out.println("LoginScope****" + LoginScope);
					System.out.println("designation  ***" +designation);
					System.out.println("CompanyCompany  ***" +company);
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println("Exceptioon e***" + e);
				}
				JSONArray array = null;
				JSONArray array1 = null;
				int srno = 0;
				try {
					System.out.println("inside the query DAO IMPL QUERY Try Block : " );
					//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
					
					List<BUSINESS_ID_REQUEST> dataList = sessionFactory.getCurrentSession()
							.createQuery("from BUSINESS_ID_REQUEST where APPROVAR_NAME='"+LoginUser+"' and (STATUS='Approval For Manager' OR STATUS='Re-Opened') and T_COMPANY='"+company+"' ORDER BY STR_TO_DATE(RAISED_DATE, '%d-%m-%Y %H:%i:%s') DESC").list(); // ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC)
					array1 = new JSONArray();
					array1 = new JSONArray();
					System.out.println("inside the query DAO IMPL : " + dataList);
					for (BUSINESS_ID_REQUEST sourceDrive : dataList) {
						srno = srno + 1;
						//System.out.println("array = " + sourceDrive.getPRIORITY());
						array = new JSONArray();

						array.put(
								"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
										+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
						array.put(
								"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
						/*
						 * array.
						 * put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
						 * + sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
						 */

						array.put(sourceDrive.getT_ID());
						System.out.println("");
						array.put(sourceDrive.getSTATUS());
//						array.put(sourceDrive.getPRIORITY());
//						array.put(sourceDrive.getSEVERITY());
//						
						array.put(sourceDrive.getT_COMPANY());
						array.put(sourceDrive.getT_BRANCH());
						array.put(sourceDrive.getT_DEPARTMENT());
//						
					
//						array.put(sourceDrive.getBUSINESS_TYPE_ID());
//						array.put(sourceDrive.getBUSINESS_TYPE_ID_NAME());
//						array.put(sourceDrive.getDOMAIN());						
						array.put(sourceDrive.getT_REQUESTER());
						array.put(sourceDrive.getT_REQUESTER_FULLNAME());
//						array.put(sourceDrive.getP_ID());
						
//						array.put(sourceDrive.getREQUEST_TYPE());
						array.put(sourceDrive.getAPPROVAR_NAME());
						array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
						array.put(sourceDrive.getRAISED_DATE());
		
						array1.put(array);
						System.out.println("inside the query DAO IMPL : " + array1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return array1;
	}

	@Override
	public JSONArray gatherBusinesRequestRequestDetails(String ticketid) {
		System.out.println("inside gatherBusinessRequestDetails");
		JSONArray array=null;
		JSONArray array1=null;
		String loginuser=null;
		String Company=null;
		String department = "";
		
		String sub_department = "";
		String location = "";
		String emailId="";
		String ContactNo="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			Company=session.getAttribute("companyname").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			array=new JSONArray();
			Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
			
			Query getData=sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_ID='"+ticketid+"'");
			
			List<BUSINESS_ID_REQUEST> list=getData.list();
			for(BUSINESS_ID_REQUEST ticketDrive:list)
			{
				JSONObject arrayobj=new JSONObject();
				Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
				List<loginmaster> listOfuser=getDataa.list();
				for (loginmaster loginDrive : listOfuser) {
					department = loginDrive.getDEPARTMENT();
					sub_department = loginDrive.getSUB_DEPARTMENT();
					location = loginDrive.getLOCATION();
					emailId=loginDrive.getEMAIL();
					ContactNo= loginDrive.getPHONE();
				}
				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);
				
				
//				
				if(emailId.isEmpty()||emailId==null)
				{
					arrayobj.put("EMAIL", "NA");
				}
				else
				{
					arrayobj.put("EMAIL", emailId);
				}
				if(ContactNo.isEmpty()||ContactNo==null)
				{
					arrayobj.put("PHONE", "NA");
				}
				else
				{
					arrayobj.put("PHONE",ContactNo);
				}
				
				arrayobj.put("T_ID",ticketDrive.getT_ID());
				arrayobj.put("STATUS",ticketDrive.getSTATUS());
				arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
				arrayobj.put("P_ID", ticketDrive.getP_ID());		
				arrayobj.put("DESC", ticketDrive.getT_DESC());
				
				arrayobj.put("APPROVAL_NAME", ticketDrive.getAPPROVAR_NAME());
				arrayobj.put("BUSINESS_ID_TYPE", ticketDrive.getBUSINESS_TYPE_ID());
				arrayobj.put("BUSINESS_TYPE_ID_NAME", ticketDrive.getBUSINESS_TYPE_ID_NAME());
				arrayobj.put("REQUEST_TYPE", ticketDrive.getREQUEST_TYPE());
				
				String req = ticketDrive.getREQUEST_TYPE();
				System.out.println("Request Type Value : " + req);
				
				String AttachName = ticketDrive.getATTACH_NAME();
				System.out.println("Attachement name"+AttachName);
				try {
					if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
						//System.out.println("Null object found");
					} else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
						//System.out.println("Object found");
					}
				} catch (Exception e) {
	
					e.printStackTrace();
				}
				array.put(arrayobj);
				System.out.println(" Value of array : " + array);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return array;
	}
	
	
	// ticket action
	
	@Override
	public JSONArray gatherBusinessActionDetails(String id) {

		//System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");

		JSONArray array1 = null;

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}

		try {
			List<BUSINESS_ID_REQUEST> ticketList = sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_ID='"+id+"'").list();
			
			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'").list();
			
			System.out.println("LOGIN MASTER VALUE : "+ tpList);
			
			array1 = new JSONArray();

			for (BUSINESS_ID_REQUEST ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {    
					System.out.println("LOGIN MASTER VALUE  forrrrrrr : "+ ticketDrive);
					JSONObject arrayobj = new JSONObject();
				
					arrayobj.put("T_REQUESTER",ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME",ticketDrive.getT_REQUESTER_FULLNAME());			
					arrayobj.put("COMPANY",ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH",ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT",ticketDrive.getT_DEPARTMENT());					
					arrayobj.put("EMAIL",ticketDrive.getEMAIL_ID());					
					arrayobj.put("PID",ticketDrive.getP_ID());
					arrayobj.put("T_ID",ticketDrive.getT_ID());
					arrayobj.put("DESC",ticketDrive.getT_DESC());
					arrayobj.put("T_PHONE",ticketDrive.getT_PHONE());					
					arrayobj.put("RAISE_DATE",ticketDrive.getRAISED_DATE());
					
					arrayobj.put("APPROVAL_NAME",ticketDrive.getAPPROVAR_NAME());
					arrayobj.put("REQUEST_FOR",ticketDrive.getBUSINESS_TYPE_ID());
					arrayobj.put("REQUEST_BUSINESS_ID",ticketDrive.getBUSINESS_TYPE_ID_NAME());
					arrayobj.put("REQUEST_TYPE",ticketDrive.getREQUEST_TYPE());
					
					String reqFor = ticketDrive.getBUSINESS_TYPE_ID();
					String reqBusinessID = ticketDrive.getREQUEST_TYPE();
					
					System.out.println("rEQUEST fOR : " + reqFor);
					System.out.println("rEQUEST tYPE : " + reqBusinessID);
					
					arrayobj.put("STATUS",ticketDrive.getSTATUS());

					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					
					String usernameGal = tpDrive.getUSERNAME();
					String galfullName = tpDrive.getFULL_NAME();					
					System.out.println("user name : "+ usernameGal);
					System.out.println("FULL NAME : " + galfullName);
					
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());					
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());
					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					
					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER() + "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'").list();
					for(loginmaster  t_requesrterdetailsnew:t_requesrterdetails)
					{
						
						System.out.println("Login master values data : " + t_requesrterdetailsnew);
						arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());
						
					}

					array1.put(arrayobj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return array1;
	}

	@Override
	public String InsertBusinessRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
			String companyRaisedBy, String raisedByName, String ticketidupdateTDassign) {
		// TODO Auto-generated method stub
		
		System.out.println("inside dao impl business request gal update submit button action ");
		int id=0;
		
		String status="";
		String FullNameOfLogin="";
		
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser="";
		String loginRoleType="";
		String company="";
		//System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL=null;
		String PHONE=null;
		String tid = null;
		
		try {
			
			System.out.println("first try block in businesss inside session ");
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company=session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
//			tid = session.getAttribute("tid").toString();
			
			System.out.println("username for 51688 :"+ loginuser);
			System.out.println("fullname for 51688 :"+ FullNameOfLogin);
			System.out.println("company for 51688 :"+ company);
			Date currentdate = dateFormat.parse(currenttime);
			try
			{
				
				System.out.println("second try block in businesss inside phone nd email ");
				Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
				List<Object[]> list=getLoginData.list();
				for(Object[] obj:list)
				{
					EMAIL = obj[0].toString();
					PHONE=obj[1].toString();
				}
				System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				
				System.out.println("third try block in businesss inside C:\\\\ITHelpDesk\\\\ ");
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

				System.out.println("inside the file coding business id approval request ");
//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//System.out.println("destFile........" + destFile);
				// //System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME: " + updatedFileName);

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
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
		try 
		{
			
			System.out.println("FDullanrme "+FullNameOfLogin);			
			Query updatesr=sessionFactory.getCurrentSession().createQuery("update BUSINESS_ID_REQUEST set APPROVAR_NAME_FULLNAME=:APPROVAR_NAME_FULLNAME,APPROVAR_DATE=:APPROVAR_DATE,APPROVAL_NOTE=:APPROVAL_NOTE,STATUS=:STATUS,ATTACH_NAME=:ATTACH_NAME where T_ID=:T_ID");
//			updatesr.setParameter("APPROVAR_NAME",approvalName);
			updatesr.setParameter("APPROVAR_NAME_FULLNAME",FullNameOfLogin);		
			updatesr.setParameter("APPROVAR_DATE",currenttime);
			updatesr.setParameter("STATUS",Status);
			updatesr.setParameter("APPROVAL_NOTE",approvenote);
			
			System.out.println("Fullanrme 51688 "+ FullNameOfLogin);
			System.out.println("user 51688 "+ loginuser);
					
			System.out.println("value of success status : " + Status);
			System.out.println("value of success : " + updatesr);
//			updatesr.setParameter("GROUPNAME","IT Compliance");
		
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			if(updatedFileName==null)
			{
				updatesr.setParameter("ATTACH_NAME","No File Available");
			}
			else
			{
				updatesr.setParameter("ATTACH_NAME",updatedFileName);
				System.out.println("inside query : " + updatedFileName);
			}
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			
				int executeUpdate = updatesr.executeUpdate();
				if(executeUpdate>0)
				{
					status = "success";
					
					System.out.println("value of another status : " + status);
				}
				else
				{
					status="error";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//////////////////////// Tracking start ////////////////////////////////////////
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
		String msg = null;
		String[] split = Status.split(" ");
		String approve=split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
				+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
		EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(ticketidupdateTDassign);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);
		System.out.println("status of 51688 tracking : " + Status);
		tickettrack.setPRIORITY("P2");
		tickettrack.setSEVERITY("Medium");
		
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
			System.out.println("inside query tracking  : " + updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		
		int ActSno = 0;
		try
		{
		
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
					.setProjection(Projections.max("SR_NO"));
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
// 			TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

		EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();

		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(ticketidupdateTDassign);
		ticketActivityLog.setSTATUS(Status);
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginuser);

		ticketActivityLog.setT_DESC(approvenote);
		ticketActivityLog.setROLE_TYPE(loginRoleType);

		ticketActivityLog.setPRIORITY("P2");
		ticketActivityLog.setSEVERITY("Medium");
		ticketActivityLog.setT_COMPANY(company);
		ticketActivityLog.setT_EMAIL(EMAIL);

		ticketActivityLog.setT_CONTACT_NO(PHONE);
		ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
		ticketActivityLog.setCHANGE_NOTES1(approvenote);
		if (updatedFileName == null) {
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			System.out.println("inside query activity log : " + updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		}	
	catch (Exception e) {
		e.printStackTrace();
	}
//		try {			
//			if(status.equals("success"))
//			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return status+"~"+id;
	}

	
	// inside viewTicket Activity log method
	@Override
	public JSONArray getBusinessTicketRequestActivityLog(String ticketid) {
		JSONArray array = new JSONArray();
		try {
			Query queryticketActivity = sessionFactory.getCurrentSession()
					.createQuery("from EFORM_BUSINESS_REQUEST_ACTIVITYLOG where T_ID=:T_ID order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
			queryticketActivity.setParameter("T_ID", ticketid);
			List<EFORM_BUSINESS_REQUEST_ACTIVITYLOG> ticketActivity = queryticketActivity.list();
			for (EFORM_BUSINESS_REQUEST_ACTIVITYLOG sourceDrive : ticketActivity) {
				JSONObject arrayobjtemp = new JSONObject();
				arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
				arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
				arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
				arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
				arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
				arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
				arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
				arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
				arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
				arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//				arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//				arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//				arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
				arrayobjtemp.put("FULLNAME",sourceDrive.getT_FULLNAME());
				arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
				array.put(arrayobjtemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	
	//galupdate business request 
	@Override
	public JSONArray getGalUpdateBusinessRequest() {
		System.out.println("Inside galUpdate DaoImpl method");

		String LoginUser = null;
		String LoginScope = null;				
		String company=null;
		String status = null;
		String designation = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();		
			designation = session.getAttribute("designation").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			
			
//			System.out.println("username****" + LoginUser);
//			System.out.println("LoginScope****" + LoginScope);
//			System.out.println("designation  ***" +designation);
//			System.out.println("companyname  ***" +company);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		try {
			System.out.println("inside the query DAO IMPL QUERY Try Block GalUpdate : " );
			//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
			
			List<BUSINESS_ID_REQUEST> dataList = sessionFactory.getCurrentSession()
					.createQuery("from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+LoginUser+"' OR STATUS='Approved By Manager') ORDER BY STR_TO_DATE(APPROVAR_DATE , '%d-%m-%Y %H:%i:%s') DESC").list();
			array1 = new JSONArray();
			array1 = new JSONArray();
			System.out.println("inside the query DAO IMPL GalUpdate  QUERY: " + dataList);
			for (BUSINESS_ID_REQUEST sourceDrive : dataList) {
				srno = srno + 1;
				//System.out.println("array = " + sourceDrive.getPRIORITY());
				array = new JSONArray();

				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				/*
				 * array.
				 * put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
				 * + sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				 */

				array.put(sourceDrive.getT_ID());
				System.out.println("");
				array.put(sourceDrive.getSTATUS());				
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());	
				
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
//				array.put(sourceDrive.getT_DESC());
				
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_DATE());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
						
				array1.put(array);
				System.out.println("inside the query DAO IMPL GalUpdate : " + array1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	
	//mail update flow
	@Override
	public JSONArray getMailAdminBusinessRequest() {
		System.out.println("Inside Mail Admin DaoImpl method");

		String LoginUser = null;
		String LoginScope = null;				
		String company=null;
		String status = null;
		String designation = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();		
			designation = session.getAttribute("designation").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			
			
//			System.out.println("username****" + LoginUser);
//			System.out.println("LoginScope****" + LoginScope);
//			System.out.println("designation  ***" +designation);
//			System.out.println("companyname  ***" +company);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		try {
			System.out.println("inside the query DAO IMPL QUERY Try Block Mail Admin : " );
			//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
			
			List<BUSINESS_ID_REQUEST> dataList = sessionFactory.getCurrentSession()
					.createQuery("from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+LoginUser+"' OR STATUS='Approved By GalUpdate' OR STATUS='Hold') order by STR_TO_DATE(GALUPDATE_APPROVAL_DATE ,'%d-%m-%Y %H:%i:%s') desc").list();
			array1 = new JSONArray();
			array1 = new JSONArray();
			System.out.println("inside the query DAO IMPL Mail Admin  QUERY: " + dataList);
			for (BUSINESS_ID_REQUEST sourceDrive : dataList) {
				srno = srno + 1;
				//System.out.println("array = " + sourceDrive.getPRIORITY());
				array = new JSONArray();

				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				
//				  array.
//				  put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//				  + sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				 

				array.put(sourceDrive.getT_ID());
				System.out.println("");
				array.put(sourceDrive.getSTATUS());
		
				
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());	
				
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
//				array.put(sourceDrive.getT_DESC());
				
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_DATE());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				
				array.put(sourceDrive.getGALUPDATE_USERNAME());
				array.put(sourceDrive.getGALUPDATE_FULLNAME());
				array.put(sourceDrive.getGALUPDATE_APPROVAL_DATE());
//				array.put(sourceDrive.getGALUPDATE_NOTE());

				array1.put(array);
				System.out.println("inside the query DAO IMPLMail Admin : " + array1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	@Override
	public JSONArray getMailAdminBucket() {
		System.out.println("Inside Mail Admin DaoImpl method");

		String LoginUser = null;
		String LoginScope = null;				
		String company=null;
		String status = "Work in Progress";
		String designation = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();		
			designation = session.getAttribute("designation").toString();
			LoginScope = session.getAttribute("loginscope").toString();
			company = session.getAttribute("companyname").toString();
			
			
//			System.out.println("username****" + LoginUser);
//			System.out.println("LoginScope****" + LoginScope);
//			System.out.println("designation  ***" +designation);
//			System.out.println("companyname  ***" +company);
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Exceptioon e***" + e);
		}
		JSONArray array = null;
		JSONArray array1 = null;
		int srno = 0;
		try {
			System.out.println("inside the query DAO IMPL QUERY Try Block Mail Admin : " );
			//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
			
			List<BUSINESS_ID_REQUEST> dataList = sessionFactory.getCurrentSession()
					.createQuery("from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+LoginUser+"' OR STATUS='Work in Progress' OR STATUS='Resolved') order by STR_TO_DATE(ML_APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc").list();
			array1 = new JSONArray();
			array1 = new JSONArray();
			System.out.println("inside the query DAO IMPL Mail Admin  QUERY: " + dataList);
			for (BUSINESS_ID_REQUEST sourceDrive : dataList) {
				srno = srno + 1;
				
				String statusTesting = sourceDrive.getSTATUS();
				System.out.println("statusTesting VALUE IS  = " + statusTesting);
				
				array = new JSONArray();

				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
				if(sourceDrive.getSTATUS().equals("Work in Progress"))
				{
				array.put(
						"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				}
				else if(sourceDrive.getSTATUS().equals("Resolved")) {
					array.put(
							"<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				} else {
					System.out.println("i am in closed");
					array.put("");
				}
				  

				array.put(sourceDrive.getT_ID());
				System.out.println("");
				array.put(sourceDrive.getSTATUS());				
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
//				array.put(sourceDrive.getT_DESC());
				
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_DATE());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				
				array.put(sourceDrive.getGALUPDATE_USERNAME());
				array.put(sourceDrive.getGALUPDATE_FULLNAME());
				array.put(sourceDrive.getGALUPDATE_APPROVAL_DATE());
//				array.put(sourceDrive.getGALUPDATE_NOTE());
				
				array.put(sourceDrive.getML_APPROVAR_USERLNAME());
				array.put(sourceDrive.getML_APPROVAR_FULLNAME());
				array.put(sourceDrive.getML_APPROVAR_DATE());
//				array.put(sourceDrive.getGALUPDATE_NOTE());
					 
				array1.put(array);
				System.out.println("inside the query DAO IMPLMail Admin : " + array1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array1;
	}

	@Override
	public String InsertBusinessRequestApprovedByGalUpdate(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String ticketidupdateTDassign) {
		System.out.println("inside dao impl business request gal update submit button action ");
		int id=0;
		String status="";
		String FullNameOfLogin="";	
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());	
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();		
		String localDateNow = localdate.format(now);
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser="";
		String loginRoleType="";
		String company="";
		String currenttime = dateFormat.format(date);
		String EMAIL=null;
		String PHONE=null;
		String tid = null;
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();//loginuser
			loginRoleType = session.getAttribute("role").toString();
			company=session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();

			
			System.out.println("username for galupdate :"+ loginuser);
			System.out.println("fullname for galupdate :"+ FullNameOfLogin);
			Date currentdate = dateFormat.parse(currenttime);
			try
			{
				Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
				List<Object[]> list=getLoginData.list();
				for(Object[] obj:list)
				{
					EMAIL = obj[0].toString();
					PHONE=obj[1].toString();
				}
				System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);
				
			}catch (Exception e) {
				
			}
			
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							
						} else {
							
						}
					}
				} catch (Exception e) {
					
				}

				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				
				String fileName = empPic.getOriginalFilename();
				
				ext = FilenameUtils.getExtension(fileName);
				
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				
				updatedFileName = createnewfilename + "." + ext;
				

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
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
		try 
		{
			
			System.out.println("FDullanrme "+FullNameOfLogin);			
			
			Query updatesr=sessionFactory.getCurrentSession().createQuery("update BUSINESS_ID_REQUEST set GALUPDATE_USERNAME=:GALUPDATE_USERNAME,GALUPDATE_FULLNAME=:GALUPDATE_FULLNAME,GALUPDATE_APPROVAL_DATE=:GALUPDATE_APPROVAL_DATE,GALUPDATE_NOTE=:GALUPDATE_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS,ATTACH_NAME=:ATTACH_NAME where T_ID=:T_ID");
			updatesr.setParameter("GALUPDATE_FULLNAME",FullNameOfLogin);
			updatesr.setParameter("GALUPDATE_USERNAME",loginuser);
			updatesr.setParameter("GALUPDATE_APPROVAL_DATE",currenttime);
			updatesr.setParameter("STATUS",Status);
			updatesr.setParameter("GALUPDATE_NOTE",approvenote);
			
			System.out.println("FDullanrme galupdate "+FullNameOfLogin);
			System.out.println("user galupdate "+ loginuser);
					
			System.out.println("value of success : " + Status);
			System.out.println("value of success : " + updatesr);
			updatesr.setParameter("GROUPNAME","Mail Admin");
		
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			if(updatedFileName==null)
			{
				updatesr.setParameter("ATTACH_NAME","No File Available");
			}
			else
			{
				updatesr.setParameter("ATTACH_NAME",updatedFileName);
			}
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			
				int executeUpdate = updatesr.executeUpdate();
				if(executeUpdate>0)
				{
					status = "success";
					
					System.out.println("value of another status : " + status);
				}
				else
				{
					status="error";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//////////////////////// Tracking start ////////////////////////////////////////
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
		String msg = null;
		String[] split = Status.split(" ");
		String approve=split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
				+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
		EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(ticketidupdateTDassign);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);
		System.out.println("ticket Tracking stataus is :" + Status);
		tickettrack.setPRIORITY("P2");
		tickettrack.setSEVERITY("Medium");
		
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		
		int ActSno = 0;
		try
		{
		
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
					.setProjection(Projections.max("SR_NO"));
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
// 			TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

		EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();

		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(ticketidupdateTDassign);
		ticketActivityLog.setSTATUS(Status);
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginuser);

		ticketActivityLog.setT_DESC(approvenote);
		ticketActivityLog.setROLE_TYPE(loginRoleType);

		ticketActivityLog.setPRIORITY("P2");
		ticketActivityLog.setSEVERITY("Medium");
		ticketActivityLog.setT_COMPANY(company);
		ticketActivityLog.setT_EMAIL(EMAIL);

		ticketActivityLog.setT_CONTACT_NO(PHONE);
		ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
		ticketActivityLog.setCHANGE_NOTES1(approvenote);
		if (updatedFileName == null) {
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		}	
	catch (Exception e) {
		e.printStackTrace();
	}
//		try {
//			
//			
//			if(status.equals("success"))
//			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return status+"~"+id;
	}

	@Override
	public String InsertBusinessRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
			String raisedByName, String ticketidupdateTDassign) {
		System.out.println("inside dao impl business request gal update submit button action ");
		int id=0;
		
		String status="";
		String FullNameOfLogin="";
		
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		String localDateNow = localdate.format(now);
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser="";
		String loginRoleType="";
		String company="";
		String currenttime = dateFormat.format(date);
		String EMAIL=null;
		String PHONE=null;
		String tid = null;
		
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company=session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
//			tid = session.getAttribute("tid").toString();
			
			System.out.println("username for galupdate :"+ loginuser);
			System.out.println("fullname for galupdate :"+ FullNameOfLogin);
			Date currentdate = dateFormat.parse(currenttime);
			try
			{
				Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
				List<Object[]> list=getLoginData.list();
				for(Object[] obj:list)
				{
					EMAIL = obj[0].toString();
					PHONE=obj[1].toString();
				}
				
			}catch (Exception e) {
				
			}
			
			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							
						} else {
						
						}
					}
				} catch (Exception e) {
				
				}

				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
			
				String fileName = empPic.getOriginalFilename();
			
				ext = FilenameUtils.getExtension(fileName);
					File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
			
				try {
					
					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {

			}
		}
		catch (Exception e) {

		}
	
		try 
		{			
			System.out.println("FDullanrme "+FullNameOfLogin);						
			Query updatesr=sessionFactory.getCurrentSession().createQuery("update BUSINESS_ID_REQUEST set ML_APPROVAR_USERLNAME=:ML_APPROVAR_USERLNAME,ML_APPROVAR_FULLNAME=:ML_APPROVAR_FULLNAME,ML_APPROVAR_DATE=:ML_APPROVAR_DATE,ML_APPROVAR_NOTE=:ML_APPROVAR_NOTE,STATUS=:STATUS where T_ID=:T_ID");
			updatesr.setParameter("ML_APPROVAR_FULLNAME",FullNameOfLogin);
			updatesr.setParameter("ML_APPROVAR_USERLNAME",loginuser);
			updatesr.setParameter("ML_APPROVAR_DATE",currenttime);
			updatesr.setParameter("STATUS",Status);
			updatesr.setParameter("ML_APPROVAR_NOTE",approvenote);
		
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			
				int executeUpdate = updatesr.executeUpdate();
				if(executeUpdate>0)
				{
					status = "success";
					
					System.out.println("value of another status : " + status);
				}
				else
				{
					status="error";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//////////////////////// Tracking start ////////////////////////////////////////
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
		String msg = null;
		String[] split = Status.split(" ");
		String approve=split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
				+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
		EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(ticketidupdateTDassign);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);
		System.out.println("status is 76524: " + Status);
		tickettrack.setPRIORITY("P2");
		tickettrack.setSEVERITY("Medium");
		
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

		if (updatedFileName == null) {
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		
		int ActSno = 0;
		try
		{
		
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
					.setProjection(Projections.max("SR_NO"));
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
			e.printStackTrace();
			System.out.println(e);
		}

		EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();

		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(ticketidupdateTDassign);
		ticketActivityLog.setSTATUS(Status);
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginuser);

		ticketActivityLog.setT_DESC(approvenote);
		ticketActivityLog.setROLE_TYPE(loginRoleType);

		ticketActivityLog.setPRIORITY("P2");
		ticketActivityLog.setSEVERITY("Medium");
		ticketActivityLog.setT_COMPANY(company);
		ticketActivityLog.setT_EMAIL(EMAIL);

		ticketActivityLog.setT_CONTACT_NO(PHONE);
		ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
		ticketActivityLog.setCHANGE_NOTES1(approvenote);
		if (updatedFileName == null) {
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		}	
	catch (Exception e) {
		e.printStackTrace();
	}
//		try {
//			
//			
//			if(status.equals("success"))
//			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return status+"~"+id;
	}

	@Override
	public String closeBusinessResolvedRequest(String ticketid, String closereason) {
		String status = null;
		String LoginUser = null;
		String loginUserCompany = null;
		String Fullname = null;
		String role_Type=null;
		try {
			
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			
			// System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

			System.out.println("INSIDE EFORMACTIVITY CLOSEBUSINESSREQUESTREQUEST DAO IMPL"+ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type=session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				int updateRequest = sessionFactory.getCurrentSession()
						.createQuery("update BUSINESS_ID_REQUEST set CLOSED_BY='" + LoginUser + "',CLOSED_BY_FULLNAME='"
								+ Fullname + "',CLOSED_DATE='"+currenttime+"',STATUS='Closed',DESCRIPTION='"+closereason+"' where T_ID='"+ticketid+"'").executeUpdate();
			
				System.out.println("update BUSINESS_ID_REQUEST set CLOSED_BY"+updateRequest);
				if(updateRequest>0)
				{
					status="success";
				}
				else
				{
					status="error";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				 
				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					System.out.println(e);
				}
						
				String msg = null;

				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
						+ "<tr><td>Status:</td><td>Closed</td></tr>" + "<tr><td>Closed By:</td><td>" + LoginUser+"  ["+Fullname+ "]</td></tr>";  // + "<tr><td>Closed Note:</td><td>" +closereason+ "</td></tr>"
				EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(ticketid);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(LoginUser);
				tickettrack.setSTATUS("Closed");
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(LoginUser);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				tickettrack.setACTIVITY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
				tickettrack.setPRIORITY("P2");
				tickettrack.setSEVERITY("Medium");
				sessionFactory.getCurrentSession().persist(tickettrack);
				status="success";
				
				
				//////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				
				int ActSno = 0;
				try
				{
					String EMAIL=null;
					String contactNo=null;
					Query getdata =sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
					List<Object[]> obj=getdata.list();
					for(Object[] object:obj)
					{
						EMAIL=object[0].toString();
						contactNo=object[1].toString();
					}
				try {
					
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
							.setProjection(Projections.max("SR_NO"));
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
					e.printStackTrace();
					System.out.println(e);
				}

				EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(ticketid);
				ticketActivityLog.setSTATUS("Closed");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(LoginUser);
				ticketActivityLog.setPRIORITY("P2");
				ticketActivityLog.setSEVERITY("Medium");
			
				ticketActivityLog.setT_DESC(closereason);
				ticketActivityLog.setROLE_TYPE(role_Type);
				ticketActivityLog.setCHANGE_NOTES1(closereason);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(EMAIL);

				ticketActivityLog.setT_CONTACT_NO(contactNo);
				ticketActivityLog.setT_FULLNAME(Fullname);

				
				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				status="success";
				}catch (Exception e) {

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

		}

	try {
			
			String ticketstatus="Closed";
			if(status.equals("success"))
			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketid, ticketstatus);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String RequestReopenResolvedBusinessTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
		System.out.println("INSIDE EFORM DAO IMPL RequestReopenResolvedBusinessTicket");
		String status="";

		String LoginUser = "";
		String loginUserCompany = "";
		String Fullname = "";
		String role_Type = "";
		String ext = "";
		String updatedFileName = null;
		//attach file start code ADD FIRST //
		
		String fileNameWithOutExt = FilenameUtils.removeExtension(reopenPic.getOriginalFilename());
		//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + ticketid;
		//System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
		
		//attach file end code //
		
		
		//attach file  code SECOND ADD//
		try {
			
			System.out.println("third try block in businesss inside C:\\\\ITHelpDesk\\\\ ");
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

			System.out.println("inside the file coding business id approval request ");
//            File uploadedFile =  empPic;
			File uploadedFile = new File(reopenPic.getOriginalFilename());
			uploadedFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(uploadedFile);
			fos.write(reopenPic.getBytes());
			fos.close();
			//System.out.println("uploadedFile::::" + uploadedFile);
			String fileName = reopenPic.getOriginalFilename();
			System.out.println("fileName::::" + fileName);
			ext = FilenameUtils.getExtension(fileName);
			//System.out.println("file_extension::::" + ext);
			// File destFile = new File(imagefilePath + File.separator + fileName);
			File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
			//System.out.println("destFile........" + destFile);
			// //System.out.println("File........" + imagefilePath + File.separator +
			// fileName);
			//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
			updatedFileName = createnewfilename + "." + ext;
			System.out.println("UPDATED FILE NAME RE-OPEN: " + updatedFileName);

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
		
		////////////attach second add ///////////////
		
		try {

			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);

			System.out.println("INSIDE EFORMACTIVITY Reopen Business Request DAO IMPL" + ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
				role_Type = session.getAttribute("role").toString();
			} catch (Exception e) {
				e.printStackTrace();
			}

			int updateReq=sessionFactory.getCurrentSession().createQuery("update BUSINESS_ID_REQUEST set STATUS='Re-Opened',RE_OPENED_DATE='"+currenttime+"',RE_OPENED_BY='"+LoginUser+"',RE_OPENED_BY_FULLNAME='"+Fullname+"',T_DESC='"+reopenreason+"'where T_ID='"+ticketid+"'").executeUpdate();
			try {
				 
				int sno = 0;
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno1 = (Integer) crit.uniqueResult();

					System.out.println(" SNO IS: " + srno1);

					if (srno1 != null) {
						sno = srno1.intValue();
						sno = sno + 1;
						System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					System.out.println(e);
				}
			
				String msg = null;
				
				
				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
						+ "<tr><td>Status:</td><td>Re-Opened</td></tr>" + "<tr><td>Re-Opened By:</td><td>" + LoginUser+"  ["+Fullname+ "]</td></tr>";
				EFORM_BUSINESS_REQUEST_TRACKING tickettrack = new EFORM_BUSINESS_REQUEST_TRACKING();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(ticketid);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(LoginUser);

				tickettrack.setSTATUS("Re-Opened");
				tickettrack.setPRIORITY("P2");
				tickettrack.setSEVERITY("Medium");
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_RAISED_NAME(LoginUser);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				tickettrack.setACTIVITY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
				
				if (updatedFileName == null) {
					tickettrack.setATTACHMENT_NAME("No File Available");
				} else {
					tickettrack.setATTACHMENT_NAME(updatedFileName);
					System.out.println("inside query tracking  : " + updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(tickettrack);
				status="success";
				
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				
				int ActSno = 0;
				try
				{
					String EMAIL=null;
					String contactNo=null;
					Query getdata =sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
					List<Object[]> obj=getdata.list();
					for(Object[] object:obj)
					{
						EMAIL=object[0].toString();
						contactNo=object[1].toString();
					}
				try {

					Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_ACTIVITYLOG.class)
							.setProjection(Projections.max("SR_NO"));
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
					e.printStackTrace();
				}
				EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new EFORM_BUSINESS_REQUEST_ACTIVITYLOG();
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(ticketid);
				ticketActivityLog.setSTATUS("Re-Opened");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(LoginUser);
				ticketActivityLog.setPRIORITY("P2");
				ticketActivityLog.setSEVERITY("Medium");
				ticketActivityLog.setT_DESC(reopenreason);
				ticketActivityLog.setROLE_TYPE(role_Type);
				ticketActivityLog.setCHANGE_NOTES1(reopenreason);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(EMAIL);

				ticketActivityLog.setT_CONTACT_NO(contactNo);
				ticketActivityLog.setT_FULLNAME(Fullname);
				
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
					System.out.println("inside query tracking  : " + updatedFileName);
				}
				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				status="success";
				}catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	@Override
	public JSONArray getBusinessReopenRequestDetails(String ticketid) {
		System.out.println("inside getBusinessReOpenRequestDetails");
		JSONArray array=null;
		JSONArray array1=null;
		String loginuser=null;
		String Company=null;
		String department = "";
		
		String sub_department = "";
		String location = "";
		String emailId="";
		String ContactNo="";
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			Company=session.getAttribute("companyname").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			array=new JSONArray();
			Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
			
			Query getData=sessionFactory.getCurrentSession().createQuery("from BUSINESS_ID_REQUEST where T_ID='"+ticketid+"'");
			
			List<BUSINESS_ID_REQUEST> list=getData.list();
			for(BUSINESS_ID_REQUEST ticketDrive:list)
			{
				JSONObject arrayobj=new JSONObject();
				Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
				List<loginmaster> listOfuser=getDataa.list();
				for (loginmaster loginDrive : listOfuser) {
					department = loginDrive.getDEPARTMENT();
					sub_department = loginDrive.getSUB_DEPARTMENT();
					location = loginDrive.getLOCATION();
					emailId=loginDrive.getEMAIL();
					ContactNo= loginDrive.getPHONE();
				}
				arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
				arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
				arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
				arrayobj.put("DEPARTMENT", department);
				arrayobj.put("SUB_DEPARTMENT", sub_department);
				arrayobj.put("LOCATION", location);
				
				if(emailId.isEmpty()||emailId==null)
				{
					arrayobj.put("EMAIL", "NA");
				}
				else
				{
					arrayobj.put("EMAIL", emailId);
				}
				if(ContactNo.isEmpty()||ContactNo==null)
				{
					arrayobj.put("PHONE", "NA");
				}
				else
				{
					arrayobj.put("PHONE",ContactNo);
				}
				arrayobj.put("T_ID",ticketDrive.getT_ID());
				arrayobj.put("STATUS",ticketDrive.getSTATUS());
				arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
				arrayobj.put("P_ID", ticketDrive.getP_ID());
				arrayobj.put("APPROVAL_NAME", ticketDrive.getAPPROVAR_NAME());
				arrayobj.put("REQUESTFOR", ticketDrive.getBUSINESS_TYPE_ID());
				arrayobj.put("REQUESTFOR_NAME", ticketDrive.getBUSINESS_TYPE_ID_NAME());
				arrayobj.put("REQUEST_TYPE", ticketDrive.getREQUEST_TYPE());
				arrayobj.put("DESC", ticketDrive.getT_DESC());
				String AttachName = ticketDrive.getATTACH_NAME();
				System.out.println("Attachement name"+AttachName);
				try {
					if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
						arrayobj.put("T_ATTACH_NAME", "No File Available");
					} else {
						arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				array.put(arrayobj);
			}
			
		} catch (Exception e) {
		}

		return array;
	}
	
	@Override
	public JSONArray getReleasePendingToApproveRequestByManager() {

		System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
//				company = session.getAttribute("c").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery("from SOFTWARE_RELEASE where APPROVAR_NAME='"
				+ loginuser
				+ "' and STATUS in('Approval For Manager','Re-Opened') ORDER bY STR_TO_DATE(RAISED_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_RELEASE> req = query.list();
		for (SOFTWARE_RELEASE sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			// array.put(sourceDrive.getAPPROVAR_NAME());
			array1.put(array);

		}
		return array1;

	}

	@Override
	public JSONArray AssignSoftwareReleaseDetails(String id) {

		//// System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");
//			String db_cname = null;
//			JSONArray array = null;

		JSONArray array1 = null;

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}

		try {
			List<SOFTWARE_RELEASE> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_RELEASE where T_ID='" + id + "'").list();

			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();

			array1 = new JSONArray();

			for (SOFTWARE_RELEASE ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {

					JSONObject arrayobj = new JSONObject();

					// System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");
//						arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
//						arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
//						arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
//						arrayobj.put("T_DEPARTMENT", ticketDrive.getT_DEPARTMENT());
//						arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
//						arrayobj.put("T_MAIL", ticketDrive.getT_MAIL());
//						arrayobj.put("VIP_LOGIN", ticketDrive.getVIP_TICKET());
//						
//						arrayobj.put("T_CATEGORY", ticketDrive.getT_CATEGORY());
//						arrayobj.put("T_SUBCAT1", ticketDrive.getT_SUBCAT1());
//						arrayobj.put("T_SUBCAT2", ticketDrive.getT_SUBCAT2());
//						arrayobj.put("T_SUBJECT", ticketDrive.getT_SUBJECT());
//						arrayobj.put("T_DATE", ticketDrive.getT_RAISE_TIME());
//						arrayobj.put("STATUS", ticketDrive.getSTATUS());
//						arrayobj.put("T_ID", ticketDrive.getT_ID());
//						arrayobj.put("T_DESC", ticketDrive.getT_DESC());
//						arrayobj.put("PRIORITY", ticketDrive.getPRIORITY());
//						arrayobj.put("SEVERITY", ticketDrive.getSEVERITY());
//						arrayobj.put("REQUEST_MODE", ticketDrive.getREQUEST_MODE());
					arrayobj.put("PID", ticketDrive.getPID());
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME", ticketDrive.getT_REQUESTER_FULLNAME());
					arrayobj.put("COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", ticketDrive.getT_DEPARTMENT());
					arrayobj.put("EMAIL", ticketDrive.getEMAIL_ID());

					arrayobj.put("T_ID", ticketDrive.getT_ID());
					arrayobj.put("DESC", ticketDrive.getT_DESC());
					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("STATUS", ticketDrive.getSTATUS());

					arrayobj.put("SNAME", ticketDrive.getS_NAME());

					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());
					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());

					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER()
									+ "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster t_requesrterdetailsnew : t_requesrterdetails) {

						arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());

					}

					array1.put(arrayobj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}

	@Override
	public String InsertReleaseApprovedByMAnager(String appByITCompname, String Status, String approvenote,
			String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String softwarename,
			String companyRaisedBy, String RaisedByName, String tid) {

		int id = 0;
		String status = "";
		String FullNameOfLogin = "";

		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		//// System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//// System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//			String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		//// System.out.println("createnewfilename***" + createnewfilename);
//			createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser = "";
		String loginRoleType = "";
		String company = "";

		//// System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL = null;
		String PHONE = null;

		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			System.out.println("dfAC");
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company = session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
			Date currentdate = dateFormat.parse(currenttime);
			try {
				Query getLoginData = sessionFactory.getCurrentSession()
						.createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='" + loginuser
								+ "' and COMPANY='" + company + "'");
				List<Object[]> list = getLoginData.list();
				for (Object[] obj : list) {
					EMAIL = obj[0].toString();
					PHONE = obj[1].toString();
				}
				// //System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);

			} catch (Exception e) {
				// TODO: handle exception
			}

			try {
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					File file = new File("C:\\ITHelpDesk\\");
					if (!file.exists()) {
						if (file.mkdir()) {
							//// System.out.println("Directory is created!");
						} else {
							//// System.out.println("Failed to create directory!");
						}
					}
				} catch (Exception e) {
					//// System.out.println("directory create exception" + e);
				}

//		            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//// System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				//// System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//// System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//// System.out.println("destFile........" + destFile);
				// ////System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//// System.out.println("File........" + imagefilePath + File.separator +
				//// createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				//// System.out.println("UPDATED FILE NAME: " + updatedFileName);

				try {

					FileUtils.copyFile(uploadedFile, destFile);
					File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					FileInputStream fis = new FileInputStream(filee);
				} catch (IOException ex) {
					//// System.out.println("Could not copy file " + fileName);
					status = "error";
					ex.printStackTrace();
				}
			} catch (Exception e) {
				//// System.out.println("directory create exception" + e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			System.out.println("vfvid" + pid);
//				String appByITCompName, String status, String approvenote,
//				String approvalName, MultipartFile empPic,
			System.out.println("inside dao impl approvede by manager" + tid);
			Query updatesr = sessionFactory.getCurrentSession().createQuery(
					"update SOFTWARE_RELEASE set APPROVAR_NAME_FULLNAME=:APPROVAR_NAME_FULLNAME,APPROVAR_DATE=:APPROVAR_DATE,APPROVAL_NOTE=:APPROVAL_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS,PID=:PID where T_ID=:T_ID");
			updatesr.setParameter("APPROVAR_NAME_FULLNAME", FullNameOfLogin);
			updatesr.setParameter("APPROVAR_DATE", currenttime);
			updatesr.setParameter("STATUS", Status);
			updatesr.setParameter("APPROVAL_NOTE", approvenote);
			updatesr.setParameter("GROUPNAME", "IT Compliance");
			updatesr.setParameter("PID", pid);
			updatesr.setParameter("T_ID", tid);
			int executeUpdate = updatesr.executeUpdate();
			if (executeUpdate > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			// System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				// System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				// System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();

			// System.out.println(e);
		}
		String msg = null;
		String currStatus = "";

		String[] split = Status.split(" ");
		String approve = split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>" + "<tr><td>Status:</td><td>" + Status
				+ "</td></tr>" + "<tr><td>" + approve + " By:</td><td>" + loginuser + "  [" + FullNameOfLogin
				+ "]</td></tr>";

		if (status.equals("success")) {
			EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(tid);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);
			tickettrack.setSTATUS(Status);
			tickettrack.setPRIORITY("P5");
			tickettrack.setSEVERITY("Information");
			tickettrack.setTICKET_TYPE("Software Release");

			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(RaisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

		}
		;
		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////

		int ActSno = 0;
		try {

			try {
		
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
						.setProjection(Projections.max("SR_NO"));
				Integer actSrno1 = (Integer) crit.uniqueResult();

				// System.out.println(" actSrno1 IS: " + actSrno1);

				if (actSrno1 != null) {
					ActSno = actSrno1.intValue();
					ActSno = ActSno + 1;
					// System.out.println("IN IF ActSno IS: " + ActSno);
				} else {
					ActSno = 1;
					// System.out.println("IN ELSE ActSno IS: " + ActSno);
				}
			} catch (Exception ess) {
				// TODO Auto-generated catch block
				ess.printStackTrace();
				// System.out.println(ess);
			}

			if (status.equals("success")) {
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();

				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(tid);
				ticketActivityLog.setSTATUS(Status);
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(loginuser);

				ticketActivityLog.setT_DESC(approvenote);
				ticketActivityLog.setROLE_TYPE(loginRoleType);

				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");
				ticketActivityLog.setT_COMPANY(company);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setTICKET_TYPE("Software Release");
				ticketActivityLog.setT_CONTACT_NO(PHONE);
				ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
				ticketActivityLog.setCHANGE_NOTES1(approvenote);
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		}
			try {
				
				
				if(status.equals("success"))
				Inv.EmaiLSmsTriggerdInSoftwareRelease(tid, Status);
			}catch(Exception es)
			{
				es.printStackTrace();
			}
		return status + "~" + tid;

	}

	@Override
	public JSONArray getReleasePendingToApproveRequestByITCompliance() {

		// System.out.println("ggggsfs cgvf ted ghjnhf ");
		JSONArray array = null;
		String loginuser = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		int srno = 0;
		array1 = new JSONArray();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from SOFTWARE_RELEASE where GROUPNAME='IT Compliance' and STATUS='Pending For Managers Approval' or  STATUS='Hold'  ORDER BY STR_TO_DATE(APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc");
		List<SOFTWARE_RELEASE> req = query.list();
		for (SOFTWARE_RELEASE sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			array.put(
					"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
			array.put("<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""
					+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
			array.put(sourceDrive.getT_ID());
			array.put(sourceDrive.getSTATUS());
			array.put(sourceDrive.getT_COMPANY());
			array.put(sourceDrive.getT_BRANCH());
			array.put(sourceDrive.getT_DEPARTMENT());
			array.put(sourceDrive.getT_REQUESTER());
			array.put(sourceDrive.getT_REQUESTER_FULLNAME());

//				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME());
//				array.put(sourceDrive.getIT_COMPIANCE_APPROVAL_NAME_FULLNAME());
			array.put(sourceDrive.getRAISED_DATE());
			array1.put(array);

		}
		return array1;
	}

	@Override
	public JSONArray gatherSoftwareReleaseDetailsToApp(String id) {

		//// System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");
//			String db_cname = null;
//			JSONArray array = null;

		JSONArray array1 = null;

		String LoginUser = null;
		String loginUserCompany = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			LoginUser = session.getAttribute("username").toString();
			loginUserCompany = session.getAttribute("companyname").toString();
			//// System.out.println("username****" + LoginUser);
		} catch (Exception e) {
			e.printStackTrace();
			//// System.out.println("Exceptioon e***" + e);
		}

		try {
			List<SOFTWARE_RELEASE> ticketList = sessionFactory.getCurrentSession()
					.createQuery("from SOFTWARE_RELEASE where T_ID='" + id + "'").list();

			List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery(
					"from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'")
					.list();

			array1 = new JSONArray();

			for (SOFTWARE_RELEASE ticketDrive : ticketList) {

				for (loginmaster tpDrive : tpList) {

					JSONObject arrayobj = new JSONObject();

//						arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
//						arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
//						arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
//						arrayobj.put("T_DEPARTMENT", ticketDrive.getT_DEPARTMENT());
//						arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
//						arrayobj.put("T_MAIL", ticketDrive.getT_MAIL());
//						arrayobj.put("VIP_LOGIN", ticketDrive.getVIP_TICKET());
//						
//						arrayobj.put("T_CATEGORY", ticketDrive.getT_CATEGORY());
//						arrayobj.put("T_SUBCAT1", ticketDrive.getT_SUBCAT1());
//						arrayobj.put("T_SUBCAT2", ticketDrive.getT_SUBCAT2());
//						arrayobj.put("T_SUBJECT", ticketDrive.getT_SUBJECT());
//						arrayobj.put("T_DATE", ticketDrive.getT_RAISE_TIME());
//						arrayobj.put("STATUS", ticketDrive.getSTATUS());
//						arrayobj.put("T_ID", ticketDrive.getT_ID());
//						arrayobj.put("T_DESC", ticketDrive.getT_DESC());
//						arrayobj.put("PRIORITY", ticketDrive.getPRIORITY());
//						arrayobj.put("SEVERITY", ticketDrive.getSEVERITY());
					arrayobj.put("PID", ticketDrive.getPID());
					arrayobj.put("ASSETCODE", ticketDrive.getASSET_CODE());

					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_REQUESTER_FULLNAME", ticketDrive.getT_REQUESTER_FULLNAME());
					arrayobj.put("COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", ticketDrive.getT_DEPARTMENT());
					arrayobj.put("EMAIL", ticketDrive.getEMAIL_ID());

					arrayobj.put("T_ID", ticketDrive.getT_ID());
					arrayobj.put("DESC", ticketDrive.getT_DESC());
					arrayobj.put("T_PHONE", ticketDrive.getT_PHONE());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("STATUS", ticketDrive.getSTATUS());

					arrayobj.put("SNAME", ticketDrive.getS_NAME());
					arrayobj.put("REQUEST_CATEGORY", ticketDrive.getREQUEST_CATEGORY());
					arrayobj.put("T_DESC", ticketDrive.getT_DESC());
					arrayobj.put("ASSETCODE", ticketDrive.getASSET_CODE());

					arrayobj.put("APPLIED_DATE", ticketDrive.getAPPLIED_DATE());
					arrayobj.put("ASSET_NAME", ticketDrive.getLAP_DESK_COMPUTER_NAME());
					arrayobj.put("ASSET_CODES", ticketDrive.getLAP_DESK_ASSET_CODE());
					arrayobj.put("ASSET_STATUS", ticketDrive.getLAP_DESK_STATUS());
					arrayobj.put("ASSET_IP", ticketDrive.getLAP_DESK_IP());

					arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
					arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
					arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
					arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
					arrayobj.put("TP_PHONE", tpDrive.getPHONE());
					arrayobj.put("TP_MAIL", tpDrive.getEMAIL());
					arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
					arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());

					List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession()
							.createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER()
									+ "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'")
							.list();
					for (loginmaster t_requesrterdetailsnew : t_requesrterdetails) {

						arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
						arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());

					}

					array1.put(arrayobj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;

	}
	@Override
	public String SoftwareTransferReopenResolvedTicket(String raisedByName, String ticketid, String reopenreason, MultipartFile reopenPic) 
	{

		//System.out.println("INSIDE EFORM DAO IMPL RequestReopenResolvedTicket");
		String status="";

		String LoginUser = "";
		String loginUserCompany = "";
		String Fullname = "";
		String role_Type = "";
		
		try {
		
		
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();

			// //System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			
			// Add File
						String fileNameWithOutExt = FilenameUtils.removeExtension(reopenPic.getOriginalFilename());
						//// //System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
						DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
						LocalDateTime now = LocalDateTime.now();
						//// //System.out.println(localdate.format(now));
						String localDateNow = localdate.format(now);
						String srno = null;
						String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + srno;
						//// //System.out.println("createnewfilename***" + createnewfilename);
						String ext = "";
						String updatedFileName = null;
						try {
							String imagefilePath;
							imagefilePath = "C:\\ITHelpDesk\\";
							try {
								File file = new File("C:\\ITHelpDesk\\");
								if (!file.exists()) {
									if (file.mkdir()) {
										//// //System.out.println("Directory is created!");
									} else {
										//// //System.out.println("Failed to create directory!");
									}
								}
							} catch (Exception e) {
								//// //System.out.println("directory create exception" + e);
							}

//				            File uploadedFile =  empPic;
							File uploadedFile = new File(reopenPic.getOriginalFilename());
							uploadedFile.createNewFile();
							FileOutputStream fos = new FileOutputStream(uploadedFile);
							fos.write(reopenPic.getBytes());
							fos.close();
							//// //System.out.println("uploadedFile::::" + uploadedFile);
							String fileName = reopenPic.getOriginalFilename();
							//// //System.out.println("fileName::::" + fileName);
							ext = FilenameUtils.getExtension(fileName);
							//// //System.out.println("file_extension::::" + ext);
							// File destFile = new File(imagefilePath + File.separator + fileName);
							File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
							//// //System.out.println("destFile........" + destFile);
							// //////System.out.println("File........" + imagefilePath + File.separator +
							// fileName);
							//// //System.out.println("File........" + imagefilePath + File.separator +
							//// createnewfilename + "." + ext);
							updatedFileName = createnewfilename + "." + ext;
							//// //System.out.println("UPDATED FILE NAME: " + updatedFileName);

							try {
								FileUtils.copyFile(uploadedFile, destFile);
								File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
								FileInputStream fis = new FileInputStream(filee);
							} catch (IOException ex) {
								//// //System.out.println("Could not copy file " + fileName);
								status = "error";
								ex.printStackTrace();
							}
						} catch (Exception e) {
							//// //System.out.println("directory create exception" + e);
						}
			//System.out.println("INSIDE EFORMACTIVITY CLOSESOFTWAREREQUESTREQUEST DAO IMPL" + ticketid);
			try {

				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				Fullname = session.getAttribute("fullname").toString();
			
			} catch (Exception e) {
				e.printStackTrace();
				// //System.out.println("Exceptioon e***" + e);
			}

		Query query=sessionFactory.getCurrentSession().createQuery("update SOFTWARE_TRANSFER set STATUS=:STATUS,RE_OPENED_DATE=:RE_OPENED_DATE,RE_OPENED_BY=:RE_OPENED_BY,DESCRIPTION=:DESCRIPTION where T_ID='"+ticketid+"'");
				query.setParameter("STATUS", "Re-Opened");
				query.setParameter("RE_OPENED_DATE",currenttime);
				query.setParameter("RE_OPENED_BY",LoginUser);
				query.setParameter("DESCRIPTION",reopenreason);
				
				query.setParameter("STATUS", "Re-Opened");
				
					int updateReq=query.executeUpdate();
			try {
				 if(updateReq>0)
				 {
					 
				int sno = 0;
				try {

					Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(EFORM_REQUEST_TRACKING.class)
							.setProjection(Projections.max("SR_NO"));
					Integer srno11 = (Integer) crit1.uniqueResult();

					if (srno11 != null) {
						sno = srno11.intValue();
						sno = sno + 1;
						//System.out.println("IN IF SNO IS: " + sno);
					} else {
						sno = 1;
						//System.out.println("IN ELSE SNO IS: " + sno);
					}
				} catch (Exception e) {

					e.printStackTrace();
					//System.out.println(e);
				}
			
				String msg = null;
				
				
				msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
						+ "<tr><td>Status:</td><td>Re-Opened</td></tr>" + "<tr><td>Re-Opened By:</td><td>" + LoginUser+"  ["+Fullname+ "]</td></tr>";
				EFORM_REQUEST_TRACKING tickettrack = new EFORM_REQUEST_TRACKING();

				tickettrack.setSR_NO(sno);
				tickettrack.setT_ID(ticketid);
				tickettrack.setACTIVITY_DATE(currenttime);
				tickettrack.setACTIVITY_NAME(LoginUser);

				tickettrack.setSTATUS("Re-Opened");
				tickettrack.setPRIORITY("P5");
				tickettrack.setSEVERITY("Information");
				tickettrack.setMESSAGE(msg);
				tickettrack.setTICKET_TYPE("Software Transfer");
				tickettrack.setTICKET_RAISED_NAME(LoginUser);
				tickettrack.setACTIVITY_DATE_TIME(currenttime);
				tickettrack.setACTIVITY_COMPANY(loginUserCompany);
				tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
				if (updatedFileName == null) {
					tickettrack.setATTACHMENT_NAME("No File Available");
				} else {
					tickettrack.setATTACHMENT_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(tickettrack);
				

				
				
				status="success";
				///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
				
				int ActSno = 0;
				try
				{
					String EMAIL=null;
					String contactNo=null;
					Query getdata =sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
					List<Object[]> obj=getdata.list();
					for(Object[] object:obj)
					{
						EMAIL=object[0].toString();
						contactNo=object[1].toString();
					}
				try {

					Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(EFORM_ACTIVITY_LOG.class)
							.setProjection(Projections.max("SR_NO"));
					Integer actSrno1 = (Integer) crit1.uniqueResult();

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
				EFORM_ACTIVITY_LOG ticketActivityLog = new EFORM_ACTIVITY_LOG();
				ticketActivityLog.setSR_NO(ActSno);
				ticketActivityLog.setT_ID(ticketid);
				ticketActivityLog.setSTATUS("Re-Opened");
				ticketActivityLog.setT_DATETIME(currenttime);
				ticketActivityLog.setT_CHANGEBY(LoginUser);
				ticketActivityLog.setPRIORITY("P5");
				ticketActivityLog.setSEVERITY("Information");
				ticketActivityLog.setT_DESC(reopenreason);
				ticketActivityLog.setROLE_TYPE(role_Type);
				ticketActivityLog.setCHANGE_NOTES1(reopenreason);
				ticketActivityLog.setT_COMPANY(loginUserCompany);
				ticketActivityLog.setT_EMAIL(EMAIL);
				ticketActivityLog.setTICKET_TYPE("Software Transfer");
				ticketActivityLog.setT_CONTACT_NO(contactNo);
				ticketActivityLog.setT_FULLNAME(Fullname);
				if (updatedFileName == null) {
					ticketActivityLog.setT_ATTACH_NAME("No File Available");
				} else {
					ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
				}

				sessionFactory.getCurrentSession().persist(ticketActivityLog);
				
				status="success";
				}catch (Exception e) {
					// TODO: handle exception
				}
				 status="success";
				 }
				 else {
					 status="error";
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Inv.EmaiLSmsTriggerdInSoftwareTransfer(ticketid, "Re-Opened");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;

	}


	@Override
	public JSONArray getSoftwaredetailsList() {

		System.out.println("Inside EFORm Activity Dao Impl ");
		JSONArray array = null;
		String loginuser = "";
		String FullNameOfLogin = "";
		String company = "";
		JSONArray array1 = null;
		try {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();

		} catch (Exception e) {
			// TODO: handle exception
		}
		String UsernameTE = loginuser + "~" + FullNameOfLogin;
		int srno = 0;
		array1 = new JSONArray();
		System.out.println("Inside EFORm Activity Dao Implasxqax ");
		Query query = sessionFactory.getCurrentSession().createQuery("from USER_SOFTWARE_MAP where USERNAME='" + UsernameTE + "'");
		List<USER_SOFTWARE_MAP> req = query.list();
		for (USER_SOFTWARE_MAP sourceDrive : req) {
			array = new JSONArray();
			srno = srno + 1;
			array.put(srno);
			
            array.put(sourceDrive.getUSERNAME());
   			array.put(sourceDrive.getPROJECT_ID());
            array.put(sourceDrive.getSTATUS());
   			array.put(sourceDrive.getPRODUCT_NAME());
			array.put(sourceDrive.getASSET_CODE());
			array.put(sourceDrive.getAPPLIED_DATE());
			
			
			array1.put(array);
		}
		return array1;

	}
	
	// SMTP Flow Start
	

@Override
		public JSONArray getUserSelectedDetails(String approvalname,String fullName) {
			////System.out.println("Inside getUserSelectedDetails method DAO fghghghghhg");
			

			JSONArray array1 = null;
			String loginuser="";
			try {
				
				array1 = new JSONArray();
			System.out.println("Inside getUserSelectedDetails method DAO fghghghghhg");
				Query dataList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+approvalname+"' and FULL_NAME='"+fullName+"'");
				List <loginmaster> list= dataList.list();	
				if(list.isEmpty())
				{
				JSONObject array =  new JSONObject();
				
						array.put("COMPANY","NA");
						array.put("BRANCH","NA");
						array.put("DEPARTMENT","NA");
						array.put("FULLNAME","NA");
						array.put("EMAIL","NA");
						array.put("ROLL_TYPE","NA");
//						////System.out.println("arra ia1 is "+array1);
						array1.put(array);
						System.out.println("data onchange : " + array1);
				}
				else
				{

					for (loginmaster sourceDrive : list) {
						JSONObject array =  new JSONObject();
						System.out.println("DDDDDD : " + sourceDrive);
						array.put("COMPANY",sourceDrive.getCOMPANY());					
						array.put("BRANCH",sourceDrive.getBRANCH());
						array.put("DEPARTMENT",sourceDrive.getDEPARTMENT());
						array.put("FULLNAME",sourceDrive.getFULL_NAME());
						array.put("EMAIL",sourceDrive.getEMAIL());
						array.put("ROLL_TYPE", sourceDrive.getROLE_TYPE());
//						////System.out.println("arra ia1 is "+array1);
						array1.put(array);
						
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
	//////System.out.println("array1 of the ;ist is "+array1);
			return array1;
		}
		
	/////////////////////////////////////////SMTP INSERT START////////////////////////////////
		
		
		@Override
		public String insertSoftwareRequest(String fullname, String compname, String site,
				String department, String phone, String emailid, String pid, String approup, String appserver,
				String appserverIp, String applicationServerloc, String servercityname, String noOfMail, String mailsize,
				String description, String expDate, MultipartFile empPic)
		{
			int id=0;
			String status="";
			String ticketTag = "";
			String companyName ="";
			System.out.println("appppp "  + approup);
			String NewTicketID = "";
			String[] split = approup.split("~");
			String appovalname=split[0];
			String approval_fullname=split[1];
			
			System.out.println("appppp "  + appovalname);
			try
			{	
				
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST.class)
						.setProjection(Projections.max("SRNO"));
				Integer srno1 = (Integer) crit.uniqueResult();

				////System.out.println(" SRNO IS: " + srno1);

				if (srno1 != null) {
					id = srno1.intValue();
					id = id + 1;
					////System.out.println("IN IF SRNO IS: " + id);
				} else {
					id = 1;
					////System.out.println("IN ELSE SRNO IS: " + id);
				}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
			////System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			////System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
//			String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
			////System.out.println("createnewfilename***" + createnewfilename);
//			createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

			String ext = "";
			String updatedFileName = null;
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			String loginuser="";
			String loginRoleType="";
			String statusOFTicket="Pending For Managers Approval";
			////System.out.println(dateFormat.format(date));
			String currenttime = dateFormat.format(date);
			
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
				loginRoleType = session.getAttribute("role").toString();
				 String string = session.getAttribute("GROUP").toString();
//				//System.out.println("group namme is dfdfed "+string);
				Date currentdate = dateFormat.parse(currenttime);
				companyName = session.getAttribute("companyname").toString();
				try {
					String imagefilePath;
					imagefilePath = "C:\\ITHelpDesk\\";
					try {
						File file = new File("C:\\ITHelpDesk\\");
						if (!file.exists()) {
							if (file.mkdir()) {
								////System.out.println("Directory is created!");
							} else {
								////System.out.println("Failed to create directory!");
							}
						}
					} catch (Exception e) {
						////System.out.println("directory create exception" + e);
					}

//		            File uploadedFile =  empPic;
					File uploadedFile = new File(empPic.getOriginalFilename());
					uploadedFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(uploadedFile);
					fos.write(empPic.getBytes());
					fos.close();

					String fileName = empPic.getOriginalFilename();

					ext = FilenameUtils.getExtension(fileName);

					File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);

					updatedFileName = createnewfilename + "." + ext;

					try {
						
						FileUtils.copyFile(uploadedFile, destFile);
						File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
						FileInputStream fis = new FileInputStream(filee);
					} catch (IOException ex) {

						status = "error";
						ex.printStackTrace();
					}
				} catch (Exception e) {

				}
			}
			catch (Exception e) {

			}
			
			try 
			{
				// Update the Phone number 
				 sessionFactory.getCurrentSession().createQuery("update loginmaster set PHONE='"+phone+"' where COMPANY='"+companyName+"'and USERNAME='"+loginuser+"'").executeUpdate();
	
				List<ticket_tag_master> tagList = sessionFactory.getCurrentSession().createQuery(
						"from ticket_tag_master where COMPANY='" + compname + "' and DEPARTMENT='" + department + "'")
						.list();
				for (ticket_tag_master sourceDrive : tagList) {
					ticketTag = sourceDrive.getTICKET_TAG();
				}
					NewTicketID = ticketTag + "EF-" + id;
					SMTP_REQUEST sr=new SMTP_REQUEST();
					sr.setT_ID(NewTicketID);
					sr.setT_REQUESTER(loginuser);
					sr.setT_REQUESTER_FULLNAME(fullname);
					sr.setRAISED_DATE(currenttime);
					sr.setSRNO(id);
					sr.setT_COMPANY(compname);
					sr.setT_BRANCH(site);
					sr.setT_DEPARTMENT(department);
					sr.setEMAIL_ID(emailid);
					sr.setT_PHONE(phone);
					sr.setP_ID(pid);
					sr.setAPPROVAR_NAME(appovalname);
					sr.setAPPROVAR_NAME_FULLNAME(approval_fullname);
					sr.setPRIORITY("P2");
					sr.setSEVERITY("Medium");
					sr.setSTATUS("Pending For Managers Approval");
					sr.setAPPLICATION_SERVER(appserver);
					sr.setAPPLICATION_SERVER_IP(appserverIp);
					sr.setSERVER_LOCATION_CODE(applicationServerloc);
					sr.setSERVER_LOCATION_CITY(servercityname);
					sr.setMAILS_PER_DAY(noOfMail);
					sr.setMAIL_SIZE(mailsize);
					sr.setDESCRIPTION(description);
					sr.setEXPIRY_DATE(expDate);

					
					
					if(updatedFileName==null)
					{
						sr.setATTACH_NAME("No File Available");
					}else
					{
						sr.setATTACH_NAME(updatedFileName);
					}
//					//System.out.println("sfgfgfdggfdgd gf g"+updatedFileName);
					sessionFactory.getCurrentSession().persist(sr);
					status = "success";
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			
			int sno = 0;
			try {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_TRACKING.class)
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

				e.printStackTrace();
				//System.out.println(e);
			}
//			String loginMasterData = getLoginMasterData();
		
			String msg = null;
			System.out.println("Fgbgbfgbgbgfbfggb");
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
					+ "<tr><td>Status:</td><td>"+statusOFTicket+"</td></tr>" + "<tr><td>Raised By:</td><td>" + loginuser+"  ["+fullname+ "]</td></tr>";
			SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(NewTicketID);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);
//			tickettrack.setCATEGORY(category);
//			tickettrack.setSUBCATEGORY1(subCat1);
//			tickettrack.setSUBCATEGORY2(subCat2);
//			tickettrack.setSUBJECT(subject);
			tickettrack.setSTATUS("Pending For Managers Approval");
			tickettrack.setPRIORITY("P2");
			tickettrack.setSEVERITY("Medium");
			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(loginuser);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(compname);
			tickettrack.setTICKET_RAISED_BY_COMPANY(compname);

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
			
			int ActSno = 0;
			try
			{
			
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
						.setProjection(Projections.max("SR_NO"));
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
	// TODO Auto-generated catch blockPendingApprovalBusinessRequest
				e.printStackTrace();
				//System.out.println(e);
			}

			SMTP_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(NewTicketID);
			ticketActivityLog.setPRIORITY("P2");
			ticketActivityLog.setSTATUS(statusOFTicket);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);
//			ticketActivityLog.setT_SUBJECT(subject);
			ticketActivityLog.setT_DESC(description);
			ticketActivityLog.setROLE_TYPE(loginRoleType);
			ticketActivityLog.setCHANGE_NOTES1(description);
//			ticketActivityLog.setT_CATEGORY(category);
//			ticketActivityLog.setT_SUB_CATEGORY1(subCat1);
			ticketActivityLog.setSEVERITY("Medium");
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
			
			}	
		catch (Exception e) {
			e.printStackTrace();
		}
//			try {
//				String ticketStatus="New";
//				if(status.equals("success"))
//				Inv.EmaiLSmsTriggerdInSoftwareRequest(NewTicketID, ticketStatus);
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
			return status+","+NewTicketID;
		
		
	}

//////////////////////////////////////SMTP INSERT  END ////////////////////////////////////////////////

		
		
		@Override
		public JSONArray getSMTPRequestList() {
			
			System.out.println("Inside SMTP Request Dao Impl ");
			JSONArray array=null;
			String loginuser="";
			String company="";
			JSONArray array1=null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
//				company = session.getAttribute("c").toString();
			
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			int srno=0;
			array1=new JSONArray();
			Query query=sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_REQUESTER='"+loginuser+"' OR STATUS='Rejected By Manager' ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC");
			List<SMTP_REQUEST> req=query.list();
			for(SMTP_REQUEST sourceDrive:req)
			{
				array = new JSONArray();
				srno=srno+1;
				array.put(srno);
				array.put(
						"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
								+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
//				array.put(sourceDrive.getT_ID());
//				if(sourceDrive.getSTATUS().equals("Resolved"))
//				{
////					array.put("<button class='btn btn-sm btn-danger' id='actionTicket'  name='Doem' onclick='actionTicket(\""
////							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
//				}
//				else
//				{
//					array.put(" ");
//				}
				if(sourceDrive.getSTATUS().equals("Rejected By Manager"))
				{
					array.put("<button class='btn btn-sm btn-warning' id='reOpen'  name='Doem' onclick='reOpen(\""
							+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
				}
				else
				{
					array.put(" ");
				}
				array.put(sourceDrive.getT_ID());
				array.put(sourceDrive.getSTATUS());
				array.put(sourceDrive.getT_COMPANY());
				array.put(sourceDrive.getT_BRANCH());
				array.put(sourceDrive.getT_DEPARTMENT());
				array.put(sourceDrive.getT_REQUESTER());
				array.put(sourceDrive.getT_REQUESTER_FULLNAME());
				array.put(sourceDrive.getRAISED_DATE());
				
				array.put(sourceDrive.getAPPROVAR_NAME());
				array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
				array.put(sourceDrive.getAPPROVAR_DATE());
//				array.put(sourceDrive.getAPPROVAL_NOTE());
				
				array.put(sourceDrive.getML_APPROVAR());
				array.put(sourceDrive.getML_APPROVAR_FULLNAME());
				array.put(sourceDrive.getML_APPROVAR_DATE());
//				array.put(sourceDrive.getML_APPROVAR_NOTE());
				
//				array.put(sourceDrive.getTEMP_DATE());
//				array.put(sourceDrive.getRAISED_DATE());
				array.put(sourceDrive.getAPPROVAR_DATE());
				array.put(sourceDrive.getCLOSED_DATE());
		
				array1.put(array);
			}
			return array1;
		}

	
		@Override
		public JSONArray gatherSMTPRequestDetails(String ticketid) {
			System.out.println("inside gatherBusinessRequestDetails");
			JSONArray array=null;
			JSONArray array1=null;
			String loginuser=null;
			String Company=null;
			String department = "";
			
			String sub_department = "";
			String location = "";
			String emailId="";
			String ContactNo="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
				Company=session.getAttribute("companyname").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				array=new JSONArray();
				Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
				
				Query getData=sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='"+ticketid+"'");
				
				List<SMTP_REQUEST> list=getData.list();
				for(SMTP_REQUEST ticketDrive:list)
				{
					JSONObject arrayobj=new JSONObject();
					Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
					List<loginmaster> listOfuser=getDataa.list();
					for (loginmaster loginDrive : listOfuser) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
						emailId=loginDrive.getEMAIL();
						ContactNo= loginDrive.getPHONE();									
					}
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);

					if(emailId.isEmpty()||emailId==null)
					{
						arrayobj.put("EMAIL", "NA");
					}
					else
					{
						arrayobj.put("EMAIL", emailId);
					}
					if(ContactNo.isEmpty()||ContactNo==null)
					{
						arrayobj.put("PHONE", "NA");
					}
					else
					{
						arrayobj.put("PHONE",ContactNo);
					}
					arrayobj.put("T_ID",ticketDrive.getT_ID());
					arrayobj.put("STATUS",ticketDrive.getSTATUS());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("P_ID", ticketDrive.getP_ID());				
			
					arrayobj.put("APPROVAR_NAME", ticketDrive.getAPPROVAR_NAME());
					arrayobj.put("APPLICATION_SERVER",ticketDrive.getAPPLICATION_SERVER());
					arrayobj.put("APPLICATION_SERVER_IP",ticketDrive.getAPPLICATION_SERVER_IP());
					arrayobj.put("SERVER_LOCATION_CITY",ticketDrive.getSERVER_LOCATION_CITY());
					arrayobj.put("DESC",ticketDrive.getDESCRIPTION());
					
					
	
					String AttachName = ticketDrive.getATTACH_NAME();
					System.out.println("Attachement name"+AttachName);
					try {
						if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
							arrayobj.put("T_ATTACH_NAME", "No File Available");
							//System.out.println("Null object found");
						} else {
							arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
							//System.out.println("Object found");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//System.out.println("IN CATCH BLOCK");
//						arrayobj.put("T_ATTACH1_NAME", "No File Available");
						e.printStackTrace();
					}
					array.put(arrayobj);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}

			return array;
		}


		
		@Override
		public JSONArray getSMTPRequestActivityLog(String ticketid) {
			//System.out.println("Inside UserActivityDaoImpl getUserTicketTracking method");
					JSONArray array = new JSONArray();
					System.out.println("inside business activivty log dao" + ticketid);
					try {
						Query queryticketActivity = sessionFactory.getCurrentSession()
								.createQuery("from SMTP_REQUEST_ACTIVITYLOG where T_ID=:T_ID order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
						queryticketActivity.setParameter("T_ID", ticketid);
						List<SMTP_REQUEST_ACTIVITYLOG> ticketActivity = queryticketActivity.list();
						for (SMTP_REQUEST_ACTIVITYLOG sourceDrive : ticketActivity) {
							JSONObject arrayobjtemp = new JSONObject();
							arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
							arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
							arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
							arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
							arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
							arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
							arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
							arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
							arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
							arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
							arrayobjtemp.put("FULLNAME",sourceDrive.getT_FULLNAME());
							arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
							array.put(arrayobjtemp);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("inside business activivty log end dao" + array);
					return array;
		}



		@Override
		public JSONArray getSMTPRequestID() {
			String LoginUser = null;
			String loginUserCompany = null;
			  String FinalGroup=null;
	          String GroupOfTc=null;
	      
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				 String GROUPNAME = session.getAttribute("GROUP").toString();
		            System.out.println("usernamesdfdffdfdffmeeem" + GROUPNAME);
		          
		            if(!GROUPNAME.equals("NA"))
					{
						if(GROUPNAME.contains(","))
						{
							System.out.println("inside if with , condition");
						String[] split = GROUPNAME.split(",");
						for (int i = 0; i < split.length; i++) {
							if (split[i].equals("Mail Admin"))
							{
								FinalGroup = split[i];
								}
						}
						}else
						{
							FinalGroup=GROUPNAME;
						System.out.println("group nsame is "+FinalGroup);

						}	
					}
					else
					{
						FinalGroup="NA";
					}
				//System.out.println("username****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			JSONArray array = null;
			JSONArray array1 = null;
		
				if (!(FinalGroup.isEmpty()) && FinalGroup.equals("Mail Admin")
					) {
					try {
						List<Object> dataList = sessionFactory.getCurrentSession()
								.createQuery("select T_ID from SMTP_REQUEST GROUP BY T_ID  ORDER BY SRNO DESC").list();
						array1 = new JSONArray();
						for (Object sourceDrive : dataList) {
							array = new JSONArray();
							array.put(sourceDrive);
							array1.put(array);
						}
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
	
				} else {
					try {
						List<Object> dataList = sessionFactory.getCurrentSession()
								.createQuery("select T_ID from SMTP_REQUEST where T_REQUESTER='" + LoginUser
										+ "' and T_COMPANY='" + loginUserCompany
										+ "' order by STR_TO_DATE(RAISED_DATE,'%d-%m-%Y %H:%i:%s') DESC")
								.list();
						array1 = new JSONArray();
						for (Object sourceDrive : dataList) {
							array = new JSONArray();
							array.put(sourceDrive.toString());
							array1.put(array);
							
					
						}
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
//				}
			}
					System.out.println("value of array 1 in dao impl " + array1);
			return array1;
			
		}

	


		@Override
		public JSONArray getUserSMTPRequestTracking(String ticketid) {
			System.out.println("inside dao IMPL request data");
			//System.out.println("Inside UserActivityDaoImpl getUserTicketTracking method");
			JSONArray array1 = null;

			try {
				System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking");
				List<SMTP_REQUEST> dataList = sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='" + ticketid + "'").list();
			
					
					array1 = new JSONArray();
					for (SMTP_REQUEST sourceDrive : dataList) {
		
						String department = "";
						String sub_department = "";
						String location = "";
						List<loginmaster> loginDataList = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where USERNAME ='" + sourceDrive.getT_REQUESTER() + "' and COMPANY ='" + sourceDrive.getT_COMPANY() + "'").list();
						for (loginmaster loginDrive : loginDataList) {
							department = loginDrive.getDEPARTMENT();
							sub_department = loginDrive.getSUB_DEPARTMENT();
							location = loginDrive.getLOCATION();
						}
		
						JSONObject arrayobj = new JSONObject();
						arrayobj.put("T_ID", sourceDrive.getT_ID());
						arrayobj.put("T_DATE", sourceDrive.getRAISED_DATE());
						arrayobj.put("T_REQUESTER", sourceDrive.getT_REQUESTER());
						arrayobj.put("T_MAIL", sourceDrive.getEMAIL_ID());
						arrayobj.put("T_PHONE", sourceDrive.getT_PHONE());
						arrayobj.put("T_COMPANY", sourceDrive.getT_COMPANY());
						arrayobj.put("T_BRANCH", sourceDrive.getT_BRANCH());
						arrayobj.put("DEPARTMENT", department);
						arrayobj.put("SUB_DEPARTMENT", sub_department);
						arrayobj.put("LOCATION", location);
						arrayobj.put("T_DESC", sourceDrive.getDESCRIPTION());
						arrayobj.put("T_ATTACH1_NAME", sourceDrive.getATTACH_NAME());
						arrayobj.put("STATUS", sourceDrive.getSTATUS());
						arrayobj.put("PRIORITY", sourceDrive.getPRIORITY());
						arrayobj.put("SEVERITY", sourceDrive.getSEVERITY());
		
						
						
						System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking JSON OBJ ARRAY 1"+array1);
		
						Query queryticketTracking = sessionFactory.getCurrentSession()
								.createQuery("from SMTP_REQUEST_TRACKING where T_ID=:T_ID  order by STR_TO_DATE(ACTIVITY_DATE , '%d-%m-%Y %H:%i:%s')  desc");
						queryticketTracking.setParameter("T_ID", ticketid);
						List<SMTP_REQUEST_TRACKING> ticketTracking = queryticketTracking.list();
						JSONArray array2 = new JSONArray();
						for (SMTP_REQUEST_TRACKING sourceDrive1 : ticketTracking) {
							JSONObject arrayobjtemp = new JSONObject();
							arrayobjtemp.put("MESSAGE", sourceDrive1.getMESSAGE());
							arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive1.getATTACHMENT_NAME());
							arrayobjtemp.put("CURRENT_STATUS", sourceDrive1.getSTATUS());
							array2.put(arrayobjtemp);
							
							System.out.println("inside dao IMPL INSIDE TRY getUserRequestTracking JSON OBJ ARRAY 2"+array2);
						}
						arrayobj.put("STATUS_LOG", array2);
						array1.put(arrayobj);
					}
					//System.out.println("db_cname: " + array1);
				
			
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return array1;
		}


		
		@Override
		public JSONArray getUserSMTPRaisedRequest() {
			System.out.println("Inside getUserSMTPRaisedRequest method");

					String LoginUser = null;
					String LoginScope = null;				
					String company=null;
					String status = null;
					String designation = null;
					try {
						ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
								.getRequestAttributes();
						HttpSession session = requestAttributes.getRequest().getSession();
						LoginUser = session.getAttribute("username").toString();		
						designation = session.getAttribute("designation").toString();
						LoginScope = session.getAttribute("loginscope").toString();
						company = session.getAttribute("companyname").toString();
						
						
						System.out.println("usernameBusiness****" + LoginUser);
						System.out.println("LoginScope****" + LoginScope);
						System.out.println("designation  ***" +designation);
						System.out.println("CompanyCompany  ***" +company);
					} catch (Exception e) {
						e.printStackTrace();
						//System.out.println("Exceptioon e***" + e);
					}
					JSONArray array = null;
					JSONArray array1 = null;
					int srno = 0;
					try {
						System.out.println("inside the query DAO IMPL QUERY Try Block : " );
						//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
						
						List<SMTP_REQUEST> dataList = sessionFactory.getCurrentSession()
								.createQuery("from SMTP_REQUEST where (APPROVAR_NAME='"+LoginUser+"' and STATUS='Approval For Manager' OR STATUS ='Re-Opened' and T_COMPANY='"+company+"') ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC").list(); // ORDER BY STR_TO_DATE(RAISED_DATE , '%d-%m-%Y %H:%i:%s') DESC)
						array1 = new JSONArray();
						System.out.println("inside the query DAO IMPL : " + dataList);
						for (SMTP_REQUEST sourceDrive : dataList) {
							srno = srno + 1;
							//System.out.println("array = " + sourceDrive.getPRIORITY());
							array = new JSONArray();

							array.put(
									"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
											+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
							array.put(
									"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
							/*
							 * array.
							 * put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
							 * + sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
							 */

							array.put(sourceDrive.getT_ID());
							System.out.println("");
							array.put(sourceDrive.getSTATUS());
//							array.put(sourceDrive.getPRIORITY());
//							array.put(sourceDrive.getSEVERITY());
//							
							array.put(sourceDrive.getT_COMPANY());
							array.put(sourceDrive.getT_BRANCH());
							array.put(sourceDrive.getT_DEPARTMENT());
						
							array.put(sourceDrive.getT_REQUESTER());
							array.put(sourceDrive.getT_REQUESTER_FULLNAME());
//							array.put(sourceDrive.getP_ID());
							
//							array.put(sourceDrive.getREQUEST_TYPE());
							array.put(sourceDrive.getAPPROVAR_NAME());
							array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
							array.put(sourceDrive.getRAISED_DATE());
			
							array1.put(array);
							System.out.println("inside the query DAO IMPL : " + array1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return array1;
		}


		@Override
		public JSONArray getSMTPPendingApprovalDetails(String ticketid) {
			System.out.println("inside getSMTPPendingApprovalDetails");
			JSONArray array=null;
			JSONArray array1=null;
			String loginuser=null;
			String Company=null;
			String department = "";
			
			String sub_department = "";
			String location = "";
			String emailId="";
			String ContactNo="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
				Company=session.getAttribute("companyname").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				array=new JSONArray();
				Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
				
				Query getData=sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='"+ticketid+"'");
				
				List<SMTP_REQUEST> list=getData.list();
				for(SMTP_REQUEST ticketDrive:list)
				{
					JSONObject arrayobj=new JSONObject();
					Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
					List<loginmaster> listOfuser=getDataa.list();
					for (loginmaster loginDrive : listOfuser) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
						emailId=loginDrive.getEMAIL();
						ContactNo= loginDrive.getPHONE();
					}
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
										
					if(emailId.isEmpty()||emailId==null)
					{
						arrayobj.put("EMAIL", "NA");
					}
					else
					{
						arrayobj.put("EMAIL", emailId);
					}
					if(ContactNo.isEmpty()||ContactNo==null)
					{
						arrayobj.put("PHONE", "NA");
					}
					else
					{
						arrayobj.put("PHONE",ContactNo);
					}
					
					arrayobj.put("T_ID",ticketDrive.getT_ID());
					arrayobj.put("STATUS",ticketDrive.getSTATUS());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("P_ID", ticketDrive.getP_ID());		
			
					
					arrayobj.put("APPROVAL_NAME", ticketDrive.getAPPROVAR_NAME());
					arrayobj.put("SERVER_LOCATION_CITY", ticketDrive.getSERVER_LOCATION_CITY());
					arrayobj.put("APPLICATION_SERVER", ticketDrive.getAPPLICATION_SERVER());
					arrayobj.put("APPLICATION_SERVER_IP", ticketDrive.getAPPLICATION_SERVER_IP());
					arrayobj.put("T_DESCRIPTION", ticketDrive.getDESCRIPTION());
	
					String applicationserver = ticketDrive.getAPPLICATION_SERVER();
					String applicationserverIP = ticketDrive.getAPPLICATION_SERVER_IP();
					String applicationserverCity = ticketDrive.getSERVER_LOCATION_CITY();
					String description = ticketDrive.getDESCRIPTION();
			
					
					String AttachName = ticketDrive.getATTACH_NAME();
					System.out.println("Attachement name"+AttachName);
					try {
						if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
							arrayobj.put("T_ATTACH_NAME", "No File Available");
						
						} else {
							arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
							
						}
					} catch (Exception e) {
					
						e.printStackTrace();
					}
					array.put(arrayobj);
					System.out.println(" Value of array : " + array);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}

			return array;
		}


		
		// inside viewTicket Activity log method
		@Override
		public JSONArray getSMTPPendingTicketRequestActivityLog(String ticketid) {
			JSONArray array = new JSONArray();
			try {
				Query queryticketActivity = sessionFactory.getCurrentSession()
						.createQuery("from SMTP_REQUEST_ACTIVITYLOG where T_ID=:T_ID order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
				queryticketActivity.setParameter("T_ID", ticketid);
				List<SMTP_REQUEST_ACTIVITYLOG> ticketActivity = queryticketActivity.list();
				for (SMTP_REQUEST_ACTIVITYLOG sourceDrive : ticketActivity) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
					arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
					arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
					String fffff = sourceDrive.getT_ATTACH_NAME();
					System.out.println("empic filem name pending to approve 36948 "  + fffff);
					
					arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
					arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
					arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
					arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
					arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//					arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//					arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//					arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
					arrayobjtemp.put("FULLNAME",sourceDrive.getT_FULLNAME());
					arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
					array.put(arrayobjtemp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return array;
		}

		// ticket action
		
		@Override
		public JSONArray SMTPPendingActionDetails(String id) {

			//System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");

			JSONArray array1 = null;

			String LoginUser = null;
			String loginUserCompany = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("username****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}

			try {
				List<SMTP_REQUEST> ticketList = sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='"+id+"'").list();
				
				List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'").list();
				
				System.out.println("LOGIN MASTER VALUE : "+ tpList);
				
				array1 = new JSONArray();

				for (SMTP_REQUEST ticketDrive : ticketList) {

					for (loginmaster tpDrive : tpList) {    
						System.out.println("LOGIN MASTER VALUE  forrrrrrr : "+ ticketDrive);
						JSONObject arrayobj = new JSONObject();
					
						arrayobj.put("T_REQUESTER",ticketDrive.getT_REQUESTER());
						arrayobj.put("T_REQUESTER_FULLNAME",ticketDrive.getT_REQUESTER_FULLNAME());			
						arrayobj.put("COMPANY",ticketDrive.getT_COMPANY());
						arrayobj.put("BRANCH",ticketDrive.getT_BRANCH());
						arrayobj.put("DEPARTMENT",ticketDrive.getT_DEPARTMENT());					
						arrayobj.put("EMAIL",ticketDrive.getEMAIL_ID());					
						arrayobj.put("PID",ticketDrive.getP_ID());
						arrayobj.put("T_ID",ticketDrive.getT_ID());
						
						arrayobj.put("T_PHONE",ticketDrive.getT_PHONE());					
						arrayobj.put("RAISE_DATE",ticketDrive.getRAISED_DATE());
						
						arrayobj.put("APPROVAL_NAME",ticketDrive.getAPPROVAR_NAME());
						
						arrayobj.put("APPLICATION_SERVER",ticketDrive.getAPPLICATION_SERVER());
						arrayobj.put("APPLICATION_SERVER_IP",ticketDrive.getAPPLICATION_SERVER_IP());
						arrayobj.put("SERVER_LOCATION_CITY",ticketDrive.getSERVER_LOCATION_CITY());
						arrayobj.put("T_DESCRIPTION",ticketDrive.getDESCRIPTION());
						
						arrayobj.put("NO_OF_MAIL",ticketDrive.getMAILS_PER_DAY());
						arrayobj.put("MAIL_SIZE",ticketDrive.getMAIL_SIZE());
						
						arrayobj.put("STATUS",ticketDrive.getSTATUS());

						arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
						
						String usernameGal = tpDrive.getUSERNAME();
						String galfullName = tpDrive.getFULL_NAME();					
						System.out.println("user name : "+ usernameGal);
						System.out.println("FULL NAME : " + galfullName);
						
						arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
						arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
						arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
						arrayobj.put("TP_PHONE", tpDrive.getPHONE());
						arrayobj.put("TP_MAIL", tpDrive.getEMAIL());					
						arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());
						arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
						
						List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER() + "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'").list();
						for(loginmaster  t_requesrterdetailsnew:t_requesrterdetails)
						{
							
							System.out.println("Login master values data : " + t_requesrterdetailsnew);
							arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
							arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());
							
						}

						array1.put(arrayobj);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return array1;
		}

		@Override
		public String InsertSMTPRequestApprovedByMAnager(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid,
				String companyRaisedBy, String raisedByName, String ticketidupdateTDassign) {
			
		// TODO Auto-generated method stub
		
		System.out.println("inside dao impl business request gal update submit button action ");
		int id=0;
		System.out.println("empic file name in daoimpl  : " + empPic);
		String status="";
		String FullNameOfLogin="";
		
		String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
		System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
		DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(localdate.format(now));
		String localDateNow = localdate.format(now);
//		String createnewfilename = UUID.randomUUID().toString();
		String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
		System.out.println("createnewfilename***" + createnewfilename);
//		createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));

		String ext = "";
		String updatedFileName = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = null;
		date = new Date();
		String loginuser="";
		String loginRoleType="";
		String company="";
		//System.out.println(dateFormat.format(date));
		String currenttime = dateFormat.format(date);
		String EMAIL=null;
		String PHONE=null;
		String tid = null;
		
		try {
			
			System.out.println("inside higher try block using session inside the try block");
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpSession session = requestAttributes.getRequest().getSession();
			loginuser = session.getAttribute("username").toString();
			loginRoleType = session.getAttribute("role").toString();
			company=session.getAttribute("companyname").toString();
			FullNameOfLogin = session.getAttribute("fullname").toString();
//			tid = session.getAttribute("tid").toString();			
			System.out.println("username for 36948 :"+ loginuser);
			System.out.println("fullname for 36948 :"+ FullNameOfLogin);
			System.out.println("company for 36948 :"+ company);
			Date currentdate = dateFormat.parse(currenttime);
			try
			{
				System.out.println("inside another try block email and phone ");
				Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
				List<Object[]> list=getLoginData.list();
				for(Object[] obj:list)
				{
					EMAIL = obj[0].toString();
					PHONE=obj[1].toString();
				}
				System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				System.out.println("inside the try block");
				String imagefilePath;
				imagefilePath = "C:\\ITHelpDesk\\";
				try {
					System.out.println("inside the inner try block");
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

				System.out.println("file code start");
//	            File uploadedFile =  empPic;
				File uploadedFile = new File(empPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(empPic.getBytes());
				fos.close();
				//System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = empPic.getOriginalFilename();
				System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				System.out.println("destFile........" + destFile);
				// //System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME smtp: " + updatedFileName);

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
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
		try 
		{
			
			System.out.println("FDullanrme "+FullNameOfLogin);			
			Query updatesr=sessionFactory.getCurrentSession().createQuery("update SMTP_REQUEST set APPROVAR_NAME=:APPROVAR_NAME,APPROVAR_NAME_FULLNAME=:APPROVAR_NAME_FULLNAME,APPROVAR_DATE=:APPROVAR_DATE,APPROVAL_NOTE=:APPROVAL_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS where T_ID=:T_ID"); //,ATTACH_NAME=:ATTACH_NAME
			updatesr.setParameter("APPROVAR_NAME",loginuser);
			updatesr.setParameter("APPROVAR_NAME_FULLNAME",FullNameOfLogin);		
			updatesr.setParameter("APPROVAR_DATE",currenttime);
			updatesr.setParameter("STATUS",Status);
			updatesr.setParameter("APPROVAL_NOTE",approvenote);
			
			System.out.println("Fullanrme 36948 "+ FullNameOfLogin);
			System.out.println("user 36948 "+ loginuser);
					
			System.out.println("value of success : " + Status);
			System.out.println("value of success : " + updatesr);
			updatesr.setParameter("GROUPNAME","Mail Admin");
		
			
			updatesr.setParameter("T_ID",ticketidupdateTDassign);
			
				int executeUpdate = updatesr.executeUpdate();
				if(executeUpdate>0)
				{
					status = "success";
					
					System.out.println("value of another status : " + status);
				}
				else
				{
					status="error";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		//////////////////////// Tracking start ////////////////////////////////////////
		int sno = 0;
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_TRACKING.class)
					.setProjection(Projections.max("SR_NO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			System.out.println(" SNO IS: " + srno1);

			if (srno1 != null) {
				sno = srno1.intValue();
				sno = sno + 1;
				System.out.println("IN IF SNO IS: " + sno);
			} else {
				sno = 1;
				System.out.println("IN ELSE SNO IS: " + sno);
			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e);
		}
		String msg = null;
		String[] split = Status.split(" ");
		String approve=split[0];
		msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
				+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
		SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();

		tickettrack.setSR_NO(sno);
		tickettrack.setT_ID(ticketidupdateTDassign);
		tickettrack.setACTIVITY_DATE(currenttime);
		tickettrack.setACTIVITY_NAME(loginuser);

		tickettrack.setSTATUS(Status);
		tickettrack.setATTACHMENT_NAME(updatedFileName);;
		System.out.println("status of 36948 tracking : " + updatedFileName);
		tickettrack.setPRIORITY("P2");
		tickettrack.setSEVERITY("Medium");
		System.out.println("status of 36948 tracking : " + Status);
		tickettrack.setMESSAGE(msg);
		tickettrack.setTICKET_RAISED_NAME(raisedByName);
		tickettrack.setACTIVITY_DATE_TIME(currenttime);
		tickettrack.setACTIVITY_COMPANY(company);
		tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

		if (updatedFileName == null) {
			System.out.println("tacking empic file name if condition : " + updatedFileName);
			tickettrack.setATTACHMENT_NAME("No File Available");
		} else {
			tickettrack.setATTACHMENT_NAME(updatedFileName);
			System.out.println("tacking empic file name : " + updatedFileName);
		}
		System.out.println("tacking empic file name : " + updatedFileName);
		sessionFactory.getCurrentSession().persist(tickettrack);

		///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
		
		int ActSno = 0;
		try
		{
		
		try {

			Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
					.setProjection(Projections.max("SR_NO"));
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
// 			TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

		SMTP_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();

		ticketActivityLog.setSR_NO(ActSno);
		ticketActivityLog.setT_ID(ticketidupdateTDassign);
		ticketActivityLog.setSTATUS(Status);
		ticketActivityLog.setT_DATETIME(currenttime);
		ticketActivityLog.setT_CHANGEBY(loginuser);

		ticketActivityLog.setT_DESC(approvenote);
		ticketActivityLog.setROLE_TYPE(loginRoleType);

		ticketActivityLog.setPRIORITY("P2");
		ticketActivityLog.setSEVERITY("Medium");
		ticketActivityLog.setT_COMPANY(company);
		ticketActivityLog.setT_EMAIL(EMAIL);

		ticketActivityLog.setT_CONTACT_NO(PHONE);
		ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
		ticketActivityLog.setCHANGE_NOTES1(approvenote);
		if (updatedFileName == null) {
			System.out.println("activity log epic file name :" + updatedFileName);
			ticketActivityLog.setT_ATTACH_NAME("No File Available");
		} else {
			ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			System.out.println("activity log epic file name aaaaaa :" + updatedFileName);
		}

		sessionFactory.getCurrentSession().persist(ticketActivityLog);
		}	
	catch (Exception e) {
		e.printStackTrace();
	}
//		try {			
//			if(status.equals("success"))
//			Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return status+"~"+id;
		}
		
		
		//SMTP REQUEST FLOW START
	
	//mail update flow
		@Override
		public JSONArray getMailAdminSMTPRequest() {
			System.out.println("Inside Mail Admin DaoImpl method");

			String LoginUser = null;
			String LoginScope = null;				
			String company=null;
			String status = null;
			String designation = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();		
				designation = session.getAttribute("designation").toString();
				LoginScope = session.getAttribute("loginscope").toString();
				company = session.getAttribute("companyname").toString();
				
				
//				System.out.println("username****" + LoginUser);
//				System.out.println("LoginScope****" + LoginScope);
//				System.out.println("designation  ***" +designation);
//				System.out.println("companyname  ***" +company);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			JSONArray array = null;
			JSONArray array1 = null;
			int srno = 0;
			try {
				System.out.println("inside the query DAO IMPL QUERY Try Block Mail Admin : " );
				//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
				
				List<SMTP_REQUEST> dataList = sessionFactory.getCurrentSession()
						.createQuery("from SMTP_REQUEST where (APPROVAR_NAME='"+LoginUser+"' OR STATUS='Approved By Manager' OR STATUS='Hold') order by STR_TO_DATE(APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc").list();
				array1 = new JSONArray();
				array1 = new JSONArray();
				System.out.println("inside the query DAO IMPL Mail Admin  QUERY: " + dataList);
				for (SMTP_REQUEST sourceDrive : dataList) {
					srno = srno + 1;
					//System.out.println("array = " + sourceDrive.getPRIORITY());
					array = new JSONArray();

					array.put(
							"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
					array.put(
							"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
					
//					  array.
//					  put("<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
//					  + sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
					 

					array.put(sourceDrive.getT_ID());
					System.out.println("");
					array.put(sourceDrive.getSTATUS());
			
					
					array.put(sourceDrive.getT_COMPANY());
					array.put(sourceDrive.getT_BRANCH());
					array.put(sourceDrive.getT_DEPARTMENT());	
					
					array.put(sourceDrive.getT_REQUESTER());
					array.put(sourceDrive.getT_REQUESTER_FULLNAME());
					array.put(sourceDrive.getRAISED_DATE());
//					array.put(sourceDrive.getT_DESC());
					
					array.put(sourceDrive.getAPPROVAR_NAME());
					array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
					array.put(sourceDrive.getAPPROVAR_DATE());
//					array.put(sourceDrive.getAPPROVAL_NOTE());
					
					array1.put(array);
					System.out.println("inside the query DAO IMPLMail Admin : " + array1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return array1;
		}

		@Override
		public JSONArray getMailAdminSMTPBucket() {
			System.out.println("Inside Mail Admin DaoImpl method");

			String LoginUser = null;
			String LoginScope = null;				
			String company=null;
			String status = "Work in Progress";
			String designation = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();		
				designation = session.getAttribute("designation").toString();
				LoginScope = session.getAttribute("loginscope").toString();
				company = session.getAttribute("companyname").toString();
				
				
//				System.out.println("username****" + LoginUser);
//				System.out.println("LoginScope****" + LoginScope);
//				System.out.println("designation  ***" +designation);
//				System.out.println("companyname  ***" +company);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}
			JSONArray array = null;
			JSONArray array1 = null;
			int srno = 0;
			try {
				System.out.println("inside the query DAO IMPL QUERY Try Block Mail Admin : " );
				//"from BUSINESS_ID_REQUEST where (APPROVAR_NAME='"+approvalName+"' and LEVEL_1_APPROVER_NAME='"+LoginUser+"' and LEVEL_1_STATUS is null and T_COMPANY='"+company+"' or LEVEL_2_DESIGNATION='"+designation+"' and LEVEL_2_APPROVER_NAME='"+LoginUser+"' and LEVEL_2_STATUS is null and T_COMPANY='"+company+"') and STATUS<>'Closed' order by STR_TO_DATE(CURRENT_STATUS_ACTIVITY_TIME ,'%d-%m-%Y %H:%i:%s') desc").list()
				
				List<SMTP_REQUEST> dataList = sessionFactory.getCurrentSession()
						.createQuery("from SMTP_REQUEST where (APPROVAR_NAME='"+LoginUser+"' OR STATUS='Work in Progress' OR STATUS='Resolved') order by STR_TO_DATE(ML_APPROVAR_DATE ,'%d-%m-%Y %H:%i:%s') desc").list();
				array1 = new JSONArray();
				array1 = new JSONArray();
				System.out.println("inside the query DAO IMPL Mail Admin  QUERY: " + dataList);
				for (SMTP_REQUEST sourceDrive : dataList) {
					srno = srno + 1;
					
					String statusTesting = sourceDrive.getSTATUS();
					System.out.println("statusTesting VALUE IS  = " + statusTesting);
					
					array = new JSONArray();

					array.put(
							"<button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modelCompany' onclick='viewTicket(\""
									+ sourceDrive.getT_ID() + "\")'><i class='fa fa-eye'></i></button>");
					if(sourceDrive.getSTATUS().equals("Work in Progress"))
					{
					array.put(
							"<button class='btn btn-sm btn-warning' id='assignticket'  name='Doem' onclick='assignTicket(\""+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
					}
					else if(sourceDrive.getSTATUS().equals("Resolved")) {
						array.put(
								"<button class='btn btn-sm btn-danger' id='closeTicket'  name='Doem' onclick='closeTicket(\""
										+ sourceDrive.getT_ID() + "\")'><i class='fa fa-check'></i></button>");
					} else {
						System.out.println("i am in closed");
						array.put("");
					}
					  

					array.put(sourceDrive.getT_ID());
					System.out.println("");
					array.put(sourceDrive.getSTATUS());				
					array.put(sourceDrive.getT_COMPANY());
					array.put(sourceDrive.getT_BRANCH());
					array.put(sourceDrive.getT_DEPARTMENT());
					
					array.put(sourceDrive.getT_REQUESTER());
					array.put(sourceDrive.getT_REQUESTER_FULLNAME());
					array.put(sourceDrive.getRAISED_DATE());
//					array.put(sourceDrive.getT_DESC());
					
					array.put(sourceDrive.getAPPROVAR_NAME());
					array.put(sourceDrive.getAPPROVAR_NAME_FULLNAME());
					array.put(sourceDrive.getAPPROVAR_DATE());
//					array.put(sourceDrive.getAPPROVAL_NOTE());
					
//					array.put(sourceDrive.getGALUPDATE_USERNAME());
//					array.put(sourceDrive.getGALUPDATE_FULLNAME());
//					array.put(sourceDrive.getGALUPDATE_APPROVAL_DATE());
////					array.put(sourceDrive.getGALUPDATE_NOTE());
//					
					array.put(sourceDrive.getML_APPROVAR());
					array.put(sourceDrive.getML_APPROVAR_FULLNAME());
					array.put(sourceDrive.getML_APPROVAR_DATE());
//					array.put(sourceDrive.getGALUPDATE_NOTE());
						 
					array1.put(array);
					System.out.println("inside the query DAO IMPLMail Admin : " + array1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return array1;
		}

//		@Override
//		public String InsertBusinessRequestApprovedByGalUpdate(String appByITComp, String Status, String approvenote,
//				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
//				String raisedByName, String ticketidupdateTDassign) {
//			System.out.println("inside dao impl business request gal update submit button action ");
//			int id=0;
//			String status="";
//			String FullNameOfLogin="";	
//			String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());	
//			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
//			LocalDateTime now = LocalDateTime.now();		
//			String localDateNow = localdate.format(now);
//			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;
//			
//
//			String ext = "";
//			String updatedFileName = null;
//			DateFormat dateFormat = null;
//			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			Date date = null;
//			date = new Date();
//			String loginuser="";
//			String loginRoleType="";
//			String company="";
//			String currenttime = dateFormat.format(date);
//			String EMAIL=null;
//			String PHONE=null;
//			String tid = null;
//			
//			try {
//				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//						.getRequestAttributes();
//				HttpSession session = requestAttributes.getRequest().getSession();
//				loginuser = session.getAttribute("username").toString();//loginuser
//				loginRoleType = session.getAttribute("role").toString();
//				company=session.getAttribute("companyname").toString();
//				FullNameOfLogin = session.getAttribute("fullname").toString();
//
//				
//				System.out.println("username for galupdate :"+ loginuser);
//				System.out.println("fullname for galupdate :"+ FullNameOfLogin);
//				Date currentdate = dateFormat.parse(currenttime);
//				try
//				{
//					Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
//					List<Object[]> list=getLoginData.list();
//					for(Object[] obj:list)
//					{
//						EMAIL = obj[0].toString();
//						PHONE=obj[1].toString();
//					}
//					System.out.println("EMAIL??????????????????????"+EMAIL+"PHONE?????????????????"+PHONE);
//					
//				}catch (Exception e) {
//					
//				}
//				
//				try {
//					String imagefilePath;
//					imagefilePath = "C:\\ITHelpDesk\\";
//					try {
//						File file = new File("C:\\ITHelpDesk\\");
//						if (!file.exists()) {
//							if (file.mkdir()) {
//								
//							} else {
//								
//							}
//						}
//					} catch (Exception e) {
//						
//					}
//
//					File uploadedFile = new File(empPic.getOriginalFilename());
//					uploadedFile.createNewFile();
//					FileOutputStream fos = new FileOutputStream(uploadedFile);
//					fos.write(empPic.getBytes());
//					fos.close();
//					
//					String fileName = empPic.getOriginalFilename();
//					
//					ext = FilenameUtils.getExtension(fileName);
//					
//					File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//					
//					updatedFileName = createnewfilename + "." + ext;
//					
//
//					try {
//						
//						FileUtils.copyFile(uploadedFile, destFile);
//						File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
//						FileInputStream fis = new FileInputStream(filee);
//					} catch (IOException ex) {
//						//System.out.println("Could not copy file " + fileName);
//						status = "error";
//						ex.printStackTrace();
//					}
//				} catch (Exception e) {
//					//System.out.println("directory create exception" + e);
//				}
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//			}
//		
//			try 
//			{
//				
//				System.out.println("FDullanrme "+FullNameOfLogin);			
//				
//				Query updatesr=sessionFactory.getCurrentSession().createQuery("update BUSINESS_ID_REQUEST set GALUPDATE_USERNAME=:GALUPDATE_USERNAME,GALUPDATE_FULLNAME=:GALUPDATE_FULLNAME,GALUPDATE_APPROVAL_DATE=:GALUPDATE_APPROVAL_DATE,GALUPDATE_NOTE=:GALUPDATE_NOTE,GROUPNAME=:GROUPNAME,STATUS=:STATUS,ATTACH_NAME=:ATTACH_NAME where T_ID=:T_ID");
//				updatesr.setParameter("GALUPDATE_FULLNAME",FullNameOfLogin);
//				updatesr.setParameter("GALUPDATE_USERNAME",loginuser);
//				updatesr.setParameter("GALUPDATE_APPROVAL_DATE",currenttime);
//				updatesr.setParameter("STATUS",Status);
//				updatesr.setParameter("GALUPDATE_NOTE",approvenote);
//				
//				System.out.println("FDullanrme galupdate "+FullNameOfLogin);
//				System.out.println("user galupdate "+ loginuser);
//						
//				System.out.println("value of success : " + Status);
//				System.out.println("value of success : " + updatesr);
//				updatesr.setParameter("GROUPNAME","Mail Admin");
//			
//				updatesr.setParameter("T_ID",ticketidupdateTDassign);
//				if(updatedFileName==null)
//				{
//					updatesr.setParameter("ATTACH_NAME","No File Available");
//				}
//				else
//				{
//					updatesr.setParameter("ATTACH_NAME",updatedFileName);
//				}
//				updatesr.setParameter("T_ID",ticketidupdateTDassign);
//				
//					int executeUpdate = updatesr.executeUpdate();
//					if(executeUpdate>0)
//					{
//						status = "success";
//						
//						System.out.println("value of another status : " + status);
//					}
//					else
//					{
//						status="error";
//					}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			
//			//////////////////////// Tracking start ////////////////////////////////////////
//			int sno = 0;
//			try {
//
//				Criteria crit = sessionFactory.getCurrentSession().createCriteria(EFORM_BUSINESS_REQUEST_TRACKING.class)
//						.setProjection(Projections.max("SR_NO"));
//				Integer srno1 = (Integer) crit.uniqueResult();
//
//				System.out.println(" SNO IS: " + srno1);
//
//				if (srno1 != null) {
//					sno = srno1.intValue();
//					sno = sno + 1;
//					System.out.println("IN IF SNO IS: " + sno);
//				} else {
//					sno = 1;
//					System.out.println("IN ELSE SNO IS: " + sno);
//				}
//			} catch (Exception e) {
//
//				e.printStackTrace();
//				System.out.println(e);
//			}
//			String msg = null;
//			String[] split = Status.split(" ");
//			String approve=split[0];
//			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
//					+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
//			SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();
//
//			tickettrack.setSR_NO(sno);
//			tickettrack.setT_ID(ticketidupdateTDassign);
//			tickettrack.setACTIVITY_DATE(currenttime);
//			tickettrack.setACTIVITY_NAME(loginuser);
//
//			tickettrack.setSTATUS(Status);
//			System.out.println("ticket Tracking stataus is :" + Status);
//			tickettrack.setPRIORITY("P2");
//			tickettrack.setSEVERITY("Medium");
//			
//			tickettrack.setMESSAGE(msg);
//			tickettrack.setTICKET_RAISED_NAME(raisedByName);
//			tickettrack.setACTIVITY_DATE_TIME(currenttime);
//			tickettrack.setACTIVITY_COMPANY(company);
//			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);
//
//			if (updatedFileName == null) {
//				tickettrack.setATTACHMENT_NAME("No File Available");
//			} else {
//				tickettrack.setATTACHMENT_NAME(updatedFileName);
//			}
//
//			sessionFactory.getCurrentSession().persist(tickettrack);
//
//			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
//			
//			int ActSno = 0;
//			try
//			{
//			
//			try {
//
//				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
//						.setProjection(Projections.max("SR_NO"));
//				Integer actSrno1 = (Integer) crit.uniqueResult();
//
//				System.out.println(" actSrno1 IS: " + actSrno1);
//
//				if (actSrno1 != null) {
//					ActSno = actSrno1.intValue();
//					ActSno = ActSno + 1;
//					System.out.println("IN IF ActSno IS: " + ActSno);
//				} else {
//					ActSno = 1;
//					System.out.println("IN ELSE ActSno IS: " + ActSno);
//				}
//			} catch (Exception e) {
////	 			TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println(e);
//			}
//
//			EFORM_BUSINESS_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();
//
//			ticketActivityLog.setSR_NO(ActSno);
//			ticketActivityLog.setT_ID(ticketidupdateTDassign);
//			ticketActivityLog.setSTATUS(Status);
//			ticketActivityLog.setT_DATETIME(currenttime);
//			ticketActivityLog.setT_CHANGEBY(loginuser);
//
//			ticketActivityLog.setT_DESC(approvenote);
//			ticketActivityLog.setROLE_TYPE(loginRoleType);
//
//			ticketActivityLog.setPRIORITY("P2");
//			ticketActivityLog.setSEVERITY("Medium");
//			ticketActivityLog.setT_COMPANY(company);
//			ticketActivityLog.setT_EMAIL(EMAIL);
//
//			ticketActivityLog.setT_CONTACT_NO(PHONE);
//			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
//			ticketActivityLog.setCHANGE_NOTES1(approvenote);
//			if (updatedFileName == null) {
//				ticketActivityLog.setT_ATTACH_NAME("No File Available");
//			} else {
//				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
//			}
//
//			sessionFactory.getCurrentSession().persist(ticketActivityLog);
//			}	
//		catch (Exception e) {
//			e.printStackTrace();
//		}
////			try {
////				
////				
////				if(status.equals("success"))
////				Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
////			}catch(Exception e)
////			{
////				e.printStackTrace();
////			}
//			return status+"~"+id;
//		}

		@Override
		public String InsertSMTPRequestApprovedByMailAdmin(String appByITComp, String Status, String approvenote,
				String approvalName, MultipartFile empPic, String phone, String emailid, String pid, String companyRaisedBy,
				String raisedByName, String ticketidupdateTDassign) {
			System.out.println("inside dao impl business request gal update submit button action ");
			int id=0;
			
			String status="";
			String FullNameOfLogin="";
			
			String fileNameWithOutExt = FilenameUtils.removeExtension(empPic.getOriginalFilename());
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			String localDateNow = localdate.format(now);
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + id;

			String ext = "";
			String updatedFileName = null;
			DateFormat dateFormat = null;
			dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = null;
			date = new Date();
			String loginuser="";
			String loginRoleType="";
			String company="";
			String currenttime = dateFormat.format(date);
			String EMAIL=null;
			String PHONE=null;
			String tid = null;
			
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
				loginRoleType = session.getAttribute("role").toString();
				company=session.getAttribute("companyname").toString();
				FullNameOfLogin = session.getAttribute("fullname").toString();
//				tid = session.getAttribute("tid").toString();
				
				System.out.println("username for galupdate :"+ loginuser);
				System.out.println("fullname for galupdate :"+ FullNameOfLogin);
				Date currentdate = dateFormat.parse(currenttime);
				try
				{
					Query getLoginData=sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+company+"'");
					List<Object[]> list=getLoginData.list();
					for(Object[] obj:list)
					{
						EMAIL = obj[0].toString();
						PHONE=obj[1].toString();
					}
					
				}catch (Exception e) {
					
				}
				
				try {
					String imagefilePath;
					imagefilePath = "C:\\ITHelpDesk\\";
					try {
						File file = new File("C:\\ITHelpDesk\\");
						if (!file.exists()) {
							if (file.mkdir()) {
								
							} else {
							
							}
						}
					} catch (Exception e) {
					
					}

					File uploadedFile = new File(empPic.getOriginalFilename());
					uploadedFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(uploadedFile);
					fos.write(empPic.getBytes());
					fos.close();
				
					String fileName = empPic.getOriginalFilename();
				
					ext = FilenameUtils.getExtension(fileName);
						File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
					updatedFileName = createnewfilename + "." + ext;
				
					try {
						
						FileUtils.copyFile(uploadedFile, destFile);
						File filee = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
						FileInputStream fis = new FileInputStream(filee);
					} catch (IOException ex) {
						status = "error";
						ex.printStackTrace();
					}
				} catch (Exception e) {

				}
			}
			catch (Exception e) {

			}
		
			try 
			{			
				System.out.println("FDullanrme "+FullNameOfLogin);						
				Query updatesr=sessionFactory.getCurrentSession().createQuery("update SMTP_REQUEST set ML_APPROVAR=:ML_APPROVAR,ML_APPROVAR_FULLNAME=:ML_APPROVAR_FULLNAME,ML_APPROVAR_DATE=:ML_APPROVAR_DATE,ML_APPROVAR_NOTE=:ML_APPROVAR_NOTE,STATUS=:STATUS where T_ID=:T_ID");
				updatesr.setParameter("ML_APPROVAR_FULLNAME",FullNameOfLogin);
				updatesr.setParameter("ML_APPROVAR",loginuser);
				updatesr.setParameter("ML_APPROVAR_DATE",currenttime);
				updatesr.setParameter("STATUS",Status);
				updatesr.setParameter("ML_APPROVAR_NOTE",approvenote);
			
				updatesr.setParameter("T_ID",ticketidupdateTDassign);
				
					int executeUpdate = updatesr.executeUpdate();
					if(executeUpdate>0)
					{
						status = "success";
						
						System.out.println("value of another status : " + status);
					}
					else
					{
						status="error";
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			//////////////////////// Tracking start ////////////////////////////////////////
			int sno = 0;
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_TRACKING.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) crit.uniqueResult();

				System.out.println(" SNO IS: " + srno1);

				if (srno1 != null) {
					sno = srno1.intValue();
					sno = sno + 1;
					System.out.println("IN IF SNO IS: " + sno);
				} else {
					sno = 1;
					System.out.println("IN ELSE SNO IS: " + sno);
				}
			} catch (Exception e) {

				e.printStackTrace();
				System.out.println(e);
			}
			String msg = null;
			String[] split = Status.split(" ");
			String approve=split[0];
			msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
					+ "<tr><td>Status:</td><td>"+Status+"</td></tr>" + "<tr><td>"+approve+" By:</td><td>" + loginuser+"  ["+FullNameOfLogin+ "]</td></tr>";
			SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();

			tickettrack.setSR_NO(sno);
			tickettrack.setT_ID(ticketidupdateTDassign);
			tickettrack.setACTIVITY_DATE(currenttime);
			tickettrack.setACTIVITY_NAME(loginuser);

			tickettrack.setSTATUS(Status);
			System.out.println("status is 76524: " + Status);
			tickettrack.setPRIORITY("P2");
			tickettrack.setSEVERITY("Medium");
			
			tickettrack.setMESSAGE(msg);
			tickettrack.setTICKET_RAISED_NAME(raisedByName);
			tickettrack.setACTIVITY_DATE_TIME(currenttime);
			tickettrack.setACTIVITY_COMPANY(company);
			tickettrack.setTICKET_RAISED_BY_COMPANY(companyRaisedBy);

			if (updatedFileName == null) {
				tickettrack.setATTACHMENT_NAME("No File Available");
			} else {
				tickettrack.setATTACHMENT_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(tickettrack);

			///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
			
			int ActSno = 0;
			try
			{
			
			try {

				Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
						.setProjection(Projections.max("SR_NO"));
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
				e.printStackTrace();
				System.out.println(e);
			}

			SMTP_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();

			ticketActivityLog.setSR_NO(ActSno);
			ticketActivityLog.setT_ID(ticketidupdateTDassign);
			ticketActivityLog.setSTATUS(Status);
			ticketActivityLog.setT_DATETIME(currenttime);
			ticketActivityLog.setT_CHANGEBY(loginuser);

			ticketActivityLog.setT_DESC(approvenote);
			ticketActivityLog.setROLE_TYPE(loginRoleType);

			ticketActivityLog.setPRIORITY("P2");
			ticketActivityLog.setSEVERITY("Medium");
			ticketActivityLog.setT_COMPANY(company);
			ticketActivityLog.setT_EMAIL(EMAIL);

			ticketActivityLog.setT_CONTACT_NO(PHONE);
			ticketActivityLog.setT_FULLNAME(FullNameOfLogin);
			ticketActivityLog.setCHANGE_NOTES1(approvenote);
			if (updatedFileName == null) {
				ticketActivityLog.setT_ATTACH_NAME("No File Available");
			} else {
				ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
			}

			sessionFactory.getCurrentSession().persist(ticketActivityLog);
			}	
		catch (Exception e) {
			e.printStackTrace();
		}
//			try {
//				
//				
//				if(status.equals("success"))
//				Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketidupdateTDassign, status);
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
			return status+"~"+id;
		}

		@Override
		public String closeSMTPResolvedRequest(String ticketid, String closereason) {
			String status = null;
			String LoginUser = null;
			String loginUserCompany = null;
			String Fullname = null;
			String role_Type=null;
			try {
				
				DateFormat dateFormat = null;
				dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date date = null;
				date = new Date();
				
				// System.out.println(dateFormat.format(date));
				String currenttime = dateFormat.format(date);

				System.out.println("INSIDE EFORMACTIVITY CLOSEBUSINESSREQUESTREQUEST DAO IMPL"+ticketid);
				try {

					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					LoginUser = session.getAttribute("username").toString();
					loginUserCompany = session.getAttribute("companyname").toString();
					Fullname = session.getAttribute("fullname").toString();
					role_Type=session.getAttribute("role").toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {

					int updateRequest = sessionFactory.getCurrentSession()
							.createQuery("update SMTP_REQUEST set CLOSED_BY='" + LoginUser + "',CLOSED_BY_FULLNAME='"
									+ Fullname + "',CLOSED_DATE='"+currenttime+"',STATUS='Closed',CLOSED_REASON='"+closereason+"' where T_ID='"+ticketid+"'").executeUpdate();
				
					System.out.println("update SMTP_REQUEST set CLOSED_BY"+updateRequest);
					if(updateRequest>0)
					{
						status="success";
					}
					else
					{
						status="error";
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					 
					int sno = 0;
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_TRACKING.class)
								.setProjection(Projections.max("SR_NO"));
						Integer srno1 = (Integer) crit.uniqueResult();

						System.out.println(" SNO IS: " + srno1);

						if (srno1 != null) {
							sno = srno1.intValue();
							sno = sno + 1;
							System.out.println("IN IF SNO IS: " + sno);
						} else {
							sno = 1;
							System.out.println("IN ELSE SNO IS: " + sno);
						}
					} catch (Exception e) {

						e.printStackTrace();
						System.out.println(e);
					}
							
					String msg = null;

					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
							+ "<tr><td>Status:</td><td>Closed</td></tr>" + "<tr><td>Closed By:</td><td>" + LoginUser+"  ["+Fullname+ "]</td></tr>";  // + "<tr><td>Closed Note:</td><td>" +closereason+ "</td></tr>"
					SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();

					tickettrack.setSR_NO(sno);
					tickettrack.setT_ID(ticketid);
					tickettrack.setACTIVITY_DATE(currenttime);
					tickettrack.setACTIVITY_NAME(LoginUser);
					tickettrack.setSTATUS("Closed");
					tickettrack.setMESSAGE(msg);
					tickettrack.setTICKET_RAISED_NAME(LoginUser);
					tickettrack.setACTIVITY_DATE_TIME(currenttime);
					tickettrack.setACTIVITY_COMPANY(loginUserCompany);
					tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
					tickettrack.setPRIORITY("P2");
					tickettrack.setSEVERITY("Medium");
					sessionFactory.getCurrentSession().persist(tickettrack);
					status="success";
					
					
					//////////////////// INSERT IN TICKET ACTIVITY log/////////////////
					
					int ActSno = 0;
					try
					{
						String EMAIL=null;
						String contactNo=null;
						Query getdata =sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
						List<Object[]> obj=getdata.list();
						for(Object[] object:obj)
						{
							EMAIL=object[0].toString();
							contactNo=object[1].toString();
						}
					try {
						
						Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
								.setProjection(Projections.max("SR_NO"));
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
						e.printStackTrace();
						System.out.println(e);
					}

					SMTP_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();

					ticketActivityLog.setSR_NO(ActSno);
					ticketActivityLog.setT_ID(ticketid);
					ticketActivityLog.setSTATUS("Closed");
					ticketActivityLog.setT_DATETIME(currenttime);
					ticketActivityLog.setT_CHANGEBY(LoginUser);
					ticketActivityLog.setPRIORITY("P2");
					ticketActivityLog.setSEVERITY("Medium");
				
					ticketActivityLog.setT_DESC(closereason);
					ticketActivityLog.setROLE_TYPE(role_Type);
					ticketActivityLog.setCHANGE_NOTES1(closereason);
					ticketActivityLog.setT_COMPANY(loginUserCompany);
					ticketActivityLog.setT_EMAIL(EMAIL);

					ticketActivityLog.setT_CONTACT_NO(contactNo);
					ticketActivityLog.setT_FULLNAME(Fullname);

					
					sessionFactory.getCurrentSession().persist(ticketActivityLog);
					status="success";
					}catch (Exception e) {

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {

			}

//		try {
//				
//				String ticketstatus="Closed";
//				if(status.equals("success"))
//				Inv.EmaiLSmsTriggerdInSoftwareRequest(ticketid, ticketstatus);
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
			return status;
		}

		@Override
		public String RequestReopenResolvedSMTPTicket(String ticketid, String reopenreason, MultipartFile reopenPic) {
			System.out.println("INSIDE EFORM DAO IMPL RequestReopenResolvedBusinessTicket");
			String status="";

			String LoginUser = "";
			String loginUserCompany = "";
			String Fullname = "";
			String role_Type = "";
			String ext = "";
			String updatedFileName = null;
			//attach file start code ADD FIRST //
			
			String fileNameWithOutExt = FilenameUtils.removeExtension(reopenPic.getOriginalFilename());
			//System.out.println("FILENAME WITHOUT EXT: " + fileNameWithOutExt);
			DateTimeFormatter localdate = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH.mm.ss");
			LocalDateTime now = LocalDateTime.now();
			//System.out.println(localdate.format(now));
			String localDateNow = localdate.format(now);
//			String createnewfilename = UUID.randomUUID().toString();
			String createnewfilename = fileNameWithOutExt + " " + localDateNow + "_" + ticketid;
			//System.out.println("createnewfilename***" + createnewfilename);
//			createnewfilename = createnewfilename.substring(0, createnewfilename.indexOf("-"));
			
			//attach file end code //
			
			
			//attach file  code SECOND ADD//
			try {
				
				System.out.println("third try block in businesss inside C:\\\\ITHelpDesk\\\\ ");
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

				System.out.println("inside the file coding business id approval request ");
//	            File uploadedFile =  empPic;
				File uploadedFile = new File(reopenPic.getOriginalFilename());
				uploadedFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(reopenPic.getBytes());
				fos.close();
				//System.out.println("uploadedFile::::" + uploadedFile);
				String fileName = reopenPic.getOriginalFilename();
				System.out.println("fileName::::" + fileName);
				ext = FilenameUtils.getExtension(fileName);
				//System.out.println("file_extension::::" + ext);
				// File destFile = new File(imagefilePath + File.separator + fileName);
				File destFile = new File(imagefilePath + File.separator + createnewfilename + "." + ext);
				//System.out.println("destFile........" + destFile);
				// //System.out.println("File........" + imagefilePath + File.separator +
				// fileName);
				//System.out.println("File........" + imagefilePath + File.separator + createnewfilename + "." + ext);
				updatedFileName = createnewfilename + "." + ext;
				System.out.println("UPDATED FILE NAME RE-OPEN: " + updatedFileName);

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
			
			////////////attach second add ///////////////
			try {

				DateFormat dateFormat = null;
				dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date date = null;
				date = new Date();

				// System.out.println(dateFormat.format(date));
				String currenttime = dateFormat.format(date);

				System.out.println("INSIDE EFORMACTIVITY Reopen SMTP Request DAO IMPL" + ticketid);
				try {

					ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes();
					HttpSession session = requestAttributes.getRequest().getSession();
					LoginUser = session.getAttribute("username").toString();
					loginUserCompany = session.getAttribute("companyname").toString();
					Fullname = session.getAttribute("fullname").toString();
					role_Type = session.getAttribute("role").toString();
				} catch (Exception e) {
					e.printStackTrace();
				}

				int updateReq=sessionFactory.getCurrentSession().createQuery("update SMTP_REQUEST set STATUS='Re-Opened',RE_OPENED_DATE='"+currenttime+"',RE_OPENED_BY='"+LoginUser+"',RE_OPENED_BY_FULLNAME='"+Fullname+"',RE_OPENED_REASON='"+reopenreason+"'where T_ID='"+ticketid+"'").executeUpdate();
				try {
					 
					int sno = 0;
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_TRACKING.class)
								.setProjection(Projections.max("SR_NO"));
						Integer srno1 = (Integer) crit.uniqueResult();

						System.out.println(" SNO IS: " + srno1);

						if (srno1 != null) {
							sno = srno1.intValue();
							sno = sno + 1;
							System.out.println("IN IF SNO IS: " + sno);
						} else {
							sno = 1;
							System.out.println("IN ELSE SNO IS: " + sno);
						}
					} catch (Exception e) {

						e.printStackTrace();
						System.out.println(e);
					}
				
					String msg = null;
					
					
					msg = "<tr><td>TimeStamp:</td><td>" + currenttime + "</td></tr>"
							+ "<tr><td>Status:</td><td>Re-Opened</td></tr>" + "<tr><td>Re-Opened By:</td><td>" + LoginUser+"  ["+Fullname+ "]</td></tr>";
					SMTP_REQUEST_TRACKING tickettrack = new SMTP_REQUEST_TRACKING();

					tickettrack.setSR_NO(sno);
					tickettrack.setT_ID(ticketid);
					tickettrack.setACTIVITY_DATE(currenttime);
					tickettrack.setACTIVITY_NAME(LoginUser);

					tickettrack.setSTATUS("Re-Opened");
					tickettrack.setPRIORITY("P2");
					tickettrack.setSEVERITY("Medium");
					tickettrack.setMESSAGE(msg);
					tickettrack.setTICKET_RAISED_NAME(LoginUser);
					tickettrack.setACTIVITY_DATE_TIME(currenttime);
					tickettrack.setACTIVITY_COMPANY(loginUserCompany);
					tickettrack.setTICKET_RAISED_BY_COMPANY(loginUserCompany);
					
					if (updatedFileName == null) {
						tickettrack.setATTACHMENT_NAME("No File Available");
					} else {
						tickettrack.setATTACHMENT_NAME(updatedFileName);
						System.out.println("inside query tracking  : " + updatedFileName);
					}

					sessionFactory.getCurrentSession().persist(tickettrack);
					status="success";
					
					///////////////////// INSERT IN TICKET ACTIVITY log/////////////////
					
					int ActSno = 0;
					try
					{
						String EMAIL=null;
						String contactNo=null;
						Query getdata =sessionFactory.getCurrentSession().createSQLQuery("select EMAIL,PHONE from loginmaster where USERNAME='"+LoginUser+"' and COMPANY='"+loginUserCompany+"'");
						List<Object[]> obj=getdata.list();
						for(Object[] object:obj)
						{
							EMAIL=object[0].toString();
							contactNo=object[1].toString();
						}
					try {

						Criteria crit = sessionFactory.getCurrentSession().createCriteria(SMTP_REQUEST_ACTIVITYLOG.class)
								.setProjection(Projections.max("SR_NO"));
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
						e.printStackTrace();
					}
					SMTP_REQUEST_ACTIVITYLOG ticketActivityLog = new SMTP_REQUEST_ACTIVITYLOG();
					ticketActivityLog.setSR_NO(ActSno);
					ticketActivityLog.setT_ID(ticketid);
					ticketActivityLog.setSTATUS("Re-Opened");
					ticketActivityLog.setT_DATETIME(currenttime);
					ticketActivityLog.setT_CHANGEBY(LoginUser);
					ticketActivityLog.setPRIORITY("P2");
					ticketActivityLog.setSEVERITY("Medium");
					ticketActivityLog.setT_DESC(reopenreason);
					ticketActivityLog.setROLE_TYPE(role_Type);
					ticketActivityLog.setCHANGE_NOTES1(reopenreason);
					ticketActivityLog.setT_COMPANY(loginUserCompany);
					ticketActivityLog.setT_EMAIL(EMAIL);

					ticketActivityLog.setT_CONTACT_NO(contactNo);
					ticketActivityLog.setT_FULLNAME(Fullname);
					
					if (updatedFileName == null) {
						ticketActivityLog.setT_ATTACH_NAME("No File Available");
					} else {
						ticketActivityLog.setT_ATTACH_NAME(updatedFileName);
						System.out.println("inside query tracking  : " + updatedFileName);
					}
					
					sessionFactory.getCurrentSession().persist(ticketActivityLog);
					status="success";
					}catch (Exception e) {
						// TODO: handle exception
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "success";
		}

		@Override
		public JSONArray getSMTPReopenRequestDetails(String ticketid) {
			System.out.println("inside getBusinessReOpenRequestDetails");
			JSONArray array=null;
			JSONArray array1=null;
			String loginuser=null;
			String Company=null;
			String department = "";
			
			String sub_department = "";
			String location = "";
			String emailId="";
			String ContactNo="";
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
						.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				loginuser = session.getAttribute("username").toString();
				Company=session.getAttribute("companyname").toString();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				array=new JSONArray();
				Query getLoginmasterdata=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+loginuser+"' and COMPANY='"+Company+"'");
				
				Query getData=sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='"+ticketid+"'");
				
				List<SMTP_REQUEST> list=getData.list();
				for(SMTP_REQUEST ticketDrive:list)
				{
					JSONObject arrayobj=new JSONObject();
					Query getDataa=sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+ticketDrive.getT_REQUESTER()+"' and COMPANY='"+ticketDrive.getT_COMPANY()+"'");
					List<loginmaster> listOfuser=getDataa.list();
					for (loginmaster loginDrive : listOfuser) {
						department = loginDrive.getDEPARTMENT();
						sub_department = loginDrive.getSUB_DEPARTMENT();
						location = loginDrive.getLOCATION();
						emailId=loginDrive.getEMAIL();
						ContactNo= loginDrive.getPHONE();
					}
					arrayobj.put("T_REQUESTER", ticketDrive.getT_REQUESTER());
					arrayobj.put("T_COMPANY", ticketDrive.getT_COMPANY());
					arrayobj.put("T_BRANCH", ticketDrive.getT_BRANCH());
					arrayobj.put("DEPARTMENT", department);
					arrayobj.put("SUB_DEPARTMENT", sub_department);
					arrayobj.put("LOCATION", location);
					
					if(emailId.isEmpty()||emailId==null)
					{
						arrayobj.put("EMAIL", "NA");
					}
					else
					{
						arrayobj.put("EMAIL", emailId);
					}
					if(ContactNo.isEmpty()||ContactNo==null)
					{
						arrayobj.put("PHONE", "NA");
					}
					else
					{
						arrayobj.put("PHONE",ContactNo);
					}
					arrayobj.put("T_ID",ticketDrive.getT_ID());
					arrayobj.put("STATUS",ticketDrive.getSTATUS());
					arrayobj.put("RAISE_DATE", ticketDrive.getRAISED_DATE());
					arrayobj.put("P_ID", ticketDrive.getP_ID());
					arrayobj.put("APPROVAL_NAME", ticketDrive.getAPPROVAR_NAME());
					arrayobj.put("APPLICATION_SERVER", ticketDrive.getAPPLICATION_SERVER());
					arrayobj.put("APPLICATION_SERVER_IP", ticketDrive.getAPPLICATION_SERVER_IP());
					arrayobj.put("SERVER_LOCATION_CITY", ticketDrive.getSERVER_LOCATION_CITY());
					arrayobj.put("DESC", ticketDrive.getAPPROVAL_NOTE());
					String AttachName = ticketDrive.getATTACH_NAME();
					System.out.println("Attachement name"+AttachName);
					try {
						if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
							arrayobj.put("T_ATTACH_NAME", "No File Available");
						} else {
							arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
						}
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					array.put(arrayobj);
				}
				
			} catch (Exception e) {
			}

			return array;
		}

		@Override
		public JSONArray gatherSMTPRequestRequestDetails(String ticketid) {
			//System.out.println("Inside TPActivityDaoImpl gatherTicketDetails method");

			JSONArray array1 = null;

			String LoginUser = null;
			String loginUserCompany = null;
			try {
				ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
				HttpSession session = requestAttributes.getRequest().getSession();
				LoginUser = session.getAttribute("username").toString();
				loginUserCompany = session.getAttribute("companyname").toString();
				//System.out.println("username****" + LoginUser);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Exceptioon e***" + e);
			}

			try {
				List<SMTP_REQUEST> ticketList = sessionFactory.getCurrentSession().createQuery("from SMTP_REQUEST where T_ID='"+ticketid+"'").list();
				
				List<loginmaster> tpList = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + LoginUser + "' and COMPANY='" + loginUserCompany + "'").list();
				
				System.out.println("LOGIN MASTER VALUE : "+ tpList);
				
				array1 = new JSONArray();

				for (SMTP_REQUEST ticketDrive : ticketList) {

					for (loginmaster tpDrive : tpList) {    
						System.out.println("LOGIN MASTER VALUE  forrrrrrr : "+ ticketDrive);
						JSONObject arrayobj = new JSONObject();
					
						arrayobj.put("T_REQUESTER",ticketDrive.getT_REQUESTER());
						arrayobj.put("T_REQUESTER_FULLNAME",ticketDrive.getT_REQUESTER_FULLNAME());			
						arrayobj.put("T_COMPANY",ticketDrive.getT_COMPANY());						
						arrayobj.put("T_BRANCH",ticketDrive.getT_BRANCH());				
						arrayobj.put("T_DEPARTMENT",ticketDrive.getT_DEPARTMENT());					
						arrayobj.put("T_EMAIL",ticketDrive.getEMAIL_ID());					
						arrayobj.put("PID",ticketDrive.getP_ID());
						arrayobj.put("T_ID",ticketDrive.getT_ID());
						arrayobj.put("DESC",ticketDrive.getAPPROVAL_NOTE());
						arrayobj.put("T_PHONE",ticketDrive.getT_PHONE());					
						arrayobj.put("RAISE_DATE",ticketDrive.getRAISED_DATE());
						
						arrayobj.put("APPROVAL_NAME",ticketDrive.getAPPROVAR_NAME());
						arrayobj.put("APPLICATION_SERVER",ticketDrive.getAPPLICATION_SERVER());
						arrayobj.put("APPLICATION_SERVER_IP",ticketDrive.getAPPLICATION_SERVER_IP());
						arrayobj.put("SERVER_LOCATION_CITY",ticketDrive.getSERVER_LOCATION_CITY());

						arrayobj.put("STATUS",ticketDrive.getSTATUS());

						arrayobj.put("TP_USERNAME", tpDrive.getUSERNAME());
						
						String usernameGal = tpDrive.getUSERNAME();
						String galfullName = tpDrive.getFULL_NAME();					
						System.out.println("user name : "+ usernameGal);
						System.out.println("FULL NAME : " + galfullName);
						
						arrayobj.put("TP_COMPANY", tpDrive.getCOMPANY());
						arrayobj.put("TP_BRANCH", tpDrive.getBRANCH());
						arrayobj.put("TP_DEPARTMENT", tpDrive.getDEPARTMENT());
						arrayobj.put("TP_PHONE", tpDrive.getPHONE());
						arrayobj.put("TP_MAIL", tpDrive.getEMAIL());					
						arrayobj.put("TP_LOCATION", tpDrive.getLOCATION());
						arrayobj.put("TP_SUBDEPARTMENT", tpDrive.getSUB_DEPARTMENT());
						
						List<loginmaster> t_requesrterdetails = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='" + ticketDrive.getT_REQUESTER() + "' and COMPANY='" + ticketDrive.getT_COMPANY() + "'").list();
						for(loginmaster  t_requesrterdetailsnew:t_requesrterdetails)
						{
							
							System.out.println("Login master values data : " + t_requesrterdetailsnew);
							arrayobj.put("T_SUBDEPARTMENT", t_requesrterdetailsnew.getSUB_DEPARTMENT());
							arrayobj.put("T_LOCATION", t_requesrterdetailsnew.getLOCATION());
							
						}
						String AttachName = ticketDrive.getATTACH_NAME();
						System.out.println("Attachement name"+AttachName);
						try {
							if (AttachName.equals(null) || AttachName.equals("null") || AttachName.equals("")) {
								arrayobj.put("T_ATTACH_NAME", "No File Available");
								//System.out.println("Null object found");
							} else {
								arrayobj.put("T_ATTACH_NAME", ticketDrive.getATTACH_NAME());
								//System.out.println("Object found");
							}
						} catch (Exception e) {
			
							e.printStackTrace();
						}

						array1.put(arrayobj);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return array1;
		}

		@Override
		public JSONArray getSMTPActivityTicketRequestActivityLog(String ticketid) {
			JSONArray array = new JSONArray();
			try {
				Query queryticketActivity = sessionFactory.getCurrentSession()
						.createQuery("from SMTP_REQUEST_ACTIVITYLOG where T_ID=:T_ID order by STR_TO_DATE(T_DATETIME,'%d-%m-%Y %H:%i:%s') desc");
				queryticketActivity.setParameter("T_ID", ticketid);
				List<SMTP_REQUEST_ACTIVITYLOG> ticketActivity = queryticketActivity.list();
				for (SMTP_REQUEST_ACTIVITYLOG sourceDrive : ticketActivity) {
					JSONObject arrayobjtemp = new JSONObject();
					arrayobjtemp.put("T_ID", sourceDrive.getT_ID());
					arrayobjtemp.put("TIMESTAMP", sourceDrive.getT_DATETIME());
					arrayobjtemp.put("CHANGEBY", sourceDrive.getT_CHANGEBY());
					arrayobjtemp.put("ATTACHMENT_NAME", sourceDrive.getT_ATTACH_NAME());
					arrayobjtemp.put("STATUS", sourceDrive.getSTATUS());
					arrayobjtemp.put("PRIORITY", sourceDrive.getPRIORITY());
					arrayobjtemp.put("SEVERITY", sourceDrive.getSEVERITY());
					arrayobjtemp.put("CHANGE_NOTES1", sourceDrive.getCHANGE_NOTES1());
					arrayobjtemp.put("CHANGE_NOTES2", sourceDrive.getCHANGE_NOTES2());
					arrayobjtemp.put("ROLE_TYPE", sourceDrive.getROLE_TYPE());
//					arrayobjtemp.put("CATEGORY",sourceDrive.getT_CATEGORY());
//					arrayobjtemp.put("SUB_CATEGORY1",sourceDrive.getT_SUB_CATEGORY1());
//					arrayobjtemp.put("SUBCATEGORY2",sourceDrive.getT_SUB_CATEGORY2());
					arrayobjtemp.put("FULLNAME",sourceDrive.getT_FULLNAME());
					arrayobjtemp.put("EMAIL", sourceDrive.getT_EMAIL());
					array.put(arrayobjtemp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return array;
		}

	
	// SMTP Flow End
}

