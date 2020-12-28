package src.com.holiday.dec;

import java.util.ArrayList;

public class Baker {
	String name;
	Cookie bestCookie;
	ArrayList<Cookie> producableCookies;
	int dailyBakingCapacity;
	int bakingCapacity;
	int dailyDeliveryCapacity;
	int deliveryCapacity;

	public Baker(String name, int dailyBakingCapacity, int dailyDeliveryCapacity, Cookie bestCookie,
				 Cookie[] producableCookies) {
		this.name = name;
		this.dailyBakingCapacity = dailyBakingCapacity;
		this.dailyDeliveryCapacity = dailyDeliveryCapacity;
		this.bestCookie = bestCookie;
		this.producableCookies = new ArrayList<>();
		
		for (Cookie cookie : producableCookies) {
			this.producableCookies.add(cookie);
		}
	}

	// Getter --------------------------------------------------------------------------------------
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
