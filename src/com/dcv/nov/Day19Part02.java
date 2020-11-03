package src.com.dcv.nov;

import java.util.Arrays;
import java.util.Scanner;

public class Day19Part02 {

    /* INFORMATION 
     * It may seem a bit strange here, but I tried to use a method that returns
     * an array with the input coordinates. This is the way you can return
     * multiple values in Java
     */

    private static Scanner sc = new Scanner(System.in);

    public static void ticTacToe() {
        char[][] ticTacToe = new char[3][3];
        fillArrWithEmpty(ticTacToe);
        char playerOne = 'X';
        char playerTwo = 'O';

        printArray(ticTacToe);
        
        int round = 0;
        while (true) {

            if (round % 2 == 0) {
                System.out.println("Player One ("+ playerOne + ")");
                readyPlayerOne(ticTacToe, playerOne);
            } else {
                System.out.println("Player Two ("+ playerTwo + ")");
                readyPlayerOne(ticTacToe, playerTwo);
            }
            
            round++;
            printArray(ticTacToe);

            if (checkWin(ticTacToe, playerOne)) {
                System.out.println("Player " + playerOne + " won");
                break;
            } else if (checkWin(ticTacToe, playerTwo)) {
                System.out.println("Player " + playerTwo + " won");
                break;
            }

            if (checkFull(ticTacToe)) {
                System.out.println("All slots full, nobody won");
                break;
            }
        }
    }

    public static void fillArrWithEmpty(char[][] arr) {
        for (char[] inner : arr) {
            Arrays.fill(inner, ' ');            
        }
    }

    public static void printArray(char[][] arr) {
        System.out.println("-------------");
        for (int row = 0; row < arr.length; row++) {
            System.out.print("|");
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(" " + arr[row][col] + " |");
            }
            System.out.println("\n-------------");
        }
    }

    public static void readyPlayerOne(char[][] arr, char mark) {
        int[] coordinates = new int[2];
        boolean isValidInput = false;

        while (!isValidInput) {
            for (int i = 0; i < 2; i++) {
                int intInput = 0;
                
                if (i == 0) {
                    System.out.println("Enter row: ");
                } else {
                    System.out.println("Enter col: ");
                }

                try {
                    String line = sc.nextLine();
                    intInput = Integer.valueOf(line.trim());
                } catch (NumberFormatException nfe) {
                    System.out.println("Not a valid input. Try again.");
                    continue;
                }
                coordinates[i] = intInput + 1;
            }

            // also catch IndexOutOfBounds errors!
            if (arr[coordinates[0]][coordinates[1]] != ' ') {
                System.out.println("Already taken. Try again.");
            } else {
                arr[coordinates[0]][coordinates[1]] = mark;
                isValidInput = true;
            }
        }
    }

    public static boolean checkFull(char[][] arr) {
        boolean full = true;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == ' ') {
                    full = false;
                    break;
                }
            }
        }
    return full;
    }

    public static boolean checkWin(char[][] arr, char player) {
        boolean won = false;

        // Horizontal check
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][0] == player && arr[row][1] == player && arr[row][2] == player) {
                won = true;
            }
        }

        // Vertical check
        for (int col = 0; col < arr[0].length; col++) {
            if (arr[0][col] == player && arr[1][col] == player && arr[2][col] == player) {
                won = true;
            }
        }

        // Horizontal check
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player ||
            arr[2][0] == player && arr[1][1] == player && arr[0][2] == player
        ) {
            won = true;
        }
        return won;
    }
}
