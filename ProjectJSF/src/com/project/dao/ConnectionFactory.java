package com.project.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static final String PU = "projectPU";
	
	public static EntityManagerFactory getConnection() {
		return Persistence.createEntityManagerFactory(PU);
	}
}
