package com.project.repositorio.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Multa;
import com.project.repositorio.IMulta;

public class MultasHibernate implements IMulta {

	private Session session;

	public MultasHibernate(Session session) {
		this.session = session;
	}

	public List<Multa> todos() {
		return session.createCriteria(Multa.class).addOrder(Order.asc("nome"))
				.list();
	}

	public void guardar(Multa multa) {
		session.merge(multa);
	}

	public void remover(Multa multa) {
		session.delete(multa);
	}

	public Multa porCodigo(Integer codigo) {
		return (Multa) session.get(Multa.class, codigo);
	}

}