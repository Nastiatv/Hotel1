package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.hotel.entity.Service;
import com.hotel.enums.Status;

public class ServiceDaoTest {

	private List<Service> services;

	@Test
	public void assertThatNewServiceIsAdded() {
		services = new ArrayList<>();
		Service testService = createService(1);
		services.add(testService);
		Assert.assertTrue(services.size() == 1);
	}
	
	@Test
	public void assertThatWeGetService() {
		services = new ArrayList<>();
		Service testService = createService(1);
		services.add(testService);
		Assert.assertTrue(testService== services.get(0));
	}
	
	@Test
	public void assertThatServiceIsDeleted() {
		services = new ArrayList<>();
		Service testService = createService(1);
		services.add(testService);
		services.remove(testService);
		Assert.assertTrue(services.isEmpty());
	}

	@Test
	public void assertThatAllServicesAreInStorage() {
		int num=5;
		services = new ArrayList<>();
		List<Service> createsServices = createServices(num);
		services.addAll(createsServices);
		Assert.assertTrue (services.size() == num);
	}

	private Service createService(int id) {
		return new Service(id,100,Status.FREE,"Test");
	}

	private List<Service> createServices(int num) {
		List<Service> listservices = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			listservices.add(createService(i));
		}
		return listservices;
	}
}
