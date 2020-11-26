package src.com.dcv.nov.day29part01;

public class Main {
	public static void main(String[] args) {
		Human h1 = new Human("Ignatz", "Aliof", "01.01.1990", "Costa Rica", "M");
		Human h2 = new Human("Rudi", "Burtlof", "10.02.2002", "New Asgard", "M");
		Human h3 = new Human("Silke", "Grantlbart", "09.05.2000", "Mercury", "W");

		printHuman(h1);
		printHuman(h2);
		printHuman(h3);
	}
	
	public static void printHuman(Human h) {
		System.out.printf("%-16s %-16s %-16s %-16s %-16s%n", h.getFirstName(), h.getLastName(), h.getDateOfBirth(), h.getPlaceOfBirth(), h.getGender());
		System.out.println(h.toString());
		System.out.println("Date Of Birth (Tag) " + h.getBirthYear());
	}
}

