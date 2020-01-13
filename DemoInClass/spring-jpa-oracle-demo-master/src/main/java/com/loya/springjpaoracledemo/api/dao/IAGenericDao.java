package com.loya.springjpaoracledemo.api.dao;

import java.util.List;

import com.loya.springjpaoracledemo.entities.AEntity;

public interface IAGenericDao<T extends AEntity> {
	
	Class<T> getGenericClass();
	
	T create(T entity);
	
	T get(Integer id);
	
	void update (T entity);
	
	void delete (T entity);
	
	List<T> getAll();
}