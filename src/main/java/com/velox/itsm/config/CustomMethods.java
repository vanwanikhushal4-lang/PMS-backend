package com.velox.itsm.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomMethods  
{

	
	public static String GetElapsTime(String startDate,String EndDate) 
	{
		String a="a,b,c";
		String b="a:q";
		StringJoiner j=new StringJoiner(",");
		j.add("jj").add("dddd");
		System.out.println(a.concat(","+b));
		System.out.println("inside GetElapsTime @@@ ");
		String difrenceelpasestring="";
		try
		{
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		Date starttime=	formatter.parse(startDate);
		Date endtime=	formatter.parse(EndDate);
		
		long difrenceelpase=endtime.getTime()-starttime.getTime();
		
		System.out.println("DIFFRENCE ELAPS TIME "+difrenceelpase );
		
		 difrenceelpasestring = String.valueOf(difrenceelpase);
		 if(difrenceelpasestring.length() >=3){
		 difrenceelpasestring= difrenceelpasestring.substring(0, difrenceelpasestring.length()-3);
		 }
		
		}catch
		(ParseException e) 
		{
			e.printStackTrace();
			
		}
		return difrenceelpasestring;
	}
	
//	public static void main(String[] args) {
//
//		StringJoiner j=new StringJoiner(",");
//		j.add("jj").add("dddd");
//		System.out.println("ff"+j);
//		String ip="Line:enp0s3    Link encap:Ethernet  HWaddr 08:00:27:17:1e:7d";
//		String[] split = ip.split("  ");
//		String str=split[3];
//		String trim = str.replace("HWaddr", "").trim();
//		System.out.println("str"+trim);
//		
//		String result = ip.substring(ip.indexOf("HWaddr")+7);
//		
//		System.out.println("result::"+result);
//		String str="AA~a,BB~b,CC~c";
//		String[]  str1=str.split(",");
//		List<String> list=new ArrayList<>();
//		for(int i=0;i<str1.length;i++)
//		{
//			String catw=str1[i];
//			System.out.println(catw);
//			String[] split = catw.split("~");
//			
//			list.add(split[1]);
//		}
//		
////		String[] v=new String(list.ge)); 
//		String a="";
//		for(int i=0;i<list.size();i++)
//		{
//			String findcat=list.get(i);
//			 if(a.equals(""))
//			 {
//				 a=findcat;
//				 System.out.println("B"+a);
//			 }
//			 else
//			 {
//				 a=a+","+findcat;
//			}
//		}
//		System.out.println("sdssssssssssssss"+a);
	
//	}
	
//	try {
//		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		HttpSession session = requestAttributes.getRequest().getSession();
//	String dd	= session.getAttribute("username").toString();
//	String	LoginScope = session.getAttribute("loginscope").toString();
//	
//		// System.out.println("LoginUser****" + LoginUser);
//		// System.out.println("loginUserCompany****" + loginUserCompany);
//		// System.out.println("LoginScope****" + LoginScope);
//	} catch (Exception e) {
//		e.printStackTrace();
//		// System.out.println("Exceptioon e***" + e);
//	}
}
