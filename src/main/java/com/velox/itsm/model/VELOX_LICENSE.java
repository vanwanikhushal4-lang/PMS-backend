package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VELOX_LICENSE")
public class VELOX_LICENSE
{
	
	private static final long serialVersionUID = -2469894830441779556L;
	
	@Id
	@Column(name = "SR_NO")
	private int SR_NO;
	
	@Column(columnDefinition="TEXT")
	private String PRODUCT_DETAILS;
	private String SPPLIERNAMELICENSE;
	private String CLIENTNAME;
	private String ENVIRONMENTKEYNO;
	private String PONUMBER;
	private String PODATE;
	private String LICENSE_STATUS;
	
	private String CLIENTADDRESS;
	private String OEMADDRESS;
	private String ENDCUSTOMERNAME;
	private String ENDCUSTOMEREMAIL;
	
	private String MAKER;
	private String CHECKER;
	private String AUTHORIZER;
	private String SMRejectedReason;
	private String MDRejectedReason;
	
	private String CMSTATUS;
	
	//06/06
	private String LICENSEFORNAME;
	//
	
	public String getSMRejectedReason() {
		return SMRejectedReason;
	}
	
	//06/06
	public String getLICENSEFORNAME() {
		return LICENSEFORNAME;
	}
	public void setLICENSEFORNAME(String lICENSEFORNAME) {
		LICENSEFORNAME = lICENSEFORNAME;
	}
	//
	
	public String getCMSTATUS() {
		return CMSTATUS;
	}
	public void setCMSTATUS(String cMSTATUS) {
		CMSTATUS = cMSTATUS;
	}
	public void setSMRejectedReason(String sMRejectedReason) {
		SMRejectedReason = sMRejectedReason;
	}
	public String getMDRejectedReason() {
		return MDRejectedReason;
	}
	public void setMDRejectedReason(String mDRejectedReason) {
		MDRejectedReason = mDRejectedReason;
	}
	private String VP_ID;
	private String VL_STATUS;
	
	private String RaiseDate;
	
	private String PO_ID;
	
	   private String CheckedBy;
		private String CheckedDate;
		
    private String AuthorizedBy;
	private String AuthorizedDate;
	private String SMNote;
	private String BHNote;
	private String MDNote;
	
	private String rejectedSMDate;
	private String rejectedMDDate;
	
	
	public String getRejectedSMDate() {
		return rejectedSMDate;
	}
	public void setRejectedSMDate(String rejectedSMDate) {
		this.rejectedSMDate = rejectedSMDate;
	}
	public String getRejectedMDDate() {
		return rejectedMDDate;
	}
	public void setRejectedMDDate(String rejectedMDDate) {
		this.rejectedMDDate = rejectedMDDate;
	}
	public String getMDNote() {
		return MDNote;
	}
	public void setMDNote(String mDNote) {
		MDNote = mDNote;
	}
	private String Payment_status;
	private String uploadfile;
	
	private String distributor;
	private String partner1;
	private String partner2;
	
	
	
