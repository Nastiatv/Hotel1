package com.hotel.api.dao;

import java.util.List;

import com.hotel.entities.Guest;

public interface IGuestDao {

	List<Guest> getAllListGuests();

	void deleteGuestFromList(int id);

	Guest getGuestFromList(int id);

	void addGuestToList(Guest guest);


}
