package it.unical.asde.login.tests;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import it.unical.asde.login.configuration.AppConfiguration;
import it.unical.asde.login.daos.UsersDao;
import it.unical.asde.login.model.Car;
import it.unical.asde.login.model.Credentials;
import it.unical.asde.login.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
@WebAppConfiguration
public class CarsAndUsersTest {

	@Autowired
	private UsersDao dao;

	@Autowired
	private SessionFactory sessionFactory;

	@Before
	public void cleanDatabase() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			session.createQuery("delete from User").executeUpdate();
			//session.createQuery("delete from Car").executeUpdate();
			//session.createQuery("delete from Credentials").executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	
	
	
	@Test
	public void testUserSave() {
		List<Car> ciccioCars = new ArrayList<>();
		User ciccio = new User(new Credentials("ciccio", "ciccio"), ciccioCars);
		ciccioCars.add(new Car(ciccio, "Fiat", "Punto", 1300));
		ciccioCars.add(new Car(ciccio, "Opel", "Astra", 1600));

		dao.saveUser(ciccio);

		User ciccioFromDb = dao.getUserByUsername("ciccio");

		Assert.assertEquals(2, ciccioFromDb.getCars().size());
	}

	@Test
	public void secondSaveTest() {
		dao.saveUser(new User(new Credentials("pippo", "pippo"), new ArrayList<>()));

		Assert.assertEquals(1, dao.getUsersCount());
	}

}
