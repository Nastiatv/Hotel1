package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.service.IGuestService;
import com.hotel.dao.GuestDao;
import com.hotel.entities.Guest;


public class GuestService implements IGuestService {

	@Override
	public void addGuest(Guest guest) {
		if (!getAllGuestId().contains(guest.getId())) {
			GuestDao.getInstance().addGuestToList(guest);
		} else {
			System.out.println("Such a guest already exists");
		}
	}

	@Override
	public Guest getGuest(int id) {
		if (getAllGuestId().contains(id)) {
			return GuestDao.getInstance().getGuestFromList(id);
		} else {
			System.out.println("There are no such guest");
			return null;
		}
	}

	@Override
	public void deleteGuest(int id) {
		if (getAllGuestId().contains(id)) {
			GuestDao.getInstance().deleteGuestFromList(id);
		} else {
			System.out.println("There are no such guest");
		}
	}

	@Override
	public List<Guest> getAll() {
		return GuestDao.getInstance().getAllListGuests();
	}

		private List<Integer> getAllGuestId() {
		List<Integer> getAllGuestId = GuestDao.getInstance().getAllListGuests().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllGuestId;
	}
}