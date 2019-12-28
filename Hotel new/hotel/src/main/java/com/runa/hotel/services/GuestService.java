package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runa.hotel.api.dao.IGuestDao;
import com.runa.hotel.api.service.IGuestService;

@Service
@Transactional
public class GuestService implements IGuestService {

	@Autowired
	private IGuestDao guestDao;

	@Override
	public com.runa.hotel.entities.Guest get(Long id) {
		return guestDao.get(id);
	}

	@Override
	public void update(com.runa.hotel.entities.Guest guest) {
		guestDao.update(guest);

	}

	@Override
	public void delete(com.runa.hotel.entities.Guest guest) {
		guestDao.delete(guest);

	}

	@Override
	public List<com.runa.hotel.entities.Guest> getAll() {
		return null;
	}

	@Override
	public com.runa.hotel.entities.Guest create(com.runa.hotel.entities.Guest guest) {
		return guestDao.create(guest);
	}
}
