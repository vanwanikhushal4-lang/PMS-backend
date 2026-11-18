package com.velox.itsm.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.ATM.ActiveDirectory;
import com.velox.itsm.dao.LoginDao;

@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao login_dao;

//	@Override
//	public String getParameter(String username) {
//
//		String ad_output = login_dao.getParameter(username);
//
//		return ad_output;
//	}

	@Override
	public JSONArray getAuthentication(String username, String password,String companycode) {
		System.out.println("Inside LoginServiceImpl ");

		JSONArray getAuthentication_dao_output = login_dao.getAuthentication(username, password,companycode);
		System.out.println("From Service_IMPL_output response " + getAuthentication_dao_output);
		return getAuthentication_dao_output;
	}

	@Override
	public String getType(String username, String password, String usertype,String AD) {
		// TODO Auto-generated method stub
		return login_dao.getType(username,password,usertype,AD);
	}
	
//	@Override
//	public String addUser(String firstname, String lastname, String username, String emailid, String password,
//			String phoneno, String conpassword, String branch, String project,String customer,String currUser) {
//		
//		return login_dao.addUser(firstname, lastname, username, emailid, password, phoneno, conpassword, branch, project,customer,currUser);
//	}

	@Override
	public String checkUserandType(String name, String usertype) {
		// TODO Auto-generated method stub
		return login_dao.checkUserandType(name, usertype);
	}

	@Override
	public String sendOtpToPhone(String name, String usertype, String number) {
		// TODO Auto-generated method stub
		return login_dao.sendOtpToPhone(name, usertype, number);
	}

	@Override
	public String checkOTP(String name, String usertype, String number, String otp) {
		// TODO Auto-generated method stub
		return login_dao.checkOTP(name, usertype, number, otp);
	}

	@Override
	public String Setpassword(String name, String usertype, String pass) {
		// TODO Auto-generated method stub
		return login_dao.Setpassword(name, usertype, pass);
	}

	@Override
	public void setactivestatus(String username ,String status) {
	login_dao.setactivestatus(username,status);
		
	}

	//05/07
	@Override
	public JSONArray sendMail(String name) {
		// TODO Auto-generated method stub
		return login_dao.sendMail(name);
	}

	//29/08
	@Override
	public String checkUserandTypeVelox(String name) {
		// TODO Auto-generated method stub
		return login_dao.checkUserandTypeVelox(name);
	}

	
	//30/08
	@Override
	public String sendOtpToMailID(String name, String usertype, String mailId) {
		// TODO Auto-generated method stub
		return login_dao.sendOtpToMailID(name, usertype, mailId);
	}

	
	//30/08
	@Override
	public String checkOTPMail(String name, String usertype, String number, String otp) {
		// TODO Auto-generated method stub
		return login_dao.checkOTPMail(name, usertype, number, otp);
	}

	//30/08
	@Override
	public String SetpasswordNew(String name, String usertype, String pass) {
		// TODO Auto-generated method stub
		return login_dao.SetpasswordNew(name, usertype, pass);
	}

	//31/08
	@Override
	public String getRegisterMail(String name) {
		// TODO Auto-generated method stub
		return login_dao.getRegisterMail(name);
	}

	
	@Override
	public void saveAuditEvent(Map<String, Object> payload) {
		// TODO Auto-generated method stub
		login_dao.saveAuditEvent(payload);
	}
}
