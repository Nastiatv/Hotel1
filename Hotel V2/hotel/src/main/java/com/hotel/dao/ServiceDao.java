package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.api.dao.IServiceDao;
import com.hotel.entity.Service;

public class ServiceDao implements IServiceDao {

	private static List<Service> listService = new ArrayList<>();
	
	private static ServiceDao services;

	public static ServiceDao getInstance() {
		if (services == null) {
			services =new ServiceDao();
		}
		return services;
	}

	@Override
	public void addServiceToList(Service service) {
		listService.add(service);
	}

	@Override
	public Service getServicefromList(int id) {
		return listService.get(id);
	}

	@Override
	public void deleteServiceFromList(int id) {
		listService.remove(id);
	}

	@Override
	public List<Service> getAllListService() {
		return listService;
	}
}
