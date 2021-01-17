package src.com.dcv.jan.day41;


public class Simulation {
	Restaurant restaurant;
	Group[][] groups;

	public Simulation(Restaurant restaurant, Group[][] groups) {
		this.restaurant = restaurant;
		this.groups = groups;
	}

	public void start() {
		boolean working = true;

		System.out.println("Simulation started\n");
		int iteration = 0;
		while(working) {
			System.out.println("Time: " + iteration * 15 + " min");

			if (iteration < groups.length) {
				int newGroups = groups[iteration].length;
				System.out.println(newGroups + " groups arrived at restaurant");
				for (Group group : groups[iteration]) {
					restaurant.addGroup(group);
				}
			}
			
			restaurant.assignTable();
			restaurant.raiseQueueWaitingIteration();
			restaurant.doRestaurantStuff();
			
			if (!restaurant.areGuestsInRestaurant()) {
				working = false;
				System.out.println("All guests satisfied");
			}

			iteration++;
			System.out.println();
		}
	}
}
