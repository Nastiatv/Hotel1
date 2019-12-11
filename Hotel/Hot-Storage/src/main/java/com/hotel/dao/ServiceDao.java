package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IServiceDao;
import com.hotel.entities.Service;

public class ServiceDao implements IServiceDao {

	private List<Service> serviceDao = new ArrayList<>();

	@Override
	public void addServiceToList(Service service) {
		serviceDao.add(service);
	}

	@Override
	public Service getServicefromList(int id) {
		return serviceDao.get(id);
	}

	@Override
	public void deleteServiceFromList(int id) {
		serviceDao.remove(id);
	}

	@Override
	public List<Service> getAllListService() {
		return serviceDao;
	}
}
