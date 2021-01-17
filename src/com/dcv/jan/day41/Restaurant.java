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

		Table t = new Table(tableNumber, seats, this);
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

	public Menu getMenu() {
		return menu;
	}

	// -- SETTER -----------------------------------------------------------------------------------
	public void raiseQueueWaitingIteration() {
		// make a copy of the queue. Can't iterate through queue and remove elements simultaniously
		
		ArrayList<Group> groupsArray = new ArrayList<>();

		for (Group group : queue) {
			groupsArray.add(group);
		}

		for (Group group : groupsArray) {
			if (group.getWaitingIteration() >= group.getMaxWaitingIteration()) {
				Printer.print("! Group " + group.getId() + " waited too long and left", 1);
				queue.remove(group);
			} else {
				group.raiseWaitingIteration();
			}
		}
	}

	public void addGroup(Group group) {
		queue.add(group);
	}

	// -- GETTER -----------------------------------------------------------------------------------
	public String getInfo() {
		return "Restaurant " + name + " with " + tables.size() + " tables";
	}
	
	public void peekNextGroup() {
		System.out.println(queue.peek());
	}
	
	
	public boolean areGuestsInRestaurant() {
		for (Table table : tables) {
			if (table.isAssigned() == true) {
				return true;
			}
		}
		return false;
	}
	
	// -- METHODS ----------------------------------------------------------------------------------
	public void assignTable() {
		ArrayList<Table> freeTables = new ArrayList<>();

		Printer.print("L Checking for free tables", 1);
		if (isTableFree()) {
			Printer.print("L At least one table free", 2);
			Printer.print("L Collecting all free tables", 3);

			// Get an ArrayList with all free tables
			for (Table table : tables) {
				if (table.isAssigned() == false) {
					freeTables.add(table);
				}
			}
		} else {
			Printer.print("L No free tables", 2);
			return;
		}
		
		Printer.print("L Checking for groups outside restaurant", 2);
		if (queue.size() > 0) {
			Printer.print("L Assigning groups to tables", 3);
	
			// Take the table with the highest amount of seats and find the group with the most 
			// optimal amount of people
			// Primary take the optimal group, secondary choose groups that came first
			// - take group with highest count but not higher than table seats

			for (Table freeTable : freeTables) {
				int seats = freeTable.getSeats();
				int highestCount = 0;
				Group assignedGroup = null;
		
				for (Group group : queue) {
					int count = group.getCount();
					if (count == seats) { // if count is the same as seats, immediately break
						assignedGroup = group;
						break;
					} else if (count <= seats && count > highestCount) {
						assignedGroup = group;
						highestCount = count;
					}
				}

				if (assignedGroup != null) {
					freeTable.assignGroup(assignedGroup);
					queue.remove(assignedGroup);
					Printer.print("L Assigning group "
						+ assignedGroup.getId()
						+ " (count: " + assignedGroup.getCount()
						+ ") to table number "
						+ freeTable.getTableNumber()
						+ " (seats: " + freeTable.getSeats()
						+ ")", 4);
				} else {
					Printer.print("L No group could be found for table number "
						+ freeTable.getTableNumber()
						+ " (seats: "
						+ freeTable.getSeats()
						+ ")", 4);
				}
			}
		} else {
			Printer.print("L No groups outside restaurants", 3);
		}
	}
	
	public void doRestaurantStuff() {
		Printer.print("L Serving restaurant guests ", 1);
		for (Table table : tables) {
			if(table.isAssigned()) {
				Printer.print("L Serving table number " + table.getTableNumber(), 2);
				table.serveTable();
			}
		}

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
