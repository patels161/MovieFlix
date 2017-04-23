package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.ratings;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.RatingRepository;


@Service
public class RatingServiceImp implements RatingService{

	@Autowired
	RatingRepository repository;
	

	@Override
	public List<ratings> findAll() {
		return repository.findAll();
	}

	@Override
	public ratings findOne(String title) {
		ratings existing = repository.findOne(title);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public ratings create(String title, ratings rt) {
		ratings existing = repository.findOne(title);
		if(existing == null){
			throw new AlreadyExistsException("Not found");
		}
		return repository.create(rt);
	}
	
	@Override
	@Transactional
	public ratings update(String title, ratings rt) {
		ratings existing = repository.findOne(title);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		return repository.update(rt);
	}

	@Override
	@Transactional
	public void delete(String title) {
		ratings existing = repository.findOne(title);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		repository.delete(existing);
	}
}
