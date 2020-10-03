package oct;

import java.util.Arrays;

public class Day09 {
    public static void helloWorldFunctions() {
        int[] myArray = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };
        bubbleSort(myArray); //function call. Note the passed parameter (arr)
    }

    // This is the function which sortes the array which was given as parameter
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        int arrLen = arr.length;
        boolean swap = true;

        while (swap) {
            swap = false;
            for (int i = 0; i < arrLen-1-i; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}