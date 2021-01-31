package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.Person;
import src.com.dcv.jan.day46.enums.PersonType;


public class Curator extends Person {
	private int donations;

	public Curator(String firstName, String lastName) {
		super(PersonType.CURATOR, firstName, lastName);
	}
	
}
