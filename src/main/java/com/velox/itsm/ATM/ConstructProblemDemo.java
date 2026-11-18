package com.velox.itsm.ATM;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.mail.Message;
import javax.mail.Transport;

//import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.velox.itsm.dao.EmailSMSDao;

public class ConstructProblemDemo implements Runnable {

	
	@Autowired
	EmailSMSDao Inv;
	
	public String FinalSMSurl="";
	Message FinalEmailMsg=null;
	int count=0;
	
	
	
	public ConstructProblemDemo(String SMSurl,Message EmailMsg)
	{
		FinalEmailMsg=EmailMsg;
		FinalSMSurl=SMSurl;
	}
	@Override
	public void run() {
		try {
			
			URL smsurl = new URL(FinalSMSurl);
			System.out.println("URL===="+FinalSMSurl);
			HttpURLConnection connection = (HttpURLConnection) smsurl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			System.out.println("SMS Send successfully........." + code);
			System.out.println("response Code***---------------------------" + code);
			System.out.println("Thread run  finished.....");
		} catch (Exception e33) {
			e33.printStackTrace();
		} finally {

		}
		//email
		
		try {
			Transport.send(FinalEmailMsg);
			count++;
			System.out.println("email Send successfully........." + count);
			System.out.println("[INFO] Mail Sent " + count);

		} catch (Exception owner1) {
			owner1.printStackTrace();
			System.out.println("[ERROR] mail owner esc  : " + owner1);
		}
	}
}
