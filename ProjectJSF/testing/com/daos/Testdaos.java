package com.daos;

import org.junit.Test;

import com.project.dao.ConnectionFactory;
import com.project.dao.TitularDao;
import com.project.model.Titular;

public class Testdaos {

	@Test
	public void test() {
		TitularDao dao = new TitularDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		Titular t = new Titular();
		t =  dao.findAll().get(2);
		t.setContacto("1234567");
		dao.update(t);
		dao.commit();
		dao.close();
	}
}
