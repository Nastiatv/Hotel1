 package entity.cat;

public class Cat {

	private int id;
	private int weight;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Cat(int id, String name, int weight) {
		this.id=id;
		this.name = name;
		this.weight = weight;

	}

}