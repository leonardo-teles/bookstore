package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.User;

public class UserDAOTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static UserDAO dao;
	
	@BeforeClass
	public static void setUp() {
		emf = Persistence.createEntityManagerFactory("bookstorePU");
		em = emf.createEntityManager();
		
		dao = new UserDAO(em);
	}

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("user_2@email.com");
		user.setFullname("Common User_2");
		user.setPassword("theworker");
		
		user = dao.create(user);
		
		assertTrue(user.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUserFieldsNotSet() {
		User user = new User();
		
		user = dao.create(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUserId(6);
		user.setEmail("user@email.com");
		user.setFullname("Most Common User");
		user.setPassword("secret");
		
		String expected = "secret";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
		
		user = dao.update(user);
	}

	@AfterClass
	public static void tearDown() {
		em.close();
		emf.close();
	}
}
