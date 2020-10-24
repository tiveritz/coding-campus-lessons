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
                    System.out.println("Unvalid input! Try again");
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

    /** Asks the user for the amount to deposit. Checks if it is a valid number.
      * @return Amount of deposit
      */
    public static int deposit() {
        int deposit = 0;
        System.out.println("Enter the amount you want to deposit");
        try {
            String line = sc.nextLine();
            deposit = Integer.valueOf(line.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid number! Returned to main menu.");
        }
        return deposit;
    }
    
    /** Asks the user for the amount to withdraw. Checks if a valid number and
      * if there is enough balance on the account.
      * @param balance Current balance
      * @return Amount of withdraw
      */
    public static int withdraw(int balance) {
        int withdraw = 0;
        System.out.println("Enter the amount you want to withdraw");
        try {
            String line = sc.nextLine();
            withdraw = Integer.valueOf(line.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid number! Returned to main menu.");
        }

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
}
