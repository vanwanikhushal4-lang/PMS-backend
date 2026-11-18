package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PurchaseOrder")
public class PurchaseOrder {

	private static final long serialVersionUID = -1722684944868971448L;
	@Id
	@Column()
	private int SR_NO;
	
	@Column(length = 5000)
	private String ImplementorFormC;
	
	private String poraisedate;
	private String purchaseOrderType;
	private String purchaseNumber;
	private String purchaseDate;
	private String amcStartDate;
	private String amcEndDate;
	private String pouploadfile;
	private String proddescrip;
    private String customername;
	private String paymentterms;
	private String prodliscense;
	private String prodamount;
	private String warrantystart;
	private String warrantyend;
	private String advaninvoice;
	private String advinvoicefile;
	private String submittedby;
	
	
	private String productFeaturedFileList;

	private String vlx_id;
	private String vlx_status;
	private String Form3_status;
	private String approvedby;
	private String approveddate;
	private String ProductSuitName;
	private String SecurityToolName;
	private String Company_MD;
	private String FormAB_status;
	
	private String formABfillby;
	private String formABfilldate;
	
	
	private String proposal_type;
	private String proposal_id;
	private String proposal_file;
	private String warranty_month;
	private String warranty_year;
	private String amc_month;
	private String amc_year;
	private String SI_Note;
	private String SM_Note;
	private String AM_Note;
	private String tennure_start;
	private String tennure_end;
	private String tennure_month;
	private String tennure_year;
	private String PO_First_Approver;
	private String PO_Second_Approver;
	
	
	private String fixedYear;
	private String subscriptionYear;
	private String perpetualYear;
	private String SMRejectedReason;
	private String RejectedBySM;
	private String RejectedSMDate;
	
	
	private String MassPOFile;
	
	private String invoiceFile;
	private String attendanceFile;
	private String calculationFile;
	private String customerEmail;
	private String subscriptionANDperpetualYear;
	private String poReference_No;
	
	private String manualPOAddRowData;
	
	
	//13/09
	private String endCustomer;
	//
	
	
	private String KOM_Status;
	
	
	
	public String getEndCustomer() {
		return endCustomer;
	}

	public void setEndCustomer(String endCustomer) {
		this.endCustomer = endCustomer;
	}
	
	

	public String getManualPOAddRowData() {
		return manualPOAddRowData;
	}

	public void setManualPOAddRowData(String manualPOAddRowData) {
		this.manualPOAddRowData = manualPOAddRowData;
	}

	public String getPoReference_No() {
		return poReference_No;
	}

	public void setPoReference_No(String poReference_No) {
		this.poReference_No = poReference_No;
	}

	public String getSubscriptionANDperpetualYear() {
		return subscriptionANDperpetualYear;
	}

