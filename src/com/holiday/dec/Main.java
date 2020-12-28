package src.com.holiday.dec;


public class Main {

	public static void main(String args[]) {
		Bakery bakery = new Bakery("Weihnachtsbäckerei");
		Cookie schokodinger = bakery.createCookie("Schokodinger", "100g");
		Cookie vanilledinger = bakery.createCookie("Vanilledinger", "100g");
		Cookie kokosdinger = bakery.createCookie("Kokosdinger", "100g");
		bakery.createBaker("Bibi", 5, 6, schokodinger, new Cookie[]{schokodinger, vanilledinger, kokosdinger});
		bakery.createBaker("Rudi", 4, 6, vanilledinger, new Cookie[]{schokodinger, vanilledinger, kokosdinger});
		bakery.createBaker("Idi", 7, 5, kokosdinger, new Cookie[]{schokodinger, vanilledinger, kokosdinger});

		Customer customer1 = new Customer("customer1", "I dont care Street 1, 4430 abcd");
		Customer customer2 = new Customer("customer2", "Somewhere 3, 4637 asdf");
		Customer customer3 = new Customer("customer3", "Winterstreet 23, 2341 blablabla");

		bakery.registerCustomer(customer1);
		bakery.registerCustomer(customer2);
		bakery.registerCustomer(customer3);

		Order order1 = new Order(customer1);
		order1.addItem(new Item(schokodinger, 2));
		order1.addItem(new Item(vanilledinger, 2));
		bakery.placeOrder(order1);

		Order order2 = new Order(customer2);
		order2.addItem(new Item(kokosdinger, 4));
		bakery.placeOrder(order2);

		System.out.println(bakery.getStructure());

		bakery.produce();
	}	
}
