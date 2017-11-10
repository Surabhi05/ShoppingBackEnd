package com.niit.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Customer implements Serializable{
 @Id
  //automatically assigns value to id using sequence
 @SequenceGenerator(name = "cusseq", sequenceName = "cusseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "cusseq")
    int cusId;
 
 @Column
 @NotBlank
 @Size(min=3,message="category name should be more than 3 characters")
 String cusName;
 
 @Column
 @NotBlank
 @Size(min=5)
 String address;
 
 @Column
 @NotBlank 
 String email;
 
 @Column
 @NotBlank
 @Size(min=6)
 String password;
 
 @Column
 @Size(min=6)
 @Transient
 String confirmPassword;
 
 @Column
 @Pattern(regexp="\\d{10}")
 String phone;
 
 @Column
 String role;
 
 public String getRole() {
	 return role;
 }
 
 public void setRole(String role){
	 this.role = role;
 }
 
public int getCusId() {
	return cusId;
}

public void setCusId(int cusId) {
	this.cusId = cusId;
}

public String getCusName() {
	return cusName;
}

public void setCusName(String cusName) {
	this.cusName = cusName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}
 
public String getPassword() {
	return password;
}

public void setPassword(String password){
	this.password = password;
}

public String getConfirmPassword(){
	return confirmPassword;
}

public void setConfirmPassword(){
	this.confirmPassword = confirmPassword;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}



}