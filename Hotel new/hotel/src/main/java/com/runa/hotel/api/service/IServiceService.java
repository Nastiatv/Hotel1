package com.runa.hotel.api.service;

import java.util.List;

import com.runa.hotel.entities.Service;

public interface IServiceService {

	Service create(Service service);

	Service get(Long id);

	void update(Service service);

	void delete(Service service);

	List<Service> getAll();
}
