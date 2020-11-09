package src.com.dcv.nov;

import java.util.Arrays;
import java.util.Scanner;

public class Day19Part02 {
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

    /** Fills the array with one whitespace char
      * @param arr The array to be filled
      */
    public static void fillArrWithEmpty(char[][] arr) {
        for (char[] inner : arr) {
            Arrays.fill(inner, ' ');            
        }
    }

    /** Prints the two dimensional array Tic Tac To - like
      * @param arr
      */
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

    /** Takes user input and writes it into the passed array. The title is a
      * reference to the movie with the same name :-)
      * @param arr The array the mark is written to
      * @param mark The mark which is written to the array
      */
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
                coordinates[i] = intInput - 1;
            }
            
            if (coordinates[0] < 0 || 
                coordinates[0] > 2 || 
                coordinates[1] < 0 ||
                coordinates[1] > 2) {
                System.out.println("This is not inside the game (row 1 - 3, col 1 - 3). Try again");
                continue;
            }

            if (arr[coordinates[0]][coordinates[1]] != ' ') {
                System.out.println("Already taken. Try again.");
                continue;
            } else {
                arr[coordinates[0]][coordinates[1]] = mark;
                isValidInput = true;
            }
        }
    }

    /** Checks if the array is full
      * @param arr The array to be checked
      * @return A boolean true if the array is full
      */
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

    /** Checks if a player has wone (any direction)
      * 
      * @param arr The array to be checked
      * @param player The player the win is checked for
      * @return True if the player has won
      */
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

        // Diagonal check
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player ||
            arr[2][0] == player && arr[1][1] == player && arr[0][2] == player
        ) {
            won = true;
        }
        return won;
    }
}
