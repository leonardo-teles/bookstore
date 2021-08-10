package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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
		user.setEmail("leonardo@email.com");
		user.setFullName("Administrator");
		user.setPassword("theboss");
		
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
		user.setFullName("Most Common User");
		user.setPassword("secret");
		
		String expected = "secret";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
		
		user = dao.update(user);
	}
	
	@Test
	public void testGetUserFound() {
		Integer userId = 6;
		User user = dao.get(userId);
		
		if(user != null) {
			System.out.println(user.getEmail());
		}
		
		assertNotNull(user);
	}
	
	@Test
	public void testGetUserNotFound() {
		Integer userId = 99;
		User user = dao.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 7;
		dao.delete(userId);
		
		User user = dao.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistedUser() {
		Integer userId = 99;
		dao.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<User> listUsers = dao.listAll();
		
		for(User user : listUsers) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = dao.count();
		
		assertEquals(2, totalUsers);
	}

	@AfterClass
	public static void tearDown() {
		em.close();
		emf.close();
	}
}
