package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.ratings;

public interface RatingService {

public List<ratings> findAll();
	
	public ratings findOne(String title);
	
	//public ratings create(ratings rt);
	
	public ratings update(String title, ratings rt);
	
	public void delete(String title);


	public ratings create(String title, ratings rt);
}
