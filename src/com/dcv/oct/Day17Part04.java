package src.com.dcv.oct;

import java.util.Scanner;

public class Day17Part04 {
    public static void helloWorldScanner() {
        int age = Integer.MIN_VALUE;

        Scanner sc = new Scanner(System.in);
        System.out.println("Your age?");
        while (age == Integer.MIN_VALUE) {
            try {
                String line = sc.nextLine();
                age = Integer.valueOf(line.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Not a number!");
            }
        }
        System.out.println("You " + age + " years old.");

        sc.close();
    }
}


