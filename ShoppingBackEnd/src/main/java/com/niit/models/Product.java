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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Entity
@Table
public class Product implements Serializable {
 @Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", qty=" + qty + ", price=" + price
				+ ", description=" + description + ", category=" + category + ", supplier=" + supplier + ", imagePath="
				+ imagePath + ", multipartfile=" + multipartfile + "]";
	}

@Id
  //automatically assigns value to id using sequence
 @SequenceGenerator(name = "proseq", sequenceName = "proseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "proseq")
    int proId;
 @Column
 String proName;
 
 @Column
 @NotNull
 int qty;
 @Column
@NotNull
double price;
 @Column
 @Size(min=5)
 @NotBlank
 String description;
 
 @OneToOne
 @JoinColumn(name="catId")
 Category category;
 @OneToOne
 @JoinColumn(name="supId")
 Supplier supplier;
 @Column
 String imagePath;
 
 @Transient
 MultipartFile multipartfile;
 
 public MultipartFile getMultipartfile() {
	 return multipartfile;
 }
 public void setMultipartfile(MultipartFile multipartfile) {
	 this.multipartfile = multipartfile;
 }
 public Category getCategory() {
	 return category;
 }
 public void setCategory(Category category) {
	 this.category = category;
 }
 public Supplier getSupplier(){
	 return supplier;
 }
 public void setSupplier(Supplier supplier) {
	 this.supplier = supplier;
 }
 public int getProId() {
	 return proId;
 }
 public void setProId(int proId) {
	 this.proId = proId;
 }
 public String getProName() {
	 return proName;
 }
 public void setProName(String proName) {
	 this.proName = proName;
 }
 
 public String getImagePath() {
	 return imagePath;
 }
 public void setImagePath(String imagePath) {
	 this.imagePath = imagePath;
 }
 public int getQty() {
	 return qty;
 }
 public void setQty(int qty) {
	 this.qty = qty;
 }
 public double getPrice() {
	 return price;
 }
 public void setPrice(double price) {
	 this.price = price;
 }
 

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
 
}