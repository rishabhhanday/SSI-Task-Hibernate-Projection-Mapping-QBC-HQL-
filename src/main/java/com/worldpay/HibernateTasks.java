package com.worldpay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class HibernateTasks {
	void retrieveSQL(Session session) {
		SQLQuery query = session.createSQLQuery("select * from Student");

		List<Object[]> list = query.list();
		for (Object object[] : list) {
			for (Object ob : object) {
				System.out.println(ob);

			}

		}

	}

	void orderingHQL(Session session) {
		Query query = session.createQuery("from Student order by marks");
		List<Student> list = query.list();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}

	void projectionQBC(Session session) {
		Criteria cr = session.createCriteria(Student.class);
		Projection p1 = Projections.property("rollNo");
		Projection p2 = Projections.property("marks");
		ProjectionList pl = Projections.projectionList();
		pl.add(p1);
		pl.add(p2);
		cr.setProjection(pl);
		List<Object[]> list = cr.list();
		for (Object object[] : list) {
			for (Object ob : object) {
				System.out.println(ob);

			}

		}
	}

	void criteriaOrder(Session session) {
		Criteria cr = session.createCriteria(Student.class);
		Order order = Order.desc("marks");
		cr.addOrder(order);
		List<Student> studs = cr.list();
		for (Student s : studs) {
			System.out.println(s);

		}
	}

	void case2(Session session) {

		Criteria cr = session.createCriteria(Student.class);
		List<Student> sts = cr.list();
		for (Student s : sts) {
			System.out.println(s);

		}
	}

	void case1(Session session) {
		Transaction tr = session.beginTransaction();
		Student st1 = new Student(1, "aaa", 10);
		Student st2 = new Student(2, "bbb", 20);
		Student st3 = new Student(3, "ccc", 30);
		session.save(st1);
		session.save(st3);
		session.save(st2);
		tr.commit();
	}

	void parameterizedDmlHQL(Session session) {
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("update Student s set s.marks=:mrk where s.rollNo =:rno");
		query.setParameter("mrk", 50);
		query.setParameter("rno", 1);

		query.executeUpdate();
		tr.commit();
	}

	public static void main(String[] args) {
		System.out.println(
				" press 1 to add data \n press 2 to retrive data using QBC \n press 3 to retrive data using QBC and ordering");
		System.out.println(
				" press 4 to retrive data using QBC filteration/projection \n press 5 to retrive data using HQL ordering/filteration \n");
		System.out.println(
				" press 6 to perform DML operation using parameterized HQL position based/named based \n press 7 to retrive data using SQL");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		HibernateTasks ht = new HibernateTasks();
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		switch (option) {
		case 1: {
			ht.case1(session);
			break;
		}
		case 2: {
			ht.case2(session);
			break;
		}
		case 3: {
			ht.criteriaOrder(session);
			break;
		}
		case 4: {
			ht.projectionQBC(session);
			break;
		}
		case 5: {
			ht.orderingHQL(session);
			break;
		}
		case 6: {
			ht.parameterizedDmlHQL(session);
			break;
		}
		case 7: {
			ht.retrieveSQL(session);
			break;

		}
		}
	}

}
