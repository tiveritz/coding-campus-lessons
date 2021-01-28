package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.interfaces.Person;


public class Thief extends Person {

	public Thief(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getInfo() {
		return super.getInfo("Thief");
	}

	public void visitRoom(Room room) {
		Room currentRoom = super.getRoom();
		if(currentRoom != null){
			currentRoom.removeThief(this);
		}
		room.addThief(this);
		super.setRoom(room);
		System.out.println("Guard " + super.getFirstName() + " " + super.getLastName() + " moves to room " + room.getRoomNumber());
	}
	
}
