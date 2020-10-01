package sept;

import java.util.Arrays;

public class Day05 {
    public static void autoManualArrayOutput() {
        // Gib ein Array mit der toString methode aus. Dann reprodizier die
        // Ausgabe 1:1 mit eigenem Code

        int[] arr = { 1, 2, 3, 99 };
        int arrLen = arr.length;

        // Print array with toString method
        System.out.println(Arrays.toString(arr));

        // Reproduce print manually
        System.out.print("[");
        for (int i = 0; i < arrLen; i++) {
            System.out.print(arr[i]);
            if (i < arrLen - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static String indexToMonth(int index) {
        // This is a helper method to map the businessResult index with Month

        String month = "";
        switch (index) {
            case (0):
                month = "Jänner";
                break;
            case (1):
                month = "Februar";
                break;
            case (2):
                month = "März";
                break;
            case (3):
                month = "April";
                break;
            case (4):
                month = "Mai";
                break;
            case (5):
                month = "Juni";
                break;
            case (6):
                month = "Juli";
                break;
            case (7):
                month = "August";
                break;
            case (8):
                month = "September";
                break;
            case (9):
                month = "Oktober";
                break;
            case (10):
                month = "November";
                break;
            case (11):
                month = "Dezember";
                break;
        }

        return month;
    }

    public static void businessResults() {
        // Ein Buchladen hat den folgenden Montastergebnisse:

        // _ Was ist das Gesamtergebnis? (Summe der Monatsergebnisse)
        // _ Was ist das beste Monatsergebnis?
        // _ In welchem Monat war das beste Monatsergebnis?
        // _ Was ist das schwächste Monatsergebnis?
        // _ In welchem Monat war das schwächste Monatsergebnis?
        // _ War zwei hintereinander kommende Monate mit negativen Ergebnis?
        // _ Was war das längste Intervall mit negativen Ergebnis?
        // _ Was war das zweitbeste Ergebnis?

        int[] businessResult = { 1, 2, -5, 3, 10, -2, -1, -3, 0, 3, 6, 7 };
        int businessResultLen = businessResult.length;
        System.out.println(Arrays.toString(businessResult));

        // Was ist das Gesamtergebnis? (Summe der Monatsergebnisse)
        int summe = 0;
        for (int i = 0; i < businessResultLen; i++) {
            summe += businessResult[i];
        }
        System.out.println("Gesamtergebnis: " + summe);

        // Was ist das beste Monatsergebnis?
        int bestResult = businessResult[0];
        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] > bestResult) {
                bestResult = businessResult[i];
            }
        }
        System.out.println("Bestes Ergebnis: " + bestResult);

        // In welchem Monat war das beste Monatsergebnis?
        int tempBestResult = businessResult[0];
        int monthBestResult = 0;
        String bestMonth = "";
        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] > tempBestResult) {
                tempBestResult = businessResult[i];
                monthBestResult = i;
            }
        }
        bestMonth = indexToMonth(monthBestResult);
        System.out.println("Monat mit dem besten Ergebins: " + bestMonth);

        // Was ist das schwächste Monatsergebnis?
        int worstResult = 0;
        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] < worstResult) {
                worstResult = businessResult[i];
            }
        }
        System.out.println("Schlechtestes Ergebnis: " + worstResult);

        // In welchem Monat war das schwächste Monatsergebnis?
        int tempWorstResult = 0;
        int monthWorstResult = 0;
        String worstMonth = "";
        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] < tempWorstResult) {
                tempWorstResult = businessResult[i];
                monthWorstResult = i;
            }
        }
        worstMonth = indexToMonth(monthWorstResult);
        System.out.println("Monat mit dem besten Ergebins: " + worstMonth);

        // War zwei hintereinander kommende Monate mit negativen Ergebnis?
        boolean hasTwoNegMonthInRow = false;
        for (int i = 0; i < businessResultLen - 1; i++) {
            if ((businessResult[i] < 0) && (businessResult[i + 1] < 0)) {
                hasTwoNegMonthInRow = true;
                break;
            }
        }

        if (hasTwoNegMonthInRow) {
            System.out.println("Ja, es gibt zwei Monate mit neg. Eregebnis nacheinander");
        } else {
            System.out.println("Nope, es gibt keine zwei Monate mit neg. Eregebnis nacheinander");
        }

        // Was war das längste Intervall mit negativen Ergebnis?
        int counter = 0;
        int maxNeg = 0;

        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] < 0) {
                counter++;
                if (counter > maxNeg) {
                    maxNeg = counter;
                }
            } else {
                counter = 0;
            }
        }
        System.out.println("Größtes Intervall negativ: " + maxNeg);

        // Was war das zweitbeste Ergebnis?
        // höchste ist, falches ergebns
        int secondBestResult = worstResult;

        for (int i = 0; i < businessResultLen; i++) {
            if (businessResult[i] > secondBestResult && businessResult[i] < bestResult) {
                secondBestResult = businessResult[i];
            }
        }
        System.out.println("Zweitbestes Ergebnis: " + secondBestResult);
    }
}
