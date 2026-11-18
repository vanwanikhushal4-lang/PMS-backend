package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Assigned_Ticket {

	
	@Id
	@Column
	private int SR_NO;
	private String branch;
	private String flag;
	private String ip_address;
	private String mail_msg;
	private String problem;
	private String subject;
	private String r_date;
	private String ref_id;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getMail_msg() {
		return mail_msg;
	}
	public void setMail_msg(String mail_msg) {
		this.mail_msg = mail_msg;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	@Override
	public String toString() {
		return "Assigned_Ticket [SR_NO=" + SR_NO + ", branch=" + branch + ", flag=" + flag + ", ip_address="
				+ ip_address + ", mail_msg=" + mail_msg + ", problem=" + problem + ", subject=" + subject + ", r_date="
				+ r_date + ", ref_id=" + ref_id + "]";
	}
	
	
	
}
