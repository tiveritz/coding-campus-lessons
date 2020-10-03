package oct;

import java.util.Arrays;

public class Day09Part02 {
    public static void functionCallFromOtherClass() {
        int[] myArray = {10, 9, 8, 6, 5, 8, 2, 4, 3, 6};
        
        //function call. Note the passed parameter (myArray)
        int[] sortedArray = Day09Part01.bubbleSort(myArray);
        System.out.println("Function call from another class");
        System.out.println(Arrays.toString(sortedArray));

        // Try to hover over the "bubbleSort()" method to see the Java docs
    }

    /***
     * Prints all values from start (included) to end (not included)
     * @param start
     * Integer for starting value (included)
     * @param end
     * Ineger for ending value (not included)
     */
    public static void recursionCounter(int start, int end) {
        int counter = start;
        System.out.println(counter);
        
        if (counter < end-1) {
            counter++;
            recursionCounter(counter, end);
        }
    }
}
