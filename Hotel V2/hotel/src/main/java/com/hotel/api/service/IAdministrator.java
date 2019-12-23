package com.hotel.api.service;

import java.time.LocalDate;

import com.hotel.entity.Guest;
import com.hotel.entity.Room;
import com.hotel.enums.Status;

public interface IAdministrator {

	public void createRoom(int id, int capacity, int dailyPrice, Status status);

	public void createService(int id, int dailyPrice, Status status, String name);

	public void createGuest(int id);

	public void checkIn(int idHistory, Room room, Guest guest, LocalDate checkInDate);

	public Room getRoom(int id);

	public Guest getGuest(int id);

	public void checkOut(int idHistory, LocalDate checkOutDate);

	public void orderService(int idService, int idHistory, LocalDate start, LocalDate end);
}
