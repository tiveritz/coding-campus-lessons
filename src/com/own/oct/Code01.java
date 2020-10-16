package src.com.own.oct;

import java.util.Random;
import java.util.Scanner;

public class Code01 {
    /* Write a funny console application to visualize the Monty Hall Problem
     * There are three closed doors behind of which are two goats and one car
     * Goal is to win the car.
Co     * After you have picked your first door the game show moderator unveils one of
     * the other remaining doors with a goat. Then he asks you whether you want to
     * change your current door or stay with your decision.
     * Which decision do you think has the highest probability to win a car?
     *
     * Idea from the Movie 21, ASCII art from asciiart.eu (car) and ascii.13375.de (goat)
     */

    private final static String[] GOAT = {
                                        "                   ",
                                        ",-----------------,",
                                        "                   ",
                                        "|-----------------|",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|  )_(            |",
                                        "| ≠° °≠__ ___     |",
                                        "|  `*´   ´    \\=, |",
                                        "|    \\  ,---| /   |",
                                        "|     ||    ||    |",
                                        "|     ^^    ^^    |",
                                        "|_________________|"};
    private final static String[] DOOR = {
                                        "                   ",
                                        ",-----------------,",
                                        "                   ",
                                        "|-----------------|",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|              O  |",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|                 |",
                                        "|_________________|"};
    private final static String[] CAR = {
                                        "                   ",
                                        ",-----------------,",
                                        "                   ",
                                        "|-----------------|",
                                        "|                 |",
                                        "|    -------------|",
                                        "|  `/\"\"\"\"/\"\"\"\"/|\"\"|",
                                        "|  /    /    / |__|",
                                        "| /----------=====|",
                                        "| | \\  /V\\  /    _|",
                                        "| |()\\ \\W/ /()   _|",
                                        "| |   \\   /     / |",
                                        "| =C========C==_| |",
                                        "|  \\_\\_/__..  \\_\\_|",
                                        "|_________________|"};
private final static String DIVIDER =   "_____________________________________________________________";


    public static void montyHallProblem() {
        clearTerminal();

        boolean revealedDoors [] = {false, false, false};
        String doors[][] = {DOOR, DOOR, DOOR};
        
        // Preparations: Use pseudo random number to set car position
        boolean[] carPosition = new boolean[3];

        Random randCar = new Random();
        int randCarIndex = randCar.nextInt(3);
        
        carPosition[randCarIndex] = true;
        
        // Step #1 -> display empty doors --------------------------------------
        doorOutput(doorBuilder(doors[0], doors[1], doors[2], 0));
        
        // Step #2 -> let the user choose door ---------------------------------
        System.out.println("Game Show Moderator: Which door to choose? (1, 2, 3)");  
        Scanner sc = new Scanner(System.in);
        int currDoor = sc.nextInt();
        String message = "";

        if ( !(currDoor >= 1 && currDoor <= 3)) {
            message = "You didn't enter a valid door, we use door 3 instead (because I don't know how to handle exceptions yet)\n";
            currDoor = 3;
        }
        
        // Step #3 -> reveal a goat---------------------------------------------
        
        // Direction of how the loops search for a goat has to be random
        Random random = new Random();
        boolean isMapRising = random.nextBoolean();
        int revealedDoor = 0;
        
        // (search for the index which is not the user choice and no car inside)
        if (isMapRising) {
            for (int i = 0; i < 3 ; i++) {
                if (i+1 == currDoor || carPosition[i]) {
                    continue;
                } else {
                    doors[i] = GOAT;
                    revealedDoors[i] = true;
                    revealedDoor = i+1;
                    break;
                }
            }
        } else {
            for (int i = 2; i > 0 ; i--) {
                if (i+1 == currDoor || carPosition[i]) {
                    continue;
                } else {
                    doors[i] = GOAT;
                    revealedDoors[i] = true;
                    revealedDoor = i+1;
                    break;
                }
            } 
        }
        
        clearTerminal();
        doorOutput(doorBuilder(doors[0], doors[1], doors[2], currDoor));
        
        // Step #4 -> Ask wheter to change door or stay ------------------------
        System.out.println(message +
                           "You chose door " +
                           currDoor +
                           ". " +
                           "I revealed a goat for you, which was behind door " +
                           revealedDoor +
                           ". Would you like to change (c) or stay (any other input) with your initial choice?");
        
        char change = sc.next().charAt(0);
        sc.close();
        
        // Step #5 -> unveil door ----------------------------------------------
        // if user stayed with door, just show dow
        // if user wants to change: change currDoor to not unveiled and not current
        
        boolean hasWon = false;

        // This statements are not very clear -> improve !!!
        if (change == 'c') {
            for (int i = 0; i < 3 ; i++) {
                if (revealedDoors[i] || i+1 == currDoor) {
                    continue;
                } else {
                    currDoor = i+1;
                    break;
                }
            }
            if (carPosition[currDoor-1]) {
                doors[currDoor-1] = CAR;
                hasWon = true;
            } else {
                doors[currDoor-1] = GOAT;
            }
        } else {
            if (carPosition[currDoor-1]) {
                doors[currDoor-1] = CAR;
                hasWon = true;
            } else {
                doors[currDoor-1] = GOAT;
            }
        }
        
        clearTerminal();
        doorOutput(doorBuilder(doors[0], doors[1], doors[2], currDoor));
        
        printWinningMessage(hasWon);
    }



    /** Prepares the arrays to be printed. Takes three arrays and the current
      * choice. If no choice markup is required use default 0. 
      */
    public static String[][] doorBuilder(String[] door1, String[] door2, String[] door3, int currDoor) {
        String[][] doors = new String[3][15];
        String door1header =   "|     DOOR # 1    |";
        String door2header =   "|     DOOR # 2    |";
        String door3header =   "|     DOOR # 3    |";
        String doorSelection = "    YOUR CHOICE    ";

        for (int row = 0; row < 15; row++ ) {
            doors[0][row] = door1[row];
            doors[1][row] = door2[row];
            doors[2][row] = door3[row];
        }
        doors[0][2] = door1header;
        doors[1][2] = door2header;
        doors[2][2] = door3header;

        if (currDoor >= 1 && currDoor <= 3) {
            doors[currDoor-1][0] = doorSelection;
        }

        return doors;
    }

    /** Takes a two-dimensional array and prints them side by side */
    public static void doorOutput(String[][] arr) {
        for (int row = 0; row < 15; row++ ) {
            for (int col = 0; col < 3; col++) {
                System.out.print(arr[col][row]);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println(DIVIDER);
        System.out.println();
    }

    /** Clears whatever was printed out before from the terminal */
    public static void clearTerminal() {
        System.out.print(String.format("\033[2J"));
    }

    /** Prints winning or loosing message depending on parameter
      * true -> won
      */
    public static void printWinningMessage(boolean hasWon) {
        if (hasWon) {
            System.out.println("Congratulations to your new car.\n\n\n");
        } else {
            System.out.println("You can still ride home on the goat...\n\n\n");
        }
    }
}
