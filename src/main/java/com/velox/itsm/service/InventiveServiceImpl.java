package com.velox.itsm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velox.itsm.dao.InventiveDao;

@Service("inventiveService")
@Transactional
public class InventiveServiceImpl implements InventiveService{

	@Autowired
	InventiveDao inventiveDao;
	
}
