package com.loya.springjpaoracledemo.api;

import com.loya.springjpaoracledemo.entity.User;

public interface IUserService {
	public User addUser(User user);

	public User updateUser(int id, User user);

	public void deleteUserById(int id);

	public void deleteAllUsers();

}
