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
        int fieldWidth = userInputScanner(2, 40);
        int pos = fieldWidth / 2;
        boolean running = true;

        while (running) {

            if (pos == 0 || pos == fieldWidth) {
                running = false;
            }
            
            printGuy(pos, fieldWidth);
            pos = newPos(pos);
            
            timeSleep(400);
        }
    }

    /** Asks for user input, checks if Integer and if within min an max values.
      * 
      * @param min Lowest possible input
      * @param max Highest possible input
      * @return Integer (whitespace cleaned)
      */
    public static int userInputScanner(int min, int max) {
        System.out.println("Welcome to the walkingGuy game. Enter the fieldWidth: ");

        int fieldWidth = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        boolean looping = true;

        while (looping) {
            try {
                String line = sc.nextLine();
                fieldWidth = Integer.valueOf(line.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Not a valid number! Try again.");
                continue;
            }
            if (fieldWidth < min || fieldWidth > max) {
                System.out.println("Not within the boundries (" + min + " - " + max + ")");
            } else {
                looping = false;;
            }
        }
        sc.close();

        return fieldWidth;
    }

    /** Prints the Game including the wall, the guy and the whitespace.
      * 
      * @param position The Position where the guy stands
      * @param fieldWidth The total width of the field
      */
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

    /** Randomly changes the position (30% left, 30% right, 40% stay)
      * 
      * @param pos The current position
      * @return The new position
      */
    public static int newPos(int pos) { 
        int chance = random.nextInt(10);
        if (chance <= 2) {
            pos++;
        } else if (chance >= 7) {
            pos--;
        }
        return pos;
    }

    /** Pauses the execution of the program.
      * 
      * @param milliseconds The amount of time to pause the program in milliseconds
      */
    public static void timeSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {
            // I don't care about that
        }
    }
}
