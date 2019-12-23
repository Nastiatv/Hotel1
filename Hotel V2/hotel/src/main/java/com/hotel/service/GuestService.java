package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.service.IGuestService;
import com.hotel.dao.GuestDao;
import com.hotel.entity.Guest;

public class GuestService implements IGuestService {
	
	private static final Logger logger =LoggerFactory.getLogger(GuestService.class);
	
	@Override
	public void addGuest(Guest guest) {
		if (!getAllGuestId().contains(guest.getId())) {
			GuestDao.getInstance().addGuestToList(guest);
		} else {
			logger.info("Such a guest already exists");
		}
	}

	@Override
	public Guest getGuest(int id) {
		if (getAllGuestId().contains(id)) {
			return GuestDao.getInstance().getGuestFromList(id);
		} else {
			logger.info("There are no such guest");
			return null;
		}
	}

	@Override
	public void deleteGuest(int id) {
		if (getAllGuestId().contains(id)) {
			GuestDao.getInstance().deleteGuestFromList(id);
		} else {
			logger.info("There are no such guest");
			}
	}

	@Override
	public List<Guest> getAll() {
		return GuestDao.getInstance().getAllListGuests();
	}

	private List<Integer> getAllGuestId() {
		return GuestDao.getInstance().getAllListGuests().stream().map(Guest::getId).collect(Collectors.toList());

	}
}