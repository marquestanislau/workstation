package com.project.dao;

import javax.persistence.EntityManager;

import com.project.model.Multa;

public class MultaDao extends GenericDaoImpl<Multa, Integer> {

	public MultaDao(EntityManager entityManager) {
		super(entityManager);
	}
}
