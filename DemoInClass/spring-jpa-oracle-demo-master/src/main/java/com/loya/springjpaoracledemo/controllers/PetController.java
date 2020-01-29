package com.loya.springjpaoracledemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loya.springjpaoracledemo.api.dto.PetDto;
import com.loya.springjpaoracledemo.api.services.IPetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	IPetService petService;

	@GetMapping
	public List<PetDto> getAllPets() {
		return petService.getAllPets();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PetDto addPet(@RequestBody PetDto petDto) {
		return petService.addPet(petDto);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updatePet(@PathVariable int id, @RequestBody PetDto petDto) {
		petService.updatePet(id, petDto);
	}

	@GetMapping(value = "/{id}")
	public PetDto getPet(@PathVariable int id) {
		return petService.getPetById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePet(@PathVariable int id) {
		petService.delete(id);
	}
}