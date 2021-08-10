package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {

	protected EntityManager em;
	
	public JpaDAO(EntityManager em) {
		this.em = em;
	}
	
	public E create(E entity) {
		em.getTransaction().begin();
		
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		
		em.getTransaction().commit();
		
		return entity;
	}
	
	public E update(E entity) {
		em.getTransaction().begin();
		
		entity = em.merge(entity);
		
		em.getTransaction().commit();
		
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		E entity = em.find(type, id);
		
		if(entity != null) {
			em.refresh(entity);
		}
		
		return entity;
	}
	
	public void delete(Class<E> type, Object id) {
		em.getTransaction().begin();
		
		Object reference = em.getReference(type, id);
		
		em.remove(reference);
		
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName) {
		Query query = em.createNamedQuery(queryName);
		
		return query.getResultList();
	}
	
	public long countWithNamedQuery(String queryName) {
		Query query = em.createNamedQuery(queryName);
		
		return (long) query.getSingleResult();
	}
}
