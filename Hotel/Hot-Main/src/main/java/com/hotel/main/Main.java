package com.hotel.main;

import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.enums.Status;
import com.hotel.services.GuestService;
import com.hotel.services.RoomService;
import com.hotel.services.ServiceService;

public class Main {

	public static void main(String[] args) {

		ServiceService serviceManager=new ServiceService();
		GuestService guestManager=new GuestService();
		RoomService roomManager=new RoomService();
		

		roomManager.addRoom(new Room(0, 1, 50, false, Status.FREE));
		roomManager.addRoom(new Room(1, 1, 50, true, Status.FREE));
		roomManager.addRoom(new Room(2, 2, 70, true, Status.FREE));
		roomManager.addRoom(new Room(3, 2, 70, true, Status.FREE));
		roomManager.addRoom(new Room(4, 3, 80, true, Status.FREE));
		roomManager.addRoom(new Room(5, 4, 80, false, Status.FREE));
		roomManager.getRoom(4).setNonSmoking(true);
		roomManager.printRooms(roomManager.getAll());
		
		
		serviceManager.addService(new Service(0, 10, Status.FREE, "Laundry"));
		serviceManager.addService(new Service(1, 100, Status.FREE, "Restaurant"));
		serviceManager.addService(new Service(2, 10, Status.FREE, "Wifi"));
		serviceManager.addService(new Service(3, 10, Status.FREE, "Parking"));
		serviceManager.printServices(serviceManager.getAll());
		
		
		guestManager.addGuest(new Guest(0, false));
		guestManager.addGuest(new Guest(1, true));
		guestManager.addGuest(new Guest(2, true));
		guestManager.addGuest(new Guest(3, true));
		guestManager.addGuest(new Guest(4, true));
		guestManager.addGuest(new Guest(5, true));
		guestManager.printGuests(guestManager.getAll());
		
		
		roomManager.checkInGuestInRoom(guestManager.getGuest(0), roomManager.getRoom(0));
		roomManager.checkInGuestInRoom(guestManager.getGuest(1), roomManager.getRoom(1));
		roomManager.checkInGuestInRoom(guestManager.getGuest(2), roomManager.getRoom(2));
		roomManager.checkInGuestInRoom(guestManager.getGuest(3), roomManager.getRoom(3));
		roomManager.checkInGuestInRoom(guestManager.getGuest(4), roomManager.getRoom(4));
		roomManager.checkInGuestInRoom(guestManager.getGuest(5), roomManager.getRoom(5));
		
		roomManager.printRooms(roomManager.getAll());
		guestManager.printGuests(guestManager.getAll());
		

		
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(0), roomManager.getRoom(0));
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(1), roomManager.getRoom(1));
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(2), roomManager.getRoom(2));
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(3), roomManager.getRoom(3));
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(4), roomManager.getRoom(4));
		roomManager.checkOutGuestFromRoom(guestManager.getGuest(5), roomManager.getRoom(5));
		
		
		
	}

}
