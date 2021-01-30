package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.ExternalPerson;
import src.com.dcv.jan.day46.enums.PersonType;

public class Visitor extends ExternalPerson {

	public Visitor(String firstName, String lastName, int maxSatisfactionLevel) {
		super(PersonType.VISITOR, firstName, lastName, maxSatisfactionLevel);
	}

	public String getInfo() {
		return super.getInfo();
	}
}

