package com.niit.dao;

import java.util.List;

import com.niit.models.Cart;
import com.niit.models.Customer;
import com.niit.models.Shipping;

public interface  ShippingDao {
 public List <Shipping> getAllShipping();
 public default  boolean save(Shipping s) {
	// TODO Auto-generated method stub
	return false;
}
 public boolean deleteById(int id);
 
 public  Shipping getById(int id);


Shipping getByCustomer(Customer c);

	
}