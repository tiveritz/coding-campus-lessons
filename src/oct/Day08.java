package src.oct;

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
                          // Für Zusatzaufgabe 2
                          // "Äustrian",
                          // "Ünited",
                          // "Öustrian",
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
        String[] namesSorted = Arrays.copyOf(names, names.length);
        
        for (int i = 0; i < namesSorted.length; i++) {
            for (int j = 0; j < namesSorted.length-1-i; j++) {
                if (namesSorted[j].compareTo(namesSorted[j + 1]) < 0) {
                    String temp = namesSorted[j];
                    namesSorted[j] = namesSorted[j + 1];
                    namesSorted[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(namesSorted));
        
        // Zusatzaufgabe 1
        // Primäre Sortierung nach Elementlänge absteigend
        // Secundäre Sortierung alphabetisch aufsteigend
        String[] namesDoubleSorted = Arrays.copyOf(names, names.length);
        
        for (int i = 0; i < namesDoubleSorted.length; i++) {
            for (int j = 0; j < namesDoubleSorted.length-1-i; j++) {
                if (namesDoubleSorted[j].length() <= namesDoubleSorted[j + 1].length()) {
                     if (namesSorted[j].compareTo(namesSorted[j + 1]) > 0) {
                        String temp = namesDoubleSorted[j];
                        namesDoubleSorted[j] = namesDoubleSorted[j + 1];
                        namesDoubleSorted[j + 1] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(namesDoubleSorted));

        // Zusatzaufgabe 2
        // Berücksichtige Umlaute bei der Sortierung
        String[] namesWiUml = Arrays.copyOf(names, names.length);
        
        for (int i = 0; i < namesWiUml.length; i++) {
            for (int j = 0; j < namesWiUml.length-1-i; j++) {
                String s1 = namesWiUml[j]
                    .toLowerCase()
                    .replace("ä", "a")
                    .replace("ö", "o")
                    .replace("ü", "u");
                String s2 = namesWiUml[j + 1]
                    .toLowerCase()
                    .replace("ä", "a")
                    .replace("ö", "o")
                    .replace("ü", "u");
                if (s1.compareTo(s2) < 0) {
                    String temp = namesWiUml[j];
                    namesWiUml[j] = namesWiUml[j + 1];
                    namesWiUml[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(namesWiUml));
    }
}
