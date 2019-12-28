package com.runa.hotel.api.dao;

import java.util.List;

import com.runa.hotel.entities.Guest;

public interface IGuestDao {

	Guest create (Guest guest);
	
	Guest get (Long id);
	
	void update (Guest guest);
	
	void delete (Guest guest);
	
	List<Guest> getAll();
}
