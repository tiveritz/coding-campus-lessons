package src.com.dcv.dec.day37;
public class FoodStock {
	private String foodType;
	private int dailyDemand;
	private String unit;

	// Constructor ---------------------------------------------------------------------------------
	public FoodStock(String foodType, String unit) {
		this.foodType = foodType;
		this.unit = unit;
	}
	
	// Setter --------------------------------------------------------------------------------------
	public void addDemand(int demand) {
		this.dailyDemand += demand;
	}
	
	// Getter --------------------------------------------------------------------------------------
	public String getInfo() {
		return dailyDemand + " " + unit + " " + foodType;
	}
	
	public String getType() {
		return this.foodType;
	}
}
