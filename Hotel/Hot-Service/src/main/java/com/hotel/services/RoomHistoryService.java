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

public class RoomHistoryService implements IRoomHistoryService {

	IRoomHistoryDao daoHistory = new RoomHistoryDao();

	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		if (!getAllHistoryId().contains(roomHistory.getId())) {
			daoHistory.addRoomHistory(roomHistory);
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
			daoHistory.deleteRoomHistory(id);
			;
		} else {
			System.out.println("There are no such history");
		}
	}

	@Override
	public List<RoomHistory> getAll() {
		return daoHistory.getAllRoomHistories();
	}
	
		public void checkIn(int idHistory, Room room, Guest guest, LocalDate checkInDate) {
			daoHistory.addRoomHistory(new RoomHistory(idHistory, room, guest, checkInDate));
			daoHistory.getRoomHistory(idHistory).setStatus(Status.OCCUPIED);
		room.setStatus(Status.OCCUPIED);
		room.setHistory(daoHistory.getRoomHistory(idHistory));
		guest.setHistory(daoHistory.getRoomHistory(idHistory));
	}

	public void checkOut(int idHistory, LocalDate checkOutDate) {
		daoHistory.getRoomHistory(idHistory).setCheckOutDate(checkOutDate);
		daoHistory.getRoomHistory(idHistory).setStatus(Status.FREE);
		daoHistory.getRoomHistory(idHistory).getRoom().setStatus(Status.FREE);
		daoHistory.getRoomHistory(idHistory).getRoom().setHistory(daoHistory.getRoomHistory(idHistory));
		daoHistory.getRoomHistory(idHistory).getGuest().setHistory(daoHistory.getRoomHistory(idHistory));
	}

	private List<Integer> getAllHistoryId() {
		List<Integer> getAllHistoryId = daoHistory.getAllRoomHistories().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllHistoryId;
	}
}
