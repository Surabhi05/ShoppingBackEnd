package com.niit.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import com.niit.models.Orders;
import com.niit.models.Product;

public interface  OrdersDao {
	public List<Orders> getAllOrder();
 
 public boolean deleteById(int id);
 public boolean update( Orders o);
 public  Orders getById(int id);

public boolean save(Orders o);

}