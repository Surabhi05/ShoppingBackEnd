package com.niit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class Cart{
 

 @Id
 // Automatically Assigns Value to id using Sequence
 @SequenceGenerator(name = "cartseq", sequenceName = "cartseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "cartseq")
    int cartid;
 
 @OneToOne
 @JoinColumn(name="cusId")
 Customer customer;
 @OneToOne
 @JoinColumn(name="proId")
 Product product;
 int qty; 
 
public int getCartid() {
	return cartid;
}

public void setCartid(int cartid) {
	this.cartid = cartid;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

}