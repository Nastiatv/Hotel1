package com.hotel.api.dao;

import java.util.List;

import com.hotel.entities.RoomHistory;

public interface IRoomHistoryDao {

	RoomHistory getRoomHistory(int id);

	List<RoomHistory> getAllRoomHistories();

	void addHistory(RoomHistory roomHistory);

	void deleteRoomHistory(int id);

}
