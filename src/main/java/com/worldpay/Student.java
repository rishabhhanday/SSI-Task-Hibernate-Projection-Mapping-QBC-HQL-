package com.worldpay;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
@Id	
private int rollNo;
private String name;
private int marks;

@OneToOne
private Laptop laptop;
@OneToOne
private Vehicle vehicle; 


public Laptop getLaptop() {
	return laptop;
}
public void setLaptop(Laptop laptop) {
	this.laptop = laptop;
}


public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}


public Student(int rollNo, String name, int marks) {
	super();
	this.rollNo = rollNo;
	this.name = name;
	this.marks = marks;
}
public Student(int rollNo, String name, int marks, Laptop laptop, Vehicle vehicle) {
	super();
	this.rollNo = rollNo;
	this.name = name;
	this.marks = marks;
	this.laptop = laptop;
	this.vehicle = vehicle;
}
public Student() {
	super();
}
@Override
public String toString() {
	return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
}

}
