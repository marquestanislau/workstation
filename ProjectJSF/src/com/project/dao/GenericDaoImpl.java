package com.project.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDaoImpl<T, PK extends Serializable> implements
		IGenericDao<T, PK> {

	protected EntityManager entityManager;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass()
				.getGenericSuperclass();	
		this.entityClass = (Class<T>) genericSuperClass
				.getActualTypeArguments()[0];
	}

	public GenericDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(PK id) {
		if(entityClass == null) {
			entityClass = (Class<T>) getClassType();
		}
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);

	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query q = this.entityManager.createQuery("select e from "
				+ getClassType().getName() + " e");
		return q.getResultList();
	}

	private Class<?> getClassType() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return (Class<?>) genericSuperClass.getActualTypeArguments()[0];
	}
	
	public void begin() {
		this.entityManager.getTransaction().begin();
	}
	
	public void commit() {
		this.entityManager.getTransaction().commit();
	}
	
	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}
	
	public void close() {
		this.entityManager.close();
	}
}
