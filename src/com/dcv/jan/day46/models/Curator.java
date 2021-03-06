package src.com.dcv.jan.day46.models;

import java.util.Random;

import src.com.dcv.jan.day46.abstracts.Person;
import src.com.dcv.jan.day46.enums.PersonType;
import src.com.dcv.jan.day46.generators.ArtPieceGenerator;


public class Curator extends Person {
	private int donations;
	private Random random;
	private ArtPiece desiredArtPiece;

	public Curator(String firstName, String lastName) {
		super(PersonType.CURATOR, firstName, lastName);
		this.random = new Random();
	}

	// -- METHODS ----------------------------------------------------------------------------------
	public void collectDonations() {
		donations += random.nextInt(100);
	}

	public boolean purchaseArtPiece() {
		if (desiredArtPiece == null) {
			desiredArtPiece = ArtPieceGenerator.createArtPiece();
		}

		int artPiecePrice = desiredArtPiece.getPrice();
		if (artPiecePrice <= donations) {
			donations -= artPiecePrice;
			System.out.println(getInfo() + " purchases Art " + desiredArtPiece.getInfo() + " for " + artPiecePrice + "€");
			return true;
		}
		return false;
	}

	public void bringArtPieceToRoom(Room room) {
		room.addArtPiece(desiredArtPiece);
		desiredArtPiece = null;
		System.out.println("Curator brings art piece to room " + room.getRoomNumber());
	}
}
