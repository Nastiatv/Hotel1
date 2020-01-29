package com.loya.springjpaoracledemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.loya.springjpaoracledemo.api.dao.IPetDao;
import com.loya.springjpaoracledemo.api.dao.IUserDao;
import com.loya.springjpaoracledemo.api.dto.PetDto;
import com.loya.springjpaoracledemo.api.services.IPetService;
import com.loya.springjpaoracledemo.entities.Pet;
import com.loya.springjpaoracledemo.entities.User;

@Service
@Transactional
public class PetService implements IPetService {

	@Autowired
	private IPetDao petDao;
	
	@Autowired
	private IUserDao userDao;

	public List<PetDto> getAllPets() {
		return PetDto.convertList(petDao.getAll());
	}

	public PetDto addPet(PetDto petDto) {
		Pet pet = new Pet();
		pet.setNickname(petDto.getNickname());
		pet.setType(petDto.getType());
		return PetDto.entityToDto(petDao.create(pet));
	}

	public PetDto getPetById(int id) {
		return PetDto.entityToDto(petDao.get(id));
	}

	public void updatePet(int id, PetDto petDto) {
		Pet pet = petDao.get(id);
		if (!StringUtils.isEmpty(petDto.getNickname ())) {
			pet.setNickname(pet.getNickname());
		}
		if (pet.getType() != null) {
			pet.setType(petDto.getType());
		}
		petDao.update(pet);
	}

	public void delete(int id) {
		petDao.delete(petDao.get(id));
	}
	
	public PetDto addUserToPet(int petId, int userId) {
		Pet pet = petDao.get(petId);
		User user = userDao.get(userId);
		pet.setUser(user);
		petDao.update(pet);
		return PetDto.entityToDto(pet);
	}
}