package com.hotel.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IRoomHistoryDao;
import com.hotel.api.service.IRoomHistoryService;
import com.hotel.dao.RoomHistoryDao;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.RoomHistory;
import com.hotel.enums.Status;


public class RoomHistoryService implements IRoomHistoryService{

	IRoomHistoryDao daoHistory=new RoomHistoryDao();
	
	public void addRoomHistory(RoomHistory roomHistory) {
		if(!getAllHistoryId().contains(roomHistory.getId())) {
			daoHistory.addHistory(roomHistory);
		} else {
			System.out.println("Such a history already exists");
		}
	}
	@Override
	public RoomHistory getRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			return daoHistory.getRoomHistory(id);
		} else {
			System.out.println("There are no such history");
			return null;
		}
	}

	@Override
	public void deleteRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			daoHistory.deleteRoomHistory(id);;
		} else {
			System.out.println("There are no such history");
			
		}
	}
	@Override
	public List<RoomHistory> getAll() {
		return daoHistory.getAllRoomHistories();
	}
	
	public void checkIn(int id, Room room, Guest guest, LocalDate checkInDate) {
		daoHistory.addHistory(new RoomHistory(id, room,guest,checkInDate));
		daoHistory.getRoomHistory(id).setStatus(Status.OCCUPIED);
	} 
	
	public void checkOut(int id, LocalDate checkOutDate) {
		daoHistory.getRoomHistory(id).setCheckOutDate(checkOutDate);
		daoHistory.getRoomHistory(id).setStatus(Status.FREE);
	} 

private List<Integer> getAllHistoryId() {
	List<Integer> getAllHistoryId = daoHistory.getAllRoomHistories().stream().map(y -> y.getId())
			.collect(Collectors.toList());
	return getAllHistoryId;
}
}
