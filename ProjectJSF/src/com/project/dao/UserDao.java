package com.project.dao;

import javax.persistence.EntityManager;

import com.project.model.User;

public class UserDao extends GenericDaoImpl<User, Long> {

	public UserDao(EntityManager enManager) {
		super(enManager);
	}
}
