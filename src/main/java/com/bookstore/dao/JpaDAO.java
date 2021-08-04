package com.bookstore.dao;

import javax.persistence.EntityManager;

public class JpaDAO<T> {

	protected EntityManager em;
	
	public JpaDAO() {}

	public JpaDAO(EntityManager em) {
		this.em = em;
	}
	
	public T create(T t) {
		em.getTransaction().begin();
		
		em.persist(t);
		em.flush();
		em.refresh(t);
		
		em.getTransaction().commit();
		
		return t;
	}
}
