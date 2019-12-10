package com.hotel.entities;

public class Guest {

	private int id;

	public Guest(int id) {
		this.id = id;
	}

	public Guest() {
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
		System.out.println(sb);
		return sb.toString();
	}
}