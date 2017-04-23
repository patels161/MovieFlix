package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.genre;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.GenreRepository;

@Service
public class GenreServiceImp implements GenreService{

	@Autowired
	GenreRepository repository;

	@Override
	public List<genre> findAll() {
		return repository.findAll();
	}

	@Override
	public genre findOne(String cat) {
		genre existing = repository.findOne(cat);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		return repository.findOne(cat);
	}

	@Override
	@Transactional
	public genre create(genre gn) {
		genre existing = repository.findOne(gn.getCategory());
		if(existing != null){
			throw new AlreadyExistsException("Already exists");
		}
		return repository.create(gn);
	}

	@Override
	@Transactional
	public genre update(String cat, genre gn) {
		genre existing = repository.findOne(cat);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		return repository.update(cat, gn);
	}

	@Override
	@Transactional
	public void delete(String cat) {
		genre existing = repository.findOne(cat);
		if(existing == null){
			throw new NotFoundException("Not found");
		}
		repository.delete(existing);
	}
}
