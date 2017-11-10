package com.niit.dao;

import java.util.List;
import com.niit.models.Supplier;



   public interface SupplierDao {
	 public List < Supplier > getAllSupplier();
	 public boolean save(Supplier s);
	 public boolean deleteById(int id);
	 public boolean update(Supplier s);
	 public Supplier getById(int id);

}
