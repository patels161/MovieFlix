package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.genre;

public interface GenreService {

	public List<genre> findAll();
	
	public genre findOne(String cat);
	
	public genre create(genre gn);
	
	public genre update(String cat, genre gn);
	
	public void delete(String cat);
}
