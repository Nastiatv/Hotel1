package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IServiceDao;
import com.hotel.entities.Service;

public class ServiceDao implements IServiceDao {

	private List<Service> serviceInHotel = new ArrayList<>();

	@Override
	public void addServiceToList(Service service) {
		serviceInHotel.add(service);
	}

	@Override
	public Service getServicefromList(int id) {
		return serviceInHotel.get(id);
	}

	@Override
	public void deleteServiceFromList(int id) {
		serviceInHotel.remove(id);
	}

	@Override
	public List<Service> getAllListService() {
		return serviceInHotel;
	}
}
