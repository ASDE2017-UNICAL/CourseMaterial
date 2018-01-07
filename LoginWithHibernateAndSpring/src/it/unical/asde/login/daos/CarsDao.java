package it.unical.asde.login.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.unical.asde.login.model.Car;

@Repository
public class CarsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveCredentials(Car car) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(car);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();

	}
	

}
