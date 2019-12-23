package com.hotel.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Guest {

private static final Logger logger =LoggerFactory.getLogger(Guest.class);
	
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
		sb.append("Guest Id: ");
		sb.append(id);
		String guestToString=sb.toString();
		logger.info(guestToString);
		return sb.toString();
	}
}

