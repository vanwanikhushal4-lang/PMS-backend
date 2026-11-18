package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AssignTaskDetails {

	private static final long serialVersionUID = -2758462706063482575L;
	
	@Id
	private int SR_NO;
	
	private String PoNumber;
	private String Date;
	private String CustomerName;
	private String ProductLicense; 
	private String CustomerImplementorName;
	private String CustomerImplementorContact;
	private String CustomerImplementorEmail;
	private String SalesManagerName;
	private String CustomerSPOCName;
	private String CustomerSPOCContact;
	private String PaymentTerms;
	private String AddRowDetails;
	private String Description;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getPoNumber() {
		return PoNumber;
	}
	public void setPoNumber(String poNumber) {
		PoNumber = poNumber;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getProductLicense() {
		return ProductLicense;
	}
	public void setProductLicense(String productLicense) {
		ProductLicense = productLicense;
	}
	public String getCustomerImplementorName() {
		return CustomerImplementorName;
	}
	public void setCustomerImplementorName(String customerImplementorName) {
		CustomerImplementorName = customerImplementorName;
	}
	public String getCustomerImplementorContact() {
		return CustomerImplementorContact;
	}
	public void setCustomerImplementorContact(String customerImplementorContact) {
		CustomerImplementorContact = customerImplementorContact;
	}
	public String getCustomerImplementorEmail() {
		return CustomerImplementorEmail;
	}
	public void setCustomerImplementorEmail(String customerImplementorEmail) {
		CustomerImplementorEmail = customerImplementorEmail;
	}
	public String getSalesManagerName() {
		return SalesManagerName;
	}
	public void setSalesManagerName(String salesManagerName) {
		SalesManagerName = salesManagerName;
	}
	public String getCustomerSPOCName() {
		return CustomerSPOCName;
	}
	public void setCustomerSPOCName(String customerSPOCName) {
		CustomerSPOCName = customerSPOCName;
	}
	public String getCustomerSPOCContact() {
		return CustomerSPOCContact;
	}
	public void setCustomerSPOCContact(String customerSPOCContact) {
		CustomerSPOCContact = customerSPOCContact;
	}
	public String getPaymentTerms() {
		return PaymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		PaymentTerms = paymentTerms;
	}
	public String getAddRowDetails() {
		return AddRowDetails;
	}
	public void setAddRowDetails(String addRowDetails) {
		AddRowDetails = addRowDetails;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "AssignTaskDetails [SR_NO=" + SR_NO + ", PoNumber=" + PoNumber + ", Date=" + Date + ", CustomerName="
				+ CustomerName + ", ProductLicense=" + ProductLicense + ", CustomerImplementorName="
				+ CustomerImplementorName + ", CustomerImplementorContact=" + CustomerImplementorContact
				+ ", CustomerImplementorEmail=" + CustomerImplementorEmail + ", SalesManagerName=" + SalesManagerName
				+ ", CustomerSPOCName=" + CustomerSPOCName + ", CustomerSPOCContact=" + CustomerSPOCContact
				+ ", PaymentTerms=" + PaymentTerms + ", AddRowDetails=" + AddRowDetails + ", Description=" + Description
				+ "]";
	}
	
	
	
	
}
