package src.com.dcv.oct;

import java.util.Random;

public class Day16PArt02 {
    public static void randomSum() {
        // Erstelle ein Programm, dass Zufallszahlen zwischen 10 und 30 generiert. Das Programm soll
        // die Zufallszahlen zusammenzählen. Sobald die Zahl 15 oder die Zahl 25 kommt, wird das
        // Programm beendet und die Summe der vorherigen Zufallszahlen ausgegeben!

        int sum = 0;
        boolean looping = true;
        
        while (looping) {
            int randomNumber = randomNumberRange(10, 30);
            System.out.println(randomNumber + " +");
            sum += randomNumber;

            if (randomNumber == 15 || randomNumber == 25) {
                looping = false;
            }
        }
        System.out.println("=====\n" + sum);
    }

    public static int randomNumberRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min + 1)) + min;

    }
}
