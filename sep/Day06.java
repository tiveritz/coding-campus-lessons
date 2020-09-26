import java.util.Arrays;

public class Day06 {

    static int compareCounter = 0;
    static int swapCounter = 0;

    public static void helloWorldRecursion(int n) {
        // Recherchiere Recursion in Java

        if (n == 0) {
            System.out.println("End of Recursion");
        } else {
            System.out.println("Recursion number " + n);
            n--;
            helloWorldRecursion(n); // This is where the magic happens
        }
    }

    public static void mergeSort() {
        // Informiere dich über den MergeSort Sortieralgorithmus und setze
        // sie in Java um.
        // Vergleiche auch die Komplexität, indem du bei jedem Zugriff auf das
        // Array einen Counter erhöhst und diesen am Ende mit ausgiebst.

        // Info von Dr. Google
        // Step 1: Create duplicate copies of sub-arrays to be sorted
        // Step 2: Maintain current index of sub-arrays and main array
        // Step 3: Until we reach the end of either L or M, pick larger among elements L
        // and M and place them in the correct position at A[p..r]
        // Step 4: When we run out of elements in either L or M, pick up the remaining
        // elements and put in A[p..r]

        // Declare the array
        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };
        // System.out.println(Arrays.toString(arr));

        int[] sortedArray = mergeSortAlgor(arr);
        System.out.println(Arrays.toString(sortedArray));

        // Print counter
        System.out.println("Comparisons: " + compareCounter);
        System.out.println("Swaps: " + swapCounter);

    }

    static int[] mergeSortAlgor(int[] arr) {

        // This works recursively
        //
        // If passed array == 1 return unchanged array
        // If array > 0 sort the array and return the sorted array
        // Sorting:
        // Split the passed arra in half (left / right)
        // Sort left and right array (recursion) and overwrite current arrays

        // Declare length variable and helper array (sorted array)
        int arrLen = arr.length;
        int[] sorted = arr;

        // Check if array length > 1. If not return array without change.
        // An array of 1 is already considered sorted
        if (arrLen > 1) {
            // Determine indexes of left and right half. This depends if array
            // has a even or odd number of elements
            int riHalf = 0;
            int leHalf = arrLen / 2;

            if (arrLen % 2 == 0) {
                riHalf = arrLen / 2;
            } else {
                riHalf = (arrLen / 2) + 1;
            }

            // Declare left and right helper arrays
            int[] left = new int[leHalf];
            int[] right = new int[riHalf];

            // Fill the helper arrays with elements
            for (int i = 0; i < leHalf; i++) {
                left[i] = arr[i];
            }

            int riIndex = 0;
            for (int j = leHalf; j < arrLen; j++) {
                right[riIndex] = arr[j];
                riIndex++;
            }

            // Sort helper arrays -> This is recursion. If list has only one
            // element the same list is returned
            left = mergeSortAlgor(left);
            right = mergeSortAlgor(right);

            // Merge left and right arrays
            int i = 0;
            int j = 0;
            int k = 0;

            // Do that for length of sorted array
            while (k < sorted.length) {
                // Check for index boundries
                if (i < left.length && j < right.length) {
                    compareCounter += 1;
                    if (left[i] < right[j]) {
                        sorted[k] = left[i];
                        swapCounter += 1;
                        i += 1;
                    } else {
                        sorted[k] = right[j];
                        swapCounter += 1;
                        j += 1;
                    }
                } else { // That means there are still values left in the arrays
                    if (i == left.length) {
                        sorted[k] = right[j];
                        swapCounter += 1;
                        j += 1;
                    } else {
                        sorted[k] = left[i];
                        swapCounter += 1;
                        i += 1;
                    }
                }
                k += 1;
            }

            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));
        }

        return sorted;
    }

}