package src.com.dcv.nov;

import java.util.Arrays;
import java.util.Random;

public class Day19Part01 {
    private static Random rand = new Random();

    public static void helloWorldTwoDimensionalArray() {

        // Declare the two dimensional array
        int[][] arr = new int[7][7];

        // Fill the array with random numbers
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = rand.nextInt(50);
            }
        }

        // Print the array (deepToString is quite useful, equivalent to toSting)
        System.out.println(Arrays.deepToString(arr));

        // Print the row sums
        for (int row = 0; row < arr.length; row++) {
            int rowSum = 0;
            for (int col : arr[row]) {
                rowSum += col;
            }
            System.out.println("Sum of row " + row + " : " + rowSum);
        }
    }
}
