package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.service.IServiceService;
import com.hotel.dao.ServiceDao;
import com.hotel.entities.Service;

public class ServiceService implements IServiceService {

	@Override
	public void addService(Service service) {
		if (!getAllServiceId().contains(service.getId())) {
			ServiceDao.getInstance().addServiceToList(service);
		} else {
			System.out.println("Such a service already exists");
		}
	}

	@Override
	public Service getService(int id) {
		if (getAllServiceId().contains(id)) {
			return ServiceDao.getInstance().getServicefromList(id);
		} else {
			System.out.println("There are no such service");
			return null;
		}
	}

	@Override
	public void deleteService(int id) {
		if (getAllServiceId().contains(id)) {
			ServiceDao.getInstance().deleteServiceFromList(id);;
		} else {
			System.out.println("There are no such service");
			
		}
	}
	@Override
	public List<Service> getAll() {
		return ServiceDao.getInstance().getAllListService();
	}

	private List<Integer> getAllServiceId() {
		List<Integer> getAllServiceId = ServiceDao.getInstance().getAllListService().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllServiceId;
	}
	}

	
