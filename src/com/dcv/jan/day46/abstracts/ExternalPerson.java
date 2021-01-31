package src.com.dcv.jan.day46.abstracts;

import src.com.dcv.jan.day46.enums.PersonType;
import src.com.dcv.jan.day46.interfaces.IVisitor;
import src.com.dcv.jan.day46.models.ArtPiece;
import src.com.dcv.jan.day46.models.Room;


public abstract class ExternalPerson extends Person implements IVisitor {
	private ArtPiece artPiece;
	private int satisfactionLvl;
	private int maxSatisfactionLvl;

	public ExternalPerson(PersonType personType, String firstName, String lastName, int maxSatisfactionLvl) {
		super(personType, firstName, lastName);
		this.satisfactionLvl = 0;
		this.maxSatisfactionLvl = maxSatisfactionLvl;
	}

	// -- INTERFACE --------------------------------------------------------------------------------
	@Override
	public void leaveMuseum() {
		System.out.println(getInfo() + " leaves the museum.");
	}
	
	@Override
	public void observeArtPiece(ArtPiece artPiece) {
		System.out.println(getInfo() + " observes art: " + artPiece.getInfo());
		this.artPiece = artPiece;
	}
	
	// -- METHODS -----------------------------------------------------------------------------------
	public void visitRoom(Room newRoom) {
		super.visitRoom(newRoom);
		satisfactionLvl++;
	}

	public boolean isSatisfied() {
		if (satisfactionLvl >= maxSatisfactionLvl) {
			return true;
		}
		return false;
	}
	
	// -- GETTER -----------------------------------------------------------------------------------
	public ArtPiece getArtPiece() {
		return artPiece;
	}
}
