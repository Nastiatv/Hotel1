package com.runa.hotel.api.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.runa.hotel.entities.Service;
import com.runa.hotel.enums.Status;

public class ServiceDto {

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	private Long id;

	private int dailyPrice;

	private Status status;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public ServiceDto(Service service) {
		this.id = service.getId();
		this.dailyPrice = service.getDailyPrice();
		this.status = service.getStatus();
		this.name = service.getName();
	}

	public ServiceDto() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ServiceDto id: ");
		sb.append(id);
		sb.append(" ServiceDto name: ");
		sb.append(name);
		sb.append(" Price = ");
		sb.append(dailyPrice);
		sb.append(" Status: ");
		sb.append(status);
		String serviceToString = sb.toString();
		logger.info(serviceToString);
		return sb.toString();
	}
}