package src.com.dcv.oct;

import java.util.Arrays;

public class Day13Part01 {
    public static void stringRepetition() {
        // Wie oft kommt das Satzzeichen '.' vor?
        String meinSatz= "Das ist ein Satz. Einmal mehr sage ich eines zu euch. Ein Mensch hat Hände.";

        var characters = meinSatz.toCharArray();
        int charCount = 0;

        for (var character : characters) {
            if (character == '.') {
                charCount++;
            }
        }
 
        System.out.println(charCount);

        // oder:
        // funktioniert nicht 100% (was ist, wenn nach dem letzten punkt noch etwas ist)
        System.out.println(meinSatz.split("\\.").length);

        //Wie oft kommt das Wort 'Hand' vor?

        String sentenceFullOfHands= "Das ist eine Hand. Mit der Hand kann ich winken. " +
                "Freundlichen Menschen gebe ich gerne die Hand. " +
                "Im Winter trage ich Handschuhe." +
                "Gibst du mir deine Hand?";
        int counter = 0;

        var sentenceNormalized = sentenceFullOfHands.replaceAll("[\\.?]", " ").toLowerCase();
        var words = sentenceNormalized.split(" ");

        for (var word : words) {
            if (word.equals("hand")) {
                counter++;
            }
        }

        System.out.println(counter);

        // Satz: ImWinter;trage_ich Handschuhe. 
        // Wie viele Worte enthält die Zeichenfolge (Wort im Sinne durch Leerzeichen getrennt). 
        // Tipps: Worte lassen sich erkennen, wenn 
        // - sie von Leerzeichen umgeben sind 
        // - mit einem Großbuchstaben anfangen 
        // 1.) Satz sauber strukturieren (Leerzeichen an der richtigen Stelle einfügen, falsche Zeichen ersetzen) 
        // 2.) Worte ermitteln 
        // 3.) Worte zählen

        String sentence02 = "ImWinter;trage_ich Handschuhe.";
        String sentence02Normalized = sentence02.replace(';', ' ')
                                            .replace('_', ' ')
                                            .replace('.', ' ')
                                            .replaceAll("(?<=[a-z])(?=[A-Z])", " ");
        String[] words02 = sentence02Normalized.split(" ");

        System.out.println("Clean sentence: " + sentence02Normalized);
        System.out.println(Arrays.toString(words02));
        System.out.println("Amount of words: " + words02.length);
    }
}