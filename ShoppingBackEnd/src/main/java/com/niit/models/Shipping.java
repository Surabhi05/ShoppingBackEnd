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

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Shipping{
 
	 @Id
	 // Automatically Assigns Value to id using Sequence
	 @SequenceGenerator(name = "shipseq", sequenceName = "shipseq")
	 @GeneratedValue(strategy=GenerationType.AUTO,generator = "shipseq")
 int shippingid;
 
	 @OneToOne
	 @JoinColumn(name="cusId")
	 Customer customer;
	 

@Column
 @NotBlank
 @Size(min=3,message="address should be more than 3 characters")
 String addressline1;
 
 
 @NotBlank
 @Size(min=3,message="address should be more than 3 characters")
 String addressline2;
 
 
 @NotBlank
 @Pattern(regexp="^[1-9][0-9]{5}$")
 String pincode;
@NotBlank
 String landmark;
 

public String getAddressline1() {
	return addressline1;
}
public int getShippingid() {
	return shippingid;
}
public void setShippingid(int shippingid) {
	this.shippingid = shippingid;
}
public void setAddressline1(String addressline1) {
	this.addressline1 = addressline1;
}
public String getAddressline2() {
	return addressline2;
}
public void setAddressline2(String addressline2) {
	this.addressline2 = addressline2;
}

public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}

public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

}