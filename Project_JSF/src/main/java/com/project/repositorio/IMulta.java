package com.project.repositorio;

import java.util.List;

import com.project.model.Multa;

public interface IMulta {
	
	public List<Multa> todos();
	public void guardar(Multa multa);
	public void remover(Multa multa);
	public Multa porCodigo(Integer codigo);

}