	public String getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getBHNote() {
		return BHNote;
	}
	public void setBHNote(String bHNote) {
		BHNote = bHNote;
	}
	public String getCheckedBy() {
		return CheckedBy;
	}
	public void setCheckedBy(String checkedBy) {
		CheckedBy = checkedBy;
	}
	public String getCheckedDate() {
		return CheckedDate;
	}
	public void setCheckedDate(String checkedDate) {
		CheckedDate = checkedDate;
	}
	public String getAuthorizedBy() {
		return AuthorizedBy;
	}
	public void setAuthorizedBy(String authorizedBy) {
		AuthorizedBy = authorizedBy;
	}
	public String getAuthorizedDate() {
		return AuthorizedDate;
	}
	public void setAuthorizedDate(String authorizedDate) {
		AuthorizedDate = authorizedDate;
	}
	public String getSMNote() {
		return SMNote;
	}
	public void setSMNote(String sMNote) {
		SMNote = sMNote;
	}
	public String getPO_ID() {
		return PO_ID;
	}
	public void setPO_ID(String pO_ID) {
		PO_ID = pO_ID;
	}
	public String getRaiseDate() {
		return RaiseDate;
	}
	public void setRaiseDate(String raiseDate) {
		RaiseDate = raiseDate;
	}
	public String getVL_STATUS() {
		return VL_STATUS;
	}
	public void setVL_STATUS(String vL_STATUS) {
		VL_STATUS = vL_STATUS;
	}
	public String getMAKER() {
		return MAKER;
	}
	public void setMAKER(String mAKER) {
		MAKER = mAKER;
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
	public String getVP_ID() {
		return VP_ID;
	}
	public void setVP_ID(String vP_ID) {
		VP_ID = vP_ID;
	}
	public String getCLIENTADDRESS() {
		return CLIENTADDRESS;
	}
	public void setCLIENTADDRESS(String cLIENTADDRESS) {
		CLIENTADDRESS = cLIENTADDRESS;
	}
	public String getOEMADDRESS() {
		return OEMADDRESS;
	}
	public void setOEMADDRESS(String oEMADDRESS) {
		OEMADDRESS = oEMADDRESS;
	}
	public String getENDCUSTOMERNAME() {
		return ENDCUSTOMERNAME;
	}
	public void setENDCUSTOMERNAME(String eNDCUSTOMERNAME) {
		ENDCUSTOMERNAME = eNDCUSTOMERNAME;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLICENSE_STATUS() {
		return LICENSE_STATUS;
	}
	public void setLICENSE_STATUS(String lICENSE_STATUS) {
		LICENSE_STATUS = lICENSE_STATUS;
	}
	public int getSR_NO() {
		return SR_NO;
	}
	public void setSR_NO(int sR_NO) {
		SR_NO = sR_NO;
	}
	public String getPRODUCT_DETAILS() {
		return PRODUCT_DETAILS;
	}
	public void setPRODUCT_DETAILS(String pRODUCT_DETAILS) {
		PRODUCT_DETAILS = pRODUCT_DETAILS;
	}
	public String getSPPLIERNAMELICENSE() {
		return SPPLIERNAMELICENSE;
	}
	public void setSPPLIERNAMELICENSE(String sPPLIERNAMELICENSE) {
		SPPLIERNAMELICENSE = sPPLIERNAMELICENSE;
	}
	public String getCLIENTNAME() {
		return CLIENTNAME;
	}
	public void setCLIENTNAME(String cLIENTNAME) {
		CLIENTNAME = cLIENTNAME;
	}
	public String getENVIRONMENTKEYNO() {
		return ENVIRONMENTKEYNO;
	}
	public void setENVIRONMENTKEYNO(String eNVIRONMENTKEYNO) {
		ENVIRONMENTKEYNO = eNVIRONMENTKEYNO;
	}
	public String getPONUMBER() {
		return PONUMBER;
	}
	public void setPONUMBER(String pONUMBER) {
		PONUMBER = pONUMBER;
	}
	public String getPODATE() {
		return PODATE;
	}
	public void setPODATE(String pODATE) {
		PODATE = pODATE;
	}
	
	public String getPayment_status() {
		return Payment_status;
	}
	public void setPayment_status(String payment_status) {
		Payment_status = payment_status;
	}
		
	public String getENDCUSTOMEREMAIL() {
		return ENDCUSTOMEREMAIL;
	}
	public void setENDCUSTOMEREMAIL(String eNDCUSTOMEREMAIL) {
		ENDCUSTOMEREMAIL = eNDCUSTOMEREMAIL;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getPartner1() {
		return partner1;
	}

	public void setPartner1(String partner1) {
		this.partner1 = partner1;
	}

	public String getPartner2() {
		return partner2;
	}

	public void setPartner2(String partner2) {
		this.partner2 = partner2;
	}

	@Override
	public String toString() {
		return "VELOX_LICENSE [SR_NO=" + SR_NO + ", PRODUCT_DETAILS=" + PRODUCT_DETAILS + ", SPPLIERNAMELICENSE="
				+ SPPLIERNAMELICENSE + ", CLIENTNAME=" + CLIENTNAME + ", ENVIRONMENTKEYNO=" + ENVIRONMENTKEYNO
				+ ", PONUMBER=" + PONUMBER + ", PODATE=" + PODATE + ", LICENSE_STATUS=" + LICENSE_STATUS
				+ ", CLIENTADDRESS=" + CLIENTADDRESS + ", OEMADDRESS=" + OEMADDRESS + ", ENDCUSTOMERNAME="
				+ ENDCUSTOMERNAME + ", ENDCUSTOMEREMAIL=" + ENDCUSTOMEREMAIL + ", MAKER=" + MAKER + ", CHECKER="
				+ CHECKER + ", AUTHORIZER=" + AUTHORIZER + ", SMRejectedReason=" + SMRejectedReason
				+ ", MDRejectedReason=" + MDRejectedReason + ", CMSTATUS=" + CMSTATUS + ", LICENSEFORNAME="
				+ LICENSEFORNAME + ", VP_ID=" + VP_ID + ", VL_STATUS=" + VL_STATUS + ", RaiseDate=" + RaiseDate
				+ ", PO_ID=" + PO_ID + ", CheckedBy=" + CheckedBy + ", CheckedDate=" + CheckedDate + ", AuthorizedBy="
				+ AuthorizedBy + ", AuthorizedDate=" + AuthorizedDate + ", SMNote=" + SMNote + ", BHNote=" + BHNote
				+ ", MDNote=" + MDNote + ", rejectedSMDate=" + rejectedSMDate + ", rejectedMDDate=" + rejectedMDDate
				+ ", Payment_status=" + Payment_status + ", uploadfile=" + uploadfile + ", distributor=" + distributor
				+ ", partner1=" + partner1 + ", partner2=" + partner2 + "]";
	}
	
	
	
	
}
