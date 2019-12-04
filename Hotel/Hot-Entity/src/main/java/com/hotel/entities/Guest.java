package com.hotel.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guest {

	private int id;
	private int numberOfGuests;
	private boolean NonSmoking;
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private List<Service> services = new ArrayList<Service>();
	private int idRoom;
	private int fee;
	
	public Guest(int id, int numberOfGuests, boolean NonSmoking, LocalDate arrivalDate, LocalDate departureDate) {
		this.id = id;
		this.numberOfGuests = numberOfGuests;
		this.NonSmoking = NonSmoking;
		this.arrivalDate=arrivalDate;
		this.departureDate=departureDate;
		}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Service> getService() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public boolean isNonSmoking() {
		return NonSmoking;
	}

	public void setNonSmoking(boolean nonSmoking) {
		NonSmoking = nonSmoking;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
}