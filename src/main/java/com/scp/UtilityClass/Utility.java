/*package com.scp.UtilityClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

	public static final SessionFactory sessionFacctory;
	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFacctory = configuration.buildSessionFactory();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static final Session currentSession(){	
			Session session=session.getSession();
			if(session==null) {
			session=sessionFacctory.openSession();
			session.set
			}
			return null;
	
	

}
*/