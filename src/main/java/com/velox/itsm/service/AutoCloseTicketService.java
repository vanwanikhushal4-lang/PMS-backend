package com.velox.itsm.service;

import org.json.JSONArray;

public interface AutoCloseTicketService {
	
	public String AutoClosedInsert(String TicketType, String TimeFormat, String Time,String rsn, String company);

	public String AutoClosedProblemInsert(String TicketType, String TimeFormat, String Time,String rsn, String company);
	
}
