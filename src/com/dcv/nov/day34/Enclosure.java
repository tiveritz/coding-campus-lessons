package src.com.dcv.nov.day34;

import java.util.Vector;

public class Enclosure {
	private String fence;
	private Vector<Animal> animals;

	public Enclosure(Zoo zoo, String fence) {
		this.fence = fence;
		zoo.addEnclosure(this);
	}
	
	public String getStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append("  L ")
		  .append("Enclosure with ")
		  .append(fence)
		  .append("\n")
		  .append("    L ");
		
		if (animals != null) {
			for (int i = 0; i < animals.size(); i++) {
				if (i > 0) {
					sb.append(", ");
				}
				sb.append(animals.get(i).toString());
			}
		}
		return sb.toString();
	}

	public int getNumberOfAnimals() {
		if (animals != null) {
			return animals.size();
		} else {
			return 0;
		}
	}

	public void addAnimal(Animal a) {
		if (animals == null) {
			this.animals = new Vector<>();
		}
		animals.add(a);
	}
}
