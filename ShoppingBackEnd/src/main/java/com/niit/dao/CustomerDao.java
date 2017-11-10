package com.niit.dao;

import java.util.List;

import com.niit.models.Customer;

public interface  CustomerDao {
 public List <Customer> getAllCustomer();
 public boolean save( Customer c);
 public boolean deleteById(int cusId);
 public boolean update( Customer c);
 public Customer getByEmail(String email);
}
