package com.scp.TestLogic;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.scp.bean.Employee;

public class TestLogic {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String choice = "no";
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
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
				System.out.println("Enter Employee Name:");
				employee1.setEmployeeName(scanner.next());
				// System.out.println("Enter Employee Id:");
				// employee1.setEmployeeId(scanner.nextInt());
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
				System.out.println("Enter Employee Id:");
				Employee employee3 = session1.get(Employee.class, (scanner.nextInt()));
				if (employee3 != null) {
					employee3.setEmployeeName(scanner.next());
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
				System.out.println("Enter Employee Id:");
				Employee employee3 = session1.load(Employee.class, (scanner.nextInt()));
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
		sessionFactory.close();

	}

	public static boolean login(int emloyeeId, String employeeName) {
		boolean b;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		String sql = "from Employee where  employeeId='" + emloyeeId + "'and employeeName='" + employeeName + "'";
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