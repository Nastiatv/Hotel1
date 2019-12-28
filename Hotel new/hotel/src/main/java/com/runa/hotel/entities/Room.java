package com.runa.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runa.hotel.enums.Status;

@Entity
@Table(name = "room")
public class Room {

	private static final Logger logger = LoggerFactory.getLogger(Room.class);

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "dailyPrice")
	private int dailyPrice;
	@Column(name = "status")
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Room(Long id, int capacity, int dailyPrice, Status status) {
		this.id = id;
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
		this.status = status;
	}

	public Room() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RoomDto Number: ");
		sb.append(id);
		sb.append(" Capacity: ");
		sb.append(capacity);
		sb.append(" Daily price: ");
		sb.append(dailyPrice);
		sb.append(" Status: ");
		sb.append(status);
		String roomToString = sb.toString();
		logger.info(roomToString);
		return sb.toString();
	}
}
