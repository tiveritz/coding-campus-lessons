package src.com.dcv.jan.day41;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int currGroupId = 0;
		
		// Create Restaurant
		Restaurant loewe = new Restaurant("Gasthof Löwen");
		loewe.addDrink("Draft beer", 4.5);
		loewe.addDrink("Cola", 3.5);
		loewe.addDrink("Apple Juice", 3.5);
		loewe.addDrink("Sparkling Water", 1.5);
		loewe.addDrink("Coffee", 4.5);
		loewe.addDrink("Tea", 2.5);
		loewe.addStarter("Salad", 5.5);
		loewe.addStarter("Smoked salmon", 6.5);
		loewe.addStarter("Soup", 4.5);
		loewe.addStarter("Bred", 3.5);
		loewe.addDish("Steak", 19.5);
		loewe.addDish("Vienna Schnitzel", 16.5);
		loewe.addDish("Burger", 14.5);
		loewe.addDish("Club Sandwich", 13.5);
		loewe.addDessert("Cheese Cake", 7.5);
		loewe.addDessert("Chocolate Cake", 7.5);
		loewe.addDessert("Crossaint", 4.5);

		// Create Tables
		loewe.createTable(13, 2);
		loewe.createTable(14, 2);
		loewe.createTable(15, 2);
		loewe.createTable(16, 2);
		loewe.createTable(31, 4);
		loewe.createTable(32, 4);
		loewe.createTable(33, 4);
		loewe.createTable(41, 6);
		loewe.createTable(42, 7);

		// Check if everything is created correctly
		System.out.println(loewe.getInfo());

		// Now add groups to queue
		loewe.createGroup(currGroupId++, 2);
		loewe.createGroup(currGroupId++, 6);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 2);
		loewe.createGroup(currGroupId++, 1);
		loewe.createGroup(currGroupId++, 7);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 3);

		// Queue operations: add(), peek(), remove()
		// Check if queue returns the first element that was added:
		loewe.peekNextGroup();

		// Simulation
		ArrayList<Group> simulationGroups = new ArrayList<>();
		simulationGroups.add(new Group(currGroupId++, 3));
		simulationGroups.add(new Group(currGroupId++, 4));
		simulationGroups.add(new Group(currGroupId++, 5));
		simulationGroups.add(new Group(currGroupId++, 1));
		simulationGroups.add(new Group(currGroupId++, 2));
		simulationGroups.add(new Group(currGroupId++, 2));
		simulationGroups.add(new Group(currGroupId++, 2));
		simulationGroups.add(new Group(currGroupId++, 7));
		simulationGroups.add(new Group(currGroupId++, 2));
		simulationGroups.add(new Group(currGroupId++, 4));
		simulationGroups.add(new Group(currGroupId++, 3));

		Simulation simulation = new Simulation(loewe, simulationGroups);
		simulation.start();
	}
	
}
