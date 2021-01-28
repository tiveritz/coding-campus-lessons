package src.com.dcv.jan.day46.generators;

import src.com.dcv.jan.day46.models.Room;

public class RoomGenerator {

	public static Room[] createRooms(int count) {
		Room[] rooms = new Room[count];
		for (int i = 0; i < count; i++) {
			rooms[i] = new Room(i + 1);
		}

		return rooms;
	}
	
	
}
