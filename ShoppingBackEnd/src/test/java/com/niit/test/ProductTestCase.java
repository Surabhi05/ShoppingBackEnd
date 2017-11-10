package com.niit.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.models.Product;
import com.niit.models.Supplier;


public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static Product product;
	@Autowired
    static	ProductDao productDao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		product =  (Product)config.getBean("product");
		productDao=  (ProductDao)config.getBean("productDao");
		
	}
	@Test
	public void checkproduct(){
		List<Product> prolist = productDao.getAllProduct();
		
		Assert.assertEquals(3, prolist.size());
	}

	@Test
	public void test() {
		
		//category.setProId(103);
		product.setProName("Laptop");
		product.setDescription("jhjkhjfdjjfnjnkjnjk");
		
		boolean saved=productDao.save(product);
		
		
		Assert.assertEquals(true, saved);
		
	}
	

}