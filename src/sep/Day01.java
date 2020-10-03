package src.sep;

public class Day01 {
      public static void helloWorld() {
            // Erste Deklarationen und Ausgaben mit Java

            System.out.println("Hello World!");

            String myString = "Hi";
            double myDouble = 1.2;
            int myInt = 2;
            System.out.println(myString);
            System.out.println(myDouble);
            System.out.println(myInt);
      }

      public static void numberList() {
            // Ordne die Zeilen so an, das die Ergebnisse genau in dieser
            // Reihenfolge ausgegeben werden: 8, 8, 81, 81, 9, 9, 7, 7

            int neueZahl = 7;

            System.out.println(++neueZahl);
            System.out.println(neueZahl++);
            System.out.println(neueZahl * neueZahl);
            System.out.println(neueZahl = neueZahl * neueZahl);
            System.out.println(neueZahl = (neueZahl - 9) / 8);
            System.out.println(neueZahl--);
            System.out.println(--neueZahl);
            System.out.println(neueZahl);
      }
}
