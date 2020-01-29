package com.loya.springjpaoracledemo.api.services;

import java.util.List;

import com.loya.springjpaoracledemo.api.dto.PetDto;

public interface IPetService {

	public List<PetDto> getAllPets();

	PetDto addPet(PetDto userDto);

	PetDto getPetById(int id);

	void updatePet(int id, PetDto petDto);

	void delete(int id);
	
	PetDto addUserToPet(int petId, int userId);

}