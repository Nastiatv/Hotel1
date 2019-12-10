package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IGuestDao;
import com.hotel.entities.Guest;
import com.hotel.entities.RoomHistory;

public class GuestDao implements IGuestDao {

	private List<Guest> guestInHotel = new ArrayList<>();

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
	

	@Override
	public void updateGuest(Guest guest,RoomHistory history) {
		guest.setHistory(history);
	}
}
