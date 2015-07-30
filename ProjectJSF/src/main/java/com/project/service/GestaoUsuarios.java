package com.project.service;

import com.project.model.User;
import com.project.repository.IUsuario;

public class GestaoUsuarios {

	private IUsuario usuarios;
	
	public GestaoUsuarios(IUsuario usuarios) {
		this.usuarios = usuarios;
	}
	
	public void guardar(User user) {
		this.usuarios.guardar(user);
	}

	public IUsuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(IUsuario usuarios) {
		this.usuarios = usuarios;
	}
	
}
