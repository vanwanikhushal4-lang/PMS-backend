package com.velox.itsm.config;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Multiperpose {
//public static String UserName=null;
//	public static String  getsesssionvalue() {
//	try {
//	ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//			.getRequestAttributes();
//	HttpSession session = requestAttributes.getRequest().getSession();
// UserName	= session.getAttribute("username").toString();
//String	LoginScope = session.getAttribute("loginscope").toString();
//
//	 System.out.println("LoginUser****!!!!!!!!!!!!!!!!!!!" + UserName);
//	// System.out.println("loginUserCompany****" + loginUserCompany);
//	// System.out.println("LoginScope****" + LoginScope);
//} catch (Exception e) {
//	e.printStackTrace();
//	// System.out.println("Exceptioon e***" + e);
//}
//	return UserName;
//	}

		public static void main(String arg[])
		{

		String array[]=new String[] {"231","111","32","545","71","098"};
		int innerarray[]=new int[array.length];
		int count1=0;
		for(String arrayitrate:array)
		{
			count1=count1+1;
			//Integer  value1=Integer.parseInt(arrayitrate);
			//int length2=	value1.length();
			int valueis2=0;
			for(int i=0; i<=arrayitrate.length(); i++)
			{
				    char  charval=arrayitrate.charAt(i);
			    	int intnumber= Character.getNumericValue(charval);
					valueis2=valueis2+intnumber;
			  	 
			}
			System.out.println("SSSSSSSSSS"+valueis2);
			innerarray[count1-1]=valueis2;
			System.out.println("DDDDDDDD"+valueis2);
		}


		System.out.println("THE ARRAY IS  "+ innerarray);
		}
		
}
