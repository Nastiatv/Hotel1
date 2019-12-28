package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runa.hotel.api.dao.IServiceDao;
import com.runa.hotel.api.service.IServiceService;

@Service
@Transactional
public class ServiceService implements IServiceService {

	@Autowired
	private IServiceDao serviceDao;

	@Override
	public com.runa.hotel.entities.Service get(Long id) {
		return serviceDao.get(id);
	}

	@Override
	public void update(com.runa.hotel.entities.Service service) {
		serviceDao.update(service);

	}

	@Override
	public void delete(com.runa.hotel.entities.Service service) {
		serviceDao.delete(service);

	}

	@Override
	public List<com.runa.hotel.entities.Service> getAll() {
		return null;
	}

	@Override
	public com.runa.hotel.entities.Service create(com.runa.hotel.entities.Service service) {
		return serviceDao.create(service);
	}
}
