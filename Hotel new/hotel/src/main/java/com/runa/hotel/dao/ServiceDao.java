package com.runa.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IServiceDao;
import com.runa.hotel.entities.Service;

@Repository
public class ServiceDao implements IServiceDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Service create(Service service) {
		entityManager.persist(service);
		return service;
	}

	@Override
	public Service get(Long id) {
		return entityManager.find(Service.class, id);
	}

	@Override
	public void update(Service service) {
		entityManager.merge(service);
		entityManager.flush();
	}

	@Override
	public void delete(Service service) {
		entityManager.remove(service);

	}

	@Override
	public List<Service> getAll() {
		return null;
	}

}
