package com.hotel.api.dao;

import java.util.List;

import com.hotel.entity.Room;

public interface IRoomDao {

	void addRoomToList(Room room);

	Room getRoomfromList(int id);

	void deleteRoomFromList(int id);

	List<Room> getAllListRooms();

}
