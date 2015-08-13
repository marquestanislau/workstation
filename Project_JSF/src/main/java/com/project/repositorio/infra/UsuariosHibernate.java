package com.project.repositorio.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Utilizador;
import com.project.repositorio.IUtilizador;

public class UsuariosHibernate implements IUtilizador {

	private Session session;

	public UsuariosHibernate(Session session) {
		this.session = session;
	}

	public List<Utilizador> todos() {
		return session.createCriteria(Utilizador.class).addOrder(Order.asc("nome"))
				.list();
	}

	public void guardar(Utilizador user) {
		session.merge(user);
	}

	public Utilizador porCodigo(Integer codigo) {
		return (Utilizador) session.get(Utilizador.class, codigo);
	}

	public void apagar(Utilizador user) {
		this.session.delete(user);
	}

}
