package com.velox.itsm.dao;

import org.json.JSONArray;

public interface AutoCloseTicketDao {

	public String AutoClosedInsert(String TicketType, String TimeFormat, String Time,String rsn, String company);

	public String AutoClosedProblemInsert(String TicketType, String TimeFormat, String Time,String rsn, String company);
}
