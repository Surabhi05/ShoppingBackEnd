package com.niit.dao;
import java.util.List;
import com.niit.models.Category;

public interface CategoryDao  {

 public List < Category > getAllCategory();
 public boolean save(Category c);
 public boolean deleteById(int id);
 public boolean update(Category c);
 public Category getById(int id);
}
