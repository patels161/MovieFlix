package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.comments;
import io.egen.movieflix_server.exception.CommentNotFoundException;
import io.egen.movieflix_server.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository repository;

	public List<comments> findAll() {
		return repository.findAll();
	}

	@Override
	public comments findOne(String id) {
		comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public comments create(comments cm) {
		return repository.create(cm);
	}

	@Override
	@Transactional
	public comments update(String id, comments cm) {
		comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Not found");
		}
		return repository.update(cm);
	}

	@Override
	@Transactional
	public void delete(String id) {
		comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Not found");
		}
		repository.delete(existing);
	}
}
