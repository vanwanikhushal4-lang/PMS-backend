package com.velox.itsm.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import de.taimos.totp.TOTP;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.velox.itsm.ATM.ActiveDirectory;
import com.velox.itsm.ATM.ApplicationPropertyReader;
import com.velox.itsm.ATM.SendOTP;
import com.velox.itsm.model.AD_INTEGRATION;
import com.velox.itsm.model.AD_USER_MANAGE;
import com.velox.itsm.model.AuditEvent;
import com.velox.itsm.model.Login;
import com.velox.itsm.model.TwoFactorAuthenticationType;
import com.velox.itsm.model.company_code_master;
import com.velox.itsm.model.enggmaster;
import com.velox.itsm.model.loginmaster;
import com.velox.itsm.model.otp_check;
import com.velox.itsm.model.sms_config;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.usermaster;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;

@Repository("login_dao")
@Transactional
public class LoginDaoImpl extends AbstractDao<Integer, Login> implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Environment environment;

	HttpServletResponse response = null;
	HttpServletRequest request = null;

//	public String getParameter(String username) {
//		String parameter = null;
//		//System.out.println("getsessionusername********" + username);
//		try {
//			Query query = getSession()
//					.createSQLQuery("Select CUSTOMIZE_VIEW from LOGIN where USERNAME='" + username + "'");
//
//			List<Login> dataList = query.setResultTransformer(Transformers.aliasToBean(Login.class)).list();
//			for (Login custList : dataList) {
//
//				parameter = (custList.getCUSTOMIZE_VIEW());
//				//System.out.println("Parameter of session user*************: " + parameter);
//				//System.out.println("*****END*********");
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return parameter;
//
//	}

	@Override
	public String getDBVerification(String username, String Password, String usertype, String activitydash1,String userfullname) {
		//System.out.println("Inside LoginDaoImpl getDBVerification method");
		String db_password = null;
		String db_username = null;
		String db_usertype = null;
		String db_userfullname = null;
		String db_login_type = null;
		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);
			//System.out.println("user: " + username + "pass: " + Password + "type: " + usertype);
			if (usertype.equals("Admin")) {
				//System.out.println("inside admin");
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from Login where USERNAME=:u and USERTYPE=:utype");
				query.setParameter("u", username);
				query.setParameter("utype", "Admin");

				List<Login> dataList = query.list();
				for (Login sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getPASSWORD());

					db_password = sourceDrive.getPASSWORD();
					db_username = sourceDrive.getUSERNAME();
					db_usertype = sourceDrive.getUSERTYPE();
					db_userfullname = sourceDrive.getUSERNAME();
					db_login_type = sourceDrive.getLOGIN_TYPE();
				//System.out.println("db_password=="+db_password);
				//System.out.println("db_username=="+db_username);
				//System.out.println("db_usertype=="+db_usertype);
				//System.out.println("db_logintype=="+db_login_type);
				
				}
			}
			if (usertype.equals("User")) {
				//System.out.println("inside user");
				Query query = sessionFactory.getCurrentSession().createQuery("from usermaster where USERNAME=:u");
				query.setParameter("u", username);
				List<usermaster> dataList = query.list();
				for (usermaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getPASSWORD());

					db_password = sourceDrive.getPASSWORD();
					db_username = sourceDrive.getUSERNAME();
					db_usertype = "user";
					db_userfullname = sourceDrive.getNAME();
					db_login_type = sourceDrive.getLOGIN_TYPE();

//					//System.out.println(db_password);	
				}
			}
			if (usertype.equals("Engineer")) {
				//System.out.println("inside engineer");
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from enggmaster where ENG_UNAME='" + username + "'");
				List<enggmaster> dataList = query.list();
				for (enggmaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getENG_PWD());

					db_password = sourceDrive.getENG_PWD();
					db_username = sourceDrive.getENG_UNAME();
					db_usertype = "engineer";
					db_userfullname = sourceDrive.getE_NAME();
					db_login_type = sourceDrive.getLOGIN_TYPE();

//					//System.out.println(db_password);	
				}
			}
			if (usertype.equals("Ticket Co-ordinator")) {
				//System.out.println("inside Ticket Co-ordinator");
				List<tpmaster> dataList = sessionFactory.getCurrentSession()
						.createQuery("from tpmaster where TP_UNAME='" + username + "'").list();
				for (tpmaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getTP_PWD());

					db_password = sourceDrive.getTP_PWD();
					db_username = sourceDrive.getTP_UNAME();
					db_usertype = "Ticket Co-ordinator";
					db_userfullname = sourceDrive.getTP_NAME();
					db_login_type = sourceDrive.getLOGIN_TYPE();

				}
			}
			if (usertype.equals("IT-Head")) {
				//System.out.println("inside IT-Head");
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from Login where USERNAME=:u and USERTYPE=:utype");
				query.setParameter("u", username);
				query.setParameter("utype", "IT-Head");
				List<Login> dataList = query.list();
				for (Login sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getPASSWORD());

					db_password = sourceDrive.getPASSWORD();
					db_username = sourceDrive.getUSERNAME();
					db_usertype = sourceDrive.getUSERTYPE();
					db_userfullname = sourceDrive.getUSERNAME();
					db_login_type = sourceDrive.getLOGIN_TYPE();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//System.out.println(db_password + "~" + db_username + "~" + db_usertype + "~" + db_userfullname+ "~" + db_login_type);
		return db_password + "~" + db_username + "~" + db_usertype + "~" + db_userfullname+ "~" + db_login_type;
	}
	
