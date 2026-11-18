package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.dao.MailConfigDao;
import com.velox.itsm.dao.MasterDao;


@Service("MailConfig")
@Transactional
public class MailConfigImpl implements MailConfig {

	@Autowired
	MailConfigDao mailConfigDao;
	
	@Override
	public JSONArray MailMasterListing(String userlist) {
		
System.out.println("Inside MailMasterListing ");
		
		System.out.println("MailMasterListing" + userlist);
		JSONArray MailMasterListing_dao_output = mailConfigDao.MailMasterListing(userlist);
		System.out.println("From Service_IMPL_output response " + MailMasterListing_dao_output);
		return MailMasterListing_dao_output;
	}

	@Override
	public String SubmitMailDetails(String host, int port, String email, String password, String authentication,String cname,String starttls) {
		// TODO Auto-generated method stub
		return mailConfigDao.SubmitMailDetails(host, port, email, password, authentication,cname,starttls);
	}
	
	
	
	
	@Override
	public String sendmailsms(String tomailsms){
		// TODO Auto-generated method stub
		return mailConfigDao.sendmailsms(tomailsms);
	}


	@Override
	public String smsConfg(String cname,String cnamevalue,String apiname,String apiurl,String uname,String uservalue1,String userpswd,String pwdvalue1,String userID,String uidvalue,String text1,String textvalue,String active4,String otherinput1,String otherinput2,String otherinput3,String otherinput4,String otherinput5,String otherinput6,String otherinput7,String otherinput8,String cname1){
		// TODO Auto-generated method stub
		return mailConfigDao.smsConfg(cname,cnamevalue,apiname,apiurl,uname,uservalue1,userpswd,pwdvalue1,userID,uidvalue,text1,textvalue,active4,otherinput1,otherinput2,otherinput3,otherinput4,otherinput5,otherinput6,otherinput7,otherinput8,cname1);		
	}

	@Override
	public String updateMailConfigSave(String hostnameupdate, int portnumberupdate, String emailupdate,
			String authenticationupdate, String passwordupdate, int cr_no,String cnameupdate,String starttlsup) {
		// TODO Auto-generated method stub
		return mailConfigDao.updateMailConfigSave(hostnameupdate, portnumberupdate, emailupdate, authenticationupdate, passwordupdate, cr_no,cnameupdate,starttlsup);
	}


	@Override
	public String DeleteMail(int crno) {
		// TODO Auto-generated method stub
		return mailConfigDao.DeleteMail(crno);
	}

	@Override
	public JSONArray EmailAuthListing(String userlist) {
		
		System.out.println("EmailAuthListing" + userlist);
		JSONArray EmailAuthListing_dao_output = mailConfigDao.EmailAuthListing(userlist);
		System.out.println("From Service_IMPL_output response " + EmailAuthListing_dao_output);
		return EmailAuthListing_dao_output;
	}

	@Override
	public JSONArray getUserDetails(String username) {
		
System.out.println("Inside getUserDetails ");
		
		System.out.println("USer name" + username);
		JSONArray username_dao_output = mailConfigDao.getUserDetails(username);
		System.out.println("From Service_IMPL_output response " + username_dao_output);
		return username_dao_output;
	}

	@Override
	public String SubmitEmailAuthDetails(String usertype, String user, String authentication) {
		// TODO Auto-generated method stub
		return mailConfigDao.SubmitEmailAuthDetails(usertype, user, authentication);
	}

	@Override
	public String updateEmailAuthSave(String usertypeupdate, String usernameupdate, String authenticationupdate,
			int cr_no) {
		// TODO Auto-generated method stub
		return mailConfigDao.updateEmailAuthSave(usertypeupdate, usernameupdate, authenticationupdate, cr_no);
	}

	@Override
	public String deletemailauth(int crno) {
		// TODO Auto-generated method stub
		return mailConfigDao.deletemailauth(crno);
	}

	@Override
	public JSONArray smsConfigListing(String userlist) {
System.out.println("Inside smsConfigListing ");
		
		System.out.println("smsConfigListing" + userlist);
		JSONArray smsConfigListing_dao_output = mailConfigDao.smsConfigListing(userlist);
		System.out.println("From Service_IMPL_output response " + smsConfigListing_dao_output);
		return smsConfigListing_dao_output;
	}



	
}
