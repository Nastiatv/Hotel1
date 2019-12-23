package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IRoomDao;
import com.hotel.entity.Room;

public class RoomDao implements IRoomDao {

	private List<Room> listRooms = new ArrayList<>();
	
	private static RoomDao roomsDao;

	public static RoomDao getInstance() {
		if (roomsDao == null) {
			roomsDao = new RoomDao();
		}
		return roomsDao;
	}

	@Override
	public void addRoomToList(Room room) {
		listRooms.add(room);
	}

	@Override
	public Room getRoomfromList(int id) {
		return listRooms.get(id);
	}

	@Override
	public void deleteRoomFromList(int id) {
		listRooms.remove(id);
	}

	@Override
	public List<Room> getAllListRooms() {
		return listRooms;
	}

}
