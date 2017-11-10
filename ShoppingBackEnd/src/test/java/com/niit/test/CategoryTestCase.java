package com.niit.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.models.Category;


public class CategoryTestCase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static Category category;
	@Autowired
    static	CategoryDao categoryDao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		category =  (Category)config.getBean("category");
		categoryDao=  (CategoryDao)config.getBean("categoryDao");
		
	}
	@Test
	public void checkcategory(){
		List<Category> catlist = categoryDao.getAllCategory();
		
		Assert.assertEquals(3, catlist.size());
	}

	@Test
	public void test() {
		
		//category.setCatId(103);
		category.setCatName("Laptop");
		category.setDescription("jhjkhjfdjjfnjnkjnjk");
		
		boolean saved=categoryDao.save(category);
		
		
		Assert.assertEquals(true, saved);
		
	}
	

}