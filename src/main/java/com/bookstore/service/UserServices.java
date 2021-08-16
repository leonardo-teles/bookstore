package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUsers = dao.listAll();
		
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("message", "New User Created Successfully");
		
		String listPage = "user_list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
		
	}
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		User user = new User(email, fullName, password);
		dao.create(user);
	}
}
