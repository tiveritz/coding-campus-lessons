package src.sep;

public class Day03 {

    public static void simpleMultiplication() {
        // # Gib das kleine Einmaleins aus

        int multResult = 0;

        for (int multiplier = 1; multiplier <= 9; multiplier++) {
            System.out.println("Reihe " + multiplier);
            for (int multiplicand = 1; multiplicand <= 9; multiplicand++) {
                multResult = multiplier * multiplicand;
                System.out.println(multiplier + " * " + multiplicand + " = " + multResult);
            }
        }
    }

    public static void primes() {
        // Gib alle Primzahlen von 0 bis 100 aus

        boolean isPrime = true;
        int primes = 100;

        for (int prime = 2; prime <= primes; prime++) {
            for (int i = 2; i < prime; i++) {
                isPrime = true;
                if (prime % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(prime);
            }
        }
    }

    public static void palindrom() {
        // Prüfe, ob ein gegebenes Wort ein Palindrom ist

        String word = "anna";
        boolean isPalin = true;
        int lenWord = word.length();

        for (int i = 0; i < lenWord / 2; i++) {
            if (word.charAt(i) != word.charAt(lenWord - 1 - i)) {
                isPalin = false;
                break;
            }
        }
        System.out.println(isPalin);
    }

    public static void helloWorldArray() {
        // Hello World Arrays

        String[] letters = { "A", "B", "C", "D", "E" };
        int[] numbers = { 1, 3, 5, 6, 3, 5 };

        // ----- Iterates through list with for loop ---------------------------
        /*
         * for(int i = 0; i < letters.length; i++) { System.out.println(letters[i]); }
         */

        // ----- Iterates through list items with foreach ----------------------
        for (String item : letters) {
            System.out.println(item);
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
