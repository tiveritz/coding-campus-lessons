package src.com.dcv.jan.day41;

public class Table {
	private int tableNumber;
	private int seats;
	private Group assignedTo;
	private Restaurant restaurant;

	public Table(int tableNumber, int seats, Restaurant restaurant) {
		this.tableNumber = tableNumber;
		this.seats = seats;
		this.assignedTo = null;
		this.restaurant = restaurant;
	}

	public void assignGroup(Group group) {
		this.assignedTo = group;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public int getSeats() {
		return seats;
	}

	public boolean isAssigned() {
		if (assignedTo == null) {
			return false;
		}
		return true;
	}

	public void serveTable() {
		int groupState = assignedTo.getServingIteration();
		switch (groupState) {
			case 0:
				Printer.print("L Getting order:", 3);
				assignedTo.order(restaurant.getMenu().getDrinks(), .9);
				break;
			case 1:
				Printer.print("L Getting order:", 3);
				assignedTo.order(restaurant.getMenu().getStarters(), .4);
				assignedTo.order(restaurant.getMenu().getDishes(), .8);
				break;
			case 5:
				Printer.print("L Getting order:", 3);
				assignedTo.order(restaurant.getMenu().getDesserts(), .3);
				assignedTo.order(restaurant.getMenu().getDrinks(), .4);
				break;
			case 8:
				Printer.print("L Table has finished and pays the bill, " + assignedTo.getBill() + "€", 3);
				assignedTo = null;
				break;
			default:
				Printer.print("L Table is busy", 3);
			}

			if (assignedTo != null) {
				assignedTo.nextIteration();
			}
		}
		
	}