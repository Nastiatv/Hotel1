package com.hotel.api.dao;

import java.util.List;

import com.hotel.entity.Service;

public interface IServiceDao {

	void addServiceToList(Service service);

	Service getServicefromList(int id);

	void deleteServiceFromList(int id);

	List<Service> getAllListService();

}
