package com.velox.itsm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEMPLATEMASTER")
public class templatemaster implements Serializable  {
  private static final long serialVersionUID = -1722684944868971448L;
  
  @Id
  @Column
  private int SR_NO;

  @Column(name = "NAME", columnDefinition = "NVARCHAR(500)")
  private String NAME;

  @Column(name = "ATTRIBUTES",columnDefinition = "NVARCHAR(500)")
  private String ATTRIBUTES;
  
  public int getSR_NO() {
    return SR_NO;
  }

  public void setSR_NO(int sR_NO) {
    SR_NO = sR_NO;
  }

  public String getNAME() {
    return NAME;
  }

  public void setNAME(String nAME) {
    NAME = nAME;
  }

  public String getATTRIBUTES() {
    return ATTRIBUTES;
  }

  public void setATTRIBUTES(String aTTRIBUTES) {
    ATTRIBUTES = aTTRIBUTES;
  }
  
  public templatemaster() {
    super();
  }
}
