package com.runa.hotel.api.dao;

import java.util.List;

import com.runa.hotel.entities.Room;

public interface IRoomDao {

	Room create (Room room);
	
	Room get (Long id);
	
	void update (Room room);
	
	void delete (Room room);
	
	List<Room> getAll();
}
