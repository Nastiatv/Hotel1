package com.loya.springjpaoracledemo.api.services;

import java.util.List;

import com.loya.springjpaoracledemo.api.dto.UserDto;
import com.loya.springjpaoracledemo.entities.User;

public interface IUserService {

	public List<UserDto> getAllUsers();

	User addUser(UserDto userDto);

	User getUserById(int id);
	
	User getByName(String userName);

	void updateUser(int id, UserDto userDto);

	void delete(int id);

}