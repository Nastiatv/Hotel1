package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IRoomDao;
import com.hotel.entities.Room;

public class RoomDao implements IRoomDao {

	private List<Room> RoomDao = new ArrayList<>();

	@Override
	public void addRoomToList(Room room) {
		RoomDao.add(room);
	}

	@Override
	public Room getRoomfromList(int id) {
		return RoomDao.get(id);
	}

	@Override
	public void deleteRoomFromList(int id) {
		RoomDao.remove(id);
	}

	@Override
	public List<Room> getAllListRooms() {
		return RoomDao;
	}

}
