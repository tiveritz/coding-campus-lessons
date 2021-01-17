package src.com.dcv.jan.day41;

import java.util.HashMap;

public class Group {
	private int id;
	private int count;
	private double bill;
	private int waitingIteration;
	private int maxWaitingIteration;
	private int servingIteration;

	// STATES
	// null -> not served yet
	// 0 - busy
	// 1 iteration 0: arrived -> drink
	// 2 iteration 1; order1 -> starter and/or dish
	// 3 iteration 5: order2 -> dessert and/or drink
	// 4 iteration 8: bill


	public Group(int id, int count) {
		this.id = id;
		this.count = count;
		this.bill = 0;
		this.waitingIteration = 0;
		this.maxWaitingIteration = 2;
		this.servingIteration = 0;
	}

	public void nextIteration() {
		servingIteration++;
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public int getWaitingIteration() {
		return waitingIteration;
	}

	public int getMaxWaitingIteration() {
		return maxWaitingIteration;
	}

	public void raiseWaitingIteration() {
		waitingIteration++;
	}

	public int getServingIteration() {
		return servingIteration;
	}

	public double getBill() {
		return bill;
	}

	public void order(HashMap<String, Double> menu, double probability) {
		for (int guest = 0; guest < count; guest++) {
			if (Math.random() <= probability) {
				// Make an array with values for random order selection
				Object[] menuItems = menu.keySet().toArray();
				var chosenItem = menuItems[(int)(Math.random() * menuItems.length)];

				// Order this item
				Printer.print("Guest " + guest + " orders " + chosenItem, 4);
				bill += menu.get(chosenItem);

			}
		}
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
