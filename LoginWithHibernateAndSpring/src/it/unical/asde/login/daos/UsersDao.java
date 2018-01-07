package it.unical.asde.login.daos;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.unical.asde.login.model.User;

@Repository
public class UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}

	public User getUserByUsername(String username) {

		Session session = sessionFactory.openSession();

		User singleResult = session.createQuery("from User u join fetch u.cars where u.credentials.username=:u", User.class)
				.setParameter("u", username).getSingleResult();

		session.close();
		return singleResult;

	}
	
	public int getUsersCount() {
		Session session = sessionFactory.openSession();
		
		int result = session.createQuery("from User u", User.class).list().size();
		
		session.close();
		return result;
	}
	
	

}
