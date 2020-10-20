package src.com.dcv.oct;

import java.util.Random;

public class Day15 {
    public static void randomArrayPrint() {
        String[] shortcut = {"lol", "hdl", "mfg", "rofl", "asdf"};
        String[] emoji = {":-)", "<3", ":|", ":P"};

        System.out.println("Random: " + getRandomElement(shortcut) + " " + getRandomElement(emoji) );
        System.out.println("Random: " + getRandomElement(shortcut) + " " + getRandomElement(emoji) );
        System.out.println("Random: " + getRandomElement(shortcut) + " " + getRandomElement(emoji) );
    }

    public static String getRandomElement(String [] arr) {
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }

}
