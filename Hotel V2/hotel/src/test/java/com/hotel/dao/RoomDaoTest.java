package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hotel.entity.Room;
import com.hotel.enums.Status;

public class RoomDaoTest {

	private List<Room> rooms;

	@Test
	public void assertThatNewRoomIsAdded() {
		rooms = new ArrayList<>();
		Room testRoom = createRoom(1);
		rooms.add(testRoom);
		Assert.assertTrue(rooms.size() == 1);
	}
	
	@Test
	public void assertThatWeGetRoom() {
		rooms = new ArrayList<>();
		Room testRoom = createRoom(1);
		rooms.add(testRoom);
		Assert.assertTrue(testRoom== rooms.get(0));
	}
	
	@Test
	public void assertThatRoomIsDeleted() {
		rooms = new ArrayList<>();
		Room testRoom = createRoom(1);
		rooms.add(testRoom);
		rooms.remove(testRoom);
		Assert.assertTrue(rooms.isEmpty());
	}

	@Test
	public void assertThatAllRoomsAreInStorage() {
		int num=5;
		rooms = new ArrayList<>();
		List<Room> createsRooms = createRooms(num);
		rooms.addAll(createsRooms);
		Assert.assertTrue(rooms.size() == num);
	}

	private Room createRoom(int id) {
		return new Room(id,1,100,Status.FREE);
	}

	private List<Room> createRooms(int num) {
		List<Room> listrooms = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			listrooms.add(createRoom(i));
		}
		return listrooms;
	}
}
