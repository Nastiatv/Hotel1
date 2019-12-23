package com.hotel.api.dao;

import java.util.List;

import com.hotel.entity.RoomHistory;

public interface IRoomHistoryDao {

	RoomHistory getRoomHistory(int id);

	List<RoomHistory> getAllRoomHistories();

	void addRoomHistory(RoomHistory roomHistory);

	void deleteRoomHistory(int id);

}
