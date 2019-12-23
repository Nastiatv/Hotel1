package com.hotel.api.service;

import java.util.List;

import com.hotel.entity.Guest;

public interface IGuestService {

	void addGuest(Guest guest);

	Guest getGuest(int id);

	void deleteGuest(int id);

	List<Guest> getAll();

}
