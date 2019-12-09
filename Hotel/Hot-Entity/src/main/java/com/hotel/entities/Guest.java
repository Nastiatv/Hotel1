package com.hotel.entities;

public class Guest {

	private int id;
	private RoomHistory history;
	
	
	public Guest(int id) {
		this.id = id;
		}
	
	public Guest() {}
	
	public RoomHistory getHistory() {
		return history;
	}

	public void setHistory(RoomHistory history) {
		this.history = history;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Guest Pasport Number: ");
		sb.append(id);
		sb.append("; Room history : ");
		sb.append(history);
		System.out.println(sb);
		return sb.toString();
	}
	
	
	
	
	
}