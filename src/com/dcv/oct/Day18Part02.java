package src.com.dcv.oct;

import java.util.Scanner;

public class Day18Part02 {

    private static Scanner sc = new Scanner(System.in);
    
    public static void atm() {
        /* Create a program that simulates an ATM. Implement the following functions
         * 1. Deposit
         * 2. Withdraw
         * 3. Account balance
         * 4. Exit
         */

        int balance = 0;
        boolean isActive = true;
        String[] mainMenu = {"\n\n--------------------------",
                            "What would you like to do?",
                            "0 - Exit",
                            "1 - Deposit",
                            "2 - Widthdraw",
                            "3 - Account balance"};

        while (isActive) {
            printMainMenu(mainMenu);

            int action = 0;
            try {
                String line = sc.nextLine();
                action = Integer.valueOf(line.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Not a valid number! Try again.");
                continue;
            }

            switch (action) {
                case 1:
                    balance += deposit();
                    break;
                case 2:
                    balance -= withdraw(balance);
                    break;
                case 3:
                    printAccountBalance(balance);
                    break;
                case 0:
                    isActive = false;;
                    break;
                default:
                    System.out.println("Invalid input! Try again");
                    break;
            }

        }
        sc.close();
    }


    /** Takes an array and prints every line
      * @param arr String array
      */
    public static void printMainMenu(String[] arr) {
        for (String line : arr) {
            System.out.println(line);
        }
    }

    /** Handles a deposit
      * @return Amount of deposit
      */
    public static int deposit() {
        int deposit = 0;
        System.out.println("Enter the amount you want to deposit");
        deposit = getUserInputInt("Not a valid deposit! Returned to main menu.");

        return deposit;
    }
    
    /** Handles a withdraw.
      * @param balance Current balance
      * @return Amount of withdraw
      */
    public static int withdraw(int balance) {
        int withdraw = 0;
        System.out.println("Enter the amount you want to withdraw");
        withdraw = getUserInputInt("Not a valid withdraw! Returned to main menu.");

        if (withdraw > balance) {
            System.out.println("Not enough money! Returned to main menu");
            withdraw = 0;
        }
        
        return withdraw;
    }

    /** Prints the balance to the console
      * @param balance
      */
    public static void printAccountBalance(int balance) {
        System.out.println("\n\nYour current balance is: " + balance);
    }

    /** Get user input and check if it is a integer. If not it prints a message
     * @param error Error message that gets printed in case of non integer input
     * @return The value of the integer
     */
    public static int getUserInputInt(String error) {
        int intInput = 0;
        try {
            String line = sc.nextLine();
            intInput = Integer.valueOf(line.trim());
        } catch (NumberFormatException nfe) {
            System.out.println(error);
        }
        return intInput;
    }
}
