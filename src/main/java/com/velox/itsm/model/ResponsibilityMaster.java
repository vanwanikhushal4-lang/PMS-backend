package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ResponsibilityMaster")
public class ResponsibilityMaster {

	  @Id
	  @Column
	  private int SR_NO;
	   
	
	  private String Company;

	
	  private String List_Of_Login;

	 
	  private String Role_Type;

	
	  private String Module;


	  
	  private String Function;


	 
	  private String CheckerorAuthorizer;


	public int getSR_NO() {
		return SR_NO;
	}


	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}


	public String getCompany() {
		return Company;
	}


	public void setCompany(String company) {
		Company = company;
	}


	public String getList_Of_Login() {
		return List_Of_Login;
	}


	public void setList_Of_Login(String list_Of_Login) {
		List_Of_Login = list_Of_Login;
	}


	public String getRole_Type() {
		return Role_Type;
	}


	public void setRole_Type(String role_Type) {
		Role_Type = role_Type;
	}


	public String getModule() {
		return Module;
	}


	public void setModule(String module) {
		Module = module;
	}


	public String getFunction() {
		return Function;
	}


	public void setFunction(String function) {
		Function = function;
	}


	public String getCheckerorAuthorizer() {
		return CheckerorAuthorizer;
	}


	public void setCheckerorAuthorizer(String checkerorAuthorizer) {
		CheckerorAuthorizer = checkerorAuthorizer;
	}


	@Override
	public String toString() {
		return "ResponsibilityMaster [SR_NO=" + SR_NO + ", Company=" + Company + ", List_Of_Login=" + List_Of_Login
				+ ", Role_Type=" + Role_Type + ", Module=" + Module + ", Function=" + Function
				+ ", CheckerorAuthorizer=" + CheckerorAuthorizer + "]";
	}

	


}
