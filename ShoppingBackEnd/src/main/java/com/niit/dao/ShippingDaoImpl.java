package com.niit.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Cart;
import com.niit.models.Customer;
import com.niit.models.Shipping;

@Repository("shippingDao")

@Transactional
public class ShippingDaoImpl implements ShippingDao {
 @Autowired
 SessionFactory sessionFactory;


@Override
public boolean save(Shipping s) {
	// TODO Auto-generated method stub
	
	try {
		   Session session = sessionFactory.openSession();
		   session.save(s);
		   session.flush();
		   session.close();
		  } catch (Exception e) {
		  return false;
		  
		  
		  }
		   return true;
}

@Override
public boolean deleteById(int id) {
	// TODO Auto-generated method stub
	
	 try {
		  Session session = sessionFactory.openSession();
		  Shipping o = (Shipping) session.get(Shipping.class, id);
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



@Override
public Shipping getById(int id) {
	Session session = sessionFactory.openSession();
	Shipping o = (Shipping) session.get(Shipping.class, id);
	  session.close();
	  return o;


}

@Override
public Shipping getByCustomer(Customer c) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	String hql = "from Shipping where customer.cusId="+c.getCusId();
	Query query = sessionFactory.openSession().createQuery(hql);
	Shipping shipping = (Shipping)query.list().get(0);
	  session.close();
	  return shipping;
}




@Override
public List<Shipping> getAllShipping() {
	// TODO Auto-generated method stub
	return null;
}





}