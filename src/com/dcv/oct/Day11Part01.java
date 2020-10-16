package src.com.dcv.oct;

import java.util.Arrays;
import java.util.Vector;

public class Day11Part01 {
    // Repetition wrapper classes:
    // An example for wrapper classes -> requred for vector classes (Integer 
    // instead of int, Character instead of char)

    public static void collectionExample() {
        // Normal integer array
        int buf [] = new int[5];

        for (int i = 0; i < buf.length; i++) {
            buf[i] = 100;
        }

        System.out.println(Arrays.toString(buf));

        // Now with vector
        Vector<Integer> vec = new Vector<Integer>();

        for (int i = 0; i <= 8; i++) {
            vec.add(i);
        }

        vec.remove(3);

        for (int element : vec) {
            System.out.print(element + " ");
        }
    }

    // Calculate the faculty of a given number
    // Example 5! should result to 120
    // Mathematical problem: 5! = 4!
    public static long recursionFaculty(int n) {
        System.out.println("faculty " + n + " begin");
        long result = 1;
        if (n > 1) {
            result = n * recursionFaculty(n - 1);
        }
        System.out.println("faculty " + n + " end");

        return result;
    }

    // Same Example without recursion
    public static long facultyWithoutRecursion(int n) {
        long result = n;
        for (int i = n; i > 1; i--) {
            result *= (i - 1);
        }
        return result;
    }

    // Other version with rising loop
    public static long facultyWithoutRecursion2(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
