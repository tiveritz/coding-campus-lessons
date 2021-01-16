package src.com.dcv.jan.day41;

public class Table {
	private int tableNumber;
	private int seats;
	private Group assignedTo;

	public Table(int tableNumber, int seats) {
		this.tableNumber = tableNumber;
		this.seats = seats;
		this.assignedTo = null;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public boolean isAssigned() {
		if (assignedTo == null) {
			return false;
		}
		return true;
	}
	
}
