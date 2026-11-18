package com.velox.itsm.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
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
import com.velox.itsm.model.categorymaster;
import com.velox.itsm.model.companynames;
import com.velox.itsm.model.departmentnames;
import com.velox.itsm.model.enggmaster;
import com.velox.itsm.model.mail_config;
import com.velox.itsm.model.mailconfigset;
import com.velox.itsm.model.prioritymaster;
import com.velox.itsm.model.request_mode_master;
import com.velox.itsm.model.sitenames;
import com.velox.itsm.model.sms_config;
import com.velox.itsm.model.subcategorymaster;
import com.velox.itsm.model.tpmaster;
import com.velox.itsm.model.usermaster;;

@Repository("mailConfigDao")
@Transactional
public class MailConfigDaoImpl extends AbstractDao<Integer, mail_config> implements MailConfigDao {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public JSONArray MailMasterListing(String userlist) {

		//System.out.println("Inside MailConfigDaoImpl MailMasterListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
//	String db_username = null;
//	String db_usertype = null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);

			List<mail_config> dataList = sessionFactory.getCurrentSession().createQuery("from mail_config").list();
//		query.setParameter("ut", "Admin");
			array1 = new JSONArray();
			for (mail_config sourceDrive : dataList) {
				srno = srno + 1;
				//System.out.println("array = " + sourceDrive.getHOST());
				array = new JSONArray();

				array.put(srno);
				array.put("<button class='btn btn-info' id='Editbtn' onclick='EditMailConfig(\"" + sourceDrive.getSNO()
						+ "\",\"" + sourceDrive.getHOST() + "\",\"" + sourceDrive.getPORT() + "\",\""
						+ sourceDrive.getE_MAIL() + "\",\"" + sourceDrive.getAUTHO()
						+ "\" ,\"" + sourceDrive.getCOMPANY()+ "\",\"" + sourceDrive.getSTART_TLS() + "\")'><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
				array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteMailConfig(\""
						+ sourceDrive.getSNO() + "\" )'><i class='fa fa-trash'></i></button>");
				array.put(sourceDrive.getCOMPANY());
				array.put(sourceDrive.getHOST());
				array.put(sourceDrive.getPORT());
				array.put(sourceDrive.getE_MAIL());
				array.put(sourceDrive.getAUTHO());
				array.put(sourceDrive.getSTART_TLS());

				array1.put(array);
				//System.out.println("ARRAY OUTPUT: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//	return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
    public String smsConfg(String cname,String cnamevalue,String apiname,String apiurl,String uname,String uservalue1,String userpswd,String pwdvalue1,String userID,String uidvalue,String text1,String textvalue,String active4,String otherinput1,String otherinput2,String otherinput3,String otherinput4,String otherinput5,String otherinput6,String otherinput7,String otherinput8,String cname1) {
            //System.out.println("Inside MasterDaoImpl adduser method");
            String status = null;
            
            String other = (otherinput1 + "=" + otherinput2 + "&" + otherinput3 + "=" + otherinput4 + "&" + otherinput5 + "=" + otherinput6 + "&" + otherinput7 + "=" + otherinput8);
            
            String Param = uname + "=" + uservalue1 + "&" + userpswd + "=" + pwdvalue1 + "&" + userID + "=" + uidvalue + "&" + text1 + "=" + textvalue + "&" + cname + "=" + cnamevalue + "&" + other;

            try {
                    //System.out.println("Before Projection List ");
                    
                   
                    int srno=0;
                    try {
                            Criteria crit=sessionFactory.getCurrentSession().createCriteria(sms_config.class).setProjection(Projections.max("SR_NO"));
                            Integer srno1= (Integer) crit.uniqueResult();
                            
                            //System.out.println(" SRNO IS: "+srno1);
                            
//                            Query query1 =sessionFactory.getCurrentSession().createQuery("select max(USERID) FROM usermaster");
//                            usermaster data1 = (usermaster) query1.uniqueResult();
//                            //System.out.println("data1......"+data1);
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
                    
                            //System.out.println("inside adduser");
                    Query query =sessionFactory.getCurrentSession().createQuery("from sms_config where SR_NO=:u");
                    query.setParameter("u", 1);
                    sms_config data = (sms_config) query.uniqueResult();
                    if(data!=null)
                    {
                            
                            String hql = "update sms_config set API_NAME= :com1,URL= :com2,PARAM= :com3,ACTIVE= :com4,COMPANY= :COMPANY WHERE SR_NO= :crno";
                			Query q = sessionFactory.getCurrentSession().createQuery(hql);
                			q.setParameter("com1", apiname);
                			q.setParameter("com2", apiurl);
                			q.setParameter("com3", Param);
                			q.setParameter("com4", active4);
                			q.setParameter("COMPANY", cname1);
                			q.setParameter("crno", 1);

                			int i = q.executeUpdate();
                			if (i > 0) {
                				status= "update";
                			}
                			else {
                				status= "fail";
                			}
                    }
                    else {
                    	sms_config user1= new sms_config();
                    	user1.setSR_NO(srno);
                    	user1.setAPI_NAME(apiname);
                    	user1.setURL(apiurl);
                    	user1.setPARAM(Param);
                    	user1.setACTIVE(active4);
                    	user1.setCOMPANY(cname1);
                    	
                    		sessionFactory.getCurrentSession().persist(user1);
                            status= "success";
                    }
            } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
            }

            return status;
//            return null;
    }









@Override
    public String sendmailsms(String tomailsms) {
		
		String output="";
		
		
            //System.out.println("url=" + tomailsms);
            
            try {
                URL hp = new URL(tomailsms);
                URLConnection hpCon = hp.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(hpCon.getInputStream()));
                //System.out.println("readLine***" + in.readLine());
                String inputLine;
                if ((inputLine = in.readLine()) != null) {
                    output = inputLine;
                    //System.out.println("output" + output);

                    if (output.contains("900")) {
                        //System.out.println("message_send");
                        output="message_send";
                        
                    } else if (output.contains("922")) {
                        //System.out.println("invalid_number");
                        output="invalid_number";

                    } else if (output.contains("900")) {
                        //System.out.println("invalid_senderid");
                        output="invalid_senderid";

                    } else if (output.contains("900")) {
                        //System.out.println("invalid_userid");
                        output="invalid_userid";

                    } else if (output.contains("900")) {
                        //System.out.println("invalid_password");
                        output="invalid_password";

                    }

                }
                else {
                	output="message_send";
                }

                in.close();
            } catch (Exception e) {
                //System.out.println("sms exception1" + e);
                output="fail_catch_exception";
            }
		
		return output;
		
	}

	
@Override
public String SubmitMailDetails(String host, int port, String email, String password, String authentication,String cname,String starttls) {

	//System.out.println("Inside MailConfigDaoImpl SubmitMailDetails method");
	String status = null;

	try {
		//System.out.println("Before Projection List ");
		Session s = getSession();
		//System.out.println("s =" + s);
		//System.out.println("host: " + host + "port: " + port + "email: " + email + "password: " + password
		//		+ "authentication: " + authentication+"Cname:"+cname);
		int srno = 0;
		try {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(mail_config.class)
					.setProjection(Projections.max("SNO"));
			Integer srno1 = (Integer) crit.uniqueResult();

			//System.out.println(" SRNO IS: " + srno1);

			if (srno1 != null) {
				srno = srno1.intValue();
				srno = srno + 1;
				//System.out.println("IN IF SRNO IS: " + srno);
			} else {
				srno = 1;
				//System.out.println("IN ELSE SRNO IS: " + srno);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println(e);
		}

		//System.out.println("inside MailConfig");
		Query query = sessionFactory.getCurrentSession().createQuery("from mail_config where COMPANY=:COMPANY");
		query.setParameter("COMPANY", cname);
		mail_config data = (mail_config) query.uniqueResult();
		if (data != null) {
			status = "duplicate";
		} else {
			mail_config mailconfig1 = new mail_config();

			mailconfig1.setSNO(srno);

			mailconfig1.setHOST(host);
			mailconfig1.setPORT(port);
			mailconfig1.setE_MAIL(email);
			mailconfig1.setPASSWRD(password);
			mailconfig1.setAUTHO(authentication);
			mailconfig1.setCOMPANY(cname);
			mailconfig1.setSENDERID(email);
			mailconfig1.setSTART_TLS(starttls);
			sessionFactory.getCurrentSession().persist(mailconfig1);
			status = "success";
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}

	return status;
}
	@Override
	public String updateMailConfigSave(String hostnameupdate, int portnumberupdate, String emailupdate,
			String authenticationupdate, String passwordupdate, int cr_no,String cnameupdate,String starttlsup) {

		//System.out.println("Inside MailConfigDaoImpl updateMailConfigSave method");
		String status = null;

		try {

			//System.out.println("inside updateMailConfigSave");
			Query query = sessionFactory.getCurrentSession().createQuery(
					"update mail_config set HOST =:HOST, PORT =:PORT, E_MAIL =:E_MAIL, PASSWRD =:PASSWRD, AUTHO =:AUTHO,COMPANY=:COMPANY,START_TLS=:STARTTLS,SENDERID=:SENDERID where SNO =:SNO");

			query.setParameter("HOST", hostnameupdate);
			query.setParameter("PORT", portnumberupdate);
			query.setParameter("E_MAIL", emailupdate);
			query.setParameter("PASSWRD", passwordupdate);
			query.setParameter("AUTHO", authenticationupdate);
			query.setParameter("COMPANY", cnameupdate);
			query.setParameter("SNO", cr_no);
			query.setParameter("STARTTLS", starttlsup);
			query.setParameter("SENDERID", emailupdate);
			//System.out.println("STAFSGFGDF;;;;;"+starttlsup);
			int i = query.executeUpdate();

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
//		return null;
	}
	@Override
	public String DeleteMail(int crno) {

		//System.out.println("Inside MailConfigDaoImpl DeleteMail method");
		String status = null;

		try {

			//System.out.println("inside DeleteMail");
			int i = sessionFactory.getCurrentSession().createQuery("delete from mail_config where SNO ="+crno).executeUpdate();
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
	public JSONArray EmailAuthListing(String userlist) {

		//System.out.println("Inside MailConfigDaoImpl EmailAuthListing method");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;
//	String db_username = null;
//	String db_usertype = null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);

			Query query = sessionFactory.getCurrentSession().createQuery("from mailconfigset");
//		query.setParameter("ut", "Admin");
			List<mailconfigset> dataList = query.list();
			array1 = new JSONArray();
			for (mailconfigset sourceDrive : dataList) {
				srno = srno + 1;
				//System.out.println("array = " + sourceDrive.getUSER_NAME());
				array = new JSONArray();

				array.put(srno);
				array.put("<button class='btn btn-info' id='Editbtn' onclick='Editemailauth(\"" + sourceDrive.getSR_NO()
						+ "\",\"" + sourceDrive.getUSER_TYPE() + "\",\"" + sourceDrive.getUSER_NAME() + "\",\""
						+ sourceDrive.getMAIL_AUTH()
						+ "\" )'><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
				array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='Deletemailauth(\""
						+ sourceDrive.getSR_NO() + "\" )'><i class='fa fa-trash'></i></button>");

				array.put(sourceDrive.getUSER_TYPE());
				array.put(sourceDrive.getUSER_NAME());
				array.put(sourceDrive.getMAIL_AUTH());

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
	public JSONArray getUserDetails(String username) {

		//System.out.println("Inside MailConfigDaoImpl getUserDetails method");
		String db_sname = null;
		JSONArray array = null;

		JSONArray array1 = null;
//		String db_username = null;
//		String db_usertype = null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);

			if (username.equals("User")) {
				Query query = sessionFactory.getCurrentSession().createQuery("from usermaster");
//			query.setParameter("c", cname);
				List<usermaster> dataList = query.list();
				array1 = new JSONArray();
				for (usermaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getUSERNAME());
					array = new JSONArray();

					array.put(sourceDrive.getUSERNAME());
//				db_username = sourceDrive.getUSERNAME();
//				db_usertype=  sourceDrive.getUSERTYPE();
					array1.put(array);
					//System.out.println("db_sname: " + array1);
				}
			} else if (username.equals("Engineer")) {
				Query query = sessionFactory.getCurrentSession().createQuery("from enggmaster");
//				query.setParameter("c", cname);
				List<enggmaster> dataList = query.list();
				array1 = new JSONArray();
				for (enggmaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getENG_UNAME());
					array = new JSONArray();

					array.put(sourceDrive.getENG_UNAME());
//					db_username = sourceDrive.getUSERNAME();
//					db_usertype=  sourceDrive.getUSERTYPE();
					array1.put(array);
					//System.out.println("db_sname: " + array1);
				}
			} else if (username.equals("Ticket Co-ordinator")) {
				Query query = sessionFactory.getCurrentSession().createQuery("from tpmaster");
//				query.setParameter("c", cname);
				List<tpmaster> dataList = query.list();
				array1 = new JSONArray();
				for (tpmaster sourceDrive : dataList) {
					//System.out.println("array = " + sourceDrive.getTP_UNAME());
					array = new JSONArray();

					array.put(sourceDrive.getTP_UNAME());
//					db_username = sourceDrive.getUSERNAME();
//					db_usertype=  sourceDrive.getUSERTYPE();
					array1.put(array);
					//System.out.println("db_sname: " + array1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

//		return db_password + "~" + db_username + "~" + db_usertype;
		return array1;
	}

	@Override
	public String SubmitEmailAuthDetails(String usertype, String user, String authentication) {

		//System.out.println("Inside MailConfigDaoImpl SubmitEmailAuthDetails method");
		String status = null;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);
			//System.out.println("usertype: " + usertype + "user: " + user + "authentication: " + authentication);
			int srno = 0;
			try {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(mailconfigset.class)
						.setProjection(Projections.max("SR_NO"));
				Integer srno1 = (Integer) crit.uniqueResult();

				//System.out.println(" SRNO IS: " + srno1);

				if (srno1 != null) {
					srno = srno1.intValue();
					srno = srno + 1;
					//System.out.println("IN IF SRNO IS: " + srno);
				} else {
					srno = 1;
					//System.out.println("IN ELSE SRNO IS: " + srno);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}

			//System.out.println("inside SubmitEmailAuthDetails");
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from mailconfigset where USER_NAME=:USER_NAME AND USER_TYPE=:USER_TYPE");
			query.setParameter("USER_NAME", user);
			query.setParameter("USER_TYPE", usertype);
			mailconfigset data = (mailconfigset) query.uniqueResult();
			if (data != null) {
				status = "duplicate";
			} else {
				mailconfigset mailconfigset1 = new mailconfigset();

				mailconfigset1.setSR_NO(srno);
				;
				mailconfigset1.setUSER_TYPE(usertype);
				;
				mailconfigset1.setUSER_NAME(user);
				;
				mailconfigset1.setMAIL_AUTH(authentication);

				sessionFactory.getCurrentSession().persist(mailconfigset1);
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return status;
	}

	@Override
	public String updateEmailAuthSave(String usertypeupdate, String usernameupdate, String authenticationupdate,
			int cr_no) {

		//System.out.println("Inside MailConfigDaoImpl updateEmailAuthSave method");
		String status = null;

		try {

			//System.out.println("inside updateEmailAuthSave");
			Query query = sessionFactory.getCurrentSession()
					.createQuery("update mailconfigset set MAIL_AUTH = :MAIL_AUTH where SR_NO = :SR_NO");

			query.setParameter("MAIL_AUTH", authenticationupdate);
			query.setParameter("SR_NO", cr_no);

			int i = query.executeUpdate();

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
	public String deletemailauth(int crno) {

		//System.out.println("Inside MailConfigDaoImpl deletemailauth method");
		String status = null;

		try {

			//System.out.println("inside deletemailauth");
			Query query = sessionFactory.getCurrentSession()
					.createQuery("delete from mailconfigset where SR_NO = :SR_NO");

			query.setParameter("SR_NO", crno);

			int i = query.executeUpdate();

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
	public JSONArray smsConfigListing(String userlist) {
		//System.out.println("Inside smsConfigListing method DAO IMPL");
		JSONArray array = null;

		JSONArray array1 = null;
		int srno = 0;

		try {
			//System.out.println("Before Projection List ");
			Session s = getSession();
			//System.out.println("s =" + s);

			List<sms_config> dataList = sessionFactory.getCurrentSession().createQuery("from sms_config").list();
//		query.setParameter("ut", "Admin");
			array1 = new JSONArray();
			for (sms_config sourceDrive : dataList) {
				srno = srno + 1;
//				//System.out.println("array = " + sourceDrive.getSUBJECT());
				array = new JSONArray();

				array.put(srno);
//				array.put("<button class='btn btn-info' id='Editbtn' onclick='EditMailConfig(\"" + sourceDrive.getSNO()
//						+ "\",\"" + sourceDrive.getHOST() + "\",\"" + sourceDrive.getPORT() + "\",\""
//						+ sourceDrive.getE_MAIL() + "\",\"" + sourceDrive.getAUTHO()
//						+ "\" )'><i class='fa fa-pencil-alt' data-icon='pencil-alt'></i></button>");
//				array.put("<button class='btn btn-danger' id='Delete'  name='Doem' onclick='DeleteMailConfig(\""
//						+ sourceDrive.getSNO() + "\" )'><i class='fa fa-trash'></i></button>");
				array.put(sourceDrive.getCOMPANY());
				array.put(sourceDrive.getAPI_NAME());
				array.put(sourceDrive.getURL());
				array.put(sourceDrive.getPARAM());
				array.put(sourceDrive.getACTIVE());
				array.put(sourceDrive.getCOMPANY());
				array1.put(array);
				//System.out.println("ARRAY OUTPUT: " + array1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return array1;
	}
}
