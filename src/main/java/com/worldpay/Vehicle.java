package com.worldpay;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
private int vNo;
private String company;
private int price;
public int getvNo() {
	return vNo;
}

public Vehicle(int vNo) {
	super();
	this.vNo = vNo;
}

public void setvNo(int vNo) {
	this.vNo = vNo;
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
public Vehicle(int vNo, String company, int price) {
	super();
	this.vNo = vNo;
	this.company = company;
	this.price = price;
}
@Override
public String toString() {
	return "Vehicle [vNo=" + vNo + ", company=" + company + ", price=" + price + "]";
}

}
