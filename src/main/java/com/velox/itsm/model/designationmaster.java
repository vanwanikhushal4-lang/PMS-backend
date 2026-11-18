package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESIGNATIONMASTER")
public class designationmaster implements Serializable {
  
  private static final long serialVersionUID = -1722684944868971448L;
  @Id
  @Column
  private int SR_NO;
  
  @Column(name = "COMPANY", columnDefinition = "NVARCHAR(500)")
  private String COMPANY;
  
  @Column(name = "DESIGNATION", columnDefinition = "NVARCHAR(500)")
  private String DESIGNATION;

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

  public String getDESIGNATION() {
    return DESIGNATION;
  }

  public void setDESIGNATION(String dESIGNATION) {
    DESIGNATION = dESIGNATION;
  }
  
}