	public void setSubscriptionANDperpetualYear(String subscriptionANDperpetualYear) {
		this.subscriptionANDperpetualYear = subscriptionANDperpetualYear;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getInvoiceFile() {
		return invoiceFile;
	}

	public void setInvoiceFile(String invoiceFile) {
		this.invoiceFile = invoiceFile;
	}

	public String getAttendanceFile() {
		return attendanceFile;
	}

	public void setAttendanceFile(String attendanceFile) {
		this.attendanceFile = attendanceFile;
	}

	public String getCalculationFile() {
		return calculationFile;
	}

	public void setCalculationFile(String calculationFile) {
		this.calculationFile = calculationFile;
	}

	public String getMassPOFile() {
		return MassPOFile;
	}

	public void setMassPOFile(String massPOFile) {
		MassPOFile = massPOFile;
	}

	public String getFixedYear() {
		return fixedYear;
	}

	public String getProductFeaturedFileList() {
		return productFeaturedFileList;
	}

	public void setProductFeaturedFileList(String productFeaturedFileList) {
		this.productFeaturedFileList = productFeaturedFileList;
	}

	public void setFixedYear(String fixedYear) {
		this.fixedYear = fixedYear;
	}

	public String getSubscriptionYear() {
		return subscriptionYear;
	}

	public void setSubscriptionYear(String subscriptionYear) {
		this.subscriptionYear = subscriptionYear;
	}

	public String getPerpetualYear() {
		return perpetualYear;
	}

	public void setPerpetualYear(String perpetualYear) {
		this.perpetualYear = perpetualYear;
	}

	public String getPO_Second_Approver() {
		return PO_Second_Approver;
	}

	public void setPO_Second_Approver(String pO_Second_Approver) {
		PO_Second_Approver = pO_Second_Approver;
	}

	public String getAM_Note() {
		return AM_Note;
	}

	public void setAM_Note(String aM_Note) {
		AM_Note = aM_Note;
	}

	public String getSM_Note() {
		return SM_Note;
	}

	public void setSM_Note(String sM_Note) {
		SM_Note = sM_Note;
	}

	public String getTennure_start() {
		return tennure_start;
	}

	public void setTennure_start(String tennure_start) {
		this.tennure_start = tennure_start;
	}

	public String getTennure_end() {
		return tennure_end;
	}

	public void setTennure_end(String tennure_end) {
		this.tennure_end = tennure_end;
	}

	public String getTennure_month() {
		return tennure_month;
	}

	public void setTennure_month(String tennure_month) {
		this.tennure_month = tennure_month;
	}

	public String getTennure_year() {
		return tennure_year;
	}

	public void setTennure_year(String tennure_year) {
		this.tennure_year = tennure_year;
	}

	public String getProposal_type() {
		return proposal_type;
	}

	public void setProposal_type(String proposal_type) {
		this.proposal_type = proposal_type;
	}

	public String getProposal_id() {
		return proposal_id;
	}

	public void setProposal_id(String proposal_id) {
		this.proposal_id = proposal_id;
	}

	public String getProposal_file() {
		return proposal_file;
	}

	public void setProposal_file(String proposal_file) {
		this.proposal_file = proposal_file;
	}

	public String getWarranty_month() {
		return warranty_month;
	}

	public void setWarranty_month(String warranty_month) {
		this.warranty_month = warranty_month;
	}

	public String getWarranty_year() {
		return warranty_year;
	}

	public void setWarranty_year(String warranty_year) {
		this.warranty_year = warranty_year;
	}

	public String getAmc_month() {
		return amc_month;
	}

	public void setAmc_month(String amc_month) {
		this.amc_month = amc_month;
	}

	public String getAmc_year() {
		return amc_year;
	}

	public void setAmc_year(String amc_year) {
		this.amc_year = amc_year;
	}

	public String getSI_Note() {
		return SI_Note;
	}

	public void setSI_Note(String sI_Note) {
		SI_Note = sI_Note;
	}

	@Column(nullable=true, name="BulkUp_ID")
	private int BulkUp_ID;

	public int getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}

	public String getPoraisedate() {
		return poraisedate;
	}

