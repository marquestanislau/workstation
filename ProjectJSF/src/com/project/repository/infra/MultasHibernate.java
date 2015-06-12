package com.project.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Multa;
import com.project.repository.IMulta;

public class MultasHibernate implements IMulta {

	private Session session;

	public MultasHibernate(Session session) {
		this.session = session;
	}

	@Override
	public List<Multa> todos() {
		return session.createCriteria(Multa.class).addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public void guardar(Multa multa) {
		session.merge(multa);
	}

	@Override
	public void remover(Multa multa) {
		session.delete(multa);
	}

	@Override
	public Multa porCodigo(Integer codigo) {
		return (Multa) session.get(Multa.class, codigo);
	}

}
