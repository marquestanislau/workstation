package mz.com.cstock.dao;

import mz.com.cstock.model.Compra;

public class CompraDAO extends GenericDAO<Compra>{

	public CompraDAO() {
		super(Compra.class);
		super.beginTransaction();
	}

	private static final long serialVersionUID = 1L;

}
