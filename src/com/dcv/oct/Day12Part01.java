package src.com.dcv.oct;

public class Day12Part01 {
    public static void stringOperationsRepetition() {
        System.out.println("Hello".charAt(1));
        System.out.println("Hello".substring(3));
        System.out.println("Hello".substring(1, 4));
        System.out.println("Hello".contains("ll"));
        System.out.println("Hello".contains("L"));

        // Numerischen Wert von einem Buchstaben ausgeben
        System.out.println((int) 'l');
        System.out.println((int) 'L');
    }

    // Unofficial excercise:
    // Schreibe ein Funktion, welche die Funktionalität von substring(int start, int
    // end)
    // implementiert OHNE, dass substring verwendet wird.
    // Beispiel:
    // Eingabe: meinSubstring(“Ich heiße Lukas”, 5, 2)
    // Ausgabe: he
    public static void substringFunction(String string, int start, int end) {
        System.out.println(string);
        System.out.println(start);
        System.out.println(end);

        for (int i = start; i < end; i++) {
            System.out.print(string.charAt(i));
        }
    }
}
