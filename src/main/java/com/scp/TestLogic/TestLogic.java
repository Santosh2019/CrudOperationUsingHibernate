package com.scp.TestLogic;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.scp.bean.Employee;

public class TestLogic  {
	public static Logger logger = Logger.getLogger(TestLogic.class);
	
	public static void main(String[] args) throws Exception {
		logger.setLevel(Level.ALL);
		for (int i = 1; i < 10; i++) {
			
			logger.fatal("This is Fatal");
			logger.error("This is Error");
			logger.warn("This is Warn");
			logger.debug("This is debug");
			logger.trace("This is Trace");
				
			TimeUnit.SECONDS.sleep(10);
			
		}
		if (true) {
			return;
		}
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		String choice = "no";
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();

		List<Employee> list = session1.createQuery("from Employee").list();
		System.out.println("Hellooo" + list);

		Transaction tr;
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("1.Insert Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Delete Employee");
		System.out.println("4.View Employee");
		System.out.println("Enter Your Choice");
		int demand = scanner2.nextInt();

		switch (demand) {

		case 1:

			do {
				Employee employee1 = new Employee();
				tr = session1.beginTransaction();
				System.out.println("Enter Employee UserName:");
				employee1.setUserName(scanner.next());

				System.out.println("Enter Employee Password:");
				employee1.setPassword(scanner.next());
				session1.save(employee1);
				session1.flush();
				System.out.println("Record Inserted Sucessfully..");
				System.out.println("");
				System.out.println("Do you want to contine y/n ?");
				choice = scanner.next();
				tr.commit();
			} while (choice.equals("Yes") | choice.equalsIgnoreCase("y"));
			break;

		case 2: {

			do {

				Employee employee1 = new Employee();
				tr = session1.beginTransaction();
				System.out.println("Enter Employee UserName:");
				Employee employee3 = session1.get(Employee.class, (scanner.nextInt()));
				if (employee3 != null) {
					employee3.setUserName(scanner.next());
					System.out.println("Enter You Want to Update Name: ");
					session1.update(employee3);
					session1.flush();
					System.out.println("Record Update Sucessfully..");
					System.out.println("");
					System.out.println("Do you want to contine y/n ?");
					choice = scanner.next();
					tr.commit();

				} else {

				}

			} while (choice.equals("Yes") | choice.equalsIgnoreCase("y"));

		}

		case 3:
			do {

				Employee employee1 = new Employee();
				tr = session1.beginTransaction();
				System.out.println("Enter Employee Password:");
				Employee employee3 = session1.load(Employee.class, (scanner.next()));
				session1.delete(employee3);
				session1.flush();
				System.out.println("Record Deleted Sucessfully..");
				System.out.println("");
				System.out.println("Do you want to contine y/n ?");
				choice = scanner.next();
				tr.commit();

			} while (choice.equals("Yes") | choice.equalsIgnoreCase("y"));
			break;

		}
		System.out.println("Thank You!");
		scanner.close();
		session1.close();
		// sessionFactory.close();

	}

	public static boolean login(String UserName, String Password) {
		boolean b;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		String sql = "from Employee where  UserName=:'" + UserName + "'and Password=:'" + Password + "'";
		// Employee employee=session.get(Employee.class,sql )
		Query<Employee> query = session.createQuery(sql);

		List<Employee> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			b = true;
			System.out.println("Data match");
			return true;

		} else {
			return false;
		}
	}

}