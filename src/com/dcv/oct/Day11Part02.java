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
        // toLowerCase()
        // toUpperCase()
        // startsWith()
        // endsWith()
        // 

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
        
        System.out.printf("%5d%n", 100);
        System.out.printf("%05d%n", 100);
    }
}
