package src.com.dcv.dec.day37;

public class Animal {
	private String name;
	private String species;
	private String type;
	private String foodType;
	private String foodUnit;
	private int foodRequirenment;
	private int bites;

	// Constructor ---------------------------------------------------------------------------------
	protected Animal(
		Zoo zoo, String enclosure, String name, String species, String type, String foodType,
		int foodRequirenment, String foodUnit)
		{
			this.name = name;
			this.species = species;
			this.type = type;
			this.foodType = foodType;
			this.foodUnit = foodUnit;
			this.foodRequirenment = foodRequirenment;
			
			Enclosure e = zoo.createEnclosure(enclosure);
			e.assignAnimal(this);

			
		}
		
		// Getter ---------------------------------------------------------------------------------
		public String getInfo() {
			return name + "(" + species + ", " + type + ") needs " + foodRequirenment + foodUnit + " " + foodType;
		}

		public String getName() {
			return this.name;
		}
}
