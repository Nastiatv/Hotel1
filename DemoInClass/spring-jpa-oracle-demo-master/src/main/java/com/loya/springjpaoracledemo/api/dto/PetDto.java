package com.loya.springjpaoracledemo.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.loya.springjpaoracledemo.entities.Pet;

public class PetDto extends ADto {
	
	private String nickname;

	private String type;

	public static List<PetDto> convertList(List<Pet> entities) {
		return entities.stream().map(PetDto::new).collect(Collectors.toList());
	}
	
	public PetDto() {
		
	}
	
	public PetDto(Pet pet) {
		this.id = pet.getId();
		this.nickname = pet.getNickname();
		this.type = pet.getType();
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}