package com.velox.itsm.service;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.dao.AutoCloseTicketDao;




@Service("AutoCloseTicketService")
@Transactional
public class AutoCloseTicketServiceImpl implements AutoCloseTicketService {

	@Autowired
	AutoCloseTicketDao autoCloseTicketDao;
	
	
	@Override
	public String AutoClosedInsert(String TicketType, String TimeFormat, String Time,String rsn, String company) {
		// TODO Auto-generated method stub
		return autoCloseTicketDao.AutoClosedInsert(TicketType, TimeFormat, Time, rsn, company);
	}


	@Override
	public String AutoClosedProblemInsert(String TicketType, String TimeFormat, String Time, String rsn, String company) {
		// TODO Auto-generated method stub
		return autoCloseTicketDao.AutoClosedProblemInsert(TicketType, TimeFormat, Time,rsn, company);
	}

	
}
