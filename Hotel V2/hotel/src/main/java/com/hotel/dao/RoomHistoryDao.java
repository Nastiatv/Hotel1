package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IRoomHistoryDao;
import com.hotel.entity.RoomHistory;

public class RoomHistoryDao implements IRoomHistoryDao{

	private List<RoomHistory> historyDao = new ArrayList<>();

	private static RoomHistoryDao historiesDao;

	public static RoomHistoryDao getInstance() {
		if (historiesDao == null) {
			historiesDao = new RoomHistoryDao();
		}
		return historiesDao;
	}
	
	@Override
	public RoomHistory getRoomHistory(int id) {
		return historyDao.get(id);
	}

	@Override
	public List<RoomHistory> getAllRoomHistories() {
		return historyDao;
	}

	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		historyDao.add(roomHistory);
	}

	@Override
	public void deleteRoomHistory(int id) {
		historyDao.remove(id);
	}
}
