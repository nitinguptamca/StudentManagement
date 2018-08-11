package com.intraedge.student.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<T> implements GenericDao<T> {
	
	/*private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentService");
	
	public static final ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();*/
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private Class<T> type;
	
	public GenericDaoImpl(){
		/*Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)t;
		type = (Class)pt.getActualTypeArguments()[0];*/
		
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.type = (Class<T>) (genericSuperclass.getActualTypeArguments()[0]);
	}
	
	/*public static EntityManager getEntityManager(){
		EntityManager em = emThreadLocal.get();
		if(em == null){
			em = emf.createEntityManager();
			emThreadLocal.set(em);
		}
		return em;
	}*/

	@Override
	public T persist(final T entity) {
		/*EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();*/
		getEntityManager().persist(entity);
		//tx.commit();
		return entity;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public T findById(Object id) {
		return getEntityManager().find(type, id);
	}

	@Override
	public T update(T entity) {
		return getEntityManager().merge(entity);
	}

}
