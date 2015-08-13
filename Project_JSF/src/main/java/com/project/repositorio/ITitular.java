package com.project.repositorio;

import java.util.List;

import com.project.model.Titular;

public interface ITitular {

	public void guardar(Titular titular);
	public Titular porCodigo(Integer codigo);
	public List<Titular> todos();
	public void remover(Titular titular);
}
