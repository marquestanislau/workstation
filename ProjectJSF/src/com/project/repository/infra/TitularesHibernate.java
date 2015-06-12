package com.project.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Multa;
import com.project.model.Titular;
import com.project.repository.ITitular;

public class TitularesHibernate implements ITitular {

	private Session session;

	public TitularesHibernate(Session session) {
		this.session = session;
	}

	@Override
	public void guardar(Titular titular) {
		session.merge(titular);
	}

	@Override
	public Titular porCodigo(Integer codigo) {
		return (Titular) session.get(Multa.class, codigo);
	}

	@Override
	public List<Titular> todos() {
		return session.createCriteria(Titular.class)
				.addOrder(Order.asc("nome")).list();
	}

	@Override
	public void remover(Titular titular) {
		session.delete(titular);
	}

}
