package src.com.dcv.jan.day41;

import java.util.ArrayList;

public class Simulation {
	Restaurant restaurant;
	ArrayList<Group> groups;

	public Simulation(Restaurant restaurant, ArrayList<Group> groups) {
		this.restaurant = restaurant;
		this.groups = new ArrayList<>();
		this.groups.addAll(groups);
	}

	public void start() {
		boolean working = true;

		System.out.println("Simulation started\n");
		int iteration = 1;
		while(working) {
			System.out.println("Time: " + iteration * 15 + " min");
			iteration++;
			
			restaurant.assignTable();
			restaurant.doRestaurantStuff();

			if (restaurant.guestsInRestaurant() == 0) {
				working = false;
				System.out.println("All guests satisfied");
			}
		}
		// restaurant.assignTables()
		// restaurant.doRestaurantStuff()
		// restaurant.createGroup()
	}
}
