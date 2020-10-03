package sep;

import java.util.Arrays;

public class Day04 {
    public static int[] randNumArrBuilder() {
        // Das ist keine Übung, kann aber für Tests ganz hilfreich sein
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        return arr;
    }

    public static void selectionSort() {
        // Informiere dich über den SelectionSort Sortieralgorithmus und setze
        // sie in Java um.
        // Vergleiche auch die Komplexität, indem du bei jedem Zugriff auf das
        // Array einen Counter erhöhst und diesen am Ende mit ausgiebst.

        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };

        int compareCounter = 0;
        int swapCounter = 0;
        int smallestElem = 0;
        int smallestElemIndex = 0;
        int temp = 0;
        int arrLen = arr.length;
        boolean toSwap = false;

        for (int i = 0; i < arrLen - 1; i++) {
            toSwap = false;
            smallestElem = arr[i];

            for (int j = i + 1; j < arrLen; j++) {
                compareCounter += 1;
                // check if actual element is smaller as smallest known element
                if (arr[j] < smallestElem) {
                    smallestElem = arr[j];
                    smallestElemIndex = j;
                    toSwap = true;
                }
            }
            // Swap the values inside array if toSwap is true
            if (toSwap) {
                swapCounter += 1;
                temp = arr[i];
                arr[i] = smallestElem;
                arr[smallestElemIndex] = temp;
            }
        }

        // Print sorted array
        System.out.print(Arrays.toString(arr));

        // Print counter
        System.out.println("\nComparisons: " + compareCounter);
        System.out.println("Swaps: " + swapCounter);
    }

    public static void bubbleSort() {
        // Informiere dich über den BubbleSort Sortieralgorithmus und setze
        // sie in Java um.
        // Vergleiche auch die Komplexität, indem du bei jedem Zugriff auf das
        // Array einen Counter erhöhst und diesen am Ende mit ausgiebst.

        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };
        // int[] arr = { 99,88,77,66,55,44,33,22,11,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5 };

        // -> This is the easier version but not 100% correct bubbleSort
        int temp = 0;
        int compareCounter = 0;
        int swapCounter = 0;
        int arrLen = arr.length;
        
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arrLen-1-i; j++) {
                compareCounter++;
                if (arr[j] > arr[j + 1]) {
                    swapCounter++;
                    
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // -> This is the real bubbleSort
        // Alternative with while (is more efficient when last parts of array
        // already sorted)
        
        /*
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < arrLen-1-i; i++) {
                compareCounter++;
                if (arr[i] > arr[i + 1]) {
                    swap = true;
                    swapCounter++;

                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        */

        // Print sorted array
        System.out.print(Arrays.toString(arr));

        // Print counter
        System.out.println();
        System.out.println("Comparisons: " + compareCounter);
        System.out.println("Swaps: " + swapCounter);
    }
}
