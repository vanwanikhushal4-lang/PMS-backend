package com.velox.itsm.ATM;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import org.hibernate.Query;



public class ActiveDirectory {
	static String loginName = null;
    static String name = null;
    static String password = null;
    static String depatment = null;
    static String emailId = null;
    static String employeId = null;
    static String surName = null;
    static String contactNo = null;
    static String firstName = null;
    static String designation=null;
    static ArrayList al = null;

	    

	    public boolean checkCredentials(String username, String password, String domain_name, String host, String port) {
	    	System.out.println("INSIDE checkCredentilas");
	    	System.out.println("username=="+username);
	    	System.out.println("password=="+password);
	    	System.out.println("domain_name=="+domain_name);
	    	System.out.println("host=="+host);
	    	System.out.println("port=="+port);
	   
	    	////////// SPLITTING DOMAIN NAME /////////
            System.out.println("DOMAIN NAME: "+domain_name);
            String domain_name_final="";
            String[] domainnametempArray=domain_name.split("\\.");
            System.out.println("domain_name_length: "+domainnametempArray.length);
            String domain_name_new = domainnametempArray[0];
            System.out.println("domain_name_new: "+domain_name_new);
            
            for(int i=0; i < domainnametempArray.length; i++){
                     System.out.println("domainnametemp: "+domainnametempArray[i]);
                     domain_name_final=domain_name_final+"DC="+domainnametempArray[i]+",";
                     System.out.println("domain name"+domain_name_final);
                     }
            if(domain_name_final.endsWith(",")) {

                    domain_name_final= domain_name_final.substring(0, domain_name_final.length() - 1);
                    System.out.println("domain name insside if"+domain_name_final);
             }
            System.out.println("domain_name_final: "+domain_name_final);
            ////////// SPLITTING DOMAIN NAME ENDS /////////
            
	        boolean login_status = false;
	        Hashtable env = new Hashtable();
			String pass = "";

			String adminName = username + "@" + domain_name_new; // chang username
			String adminPassword = password;
			String ldapURL = "ldap://" + host + ":" + port;
		
			System.out.println("ADMIN NAME: "+adminName);
			System.out.println("ADMIN PASSWORD: "+adminPassword);
			System.out.println("LDAP URL: "+ldapURL);

			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, adminName);

			env.put(Context.SECURITY_CREDENTIALS, adminPassword);

			env.put(Context.PROVIDER_URL, ldapURL);

			System.out.println("till try catch.........");
	        try {

	// Create the initial directory context
	        	DirContext ctx = new InitialLdapContext(env, null);
	            System.out.println("till ctx.........  "+ctx);

			            login_status = true;
	           
	            ctx.close();

	        } catch (NamingException e) {
	        	System.out.println("connection failed..");
	            System.err.println("Problem searching directory: " + e);
	            login_status = false;
	        }

	        return login_status;
	    }

	
}
