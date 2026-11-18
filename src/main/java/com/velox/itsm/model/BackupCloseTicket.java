package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="backup_close_ticket")
public class BackupCloseTicket implements Serializable{
	private static final long serialVersionUID = -2758462706063482575L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SrNo;
	
	private String FromDate;
	
	private String ToDate;
	
	private String Status;

	public int getSrNo() {
		return SrNo;
	}

	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	public String getFromDate() {
		return FromDate;
	}

	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}

	public String getToDate() {
		return ToDate;
	}

	public void setToDate(String toDate) {
		ToDate = toDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "BackupCloseTicket [SrNo=" + SrNo + ", FromDate=" + FromDate + ", ToDate=" + ToDate + ", Status="
				+ Status + "]";
	}
	
	
}
