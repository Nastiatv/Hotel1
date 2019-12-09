package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IRoomDao;
import com.hotel.api.service.IRoomService;
import com.hotel.dao.RoomDao;
import com.hotel.entities.Room;


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

	private List<Integer> getAllRoomsId() {
		List<Integer> getAllRoomsId = daoRooms.getAllListRooms().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllRoomsId;
	}

	}
