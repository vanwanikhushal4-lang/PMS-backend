package com.velox.itsm.dao;

import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.JSONArray;

public class mail {

	// RF submit SI

	
	// RF end

	// mail start
	/// send mail SI to VP
	public String Send_mailVP(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String JD_Emial, String ProHead_Emial, String MDMAM_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + MDMAM_Emial + "," + resultAuthorizerEmails + "," + JD_Emial
				+ "," + ProHead_Emial;
//	        final String allRecipients =  additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Raised. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Raised Information:</b><br>";
		mainMSG += "Raised Proposal Reference: " + vlx + "<br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Commercial Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	/// start commerical proposal raised by nishi

	// start sales manager approve VP
	public String Send_mail_SM_APPROVE(String uname, String crno, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		System.out.println("sent approved from sale manager  velox proposal");
		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Commercial Proposal with Reference Number " + crno
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Approval Information:</b><br>";
		mainMSG += "Proposal Reference Number: " + crno + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Commercial Proposal Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}
		return Status;
	}

	// END sales manager approve VP

	// START sales manager REJECT VP
	public String Send_mailRejectVP(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox proposal");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;
//		        final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";

		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Commercial Proposal with Reference Number " + crno
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Rejection Information:</b><br>";
		mainMSG += "Rejected Proposal Reference Number: " + crno + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Commercial Proposal Rejected  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// END sales manager REJECT VP

	// start reject mai to md
	public String Send_mailRejectVPtoMD(String fullname, String vlx, String resultEmails, String mD_Emial,
			String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + JD_Emial + "," + ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";

		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Rejection Information:</b><br>";
		mainMSG += "Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Rejected By: " + "DR.Mangesh Amale" + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(mD_Emial));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Commercial Proposal Rejected  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// emd reject to md

	// // START VP MD
	public String Send_mailApprovedMD(String fullname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox proposal");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Approval Information:</b><br>";
		mainMSG += "Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(mD_Emial));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Commercial Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	/// Send_mailResendsales_init

	public String Send_mailResendsales_init(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;
//	        final String additionalRecipients = "shahidchoudhary321@gmail.com,maqsoodkhan19990605@gmail.com,adnanparkote79@gmail.com,nitindhanawade0003@gmail.com" ;

//	        id...service@velox.co.in
		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultUserEmails + "," + resultAuthorizerEmails;
		;
		final String allRecipients = mailid + "," + additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Commercial Proposal with Reference Number " + crno
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Approved Information:</b><br>";
		mainMSG += "Revised Proposal Reference: " + crno + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Revised Commercial Proposal Confirmation (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

// send mail nishi in purchase order

	public String Send_mailPO(String fullname, String vlxid, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String JD_Emial, String ProHead_Emial,String email_HeadProjects,String potype,String ponumber,String customername) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial+ "," + email_HeadProjects;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "This email is regarding the Purchase Order with reference number <span style='background-color: #ffff00; font-weight: bold;'>" + vlxid + "</span> that has been raised. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Purchase Order Raised Information:</b><br>";
		mainMSG += "Purchase Order Reference Number: " + vlxid + "<br><br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "Purchase Order Type: " + potype + "<br><br>";
		mainMSG += "Purchase Order Number: " + ponumber + "<br><br>";
		mainMSG += "Customer Name: " + customername + "<br><br>";
		
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";		
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Purchase Order Confirmation  (" + vlxid + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	/// end Purchase Order raised by nishi

	// start sales manager approve PO
	public String Send_mail_SM_APPROVEPO(String fullname, String crno, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String Impl, String JD_Emial, String ProHead_Emial, String headProject_Email,String supportManager,String form2customername,String poform2No) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + Impl + "," + JD_Emial + ","
				+ ProHead_Emial + "," + headProject_Email + ","+supportManager;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "This email is regarding the Purchase Order with reference number <span style='background-color: #ffff00; font-weight: bold;'>" + crno + "</span> that has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Purchase Order Approval Information:</b><br>";
		mainMSG += "Purchase Order Reference: " + crno + "<br><br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "Purchase Order Number: " + poform2No + "<br><br>";
		mainMSG += "Customer Name: " + form2customername + "<br><br>";
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Purchase Order Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}
		return Status;
	}

	// END sales manager approve PO

	public String Send_mail_RF_ApprovedbyAcmgr(String uname, String crno, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";

		// Merge the original recipient and new recipients

		final String additionalRecipients = resultAuthorizerEmails + "," + mailid + "," + JD_Emial + ","
				+ ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Registration form with Reference Number " + crno
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Approved Registration Form Information:</b><br>";
		mainMSG += "Registration Reference: " + crno + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation, and we look forward to welcoming you.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solution India Pvt. Ltd</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Registration Form Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mailRejectRFbyAcmgr(String uname, String crno, String resultEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";

		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		// Merge the original recipient and new recipients

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Registration form with Reference Number " + crno
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Rejection Information:</b><br>";
		mainMSG += "Registration Reference: " + crno + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br>";
		mainMSG += "Reason for Rejection: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solution India Pvt. Ltd</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Registration Form Rejected  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mail_PO_ApprovedbyAcmgr(String fullname, String crno, String resultEmails, String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;
// 		        final String additionalRecipients = "shahidchoudhary321@gmail.com,maqsoodkhan19990605@gmail.com,adnanparkote79@gmail.com,nitindhanawade0003@gmail.com" ;

// 		        id...service@velox.co.in
		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails;
		final String allRecipients = mailid + "," + additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Purchase Order with Reference Number " + crno
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Purchase Order Approval Information:</b><br>";
		mainMSG += "Purchase Order Reference: " + crno + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation, and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Approved Purchase Order (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// 23
	public String Send_mailimplementer(String uname, String crno, String resultEmails, String resultAuthorizerEmails,
			String SMEmailsEmailAdd, String mD_Emial, String collectionEmails1, String JD_Emial,String email_HeadProjects, String Customername,String PurchaseNumber) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial + "," + collectionEmails1 + "," + JD_Emial + "," + email_HeadProjects;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + SMEmailsEmailAdd;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "This email is regarding the Form C with reference number <span style='background-color: #ffff00; font-weight: bold;'>" + crno + "</span> that has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Form C Approval Information:</b><br>";
		mainMSG += "Form C Reference Number: " + crno + "<br><br>";
		mainMSG += "Submitted By: " + firstName + "<br><br>";
		mainMSG += "Customer Name: " + Customername + "<br><br>";
		mainMSG += "Purchase Order Number: " + PurchaseNumber + "<br><br>";
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Form C Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}
		return Status;
	}

	public String Send_mailrejectedbyMD(String fullname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String rejectreason, String mD_Emial) {
		String Status = null;

		System.out.println("mail inside  Send_mailApprovedMD :" + vlx);
		System.out.println("sent Reject from sale manager  velox proposal");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;
//		        final String additionalRecipients = "shahidchoudhary321@gmail.com,maqsoodkhan19990605@gmail.com,adnanparkote79@gmail.com" ;

//		        id...service@velox.co.in
		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + resultAuthorizerEmails;
		final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;
//		        mainMSG += "<b>This is an electronically auto generated mail. Please do not reply to the same.</b><br><br>";
//		        mainMSG = mainMSG + "Dear All,<br><br>Approved Commercial Proposal "+vlx+"  from  Managing Director .<b>";
		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Proposal Rejection Information:</b><br>";
		mainMSG += "Proposal Reference: " + vlx + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Rejected Commercial Proposal " + vlx);
			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// start
	// // START VP MD
	public String Send_mailReviseProposalapprove(String fullname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Commercial Proposal with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Approval Information:</b><br>";
		mainMSG += "Revised Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Revised Proposal Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	
	
	//Send Mail SI For raised
	public String Send_mailReviseProposalRaiseSI(String fullname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Commercial Proposal with Reference Number " + vlx
				+ " has been Raised. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Raised Information:</b><br>";
		mainMSG += "Revised Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Revised Proposal Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	
	
	public String Send_mailReviseManualProposalRaiseSI(String fullname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Manual Commercial Proposal with Reference Number " + vlx
				+ " has been Raised. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Raised Information:</b><br>";
		mainMSG += "Revised Manual Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Revised Manual Proposal Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// end

	// code start
	public String Send_mail_SM_APPROVERevise(String uname, String crno, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;
		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Commercial Proposal with Reference Number (" + crno
				+ ") has been Approved. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Approval Information:</b><br>";
		mainMSG += "Revised Proposal Reference Number: " + crno + "<br>";
		mainMSG += "Revised Proposal Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Proposal Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}
		return Status;
	}
	// code end

	// code start
	// START sales manager REJECT VP
	public String Send_mailRejectVPRevised(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";

		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Revised Commercial Proposal with Reference Number (" + crno
				+ ") has been Rejected. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Rejection Information:</b><br>";
		mainMSG += "Revised Proposal Reference Number: " + crno + "<br>";
		mainMSG += "Revised Proposal Rejected By: " + firstName + "<br><br>";
		mainMSG += "Revised Proposal Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Proposal Rejected  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	// code end

	// START sales manager REJECT PO
	public String Send_mailRejectPO(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,String ProHead_Emial,String PurchaseNumber,String Customername) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Purchase Order with reference number <span style='background-color: #ff9999; font-weight: bold;'>" + crno + "</span> has been rejected. ";
		mainMSG += "Please see below for more details:<br><br>";
		mainMSG += "<b>Purchase Order Rejection Information:</b><br>";
		mainMSG += "Purchase Order Reference Number: " + crno + "<br><br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "Customer Name: " + Customername + "<br><br>";
		mainMSG += "Purchase Order Number: " + PurchaseNumber + "<br><br>";
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";

		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Purchase Order Rejected  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// END sales manager REJECT PO

	public String Send_mailupdatePObySI(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String resultAuthorizerEmails2, String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;
// 			        final String additionalRecipients = "shahidchoudhary321@gmail.com,maqsoodkhan19990605@gmail.com,adnanparkote79@gmail.com,nitindhanawade0003@gmail.com" ;

// 			        id...service@velox.co.in

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails + "," + resultUserEmails;
		final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Purchase Order with Reference Number " + crno
				+ " has been Updated. ";
		mainMSG += "The Updated details are as follows:<br><br>";
		mainMSG += "<b>Updated Purchase Order Information:</b><br>";
		mainMSG += "New Purchase Order Reference Number: " + crno + "<br>";
		mainMSG += "Updated By: " + resultFullNames + "<br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Resend Purchase Order " + crno + "");
			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mailupdateRegiformbySI(String resultFullNames, String rfid, String resultUserEmails,
			String resultAuthorizerEmails, String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;
// 			        final String additionalRecipients = "shahidchoudhary321@gmail.com,maqsoodkhan19990605@gmail.com,adnanparkote79@gmail.com,nitindhanawade0003@gmail.com" ;

// 			        id...service@velox.co.in

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails + "," + resultUserEmails;
		final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Registration Form with Reference Number " + rfid
				+ " has been Successfully Updated. ";
		mainMSG += "The Updated Registration Form details are as follows:<br><br>";
		mainMSG += "<b>Updated Registration Form Information:</b><br>";
		mainMSG += "New Registration Form Reference Number: " + rfid + "<br>";
		mainMSG += "Updated By: " + resultFullNames + "<br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Resend Registration Form " + rfid + "");
			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// 22.12
	// mail start

	public String Send_mailUpdatedBySIVP(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + resultAuthorizerEmails;
		;
		final String allRecipients = mailid + "," + additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Updated. ";
		mainMSG += "The Updated Commercial Proposal details are as follows:<br><br>";
		mainMSG += "<b>Updated Commercial Proposal Raised Information:</b><br>";
		mainMSG += "Updated Commercial Proposal Reference: " + vlx + "<br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Updated Commercial Proposal Confirmation (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// mail start

	public String Send_mailUpdatedByMDVP(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + resultAuthorizerEmails;
		;
		final String allRecipients = mailid + "," + additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Commercial Proposal with Reference Number " + vlx
				+ " has been Updated. ";
		mainMSG += "The Updated Commercial Proposal details are as follows:<br><br>";
		mainMSG += "<b>Updated Commercial Proposal Raised Information:</b><br>";
		mainMSG += "Updated Commercial Proposal Reference: " + vlx + "<br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(allRecipients));
			final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);
			message.setSubject("Updated Commercial Proposal Confirmation (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	// mail end

	// start sales manager approve VP
	public String Send_mail_CM_APPROVE(String uname, String crno, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String resultSMEmails, String resultIMPLEmails, String JD_Emial,String email_HeadProjects,String email_ProjectManager, String Customername,String PurchaseNumber) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + resultSMEmails + ","
				+ resultIMPLEmails + "," + JD_Emial+ "," + email_HeadProjects+ "," + email_ProjectManager;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "This email is regarding the Purchase Order with reference number <span style='background-color: #ffff00; font-weight: bold;'>" + crno + "</span> that has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Purchase Order Approval Information:</b><br>";
		mainMSG += "Purchase Order Reference Number: " + crno + "<br><br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "Customer Name: " + Customername + "<br><br>";
		mainMSG += "Purchase Order Number: " + PurchaseNumber + "<br><br>";
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Purchase Order Confirmation  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}
		return Status;
	}

	// mail start for Manual Proposal SI

	public String Send_mailManualProposal(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String JD_Emial, String ProHead_Emial, String MDMAM_Emial) {

		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + MDMAM_Emial + "," + resultAuthorizerEmails + "," + JD_Emial
				+ "," + ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;
		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Manual Commercial Proposal with Reference Number " + vlx
				+ " has been Raised. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Manual Commercial Proposal Raised Information:</b><br>";
		mainMSG += "Manual Commercial Proposal Reference: " + vlx + "<br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Manual Commercial Proposal Confirmation (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// mail end for manual proposal

	// mail start for manual proposal to SM

	public String Send_mailmanualProposalToSM(String uname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Manual Commercial Proposal with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Manual Commercial Proposal Approved Information:</b><br>";
		mainMSG += "Manual Commercial Proposal Reference: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Manual Commercial Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	// mail end for manual proposal to SM

	// mail start for manual proposal to MD

	public String Send_mailmanualproposalMD(String uname, String vlx, String resultMDEmails,
			String resultAuthorizerEmails, String resultSMEmails, String JD_Emial, String ProHead_Emial) {
		String Status = null;
		System.out.println("resultSMEmails" + resultSMEmails);
		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = resultMDEmails;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails + "," + resultSMEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Manual Commercial Proposal with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Manual Commercial Proposal Approved Information:</b><br>";
		mainMSG += "Manual Commercial Proposal Reference: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultMDEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Manual Commercial Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// mail end for manual proposal to MD

	// mail start for license
	public String Send_mailLicense(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String resultcollecEmails, String resultkaleEmails, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + resultcollecEmails + ","
				+ resultkaleEmails + "," + JD_Emial + "," + ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Velox License with Reference Number " + vlx
				+ " has been Raised. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Velox License Raised Information:</b><br>";
		mainMSG += "Velox License Reference: " + vlx + "<br>";
		mainMSG += "Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Velox License Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	// mail end for license

	// mail start for license sm
	public String Send_mailLicenseSM(String uname, String vlx, String resultEmails, String resultAuthorizerEmails,
			String mD_Emial, String resultcollecEmails, String resultkaleEmails, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + resultcollecEmails + ","
				+ resultkaleEmails + "," + JD_Emial + "," + ProHead_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Velox License with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Velox License Approved Information:</b><br>";
		mainMSG += "Velox License Reference: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Velox License Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	// mail end for license sm

	// start mail send for collectionto customer with attached file
	public String Send_mailwithattachedfile(String uname, String fullname, String crno, String resultUserEmails,
			String mD_Emial, String filenameStandard, String SImailid, String SMmailid, String CMmailid,
			String Customermailid, String JD_Emial, String UploadedFile, String  ponumber, String podate, String Quantities,String distributorEmail,String partnerEmail,String linkForEmail ) {
		System.out.println("Customermailid" + Customermailid);
		System.out.println("UploadedFile" + UploadedFile);
		System.out.println("filenameStandard" + filenameStandard);
		System.out.println("resultUserEmails" + resultUserEmails);

		try {
			// Sender's email credentials
			final String senderEmail = System.getenv("SCM_SMTP_USER");
			final String senderPassword = System.getenv("SCM_SMTP_PASSWORD");
			final int smtpPort = 587;

			// Recipient emails
			final String mainRecipient = resultUserEmails;
			final String additionalRecipients = mD_Emial + "," + mainRecipient + "," + SImailid + "," + SMmailid + ","
					+ CMmailid + "," + JD_Emial;
            final String allmailsid=Customermailid+","+distributorEmail+","+partnerEmail;
			// Setup mail properties
			final Properties props = new Properties();
			props.put("mail.smtp.ssl.trust", "*");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", "smtp.office365.com");
			props.put("mail.smtp.port", "" + smtpPort);
			props.put("mail.smtp.sendpartial", "true");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

			// Create a mail session
			final Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmail, senderPassword);
				}
			});

			// Create the main message
			String mainMSG=null;
			
			if((partnerEmail=="" || partnerEmail==null) || (linkForEmail=="" || linkForEmail==null))
			{
				mainMSG = "Dear Customer,<br><br>";
				mainMSG +="Thanks for your order.<br><br>";
			
				mainMSG +="<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
//				mainMSG += "The details are as follows:<br><br>";
//				mainMSG += "<b>Velox License Raised Information:</b><br>";
//				mainMSG += "Velox License Reference: " + crno + "<br>";
//				mainMSG += "Raised By: " + fullname + "<br><br>";
//				mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
//				mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
				mainMSG += "<p>Thanks & Regards,<br>Velox Solutions Pvt. Ltd.</p>";
			}
			else
			{
				mainMSG = "Dear Customer,<br><br>";
				mainMSG +="Thanks for your order.<br><br>";
				mainMSG += "Click on Link.<br><br>" + linkForEmail + "<br><br>";
				mainMSG += "Please find the attached License Agreement generated with respect to Purchase Order No." + ponumber
						+ " Dated "+ podate +" for Qty of "+Quantities +" via reference no."+crno+".<br><br>";
				mainMSG +="<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
//				mainMSG += "The details are as follows:<br><br>";
//				mainMSG += "<b>Velox License Raised Information:</b><br>";
//				mainMSG += "Velox License Reference: " + crno + "<br>";
//				mainMSG += "Raised By: " + fullname + "<br><br>";
//				mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
//				mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
				mainMSG += "<p>Thanks & Regards,<br>Velox Solutions Pvt. Ltd.</p>";
			}
			
	

			// Create a MimeMessage
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(allmailsid));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(additionalRecipients, true));

			message.setSubject("Velox License Confirmation (" + crno + ")");

			// Attach main message
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mainMSG, "text/html");

			// Attach file
			BodyPart attachmentBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\Uploaded License\\" + UploadedFile);
			System.out.println("source" + source);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(UploadedFile);

			// Create multipart to combine message and attachment
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentBodyPart);

			// Set content
			message.setContent(multipart);

			// Send the email
			Transport.send(message);

			System.out.println("[INFO] Mail Sent");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Mail failed--------------");
			return "Fail";
		}

	}

	// end mail send for collectionto customer with attached file

	public String Send_mailRejectVPSM(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox proposal");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";

		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Manual Commercial Proposal with Reference Number " + crno
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Manual Commercial Proposal Rejection Information:</b><br>";
		mainMSG += "Proposal Reference Number: " + crno + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Manual Commercial Proposal Rejection  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mailmanualProposalToMD(String uname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial,
			String SMEmailaddress) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails + "," + JD_Emial + "," + ProHead_Emial + ","
				+ SMEmailaddress;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Velox Proposal License with Reference Number " + vlx
				+ " has been Approved. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Velox Proposal License Approved Information:</b><br>";
		mainMSG += "Velox Proposal License Reference: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Velox Proposal License Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mailRevisecomproposalmd(String fullname, String vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String JD_Emial, String ProHead_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultEmails + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Revised Commercial Proposal with Reference Number (" + vlx
				+ ") has been Approved. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Revised Proposal Approval Information:</b><br>";
		mainMSG += "Revised Proposal Reference Number: " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(mD_Emial));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Revised Commercial Proposal Confirmation  (" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// for task assign
	public String Send_mailTaskAssignMail(
//			String fullname, int vlx, String resultEmails, String resultAuthorizerEmails,
//			String mD_Emial, String resultDEVEmails, String JD_Emial, String ProHead_Emial, String developer,
//			String enddate
			String resultFullNames,String customerWiseTaskID,String resultUserEmails,String
			resultAuthorizerEmails,String End_Date, String assignBy
			) {
		String Status = null;

// 			        final String Senderid1 = System.getenv("SCM_SMTP_USER");
// 			        final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");

		final int port = 587;
//		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails;
//		+ "," + ProHead_Emial
//				+ "," +resultEmails ;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear,<br><br>";
		mainMSG += "I hope this message finds you well. We are pleased to inform you that a new task has been Assigned to you. The details are as follows:<br><br>";
		mainMSG += "<b>Task Details:</b><br>";
		mainMSG += "- Task Reference Number: TaskID:-" + customerWiseTaskID + "<br>";
		mainMSG += "- Deadline: " + End_Date + "<br><br>";
		mainMSG += "<b>Assigned By:</b><br>";
		mainMSG += "- Name: " + assignBy + ",<br><br>";
		
		mainMSG += "<b>Assigned To:</b><br>";
		mainMSG += "- Name: " + resultFullNames + ",<br><br>";
		mainMSG += "Please review the task details and ensure that you have all the necessary information. If you have any questions or need clarification, feel free to reach out. We trust in your abilities to successfully complete this task.<br><br>";
		mainMSG += "For additional resources or documentation, you can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br><br>";
		mainMSG += "Thank you for your dedication and prompt attention to this matter. We look forward to your successful completion of the task.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Task Assigned  Confirmation  TaskID:-(" + customerWiseTaskID + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// dailytaskassign
	public String Send_mailDailyTaskAssignMail(String fullname, int vlx, String resultEmails,
			String resultAuthorizerEmails, String mD_Emial, String resultDEVEmails, String JD_Emial,
			String ProHead_Emial, String developer, String enddate) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + "," + ProHead_Emial
				+ "," + resultDEVEmails;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear " + developer + ",<br><br>";
		mainMSG += "I hope this message finds you well. We are pleased to inform you that a new task has been Assigned to you. The details are as follows:<br><br>";
		mainMSG += "<b>Daily Task Details:</b><br>";
		mainMSG += "- Daily Task Reference Number: TaskID:-" + vlx + "<br>";
		mainMSG += "- Deadline: " + enddate + "<br><br>";
		mainMSG += "<b>Assigned By:</b><br>";
		mainMSG += "- Name: " + firstName + ",<br><br>";
		mainMSG += "Please review the task details and ensure that you have all the necessary information. If you have any questions or need clarification, feel free to reach out. We trust in your abilities to successfully complete this task.<br><br>";
		mainMSG += "For additional resources or documentation, you can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br><br>";
		mainMSG += "Thank you for your dedication and prompt attention to this matter. We look forward to your successful completion of the task.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Daily Task Assigned  Confirmation  TaskID:-(" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// update task dev
	public String Send_mailDailyTaskAssignUpdatedMail(String fullname, int vlx, String resultEmails,
			String resultTLEmails, String mD_Emial, String resultMGREmails, String JD_Emial, String ProHead_Emial,
			String developer, String enddate, String Manager_Name) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultTLEmails + "," + JD_Emial + "," + ProHead_Emial + ","
				+ resultMGREmails;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear " + Manager_Name + ",<br><br>";
		mainMSG += "I hope this message finds you well. We are pleased to inform you that the task Assigned to Me has been Successfully Completed. The Details are as Follows:<br><br>";
		mainMSG += "<b>Completed Task Details:</b><br>";
		mainMSG += "- Task Reference Number: TaskID:-" + vlx + "<br>";
		mainMSG += "- Deadline: " + enddate + "<br><br>";
		mainMSG += "<b>Task Completed By:</b><br>";
		mainMSG += "- Name: " + firstName + "<br><br>";
		mainMSG += "Thank you for your dedication and prompt attention to this matter. Your efforts are greatly appreciated. If you have any further questions or need assistance, please feel free to reach out.<br><br>";
		mainMSG += "For additional resources or documentation, you can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br><br>";
		mainMSG += "We look forward to your continued success in upcoming tasks.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Completed Task  Confirmation  TaskID:-(" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// for RD
	public String Send_mailForRD(String fullname, int vlx, String resultEmails, String resultIMPEmails, String mD_Emial,
			String resultSMEmails, String JD_Emial, String ProHead_Emial,String BugName) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultIMPEmails + "," + JD_Emial + "," + ProHead_Emial + ","
				+ resultSMEmails;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		
		mainMSG += "Dear Sir/Madam ,<br><br>";
		mainMSG += "I trust this email finds you in good health and high spirits. We are delighted to share the uplifting news that the Requirement Document has been successfully Raised. Allow us to provide you with the details:<br><br>";
		mainMSG += "<b>Requirement Document Details:</b><br>";
		mainMSG += "- Requirement Document Reference Number: <span style='background-color: yellow; font-weight: bold;'>RD-" + vlx + "</span><br>";
		mainMSG += "- RD Created By: " + firstName + "<br><br>";
		mainMSG += "For additional resources or documentation, please don't hesitate to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br><br>";
		mainMSG += "Thank you for contributing to our collective success. We look forward to your continued excellence in all future endeavors.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>NOTE:- This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Requirement Document Confirmation (RD-" + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");
			
			// Attach file
						BodyPart attachmentBodyPart1 = new MimeBodyPart();
						DataSource source1 = new FileDataSource("C:\\SCM\\" + BugName);
						System.out.println("source" + source1);
						attachmentBodyPart1.setDataHandler(new DataHandler(source1));
						attachmentBodyPart1.setFileName(BugName);
						

						Multipart multipart = new MimeMultipart();
						multipart.addBodyPart(messageBodyPart);
						multipart.addBodyPart(attachmentBodyPart1);
						
			
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_mailInserManualPO(String fullname, String vlxid, String resultEmails, String mD_Emial,
			String JD_Emial, String ProHead_Emial,String support_Emial, String MDMAM_Emial) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = fullname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + JD_Emial + "," + ProHead_Emial + "," + support_Emial;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Manual Purchase Order with Reference Number " + vlxid
				+ " has been Raised. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Manual Purchase Order Raised Information:</b><br>";
		mainMSG += "Manual Purchase Order Reference Number: " + vlxid + "<br>";
		mainMSG += "Manual Purchase Order Raised By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation, and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Manual Purchase Order Confirmation  (" + vlxid + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// START sales manager REJECT license
	public String Send_mail_SMRejectLicense(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox License");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial + ","
				+ ProHead_Emial;
// 			        final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});

		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Velox License with Reference Number " + crno
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Velox License Rejected Information:</b><br>";
		mainMSG += "Velox License Reference: " + crno + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Velox License Rejected (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	// END sales manager REJECT VP

	// START sales manager REJECT license
	public String Send_mail_SMRejectLicenseBYMD(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String SMMailadd, String rejectreason, String JD_Emial,
			String ProHead_Emial) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox License");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = resultAuthorizerEmails + "," + SMMailadd + "," + JD_Emial + ","
				+ ProHead_Emial;
// 			        final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});

		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Velox License with Reference Number " + crno
				+ " has been Rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Velox License Rejected Information:</b><br>";
		mainMSG += "Velox License Reference: " + crno + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Velox License Rejected (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public static String Send_mailprojectkofMeeting(String resultFullNames, String srno, String resultUserEmails,
			String SMEmailsid, String MD_Emial, String ProdM, String JD_Emial, String ProHead_Emial,
			String formattedDate, String typeofmeet, String link, String BugName, String invoicFileName, String typeofrm, String cname) {

		System.out.println("in KOM maill send");
		
		System.out.println("in SMEmailsid "+SMEmailsid);
		System.out.println("inProdMsend "+ProdM);
		System.out.println("in resultUserEmails send "+resultUserEmails);
		
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;

		final String additionalRecipients = SMEmailsid + "," + JD_Emial + "," + ProHead_Emial
//				+ "," + ProdM + "," + MD_Emial;
				+ "," + MD_Emial;
		
		System.out.println("all additionalRecipients "+additionalRecipients);

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});

		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the meeting has been scheduled. Here are the details:<br><br>";
		mainMSG += "<b>Meeting Information:</b><br>";
		mainMSG += "Reference ID : " + srno + "<br>";
		mainMSG += "Submitted By: " + resultFullNames + "<br>";
		mainMSG += "Customer Name: " + cname + "<br>";
		mainMSG += "Meeting Date: " + formattedDate + "<br>";
		
		if(typeofmeet.equalsIgnoreCase("Physical Mode")) {
			mainMSG += "Meeting Room : " + typeofrm + "<br>";
		}
		else {
			mainMSG += "Meeting Credentials : " + link + "<br>";
		}
		
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		try {

			// Create a MimeMessage
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(additionalRecipients));
			}

//			// Set BCC recipients
//			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(additionalRecipients, true));

			message.setSubject("Schedule Meeting");

			// Attach main message
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mainMSG, "text/html");

			// Attach file
			BodyPart attachmentBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\SCM\\" + BugName);
			System.out.println("source" + source);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(BugName);

			// Attach file 2
			BodyPart attachmentBodyPart1 = new MimeBodyPart();
			if(!(invoicFileName.isEmpty() || invoicFileName == null || invoicFileName.equals("")) ) {
				System.out.println("innn otherfille");
				DataSource source1 = new FileDataSource("C:\\SCM\\" + invoicFileName);
				System.out.println("source" + source1);
				attachmentBodyPart1.setDataHandler(new DataHandler(source1));
				attachmentBodyPart1.setFileName(invoicFileName);
			} else {
				System.out.println("innn else otherfille");
			}

			// Create multipart to combine message and attachment
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			if(!(invoicFileName.isEmpty() || invoicFileName == null || invoicFileName.equals("")) ) {
				System.out.println("innn otherfille attachemnt");
				multipart.addBodyPart(attachmentBodyPart1);
			} else {
				System.out.println("innn else otherfille attchement");
			}
			multipart.addBodyPart(attachmentBodyPart);

			// Set content
			message.setContent(multipart);

			// Send the email
			Transport.send(message);

			System.out.println("[INFO] Mail Sent");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Status;
	}

	public static String Send_mailUnderstandingdoc(String resultFullNames, String srno, String resultUserEmails,
			String TLmails, String MD_Emial, String Devmail, String JD_Emial, String ProHead_Emial, String rdUpFile,
			String Teamlead, String Dev,String manualProposalFile1) {

		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;

		final String additionalRecipients = TLmails + "," + ProHead_Emial + "," + JD_Emial + "," + ProHead_Emial + ","
				+ Devmail + "," + MD_Emial;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});

		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "We are pleased to inform you that the understanding document has been successfully submitted. Here are the details:<br><br>";
		mainMSG += "<b>Document Information:</b><br>";
		mainMSG += "Submitted By: " + resultFullNames + "<br>";
		mainMSG += "Team Leader Name: " + Teamlead + "<br>";
		mainMSG += "Developer Name : " + Dev + "<br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation, and we look forward to processing your registration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		try {

			// Create a MimeMessage
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(additionalRecipients, true));

			message.setSubject("Understanding Document Confirmation");

			// Attach main message
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mainMSG, "text/html");

			// Attach file
			BodyPart attachmentBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource("C:\\SCM\\" + manualProposalFile1);
			System.out.println("source" + source);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(manualProposalFile1);

			// Attach file
			BodyPart attachmentBodyPart1 = new MimeBodyPart();
			DataSource source1 = new FileDataSource("C:\\SCM\\" + rdUpFile);
			System.out.println("source" + source1);
			attachmentBodyPart1.setDataHandler(new DataHandler(source1));
			attachmentBodyPart1.setFileName(rdUpFile);

			// Attach file
//			BodyPart attachmentBodyPart2 = new MimeBodyPart();
//			DataSource source2 = new FileDataSource("C:\\SCM\\" + maskedupPOFile);
//			System.out.println("source" + source2);
//			attachmentBodyPart2.setDataHandler(new DataHandler(source2));
//			attachmentBodyPart2.setFileName(maskedupPOFile);

			// Create multipart to combine message and attachment
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentBodyPart1);
			multipart.addBodyPart(attachmentBodyPart);

			// Set content
			message.setContent(multipart);

			// Send the email
			Transport.send(message);

			System.out.println("[INFO] Mail Sent");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Status;
	}
	
	

	public String Send_mailUDApprovedByMD(String resultFullNames, int vlx, String resultUserEmails, String mD_Emial, String JD_Emial, String ProHead_Emial,String prodmgrmail) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients =  ProHead_Emial + "," + JD_Emial + ","+ prodmgrmail;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Understanding Document  with Reference Number(UD-" + vlx + ") has been Approved. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Understanding Document Approval Information:</b><br>";
		mainMSG += "Understanding Document Reference Number: UD- " + vlx + "<br>";
		mainMSG += "Approved By: " + firstName + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(mD_Emial));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Understanding Document Confirmation  (UD- " + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	public String Send_maiCMRejectPO(String resultFullNames, String crno, String resultUserEmails,
			String resultAuthorizerEmails, String rejectreason, String mD_Emial, String JD_Emial,String PurchaseNumber,String Customername) {
		String Status = null;

		System.out.println("sent Reject from sale manager  velox proposal");

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = mD_Emial;

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients = mailid + "," + resultAuthorizerEmails + "," + JD_Emial ;
//		        final String allRecipients = mailid + "," + additionalRecipients;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";

		int count = -1;

		
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am writing to inform you that the Purchase Order with reference number <span style='background-color: #ff9999; font-weight: bold;'>" + crno + "</span> has been rejected. ";
		mainMSG += "The details are as follows:<br><br>";
		mainMSG += "<b>Purchase Order Rejection Information:</b><br>";
		mainMSG += "Rejected Purchase Order Reference Number: " + crno + "<br><br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "Customer Name: " + Customername + "<br><br>";
		mainMSG += "Purchase Order Number: " + PurchaseNumber + "<br><br>";
		mainMSG += "<p>If you have any concerns or queries regarding this Purchase Order, please raise a dispute in the SCM portal. You can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a> for further assistance.</p><br>";		mainMSG += "Thank you for your understanding.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>Note:</b> This is an electronically auto-generated email. Please do not reply to this message.";
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Purchase Order Rejected  (" + crno + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}


	public String Send_mailforRejectUDbyMD(String resultFullNames, int vlx, String resultUserEmails,String resultSMEmails,String JD_Emial, String ProHead_Emial,String rejectreason) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		

		String fullNamesss = resultFullNames;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
		final String additionalRecipients =  ProHead_Emial + "," + JD_Emial+","+resultSMEmails ;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		
		mainMSG += "Dear Sir/Madam,<br><br>";
		mainMSG += "I am pleased to inform you that the Understanding Document  with Reference Number(UD-" + vlx + ") has been Rejected. ";
		mainMSG += "The Details are as follows:<br><br>";
		mainMSG += "<b>Understanding Document Rejected Information:</b><br>";
		mainMSG += "Understanding Document Reference Number: UD- " + vlx + "<br>";
		mainMSG += "Rejected By: " + firstName + "<br><br>";
		mainMSG += "Rejected Reason: " + rejectreason + "<br><br>";
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";
		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultUserEmails));

			// Set CC recipients
			if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(additionalRecipients));
			}

			// Set BCC recipients
			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("Understanding Document Rejected  (UD- " + vlx + ")");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}

	
	
