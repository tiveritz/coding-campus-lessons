package src.com.dcv.dec.day38;

import java.util.Arrays;


public class Main {
    public static void main(String args[]) {
        String[] array = new String[]{"abc", "def", "ghi", "jkl", "mno"};
        String[] array2 = new String[]{"def", "mno", "abc", "ghi", "jkl"};
        
        System.out.println("Linear search:");
        printSearchResultString(linearSearch(array, "ghi"));
        printSearchResultString(linearSearch(array, "ni"));
        
        System.out.println("\nBinary search:");
        // Note: Since the array is sorted for binary search the returned index isn't correct
        // It does not seem to be what we want, but documentation always takes a sorted array...
        printSearchResultString(binarySearch(array2, "ghi"));
        printSearchResultString(binarySearch(array2, "ni"));

    }
    
    public static Integer linearSearch(String[] arr, String searchString) {
        int comparisonCounter = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisonCounter++;
            if (arr[i].equals(searchString)) {
                System.out.println("Comparisons: " + comparisonCounter);
                return i;
            };
        }
        System.out.println("Comparisons: " + comparisonCounter);
        return null;
    }
    
        public static Integer binarySearch(String[] arr, String searchString) {
            Arrays.sort(arr);
            return binarySearchAlgorithm(arr, 0, arr.length - 1, searchString);
    }
    
    public static Integer binarySearchAlgorithm(String[] arr, int left, int right, String searchString) {
        if (right >= left) { 
            int middle = left + (right - left) / 2; 
            if (arr[middle].equals(searchString)) {
                return middle; 
            }
            if (arr[middle].compareTo(searchString) > 0) {
                return binarySearchAlgorithm(arr, left, middle - 1, searchString); 
            } else {
                return binarySearchAlgorithm(arr, middle + 1, right, searchString); 
            }
        }
        return null;
    }
    
    public static void printSearchResultString(Integer index) {
        if (index != null) {
            System.out.println("Element is at index: " + index);
        } else {
            System.out.println("Element is not in the list");
        }
    }
}