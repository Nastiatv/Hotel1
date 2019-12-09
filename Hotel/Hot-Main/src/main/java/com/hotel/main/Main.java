package com.hotel.main;

import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.RoomHistory;
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
		RoomHistoryService RoomHistoryManager=new RoomHistoryService();

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

		RoomHistoryManager.addRoomHistory(new RoomHistory(0));
		RoomHistoryManager.addRoomHistory(new RoomHistory(1));
		RoomHistoryManager.addRoomHistory(new RoomHistory(2));
		RoomHistoryManager.addRoomHistory(new RoomHistory(3));
		RoomHistoryManager.addRoomHistory(new RoomHistory(4));
		RoomHistoryManager.addRoomHistory(new RoomHistory(5));
		RoomHistoryManager.getAll().toString();
		
	
	}

}
