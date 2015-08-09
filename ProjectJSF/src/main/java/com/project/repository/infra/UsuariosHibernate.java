package com.project.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Utilizador;
import com.project.repository.IUtilizador;

public class UsuariosHibernate implements IUtilizador {

	private Session session;

	public UsuariosHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilizador> todos() {
		return session.createCriteria(Utilizador.class).addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public void guardar(Utilizador user) {
		session.merge(user);
	}

	@Override
	public Utilizador porCodigo(Integer codigo) {
		return (Utilizador) session.get(Utilizador.class, codigo);
	}

	@Override
	public void apagar(Utilizador user) {
		this.session.delete(user);
	}

}
