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

public class mail_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/// sfgdfjdfjylgylpo
	
	        final String Senderid1 = System.getenv("SCM_SMTP_USER");
	        final String pass1 = System.getenv("SCM_SMTP_PASSWORD");
//	        final String hostname = "121.243.77.117";
	        final int port = 587;
	        final String mailid = System.getenv("SCM_SMTP_TEST_RECIPIENT");
	        final String additionalRecipients = System.getenv("SCM_SMTP_TEST_CC");
	        
//	        id...supp.trackproject23@gmail.com

	        // Merge the original recipient and new recipients
	        final String allRecipients = mailid + "," + additionalRecipients;
	        
	        
	    
	        final Properties props = new Properties();
	        props.put("mail.smtp.ssl.trust", "*");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "" + port);
	        props.put("mail.smtp.sendpartial", "true");
	        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        final Session session = Session.getInstance(props, (Authenticator)new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(Senderid1, pass1);
	            }
	        });
	        
	        
	        String mainMSG = "";
	        int count = -1;
	        mainMSG += "<b>This is an electronically auto generated mail. Please do not reply to the same.</b><br><br>";
	        mainMSG = mainMSG + "Dear Sir,<br><br> Auto AD users syncronization completed.<b>";
	        MimeMessage message=new MimeMessage(session); 
	        

	        try {
	            // Create a MimeMessage object
	            MimeMessage message1 = new MimeMessage(session);

	            // Set the sender and recipient addresses
	            message.setFrom(new InternetAddress(Senderid1));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailid));

	            // Set the email subject
	            message.setSubject("Email with Attachment");

	            // Create a multipart message
	            Multipart multipart = new MimeMultipart();

	            // Create the message body part
	            BodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setText("Please find the attached PDF file.");

	            // Add the message body part to the multipart
	            multipart.addBodyPart(messageBodyPart);

	            // Attach the PDF file
	            messageBodyPart = new MimeBodyPart();
	            String filename = "path_to_your_pdf_file.pdf";
	            DataSource source = new FileDataSource(filename);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(filename);

	            // Add the attachment to the multipart
	            multipart.addBodyPart(messageBodyPart);

	            // Set the multipart as the message's content
	            message.setContent(multipart);

	            // Send the message
	            Transport.send(message);

	            System.out.println("Email with attachment sent successfully!");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
//	        try {
//	            message.setFrom((Address)new InternetAddress(Senderid1));
//	            message.setRecipients(Message.RecipientType.TO, (Address[])InternetAddress.parse(allRecipients));
//	            final InternetAddress[] parse = InternetAddress.parse(allRecipients, true);
//	            message.addRecipients(Message.RecipientType.BCC, (Address[])parse);
//	            message.setSubject("Automatic Email for AD Sync");
//	            final BodyPart messageBodyPart = (BodyPart)new MimeBodyPart();
//	            messageBodyPart.setContent((Object)mainMSG, "text/html");
//	            final Multipart multipart = (Multipart)new MimeMultipart();
//	            multipart.addBodyPart(messageBodyPart);
//	            message.setContent(multipart);
//	        }
//	        catch (Exception e) {
//	            e.printStackTrace();
//	        }
	        try {
	            Transport.send(message);
	            count = 1;
	            ++count;
	            System.out.println("[INFO] Mail Sent " + count);
	        }
	        catch (Exception owner1) {
	            count = 0;
	            owner1.printStackTrace();
	            System.out.println("Mail failed--------------");
	        }

	}
	
	



}




