package oct;

import java.util.Arrays;

public class Day08 {
    public static void sortNamesArray() {

        String[] names = {
                          "Austrian",
                          "KLM",
                          "China",
                          "Ryan Air",
                          "Lufthansa",
                          "United",
                          "American",
                          "Turkish",
                          "Aeromexico",
                          "Alitalia",
                          "Delta",
                          "Quatar",
                          "Austrian",
                          "Quatar",
                          };

        System.out.println(Arrays.toString(names));

        // 1. Wie viele Elemente sind in der Liste?
        System.out.println("1. Elemente in Array: " + names.length);

        // 2.1 Was ist das kürzeste Element? (Pos + Name)
        String shortestElem = names[0];
        int shortestElemIndex = 0;

        for (int i = 0; i < names.length; i++) {
            if (shortestElem.length() > names[i].length()) {
                shortestElem = names[i];
                shortestElemIndex = i;
            }
        }

        System.out.println("2.1 Shortest Element: " + shortestElem +
                           " at index " + shortestElemIndex
                           );

        // 2.2. Was ist das längste Element? (Pos + Name)
        String longestElem = names[0];
        int longestElemIndex = 0;

        for (int i = 0; i < names.length; i++) {
          if (longestElem.length() < names[i].length()) {
            longestElem = names[i];
            longestElemIndex = i;
          }
        }

        System.out.println("2.2 Longest Element: " + longestElem +
                           " at index " + longestElemIndex
                           );
        
        // 3.1. Was ist alphabetisch das erste Element? (Pos + Name)
        String abcFirstElem = names[0];
        int abcFirstElemIndex = 0;

        for (int i = 0; i < names.length; i++) {
            if (abcFirstElem.compareTo(names[i]) > 0) {
                abcFirstElem = names[i];
                abcFirstElemIndex = i;
            }
        }
        
        System.out.println("3.1 Alphabetically first Element: " + abcFirstElem +
                           " at index " + abcFirstElemIndex
                           );
        
        // 3.2. Was ist alphabetisch das letzte Element? (Pos + Name)
        String abcLastElem = names[0];
        int abcLastElemIndex = 0;

        for (int i = 0; i < names.length; i++) {
            if (abcLastElem.compareTo(names[i]) < 0) {
                abcLastElem = names[i];
                abcLastElemIndex = i;
            }
        }
        
        System.out.println("3.2 Alphabetically last Element: " + abcLastElem +
                           " at index " + abcLastElemIndex
                           );
        
        // 4.1. Gibt es ein Element 2 Mal?
        boolean duplicate = false;

        for (int i = 0; i < names.length; i++) {

            for(int j = 0; j < names.length; j++) {
                if (i == j) {
                    continue;
                } else if (names[i].compareTo(names[j]) == 0) {
                    duplicate = true;
                }
            }
            
            if (duplicate) {
                break;
            }
        }

        if (duplicate) {
            System.out.println("4.1 There is at least one duplicate");
        } else {
            System.out.println("4.1 There are no duplicates");
        }
    
        // 4.2. Welche Elemente gibt es doppelt?
        for (int i = 0; i < names.length; i++) {
            for(int j = 0; j < names.length; j++) {
                if (i == j) {
                    continue;
                } else if (names[i].compareTo(names[j]) == 0) {
                    System.out.println("4.2 Duplicate found: " + names[i]);
                }
            }
        }

        // 8. Sortiere alphabetisch absteigend.
        String temp = "";
        
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length-1-i; j++) {
                if (names[j].compareTo(names[j + 1]) < 0) {
                    temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(names));
            
    }
}
