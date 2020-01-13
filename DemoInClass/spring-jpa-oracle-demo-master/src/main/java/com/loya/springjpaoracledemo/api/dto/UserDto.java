package com.loya.springjpaoracledemo.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.loya.springjpaoracledemo.entities.User;

public class UserDto extends ADto {

	private String name;

	private Integer salary;

	public static List<UserDto> convertList(List<User> entities) {
		return entities.stream().map(UserDto::new).collect(Collectors.toList());
	}

	public UserDto() {

	}

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}