package src.com.dcv.oct;

public class Day11Part02 {
    public static void helloWorldString() {
        String helloWorld = "Hello World";

        // useful methods:
        // charAt()
        // compareTo()
        // equals()
        // concat()
        // contains()
        // startsWith()
        // endsWith()
        // toLowerCase()
        // toUpperCase()
        // indexOf()
        // lastIndexOf()
        // isBlank()
        // isEmpty()
        // length()
        // replaceAll()
        // matches()

        // split()


        System.out.println("helloWorld.charAt(1): " + helloWorld.charAt(1));

        System.out.println("helloWorld.compareTo(\"Apfelsaft\"): " + helloWorld.compareTo("Apfelsaft"));
        System.out.println("helloWorld.compareTo(\"Zugführer\"): " + helloWorld.compareTo("Zugführer"));
        System.out.println("helloWorld.compareTo(\"Hello World\"): " + helloWorld.compareTo("Hello World"));
        
        System.out.println("helloWorld.compareTo(\"HELLO WORLD\"): " + helloWorld.compareTo("HELLO WORLD"));
        System.out.println("helloWorld.compareToIgnoreCase(\"HELLO WORLD\"): " + helloWorld.compareToIgnoreCase("HELLO WORLD"));
        
        System.out.println("helloWorld.equals(\"HELLO WORLD\"): " + helloWorld.equals("HELLO WORLD"));
        System.out.println("helloWorld.equals(\"Hello World\"): " + helloWorld.equals("Hello World"));
        
        System.out.println("helloWorld.concat(\"!!!!\"): " + helloWorld.concat("!!!!"));
        
        System.out.println("helloWorld.contains(\"Apfelsaft\"): " + helloWorld.contains("Apfelsaft"));
        System.out.println("helloWorld.contains(\"Worl\"): " + helloWorld.contains("Worl"));
        
        System.out.println("helloWorld.startsWith(\"Hell\"): " + helloWorld.startsWith("Hell"));
        System.out.println("helloWorld.startsWith(\"ld\"): " + helloWorld.startsWith("ld"));
        
        System.out.println("helloWorld.endsWith(\"Hell\"): " + helloWorld.endsWith("Hell"));
        System.out.println("helloWorld.endsWith(\"ld\"): " + helloWorld.endsWith("ld"));
        
        System.out.println("helloWorld.toLowerCase(\"Worl\"): " + helloWorld.toLowerCase());
        System.out.println("helloWorld.toUpperCase(\"Worl\"): " + helloWorld.toUpperCase());
        
        // System.out.printf("%5d%n", 100);
        // System.out.printf("%05d%n", 100);

        String myFormattedString = String.format("%5d%n", 100);
        System.out.print(myFormattedString);
        
        System.out.println("helloWorld.indexOf(\"e\"): " + helloWorld.indexOf("e"));
        System.out.println("helloWorld.indexOf(\"o\"): " + helloWorld.indexOf("o"));
        System.out.println("helloWorld.indexOf(\"o\", 6): " + helloWorld.indexOf("o", 6));
        
        System.out.println("helloWorld.lastIndexOf(\"o\"): " + helloWorld.lastIndexOf("o"));
        
        String blanks = "                  ";
        System.out.println("\"" + blanks + "\".isBlank(): " + blanks.isBlank());
        System.out.println("\"" + blanks + "\".isEmpty(): " + blanks.isEmpty());
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
        
        System.out.println("helloWorld.length(): " + helloWorld.length());

        System.out.println("helloWorld.repeat(3): " + helloWorld.repeat(3));

        System.out.println(helloWorld.replaceAll("Hello", "Good night"));
        System.out.println(helloWorld.replaceAll(" World", ""));
        
        String textForReplace = "The resulting     pattern can then be used to create";
        System.out.println(textForReplace);
        System.out.println(textForReplace.replaceAll(" ", "-"));
        System.out.println(textForReplace.replaceAll("[ ]+", " "));
        System.out.println(textForReplace.replaceAll("[AEIOUaeiou]", "#"));
        System.out.println(textForReplace.replaceAll("[a-z]", "#"));
        
        String deutscheSprache = "ÄÖÜäöüß";
        System.out.println(deutscheSprache + " -> " + deutscheSprache
                .replaceAll("[Ä]", "Ae")
                .replaceAll("[Ö]", "Oe")
                .replaceAll("[Ü]", "Ue")
                .replaceAll("[ä]", "ae")
                .replaceAll("[ö]", "oe")
                .replaceAll("[ü]", "ue")
                .replaceAll("[ß]", "ss"));
        
        String testPLZ1 = "1234";
        String testPLZ2 = "234";
        String testPLZ3 = "11234";
        String testPLZ4 = "1aaa";

        System.out.println(testPLZ1 + " is a valid postal code? " + testPLZ1.matches("[1-9][0-9]{3}"));
        System.out.println(testPLZ2 + " is a valid postal code? " + testPLZ2.matches("[1-9][0-9]{3}"));
        System.out.println(testPLZ3 + " is a valid postal code? " + testPLZ3.matches("[1-9][0-9]{3}"));
        System.out.println(testPLZ4 + " is a valid postal code? " + testPLZ4.matches("[1-9][0-9]{3}"));
    
        String[] words = helloWorld.split(" ");
        System.out.println("Split auf Words:");
        for (String oneWord : words) {
            System.out.println(oneWord);
        }
    }

    public static void checkIBAN() {
        String testIBAN1 = "AT12 1234 1234 1234 1234";
        String testIBAN2 = "AT62 6541 6985 555 0001";
        String testIBAN3 = "DE55 2258 2258 2258 2211";
        String testIBAN4 = "DE112 2254 2251 2251 222";

        String pattern = "[A-Z]{2}[0-9]{2}(?: [0-9]{4}){4}";

        System.out.println(testIBAN1 + " is a valid postal code? " + testIBAN1.matches(pattern));
        System.out.println(testIBAN2 + " is a valid postal code? " + testIBAN2.matches(pattern));
        System.out.println(testIBAN3 + " is a valid postal code? " + testIBAN3.matches(pattern));
        System.out.println(testIBAN4 + " is a valid postal code? " + testIBAN4.matches(pattern));
        
    }
}
