package it.unical.asde.hibernate_first_example.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBManager {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
