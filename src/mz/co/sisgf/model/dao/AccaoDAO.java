package mz.co.sisgf.model.dao;

import javax.persistence.EntityManager;

import mz.co.sisgf.model.Accao;

public class AccaoDAO extends GenericDAO<Long, Accao>{

	public AccaoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
