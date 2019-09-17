package com.worldpay;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
void insertLaptop(Session session){
	Laptop lap1 = new Laptop(1, "DELL", 20000);
	Laptop lap2 = new Laptop(2, "HP", 40000);
	Laptop lap3 = new Laptop(3, "ASUS", 60000);
	Transaction tr = session.beginTransaction();
	session.save(lap1);
	session.save(lap2);
	session.save(lap3);
	tr.commit();
	session.close();
	System.out.println("saved");
}
void insertStudent(Session session){
	Student stu1 = new Student(7, "DDD", 20,new Laptop(3),new Vehicle(1));
	Student stu2 = new Student(8, "EEE", 60,new Laptop(1),new Vehicle(2));
	Student stu3 = new Student(9, "FFF", 80,new Laptop(2),new Vehicle(3));
	Transaction tr = session.beginTransaction();
	session.save(stu1);
	session.save(stu2);
	session.save(stu3);
	tr.commit();
	session.close();
	System.out.println("saved");
}
void insertVehicel(Session session){
	Vehicle v1 = new Vehicle(1, "AUDI", 20000);
	Vehicle v2 = new Vehicle(2, "WAGON-R", 40000);
	Vehicle v3 = new Vehicle(3, "FORTUNER", 60000);
	Transaction tr = session.beginTransaction();
	session.save(v1);
	session.save(v2);
	session.save(v3);
	tr.commit();
	session.close();
	System.out.println("saved");
}
	public static void main(String... sd) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		MappingDemo  md = new MappingDemo();
		//md.insertLaptop(session); 
		md.insertStudent(session);
		//md.insertVehicel(session);
		
		
	}
}
