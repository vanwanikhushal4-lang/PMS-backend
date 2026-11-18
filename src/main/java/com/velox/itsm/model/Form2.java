package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Form2")
public class Form2 {

	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column()
	private int SR_NO;
	
	
	private String raisedate;
	private String vlx_id;
	private String vlx_status;
	private String form2date;
	private String form2customername;
    private String RPFTIMELINES;
	private String potimeline;
	private String firstinvoicegeneratedate;
	private String customerflowchartpayment;
	private String projstartdate;
	private String projenddate;
	private String customerflowchartRemarks;
	private String form2PONo;
	private String pymentterms;
	private String projecthead;
	
	
	private String approvedby;
	private String approveddate;
	private String submittedby;
	
	private String formABfillby;
	private String formABfilldate;
	
	@Column(length = 5000)
	private String ImplementorFormC;
	
	
	
	
	public String getImplementorFormC() {
		return ImplementorFormC;
	}
	public void setImplementorFormC(String implementorFormC) {
		ImplementorFormC = implementorFormC;
	}
	public String getRaisedate() {
		return raisedate;
	}
	public void setRaisedate(String raisedate) {
		this.raisedate = raisedate;
	}
	public String getVlx_id() {
		return vlx_id;
	}
	public void setVlx_id(String vlx_id) {
		this.vlx_id = vlx_id;
	}
	public String getVlx_status() {
		return vlx_status;
	}
	public void setVlx_status(String vlx_status) {
		this.vlx_status = vlx_status;
	}

	
	
	public String getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	public String getApproveddate() {
		return approveddate;
	}
	public void setApproveddate(String approveddate) {
		this.approveddate = approveddate;
	}
	public String getSubmittedby() {
		return submittedby;
	}
	public void setSubmittedby(String submittedby) {
		this.submittedby = submittedby;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getForm2date() {
		return form2date;
	}
	public void setForm2date(String form2date) {
		this.form2date = form2date;
	}
	public String getForm2customername() {
		return form2customername;
	}
	public void setForm2customername(String form2customername) {
		this.form2customername = form2customername;
	}
	public String getRPFTIMELINES() {
		return RPFTIMELINES;
	}
	public void setRPFTIMELINES(String rPFTIMELINES) {
		RPFTIMELINES = rPFTIMELINES;
	}
	public String getPotimeline() {
		return potimeline;
	}
	public void setPotimeline(String potimeline) {
		this.potimeline = potimeline;
	}
	public String getFirstinvoicegeneratedate() {
		return firstinvoicegeneratedate;
	}
	public void setFirstinvoicegeneratedate(String firstinvoicegeneratedate) {
		this.firstinvoicegeneratedate = firstinvoicegeneratedate;
	}

	public String getCustomerflowchartpayment() {
		return customerflowchartpayment;
	}
	public void setCustomerflowchartpayment(String customerflowchartpayment) {
		this.customerflowchartpayment = customerflowchartpayment;
	}
	public String getProjstartdate() {
		return projstartdate;
	}
	public void setProjstartdate(String projstartdate) {
		this.projstartdate = projstartdate;
	}
	public String getProjenddate() {
		return projenddate;
	}
	public void setProjenddate(String projenddate) {
		this.projenddate = projenddate;
	}
	public String getPymentterms() {
		return pymentterms;
	}
	public void setPymentterms(String pymentterms) {
		this.pymentterms = pymentterms;
	}
	public String getProjecthead() {
		return projecthead;
	}
	public void setProjecthead(String projecthead) {
		this.projecthead = projecthead;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCustomerflowchartRemarks() {
		return customerflowchartRemarks;
	}
	public void setCustomerflowchartRemarks(String customerflowchartRemarks) {
		this.customerflowchartRemarks = customerflowchartRemarks;
	}
	public String getForm2PONo() {
		return form2PONo;
	}
	public void setForm2PONo(String form2poNo) {
		form2PONo = form2poNo;
	}
	public String getFormABfillby() {
		return formABfillby;
	}
	public void setFormABfillby(String formABfillby) {
		this.formABfillby = formABfillby;
	}
	public String getFormABfilldate() {
		return formABfilldate;
	}
	public void setFormABfilldate(String formABfilldate) {
		this.formABfilldate = formABfilldate;
	}
	
	
	
	
}
