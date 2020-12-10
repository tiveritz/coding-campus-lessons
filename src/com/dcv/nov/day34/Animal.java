package src.com.dcv.nov.day34;

public class Animal {
	private Enclosure enclosure;
	private String species;
	private String name;
	private Food food;

	public Animal(Enclosure enclosure, String species, String name, Food food) {
		enclosure.addAnimal(this);
		this.species = species;
		this.name = name;
		this.food = food;
	}

	public void feed(int quantity) {
		food.addQuantity(quantity);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
