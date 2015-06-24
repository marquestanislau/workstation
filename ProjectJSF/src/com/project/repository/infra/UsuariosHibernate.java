package com.project.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.project.model.User;
import com.project.repository.IUsuario;

public class UsuariosHibernate implements IUsuario {

	private Session session;

	public UsuariosHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> todos() {
		return session.createCriteria(User.class).addOrder(Order.asc("nome"))
				.list();
	}

	@Override
	public void guardar(User user) {
		session.merge(user);
	}

	@Override
	public User porCodigo(Long codigo) {
		return (User) session.get(User.class, codigo);
	}

	@Override
	public void apagar(User user) {
		this.session.delete(user);
	}
	
	

}
