package com.velox.itsm.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("inventiveDao")
@Transactional
public class InventiveDaoImpl implements InventiveDao{
	
	@Autowired
	SessionFactory sessionFactory;
}
