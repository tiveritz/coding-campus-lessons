package src.com.dcv.jan.day41;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;


public class Restaurant {
	private String name;
	private HashMap<String, Double> drinks;
	private HashMap<String, Double> starters;
	private HashMap<String, Double> dishes;
	private HashMap<String, Double> desserts;
	private ArrayList<Table> tables;
	private Queue<Group> groups;

	public Restaurant(String name) {
		this.name = name;
		this.drinks = new HashMap<>();
		this.starters = new HashMap<>();
		this.dishes = new HashMap<>();
		this.desserts = new HashMap<>();
		this.tables = new ArrayList<>();
		this.groups = new LinkedList<>();
	}

	// -- FACTORY ----------------------------------------------------------------------------------
	public Table createTable(int tableNumber, int seats) {
		for (Table table : tables) {
			if (table.getTableNumber() == tableNumber) {
				return table;
			}
		}

		Table t = new Table(tableNumber, seats);
		tables.add(t);
		return t;
	}

	public Group createGroup(int id, int count) {
		for (Group group : groups) {
			if (group.getId() == id) {
				return group;
			}
		}

		Group g = new Group(id, count);
		groups.add(g);
		return g;
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

	// -- GETTER -----------------------------------------------------------------------------------
	public String getInfo() {
		return "Restaurant " + name + " with " + tables.size() + " tables";
	}

	public void peekNextGroup() {
		System.out.println(groups.peek());
	}

}
