package src.com.dcv.nov.day34;

public class Animal {
	private Enclosure enclosure;
	private String species;

	public Animal(Enclosure enclosure, String species) {
		this.species = species;
		enclosure.addAnimal(this);
	}
	
	@Override
	public String toString() {
		return species;
	}
}
