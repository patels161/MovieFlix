package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.genre;

public interface GenreRepository {

	public List<genre> findAll();
	
	public genre findOne(String cat);
	
	public genre create(genre gn);
	
	public genre update(String cat, genre gn);
	
	public void delete(genre gn);

	//public List<genre> getByCategory(String category);

	public List<genre> findByCategory(String cat);
}
