package com.loya.springjpaoracledemo.dao;

import org.springframework.stereotype.Repository;

import com.loya.springjpaoracledemo.api.dao.IPetDao;
import com.loya.springjpaoracledemo.entities.Pet;

@Repository
public class PetDao extends AGenericDao<Pet> implements IPetDao {

	public PetDao() {
		super(Pet.class);
	}
}