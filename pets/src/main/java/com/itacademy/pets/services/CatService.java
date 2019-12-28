package com.itacademy.pets.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.pets.api.dao.ICatDao;
import com.itacademy.pets.api.services.ICatService;
import com.itacademy.pets.entities.Cat;

@Service
@Transactional
public class CatService implements ICatService {

	@Autowired
	private ICatDao catDao;
	
	@Override
	public Cat create(Cat cat) {
		return catDao.create(cat);
	}

	@Override
	public Cat get(Long id) {
		return catDao.get(id);
	}

	@Override
	public void update(Cat cat) {
		catDao.update(cat);
	}

	@Override
	public void delete(Cat cat) {
		catDao.delete(cat);
	}

	@Override
	public List<Cat> getAll() {
		return null;
	}
}