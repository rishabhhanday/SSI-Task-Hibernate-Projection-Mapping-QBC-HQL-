package com.worldpay;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
@Id
private int laptopNo;
private String company;
private int price;

public int getLaptopNo() {
	return laptopNo;
}
public void setLaptopNo(int laptopNo) {
	this.laptopNo = laptopNo;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Laptop(int laptopNo, String company, int price) {
	super();
	this.laptopNo = laptopNo;
	this.company = company;
	this.price = price;
}
@Override
public String toString() {
	return "Laptop [laptopNo=" + laptopNo + ", company=" + company + ", price=" + price + "]";
}
public Laptop(int laptopNo) {
	super();
	this.laptopNo = laptopNo;
}


}
