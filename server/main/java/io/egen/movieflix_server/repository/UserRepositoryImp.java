package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.users;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<users> findAll() {
		TypedQuery<users> query = em.createNamedQuery("users.findAll", users.class);
		return query.getResultList();
	}

	@Override
	public users findById(String id) {
		return em.find(users.class, id);
	}

	@Override
	public users findByEmail(String email) {
		TypedQuery<users> query = em.createNamedQuery("users.findByEmail", users.class);
		query.setParameter("pEmail", email);
		List<users> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public users create(users emp) {
		em.persist(emp);
		return emp;
	}

	@Override
	public users update(users us) {
		return em.merge(us);
	}

	@Override
	public void delete(users us) {
		em.remove(us);
	}

	@Override
	public users findOne(String id) {
		return em.find(users.class, id);
	}
	
}
