package com.hotel.entities;

import com.hotel.enums.Status;

public class Service {

	private int id;
	private int dailyPrice;
	private Status status;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Service(int id, int dailyPrice, Status status , String name) {
		this.id=id;
		this.dailyPrice=dailyPrice;
		this.status=status;
		this.name=name;
		}
	
	public Service() {}
	
	
	
	
}
