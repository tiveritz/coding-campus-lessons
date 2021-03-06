package src.com.dcv.dec.day37;

import java.util.Vector;

public class DinosaurHandler {
	private String name;
	private Animal favouriteAnimal;
	private Vector<Enclosure> enclosureResponsibilities;

	// Constructor ---------------------------------------------------------------------------------
	protected DinosaurHandler(
		String name, Animal favouriteAnimal, Vector<Enclosure> enclosureResponsibilities)
		{
		this.name = name;
		this.favouriteAnimal = favouriteAnimal;
		this.enclosureResponsibilities = enclosureResponsibilities;
	}

	// Methods -------------------------------------------------------------------------------------
	public void feedAnimals() {
		if (enclosureResponsibilities != null) {
			for (Enclosure enclosure : enclosureResponsibilities) {
				Vector<Animal> animals = enclosure.getAnimals();

				for (Animal animal : animals) {
					System.out.println(name + " feeds: " + animal.getName());
				}
			}
		}
	}

	public void admireAnimals(double probabilityAdmireStandardAnimal, double probabilityAdmireFavouriteAnimal) {
		if (enclosureResponsibilities != null) {
			for (Enclosure enclosure : enclosureResponsibilities) {
				Vector<Animal> animals = enclosure.getAnimals();
				
				for (Animal animal : animals) {					
					double random = Math.random();
					if (animal.equals(favouriteAnimal)) {
						if (probabilityAdmireFavouriteAnimal > random) {
							System.out.println(name + " admires favourite: " + animal.getName());
						}
					} else {
						if (probabilityAdmireStandardAnimal > random) {
							System.out.println(name + " admires: " + animal.getName());
						}
					}
				}
			}
		}
	}


	// Getter --------------------------------------------------------------------------------------
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append(name)
		  .append("\n     Favourite Animal: ")
		  .append(favouriteAnimal.getName())
		  .append("\n     Assigned enclosures: ");

		for (int i = 0; i < enclosureResponsibilities.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(enclosureResponsibilities.get(i).getName());
		}
		return sb.toString();
	}

	public String getName() {
		return this.name;
	}
}
