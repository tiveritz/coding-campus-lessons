package src.com.dcv.jan.day46.generators;

import java.util.Random;

import src.com.dcv.jan.day46.models.Guard;

public class VisitorGenerator {
	private static String[] firstNames = new String[]{"Daniel", "Erich", "Bokhee", "Marcella", "Ali", "Sabrina", "Mihael", "Samet", "Irene"};
    private static String[] lastNames = new String[]{"Maier", "Müller", "Böhler", "Schmidt", "Apfelauge", "Rüetli", "Mähr", "Amann", "Metzger"};
	
	public static Guard[] createGuards(int count) {
        Guard[] guards = new Guard[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length - 1)];
            String lastName = lastNames[random.nextInt(lastNames.length - 1)];
            guards[i] = new Guard(firstName, lastName);
        }
        return guards;
    }
}
