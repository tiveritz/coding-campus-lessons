import java.util.Arrays;

public class Day06 {
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
        // int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };
        int[] arr = { 9, 2, 3, 3, 8, 6, 7, 4, 6, 1, 9, 0, 4 };

        // recursive method MergeSort (array)
        // If array > 0 Split the array in half (Left | Right)
        // call MergeSort (Left half)
        // call MergeSort (Right half)
        // then merge the sub arrays
        //
        // Method merge arrays (that is not easy in java)
        // Declare left helper array
        // Declare right helper array
        // Fill the two helper arrays
        // Get larger element and fill into arr

        mergeSortAlgor(arr);
    }

    // difficult -> use left and right length as method arguments in order for the
    // recursion to work
    //
    static void mergeSortAlgor(int[] arr) {
        // if (left < right) {
        // int half = (left + right) / 2;
        //
        // mergeSortAlgor(arr, left, half);
        // mergeSortAlgor(arr, half + 1, right);
        //
        // int test = half + 1;
        // System.out.println("Array Algorythmus " + left + " - " + half + " | " + test
        // + " - " + right);
        //
        // } <-- versteh ich nicht

        // neuer ansatz: Schritt eins: arrays aufsplitten (mit recursion) bis nur noch
        // sub arrays mit 1 element vorhanden sind

        int arrLen = arr.length;

        if (arrLen > 1) {
            int leHalf = 0;
            int riHalf = 0;

            if (arrLen % 2 == 0) {
                leHalf = arrLen / 2;
                riHalf = arrLen / 2;
            } else {
                leHalf = arrLen / 2;
                riHalf = (arrLen / 2) + 1;
            }
            int half = arrLen / 2;
            int[] left = new int[leHalf];
            int[] right = new int[riHalf];

            for (int i = 0; i < half; i++) {
                left[i] = arr[i];
            }

            int riIndex = 0;
            for (int j = half; j < arrLen; j++) {
                right[riIndex] = arr[j];
                riIndex++;
            }

            System.out.println(Arrays.toString(left));
            System.out.println(Arrays.toString(right));

            mergeSortAlgor(left);
            mergeSortAlgor(right);

        }
    }

}