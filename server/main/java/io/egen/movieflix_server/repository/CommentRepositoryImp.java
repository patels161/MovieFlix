package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.comments;

@Repository
public class CommentRepositoryImp implements CommentRepository{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<comments> findAll() {
		TypedQuery<comments> query = em.createNamedQuery("comments.findAll", comments.class);
		return query.getResultList();
	}

	@Override
	public comments findOne(String id) {
		return em.find(comments.class, id);
	}

	@Override
	public comments create(comments cm) {
		em.persist(cm);
		return cm;
	}
	
	@Override
	public comments update(comments cm) {
		return em.merge(cm);
	}

	@Override
	public void delete(comments cm) {
		em.remove(cm);;
	}

	@Override
	public List<comments> findByTitle(String id) {
		TypedQuery<comments> query = em.createNamedQuery("comments.findByTitle", comments.class);
		query.setParameter("pId", id);
		List<comments> cms = query.getResultList();
		if(cms!= null && cms.size() >=1) {
			return cms;
		}
		return null;
		
	}

}
