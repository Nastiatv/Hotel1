package com.loya.springjpaoracledemo.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.loya.springjpaoracledemo.entities.Pet;

public class PetDto extends ADto {

	private String nickname;

	private String type;

	private String userName;

	public static List<PetDto> convertList(List<Pet> entities) {
		List<PetDto> pets = new ArrayList<>();
		for (Pet entity : entities) {
			PetDto dto = new PetDto();
			dto.setId(entity.getId());
			dto.setNickname(entity.getNickname());
			dto.setType(entity.getType());
			if (entity.getUser() != null) {
				dto.setUserName(entity.getUser().getName());
			}
			pets.add(dto);
		}
		return pets;
	}

	public static PetDto entityToDto(Pet entity) {
		PetDto dto = new PetDto();
		dto.setId(entity.getId());
		dto.setNickname(entity.getNickname());
		dto.setType(entity.getType());
		if (entity.getUser() != null) {
			dto.setUserName(entity.getUser().getName());
		} else {
			dto.setUserName(null);
		}
		return dto;
	}

	public static Pet dtoToEntity(PetDto dto) {
		Pet pet = new Pet();
		pet.setId(dto.getId());
		pet.setNickname(dto.getNickname());
		pet.setType(dto.getType());
		return pet;
	}

	public PetDto() {

	}

	public PetDto(Pet pet) {
		this.id = pet.getId();
		this.nickname = pet.getNickname();
		this.type = pet.getType();
		this.userName = pet.getUser().getName();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}