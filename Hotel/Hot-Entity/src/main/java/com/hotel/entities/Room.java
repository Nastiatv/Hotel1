package com.hotel.entities;

import com.hotel.enums.Status;

public class Room {

	private int id;
	private int capacity;
	private int dailyPrice;
	private boolean NonSmoking;
	private Status status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public boolean isNonSmoking() {
		return NonSmoking;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setNonSmoking(boolean nonSmoking) {
		NonSmoking = nonSmoking;
	}	

	public Room(int id, int capacity, int dailyPrice, boolean NonSmoking, Status status ) {
		this.id=id;
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
		this.NonSmoking = NonSmoking;
		this.status = status;

	}
	
	public Room() {}

}
