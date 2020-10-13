package src.com.dcv.oct;


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
        System.out.println(meinSatz.split("\\.").length);
    }
}