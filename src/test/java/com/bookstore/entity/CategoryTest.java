package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

	public static void main(String[] args) {
		Category category = new Category();
		
		category.setName("Advanced Java");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstorePU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println("The category was saved");
	}
}
