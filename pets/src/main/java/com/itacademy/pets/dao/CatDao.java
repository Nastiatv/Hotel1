package com.itacademy.pets.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.itacademy.pets.api.dao.ICatDao;
import com.itacademy.pets.entities.Cat;

@Repository
public class CatDao implements ICatDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	public Cat create(Cat cat) {
		entityManager.persist(cat);
		return cat;
	}

	@Override
	public Cat get(Long id) {
		return entityManager.find(Cat.class, id);
	}

	@Override
	public void update(Cat cat) {
		entityManager.merge(cat);
		entityManager.flush();
	}

	@Override
	public void delete(Cat cat) {
		entityManager.remove(cat);
	}

	@Override
	public List<Cat> getAll() {
		return null;
	}
}