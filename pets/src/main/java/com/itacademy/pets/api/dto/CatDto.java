package com.itacademy.pets.api.dto;

import com.itacademy.pets.entities.Cat;

public class CatDto {

	private Long id;
	
	private String name;
	
	private int age;
	
	private int strength;

	public CatDto() {

	}

	public CatDto(Cat cat) {
		this.id = cat.getId();
		this.name = cat.getName();
		this.age = cat.getAge();
		this.strength = cat.getStrength();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}