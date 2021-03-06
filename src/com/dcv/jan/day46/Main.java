package src.com.dcv.jan.day46;

import src.com.dcv.jan.day46.simulations.Simulation;
import src.com.dcv.jan.day46.models.Curator;
import src.com.dcv.jan.day46.models.Museum;


public class Main {
	public static void main(String[] args) {

		Museum museum = new Museum("Bergmuseum", new Curator("Taneleer", "Tivan"), 9, 17);

		Simulation simulation = new Simulation(museum, 6, 3, 4);
		simulation.init();

		System.out.println();
		System.out.println(museum.getStructure());

		simulation.start();
	}
}
