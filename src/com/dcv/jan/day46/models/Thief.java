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
}
