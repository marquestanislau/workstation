package mz.com.cstock.dao;

import mz.com.cstock.model.Supplier;

public class SupplierDAO extends GenericDAO<Supplier> {

	private static final long serialVersionUID = 1L;

	public SupplierDAO() {
		super(Supplier.class);
		beginTransaction();
	}
}
