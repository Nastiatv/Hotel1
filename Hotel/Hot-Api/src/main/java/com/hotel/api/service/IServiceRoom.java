package com.hotel.api.service;

import java.util.List;

import com.hotel.entities.Guest;
import com.hotel.entities.Room;

public interface IServiceRoom {

	void addRoom(Room room);

	Room getRoom(int id);

	void deleteRoom(int id); 

	List<Room> getAll();

	void printRooms(List<Room> rooms);		
	
	void checkInGuestInRoom(Guest guest,Room room);
	}


