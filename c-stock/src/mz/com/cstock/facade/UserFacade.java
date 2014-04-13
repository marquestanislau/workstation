package mz.com.cstock.facade;

import mz.com.cstock.dao.UserDAO;
import mz.com.cstock.model.User;

public class UserFacade {

	private UserDAO userDAO = null;

	public UserFacade() {
		userDAO = new UserDAO();
	}

	public boolean validateUser(String name, String password) {

		User user = userDAO.findByName(name);

		if (user != null && user.getPassword().equals(password))
			return true;

		return false;
	}
	
	public User findByName(String name) {
		return userDAO.findByName(name);
	}
}
