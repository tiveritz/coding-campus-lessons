package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.ExternalPerson;
import src.com.dcv.jan.day46.enums.PersonType;

public class Thief extends ExternalPerson {

	public Thief(String firstName, String lastName, int maxSatisfactionLevel) {
		super(PersonType.THIEF, firstName, lastName, maxSatisfactionLevel);
	}

	public String getInfo() {
		return super.getInfo();
	}

	public void stealArtPiece() {
		System.out.println(getInfo() + " steals art: " + getArtPiece().getInfo());
	}

	public ArtPiece getArtPiece() {
		return super.getArtPiece();
	}
}
