package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.velox.itsm.dao.NotificationDao;


@Service("otificationConfig")
@Transactional
public class NotificationConfigImpl implements NotificationConfig {

	@Autowired
	NotificationDao notificationDao;
	
	@Override
	public JSONArray getUserNotification(String notify) {
	//	System.out.println("getUserNotification" + notify);
		JSONArray getUserNotification_dao_output = notificationDao.getUserNotification(notify);
	//	System.out.println("From Service_IMPL_output response " + getUserNotification_dao_output);
		return getUserNotification_dao_output;
	}

	@Override
	public JSONArray getTPNotification(String notify) {
		//System.out.println("getTPNotification" + notify);
		JSONArray getTPNotification_dao_output = notificationDao.getTPNotification(notify);
		//System.out.println("From Service_IMPL_output response " + getTPNotification_dao_output);
		return getTPNotification_dao_output;
	}

	@Override
	public JSONArray getEnggNotification(String notify) {
	//	System.out.println("getEnggNotification" + notify);
		JSONArray getEnggNotification_dao_output = notificationDao.getEnggNotification(notify);
	//	System.out.println("From Service_IMPL_output response " + getEnggNotification_dao_output);
		return getEnggNotification_dao_output;
	}

	@Override
	public JSONArray getTPOutage(String outage) {
		JSONArray getTPOutage_dao_output = notificationDao.getTPOutage(outage);
		return getTPOutage_dao_output;
	}

	@Override
	public JSONArray getUserOutage(String outage) {
		JSONArray getUserOutage_dao_output = notificationDao.getUserOutage(outage);
		return getUserOutage_dao_output;
	}

	@Override
	public JSONArray getEnggOutage(String outage) {
		JSONArray getEnggOutage_dao_output = notificationDao.getEnggOutage(outage);
		return getEnggOutage_dao_output;
	}
	
	@Override
	public JSONArray getITHeadOutage(String outage) {
		JSONArray getUserOutage_dao_output = notificationDao.getITHeadOutage(outage);
		return getUserOutage_dao_output;
	}

	@Override
	public JSONArray getItHeadNotification(String notify) {

		//System.out.println("getItHeadNotification" + notify);
		JSONArray getUserNotification_dao_output = notificationDao.getItHeadNotification(notify);
	//	System.out.println("From Service_IMPL_output response " + getUserNotification_dao_output);
		return getUserNotification_dao_output;
	
	}
	
	
}