	//05/07
	public String Send_mailRequestAccActivation(String resulTLEmails, String resulTLName, String resultManagerEmails,
			String resultManagerName, StringBuilder reqSenderName, String reqSenderMail) {
		
		String Status=null;
		
		final String Senderid1 = System.getenv("SCM_SMTP_USER");
        final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
        final int port = 587;
        final String mailid1 = resulTLEmails;
        final String maildid2 = resultManagerEmails;

        String fullNamesss1 = resulTLName;
        String fullNamesss2 = resultManagerName;

        String[] names1 = fullNamesss1.split(",");
        String[] names2 = fullNamesss2.split(",");
        

        String firstName1 = names1.length > 0 ? names1[0] : "";
        String firstName2 = names2.length > 0 ? names2[0] : "";
        
        

        final String additionalRecipients = resulTLEmails + "," + resultManagerEmails;

        final String allRecipients = additionalRecipients;

        // Properties for configuring the mail session
        final Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "" + port);
        props.put("mail.smtp.sendpartial", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create a mail session with authentication
        final javax.mail.Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Senderid1, pass1);
            }
        });

        // Construct the email message body
        String mainMSG = "";
        mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
        mainMSG += "Dear Sir/Madam,<br><br>";

        mainMSG += reqSenderName+" is requesting account activation. Please follow the instructions below to complete the process:<br><br>";
        mainMSG += "<b>Account Reactivation Instructions:</b>";
        mainMSG += "1. Click on the following link to verify and reactivate your account: <a href='http://45.118.160.203:2023/SCM/'>Reactivate My Account</a><br><br>";
        mainMSG += "2. If you have any questions or need further assistance, please visit our <a href='http://45.118.160.203:2023/SCM/'>Help Center</a>.<br><br>";
        mainMSG += "Thank you for choosing our services. We look forward to serving you again!<br><br>";
        mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";


        // Create a MimeMessage object for the email
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(Senderid1));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(allRecipients));
            
            if (!additionalRecipients.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC,
						(Address[]) InternetAddress.parse(reqSenderMail));
			}

            message.setSubject("Request for Re-Activate Account");
            
            // Create a MimeBodyPart for the HTML content
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mainMSG, "text/html");

            // Create a multipart message and add the HTML part to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Set the content of the message to the multipart message
            message.setContent(multipart);

            // Send the message using Transport
            Transport.send(message);

            // If sent successfully, set status to "Success"
            Status = "Success";
            System.out.println("[INFO] Mail Sent");
        } catch (MessagingException e) {
        	e.printStackTrace();
            // If an exception occurs during sending, set status to "Fail" and print stack trace
            Status = "Fail";
            e.printStackTrace();
            System.out.println("Mail failed--------------");
        }

        return Status;
	}
	//
	
	
	
	
	
	//26/08
	public String SendMailCredentials(String uname, String password, String userMail, String fname) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = userMail;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
