package com.hotel.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IGuestDao;
import com.hotel.api.dao.IRoomDao;
import com.hotel.api.dao.IRoomHistoryDao;
import com.hotel.api.dao.IServiceDao;
import com.hotel.api.service.IRoomHistoryService;
import com.hotel.dao.GuestDao;
import com.hotel.dao.RoomDao;
import com.hotel.dao.RoomHistoryDao;
import com.hotel.dao.ServiceDao;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.RoomHistory;
import com.hotel.entities.Service;
import com.hotel.enums.Status;

public class RoomHistoryService implements IRoomHistoryService {

	IRoomHistoryDao historyDao = new RoomHistoryDao();
	IServiceDao serviceDao = new ServiceDao();
	IRoomDao roomDao = new RoomDao();
	IGuestDao guestDao = new GuestDao();

	@Override
	public void addRoomHistory(RoomHistory roomHistory) {
		if (!getAllHistoryId().contains(roomHistory.getId())) {
			historyDao.addRoomHistory(roomHistory);
		} else {
			System.out.println("Such a history already exists");
		}
	}

	@Override
	public RoomHistory getRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			return historyDao.getRoomHistory(id);
		} else {
			System.out.println("There are no such history");
			return null;
		}
	}

	@Override
	public void deleteRoomHistory(int id) {
		if (getAllHistoryId().contains(id)) {
			historyDao.deleteRoomHistory(id);
			;
		} else {
			System.out.println("There are no such history");
		}
	}

	@Override
	public List<RoomHistory> getAll() {
		return historyDao.getAllRoomHistories();
	}

	public void checkIn(int idHistory, Room room, Guest guest, LocalDate checkInDate) {
		historyDao.addRoomHistory(new RoomHistory(idHistory, room, guest, checkInDate));
		historyDao.getRoomHistory(idHistory).setStatus(Status.OCCUPIED);
		room.setStatus(Status.OCCUPIED);
	}

	public void checkOut(int idHistory, LocalDate checkOutDate) {
		RoomHistory rh=historyDao.getRoomHistory(idHistory);
		rh.setCheckOutDate(checkOutDate);
		rh.setStatus(Status.FREE);
		rh.getRoom().setStatus(Status.FREE);
	}

	public void orderService(int idService, int idHistory, LocalDate start, LocalDate end) {
		if (historyDao.getRoomHistory(idHistory).getServices() == null) {
			List<Service> listserv = new ArrayList<>();
			serviceDao.getAllListService();
			listserv.add(serviceDao.getServicefromList(idService));
			historyDao.getRoomHistory(idHistory).setServices(listserv);
		} else {
			List<Service> listserv = historyDao.getRoomHistory(idHistory).getServices();
			listserv.add(serviceDao.getServicefromList(idService));
			historyDao.getRoomHistory(idHistory).setServices(listserv);
		}
	}

	private List<Integer> getAllHistoryId() {
		List<Integer> getAllHistoryId = historyDao.getAllRoomHistories().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllHistoryId;
		}
	}
