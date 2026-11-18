package com.velox.itsm.ATM;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.mail.Message;

public class SendOTP implements Runnable {

	public String url12 = "";

	public SendOTP(String url) {

		url12 = url;

	}

	@Override
	public void run() {

		System.out.println("Inside SendOTP Thread");
		// Send OTP Through SMS

		try {

			URL urll = new URL(url12);
			System.out.println("URL====" + url12);
			HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			System.out.println("SMS Send successfully........." + code);

			System.out.println("Thread run  finished.....");
		} catch (Exception e33) {
			e33.printStackTrace();
			System.out.println("Exception in SendOTP" + e33);
		} finally {

		}

	}

}
