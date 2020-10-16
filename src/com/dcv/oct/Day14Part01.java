package src.com.dcv.oct;

import java.util.Arrays;

public class Day14Part01 {
    private final static String text = "Zur Zeit des Zweiten Weltkriegs waren seine großen Werke Siddhartha und Der Steppenwolf noch verboten. Heute gehört Hermann Hesse zu den bekanntesten deutschen Schriftstellern. Mehr über den Weltveränderer lest ihr hier\n"
            + "Hermann Hesse\n" + "\n" + "Hermann Hesse erhielt den Nobelpreis für Literatur\n"
            + "Hermann Hesse: Kurz-Steckbrief\n" + "\n" + "    Vollständiger Name: Hermann Karl Hesse\n"
            + "    Lebensdaten: 2. Juli 1877 bis 9. August 1962\n" + "    Nationalität: deutsch, später schweizerisch\n"
            + "    Zitat: \"Wenn wir einen Menschen glücklicher und heiterer machen können, so sollten wir es auf jeden Fall tun, mag er uns darum bitten oder nicht.\"\n"
            + "\n"
            + "Als Schriftsteller, Dichter und Maler prägte Hermann Hesse die Literatur und Kunst des 19. Jahrhunderts.\n"
            + "Wie Hermann Hesse lebte\n" + "\n"
            + "Hermann Hesse wurde am 2. Juli 1877 in Calw, einer Stadt in Württemberg geboren. Seine Familie war sehr religiös, der Vater Johannes sogar Missionar, also so genannter \"Gesandter\", der seinen Glauben weiterverbreiten wollte.\n"
            + "\n"
            + "So sollten auch die Kinder in die Fußstapfen der religiösen Eltern treten. Hesse war davon aber gar nicht begeistert und soll einmal gesagt haben, dass er \"entweder Dichter oder gar nichts werden\" wolle.\n"
            + "\n"
            + "1893 verließ der junge Hesse das Gymnasium mit dem Abschluss der Mittleren Reife. Danach schloss er zwei Lehren ab: eine als Turmuhrenmechaniker und eine als Buchhändler.\n"
            + "\n"
            + "Gegen den Willen seiner Eltern ließ er sich in der Schweizer Stadt Basel nieder, um seinem Traum vom Dichter-Dasein näher zu kommen. 1899 veröffentlichte er seine erste Lyriksammlung. In dieser Zeit heiratete er auch seine erste Frau Maria Bernoulli, von der er sich aber 15 Jahre später wieder trennte. Aus der Ehe gingen drei Söhne hervor.\n"
            + "\n"
            + "Zwölf Jahre lang ist Adolf Hitler Deutschlands Reichskanzler. Viele Menschen sind damals von ihm begeistert, doch es wird eine Schreckensherrschaft. Wir haben die Geschichte des Nationalsozialismus auf dieser Themenseite für euch zusammengefasst\n"
            + "\n" + "\n" + "Wie Hermann Hesse die Welt veränderte\n" + "\n"
            + "Um das Jahr 1904 gelang ihm der Durchbruch. Der Roman \"Peter Camenzind\" stimmt an vielen Stellen mit Hesses Leben überein. Literatur-Experten handeln das Werk als \"Beginn des modernen Bildungsromans\". Auf den ersten großen Erfolg folgten weitere beeindruckende Erzählungen und Romane.\n"
            + "\n"
            + "1914, als der erste Weltkrieg begann, meldete sich der Schriftsteller zum Militärdienst für das Deutsche Reich. Aufgrund seiner Kurzsichtigkeit wurde er aber ausgemustert und der deutschen Kriegsgefangenenfürsorge zugeteilt. Seine Aufgabe war es, für die Gefangenen Bücher zu sammeln. Außerdem leitete er die \"Bücherei für deutsche Kriegsgefangene\".\n"
            + "\n"
            + "Diese Erfahrungen prägten Hesse sehr. In vielen seiner folgenden Texte sprach er sich deutlich gegen Krieg und Patriotismus (\"Vaterlandsliebe\") aus. Zusätzlich belasteten ihn familiäre Schicksalsschläge: 1916 starb sein Vater, sein Sohn litt an einer schweren Erkrankung und seine Ehe mit Bernoulli ging in die Brüche. Das ging Hesse so nahe, dass er eine Therapie machte. In dieser Phase seines Lebens widmete er sich auch erstmals der Malerei.\n"
            + "\n"
            + "Innerhalb kurzer Zeit heiratete er daraufhin zweimal: 1924 Ruth Wenger, die Tochter einer bekannten Schriftstellerin, 1931 die Kunsthistorikerin Ninon Dolbin. Gleichzeitig begann der Zweite Weltkrieg. Die Nationalsozialisten erklärten seine Werke als volksfeindlich und verbaten beispielsweise \"Unterm Rad\", \"Der Steppenwolf\" und \"Betrachtungen\". Hesses Verleger Peter Suhrkamp wurde 1944 sogar verhaftet.\n"
            + "\n"
            + "Hermann Hesse ließ sich den Mund aber nicht verbieten: Weiterhin schrieb er Regime-kritische Texte, also Texte, die die nationalsozialistische Herrschaft unter Adolf Hitler angriffen. Nach dem Zweiten Weltkrieg wurden diese dann auch veröffentlicht.\n"
            + "\n"
            + "Er hasste den Krieg. In seinem Testament widmete der Physiker und Chemiker Alfred Nobel sein Vermögen unter anderem der Vergabe des jährlichen Friedenspreises\n"
            + "Hermann Hesses Tod in der Schweiz\n" + "\n"
            + "1946 zog sich Hesse zurück, da sein Gesundheitszustand immer schlechter wurde. \"Das Glasperlenspiel\" und \"Krieg und Frieden\" waren Anlass dafür, dass er am 14. November desselben Jahres mit dem Nobelpreis für Literatur ausgezeichnet wurde. Für sein Lebenswerk wurde er ein Jahr später zum Ehrendoktor sowie Ehrenbürger von Calw, seiner Geburtsstadt, ernannt. 1955 folgte der Friedenspreis des Deutschen Buchhandels.\n"
            + "\n"
            + "Am 9. August 1962 starb Hermann Hesse an einem Gehirnschlag in seinem Haus in der Schweiz. Heute gehört Hermann Hesse zu denbekanntesten deutschsprachigenr Schriftstellern. Seine Werke wurden in 55 Sprachen übersetzt.\n"
            + "Zitate von Hermann Hesse\n" + "\n"
            + "\"Man muß das Unmögliche versuchen, um das Mögliche zu erreichen.\"\n" + "Hermann Hesse\n" + " \n" + "\n"
            + "\"Man braucht vor niemand Angst zu haben. Wenn man jemanden fürchtet, dann kommt es daher, daß man diesem Jemand Macht über sich eingeräumt hat.\"\n"
            + "Hermann Hesse, Demian\n" + " \n" + "\n"
            + "\"Man hat nur Angst, wenn man mit sich selber nicht einig ist.\"\n" + "Hermann Hesse, Demian\n" + " \n"
            + "\n"
            + "\"Recht als wolle es ihn mit der Nase darauf stoßen, hatte sein Glück ihm diese prächtige Figur in seinen Weg gestellt, daß er sich an sie halte. Aber der Mensch ist zu nichts schwerer zu bringen als zu seinem Glück.\"\n"
            + "Hermann Hesse, Der Weltverbesserer\n" + " \n" + "\n"
            + "\"Wenn wir einen Menschen glücklicher und heiterer machen können, so sollten wir es in jedem Fall tun, mag er uns darum bitten oder nicht.\"\n"
            + "Hermann Hesse, Das Glasperlenspiel\n" + " \n" + "\n"
            + "\"Die Welt zu durchschauen, sie zu verachten, mag großer Denker Sache sein. Mir aber liegt einzig daran, die Welt lieben zu können, sie und mich und alle Wesen mit Liebe und Bewunderung und Ehrfurcht betrachten zu können.\"\n"
            + "Hermann Hesse";

