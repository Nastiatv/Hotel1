package com.loya.springjpaoracledemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.loya.springjpaoracledemo.api.dao.IUserDao;
import com.loya.springjpaoracledemo.api.dto.UserDto;
import com.loya.springjpaoracledemo.api.services.IUserService;
import com.loya.springjpaoracledemo.entities.User;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	public List<UserDto> getAllUsers() {
		return UserDto.convertList(userDao.getAll());
	}

	public User addUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setSalary(userDto.getSalary());
		return userDao.create(user);
	}

	public User getUserById(int id) {
		return userDao.get(id);
	}

	public User getByName(String userName) {
		return userDao.getByName(userName);
	}
	
	public void updateUser(int id, UserDto userDto) {
		User user = getUserById(id);
		if (!StringUtils.isEmpty(userDto.getName())) {
			user.setName(user.getName());
		}
		if (user.getSalary() != null) {
			user.setSalary(userDto.getSalary());
		}
		userDao.update(user);
	}

	public void delete(int id) {
		userDao.delete(getUserById(id));
	}
}