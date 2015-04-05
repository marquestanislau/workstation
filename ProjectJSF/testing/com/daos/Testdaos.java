package com.daos;

import org.junit.Test;

import com.project.dao.ConnectionFactory;
import com.project.dao.UserDao;
import com.project.model.User;

public class Testdaos {

	private User user;

	@Test
	public void test() {
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		user = new User();
		user.setNome("Teste");
		user.setPassword("1212");
		dao.create(user);
		dao.commit();
		dao.close();
	}
}
