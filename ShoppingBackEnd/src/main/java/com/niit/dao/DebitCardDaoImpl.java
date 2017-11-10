package com.niit.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.models.DebitCard;

	
	@Repository("debitCardDao")
	@Transactional
	public  class DebitCardDaoImpl implements DebitCardDao
	{
	 @Autowired
	 SessionFactory sessionFactory;
	
	 @Override
	 public boolean save(DebitCard d) {
	  try {
	   Session session = sessionFactory.openSession();
	   session.save(d);
	   session.flush();
	   session.close();
	  } catch (Exception e) {
	   return false;
	  }

	  return true;
	 }
	
	}
	
	