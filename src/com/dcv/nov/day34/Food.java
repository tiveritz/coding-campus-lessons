package src.com.dcv.nov.day34;

public class Food {
	private String name;
	private int amount;
	private String unit;

	public Food(Zoo zoo, String name, int amount, String unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
		zoo.addFood(this);
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public String getUnit() {
		return unit;
	}
}
