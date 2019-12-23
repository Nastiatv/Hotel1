package com.hotel.api.service;

import java.util.List;

import com.hotel.entity.Room;

public interface IRoomService {

	void addRoom(Room room);

	Room getRoom(int id);

	void deleteRoom(int id); 

	List<Room> getAll();

}
