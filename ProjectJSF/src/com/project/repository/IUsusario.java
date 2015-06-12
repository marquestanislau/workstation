package com.project.repository;

import java.util.List;

import com.project.model.User;

public interface IUsusario {

	public List<User> todos();
	public void guardar(User user);
	public User porCodigo(Long codigo);
}
