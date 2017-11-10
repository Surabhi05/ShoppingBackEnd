package com.niit.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Category implements Serializable {
 @Id
  //automatically assigns value to id using sequence
 @SequenceGenerator(name = "catseq", sequenceName = "catseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "catseq")
    int catId;
 
 @Column
 @NotBlank
 @Size(min=3,message="category name should be more than 3 characters")
 String catName;
 
 @Column
 @NotBlank
 @Size(min=8)
 String description;

public int getCatId() {
	return catId;
}

public void setCatId(int catId) {
	this.catId = catId;
}

public String getCatName() {
	return catName;
}

public void setCatName(String catName) {
	this.catName = catName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


}