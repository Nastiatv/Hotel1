package com.loya.springjpaoracledemo.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.loya.springjpaoracledemo.entities.User;

public class UserDto extends ADto {

	private String name;

	private Integer salary;

	private List<PetDto> pets;

	public static List<UserDto> convertList(List<User> entities) {
		List<UserDto> users = new ArrayList<>();
		for (User entity : entities) {
			UserDto dto = new UserDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setSalary(entity.getSalary());
			dto.setPets(PetDto.convertList(entity.getPets()));
			users.add(dto);
		}
		return users;
	}

	public static UserDto entityToDto(User entity) {
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSalary(entity.getSalary());
		dto.setPets(PetDto.convertList(entity.getPets()));
		return dto;
	}

	public UserDto() {

	}

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.salary = user.getSalary();
		this.pets = PetDto.convertList(user.getPets());
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

	public List<PetDto> getPets() {
		return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}
}