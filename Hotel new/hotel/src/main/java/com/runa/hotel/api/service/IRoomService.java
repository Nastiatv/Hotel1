package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.entities.Room;

public interface IRoomService {

	Room create(Room room);

	Room get(Long id);

	void update(Room room);

	void delete(Room room);

	List<Room> getAll();
}
