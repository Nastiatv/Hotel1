package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IRoomDao;
import com.hotel.entities.Room;

public class RoomDao implements IRoomDao {

	private List<Room> roomsInHotel = new ArrayList<>();

	@Override
	public void addRoomToList(Room room) {
		roomsInHotel.add(room);
	}

	@Override
	public Room getRoomfromList(int id) {
		return roomsInHotel.get(id);
	}

	@Override
	public void deleteRoomFromList(int id) {
		roomsInHotel.remove(id);
	}

	@Override
	public List<Room> getAllListRooms() {
		return roomsInHotel;
	}

}
