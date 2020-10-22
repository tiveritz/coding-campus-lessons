package src.com.dcv.oct;

import java.util.Random;

public class Day17Part01 {
    // Seed = numbers are random, but every execution returns the same numbers
    private static Random random = new Random(3024);

    public static void randomRepetition() {
        String[] words = {"Audi", "BMW", "Mercedes", "Seat", "Volkswagen"};

        for (int i = 0; i < 10; i++) {
            System.out.println(words[random.nextInt(words.length)]);
        }   
    }
}
