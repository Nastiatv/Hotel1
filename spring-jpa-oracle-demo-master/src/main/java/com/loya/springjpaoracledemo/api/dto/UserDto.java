package com.loya.springjpaoracledemo.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import com.loya.springjpaoracledemo.entity.User;

public class UserDto {

	private Integer id;
	@Size(max=10)
	private String name;
	private Integer salary;

	public static List<UserDto> convertList(List<User> entities){
		return entities.stream().map(UserDto::new).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public UserDto() {
	}

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
	}
}
