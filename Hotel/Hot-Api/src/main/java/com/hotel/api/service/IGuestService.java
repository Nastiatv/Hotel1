package com.hotel.api.service;

import java.util.List;

import com.hotel.entities.Guest;

public interface IGuestService {

	void addGuest(Guest guest);

	Guest getGuest(int id);

	void deleteGuest(int id);

	List<Guest> getAll();

	void printGuests(List<Guest> guest);

}
