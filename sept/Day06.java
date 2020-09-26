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

        // Infor von Dr. Google
        // Step 1: Create duplicate copies of sub-arrays to be sorted
        // Step 2: Maintain current index of sub-arrays and main array
        // Step 3: Until we reach the end of either L or M, pick larger among elements L
        // and M and place them in the correct position at A[p..r]
        // Step 4: When we run out of elements in either L or M, pick up the remaining
        // elements and put in A[p..r]

        // Declare the array
        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };

        /*
         * Use a recursive method MergeSort (array) If array > 0 Split the array in half
         * (Left | Right) call MergeSort (Left half) call MergeSort (Right half) then
         * merge the sub arrays
         * 
         */

        System.out.println("Hello World Merge Sort");
    }

}