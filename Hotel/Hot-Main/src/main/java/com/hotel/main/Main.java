package com.hotel.main;

import java.time.LocalDate;

import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.enums.Status;
import com.hotel.services.GuestService;
import com.hotel.services.RoomHistoryService;
import com.hotel.services.RoomService;
import com.hotel.services.ServiceService;

public class Main {

	public static void main(String[] args) {

		ServiceService serviceManager = new ServiceService();
		GuestService guestManager = new GuestService();
		RoomService roomManager = new RoomService();
		RoomHistoryService RoomHistoryManager = new RoomHistoryService();

		roomManager.addRoom(new Room(0, 1, 50, Status.FREE));
		roomManager.addRoom(new Room(1, 1, 50, Status.FREE));
		roomManager.addRoom(new Room(2, 2, 70, Status.FREE));
		roomManager.addRoom(new Room(3, 2, 70, Status.FREE));
		roomManager.addRoom(new Room(4, 3, 80, Status.FREE));
		roomManager.addRoom(new Room(5, 4, 80, Status.FREE));
		roomManager.getAll().toString();

		serviceManager.addService(new Service(0, 10, Status.FREE, "Laundry"));
		serviceManager.addService(new Service(1, 100, Status.FREE, "Restaurant"));
		serviceManager.addService(new Service(2, 10, Status.FREE, "Wifi"));
		serviceManager.addService(new Service(3, 10, Status.FREE, "Parking"));
		serviceManager.getAll().toString();
	
		guestManager.addGuest(new Guest(0));
		guestManager.addGuest(new Guest(1));
		guestManager.addGuest(new Guest(2));
		guestManager.addGuest(new Guest(3));
		guestManager.addGuest(new Guest(4));
		guestManager.addGuest(new Guest(5));
		guestManager.getAll().toString();

		RoomHistoryManager.checkIn(0, roomManager.getRoom(0), guestManager.getGuest(0), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.checkIn(1, roomManager.getRoom(1), guestManager.getGuest(1), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.checkIn(2, roomManager.getRoom(2), guestManager.getGuest(2), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.checkIn(3, roomManager.getRoom(3), guestManager.getGuest(3), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.checkIn(4, roomManager.getRoom(4), guestManager.getGuest(4), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.checkIn(5, roomManager.getRoom(5), guestManager.getGuest(5), LocalDate.of(2019, 12, 31));
		RoomHistoryManager.getAll().toString();
		
		RoomHistoryManager.orderService(0, roomManager.getRoom(0), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.orderService(1, roomManager.getRoom(1), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.orderService(2, roomManager.getRoom(2), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.orderService(3, roomManager.getRoom(3), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.orderService(2, roomManager.getRoom(4), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.orderService(2, roomManager.getRoom(5), LocalDate.of(2019, 12, 31), LocalDate.of(2020, 1, 2));
		
		
		RoomHistoryManager.checkOut(roomManager.getRoom(0), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.checkOut(roomManager.getRoom(1), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.checkOut(roomManager.getRoom(2), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.checkOut(roomManager.getRoom(3), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.checkOut(roomManager.getRoom(4), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.checkOut(roomManager.getRoom(5), LocalDate.of(2020, 1, 2));
		RoomHistoryManager.getAll().toString();
		
	
		
		
	}

}
