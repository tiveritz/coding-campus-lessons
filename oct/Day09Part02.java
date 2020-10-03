package oct;

import java.util.Arrays;

public class Day09Part02 {
    public static void functionCallFromOtherClass() {
        int[] myArray = {10, 9, 8, 6, 5, 8, 2, 4, 3, 6};
        
        //function call. Note the passed parameter (myArray)
        int[] sortedArray = Day09Part01.bubbleSort(myArray);
        System.out.println("Function call from another class");
        System.out.println(Arrays.toString(sortedArray));

    }
}
