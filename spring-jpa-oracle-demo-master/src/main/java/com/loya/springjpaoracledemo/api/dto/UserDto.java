package com.loya.springjpaoracledemo.api.dto;

import com.loya.springjpaoracledemo.entity.User;

public class UserDto {

	private Integer id;
	private String name;
	private Integer salary;
	
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

	public UserDto() {}

	
	public UserDto(User user) {
	this.id=user.getId();
	this.name=user.getName();
	this.salary=user.getSalary();
	}
}
