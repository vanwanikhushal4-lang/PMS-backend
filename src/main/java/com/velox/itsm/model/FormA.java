package com.velox.itsm.model;
    
    import java.io.Serializable;
    import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "FormA")
	public class FormA implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -1722684944868971448L;
		@Id
		@Column()
		private int SR_NO;
		
		
		private String raisedate;
		private String vlx_id;
		private String vlx_status;
		private String formAPOno;
		private String dateforma;
		private String salemangname;
		
		private String distributorpartyname;
		private String distributorprojectname;
		private String distributortechpersonname;
		private String distributorprsndesignation;
		private String distributorcontactnumber;
		private String distributoremailid;
		
		private String partnerpartyname;
		private String partnerprojectname;
		private String partnertechpersonname;
		private String partnerprsndesignation;
		private String partnercontactnumber;
		private String partneremailid;
		
		private String customerpartyname;
		private String customerprojectname;
		private String customertechpersonname;
		private String customerprsndesignation;
		private String customercontactnumber;
		private String customeremailid;
		
		private String implementorpartyname;
		private String implementorprojectname;
		private String implementortechpersonname;
		private String implementorprsndesignation;
		private String implementorcontactnumber;
		private String implementoremailid;
		
		private String endcustomerpartyname;
		private String endcustomerprojectname;
		private String endcustomertechpersonname;
		private String endcustomerprsndesignation;
		private String endcustomercontactnumber;
		private String endcustomeremailid;
		
		private String approvedby;
		private String approveddate;
		private String submittedby;
		private String formABfillby;
		private String formABfilldate;
	
		
		
		
	
		public String getEndcustomerpartyname() {
			return endcustomerpartyname;
		}
		public void setEndcustomerpartyname(String endcustomerpartyname) {
			this.endcustomerpartyname = endcustomerpartyname;
		}
		public String getEndcustomerprojectname() {
			return endcustomerprojectname;
		}
		public void setEndcustomerprojectname(String endcustomerprojectname) {
			this.endcustomerprojectname = endcustomerprojectname;
		}
		public String getEndcustomertechpersonname() {
			return endcustomertechpersonname;
		}
		public void setEndcustomertechpersonname(String endcustomertechpersonname) {
			this.endcustomertechpersonname = endcustomertechpersonname;
		}
		public String getEndcustomerprsndesignation() {
			return endcustomerprsndesignation;
		}
		public void setEndcustomerprsndesignation(String endcustomerprsndesignation) {
			this.endcustomerprsndesignation = endcustomerprsndesignation;
		}
		public String getEndcustomercontactnumber() {
			return endcustomercontactnumber;
		}
		public void setEndcustomercontactnumber(String endcustomercontactnumber) {
			this.endcustomercontactnumber = endcustomercontactnumber;
		}
		public String getEndcustomeremailid() {
			return endcustomeremailid;
		}
		public void setEndcustomeremailid(String endcustomeremailid) {
			this.endcustomeremailid = endcustomeremailid;
		}
		public int getSR_NO() {
			return SR_NO;
		}
		public void setSR_NO(int sR_NO) {
			SR_NO = sR_NO;
		}
		public String getDateforma() {
			return dateforma;
		}
		public void setDateforma(String dateforma) {
			this.dateforma = dateforma;
		}
		public String getSalemangname() {
			return salemangname;
		}
		
		public String getRaisedate() {
			return raisedate;
		}
		public void setRaisedate(String raisedate) {
			this.raisedate = raisedate;
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
		public void setSalemangname(String salemangname) {
			this.salemangname = salemangname;
		}
		public String getDistributorpartyname() {
			return distributorpartyname;
		}
		public void setDistributorpartyname(String distributorpartyname) {
			this.distributorpartyname = distributorpartyname;
		}
		public String getDistributorprojectname() {
			return distributorprojectname;
		}
		public void setDistributorprojectname(String distributorprojectname) {
			this.distributorprojectname = distributorprojectname;
		}
		public String getDistributortechpersonname() {
			return distributortechpersonname;
		}
		public void setDistributortechpersonname(String distributortechpersonname) {
			this.distributortechpersonname = distributortechpersonname;
		}
		public String getDistributorprsndesignation() {
			return distributorprsndesignation;
		}
		public void setDistributorprsndesignation(String distributorprsndesignation) {
			this.distributorprsndesignation = distributorprsndesignation;
		}
		public String getDistributorcontactnumber() {
			return distributorcontactnumber;
		}
		public void setDistributorcontactnumber(String distributorcontactnumber) {
			this.distributorcontactnumber = distributorcontactnumber;
		}
		public String getDistributoremailid() {
			return distributoremailid;
		}
		public void setDistributoremailid(String distributoremailid) {
			this.distributoremailid = distributoremailid;
		}
		public String getPartnerpartyname() {
			return partnerpartyname;
		}
		public void setPartnerpartyname(String partnerpartyname) {
			this.partnerpartyname = partnerpartyname;
		}
		public String getPartnerprojectname() {
			return partnerprojectname;
		}
		public void setPartnerprojectname(String partnerprojectname) {
			this.partnerprojectname = partnerprojectname;
		}
		public String getPartnertechpersonname() {
			return partnertechpersonname;
		}
		public void setPartnertechpersonname(String partnertechpersonname) {
			this.partnertechpersonname = partnertechpersonname;
		}
		public String getPartnerprsndesignation() {
			return partnerprsndesignation;
		}
		public void setPartnerprsndesignation(String partnerprsndesignation) {
			this.partnerprsndesignation = partnerprsndesignation;
		}
		public String getPartnercontactnumber() {
			return partnercontactnumber;
		}
		public void setPartnercontactnumber(String partnercontactnumber) {
			this.partnercontactnumber = partnercontactnumber;
		}
		public String getPartneremailid() {
			return partneremailid;
		}
		public void setPartneremailid(String partneremailid) {
			this.partneremailid = partneremailid;
		}
		public String getCustomerpartyname() {
			return customerpartyname;
		}
		public void setCustomerpartyname(String customerpartyname) {
			this.customerpartyname = customerpartyname;
		}
		public String getCustomerprojectname() {
			return customerprojectname;
		}
		public void setCustomerprojectname(String customerprojectname) {
			this.customerprojectname = customerprojectname;
		}
		public String getCustomertechpersonname() {
			return customertechpersonname;
		}
		public void setCustomertechpersonname(String customertechpersonname) {
			this.customertechpersonname = customertechpersonname;
		}
		public String getCustomerprsndesignation() {
			return customerprsndesignation;
		}
		public void setCustomerprsndesignation(String customerprsndesignation) {
			this.customerprsndesignation = customerprsndesignation;
		}
		public String getCustomercontactnumber() {
			return customercontactnumber;
		}
		public void setCustomercontactnumber(String customercontactnumber) {
			this.customercontactnumber = customercontactnumber;
		}
		public String getCustomeremailid() {
			return customeremailid;
		}
		public void setCustomeremailid(String customeremailid) {
			this.customeremailid = customeremailid;
		}
		public String getImplementorpartyname() {
			return implementorpartyname;
		}
		public void setImplementorpartyname(String implementorpartyname) {
			this.implementorpartyname = implementorpartyname;
		}
		public String getImplementorprojectname() {
			return implementorprojectname;
		}
		public void setImplementorprojectname(String implementorprojectname) {
			this.implementorprojectname = implementorprojectname;
		}
		public String getImplementortechpersonname() {
			return implementortechpersonname;
		}
		public void setImplementortechpersonname(String implementortechpersonname) {
			this.implementortechpersonname = implementortechpersonname;
		}
		public String getImplementorprsndesignation() {
			return implementorprsndesignation;
		}
		public void setImplementorprsndesignation(String implementorprsndesignation) {
			this.implementorprsndesignation = implementorprsndesignation;
		}
		public String getImplementorcontactnumber() {
			return implementorcontactnumber;
		}
		public void setImplementorcontactnumber(String implementorcontactnumber) {
			this.implementorcontactnumber = implementorcontactnumber;
		}
		public String getImplementoremailid() {
			return implementoremailid;
		}
		public void setImplementoremailid(String implementoremailid) {
			this.implementoremailid = implementoremailid;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		public String getSubmittedby() {
			return submittedby;
		}
		public void setSubmittedby(String submittedby) {
			this.submittedby = submittedby;
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
		public String getFormAPOno() {
			return formAPOno;
		}
		public void setFormAPOno(String formAPOno) {
			this.formAPOno = formAPOno;
		}
		@Override
		public String toString() {
			return "FormA [SR_NO=" + SR_NO + ", dateforma=" + dateforma + ", salemangname=" + salemangname
					+ ", distributorpartyname=" + distributorpartyname + ", distributorprojectname="
					+ distributorprojectname + ", distributortechpersonname=" + distributortechpersonname
					+ ", distributorprsndesignation=" + distributorprsndesignation + ", distributorcontactnumber="
					+ distributorcontactnumber + ", distributoremailid=" + distributoremailid + ", partnerpartyname="
					+ partnerpartyname + ", partnerprojectname=" + partnerprojectname + ", partnertechpersonname="
					+ partnertechpersonname + ", partnerprsndesignation=" + partnerprsndesignation
					+ ", partnercontactnumber=" + partnercontactnumber + ", partneremailid=" + partneremailid
					+ ", customerpartyname=" + customerpartyname + ", customerprojectname=" + customerprojectname
					+ ", customertechpersonname=" + customertechpersonname + ", customerprsndesignation="
					+ customerprsndesignation + ", customercontactnumber=" + customercontactnumber
					+ ", customeremailid=" + customeremailid + ", implementorpartyname=" + implementorpartyname
					+ ", implementorprojectname=" + implementorprojectname + ", implementortechpersonname="
					+ implementortechpersonname + ", implementorprsndesignation=" + implementorprsndesignation
					+ ", implementorcontactnumber=" + implementorcontactnumber + ", implementoremailid="
					+ implementoremailid + "]";
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

		
		
		
		
	

}
