package com.velox.itsm.ATM;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.mail.Message;
import javax.mail.Transport;

//import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.velox.itsm.dao.EmailSMSDao;

public class ConstructDemo implements Runnable {

	
	@Autowired
	EmailSMSDao Inv;
	
	public String url12="";
	Message message=null;
	int count=0;
	
	
	
	public ConstructDemo(String url,Message msg)
	{
		message=msg;
		url12=url;
		System.out.println("Construct demo is called..............");
		
	}
	@Override
	public void run() {
		///System.out.println("Const run is calling.....");
		try {
			
			URL urll = new URL(url12);
			System.out.println("URL CONSTRUCT DEMO===="+url12);
			HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			System.out.println("SMS Send successfully........." + code);
			System.out.println("response Code***---------------------------" + code);
			System.out.println("Thread run  finished.....");
		} catch (Exception e33) {
			System.out.println("EXCEPTION IN CONSTRUCT DEMO");
			e33.printStackTrace();
		} finally {

		}
		
		
		//email
		
		try {
			System.out.println("IN MAIL BLOCK MSG: "+message);
			Transport.send(message);
			count++;
			System.out.println("email Send successfully........." + count);
			System.out.println("[INFO] Mail Sent " + count);

		} catch (Exception owner1) {
			owner1.printStackTrace();
			System.out.println("[ERROR] mail owner esc  : " + owner1);
		}

		
		
	}
	
	

}
