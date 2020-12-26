package src.com.dcv.dec.day37;


public class Main {
	public static void main(String[] args) {
		
		// Create Zoo
		Zoo zoo = new Zoo("Jurassic Zoo", "Simon Masrani");

		// Note that not all Objects are assigned to a variable when instantiating. That is only
		// required if you want to access objects directly. Since most objects in this example are
		// referenced inside Vectors of "parent" Objects, there is really no reason to do that

		// Create Animals and reference them with variables -> for later use
		Animal hybrid = zoo.createAnimal(
			"Research area", "Hybrid","Indominus Rex", "Carnivore", "cows", 30, "");
		Animal blue = zoo.createAnimal(
			"Training cage", "Blue", "Velociraptor", "Carnivore", "pigs", 1, "");
		
		// Create Animals and don't reference them with a variable -> reference in "parent object"
		zoo.createAnimal(
			"Training cage", "Charlie", "Velociraptor", "Carnivore", "pigs", 1, "");
		zoo.createAnimal(
			"Training cage", "Delta", "Velociraptor", "Carnivore", "pigs", 1, "");
		zoo.createAnimal(
			"Training cage", "Echo", "Velociraptor", "Carnivore", "pigs", 1, "");
		zoo.createAnimal(
			"3 million gallon water pool", "Mosi", "Mosasaurus", "Carnivore", "fish", 200, "");
		zoo.createAnimal(
			"Forest cage", "Tyrant Lizard", "Tyrannosaurus Rex", "Carnivore", "cows", 15, "");
		zoo.createAnimal(
			"Open area", "Fused Lizard", "Ankylosaurus", "Herbivore", "grass", 600, "kg");
		zoo.createAnimal(
			"Aviary", "Needle head", "Pteranodon", "Carnivore", "fish", 25, "");
		zoo.createAnimal(
			"Aviary", "Triangle face", "Pteranodon", "Carnivore", "fish", 30, "");
		zoo.createAnimal(
			"Aviary", "Fish diver", "Pteranodon", "Carnivore", "fish", 22, "");
			
			
		// Create personell
		zoo.createVeterinary("Dr. Alan Grant");
		zoo.createDinosaurHandler("Owen Grady", blue, new String[] {"Training cage"});
		zoo.createDinosaurHandler("Barry", hybrid, new String[] {"Research area", "Aviary", "Open area"});


		// Instead of printing directly with the object's methods, let them build a string and 
		// return it. the actual print is done here
		System.out.println();
		System.out.println(zoo.getStructure() + "\n");
		System.out.println("Demand of food:\n" + zoo.getFoodDemand() + "\n");

		// Simulation
		Simulation simulation = new Simulation(zoo, 6, .1, .5, .1);
		simulation.start();
	}	
}
