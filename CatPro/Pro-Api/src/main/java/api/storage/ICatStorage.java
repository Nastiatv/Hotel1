package api.storage;

import java.util.List;

import entity.cat.Cat;

public interface ICatStorage {

	void create(Cat cat);

	Cat getCat(int id);

	void delete(int id);

	List<Cat> getAll();

}