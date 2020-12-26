package src.com.dcv.dec.day37;

public class Simulation {
	private Zoo zoo;
	private int durationInDays;
	private double probabilityAdmireStandardAnimal;
	private double probabilityAdmireFavouriteAnimal;
	private double probabilityOfBite;

	// Constructor ---------------------------------------------------------------------------------
	public Simulation(
		Zoo zoo, int durationInDays, double probabilityAdmireStandardAnimal,
		double probabilityAdmireFavouriteAnimal, double probabilityOfBite)
		{
		this.zoo = zoo;
		this.durationInDays = durationInDays;
		this.probabilityAdmireStandardAnimal = probabilityAdmireStandardAnimal;
		this.probabilityAdmireFavouriteAnimal = probabilityAdmireFavouriteAnimal;
		this.probabilityOfBite = probabilityOfBite;
	}

	// Methods -------------------------------------------------------------------------------------
	public void start() {
		for (int day = 1; day <= durationInDays; day++) {
			System.out.println("\n\nDay " + day + " --------------------");
			zoo.feedAnimals();
			zoo.admireAnimals(probabilityAdmireStandardAnimal, probabilityAdmireFavouriteAnimal);

			timeSleep(1000);
		}
	}

	// Helper methods ------------------------------------------------------------------------------
	private void timeSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            // I don't care about that
        }
    }
}
