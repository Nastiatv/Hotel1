package com.runa.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="guest")
public class Guest {

	
private static final Logger logger =LoggerFactory.getLogger(Guest.class);
	
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Guest(Long id) {
		this.id = id;
	}

	public Guest() {
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
