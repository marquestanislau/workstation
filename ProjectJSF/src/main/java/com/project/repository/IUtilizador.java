package com.project.repository;

import java.util.List;

import com.project.model.Utilizador;

public interface IUtilizador {

	public List<Utilizador> todos();
	public void guardar(Utilizador user);
	public Utilizador porCodigo(Integer codigo);
	public void apagar(Utilizador user);
}
