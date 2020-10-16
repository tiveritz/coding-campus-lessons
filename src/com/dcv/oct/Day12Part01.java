package src.com.dcv.oct;

import java.util.Arrays;

public class Day12Part01 {
    public static void stringOperationsRepetition() {
        System.out.println("Hello".charAt(1));
        System.out.println("Hello".substring(3));
        System.out.println("Hello".substring(1, 4));
        System.out.println("Hello".contains("ll"));
        System.out.println("Hello".contains("LL"));

        String[] array = "das ist ein test".split(" ");
        System.out.println(Arrays.toString(array));

        // Print numeric value of a character
        System.out.println((int) 'l');
        System.out.println((int) 'L');
    }

    // Write a function, which mirrors the functionality of substring(int start, int end)
    public static void substringFunction(String string, int start, int end) {
        System.out.println("String: " + string);
        System.out.println("Start: " + start);
        System.out.println("End: " + end);

        for (int i = start; i < end; i++) {
            System.out.print(string.charAt(i));
        }
    }
}
