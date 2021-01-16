package src.com.dcv.jan.day41;

import java.util.HashMap;

public class Menu {
	private HashMap<String, Double> drinks;
	private HashMap<String, Double> starters;
	private HashMap<String, Double> dishes;
	private HashMap<String, Double> desserts;

	public Menu() {
		this.drinks = new HashMap<>();
		this.starters = new HashMap<>();
		this.dishes = new HashMap<>();
		this.desserts = new HashMap<>();
	}
	
	// -- SETTER -----------------------------------------------------------------------------------
	public void addDrink(String name, Double price) {
		drinks.put(name, price);
	}

	public void addStarter(String name, Double price) {
		starters.put(name, price);
	}

	public void addDish(String name, Double price) {
		dishes.put(name, price);
	}

	public void addDessert(String name, Double price) {
		desserts.put(name, price);
	}
}
