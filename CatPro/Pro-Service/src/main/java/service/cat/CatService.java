package service.cat;

import java.util.List;
import java.util.stream.Collectors;
import api.service.ICatService;
import api.storage.ICatStorage;
import entity.cat.Cat;
import storage.cat.CatStorage;

public class CatService implements ICatService {

	ICatStorage catStorage = new CatStorage();

	public void fight(Cat name1, Cat name2) {
		if (name1.getWeight() >= name1.getWeight()) {
			System.out.println("Winner is: " + name1.getName());
		} else {
			System.out.println("Winner is : " + name2.getName());
		}
	}

	public void create(Cat newcat) {
		List<String> allCatsNames = catStorage.getAll().stream().map(x -> x.getName()).collect(Collectors.toList());
		if (!allCatsNames.contains(newcat.getName()) && !getAllCatsId().contains(newcat.getId())) {
			catStorage.create(newcat);
		} else {
			System.out.println("The cat with such name is already exists!");
		}
	}

	public Cat getCat(int id) {
		if (getAllCatsId().contains(id)) {
			return catStorage.getCat(id);
		} else {
			System.out.println("No Cat with id" + id);
			return null;
			// make try catch or throws
		}
	}

	public void delete(int id) {
		if (getAllCatsId().contains(id)) {
			catStorage.delete(id);
		} else {
			System.out.println("The cat is not exists!");
		}
	}

	public List<Cat> getAll() {
		return catStorage.getAll();
	}

	private List<Integer> getAllCatsId() {
		List<Integer> allCatsIds = catStorage.getAll().stream().map(y -> y.getId()).collect(Collectors.toList());
		return allCatsIds;

	}
}