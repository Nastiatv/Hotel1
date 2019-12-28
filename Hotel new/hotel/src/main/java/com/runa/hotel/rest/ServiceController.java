package com.runa.hotel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runa.hotel.api.dto.ServiceDto;
import com.runa.hotel.api.service.IServiceService;
import com.runa.hotel.entities.Service;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

	@Autowired
	private IServiceService serviceService;
	
	@GetMapping(value = "/{id}")
	public ServiceDto getService(@PathVariable("id") Long id) {
		return new ServiceDto(serviceService.get(id));
	}
	
	@PostMapping
	public ServiceDto createService(@RequestBody ServiceDto dto) {
		Service service = new Service();
		return new ServiceDto(serviceService.create(service));
	}
}