	public void setPoraisedate(String poraisedate) {
		this.poraisedate = poraisedate;
	}

	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}

	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public String getFormAB_status() {
		return FormAB_status;
	}

	public void setFormAB_status(String formAB_status) {
		FormAB_status = formAB_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getAmcStartDate() {
		return amcStartDate;
	}

	public void setAmcStartDate(String amcStartDate) {
		this.amcStartDate = amcStartDate;
	}

	public String getAmcEndDate() {
		return amcEndDate;
	}

	public void setAmcEndDate(String amcEndDate) {
		this.amcEndDate = amcEndDate;
	}

	public String getPouploadfile() {
		return pouploadfile;
	}

	public void setPouploadfile(String pouploadfile) {
		this.pouploadfile = pouploadfile;
	}

	public String getProddescrip() {
		return proddescrip;
	}

	public void setProddescrip(String proddescrip) {
		this.proddescrip = proddescrip;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPaymentterms() {
		return paymentterms;
	}

	public void setPaymentterms(String paymentterms) {
		this.paymentterms = paymentterms;
	}

	public String getProdliscense() {
		return prodliscense;
	}

	public void setProdliscense(String prodliscense) {
		this.prodliscense = prodliscense;
	}

	public String getProdamount() {
		return prodamount;
	}

	public void setProdamount(String prodamount) {
		this.prodamount = prodamount;
	}

	public String getWarrantystart() {
		return warrantystart;
	}

	public void setWarrantystart(String warrantystart) {
		this.warrantystart = warrantystart;
	}

	public String getWarrantyend() {
		return warrantyend;
	}

	public void setWarrantyend(String warrantyend) {
		this.warrantyend = warrantyend;
	}

	public String getAdvaninvoice() {
		return advaninvoice;
	}

	public void setAdvaninvoice(String advaninvoice) {
		this.advaninvoice = advaninvoice;
	}

	public String getAdvinvoicefile() {
		return advinvoicefile;
	}

	public void setAdvinvoicefile(String advinvoicefile) {
		this.advinvoicefile = advinvoicefile;
	}

	public String getSubmittedby() {
		return submittedby;
	}

	public void setSubmittedby(String submittedby) {
		this.submittedby = submittedby;
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

	public String getForm3_status() {
		return Form3_status;
	}

	public void setForm3_status(String form3_status) {
		Form3_status = form3_status;
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

	public String getProductSuitName() {
		return ProductSuitName;
	}

	public void setProductSuitName(String productSuitName) {
		ProductSuitName = productSuitName;
	}

	public String getSecurityToolName() {
		return SecurityToolName;
	}

	public void setSecurityToolName(String securityToolName) {
		SecurityToolName = securityToolName;
	}

	public String getCompany_MD() {
		return Company_MD;
	}

	public void setCompany_MD(String company_MD) {
		Company_MD = company_MD;
	}

	public int getBulkUp_ID() {
		return BulkUp_ID;
	}

	public void setBulkUp_ID(int bulkUp_ID) {
		BulkUp_ID = bulkUp_ID;
	}
	public String getImplementorFormC() {
		return ImplementorFormC;
	}

	public void setImplementorFormC(String implementorFormC) {
		ImplementorFormC = implementorFormC;
	}
	
	
	
	
	
	public String getSMRejectedReason() {
		return SMRejectedReason;
	}

	public void setSMRejectedReason(String sMRejectedReason) {
		SMRejectedReason = sMRejectedReason;
	}

	public String getRejectedBySM() {
		return RejectedBySM;
	}

	public void setRejectedBySM(String rejectedBySM) {
		RejectedBySM = rejectedBySM;
	}

	public String getRejectedSMDate() {
		return RejectedSMDate;
	}

	public void setRejectedSMDate(String rejectedSMDate) {
		RejectedSMDate = rejectedSMDate;
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

	public String getPO_First_Approver() {
		return PO_First_Approver;
	}

	public void setPO_First_Approver(String pO_First_Approver) {
		PO_First_Approver = pO_First_Approver;
	}

	public String getKOM_Status() {
		return KOM_Status;
	}

	public void setKOM_Status(String kOM_Status) {
		KOM_Status = kOM_Status;
	}

	
	@Override
	public String toString() {
		return "PurchaseOrder [SR_NO=" + SR_NO + ", ImplementorFormC=" + ImplementorFormC + ", poraisedate="
				+ poraisedate + ", purchaseOrderType=" + purchaseOrderType + ", purchaseNumber=" + purchaseNumber
				+ ", purchaseDate=" + purchaseDate + ", amcStartDate=" + amcStartDate + ", amcEndDate=" + amcEndDate
				+ ", pouploadfile=" + pouploadfile + ", proddescrip=" + proddescrip + ", customername=" + customername
				+ ", paymentterms=" + paymentterms + ", prodliscense=" + prodliscense + ", prodamount=" + prodamount
				+ ", warrantystart=" + warrantystart + ", warrantyend=" + warrantyend + ", advaninvoice=" + advaninvoice
				+ ", advinvoicefile=" + advinvoicefile + ", submittedby=" + submittedby + ", productFeaturedFileList="
				+ productFeaturedFileList + ", vlx_id=" + vlx_id + ", vlx_status=" + vlx_status + ", Form3_status="
				+ Form3_status + ", approvedby=" + approvedby + ", approveddate=" + approveddate + ", ProductSuitName="
				+ ProductSuitName + ", SecurityToolName=" + SecurityToolName + ", Company_MD=" + Company_MD
				+ ", FormAB_status=" + FormAB_status + ", formABfillby=" + formABfillby + ", formABfilldate="
				+ formABfilldate + ", proposal_type=" + proposal_type + ", proposal_id=" + proposal_id
				+ ", proposal_file=" + proposal_file + ", warranty_month=" + warranty_month + ", warranty_year="
				+ warranty_year + ", amc_month=" + amc_month + ", amc_year=" + amc_year + ", SI_Note=" + SI_Note
				+ ", SM_Note=" + SM_Note + ", AM_Note=" + AM_Note + ", tennure_start=" + tennure_start
				+ ", tennure_end=" + tennure_end + ", tennure_month=" + tennure_month + ", tennure_year=" + tennure_year
				+ ", PO_First_Approver=" + PO_First_Approver + ", PO_Second_Approver=" + PO_Second_Approver
				+ ", fixedYear=" + fixedYear + ", subscriptionYear=" + subscriptionYear + ", perpetualYear="
				+ perpetualYear + ", SMRejectedReason=" + SMRejectedReason + ", RejectedBySM=" + RejectedBySM
				+ ", RejectedSMDate=" + RejectedSMDate + ", MassPOFile=" + MassPOFile + ", invoiceFile=" + invoiceFile
				+ ", attendanceFile=" + attendanceFile + ", calculationFile=" + calculationFile + ", customerEmail="
				+ customerEmail + ", subscriptionANDperpetualYear=" + subscriptionANDperpetualYear + ", poReference_No="
				+ poReference_No + ", manualPOAddRowData=" + manualPOAddRowData + ", endCustomer=" + endCustomer
				+ ", KOM_Status=" + KOM_Status + ", BulkUp_ID=" + BulkUp_ID + "]";
	}


	
	
	
	
	
	
	
	
	
	
}
