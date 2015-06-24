package com.project.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.project.repository.IMulta;
import com.project.repository.ITitular;
import com.project.repository.IUsuario;
import com.project.repository.infra.MultasHibernate;
import com.project.repository.infra.TitularesHibernate;
import com.project.repository.infra.UsuariosHibernate;

public class Repositorio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1921518600016820244L;

	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
	
	public IUsuario getUsuarios() {
		return new UsuariosHibernate(getSession());
	}
	
	public IMulta getMultas() {
		return new MultasHibernate(getSession());
	}
	
	public ITitular getTitulares() {
		return new TitularesHibernate(getSession());
	}

}
