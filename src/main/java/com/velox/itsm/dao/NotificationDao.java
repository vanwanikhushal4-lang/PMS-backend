package com.velox.itsm.dao;

import org.json.JSONArray;

public interface NotificationDao {

	public JSONArray getUserNotification(String notify);
	public JSONArray getTPNotification(String notify);
	public JSONArray getEnggNotification(String notify);
	public JSONArray getTPOutage(String outage);
	public JSONArray getUserOutage(String outage);
	public JSONArray getEnggOutage(String outage);
	public JSONArray getITHeadOutage(String outage);
	public JSONArray getItHeadNotification(String notify);

}
