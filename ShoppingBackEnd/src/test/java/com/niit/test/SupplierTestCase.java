package com.niit.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.models.Supplier;


public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static Supplier supplier;
	@Autowired
    static	SupplierDao supplierDao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		supplier =  (Supplier)config.getBean("supplier");
		supplierDao=  (SupplierDao)config.getBean("supplierDao");
		
	}
	@Test
	public void checksupplier(){
		List<Supplier> suplist = supplierDao.getAllSupplier();
		
		Assert.assertEquals(3, suplist.size());
	}

	@Test
	public void test() {
		
		//category.setSupId(103);
		supplier.setSupName("Laptop");
		supplier.setDescription("jhjkhjfdjjfnjnkjnjk");
		
		boolean saved=supplierDao.save(supplier);
		
		
		Assert.assertEquals(true, saved);
		
	}
	

}