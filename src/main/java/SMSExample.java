



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMSExample  {

	public static void main(String[] args) {
		

		  
	    String userId = System.getenv("SCM_SMS_USER");
	    String password = System.getenv("SCM_SMS_PASSWORD");
	    String sendMethod = "simpleMsg";
	    String msgType = "text";
	    String mobile = System.getenv("SCM_SMS_RECIPIENT");
	    String senderId = System.getenv("SCM_SMS_SENDER");
	    String msg = "Example SMS";
	    String format = "json";
	    URLConnection myURLConnection = null;
	    URL myURL = null;
	    BufferedReader reader = null;
	    String urlencodedmsg = URLEncoder.encode(msg);
	    String mainUrl = "https://dq2rr.api.infobip.com/sms/1/text/query?";
	    StringBuilder sendSmsData = new StringBuilder(mainUrl);
	    sendSmsData.append("username=" + userId);
	    sendSmsData.append("&password=" + password);
	    sendSmsData.append("&to=" + mobile);
	    sendSmsData.append("&text=" + urlencodedmsg);
	    sendSmsData.append("&from=EPSALT&indiaDltContentTemplateId=1107168959774000343&indiaDltPrincipalEntityId=1101379030000030496");
	    mainUrl = sendSmsData.toString();
	    System.out.println("main url:    " + mainUrl);
	    try {
	      myURL = new URL(mainUrl);
	      myURLConnection = myURL.openConnection();
	      myURLConnection.connect();
	      reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	      String response;
	      while ((response = reader.readLine()) != null)
	        System.out.println(response); 
	      System.out.println("SMS SEND TO "+mobile);
	      reader.close();
	    } catch (IOException e) {
	    
	      System.out.println("SMS Not SEND");
	      
	    } 
	  
	}

}


