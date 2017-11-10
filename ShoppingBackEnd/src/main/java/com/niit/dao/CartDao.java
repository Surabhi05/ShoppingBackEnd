package com.niit.dao;
import java.util.List;

import com.niit.models.Cart;
import com.niit.models.Customer;

public interface  CartDao {
	public boolean deleteById(int id);
	public List<Cart> getByCustomer(Customer c);
	public boolean save(Cart c);
	public Double getTotalAmount(Customer c);
	public Double getAllCart();
	public Cart getById(String cartid);
	boolean deleteByCustomer(Customer c);
	public void deleteByCustomer();
	
}