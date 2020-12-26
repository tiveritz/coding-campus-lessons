package src.com.dcv.dec.day37;
import java.util.Vector;

public class Zoo {
	private String name;
	private String chairname;
	private Vector<Enclosure> enclosures;
	private Vector<DinosaurHandler> dinosaurHandlers;
	private Vector<FoodStock> foodStock;
	private Vector<Veterinary> veterinaries;

	public Zoo(String name, String chairman) {

		// A constructor does not neccessarily always need this.something = something. It is
		// perfectly valid to do some more interesting stuff here. Calls some helper functions,
		// validate data, do calculations (or in this case a T-Rex String concatenation)
		this.name =
			" e-e\n" +
			"(\\_/)\\\n" +
			" `-'\\ `--.___,\n" +
			"    '\\( ,_.-'\n" +
			"       \\\\\n" +
			"       ^'\n" + name; // grrr

		// Note that other code initializes the Vectors here with ... = new Vector<>(). In this
		// example we don't do that here, check out the factory section -> Vectros are only
		// initialized when needed
	}
	
	// Factory -------------------------------------------------------------------------------------
	public Animal createAnimal(
		String enclosure, String name, String species, String type, String foodType, int foodDemand,
		String foodUnit)
		{
			
			// Do two things here:
			
			// 1. create the foodStock with the food data and demand
			createFoodStock(foodType, foodDemand, foodUnit);
			
			// 2. Create a new Animal
			return new Animal(this, enclosure, name, species, type, foodType, foodDemand, foodUnit);
			// The animal has no association to the foodStock whatsoever, that is not required. Still
			// the animal has attributes regarding his food for informative purposes (getStructure())
		}

	public Enclosure createEnclosure(String name) {
		
		// Initialize a new Vector when it is still empty at this moment
		if (enclosures == null) {
			enclosures = new Vector<>();
		}
		
		for (Enclosure enclosure : enclosures) {
			if (enclosure.getName().equals(name)) {
				// Means that this objects was already created before. Now just
				// return the objects
				
				return enclosure;
			}
		}
		
		// Note that if the code directly above reveiled an already existing object the program will
		// never go below the return statement -> return always stops execution of below code
		Enclosure e = new Enclosure(name);
		enclosures.add(e);
		return e;
	}

	public DinosaurHandler createDinosaurHandler(
		String name, Animal favouriteAnimal, String[] enclosures) {

		// Initialize a new Vector when it is still empty at this moment
		if (dinosaurHandlers == null) {
			dinosaurHandlers = new Vector<>();
		}
		
		for (DinosaurHandler dinosaurHandler : dinosaurHandlers) {
			if (dinosaurHandler.getName().equals(name)) {
				// Means that this objects was already created before. Now just
				// return the objects
				return dinosaurHandler;
			}
		}
		
		// Note that if the code directly above reveiled an already existing object the program will
		// never go below the return statement -> return always stops execution of below code
		
		// Since we allow to pass an array of enclosure responsibilities now handle them
		// -> create the enclosure (the createEnclosure is in the same zoo class, so there is no
		// need to call over the class (zoo.createEnclosure(...)) -> Just call the method as usual)
		Vector<Enclosure> handlerEnclosures = new Vector<>();
		for (String enclosureName : enclosures) {
			Enclosure enclosure = createEnclosure(enclosureName); // Just call the method
			handlerEnclosures.add(enclosure);
		}
		
		DinosaurHandler d = new DinosaurHandler(name, favouriteAnimal, handlerEnclosures);
		dinosaurHandlers.add(d);
		return d;
	}

	public Veterinary createVeterinary(String name) {
		
		// Initialize a new Vector when it is still empty at this moment
		if (veterinaries == null) {
			veterinaries = new Vector<>();
		}
		
		for (Veterinary veterinary : veterinaries) {
			if (veterinary.getName().equals(name)) {
				return veterinary;
			}
		}
		
		// Note that if the code directly above reveiled an already existing object the program will
		// never go below the return statement -> return always stops execution of below code
		Veterinary v = new Veterinary(name);
		veterinaries.add(v);
		return v;
	}
	
	public void createFoodStock(String foodType, int foodDemand, String foodUnit) {
		
		// Initialize a new Vector when it is still empty at this moment
		if (foodStock == null) {
			foodStock = new Vector<>();
		}
		
		// Use a helper boolean to check if food is already in stock. if not, a new FoodStock object
		// has to be created
		
		boolean foodAlreadyInFoodStock = false;
		for (FoodStock food : foodStock) {
			if (food.getType().equals(foodType)) {
				food.addDemand(foodDemand);
				foodAlreadyInFoodStock = true;
			}
		}
		
		if (!foodAlreadyInFoodStock) {
			FoodStock foodToStore = new FoodStock(foodType, foodUnit);
			foodToStore.addDemand(foodDemand);
			foodStock.add(foodToStore);
		}
	}
	
	// Methods -------------------------------------------------------------------------------------
	public void feedAnimals() {
		if (dinosaurHandlers != null) {
			for (DinosaurHandler dinosaurHandler : dinosaurHandlers) {
				dinosaurHandler.feedAnimals();				
			}
		}
	}
		
	public void admireAnimals(double probabilityAdmireStandardAnimal, double probabilityAdmireFavouriteAnimal) {
		if (dinosaurHandlers != null) {
			for (DinosaurHandler dinosaurHandler : dinosaurHandlers) {
				dinosaurHandler.admireAnimals(probabilityAdmireStandardAnimal, probabilityAdmireFavouriteAnimal);				
			}
		}
	}
	
	// Getter --------------------------------------------------------------------------------------
	public String getStructure() {
		// Instantiate StringBuilder -> alterntive to direct printing or String concatenation
		// (" " + name + " ")
		StringBuilder sb = new StringBuilder();
		sb.append(name);
				
		// Only loop through enclosures if Vector was already initialized
		if (enclosures != null) {
			for (Enclosure enclosure : enclosures) {
				sb.append("\n").append(enclosure.getStructure());
			}
		}
		
		// Only loop through veterinaries if Vector was already initialized
		if (veterinaries != null) {
			sb.append("\n").append("Veterinaries");
			for (Veterinary veterinary : veterinaries) {
				sb.append("\n  ").append(veterinary.getName());
			}
		}
		sb.append("\n");
		
		// Only loop through dinosaur handlers if Vector was already initialized
		if (dinosaurHandlers != null) {
			sb.append("\n").append("Dinosaur Handler");
			for (DinosaurHandler handler : dinosaurHandlers) {
				sb.append("\n   - ").append(handler.getInfo());
			}
		}
		return sb.toString(); // The StringBuilder has to be converted to a String before returning
	}

	public String getFoodDemand() {
		StringBuilder sb = new StringBuilder();
		if (foodStock != null) {
			for (FoodStock food : foodStock) {
				sb.append(food.getInfo() + "\n");
			}
		}
		return sb.toString();
	}
}
