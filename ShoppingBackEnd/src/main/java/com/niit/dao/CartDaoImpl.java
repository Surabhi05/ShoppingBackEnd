package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.models.Cart;
import com.niit.models.Customer;

@Repository("cartDao")

@Transactional
public  class CartDaoImpl implements CartDao {
@Autowired
 SessionFactory sessionFactory;

@Override
public boolean save(Cart c) {
	try {
		   Session session = sessionFactory.openSession();
		   session.save(c);
		   
		   session.close();
		  } catch (Exception e) {
			  e.printStackTrace();
		   return false;
		  }

		  return true;
}


@Override
public List<Cart> getByCustomer(Customer c) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	String hql = "from Cart where customer.cusId="+c.getCusId();
	Query query = sessionFactory.openSession().createQuery(hql);
	
	List<Cart> cartList = query.list();
	  session.close();
	  return cartList;
}



@Override
public boolean deleteByCustomer(Customer c) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.openSession();
	String hql = "delete from Cart where customer.cusId="+c.getCusId();
	Query query = sessionFactory.openSession().createQuery(hql);
	query.executeUpdate();
	
	  session.close();
	  return false;
	  
}

@Override
public boolean deleteById(int id) {
 try {
  Session session = sessionFactory.openSession();
  Cart c = (Cart) session.get(Cart.class,id);
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
@Override
public Double getTotalAmount(Customer c) {
	String hql = "select sum(product.price) from Cart where customer.cusId="+c.getCusId();
	  Session session = sessionFactory.openSession();
	Query query = session.createQuery(hql);
	Double d=  (Double) query.uniqueResult();
	session.close();
	if (d==null)
		return 0.0;
	return d;

}


@Override
public Double getAllCart() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Cart getById(String cartid) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void deleteByCustomer() {
	// TODO Auto-generated method stub
	
}



}
