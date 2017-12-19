package it.unical.asde.login.daos;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.unical.asde.login.model.Credentials;

@Repository
public class CredentialsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() {
		saveCredentials(new Credentials("ciccio", "ciccio"));
		saveCredentials(new Credentials("pippo", "pippo"));
	}

	public boolean credentialsExist(String username, String password) {

		Session session = sessionFactory.openSession();

		boolean success = !session
				.createQuery("from Credentials c where c.username=:u and c.password=:p", Credentials.class)
				.setParameter("u", username).setParameter("p", password).list().isEmpty();

		session.close();
		return success;

	}

	public void saveCredentials(Credentials credentials) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(credentials);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}

}
