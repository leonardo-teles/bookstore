package com.bookstore.dao;

import javax.persistence.EntityManager;

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
}
