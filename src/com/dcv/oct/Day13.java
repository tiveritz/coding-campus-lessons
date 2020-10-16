package src.com.dcv.oct;

import java.util.Arrays;

public class Day13 {
    public static void stringRepetition() {
        // ---------------------------------------------------------------------
        // Repetition with hands sentence
        // #1 Count character '.'
        String mySentence= "Das ist ein Satz. Einmal mehr sage ich eines zu euch. Ein Mensch hat Hände.";

        var characters = mySentence.toCharArray();
        int charCount = 0;

        for (var character : characters) {
            if (character == '.') {
                charCount++;
            }
        }
 
        System.out.println("Amount of \".\": " + charCount);

        // #2 Count occurence of "Hand"
        String sentenceFullOfHands = "Das ist eine Hand. Mit der Hand kann ich winken. " +
                                     "Freundlichen Menschen gebe ich gerne die Hand. " +
                                     "Im Winter trage ich Handschuhe." +
                                     "Gibst du mir deine Hand?";
        int counter = 0;

        var normalizedSentence = sentenceFullOfHands.replaceAll("[\\.?]", " ").toLowerCase();
        var words = normalizedSentence.split(" ");

        for (var word : words) {
            if (word.equals("hand")) {
                counter++;
            }
        }

        System.out.println("Number of \"hand\": " + counter);

        
        // ---------------------------------------------------------------------
        // Repetition 1 with another sentence

        // #1 Clean and structure sentence
        String sentenceWinter = "ImWinter;trage_ich Handschuhe.";
        String sentenceWinterNormalized = sentenceWinter
                                        .replaceAll("[.;_]", " ")
                                        .replaceAll("(?<=[a-z])(?=[A-Z])", " ");
                                        
        System.out.println("Clean sentence: " + sentenceWinterNormalized);
        
        // #2 Detect words
        String[] normalizedSentenceWinter = sentenceWinterNormalized.split(" ");
        System.out.println(Arrays.toString(normalizedSentenceWinter));

        // #3 Count words
        System.out.println("Amount of words: " + normalizedSentenceWinter.length);
    }
}
