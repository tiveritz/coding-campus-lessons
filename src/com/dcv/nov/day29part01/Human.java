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
	private Date date;
	private int day;
	private int month;
	private int year;
	
	Human(String firstName, String lastName, String dateOfBirth, String placeOfBirth, String gender) {
		try {
			this.date = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
		} catch (Exception e) {
			System.out.println("badly handled exception");
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		this.month = calendar.get(Calendar.MONTH);
		this.year = calendar.get(Calendar.YEAR);

		
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

	public int getBirthDay() {
		return day;
	}
}
