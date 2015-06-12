package com.project.service;

import com.project.model.User;
import com.project.repository.IUsusario;

public class GestaoUsuarios {

	private IUsusario usuarios;
	
	public GestaoUsuarios(IUsusario usuarios) {
		this.usuarios = usuarios;
	}
	
	public void guardar(User user) {
		this.usuarios.guardar(user);
	}

	public IUsusario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(IUsusario usuarios) {
		this.usuarios = usuarios;
	}
	
}
