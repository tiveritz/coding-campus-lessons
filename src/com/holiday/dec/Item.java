package src.com.holiday.dec;

public class Item {
	Cookie cookie;
	int amount;
	
	public Item(Cookie cookie, int amount) {
		this.cookie = cookie;
		this.amount = amount;
	}

	// Getter --------------------------------------------------------------------------------------
	@Override
	public String toString() {
		return amount + " " + cookie;
	}
}
