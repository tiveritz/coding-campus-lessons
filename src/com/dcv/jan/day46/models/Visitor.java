package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.interfaces.Person;


public class Visitor extends Person {

	public Visitor(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getInfo() {
		return super.getInfo("Visitor");
	}

	public void visitRoom(Room room) {
		Room currentRoom = super.getRoom();
		if(currentRoom != null){
			currentRoom.removeVisitor(this);
		}
		room.addVisitor(this);
		super.setRoom(room);
		System.out.println("Visitor " + super.getFirstName() + " " + super.getLastName() + " moves to room " + room.getRoomNumber());
	}
}

