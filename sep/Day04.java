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

        // Declare the array
        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };

        // Declare variables
        int compareCounter = 0;
        int swapCounter = 0;
        int smallestElem = 0;
        int smallestElemIndex = 0;
        int temp = 0;
        int arrLen = arr.length;
        boolean toSwap = false;

        // Selection sort
        for (int i = 0; i < arrLen - 1; i++) {
            toSwap = false;
            smallestElem = arr[i];
            compareCounter += 1;
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Print counter
        System.out.println("\nComparisons: " + compareCounter);
        System.out.println("Swaps: " + swapCounter);
    }

    public static void bubbleSort() {
        // Informiere dich über den BubbleSort Sortieralgorithmus und setze
        // sie in Java um.
        // Vergleiche auch die Komplexität, indem du bei jedem Zugriff auf das
        // Array einen Counter erhöhst und diesen am Ende mit ausgiebst.

        // Declare the array
        int[] arr = { 6, 23, 78, 34, 89, 2, 56, 78, 6, 30, 27, 81, 7, 7, 84, 20 };

        // Declare variables
        int temp = 0;
        int compareCounter = 0;
        int swapCounter = 0;
        boolean swap = true;
        int arrLen = arr.length;

        while (swap == true) {
            swap = false;
            for (int i = 1; i < arrLen; i++) {
                compareCounter += 1;
                if (arr[i - 1] > arr[i]) {
                    swap = true;
                    swapCounter += 1;

                    temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        // Print sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Print counter
        System.out.println();
        System.out.println("Comparisons: " + compareCounter);
        System.out.println("Swaps: " + swapCounter);
    }
}
