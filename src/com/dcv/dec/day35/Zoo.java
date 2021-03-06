package src.com.dcv.dec.day35;

import java.util.Vector;

public class Zoo {
	private String name;
	private String chairman;
	private Vector<Enclosure> enclosures;
	private Vector<Food> foodList;
	private Vector<Palaeontologist> palaes;
	private Vector<DinosaurHandler> dinosaurHandler;

	public Zoo(String name, String chairman) {

		// A constructor does not neccessarily always need this.something = something. It is
		// perfectly valid to do some more interesting stuff here. Calls some helper functions,
		// validate data, do calculations (or in this case a T-Rex String concatenation)
		this.name =
			" e-e\n" +
			"(\\_/)\\\n" +
			" `-'\\ `--.___,\n" +
			"    '\\( ,_.-'\n" +
			"       \\\\\n" +
			"       ^'\n" + name;
		this.chairman = chairman;
		this.enclosures = new Vector<>();
		this.foodList = new Vector<>();
		this.palaes = new Vector<>();
		this.dinosaurHandler = new Vector<>();
	}

	public Animal createAnimal(String enclosure, String name, String species, String type, String foodType, int foodDemand, String foodUnit) {
		return new Animal(this, enclosure, name, species, type, foodType, foodDemand, foodUnit);
	}

	public Food createFood(String foodType, String foodUnit) {
		return createFood(foodType, 0, foodUnit);
	}

	public Food createFood(String foodType, int foodDemand, String foodUnit) {
		for (Food food : foodList) {
			if (food.getName().equals(foodType)) {
				food.addDemand(foodDemand);
				return food;
			}
		}
		Food f = new Food(foodType, foodDemand, foodUnit);
		foodList.add(f);
		return f;
	}

	public Enclosure createEnclosure(String name) {
		for (Enclosure enclosure : enclosures) {
			if (enclosure.getName().equals(name)) {
				return enclosure;
			}
		}
		Enclosure e = new Enclosure(name);
		enclosures.add(e);
		return e;
	}

	public Palaeontologist createPalaeontologist(String name) {
		for (Palaeontologist palea : palaes) {
			if (palea.getName().equals(name)) {
				return palea;
			}
		}
		Palaeontologist p = new Palaeontologist(name);
		palaes.add(p);
		return p;
	}

	public DinosaurHandler createDinosaurHandler(String name, Animal favouriteAnimal, String[] enclosures) {
		for (DinosaurHandler handler : dinosaurHandler) {
			if (handler.getName().equals(name)) {
				return handler;
			}
		}
		Vector<Enclosure> handlerEnclosures = new Vector<>();
		for (String enclosureName : enclosures) {
			Enclosure enclosure = createEnclosure(enclosureName);
			handlerEnclosures.add(enclosure);
		}

		DinosaurHandler d = new DinosaurHandler(name, favouriteAnimal, handlerEnclosures);
		dinosaurHandler.add(d);
		return d;
	}

	public String getStructure() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		
		if (enclosures != null) {
			for (Enclosure enclosure : enclosures) {
				sb.append("\n").append(enclosure.getStructure());
			}
		}

		// Personnel
		if (palaes != null) {
			sb.append("\n").append("Palaeontologist");
			for (Palaeontologist palae : palaes) {
				sb.append("\n  ").append(palae.getName());
			}
		}
		sb.append("\n");

		if (dinosaurHandler != null) {
			sb.append("\n").append("Dinosaur Handler");
			for (DinosaurHandler handler : dinosaurHandler) {
				sb.append("\n   - ").append(handler.toString());
			}
		}
		return sb.toString();
	}

	public int getNumberOfAnimals() {
		int number = 0;
		if (enclosures != null) {
			for (Enclosure enclosure : enclosures) {
				number += enclosure.getNumberOfAnimals();
			}
		}
		return number;
	}

	public String printFoodDemand() {
		StringBuilder sb = new StringBuilder();
		if (foodList != null){
			for (Food food : foodList) {
				sb.append(food.getDemand() + " " + food.getUnit() + " " + food.getName() + "\n");
			}
		}
		return sb.toString();
	}
}
