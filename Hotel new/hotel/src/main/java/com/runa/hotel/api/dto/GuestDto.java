package com.runa.hotel.api.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runa.hotel.entities.Guest;

public class GuestDto {

	private static final Logger logger =LoggerFactory.getLogger(Guest.class);
	
	private Long id;

	public GuestDto(Guest guest) {
		this.id = guest.getId();
	}

	public GuestDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GuestDao Id: ");
		sb.append(id);
		String guestToString=sb.toString();
		logger.info(guestToString);
		return sb.toString();
	}
}
