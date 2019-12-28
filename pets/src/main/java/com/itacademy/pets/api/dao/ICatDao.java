package com.itacademy.pets.api.dao;

import java.util.List;

import com.itacademy.pets.entities.Cat;

public interface ICatDao {

	Cat create (Cat cat);
	
	Cat get (Long id);
	
	void update (Cat cat);
	
	void delete (Cat cat);
	
	List<Cat> getAll();
}