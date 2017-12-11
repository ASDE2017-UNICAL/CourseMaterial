package it.unical.asde.hibernate_first_example.dao;

import it.unical.asde.hibernate_first_example.model.Author;
import it.unical.asde.hibernate_first_example.model.Book;

public interface BooksDAO {

	void save(Book book);
	
	Author getAuthorByTitle(String title);
}
