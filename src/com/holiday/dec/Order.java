package src.com.holiday.dec;

import java.util.ArrayList;

public class Order {
	Customer customer;
	ArrayList<Item> items;

	public Order(Customer customer) {
		this.customer = customer;
		this.items = new ArrayList<>();
	}

	// Setter --------------------------------------------------------------------------------------
	public void addItem(Item item) {
		items.add(item);
	}

	// Getter --------------------------------------------------------------------------------------
	public ArrayList<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Order from " + customer;
	}
}
