package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.ratings;

public interface RatingRepository {

public List<ratings> findAll();
	
	public ratings findOne(String title);
	
	public ratings create(ratings rt);
	
	public ratings update(ratings rt);
	
	//public ratings delete(String title);

	public void delete(ratings rt);
	//public ratings findByTitle(String title);

	List<ratings> findByUMId(String userId, String movieId);
}
