public class Day06 {
    public static void HelloWorldRecursion(int n) {
        // Recherchiere Recursion in Java

        if (n == 0) {
            System.out.println("End of Recursion");
        } else {
            System.out.println("Recursion number " + n);
            n--;
            HelloWorldRecursion(n); // This is where the magic happens
        }

    }
}