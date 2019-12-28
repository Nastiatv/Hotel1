package com.runa.hotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runa.hotel.api.dto.GuestDto;
import com.runa.hotel.api.service.IGuestService;
import com.runa.hotel.entities.Guest;

@RestController
@RequestMapping(value = "/guest")
public class GuestController {

	@Autowired
	private IGuestService guestService;
	
	@GetMapping(value = "/{id}")
	public GuestDto getGuest(@PathVariable("id") Long id) {
		return new GuestDto(guestService.get(id));
	}
	
	@PostMapping
	public GuestDto createGuest(@RequestBody GuestDto dto) {
		Guest guest = new Guest();
		return new GuestDto(guestService.create(guest));
	}
}
