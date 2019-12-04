package com.hotel.services;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.api.dao.IServiceDao;
import com.hotel.api.service.IServiceService;
import com.hotel.dao.ServiceDao;
import com.hotel.entities.Service;

public class ServiceService implements IServiceService {

	IServiceDao daoService=new ServiceDao();
	
	@Override
	public void addService(Service service) {
		if (!getAllServiceId().contains(service.getId())) {
			daoService.addServiceToList(service);
		} else {
			System.out.println("Such a service already exists");
		}
	}

	@Override
	public Service getService(int id) {
		if (getAllServiceId().contains(id)) {
			return daoService.getServicefromList(id);
		} else {
			System.out.println("There are no such service");
			return null;
		}
	}

	@Override
	public void deleteService(int id) {
		if (getAllServiceId().contains(id)) {
			daoService.deleteServiceFromList(id);;
		} else {
			System.out.println("There are no such service");
			
		}
	}
	@Override
	public List<Service> getAll() {
		return daoService.getAllListService();
	}

	@Override
	public void printServices(List<Service> services) {
		System.out.println("Here's the information about needed services in our hotel: ");
		for (Service service : services) {
			StringBuilder sb = new StringBuilder();
			sb.append("Service name = ");
			sb.append(service.getName());
			sb.append("; Price = ");
			sb.append(service.getDailyPrice());
			sb.append("; Status = ");
			sb.append(service.getStatus());
			System.out.println(sb);
		}
		}
	
	
	
	
	private List<Integer> getAllServiceId() {
		List<Integer> getAllServiceId = daoService.getAllListService().stream().map(y -> y.getId())
				.collect(Collectors.toList());
		return getAllServiceId;
	}
	}

	
