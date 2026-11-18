package com.velox.itsm.ATM;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


import javax.mail.*;

public class EmailDemo {

	protected static final String Senderid1 =System.getenv("SCM_SMTP_USER");
	protected static final String pass1 = System.getenv("SCM_SMTP_PASSWORD");

	public static void main(String[] args) {
	
		System.out.println("email start----------------status==");
	     String hostname = "mail.velox.co.in";
		int port = 25;
		   String Senderid = System.getenv("SCM_SMTP_USER");
		String pass =System.getenv("SCM_SMTP_PASSWORD");
		String mailid = "priyanka.panigrahi@velox.co.in";
		
		
		Properties props = new Properties();

		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.host", hostname);
		props.put("mail.smtp.port", "" + port);
		
		System.out.println("all propert set----------------status=");
		
		final Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			
			
			protected PasswordAuthentication getPasswordAuthentication() {
				//System.out.println("session value============"+session);
				//System.out.println("In ready class call to auth check----------------Senderid1="+Senderid1+" pass1="+pass1);
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});

		String nunknownmail="";
		String usermail1="";
		String mainMSG = "";
		int count=0;
		
		usermail1 = "shital.jachak@velox.co.in";
		nunknownmail="akash.mali@velox.co.in";
		
		
		System.out.println("in raise status cond=----------------");
		
		mainMSG = "<span style='color:#1f497d'>Dear Sir/Madam,<br> <br>Raise Ticket Alert</span><br><br><html><head></head><body><div style='padding:0px'><h4 style='color:#1f497d'>Ticket Details</h4><table border='1' style='border-collapse:collapse;text-align:center'>  <tr><thead style='background:linear-gradient(to bottom, rgb(250,250,250) 0%,rgb(222, 221, 221) 100%);'><th style='padding:5px'>Action</th><th style='padding:5px'>Ticket ID</th><th style='padding:5px'>Raised By</th><th style='padding:5px'>Category</th><th style='padding:5px'>Branch</th><th style='padding:5px'>Status</th><th style='padding:5px'>Subject</th><th style='padding:5px'>Priority</th><th style='padding:5px'>Date</th></thead></tr><tr> <td>Ticket Raised  <br></td> <td>"
				+ 101  + "</td> <td>" + "Velox" + "</td> <td>" + "hardware" + "</td><td>" + "vashi" 
				+ "</td><td>" + "New"  + "</td><td>" + "software"  + "</td><td>" + "High" + "</td><td>" + "mysqldate"
				+ "</td></tr></table></div></body></html><br><br> <span style='color:#1f497d'>Thanks And Regards</span>,<br><span style='color:#1f497d'>ITSM-Helpdesk Team</span>";
									
		System.out.println("message======"+mainMSG);
		Message message = new MimeMessage(session);
		
					try {
						
					
						//
										message.setFrom(new InternetAddress(mailid));
										message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usermail1));
										InternetAddress[] parse = InternetAddress.parse(nunknownmail, true);
						                //InternetAddress.parse(""+usermail1+"")
										message.addRecipients(Message.RecipientType.CC, parse);
										
						BodyPart messageBodyPart = new MimeBodyPart();

						messageBodyPart.setContent(mainMSG, "text/html");

						Multipart multipart = new MimeMultipart();

						multipart.addBodyPart(messageBodyPart);
						
						message.setSubject("Test Email Send");
						
						message.setContent(multipart);
						
					} catch (Exception e) {
						// TODO: handle exception
					}

		try {
			Transport.send(message);
			count++;
			System.out.println("[INFO] Mail Sent " + count);
			System.out.println("Mail success--------------");

		} catch (Exception owner1) {

			System.out.println("[ERROR] mail owner esc  : " + owner1);
			System.out.println("Mail failed--------------");
		}
		
		
		

	}

}
