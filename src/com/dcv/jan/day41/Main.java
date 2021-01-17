package src.com.dcv.jan.day41;


public class Main {
	public static void main(String[] args) {
		int currGroupId = 0;
		
		// Create Restaurant
		Restaurant loewe = new Restaurant("Gasthof Löwen");
		Menu menu = loewe.createMenu();
		menu.addDrink("Draft beer", 4.5);
		menu.addDrink("Cola", 3.5);
		menu.addDrink("Apple Juice", 3.5);
		menu.addDrink("Sparkling Water", 1.5);
		menu.addDrink("Coffee", 4.5);
		menu.addDrink("Tea", 2.5);
		menu.addStarter("Salad", 5.5);
		menu.addStarter("Smoked salmon", 6.5);
		menu.addStarter("Soup", 4.5);
		menu.addStarter("Bred", 3.5);
		menu.addDish("Steak", 19.5);
		menu.addDish("Vienna Schnitzel", 16.5);
		menu.addDish("Burger", 14.5);
		menu.addDish("Club Sandwich", 13.5);
		menu.addDessert("Cheese Cake", 7.5);
		menu.addDessert("Chocolate Cake", 7.5);
		menu.addDessert("Crossaint", 4.5);

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
		/* deactivated for Simulation
		loewe.createGroup(currGroupId++, 2);
		loewe.createGroup(currGroupId++, 6);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 2);
		loewe.createGroup(currGroupId++, 1);
		loewe.createGroup(currGroupId++, 7);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 3);
		loewe.createGroup(currGroupId++, 3);
		*/

		// Queue operations: add(), peek(), remove()
		// Check if queue returns the first element that was added:
		System.out.print("Test queue peek: ");
		loewe.peekNextGroup();

		// Simulation
		Group[][] simulationGroups = {
			{new Group(currGroupId++, 3), new Group(currGroupId++, 2), new Group(currGroupId++, 1), new Group(currGroupId++, 2)},
			{new Group(currGroupId++, 4), new Group(currGroupId++, 4)},
			{new Group(currGroupId++, 1), new Group(currGroupId++, 1)},
			{new Group(currGroupId++, 7)},
			{new Group(currGroupId++, 2), new Group(currGroupId++, 3), new Group(currGroupId++, 4), new Group(currGroupId++, 4)},
			{new Group(currGroupId++, 2), new Group(currGroupId++, 6), new Group(currGroupId++, 3)},
			{new Group(currGroupId++, 6), new Group(currGroupId++, 5), new Group(currGroupId++, 3)},
			{new Group(currGroupId++, 4), new Group(currGroupId++, 2), new Group(currGroupId++, 6)},
			{new Group(currGroupId++, 4), new Group(currGroupId++, 2), new Group(currGroupId++, 2)},
			{new Group(currGroupId++, 5), new Group(currGroupId++, 4), new Group(currGroupId++, 7)},
			{new Group(currGroupId++, 1), new Group(currGroupId++, 2), new Group(currGroupId++, 2)},
			{new Group(currGroupId++, 2), new Group(currGroupId++, 2), new Group(currGroupId++, 5)},
		};

		Simulation simulation = new Simulation(loewe, simulationGroups);
		simulation.start();
	}
	
}
