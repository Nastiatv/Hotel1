package com.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotel.api.service.IServiceService;
import com.hotel.dao.ServiceDao;
import com.hotel.entity.Service;

public class ServiceService implements IServiceService {

	private static final Logger logger =LoggerFactory.getLogger(ServiceService.class);
	
	@Override
	public void addService(Service service) {
		if (!getAllServiceId().contains(service.getId())) {
			ServiceDao.getInstance().addServiceToList(service);
		} else {
			logger.info("Such a service already exists");
		}
	}

	@Override
	public Service getService(int id) {
		if (getAllServiceId().contains(id)) {
			return ServiceDao.getInstance().getServicefromList(id);
		} else {
			logger.info("There are no such service");
			return null;
		}
	}

	@Override
	public void deleteService(int id) {
		if (getAllServiceId().contains(id)) {
			ServiceDao.getInstance().deleteServiceFromList(id);
		} else {
			logger.info("There are no such service");

		}
	}

	@Override
	public List<Service> getAll() {
		return ServiceDao.getInstance().getAllListService();
	}

	private List<Integer> getAllServiceId() {
		return ServiceDao.getInstance().getAllListService().stream().map(Service::getId).collect(Collectors.toList());

	}
}
