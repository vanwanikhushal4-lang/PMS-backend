package com.velox.itsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReminderMails")
public class ReminderMails {

	private static final long serialVersionUID = -6631147707364792372L;
	@Id
	@Column
	private int SR_NO;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String FULL_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String EMAIL;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String REMINDER_NAME;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String TYPE;
	
	@Column(columnDefinition = "NVARCHAR(500)")
	private String MESSAGE;
	
	
}
