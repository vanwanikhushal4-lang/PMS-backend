package com.velox.itsm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProposalMaster")
public class ProposalMaster {

	  
	  private static final long serialVersionUID = -1722684944868971448L;
	  @Id
	  @Column
	  private int SR_NO;
	   
	  
		
		
		@Column(name = "proposalName", columnDefinition = "NVARCHAR(500)")
		private String proposalName;


		public int getSR_NO() {
			return SR_NO;
		}


		public void setSR_NO(int sR_NO) {
			SR_NO = sR_NO;
		}


		public String getProposalName() {
			return proposalName;
		}


		public void setProposalName(String proposalName) {
			this.proposalName = proposalName;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}




	

	
	  

}
