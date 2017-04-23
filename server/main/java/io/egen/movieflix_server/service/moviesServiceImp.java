package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.movies;
import io.egen.movieflix_server.exception.MovieAlreadyExistsException;
import io.egen.movieflix_server.exception.MovieNotFoundException;
import io.egen.movieflix_server.repository.MoviesRepository;

@Service
public class moviesServiceImp implements moviesService{

	@Autowired
	MoviesRepository repository;
	@Override
	public List<movies> findAll() {
		return repository.findAll();
	}

	@Override
	public movies findOne(String title) {
		movies existing = repository.findOne(title);
		if(existing == null){
			throw new MovieNotFoundException("Not found");
		}
		return repository.findOne(title);
	}

	@Override
	@Transactional
	public movies create(movies mv) {
		movies existing = repository.findOne(mv.getTitle());
		if(existing != null){
			throw new MovieAlreadyExistsException("Already exists");
		}
		return repository.create(mv);
	}

	@Override
	@Transactional
	public movies update(String title,movies mv) {
		movies existing = repository.findOne(title);
		if(existing == null){
			throw new MovieNotFoundException("Not found");
		}
		return repository.update(mv);
	}

	@Override
	@Transactional
	public void delete(String title) {
		movies existing = repository.findOne(title);
		if(existing == null){
			throw new MovieNotFoundException("Not found");
		}
		repository.delete(existing);
	}
	
	
}
