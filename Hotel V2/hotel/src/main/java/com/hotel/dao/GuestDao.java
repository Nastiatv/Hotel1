package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IGuestDao;
import com.hotel.entity.Guest;

public class GuestDao implements IGuestDao {

	private List<Guest> guestInHotel = new ArrayList<>();

	private static GuestDao guestDao;

	public static GuestDao getInstance() {
		if (guestDao == null) {
			guestDao = new GuestDao();
		}
		return guestDao;
	}

	@Override
	public void addGuestToList(Guest guest) {
		guestInHotel.add(guest);
	}

	@Override
	public Guest getGuestFromList(int id) {
		return guestInHotel.get(id);
	}

	@Override
	public void deleteGuestFromList(int id) {
		guestInHotel.remove(id);
	}

	@Override
	public List<Guest> getAllListGuests() {
		return guestInHotel;
	}
}
