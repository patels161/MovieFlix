package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.movies;

@Repository
public class moviesRepositoryImp implements MoviesRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<movies> findAll() {
		TypedQuery<movies> query = em.createNamedQuery("movies.findAll", movies.class);
		return query.getResultList();
	}
	
	@Override
	public movies findOne(String title) {
		return em.find(movies.class, title);
	}
	@Override
	public movies create(movies mv) {
		em.persist(mv);
		return mv;
	}
	@Override
	public movies update(movies mv) {
		return em.merge(mv);
	}
	@Override
	public void delete(movies mv) {
		em.remove(mv);
	}
	@Override
	public movies findByTitle(String title) {
		TypedQuery<movies> query = em.createNamedQuery("movies.findByTitle", movies.class);
		query.setParameter("pTitle", title);
		List<movies> movies = query.getResultList();
		if(movies != null && movies.size()==1){
			return movies.get(0);
		}
		return null;
	}
	@Override
	public movies findByYear(String year) {
		TypedQuery<movies> query = em.createNamedQuery("movies.findByYear", movies.class);
		query.setParameter("pYear", year);
		List<movies> movies = query.getResultList();
		if(movies != null && movies.size()==1){
			return movies.get(0);
		}
		return null;
	}
	@Override
	public movies findByGenre(String genre) {
		TypedQuery<movies> query = em.createNamedQuery("movies.findByGenre", movies.class);
		query.setParameter("pGenre", genre);
		List<movies> movies = query.getResultList();
		if(movies != null && movies.size()==1){
			return movies.get(0);
		}
		return null;
	}
	@Override
	public List<movies> findByType(String Type) {
		TypedQuery<movies> query = em.createQuery("Select m from movies m where m.Type= :pType", movies.class);
		query.setParameter("pType", Type);
		return query.getResultList();
	}
	@Override
	public List<movies> sortByImdbVotes() {
		TypedQuery<movies> query = em.createQuery("Select m from movies m ORDER BY m.imdbVotes DESC", movies.class);
		List<movies> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("Empty list, please try another");
			return null;
		}
		else {
			return query.getResultList();
		}
	}
	@Override
	public List<movies> sortByYear() {
		TypedQuery<movies> query = em.createQuery("Select m from movies m ORDER BY m.year DESC", movies.class);
		List<movies> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("Empty list, please try another");
			return null;
		}
		else {
			return query.getResultList();
		}
	}
	@Override
	public List<movies> sortByRating() {
		TypedQuery<movies> query = em.createQuery("Select m from movies m ORDER BY m.imdbRating DESC", movies.class);
		List<movies> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("Empty list, please try another");
			return null;
		}
		else {
			return query.getResultList();
		}
	}
}
