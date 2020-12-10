package src.com.dcv.nov.day34;

public class Animal {
	private Enclosure enclosure;
	private String species;
	private String name;
	private Food foodRequirenment;

	public Animal(Enclosure enclosure, String species, String name, Food foodRequirenment) {
		enclosure.addAnimal(this);
		this.species = species;
		this.name = name;
		this.foodRequirenment = foodRequirenment;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
