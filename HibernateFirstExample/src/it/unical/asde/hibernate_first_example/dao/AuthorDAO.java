package it.unical.asde.hibernate_first_example.dao;

import java.util.List;

import it.unical.asde.hibernate_first_example.model.Author;

public interface AuthorDAO {
	
	void save(Author author);

	List<Author> getAllAuthors();
	
}
