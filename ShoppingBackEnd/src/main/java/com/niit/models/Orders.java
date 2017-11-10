package com.niit.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.Min;


import org.springframework.stereotype.Component;
@Component
@Entity
@Table
 
public class Orders implements Serializable {
	 @Id
	 // Automatically Assigns Value to id using Sequence
	 @SequenceGenerator(name = "myorderseq", sequenceName = "myorderseq")
	 @GeneratedValue(strategy=GenerationType.AUTO,generator = "myorderseq")
	
	int orderId;
	 
	 @OneToOne
	 @JoinColumn(name="cusId")
	 Customer customer;
	 
	 @OneToOne
	 @JoinColumn(name="proId")
	 Product product;
	 
	 @OneToOne
	 @JoinColumn(name="shippingId")
	 Shipping shipping;
	 
	 @Column
	
	  int qty;
	 
	 @Column
		double totalAmt;
		
	 
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer + ", product=" + product + ", shipping="
				+ shipping + ", qty=" + qty + ", totalAmt=" + totalAmt + "]";
	}
	
	
}