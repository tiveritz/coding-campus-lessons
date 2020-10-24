package src.com.dcv.oct;

public class Day18Part01 {
    public static void functionRepetition() {
        
        // Function that prints Hello + name
        String name1 = "Lukas";
        String name2 = "Alex";
        
        printHelloWorld(name2);
        
        // Function that creates new String with Hello + Name
        String newName = createString(name1);
        System.out.println(newName);
        
        System.out.println(createString(name1)); // The same thing as above

        // Function that squares a number
        System.out.println(squared(3));
        System.out.println(squared(3) + 2);

        // Function that calles another function
        System.out.println(squaredMultiplication(2));
    }
    
    public static void printHelloWorld(String nameWithinFunction) {
        System.out.println("Hello " + nameWithinFunction);
    }

    public static String createString(String name) {
        // System.out.println("Function parameter \"name\": " + name);
        String newString = "Hi " + name;
        return newString;
    }

    public static int squared(int base) {
        return base * base;
    }

    public static int squaredMultiplication(int base) {
        return squared(base) * squared(base);
    }
}
