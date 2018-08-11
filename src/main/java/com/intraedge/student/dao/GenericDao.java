package com.intraedge.student.dao;

public interface GenericDao<T> {
	
	T persist(T entity);
	
	void remove(T entity);
	
	T findById(Object id);
	
	T update(T entity);

}
