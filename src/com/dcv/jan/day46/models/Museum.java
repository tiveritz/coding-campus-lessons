package src.com.dcv.jan.day46.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import src.com.dcv.jan.day46.abstracts.Person;


public class Museum {
	private String name;
	private Room[] rooms;
	private Calendar openingTime;
	private Calendar entryUntil;
	private Calendar closingTime;	

	public Museum(String name, int openingTime, int closingTime) {
		this.name = name;
		this.openingTime = parseTime(openingTime);
		this.closingTime = parseTime(closingTime);

		Calendar entryUntil = (Calendar) this.closingTime.clone();
		entryUntil.add(Calendar.HOUR, -1);

		this.entryUntil = entryUntil;
	}

	// -- SETTER -----------------------------------------------------------------------------------
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	// -- GETTER -----------------------------------------------------------------------------------
	public Calendar getOpeningTime() {
		return openingTime;
	}
	
	public Calendar getClosingTime() {
		return closingTime;
	}
	
	public Room getRandomRoom() {
		Random random = new Random();
		return rooms[random.nextInt(rooms.length - 1)];
	}
	
	public boolean isOpenForVisitors(Calendar currTime) {
		if (currTime.compareTo(entryUntil) < 0) {
			return true;
		};
		return false;
	}
	
	// -- METHODS -----------------------------------------------------------------------------------
	public void close() {
		for (Room room : rooms) {
			room.sendPersonsHome();
		}
	}

	public void simulate() {
		ArrayList<Person> personsToSimulate = new ArrayList<>();

		for (Room room : rooms) {
			room.releaseSatisfiedPersons();
			if (room.onlyThievesInRoom()) {
				room.stealArtPiece();
			} else {
				personsToSimulate.addAll(room.getCopyOfPersons());
			}
		}

		for (Person person : personsToSimulate) {
			Random random = new Random();

			if (random.nextInt(9) < 7) {
				person.visitRoom(getRandomRoom());
			}
		}
	}
	
	// -- HELPER METHODS ---------------------------------------------------------------------------
	private Calendar parseTime(int time) {
		Calendar dateTime = Calendar.getInstance();
		dateTime.set(Calendar.HOUR_OF_DAY, time);
		dateTime.set(Calendar.MINUTE, 0);
		return dateTime;
	}
}

