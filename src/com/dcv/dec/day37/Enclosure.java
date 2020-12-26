package src.com.dcv.dec.day37;
import java.util.Vector;


public class Enclosure {
	private String name;
	private Vector<Animal> animals;
	
	// Constructor ---------------------------------------------------------------------------------
	protected Enclosure(String name) {
		this.name = name;
	}
	
	// Setter --------------------------------------------------------------------------------------
	public void assignAnimal(Animal animal) {
		
		// Note that the constructor does not contain the new Vector<>(). Therefore check here if
		// the Vector was already created, and do so if not. Reason: Classes may have many
		// attributes / list / vectors / linked objects ... Initialize them only when needed to save
		// recources
		if (animals == null) {
			animals = new Vector<>();
		}
		animals.add(animal);
	}

	// Getter --------------------------------------------------------------------------------------
	public String getStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append("  L ")
		  .append(name)
		  .append("\n");
		
		if (animals != null) {
			for (Animal animal : animals) {
				sb.append("      L ").append(animal.getInfo()).append("\n");
			}
		}
		return sb.toString();
	}

	public Vector<Animal> getAnimals() {
		return this.animals;
	}

	public String getName() {
		return name;
	}
	
}
