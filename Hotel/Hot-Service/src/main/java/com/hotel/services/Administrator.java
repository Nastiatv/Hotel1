package com.hotel.services;

import java.time.LocalDate;

import com.hotel.api.service.IAdministrator;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.enums.Status;

public class Administrator implements IAdministrator {

	ServiceService serviceManager = new ServiceService();
	GuestService guestManager = new GuestService();
	RoomService roomManager = new RoomService();
	RoomHistoryService roomHistoryManager = new RoomHistoryService();

	public void createRoom(int id, int capacity, int dailyPrice, Status status) {
		roomManager.addRoom(new Room(id, capacity, dailyPrice, status));
	}

	public void createService(int id, int dailyPrice, Status status, String name) {
		serviceManager.addService(new Service(id, dailyPrice, status, name));
	}

	public void createGuest(int id) {
		guestManager.addGuest(new Guest(id));
	}
	
	public void checkIn(int idHistory, Room room, Guest guest, LocalDate checkInDate) {
		roomHistoryManager.checkIn(idHistory, room, guest, checkInDate);
	}
	
	public Room getRoom(int id) {
		return roomManager.getRoom(id);
	}
	
	public Guest getGuest(int id) {
		return guestManager.getGuest(id);
	}
	
	public void checkOut(int idHistory, LocalDate checkOutDate) {
		roomHistoryManager.checkOut(idHistory, checkOutDate);
	}
	
	public void orderService(int idService, int idHistory, LocalDate start, LocalDate end) {
		roomHistoryManager.orderService(idService, idHistory, start, end);
	}
	
}
