package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReviseManualProposal {

	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	private String vlx_id;
	private String vp_id;
	private String vlx_status;
	private String submittedby;
	private String submittedDate;
	private String checkedby;
	private String checkedDate;
	private String authorizedby;
	private String authorizedDate;
	private String PO_INITIATOR_NAME;
	private String PO_INITIATOR_CONTACTNO;
	private String FIRST_APPROVER_NAME;
	private String FIRST_APPROVER_CONTACTNO;
	private String SECOND_APPROVER_NAME;
	private String SECOND_APPROVER_CONTACTNO;
	private String CLIENT_NAME;
	private String VELOX_DESCRIPTION;
	private String SUB_TOTAL_A;
	private String INTEGRATE_DEPLOY_SUPPORT;
	private String CLOUD_DEPLOY_CHARGES;
	private String SUB_TOTAL_B;
	
	@Column(columnDefinition="TEXT")
	private String product_details;
	
    private	String VELOX_PROPOSAL_PATH ;
	private String rejectedBySM;
	private String rejectedSMDate;
	private String SMRejectedReason;
	private String SMNote;
	private String SInote;
	private String ReSendSIDate;
	private String ReSendBySI;
	private String RESOURCEAMOUNT;	
	private String ATC;
	
	private String PROPOSALTYPE;	
	private String PERPETUAL;
	private String SUBSCRIPTION;
	private String INTEGRATION_CHARGESYESNO;	
	private String INTEGRATIONCHARGE;	
	private String SUBTOTALC;	
	private String GST18PERCENTAGE;	
	private String GRAND_TOTAL;	
	private String rejectedByMD;
	private String rejectedMDDate;	
	private String MDRejectedReason;
	private String MDNote;
	private String ENDCUSTOMERNAME;
	private String PRODUCT_SUITNAME;
	private String FIXEDyEAR;
	private String PRODUCT_SUIT_VERSION;
	
	
	private String ReviseManualProposalVersion;
	private String SubscriptionAndPerpetualYear;
	private String CONTACTPERSON;
	private String ManualAmount;
	
	
	
	
	
	public String getReviseManualProposalVersion() {
		return ReviseManualProposalVersion;
	}
	public void setReviseManualProposalVersion(String reviseManualProposalVersion) {
		ReviseManualProposalVersion = reviseManualProposalVersion;
	}
	public String getSubscriptionAndPerpetualYear() {
		return SubscriptionAndPerpetualYear;
	}
	public void setSubscriptionAndPerpetualYear(String subscriptionAndPerpetualYear) {
		SubscriptionAndPerpetualYear = subscriptionAndPerpetualYear;
	}
	public String getCONTACTPERSON() {
		return CONTACTPERSON;
	}
	public void setCONTACTPERSON(String cONTACTPERSON) {
		CONTACTPERSON = cONTACTPERSON;
	}
	public String getManualAmount() {
		return ManualAmount;
	}
	public void setManualAmount(String manualAmount) {
		ManualAmount = manualAmount;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getVlx_id() {
		return vlx_id;
	}
	public void setVlx_id(String vlx_id) {
		this.vlx_id = vlx_id;
	}
	public String getVp_id() {
		return vp_id;
	}
	public void setVp_id(String vp_id) {
		this.vp_id = vp_id;
	}
	public String getVlx_status() {
		return vlx_status;
	}
	public void setVlx_status(String vlx_status) {
		this.vlx_status = vlx_status;
	}
	public String getSubmittedby() {
		return submittedby;
	}
	public void setSubmittedby(String submittedby) {
		this.submittedby = submittedby;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	
	public String getReviseProposalVersion() {
		return ReviseManualProposalVersion;
	}
	public void setReviseProposalVersion(String reviseProposalVersion) {
		ReviseManualProposalVersion = reviseProposalVersion;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getCheckedby() {
		return checkedby;
	}
	public void setCheckedby(String checkedby) {
		this.checkedby = checkedby;
	}
	public String getCheckedDate() {
		return checkedDate;
	}
	public void setCheckedDate(String checkedDate) {
		this.checkedDate = checkedDate;
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
	public String getPO_INITIATOR_NAME() {
		return PO_INITIATOR_NAME;
	}
	public void setPO_INITIATOR_NAME(String pO_INITIATOR_NAME) {
		PO_INITIATOR_NAME = pO_INITIATOR_NAME;
	}
	public String getPO_INITIATOR_CONTACTNO() {
		return PO_INITIATOR_CONTACTNO;
	}
	public void setPO_INITIATOR_CONTACTNO(String pO_INITIATOR_CONTACTNO) {
		PO_INITIATOR_CONTACTNO = pO_INITIATOR_CONTACTNO;
	}
	public String getFIRST_APPROVER_NAME() {
		return FIRST_APPROVER_NAME;
	}
	public void setFIRST_APPROVER_NAME(String fIRST_APPROVER_NAME) {
		FIRST_APPROVER_NAME = fIRST_APPROVER_NAME;
	}
	public String getFIRST_APPROVER_CONTACTNO() {
		return FIRST_APPROVER_CONTACTNO;
	}
	public void setFIRST_APPROVER_CONTACTNO(String fIRST_APPROVER_CONTACTNO) {
		FIRST_APPROVER_CONTACTNO = fIRST_APPROVER_CONTACTNO;
	}
	public String getSECOND_APPROVER_NAME() {
		return SECOND_APPROVER_NAME;
	}
	public void setSECOND_APPROVER_NAME(String sECOND_APPROVER_NAME) {
		SECOND_APPROVER_NAME = sECOND_APPROVER_NAME;
	}
	public String getSECOND_APPROVER_CONTACTNO() {
		return SECOND_APPROVER_CONTACTNO;
	}
	public void setSECOND_APPROVER_CONTACTNO(String sECOND_APPROVER_CONTACTNO) {
		SECOND_APPROVER_CONTACTNO = sECOND_APPROVER_CONTACTNO;
	}
	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}
	public void setCLIENT_NAME(String cLIENT_NAME) {
		CLIENT_NAME = cLIENT_NAME;
	}
	public String getVELOX_DESCRIPTION() {
		return VELOX_DESCRIPTION;
	}
	public void setVELOX_DESCRIPTION(String vELOX_DESCRIPTION) {
		VELOX_DESCRIPTION = vELOX_DESCRIPTION;
	}
	public String getSUB_TOTAL_A() {
		return SUB_TOTAL_A;
	}
	public void setSUB_TOTAL_A(String sUB_TOTAL_A) {
		SUB_TOTAL_A = sUB_TOTAL_A;
	}
	public String getINTEGRATE_DEPLOY_SUPPORT() {
		return INTEGRATE_DEPLOY_SUPPORT;
	}
	public void setINTEGRATE_DEPLOY_SUPPORT(String iNTEGRATE_DEPLOY_SUPPORT) {
		INTEGRATE_DEPLOY_SUPPORT = iNTEGRATE_DEPLOY_SUPPORT;
	}
	public String getCLOUD_DEPLOY_CHARGES() {
		return CLOUD_DEPLOY_CHARGES;
	}
	public void setCLOUD_DEPLOY_CHARGES(String cLOUD_DEPLOY_CHARGES) {
		CLOUD_DEPLOY_CHARGES = cLOUD_DEPLOY_CHARGES;
	}
	public String getSUB_TOTAL_B() {
		return SUB_TOTAL_B;
	}
	public void setSUB_TOTAL_B(String sUB_TOTAL_B) {
		SUB_TOTAL_B = sUB_TOTAL_B;
	}
	public String getProduct_details() {
		return product_details;
	}
	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}
	public String getVELOX_PROPOSAL_PATH() {
		return VELOX_PROPOSAL_PATH;
	}
	public void setVELOX_PROPOSAL_PATH(String vELOX_PROPOSAL_PATH) {
		VELOX_PROPOSAL_PATH = vELOX_PROPOSAL_PATH;
	}
	public String getRejectedBySM() {
		return rejectedBySM;
	}
	public void setRejectedBySM(String rejectedBySM) {
		this.rejectedBySM = rejectedBySM;
	}
	public String getRejectedSMDate() {
		return rejectedSMDate;
	}
	public void setRejectedSMDate(String rejectedSMDate) {
		this.rejectedSMDate = rejectedSMDate;
	}
	public String getSMRejectedReason() {
		return SMRejectedReason;
	}
	public void setSMRejectedReason(String sMRejectedReason) {
		SMRejectedReason = sMRejectedReason;
	}
	public String getSMNote() {
		return SMNote;
	}
	public void setSMNote(String sMNote) {
		SMNote = sMNote;
	}
	public String getSInote() {
		return SInote;
	}
	public void setSInote(String sInote) {
		SInote = sInote;
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
	public String getRESOURCEAMOUNT() {
		return RESOURCEAMOUNT;
	}
	public void setRESOURCEAMOUNT(String rESOURCEAMOUNT) {
		RESOURCEAMOUNT = rESOURCEAMOUNT;
	}
	public String getATC() {
		return ATC;
	}
	public void setATC(String aTC) {
		ATC = aTC;
	}
	public String getPROPOSALTYPE() {
		return PROPOSALTYPE;
	}
	public void setPROPOSALTYPE(String pROPOSALTYPE) {
		PROPOSALTYPE = pROPOSALTYPE;
	}
	public String getPERPETUAL() {
		return PERPETUAL;
	}
	public void setPERPETUAL(String pERPETUAL) {
		PERPETUAL = pERPETUAL;
	}
	public String getSUBSCRIPTION() {
		return SUBSCRIPTION;
	}
	public void setSUBSCRIPTION(String sUBSCRIPTION) {
		SUBSCRIPTION = sUBSCRIPTION;
	}
	public String getINTEGRATION_CHARGESYESNO() {
		return INTEGRATION_CHARGESYESNO;
	}
	public void setINTEGRATION_CHARGESYESNO(String iNTEGRATION_CHARGESYESNO) {
		INTEGRATION_CHARGESYESNO = iNTEGRATION_CHARGESYESNO;
	}
	public String getINTEGRATIONCHARGE() {
		return INTEGRATIONCHARGE;
	}
	public void setINTEGRATIONCHARGE(String iNTEGRATIONCHARGE) {
		INTEGRATIONCHARGE = iNTEGRATIONCHARGE;
	}
	public String getSUBTOTALC() {
		return SUBTOTALC;
	}
	public void setSUBTOTALC(String sUBTOTALC) {
		SUBTOTALC = sUBTOTALC;
	}
	public String getGST18PERCENTAGE() {
		return GST18PERCENTAGE;
	}
	public void setGST18PERCENTAGE(String gST18PERCENTAGE) {
		GST18PERCENTAGE = gST18PERCENTAGE;
	}
	public String getGRAND_TOTAL() {
		return GRAND_TOTAL;
	}
	public void setGRAND_TOTAL(String gRAND_TOTAL) {
		GRAND_TOTAL = gRAND_TOTAL;
	}
	public String getRejectedByMD() {
		return rejectedByMD;
	}
	public void setRejectedByMD(String rejectedByMD) {
		this.rejectedByMD = rejectedByMD;
	}
	public String getRejectedMDDate() {
		return rejectedMDDate;
	}
	public void setRejectedMDDate(String rejectedMDDate) {
		this.rejectedMDDate = rejectedMDDate;
	}
	public String getMDRejectedReason() {
		return MDRejectedReason;
	}
	public void setMDRejectedReason(String mDRejectedReason) {
		MDRejectedReason = mDRejectedReason;
	}
	public String getMDNote() {
		return MDNote;
	}
	public void setMDNote(String mDNote) {
		MDNote = mDNote;
	}
	public String getENDCUSTOMERNAME() {
		return ENDCUSTOMERNAME;
	}
	public void setENDCUSTOMERNAME(String eNDCUSTOMERNAME) {
		ENDCUSTOMERNAME = eNDCUSTOMERNAME;
	}
	public String getPRODUCT_SUITNAME() {
		return PRODUCT_SUITNAME;
	}
	public void setPRODUCT_SUITNAME(String pRODUCT_SUITNAME) {
		PRODUCT_SUITNAME = pRODUCT_SUITNAME;
	}
	public String getFIXEDyEAR() {
		return FIXEDyEAR;
	}
	public void setFIXEDyEAR(String fIXEDyEAR) {
		FIXEDyEAR = fIXEDyEAR;
	}
	public String getPRODUCT_SUIT_VERSION() {
		return PRODUCT_SUIT_VERSION;
	}
	public void setPRODUCT_SUIT_VERSION(String pRODUCT_SUIT_VERSION) {
		PRODUCT_SUIT_VERSION = pRODUCT_SUIT_VERSION;
	}
	
	@Override
	public String toString() {
		return "ReviseManualProposal [SR_NO=" + SR_NO + ", vlx_id=" + vlx_id + ", vp_id=" + vp_id + ", vlx_status="
				+ vlx_status + ", submittedby=" + submittedby + ", submittedDate=" + submittedDate + ", checkedby="
				+ checkedby + ", checkedDate=" + checkedDate + ", authorizedby=" + authorizedby + ", authorizedDate="
				+ authorizedDate + ", PO_INITIATOR_NAME=" + PO_INITIATOR_NAME + ", PO_INITIATOR_CONTACTNO="
				+ PO_INITIATOR_CONTACTNO + ", FIRST_APPROVER_NAME=" + FIRST_APPROVER_NAME
				+ ", FIRST_APPROVER_CONTACTNO=" + FIRST_APPROVER_CONTACTNO + ", SECOND_APPROVER_NAME="
				+ SECOND_APPROVER_NAME + ", SECOND_APPROVER_CONTACTNO=" + SECOND_APPROVER_CONTACTNO + ", CLIENT_NAME="
				+ CLIENT_NAME + ", VELOX_DESCRIPTION=" + VELOX_DESCRIPTION + ", SUB_TOTAL_A=" + SUB_TOTAL_A
				+ ", INTEGRATE_DEPLOY_SUPPORT=" + INTEGRATE_DEPLOY_SUPPORT + ", CLOUD_DEPLOY_CHARGES="
				+ CLOUD_DEPLOY_CHARGES + ", SUB_TOTAL_B=" + SUB_TOTAL_B + ", product_details=" + product_details
				+ ", VELOX_PROPOSAL_PATH=" + VELOX_PROPOSAL_PATH + ", rejectedBySM=" + rejectedBySM
				+ ", rejectedSMDate=" + rejectedSMDate + ", SMRejectedReason=" + SMRejectedReason + ", SMNote=" + SMNote
				+ ", SInote=" + SInote + ", ReSendSIDate=" + ReSendSIDate + ", ReSendBySI=" + ReSendBySI
				+ ", RESOURCEAMOUNT=" + RESOURCEAMOUNT + ", ATC=" + ATC + ", PROPOSALTYPE=" + PROPOSALTYPE
				+ ", PERPETUAL=" + PERPETUAL + ", SUBSCRIPTION=" + SUBSCRIPTION + ", INTEGRATION_CHARGESYESNO="
				+ INTEGRATION_CHARGESYESNO + ", INTEGRATIONCHARGE=" + INTEGRATIONCHARGE + ", SUBTOTALC=" + SUBTOTALC
				+ ", GST18PERCENTAGE=" + GST18PERCENTAGE + ", GRAND_TOTAL=" + GRAND_TOTAL + ", rejectedByMD="
				+ rejectedByMD + ", rejectedMDDate=" + rejectedMDDate + ", MDRejectedReason=" + MDRejectedReason
				+ ", MDNote=" + MDNote + ", ENDCUSTOMERNAME=" + ENDCUSTOMERNAME + ", PRODUCT_SUITNAME="
				+ PRODUCT_SUITNAME + ", FIXEDyEAR=" + FIXEDyEAR + ", PRODUCT_SUIT_VERSION=" + PRODUCT_SUIT_VERSION
				+ ", ReviseManualProposalVersion=" + ReviseManualProposalVersion + ", SubscriptionAndPerpetualYear="
				+ SubscriptionAndPerpetualYear + ", CONTACTPERSON=" + CONTACTPERSON + ", ManualAmount=" + ManualAmount
				+ "]";
	}
	
	
	
	
}
