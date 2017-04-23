package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.movies;

public interface moviesService {

	public List<movies> findAll();
	
	public movies findOne(String title);
	
	public movies create(movies mv);
	
	public movies update(String title, movies mv);
	
	//public void delete(movies mv);

	public void delete(String title);
}
