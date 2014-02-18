package mz.com.cstock.dao;

import java.util.Iterator;

import mz.com.cstock.model.User;

public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 1L;

	public UserDAO() {
		super(User.class);
		beginTransaction();
	}

	public User findByName(String name) {
		
		Iterator<User> it = findAll().iterator();
		User user = null;
		
		while(it.hasNext()) {
			user = it.next();
			
			if(name.equals(user.getName()))
				return user;
		}
		
		return null;
		
	}
}
