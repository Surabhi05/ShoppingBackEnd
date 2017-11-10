package com.niit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class DebitCard{
	 @Id
	 // Automatically Assigns Value to id using Sequence
	 @SequenceGenerator(name = "debitseq", sequenceName = "debitseq")
	 @GeneratedValue(strategy=GenerationType.AUTO,generator = "debitseq")
 int cardId;
 
 @OneToOne
 @JoinColumn(name="cusId")
 Customer customer;
 @NotBlank
 @Pattern(regexp="^[1-9][0-9]{15}$")
 String cardNo;
 
@Min(value=1)
@Max(value=12)
 int expireMonth;
 
 @NotBlank
 @Pattern(regexp="^[1-9][0-9]{3}$")
 String expireYear;
 
 @NotBlank
 String cardName;

@Transient
@Pattern(regexp="^[1-9][0-9]{3}$")
 String atmPin;



 public int getCardId() {
	return cardId;
}

public void setCardId(int cardId) {
	this.cardId = cardId;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public String getCardNo() {
	return cardNo;
}

public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}

public int getExpireMonth() {
	return expireMonth;
}

public void setExpireMonth(int expireMonth) {
	this.expireMonth = expireMonth;
}


public String getExpireYear() {
	return expireYear;
}


public void setExpireYear(String expireYear) {
	this.expireYear = expireYear;
}


public String getCardName() {
	return cardName;
}

public void setCardName(String cardName) {
	this.cardName = cardName;
}

public String getAtmPin() {
	return atmPin;
}

public void setAtmPin(String atmPin) {
	this.atmPin = atmPin;
}

public String getCvv() {
	return cvv;
}

public void setCvv(String cvv) {
	this.cvv = cvv;
}

@Transient
 @Pattern(regexp="^[1-9][0-9]{2}$")
 String cvv;
 
}