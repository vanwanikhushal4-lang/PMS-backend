package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FunctionMaster")
public class FunctionMaster {

	  
	  private static final long serialVersionUID = -1722684944868971448L;
	  @Id
	  @Column
	  private int SR_NO;
	   
	  @Column(name = "MODULE", columnDefinition = "NVARCHAR(500)")
		private String MODULE;
		
		
		@Column(name = "FUNCTION_NAME", columnDefinition = "NVARCHAR(500)")
		private String FUNCTION_NAME;


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


		public String getFUNCTION_NAME() {
			return FUNCTION_NAME;
		}


		public void setFUNCTION_NAME(String fUNCTION_NAME) {
			FUNCTION_NAME = fUNCTION_NAME;
		}


		@Override
		public String toString() {
			return "FunctionMaster [SR_NO=" + SR_NO + ", MODULE=" + MODULE + ", FUNCTION_NAME=" + FUNCTION_NAME + "]";
		}
		
	  

}
