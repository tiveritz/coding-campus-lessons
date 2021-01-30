package src.com.dcv.jan.day46.simulations;

import src.com.dcv.jan.day46.generators.VisitorGenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import src.com.dcv.jan.day46.generators.ArtPieceGenerator;
import src.com.dcv.jan.day46.generators.RoomGenerator;
import src.com.dcv.jan.day46.models.ArtPiece;
import src.com.dcv.jan.day46.models.Guard;
import src.com.dcv.jan.day46.models.Museum;
import src.com.dcv.jan.day46.models.Room;
import src.com.dcv.jan.day46.models.Thief;
import src.com.dcv.jan.day46.models.Visitor;

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

		// Generate the Rooms with initial ArtPieces
		Room[] rooms = new Room[numberOfRooms];
		for (int i = 0; i < numberOfRooms; i++) {
			Random random = new Random();
			int numberOfArtPieces = random.nextInt(5) + 4;
			ArtPiece[] artPieces = new ArtPiece[numberOfArtPieces];
			for (int j = 0; j < numberOfArtPieces; j++) {
				artPieces[j] = (ArtPieceGenerator.createArtPiece());
			}

			rooms[i] = RoomGenerator.createRoom(i, artPieces);
		}
		museum.setRooms(rooms);

		// Generate the Guards
		System.out.println("--------------------");
		System.out.println("Museum working day starts");
		System.out.println("--------------------");
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
		
		closingHour.add(Calendar.MINUTE, -15);

		while (currentTime.compareTo(closingHour) < 0) {
			System.out.println(timeFormat.format(currentTime.getTime()));
			currentTime.add(Calendar.MINUTE, 15);

			if (museum.isOpenForVisitors(currentTime)) {
				addRandomVisitorsToMuseum();
				addRandomThief();
			};

			museum.simulate();
			timeSleep(100);
		}
		System.out.println(timeFormat.format(currentTime.getTime()));
		museum.close();

		System.out.println("\n--------------------");
		System.out.println("Simulation completed");
		System.out.println("--------------------\n");
	}

	// -- HELPER -----------------------------------------------------------------------------------
	private void addRandomVisitorsToMuseum() {
		Random random = new Random();

		Visitor[] visitors = VisitorGenerator.createVisitors(random.nextInt(3));
		for (Visitor visitor : visitors) {
			Room room = museum.getRandomRoom();
			visitor.visitRoom(room);
			visitor.observeArtPiece(room.getRandomArtPiece());
		}
	}

	private void addRandomThief() {
		Random random = new Random();

		if (random.nextInt(10) <= 2) { // random: 0...9
			Thief thief = VisitorGenerator.createThief();
			Room room = museum.getRandomRoom();
			thief.visitRoom(room);
			thief.observeArtPiece(room.getRandomArtPiece());
		}
	}

	private void timeSleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException ie) {
			// I don't care about that
		}
	}
}
