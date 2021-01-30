package src.com.dcv.jan.day46.abstracts;

import src.com.dcv.jan.day46.enums.PersonType;
import src.com.dcv.jan.day46.interfaces.IVisitor;
import src.com.dcv.jan.day46.models.ArtPiece;

public abstract class ExternalPerson extends Person implements IVisitor {
	private ArtPiece artPiece;

	public ExternalPerson(PersonType personType, String firstName, String lastName, int maxSatisfactionLevel) {
		super(personType, firstName, lastName, maxSatisfactionLevel);
	}

	@Override
	public void leaveMuseum() {
		System.out.println(getInfo() + " leaves the museum.");
	}

	@Override
	public void observeArtPiece(ArtPiece artPiece) {
		System.out.println(getInfo() + " observes art: " + artPiece.getInfo());
		this.artPiece = artPiece;
	}

	public ArtPiece getArtPiece() {
		return artPiece;
	}
}