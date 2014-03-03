package mz.com.cstock.dao;

import mz.com.cstock.model.LogedUser;

public class LogedUserDAO extends GenericDAO<LogedUser> {

	private static final long serialVersionUID = 1L;

	public LogedUserDAO() {
		super(LogedUser.class);
		beginTransaction();
	}
}
