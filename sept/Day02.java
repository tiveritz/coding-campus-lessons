public class Day02 {

    public static void Sum() {
        // Berechne die Summer der Zahlen von 0 bis 1000
        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }
        System.out.print(sum);
    }

    public static void Factorial() {
        // Berechne die Fakultät der Zahl 20

        int factorial = 20;
        long multiplikation = 1;

        for (int i = 1; i <= factorial; i++) {
            multiplikation *= i;
        }
        System.out.println(multiplikation);
    }

    public static void PiApproximation() {
        // Berechne die Annäherung von PI mit Hilfe der Formel 4 - 4/3 + 4/5 - 4/7 ...

        double numerator = 4.0;
        double denominator = 1.0;
        int aproxxLevel = 10;
        double piApprox = 0.0;

        for (int i = 0; i <= aproxxLevel; i++) {
            piApprox += (numerator / denominator);
            denominator += 2;
            piApprox -= (numerator / denominator);
            denominator += 2;
        }

        System.out.println(piApprox);
    }

    public static void PiApproximationPosNeg() {

        // Declare required variables
        double numerator = 4.0;
        double denominator = 1.0;
        int aproxxLevel = 10;
        double negApprox = 0.0;
        double posApprox = 0.0;

        // Calculate positive approximation
        int i = 0;
        denominator = 3.0;
        while (i <= aproxxLevel) {
            posApprox += (numerator / denominator);
            denominator += 4.0;
            i++;
        }

        // Calculate negative approximation
        int j = 0;
        denominator = 1.0;
        while (j <= aproxxLevel) {
            negApprox += (numerator / denominator);
            denominator += 4.0;
            j++;
        }

        // Calculate Pi approximation
        double piApproximation = negApprox - posApprox;

        // Print values
        System.out.println("Negative approximation: " + posApprox);
        System.out.println("Positive approximation: " + negApprox);
        System.out.println("Pi approximation " + piApproximation);
    }

    public static void TextSquareOutput() {
        // Erstelle ein Programm das mittels 2 Schleifen ein Quadrat mit einem
        // Buchstaben ausgibt

        int size = 5;
        String text = "A";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void TextArrowOutput() {
        // Erstelle den folgenden Output mit Schleife
        // *
        // **
        // ***
        // ****
        // *****
        // ****
        // ***
        // **
        // *

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}