package com.hotel.api.service;

import java.util.List;

import com.hotel.entities.Room;

public interface IRoomService {

	void addRoom(Room room);

	Room getRoom(int id);

	void deleteRoom(int id); 

	List<Room> getAll();

	}


