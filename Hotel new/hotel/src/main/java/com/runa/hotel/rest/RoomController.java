package com.runa.hotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runa.hotel.api.dto.RoomDto;
import com.runa.hotel.api.service.IRoomService;
import com.runa.hotel.entities.Room;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

	@Autowired
	private IRoomService roomService;
	
	@GetMapping(value = "/{id}")
	public RoomDto getRoom(@PathVariable("id") Long id) {
		return new RoomDto(roomService.get(id));
	}
	
	@PostMapping
	public RoomDto createRoom(@RequestBody RoomDto dto) {
		Room room = new Room();
		return new RoomDto(roomService.create(room));
	}
}
