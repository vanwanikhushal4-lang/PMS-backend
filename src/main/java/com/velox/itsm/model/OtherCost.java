package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OtherCost" )
public class OtherCost  implements Serializable {
	
@Id	
private int SR_NO ;
private String ENGINEERTYPE ;
private String ENGINEERCOST ;

private String  IMPLEMENTORCOST ;
private String IMPLEMENTCOST ;
private String TYPEPERCENTAGE ;
private String COSTDATA ;
private String TOTALOTHERCOST ;
public int getSR_NO() {
	return SR_NO;
}
public void setSR_NO(int sR_NO) {
	SR_NO = sR_NO;
}
public String getENGINEERTYPE() {
	return ENGINEERTYPE;
}
public void setENGINEERTYPE(String eNGINEERTYPE) {
	ENGINEERTYPE = eNGINEERTYPE;
}
public String getENGINEERCOST() {
	return ENGINEERCOST;
}
public void setENGINEERCOST(String eNGINEERCOST) {
	ENGINEERCOST = eNGINEERCOST;
}
public String getIMPLEMENTORCOST() {
	return IMPLEMENTORCOST;
}
public void setIMPLEMENTORCOST(String iMPLEMENTORCOST) {
	IMPLEMENTORCOST = iMPLEMENTORCOST;
}
public String getIMPLEMENTCOST() {
	return IMPLEMENTCOST;
}
public void setIMPLEMENTCOST(String iMPLEMENTCOST) {
	IMPLEMENTCOST = iMPLEMENTCOST;
}
public String getTYPEPERCENTAGE() {
	return TYPEPERCENTAGE;
}
public void setTYPEPERCENTAGE(String tYPEPERCENTAGE) {
	TYPEPERCENTAGE = tYPEPERCENTAGE;
}
public String getCOSTDATA() {
	return COSTDATA;
}
public void setCOSTDATA(String cOSTDATA) {
	COSTDATA = cOSTDATA;
}
public String getTOTALOTHERCOST() {
	return TOTALOTHERCOST;
}
public void setTOTALOTHERCOST(String tOTALOTHERCOST) {
	TOTALOTHERCOST = tOTALOTHERCOST;
}
@Override
public String toString() {
	return "OtherCost [SR_NO=" + SR_NO + ", ENGINEERTYPE=" + ENGINEERTYPE + ", ENGINEERCOST=" + ENGINEERCOST
			+ ", IMPLEMENTORCOST=" + IMPLEMENTORCOST + ", IMPLEMENTCOST=" + IMPLEMENTCOST + ", TYPEPERCENTAGE="
			+ TYPEPERCENTAGE + ", COSTDATA=" + COSTDATA + ", TOTALOTHERCOST=" + TOTALOTHERCOST + "]";
}


}
