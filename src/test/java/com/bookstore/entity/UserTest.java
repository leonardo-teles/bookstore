package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {

	public static void main(String[] args) {
		User user = new User();
		user.setEmail("user_2@email.com");
		user.setFullname("Worker User Name");
		user.setPassword("helloworld");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookstorePU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println("The user was saved");
	}
}
