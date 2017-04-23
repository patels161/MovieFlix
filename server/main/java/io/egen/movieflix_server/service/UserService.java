package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.users;

public interface UserService {

public List<users> findAll();
	
	public users findOne(String id);
	
	public users create(users us);
	
	public users update(String id, users us);
	
	public void delete(String id);
}
