package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORM3")
public class FORM3  implements Serializable
{
	private static final long serialVersionUID = -6631147707364792372L;
	
	@Id
	@Column
	private int SR_NO ;
	private  String T_Date ;
	private String PROJECT_IMPL_NAME;
	private String  CUSTOMER_NAME;
	private String PROJECT_NAME;
	
	private String SERVER_AVAILABILITY ;
	private String SERVER_RESPONSIBILITY ;
	private String SERVER_STARTDATE;
	private String SERVER_ENDDATE;
	private String INSTALL_VELOX_LICENSE;
	private String RESPONSIBILTIY_VELOX_LICENSE;
	private String VELOX_LICENSE_STARTDATE;
	private String VELOX_LICENSE_ENDDATE;
	private String UAT_TESTING;
	private String RESPONSIBILITY_UAT_TESTING;
	private String UAT_STARTDATE;
	private String UAT_ENDDATE;
	private String PRODUCT_GO_LIVE;
	private String RESPONSIBILITY_PRODUCTGOLIVE;
	private String PRODUCT_GO_LIVE_STARTDATE;
	private String PRODUCT_GO_LIVE_ENDDATE;
	private String ROLLOUT;
	private String RSPOSINBILITY_ROLLOUT;
	private String ROLLOUT_STARTDATE;
	private String ROLLOUT_ENDDATE;
	private String DEMO_LIVE;
	private String RESPONSIBILTY_DEMOLIVE;
	private String DEMOLIVE_STARTDATE;
	private String DEMOLIVE_ENDDATE;
	private String PAYMENT_TERMS;
	private String RESPONSIBILITY_PAYMENTTERMS;
	private String PAYMENT_TERMS_STARTDATE;
	private String PAYMENT_TERMS_ENDDATE;	
	private String SIGNOFF ;
	private String RESPONSIBILTY_SIGNOFF;
	private String SIGNOFF_STARTDATE;
	private String SIGNOFF_ENDDATE;
	private String Form3Fillby;
	private String Form3FillbyFullName;
	private String form3PONo;
	private String raisedate;
	private String VP_id;
	private String VP_status;
	
	private String product_license;
	private String Product_Implementors;
	private String Form3FillDate;
	
	
	private String CUSTOMER_IMPLEMENTOR_NAME ;
	private String CUSTOMER_IMPLEMENTOR_CONTACT;
	private String CUSTOMER_IMPLEMENTOR_EMAIL ;
	private String SALES_MANAGER_NAME;
	private String END_CUSTOMER_NAME;
	private String END_CUSTOMER_CONTACT;
	
	
	
	
	
