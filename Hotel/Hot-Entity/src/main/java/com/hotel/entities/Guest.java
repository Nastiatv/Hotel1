package com.hotel.entities;

import java.util.ArrayList;
import java.util.List;

public class Guest {

	private int id;
	private boolean NonSmoking;
	private List<Service> services = new ArrayList<>();
	private int idRoom;
	private int fee;
	
	
	public Guest(int id, boolean NonSmoking) {
		this.id = id;
		this.NonSmoking = NonSmoking;

		}
	
	public Guest() {}
	
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
	
	public boolean getisNonSmoking() {
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