//	@Override
//	public String getADVerified(String username) {
//          String user="";
//          String host="";
//          String port="";
//          String domain_name="";
//          //System.out.println("%%%%%%%%%%%%%");
//        
//		try {
//			//System.out.println("Before Projection List ");
//			Session s=getSession();
//			
//			//System.out.println("s ="+s);
//			Criteria crit = sessionFactory.getCurrentSession().createCriteria(AD_INTEGRATION.class);
//			ProjectionList proList = Projections.projectionList();
//			//System.out.println("Projection List started");
//			//proList.add(Projections.property("username"), "username");
//			//proList.add(Projections.property("password"), "password");
//			proList.add(Projections.property("HOST"), "HOST");
//			proList.add(Projections.property("PORT"), "PORT");
//			proList.add(Projections.property("DOMAIN_NAME"), "DOMAIN_NAME");
//			
//			crit.setProjection(Projections.distinct(proList));
//			//crit.add(Restrictions.eq("username", username));
//			long row=0;
//			String SQL_QUERY = "SELECT COUNT(*) FROM AD_INTEGRATION";
//			  Query query = s.createQuery(SQL_QUERY);
//			  for(Iterator it=query.iterate();it.hasNext();)
//			  {
//			  row = (Long) it.next();
//			   System.out.print("Count here: " + row+" ");
//			  }
//			  
//			  if(row!=0) {
//			@SuppressWarnings("unchecked")
//			List<AD_INTEGRATION> dataList = crit.setResultTransformer(Transformers.aliasToBean(AD_INTEGRATION.class))
//					.list();
//
//			for (AD_INTEGRATION sourceDrive : dataList) {
//				
//				//System.out.println("getUsername = "+sourceDrive.getUSERNAME());
//				//System.out.println("getHost = "+sourceDrive.getHOST());
//				//System.out.println("getPort = "+sourceDrive.getPORT());
//				//System.out.println("getDomain_name = "+sourceDrive.getDOMAIN_NAME());
//				////System.out.println("array = "+sourceDrive.getPass());
//				//user=sourceDrive.getUsername();
//						host=sourceDrive.getHOST();
//						port=sourceDrive.getPORT();
//						domain_name=sourceDrive.getDOMAIN_NAME();
//						
//			}
//			  }
//		} catch (Exception e) {
//			e.printStackTrace();
//			//System.out.println("ERRROR inf AD get values"+e);
//		}
//		
//		//System.out.println(" host~port~domain_name==="+ host+"~"+port+"~"+domain_name);
//		return host+"~"+port+"~"+domain_name;
//	}
//	
//	

	@Override
	public String getType(String username, String Password, String usertype1,String AD) {
		//System.out.println("Inside LoginDaoImpl getType method");
	
		String userType = "";
		try {
			
			
            if(AD.contains("false"))
            {
            	//System.out.println("ad false here.......");
//            	Query query =sessionFactory.getCurrentSession().createQuery("from AD_INTEGRATION where USERNAME=:u");
//                query.setParameter("u", username);
//                AD_INTEGRATION data = (AD_INTEGRATION) query.uniqueResult();
//                if(data!=null) {
//                	//System.out.println("data not null...");
//            	userType= "ADUser";
//                }
//                else {
//                	//System.out.println("data null...");
//                	Criteria criteria = createEntityCriteria();
//        			ProjectionList proList = Projections.projectionList();
//        			proList.add(Projections.property("USERTYPE"), "USERTYPE");
//        			criteria.setProjection(Projections.distinct(proList));
//        			criteria.add(Restrictions.eq("PASSWORD", Password));
//        			criteria.add(Restrictions.eq("USERNAME", username));
//        			List<Login> branchList = criteria.setResultTransformer(Transformers.aliasToBean(Login.class))
//        					.list();
//
//        			for (Login list : branchList) {
//        				userType = list.getUSERTYPE();
//        				//System.out.println("if chekcked false user type========="+userType);
//        			}
//                }
            	userType=usertype1;
                
              
            }
            
            //----if user from AD then this without user type then not need to fetch user type
            else {
            	//System.out.println("ad true here.......");
    		
            	List<AD_USER_MANAGE> all_ip=new ArrayList<AD_USER_MANAGE>();

    			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM AD_USER_MANAGE WHERE USERNAME= :id");
    			q1.setParameter("id",username);
    			
    			all_ip=q1.list();

    			for (AD_USER_MANAGE a : all_ip) {
    			
    				userType=a.getUSERTYPE();
    			}

            if(userType!=null)
            {
            	
            	
            }
            
                else {
                	userType= "UseSynchFun";
                }

		}

		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return userType;
	}

	@Override
	public String checkUserandType(String name, String usertype) {
		// TODO Auto-generated method stub
		// System.out.println("inside check user and usertype for forgot password
		// method***");

		String Phonenum = "";
		String Phonenum1 = "";
		String status = null;

		PrintWriter out = null;
		try {
//			out = response.getWriter();

			if (usertype.equals("Engineer")) {
				List<Object[]> enggList = sessionFactory.getCurrentSession()
						.createSQLQuery("Select ENG_UNAME,E_PHONE from ENGGMASTER where ENG_UNAME='" + name + "'")
						.list();
				for (Object[] enggmaster : enggList) {
//						out.println("before masking Phonenum " + Phonenum);
					Phonenum = (String) enggmaster[1];
					// System.out.println("after masking Phonenum " + Phonenum1);
					Phonenum1 = Phonenum.replaceAll("\\d(?=\\d{4})", "*");
				}
				if (enggList.isEmpty()) {
					status = "wrongcredentials";
				} else {

					status = "success" + "#" + Phonenum + "#" + Phonenum1;
				}
			} else if (usertype.equals("Admin")) {
				List<Object[]> Loginlist = sessionFactory.getCurrentSession()
						.createSQLQuery("Select USERNAME,PHONE from LOGIN where USERNAME='" + name + "'").list();
				for (Object[] login : Loginlist) {
					Phonenum = (String) login[1];
//						out.println("before masking Phonenum " + Phonenum);
					Phonenum1 = Phonenum.replaceAll("\\d(?=\\d{4})", "*");
					//System.out.println("after masking Phonenum " + Phonenum1);
				}
				if (Loginlist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					status = "success" + "#" + Phonenum + "#" + Phonenum1;
				}
			} else if (usertype.equals("Ticket Co-ordinator")) {
				List<Object[]> tplist = getSession()
						.createSQLQuery("Select TP_UNAME,TP_PHONE from TPMASTER where TP_UNAME='" + name + "'").list();
				for (Object[] tpmaster : tplist) {
					Phonenum = (String)tpmaster[1];
//						out.println("before masking Phonenum " + Phonenum);
					Phonenum1 = Phonenum.replaceAll("\\d(?=\\d{4})", "*");
					//System.out.println("after masking Phonenum " + Phonenum1);
					System.out.print("success" + "#" + Phonenum + "#" + Phonenum1);
				}
				if (tplist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					status = "success" + "#" + Phonenum + "#" + Phonenum1;
				}
			} else if (usertype.equals("User")) {
				//System.out.println("IN USERTYPE CHECK");
				List<Object[]> userlist = getSession()
						.createSQLQuery("Select USERNAME,PHONE from USERMASTER where USERNAME='" + name + "'").list();
				for (Object[] usermaster : userlist) {
					Phonenum = (String) usermaster[1];
//						out.println("before masking Phonenum " + Phonenum);
					Phonenum1 = Phonenum.replaceAll("\\d(?=\\d{4})", "*");
					//System.out.println("after masking Phonenum " + Phonenum1);
					System.out.print("success" + "#" + Phonenum + "#" + Phonenum1);
				}
				if (userlist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					status = "success" + "#" + Phonenum + "#" + Phonenum1;
				}
			} else if (usertype.equals("IT-Head")) {
				List<Object[]> Loginlist = sessionFactory.getCurrentSession()
						.createSQLQuery("Select USERNAME,PHONE from LOGIN where USERNAME='" + name + "'").list();
				for (Object[] login : Loginlist) {
					Phonenum = (String)login[1];
//						out.println("before masking Phonenum " + Phonenum);
					Phonenum1 = Phonenum.replaceAll("\\d(?=\\d{4})", "*");
					//System.out.println("after masking Phonenum " + Phonenum1);
				}
				if (Loginlist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					status = "success" + "#" + Phonenum + "#" + Phonenum1;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String sendOtpToPhone(String name, String usertype, String number) {
		// TODO Auto-generated method stub
		//System.out.println("inside send otp method***");

		String url1 = "";
		String url2 = "";
		String status = null;
		try {

			List<Object[]> sms_config_list = sessionFactory.getCurrentSession()
					.createSQLQuery("Select URL,PARAM from SMS_CONFIG").list();
			for (Object[] objectdata : sms_config_list) {
				url1 = (String) objectdata[0];
				url2 = (String) objectdata[1];
			}
			//System.out.println("url1***" + url1 + "url2***" + url2);
			String url = url1.concat("?");
			url = url.concat(url2);
			//System.out.println("After concat***" + url);

			// otp generate
			int randomPin = (int) (Math.random() * 9000) + 1000;
			String otp1 = String.valueOf(randomPin);
			//System.out.println("otp***" + otp1);
			

			try {

				int srno=1;
				try {
					srno = (int) sessionFactory.getCurrentSession().createCriteria(otp_check.class)
							.setProjection(Projections.max("SR_NO")).uniqueResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("SRNO IS::: "+srno);
				if (srno > 1) {
					srno += 1;
				} 
//System.out.println("AFTER SRNO: "+srno);
				List<Object[]> otp_check_list = sessionFactory.getCurrentSession()
						.createSQLQuery("Select CONTACT,USER_TYPE from OTP_CHECK where CONTACT='" + number
								+ "' AND USER_TYPE='" + usertype + "'")
						.list();
				if (otp_check_list.isEmpty()) {
					
					sessionFactory.getCurrentSession().save(new otp_check(srno, number, otp1, usertype));

//					int i = sessionFactory.getCurrentSession()
//							.createQuery("INSERT INTO otp_check(SR_NO,CONTACT,OTP,USER_TYPE) VALUES(" + srno + ",'"
//									+ number + "','" + otp1 + "','" + usertype + "')")
//							.executeUpdate();
//					if (i > 0) {
//						//System.out.println("OTP CHECK inserted***");
//					} else {
//						//System.out.println("OTP Check Failed*******");
//					}

				} else {
					int i = sessionFactory.getCurrentSession().createQuery("UPDATE otp_check SET OTP='" + otp1
							+ "' WHERE CONTACT='" + number + "' AND USER_TYPE='" + usertype + "'").executeUpdate();
					if (i > 0) {
						//System.out.println("OTP CHECK updated***");
					} else {
						//System.out.println("Update failed*********");
					}
				}
			} catch (Exception e13) {
				e13.printStackTrace();
			}

			// otp send to mobile number call url
			url = url.replace("spalert_msg", "Your%20IT-HelpDesk%20Forgot%20Password%20OTP%20is:%20" + otp1);
			String url12 = url.replace("spalert_contact", number);
			//System.out.println("url connect***" + url12);
			
			try {
				URL urll = new URL(url12);
				HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int code = connection.getResponseCode();
				//System.out.println("response Code***" + code);
				if(code == 200) {
					status = "success";
				} else {
					status = "failed";
				}

				// response code
				// 200 = success
			} catch (Exception e33) {
				e33.printStackTrace();
			}
		} catch (Exception e) {
			//System.out.println("exception e****" + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String checkOTP(String name, String usertype, String number, String otp) {
		// TODO Auto-generated method stub
		HttpRequest request;
		HttpResponse response;
		//System.out.println("inside send otp method***");
		PrintWriter out = null;
		String tableotp = "";
		String status1 = null;
		try {
//			out = response.getWriter();
			List<otp_check> otp_check_list = sessionFactory.getCurrentSession()
					.createQuery("from otp_check where CONTACT='" + number + "' AND USER_TYPE='" + usertype + "'")
					.list();
			for (otp_check otp_check_data : otp_check_list) {
				tableotp = otp_check_data.getOTP();
			}
			//System.out.println("tableotp " + tableotp);

			if (tableotp.equals(otp)) {
				status1 = "success";
			} else {
				status1 = "failed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status1;
	}

	@Override
	public String Setpassword(String name, String usertype, String pass) {
		// TODO Auto-generated method stub
		//System.out.println("inside send otp method***");

		PrintWriter out = null;
		String status = null;
		try {
			if (usertype.equals("Engineer")) {
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE enggmaster SET ENG_PWD='" + pass
						+ "',CONFPASS='" + pass + "' where ENG_UNAME='" + name + "'").executeUpdate();
				if (i > 0) {
					status = "success";
				} else {
					status = "failed";
				}

			} else if (usertype.equals("Admin")) {
				int i = sessionFactory.getCurrentSession()
						.createQuery("UPDATE login SET PASSWORD='" + pass + "' where USERNAME='" + name + "'")
						.executeUpdate();
				if (i > 0) {
					status = "success";
				} else {
					status = "failed";
				}

			} else if (usertype.equals("Ticket Co-ordinator")) {
				int i = sessionFactory.getCurrentSession()
						.createQuery("UPDATE tpmaster SET TP_PWD='" + pass + "' where TP_UNAME='" + name + "'")
						.executeUpdate();
				if (i > 0) {
					status = "success";
				} else {
					status = "failed";
				}

			} else if (usertype.equals("Client")) {
				int i = sessionFactory.getCurrentSession().createQuery("UPDATE usermaster SET PASSWORD='" + pass
						+ "',CONFPASS='" + pass + "' where USERNAME='" + name + "'").executeUpdate();
				if (i > 0) {
					status = "success";
				} else {
					status = "failed";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String getADFullName(String username) {
		String UserFullName="";
		try {
			List<AD_USER_MANAGE> all_data=new ArrayList<AD_USER_MANAGE>();

			Query q1 = sessionFactory.getCurrentSession().createQuery("FROM AD_USER_MANAGE WHERE USERNAME= :id");
			q1.setParameter("id",username);
			
			all_data=q1.list();

			for (AD_USER_MANAGE a : all_data) {
			
				UserFullName=a.getNAME();
			}
		}catch(Exception e){
		e.printStackTrace();	
		}
		return UserFullName;
	}

	@Override
	public JSONArray getAuthentication(String username, String password,String companycode) {
		
		


		//System.out.println("INSIDE getAuthentication DAO IMPL");
		//System.out.println("USERNAME INPUT: "+username);
		JSONArray finalOutput=new JSONArray();
		JSONObject arrayobj = new JSONObject();
		String USERNAME_DB="";
		String PASSWORD_DB="";
		String ROLE_TYPE_DB="";
		String LOGIN_TYPE_DB="";
		String LOGIN_SCOPE_DB="";
		String COMPANY_NAME="";
		String Company_codedb="";
		int loginid=0;
		String COMPANY_NAME2="";
		String loginpassword=null;
		String DESIGNATION="";
		String BRANCH="";
		String DEPARTMENT="";
		String usernamec="";
		String compc="";
		String visibility="";
		String company_CODE="";
		String GROUPNAME="";
		String SIDEBAR="";
		String LASTLOGIN = "";
		String VIEW_DESIGNATION = "";
		//  HttpSession session = request.getSession();
		
		try {
			///////////////// CHECKING ANG GETTING COMPANY NAME FROM COMPANY CODE MASTER
			///////////////// ///////////
			List<company_code_master> Companycodedata = sessionFactory.getCurrentSession()
					.createQuery("from company_code_master where COMPANY_CODE='" + companycode + "'").list();
			// System.out.println("before loop");

			try {
				List<loginmaster> userData = sessionFactory.getCurrentSession()
						.createQuery("from loginmaster where USERNAME='" + username + "' ").list();
				String lastLogin = null;
				String roleType = null;
				String loginHistory = null;

				DateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				Date curdate = new Date();
				String current_dateTime = dateTimeFormat.format(curdate);

				for (loginmaster data : userData) {
					roleType = data.getROLE_TYPE();
					
					try {
						
						if(data.getLOGIN_HISTORY() == null || data.getLOGIN_HISTORY().contentEquals("")) {
							loginHistory = current_dateTime;
						} else {
							loginHistory = data.getLOGIN_HISTORY();
							
							String[] entries = loginHistory.split(",");
						    int count = entries.length;
						    
							if(count < 60) {
								if(loginHistory.contains(current_dateTime.split(" ")[0])) {
									loginHistory = data.getLOGIN_HISTORY();
								} else {
									loginHistory = loginHistory +","+ current_dateTime;
								}
							} else {
								loginHistory = current_dateTime;
							}	
						}
					} catch (Exception e) {
						loginHistory = current_dateTime;
					}
					
					if (data.getLast_login_time() == null || data.getLast_login_time().contentEquals("")) {
						lastLogin = current_dateTime;
					} else {
						lastLogin = data.getLast_login_time();
					}
				}

//				Date lastLoginDate = dateTimeFormat.parse(lastLogin);
//				Date currentDate = new Date();
//
//				LocalDateTime lastLoginDateTime = LocalDateTime.ofInstant(lastLoginDate.toInstant(),
//						ZoneId.systemDefault());
//				LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
//						ZoneId.systemDefault());
//
//				long daysss = calculateDaysExcludingSpecificDays(lastLoginDateTime.toLocalDate(),
//						currentDateTime.toLocalDate());
//				System.out.println("daysss " + daysss);
//				String ddays = Long.toString(daysss);
//				
//				System.out.println("Total inactive days::"+ddays);
				
				
				Date lastLoginDate = dateTimeFormat.parse(lastLogin);
				Date currentDate = new Date();

				LocalDateTime lastLoginDateTime = LocalDateTime.ofInstant(lastLoginDate.toInstant(), ZoneId.systemDefault());
				LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());

				Duration duration = Duration.between(lastLoginDateTime, currentDateTime);

				long ddays = duration.toDays();
				long remainingHours = duration.toHours() - ddays * 24;  // Remaining hours after considering full days

				System.out.println("Total inactive time: " + ddays + " days and " + remainingHours + " hours");


//				if (ddays >= 3 || (ddays == 2 && remainingHours >= 24)) {
//				if (ddays >= 1 || (ddays == 0 && remainingHours >= 24)) {

//					if(roleType.equalsIgnoreCase("Developer") || roleType.equalsIgnoreCase("Tester") ) {
//						LASTLOGIN = "false";
//						String hql = "update loginmaster set ACTIVE_USER=:Astatus,TOTAL_INACTIVE_DAYS=:days WHERE USERNAME= :uname";
//						Query q = sessionFactory.getCurrentSession().createQuery(hql);
//
//						q.setParameter("uname", username);
//						q.setParameter("Astatus", "Inactive");
//						q.setParameter("days",Long.toString(ddays));
//						int ii = q.executeUpdate();
//					} else {
//						LASTLOGIN = "true";
//						String hql = "update loginmaster set last_login_time=:curdate ,ACTIVE_USER=:Astatus,TOTAL_INACTIVE_DAYS=:days WHERE USERNAME= :uname";
//						Query q = sessionFactory.getCurrentSession().createQuery(hql);
//
//						q.setParameter("uname", username);
//						q.setParameter("curdate", current_dateTime);
//						q.setParameter("Astatus", "Active");
//						q.setParameter("days",Long.toString(ddays));
//
//						q.executeUpdate();
//					}
					
					System.out.println("Last login is more than 3 days ago.");
//				} else {
					LASTLOGIN = "true";

					String hql = "update loginmaster set last_login_time=:curdate ,ACTIVE_USER=:Astatus,TOTAL_INACTIVE_DAYS=:days, LOGIN_HISTORY=:history WHERE USERNAME= :uname";
					Query q = sessionFactory.getCurrentSession().createQuery(hql);

					q.setParameter("uname", username);
					q.setParameter("curdate", current_dateTime);
					q.setParameter("Astatus", "Active");
					q.setParameter("days", "0");
					q.setParameter("history", loginHistory);

					q.executeUpdate();
//				}

			} catch (Exception e) {
				e.printStackTrace();
			}

//			  //System.out.println("COMPANY NAME FOUND FOR COMPANY CODE "+companycode+ " IS "+COMPANY_NAME);

			if (Companycodedata.isEmpty()) {
				// //System.out.println("FOUND NO COMPANY FOR COMPANY CODE: "+companycode);
				// //System.out.println("NO Companycode FOUND");
				arrayobj.put("USERNAME", "NA");
				arrayobj.put("FULLNAME", "NA");
				arrayobj.put("ROLE", "NA");
				arrayobj.put("LOGIN_TYPE", "NA");
				arrayobj.put("LOGIN_SCOPE", "NA");
				arrayobj.put("STATUS", "nocompanycode");
				arrayobj.put("companyname", COMPANY_NAME2);
				arrayobj.put("visibility", "NA");
				arrayobj.put("GROUP", "NA");
				arrayobj.put("SIDEBARSCOPE", "NA");
				finalOutput.put(arrayobj);
			} else {
				for (company_code_master sourceDrive3 : Companycodedata) {
					company_CODE = sourceDrive3.getCOMPANY_CODE();
				}
				if (company_CODE.equals(companycode)) {
					for (company_code_master sourceDrive3 : Companycodedata) {
						COMPANY_NAME = sourceDrive3.getCOMPANY_NAME();
						// //System.out.println("FOUND COMPANY "+COMPANY_NAME+" FOR COMPANY CODE:
						// "+companycode);

						//////////////// GETTING AND CHECKING IF USERNAME EXISTS IN THAT COMPANY
						//////////////// ///////////
						List<loginmaster> logindata2 = sessionFactory.getCurrentSession()
								.createQuery("from loginmaster where USERNAME='" + username + "' AND COMPANY='"
										+ COMPANY_NAME + "' ")
								.list();

						if (logindata2.isEmpty()) {
							// //System.out.println("NO USER FOUND FOR COMPANY: "+COMPANY_NAME);
							// //System.out.println("NO USERNAME FOUND");
							arrayobj.put("USERNAME", "NA");
							arrayobj.put("FULLNAME", "NA");
							arrayobj.put("ROLE", "NA");
							arrayobj.put("LOGIN_TYPE", "NA");
							arrayobj.put("LOGIN_SCOPE", "NA");
							arrayobj.put("STATUS", "Fail");
							arrayobj.put("DESIGNATION", "NA");
							arrayobj.put("visibility", "NA");
							arrayobj.put("BRANCH", "NA");
							arrayobj.put("DEPARTMENT", "NA");
							arrayobj.put("GROUP", "NA");
							arrayobj.put("SIDEBARSCOPE", "NA");
							finalOutput.put(arrayobj);
						} else {
							// System.out.println("USER FOUND FOR COMPANY: "+COMPANY_NAME);

							for (loginmaster sourceDrive12 : logindata2) {
								usernamec = sourceDrive12.getUSERNAME();
								compc = sourceDrive12.getCOMPANY();
							}
							if (usernamec.equals(username) && compc.equals(COMPANY_NAME)) {
								for (loginmaster sourceDrive : logindata2) {
									USERNAME_DB = sourceDrive.getUSERNAME();
									PASSWORD_DB = sourceDrive.getPASSWORD();
									ROLE_TYPE_DB = sourceDrive.getROLE_TYPE();
									LOGIN_TYPE_DB = sourceDrive.getLOGIN_TYPE();
									LOGIN_SCOPE_DB = sourceDrive.getLOGIN_SCOPE();
									COMPANY_NAME2 = sourceDrive.getCOMPANY();
									DESIGNATION = sourceDrive.getDESIGNATION();
									visibility = sourceDrive.getVISIBILITY();
									BRANCH = sourceDrive.getBRANCH();
									DEPARTMENT = sourceDrive.getDEPARTMENT();
									GROUPNAME = sourceDrive.getGROUP_NAME();
									SIDEBAR = sourceDrive.getSIDEBAR_SCOPE();
									if(sourceDrive.getVIEW_DESIGNATION() == null || sourceDrive.getVIEW_DESIGNATION().contentEquals("")) {
										VIEW_DESIGNATION = sourceDrive.getDESIGNATION();
									} else {
										VIEW_DESIGNATION = sourceDrive.getVIEW_DESIGNATION();
									}
									
									if (ROLE_TYPE_DB.equals("Ticket Co-ordinator") && !visibility.isEmpty()) {
										arrayobj.put("visibility", visibility);
									} else {
										arrayobj.put("visibility", "NA");
										visibility = "NA";
									}
									// //System.out.println("COMAPNY VALUE ::" +sourceDrive.getCOMPANY());
									// System.out.println("COMAPNY VALUE ::" +COMPANY_NAME2);
									// session.setAttribute("companyname", sourceDrive.getCOMPANY());
									//// System.out.println("LOGIN SCOPE FOUND: "+LOGIN_SCOPE_DB);
									if (LOGIN_SCOPE_DB == null || LOGIN_SCOPE_DB.equals("null")
											|| LOGIN_SCOPE_DB.equals("") || LOGIN_SCOPE_DB == ""
											|| LOGIN_SCOPE_DB == "null" || LOGIN_SCOPE_DB.equals(null)) {
										// System.out.println("INSIDE NULL FOUND: "+LOGIN_SCOPE_DB);
										LOGIN_SCOPE_DB = "NA";
									}

//							//System.out.println("USERNAME_DB: "+USERNAME_DB);
//							//System.out.println("PASSWORD_DB: "+PASSWORD_DB);
//							//System.out.println("ROLE_TYPE_DB: "+ROLE_TYPE_DB);
//							//System.out.println("LOGIN_TYPE_DB: "+LOGIN_TYPE_DB);
									// System.out.println("LOGIN_SCOPE_DB: "+LOGIN_SCOPE_DB);
									// System.out.println("Usertype--- " + LOGIN_TYPE_DB);
									//////////////////////// VALIDATION BASED ON LOGIN TYPE //////////////
									if (LOGIN_TYPE_DB.equals("Non-AD")) {
										System.out.println("IN NON AD BLOCK");
										////////////////// CHECK IF PASSWORD MATCHES WITH DATABASE /////////////////
										if (password.equals(PASSWORD_DB)) {
											System.out.println("PASS MATCH if");
											arrayobj.put("USERNAME", USERNAME_DB);
											arrayobj.put("FULLNAME", sourceDrive.getFULL_NAME());
											arrayobj.put("ROLE", ROLE_TYPE_DB);
											arrayobj.put("LOGIN_TYPE", LOGIN_TYPE_DB);
											arrayobj.put("LOGIN_SCOPE", LOGIN_SCOPE_DB);
											arrayobj.put("STATUS", "Pass");
											arrayobj.put("companyname", COMPANY_NAME2);

											arrayobj.put("DESIGNATION", DESIGNATION);
											arrayobj.put("visibility", visibility);
											arrayobj.put("BRANCH", BRANCH);
											arrayobj.put("DEPARTMENT", DEPARTMENT);
											arrayobj.put("GROUP", GROUPNAME);
											arrayobj.put("SIDEBARSCOPE", SIDEBAR);
											arrayobj.put("LASTLOGIN", LASTLOGIN);
											arrayobj.put("VIEW_DESIGNATION", VIEW_DESIGNATION);
											
											finalOutput.put(arrayobj);

										} else {
											System.out.println("PASS NOT MATCHED else");
											arrayobj.put("USERNAME", USERNAME_DB);
											arrayobj.put("FULLNAME", sourceDrive.getFULL_NAME());
											arrayobj.put("ROLE", ROLE_TYPE_DB);
											arrayobj.put("LOGIN_TYPE", LOGIN_TYPE_DB);
											arrayobj.put("LOGIN_SCOPE", LOGIN_SCOPE_DB);
											arrayobj.put("STATUS", "Fail");
											arrayobj.put("companyname", COMPANY_NAME2);
											arrayobj.put("DESIGNATION", DESIGNATION);
											arrayobj.put("visibility", visibility);
											arrayobj.put("BRANCH", BRANCH);
											arrayobj.put("DEPARTMENT", DEPARTMENT);
											arrayobj.put("GROUP", GROUPNAME);
											arrayobj.put("SIDEBARSCOPE", SIDEBAR);
											arrayobj.put("LASTLOGIN", LASTLOGIN);
											arrayobj.put("VIEW_DESIGNATION", VIEW_DESIGNATION);

											finalOutput.put(arrayobj);
										}

									}

									else if (LOGIN_TYPE_DB.equals("AD")) {
										System.out.println("IN AD BLOCK");

										JSONObject ad_output = getADVerified(username, COMPANY_NAME);
										// System.out.println("ALL VALUES::"+ad_output);
										// String[] arrOfStr22 = ad_output.split("~");
										// username11=arrOfStr22[0];
										String host11 = ad_output.get("HOST").toString();
										String port11 = ad_output.get("PORT").toString();
										String domainname11 = ad_output.get("DOMAIN_NAME").toString();

										// System.out.println("host " +host11);
										// System.out.println("Post " +port11);
										// System.out.println("domainname " +domainname11);

//								//System.out.println("host:"+ad_output[0]["hh"]+" port:"+port11+" domain:"+domainname11+" username:"+username+" password:"+password);
										// //System.out.println("host:"+ad_output["PORT"]);

										ActiveDirectory ad = new ActiveDirectory();
//						            boolean status = ad.checkCredentilas(username, password, "@"+domainname11, "ldap://"+host11+":"+port11);
										boolean status = ad.checkCredentials(username, password, domainname11, host11,
												port11);
										// System.out.println("Statusss:"+status);
										if (status == true) {
											//// System.out.println("status is true so success----------------");

											String getADFullName = getADFullName(username);

//						            	 controller_response=password+"~"+username+"~"+""+"~"+getADFullName+"~"+"success";
											// System.out.println("AD PASSED MATCHED");
											arrayobj.put("USERNAME", USERNAME_DB);
											arrayobj.put("FULLNAME", getADFullName);
											arrayobj.put("ROLE", ROLE_TYPE_DB);
											arrayobj.put("LOGIN_TYPE", LOGIN_TYPE_DB);
											arrayobj.put("LOGIN_SCOPE", LOGIN_SCOPE_DB);
											arrayobj.put("STATUS", "Pass");
											arrayobj.put("companyname", COMPANY_NAME2);
											arrayobj.put("DESIGNATION", DESIGNATION);
											arrayobj.put("visibility", visibility);
											arrayobj.put("BRANCH", BRANCH);
											arrayobj.put("DEPARTMENT", DEPARTMENT);
											arrayobj.put("GROUP", GROUPNAME);
											arrayobj.put("SIDEBARSCOPE", SIDEBAR);
											arrayobj.put("LASTLOGIN", LASTLOGIN);
											arrayobj.put("VIEW_DESIGNATION", VIEW_DESIGNATION);
											
											finalOutput.put(arrayobj);
										} else {
											String getADFullName = getADFullName(username);
//						            	controller_response=password+"~"+username+"~"+""+"~"+getADFullName+"~"+"error";
											// System.out.println("AD PASSED MATCHED");
											arrayobj.put("USERNAME", USERNAME_DB);
											arrayobj.put("FULLNAME", getADFullName);
											arrayobj.put("ROLE", ROLE_TYPE_DB);
											arrayobj.put("LOGIN_TYPE", LOGIN_TYPE_DB);
											arrayobj.put("LOGIN_SCOPE", LOGIN_SCOPE_DB);
											arrayobj.put("STATUS", "Fail");
											arrayobj.put("companyname", COMPANY_NAME2);
											arrayobj.put("DESIGNATION", DESIGNATION);
											arrayobj.put("visibility", visibility);
											arrayobj.put("BRANCH", BRANCH);
											arrayobj.put("DEPARTMENT", DEPARTMENT);
											arrayobj.put("GROUP", GROUPNAME);
											arrayobj.put("SIDEBARSCOPE", SIDEBAR);
											arrayobj.put("LASTLOGIN", LASTLOGIN);
											arrayobj.put("VIEW_DESIGNATION", VIEW_DESIGNATION);
											
											finalOutput.put(arrayobj);

										}
									}
								}
							} else {
								arrayobj.put("USERNAME", "NA");
								arrayobj.put("FULLNAME", "NA");
								arrayobj.put("ROLE", "NA");
								arrayobj.put("LOGIN_TYPE", "NA");
								arrayobj.put("LOGIN_SCOPE", "NA");
								arrayobj.put("STATUS", "Fail");
								arrayobj.put("DESIGNATION", "NA");
								arrayobj.put("visibility", "NA");
								arrayobj.put("BRANCH", "NA");
								arrayobj.put("DEPARTMENT", "NA");
								arrayobj.put("GROUP", "NA");
								arrayobj.put("SIDEBARSCOPE", "NA");
								finalOutput.put(arrayobj);
							}
						}

					}

				} else {
					arrayobj.put("USERNAME", "NA");
					arrayobj.put("FULLNAME", "NA");
					arrayobj.put("ROLE", "NA");
					arrayobj.put("LOGIN_TYPE", "NA");
					arrayobj.put("LOGIN_SCOPE", "NA");
					arrayobj.put("STATUS", "Fail");
					arrayobj.put("DESIGNATION", "NA");
					arrayobj.put("visibility", "NA");
					arrayobj.put("BRANCH", "NA");
					arrayobj.put("DEPARTMENT", "NA");
					arrayobj.put("GROUP", "NA");
					arrayobj.put("SIDEBARSCOPE", "NA");
					finalOutput.put(arrayobj);
				}
			}
		}catch(Exception e) {
			//System.out.println("Exception in login found");
			e.printStackTrace();
		}
return finalOutput;
	
	}
	
	
	 public static long calculateDaysExcludingSpecificDays(LocalDate startDate, LocalDate endDate) {
	        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
	        long excludedDays = 0;

	        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
	            if (isSecondOrFourthSaturday(date) || isSunday(date)) {
	                excludedDays++;
	            }
	        }
	        return totalDays - excludedDays;
	    }

	    private static boolean isSecondOrFourthSaturday(LocalDate date) {
	        if (date.getDayOfWeek() != DayOfWeek.SATURDAY) {
	            return false;
	        }
	        int dayOfMonth = date.getDayOfMonth();
	        int weekOfMonth = (dayOfMonth - 1) / 7 + 1;

	        return weekOfMonth == 2 || weekOfMonth == 4;
	    }

	    private static boolean isSunday(LocalDate date) {
	        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
	    }

	
	
	
	
	
	
	public JSONObject getADVerified(String username, String COMPANY_NAME) {
		JSONArray finalOutput=new JSONArray();
		JSONObject arrayobj = new JSONObject();
		 JsonArray jsArray=null;
		 String user="";
         String host="";
         String port="";
         String domain_name="";
         //System.out.println("%%%%%%%%%%%%%");
       
		try {
			//System.out.println("Before Projection List ");
			Session s=getSession();
			
			//System.out.println("s ="+s);
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(AD_INTEGRATION.class);
			ProjectionList proList = Projections.projectionList();
			//System.out.println("Projection List started");

			proList.add(Projections.property("HOST"), "HOST");
			proList.add(Projections.property("PORT"), "PORT");
			proList.add(Projections.property("DOMAIN_NAME"), "DOMAIN_NAME");
			
			crit.setProjection(Projections.distinct(proList));

			long row=0;
			String SQL_QUERY = "SELECT COUNT(*) FROM AD_INTEGRATION";
			  Query query = s.createQuery(SQL_QUERY);
			  for(Iterator it=query.iterate();it.hasNext();)
			  {
			  row = (Long) it.next();
			   System.out.print("Count here: " + row+" ");
			  }
			  
			  if(row!=0) {
			@SuppressWarnings("unchecked")
			List<AD_INTEGRATION> dataList = sessionFactory.getCurrentSession().createQuery("from AD_INTEGRATION where COMPANY='" + COMPANY_NAME + "'").list();
			
			//crit.setResultTransformer(Transformers.aliasToBean(AD_INTEGRATION.class))
				
			for (AD_INTEGRATION sourceDrive : dataList) {
				
				
				jsArray=new JsonArray();
				//System.out.println("getUsername = "+sourceDrive.getUSERNAME());
				//System.out.println("getHost = "+sourceDrive.getHOST());
				//System.out.println("getPort = "+sourceDrive.getPORT());
				//System.out.println("getDomain_name = "+sourceDrive.getDOMAIN_NAME());
				////System.out.println("array = "+sourceDrive.getPass());
				//user=sourceDrive.getUsername();
				
				arrayobj.put("HOST", sourceDrive.getHOST());
				arrayobj.put("PORT", sourceDrive.getPORT());
				arrayobj.put("DOMAIN_NAME", sourceDrive.getDOMAIN_NAME());
				
				finalOutput.put(arrayobj);
			
				
				 
//				 host= port=sourceDrive.getPORT(); d
//				 omain_name=sourceDrive.getDOMAIN_NAME();
//						
			}
			  }
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("ERRROR inf AD get values"+e);
		}
		
		//System.out.println(" host~port~domain_name==="+ host+"~"+port+"~"+domain_name);
	//	return host+"~"+port+"~"+domain_name;
		return arrayobj;
	}
	
	
	@Override
	public JSONArray checkMFAType(String user, String userType) {
		
		JSONArray finalOutput=new JSONArray();
		JSONObject arrayobj = new JSONObject();
		
		try {

			String MFAType = "OFF";

			String phno = null;
			String URL1 = "";
			String URL2 = "";
			String url12 = "";
			List<TwoFactorAuthenticationType> dataList = sessionFactory.getCurrentSession()
					.createQuery("from TwoFactorAuthenticationType").list();

			for (TwoFactorAuthenticationType mfa : dataList) {

				MFAType = mfa.getAuthentication_Type();

			}

			//System.out.println("MFAType:-" + MFAType);
			
			arrayobj.put("MFA_TYPE", MFAType);

			if (MFAType != null && MFAType.equalsIgnoreCase("SMS")) {
				arrayobj.put("FIRST_LOGIN", "NA");
				Query query2 = sessionFactory.getCurrentSession().createSQLQuery(
						"Select PHONE from LOGINMASTER where USERNAME='" + user + "' and ROLE_TYPE='" + userType + "'");
				List<loginmaster> UserNOs = query2
						.setResultTransformer(Transformers.aliasToBean(loginmaster.class)).list();
				for (loginmaster lm : UserNOs) {
					phno = lm.getPHONE();

				}

				//System.out.println("PHONE No for SMS:-" + phno);
				String secretKey = System.getenv("SCM_SMS_TOTP_SECRET");
				String otp = getTOTPCode(secretKey);
				//System.out.println("getOTPCode:-" + otp);

				Query query = sessionFactory.getCurrentSession().createQuery("from sms_config");

				List<sms_config> smsData = query.list();
				//System.out.println("before user if" + smsData);

				for (sms_config dataList12 : smsData) {

					URL1 = dataList12.getURL();
					URL2 = dataList12.getPARAM();
					//System.out.println("url1***-----------------" + URL1 + "\nurl2***-------------------" + URL2);
					String url = URL1.concat("?");
					url = url.concat(URL2);
					//System.out.println("After concat***---------------------u1+u2===" + url);

					url = url.replace("spalert_msg",
							"%20Hi%20" + user.toUpperCase() + "%20,%20" + otp + "%20is%20OTP%20for%20ITSM%20 .%20");

					url12 = url.replace("spalert_contact", phno);
					if (url12.contains(" "))
						url12 = url12.replace(" ", "%20");
					//System.out.println("url connect***--------------------" + url12);

				}

				try {
					//System.out.println("SendOTP Thread is calling started.....");
					Thread t = new Thread(new SendOTP(url12));
					t.join();
					t.start();
					//System.out.println("Thread is calling finished.....");
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else if (MFAType != null && MFAType.equalsIgnoreCase("GoogleAppAuthentication")) {

				String FIRST_LOGIN = "false";

				Query query2 = sessionFactory.getCurrentSession().createSQLQuery(
						"Select FIRST_LOGIN from LOGINMASTER where USERNAME='" + user + "' and ROLE_TYPE='" + userType + "'");
				List<loginmaster> UserNOs = query2
						.setResultTransformer(Transformers.aliasToBean(loginmaster.class)).list();
				for (loginmaster tfa : UserNOs) {
					FIRST_LOGIN = tfa.getFIRST_LOGIN();

				}

				//System.out.println("Is FIRST_LOGIN:-" + FIRST_LOGIN);

				if (FIRST_LOGIN.equalsIgnoreCase("true")) {

					String res = generateQRCode(user, userType);

					if (res != null && res.equalsIgnoreCase("Success")) {

						arrayobj.put("FIRST_LOGIN", "yes");
						
						
					} else {

						arrayobj.put("FIRST_LOGIN", "no");
						
					}

				} else if (FIRST_LOGIN.equalsIgnoreCase("false")) {

					arrayobj.put("FIRST_LOGIN", "no");
					

				}

			}else {
				
				arrayobj.put("FIRST_LOGIN", "NA");
			}
			
			

		} catch (Exception e) {
			
			//System.out.println("Exception in check MFA:-" + e);
			e.printStackTrace();
		}
		
		finalOutput.put(arrayobj);

		return finalOutput;
	}

	public static String getTOTPCode(String secretKey) {
		Base32 base32 = new Base32();
		byte[] bytes = base32.decode(secretKey);
		String hexKey = Hex.encodeHexString(bytes);
		return TOTP.getOTP(hexKey);
	}
	

	public static String generateSecretKey() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		Base32 base32 = new Base32();
		//System.out.println();
		return base32.encodeToString(bytes);
	}
	
	public String generateQRCode(String user, String userType) {

		String status = "Fail";

		String secretKey = generateSecretKey();
		// String secretKey = System.getenv("SCM_SMS_TOTP_SECRET");
		//System.out.println("secretKey:-" + secretKey);

		String email = "SarjeraoPhanse@velox.co.in";
		String companyName = "Velox Solution";
		String barCodeUrl = getGoogleAuthenticatorQRCode(secretKey, email, companyName);
		//System.out.println(barCodeUrl);
		
		String path=ApplicationPropertyReader.QR_Code_Path;
		//System.out.println("QR COde path:-"+path);
		try {
			createQRCode(barCodeUrl, path, 400, 350);
			//System.out.println("Barcode generated for user:-" + user);
			status = "Success";

		} catch (WriterException | IOException e) {
			//System.out.println("Exception in generateQRCode:-" + e);
			e.printStackTrace();

		}

		try {

			if (status != null && status.equalsIgnoreCase("Success")) {

				Query query1 = sessionFactory.getCurrentSession().createQuery("update loginmaster set "
						+ "SECRETKEY =:secretKey where USERNAME =:USER_NAME and ROLE_TYPE =:USER_TYPE");

				query1.setParameter("secretKey", secretKey);

				query1.setParameter("USER_NAME", user);
				query1.setParameter("USER_TYPE", userType);

				int updateVal = query1.executeUpdate();

				//System.out.println("updateVal of secretKey:-" + updateVal);

			}

		} catch (Exception e) {

			//System.out.println("Exception in updateVal of secretKey:-" + e);
			e.printStackTrace();
		}

		return status;

	}

	

	public static String getGoogleAuthenticatorQRCode(String secretKey, String account, String issuer) {
		try {
			return "otpauth://totp/" + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
					+ "?secret=" + URLEncoder.encode(secretKey, "UTF-8").replace("+", "%20") + "&issuer="
					+ URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static void createQRCode(String barCodeData, String filePath, int height, int width)
			throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE, width, height);
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			MatrixToImageWriter.writeToStream(matrix, "png", out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public String verifyOTP(String username, String userType, String otp) {

		//System.out.println("Inside verifyOTP Dao Impl");
		String status = "fail";
		try {

			String sk = "";
			String generatedOTP = "";

			Query query2 = sessionFactory.getCurrentSession().createSQLQuery(
					"Select SECRETKEY from LOGINMASTER where USERNAME='" + username + "' and ROLE_TYPE='" + userType + "'");
			List<loginmaster> UserNOs = query2
					.setResultTransformer(Transformers.aliasToBean(loginmaster.class)).list();
			for (loginmaster tfa : UserNOs) {
				sk = tfa.getSECRETKEY();

			}
			generatedOTP = getTOTPCode(sk);
			//System.out.println("First Time OTP:- " + otp + " generatedOTP:-" + generatedOTP);
			if (otp != null && generatedOTP != null) {
				if (otp.equals(generatedOTP)) {
					status = "success";
					//System.out.println("OTP Matched successfully");
				} else {
					status = "fail";
					//System.out.println("OTP does not Matched ");
				}

			}

			if (status.equalsIgnoreCase("fail")) {
				//System.out.println("2nd Time OTP verification");
				Thread.sleep(5000);

				generatedOTP = getTOTPCode(sk);
				//System.out.println("Second Time OTP:- " + otp + " generatedOTP:-" + generatedOTP);
				if (otp != null && generatedOTP != null) {
					if (otp.equals(generatedOTP)) {
						status = "success";
						//System.out.println("2nd Time OTP Matched successfully");
					} else {
						status = "fail";
						//System.out.println("2nd Time OTP does not Matched ");
					}

				}

			}

		} catch (Exception e) {
			status = "fail";
			//System.out.println("Exception in verifyOTP Dao Impl:-" + e);
			e.printStackTrace();
		}

		if (status != null && status.equalsIgnoreCase("success")) {
			try {

				Query query1 = sessionFactory.getCurrentSession().createQuery("update loginmaster set "
						+ "FIRST_LOGIN =:FIRST_LOGIN where USERNAME =:USER_NAME and ROLE_TYPE =:USER_TYPE");

				query1.setParameter("FIRST_LOGIN", "false");

				query1.setParameter("USER_NAME", username);
				query1.setParameter("USER_TYPE", userType);

				int updateVal = query1.executeUpdate();

				//System.out.println("updateVal of FIRST_LOGIN:-" + updateVal);

			} catch (Exception e) {
				//System.out.println("Exception in updating FIrst login status:-" + e);
				e.printStackTrace();

			}

		}

		return status;
	}

	@Override
	public Object setactivestatus(String username, String status) {
		try { 
			if(status.equals("Login")) {
			Query query1 = sessionFactory.getCurrentSession().createQuery("update loginmaster set "
					+ "ACTIVE_STATUS =:as where USERNAME =:USER_NAME"); 
			query1.setParameter("as", "True"); 
			query1.setParameter("USER_NAME", username); 
			int updateVal = query1.executeUpdate(); 
			System.out.println("Login of ACtive_status ++++==========================:-" + updateVal);
			}
			if(status.equals("Logout")) {
				Query query1 = sessionFactory.getCurrentSession().createQuery("update loginmaster set "
						+ "ACTIVE_STATUS =:as where USERNAME =:USER_NAME"); 
				query1.setParameter("as", "False"); 
				query1.setParameter("USER_NAME", username); 
				int updateVal = query1.executeUpdate(); 
				System.out.println("Logout of ACtive_status ++++==========================:-" + updateVal);
				}
		} catch (Exception e) {
			System.out.println("Exception in updating ACtivbe Status status:-" + e);
			e.printStackTrace(); 
		}
		return username;
	}

	
	//05/07
	@Override
	public JSONArray sendMail(String name) {
	    System.out.println("helloooooooooooo");
	    List<loginmaster> list = sessionFactory.getCurrentSession().createQuery("from loginmaster where USERNAME='"+name+"'").list();
	    System.out.println("hiiiiiiiiiiiiiii");
	    
	    DateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	    Date curdate = new Date();
	    String current_dateTime = dateTimeFormat.format(curdate);
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    Date currentDate = new Date();
	    String formattedCurrentDate = dateFormat.format(currentDate);
	    
	    System.out.println("current_dateTime"+current_dateTime);
	    System.out.println("formattedCurrentDate"+formattedCurrentDate);
	    
	    JSONArray array=new JSONArray();
	    try {
	        for (loginmaster user : list) {
	            JSONArray userarr = new JSONArray();
	            userarr.put(user.getFULL_NAME());
	            userarr.put(user.getSEND_MAIL_DATE());
	            
	            // Check if send mail date needs to be updated
	            String formattedSendMailDate = null;
	            
	            String sendMailDate=user.getSEND_MAIL_DATE();
	            if(user.getSEND_MAIL_DATE()==null)
                {
                    String[] sendMailDateAndTime=sendMailDate.split(" ");
	                formattedSendMailDate=sendMailDateAndTime[0];
                }
                else
                {
                    	String[] sendMailDateAndTime=sendMailDate.split(" ");
	                    formattedSendMailDate=sendMailDateAndTime[0];
                }
	            
	            
	            if (formattedSendMailDate == null || !(formattedSendMailDate.equals(formattedCurrentDate))) {
	                // Update send mail date
	                Query query = sessionFactory.getCurrentSession().createQuery("update loginmaster set SEND_MAIl_DATE='"+current_dateTime+"' where USERNAME='"+name+"'");
	                int res=query.executeUpdate();
	                if (res != 0) {
	                    // Mail start
	                    try {
	                        String temp = name;
	                        System.out.println("sales_ini" + temp);
	                        
	                        if (name.equals(temp)) {
	                            // Assuming getSession() returns a Hibernate Session
	                            Session session = getSession();
	                            
	                            List<loginmaster> allUsers = new ArrayList<>();
	                            
	                            // Query to get distinct email addresses based on USERNAME
	                            Query qByTLname = session.createQuery("SELECT EMAIL,FULL_NAME FROM loginmaster WHERE FULL_NAME IN (SELECT Team_Leader FROM TlMaster WHERE Developer = (SELECT FULL_NAME FROM loginmaster WHERE USERNAME='"+name+"'))");
	                            List<Object[]> TLResults = qByTLname.list();
	                            StringBuilder emailAddresses = new StringBuilder();
	                            StringBuilder tlName = new StringBuilder();
	                            for (Object[] result : TLResults) {
	                                String emailValue = (String) result[0];
	                                String nameValue = (String) result[1];
	                                
	                                emailAddresses.append(emailValue).append(", ");
	                                tlName.append(nameValue).append(", ");
	                            }
	                            
	                            Query qByManagername = session.createQuery("SELECT EMAIL,FULL_NAME FROM loginmaster WHERE FULL_NAME IN (SELECT ImplementerName FROM TlMaster WHERE Developer = (SELECT FULL_NAME FROM loginmaster WHERE USERNAME='"+name+"'))");
	                            List<Object[]> managerResults = qByManagername.list();
	                            
	                            // Separate the results into emailAddresses and fullNames
	                            StringBuilder emailAddresses1 = new StringBuilder();
	                            StringBuilder managerName = new StringBuilder();
	                            for (Object[] result : managerResults) {
	                                String emailValue1 = (String) result[0];
	                                String managerValue1 = (String) result[1];
	                                
	                                emailAddresses1.append(emailValue1).append(", ");
	                                managerName.append(managerValue1).append(", ");
	                            }
	                            
	                            // Query to get distinct email addresses based on FULL_NAME
	                            Query qByFullName = session.createQuery("SELECT DISTINCT FULL_NAME FROM loginmaster WHERE USERNAME IN (:authname)");
	                            qByFullName.setParameter("authname", name);
	                            List<String> reqSender = qByFullName.list();
	                            
	                            // Separate the results into emailAddresses for Authorizer
	                            StringBuilder reqSenderName = new StringBuilder();
	                            
	                            for (String emailValue : reqSender) {
	                                reqSenderName.append(emailValue).append(", ");
	                            }
	                            
	                            // Remove the trailing comma and space, if any
	                            String resulTLEmails = emailAddresses.toString().replaceAll(", $", "");
	                            String resulTLName = tlName.toString().replaceAll(", $", "");
	                            
	                            String resultManagerEmails = emailAddresses1.toString().replaceAll(", $", "");
	                            String resultManagerName = managerName.toString().replaceAll(", $", "");
	                            
	                            System.out.println("Resulting Email Addresses for team leader: " + resulTLEmails);
	                            System.out.println("Resulting Name for team leader: " + resulTLName);
	                            
	                            System.out.println("Resulting Email Addresses for manager: " + resultManagerEmails);
	                            System.out.println("Resulting Name for manager: " + resultManagerName);
	                            
	                            // Mail start
	                            mail m = new mail();
	                            
	                            // Pass the resultUserEmails and resultAuthorizerEmails to the Send_mail method
	                            if (!resulTLEmails.isEmpty() && !resultManagerEmails.isEmpty()) {
	                                
	                                Query querySend=sessionFactory.getCurrentSession().createQuery("select EMAIL from loginmaster where USERNAME='"+name+"'");
	                                String reqSenderMail=(String) querySend.uniqueResult();
	                                
	                                String userMailStatus = m.Send_mailRequestAccActivation(resulTLEmails,resulTLName,resultManagerEmails,resultManagerName,reqSenderName,reqSenderMail);
	                                System.out.println("Team Leader Mail Status: " + userMailStatus);
	                            }
//	                            else if (!resultManagerEmails.isEmpty()) {
//	                                String userMailStatus1 = m.Send_mailRequestAccActivation1(resultManagerEmails,resultManagerName,reqSenderName);
//	                                System.out.println("Team Leader Mail Status: " + userMailStatus1);
//	                            }
	                            else {
	                                System.out.println("No email addresses found for Team Leader & Manager");
	                            }
	                            
	                        }
	                        
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                        // Handle the exception as needed
	                    }
	                    // end
	                    
	                    System.out.println("updated");
	                } else {
	                    System.out.println("not updated");
	                }
	            }
	            
	            array.put(userarr);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("arrayarrayarrayarray" +array );
	    return array;
	}

	
	//29/08
	@Override
	public String checkUserandTypeVelox(String name) {

		String mailId = "";
		String Phonenum1 = "";
		String status = null;

		PrintWriter out = null;
		try {
//			out = response.getWriter();

				List<String> userlist = getSession()
						.createSQLQuery("Select EMAIL from loginmaster where USERNAME='" + name + "'").list();
//				for (Object[] usermaster : userlist) {
//					mailId = (String) usermaster[0];
//					//System.out.println("after masking Phonenum " + Phonenum1);
//					System.out.print("success" + "#" + mailId);
//				}
				if (userlist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					Object result = userlist.get(0);
		            if (result != null) {
		                mailId = result.toString();
		                status = "success#" + mailId;
		            } else {
		                status = "wrongcredentials";
		            }
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	//30/08
	@Override
	public String sendOtpToMailID(String name, String usertype, String mailId) {
		
		System.out.println("inside send otp method***");

		String status = null;
		String res=null;
		try {

//			 otp generate
			int randomPin = (int) (Math.random() * 9000) + 1000;
			String otp1 = String.valueOf(randomPin);
			System.out.println("otp***" + otp1);
			
			
			
			try {
				List<String> userlist = getSession()
						.createSQLQuery("Select FULL_NAME from loginmaster where USERNAME='" + name + "'").list();
				
				String uname=userlist.get(0);
				
				
				mail m=new mail();
				res=m.SendMailToMailID(uname, otp1, mailId);
				
				String hqlUpdate = "UPDATE loginmaster SET mailOTP = :otp, TIMESTAMP = CURRENT_TIMESTAMP where USERNAME='" + name + "'";
				int otpres = getSession().createQuery(hqlUpdate)
				                         .setParameter("otp", otp1)
				                         .executeUpdate();
				
				if(otpres > 0)
				{
					System.out.println("Updated opt in database");
				}
				else
				{
					System.out.println("Not updated");
				}
				
				
				if(res.equals("Success"))
				{
					status="success";
				}
				else
				{
					status="failed";
				}
				
			} catch (Exception e13) {
				e13.printStackTrace();
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}

	
	//30/08
//	@Override
//	public String checkOTPMail(String name, String usertype, String number, String otp) {
//		// TODO Auto-generated method stub
//		HttpRequest request;
//		HttpResponse response;
//		
//		PrintWriter out = null;
//		String tableotp = "";
//		String timestamp="";
//		String status1 = null;
//		String getStatus=null;
//		try {
////			
//			List<loginmaster> otp_check_list = sessionFactory.getCurrentSession()
//					.createQuery("from loginmaster where USERNAME='"+name+"'")
//					.list();
//			for (loginmaster otp_check_data : otp_check_list) {
//				tableotp = otp_check_data.getMailOTP();
//				timestamp = otp_check_data.getTIMESTAMP();
//			}
//			
//			
//			loginmaster otpCheckData = otp_check_list.get(0);
//	        String tableOtp = otpCheckData.getMailOTP();
//	        String otpTimestamp = otpCheckData.getTIMESTAMP();
//			
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        try {
//	            
//	            java.util.Date otpDate = dateFormat.parse(otpTimestamp);
//	            long otpTimeMillis = otpDate.getTime(); 
//
//	            
//	            long currentTimeMillis = System.currentTimeMillis();
//	            long elapsedTimeMillis = currentTimeMillis - otpTimeMillis;
//	            long fiveMinutesMillis = 5 * 60 * 1000; 
//
//	            if (tableOtp.equals(otp)) {
//	                if (elapsedTimeMillis <= fiveMinutesMillis) {
//	                    status1 = "success";
//	                } else {
//	                    status1 = "OTP expired";
//	                }
//	            } else {
//	                status1 = "failed";
//	            }
//			
//			
//			
////			if (tableotp.equals(otp)) {
////				status1 = "success";
////			} else {
////				status1 = "failed";
////			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status1;
//	}
//}
	
	
	
	
	public String checkOTPMail(String name, String usertype, String number, String otp) {
	    // TODO Auto-generated method stub
	    HttpRequest request;
	    HttpResponse response;

	    PrintWriter out = null;
	    String tableotp = "";
	    String timestamp = "";
	    String status1 = null;
	    String getStatus = null;

	    try {
	        List<loginmaster> otp_check_list = sessionFactory.getCurrentSession()
	                .createQuery("from loginmaster where USERNAME='" + name + "'")
	                .list();
	        for (loginmaster otp_check_data : otp_check_list) {
	            tableotp = otp_check_data.getMailOTP();
	            timestamp = otp_check_data.getTIMESTAMP();
	        }

	        loginmaster otpCheckData = otp_check_list.get(0);
	        String tableOtp = otpCheckData.getMailOTP();
	        String otpTimestamp = otpCheckData.getTIMESTAMP();

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        try {
	            java.util.Date otpDate = dateFormat.parse(otpTimestamp);
	            long otpTimeMillis = otpDate.getTime();

	            long currentTimeMillis = System.currentTimeMillis();
	            long elapsedTimeMillis = currentTimeMillis - otpTimeMillis;
	            long fiveMinutesMillis = 5 * 60 * 1000; // 5 minutes in milliseconds

	            if (tableOtp.equals(otp)) {
	                if (elapsedTimeMillis <= fiveMinutesMillis) {
	                    status1 = "success";
	                } else {
	                    status1 = "OTP expired";
	                    
	                    
	                    
	                    
	                }
	            } else {
	                status1 = "failed";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status1;
	}

	

	
	//30/08
	@Override
	public String SetpasswordNew(String name, String usertype, String pass) {
		// TODO Auto-generated method stub
		//System.out.println("inside send otp method***");

		PrintWriter out = null;
		String status = null;
		try {
			
			int i = sessionFactory.getCurrentSession().createQuery("UPDATE loginmaster SET PASSWORD='" + pass
						+ "'where USERNAME='" + name + "'").executeUpdate();
			if (i > 0) {
				status = "success";
			} else {
				status = "failed";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	//31/08
	@Override
	public String getRegisterMail(String name) {

		String mailId = "";
		String Phonenum1 = "";
		String status = null;

		PrintWriter out = null;
		try {

				List<?> userlist = getSession()
						.createSQLQuery("Select EMAIL from loginmaster where USERNAME='" + name + "'").list();

		
				if (userlist.isEmpty()) {
					status = "wrongcredentials";
				} else {
					Object result = userlist.get(0);
		            if (result != null) {
		                mailId = result.toString();
		              
		                String maskedEmail = maskEmail(mailId);
		                status = maskedEmail;
		            } else {
		                status = "wrongcredentials"; 
		            }
				}
				


		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("maskedEmail:::"+status);
		return status;
	}
	
	
	
	private String maskEmail(String email) {
	    if (email == null || !email.contains("@")) {
	        return email; 
	    }

	    String[] parts = email.split("@");
	    String localPart = parts[0];
	    String domainPart = parts[1];

	    String maskedLocalPart = localPart.length() > 2
	        ? localPart.substring(0, 3) + "****"
	        : localPart;

	    return maskedLocalPart + "@" + domainPart;
	}

	
	@Override
	public void saveAuditEvent(Map<String, Object> payload) {
		// TODO Auto-generated method stub

		AuditEvent event = new AuditEvent();
		event.setUsername((String) payload.get("username"));
		event.setActivity((String) payload.get("activity"));
		event.setTime((String) payload.get("time"));
		event.setDate((String) payload.get("date"));
		event.setSource("ATM_MONITORING");

	    sessionFactory.getCurrentSession().save(event);
	}


	
}