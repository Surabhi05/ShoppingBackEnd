
package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class HibernateConfig {
 @Autowired
 @Bean(name = "dataSource")
 public DataSource getDataSource() {
  BasicDataSource dataSource = new BasicDataSource();
  // DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName("org.h2.Driver");
  dataSource.setUrl("jdbc:h2:~/test");
  dataSource.setUsername("sa"); // Schema name
  dataSource.setPassword("");
  return dataSource;
 }

 private Properties getHibernateProperties() {
  Properties p = new Properties();
  p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
  p.put("hibernate.show_sql", "true");

  p.put("hibernate.hbm2ddl.auto", "update");

  return p;
 }

 @Autowired
 @Bean(name = "sessionFactory")
 public SessionFactory getSessionFactory(DataSource dataSource) {
  LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
  sessionBuilder.addProperties(getHibernateProperties());
  sessionBuilder.scanPackages("com.niit");
  return sessionBuilder.buildSessionFactory();
 }

 @Autowired
 @Bean(name = "transactionManager")
 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
  HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
  return transactionManager;
 }

}

