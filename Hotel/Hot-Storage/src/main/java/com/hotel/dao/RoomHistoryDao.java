package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IRoomHistoryDao;
import com.hotel.entities.RoomHistory;

public class RoomHistoryDao implements IRoomHistoryDao {

	private List<RoomHistory> RoomHistories = new ArrayList<>();

	@Override
	public RoomHistory getRoomHistory(int id) {
		return RoomHistories.get(id);
	}

	@Override
	public List<RoomHistory> getAllRoomHistories() {
		return RoomHistories;
	}
	
	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		RoomHistories.add(roomHistory);
	}

	@Override
	public void deleteRoomHistory(int id) {
		RoomHistories.remove(id);
		
	}
}
