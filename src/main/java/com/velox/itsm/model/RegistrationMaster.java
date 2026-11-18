package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegistrationMaster")
public class RegistrationMaster {

	private static final long serialVersionUID = 4L;

	@Id
	@Column
	private int SR_NO;	
	
	private String  RF_id;	
	private String COMPANY_NAME;
	private String REGISTRATION_NO ;
	private String ADDRESS;
	private String CONTACT_PERSON_NAME;
	private String MOBILE_NO;
	private String TELEPHONE_NO ;
	private String MD_CEO_EMAIL_ID ;
	private String SALES_EMAIL_ID;
	private String SUPPORT_EMAIL_ID ;
	
	private String EMAIL_ID_CONTACT_PERSON;
	private String EMAIL_ID_OFFICE ;
	private String CITY;
	private String DISTRICT;
	private String STATE;
	private String PIN;
	private String COUNTRY;
	private String WEBSITE;		
	private String PAN_NO ;
	private String OWNERSHIP_TYPE ;
	private String SCALE_OF_COMPANY ;
	private String GSTIN;
	private String OTHER_COUNTRY_TAXNO ;
	private String DETAILS_OF_DIRECTOR ;
	private String DATE_COMMENCEMENT_BUSSINESS;
	private String CURRENCY;
	private String YEAR1;
	private String YEAR2;	
	private String YEAR3;
	private String AMOUNT1;
	private String AMOUNT2;
	private String AMOUNT3;
	private String REGISTERED_GEMPORTAL;
	private String REGISTERED_MSMED;
	private String ENTREPRENEUR_MEMORANDUM;
	private String INCORPORATION_CERTIFICATE;
	private String PAN_CARD_FILE ;
	private String GST_CERTIFICATE;
	private String MSMED_FILE;	
	private String CANCLE_CHECKED_FILE;
	private String LAST_YEAR_BS_PANDL;
	private String MSMED_DOCUMENT_FILE;
	private String CHECKER;
	private String AUTHORIZER;
	private String VERIFIED_TICK_MARK;
	private String CATEGORY_TYPE;
	private String DISTRIBUTOR_NAME;
	private String PARTNER_NAME ;
	private String STATUS;
	private String ApprovedBy;
	private String ApprovedDate;
	private String SubmittedDate;
	private String SubmittedBy;
	private String Company_MD;
	private String RejectedBy;
	
	private String RejectNoteAM;
	
	private String salesManager;
	
	private String msmedRegisterType;
	
	private String commercialProposalFile;
	private String purchaseOrderFile;
	
