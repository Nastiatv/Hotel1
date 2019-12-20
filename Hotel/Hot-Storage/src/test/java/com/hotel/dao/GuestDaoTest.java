package com.hotel.dao;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hotel.entities.Guest;

public class GuestDaoTest {

	private List<Guest> guests;

	@Test
	public void assertThatNewGuestIsAdded() {
		guests = new ArrayList<>();
		Guest testGuest = createGuest(1);
		guests.add(testGuest);
		Assert.assertTrue(guests.size() == 1);
	}
	
	@Test
	public void assertThatWeGetGuest() {
		guests = new ArrayList<>();
		Guest testGuest = createGuest(1);
		guests.add(testGuest);
		Assert.assertTrue(testGuest== guests.get(0));
	}
	
	@Test
	public void assertThatGuestIsDeleted() {
		guests = new ArrayList<>();
		Guest testGuest = createGuest(1);
		guests.add(testGuest);
		guests.remove(testGuest);
		Assert.assertTrue(guests.isEmpty());
	}

	@Test
	public void assertThatAllGuestsAreInStorage() {
		int num=5;
		guests = new ArrayList<>();
		List<Guest> createsCats = createGuests(num);
		guests.addAll(createsCats);
		Assert.assertTrue(guests.size() == num);
	}

	private Guest createGuest(int id) {
		return new Guest(id);
	}

	private List<Guest> createGuests(int num) {
		List<Guest> listguests = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			listguests.add(createGuest(i));
		}
		return listguests;
	}
}