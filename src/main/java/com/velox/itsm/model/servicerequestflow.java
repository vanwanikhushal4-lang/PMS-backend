package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_REQUEST_FLOW")
public class servicerequestflow implements Serializable{
  public static final long serialVersionUID = -1722684944868971448L;
  
  @Id
  @Column
  private int SR_NO;
  
  @Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
  private String COMPANY;
  
  @Column(name = "REQUEST", columnDefinition = "NVARCHAR(500)")
  private String REQUEST;
  
  @Column(name = "DESIGNATION", columnDefinition = "NVARCHAR(500)")
  private String DESIGNATION;
  
  @Column(name = "APPROVER_NAME", columnDefinition = "NVARCHAR(500)")
  private String APPROVER_NAME;
  
  @Column(name = "DEPARTMENT", columnDefinition = "NVARCHAR(500)")
  private String DEPARTMENT;

  public int getSR_NO() {
    return SR_NO;
  }

  public void setSR_NO(int sR_NO) {
    SR_NO = sR_NO;
  }

  public String getCOMPANY() {
    return COMPANY;
  }

  public void setCOMPANY(String cOMPANY) {
    COMPANY = cOMPANY;
  }

  public String getREQUEST() {
    return REQUEST;
  }

  public void setREQUEST(String rEQUEST) {
    REQUEST = rEQUEST;
  }

  public String getDESIGNATION() {
    return DESIGNATION;
  }

  public void setDESIGNATION(String dESIGNATION) {
    DESIGNATION = dESIGNATION;
  }

  public String getAPPROVER_NAME() {
    return APPROVER_NAME;
  }

  public void setAPPROVER_NAME(String aPPROVER_NAME) {
    APPROVER_NAME = aPPROVER_NAME;
  }

  public String getDEPARTMENT() {
    return DEPARTMENT;
  }

  public void setDEPARTMENT(String dEPARTMENT) {
    DEPARTMENT = dEPARTMENT;
  }

}
