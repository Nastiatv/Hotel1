package com.runa.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.runa.hotel.api.dao.IRoomDao;
import com.runa.hotel.entities.Room;

@Repository
public class RoomDao implements IRoomDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Room create(Room room) {
		entityManager.persist(room);
		return room;
	}

	@Override
	public Room get(Long id) {
		return entityManager.find(Room.class, id);
	}

	@Override
	public void update(Room room) {
		entityManager.merge(room);
		entityManager.flush();
	}

	@Override
	public void delete(Room room) {
		entityManager.remove(room);

	}

	@Override
	public List<Room> getAll() {
		return null;
	}

}
