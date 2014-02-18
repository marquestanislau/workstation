package mz.com.cstock.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	public static EntityManagerFactory getConnection() {
		return Persistence.createEntityManagerFactory("c-stock");
	}
}
