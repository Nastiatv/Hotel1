package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.service.IRoomService;
import com.hotel.dao.RoomDao;
import com.hotel.entities.Room;


public class RoomService implements IRoomService {

	private static final Logger logger =LoggerFactory.getLogger(RoomService.class);
	
	@Override
	public void addRoom(Room room) {
		if (!getAllRoomsId().contains(room.getId())) {
			RoomDao.getInstance().addRoomToList(room);
		} else {
			logger.info("Such a room already exists");
		}
	}

	@Override
	public Room getRoom(int id) {
		if (getAllRoomsId().contains(id))
			return RoomDao.getInstance().getRoomfromList(id);
		else {
			logger.info("There are no such rooms");
			return null;
		}
	}

	@Override
	public void deleteRoom(int id) {
		if (getAllRoomsId().contains(id)) {
			RoomDao.getInstance().deleteRoomFromList(id);
		} else {
			logger.info("There are no such rooms");
		}
	}

	@Override
	public List<Room> getAll() {
		return RoomDao.getInstance().getAllListRooms();
	}

	private List<Integer> getAllRoomsId() {
		return RoomDao.getInstance().getAllListRooms().stream().map(Room::getId)
				.collect(Collectors.toList());
		}
	}
