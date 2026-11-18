package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_code_master")
public class company_code_master implements Serializable {
	private static final long serialVersionUID = -3874703333288861201L;
	
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String COMPANY_CODE;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY) {
		COMPANY_NAME = cOMPANY;
	}

	public String getCOMPANY_CODE() {
		return COMPANY_CODE;
	}

	public void setCOMPANY_CODE(String cOMPANY_CODE) {
		COMPANY_CODE = cOMPANY_CODE;
	}
}
