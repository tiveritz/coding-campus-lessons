package src.com.dcv.jan.day46.interfaces;

import src.com.dcv.jan.day46.models.Room;

public abstract class Person {
		private String firstName;
		private String lastName;
		private Room room;
	
		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getInfo(String type) {
			return type + " {\n" +
					"\t\"firstName\" : \"" + firstName + "\",\n" +
					"\t\"lastName\" : \"" + lastName + "\"\n" +
					"}";
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}
}
