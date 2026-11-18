package com.velox.itsm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.dao.EmailSMSDao;
import com.velox.itsm.dao.LoginDao;

@Service("EmailSMSService")
@Transactional
public class EmailSMSServiceImpl {
	
	@Autowired
	EmailSMSDao EmailSMS_dao;


}
