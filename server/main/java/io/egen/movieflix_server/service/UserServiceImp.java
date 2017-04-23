package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import io.egen.movieflix_server.entity.users;
import io.egen.movieflix_server.exception.UserAlreadyExistsException;
import io.egen.movieflix_server.exception.UserNotFoundException;
import io.egen.movieflix_server.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public List<users> findAll() {
		return repository.findAll();
	}

	@Override
	public users findOne(String id) {
		users existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("Notfound");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public users create(users us) {
		users existing = repository.findByEmail(us.getEmail());
		if(existing != null){
			throw new UserAlreadyExistsException("Already exists");
		}
		return repository.create(us);
	}

	@Override
	@Transactional
	public users update(String email, users us) {
		users existing = repository.findByEmail(email);
		if(existing == null){
			throw new UserNotFoundException("Not found");
		}
		return repository.create(us);
	}

	@Override
	@Transactional
	public void delete(String id) {
		users existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("Not found");
		}
		repository.delete(existing);
	}

}
