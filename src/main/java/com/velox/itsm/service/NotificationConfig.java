package com.velox.itsm.service;

import org.json.JSONArray;

public interface NotificationConfig {
	public JSONArray getUserNotification(String notify);
	public JSONArray getTPNotification(String notify);
	public JSONArray getEnggNotification(String notify);
	public JSONArray getTPOutage(String outage);
	public JSONArray getUserOutage(String outage);
	public JSONArray getEnggOutage(String outage);
	public JSONArray getITHeadOutage(String outage);
	public JSONArray getItHeadNotification(String notify);
	
}
