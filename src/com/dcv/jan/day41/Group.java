package src.com.dcv.jan.day41;


public class Group {
	private int id;
	private int count;
	private double bill;
	private int waitingIteration;
	private String state;

	public Group(int id, int count) {
		this.id = id;
		this.count = count;
		this.bill = 0;
		this.waitingIteration = 0;
		this.state = "drink";
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
