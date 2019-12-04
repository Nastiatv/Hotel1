package com.hotel.api.service;

import java.util.List;

import com.hotel.entities.Service;

public interface IServiceService {

	void addService(Service service);

	Service getService(int id);

	void deleteService(int id);

	List<Service> getAll();

	void printServices(List<Service> services);

}
