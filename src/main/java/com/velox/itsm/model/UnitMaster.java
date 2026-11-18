package com.velox.itsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UnitMaster" )
public class UnitMaster {
	@Id	
	private int SR_NO;
	
	private String Unit ;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	@Override
	public String toString() {
		return "UnitMaster [SR_NO=" + SR_NO + ", Unit=" + Unit + "]";
	}

}
