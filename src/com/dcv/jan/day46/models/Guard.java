package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.interfaces.Person;


public class Guard extends Person {

	public Guard(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public String getInfo() {
		return super.getInfo("Guard");
	}

	public void visitRoom(Room room) {
		Room currentRoom = super.getRoom();
		if(currentRoom != null){
			currentRoom.removeGuard(this);
		}
		room.addGuard(this);
		super.setRoom(room);
		System.out.println("Guard " + super.getFirstName() + " " + super.getLastName() + " moves to room " + room.getRoomNumber());
	}
}

