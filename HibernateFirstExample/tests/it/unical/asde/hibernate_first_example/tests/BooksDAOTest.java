package it.unical.asde.hibernate_first_example.tests;

import org.junit.Assert;
import org.junit.Test;

import it.unical.asde.hibernate_first_example.dao.BooksDAO;
import it.unical.asde.hibernate_first_example.dao.BooksDAOImpl;
import it.unical.asde.hibernate_first_example.model.Author;
import it.unical.asde.hibernate_first_example.model.Book;

public class BooksDAOTest {
	
	@Test
	public void basicTest() {
		BooksDAO dao = new BooksDAOImpl();
		
		dao.save(new Book("The lord of the rings", new Author("J.R.R. Tolkien", "English"), "Bompiani"));
		
		Author author = dao.getAuthorByTitle("The lord of the rings");
		
		Assert.assertEquals("J.R.R. Tolkien", author.getName());
	}

}
