package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Customer;

@Repository("customerDao")

@Transactional
public class CustomerDaoImpl implements CustomerDao {
 @Autowired
 SessionFactory sessionFactory;



@Override
public List<Customer> getAllCustomer() {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	  Query query = session.createQuery("from customer"); // HQL is used here
	               // not SQL
	  List <Customer> customerlist = query.list();
	  session.close();
	  return customerlist;

	
}

@Override
public boolean save(Customer c) {
	  try {
		   Session session = sessionFactory.openSession();
		   c.setRole("ROLE_USER");
		   session.save(c);
		   session.flush();
		   session.close();
		  } catch (Exception e) {
		  return false;
		  
		  
		  }
		   return true;
}

@Override
public boolean update(Customer c) {
	// TODO Auto-generated method stub

	 try {
		   Session session = sessionFactory.openSession();
		   session.update(c);
		   session.flush();
		   session.close();
		  } catch (Exception e) {
		   return false;
		  }

		  return true;
	
	
	
}

@Override
public Customer getByEmail( String email) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	String hql="from Customer where email='"+email+"'";
	Query query = session.createQuery(hql);
	Customer c = (Customer) query.list().get(0);
	  session.close();
	  return c;
}
@Override
public boolean deleteById(int cusId) {
 try {
  Session session = sessionFactory.openSession();
  Customer c = (Customer) session.get(Customer.class, cusId);
  if (c== null)
   return false;
  session.delete(c);
  session.flush();
  session.close();
 } catch (Exception e) {
  return false;
 }

 return true;
}


}

