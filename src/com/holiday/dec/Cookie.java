package src.com.holiday.dec;

public class Cookie {
	String name;
	String packageUnit;

	public Cookie(String name, String packageUnit) {
		this.name = name;
		this.packageUnit = packageUnit;
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
