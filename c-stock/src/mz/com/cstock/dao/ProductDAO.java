package mz.com.cstock.dao;

import java.util.List;

import mz.com.cstock.model.Product;

public class ProductDAO extends GenericDAO<Product> {

	private static final long serialVersionUID = 1L;

	public ProductDAO() {
		super(Product.class);
		beginTransaction();
	}

	@Override
	public List<Product> findAll() {
		return super.findAll();
	}
}
