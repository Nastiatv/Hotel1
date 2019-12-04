  package api.service;

import java.util.List;
import entity.cat.Cat;

public interface ICatService {

	void fight(Cat cat1,Cat cat2);

	void create(Cat cat);

	Cat getCat(int id);

	void delete(int id);

	List<Cat> getAll();}