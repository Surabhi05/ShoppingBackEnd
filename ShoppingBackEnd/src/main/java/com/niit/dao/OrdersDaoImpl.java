package com.niit.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Orders;


@Repository("OrdersDao")

@Transactional
public class OrdersDaoImpl implements OrdersDao {
 @Autowired
 SessionFactory sessionFactory;

@Autowired
ProductDao productDao;


public List<Orders> getAllOrder() {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	  Query query = session.createQuery("from Orders"); // HQL is used here
	               // not SQL
	  List <Orders> orderslist = query.list();
	  session.close();
	  return orderslist;

	
}


public boolean save(Orders o) {
	  try {
		   Session session = sessionFactory.openSession();
		   session.save(o);
		   session.flush();
		   session.close();
		  } catch (Exception e) {
		  return false;
		  
		  
		  }
		   return true;
}

public boolean update(Orders o) {
	// TODO Auto-generated method stub

	 try {
		   Session session = sessionFactory.openSession();
		   session.update(o);
		   session.flush();
		   session.close();
		  } catch (Exception e) {
		   return false;
		  }

		  return true;
	
	
	
}

public Orders getById(int cusId) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	Orders o = (Orders) session.get(Orders.class, cusId);
	  session.close();
	  return o;
}


public boolean deleteById(int cusId) {
 try {
  Session session = sessionFactory.openSession();
  Orders o = (Orders) session.get(Orders.class, cusId);
  if (o== null)
   return false;
  session.delete(o);
  session.flush();
  session.close();
 } catch (Exception e) {
  return false;
 }

 return true;
}



}