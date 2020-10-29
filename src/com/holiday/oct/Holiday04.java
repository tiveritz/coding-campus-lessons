package src.com.holiday.oct;

import java.util.Arrays;

public class Holiday04 {

public static final String TEXT = 
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


    public static void cipherWithString() {
        String word = "Java is awesome";
        word = word.toLowerCase();
        int[] cipher = new int[word.length()];

        int currIndex = 0;
        int cipherNum = 0;
        
        // Encrypt
        for (int i = 0; i < word.length(); i++) {
            int index = TEXT.indexOf(word.charAt(i), currIndex);
            cipherNum = index - currIndex;
            currIndex = index;
            cipher[i] = cipherNum;
        }

        System.out.println(Arrays.toString(cipher));

        // Decrypt
        int decryptIndex = 0;

        for (int i = 0; i < cipher.length; i++) {
            decryptIndex += cipher[i];
            char character = TEXT.charAt(decryptIndex);
            System.out.print(character);
        }

    }
}