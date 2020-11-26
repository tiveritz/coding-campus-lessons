package src.com.dcv.nov.day29part01;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Human {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String placeOfBirth;
	private String gender;
	Date date = new Date();
	private Calendar calendar = new GregorianCalendar();
	
	Human(String firstName, String lastName, String dateOfBirth, String placeOfBirth, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;

		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
		} catch (Exception e) {
			System.out.println("badly handled exception");
		}
		calendar.setTime(date);
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

	public int getBirthDay() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public int getBirthMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}

	public int getBirthYear() {
		return calendar.get(Calendar.YEAR);
	}
	

	@Override
	public String toString() {
		return "{\"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"gener\": \"" + gender + "\"}";
	}
}
