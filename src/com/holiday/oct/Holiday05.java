package src.com.holiday.oct;

public class Holiday05 {

    public static final int CONSTANT = -2147483648;

    public static void helloWorldClassesAndMethods() {
        // Integer is a Class - MIN_VALUE is a constant in the Integer class
        int integer = Integer.MIN_VALUE;
        System.out.println(integer);

        // Holiday05 is a Class - CONSTANT is a constant in the Holiday05 class
        int ownClassConstant = Holiday05.CONSTANT;
        System.out.println(ownClassConstant);

        // Integer is a Class - toString is a class method
        String string = Integer.toString(5);
        System.out.println("Is a string: " + string);

        // Holiday05 is a Class - giveMeFive is a class method
        int five = Holiday05.giveMeFive();
        System.out.println(five);

        // Of course you can call methods from any of your own classes
        Holiday04.cipherWithString();
        System.out.println(Holiday04.TEXT);

        // Note: if you want to access variables, constants or methods of other
        // classes, you have to declare them public
    }

    public static int giveMeFive() {
        return 5;
    }
    
}
