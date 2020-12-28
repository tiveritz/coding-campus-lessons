package src.com.holiday.dec;

import java.util.ArrayList;
// java.util.List;

public class Bakery {
	String name;
	ArrayList<Baker> bakers;
	ArrayList<Customer> customers;
	ArrayList<Cookie> cookies;
	ArrayList<Order> pendingOrders;
	ArrayList<Order> readyOrders;
	
	public Bakery(String name) {
		this.name = name;
		this.bakers = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.cookies = new ArrayList<>();
		this.pendingOrders = new ArrayList<>();
		this.readyOrders = new ArrayList<>();
	}

	// Factory -------------------------------------------------------------------------------------
	public Baker createBaker(String name, int dailyBakingCapacity, int dailyDeliveryCapacity,
							 Cookie bestCookie, Cookie[] producableCookies) {
		for (Baker baker : bakers) {
			if (baker.getName().equals(name)) {
				return baker;
			}
		}

		Baker b = new Baker(name, dailyBakingCapacity, dailyDeliveryCapacity, bestCookie, producableCookies);
		bakers.add(b);
		return b;

	}

	public Cookie createCookie(String name, String packageUnit) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie;
			}
		}

		Cookie c = new Cookie(name, packageUnit);
		cookies.add(c);
		return c;
	}

	// Setter --------------------------------------------------------------------------------------
	public void registerCustomer(Customer customer) {
		customers.add(customer);
	}

	// Getter --------------------------------------------------------------------------------------
	public String getStructure() {
		StringBuilder sb = new StringBuilder();

		sb.append(name)
		  .append("\n")
		  .append("  L Bakers: ")
		  .append(bakers.toString())
		  .append("\n")
		  .append("  L Cookies: ")
		  .append(cookies.toString())
		  .append("\n")
		  .append("  L Customers: ")
		  .append(customers.toString())
		  .append("\n")
		  .append("  L Orders: ")
		  .append(pendingOrders.toString())
		  .append("\n");

		return sb.toString();
	}

	// Methods -------------------------------------------------------------------------------------
	public void placeOrder(Order order) {
		pendingOrders.add(order);
	}

	public void produce() {
		for (Order order : pendingOrders) {
			System.out.println("producing order: " + order);
			for (Item item : order.getItems()) {
				System.out.println("producing item: " + item);
			}
			System.out.println();
		}
	}
}
