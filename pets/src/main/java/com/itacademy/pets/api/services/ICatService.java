package com.itacademy.pets.api.services;

import java.util.List;
import com.itacademy.pets.entities.Cat;

public interface ICatService {
	Cat create(Cat cat);

	Cat get(Long id);

	void update(Cat cat);

	void delete(Cat cat);

	List<Cat> getAll();
}