//	        final String allRecipients =  additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear " +fname+",<br><br>";
		mainMSG += "Your SCM/PMS account has been created successfully. Here are your credentials: <br><br>";
		mainMSG += "Username: "+uname+"<br>";
		mainMSG += "Password: "+password+"<br>";
		mainMSG += "URL: <a href='http://45.118.160.203:2023/SCM/'>http://45.118.160.203:2023/SCM/</a><br>";
		
		mainMSG += "<p>If you have any questions or require further information, please feel free to <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.</p>";
		mainMSG += "Thank you for your cooperation and we look forward to a successful collaboration.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			
			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(userMail));

			message.setSubject("User Login Credentials");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	
	//
	
	
	
	
	
	//30/08
	public String SendMailToMailID(String uname, String otp, String userMail) {
		String Status = null;

		System.out.println("userMail::"+userMail);
		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		final String mailid = userMail;

		String fullNamesss = uname;

		// Split the full name by spaces
		String[] names = fullNamesss.split(",");

		// Extract the first name
		String firstName = names.length > 0 ? names[0] : "";
		// Merge the original recipient and new recipients
//	        final String allRecipients =  additionalRecipients;

		// tester

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		
		
		
		
		String mainMSG = "";
		int count = -1;

		mainMSG += "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear " +firstName+",<br><br>";

		mainMSG += "We have received a request to reset your password. Please use the following OTP (One-Time Password) to complete the process:<br><br>";
		mainMSG += "<b style='font-size: 24px; color: #007bff;'>" + otp + "</b><br><br>";
		mainMSG += "This OTP is valid for the next 5 minutes. If you did not request this, please ignore this email.<br><br>";
		
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));
			
			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(mailid));

			message.setSubject("One-Time Password");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			Status = "Success";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	
	
	// RFP task mail
	public String RFPtaskAssignMail(String fullname, int vlx, String resultEmails,String enddate, String assignedBy, String status,String solution, String moduleName, String rfpPoint ) {
		String Status = null;

		final String Senderid1 = System.getenv("SCM_SMTP_USER");
		final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
		final int port = 587;
		
		final String scmMail = "scmpms@velox.co.in";
		
		String statement = "";
		String markedBy = "";
		
		if(status.equalsIgnoreCase("Developed")) {
			statement="a new task has been assigned to you for testing. Please mark the status as <b>Pass/Fail</b> once the testing is complete.";
			markedBy = "Assigned By";
		} else if(status.equalsIgnoreCase("Tested")) {
			statement="a task has been awaiting an update from you. Please mark the status as <b>Ready to Deliver</b> once it is done.";
			markedBy = "Tested By";
		} else if(status.equalsIgnoreCase("Ready to Deliver")) {
			statement="a task has been awaiting an update from you. Please mark the status as <b>Close</b> once it is done.";
			markedBy = "Updated By";
		} else if(status.equalsIgnoreCase("Assigned")) {
			statement="a task has been assigned to you after the failure of test cases. Please mark the status as <b>Developed</b> once it is completed.";
			markedBy = "Tested By";
		} 
		

		String fullNamesss = fullname;
		String[] names = fullNamesss.split(",");
		String firstName = names.length > 0 ? names[0] : "";

		final String additionalRecipients = scmMail ;

		final Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "" + port);
		props.put("mail.smtp.sendpartial", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		final javax.mail.Session session = Session.getInstance(props, (Authenticator) new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Senderid1, pass1);
			}
		});
		String mainMSG = "";
		int count = -1;

		mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
		mainMSG += "Dear " + fullname + ",<br><br>";
		mainMSG += "I hope this message finds you well. We are pleased to inform you that "+statement+" <br><br>";
		mainMSG += "<b>Task Details:</b><br>";
		mainMSG += "- TaskID : " + vlx + "<br>";
		mainMSG += "- Solution : " + solution + "<br>";
		mainMSG += "- Module : " + moduleName + "<br>";
		mainMSG += "- RFP Point : " + rfpPoint + "<br>";
		mainMSG += "- Target Date : " + enddate + "<br>";
		mainMSG += "<b>"+markedBy+" :</b><br>";
		mainMSG += "- Name : " + assignedBy + ",<br><br>";
		mainMSG += "For additional resources or information, you can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br>";
		mainMSG += "Thank you for your dedication and prompt attention to this matter. We look forward to your successful completion of the task.<br><br>";
		mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom((Address) new InternetAddress(Senderid1));

			// Set TO recipient
			message.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(resultEmails));

			// Set CC recipients
