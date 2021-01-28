package src.com.dcv.jan.day46.simulations;

import src.com.dcv.jan.day46.generators.VisitorGenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import src.com.dcv.jan.day46.generators.RoomGenerator;
import src.com.dcv.jan.day46.models.Guard;
import src.com.dcv.jan.day46.models.Museum;

public class Simulation {
	Museum museum;
	int numberOfRooms;
	int numberOfGuards;
	int maxGuestsPerTick;

	public Simulation(Museum museum, int numberOfRooms, int numberOfGuards, int maxGuestsPerTick) {
		this.museum = museum;
		this.numberOfRooms = numberOfRooms;
		this.numberOfGuards = numberOfGuards;
		this.maxGuestsPerTick = maxGuestsPerTick;
	}

	public void init() {
		museum.setRooms(RoomGenerator.createRooms(numberOfRooms));

		Guard[] guards = VisitorGenerator.createGuards(numberOfGuards);
		for (Guard guard : guards) {
			guard.visitRoom(museum.getRandomRoom());
		}
	}

	public void start() {
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		System.out.println("--------------------");
		System.out.println("Simulation started");
		System.out.println("--------------------\n");
		
		Calendar currentTime = (Calendar) museum.getOpeningTime().clone();
		Calendar closingHour = museum.getClosingTime();
		
		while (currentTime.compareTo(closingHour) < 0) {
			System.out.println(timeFormat.format(currentTime.getTime()));
			currentTime.add(Calendar.MINUTE, 15);
		}

		System.out.println("\n--------------------");
		System.out.println("Simulation completed");
		System.out.println("--------------------\n");
	}
}
