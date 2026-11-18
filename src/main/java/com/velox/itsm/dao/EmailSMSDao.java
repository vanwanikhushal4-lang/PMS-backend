package com.velox.itsm.dao;

public interface EmailSMSDao {
	
	
	public String RaiseNCloseEmailSMS(int id, String name1, String status, String site, String category,String subject,String description,String priority,String phone,String emailid);
	
	public String RaiseNCloseProblemEmailSMS(String Problem_ID,String Problem_Status);
	
	public String EmailSMSTriggered(String ticketID, String TicketStatus);
	public String EmailSMSTriggeredForServiceRequest(String newTicketID, String string, String assign_TO, String engName, String userPh, String enggcompany,String engGroupName);

	public void EmaiLSmsTriggerdInSoftwareRequest(String newTicketID, String status);
	public void EmaiLSmsTriggerdInSoftwareRelease(String tid,String status);

	public void EmaiLSmsTriggerdInSoftwareTransfer(String newTicketID, String status);

}
