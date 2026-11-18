package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TrackingMaster")
public class TrackingMaster {
	
	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column()
	private int SR_NO;
	
	
	private String raisedate;
	private String vlx_id;
	private String vlx_status;
	
	private String submittedby;
	
	
	private String approvedby;
	private String approveddate;
	
	private String authorizedby;
	private String authorizedDate;
	private String rejectedBySM;
	private String rejectedDateSM;
	
	private String rejectedByMD;
	private String rejectedDateMD;
	
	private String ReSendSIDate;
	private String ReSendBySI;	
	
	
	private String ReSendSItoMDDate;
	private String ReSendBySItoMD;	
	
	private String currentUpdatedTime;	
	
	private String form3date;
	private String form3submitby;	
	
	private String formABdate;
	private String formABsubmitby;	

	
	
	
	public String getReSendSItoMDDate() {
		return ReSendSItoMDDate;
	}

	public void setReSendSItoMDDate(String reSendSItoMDDate) {
		ReSendSItoMDDate = reSendSItoMDDate;
	}

	public String getReSendBySItoMD() {
		return ReSendBySItoMD;
	}

	public void setReSendBySItoMD(String reSendBySItoMD) {
		ReSendBySItoMD = reSendBySItoMD;
	}

	public String getForm3date() {
		return form3date;
	}

	public void setForm3date(String form3date) {
		this.form3date = form3date;
	}

	public String getForm3submitby() {
		return form3submitby;
	}

	public void setForm3submitby(String form3submitby) {
		this.form3submitby = form3submitby;
	}

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getRaisedate() {
		return raisedate;
	}

	public String getRejectedByMD() {
		return rejectedByMD;
	}

	public void setRejectedByMD(String rejectedByMD) {
		this.rejectedByMD = rejectedByMD;
	}

	public String getRejectedDateMD() {
		return rejectedDateMD;
	}

	public void setRejectedDateMD(String rejectedDateMD) {
		this.rejectedDateMD = rejectedDateMD;
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

	public String getCurrentUpdatedTime() {
		return currentUpdatedTime;
	}

	public void setCurrentUpdatedTime(String currentUpdatedTime) {
		this.currentUpdatedTime = currentUpdatedTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAuthorizedby() {
		return authorizedby;
	}

	public void setAuthorizedby(String authorizedby) {
		this.authorizedby = authorizedby;
	}

	public String getAuthorizedDate() {
		return authorizedDate;
	}

	public void setAuthorizedDate(String authorizedDate) {
		this.authorizedDate = authorizedDate;
	}

	public String getRejectedBySM() {
		return rejectedBySM;
	}

	public void setRejectedBySM(String rejectedBySM) {
		this.rejectedBySM = rejectedBySM;
	}

	public String getRejectedDateSM() {
		return rejectedDateSM;
	}

	public void setRejectedDateSM(String rejectedDateSM) {
		this.rejectedDateSM = rejectedDateSM;
	}

	public String getReSendSIDate() {
		return ReSendSIDate;
	}

	public void setReSendSIDate(String reSendSIDate) {
		ReSendSIDate = reSendSIDate;
	}

	public String getReSendBySI() {
		return ReSendBySI;
	}

	public void setReSendBySI(String reSendBySI) {
		ReSendBySI = reSendBySI;
	}

	public String getFormABdate() {
		return formABdate;
	}

	public void setFormABdate(String formABdate) {
		this.formABdate = formABdate;
	}

	public String getFormABsubmitby() {
		return formABsubmitby;
	}

	public void setFormABsubmitby(String formABsubmitby) {
		this.formABsubmitby = formABsubmitby;
	}
	
	
	

}
