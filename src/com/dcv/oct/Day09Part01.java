package src.com.dcv.oct;

import java.util.Arrays;

public class Day09Part01 {
    public static void helloWorldFunctions() {
        int[] myArray = {6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20};
        
        //function call. Note the passed parameter (myArray)
        int[] sortedArray = bubbleSort(myArray);
        //System.out.println("Sorted Array");
        //System.out.println(Arrays.toString(sortedArray));

        // Original Array remained untouched
        System.out.println("Test if original array remains untouched");
        System.out.println(Arrays.toString(myArray));

        // Weiteres Beispiel
        int[] myArray2 = {-2, -9, 5, 9, 5, 2, 4, -3, 8, -6, 4, 6};
        int[] sortedArray2 = bubbleSort(myArray2);
        System.out.println("Test if another array works");
        System.out.println(Arrays.toString(sortedArray2));

    }

    // This is the function which sortes the array which was given as parameter
    /***
     * Creates a copy of the original array and returns the sorted copy
     * @param arrToSort
     * Pass the array you want to sort
     */
    public static int[] bubbleSort(int[] arrToSort) {
        int[] arrSorted = Arrays.copyOf(arrToSort, arrToSort.length);

        int arrSortedLen = arrSorted.length;
        int temp = 0;
        
        for (int i = 0; i < arrSortedLen; i++) {
            for (int j = 0; j < arrSortedLen-1-i; j++) {
                if (arrSorted[j] > arrSorted[j + 1]) {
                    temp = arrSorted[j];
                    arrSorted[j] = arrSorted[j + 1];
                    arrSorted[j + 1] = temp;
                }
            }
        }

        return arrSorted;
    }
}