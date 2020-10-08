package src.com.dcv.oct;

import java.util.Arrays;
import java.util.Vector;

public class Day11 {

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
    
}
