package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ClientMasterSupport {
	
	
	@Id
	@Column
	private int SR_NO;
	private String Product_Suite;
	private String Product_Tool;
	private String Customer_Name;
	private String Product_Manager;
	private String Function_name;
	private String Target_Date;
	private String Status;

	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTarget_Date() {
		return Target_Date;
	}
	public void setTarget_Date(String target_Date) {
		Target_Date = target_Date;
	}
	public String getFunction_name() {
		return Function_name;
	}
	public void setFunction_name(String function_name) {
		Function_name = function_name;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getProduct_Suite() {
		return Product_Suite;
	}
	public void setProduct_Suite(String product_Suite) {
		Product_Suite = product_Suite;
	}
	public String getProduct_Tool() {
		return Product_Tool;
	}
	public void setProduct_Tool(String product_Tool) {
		Product_Tool = product_Tool;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getProduct_Manager() {
		return Product_Manager;
	}
	public void setProduct_Manager(String product_Manager) {
		Product_Manager = product_Manager;
	}
	
	
	
	@Override
	public String toString() {
		return "ClientMasterSupport [SR_NO=" + SR_NO + ", Product_Suite=" + Product_Suite + ", Product_Tool="
				+ Product_Tool + ", Customer_Name=" + Customer_Name + ", Product_Manager=" + Product_Manager
				+ ", Function_name=" + Function_name + ", Target_Date=" + Target_Date + ", Status=" + Status + "]";
	}
	
	
	
	
	
	
}
