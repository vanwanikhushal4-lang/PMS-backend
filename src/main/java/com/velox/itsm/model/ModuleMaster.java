package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ModuleMaster")
public class ModuleMaster {
	  
	  private static final long serialVersionUID = -1722684944868971448L;
	  @Id
	  @Column
	  private int SR_NO;
	   
	  @Column(name = "MODULE", columnDefinition = "NVARCHAR(500)")
	  private String MODULE;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getMODULE() {
		return MODULE;
	}

	public void setMODULE(String mODULE) {
		MODULE = mODULE;
	}

	@Override
	public String toString() {
		return "ModuleMaster [SR_NO=" + SR_NO + ", MODULE=" + MODULE + "]";
	}

	 
	  
}
