package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.users;

public interface UserRepository {

	public List<users> findAll();
	
	public users findOne(String id);
	
	public users create(users us);
	
	//public users update(String id, users us);
	
	//public users delete(String id);

	public users findById(String id);

	void delete(users us);

	public users update(users us);

	public users findByEmail(String email);
}
