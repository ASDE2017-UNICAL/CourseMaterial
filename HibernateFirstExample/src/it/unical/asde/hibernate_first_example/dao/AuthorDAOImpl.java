package it.unical.asde.hibernate_first_example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import it.unical.asde.hibernate_first_example.model.Author;

public class AuthorDAOImpl implements AuthorDAO {

	

	private static AuthorDAOImpl instance;
	
	public static AuthorDAOImpl getInstance() {
		if(instance==null) {
			instance = new AuthorDAOImpl();
		}
		return instance;
	}

	private SessionFactory sessionFactory;
	
	public AuthorDAOImpl() {

		sessionFactory = DBManager.getSessionFactory();
	}

	public void save(Author author) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(author);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}

	public List<Author> getAllAuthors() {
		Session session = sessionFactory.openSession();

		//sql query
		List<Author> result = session.createNativeQuery("SELECT * FROM author", Author.class).list();

		session.close();
		return result;

	}

}