	public String getCUSTOMER_IMPLEMENTOR_NAME() {
		return CUSTOMER_IMPLEMENTOR_NAME;
	}
	public void setCUSTOMER_IMPLEMENTOR_NAME(String cUSTOMER_IMPLEMENTOR_NAME) {
		CUSTOMER_IMPLEMENTOR_NAME = cUSTOMER_IMPLEMENTOR_NAME;
	}
	public String getCUSTOMER_IMPLEMENTOR_CONTACT() {
		return CUSTOMER_IMPLEMENTOR_CONTACT;
	}
	public void setCUSTOMER_IMPLEMENTOR_CONTACT(String cUSTOMER_IMPLEMENTOR_CONTACT) {
		CUSTOMER_IMPLEMENTOR_CONTACT = cUSTOMER_IMPLEMENTOR_CONTACT;
	}
	public String getCUSTOMER_IMPLEMENTOR_EMAIL() {
		return CUSTOMER_IMPLEMENTOR_EMAIL;
	}
	public void setCUSTOMER_IMPLEMENTOR_EMAIL(String cUSTOMER_IMPLEMENTOR_EMAIL) {
		CUSTOMER_IMPLEMENTOR_EMAIL = cUSTOMER_IMPLEMENTOR_EMAIL;
	}
	public String getSALES_MANAGER_NAME() {
		return SALES_MANAGER_NAME;
	}
	public void setSALES_MANAGER_NAME(String sALES_MANAGER_NAME) {
		SALES_MANAGER_NAME = sALES_MANAGER_NAME;
	}
	public String getEND_CUSTOMER_NAME() {
		return END_CUSTOMER_NAME;
	}
	public void setEND_CUSTOMER_NAME(String eND_CUSTOMER_NAME) {
		END_CUSTOMER_NAME = eND_CUSTOMER_NAME;
	}
	public String getEND_CUSTOMER_CONTACT() {
		return END_CUSTOMER_CONTACT;
	}
	public void setEND_CUSTOMER_CONTACT(String eND_CUSTOMER_CONTACT) {
		END_CUSTOMER_CONTACT = eND_CUSTOMER_CONTACT;
	}
	public String getForm3FillbyFullName() {
		return Form3FillbyFullName;
	}
	public void setForm3FillbyFullName(String form3FillbyFullName) {
		Form3FillbyFullName = form3FillbyFullName;
	}
	public String getProduct_Implementors() {
		return Product_Implementors;
	}
	public void setProduct_Implementors(String product_Implementors) {
		Product_Implementors = product_Implementors;
	}
	public String getProduct_license() {
		return product_license;
	}
	public void setProduct_license(String product_license) {
		this.product_license = product_license;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getT_Date() {
		return T_Date;
	}
	public void setT_Date(String t_Date) {
		T_Date = t_Date;
	}
	public String getPROJECT_IMPL_NAME() {
		return PROJECT_IMPL_NAME;
	}
	public void setPROJECT_IMPL_NAME(String pROJECT_IMPL_NAME) {
		PROJECT_IMPL_NAME = pROJECT_IMPL_NAME;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getSERVER_AVAILABILITY() {
		return SERVER_AVAILABILITY;
	}
	public void setSERVER_AVAILABILITY(String sERVER_AVAILABILITY) {
		SERVER_AVAILABILITY = sERVER_AVAILABILITY;
	}
	public String getSERVER_RESPONSIBILITY() {
		return SERVER_RESPONSIBILITY;
	}
	public void setSERVER_RESPONSIBILITY(String sERVER_RESPONSIBILITY) {
		SERVER_RESPONSIBILITY = sERVER_RESPONSIBILITY;
	}
	public String getSERVER_STARTDATE() {
		return SERVER_STARTDATE;
	}
	
	public String getForm3FillDate() {
		return Form3FillDate;
	}
	public void setForm3FillDate(String form3FillDate) {
		Form3FillDate = form3FillDate;
	}
	public void setSERVER_STARTDATE(String sERVER_STARTDATE) {
		SERVER_STARTDATE = sERVER_STARTDATE;
	}
	public String getSERVER_ENDDATE() {
		return SERVER_ENDDATE;
	}
	public void setSERVER_ENDDATE(String sERVER_ENDDATE) {
		SERVER_ENDDATE = sERVER_ENDDATE;
	}
	public String getINSTALL_VELOX_LICENSE() {
		return INSTALL_VELOX_LICENSE;
	}
	public void setINSTALL_VELOX_LICENSE(String iNSTALL_VELOX_LICENSE) {
		INSTALL_VELOX_LICENSE = iNSTALL_VELOX_LICENSE;
	}
	
	public String getForm3Fillby() {
		return Form3Fillby;
	}
	public void setForm3Fillby(String form3Fillby) {
		Form3Fillby = form3Fillby;
	}
	public String getRESPONSIBILTIY_VELOX_LICENSE() {
		return RESPONSIBILTIY_VELOX_LICENSE;
	}
	public void setRESPONSIBILTIY_VELOX_LICENSE(String rESPONSIBILTIY_VELOX_LICENSE) {
		RESPONSIBILTIY_VELOX_LICENSE = rESPONSIBILTIY_VELOX_LICENSE;
	}
	public String getVELOX_LICENSE_STARTDATE() {
		return VELOX_LICENSE_STARTDATE;
	}
	public void setVELOX_LICENSE_STARTDATE(String vELOX_LICENSE_STARTDATE) {
		VELOX_LICENSE_STARTDATE = vELOX_LICENSE_STARTDATE;
	}
	public String getVELOX_LICENSE_ENDDATE() {
		return VELOX_LICENSE_ENDDATE;
	}
	public void setVELOX_LICENSE_ENDDATE(String vELOX_LICENSE_ENDDATE) {
		VELOX_LICENSE_ENDDATE = vELOX_LICENSE_ENDDATE;
	}
	public String getUAT_TESTING() {
		return UAT_TESTING;
	}
	public void setUAT_TESTING(String uAT_TESTING) {
		UAT_TESTING = uAT_TESTING;
	}
	public String getRESPONSIBILITY_UAT_TESTING() {
		return RESPONSIBILITY_UAT_TESTING;
	}
	public void setRESPONSIBILITY_UAT_TESTING(String rESPONSIBILITY_UAT_TESTING) {
		RESPONSIBILITY_UAT_TESTING = rESPONSIBILITY_UAT_TESTING;
	}
	public String getUAT_STARTDATE() {
		return UAT_STARTDATE;
	}
	public void setUAT_STARTDATE(String uAT_STARTDATE) {
		UAT_STARTDATE = uAT_STARTDATE;
	}
	public String getUAT_ENDDATE() {
		return UAT_ENDDATE;
	}
	public void setUAT_ENDDATE(String uAT_ENDDATE) {
		UAT_ENDDATE = uAT_ENDDATE;
	}
	public String getPRODUCT_GO_LIVE() {
		return PRODUCT_GO_LIVE;
	}
	public void setPRODUCT_GO_LIVE(String pRODUCT_GO_LIVE) {
		PRODUCT_GO_LIVE = pRODUCT_GO_LIVE;
	}
	public String getRESPONSIBILITY_PRODUCTGOLIVE() {
		return RESPONSIBILITY_PRODUCTGOLIVE;
	}
	public void setRESPONSIBILITY_PRODUCTGOLIVE(String rESPONSIBILITY_PRODUCTGOLIVE) {
		RESPONSIBILITY_PRODUCTGOLIVE = rESPONSIBILITY_PRODUCTGOLIVE;
	}
	public String getPRODUCT_GO_LIVE_STARTDATE() {
		return PRODUCT_GO_LIVE_STARTDATE;
	}
	public void setPRODUCT_GO_LIVE_STARTDATE(String pRODUCT_GO_LIVE_STARTDATE) {
		PRODUCT_GO_LIVE_STARTDATE = pRODUCT_GO_LIVE_STARTDATE;
	}
	public String getPRODUCT_GO_LIVE_ENDDATE() {
		return PRODUCT_GO_LIVE_ENDDATE;
	}
	public void setPRODUCT_GO_LIVE_ENDDATE(String pRODUCT_GO_LIVE_ENDDATE) {
		PRODUCT_GO_LIVE_ENDDATE = pRODUCT_GO_LIVE_ENDDATE;
	}
	public String getROLLOUT() {
		return ROLLOUT;
	}
	public void setROLLOUT(String rOLLOUT) {
		ROLLOUT = rOLLOUT;
	}
	public String getRSPOSINBILITY_ROLLOUT() {
		return RSPOSINBILITY_ROLLOUT;
	}
	public void setRSPOSINBILITY_ROLLOUT(String rSPOSINBILITY_ROLLOUT) {
		RSPOSINBILITY_ROLLOUT = rSPOSINBILITY_ROLLOUT;
	}
	public String getROLLOUT_STARTDATE() {
		return ROLLOUT_STARTDATE;
	}
	public void setROLLOUT_STARTDATE(String rOLLOUT_STARTDATE) {
		ROLLOUT_STARTDATE = rOLLOUT_STARTDATE;
	}
	public String getROLLOUT_ENDDATE() {
		return ROLLOUT_ENDDATE;
	}
	public void setROLLOUT_ENDDATE(String rOLLOUT_ENDDATE) {
		ROLLOUT_ENDDATE = rOLLOUT_ENDDATE;
	}
	public String getDEMO_LIVE() {
		return DEMO_LIVE;
	}
	public void setDEMO_LIVE(String dEMO_LIVE) {
		DEMO_LIVE = dEMO_LIVE;
	}
	public String getRESPONSIBILTY_DEMOLIVE() {
		return RESPONSIBILTY_DEMOLIVE;
	}
	public void setRESPONSIBILTY_DEMOLIVE(String rESPONSIBILTY_DEMOLIVE) {
		RESPONSIBILTY_DEMOLIVE = rESPONSIBILTY_DEMOLIVE;
	}
	public String getDEMOLIVE_STARTDATE() {
		return DEMOLIVE_STARTDATE;
	}
	public void setDEMOLIVE_STARTDATE(String dEMOLIVE_STARTDATE) {
		DEMOLIVE_STARTDATE = dEMOLIVE_STARTDATE;
	}
	public String getDEMOLIVE_ENDDATE() {
		return DEMOLIVE_ENDDATE;
	}
	public void setDEMOLIVE_ENDDATE(String dEMOLIVE_ENDDATE) {
		DEMOLIVE_ENDDATE = dEMOLIVE_ENDDATE;
	}
	public String getPAYMENT_TERMS() {
		return PAYMENT_TERMS;
	}
	public void setPAYMENT_TERMS(String pAYMENT_TERMS) {
		PAYMENT_TERMS = pAYMENT_TERMS;
	}
	
	public String getRaisedate() {
		return raisedate;
	}
	public void setRaisedate(String raisedate) {
		this.raisedate = raisedate;
	}
	public String getVP_id() {
		return VP_id;
	}
	public void setVP_id(String vP_id) {
		VP_id = vP_id;
	}
	public String getVP_status() {
		return VP_status;
	}
	public void setVP_status(String vP_status) {
		VP_status = vP_status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRESPONSIBILITY_PAYMENTTERMS() {
		return RESPONSIBILITY_PAYMENTTERMS;
	}
	public void setRESPONSIBILITY_PAYMENTTERMS(String rESPONSIBILITY_PAYMENTTERMS) {
		RESPONSIBILITY_PAYMENTTERMS = rESPONSIBILITY_PAYMENTTERMS;
	}
	public String getPAYMENT_TERMS_STARTDATE() {
		return PAYMENT_TERMS_STARTDATE;
	}
	public void setPAYMENT_TERMS_STARTDATE(String pAYMENT_TERMS_STARTDATE) {
		PAYMENT_TERMS_STARTDATE = pAYMENT_TERMS_STARTDATE;
	}
	public String getPAYMENT_TERMS_ENDDATE() {
		return PAYMENT_TERMS_ENDDATE;
	}
	public void setPAYMENT_TERMS_ENDDATE(String pAYMENT_TERMS_ENDDATE) {
		PAYMENT_TERMS_ENDDATE = pAYMENT_TERMS_ENDDATE;
	}
	public String getSIGNOFF() {
		return SIGNOFF;
	}
	public void setSIGNOFF(String sIGNOFF) {
		SIGNOFF = sIGNOFF;
	}
	public String getRESPONSIBILTY_SIGNOFF() {
		return RESPONSIBILTY_SIGNOFF;
	}
	public void setRESPONSIBILTY_SIGNOFF(String rESPONSIBILTY_SIGNOFF) {
		RESPONSIBILTY_SIGNOFF = rESPONSIBILTY_SIGNOFF;
	}
	public String getSIGNOFF_STARTDATE() {
		return SIGNOFF_STARTDATE;
	}
	public void setSIGNOFF_STARTDATE(String sIGNOFF_STARTDATE) {
		SIGNOFF_STARTDATE = sIGNOFF_STARTDATE;
	}
	public String getSIGNOFF_ENDDATE() {
		return SIGNOFF_ENDDATE;
	}
	public void setSIGNOFF_ENDDATE(String sIGNOFF_ENDDATE) {
		SIGNOFF_ENDDATE = sIGNOFF_ENDDATE;
	}
	
	
	public String getForm3PONo() {
		return form3PONo;
	}
	public void setForm3PONo(String form3poNo) {
		form3PONo = form3poNo;
	}
	@Override
	public String toString() {
		return "FORM3 [SR_NO=" + SR_NO + ", T_Date=" + T_Date + ", PROJECT_IMPL_NAME=" + PROJECT_IMPL_NAME
				+ ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", PROJECT_NAME=" + PROJECT_NAME + ", SERVER_AVAILABILITY="
				+ SERVER_AVAILABILITY + ", SERVER_RESPONSIBILITY=" + SERVER_RESPONSIBILITY + ", SERVER_STARTDATE="
				+ SERVER_STARTDATE + ", SERVER_ENDDATE=" + SERVER_ENDDATE + ", INSTALL_VELOX_LICENSE="
				+ INSTALL_VELOX_LICENSE + ", RESPONSIBILTIY_VELOX_LICENSE=" + RESPONSIBILTIY_VELOX_LICENSE
				+ ", VELOX_LICENSE_STARTDATE=" + VELOX_LICENSE_STARTDATE + ", VELOX_LICENSE_ENDDATE="
				+ VELOX_LICENSE_ENDDATE + ", UAT_TESTING=" + UAT_TESTING + ", RESPONSIBILITY_UAT_TESTING="
				+ RESPONSIBILITY_UAT_TESTING + ", UAT_STARTDATE=" + UAT_STARTDATE + ", UAT_ENDDATE=" + UAT_ENDDATE
				+ ", PRODUCT_GO_LIVE=" + PRODUCT_GO_LIVE + ", RESPONSIBILITY_PRODUCTGOLIVE="
				+ RESPONSIBILITY_PRODUCTGOLIVE + ", PRODUCT_GO_LIVE_STARTDATE=" + PRODUCT_GO_LIVE_STARTDATE
				+ ", PRODUCT_GO_LIVE_ENDDATE=" + PRODUCT_GO_LIVE_ENDDATE + ", ROLLOUT=" + ROLLOUT
				+ ", RSPOSINBILITY_ROLLOUT=" + RSPOSINBILITY_ROLLOUT + ", ROLLOUT_STARTDATE=" + ROLLOUT_STARTDATE
				+ ", ROLLOUT_ENDDATE=" + ROLLOUT_ENDDATE + ", DEMO_LIVE=" + DEMO_LIVE + ", RESPONSIBILTY_DEMOLIVE="
				+ RESPONSIBILTY_DEMOLIVE + ", DEMOLIVE_STARTDATE=" + DEMOLIVE_STARTDATE + ", DEMOLIVE_ENDDATE="
				+ DEMOLIVE_ENDDATE + ", PAYMENT_TERMS=" + PAYMENT_TERMS + ", RESPONSIBILITY_PAYMENTTERMS="
				+ RESPONSIBILITY_PAYMENTTERMS + ", PAYMENT_TERMS_STARTDATE=" + PAYMENT_TERMS_STARTDATE
				+ ", PAYMENT_TERMS_ENDDATE=" + PAYMENT_TERMS_ENDDATE + ", SIGNOFF=" + SIGNOFF
				+ ", RESPONSIBILTY_SIGNOFF=" + RESPONSIBILTY_SIGNOFF + ", SIGNOFF_STARTDATE=" + SIGNOFF_STARTDATE
				+ ", SIGNOFF_ENDDATE=" + SIGNOFF_ENDDATE + ", Form3Fillby=" + Form3Fillby + ", Form3FillbyFullName="
				+ Form3FillbyFullName + ", form3PONo=" + form3PONo + ", raisedate=" + raisedate + ", VP_id=" + VP_id
				+ ", VP_status=" + VP_status + ", product_license=" + product_license + ", Product_Implementors="
				+ Product_Implementors + ", Form3FillDate=" + Form3FillDate + ", CUSTOMER_IMPLEMENTOR_NAME="
				+ CUSTOMER_IMPLEMENTOR_NAME + ", CUSTOMER_IMPLEMENTOR_CONTACT=" + CUSTOMER_IMPLEMENTOR_CONTACT
				+ ", CUSTOMER_IMPLEMENTOR_EMAIL=" + CUSTOMER_IMPLEMENTOR_EMAIL + ", SALES_MANAGER_NAME="
				+ SALES_MANAGER_NAME + ", END_CUSTOMER_NAME=" + END_CUSTOMER_NAME + ", END_CUSTOMER_CONTACT="
				+ END_CUSTOMER_CONTACT + "]";
	}
	
	
	
	
	
	

}
