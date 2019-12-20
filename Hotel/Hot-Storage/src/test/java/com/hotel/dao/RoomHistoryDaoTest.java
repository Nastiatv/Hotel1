package com.hotel.dao;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hotel.entities.RoomHistory;


public class RoomHistoryDaoTest {

	private List<RoomHistory> roomHistories;

	@Test
	public void assertThatNewRoomHistoryIsAdded() {
		roomHistories = new ArrayList<>();
		RoomHistory testRoomHistory = createRoomHistory(1);
		roomHistories.add(testRoomHistory);
		Assert.assertTrue(roomHistories.size() == 1);
	}
	
	@Test
	public void assertThatWeGetRoomHistory() {
		roomHistories = new ArrayList<>();
		RoomHistory testRoomHistory = createRoomHistory(1);
		roomHistories.add(testRoomHistory);
		Assert.assertTrue(testRoomHistory== roomHistories.get(1));
	}
	
	@Test
	public void assertThatRoomHistoryIsDeleted() {
		roomHistories = new ArrayList<>();
		RoomHistory testRoomHistory = createRoomHistory(1);
		roomHistories.add(testRoomHistory);
		roomHistories.remove(testRoomHistory);
		Assert.assertTrue(roomHistories.isEmpty());
	}

	@Test
	public void assertThatAllRoomHistoriesAreInStorage() {
		int num=5;
		roomHistories = new ArrayList<>();
		List<RoomHistory> createsRoomHistories = createRoomHistories(num);
		roomHistories.addAll(createsRoomHistories);
		Assert.assertTrue(roomHistories.size() == num);
	}

	private RoomHistory createRoomHistory(int id) {
		return new RoomHistory(id);
	}

	private List<RoomHistory> createRoomHistories(int num) {
		List<RoomHistory> listroomHistories = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			listroomHistories.add(createRoomHistory(i));
		}
		return listroomHistories;
	}
}