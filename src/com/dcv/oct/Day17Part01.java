package src.com.dcv.oct;

import java.util.Random;

public class Day17Part01 {
    private static Random random = new Random();

    public static void randomRepetition() {
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }    
    }
}
