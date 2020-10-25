package src.com.holiday.oct;

import java.util.Random;


public class Holiday01 {
    public static void wichteln() {
        /* To be ready for wichteln for Christmas write a program, that takes an array of names and
         * assigns every name a wichtel.
         * https://de.wikipedia.org/wiki/Wichteln
         */
        String[] names = {"Christian", "Maximilian", "Thomas", "Frank", "Marcel", "Andreas",
                          "Niklas", "Patrick", "Johannes", "Herbert", "Robert", "Pascal"};
        
        String[] assigned = new String[names.length];
        Random random = new Random();
        
        for (int i = 0; i < names.length; i++) {
            boolean looping = true;

            while (looping) {
                int selected = random.nextInt(names.length);
                if (i != selected && !isInArray(assigned, names[selected])) {
                    assigned[i] = names[selected];
                    System.out.println(names[i] + " -> " + names[selected]);
                    looping = false;
                }
            }
        }
    }

    public static boolean isInArray(String[] arr, String string) {
        boolean inArray = false;

        for (String element : arr) {
            if (element != null && element.equals(string)) {
                inArray = true;
                break;
            }
        }
        return inArray;
    }
}
