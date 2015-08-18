package com.project.repositorio.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.Multa;
import com.project.model.Titular;
import com.project.repositorio.ITitular;

public class TitularesHibernate implements ITitular {

	private Session session;

	public TitularesHibernate(Session session) {
		this.session = session;
	}

	public void guardar(Titular titular) {
		session.merge(titular);
	}

	public Titular porCodigo(Integer codigo) {
		return (Titular) session.get(Multa.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Titular> todos() {
		return session.createCriteria(Titular.class)
				.addOrder(Order.asc("nome")).list();
	}

	public void remover(Titular titular) {
		session.delete(titular);
	}

}
