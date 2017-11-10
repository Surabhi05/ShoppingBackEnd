package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Supplier;

@Repository("supplierDao")

@Transactional
public class SupplierDaoImpl implements SupplierDao {
 @Autowired
 SessionFactory sessionFactory;

 @Override
 public List <Supplier> getAllSupplier() {
  Session session = sessionFactory.openSession();
  Query query = session.createQuery("from Supplier"); // HQL is used here
               // not SQL
  List < Supplier > supplierlist = query.list();
  session.close();
  return supplierlist;
 }

 @Override
 public boolean save(Supplier s) {
  try {
   Session session = sessionFactory.openSession();
   session.save(s);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public boolean deleteById(int id) {
  try {
   Session session = sessionFactory.openSession();
   Supplier s = (Supplier) session.get(Supplier.class, id);
   if (s == null)
    return false;
   session.delete(s);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public boolean update(Supplier s) {
  try {
   Session session = sessionFactory.openSession();
   session.update(s);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public Supplier getById(int id) {

  Session session = sessionFactory.openSession();
  Supplier s = (Supplier) session.get(Supplier.class, id);
  session.close();
  return s;
 }

}
