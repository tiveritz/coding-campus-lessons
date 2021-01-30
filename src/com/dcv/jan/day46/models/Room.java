package src.com.dcv.jan.day46.models;

import java.util.ArrayList;
import java.util.Random;

import src.com.dcv.jan.day46.abstracts.Person;
import src.com.dcv.jan.day46.enums.PersonType;


public class Room {
	private int roomNumber;
	private ArrayList<ArtPiece> artPieces;
	private ArrayList<Person> persons;

	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		this.artPieces = new ArrayList<>();
		this.persons = new ArrayList<>();
	}

	// -- GETTER -----------------------------------------------------------------------------------
	public int getRoomNumber() {
		return roomNumber;
	}

	public ArrayList<Person> getCopyOfPersons() {
		ArrayList<Person> personsCopy = new ArrayList<>();

		for (Person person : persons) {
			personsCopy.add(person);
		}
		return personsCopy;
	}


	// -- SETTER -----------------------------------------------------------------------------------
	public void addArtPieces(ArtPiece[] artPieces) {
		for (ArtPiece artPiece : artPieces) {
			this.artPieces.add(artPiece);
		}
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void removePerson(Person person) {
		persons.remove(person);
	}

	// -- METHODS ----------------------------------------------------------------------------------
	public void sendPersonsHome() {
		for (Person person : persons) {
			if (person.getType() == PersonType.VISITOR || person.getType() == PersonType.THIEF) {
				System.out.println(person.getInfo() + " goes home");
			}
		}
		persons.clear();
	}

	public boolean onlyThievesInRoom() {
		boolean onlyThievesInRoom = true;

		for (Person person : persons) {
			if (person.getType() != PersonType.THIEF) {
				onlyThievesInRoom = false;
				break;
			}
		}



		return onlyThievesInRoom;
	}

	public void stealArtPiece() {
		for (Person person : persons) {
			Thief thief = (Thief) person;
			thief.stealArtPiece();

		}
		persons.clear();
	}

	public void releaseSatisfiedPersons() {
		for (Person person : getCopyOfPersons()) {
			if (person.getType() == PersonType.VISITOR || person.getType() == PersonType.THIEF) {
				if (person.isSatisfied()) {
					System.out.println(person.getInfo() + " is satisfied and leaves");
					persons.remove(person);
				}
			}
		}
	}

	public ArtPiece getRandomArtPiece() {
		Random random = new Random();
		return artPieces.get(random.nextInt(artPieces.size()));
	}
}