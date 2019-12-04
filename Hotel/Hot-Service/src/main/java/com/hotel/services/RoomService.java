package com.hotel.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IRoomService;
import com.hotel.dao.RoomDao;
import com.hotel.entities.Guest;
import com.hotel.entities.Room;
import com.hotel.entities.Service;
import com.hotel.enums.Status;

public class RoomService implements IRoomService {

	IRoomDao daoRooms = new RoomDao();
	
	
	@Override
	public void addRoom(Room room) {
		if (!getAllRoomsId().contains(room.getId())) {
			daoRooms.addRoomToList(room);
		} else {
			System.out.println("Such a room already exists");
		}
	}

	@Override
	public Room getRoom(int id) {
		if (getAllRoomsId().contains(id))
			return daoRooms.getRoomfromList(id);
		else {
			System.out.println("There are no such rooms");
			return null;
		}
	}

	@Override
	public void deleteRoom(int id) {
		if (getAllRoomsId().contains(id)) {
			daoRooms.deleteRoomFromList(id);
		} else {
			System.out.println("There are no such rooms");
		}
	}

	@Override
	public List<Room> getAll() {
		return daoRooms.getAllListRooms();
	}

	@Override
	public void printRooms(List<Room> rooms) {
		System.out.println("Here's the information about needed rooms in our hotel:");
		for (Room room : rooms) {
			StringBuilder sb = new StringBuilder();
			sb.append("Room number = ");
			sb.append(room.getId());
			sb.append("; DailyPrice = ");
			sb.append(room.getDailyPrice());
			sb.append("; Capacity = ");
			sb.append(room.getCapacity());
			sb.append("; NonSmoking = ");
			sb.append(room.isNonSmoking());
			sb.append("; Status = ");
			sb.append(room.getStatus());
			System.out.println(sb);
		}
	}
	public void checkInGuestInRoom(Guest guest,Room room) {
		room.setStatus(Status.OCCUPIED);
		guest.setIdRoom(room.getId());
	}
	public void checkOutGuestFromRoom(Guest guest,Room room) {
		room.setStatus(Status.SERVICE );
		countFee(guest);
		room.setStatus(Status.FREE );
	}
		
	public void orderService(Room room, Service service, LocalDate start, LocalDate finish) {
		
	}
	
	private void countFee(Guest guest) {
		LocalDate startDate = guest.getArrivalDate();
		LocalDate endDate = guest.getDepartureDate();
		int daysinhotel = Period.between(startDate, endDate).getDays();
		int dailyForRoom=daoRooms.getRoomfromList(guest.getIdRoom()).getDailyPrice();
		int sum=daysinhotel*dailyForRoom;
		System.out.println("Amount payable: "+sum);;
		
		
		
		
		
		
	}

	private List<Integer> getAllRoomsId() {
		List<Integer> getAllRoomsId = daoRooms.getAllListRooms().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllRoomsId;
	}
}
