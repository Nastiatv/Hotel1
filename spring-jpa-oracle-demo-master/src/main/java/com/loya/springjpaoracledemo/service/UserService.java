package com.loya.springjpaoracledemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.loya.springjpaoracledemo.api.IUserDao;
import com.loya.springjpaoracledemo.api.IUserService;
import com.loya.springjpaoracledemo.entity.User;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserDao userDao;

	public List<User> getAllUsers() {
		return this.userDao.findAll();
	}

	public User addUser(User user) {
		return this.userDao.save(user);
	}

	// other methods go here

	public Optional<User> getUserById(int id) {
		return this.userDao.findById(id);
	}

	public User updateUser(int id, User user) {
		User existingUser = getUserByUserId(id);
		if (!StringUtils.isEmpty(user.getName())) {
			existingUser.setName(user.getName());
		}
		if (user.getSalary() != null) {
			existingUser.setSalary(user.getSalary());
		}

		return this.userDao.save(existingUser);
	}

	public void deleteUserById(int id) {
		this.userDao.deleteById(id);
	}

	public void deleteAllUsers() {
		this.userDao.deleteAll();
	}

	private User getUserByUserId(int id) {
		return userDao.findAll().stream().filter(u -> u.getId().equals(id)).collect(Collectors.toList()).get(0);
	}
}