//			if (!additionalRecipients.isEmpty()) {
//				message.setRecipients(Message.RecipientType.CC,
//						(Address[]) InternetAddress.parse(additionalRecipients));
//			}

//			// Set BCC recipients
//			final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
//			message.addRecipients(Message.RecipientType.BCC, (Address[]) parse);

			message.setSubject("RFP Task Assigned"+ " | TaskID : " + vlx + " ");

			final BodyPart messageBodyPart = (BodyPart) new MimeBodyPart();
			messageBodyPart.setContent((Object) mainMSG, "text/html");

			final Multipart multipart = (Multipart) new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
			count = 1;
			++count;
			Status = "Sucess";
			System.out.println("[INFO] Mail Sent " + count);
		} catch (Exception owner1) {
			count = 0;
			Status = "Fail";
			owner1.printStackTrace();
			System.out.println("Mail failed--------------");
		}

		return Status;
	}
	
	
	
	
	
	
	// multiple RFP mail 
	
	// RFP task mail
	public String RFPtaskAssignMailTL(Map<String, JSONArray> uniqueNamesMap, String assignedBy) {
	    String Status = null;

	    for (Map.Entry<String, JSONArray> entry : uniqueNamesMap.entrySet()) {
	        String name = entry.getKey();  // Get the key (name)
	        JSONArray dataArray = entry.getValue();  // Get the value (JSONArray for that name)

	        // Initialize message content for each recipient
	        String soln = "";
	        String module = "";
	        String target = "";
	        String emailId = "";
	        
	        final String Senderid1 = System.getenv("SCM_SMTP_USER");
	        final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
	        final int port = 587;
	        
	        String additionalRecipients = "scmpms@velox.co.in"; // Add any additional recipients here

	        final Properties props = new Properties();
	        props.put("mail.smtp.ssl.trust", "*");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.office365.com");
	        props.put("mail.smtp.port", "" + port);
	        props.put("mail.smtp.sendpartial", "true");
	        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        final javax.mail.Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(Senderid1, pass1);
	            }
	        });

	        String mainMSG = "<b>This is an electronically auto-generated email. Please do not reply to this message.</b><br><br>";
	        mainMSG += "Dear " + name + ",<br><br>";
	        mainMSG += "I hope this message finds you well. We are pleased to inform you that tasks have been assigned to you.<br><br>";
	        mainMSG += "<b>Task Details :</b><br>";
	        mainMSG += "<table border='1'><tr><th>Sr.No</th><th>Solution Name</th><th>RFP Point</th><th>Target_Date</th></tr>";

	        // Iterate through the dataArray for each key and get the details (soln, module, target)
	        int Srno = 0;
	        
	        for (int j = 0; j < dataArray.length(); j += 4) {
	        	Srno++;
	            soln = dataArray.getString(j);
	            module = dataArray.getString(j + 1);
	            target = dataArray.getString(j + 2);
	            emailId = dataArray.getString(j + 3);

	            // Output task details for the specific key
	            System.out.println("- Solution: " + soln);
	            System.out.println("- Module: " + module);
	            System.out.println("- Target Date: " + target);
	            System.out.println("- emailId : " + emailId);

	            mainMSG += "<tr>";
	            mainMSG += "<td>" + Srno + "</td>";
	            mainMSG += "<td>" + soln + "</td>";
	            mainMSG += "<td>" + module + "</td>";
	            mainMSG += "<td>" + target + "</td>";
	            mainMSG += "</tr>";
	        }

	        mainMSG += "</table><br>";
	        mainMSG += "<b>Assigned By : </b>" + assignedBy + ",<br><br>";
	        mainMSG += "For additional resources or information, you can <a href='http://45.118.160.203:2023/SCM/'>visit our website</a>.<br>";
	        mainMSG += "Thank you for your dedication and prompt attention to this matter. We look forward to your successful completion of the task.<br><br>";
	        mainMSG += "<p>Best Regards,<br>Velox Solutions Pvt. Ltd.</p>";

	        MimeMessage message = new MimeMessage(session);
	        try {
	            message.setFrom(new InternetAddress(Senderid1));

	            // Set TO recipient to the emailId found in the dataArray
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));

	            // Set CC recipients
//	            if (!additionalRecipients.isEmpty()) {
//	                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(additionalRecipients));
//	            }

	            // Set BCC recipients
//	            final InternetAddress[] parse = InternetAddress.parse(additionalRecipients, true);
//	            message.addRecipients(Message.RecipientType.BCC, parse);

	            message.setSubject("RFP Task Assigned");

	            final BodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setContent(mainMSG, "text/html");

	            final Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(messageBodyPart);
	            message.setContent(multipart);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        try {
	            Transport.send(message);
	            Status = "Success";
	            System.out.println("[INFO] Mail Sent to " + name);
	        } catch (Exception owner1) {
	            Status = "Fail";
	            owner1.printStackTrace();
	            System.out.println("Mail failed--------------");
	        }
	    }

	    return Status;
	}

	
	
	
}
