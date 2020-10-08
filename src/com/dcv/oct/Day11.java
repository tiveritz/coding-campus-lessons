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

        vec.add(199);
        vec.add(200);

        for (int element : vec) {
            System.out.print(element + " ");
        }
    }
    
}
