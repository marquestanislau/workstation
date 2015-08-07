package com.project.service;

import com.project.model.Utilizador;
import com.project.repository.IUtilizador;

public class GestaoUsuarios {

	private IUtilizador usuarios;
	
	public GestaoUsuarios(IUtilizador usuarios) {
		this.usuarios = usuarios;
	}
	
	public void guardar(Utilizador user) {
		this.usuarios.guardar(user);
	}

	public IUtilizador getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(IUtilizador usuarios) {
		this.usuarios = usuarios;
	}
	
}
