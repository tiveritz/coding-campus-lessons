package src.com.dcv.jan.day41;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;


public class Restaurant {
	private String name;
	private Menu menu;
	private ArrayList<Table> tables;
	private Queue<Group> queue;
	private ArrayList<Group> groups;

	public Restaurant(String name) {
		this.name = name;
		this.tables = new ArrayList<>();
		this.queue = new LinkedList<>();
		this.groups = new ArrayList<>();
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
		for (Group q : queue) {
			if (q.getId() == id) {
				return q;
			}
		}

		Group g = new Group(id, count);
		queue.add(g);
		return g;
	}

	public Menu createMenu() {
		Menu menu = new Menu();
		this.menu = menu;
		return menu;
	}

	// -- GETTER -----------------------------------------------------------------------------------
	public String getInfo() {
		return "Restaurant " + name + " with " + tables.size() + " tables";
	}
	
	public void peekNextGroup() {
		System.out.println(queue.peek());
	}
	
	
	public int guestsInRestaurant() {
		return groups.size();
	}
	
	// -- METHODS ----------------------------------------------------------------------------------
	public void assignTable() {
		System.out.println("  L Checking for free tables");
		if (isTableFree()) {
			System.out.println("    L At least one table free");
			System.out.println("      L Collecting all free tables");
			// Get an ArrayList with all free tables
			ArrayList<Table> freeTables = new ArrayList<>();
			for (Table table : tables) {
				if (table.isAssigned() == false) {
					freeTables.add(table);
				}
			}
			
			System.out.println("        L Assigning groups to tables");
			System.out.println(freeTables);
			/*
			for (Group group : queue) {
				int count = group.getCount();
				int 
				for (Table table : tables) {
					if (table.getSeats())
				}
				System.out.println(group.getCount());
			}
			*/
			
		}
	}
	
	public void doRestaurantStuff() {
		System.out.println("doing restaurant stuff");
	}
	
	// -- HELPER METHODS ---------------------------------------------------------------------------
	private boolean isTableFree() {
		for (Table table : tables) {
			if (table.isAssigned() == false) {
				return true;
			};
		}
		return false;
	}
}
