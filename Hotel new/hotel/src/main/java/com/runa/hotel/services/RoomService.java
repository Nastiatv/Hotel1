package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runa.hotel.api.dao.IRoomDao;
import com.runa.hotel.api.service.IRoomService;

@Service
@Transactional
public class RoomService implements IRoomService {

	@Autowired
	private IRoomDao roomDao;

	@Override
	public com.runa.hotel.entities.Room get(Long id) {
		return roomDao.get(id);
	}

	@Override
	public void update(com.runa.hotel.entities.Room room) {
		roomDao.update(room);

	}

	@Override
	public void delete(com.runa.hotel.entities.Room room) {
		roomDao.delete(room);

	}

	@Override
	public List<com.runa.hotel.entities.Room> getAll() {
		return null;
	}

	@Override
	public com.runa.hotel.entities.Room create(com.runa.hotel.entities.Room room) {
		return roomDao.create(room);
	}
}
