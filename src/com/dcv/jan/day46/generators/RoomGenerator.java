package src.com.dcv.jan.day46.generators;

import src.com.dcv.jan.day46.models.ArtPiece;
import src.com.dcv.jan.day46.models.Room;


public abstract class RoomGenerator {
	public static Room createRoom(int roomNumber, ArtPiece[] artPieces) {
		Room room = new Room(roomNumber);
		room.addArtPieces(artPieces);
		return room;
	}
}
