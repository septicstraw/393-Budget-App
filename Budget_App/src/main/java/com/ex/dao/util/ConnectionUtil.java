package com.ex.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConnectionUtil {
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
			.configure("com/ex/resources/hibernate.cfg.xml").buildSessionFactory();

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
