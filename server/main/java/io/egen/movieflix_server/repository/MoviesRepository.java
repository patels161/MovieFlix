package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.movies;

public interface MoviesRepository {

	public List<movies> findAll();
	
	public movies findOne(String title);
	
	public movies create(movies mv);
	
	public movies update(movies mv);
	
	//public void delete(movies mv);

	public movies findByTitle(String title);

	public void delete(movies mv);

	public List<movies> findByType(String Type);

	public List<movies> sortByImdbVotes();
	public List<movies> sortByYear();
	public List<movies> sortByRating();

	public movies findByYear(String year);
	public movies findByGenre(String genre);

	
}