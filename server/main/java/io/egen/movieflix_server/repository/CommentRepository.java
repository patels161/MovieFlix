package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.comments;

public interface CommentRepository {


	public List<comments> findAll();
	
	public comments findOne(String id);
	
	public comments create(comments cm);
	
	//public comments update(String id, comments cm);
	
	public void delete(comments cm);
	
	public List<comments> findByTitle(String id);

	public comments update(comments cm);

	//void delete(comments cm);
}
