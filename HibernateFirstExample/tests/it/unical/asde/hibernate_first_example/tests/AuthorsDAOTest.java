package it.unical.asde.hibernate_first_example.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.hibernate_first_example.dao.AuthorDAO;
import it.unical.asde.hibernate_first_example.dao.AuthorDAOImpl;
import it.unical.asde.hibernate_first_example.model.Author;

public class AuthorsDAOTest {
	
	@Test
	public void saveTest() {
		AuthorDAO dao = AuthorDAOImpl.getInstance();
		Author pippo = new Author("pippo", "Italy");
		dao.save(new Author("ciccio", "Italy"));
		dao.save(pippo);
		List<Author> allAuthors = dao.getAllAuthors();
		
		Assert.assertTrue(allAuthors.contains(pippo));
	}

}
