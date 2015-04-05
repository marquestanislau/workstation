package com.project.dao;

import javax.persistence.EntityManager;

import com.project.model.Titular;

public class TitularDao extends GenericDaoImpl<Titular, Integer> {
	
	public TitularDao(EntityManager entityManager) {
		super(entityManager);
	}
	
}
