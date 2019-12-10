package com.hotel.api.dao;

import java.util.List;

import com.hotel.entities.Guest;
import com.hotel.entities.RoomHistory;

public interface IGuestDao {

	List<Guest> getAllListGuests();

	void deleteGuestFromList(int id);

	Guest getGuestFromList(int id);

	void addGuestToList(Guest guest);

	void updateGuest(Guest guest, RoomHistory history);

}