	private String Customer_Name;
	private String End_Customer;
	private int BulkUp_ID;
	private String RejectedDate;
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getRF_id() {
		return RF_id;
	}
	public void setRF_id(String rF_id) {
		RF_id = rF_id;
	}
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}
	
	public String getCommercialProposalFile() {
		return commercialProposalFile;
	}
	public void setCommercialProposalFile(String commercialProposalFile) {
		this.commercialProposalFile = commercialProposalFile;
	}
	public String getPurchaseOrderFile() {
		return purchaseOrderFile;
	}
	public void setPurchaseOrderFile(String purchaseOrderFile) {
		this.purchaseOrderFile = purchaseOrderFile;
	}
	public String getMsmedRegisterType() {
		return msmedRegisterType;
	}
	public void setMsmedRegisterType(String msmedRegisterType) {
		this.msmedRegisterType = msmedRegisterType;
	}
	public String getSalesManager() {
		return salesManager;
	}
	public void setSalesManager(String salesManager) {
		this.salesManager = salesManager;
	}
	public String getRejectNoteAM() {
		return RejectNoteAM;
	}
	public void setRejectNoteAM(String rejectNoteAM) {
		RejectNoteAM = rejectNoteAM;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getREGISTRATION_NO() {
		return REGISTRATION_NO;
	}
	public void setREGISTRATION_NO(String rEGISTRATION_NO) {
		REGISTRATION_NO = rEGISTRATION_NO;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getCONTACT_PERSON_NAME() {
		return CONTACT_PERSON_NAME;
	}
	public void setCONTACT_PERSON_NAME(String cONTACT_PERSON_NAME) {
		CONTACT_PERSON_NAME = cONTACT_PERSON_NAME;
	}
	public String getMOBILE_NO() {
		return MOBILE_NO;
	}
	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
	public String getTELEPHONE_NO() {
		return TELEPHONE_NO;
	}
	public void setTELEPHONE_NO(String tELEPHONE_NO) {
		TELEPHONE_NO = tELEPHONE_NO;
	}
	public String getMD_CEO_EMAIL_ID() {
		return MD_CEO_EMAIL_ID;
	}
	public void setMD_CEO_EMAIL_ID(String mD_CEO_EMAIL_ID) {
		MD_CEO_EMAIL_ID = mD_CEO_EMAIL_ID;
	}
	public String getSALES_EMAIL_ID() {
		return SALES_EMAIL_ID;
	}
	public void setSALES_EMAIL_ID(String sALES_EMAIL_ID) {
		SALES_EMAIL_ID = sALES_EMAIL_ID;
	}
	public String getSUPPORT_EMAIL_ID() {
		return SUPPORT_EMAIL_ID;
	}
	public void setSUPPORT_EMAIL_ID(String sUPPORT_EMAIL_ID) {
		SUPPORT_EMAIL_ID = sUPPORT_EMAIL_ID;
	}
	public String getEMAIL_ID_CONTACT_PERSON() {
		return EMAIL_ID_CONTACT_PERSON;
	}
	public void setEMAIL_ID_CONTACT_PERSON(String eMAIL_ID_CONTACT_PERSON) {
		EMAIL_ID_CONTACT_PERSON = eMAIL_ID_CONTACT_PERSON;
	}
	public String getEMAIL_ID_OFFICE() {
		return EMAIL_ID_OFFICE;
	}
	public void setEMAIL_ID_OFFICE(String eMAIL_ID_OFFICE) {
		EMAIL_ID_OFFICE = eMAIL_ID_OFFICE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getDISTRICT() {
		return DISTRICT;
	}
	public void setDISTRICT(String dISTRICT) {
		DISTRICT = dISTRICT;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getWEBSITE() {
		return WEBSITE;
	}
	public void setWEBSITE(String wEBSITE) {
		WEBSITE = wEBSITE;
	}
	public String getPAN_NO() {
		return PAN_NO;
	}
	public void setPAN_NO(String pAN_NO) {
		PAN_NO = pAN_NO;
	}
	public String getOWNERSHIP_TYPE() {
		return OWNERSHIP_TYPE;
	}
	public void setOWNERSHIP_TYPE(String oWNERSHIP_TYPE) {
		OWNERSHIP_TYPE = oWNERSHIP_TYPE;
	}
	public String getSCALE_OF_COMPANY() {
		return SCALE_OF_COMPANY;
	}
	public void setSCALE_OF_COMPANY(String sCALE_OF_COMPANY) {
		SCALE_OF_COMPANY = sCALE_OF_COMPANY;
	}
	public String getGSTIN() {
		return GSTIN;
	}
	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}
	public String getOTHER_COUNTRY_TAXNO() {
		return OTHER_COUNTRY_TAXNO;
	}
	public void setOTHER_COUNTRY_TAXNO(String oTHER_COUNTRY_TAXNO) {
		OTHER_COUNTRY_TAXNO = oTHER_COUNTRY_TAXNO;
	}
	public String getDETAILS_OF_DIRECTOR() {
		return DETAILS_OF_DIRECTOR;
	}
	public void setDETAILS_OF_DIRECTOR(String dETAILS_OF_DIRECTOR) {
		DETAILS_OF_DIRECTOR = dETAILS_OF_DIRECTOR;
	}
	public String getDATE_COMMENCEMENT_BUSSINESS() {
		return DATE_COMMENCEMENT_BUSSINESS;
	}
	public void setDATE_COMMENCEMENT_BUSSINESS(String dATE_COMMENCEMENT_BUSSINESS) {
		DATE_COMMENCEMENT_BUSSINESS = dATE_COMMENCEMENT_BUSSINESS;
	}
	public String getCURRENCY() {
		return CURRENCY;
	}
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	public String getYEAR1() {
		return YEAR1;
	}
	public void setYEAR1(String yEAR1) {
		YEAR1 = yEAR1;
	}
	public String getYEAR2() {
		return YEAR2;
	}
	public void setYEAR2(String yEAR2) {
		YEAR2 = yEAR2;
	}
	public String getYEAR3() {
		return YEAR3;
	}
	public void setYEAR3(String yEAR3) {
		YEAR3 = yEAR3;
	}
	public String getAMOUNT1() {
		return AMOUNT1;
	}
	public void setAMOUNT1(String aMOUNT1) {
		AMOUNT1 = aMOUNT1;
	}
	public String getAMOUNT2() {
		return AMOUNT2;
	}
	public void setAMOUNT2(String aMOUNT2) {
		AMOUNT2 = aMOUNT2;
	}
	public String getAMOUNT3() {
		return AMOUNT3;
	}
	public void setAMOUNT3(String aMOUNT3) {
		AMOUNT3 = aMOUNT3;
	}
	public String getREGISTERED_GEMPORTAL() {
		return REGISTERED_GEMPORTAL;
	}
	public void setREGISTERED_GEMPORTAL(String rEGISTERED_GEMPORTAL) {
		REGISTERED_GEMPORTAL = rEGISTERED_GEMPORTAL;
	}
	public String getREGISTERED_MSMED() {
		return REGISTERED_MSMED;
	}
	public void setREGISTERED_MSMED(String rEGISTERED_MSMED) {
		REGISTERED_MSMED = rEGISTERED_MSMED;
	}
	public String getENTREPRENEUR_MEMORANDUM() {
		return ENTREPRENEUR_MEMORANDUM;
	}
	public void setENTREPRENEUR_MEMORANDUM(String eNTREPRENEUR_MEMORANDUM) {
		ENTREPRENEUR_MEMORANDUM = eNTREPRENEUR_MEMORANDUM;
	}
	public String getINCORPORATION_CERTIFICATE() {
		return INCORPORATION_CERTIFICATE;
	}
	public void setINCORPORATION_CERTIFICATE(String iNCORPORATION_CERTIFICATE) {
		INCORPORATION_CERTIFICATE = iNCORPORATION_CERTIFICATE;
	}
	public String getPAN_CARD_FILE() {
		return PAN_CARD_FILE;
	}
	public void setPAN_CARD_FILE(String pAN_CARD_FILE) {
		PAN_CARD_FILE = pAN_CARD_FILE;
	}
	public String getGST_CERTIFICATE() {
		return GST_CERTIFICATE;
	}
	public void setGST_CERTIFICATE(String gST_CERTIFICATE) {
		GST_CERTIFICATE = gST_CERTIFICATE;
	}
	public String getMSMED_FILE() {
		return MSMED_FILE;
	}
	public void setMSMED_FILE(String mSMED_FILE) {
		MSMED_FILE = mSMED_FILE;
	}
	public String getCANCLE_CHECKED_FILE() {
		return CANCLE_CHECKED_FILE;
	}
	public void setCANCLE_CHECKED_FILE(String cANCLE_CHECKED_FILE) {
		CANCLE_CHECKED_FILE = cANCLE_CHECKED_FILE;
	}
	public String getLAST_YEAR_BS_PANDL() {
		return LAST_YEAR_BS_PANDL;
	}
	public void setLAST_YEAR_BS_PANDL(String lAST_YEAR_BS_PANDL) {
		LAST_YEAR_BS_PANDL = lAST_YEAR_BS_PANDL;
	}
	public String getMSMED_DOCUMENT_FILE() {
		return MSMED_DOCUMENT_FILE;
	}
	public void setMSMED_DOCUMENT_FILE(String mSMED_DOCUMENT_FILE) {
		MSMED_DOCUMENT_FILE = mSMED_DOCUMENT_FILE;
	}
	public String getCHECKER() {
		return CHECKER;
	}
	public void setCHECKER(String cHECKER) {
		CHECKER = cHECKER;
	}
	public String getAUTHORIZER() {
		return AUTHORIZER;
	}
	public void setAUTHORIZER(String aUTHORIZER) {
		AUTHORIZER = aUTHORIZER;
	}
	public String getVERIFIED_TICK_MARK() {
		return VERIFIED_TICK_MARK;
	}
	public void setVERIFIED_TICK_MARK(String vERIFIED_TICK_MARK) {
		VERIFIED_TICK_MARK = vERIFIED_TICK_MARK;
	}
	public String getCATEGORY_TYPE() {
		return CATEGORY_TYPE;
	}
	public void setCATEGORY_TYPE(String cATEGORY_TYPE) {
		CATEGORY_TYPE = cATEGORY_TYPE;
	}
	public String getDISTRIBUTOR_NAME() {
		return DISTRIBUTOR_NAME;
	}
	public void setDISTRIBUTOR_NAME(String dISTRIBUTOR_NAME) {
		DISTRIBUTOR_NAME = dISTRIBUTOR_NAME;
	}
	public String getPARTNER_NAME() {
		return PARTNER_NAME;
	}
	public void setPARTNER_NAME(String pARTNER_NAME) {
		PARTNER_NAME = pARTNER_NAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getApprovedBy() {
		return ApprovedBy;
	}
	public void setApprovedBy(String approvedBy) {
		ApprovedBy = approvedBy;
	}
	public String getApprovedDate() {
		return ApprovedDate;
	}
	public void setApprovedDate(String approvedDate) {
		ApprovedDate = approvedDate;
	}
	public String getSubmittedDate() {
		return SubmittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		SubmittedDate = submittedDate;
	}
	public String getSubmittedBy() {
		return SubmittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		SubmittedBy = submittedBy;
	}
	public String getCompany_MD() {
		return Company_MD;
	}
	public void setCompany_MD(String company_MD) {
		Company_MD = company_MD;
	}
	public String getRejectedBy() {
		return RejectedBy;
	}
	public void setRejectedBy(String rejectedBy) {
		RejectedBy = rejectedBy;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getEnd_Customer() {
		return End_Customer;
	}
	public void setEnd_Customer(String end_Customer) {
		End_Customer = end_Customer;
	}
	public int getBulkUp_ID() {
		return BulkUp_ID;
	}
	public void setBulkUp_ID(int bulkUp_ID) {
		BulkUp_ID = bulkUp_ID;
	}
	public String getRejectedDate() {
		return RejectedDate;
	}
	public void setRejectedDate(String rejectedDate) {
		RejectedDate = rejectedDate;
	}
	@Override
	public String toString() {
		return "RegistrationMaster [SR_NO=" + SR_NO + ", RF_id=" + RF_id + ", COMPANY_NAME=" + COMPANY_NAME
				+ ", REGISTRATION_NO=" + REGISTRATION_NO + ", ADDRESS=" + ADDRESS + ", CONTACT_PERSON_NAME="
				+ CONTACT_PERSON_NAME + ", MOBILE_NO=" + MOBILE_NO + ", TELEPHONE_NO=" + TELEPHONE_NO
				+ ", MD_CEO_EMAIL_ID=" + MD_CEO_EMAIL_ID + ", SALES_EMAIL_ID=" + SALES_EMAIL_ID + ", SUPPORT_EMAIL_ID="
				+ SUPPORT_EMAIL_ID + ", EMAIL_ID_CONTACT_PERSON=" + EMAIL_ID_CONTACT_PERSON + ", EMAIL_ID_OFFICE="
				+ EMAIL_ID_OFFICE + ", CITY=" + CITY + ", DISTRICT=" + DISTRICT + ", STATE=" + STATE + ", PIN=" + PIN
				+ ", COUNTRY=" + COUNTRY + ", WEBSITE=" + WEBSITE + ", PAN_NO=" + PAN_NO + ", OWNERSHIP_TYPE="
				+ OWNERSHIP_TYPE + ", SCALE_OF_COMPANY=" + SCALE_OF_COMPANY + ", GSTIN=" + GSTIN
				+ ", OTHER_COUNTRY_TAXNO=" + OTHER_COUNTRY_TAXNO + ", DETAILS_OF_DIRECTOR=" + DETAILS_OF_DIRECTOR
				+ ", DATE_COMMENCEMENT_BUSSINESS=" + DATE_COMMENCEMENT_BUSSINESS + ", CURRENCY=" + CURRENCY + ", YEAR1="
				+ YEAR1 + ", YEAR2=" + YEAR2 + ", YEAR3=" + YEAR3 + ", AMOUNT1=" + AMOUNT1 + ", AMOUNT2=" + AMOUNT2
				+ ", AMOUNT3=" + AMOUNT3 + ", REGISTERED_GEMPORTAL=" + REGISTERED_GEMPORTAL + ", REGISTERED_MSMED="
				+ REGISTERED_MSMED + ", ENTREPRENEUR_MEMORANDUM=" + ENTREPRENEUR_MEMORANDUM
				+ ", INCORPORATION_CERTIFICATE=" + INCORPORATION_CERTIFICATE + ", PAN_CARD_FILE=" + PAN_CARD_FILE
				+ ", GST_CERTIFICATE=" + GST_CERTIFICATE + ", MSMED_FILE=" + MSMED_FILE + ", CANCLE_CHECKED_FILE="
				+ CANCLE_CHECKED_FILE + ", LAST_YEAR_BS_PANDL=" + LAST_YEAR_BS_PANDL + ", MSMED_DOCUMENT_FILE="
				+ MSMED_DOCUMENT_FILE + ", CHECKER=" + CHECKER + ", AUTHORIZER=" + AUTHORIZER + ", VERIFIED_TICK_MARK="
				+ VERIFIED_TICK_MARK + ", CATEGORY_TYPE=" + CATEGORY_TYPE + ", DISTRIBUTOR_NAME=" + DISTRIBUTOR_NAME
				+ ", PARTNER_NAME=" + PARTNER_NAME + ", STATUS=" + STATUS + ", ApprovedBy=" + ApprovedBy
				+ ", ApprovedDate=" + ApprovedDate + ", SubmittedDate=" + SubmittedDate + ", SubmittedBy=" + SubmittedBy
				+ ", Company_MD=" + Company_MD + ", RejectedBy=" + RejectedBy + ", Customer_Name=" + Customer_Name
				+ ", End_Customer=" + End_Customer + ", BulkUp_ID=" + BulkUp_ID + ", RejectedDate=" + RejectedDate
				+ "]";
	}
	
	
	
	
	
}
