package com.loya.springjpaoracledemo.api.services;

import com.loya.springjpaoracledemo.api.dto.PetDto;
import com.loya.springjpaoracledemo.entities.Pet;

public interface IPetService {

//	public List<PetDto> getAllPets();

	Pet addPet(PetDto userDto);

	Pet getPetById(int id);

	Pet updatePet(int id, Pet user);

	void delete(int id);

}