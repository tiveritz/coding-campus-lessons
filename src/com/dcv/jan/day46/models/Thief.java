package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.ExternalPerson;
import src.com.dcv.jan.day46.enums.PersonType;


public class Thief extends ExternalPerson {
	
	public Thief(String firstName, String lastName, int maxSatisfactionLvl) {
		super(PersonType.THIEF, firstName, lastName, maxSatisfactionLvl);
	}

	// -- METHODS ----------------------------------------------------------------------------------
	public void stealArtPiece() {
		System.out.println(getInfo() + " steals art piece: " + getArtPiece().getInfo());
	}
}
