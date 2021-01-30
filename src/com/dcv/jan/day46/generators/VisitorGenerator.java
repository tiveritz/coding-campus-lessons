package src.com.dcv.jan.day46.generators;

import java.util.Random;

import src.com.dcv.jan.day46.models.Guard;
import src.com.dcv.jan.day46.models.Thief;
import src.com.dcv.jan.day46.models.Visitor;

public class VisitorGenerator {
	private static String[] firstNames = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private static String[] lastNames = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	
	public static Guard[] createGuards(int count) {
		Guard[] guards = new Guard[count];
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			String firstName = firstNames[random.nextInt(firstNames.length - 1)];
			String lastName = lastNames[random.nextInt(lastNames.length - 1)];
			guards[i] = new Guard(firstName, lastName, random.nextInt(6) + 4);
		}
		return guards;
	}

	public static Visitor[] createVisitors(int count) {
		Visitor[] visitors = new Visitor[count];
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			String firstName = firstNames[random.nextInt(firstNames.length - 1)];
			String lastName = lastNames[random.nextInt(lastNames.length - 1)];
			visitors[i] = new Visitor(firstName, lastName, random.nextInt(6) + 4);
		}
		return visitors;
	}

	public static Thief createThief() {
		Random random = new Random();

		String firstName = firstNames[random.nextInt(firstNames.length - 1)];
		String lastName = lastNames[random.nextInt(lastNames.length - 1)];
		return new Thief(firstName, lastName, random.nextInt(6) + 4);
	}
}
