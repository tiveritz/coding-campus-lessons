package src.com.holiday.oct;

import java.util.Random;

public class Holiday03 {
    /* Write a program that encrypts a word with the help of a text
     * (https://de.wikipedia.org/wiki/Buch-Verschlüsselung)
     */

    /* Considerations
     * 1. Use a multidimensional array (convert the String)
     * 2. Randomly search for a slot (x.y) with the caracter
     *   - select a random row and loop to the end
     *      - select a random col and loop to the end
     *        - if no match in col try loop to the beginning
     *    - if no match in row loop to the beginning
     *    - nobody cares about capitalization. compare to lower letters
     *    - if no match use two random numbers
     * 3. Output result (for every letter in word)
     */

    private static final String BOOK = 
    /*             00000000011111111112222222222333333333344444444445555555555666666666677777777778888888888 */
    /*             12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789 */
    /* 1  */      "For instance, on the planet Earth, man had always assumed that he was more\n"
    /* 2  */    + "intelligent than dolphins because he had achieved so much—the wheel, New York,\n"
    /* 3  */    + "wars and so on—whilst all the dolphins had ever done was muck about in the water\n"
    /* 4  */    + "having a good time. But conversely, the dolphins had always believed that they\n"
    /* 5  */    + "were far more intelligent than man—for precisely the same reasons.\n"
    /* 6  */    + "\n"
    /* 7  */    + "Don't Panic.\n"
    /* 8  */    + "\n"
    /* 9  */    + "Time is an illusion. Lunchtime doubly so.\n"
    /* 10 */    + "\n"
    /* 11 */    + "Space is big. You just won't believe how vastly, hugely, mind-bogglingly big it is. I\n"
    /* 12 */    + "mean, you may think it's a long way down the road to the chemist's, but that's just\n"
    /* 13 */    + "peanuts to space.\n"
    /* 14 */    + "For a moment, nothing happened. Then, after a second or so, nothing continued to happen.\n"
    /* 15 */    + "A towel, [The Hitchhiker's Guide to the Galaxy] says, is about the most massively\n"
    /* 16 */    + "\n"
    /* 17 */    + "useful thing an interstellar hitchhiker can have. Partly it has great practical value.\n"
    /* 18 */    + "You can wrap it around you for warmth as you bound across the cold moons of\n"
    /* 19 */    + "Jaglan Beta; you can lie on it on the brilliant marble-sanded beaches of\n"
    /* 20 */    + "Santraginus V, inhaling the heady sea vapors; you can sleep under it beneath the\n"
    /* 21 */    + "stars which shine so redly on the desert world of Kakrafoon; use it to sail a miniraft\n"
    /* 22 */    + "down the slow heavy River Moth; wet it for use in hand-to-hand-combat; wrap it\n"
    /* 23 */    + "round your head to ward off noxious fumes or avoid the gaze of the Ravenous\n"
    /* 24 */    + "Bugblatter Beast of Traal (such a mind-boggingly stupid animal, itassumes that if\n"
    /* 25 */    + "you can't see it, it can't see you); you can wave your towel in emergencies as a\n"
    /* 26 */    + "distress signal, and of course dry yourself off with it if it still seems to be clean\n"
    /* 27 */    + "enough.\n";

    private static Random rand = new Random();

    public static void bookCipher() {
        String word = "Java";
        String[][] wordArr = stringToArray(BOOK);

        for (String letter : word.split("")) {
            System.out.print(getCoordinates(wordArr, letter) + " ");
        }
    }
    
    public static String[][] stringToArray(String string) {
        String[] wordArr = string.split("\n");
        String text[][] = new String[wordArr.length][];

        for (int row = 0; row < wordArr.length; row++) {
            text[row] = wordArr[row].split("");
        }

        return text;
    }

    public static int getColCoordinate(String[] row, String string) {
        int colCoor = Integer.MIN_VALUE;
        int start = rand.nextInt(row.length);

        for (int col = start; col < row.length; col++) {
            if (row[col].equals(string.toLowerCase())) {
                colCoor = col;
                break;
            }
        }

        if (colCoor == Integer.MIN_VALUE) {
            for (int col = start-1; col == 0; col--) {
                if (row[col].equals(string.toLowerCase())) {
                    colCoor = col;
                    break;
                }
            }
        }
        return colCoor;
    }

    public static String getCoordinates(String[][] wordArr, String string) {
        int rowCoor = Integer.MIN_VALUE;
        int colCoor = Integer.MIN_VALUE;
        int start = rand.nextInt(wordArr.length);

        for (int row = start; row < wordArr.length; row++) {
            colCoor = getColCoordinate(wordArr[row], string);
            if (colCoor != Integer.MIN_VALUE) {
                rowCoor = row;
                break;
            }
        }

        if (rowCoor == Integer.MIN_VALUE) {
            for (int row = start-1; row == 0; row--) {
                colCoor = getColCoordinate(wordArr[row], string);
                if (colCoor != Integer.MIN_VALUE) {
                    rowCoor = row;
                    break;
                }
            }
        }
        // Check whether or not a slot was found. If not, use any Random number
        // to keep the strengths of the cipher - avoid any reproducable patterns
        if (rowCoor == Integer.MIN_VALUE) {
            rowCoor = rand.nextInt(50);
        }
        if (colCoor == Integer.MIN_VALUE) {
            colCoor = rand.nextInt(50);
        }
        
        // Convert the Coordinates from code index to user index
        rowCoor++; colCoor++;
        return "(" + rowCoor+ "." + colCoor + ")";
    }
}
