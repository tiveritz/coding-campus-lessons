package src.com.dcv.oct;

import java.util.Arrays;
import java.util.Vector;

public class Day11 {

    // Wiederholung Wrapperklassen:
    // Ein Beispiel für Wrapperklassen -> Für Vektoren muss die Wrapperklasse
    // Integer verwendet werden, int würde Fehler auswerfen
    public static void collectionExample() {
        // Normal integer array
        int buf [] = new int[5];

        for (int i = 0; i < buf.length; i++) {
            buf[i] = 100;
        }

        System.out.println(Arrays.toString(buf));

        // Now with vector
        Vector<Integer> vec = new Vector<Integer>();

        for (int i = 0; i <= 8; i++) {
            vec.add(i);
        }

        vec.remove(3);

        for (int element : vec) {
            System.out.print(element + " ");
        }
    }

    // Berechne die Fakultät einer gegebenen Zahl
    // Beispiel 5! sollte 120 ausgeben
    // Mathematisches Problem: 5! = 5 * 4!
    public static long recursionFaculty(int n) {
        System.out.println("faculty " + n + " begin");
        long result = 1;
        if (n > 1) {
            result = n * recursionFaculty(n - 1);
        }
        System.out.println("faculty " + n + " end");

        return result;
    }

    // Dieselbe Aufgabe nur ohne Rekursion:
    public static long facultyWithoutRecursion(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    } 
}
