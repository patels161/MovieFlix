package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.ratings;

@Repository
public class RatingRepositoryImp implements RatingRepository{

	@PersistenceContext
	public EntityManager em;
	
	@Override
	public List<ratings> findAll() {
		TypedQuery<ratings> query = em.createNamedQuery("ratings.findAll", ratings.class);
		return query.getResultList();
	}
	
	@Override
	public ratings findOne(String title) {
		return em.find(ratings.class, title);
	}

	@Override
	public ratings create(ratings rt) {
		em.persist(rt);
		return rt;
	}

	@Override
	public ratings update(ratings rt) {
		return em.merge(rt);
	}

	@Override
	public void delete(ratings rt) {
		em.remove(rt);
	}

	@Override
	public List<ratings> findByUMId(String uId, String mId) {
		TypedQuery<ratings> query = em.createNamedQuery("ratings.findByUMId", ratings.class);
		query.setParameter("pUserId", uId); 
		query.setParameter("pMovieId", mId);
		return query.getResultList();
	}
	
	
}
