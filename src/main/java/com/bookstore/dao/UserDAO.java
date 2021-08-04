package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.User;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User> {
	
	public UserDAO(EntityManager em) {
		super(em);
	}

	@Override
	public User create(User user) {
		return super.create(user);
	}
	
	@Override
	public User update(User user) {
		return super.update(user);
	}

	@Override
	public User get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


}
