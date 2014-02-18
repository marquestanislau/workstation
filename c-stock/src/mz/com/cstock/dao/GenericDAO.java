package mz.com.cstock.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Class<T> entityClass;
	private static final EntityManagerFactory emf = ConnectionFactory.getConnection();
	private EntityManager manager;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void beginTransaction() {
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
	}

	public void commitTransaction() {
		manager.getTransaction().commit();
	}

	public void rollbackTransaction() {
		manager.getTransaction().rollback();
	}

	public void closeTransaction() {
		manager.close();
	}

	public void commitAndCloseTransaction() {
		commitTransaction();
		closeTransaction();
	}

	public void joinTransaction() {
		manager = emf.createEntityManager();
		manager.joinTransaction();
	}

	public void save(T persistedObject) {
		manager.persist(persistedObject);
	}

	public void delete(Object id, Class<T> classe) {
		T deletedObject = manager.getReference(classe, id);
		manager.remove(deletedObject);
	}

	public T update(T entity) {
		return manager.merge(entity);
	}

	public T find(Object id) {
		return manager.find(entityClass, id);
	}

	@SuppressWarnings({ "unchecked" })
    public List<T> findAll() {
        @SuppressWarnings("rawtypes")
		CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return manager.createQuery(cq).getResultList();
    }
}