    public static void betterTextAnalysis() {
        /*
         * Target of this lesson is to train various String operations and to
         * write the code functions into their own methods (creation, call,
         * return, passing parameters
         */

        // #1 Count characters
        System.out.println("Amount of characters: " + allCharCount(text));

        // #2 Count "real" (spoken) characters
        System.out.println("Amount of real characters: " + realCharCount(text));

        // #3 Count words
        String cleanText = cleanText(text);
        String[] words = cleanText.split(" ");
        System.out.println("Amount of words: " + words.length);

        // 4# Shortest / longest word
        System.out.println("Shortest word: " + getShortestWord(words));
        System.out.println("Longest word: " + getLongestWord(words));

        // #5 Count appearance of "Hesse"
        System.out.println("Occurence word \"Hesse\": " + occurencesInArray(words, "Hesse"));

        // #6 Count words written lowercase and UPPERCASE
        System.out.println("Words in lowercase: " + countAllLowerCase(words));
        System.out.println("Words in UPPERCASE: " + countAllUpperCase(words));

        // #7 Print alphabetically first and last word
        System.out.println("Alphabetically first word: " + getAlphabeticallyFirstWord(words));
        System.out.println("Alphabetically last word: " + getAlphabeticallyLastWord(words));

        // #8 Sort words by length destending and within the length
        // alphabetically ascending. Implement with own sorting algorithm
        String[] wordsDoubleSorted = doubleSort(words);
        System.out.println(Arrays.toString(wordsDoubleSorted));
    }

