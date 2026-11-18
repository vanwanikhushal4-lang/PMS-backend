package com.velox.itsm.dao;

import java.util.Map;

import org.json.JSONArray;

public interface LoginDao {

	public String getDBVerification(String username, String Password, String usertype, String activitydash1,String userfullname);
	
//    public String getADVerified(String username);
	
	public String getType(String username, String Password,String usertype,String AD);

	public String checkUserandType(String name, String usertype);

	public String sendOtpToPhone(String name, String usertype, String number);

	public String checkOTP(String name, String usertype, String number, String otp);

	public String Setpassword(String name, String usertype, String pass);

	public String getADFullName(String username);

	public JSONArray getAuthentication(String username, String password, String companycode);
	
	public JSONArray checkMFAType(String username,String userType);
	public String verifyOTP(String username, String userType, String otp);

	public Object setactivestatus(String username, String status);

	
	//05/07
	public JSONArray sendMail(String name);

	//29/08
	public String checkUserandTypeVelox(String name);

	//30/08
	public String sendOtpToMailID(String name, String usertype, String mailId);

	//30/08
	public String checkOTPMail(String name, String usertype, String number, String otp);

	//30/08
	public String SetpasswordNew(String name, String usertype, String pass);

	//31/08
	public String getRegisterMail(String name);

	public void saveAuditEvent(Map<String, Object> payload);

	// public String getParameter(String username);

	// public String addUser(String firstname,String lastname,String username,String
	// emailid,String password,String phoneno,String conpassword,String
	// branch,String project,String customer,String currUser);

}
