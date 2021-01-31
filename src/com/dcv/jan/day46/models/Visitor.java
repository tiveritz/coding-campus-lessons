package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.ExternalPerson;
import src.com.dcv.jan.day46.enums.PersonType;


public class Visitor extends ExternalPerson {

	public Visitor(String firstName, String lastName, int maxSatisfactionLvl) {
		super(PersonType.VISITOR, firstName, lastName, maxSatisfactionLvl);
	}
}
