package src.com.dcv.jan.day46.models;

import java.util.Calendar;
import java.util.Random;


public class Museum {
	private String name;
	private Room[] rooms;
	private Calendar openingTime;
	private int entryUntil;
	private Calendar closingTime;	

	public Museum(String name, int openingTime, int closingTime) {
		this.name = name;
		this.openingTime = parseTime(openingTime);
		//this.entryUntil = openingTime - 100;
		this.closingTime = parseTime(closingTime);
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

	// -- DEBUG METHODS ----------------------------------------------------------------------------
	public void printStructure() {
		for (Room room : rooms) {
			System.out.println("Room with roomNumber: " + room.getRoomNumber());
			room.printStructure();
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

