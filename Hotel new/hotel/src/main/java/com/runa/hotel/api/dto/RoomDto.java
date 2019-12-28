package com.runa.hotel.api.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runa.hotel.entities.Room;
import com.runa.hotel.enums.Status;

public class RoomDto {

	private static final Logger logger = LoggerFactory.getLogger(Room.class);

	private Long id;
	private int capacity;
	private int dailyPrice;
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

	public RoomDto(Room room) {
			this.id = room.getId();
			this.capacity = room.getCapacity();
			this.dailyPrice = room.getDailyPrice();
			this.status = room.getStatus();
		}

	public RoomDto() {
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
