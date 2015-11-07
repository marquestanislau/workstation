package mz.co.sisgf.model.dao;

import javax.persistence.EntityManager;

import mz.co.sisgf.model.Utilizador;

public class UtilizadorDao extends GenericDAO<Long, Utilizador> {

	public UtilizadorDao(EntityManager entityManager) {
		super(entityManager);
	}

}
