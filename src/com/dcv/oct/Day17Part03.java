package src.com.dcv.oct;

import java.util.Random;
import java.util.Scanner;


public class Day17Part03 {
    private static Random random = new Random();

    private final static String[] GUY = {
                                            " O ",
                                            "/|\\",
                                            "/ \\"
                                        };

    public static void walkingGuy() {
        int fieldWidth = userInputScanner();
        int pos = fieldWidth / 2;
        boolean running = true;

        while (running) {

            if (pos == 0 || pos == fieldWidth) {
                running = false;
            }
            
            printGuy(pos, fieldWidth);
            pos = newPos(pos);
            
            timeSleep(500);
        }
    }

    public static int userInputScanner() {
        System.out.println("Welcome to the walkingGuy game. Enter the fieldWidth: ");
        Scanner sc = new Scanner(System.in);

        int fieldWidth = sc.nextInt();

        sc.close();

        return fieldWidth;
    }

    public static void printGuy(int position, int fieldWidth) {
        for (String line : GUY) {
            System.out.print("|");
            for (int i = 0; i < position; i++) {
                System.out.print(" ");
            }

            System.out.print(line);

            for (int i = 0; i < fieldWidth - position; i++) {
                System.out.print(" ");
            }
                System.out.println("|");
        }
        System.out.println();
    }

    public static int newPos(int pos) { 
        int chance = random.nextInt(10);
        if (chance <= 2) {
            pos++;
        } else if (chance >= 7) {
            pos--;
        }
        return pos;
    }

    public static void timeSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            // I don't care about that
        }
    }
}
