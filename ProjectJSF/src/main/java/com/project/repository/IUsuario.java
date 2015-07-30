package com.project.repository;

import java.util.List;

import com.project.model.User;

public interface IUsuario {

	public List<User> todos();
	public void guardar(User user);
	public User porCodigo(Long codigo);
	public void apagar(User user);
}
