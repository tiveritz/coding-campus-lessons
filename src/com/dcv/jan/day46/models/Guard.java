package src.com.dcv.jan.day46.models;

import src.com.dcv.jan.day46.abstracts.Person;
import src.com.dcv.jan.day46.enums.PersonType;


public class Guard extends Person {

	public Guard(String firstName, String lastName, int maxSatisfactionLevel) {
		super(PersonType.GUARD, firstName, lastName, maxSatisfactionLevel);
	}

	public String getInfo() {
		return super.getInfo();
	}
}

