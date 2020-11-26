package src.com.dcv.nov.day29part01;

public class Human {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String placeOfBirth;
	private String gender;

	Human(String firstName, String lastName, String dateOfBirth, String placeOfBirth, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getGender() {
		return gender;
	}
}
