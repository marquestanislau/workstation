package mz.co.sisgf.model.dao;

import javax.persistence.EntityManager;

import mz.co.sisgf.model.Banco;

public class BancoDAO extends GenericDAO<Long, Banco>{

	public BancoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
