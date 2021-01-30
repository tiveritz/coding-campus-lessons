package src.com.dcv.jan.day46.abstracts;

import src.com.dcv.jan.day46.enums.PersonType;
import src.com.dcv.jan.day46.models.Room;

public abstract class Person {
		private PersonType type;
		private String firstName;
		private String lastName;
		private int satisfactionLevel;
		private int maxSatisfactionLevel;
		private Room room;
	
		public Person(PersonType type, String firstName, String lastName, int maxSatisfactionLevel) {
			this.type = type;
			this.firstName = firstName;
			this.lastName = lastName;
			this.satisfactionLevel = 0;
			this.maxSatisfactionLevel = maxSatisfactionLevel;
			this.room = null;
		}

		public String getInfo() {
			return type + " " + firstName + " " + lastName;
		}

		public boolean isSatisfied() {
			if (satisfactionLevel >= maxSatisfactionLevel) {
				return true;
			}
			return false;
		}

		public PersonType getType() {
			return type;
		}

		public void visitRoom(Room newRoom) {
			if (this.room != null) {
				this.room.removePerson(this);
			}
			this.room = newRoom;
			this.room.addPerson(this);
			satisfactionLevel++;
			System.out.println(getInfo() + " moves to room " + room.getRoomNumber());
		}
}
