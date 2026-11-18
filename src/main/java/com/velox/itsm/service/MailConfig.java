package com.velox.itsm.service;

import org.json.JSONArray;

public interface MailConfig {

	public JSONArray MailMasterListing(String userlist);
	public String SubmitMailDetails(String host, int port, String email, String password, String authentication, String cname, String starttls);
	public String updateMailConfigSave(String hostnameupdate,int portnumberupdate,String emailupdate,String authenticationupdate,String passwordupdate,int cr_no, String cnameupdate,String starttlsup);
	
	public String DeleteMail(int crno);
	public JSONArray EmailAuthListing(String userlist);
	public JSONArray getUserDetails(String username);
	public String SubmitEmailAuthDetails(String usertype,String user, String authentication);
	public String updateEmailAuthSave(String usertypeupdate,String usernameupdate,String authenticationupdate,int cr_no);
	public String deletemailauth(int crno);
	
	public String sendmailsms(String tomailsms);

	public String smsConfg(String cname,String cnamevalue,String apiname,String apiurl,String uname,String uservalue1,String userpswd,String pwdvalue1,String userID,String uidvalue,String text1,String textvalue,String active4,String otherinput1,String otherinput2,String otherinput3,String otherinput4,String otherinput5,String otherinput6,String otherinput7,String otherinput8, String cname1);

	public JSONArray smsConfigListing(String userlist);
	
}
