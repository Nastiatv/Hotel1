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
import org.springframework.web.servlet.ModelAndView;

import com.loya.springjpaoracledemo.api.dto.UserDto;
import com.loya.springjpaoracledemo.api.services.IPetService;
import com.loya.springjpaoracledemo.api.services.IUserService;
import com.loya.springjpaoracledemo.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IPetService petService;

	@GetMapping
	public ModelAndView getAllUsers() {
		ModelAndView modelAndView = new ModelAndView();
		List<UserDto> users = userService.getAllUsers();
		modelAndView.setViewName("users");
		modelAndView.addObject("userList", users);
		return modelAndView;
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
		userService.updateUser(id, userDto);
	}

	@GetMapping(value = "/{id}")
	public UserDto getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping(value = "/byName/{name}")
	public UserDto getUserByName(@PathVariable String name) {
		return userService.getByName(name);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}
}