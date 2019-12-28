package com.runa.hotel.api.dao;

import java.util.List;

import com.runa.hotel.entities.Service;


public interface IServiceDao {

	Service create (Service service);
	
	Service get (Long id);
	
	void update (Service service);
	
	void delete (Service service);
	
	List<Service> getAll();
	}
