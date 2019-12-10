package com.hotel.api.service;

import java.util.List;

import com.hotel.entities.RoomHistory;

public interface IRoomHistoryService {

	List<RoomHistory> getAll();

	RoomHistory getRoomHistory(int id);

	void deleteRoomHistory(int id);

	void addRoomHistory(RoomHistory roomHistory);

}
