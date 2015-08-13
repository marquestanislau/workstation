package com.project.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.project.repositorio.IMulta;
import com.project.repositorio.ITitular;
import com.project.repositorio.IUtilizador;
import com.project.repositorio.infra.MultasHibernate;
import com.project.repositorio.infra.TitularesHibernate;
import com.project.repositorio.infra.UsuariosHibernate;

public class Repositorio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
	
	public IUtilizador getUsuarios() {
		return new UsuariosHibernate(getSession());
	}
	
	public IMulta getMultas() {
		return new MultasHibernate(getSession());
	}
	
	public ITitular getTitulares() {
		return new TitularesHibernate(getSession());
	}

}
