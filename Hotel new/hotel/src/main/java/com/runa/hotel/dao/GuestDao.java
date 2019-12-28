package com.runa.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IGuestDao;
import com.runa.hotel.entities.Guest;

@Repository
public class GuestDao implements IGuestDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Guest create(Guest guest) {
		entityManager.persist(guest);
		return guest;
	}

	@Override
	public Guest get(Long id) {
		return entityManager.find(Guest.class, id);
	}

	@Override
	public void update(Guest guest) {
		entityManager.merge(guest);
		entityManager.flush();
	}

	@Override
	public void delete(Guest guest) {
		entityManager.remove(guest);

	}

	@Override
	public List<Guest> getAll() {
		return null;
	}

}
