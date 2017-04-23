package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.genre;

@Repository
public class GenreRepositoryImp implements GenreRepository {

	@PersistenceContext
	public EntityManager em;
	public List<genre> findAll() {
		TypedQuery<genre> query = em.createNamedQuery("genre.findAll", genre.class);
		return query.getResultList();
	}

	@Override
	public genre findOne(String cat) {
		return em.find(genre.class, cat);
	}

	@Override
	public genre create(genre gn) {
		em.persist(gn);
		return gn;
	}

	@Override
	public genre update(String cat, genre gn) {
		return em.merge(gn);
	}

	@Override
	public void delete(genre gn) {
		em.remove(gn);
	}

	@Override
	public List<genre> findByCategory(String category) {
		TypedQuery<genre> query = em.createNamedQuery("genre.findByCategory", genre.class);
		query.setParameter("pGenre", category);
		return query.getResultList();
	}

}
