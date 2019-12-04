package storage.cat;

import java.util.ArrayList;
import java.util.List;

import api.storage.ICatStorage;
import entity.cat.Cat;

public class CatStorage implements ICatStorage {

private List<Cat> cats=new ArrayList<>();

public List<Cat> getCats() {
	return cats;
}

@Override
public void create(Cat cat1) {
	cats.add(cat1);
	
}

@Override
public Cat getCat(int id) {
	return cats.get(id);
	
}

@Override
public void delete(int id) {
	cats.remove(id);
	
}

@Override
public List<Cat> getAll() {
	return cats;
}

	
	
	
}