package com.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

public class UserServices {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private UserDAO dao;
	
	public UserServices() {
		emf = Persistence.createEntityManagerFactory("bookstorePU");
		em = emf.createEntityManager();
		
		dao = new UserDAO(em);
	}

	public List<User> listUser() {
		List<User> listUsers = dao.listAll();
		
		return listUsers;
	}
}
