package com.itacademy.pets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.pets.api.dto.CatDto;
import com.itacademy.pets.api.services.ICatService;
import com.itacademy.pets.entities.Cat;

@RestController
@RequestMapping(value = "/cat")
public class CatController {

	@Autowired
	private ICatService catService;
	
	@GetMapping(value = "/{id}")
	public CatDto getCat(@PathVariable("id") Long id) {
		return new CatDto(catService.get(id));
	}
	
	@PostMapping
	public CatDto createCat(@RequestBody CatDto dto) {
		Cat cat = new Cat();
		cat.setStrength(9);
		return new CatDto(catService.create(cat));
	}
}