    /** Returns an int with the length of the passed String */
    public static int allCharCount(String text) {
        return (text.length());
    }

    /** Returns an int with the number off "real" characters */
    public static int realCharCount(String text) {
        int spokenChar = 0;

        for (int i = 0; i < text.length(); i++) {
            if (isAlphanumeric(text.charAt(i))) {
                spokenChar++;
            }
        }
        return spokenChar;
    }

    /** Returns a boolean which indicates whether the passed char is a alphanumeric character */
    public static boolean isAlphanumeric(char letter) {
        return Character.toString(letter).matches("[a-zA-ZäöüÄÖÜß]");
    }

    /** Returns a String with all valid words separated by spaces */
    public static String cleanText(String text) {
        return text.replaceAll("[^a-zA-ZßäÄöÖüÜ]", " ") /* ^ im regex negiert die Ausdrücke */
                .replaceAll("[ ]+", " "); /* doppelte Leerzeichen entfernen   */
    }

    /** Returns any of the shortest Word from the passed String array */
    public static String getShortestWord(String[] words) {
        String shortestWord = "";
        int shortestWordLen = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];

            if (currWord.length() < shortestWordLen) {
                shortestWordLen = currWord.length();
                shortestWord = currWord;
            }
        }
        return shortestWord;
    }

    /** Returns any of the longest Word from the passed String array */
    public static String getLongestWord(String[] words) {
        String longestWord = "";
        int longestWordLen = 0;

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];

            if (currWord.length() > longestWordLen) {
                longestWordLen = currWord.length();
                longestWord = currWord;
            }
        }
        return longestWord;
    }

    /** Returns an int with the number of occurences of the passed String in the
      * passed Array
      */
    public static int occurencesInArray(String[] arr, String string) {
        int amountWord = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(string)) {
                amountWord++;
            }
        }
        return amountWord;
    }

    /** Returns an int with the number of occurences of all upper case words in 
      * the passed String array 
      */
    public static int countAllUpperCase(String[] arr) {
        int amountWordUpper = 0;

        for (int i = 0; i < arr.length; i++) {
            char[] characters = arr[i].toCharArray();
            boolean isUpper = true;

            for (char character : characters) {
                if (Character.isLowerCase(character)) {
                    isUpper = false;
                }
            }

            if (isUpper) {
                amountWordUpper++;
            }
        }
        return amountWordUpper;
    }

    /** Returns an int with the number of occurences of all lower case words in 
      * the passed String array 
      */
    public static int countAllLowerCase(String[] arr) {
        int amountWordLower = 0;

        for (int i = 0; i < arr.length; i++) {
            char[] characters = arr[i].toCharArray();
            boolean isLower = true;

            for (char c : characters) {
                if (Character.isUpperCase(c)) {
                    isLower = false;
                }
            }

            if (isLower) {
                amountWordLower++;
            }
        }
        return amountWordLower;
    }

    /** Returns the alphabetically first word of the passed String array */
    public static String getAlphabeticallyFirstWord(String[] arr) {
        String firstWord = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(firstWord) < 0) {
                firstWord = arr[i];
            }
        }
        return firstWord;
    }

    /** Returns the alphabetically last word of the passed String array */
    public static String getAlphabeticallyLastWord(String[] arr) {
        String lastWord = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            String left = normalizeWord(arr[i]);
            String right = normalizeWord(lastWord);
            if (left.compareTo(right) > 0) {
                lastWord = arr[i];
            }
        }
        return lastWord;
    }

    /** Returns the version of the passed words with Umlauts and ß replaced */
    public static String normalizeWord(String word) {
        String normalized = word
                            .replace("ä", "ue")
                            .replace("Ä", "ue")
                            .replace("ö", "oe")
                            .replace("Ö", "Oe")
                            .replace("ü", "ue")
                            .replace("Ü", "Ue")
                            .replace("ß", "ss");
        return normalized;
    }

    /** Returns the sorted version of the passed array
      * Sorting conditions:
      * Primary length descending and secondary alphabeticall ascending
      */
    public static String[] doubleSort(String[] origArr) {
        String[] arr = Arrays.copyOf(origArr, origArr.length);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                String normalizedWordLeft = normalizeWord(arr[j]);
                String normalizedWordRight = normalizeWord(arr[j + 1]);
                int wordLeftLength = arr[j].length();
                int wordRightLength = arr[j + 1].length();

                if ((wordLeftLength < wordRightLength)
                            || (wordLeftLength == wordRightLength
                            && normalizedWordLeft.compareTo(normalizedWordRight) > 0)) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
