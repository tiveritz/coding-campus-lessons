package sept;

public class Day02 {
    public static void Factorial() {
        // faktorial -> 5! = 5 * 4 * 3 * 2 * 1

        int factorial = 20;
        long multiplikation = 1;

        for (int i = 1; i <= factorial; i++) {
            multiplikation *= i;
        }
        System.out.println(multiplikation);
    }

    public static void Sum() {
        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }
        System.out.print(sum);
    }

    /*
     * Problem: 4 - 4/3 + 4/5 - 4/7 + 4/8 4/1 - 4/n+2 + 4/n+4 - 4/n+6... --> n += 2
     * Attention --> changing + and -
     */

    public static void Pi() {

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

        /*
         * int i = 0; while(i <= aproxxLevel) { if (i % 2 == 0) { piApprox += (numerator
         * / denominator); } else { piApprox -= (numerator / denominator); } denominator
         * += 2; i++; }
         */

        /*
         * for (int i = 0; i <= aproxxLevel; i++) { piApprox += (numerator /
         * denominator); denominator += 2; piApprox -= (numerator / denominator);
         * denominator += 2; }
         */

        // System.out.println(piApprox);
    }

    public static void WeirdA() {
        int size = 5;
        String text = "A";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}