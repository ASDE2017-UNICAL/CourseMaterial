package it.unical.asde.hibernate_first_example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import it.unical.asde.hibernate_first_example.model.Author;
import it.unical.asde.hibernate_first_example.model.Book;

public class BooksDAOImpl implements BooksDAO {

	private SessionFactory sessionFactory;

	public BooksDAOImpl() {
		sessionFactory = DBManager.getSessionFactory();
	}

	public void save(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();

	}

	public Author getAuthorByTitle(String title) {

		Session session = sessionFactory.openSession();
		//hql query
		Author result = session.createQuery("select author from Book book where book.title=:title", Author.class)
				.setParameter("title", title).uniqueResult();

		session.close();
		return result;

	}

}
