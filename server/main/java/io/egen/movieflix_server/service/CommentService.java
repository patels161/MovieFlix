package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.comments;

public interface CommentService {
	
public List<comments> findAll();
	
	public comments findOne(String id);
	
	public comments create(comments cm);
	
	public comments update(String id, comments cm);
	
	public void delete(String id);
}
