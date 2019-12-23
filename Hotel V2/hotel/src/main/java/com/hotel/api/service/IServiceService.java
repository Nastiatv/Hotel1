package com.hotel.api.service;

import java.util.List;

import com.hotel.entity.Service;

public interface IServiceService {

	void addService(Service service);

	Service getService(int id);

	void deleteService(int id);

	List<Service> getAll();
}
